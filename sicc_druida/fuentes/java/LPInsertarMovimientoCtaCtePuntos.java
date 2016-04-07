public class LPInsertarMovimientoCtaCtePuntos extends LPSICCBase{

  public LPInsertarMovimientoCtaCtePuntos(){
    super();
  }

  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {

			  try{
				 this.rastreo();
				 this.conectorAction("LPMovimientoCtaCtePuntosInsertar");
				 this.conectorActionParametro("opcionMenu", "Insertar Movimientos en Cuenta Corriente de Puntos");
				 this.conectorActionParametro("accion", "");
			  }catch(Exception e){
				 traza(e);
				 this.lanzarPaginaError(e);
			  }
  
  }

}