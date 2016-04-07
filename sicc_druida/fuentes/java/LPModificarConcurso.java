public class LPModificarConcurso extends LPSICCBase{

  public LPModificarConcurso(){
    super();
  }

  public void inicio() throws Exception {}
  
  public void ejecucion() throws Exception {

                           try{
                             this.rastreo();
                             this.conectorAction("LPMantenimientoConcursos");
                             this.conectorActionParametro("opcionMenu", "Modificar Concurso");
                             this.conectorActionParametro("accion", "");
                           }catch(Exception e){
                             traza(e);
                             this.lanzarPaginaError(e);
                           }
  
  }

}

