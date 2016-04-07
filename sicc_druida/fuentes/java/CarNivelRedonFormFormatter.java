
/*
    INDRA/CAR/mmg
    $Id: CarNivelRedonFormFormatter.java,v 1.1 2009/12/03 18:40:33 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarNivelRedon" para Druida
 * 
 * @author Indra
 */
public class CarNivelRedonFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarNivelRedonFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carNivelRedonList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carNivelRedonList.size(); i++) {
		
			CarNivelRedonData carNivelRedonData = (CarNivelRedonData) carNivelRedonList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carNivelRedonData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carNivelRedonData.getDescripcion() != null ? 
				FormatUtils.formatObject(carNivelRedonData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carNivelRedonData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
