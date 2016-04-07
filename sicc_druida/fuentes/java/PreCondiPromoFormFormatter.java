
/*
    INDRA/CAR/mmg
    $Id: PreCondiPromoFormFormatter.java,v 1.1 2009/12/03 18:37:03 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreCondiPromo" para Druida
 * 
 * @author Indra
 */
public class PreCondiPromoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreCondiPromoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preCondiPromoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preCondiPromoList.size(); i++) {
		
			PreCondiPromoData preCondiPromoData = (PreCondiPromoData) preCondiPromoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preCondiPromoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preCondiPromoData.getCodCondProm() != null ? 
				FormatUtils.formatObject(preCondiPromoData.getCodCondProm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preCondiPromoData.getDescripcion() != null ? 
				FormatUtils.formatObject(preCondiPromoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preCondiPromoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
