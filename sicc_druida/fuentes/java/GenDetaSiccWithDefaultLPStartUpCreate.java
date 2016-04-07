/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccWithDefaultLPStartUpCreate.java,v 1.1 2009/12/03 18:32:56 pecbazalar Exp $
    DESC
*/

import es.indra.druida.belcorp.MMGDruidaBase;

// Definicion de la clase
public class GenDetaSiccWithDefaultLPStartUpCreate extends MMGDruidaBase{
	public void inicio() throws Exception {
		//No tiene asociado xml ya que simpelmente redirecciona
	}

	public void ejecucion() throws Exception {
		conectorAction("GenDetaSiccWithDefaultLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, "create");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro("idFuncion", 
			conectorParametro("idFuncion") == null?"": conectorParametro("idFuncion"));
		conectorActionParametro(PARAMETRO_MENU_FROM_MENU, 
			conectorParametro(PARAMETRO_MENU_FROM_MENU) == null?"": conectorParametro(PARAMETRO_MENU_FROM_MENU));
		conectorActionParametro(PARAMETRO_MENU_CDOS_IDIOMA, 
			conectorParametro(PARAMETRO_MENU_CDOS_IDIOMA) == null? "": conectorParametro(PARAMETRO_MENU_CDOS_IDIOMA));
		rastreo();
	}
}

