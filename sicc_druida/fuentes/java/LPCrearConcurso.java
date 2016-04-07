public class LPCrearConcurso extends LPSICCBase{

  public LPCrearConcurso(){
    super();
  }

  public void inicio() throws Exception {
    this.pagina("contenido_concurso_crear");
  }
  
  public void ejecucion() throws Exception{
  
	setTrazaFichero();

	traza("LPCrearConcurso.ejecucion()");

    this.setTrazaFichero();
  
    try{
      //this.rastreo();
      this.conectorAction("LPMantenimientoConcursos");
      this.conectorActionParametro("opcionMenu", "Crear concurso");
      this.conectorActionParametro("accion", "");
    }catch(Exception e){
      traza("Excepcion en LPCrearConcurso: " + e.toString());
      traza(e);
      this.lanzarPaginaError(e);
    }
  }

}
