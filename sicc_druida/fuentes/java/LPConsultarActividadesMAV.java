import LPSICCBase;

public class LPConsultarActividadesMAV extends LPSICCBase{
	public LPConsultarActividadesMAV(){
		super();
	}

	public void inicio() throws Exception{	}

	public void ejecucion() throws Exception{
		// Llamar a "LPMantenimientoActividadesMAV" con acción = "consultar" y 
		// pasar en una variable "casodeuso" el valor "consultar".
		this.rastreo();
		setTrazaFichero();
		traza(">  ENTRANDO A LPConsultarActividadesMAV.ejecucion");
		try{
			conectorAction("LPMantenimientoActividadesMAV");
			conectorActionParametro("accion", "consultar");
			conectorActionParametro("casodeuso", "consultar");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
