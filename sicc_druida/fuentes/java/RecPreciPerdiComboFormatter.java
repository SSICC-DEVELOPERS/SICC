
/*
    INDRA/CAR/mmg
    $Id: RecPreciPerdiComboFormatter.java,v 1.1 2009/12/03 18:36:15 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: RecPreciPerdiComboFormatter.java,v 1.1 2009/12/03 18:36:15 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecPreciPerdi" para Druida
 * 
 * @author Indra
 */
public class RecPreciPerdiComboFormatter extends MMGDruidaFormatoObjeto {
	
	public RecPreciPerdiComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recPreciPerdiCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< recPreciPerdiCombo.size(); i++){
			RecPreciPerdiData recPreciPerdiData = (RecPreciPerdiData)recPreciPerdiCombo.get(i);
			String description = recPreciPerdiData.getCodPrecPerd() != null ? 
				FormatUtils.formatObject(recPreciPerdiData.getCodPrecPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), recPreciPerdiData);
		}

		//Construimos cada fila con los valores de la clave y la descripci�n del elemento que se mostrar� en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			RecPreciPerdiData recPreciPerdiData = (RecPreciPerdiData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = recPreciPerdiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el atributo choice
			row.add((recPreciPerdiData.getCodPrecPerd() != null ? 
				FormatUtils.formatObject(recPreciPerdiData.getCodPrecPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
