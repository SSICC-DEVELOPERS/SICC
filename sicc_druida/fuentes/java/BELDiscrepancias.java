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

public class BELDiscrepancias extends LPSICCBase {           
   public BELDiscrepancias() {	 
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
           getConfiguracionMenu("BELDiscrepancias");
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
     pagina("contenido_discrepancias_obtener");   
    
     ComposerViewElementList cv = crearParametrosEntrada();
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     conector.ejecucion();
     DruidaConector resultados = conector.getConector();
     traza(" 4 " + resultados.getXML());
         
     asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
        
     this.generarHiddenFormatoFecha();
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "BEL");
     
     //comienzo de los parametrso de filtrado
             
     String canal = conectorParametroLimpia("canal", "", true);
     String canalDesc = conectorParametroLimpia("canalDesc", "", true);
     if(!canal.equals("")){
        datos.put(ConstantesREP.CANAL, canal);
        datos.put(ConstantesREP.CANALDESC, canalDesc);
     }
     
     String acceso = conectorParametroLimpia("acceso", "", true);
     String accesoDesc = conectorParametroLimpia("accesoDesc", "", true);
     if(!acceso.equals("")){
        datos.put(ConstantesREP.ACCESO, acceso);
        datos.put(ConstantesREP.ACCESODESC, accesoDesc);
     }
     
     String subacceso        = conectorParametroLimpia("subacceso", "", true);
     if(!subacceso.equals("")){
        datos.put(ConstantesREP.SUBACCESOS, subacceso);     
     }
     
     String fechaDesde        = conectorParametroLimpia("fechaDesde", "", true);
     if(!fechaDesde.equals("")){
        datos.put(ConstantesREP.FECHADESDE, fechaDesde);     
     }
     
     String fechaHasta        = conectorParametroLimpia("fechaHasta", "", true);
     if(!fechaHasta.equals("")){
        datos.put(ConstantesREP.FECHAHASTA, fechaHasta);     
     }
            
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
        datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
    
     datos.put(ConstantesREP.TITULO, "Discrepancias en Hoja de Demanda");     
     traza("++++++Antes de enviar a reportes " + datos); 
     String reporte = null;
     
     String grupoDiferencias        = conectorParametroLimpia("grupoDiferencias", "", true);
     
     if(grupoDiferencias.equals("1")){
        reporte = "RD_REP-093_01";
     }else{
        if(grupoDiferencias.equals("2")){
           reporte = "RD_REP-093_02";
        }else{
           reporte = "RD_REP-093_03";
        }
     }
     
     datos.put(ConstantesREP.GRUPODIFERENCIAS, grupoDiferencias);     
     traza("el formaro es  " + formato);
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, formato);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, formato);
    
          
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
                          
    
     lista.addViewElement(cbCanales);   
        
     
     return lista;
  }
  
  
 
  
  

    
  
 
 


}












