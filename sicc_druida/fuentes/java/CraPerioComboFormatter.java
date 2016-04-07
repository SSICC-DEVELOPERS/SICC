
/*
    INDRA/CAR/mmg
    $Id: CraPerioComboFormatter.java,v 1.1 2009/12/03 18:40:59 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CraPerioComboFormatter.java,v 1.1 2009/12/03 18:40:59 pecbazalar Exp $
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
 * Clase de formateo de objetos "CraPerio" para Druida
 * 
 * @author Indra
 */
public class CraPerioComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CraPerioComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector craPerioCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< craPerioCombo.size(); i++){
			CraPerioData craPerioData = (CraPerioData)craPerioCombo.get(i);
			String description = craPerioData.getIndPeriCruc() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCruc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), craPerioData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CraPerioData craPerioData = (CraPerioData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = craPerioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((craPerioData.getIndPeriCruc() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCruc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
