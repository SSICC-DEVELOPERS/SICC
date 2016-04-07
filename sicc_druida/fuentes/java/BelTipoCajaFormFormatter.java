
/*
    INDRA/CAR/mmg
    $Id: BelTipoCajaFormFormatter.java,v 1.1 2009/12/03 18:33:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoCaja" para Druida
 * 
 * @author Indra
 */
public class BelTipoCajaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoCajaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoCajaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belTipoCajaList.size(); i++) {
		
			BelTipoCajaData belTipoCajaData = (BelTipoCajaData) belTipoCajaList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = belTipoCajaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((belTipoCajaData.getCodTipoCaja() != null ? 
				FormatUtils.formatObject(belTipoCajaData.getCodTipoCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belTipoCajaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
