
/*
    INDRA/CAR/mmg
    $Id: CobMetodLiquiFormFormatter.java,v 1.1 2009/12/03 18:39:15 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobMetodLiqui" para Druida
 * 
 * @author Indra
 */
public class CobMetodLiquiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobMetodLiquiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobMetodLiquiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobMetodLiquiList.size(); i++) {
		
			CobMetodLiquiData cobMetodLiquiData = (CobMetodLiquiData) cobMetodLiquiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobMetodLiquiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobMetodLiquiData.getCodMetoLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiData.getCodMetoLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiData.getValDescMetoLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiData.getValDescMetoLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiData.getIndLiqu() != null ? 
				FormatUtils.formatObject(cobMetodLiquiData.getIndLiqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiData.getIndLiquGrupUsua() != null ? 
				FormatUtils.formatObject(cobMetodLiquiData.getIndLiquGrupUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiData.getValObse() != null ? 
				FormatUtils.formatObject(cobMetodLiquiData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMetodLiquiData.getPaisOidPais() != null ? cobMetodLiquiData.getPaisOidPais().getId() : null));
			row.add((cobMetodLiquiData.getBaesOidBaseEsca() != null ? cobMetodLiquiData.getBaesOidBaseEsca().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobMetodLiquiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
