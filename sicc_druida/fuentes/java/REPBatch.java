import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.rep.dtos.DTOReporte;

import es.indra.mare.common.mln.MareBusinessID;
import java.util.Vector;
import es.indra.druida.DruidaConector;

import es.indra.mare.common.exception.MareException;
import java.lang.reflect.InvocationTargetException;

public class REPBatch extends LPSICCBase {           
   public REPBatch() {	 
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
        }else if(accion.equals("consultarEjecucion")) {
		   pagina("salidaGenerica");	 
		   traza("vengo por poleo de estado.....");	 
           pollEstadoGeneracion();
        }else if(accion.equals("mostrar")) {
           traza("vengo por mostrar el reporte.....");	 
		   asignoTagFichero();
		}
     
     } catch (Exception ex) {
     		              
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
  
  private void generarReporte() throws Exception{
     pagina("contenido_generando_fichero");   
     
  }
  
  private void pollEstadoGeneracion() throws Exception{
     traza("metodo: pollEstadoGeneracion(.....");	 

	 DTOString dtoS = new  DTOString();

	 dtoS.setOidPais(UtilidadesSession.getPais(this));
	 dtoS.setOidIdioma(UtilidadesSession.getIdioma(this));

	 String codigoRep =  conectorParametroLimpia("idProceso", "", true);
	 traza("el codigo de reporte, es: " + codigoRep);

	 dtoS.setCadena(codigoRep);

	 MareBusinessID bizId = new MareBusinessID("REPVerReporte");

     Vector params = new Vector();
     params.addElement( dtoS );
     params.addElement( bizId );
	 String extension = conectorParametroLimpia( "extension", "", true );
    
	 try {
       pagina("salidaGenerica"); 
	   asignarAtributo("VAR", "cerrarVentana", "valor", "0"); 
       traza("Antes conector: " + dtoS);
       DruidaConector dc = conectar( "ConectorPollEstados" , params);
       traza( "dc ");
    
       DTOReporte dtoSal = (DTOReporte) dc.objeto("dtoSalida");
       traza("DTO Reporte resultante: "+dtoSal.getResultados());
 
	   //llamo a, ver reporte....
	   //this.verReporte(dtoSal, extension); 
	   asignarAtributo("VAR", "ejecutar", "valor", "muestroReporte();"); 
       traza("acabo de tirar muestroReporte()......");

     } catch (Exception e) {

		 if(e instanceof InvocationTargetException) {
           if (((InvocationTargetException) e).getTargetException() instanceof MareException) {
                 MareException mareException = (MareException) ((InvocationTargetException) e).getTargetException();

                 traza("la mare-exc. que me retorna, tiene el codigo : " + mareException.getCode());	                 

   		        /*el registro esta en: GEN_REPOR, pero el blob esta vacio!.*/
                if (mareException.getCode() == 40601) {            
           		  this.lanzarPaginaError(e);
		          traza("if del blob vacio!!");
                  asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");
  			    /*el registro todavia no esta*/
                } else if(mareException.getCode() == 5) {        
                  traza("if del registro todavia no esta!!");  
                /*NamingException, todo mal!!*/ 
			    } else if(mareException.getCode() == 101){       
			      this.lanzarPaginaError(e);
				  traza("if del naming exception!!");
				  asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
                /*reporte encolado*/
			    } else if (mareException.getCode() == 40602) {
                  traza("if de reporte encolado!!");    
                /*reporte en ejec.*/ 
			    } else if (mareException.getCode() == 40603) {
                  traza("if de reporte ejecutandose!!");    
                /*reporte finaliz. err.*/
			    } else if (mareException.getCode() == 40604) {
                  traza("if de reporte con fin erroneo!!");    
			      this.lanzarPaginaError(e);
				  asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
                /*reporte abortado*/ 
			    } else if (mareException.getCode() == 40605) {
                  traza("if de reporte abortado!!");    
			      this.lanzarPaginaError(e);
				  asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
  	            }
		   } else { 
	           traza("que, no es instancia...........de: MareException??");
		       ByteArrayOutputStream stack = new ByteArrayOutputStream();
			   PrintStream out = new PrintStream(stack);
	  	       e.printStackTrace(out);
			   traza("EXCEPCION:" + stack.toString());
			   this.lanzarPaginaError(e);
			   asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
		   }
         } else {
           traza("que, no es instancia...........de: InvocationTargetException??");
           ByteArrayOutputStream stack = new ByteArrayOutputStream();
	       PrintStream out = new PrintStream(stack);
		   e.printStackTrace(out);
		   traza("EXCEPCION:" + stack.toString());
		   this.lanzarPaginaError(e);
		   asignarAtributo("VAR", "ejecutarError", "valor", "killTimeOut();");  
         } 
	 }
  }

  private void asignoTagFichero() throws Exception {
     traza("metodo: asignoTagFichero(.....");	 

	 DTOString dtoS = new  DTOString();

	 dtoS.setOidPais(UtilidadesSession.getPais(this));
	 dtoS.setOidIdioma(UtilidadesSession.getIdioma(this));

	 String codigoRep =  conectorParametroLimpia("idProceso", "", true);
	 traza("el codigo de reporte, es: " + codigoRep);

	 dtoS.setCadena(codigoRep);

	 MareBusinessID bizId = new MareBusinessID("REPVerReporte");

     Vector params = new Vector();
     params.addElement( dtoS );
     params.addElement( bizId );
	 String extension = conectorParametroLimpia( "extension", "", true );
    
     traza("Antes conector: " + dtoS);
     DruidaConector dc = conectar("ConectorPollEstados" , params);
     traza( "dc ");
    
     DTOReporte dtoSal = (DTOReporte) dc.objeto("dtoSalida");
     traza("DTO Reporte resultante: "+dtoSal.getResultados());

     //llamo a, ver reporte....
	 this.verReporte(dtoSal, extension);
  }

}