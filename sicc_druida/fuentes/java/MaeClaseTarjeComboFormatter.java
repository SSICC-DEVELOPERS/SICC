
/*
    INDRA/CAR/mmg
    $Id: MaeClaseTarjeComboFormatter.java,v 1.1 2009/12/03 18:38:04 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: MaeClaseTarjeComboFormatter.java,v 1.1 2009/12/03 18:38:04 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClaseTarje" para Druida
 * 
 * @author Indra
 */
public class MaeClaseTarjeComboFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClaseTarjeComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClaseTarjeCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< maeClaseTarjeCombo.size(); i++){
			MaeClaseTarjeData maeClaseTarjeData = (MaeClaseTarjeData)maeClaseTarjeCombo.get(i);
			String description = maeClaseTarjeData.getDesClasTarj() != null ? 
				FormatUtils.formatObject(maeClaseTarjeData.getDesClasTarj(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), maeClaseTarjeData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			MaeClaseTarjeData maeClaseTarjeData = (MaeClaseTarjeData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClaseTarjeData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((maeClaseTarjeData.getDesClasTarj() != null ? 
				FormatUtils.formatObject(maeClaseTarjeData.getDesClasTarj(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
