
/*
    INDRA/CAR/mmg
    $Id: FacDestiImpreFormFormatter.java,v 1.1 2009/12/03 18:38:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacDestiImpre" para Druida
 * 
 * @author Indra
 */
public class FacDestiImpreFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacDestiImpreFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facDestiImpreList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facDestiImpreList.size(); i++) {
		
			FacDestiImpreData facDestiImpreData = (FacDestiImpreData) facDestiImpreList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facDestiImpreData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facDestiImpreData.getDesDest() != null ? 
				FormatUtils.formatObject(facDestiImpreData.getDesDest(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facDestiImpreData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
