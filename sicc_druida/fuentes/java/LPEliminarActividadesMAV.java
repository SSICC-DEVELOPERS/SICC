import LPSICCBase;

public class LPEliminarActividadesMAV extends LPSICCBase{
	public LPEliminarActividadesMAV(){
		super();
	}

	public void inicio()throws Exception{}

	public void ejecucion() throws Exception{
		// Llamar a "LPMantenimientoActividadesMAV" con acción = "consultar" 
		// y pasar en una variable "casodeuso" el valor "eliminar".
		this.rastreo();
		setTrazaFichero();
		traza(">  ENTRANDO A LPEliminarActividadesMAV.ejecucion");
		try{
			conectorAction("LPMantenimientoActividadesMAV");
			conectorActionParametro("accion", "consultar");
			conectorActionParametro("casodeuso", "eliminar");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
