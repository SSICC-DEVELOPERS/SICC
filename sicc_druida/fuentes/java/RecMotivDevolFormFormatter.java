
/*
    INDRA/CAR/mmg
    $Id: RecMotivDevolFormFormatter.java,v 1.1 2009/12/03 18:41:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecMotivDevol" para Druida
 * 
 * @author Indra
 */
public class RecMotivDevolFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecMotivDevolFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recMotivDevolList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recMotivDevolList.size(); i++) {
		
			RecMotivDevolData recMotivDevolData = (RecMotivDevolData) recMotivDevolList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recMotivDevolData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recMotivDevolData.getCodMotiDevo() != null ? 
				FormatUtils.formatObject(recMotivDevolData.getCodMotiDevo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recMotivDevolData.getPaisOidPais() != null ? recMotivDevolData.getPaisOidPais().getId() : null));
			row.add((recMotivDevolData.getDescripcion() != null ? 
				FormatUtils.formatObject(recMotivDevolData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recMotivDevolData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
