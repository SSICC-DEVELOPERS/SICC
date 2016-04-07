//import LPSICCBase;

public class LPInsertarEjecutivos extends LPSICCBase {
	public LPInsertarEjecutivos() {super();}	

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
			traza("******* Entre a LPInsertarEjecutivos");
			conectorAction("LPEjecutivosCuenta");
      traza("******* Llamando a LPEjecutivosCuenta con accion inserta");

			//conectorActionParametro("accion", "inserta");

			//Modificado por Inc. BELC300014826.
			//Se cambia accion "insertar" por "asignaEjecutivo".
			conectorActionParametro("accion", "asignaEjecutivo");
			conectorActionParametro("casoDeUso", "insertar");
		}
    catch ( Exception e )  {
      e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}
