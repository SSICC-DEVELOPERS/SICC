
/*
    INDRA/CAR/mmg
    $Id: SegPerioCorpoFormFormatter.java,v 1.1 2009/12/03 18:33:53 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegPerioCorpo" para Druida
 * 
 * @author Indra
 */
public class SegPerioCorpoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegPerioCorpoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segPerioCorpoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segPerioCorpoList.size(); i++) {
		
			SegPerioCorpoData segPerioCorpoData = (SegPerioCorpoData) segPerioCorpoList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = segPerioCorpoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((segPerioCorpoData.getTipeOidTipoPeri() != null ? segPerioCorpoData.getTipeOidTipoPeri().getId() : null));
			row.add((segPerioCorpoData.getCodPeri() != null ? 
				FormatUtils.formatObject(segPerioCorpoData.getCodPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPerioCorpoData.getDescripcion() != null ? 
				FormatUtils.formatObject(segPerioCorpoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPerioCorpoData.getValAnio() != null ? 
				FormatUtils.formatObject(segPerioCorpoData.getValAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segPerioCorpoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
