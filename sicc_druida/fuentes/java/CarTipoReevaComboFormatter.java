
/*
    INDRA/CAR/mmg
    $Id: CarTipoReevaComboFormatter.java,v 1.1 2009/12/03 18:34:58 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarTipoReevaComboFormatter.java,v 1.1 2009/12/03 18:34:58 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarTipoReeva" para Druida
 * 
 * @author Indra
 */
public class CarTipoReevaComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarTipoReevaComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carTipoReevaCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carTipoReevaCombo.size(); i++) {
		
			CarTipoReevaData carTipoReevaData = (CarTipoReevaData) carTipoReevaCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carTipoReevaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((carTipoReevaData.getId() != null ? 
				FormatUtils.formatObject(carTipoReevaData.getId(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
