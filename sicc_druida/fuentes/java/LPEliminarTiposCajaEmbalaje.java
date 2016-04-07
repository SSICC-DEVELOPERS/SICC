public class LPEliminarTiposCajaEmbalaje extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;

    public LPEliminarTiposCajaEmbalaje() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPEliminarTiposCajaEmbalaje.ejecucion(): Entrada");
        conectorAction("LPMantenimientoTiposCajaEmbalaje");
        conectorActionParametro("accion", "");
        conectorActionParametro("opcionMenu", "EliminarTiposCajaEmbalaje");
        traza("LPEliminarTiposCajaEmbalaje.ejecucion(): Salida");
    }
}
