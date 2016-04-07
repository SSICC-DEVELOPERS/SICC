public class LPModificarParticipantes extends LPSICCBase {
    public LPModificarParticipantes() {  super(); }
         public void inicio() throws Exception {     }
  
    public void ejecucion() throws Exception {
      setTrazaFichero();
      try  {
          this.rastreo();
          traza("*********** Entre a LPModificarParticipantes");
          conectorAction("LPMantenimientoParticipantesConcursoINCDetalle");
          conectorActionParametro("opcionMenu", "modificar"); 
          conectorActionParametro("accion", ""); 
      }
           catch ( Exception e )  {
                  traza("Exception en LPModificarParticipantes");
                  e.printStackTrace();
                  lanzarPaginaError(e);
     }
  }
}
