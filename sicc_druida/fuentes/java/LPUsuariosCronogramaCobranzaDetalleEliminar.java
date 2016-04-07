
public class LPUsuariosCronogramaCobranzaDetalleEliminar extends LPSICCBase {

   public LPUsuariosCronogramaCobranzaDetalleEliminar() {
	  super();
   }

   public void inicio() throws Exception {
	 
   }

  public void ejecucion() throws Exception {
    setTrazaFichero();

    try {
      rastreo();    
      conectorAction("LPUsuariosCronogramaCobranzaDetalleMantenimiento");
      conectorActionParametro("accion", "eliminar");
    }
    catch ( Exception e ) {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }
}

