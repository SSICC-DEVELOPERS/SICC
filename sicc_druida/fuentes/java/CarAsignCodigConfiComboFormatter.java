
/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiComboFormatter.java,v 1.1 2009/12/03 18:40:09 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiComboFormatter.java,v 1.1 2009/12/03 18:40:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarAsignCodigConfi" para Druida
 * 
 * @author Indra
 */
public class CarAsignCodigConfiComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarAsignCodigConfiComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carAsignCodigConfiCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carAsignCodigConfiCombo.size(); i++) {
		
			CarAsignCodigConfiData carAsignCodigConfiData = (CarAsignCodigConfiData) carAsignCodigConfiCombo.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = carAsignCodigConfiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el atributo choice
			row.add((carAsignCodigConfiData.getValLineCredInic() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getValLineCredInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
