public class LPEliminarValoresPorDefecto extends LPSICCBase {

	public LPEliminarValoresPorDefecto(){
		super();
	}

	public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {

		setTrazaFichero();

		try{

			traza("LPEliminarValoresPorDefecto - entrada");

			rastreo();

			traza("LPEliminarValoresPorDefecto - hizo rastreo");

			this.conectorAction("LPMantieneValoresPorDefecto");

			traza("LPEliminarValoresPorDefecto - hizo conectorAction");

			this.conectorActionParametro("accion", "muestraConsulta");
			this.conectorActionParametro("opcionMenu", "eliminar");

			traza("LPEliminarValoresPorDefecto - Salida");

		} catch(Exception e){
			traza("Exception en LPModificarValoresPorDefecto");
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
