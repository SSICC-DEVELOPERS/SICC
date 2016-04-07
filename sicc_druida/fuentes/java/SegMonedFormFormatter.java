
/*
    INDRA/CAR/mmg
    $Id: SegMonedFormFormatter.java,v 1.1 2009/12/03 18:38:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegMoned" para Druida
 * 
 * @author Indra
 */
public class SegMonedFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegMonedFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segMonedList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segMonedList.size(); i++) {
		
			SegMonedData segMonedData = (SegMonedData) segMonedList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segMonedData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segMonedData.getCodMone() != null ? 
				FormatUtils.formatObject(segMonedData.getCodMone(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMonedData.getDescripcion() != null ? 
				FormatUtils.formatObject(segMonedData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMonedData.getValNombCortMone() != null ? 
				FormatUtils.formatObject(segMonedData.getValNombCortMone(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMonedData.getValSimbMone() != null ? 
				FormatUtils.formatObject(segMonedData.getValSimbMone(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMonedData.getNumDeci() != null ? 
				FormatUtils.formatObject(segMonedData.getNumDeci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segMonedData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
