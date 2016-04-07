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

public class BELCierraPuertas extends LPSICCBase {           
   public BELCierraPuertas() {	 
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
           getConfiguracionMenu("BELCierraPuertas");
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
     pagina("contenido_atencion_cierra_puerta_obtener");   
    
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
             
     String canal        = conectorParametroLimpia("canal", "", true);
     datos.put(ConstantesREP.CANAL, canal);     
          
     String acceso        = conectorParametroLimpia("acceso", "", true);
     datos.put(ConstantesREP.ACCESO, acceso);     
          
     String subacceso        = conectorParametroLimpia("subacceso", "", true);
     datos.put(ConstantesREP.SUBACCESOS, subacceso);     
     
     String codigoDescuento        = conectorParametroLimpia("codigoDescuento", "", true);     
     if(!codigoDescuento.equals("")){
        datos.put(ConstantesREP.CODIGODESCUENTO, codigoDescuento);     
     }
     
     String fechaDesde        = conectorParametroLimpia("fechaDesde", "", true);
     datos.put(ConstantesREP.FECHADESDE, fechaDesde);     
         
     String fechaHasta        = conectorParametroLimpia("fechaHasta", "", true);
     datos.put(ConstantesREP.FECHAHASTA, fechaHasta);     
          
     String horaDesde        = conectorParametroLimpia("horaDesde", "", true);
     datos.put(ConstantesREP.HORADESDE, horaDesde);     
     
     String horaHasta        = conectorParametroLimpia("horaHasta", "", true);
     datos.put(ConstantesREP.HORAHASTA, horaHasta);     
                 
     
     String formatoSalida = conectorParametroLimpia("formatoSalida", "", true);
     String formato = null;
     
     if(formatoSalida.equals("xls")){
  		  datos.put(ConstantesREP.FORMATOSALIDA, "EXCEL");
        formato = "xls";
     }else{
        formato = "pdf";
     }
    
     datos.put(ConstantesREP.TITULO, "Atenciones de Cierra Puertas");     
     traza("++++++Antes de enviar a reportes " + datos); 
     String reporte = null;
     String detalle = conectorParametroLimpia("detalle", "", true);
     
     if(detalle.equals("1")){
        reporte = "RD_REP-096_01";
     }else{
        if(detalle.equals("2")){
           reporte = "RD_REP-096_02";
        }else{
           reporte = "RD_REP-096_03";
        }
     }
     
     traza("el reporte es " + reporte);
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












