import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class CALLlamadasStatus extends LPSICCBase {           
   public CALLlamadasStatus() {	 
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
           getConfiguracionMenu("CALLlamadasStatus");
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
     pagina("contenido_llamadas_status_obtener");   
       
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR", "hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

       
     this.generarHiddenFormatoFecha();
     
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "CAL");
     
     //comienzo de los parametrso de filtrado
   
    
     
     String fechaInicio        = conectorParametroLimpia("fechaInicio", "", true);
     datos.put(ConstantesREP.FECHAINICIO, fechaInicio);     
     
     String fechaFin        = conectorParametroLimpia("fechaFin", "", true);
     datos.put(ConstantesREP.FECHAFIN, fechaFin);     
     
     String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
     if(!codigoCliente.equals("")){
        datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);     
     }
         
     datos.put(ConstantesREP.TITULO, "Llamadas por Status No Concluidas");     
       
     traza("++++++Antes de enviar a reportes " + datos); 
         
     //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-087" , null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-087", "pdf");
     
          
  } 
  
  
  
  

    
  
 
 


}














