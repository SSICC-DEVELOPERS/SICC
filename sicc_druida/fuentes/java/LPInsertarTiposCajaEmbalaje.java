public class LPInsertarTiposCajaEmbalaje extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;

    public LPInsertarTiposCajaEmbalaje() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPInsertarTiposCajaEmbalaje.ejecucion(): Entrada");
        conectorAction("LPMantenimientoTiposCajaEmbalaje");
        conectorActionParametro("accion", "");
        conectorActionParametro("opcionMenu", "InsertarTiposCajaEmbalaje");
        traza("LPInsertarTiposCajaEmbalaje.ejecucion(): Salida");
    }
}
