
/*
    INDRA/CAR/mmg
    $Id: CobSubtiAccioComboFormatter.java,v 1.1 2009/12/03 18:39:14 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CobSubtiAccioComboFormatter.java,v 1.1 2009/12/03 18:39:14 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobSubtiAccio" para Druida
 * 
 * @author Indra
 */
public class CobSubtiAccioComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CobSubtiAccioComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobSubtiAccioCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< cobSubtiAccioCombo.size(); i++){
			CobSubtiAccioData cobSubtiAccioData = (CobSubtiAccioData)cobSubtiAccioCombo.get(i);
			String description = cobSubtiAccioData.getCodSubtAcci() != null ? 
				FormatUtils.formatObject(cobSubtiAccioData.getCodSubtAcci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), cobSubtiAccioData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CobSubtiAccioData cobSubtiAccioData = (CobSubtiAccioData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobSubtiAccioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((cobSubtiAccioData.getCodSubtAcci() != null ? 
				FormatUtils.formatObject(cobSubtiAccioData.getCodSubtAcci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
