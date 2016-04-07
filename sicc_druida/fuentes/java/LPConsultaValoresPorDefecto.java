public class LPConsultaValoresPorDefecto extends LPSICCBase {

	public LPConsultaValoresPorDefecto() { super();	}

  public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {  
		setTrazaFichero();
		try  {
			this.rastreo();
		  traza("*********** Entre a LPConsultaValoresPorDefecto");      
			conectorAction("LPMantieneValoresPorDefecto");
			conectorActionParametro("accion", "muestraConsulta");
		}
		catch ( Exception e )  {
			e.printStackTrace();     
			lanzarPaginaError(e);
		}
	}
}
