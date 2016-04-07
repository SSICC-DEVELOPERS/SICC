import LPSICCBase;

public class LPEliminarListaConsultoras extends LPSICCBase {

  public LPEliminarListaConsultoras() {
    super();
  }

  public void inicio() throws Exception {}
    
  public void ejecucion() throws Exception {
    rastreo();
    conectorAction( "LPMantenimientoConsultoras" );
    conectorActionParametro( "opcionMenu", "Eliminar mensaje" );
    conectorActionParametro( "accion", "" );
  }
}

