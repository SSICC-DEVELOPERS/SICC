import es.indra.druida.belcorp.MMGDruidaBase;

/*
 * Created on 28-oct-2003
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */


/**
 * @author gogomez
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
public class MMGLPStartUp extends MMGDruidaBase {

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#inicio()
	 */
	public void inicio() throws Exception {
		pagina(MMG_INDEX_PAGE);
	}

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception {
		//Simplemente metemos en los paramtros de origen y accion
		asignar("VAR", "entity", conectorParametro("entity"));
		asignar("VAR", "action", conectorParametro("action"));
	}
}
