
/*
    INDRA/CAR/mmg
    $Id: PreCatalOrdenFormFormatter.java,v 1.1 2009/12/03 18:33:39 pecbazalar Exp $
    DESC
*/


import java.util.Vector;
import java.util.Hashtable;
import java.util.Enumeration;

import es.indra.belcorp.mso.*;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "PreCatalOrden" para Druida
 * 
 * @author Indra
 */
public class PreCatalOrdenFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreCatalOrdenFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preCatalOrdenList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preCatalOrdenList.size(); i++) {
		
			PreCatalOrdenData preCatalOrdenData = (PreCatalOrdenData) preCatalOrdenList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preCatalOrdenData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preCatalOrdenData.getMarcOidMarc() != null ? preCatalOrdenData.getMarcOidMarc().getId() : null));
			row.add((preCatalOrdenData.getCanaOidCana() != null ? preCatalOrdenData.getCanaOidCana().getId() : null));
			row.add((preCatalOrdenData.getOcatOidCata() != null ? preCatalOrdenData.getOcatOidCata().getId() : null));
			row.add((preCatalOrdenData.getNumOrde() != null ? 
				FormatUtils.formatObject(preCatalOrdenData.getNumOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preCatalOrdenData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
