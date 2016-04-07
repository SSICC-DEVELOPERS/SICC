import LPSICCBase;

public class LPModificarListaConsultoras extends LPSICCBase {
  public LPModificarListaConsultoras() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
    rastreo();
    conectorAction( "LPMantenimientoConsultoras" );
    conectorActionParametro( "opcionMenu", "Modificar mensaje" );
    conectorActionParametro( "accion", "" );
  }
}

