
/*
    INDRA/CAR/mmg
    $Id: PedTipoDespaComboFormatter.java,v 1.1 2009/12/03 18:40:01 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: PedTipoDespaComboFormatter.java,v 1.1 2009/12/03 18:40:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoDespa" para Druida
 * 
 * @author Indra
 */
public class PedTipoDespaComboFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoDespaComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoDespaCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< pedTipoDespaCombo.size(); i++){
			PedTipoDespaData pedTipoDespaData = (PedTipoDespaData)pedTipoDespaCombo.get(i);
			String description = pedTipoDespaData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTipoDespaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), pedTipoDespaData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			PedTipoDespaData pedTipoDespaData = (PedTipoDespaData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoDespaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((pedTipoDespaData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTipoDespaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
