/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaLPStartUpQuery.java,v 1.1 2009/12/03 18:38:12 pecbazalar Exp $
    DESC
*/

import es.indra.druida.belcorp.MMGDruidaBase;

// Definicion de la clase
public class CccMovimBancaLPStartUpQuery extends MMGDruidaBase{
	public void inicio() throws Exception {
		//No tiene asociado xml ya que simpelmente redirecciona
	}

	public void ejecucion() throws Exception {
		conectorAction("CccMovimBancaLPStartUp");
		conectorActionParametro(PARAMETRO_GENERICO_ACCION, "query");
		conectorActionParametro(PARAMETRO_GENERICO_ORIGEN, "menu");
		conectorActionParametro("idFuncion", 
			conectorParametro("idFuncion") == null?"": conectorParametro("idFuncion"));
		conectorActionParametro(PARAMETRO_MENU_FROM_MENU, 
			conectorParametro(PARAMETRO_MENU_FROM_MENU) == null?"": conectorParametro(PARAMETRO_MENU_FROM_MENU));
		conectorActionParametro(PARAMETRO_MENU_CDOS_IDIOMA, 
			conectorParametro(PARAMETRO_MENU_CDOS_IDIOMA) == null? "": conectorParametro(PARAMETRO_MENU_CDOS_IDIOMA));
	}
}

