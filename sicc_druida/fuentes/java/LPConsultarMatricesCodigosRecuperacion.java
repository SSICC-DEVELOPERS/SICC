import LPSICCBase;


public class LPConsultarMatricesCodigosRecuperacion extends LPSICCBase
{

   private String accion = "";
   
   public void inicio() throws Exception{
  }

  public LPConsultarMatricesCodigosRecuperacion(){
  }

	public void ejecucion() throws Exception {
		rastreo();
		if(accion.equals("")) {
			conectorParametroSesion("casodeuso", "consultar");

			conectorAction("LPBuscarMatrizCodigosRecuperacion");     
			conectorActionParametro("accion", "");
		}
	}
}