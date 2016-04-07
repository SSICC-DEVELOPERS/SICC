import es.indra.druida.DruidaBase;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import java.util.Vector;
import es.indra.sicc.dtos.zon.DTOZONConsultarPaises;
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

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;


import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.util.DTOPais;

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


public class LPModificarEG extends LPSICCBase // Usar DruidaBase para que compile en JDEVELOPER
{

  private String sOidAnterior = new String();
  private String sNivelAnterior = new String();


  public LPModificarEG()
  {
    super();
  }

  public void inicio() throws Exception
  {
		 pagina("contenido_estructura_geopolitica_pais_modificar");
  }

  public void ejecucion() throws Exception 
  {   
      setTrazaFichero();
      traza("Entro a Modificar EG!!!!!!!!");

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
      
  	  traza("Accion: " + accion);

      try
      {
             MareBusinessID idx = new MareBusinessID("ZONConsultarEstructuraGeopolitica");
             Vector parametrosx = new Vector();
             traza("Setea parametros");

             DTOZONConsultarPaises dtoZon = new DTOZONConsultarPaises();
             DTOPais dtoPais = new DTOPais();
             Vector vPaises = new Vector(); // contendra SOLO UN pais, el de sesion.
             
             dtoPais.setPais( UtilidadesSession.getPais(this) );
             traza("pais: " + UtilidadesSession.getPais(this) );
             vPaises.add( dtoPais ); // Agrega el pais.
             dtoZon.setPaises(vPaises);
             dtoZon.setIdioma( UtilidadesSession.getIdioma(this) );
             dtoZon.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
             dtoZon.setPrograma( UtilidadesSession.getFuncion(this) );
             
             parametrosx.add( dtoZon );
             parametrosx.add( idx );
             traza("Antes de conectar");            

             DruidaConector conectorx = conectar("ConectorConsultarEGEnModificar", parametrosx);
             traza("Despues de conectar");
             //traza("ConectorX: " + conectorx.getXML() );
             //DTOSalida dtoSalida = (DTOSalida) conectorx.objeto("dtoSalida");
			 
             DTOEstructuraGeopoliticaPais dtoEG = (DTOEstructuraGeopoliticaPais) conectorx.objeto("dtoSalida");
             traza("dtoEG: " + dtoEG.toString() );

			 //traza("dtoSalida: " + dtoSalida.toString() );             
			 RecordSet rs_diviciones_politicas = new RecordSet();

			 Vector codDivPol = dtoEG.getCodDivPol();
             traza("codDivPol: " + codDivPol.toString() );
             Vector desDivPol = dtoEG.getDescripcionDivPol();
             traza("descripcionDivPol: " + desDivPol.toString() );

			 // Verifica si hay estructura creada
			 boolean estructura = false;
			 for(int i=0; i < codDivPol.size(); i++) { 
				if(dtoEG.getNivelEG().get(i)!= null){
					estructura = true;
					break;
				}
			 }

            // Hay estructura creada
			if(estructura) {
				 asignarAtributo("VAR", "cantNiveles", "valor", new Integer(codDivPol.size()).toString());
				 //traza("cant niv: " +  new Integer(codDivPol.size()).toString());

				 rs_diviciones_politicas.addColumn("oid");
				 rs_diviciones_politicas.addColumn("desc_div_polit");
				 rs_diviciones_politicas.addColumn("nivel");
				 Vector row = null;
				 for(int i=0; i < codDivPol.size(); i++) { 
					row = new Vector();
					row.addElement(dtoEG.getCodDivPol().get(i));               
					row.addElement(dtoEG.getDescripcionDivPol().get(i));
					row.addElement(dtoEG.getNivelEG().get(i));
					rs_diviciones_politicas.addRow(row);               								
				 }	
				 
				 traza("rs_diviciones_politicas: " + rs_diviciones_politicas.toString() );
							  
				 int nRowCount = rs_diviciones_politicas.getRowCount();
				 
				 DruidaConector listaeditable_diviciones_politicas = this.generarConectorParaListaEditable("DTOSalida.rs_diviciones_politicas_ROWSET",rs_diviciones_politicas, rs_diviciones_politicas.getColumnIdentifiers());
				 //traza("Conector: " + listaeditable_diviciones_politicas.getXML() );
				 traza("asignar LISTAEDITABLE");
				 asignar("LISTADOA","listado1",listaeditable_diviciones_politicas,"DTOSalida.rs_diviciones_politicas_ROWSET");	
			}

            if (accion.equals("actualizar")) {  // El usuario cliqueo el boton de Actualizar.              
                  // Graba lo que hay en las cajas de texto en la pantalla. 
                  // Se presupone que están todas llenas y tienen datos válidos.
                  // (Esto se chequea desde el XML)
                  Vector vListaOids = new Vector();
                  Vector vListaNiveles = new Vector();
                  Vector params = new Vector();
                  DTOEstructuraGeopoliticaPais dtoe = new DTOEstructuraGeopoliticaPais();
              
                  //dtoe.setPais( new Long(getPais()) );
                  String sListaOids = conectorParametro("enviaOid");
                  sOidAnterior = conectorParametro("enviaOid"); // Variable Nivel Clase.
                  traza("sListaOids: " + sOidAnterior);
              
                  String sListaNiveles = conectorParametro("enviaNivel");
                  sNivelAnterior = conectorParametro("enviaNivel"); // Variable Nivel Clase.
				  asignarAtributo("VAR", "hidRecibeNivelAnterior", "valor", sNivelAnterior);

                  //traza("sNivelAnterior: " + sNivelAnterior);

                  // ********* Forma lista vListaOid ***********************
                  StringTokenizer token = new StringTokenizer(sListaNiveles, "|");
                  StringTokenizer tokenOids = new StringTokenizer(sListaOids, "|");
                  String sBuffer = null;
                  String sOid = null;
                  traza("Forma vListaNiveles");
                  traza("Cantidad de tokens: " + new Integer(token.countTokens()).toString() );
    
                  while ( token.hasMoreTokens() ) {
                    sBuffer = token.nextToken();
                    sOid = tokenOids.nextToken();
                    traza("sOid: " + sOid);
                    traza("sBuffer: " + sBuffer);
                    // "NADA" indica que está vacío. 
                    // Cualquier otro valor sería un número (caja llena).
                    if ( !sBuffer.equals("NADA") ) {
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

                  MareBusinessID bussID = new MareBusinessID("ZONModificarEstructuraGeopolitica");
                  params.add(dtoe);
                  params.add(bussID);

                  traza("******** Antes de conectar y modificar *************");
                  DruidaConector con = conectar("ConectorModificarEG", params);
                  traza("************* Despues de conectar y modificar *************");
                  asignarAtributo("VAR", "exito", "valor", "S" );
              } 
			  getConfiguracionMenu("LPModificarEG");
  	} catch (Exception ex)
    {
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          ex.printStackTrace(out);
          traza("EXCEPCION:" + stack.toString());
          traza("EXCEPCION:" + stack.toString());
		  this.lanzarPaginaError(ex);
		  /* Patricio Peralta 23/01/2004 uso de this.lanzarPaginaError(ex)
		  
          BelcorpError belcorpError = new BelcorpError();
          Long codPais = UtilidadesSession.getPais(this);
          Long codIdioma = UtilidadesSession.getIdioma(this);
          
          DTOError dtoError = belcorpError.obtenerError(ex, codIdioma.toString(), codPais.toString() );

          traza("codigo:"+dtoError.getCodigoError());
          traza("descricption:"+dtoError.getDescripcionError() );
          asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()) ;
		  */
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

  private String armaVariableJScript(Vector vDescripcion, boolean bigDecimal) throws Exception
  {
      // *************************************************************
      // Arma un String para setear una variable de formulario con 
      // con formato elemento | elemento | elemento | elemento 
      //
      // Si bigDecimal es true, castea a BigDecimal.
      // Si bigDecimal es false, castea a String.
      // Si insertaNADA es true, los elementos vacíos o null se 
      // reemplazan con "NADA".
      // Si insertaNADA es false, los elementos vacíos se dejan
      // sin espacio en blanco ni nada. (ej. |||1) <--- No sirve
      // Setear insertaNADA en false cuando se sepa que TODOS los 
      // elementos contienen valor. 
      // ********************************************************
      traza("Funcion armaVariableJScript");
      StringBuffer sRetorno = new StringBuffer();
      String sValorVacio = null;
      String sToAdd = null;

      sValorVacio = "NADA";
      int i = 0;
      int nSize = vDescripcion.size();
      traza("vDescripcion: " + vDescripcion.toString() );

      if ( nSize != 0 )
      {
          // Por cada elemento del vector.
          for (i = 0; i < nSize; i++)
          {
              traza("bucle " + i);
              if (i!=0)
              {
                  sRetorno.append("|");
              }               

              if ( vDescripcion.get(i) == null || vDescripcion.get(i).equals("") )
                  sToAdd = sValorVacio.toString();                  
              else
              {
                  if (bigDecimal == true) // Indica que se debe castear a BigDecimal. 
                    sToAdd = ( (BigDecimal) vDescripcion.get(i) ).toString();
                  else // Castea a String. 
                    sToAdd = (String) vDescripcion.get(i);                
              }
              sRetorno.append(sToAdd);

          }
          //vDescripcion.elements().nextElement();
          traza("valor temporal de sRetorno: " + sRetorno.toString() ) ;            
       }
       
       traza("**** Valor FINAL de sRetorno: " + sRetorno.toString() );
       return sRetorno.toString();       
  }

      
}

