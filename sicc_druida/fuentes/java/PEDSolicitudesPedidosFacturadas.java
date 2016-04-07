//01-02-2005 mdolce
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.dtos.cra.DTOPeriodo;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Date;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

public class PEDSolicitudesPedidosFacturadas extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public PEDSolicitudesPedidosFacturadas() {	 
     super();
   }

   public void inicio() throws Exception { 
     
   }

   public void ejecucion() throws Exception {		
      String accion = conectorParametroLimpia("accion","", true);
      setTrazaFichero();
      traza("vengo.....");
      pais = UtilidadesSession.getPais(this);     
      idioma = UtilidadesSession.getIdioma(this);
      try {
         this.rastreo();
        
         if (accion.equals("generar")){
            generarReporte(); 
            traza("termino de generar el reporte");
         }else{
            traza("c. inicial...............");
            cargarPagina();
            getConfiguracionMenu("PEDSolicitudesPedidosFacturadas");
         }
     
      } catch (Exception ex) {
     			
                
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
    	 PrintStream out = new PrintStream(stack);
	 	 ex.printStackTrace(out);
	     traza("EXCEPCION:" + stack.toString());
	 	 lanzarPaginaError(ex);
     }
   }

   private void cargarPagina() throws Exception{
      traza("seteo pagina");
      pagina("contenido_informe_solicitudes_pedidos_generar");   
	  traza("setie pagina");

      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());
	  asignarAtributo("LABELC", "lblPaisdt", "valor", this.pais.toString());

      //cargarAccesos(); //Comentado por Sapaza, para que los accesos no se cargen en la LP 
	  //cargarPeriodos(); //Comentado por Sapaza, para que los periodos no se cargen en la LP 
	  cargarTiposSolicitud();
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
	  asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");

   }

   private void cargarAccesos() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOOID dto = new DTOOID();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setOid(null);
         
         DruidaConector conAcceso = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("SEGObtenerAccesosSinFiltro"));

         conAcceso = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conAcceso.objeto("DTOSalida");


         conAcceso = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_ACCE", "VAL_I18N", "CANA_OID_CANA",null,null,null);
         asignar("COMBO", "lstAcceso", conAcceso, "dtoSalida");
         
    } 

    private void cargarPeriodos() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOPeriodo dto = new DTOPeriodo();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setPais(pais);
         
         DruidaConector conPeri = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("CRAObtenerPeriodos"));

         conPeri = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conPeri.objeto("DTOSalida");
         
         conPeri = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_PERI", "VAL_NOMB_PERI", "MARC_OID_MARC","CANA_OID_CANA","FEC_INIC","FEC_FINA");
         asignar("COMBO", "lstPeriodo", conPeri, "dtoSalida");
         
    }      
    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
         String campoNom, String campoF, String campoG, String campoH, String campoI) throws Exception {
         XMLDocument xmlDoc = new XMLDocument();
         Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

         String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);

         Element e_rows = docDestino.createElement("ROWSET");
         e_rows.setAttribute("ID", ID_Rows);
         docDestino.getDocumentElement().appendChild(e_rows);

         for (int i = 0; i < rs.getRowCount(); i++) {
             Element e_row = docDestino.createElement("ROW");
             e_rows.appendChild(e_row);

             Element e_campo1 = docDestino.createElement("CAMPO");
             e_campo1.setAttribute("NOMBRE", campoCod);
             e_campo1.setAttribute("TIPO", "OBJECTO");
             e_campo1.setAttribute("LONGITUD", "50");

             Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
                                                                                                      : rs.getValueAt(
                           i, campoCod).toString()));
             e_campo1.appendChild(txtCod);
             e_row.appendChild(e_campo1);

             Element e_campo2 = docDestino.createElement("CAMPO");
             e_campo2.setAttribute("NOMBRE", campoNom);
             e_campo2.setAttribute("TIPO", "OBJECTO");
             e_campo2.setAttribute("LONGITUD", "50");

             Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
                                                                                                        : rs.getValueAt(
                           i, campoNom).toString()));
             e_campo2.appendChild(txtDesc);
             e_row.appendChild(e_campo2);

             if (campoF != null) {
                  Element e_campo3 = docDestino.createElement("CAMPO");
                  e_campo3.setAttribute("NOMBRE", campoF);
                  e_campo3.setAttribute("TIPO", "OBJECTO");
                  e_campo3.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoF).toString()));
                  e_campo3.appendChild(txtF);
                  e_row.appendChild(e_campo3);
             }
             if (campoG != null) {
                  Element e_campo4 = docDestino.createElement("CAMPO");
                  e_campo4.setAttribute("NOMBRE", campoG);
                  e_campo4.setAttribute("TIPO", "OBJECTO");
                  e_campo4.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoG) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoG).toString()));
                  e_campo4.appendChild(txtF);
                  e_row.appendChild(e_campo4);
             }  
             if (campoH != null) {
                  Element e_campo5 = docDestino.createElement("CAMPO");
                  e_campo5.setAttribute("NOMBRE", campoG);
                  e_campo5.setAttribute("TIPO", "OBJECTO");
                  e_campo5.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoH) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoH).toString()));
                  e_campo5.appendChild(txtF);
                  e_row.appendChild(e_campo5);
             }        
             if (campoI != null) {
                  Element e_campo6 = docDestino.createElement("CAMPO");
                  e_campo6.setAttribute("NOMBRE", campoI);
                  e_campo6.setAttribute("TIPO", "OBJECTO");
                  e_campo6.setAttribute("LONGITUD", "50");

                  Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoI) == null) ? ""
                                                                                                      : rs.getValueAt(
                                i, campoI).toString()));
                  e_campo6.appendChild(txtF);
                  e_row.appendChild(e_campo6);
             }               
         }

         DruidaConector conect = new DruidaConector();
         conect.setXML(docDestino.getDocumentElement());

         return conect;
    }    

  private void generarReporte() throws Exception{
     //pagina("contenido_generando_fichero");    
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "PED");
     
     //comienzo de los parametrso de filtrado    

     String marca = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }

     String acceso    = conectorParametroLimpia("acceso", "", true);
     if(!acceso.equals("")){
        datos.put(ConstantesREP.ACCESOS, acceso);     
     }

     String periodos    = conectorParametroLimpia("periodo", "", true);
     if(!periodos.equals("")){
        datos.put(ConstantesREP.PERIODOS, periodos);     
     }
     
     String tiposol    = conectorParametroLimpia("tiposol", "", true);
     if(!tiposol.equals("")){
        datos.put(ConstantesREP.TIPOSOLICITUDES, tiposol);     
     }    
     
	 String zonas = conectorParametroLimpia("zonas", "", true);
     if(!zonas.equals("")){
        datos.put(ConstantesREP.ZONAS, zonas);     
     }
     datos.put(ConstantesREP.TITULO, "Informe Solicitudes de Pedidos Facturadas");
          
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-018", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-018", "pdf");
  }

   private ComposerViewElementList crearParametrosEntrada() throws Exception{
     traza("metodo crearParametrosEntrada() ");
     DTOBelcorp dtoBel = new DTOBelcorp();
     
     dtoBel.setOidPais(UtilidadesSession.getPais(this));
     dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
       
     ComposerViewElementList lista = new ComposerViewElementList();
     
     //Carga de combo marca
     ComposerViewElement cbMarca = new ComposerViewElement();
     cbMarca.setIDBusiness("SEGConsultaMarcas");
     cbMarca.setDTOE(dtoBel);
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);
                          
     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
     
     return lista;
   }
   private void cargarTiposSolicitud() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOBelcorp dto = new DTOBelcorp();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);         
         
         DruidaConector conTipoSoli = null;         

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("PEDObtenerTiposSolicitudPais"));

         conTipoSoli = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conTipoSoli.objeto("DTOSalida");


         //Subacceso
         conTipoSoli = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_TIPO_SOLI_PAIS", "VAL_I18N", "ACCESO","MARCA","CANAL",null);
         asignar("COMBO", "lstTipoSoli", conTipoSoli, "dtoSalida");
         
    }         
}
