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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class PEDEstadoDigitacionInformeDiario extends LPSICCBase {   
  
   Long pais = null;
   Long idioma = null;

   public PEDEstadoDigitacionInformeDiario() {	 
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
           getConfiguracionMenu("PEDEstadoDigitacionInformeDiario");
        }
     
     } catch (Exception ex) {
     			
        /*cargarPagina();
        getConfiguracionMenu("PEDEstadoDigitacionInformeDiario");*/
               
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
      pagina("contenido_informe_estado_diario_generar");   
    
      ComposerViewElementList cv = crearParametrosEntrada();
      ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
      conector.ejecucion();
      DruidaConector resultados = conector.getConector();
      traza(" 4 " + resultados.getXML());
      
      asignarAtributo("VAR", "idioma", "valor", this.idioma.toString());
      asignarAtributo("VAR", "pais", "valor", this.pais.toString());

      cargarSubaccesos();
      this.generarHiddenFormatoFecha();
      asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");             
      asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
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
     
     String subaccesos    = conectorParametroLimpia("subaccesos", "", true);
     if(!subaccesos.equals("")){
        datos.put(ConstantesREP.SUBACCESOS, subaccesos);     
     }

     String fechaInicio    = conectorParametroLimpia("fechaInicio", "", true);
     if(!fechaInicio.equals("")){
        datos.put(ConstantesREP.FECHAINICIO, fechaInicio);     
     }
     
     String fechaFin    = conectorParametroLimpia("fechaFin", "", true);
     if(!fechaFin.equals("")){
        datos.put(ConstantesREP.FECHAFIN, fechaFin);     
     }     
     
     datos.put(ConstantesREP.TITULO, "Estado de Digitación Informe Diario");
          
     traza("++++++Antes de enviar a reportes " + datos); 
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-019", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-019", "pdf");
          
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
                  "OID_SBAC", "VAL_I18N", "ACCE_OID_ACCE");
         asignar("COMBO", "lstSubacceso", conSubacceso, "dtoSalida");
         
    }  
    

    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
         String campoNom, String campoF) throws Exception {
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
         }

         DruidaConector conect = new DruidaConector();
         conect.setXML(docDestino.getDocumentElement());

         return conect;
    }    
}
