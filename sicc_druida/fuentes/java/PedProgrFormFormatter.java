
/*
    INDRA/CAR/mmg
    $Id: PedProgrFormFormatter.java,v 1.1 2009/12/03 18:41:52 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedProgr" para Druida
 * 
 * @author Indra
 */
public class PedProgrFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedProgrFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedProgrList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedProgrList.size(); i++) {
		
			PedProgrData pedProgrData = (PedProgrData) pedProgrList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedProgrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedProgrData.getValNomb() != null ? 
				FormatUtils.formatObject(pedProgrData.getValNomb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedProgrData.getValClasEjec() != null ? 
				FormatUtils.formatObject(pedProgrData.getValClasEjec(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedProgrData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
