
public class LPUsuariosCronogramaCobranzaDetalleModificar extends LPSICCBase {

   public LPUsuariosCronogramaCobranzaDetalleModificar() {
	  super();
   }

   public void inicio() throws Exception {
	 
   }

  public void ejecucion() throws Exception {
    setTrazaFichero();

    try {
      rastreo();    
      conectorAction("LPUsuariosCronogramaCobranzaDetalleMantenimiento");
      conectorActionParametro("accion", "modificar");
    }
    catch ( Exception e ) {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}

