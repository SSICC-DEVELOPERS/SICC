import java.lang.Exception;

public class LPConsultarTipoClienteComDetalle extends LPSICCBase {

    public LPConsultarTipoClienteComDetalle() {
        super();
    }


    public void inicio() throws Exception{
        traza("Entro Inicio LPConsultarTipoClienteComDetalle");
	}

	public void ejecucion() throws Exception {
		/*
		-> LLamar a la LPParamTipoClienteComDetalle con accion == "consultar"
		*/
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPConsultarTipoClienteComDetalle");
			conectorAction("LPParamTipoClienteComDetalle");
			conectorActionParametro("accion", "consultar");
      conectorActionParametro("opcionMenu", "consultarTipoClienteCom");
		}
		catch ( Exception e )  {
			traza("Exception en LPConsultarTipoClienteComDetalle");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
