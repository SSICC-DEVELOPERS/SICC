import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class CCCChequesDevueltosCancelados extends LPSICCBase {           
   public CCCChequesDevueltosCancelados() {	 
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
           getConfiguracionMenu("CCCChequesDevueltosCancelados");
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
     pagina("contenido_informe_cheques_devueltos_cancelados_generar");   
     this.generarHiddenFormatoFecha();
     
     
     
     
     String fechaActual = null;
     java.util.Date fecha = new java.util.Date(System.currentTimeMillis());
     String formatoFechaSesion = UtilidadesSession.getFormatoFecha(this);
     formatoFechaSesion = formatoFechaSesion.replace('m', 'M');
            
     SimpleDateFormat simpleDate = new SimpleDateFormat(formatoFechaSesion);
     fechaActual = simpleDate.format(fecha);
     traza("la fecha actual " + fechaActual);
     asignarAtributo("VAR", "fechaActual", "valor", fechaActual);     
     
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CCC");
     
     //comienzo de los parametrso de filtrado
        
     String fechaDesde        = conectorParametroLimpia("fechaDesde", "", true);
     datos.put(ConstantesREP.FECHADESDE, fechaDesde);
     
     String fechaHasta        = conectorParametroLimpia("fechaHasta", "", true);
     datos.put(ConstantesREP.FECHAHASTA, fechaHasta);
     
     String orden = conectorParametroLimpia("orden", "", true);
     String reporte = null;
     
     if(orden.equals("1")){
        datos.put(ConstantesREP.CRITERIODEORDENAMIENTO, "CONSUL");   
     }else{
        datos.put(ConstantesREP.CRITERIODEORDENAMIENTO, "FECHA");   
     }
       
     datos.put(ConstantesREP.TITULO, "Cheques Devueltos Cancelados");     
     traza("++++++Antes de enviar a reportes " + datos); 
       
          
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-134", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-134", "pdf");
    
    
          
    } 
  
  }
















