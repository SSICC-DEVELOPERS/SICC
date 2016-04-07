
/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentFormFormatter.java,v 1.1 2009/12/03 18:38:43 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarEjecuCuent" para Druida
 * 
 * @author Indra
 */
public class CarEjecuCuentFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarEjecuCuentFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carEjecuCuentList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carEjecuCuentList.size(); i++) {
		
			CarEjecuCuentData carEjecuCuentData = (CarEjecuCuentData) carEjecuCuentList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = carEjecuCuentData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((carEjecuCuentData.getPaisOidPais() != null ? carEjecuCuentData.getPaisOidPais().getId() : null));
			row.add((carEjecuCuentData.getCodEjecCuen() != null ? 
				FormatUtils.formatObject(carEjecuCuentData.getCodEjecCuen(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carEjecuCuentData.getJeraOidJera() != null ? carEjecuCuentData.getJeraOidJera().getId() : null));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carEjecuCuentData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
