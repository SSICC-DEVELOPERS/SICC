import LPSICCBase;

public class LPModificarActividadesMAV extends LPSICCBase{
	public LPModificarActividadesMAV(){
		super();
	}

	public void inicio() throws Exception{}

	public void ejecucion() throws Exception{
		// Llamar a "LPMantenimientoActividadesMAV" con acción = "consultar" y 
		// pasar en una variable "casodeuso" el valor "modificar"
		this.rastreo();
		setTrazaFichero();
		traza(">  ENTRANDO A LPModificarActividadesMAV.ejecucion");
		try{
			conectorAction("LPMantenimientoActividadesMAV");
			conectorActionParametro("accion", "consultar");
			conectorActionParametro("casodeuso", "modificar");
		} catch(Exception e){
			lanzarPaginaError(e);
		}
	}
}
