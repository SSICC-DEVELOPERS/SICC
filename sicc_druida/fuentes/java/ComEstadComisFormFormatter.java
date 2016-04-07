
/*
    INDRA/CAR/mmg
    $Id: ComEstadComisFormFormatter.java,v 1.1 2009/12/03 18:36:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "ComEstadComis" para Druida
 * 
 * @author Indra
 */
public class ComEstadComisFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ComEstadComisFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector comEstadComisList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < comEstadComisList.size(); i++) {
		
			ComEstadComisData comEstadComisData = (ComEstadComisData) comEstadComisList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = comEstadComisData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((comEstadComisData.getCodEstaComi() != null ? 
				FormatUtils.formatObject(comEstadComisData.getCodEstaComi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comEstadComisData.getDescripcion() != null ? 
				FormatUtils.formatObject(comEstadComisData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(comEstadComisData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
