
/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaViewComboFormatter.java,v 1.1 2009/12/03 18:33:57 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaViewComboFormatter.java,v 1.1 2009/12/03 18:33:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecTiposOperaView" para Druida
 * 
 * @author Indra
 */
public class RecTiposOperaViewComboFormatter extends MMGDruidaFormatoObjeto {
	
	public RecTiposOperaViewComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recTiposOperaViewCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< recTiposOperaViewCombo.size(); i++){
			RecTiposOperaViewData recTiposOperaViewData = (RecTiposOperaViewData)recTiposOperaViewCombo.get(i);
			String description = recTiposOperaViewData.getValTipoOper() != null ? 
				FormatUtils.formatObject(recTiposOperaViewData.getValTipoOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), recTiposOperaViewData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			RecTiposOperaViewData recTiposOperaViewData = (RecTiposOperaViewData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recTiposOperaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((recTiposOperaViewData.getValTipoOper() != null ? 
				FormatUtils.formatObject(recTiposOperaViewData.getValTipoOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
