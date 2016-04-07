
public class LPCalcularMetas extends LPSICCBase {
    
    public LPCalcularMetas() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {    
          setTrazaFichero();
          try  {
            rastreo();
            conectorAction("LPMantenimientoComisiones");
            conectorActionParametro("accion", "CargaCalcularMetas");
        }catch(Exception e){
            e.printStackTrace();
            lanzarPaginaError(e);
        }
    }
    
}
