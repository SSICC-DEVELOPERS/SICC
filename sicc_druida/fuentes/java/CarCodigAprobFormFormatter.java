
/*
    INDRA/CAR/mmg
    $Id: CarCodigAprobFormFormatter.java,v 1.1 2009/12/03 18:34:48 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarCodigAprob" para Druida
 * 
 * @author Indra
 */
public class CarCodigAprobFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarCodigAprobFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carCodigAprobList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carCodigAprobList.size(); i++) {
		
			CarCodigAprobData carCodigAprobData = (CarCodigAprobData) carCodigAprobList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = carCodigAprobData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((carCodigAprobData.getCodApro() != null ? 
				FormatUtils.formatObject(carCodigAprobData.getCodApro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carCodigAprobData.getDescripcion() != null ? 
				FormatUtils.formatObject(carCodigAprobData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carCodigAprobData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
