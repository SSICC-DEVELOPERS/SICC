
public class LPInicioChequearCajas extends LPSICCBase {

    public LPInicioChequearCajas()
    {  }

    public void inicio() throws Exception
    {  }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        traza("LPInicioChequearCajas.ejecucion(): Entrada");
        conectorAction("LPChequearCajas");
        conectorActionParametro("accion", "");
        traza("LPInicioChequearCajas.ejecucion(): Salida");
    }
}
