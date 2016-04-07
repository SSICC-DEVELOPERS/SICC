
/*
    INDRA/CAR/mmg
    $Id: FacParamFactuComboFormatter.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: FacParamFactuComboFormatter.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacParamFactu" para Druida
 * 
 * @author Indra
 */
public class FacParamFactuComboFormatter extends MMGDruidaFormatoObjeto {
	
	public FacParamFactuComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facParamFactuCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< facParamFactuCombo.size(); i++){
			FacParamFactuData facParamFactuData = (FacParamFactuData)facParamFactuCombo.get(i);
			String description = facParamFactuData.getIndPrecCont() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), facParamFactuData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			FacParamFactuData facParamFactuData = (FacParamFactuData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facParamFactuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((facParamFactuData.getIndPrecCont() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
