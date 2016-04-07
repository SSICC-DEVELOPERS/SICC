
/*
    INDRA/CAR/mmg
    $Id: RecMotivRechaDesblFormFormatter.java,v 1.1 2009/12/03 18:38:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecMotivRechaDesbl" para Druida
 * 
 * @author Indra
 */
public class RecMotivRechaDesblFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecMotivRechaDesblFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recMotivRechaDesblList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recMotivRechaDesblList.size(); i++) {
		
			RecMotivRechaDesblData recMotivRechaDesblData = (RecMotivRechaDesblData) recMotivRechaDesblList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recMotivRechaDesblData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recMotivRechaDesblData.getPaisOidPais() != null ? recMotivRechaDesblData.getPaisOidPais().getId() : null));
			row.add((recMotivRechaDesblData.getCodRechDesb() != null ? 
				FormatUtils.formatObject(recMotivRechaDesblData.getCodRechDesb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recMotivRechaDesblData.getDescripcion() != null ? 
				FormatUtils.formatObject(recMotivRechaDesblData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recMotivRechaDesblData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
