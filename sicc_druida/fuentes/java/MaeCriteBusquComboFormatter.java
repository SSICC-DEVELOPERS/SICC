
/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquComboFormatter.java,v 1.1 2009/12/03 18:36:04 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquComboFormatter.java,v 1.1 2009/12/03 18:36:04 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeCriteBusqu" para Druida
 * 
 * @author Indra
 */
public class MaeCriteBusquComboFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeCriteBusquComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeCriteBusquCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< maeCriteBusquCombo.size(); i++){
			MaeCriteBusquData maeCriteBusquData = (MaeCriteBusquData)maeCriteBusquCombo.get(i);
			String description = maeCriteBusquData.getAtreOidAtriEsp2() != null ? 
				FormatUtils.formatObject(maeCriteBusquData.getAtreOidAtriEsp2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), maeCriteBusquData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			MaeCriteBusquData maeCriteBusquData = (MaeCriteBusquData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeCriteBusquData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((maeCriteBusquData.getAtreOidAtriEsp2() != null ? 
				FormatUtils.formatObject(maeCriteBusquData.getAtreOidAtriEsp2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
