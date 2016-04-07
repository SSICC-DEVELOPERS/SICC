import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class CCCResumenCC extends LPSICCBase {           
   public CCCResumenCC() {	 
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
           getConfiguracionMenu("CCCResumenCC");
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
     pagina("contenido_informe_resumen_CCC_generar");   
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
       
     datos.put(ConstantesREP.TITULO, "Resumen de Cuentas Corrientes");     
     traza("++++++Antes de enviar a reportes " + datos); 
       
          
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-132", null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-132", "pdf");
    
    
          
    } 
  
  }















