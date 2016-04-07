
/*
    INDRA/CAR/mmg
    $Id: MsgTipoMetacFormFormatter.java,v 1.1 2009/12/03 18:40:21 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgTipoMetac" para Druida
 * 
 * @author Indra
 */
public class MsgTipoMetacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgTipoMetacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgTipoMetacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgTipoMetacList.size(); i++) {
		
			MsgTipoMetacData msgTipoMetacData = (MsgTipoMetacData) msgTipoMetacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = msgTipoMetacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((msgTipoMetacData.getCodTipo() != null ? 
				FormatUtils.formatObject(msgTipoMetacData.getCodTipo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgTipoMetacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
