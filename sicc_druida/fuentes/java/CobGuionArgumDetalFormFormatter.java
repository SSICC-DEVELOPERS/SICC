
/*
    INDRA/CAR/mmg
    $Id: CobGuionArgumDetalFormFormatter.java,v 1.1 2009/12/03 18:38:54 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobGuionArgumDetal" para Druida
 * 
 * @author Indra
 */
public class CobGuionArgumDetalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobGuionArgumDetalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobGuionArgumDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobGuionArgumDetalList.size(); i++) {
		
			CobGuionArgumDetalData cobGuionArgumDetalData = (CobGuionArgumDetalData) cobGuionArgumDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobGuionArgumDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobGuionArgumDetalData.getGacaOidGuioArguCabe() != null ? cobGuionArgumDetalData.getGacaOidGuioArguCabe().getId() : null));
			row.add((cobGuionArgumDetalData.getArguOidArgu() != null ? cobGuionArgumDetalData.getArguOidArgu().getId() : null));
			row.add((cobGuionArgumDetalData.getNumOrdeArgu() != null ? 
				FormatUtils.formatObject(cobGuionArgumDetalData.getNumOrdeArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumDetalData.getIndActiAtriObse() != null ? 
				FormatUtils.formatObject(cobGuionArgumDetalData.getIndActiAtriObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumDetalData.getValObse() != null ? 
				FormatUtils.formatObject(cobGuionArgumDetalData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumDetalData.getVaarOidValoArgu() != null ? cobGuionArgumDetalData.getVaarOidValoArgu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobGuionArgumDetalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
