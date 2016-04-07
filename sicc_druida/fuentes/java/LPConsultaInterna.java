public class LPConsultaInterna extends LPSICCBase {

    public LPConsultaInterna(){
        super();
    }
    
    public void inicio() throws Exception {
        ;
    }
    
    public void ejecucion() throws Exception {
        conectorAction("LPRecepcionLlamadas");
        conectorActionParametro("accion","Buscar");
        conectorActionParametro("casoDeUso","Presentar");
    }
}