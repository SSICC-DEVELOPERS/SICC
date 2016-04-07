public class LPIniciarCubicajeAFP extends LPSICCBase {
    //private String accion = null;
    //private String opcionMenu = null;

    public LPIniciarCubicajeAFP() {
        super();
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPIniciarCubicajeAFP.ejecucion(): Entrada");
        conectorAction("LPCubicajeAFP");
        conectorActionParametro("accion", "");
        //conectorActionParametro("opcionMenu", "");
        traza("LPIniciarCubicajeAFP.ejecucion(): Salida");
    }
}
