
/*
    INDRA/CAR/mmg
    $Id: CarCondiEvaluNrComboFormatter.java,v 1.1 2009/12/03 18:43:16 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CarCondiEvaluNrComboFormatter.java,v 1.1 2009/12/03 18:43:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarCondiEvaluNr" para Druida
 * 
 * @author Indra
 */
public class CarCondiEvaluNrComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CarCondiEvaluNrComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carCondiEvaluNrCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< carCondiEvaluNrCombo.size(); i++){
			CarCondiEvaluNrData carCondiEvaluNrData = (CarCondiEvaluNrData)carCondiEvaluNrCombo.get(i);
			String description = carCondiEvaluNrData.getValEscaMini() != null ? 
				FormatUtils.formatObject(carCondiEvaluNrData.getValEscaMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), carCondiEvaluNrData);
		}

		//Construimos cada fila con los valores de la clave y la descripci�n del elemento que se mostrar� en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CarCondiEvaluNrData carCondiEvaluNrData = (CarCondiEvaluNrData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = carCondiEvaluNrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el atributo choice
			row.add((carCondiEvaluNrData.getValEscaMini() != null ? 
				FormatUtils.formatObject(carCondiEvaluNrData.getValEscaMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
