public class LPInsertarPlantilla extends LPSICCBase {

    public LPInsertarPlantilla() {	super(); }

	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
	  traza("111");
      try  {
         this.rastreo();
         traza("*********** Entre a LPInsertarPlantilla");
         conectorAction("LPMantenimientoPlantilla");
         conectorActionParametro("opcionMenu", "InsertarPlantilla"); 
         conectorActionParametro("accion", ""); 
      } catch ( Exception e )  {
		traza("Exception en LPInsertarPlantilla");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}
