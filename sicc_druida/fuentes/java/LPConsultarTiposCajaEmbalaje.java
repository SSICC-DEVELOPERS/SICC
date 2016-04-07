public class LPConsultarTiposCajaEmbalaje extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;

    public LPConsultarTiposCajaEmbalaje() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPConsultarTiposCajaEmbalaje.ejecucion(): Entrada");
        conectorAction("LPMantenimientoTiposCajaEmbalaje");
        conectorActionParametro("accion", "");
        conectorActionParametro("opcionMenu", "ConsultarTiposCajaEmbalaje");
        traza("LPConsultarTiposCajaEmbalaje.ejecucion(): Salida");
    }
}
