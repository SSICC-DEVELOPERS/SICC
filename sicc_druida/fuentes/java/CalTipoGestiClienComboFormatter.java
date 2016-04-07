
/*
    INDRA/CAR/mmg
    $Id: CalTipoGestiClienComboFormatter.java,v 1.1 2009/12/03 18:43:08 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CalTipoGestiClienComboFormatter.java,v 1.1 2009/12/03 18:43:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalTipoGestiClien" para Druida
 * 
 * @author Indra
 */
public class CalTipoGestiClienComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CalTipoGestiClienComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calTipoGestiClienCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< calTipoGestiClienCombo.size(); i++){
			CalTipoGestiClienData calTipoGestiClienData = (CalTipoGestiClienData)calTipoGestiClienCombo.get(i);
			String description = calTipoGestiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(calTipoGestiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), calTipoGestiClienData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CalTipoGestiClienData calTipoGestiClienData = (CalTipoGestiClienData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calTipoGestiClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((calTipoGestiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(calTipoGestiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
