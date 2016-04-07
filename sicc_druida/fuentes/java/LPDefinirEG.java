import es.indra.druida.DruidaBase;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import java.util.Vector;
//import java.util.Date;
import java.util.StringTokenizer;
import java.math.BigDecimal;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.util.Calendar;
import java.sql.Date;
import es.indra.mare.common.mii.MareCredentials;


import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.zon.DTOZONConsultarPaises;

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;


import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;

import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;


import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import java.util.HashMap;
import es.indra.mare.common.mgu.manager.Property;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPDefinirEG extends LPSICCBase // Usar DruidaBase para que compile en JDEVELOPER
{

  private String sOidAnterior = new String();
  private String sNivelAnterior = new String();


  public LPDefinirEG () 
  {
      super();
  }
  

  public void inicio() throws Exception
  {
		 pagina("contenido_estructura_geopolitica_pais_definir");
  }

  public void ejecucion() throws Exception 
  {   
      setTrazaFichero();
      traza("Entro a Definir EG!!!!!!!!");
      String accion		= conectorParametro("accion");
      String idF = conectorParametro("idFuncion");
      if (idF == null)
        traza("Es null");
      else
        traza("idF.toString(): " + idF.toString() );

      accion = (accion==null )?"":accion;

	  // Rastreo
	  if(accion.equals("")){
		  this.rastreo();
	  }
  
      String paisABuscar		= conectorParametro("hidPaisABuscar");
      paisABuscar = (paisABuscar==null )?"":paisABuscar;

      asignarAtributo("VAR", "hidPaisABuscar", "valor", paisABuscar);
      asignarAtributo("VAR", "accion", "valor", accion);
      asignarAtributo("VAR", "casoDeUso", "valor", "definir");

      //sNivelAnterior = "|1|2|";
      //asignarAtributo("VAR", "hidRecibeNivelAnterior", "valor", sNivelAnterior.toString() );      
      
  	  traza("Accion: " + accion);

      try
      {   
          if ( accion.equals("") || accion.equals("definir") )
          {
             MareBusinessID idx = new MareBusinessID("ZONCargarTodasDivisionPolitica");
             Vector parametrosx = new Vector();
             traza("Setea parametros");

             DTOZONConsultarPaises dtoZon = new DTOZONConsultarPaises();
             Vector vPaises = new Vector(); // contendra SOLO UN pais, el de sesion.

             vPaises.add( UtilidadesSession.getPais(this).toString() ); // Agrega el pais.
             dtoZon.setPaises(vPaises);
             dtoZon.setIdioma(UtilidadesSession.getIdioma(this) );             

             // Setea el Vector.
             parametrosx.add(dtoZon);
             parametrosx.add(idx);
             traza("Antes de conectar");
             
             DruidaConector conectorx = conectar("ConectorCargarTodasDivisionPolitica", parametrosx);
             traza("Despues de conectar");
             traza("ConectorX: " + conectorx.getXML() );
             DTOSalida dtoSalida = (DTOSalida) conectorx.objeto("dtoSalida");
             RecordSet rs_diviciones_politicas = dtoSalida.getResultado();
			 int nRowCount = rs_diviciones_politicas.getRowCount();

			 // Pongo valores en blanco en niveles
			 Vector niveles = new Vector();

			 for(int i=0; i<nRowCount; i++) {
				 niveles.add("");
		     }

			 rs_diviciones_politicas.addColumn("Nivel", niveles);
             
             traza("dtoSalida: " + dtoSalida.toString() );
             traza("rs_diviciones_politicas: " + rs_diviciones_politicas.toString() );
             
             // Asigna la cant. de niveles en la variable de formulario
             // para poder después chequear cajas de texto y validaciones
             // (se necesita saber cuántas se crearon).
             //asignarAtributo("VAR", "cantNiveles", "valor", new Integer(nRowCount).toString() );

             StringBuffer sEtiquetas = new StringBuffer();			  			   
			 traza("Generar conector para rs_diviciones_politicas");
			 DruidaConector listaeditable_diviciones_politicas = this.generarConectorParaListaEditable("DTOSalida.rs_diviciones_politicas_ROWSET",rs_diviciones_politicas, rs_diviciones_politicas.getColumnIdentifiers());
			 //traza("Conector: " + listaeditable_diviciones_politicas.getXML() );
			 traza("asignar LISTAEDITABLE");
			 asignar("LISTADOA","listado1",listaeditable_diviciones_politicas,"DTOSalida.rs_diviciones_politicas_ROWSET");			                           

          } // Fin if.
          if (accion.equals("definir") ) 
          {
              // Graba lo que hay en las cajas de texto en la pantalla. 
              // Se presupone que están todas llenas y tienen datos válidos.
              // (Esto se chequea desde el XML)
              Vector vListaOids = new Vector();
              Vector vListaNiveles = new Vector();
              Vector params = new Vector();
              DTOEstructuraGeopoliticaPais dtoe = new DTOEstructuraGeopoliticaPais();
              
              //dtoe.setPais( new Long(getPais()) );
              String sListaOids = conectorParametro("enviaOid");
              sOidAnterior = conectorParametro("enviaOid");
              traza("sListaOids: " + sOidAnterior);
              
              String sListaNiveles = conectorParametro("enviaNivel");
              sNivelAnterior = conectorParametro("enviaNivel");              
              traza("sNivelAnterior: " + sNivelAnterior);


              // ********* Forma lista vListaOid ***********************
              StringTokenizer token = new StringTokenizer(sListaNiveles, "|");
              StringTokenizer tokenOids = new StringTokenizer(sListaOids, "|");
              String sBuffer = null;
              String sOid = null;
              traza("Forma vListaNiveles");
              traza("Cantidad de tokens: " + new Integer(token.countTokens()).toString() );
    
              while ( token.hasMoreTokens() )
              {
                sBuffer = token.nextToken();
                sOid = tokenOids.nextToken();
                traza("sOid: " + sOid);
                traza("sBuffer: " + sBuffer);
                // "NADA" indica que está vacío. 
                // Cualquier otro valor sería un número (caja llena).
                if ( !sBuffer.equals("NADA") ) 
                {
                  vListaNiveles.add( new Integer( sBuffer.toString() ) );
                  vListaOids.add( new Integer(sOid.toString() ) );
                  //vListaOids.add( sOid.toString()  );  <--- Pincha (para testeo de errores)
                }

              }
              traza("vListaOids: " + vListaOids.toString() );
              traza("vListaNiveles: " + vListaNiveles.toString() );

              Long codPais = UtilidadesSession.getPais(this);
              String ipCliente = UtilidadesBelcorp.getIPCliente(this);

              dtoe.setNivelEG(vListaNiveles);
              dtoe.setCodDivPol(vListaOids);
              dtoe.setPais( codPais );
              dtoe.setPrograma( UtilidadesSession.getFuncion(this) );
              dtoe.setIpCliente(ipCliente);

              MareBusinessID bussID = new MareBusinessID("ZONDefinirEstructuraGeopolitica");
              params.add(dtoe);
              params.add(bussID);

              traza("Antes de conectar");
              DruidaConector con = conectar("ConectorDefinirEGPais", params);
              traza("Despues de conectar");
              asignarAtributo("VAR", "exito", "valor", "S" );
            
          } else if (accion.equals("volver") )
          {
              // Este método es llamado luego de que el usuario da click en 
              // aceptar o cancelar. Vuelve a la pantalla de Inicio.
              String pantallaInicio = getPantallaInicioAsociada();
              if (pantallaInicio == null)
              {
                traza("PantallaInicio es null");
                conectorAction("LPInicioBelcorp");
              } else
              {
                traza("Pantalla de inicio en sesion: " + pantallaInicio.toString() );
                conectorAction(pantallaInicio);
              }
          }

          
  	  getConfiguracionMenu();
  	} catch (Exception ex)
    {
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          ex.printStackTrace(out);
		   this.lanzarPaginaError(ex);
		  traza("EXCEPCION:" + stack.toString());
		  /* Patricio Peralta 23/01/2004 uso de this.lanzarPaginaError(ex)
		  
          BelcorpError belcorpError = new BelcorpError();
          Long codPais = UtilidadesSession.getPais(this);
          Long codIdioma = UtilidadesSession.getIdioma(this);
          
          DTOError dtoError = belcorpError.obtenerError(ex, codIdioma.toString(), codPais.toString() );
		
          traza("codigo:"+dtoError.getCodigoError());
          traza("descricption:"+dtoError.getDescripcionError() );
          asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError() );
		  */
          // Asigna lo que el usuario ingreso anteriormente para luego setearlo
          // al recargar la pagina. 
          asignarAtributo("VAR", "hidRecibeOidAnterior", "valor", sOidAnterior.toString() );
          asignarAtributo("VAR", "hidRecibeNivelAnterior", "valor", sNivelAnterior.toString() );
          
  	}
 }

	private DruidaConector generarConector(String rowsetID,RecordSet datos,Vector columns)
		throws DOMException,Exception
	{
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ){
			columns = new Vector();
		}

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++)
		{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++){
				if ( columns.contains(columsDesc.elementAt(j)) ){
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt);
					e_row.appendChild(e_campo2);
				}
			}
		}	
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		return conectorValoresPosibles;
	}

	private String getPais() throws Exception
	{
		HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");		
        traza("propiedades.toString(): " + propiedades.toString() );
		if ( propiedades == null || propiedades.size()==0 ){
			return "";
		}
		Property paisDefecto = (Property) propiedades.get("PaisDefecto");
		if ( paisDefecto == null || paisDefecto.getValue() == null ){
			return "";
		}
		return (String)paisDefecto.getValue(); 
	}

	private DruidaConector generarConectorParaListaEditable(String rowsetID, RecordSet datos,Vector columns) 
      throws DOMException, Exception {
		//StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		if ( columns == null )
			columns = new Vector();		
		Vector columsDesc = datos.getColumnIdentifiers();				
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);		
		for (int i=0; i < sizeRows; i++)	{
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);
			for (int j=0; j < sizeColums; j++){				
					Element e_campo2   = docDestino.createElement("CAMPO");
					e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
					e_campo2.setAttribute("TIPO","OBJECTO");
					e_campo2.setAttribute("LONGITUD","50");
					Text txt0 = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
					e_campo2.appendChild(txt0);
					e_row.appendChild(e_campo2);
			}
		}
      conectorValoresPosibles.setXML(docDestino.getDocumentElement());
      return conectorValoresPosibles;
	}	



  
	private String getPantallaInicioAsociada() throws Exception
	{
		HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");

		if ( propiedades == null || propiedades.size()==0 )
			return null;
 		Property pantallaInicio = (Property) propiedades.get("PantallaInicioAsociada");
		if ( pantallaInicio == null || pantallaInicio.getValue() == null)
		   return null;
	  traza("propiedades.toString(): " + propiedades.toString() );
    
		return (String)pantallaInicio.getValue();
    
	}  

}
