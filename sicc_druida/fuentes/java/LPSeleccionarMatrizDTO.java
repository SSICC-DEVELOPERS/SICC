/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion; 
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
 
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
 
 
 /**
  * Sistema:             Belcorp - SICC
  * Modulo:              DTO - Descuentos
  * Componente:          LPSeleccionarMatrizDTO
  * Fecha:               06/07/2004
  * Dcoumentacion:       
  *                      documentos: SICC-DMCO-DTO-201-324
  * Observaciones:
  * @version             3.0
  * @author              Cintia Verónica Argain
  */
 public class LPSeleccionarMatrizDTO extends LPSICCBase {
    private Long lIdioma 	= null;
    private Long lPais 		= null;
    private String sOidCabeceraMatrizSel	= null;

 
    public LPSeleccionarMatrizDTO() {
    }
    
    public void inicio() throws Exception {
       pagina("contenido_matriz_origen_seleccionar");
    }
 
     public void ejecucion() throws Exception {
         setTrazaFichero();
         try{
            traza("<<<<<<<<< Inicializando LPSeleccionarMatrizDTO >>>>>>>>>>>>");		
            String sAccion = conectorParametroLimpia("accion", "", true);
            traza("Accion: "+sAccion);
            this.rastreo();
            lIdioma = UtilidadesSession.getIdioma(this);
            lPais = UtilidadesSession.getPais(this);
            if (sAccion.equals("")){
                getConfiguracionMenu("LPSeleccionarMatrizDTO","");
                asignarAtributoPagina("cod","0644");
                traza("listo");
                DTOSiccPaginacion dtoSicPag	= new DTOSiccPaginacion();

                dtoSicPag.setOidIdioma(lIdioma);
                dtoSicPag.setOidPais(lPais);
                MareBusinessID idBuscarMatricesDTOActivas = new MareBusinessID(
                                                "DTOBuscarMatricesDTOActivas");

                Vector vParamEntrada	= new Vector();
                vParamEntrada.add(dtoSicPag);
                vParamEntrada.add(idBuscarMatricesDTOActivas);

                DruidaConector conector =  conectar(
                            "ConectorBuscarMatricesDTOActivas", vParamEntrada);
                traza (" Despues de Druida ");
                /*.............. Recuperar DTOSalida respuesta ...........*/
                DTOSalida dtoSalida = (DTOSalida) conector.objeto("dtoSalida");
                /*.......... asignar atributo RecordSet a pantalla ...........*/
                RecordSet recLista = new RecordSet();
                recLista = dtoSalida.getResultado();

                String nombreListado = "listado1";
                asignar("LISTADOA", nombreListado,
                            generarConectorListEditCF("ROWSET", recLista, 
                            (Vector)recLista.getColumnIdentifiers()),"ROWSET");            

            } else if (sAccion.equals("crear")) {                
                sOidCabeceraMatrizSel = this.conectorParametro(
                                              "hidOidCabeceraMatrizSel");
                traza ("sOidCabeceraMatrizSel: " + sOidCabeceraMatrizSel );

                DTOOID dtoOid = new DTOOID();
                dtoOid.setOid(new Long(sOidCabeceraMatrizSel));
                dtoOid.setOidIdioma(lIdioma);
                dtoOid.setOidPais(lPais);
                conectorParametroSesion("DTOMatrizSeleccionada", dtoOid);                
                conectorParametroSesion("DTOUltimaLP", "LPSeleccionarMatrizDTO");                
                conectorAction("LPMantenimientoDTODG");
                conectorActionParametro("accion","");                
                conectorActionParametro("casoDeUso","insertar");
            }            
            this.getConfiguracionMenu("LPSeleccionarMatrizDTO");
            getConfiguracionMenu();
         } catch(Exception ex) {
              logStackTrace(ex);
              this.lanzarPaginaError(ex);
         }
     }
 
     private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());
        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);
        if (e instanceof MareException) {
          MareException e2=(MareException)e;
          traza("Es una mare Exception con codigo de error: "+e2.getCode());
        }
        e.printStackTrace(out);
        traza("stack Trace : " +  pila.toString());
     }

  /*
   * Metodo para utilizar listas editable - Mario Bobadilla	
   */	
	private DruidaConector generarConectorListEditCF(String rowsetID, 
            RecordSet datos, Vector columns) throws DOMException, Exception {
		StringBuffer salida = new StringBuffer();
		int sizeColums = datos.getColumnCount();
		int sizeRows = datos.getRowCount();
		
		if ( columns == null ) {
			columns = new Vector();
		}

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
        if (columns.contains(columsDesc.elementAt(j)))
        {
                  Element e_campo2   = docDestino.createElement("CAMPO");
                  e_campo2.setAttribute("NOMBRE",columsDesc.
                                                elementAt(j).toString());
                  e_campo2.setAttribute("TIPO","OBJECTO");
                  e_campo2.setAttribute("LONGITUD","50");
                  Text txt0 = docDestino.createTextNode((
                                datos.getValueAt(i,j)==null?"":
                                      datos.getValueAt(i,j).toString()));
                  e_campo2.appendChild(txt0);
                  e_row.appendChild(e_campo2);
        }
      }
		}
		conectorValoresPosibles.setXML(docDestino.getDocumentElement());
		traza("return");
		traza("Conector: " + conectorValoresPosibles.getXML() );
		return conectorValoresPosibles;
	}// Fin metodo generarConectorListEditCF
}
