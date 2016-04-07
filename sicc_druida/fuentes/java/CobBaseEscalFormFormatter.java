
/*
    INDRA/CAR/mmg
    $Id: CobBaseEscalFormFormatter.java,v 1.1 2009/12/03 18:32:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobBaseEscal" para Druida
 * 
 * @author Indra
 */
public class CobBaseEscalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobBaseEscalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobBaseEscalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobBaseEscalList.size(); i++) {
		
			CobBaseEscalData cobBaseEscalData = (CobBaseEscalData) cobBaseEscalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobBaseEscalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobBaseEscalData.getCodBaseEsca() != null ? 
				FormatUtils.formatObject(cobBaseEscalData.getCodBaseEsca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobBaseEscalData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobBaseEscalData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobBaseEscalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
