public class LPModificarValoresPorDefecto extends LPSICCBase {

	public LPModificarValoresPorDefecto(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {

		setTrazaFichero();

		try{

			traza("LPModificarValoresPorDefecto - entrada");

			rastreo();

			traza("LPModificarValoresPorDefecto - hizo rastreo");

			this.conectorAction("LPMantieneValoresPorDefecto");

			traza("LPModificarValoresPorDefecto - hizo conectorAction");

			this.conectorActionParametro("accion", "muestraConsulta");
			this.conectorActionParametro("opcionMenu", "modificar");

			traza("LPModificarValoresPorDefecto - Salida");

		} catch(Exception e){
			traza("Exception en LPModificarValoresPorDefecto");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
