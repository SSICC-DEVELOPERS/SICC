
/*
    INDRA/CAR/mmg
    $Id: MaeMagniComboFormatter.java,v 1.1 2009/12/03 18:41:41 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: MaeMagniComboFormatter.java,v 1.1 2009/12/03 18:41:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeMagni" para Druida
 * 
 * @author Indra
 */
public class MaeMagniComboFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeMagniComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeMagniCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< maeMagniCombo.size(); i++){
			MaeMagniData maeMagniData = (MaeMagniData)maeMagniCombo.get(i);
			String description = maeMagniData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeMagniData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), maeMagniData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			MaeMagniData maeMagniData = (MaeMagniData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeMagniData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((maeMagniData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeMagniData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
