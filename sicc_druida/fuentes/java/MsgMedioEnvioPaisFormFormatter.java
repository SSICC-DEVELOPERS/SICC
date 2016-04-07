
/*
    INDRA/CAR/mmg
    $Id: MsgMedioEnvioPaisFormFormatter.java,v 1.1 2009/12/03 18:36:43 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgMedioEnvioPais" para Druida
 * 
 * @author Indra
 */
public class MsgMedioEnvioPaisFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgMedioEnvioPaisFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgMedioEnvioPaisList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgMedioEnvioPaisList.size(); i++) {
		
			MsgMedioEnvioPaisData msgMedioEnvioPaisData = (MsgMedioEnvioPaisData) msgMedioEnvioPaisList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = msgMedioEnvioPaisData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((msgMedioEnvioPaisData.getPaisOidPais() != null ? msgMedioEnvioPaisData.getPaisOidPais().getId() : null));
			row.add((msgMedioEnvioPaisData.getMeenOidMediEnvi() != null ? msgMedioEnvioPaisData.getMeenOidMediEnvi().getId() : null));
			row.add((msgMedioEnvioPaisData.getCodEsta() != null ? 
				FormatUtils.formatObject(msgMedioEnvioPaisData.getCodEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgMedioEnvioPaisData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
