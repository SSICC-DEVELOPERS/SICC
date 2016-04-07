
/*
    INDRA/CAR/mmg
    $Id: IntAccesBuzonIvrrgFormFormatter.java,v 1.1 2009/12/03 18:32:34 pecbazalar Exp $
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
 * Clase de formateo de objetos "IntAccesBuzonIvrrg" para Druida
 * 
 * @author Indra
 */
public class IntAccesBuzonIvrrgFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IntAccesBuzonIvrrgFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector intAccesBuzonIvrrgList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < intAccesBuzonIvrrgList.size(); i++) {
		
			IntAccesBuzonIvrrgData intAccesBuzonIvrrgData = (IntAccesBuzonIvrrgData) intAccesBuzonIvrrgList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = intAccesBuzonIvrrgData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((intAccesBuzonIvrrgData.getCodAcceBuzoIvrr() != null ? 
				FormatUtils.formatObject(intAccesBuzonIvrrgData.getCodAcceBuzoIvrr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intAccesBuzonIvrrgData.getZorgOidRegi() != null ? intAccesBuzonIvrrgData.getZorgOidRegi().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(intAccesBuzonIvrrgData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
