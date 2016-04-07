
/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentComboFormatter.java,v 1.1 2009/12/03 18:38:50 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentComboFormatter.java,v 1.1 2009/12/03 18:38:50 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
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
 * Clase de formateo de objetos "CarEjecuCuent" para Druida
 * 
 * @author Indra
 */
public class CarEjecuCuentComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarEjecuCuentComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carEjecuCuentCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carEjecuCuentCombo.size(); i++) {
		
			CarEjecuCuentData carEjecuCuentData = (CarEjecuCuentData) carEjecuCuentCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carEjecuCuentData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((carEjecuCuentData.getJeraOidJera() != null ? 
				FormatUtils.formatObject(carEjecuCuentData.getJeraOidJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
