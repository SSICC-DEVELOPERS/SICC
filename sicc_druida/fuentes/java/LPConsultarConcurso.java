public class LPConsultarConcurso extends LPSICCBase{

  public LPConsultarConcurso(){
    super();
  }

  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {

			try{
			  this.rastreo();
			  this.conectorAction("LPMantenimientoConcursos");
			  this.conectorActionParametro("opcionMenu", "Consultar Concurso");
			  this.conectorActionParametro("accion", "");
			}catch(Exception e){
			  traza(e);
			  this.lanzarPaginaError(e);
			}
  
  }

}
