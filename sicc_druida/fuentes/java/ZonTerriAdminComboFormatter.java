
/*
    INDRA/CAR/mmg
    $Id: ZonTerriAdminComboFormatter.java,v 1.1 2009/12/03 18:38:51 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: ZonTerriAdminComboFormatter.java,v 1.1 2009/12/03 18:38:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonTerriAdmin" para Druida
 * 
 * @author Indra
 */
public class ZonTerriAdminComboFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonTerriAdminComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonTerriAdminCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		TreeMap orderBy = new TreeMap();
		for(int i=0; i< zonTerriAdminCombo.size(); i++){
			ZonTerriAdminData zonTerriAdminData = (ZonTerriAdminData)zonTerriAdminCombo.get(i);
			String description = zonTerriAdminData.getFecRtz() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getFecRtz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), zonTerriAdminData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			ZonTerriAdminData zonTerriAdminData = (ZonTerriAdminData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonTerriAdminData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((zonTerriAdminData.getFecRtz() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getFecRtz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
