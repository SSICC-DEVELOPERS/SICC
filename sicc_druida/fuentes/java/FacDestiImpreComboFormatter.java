
/*
    INDRA/CAR/mmg
    $Id: FacDestiImpreComboFormatter.java,v 1.1 2009/12/03 18:42:40 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: FacDestiImpreComboFormatter.java,v 1.1 2009/12/03 18:42:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacDestiImpre" para Druida
 * 
 * @author Indra
 */
public class FacDestiImpreComboFormatter extends MMGDruidaFormatoObjeto {
	
	public FacDestiImpreComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facDestiImpreCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< facDestiImpreCombo.size(); i++){
			FacDestiImpreData facDestiImpreData = (FacDestiImpreData)facDestiImpreCombo.get(i);
			String description = facDestiImpreData.getDesDest() != null ? 
				FormatUtils.formatObject(facDestiImpreData.getDesDest(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), facDestiImpreData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			FacDestiImpreData facDestiImpreData = (FacDestiImpreData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facDestiImpreData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((facDestiImpreData.getDesDest() != null ? 
				FormatUtils.formatObject(facDestiImpreData.getDesDest(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
