
/*
    INDRA/CAR/mmg
    $Id: PreCatalFormFormatter.java,v 1.1 2009/12/03 18:34:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreCatal" para Druida
 * 
 * @author Indra
 */
public class PreCatalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreCatalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preCatalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preCatalList.size(); i++) {
		
			PreCatalData preCatalData = (PreCatalData) preCatalList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = preCatalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((preCatalData.getCodCata() != null ? 
				FormatUtils.formatObject(preCatalData.getCodCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preCatalData.getDesCata() != null ? 
				FormatUtils.formatObject(preCatalData.getDesCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preCatalData.getPaisOidPais() != null ? preCatalData.getPaisOidPais().getId() : null));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preCatalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
