public class LPEliminarPlantilla extends LPSICCBase {

    public LPEliminarPlantilla() {	super(); }

	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPEliminarPlantilla");
         conectorAction("LPMantenimientoPlantilla");
         conectorActionParametro("opcionMenu", "EliminarPlantilla"); 
         conectorActionParametro("accion", ""); 
      } catch ( Exception e )  {
		traza("Exception en LPEliminarPlantilla");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}