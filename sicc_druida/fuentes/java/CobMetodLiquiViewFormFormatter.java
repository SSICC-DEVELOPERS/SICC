
/*
    INDRA/CAR/mmg
    $Id: CobMetodLiquiViewFormFormatter.java,v 1.1 2009/12/03 18:35:32 pecbazalar Exp $
    DESC
*/


import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;

import es.indra.belcorp.mso.*;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "CobMetodLiquiView" para Druida
 * 
 * @author Indra
 */
public class CobMetodLiquiViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobMetodLiquiViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobMetodLiquiViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobMetodLiquiViewList.size(); i++) {
		
			CobMetodLiquiViewData cobMetodLiquiViewData = (CobMetodLiquiViewData) cobMetodLiquiViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobMetodLiquiViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobMetodLiquiViewData.getCodMetoLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiViewData.getCodMetoLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiViewData.getValDescMetoLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiViewData.getValDescMetoLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiViewData.getIndLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiViewData.getIndLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiViewData.getIndLiquGrupUsua() != null ? 
				FormatUtils.formatObject(cobMetodLiquiViewData.getIndLiquGrupUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiViewData.getBaesOidBaseEsca() != null ? cobMetodLiquiViewData.getBaesOidBaseEsca().getId() : null));
			row.add((cobMetodLiquiViewData.getPaisOidPais() != null ? cobMetodLiquiViewData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobMetodLiquiViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
