import LPSICCBase;


public class LPEliminarMatricesCodigosRecuperacion extends LPSICCBase
{

   private String accion = "";
   
   public void inicio() throws Exception{
  }

  public LPEliminarMatricesCodigosRecuperacion(){
  }

  public void ejecucion() throws Exception
  {
	  rastreo();
      if(accion.equals(""))
      {
		  conectorParametroSesion("casodeuso", "eliminar");

		  conectorAction("LPBuscarMatrizCodigosRecuperacion");
          conectorActionParametro("accion", "");
      }
  }
}