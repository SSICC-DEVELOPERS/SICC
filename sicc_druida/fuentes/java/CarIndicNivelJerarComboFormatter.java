
/*
    INDRA/CAR/mmg
    $Id: CarIndicNivelJerarComboFormatter.java,v 1.1 2009/12/03 18:38:40 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarIndicNivelJerarComboFormatter.java,v 1.1 2009/12/03 18:38:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarIndicNivelJerar" para Druida
 * 
 * @author Indra
 */
public class CarIndicNivelJerarComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarIndicNivelJerarComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carIndicNivelJerarCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< carIndicNivelJerarCombo.size(); i++){
			CarIndicNivelJerarData carIndicNivelJerarData = (CarIndicNivelJerarData)carIndicNivelJerarCombo.get(i);
			String description = carIndicNivelJerarData.getCodIndiNiveJera() != null ? 
				FormatUtils.formatObject(carIndicNivelJerarData.getCodIndiNiveJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), carIndicNivelJerarData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CarIndicNivelJerarData carIndicNivelJerarData = (CarIndicNivelJerarData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carIndicNivelJerarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((carIndicNivelJerarData.getCodIndiNiveJera() != null ? 
				FormatUtils.formatObject(carIndicNivelJerarData.getCodIndiNiveJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
