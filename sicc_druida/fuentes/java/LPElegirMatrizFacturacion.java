public class LPElegirMatrizFacturacion extends LPSICCBase {
    public LPElegirMatrizFacturacion() {
        super();
    }
    public void inicio() throws Exception {
    }
    public void ejecucion() throws Exception {
        setTrazaFichero();
        try  {
            conectorAction("LPSeleccionarMF");
            conectorActionParametro("accion", "ElegirMatriz");
            conectorActionParametro("nueva", "false");
        }
        catch ( Exception e )  {
            e.printStackTrace();     
            lanzarPaginaError(e);
        }
    }
}
