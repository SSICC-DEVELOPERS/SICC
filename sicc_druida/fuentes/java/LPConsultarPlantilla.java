public class LPConsultarPlantilla extends LPSICCBase {

    public LPConsultarPlantilla() {	super(); }

	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPConsultarPlantilla");
         conectorAction("LPMantenimientoPlantilla");
         conectorActionParametro("opcionMenu", "ConsultarPlantilla"); 
         conectorActionParametro("accion", ""); 
      } catch ( Exception e )  {
		traza("Exception en LPConsultarPlantilla");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}
