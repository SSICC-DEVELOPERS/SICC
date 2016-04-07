public class LPConsultarParticipantes extends LPSICCBase {
    public LPConsultarParticipantes() {	super(); }
	public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
         this.rastreo();
         traza("*********** Entre a LPConsultarParticipantes");
         conectorAction("LPMantenimientoParticipantesConcursoINCDetalle");
         conectorActionParametro("opcionMenu", "consultar"); 
         conectorActionParametro("accion", ""); 
      }
	  catch ( Exception e )  {
		traza("Exception en LPConsultarParticipantes");
		e.printStackTrace();     
		lanzarPaginaError(e);
     }
  }
}