import LPSICCBase;

public class LPBusquedaEliminarImpuestos extends LPSICCBase{
   public LPBusquedaEliminarImpuestos() {super();}
         
   public void inicio() throws Exception {}

   public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
        rastreo();
        traza("caso de uso = eliminar");
        conectorAction("LPBusquedaImpuestos");
        conectorActionParametro("hidCasodeUso", "eliminar");
      } catch ( Exception e )  {
         e.printStackTrace();     
         lanzarPaginaError(e);
      }	
   }
}

