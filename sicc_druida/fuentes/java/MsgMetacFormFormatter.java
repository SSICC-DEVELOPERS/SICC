
/*
    INDRA/CAR/mmg
    $Id: MsgMetacFormFormatter.java,v 1.1 2009/12/03 18:39:59 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgMetac" para Druida
 * 
 * @author Indra
 */
public class MsgMetacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgMetacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgMetacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgMetacList.size(); i++) {
		
			MsgMetacData msgMetacData = (MsgMetacData) msgMetacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = msgMetacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((msgMetacData.getCodMeta() != null ? 
				FormatUtils.formatObject(msgMetacData.getCodMeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMetacData.getDescripcion() != null ? 
				FormatUtils.formatObject(msgMetacData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMetacData.getTimeOidTipo() != null ? msgMetacData.getTimeOidTipo().getId() : null));
			row.add((msgMetacData.getValEsta() != null ? 
				FormatUtils.formatObject(msgMetacData.getValEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMetacData.getValLiteIden() != null ? 
				FormatUtils.formatObject(msgMetacData.getValLiteIden(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgMetacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
