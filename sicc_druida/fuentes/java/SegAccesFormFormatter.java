
/*
    INDRA/CAR/mmg
    $Id: SegAccesFormFormatter.java,v 1.1 2009/12/03 18:41:38 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegAcces" para Druida
 * 
 * @author Indra
 */
public class SegAccesFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegAccesFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segAccesList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segAccesList.size(); i++) {
		
			SegAccesData segAccesData = (SegAccesData) segAccesList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = segAccesData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((segAccesData.getCodAcce() != null ? 
				FormatUtils.formatObject(segAccesData.getCodAcce(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segAccesData.getDescripcion() != null ? 
				FormatUtils.formatObject(segAccesData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segAccesData.getCanaOidCana() != null ? segAccesData.getCanaOidCana().getId() : null));
			row.add((segAccesData.getIndAcce() != null ? 
				FormatUtils.formatObject(segAccesData.getIndAcce(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segAccesData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
