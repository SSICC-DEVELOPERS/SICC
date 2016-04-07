public class LPEliminarParticipantes extends LPSICCBase {
    public LPEliminarParticipantes() {	super(); }
	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPEliminarParticipantes");
         conectorAction("LPMantenimientoParticipantesConcursoINCDetalle");
         conectorActionParametro("opcionMenu", "eliminar"); 
         conectorActionParametro("accion", ""); 
      }
	  catch ( Exception e )  {
		traza("Exception en LPEliminarParticipantes");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}