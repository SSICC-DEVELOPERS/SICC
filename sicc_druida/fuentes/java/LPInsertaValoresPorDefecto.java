public class LPInsertaValoresPorDefecto extends LPSICCBase {

  public LPInsertaValoresPorDefecto() { super();	}

  public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {  
		setTrazaFichero();    
		try  {
      this.rastreo();
		  traza("*********** Entre a LPInsertaValoresPorDefecto");      
			conectorAction("LPMantieneValoresPorDefecto");
			conectorActionParametro("accion", "muestraInsercion");
			conectorActionParametro("opcionMenu", "insertar");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
