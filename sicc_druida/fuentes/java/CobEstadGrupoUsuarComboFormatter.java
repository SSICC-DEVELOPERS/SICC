
/*
    INDRA/CAR/mmg
    $Id: CobEstadGrupoUsuarComboFormatter.java,v 1.1 2009/12/03 18:40:27 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CobEstadGrupoUsuarComboFormatter.java,v 1.1 2009/12/03 18:40:27 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEstadGrupoUsuar" para Druida
 * 
 * @author Indra
 */
public class CobEstadGrupoUsuarComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEstadGrupoUsuarComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEstadGrupoUsuarCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< cobEstadGrupoUsuarCombo.size(); i++){
			CobEstadGrupoUsuarData cobEstadGrupoUsuarData = (CobEstadGrupoUsuarData)cobEstadGrupoUsuarCombo.get(i);
			String description = cobEstadGrupoUsuarData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobEstadGrupoUsuarData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), cobEstadGrupoUsuarData);
		}

		//Construimos cada fila con los valores de la clave y la descripci�n del elemento que se mostrar� en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CobEstadGrupoUsuarData cobEstadGrupoUsuarData = (CobEstadGrupoUsuarData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = cobEstadGrupoUsuarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el atributo choice
			row.add((cobEstadGrupoUsuarData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobEstadGrupoUsuarData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
