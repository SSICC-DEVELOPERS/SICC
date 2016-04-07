import LPSICCBase;

public class LPBusquedaModificarImpuestos extends LPSICCBase{
   public LPBusquedaModificarImpuestos() {super();}
         
   public void inicio() throws Exception {}

   public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
        rastreo();
        traza("caso de uso = modificar");
        conectorAction("LPBusquedaImpuestos");
        conectorActionParametro("hidCasodeUso", "modificar");
      } catch ( Exception e )  {
         e.printStackTrace();     
         lanzarPaginaError(e);
      }	
   }
}

