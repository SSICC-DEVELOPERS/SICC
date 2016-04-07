import LPSICCBase;

public class LPBusquedaConsultarImpuestos extends LPSICCBase{
   public LPBusquedaConsultarImpuestos() {super();}
         
   public void inicio() throws Exception {}

   public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
        rastreo();
        traza("caso de uso = consultar");
        conectorAction("LPBusquedaImpuestos");
        conectorActionParametro("hidCasodeUso", "consultar");
      } catch ( Exception e )  {
         e.printStackTrace();     
         lanzarPaginaError(e);
      }	
   }
}

