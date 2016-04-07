import java.lang.Exception;

public class LPEliminarTipoClienteComDetalle extends LPSICCBase {

    public LPEliminarTipoClienteComDetalle() {
        super();
    }


    public void inicio() throws Exception{
        traza("Entro Inicio LPEliminarTipoClienteComDetalle");
	}

	public void ejecucion() throws Exception {
		/*
		-> LLamar a la LPParamTipoClienteComDetalle con accion == "eliminar"
		*/

		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPEliminarTipoClienteComDetalle");
			conectorAction("LPParamTipoClienteComDetalle");
			conectorActionParametro("accion", "eliminar"); 
      conectorActionParametro("opcionMenu", "eliminarTipoClienteCom"); 
		}
		catch ( Exception e )  {
			traza("Exception en LPEliminarTipoClienteComDetalle");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
