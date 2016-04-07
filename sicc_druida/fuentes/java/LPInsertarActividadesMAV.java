

public class LPInsertarActividadesMAV extends LPSICCBase{
	public LPInsertarActividadesMAV(){
		super();
	}

	public void inicio() throws Exception{
	}

	public void ejecucion() throws Exception {
		this.rastreo();
		setTrazaFichero();
		traza("Entro en LPInsertarActividadesMAV...");
		try{
			conectorAction("LPMantenimientoActividadesMAV");
			conectorActionParametro("accion", "insertar");		
			conectorActionParametro("casodeuso","insertar");
			traza("Delegando a LPMantenimientoActividadesMAV");
		} catch(Exception e){
			this.lanzarPaginaError(e);
		}
	}
}
