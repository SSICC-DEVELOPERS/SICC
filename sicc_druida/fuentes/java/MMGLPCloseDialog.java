/*
	INDRA/CAR/PROY
	$Id: MMGLPCloseDialog.java,v 1.1 2009/12/03 18:40:25 pecbazalar Exp $
	DESC

	DRUIDATARGET=/install/cvsiniciales
*/

import es.indra.druida.belcorp.MMGDruidaBase;

/*
 * Created on 22-mar-2004
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
public class MMGLPCloseDialog extends MMGDruidaBase {

	public static final String MMG_CLOSE_DIALOG_PAGE = "MMGCloseDialog";

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#inicio()
	 */
	public void inicio() throws Exception {
		pagina(MMG_CLOSE_DIALOG_PAGE);
	}
}
