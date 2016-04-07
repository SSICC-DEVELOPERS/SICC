
/*
    INDRA/CAR/mmg
    $Id: IntImporContaFactuFormFormatter.java,v 1.1 2009/12/03 18:41:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "IntImporContaFactu" para Druida
 * 
 * @author Indra
 */
public class IntImporContaFactuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IntImporContaFactuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector intImporContaFactuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < intImporContaFactuList.size(); i++) {
		
			IntImporContaFactuData intImporContaFactuData = (IntImporContaFactuData) intImporContaFactuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = intImporContaFactuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((intImporContaFactuData.getCodImpoCont() != null ? 
				FormatUtils.formatObject(intImporContaFactuData.getCodImpoCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intImporContaFactuData.getValIdenCabeDeta() != null ? 
				FormatUtils.formatObject(intImporContaFactuData.getValIdenCabeDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intImporContaFactuData.getValDescImpo() != null ? 
				FormatUtils.formatObject(intImporContaFactuData.getValDescImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intImporContaFactuData.getValObse() != null ? 
				FormatUtils.formatObject(intImporContaFactuData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(intImporContaFactuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
