//import LPSICCBase;

public class LPInsertarParametrosCAR extends LPSICCBase{
	public LPInsertarParametrosCAR() {super();}
	
	public void inicio() throws Exception {}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       
	 * @version     
	 * @autor
	 * Fecha:		19/07/2005
	 * @modified	mmaidana
	 * Se modifico el metodo ejecucion por Inc. BELC300014826
	 */
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {
			rastreo();
			traza("caso de uso = inserta");
			conectorAction("LPParametrosCAR");

			//conectorActionParametro("accion", "inserta");

			//Modificado por Inc. BELC300014826.
			//Se cambia accion "inserta" por "asignaCodigo".
			conectorActionParametro("accion", "asignaCodigo");

			conectorActionParametro("casoDeUso", "insertar");
		} catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
