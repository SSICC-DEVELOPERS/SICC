import LPSICCBase;


public class LPEliminarMatricesCodigosReemplazo extends LPSICCBase
{

   private String accion = "";
   
   public void inicio() throws Exception{
  }

  public LPEliminarMatricesCodigosReemplazo(){
  }

  public void ejecucion() throws Exception
  {
      if(accion.equals(""))
      {
		  conectorParametroSesion("casodeuso", "eliminar");

		  conectorAction("LPBuscarMatrizCodigosReemplazo");
          conectorActionParametro("accion", "");
      }
  }
}
