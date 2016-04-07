import java.lang.Exception;

public class LPModificarTipoClienteComDetalle extends LPSICCBase {

    public LPModificarTipoClienteComDetalle() {
        super();
    }


    public void inicio() throws Exception{
        traza("Entro Inicio LPModificarTipoClienteComDetalle");
	}

	public void ejecucion() throws Exception {
		/*
		-> LLamar a la LPParamTipoClienteComDetalle con accion == "modificar"
		*/
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPModificarTipoClienteComDetalle");
			conectorAction("LPParamTipoClienteComDetalle");
			conectorActionParametro("accion", "modificar"); 
      conectorActionParametro("opcionMenu", "modificarTipoClienteCom");
		}
		catch ( Exception e )  {
			traza("Exception en LPModificarTipoClienteComDetalle");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
