import es.indra.sicc.rep.logicanegocio.ConstantesREP;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
//import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class COBConsultaCobranza extends LPSICCBase {           
   public COBConsultaCobranza() {	 
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
           getConfiguracionMenu("COBConsultaCobranza");
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
     pagina("contenido_informe_consulta_cobranza_generar");   
     
     asignarAtributo("VAR", "idioma", "valor", UtilidadesSession.getIdioma(this).toString());
     asignarAtributo("VAR", "pais", "valor", UtilidadesSession.getPais(this).toString());
     asignarAtributo("VAR","hLongCliente", "valor", this.obtenerLongitudCodigoCliente().toString());

    
      
  }
          
  
 private void generarReporte() throws Exception{
     
  
     HashMap datos = new HashMap();
     datos.put("MODULO", "COB");
     
     //comienzo de los parametrso de filtrado
        
     String codigoCliente        = conectorParametroLimpia("codigoCliente", "", true);
     datos.put(ConstantesREP.CODIGOCLIENTE, codigoCliente);
     
     String titulo = null;
     String reporte = null;
     String camposBusqueda = conectorParametroLimpia("camposBusqueda", "", true);
     
     if(camposBusqueda.equals("1")){
        titulo = "Cargos Pendientes de Pago";
        reporte = "RD_REP-124";
     }else{
        if(camposBusqueda.equals("2")){
           titulo = "Cargos Cancelados en Gestion de Cobranza de Pago";
           reporte = "RD_REP-124_01";
        }
     }
        
     datos.put(ConstantesREP.TITULO, titulo);     
     traza("++++++Antes de enviar a reportes " + datos); 
             
     //ejecutarReporte(datos, "REPGenerarReporte", reporte, null);
     ejecutarReporte2(datos, "REPGenerarReporteBatch", reporte, "pdf");
          
  } 
  
   
    
   

  
 }















