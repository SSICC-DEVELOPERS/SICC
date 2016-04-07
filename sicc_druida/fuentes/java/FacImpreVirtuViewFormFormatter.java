
/*
    INDRA/CAR/mmg
    $Id: FacImpreVirtuViewFormFormatter.java,v 1.1 2009/12/03 18:35:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacImpreVirtuView" para Druida
 * 
 * @author Indra
 */
public class FacImpreVirtuViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacImpreVirtuViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facImpreVirtuViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facImpreVirtuViewList.size(); i++) {
		
			FacImpreVirtuViewData facImpreVirtuViewData = (FacImpreVirtuViewData) facImpreVirtuViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facImpreVirtuViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facImpreVirtuViewData.getCodImpr() != null ? 
				FormatUtils.formatObject(facImpreVirtuViewData.getCodImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuViewData.getDesImpr() != null ? 
				FormatUtils.formatObject(facImpreVirtuViewData.getDesImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facImpreVirtuViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
