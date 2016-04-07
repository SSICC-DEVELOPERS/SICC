import LPSICCBase;

public class LPConsultarListaConsultoras extends LPSICCBase {

  public LPConsultarListaConsultoras() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
    rastreo();
    conectorAction( "LPMantenimientoConsultoras" );
    conectorActionParametro( "opcionMenu", "Consultar mensaje" );
    conectorActionParametro( "accion", "" );
  }
}

