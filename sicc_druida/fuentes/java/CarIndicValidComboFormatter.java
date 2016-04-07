
/*
    INDRA/CAR/mmg
    $Id: CarIndicValidComboFormatter.java,v 1.1 2009/12/03 18:33:10 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarIndicValidComboFormatter.java,v 1.1 2009/12/03 18:33:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarIndicValid" para Druida
 * 
 * @author Indra
 */
public class CarIndicValidComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarIndicValidComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carIndicValidCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carIndicValidCombo.size(); i++) {
		
			CarIndicValidData carIndicValidData = (CarIndicValidData) carIndicValidCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carIndicValidData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((carIndicValidData.getCodIndiVali() != null ? 
				FormatUtils.formatObject(carIndicValidData.getCodIndiVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
