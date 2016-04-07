
/*
    INDRA/CAR/mmg
    $Id: ZonZonaComboFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: ZonZonaComboFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonZona" para Druida
 * 
 * @author Indra
 */
public class ZonZonaComboFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonZonaComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonZonaCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		TreeMap orderBy = new TreeMap();
		for(int i=0; i< zonZonaCombo.size(); i++){
			ZonZonaData zonZonaData = (ZonZonaData)zonZonaCombo.get(i);
			String description = zonZonaData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonZonaData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), zonZonaData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			ZonZonaData zonZonaData = (ZonZonaData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonZonaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((zonZonaData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonZonaData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
