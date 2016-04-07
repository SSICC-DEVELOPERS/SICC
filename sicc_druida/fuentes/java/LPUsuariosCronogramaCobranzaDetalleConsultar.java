
public class LPUsuariosCronogramaCobranzaDetalleConsultar extends LPSICCBase {

   public LPUsuariosCronogramaCobranzaDetalleConsultar() {
	  super();
   }

   public void inicio() throws Exception {
	 
   }

  public void ejecucion() throws Exception {
    setTrazaFichero();

    try {
      rastreo();    
      conectorAction("LPUsuariosCronogramaCobranzaDetalleMantenimiento");
      conectorActionParametro("accion", "consultar");
    }
    catch ( Exception e ) {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}

