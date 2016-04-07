
/*
    INDRA/CAR/mmg
    $Id: CarParamNrFormFormatter.java,v 1.1 2009/12/03 18:35:13 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamNr" para Druida
 * 
 * @author Indra
 */
public class CarParamNrFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamNrFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamNrList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carParamNrList.size(); i++) {
		
			CarParamNrData carParamNrData = (CarParamNrData) carParamNrList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamNrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamNrData.getNiriOidNiveRies() != null ? carParamNrData.getNiriOidNiveRies().getId() : null));
			row.add((carParamNrData.getValMini() != null ? 
				FormatUtils.formatObject(carParamNrData.getValMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamNrData.getValMaxi() != null ? 
				FormatUtils.formatObject(carParamNrData.getValMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carParamNrData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
