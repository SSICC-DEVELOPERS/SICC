public class LPModificarTiposCajaEmbalaje extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;

    public LPModificarTiposCajaEmbalaje() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPModificarTiposCajaEmbalaje.ejecucion(): Entrada");
        conectorAction("LPMantenimientoTiposCajaEmbalaje");
        conectorActionParametro("accion", "");
        conectorActionParametro("opcionMenu", "ModificarTiposCajaEmbalaje");
        traza("LPModificarTiposCajaEmbalaje.ejecucion(): Salida");
    }
}
