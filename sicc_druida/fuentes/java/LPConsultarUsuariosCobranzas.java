public class LPConsultarUsuariosCobranzas extends LPSICCBase
{
	public LPConsultarUsuariosCobranzas() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception 
    {   setTrazaFichero();
		try  
		{	rastreo();
			traza("caso de uso = consultar");
			/*Llama a la LPUsuariosCobranzas con: 
				- accion="insertar" */
			conectorAction("LPUsuariosCobranzas");
			conectorActionParametro("accion", "consultar");
			conectorActionParametro("casoDeUso", "consultar");
		} 
		catch ( Exception e )  
		{	e.printStackTrace();     
			lanzarPaginaError(e);
		}	
	}
}