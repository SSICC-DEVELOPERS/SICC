
/*
    INDRA/CAR/mmg
    $Id: ZonRegioComboFormatter.java,v 1.1 2009/12/03 18:35:40 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: ZonRegioComboFormatter.java,v 1.1 2009/12/03 18:35:40 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
*/

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import es.indra.belcorp.mso.*;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "ZonRegio" para Druida
 * 
 * @author Indra
 */
public class ZonRegioComboFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonRegioComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonRegioCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		TreeMap orderBy = new TreeMap();
		for(int i=0; i< zonRegioCombo.size(); i++){
			ZonRegioData zonRegioData = (ZonRegioData)zonRegioCombo.get(i);
			String description = zonRegioData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonRegioData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), zonRegioData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			ZonRegioData zonRegioData = (ZonRegioData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonRegioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((zonRegioData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonRegioData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
