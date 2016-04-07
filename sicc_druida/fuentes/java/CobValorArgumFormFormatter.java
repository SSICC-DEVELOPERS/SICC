
/*
    INDRA/CAR/mmg
    $Id: CobValorArgumFormFormatter.java,v 1.1 2009/12/03 18:35:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobValorArgum" para Druida
 * 
 * @author Indra
 */
public class CobValorArgumFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobValorArgumFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobValorArgumList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobValorArgumList.size(); i++) {
		
			CobValorArgumData cobValorArgumData = (CobValorArgumData) cobValorArgumList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobValorArgumData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobValorArgumData.getValArgu() != null ? 
				FormatUtils.formatObject(cobValorArgumData.getValArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobValorArgumData.getValDescValoArgu() != null ? 
				FormatUtils.formatObject(cobValorArgumData.getValDescValoArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobValorArgumData.getValObse() != null ? 
				FormatUtils.formatObject(cobValorArgumData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobValorArgumData.getArguOidArgu() != null ? cobValorArgumData.getArguOidArgu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobValorArgumData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
