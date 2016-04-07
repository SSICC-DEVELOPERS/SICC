
/*
    INDRA/CAR/mmg
    $Id: CobSubtiAccioFormFormatter.java,v 1.1 2009/12/03 18:34:24 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobSubtiAccio" para Druida
 * 
 * @author Indra
 */
public class CobSubtiAccioFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobSubtiAccioFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobSubtiAccioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobSubtiAccioList.size(); i++) {
		
			CobSubtiAccioData cobSubtiAccioData = (CobSubtiAccioData) cobSubtiAccioList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobSubtiAccioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobSubtiAccioData.getCodSubtAcci() != null ? 
				FormatUtils.formatObject(cobSubtiAccioData.getCodSubtAcci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobSubtiAccioData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
