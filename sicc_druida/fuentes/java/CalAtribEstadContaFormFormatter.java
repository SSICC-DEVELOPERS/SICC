
/*
    INDRA/CAR/mmg
    $Id: CalAtribEstadContaFormFormatter.java,v 1.1 2009/12/03 18:33:47 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalAtribEstadConta" para Druida
 * 
 * @author Indra
 */
public class CalAtribEstadContaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalAtribEstadContaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calAtribEstadContaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calAtribEstadContaList.size(); i++) {
		
			CalAtribEstadContaData calAtribEstadContaData = (CalAtribEstadContaData) calAtribEstadContaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calAtribEstadContaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((calAtribEstadContaData.getTecoOidTipoEstaCont() != null ? calAtribEstadContaData.getTecoOidTipoEstaCont().getId() : null));
			row.add((calAtribEstadContaData.getCodAtri() != null ? 
				FormatUtils.formatObject(calAtribEstadContaData.getCodAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calAtribEstadContaData.getDescripcion() != null ? 
				FormatUtils.formatObject(calAtribEstadContaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calAtribEstadContaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
