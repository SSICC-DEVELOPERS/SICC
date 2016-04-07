
/*
    INDRA/CAR/mmg
    $Id: RecPreciPerdiFormFormatter.java,v 1.1 2009/12/03 18:41:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecPreciPerdi" para Druida
 * 
 * @author Indra
 */
public class RecPreciPerdiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecPreciPerdiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recPreciPerdiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recPreciPerdiList.size(); i++) {
		
			RecPreciPerdiData recPreciPerdiData = (RecPreciPerdiData) recPreciPerdiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recPreciPerdiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recPreciPerdiData.getCodPrecPerd() != null ? 
				FormatUtils.formatObject(recPreciPerdiData.getCodPrecPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recPreciPerdiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
