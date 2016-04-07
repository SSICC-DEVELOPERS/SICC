import es.indra.sicc.rep.logicanegocio.ConstantesREP;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;

public class LPFuncionesUsuarios extends LPSICCBase {           
   public LPFuncionesUsuarios() {	 
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
        }else{
			     pagina("contenido_listado_funciones_totales_obtener"); 
           asignarAtributoPagina("cod", "0732");
			     asignarAtributo("VAR", "casoDeUso", "valor","LPFuncionesUsuarios");
			     getConfiguracionMenu("LPFuncionesUsuarios");
		    }
     
     } catch (Exception ex) {
			   pagina("contenido_listado_funciones_totales_obtener"); 
			   asignarAtributo("VAR", "casoDeUso", "valor","LPFuncionesUsuarios");
			   getConfiguracionMenu("LPFuncionesUsuarios");

	        ByteArrayOutputStream stack = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(stack);
			ex.printStackTrace(out);
	        traza("EXCEPCION:" + stack.toString());
		    lanzarPaginaError(ex);

     }
     
  }
  
    private void generarReporte() throws Exception{
        
        HashMap datos = new HashMap();
        datos.put(ConstantesREP.MODULO, "SEG");
        datos.put(ConstantesREP.TITULO, "Funciones y usuarios");
        //ejecutarReporte(datos, "REPGenerarReporte", "RD_REP-027", null);
        ejecutarReporte2(datos, "REPGenerarReporteBatch", "RD_REP-027", "pdf");
    }
}
