public class LPEliminarUsuariosCobranzas extends LPSICCBase
{
	public LPEliminarUsuariosCobranzas() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception 
    {   setTrazaFichero();
		try  
		{	rastreo();
			traza("caso de uso = eliminar");
			/*Llama a la LPUsuariosCobranzas con: 
				- accion="insertar" */
			conectorAction("LPUsuariosCobranzas");
			conectorActionParametro("accion", "eliminar");
			conectorActionParametro("casoDeUso", "eliminar");
		} 
		catch ( Exception e )  
		{	e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}