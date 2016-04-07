import LPSICCBase;


public class LPConsultarMatricesCodigosReemplazo extends LPSICCBase{

  private String accion = "";
   
  public void inicio() throws Exception{
  }

  public LPConsultarMatricesCodigosReemplazo(){
  }

  public void ejecucion() throws Exception{
    if(accion.equals("")){
      conectorParametroSesion("casodeuso", "consultar");

      conectorAction("LPBuscarMatrizCodigosReemplazo");     
      conectorActionParametro("accion", "");
    }
  }
}
