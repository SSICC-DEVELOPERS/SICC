import java.lang.Exception;

public class LPInsertarTipoClienteComDetalle extends LPSICCBase {

    public LPInsertarTipoClienteComDetalle() {
        super();
    }


    public void inicio() throws Exception{
        traza("Entro Inicio LPInsertarTipoClienteComDetalle");
	}

	public void ejecucion() throws Exception {
		/*
		-> LLamar a la LPParamTipoClienteComDetalle con accion == "insertar"
		*/
		setTrazaFichero();
		try  {
			this.rastreo();
			traza("*********** Entre a LPInsertarTipoClienteComDetalle");
			conectorAction("LPParamTipoClienteComDetalle");
			conectorActionParametro("accion", "insertar");
      conectorActionParametro("opcionMenu", "insertarTipoClienteCom");
		}
		catch ( Exception e )  {
			traza("Exception en LPInsertarTipoClienteComDetalle");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
