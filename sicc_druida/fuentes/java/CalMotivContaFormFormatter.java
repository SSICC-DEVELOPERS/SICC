
/*
    INDRA/CAR/mmg
    $Id: CalMotivContaFormFormatter.java,v 1.1 2009/12/03 18:36:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalMotivConta" para Druida
 * 
 * @author Indra
 */
public class CalMotivContaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalMotivContaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calMotivContaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calMotivContaList.size(); i++) {
		
			CalMotivContaData calMotivContaData = (CalMotivContaData) calMotivContaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calMotivContaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((calMotivContaData.getCodMoti() != null ? 
				FormatUtils.formatObject(calMotivContaData.getCodMoti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calMotivContaData.getDescripcion() != null ? 
				FormatUtils.formatObject(calMotivContaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calMotivContaData.getCodProc() != null ? 
				FormatUtils.formatObject(calMotivContaData.getCodProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calMotivContaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
