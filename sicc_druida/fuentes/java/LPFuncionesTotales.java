import es.indra.sicc.rep.logicanegocio.ConstantesREP;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

public class LPFuncionesTotales extends LPSICCBase {           
   public LPFuncionesTotales() {	 
     super();
  }

  public void inicio() throws Exception { 
     
  }

  public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     traza("la accion es " + accion);
     setTrazaFichero();
     try {
        this.rastreo();
        
        if (accion.equals("generar")){
           generarReporte();         
        }else{
           pagina("contenido_listado_funciones_totales_obtener"); 
			     asignarAtributo("VAR", "casoDeUso", "valor","LPFuncionesTotales");
			     getConfiguracionMenu("LPFuncionesTotales");
        }
     
     } catch (Exception ex) {
        traza("sale de excepcion");
		//	  pagina("contenido_listado_funciones_totales_obtener"); 
		//	  asignarAtributo("VAR", "casoDeUso", "valor","LPFuncionesTotales");
			  getConfiguracionMenu("LPFuncionesTotales");

	      ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			  ex.printStackTrace(out);
	      traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
     
  }
   
   private void generarReporte() throws Exception{
        traza("entro a generar");
//        pagina("contenido_generando_fichero");     
        
        HashMap datos = new HashMap();
        datos.put(ConstantesREP.MODULO, "SEG");
        datos.put(ConstantesREP.TITULO, "LISTADO DE FUNCIONES TOTALES");
		    traza("ejecutarReporte2.....");
        ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-026", "pdf");
   }
} 
