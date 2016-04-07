import LPSICCBase;
import java.io.*;

public class LPEliminarParametrosCAR extends LPSICCBase{
	public LPEliminarParametrosCAR() {super();}
	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = elimina");
			conectorAction("LPParametrosCAR");
			conectorActionParametro("accion", "elimina");
      conectorActionParametro("casoDeUso", "eliminar");
		} catch ( Exception e )  {
			   traza("EXCEPCION " + e);
         
         ByteArrayOutputStream stack = new ByteArrayOutputStream();
			   PrintStream out = new PrintStream(stack);
			   e.printStackTrace(out);
			   traza("EXCEPCION:" + stack.toString());
			   lanzarPaginaError(e);
		}	
	}
}
