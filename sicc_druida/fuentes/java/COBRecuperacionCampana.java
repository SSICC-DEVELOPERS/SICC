import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class COBRecuperacionCampana extends LPSICCBase {           
   public COBRecuperacionCampana() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte(); 
           traza("termino de generar el reporte");
          //cargarPagina();
        }else{
           cargarPagina();
           getConfiguracionMenu("COBRecuperacionCampana");
        }
     
     } catch (Exception ex) {
     			
      // cargarPagina();
      //  getConfiguracionMenu("EDUFichaTecnicaCurso");
               
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
     pagina("contenido_informe_recuperacion_campana_generar");   
    
    
  
      
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
           
     asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");              
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     this.generarHiddenFormatoFecha();
  
      
  }
        
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "COB");
     
     //comienzo de los parametrso de filtrado
      
    
     String marca        = conectorParametroLimpia("marca", "", true);
	 String marcaDesc        = conectorParametroLimpia("marcaDesc", "", true);
     if(!marca.equals("")){
        datos.put(ConstantesREP.MARCA, marca);
		datos.put(ConstantesREP.MARCADESC, marcaDesc);
     } 
     
     String canal        = conectorParametroLimpia("canal", "", true);
     String canalDesc        = conectorParametroLimpia("canalDesc", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);
        datos.put(ConstantesREP.CANALDESC, canalDesc);
     } 
     
     String region        = conectorParametroLimpia("region", "", true);
	 String regionDesc        = conectorParametroLimpia("regionDesc", "", true);
     if(!region.equals("")){
        datos.put(ConstantesREP.REGION, region);
		datos.put(ConstantesREP.REGIONDESC, regionDesc);
     } 

   
     String zona        = conectorParametroLimpia("zona", "", true);
	 String zonaDesc        = conectorParametroLimpia("zonaDesc", "", true);
     if(!zona.equals("")){
        datos.put(ConstantesREP.ZONA, zona);
		datos.put(ConstantesREP.ZONADESC, zonaDesc);
     } 
     
     String seccion        = conectorParametroLimpia("seccion", "", true);
	 String seccionDesc        = conectorParametroLimpia("seccion", "", true);
     if(!seccion.equals("")){
        datos.put(ConstantesREP.SECCION, seccion);
		datos.put(ConstantesREP.SECCIONDESC, seccionDesc);
     } 
     
     String tipoReporte        = conectorParametroLimpia("tipoReporte", "", true);
     String reporte = null;
     
     if(tipoReporte.equals("1")){
        reporte = "RD_REP-129";
     }else{
        reporte = "RD_REP-129_01";
     }       
     
     
     String periodo        = conectorParametroLimpia("periodo", "", true);
	 String periodoDesc        = conectorParametroLimpia("periodoDesc", "", true);
     if(!periodo.equals("")){
        datos.put(ConstantesREP.PERIODOS, periodo);
		datos.put(ConstantesREP.PERIODODESC, periodoDesc);
     }
    
   
     String formato = conectorParametroLimpia("formato", "", true);
     String formatoSalida = null;
     
     if(formato.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formatoSalida = "xls";
     }else{
        formato = "pdf";
     }
       
     datos.put(ConstantesREP.TITULO, "Recuperacion por Campaña");     
     traza("++++++Antes de enviar a reportes " + datos); 
       
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-129", formatoSalida);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formato);
          
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

  
            
}

















