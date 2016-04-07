
/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaComboFormatter.java,v 1.1 2009/12/03 18:39:04 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaComboFormatter.java,v 1.1 2009/12/03 18:39:04 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccMovimBanca" para Druida
 * 
 * @author Indra
 */
public class CccMovimBancaComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CccMovimBancaComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccMovimBancaCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccMovimBancaCombo.size(); i++) {
		
			CccMovimBancaData cccMovimBancaData = (CccMovimBancaData) cccMovimBancaCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccMovimBancaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((cccMovimBancaData.getFecMoviApli() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getFecMoviApli(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
