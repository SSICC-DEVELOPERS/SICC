public class LPInsertarUsuariosCobranzas extends LPSICCBase
{
	private String accion = null;
	private String oid = null;
	private String codUsuario = null;
	private String nombre = null;
	private String idUsuario = null;
	private String casoDeUso = "";

	public LPInsertarUsuariosCobranzas() {super();}	
	public void inicio() throws Exception {}

	public void ejecucion() throws Exception 
    {   setTrazaFichero();
   traza("*** Entrada - LPInsertarUsuariosCobranzas() - ejecucion ***");
		
		try  
		{	rastreo();
			traza("caso de uso = insertar");
			/*Llama a la LPUsuariosCobranzas con: 
				- accion="insertar" */

			traza("*** llamando a 'LPUsuariosCobranzas'");
			conectorAction("LPUsuariosCobranzas");

			accion = conectorParametroLimpia("accion", "", true);
			casoDeUso = conectorParametroLimpia("casoDeUso", "", true);
			
			if(accion == null || "".equals(accion))
			{
               conectorActionParametro("accion","insertar");		
			}
			else
			{
            oid = conectorParametroLimpia("oid", "", true);
			   codUsuario = conectorParametroLimpia("codUsuario", "", true);
			   nombre = conectorParametroLimpia("nombre", "", true);
			   idUsuario = conectorParametroLimpia("idUsuario", "", true);
			   conectorActionParametro("accion",accion);
			   conectorActionParametro("oid",oid);
			   conectorActionParametro("codUsuario",codUsuario);
			   conectorActionParametro("nombre",nombre);
			   conectorActionParametro("idUsuario",idUsuario);
			}
			
			conectorActionParametro("casoDeUso", (casoDeUso.equals("modificar")?"modificar":"insertar" ));
		} 
		catch ( Exception e )  
		{	e.printStackTrace();     
			lanzarPaginaError(e);
		}	
		traza("*** Salida - LPInsertarUsuariosCobranzas() - ejecucion ***");
	}
}

