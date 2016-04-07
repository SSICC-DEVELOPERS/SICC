
/*
    INDRA/CAR/mmg
    $Id: CarParamNrComboFormatter.java,v 1.1 2009/12/03 18:40:52 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarParamNrComboFormatter.java,v 1.1 2009/12/03 18:40:52 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
*/

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

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
public class CarParamNrComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamNrComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamNrCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< carParamNrCombo.size(); i++){
			CarParamNrData carParamNrData = (CarParamNrData)carParamNrCombo.get(i);
			String description = carParamNrData.getValMaxi() != null ? 
				FormatUtils.formatObject(carParamNrData.getValMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), carParamNrData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CarParamNrData carParamNrData = (CarParamNrData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamNrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((carParamNrData.getValMaxi() != null ? 
				FormatUtils.formatObject(carParamNrData.getValMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
