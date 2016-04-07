
/*
    INDRA/CAR/mmg
    $Id: SegMarcaCorpoMarcaProduComboFormatter.java,v 1.1 2009/12/03 18:43:07 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: SegMarcaCorpoMarcaProduComboFormatter.java,v 1.1 2009/12/03 18:43:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegMarcaCorpoMarcaProdu" para Druida
 * 
 * @author Indra
 */
public class SegMarcaCorpoMarcaProduComboFormatter extends MMGDruidaFormatoObjeto {
	
	public SegMarcaCorpoMarcaProduComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segMarcaCorpoMarcaProduCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< segMarcaCorpoMarcaProduCombo.size(); i++){
			SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduData = (SegMarcaCorpoMarcaProduData)segMarcaCorpoMarcaProduCombo.get(i);
			String description = segMarcaCorpoMarcaProduData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(segMarcaCorpoMarcaProduData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), segMarcaCorpoMarcaProduData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduData = (SegMarcaCorpoMarcaProduData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segMarcaCorpoMarcaProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((segMarcaCorpoMarcaProduData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(segMarcaCorpoMarcaProduData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
