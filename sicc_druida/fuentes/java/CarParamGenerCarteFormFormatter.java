
/*
    INDRA/CAR/mmg
    $Id: CarParamGenerCarteFormFormatter.java,v 1.1 2009/12/03 18:34:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamGenerCarte" para Druida
 * 
 * @author Indra
 */
public class CarParamGenerCarteFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamGenerCarteFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamGenerCarteList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carParamGenerCarteList.size(); i++) {
		
			CarParamGenerCarteData carParamGenerCarteData = (CarParamGenerCarteData) carParamGenerCarteList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamGenerCarteData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamGenerCarteData.getPaisOidPais() != null ? carParamGenerCarteData.getPaisOidPais().getId() : null));
			row.add((carParamGenerCarteData.getNireOidNiveRedo() != null ? carParamGenerCarteData.getNireOidNiveRedo().getId() : null));
			row.add((carParamGenerCarteData.getNumPeriNuev() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getNumPeriNuev(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamGenerCarteData.getNumPeriAnti() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getNumPeriAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamGenerCarteData.getInijOidIndiNiveJera() != null ? carParamGenerCarteData.getInijOidIndiNiveJera().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carParamGenerCarteData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
