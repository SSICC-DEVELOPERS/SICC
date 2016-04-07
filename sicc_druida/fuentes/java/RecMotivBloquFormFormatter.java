
/*
    INDRA/CAR/mmg
    $Id: RecMotivBloquFormFormatter.java,v 1.1 2009/12/03 18:32:23 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecMotivBloqu" para Druida
 * 
 * @author Indra
 */
public class RecMotivBloquFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecMotivBloquFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recMotivBloquList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recMotivBloquList.size(); i++) {
		
			RecMotivBloquData recMotivBloquData = (RecMotivBloquData) recMotivBloquList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recMotivBloquData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recMotivBloquData.getValMotiBloq() != null ? 
				FormatUtils.formatObject(recMotivBloquData.getValMotiBloq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recMotivBloquData.getPaisOidPais() != null ? recMotivBloquData.getPaisOidPais().getId() : null));
			row.add((recMotivBloquData.getDescripcion() != null ? 
				FormatUtils.formatObject(recMotivBloquData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recMotivBloquData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
