
/*
    INDRA/CAR/mmg
    $Id: CarIndicValidFormFormatter.java,v 1.1 2009/12/03 18:41:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarIndicValid" para Druida
 * 
 * @author Indra
 */
public class CarIndicValidFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarIndicValidFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carIndicValidList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carIndicValidList.size(); i++) {
		
			CarIndicValidData carIndicValidData = (CarIndicValidData) carIndicValidList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = carIndicValidData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((carIndicValidData.getCodIndiVali() != null ? 
				FormatUtils.formatObject(carIndicValidData.getCodIndiVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carIndicValidData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
