import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import es.indra.sicc.dtos.com.DTOComisiones;
import java.io.PrintStream;

public class LPGuardarComisiones extends LPComisiones {
	private String accion = null;

	public LPGuardarComisiones() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {
		setTrazaFichero();    
  		traza("************ Entre a LPGuardarComisiones");
		accion = conectorParametroLimpia("accion", "", true);
 		traza("************ accion:" + accion);
    
//		try {
//			if(accion.equals("guardar"))  {
//				this.guardar();
//			}      
//		}
/*		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		}    */
  }
  
  public void guardar () throws Exception {
    setTrazaFichero();
    traza("************ Entre a guardar - LPGuardarComisiones");

    /*-> Llamar al método "getComision()" y recuperar el DTOComisiones 
      -> Crear idBusiness = "COMGuardarComisiones" 
      -> Asignar conector "ConectorGuardarComisiones" con idBusiness y dto anteriores */

/*		DTOComisiones dtoComisiones = this.getComision();
    
    MareBusinessID businessID = new MareBusinessID("COMGuardarComisiones");
		Vector parametros = new Vector();
		parametros.add(dtoComisiones);
		parametros.add(businessID);*/

//		try {      
//	    traza("******************* Antes de conectar");			
//      DruidaConector con = conectar("ConectorGuardarComisiones", parametros);
//			traza("******************* Despues de conectar");

// 	    asignarAtributo("VAR","ejecutar","valor","reInicio()");   
		throw new Exception();
//    }
/*    catch(Exception e) {
      traza("******************* Entro al catch...");        
      asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
      throw e;
    }        */
  }   
}