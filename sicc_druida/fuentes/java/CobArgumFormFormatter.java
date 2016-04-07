
/*
    INDRA/CAR/mmg
    $Id: CobArgumFormFormatter.java,v 1.1 2009/12/03 18:35:02 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobArgum" para Druida
 * 
 * @author Indra
 */
public class CobArgumFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobArgumFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobArgumList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobArgumList.size(); i++) {
		
			CobArgumData cobArgumData = (CobArgumData) cobArgumList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobArgumData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobArgumData.getCodArgu() != null ? 
				FormatUtils.formatObject(cobArgumData.getCodArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobArgumData.getValDesc() != null ? 
				FormatUtils.formatObject(cobArgumData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobArgumData.getValObse() != null ? 
				FormatUtils.formatObject(cobArgumData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobArgumData.getPaisOidPais() != null ? cobArgumData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobArgumData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
