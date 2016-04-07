import es.indra.druida.DruidaBase;
import LPSICCBase;
import es.indra.sicc.dtos.zon.DTOZONConsultarPaises;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOPais;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;
import java.util.Vector;
import java.util.Date;
import java.util.StringTokenizer;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.zon.DTOUsuario;
import es.indra.sicc.dtos.zon.DTOEGPaises;

import java.lang.reflect.InvocationTargetException;
import com.evermind.server.rmi.OrionRemoteException;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;

import java.util.HashMap;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.mare.common.mgu.manager.Property;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.DTOSalida;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.w3c.dom.DOMException;
import es.indra.sicc.util.xml.XMLDocument;
import java.lang.StringBuffer;

public class LPConsultarEG extends LPSICCBase {

  public LPConsultarEG () {super();}

  public void inicio() throws Exception {
	 pagina("contenido_estructura_geopolitica_pais_consultar");
  }

  public void ejecucion() throws Exception {   
      setTrazaFichero();
      traza("Entro a consultar EG!!!!!!!!");

      String accion	= conectorParametro("accion");
      accion = (accion==null )?"":accion;

      String paises	= conectorParametro("hidPaises");
      paises = (paises==null )?"":paises;
	  
  	  String casoDeUso	= conectorParametro("casoDeUso");
      casoDeUso = (casoDeUso==null)?"":casoDeUso;

      // Rastreo
	  if(accion.equals("")){
		  this.rastreo();
	  }
      
   	  asignarAtributo("VAR", "hidAccion", "valor", accion);
      asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
	  asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());

      try {
           getConfiguracionMenu("LPConsultarEG","");
  
           cargaComboPaises(); 

        if (!accion.equals("Consultar")) {	
				 asignarAtributo("CAPA", "capaTitulo", "visibilidad", "hidden");			
				 asignarAtributo("CAPA", "capaResultado", "visibilidad", "hidden");
				 if (casoDeUso.equals("modificar")) {
				   asignarAtributo("BOTON", "btnBuscar", "alt", "Modificar");
				 }
		} else {
            traza("accion: " + accion);
            MareBusinessID idx = new MareBusinessID("ZONConsultarEstructuraGeopoliticaPaises");
			 
			Vector vecPaises = new Vector();
			Vector parametrosx = new Vector();
			DTOPais pais;
			StringTokenizer token = new StringTokenizer(paises, ",");

			String paisSelec = "";
			while ( token.hasMoreTokens() ) {
				pais = new DTOPais();
				Long oidPais =  new Long( token.nextToken() );
				pais.setPais(oidPais);
				paisSelec = paisSelec + oidPais.toString() + "|";
				vecPaises.add( pais );
            }

			asignarAtributo("VAR", "hPaisesSelec", "valor", paisSelec);

			DTOZONConsultarPaises dtoe = new DTOZONConsultarPaises();
			dtoe.setPaises(vecPaises);
			dtoe.setIdioma( UtilidadesSession.getIdioma(this) );

			parametrosx.add(dtoe);
			parametrosx.add(idx);

			traza("antes conector");
			DruidaConector conectorx = conectar("ConectorConsultarEG", parametrosx);
			traza("despues conector");

			DTOSalida dtoS = (DTOSalida)conectorx.objeto("dtoSalida");
			RecordSet miRS = dtoS.getResultado();
			traza("miRS: "+miRS);

				 Vector nomColumns = miRS.getColumnIdentifiers();
			//traza("Columnas: "+nomColumns);
			String nomCol = "";
			for (int i = 2; i < nomColumns.size(); i++) {
				nomCol = nomCol + ((String) nomColumns.get(i)) + "|";
			}

			asignarAtributo("VAR", "hNomCols", "valor", nomCol);
			int cantColumns = miRS.getColumnCount();
			DruidaConector resultC = generarConector("dtoSalida.resultado_ROWSET", miRS, nomColumns);
		   
			asignar ("LISTADOA", "listado1", resultC, "dtoSalida.resultado_ROWSET");
		   
			asignarAtributo("VAR", "hCantPaises", "valor", new Integer(vecPaises.size()).toString());
       }

      } catch (Exception ex) {  
          ByteArrayOutputStream stack = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(stack);
          ex.printStackTrace(out);
		  traza("HAY EXCEPCION:" + stack.toString());
		  this.lanzarPaginaError(ex);
		  /* Patricio Peralta 23/01/2004
        
          BelcorpError belcorpError = new BelcorpError();
          DTOError dtoError = belcorpError.obtenerError(ex,"1","1");

	      asignarAtributo("VAR","errCodigo", "valor", "" + dtoError.getCodigoError());
          asignarAtributo("VAR","errDescripcion", "valor", dtoError.getDescripcionError()) ;
          traza(ex);
		  */

      }	  
  }



  private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) throws DOMException,Exception {
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();

		if ( columns == null ) columns = new Vector();

		Vector columsDesc = datos.getColumnIdentifiers();		
		
		DruidaConector conectorValoresPosibles = new DruidaConector();				
		XMLDocument xmlDoc  = new XMLDocument();
		Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
		Element e_rows = docDestino.createElement("ROWSET");
		e_rows.setAttribute("ID",rowsetID);
		docDestino.getDocumentElement().appendChild(e_rows);
		
		for (int i=0; i < sizeRows; i++) {
			Element e_row = docDestino.createElement("ROW");
			e_rows.appendChild(e_row);

			for (int j=0; j < sizeColums; j++) {
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

  private String getUserID() throws Exception	{
		HashMap propiedades  = (HashMap) conectorParametroSesion("propiedades");
		if ( propiedades == null || propiedades.size()==0 )	return null;
 		Property userID = (Property) propiedades.get("userID");
		if ( userID == null || userID.getValue() == null) return null;
		return (String)userID.getValue();
  }


  private void cargaComboPaises() throws Exception {
		 Vector parametros = new Vector();
		 MareBusinessID id = new MareBusinessID("ZONCargarPaisesConEG");
		 String userID = getUserID();

         DTOUsuario dtoe = new DTOUsuario();
         //dtoe.setIdUsuario(userID);
         dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));
         parametros.add(dtoe);
         parametros.add(id);
      
         DruidaConector conector = conectar("ConectorCargaPaisesEG", parametros);
         DTOSalida dtoSalida = (DTOSalida) conector.objeto("dtoSalida");

         RecordSet r = dtoSalida.getResultado();

         DruidaConector conCombo = generarConector( "dtoCombo", r, r.getColumnIdentifiers() ); 
         //traza("ConCombo: "+conCombo.getXML());
         asignar("COMBO", "comboPais", conCombo, "dtoCombo");
  }
  
}
