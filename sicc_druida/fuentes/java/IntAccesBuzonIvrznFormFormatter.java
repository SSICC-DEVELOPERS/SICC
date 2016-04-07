
/*
    INDRA/CAR/mmg
    $Id: IntAccesBuzonIvrznFormFormatter.java,v 1.1 2009/12/03 18:35:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "IntAccesBuzonIvrzn" para Druida
 * 
 * @author Indra
 */
public class IntAccesBuzonIvrznFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IntAccesBuzonIvrznFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector intAccesBuzonIvrznList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < intAccesBuzonIvrznList.size(); i++) {
		
			IntAccesBuzonIvrznData intAccesBuzonIvrznData = (IntAccesBuzonIvrznData) intAccesBuzonIvrznList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = intAccesBuzonIvrznData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((intAccesBuzonIvrznData.getCodAcceBuzoIvrz() != null ? 
				FormatUtils.formatObject(intAccesBuzonIvrznData.getCodAcceBuzoIvrz(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intAccesBuzonIvrznData.getZzonOidZona() != null ? intAccesBuzonIvrznData.getZzonOidZona().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(intAccesBuzonIvrznData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
