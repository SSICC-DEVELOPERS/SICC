public class LPModificarPlantilla extends LPSICCBase {

    public LPModificarPlantilla() {	super(); }

	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPModificarPlantilla");
         conectorAction("LPMantenimientoPlantilla");
         conectorActionParametro("opcionMenu", "ModificarPlantilla"); 
         conectorActionParametro("accion", ""); 
      } catch ( Exception e )  {
		traza("Exception en LPModificarPlantilla");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}
