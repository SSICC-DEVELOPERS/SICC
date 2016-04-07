import LPSICCBase;

public class LPEliminarMensaje extends LPSICCBase {

  public LPEliminarMensaje() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
    this.conectorAction( "LPMantenimientoMensajes" );
    this.conectorActionParametro( "opcionMenu", "Eliminar mensaje" );
    this.conectorActionParametro( "casoDeUso", "Eliminar mensaje" );
    this.conectorActionParametro( "accion", "" );
  }
}
