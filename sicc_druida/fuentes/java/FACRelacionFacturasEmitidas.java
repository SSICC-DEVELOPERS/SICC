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
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

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

public class FACRelacionFacturasEmitidas extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public FACRelacionFacturasEmitidas() {	 
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
            //cargarPeriodos();
            getConfiguracionMenu("FACRelacionFacturasEmitidas");
         }
     
      } catch (Exception ex) {
     			
                
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
    	 PrintStream out = new PrintStream(stack);
	 	 ex.printStackTrace(out);
	     traza("EXCEPCION:" + stack.toString());
	 	 lanzarPaginaError(ex);
     }
   }

 private void generarReporte() throws Exception{
        // pagina("contenido_generando_fichero");
        
     HashMap datos = new HashMap();
     datos.put("MODULO", "FAC");
     
     //comienzo de los parametrso de filtrado    

     String marca        = conectorParametroLimpia("marca", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);     
     }
     
     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }
        
     String periodo    = conectorParametroLimpia("periodo", "", true);
     String periodoDesc    = conectorParametroLimpia("periodoDesc", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODO, periodo);     
        datos.put(ConstantesREP.PERIODODESC, periodoDesc);     
     }
     
     String accesos    = conectorParametroLimpia("acceso", "", true);
     if(!accesos.equals("")){
        datos.put(ConstantesREP.ACCESO, accesos);     
     }
    
     String regiones    = conectorParametroLimpia("region", "", true);
     if(!regiones.equals("")){
        datos.put(ConstantesREP.REGIONES, regiones);     
     }    
     
     String zonas    = conectorParametroLimpia("zonas", "", true);
     if(!zonas.equals("")){
        datos.put(ConstantesREP.ZONAS, zonas);     
     }    
     
     String Fdesde = conectorParametroLimpia("desde", "", true);
     if(!Fdesde.equals("")){
        datos.put(ConstantesREP.FECHAINICIO, Fdesde);     
     }

     String Fhasta = conectorParametroLimpia("hasta", "", true);
     if(!Fhasta.equals("")){
        datos.put(ConstantesREP.FECHAFIN, Fhasta);     
     }
     
     datos.put(ConstantesREP.TITULO, "Relacion Facturas Emitidas");
        
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-158", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-158", "pdf");
          
  }

   private void cargarPagina() throws Exception{
      traza("seteo pagina");
      pagina("contenido_relacion_facturas_emitidas");   
	  traza("setie pagina");

      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());
	  asignarAtributo("LABELC", "lblPaisdt", "valor", UtilidadesSession.getDescripcionPais(this));

	  String formatoFechaPais = UtilidadesSession.getFormatoFecha(this);
	  asignarAtributo("VAR", "formatoFecha", "valor", formatoFechaPais);

      cargarAccesos();
      //cargarPeriodos();
      cargarRegiones();
      //cargarZonas();

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
         
         conPeri = generaConector1(dtoS.getResultado(), "dtoSalida",
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

    private DruidaConector generaConector1(RecordSet rs, String ID_Rows, String campoCod,
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
                  Date aux = (Date)rs.getValueAt(i, campoH);
                  String dDesde = ((rs.getValueAt(i, campoH) == null) ? null : UtilidadesBelcorp.fechaFormateada(aux, formatoFechaPais));
				  Text txtF = docDestino.createTextNode(dDesde);

                  e_campo5.appendChild(txtF);
                  e_row.appendChild(e_campo5);
             }        
             if (campoI != null) {
                  Element e_campo6 = docDestino.createElement("CAMPO");
                  e_campo6.setAttribute("NOMBRE", campoI);
                  e_campo6.setAttribute("TIPO", "OBJECTO");
                  e_campo6.setAttribute("LONGITUD", "50");
                  Date aux1 = (Date)rs.getValueAt(i, campoI);
		   		  String dHasta = ((rs.getValueAt(i, campoI) == null) ? null : UtilidadesBelcorp.fechaFormateada(aux1, formatoFechaPais));
                  Text txtF = docDestino.createTextNode(dHasta);

                  e_campo6.appendChild(txtF);
                  e_row.appendChild(e_campo6);
             }               
         }

         DruidaConector conect = new DruidaConector();
         conect.setXML(docDestino.getDocumentElement());

         return conect;
    } 

}
