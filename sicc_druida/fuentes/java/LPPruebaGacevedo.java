import es.indra.druida.DruidaConector;

public class LPPruebaGacevedo extends LPSICCBase {
  public void ejecucion() throws Exception {
			pagina("prueba");
			getFormatosValidaciones();
  }
  public void inicio() throws Exception {
	 setTrazaFichero();
  }
}
