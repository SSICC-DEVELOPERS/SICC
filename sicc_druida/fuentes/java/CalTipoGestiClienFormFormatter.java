
/*
    INDRA/CAR/mmg
    $Id: CalTipoGestiClienFormFormatter.java,v 1.1 2009/12/03 18:38:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalTipoGestiClien" para Druida
 * 
 * @author Indra
 */
public class CalTipoGestiClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalTipoGestiClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calTipoGestiClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calTipoGestiClienList.size(); i++) {
		
			CalTipoGestiClienData calTipoGestiClienData = (CalTipoGestiClienData) calTipoGestiClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calTipoGestiClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((calTipoGestiClienData.getCodGest() != null ? 
				FormatUtils.formatObject(calTipoGestiClienData.getCodGest(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calTipoGestiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(calTipoGestiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calTipoGestiClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
