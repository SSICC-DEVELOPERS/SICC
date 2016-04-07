
import es.indra.druida.belcorp.MMGDruidaBase;

/*
 * Created on 23-mar-2004
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
public class MMGLPErrorDialogTrigger extends MMGDruidaBase{

	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#inicio()
	 */
	public void inicio() throws Exception {
		pagina(MMG_ERROR_DIALOG_TRIGGER_PAGE);
	}
	
	/* (non-Javadoc)
	 * @see es.indra.druida.base.ObjetoNegocio#ejecucion()
	 */
	public void ejecucion() throws Exception {
		//Sacamos la info del error de la request y lo metemos en la pantalla
		asignar("VAR", ERROR_DIALOG_TRIGGER_CODE, conectorParametro(ERROR_DIALOG_TRIGGER_CODE));
		asignar("VAR", ERROR_DIALOG_TRIGGER_DESCRIPTION, conectorParametro(ERROR_DIALOG_TRIGGER_DESCRIPTION));
		asignar("VAR", ERROR_DIALOG_TRIGGER_SEVERITY, conectorParametro(ERROR_DIALOG_TRIGGER_SEVERITY));
	}

}
