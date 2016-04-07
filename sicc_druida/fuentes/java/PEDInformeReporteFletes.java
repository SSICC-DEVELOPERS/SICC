import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mln.MareBusinessID;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class PEDInformeReporteFletes extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public PEDInformeReporteFletes() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();

      pais = UtilidadesSession.getPais(this);
      idioma = UtilidadesSession.getIdioma(this);     
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("PEDInformeReporteFletes");
        }
     
     } catch (Exception ex) {
     			
        /*cargarPagina();
        getConfiguracionMenu("PEDEstadoDigitacionInformeHora");*/
               
        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);
      /*  try{
            cargarPagina();
        }catch(Exception e){
            e.printStackTrace();
        }*/

     }

    
  }
  
  private void cargarPagina() throws Exception{
      pagina("contenido_informe_reporte_fletes_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());

      cargarAccesos();
      //cargarPeriodos(); //comentado por Sapaza, para que los periodos no se cargen en la LP 
      cargarRegiones();
      //cargarZonas(); //comentado por Sapaza, para que las zonas no se cargen en la LP 
      cargarTipoSubtipo();
      cargarTipoClasiClasi();
           
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
      asignar("COMBO","cbTipoDespacho",resultados,"PEDObtenerTipoDespacho");
     
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
                          
     //Carga de combo TipoDespacho
     ComposerViewElement cbTipoDespacho = new ComposerViewElement();
     cbTipoDespacho.setIDBusiness("PEDObtenerTipoDespacho");
     cbTipoDespacho.setDTOE(dtoBel);    

     lista.addViewElement(cbMarca);
     lista.addViewElement(cbCanales);   
     lista.addViewElement(cbTipoDespacho);   
        
     
     return lista;
  }
         
  
 private void generarReporte() throws Exception{
        // pagina("contenido_generando_fichero");
        
     HashMap datos = new HashMap();
     datos.put("MODULO", "PED");
     
     //comienzo de los parametrso de filtrado    
 
     
     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }
        
     String accesos    = conectorParametroLimpia("accesos", "", true);
     if(!accesos.equals("")){
        datos.put(ConstantesREP.ACCESOS, accesos);     
     }

     String periodos    = conectorParametroLimpia("periodos", "", true);
     if(!periodos.equals("")){
        datos.put(ConstantesREP.PERIODOS, periodos);     
     }
     
     String regiones    = conectorParametroLimpia("regiones", "", true);
     if(!regiones.equals("")){
        datos.put(ConstantesREP.REGIONES, regiones);     
     }   
     
     String zonas    = conectorParametroLimpia("zonas", "", true);
     if(!zonas.equals("")){
        datos.put(ConstantesREP.ZONAS, zonas);     
     }    
     
     String tiposdespacho    = conectorParametroLimpia("tiposdespacho", "", true);
     if(!tiposdespacho.equals("")){
        datos.put(ConstantesREP.TIPODESPACHOS, tiposdespacho);
     }    
     
     String tiposcliente    = conectorParametroLimpia("tiposcliente", "", true);
     if(!tiposcliente.equals("")){
        datos.put(ConstantesREP.TIPOCLIENTES, tiposcliente);     
     }    
     
     String subtiposcliente    = conectorParametroLimpia("subtiposcliente", "", true);
     if(!subtiposcliente.equals("")){
        datos.put(ConstantesREP.SUBTIPOCLIENTES, subtiposcliente);     
     }    
     
     String tiposclasifica    = conectorParametroLimpia("tiposclasifica", "", true);
     if(!tiposclasifica.equals("")){
        datos.put(ConstantesREP.TIPOCLASIFICACIONES, tiposclasifica);     
     }    
     
     String clasificaciones    = conectorParametroLimpia("clasificaciones", "", true);
     if(!clasificaciones.equals("")){
        datos.put(ConstantesREP.CLASIFICACIONES, clasificaciones);     
     }    
     
     datos.put(ConstantesREP.TITULO, "Reporte de Fletes");
        
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-026PED", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-026PED", "pdf");
          
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
    
   private void cargarRegiones() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOOID dto = new DTOOID();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setOid(null);
         
         DruidaConector conRegion = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("ZONObtenerRegionesPorPais"));

         conRegion = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conRegion.objeto("DTOSalida");


         conRegion = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID", "DESCRIPCION", "MARCA","CANAL",null,null);
         asignar("COMBO", "lstRegion", conRegion, "dtoSalida");
         
    }  
    
   private void cargarZonas() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOUnidadAdministrativa dto = new DTOUnidadAdministrativa();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setOidMarca(null);
         dto.setOidCanal(null);
         
         DruidaConector conZona = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));

         conZona = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conZona.objeto("DTOSalida");


         conZona = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_ZONA", "ZORG_OID_REGI", "DES_ZONA","MARCA","CANAL",null);
         asignar("COMBO", "lstZona", conZona, "dtoSalida");
         
    }         

   private void cargarTipoSubtipo() throws Exception {
    
         DTOTipoSubtipo dtoS = new DTOTipoSubtipo();
         DTOBelcorp dto = new DTOBelcorp();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         
         DruidaConector conTipo = null;         
         DruidaConector conSubtipo = null;  

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("MAEObtenerTipoSubtipo"));

         conTipo = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOTipoSubtipo) conTipo.objeto("DTOSalida");


         conTipo = generaConector(dtoS.getTipos(), "dtoSalida",
                  "OID_TIPO_CLIE", "VAL_I18N", null,null,null,null);
         asignar("COMBO", "lstTipo", conTipo, "dtoSalida");

         conSubtipo = generaConector(dtoS.getSubtipos(), "dtoSalida",
                  "OID_SUBT_CLIE", "TICL_OID_TIPO_CLIE", "VAL_I18N",null,null,null);
         asignar("COMBO", "lstSubTipo", conSubtipo, "dtoSalida");         
         
    }         

   private void cargarTipoClasiClasi() throws Exception {
    
         DTOClasificaciones dtoS = new DTOClasificaciones();
         DTOBelcorp dto = new DTOBelcorp();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         
         DruidaConector conTipoClasi = null;         
         DruidaConector conClasi = null;  

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("MSGObtenerClasificacion"));

         conTipoClasi = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOClasificaciones) conTipoClasi.objeto("DTOSalida");


         conTipoClasi = generaConector(dtoS.getTipoClasificacion(), "dtoSalida",
                  "OID_TIPO_CLAS", "SBTI_OID_SUBT_CLIE", "VAL_I18N",null,null,null);
         asignar("COMBO", "lstTipoClasi", conTipoClasi, "dtoSalida");

         conClasi = generaConector(dtoS.getClasificacion(), "dtoSalida",
                  "OID_CLAS", "TCCL_OID_TIPO_CLAS", "VAL_I18N",null,null,null);
         asignar("COMBO", "lstClasi", conClasi, "dtoSalida");         
         
    }         



    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
         String campoNom, String campoF, String campoG, String campoH, String campoI) throws Exception {
         XMLDocument xmlDoc = new XMLDocument();
         Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

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
}

