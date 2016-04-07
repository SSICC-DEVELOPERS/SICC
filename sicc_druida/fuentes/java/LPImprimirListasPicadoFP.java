public class LPImprimirListasPicadoFP extends LPSICCBase {
    private String accion = null;
    private String opcionMenu = null;

    public LPImprimirListasPicadoFP() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPImprimirListasPicadoFP.ejecucion(): Entrada");
        conectorAction("LPImpresionListaPicadoFP");
        conectorActionParametro("accion", "");
        //conectorActionParametro("opcionMenu", "InsertarTiposCajaEmbalaje");
        traza("LPImprimirListasPicadoFP.ejecucion(): Salida");
    }
}
