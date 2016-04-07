
public class LPUsuariosCronogramaCobranzaDetalleInsertar extends LPSICCBase {

   public LPUsuariosCronogramaCobranzaDetalleInsertar() {
	  super();
   }

   public void inicio() throws Exception {
	 
   }

  public void ejecucion() throws Exception {
    setTrazaFichero();

    try {
      rastreo();    
      conectorAction("LPUsuariosCronogramaCobranzaDetalleMantenimiento");
      conectorActionParametro("accion", "insertar");
    }
    catch ( Exception e ) {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}

