import LPSICCBase;

public class LPModificarMensaje extends LPSICCBase {

    public LPModificarMensaje() {
        super();
    }

    public void inicio() throws Exception {
    }
    
    public void ejecucion() throws Exception {
      this.conectorAction("LPMantenimientoMensajes");
      this.conectorActionParametro( "opcionMenu", "Modificar mensaje" );
      this.conectorActionParametro( "casoDeUso", "Modificar mensaje" );
      this.conectorActionParametro( "accion", "" );
    }
}
