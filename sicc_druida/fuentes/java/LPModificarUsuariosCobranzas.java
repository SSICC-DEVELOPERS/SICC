public class LPModificarUsuariosCobranzas extends LPSICCBase
{
	public LPModificarUsuariosCobranzas() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception 
    {   setTrazaFichero();
		try  
		{	rastreo();
			traza("caso de uso = modificar");
			/*Llama a la LPUsuariosCobranzas con: 
				- accion="insertar" */
			conectorAction("LPUsuariosCobranzas");
			conectorActionParametro("accion", "modificar");
			conectorActionParametro("casoDeUso", "modificar");
		} 
		catch ( Exception e )  
		{	e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}