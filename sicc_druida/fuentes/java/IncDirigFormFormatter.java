
/*
    INDRA/CAR/mmg
    $Id: IncDirigFormFormatter.java,v 1.1 2009/12/03 18:42:12 pecbazalar Exp $
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
 * Clase de formateo de objetos "IncDirig" para Druida
 * 
 * @author Indra
 */
public class IncDirigFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IncDirigFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector incDirigList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < incDirigList.size(); i++) {
		
			IncDirigData incDirigData = (IncDirigData) incDirigList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = incDirigData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((incDirigData.getDescripcion() != null ? 
				FormatUtils.formatObject(incDirigData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(incDirigData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
