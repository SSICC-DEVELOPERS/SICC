public class LPConsultarMensaje extends LPSICCBase {

  public LPConsultarMensaje() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
    this.conectorAction( "LPMantenimientoMensajes" );
    this.conectorActionParametro( "opcionMenu", "Consultar mensaje" );
    this.conectorActionParametro( "casoDeUso", "Consultar mensaje" );
    this.conectorActionParametro( "accion", "" );
  }
}
