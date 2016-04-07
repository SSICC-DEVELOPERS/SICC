
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisViewComboFormatter.java,v 1.1 2009/12/03 18:40:06 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisViewComboFormatter.java,v 1.1 2009/12/03 18:40:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolicPaisView" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicPaisViewComboFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicPaisViewComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicPaisViewCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< pedTipoSolicPaisViewCombo.size(); i++){
			PedTipoSolicPaisViewData pedTipoSolicPaisViewData = (PedTipoSolicPaisViewData)pedTipoSolicPaisViewCombo.get(i);
			String description = pedTipoSolicPaisViewData.getTsolOidTipoSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisViewData.getTsolOidTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), pedTipoSolicPaisViewData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			PedTipoSolicPaisViewData pedTipoSolicPaisViewData = (PedTipoSolicPaisViewData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoSolicPaisViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((pedTipoSolicPaisViewData.getTsolOidTipoSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisViewData.getTsolOidTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
