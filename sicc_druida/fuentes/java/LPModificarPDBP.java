import es.indra.sicc.util.UtilidadesLog;

public class LPModificarPDBP extends LPSICCBase  {
    public LPModificarPDBP() {
        super();    
    }

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception {
        try {
            conectorAction("LPMantenimientoPDBP");
            conectorActionParametro("casoDeUso","modificar");
            conectorActionParametro("accion","");
        } catch (Throwable th) {
            UtilidadesLog.error("ERROR al redireccionar a LPMantenimientoPDBP",th);
        }
    }
}
