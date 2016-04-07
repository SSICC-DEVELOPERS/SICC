
/*
    INDRA/CAR/mmg
    $Id: MsgMedioEnvioFormFormatter.java,v 1.1 2009/12/03 18:38:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgMedioEnvio" para Druida
 * 
 * @author Indra
 */
public class MsgMedioEnvioFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgMedioEnvioFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgMedioEnvioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgMedioEnvioList.size(); i++) {
		
			MsgMedioEnvioData msgMedioEnvioData = (MsgMedioEnvioData) msgMedioEnvioList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = msgMedioEnvioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((msgMedioEnvioData.getCodMediEnvi() != null ? 
				FormatUtils.formatObject(msgMedioEnvioData.getCodMediEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMedioEnvioData.getDesMediEnvi() != null ? 
				FormatUtils.formatObject(msgMedioEnvioData.getDesMediEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgMedioEnvioData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
