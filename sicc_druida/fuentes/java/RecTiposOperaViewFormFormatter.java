
/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaViewFormFormatter.java,v 1.1 2009/12/03 18:34:34 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecTiposOperaView" para Druida
 * 
 * @author Indra
 */
public class RecTiposOperaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecTiposOperaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recTiposOperaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recTiposOperaViewList.size(); i++) {
		
			RecTiposOperaViewData recTiposOperaViewData = (RecTiposOperaViewData) recTiposOperaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recTiposOperaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recTiposOperaViewData.getRopeOidOper() != null ? recTiposOperaViewData.getRopeOidOper().getId() : null));
			row.add((recTiposOperaViewData.getValTipoOper() != null ? 
				FormatUtils.formatObject(recTiposOperaViewData.getValTipoOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recTiposOperaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
