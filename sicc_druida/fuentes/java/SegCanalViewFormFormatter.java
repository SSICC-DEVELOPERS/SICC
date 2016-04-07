
/*
    INDRA/CAR/mmg
    $Id: SegCanalViewFormFormatter.java,v 1.1 2009/12/03 18:39:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegCanalView" para Druida
 * 
 * @author Indra
 */
public class SegCanalViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegCanalViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segCanalViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segCanalViewList.size(); i++) {
		
			SegCanalViewData segCanalViewData = (SegCanalViewData) segCanalViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segCanalViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segCanalViewData.getCodCana() != null ? 
				FormatUtils.formatObject(segCanalViewData.getCodCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segCanalViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(segCanalViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segCanalViewData.getTipeOidTipoPeri() != null ? segCanalViewData.getTipeOidTipoPeri().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segCanalViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
