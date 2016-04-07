public class LPInsertarParticipantes extends LPSICCBase {
    public LPInsertarParticipantes() {	super(); }
	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPInsertarParticipantes");
         conectorAction("LPMantenimientoParticipantesConcursoINCDetalle");
         conectorActionParametro("opcionMenu", "insertar"); 
         conectorActionParametro("accion", ""); 
      }
	  catch ( Exception e )  {
		traza("Exception en LPInsertarParticipantes");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}