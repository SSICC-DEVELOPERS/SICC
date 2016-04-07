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

public class FACRegistroVentas extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public FACRegistroVentas() {	 
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
            cargarSubaccesos();
            getConfiguracionMenu("FACRegistroVentas");
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
      pagina("contenido_registro_ventas");   
	  traza("setie pagina");

      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());
	  asignarAtributo("LABELC", "lblPaisdt", "valor", this.pais.toString());

      cargarAccesos();
      cargarSubaccesos();      
	  asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
	  asignar("COMBO","cbTipoDocLegal",resultados,"FACObtenerTiposDocumentoLegal");

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
     
     //Carga de combo canales
     ComposerViewElement cbCanales = new ComposerViewElement();
     cbCanales.setIDBusiness("SEGConsultaCanales");
     cbCanales.setDTOE(dtoBel);

     //Carga tipo de Doc. legal
     ComposerViewElement cbTipoDocLegal = new ComposerViewElement();
     cbTipoDocLegal.setIDBusiness("FACObtenerTiposDocumentoLegal");
     cbTipoDocLegal.setDTOE(dtoBel);

     lista.addViewElement(cbCanales);   
	 lista.addViewElement(cbTipoDocLegal);   

     return lista;
  }

   private void cargarSubaccesos() throws Exception {
    
         DTOSalida dtoS = new DTOSalida();
         DTOOID dto = new DTOOID();
         dto.setOidIdioma(idioma);
         dto.setOidPais(pais);
         dto.setOid(null);
         
         DruidaConector conSubacceso = null;         

         /*DTOBelcorp dtoE = new DTOBelcorp();
         dtoE.setOidIdioma(idioma);*/

         Vector paramEntrada = new Vector();
         paramEntrada.add(dto);
         paramEntrada.add(new MareBusinessID("SEGObtenerSubccesosSinFiltro"));

         conSubacceso = conectar("ConectorObjeto", paramEntrada);

         dtoS = (DTOSalida) conSubacceso.objeto("DTOSalida");


         //Subacceso
         conSubacceso = generaConector(dtoS.getResultado(), "dtoSalida",
                  "OID_SBAC", "VAL_I18N", "ACCE_OID_ACCE", null, null, null);
         asignar("COMBO", "lstSubacceso", conSubacceso, "dtoSalida");
         
    }  

 private void generarReporte() throws Exception{
        // pagina("contenido_generando_fichero");
        
     HashMap datos = new HashMap();
     datos.put("MODULO", "PED");
     
     //comienzo de los parametrso de filtrado    

     String canal        = conectorParametroLimpia("canal", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);     
     }

     String Fdesde = conectorParametroLimpia("desde", "", true);
     if(!Fdesde.equals("")){
        datos.put(ConstantesREP.FECHADESDE, Fdesde);     
     }

     String Fhasta = conectorParametroLimpia("hasta", "", true);
     if(!Fhasta.equals("")){
        datos.put(ConstantesREP.FECHAHASTA, Fhasta);     
     }

     String accesos    = conectorParametroLimpia("acceso", "", true);
     if(!accesos.equals("")){
        datos.put(ConstantesREP.ACCESOS, accesos);     
     }

     String subaccesos    = conectorParametroLimpia("subacceso", "", true);
     if(!subaccesos.equals("")){
        datos.put(ConstantesREP.SUBACCESOS, subaccesos);     
     }

     String tipodocleg    = conectorParametroLimpia("tipoDocLeg", "", true);
     if(!tipodocleg.equals("")){
        datos.put(ConstantesREP.TIPODOCUMENTOSLEGAL, tipodocleg);     
     }

     String serie    = conectorParametroLimpia("serie", "", true);
     if(!serie.equals("")){
        datos.put(ConstantesREP.SERIE, serie);     
     }

     String tipoinf    = conectorParametroLimpia("tipoInf", "", true);
     
     String reporte = null;
     String titulo = null;
     
     if(tipoinf.equals("1")){
        reporte = "RD_REP-164";
        titulo = "Informe Registro de Ventas- Documentos emitidos Detallado";
     }else{
        reporte = "RD_REP-164_01";
        titulo = "Informe Registro de Ventas- Documentos emitidos Resumen";
     }

     String descAccesos    = conectorParametroLimpia("descAccesos", "", true);
     if(!descAccesos.equals("")){
        datos.put(ConstantesREP.ACCESODESC, descAccesos);     
     }
     
     datos.put(ConstantesREP.TITULO, titulo);
     
     traza("++++++Antes de enviar a reportes " + datos);
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-164", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, "pdf");
          
  }

}
