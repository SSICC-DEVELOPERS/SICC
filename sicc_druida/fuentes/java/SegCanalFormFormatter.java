
/*
    INDRA/CAR/mmg
    $Id: SegCanalFormFormatter.java,v 1.1 2009/12/03 18:38:59 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegCanal" para Druida
 * 
 * @author Indra
 */
public class SegCanalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegCanalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segCanalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segCanalList.size(); i++) {
		
			SegCanalData segCanalData = (SegCanalData) segCanalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segCanalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segCanalData.getCodCana() != null ? 
				FormatUtils.formatObject(segCanalData.getCodCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segCanalData.getDescripcion() != null ? 
				FormatUtils.formatObject(segCanalData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segCanalData.getTipeOidTipoPeri() != null ? segCanalData.getTipeOidTipoPeri().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segCanalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
