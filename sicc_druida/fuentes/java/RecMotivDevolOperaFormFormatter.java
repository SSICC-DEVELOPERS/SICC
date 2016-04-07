
/*
    INDRA/CAR/mmg
    $Id: RecMotivDevolOperaFormFormatter.java,v 1.1 2009/12/03 18:34:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecMotivDevolOpera" para Druida
 * 
 * @author Indra
 */
public class RecMotivDevolOperaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecMotivDevolOperaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recMotivDevolOperaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recMotivDevolOperaList.size(); i++) {
		
			RecMotivDevolOperaData recMotivDevolOperaData = (RecMotivDevolOperaData) recMotivDevolOperaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recMotivDevolOperaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recMotivDevolOperaData.getRopeOidOper() != null ? recMotivDevolOperaData.getRopeOidOper().getId() : null));
			row.add((recMotivDevolOperaData.getModvOidMotiDevo() != null ? recMotivDevolOperaData.getModvOidMotiDevo().getId() : null));
			row.add((recMotivDevolOperaData.getValMarcDefe() != null ? 
				FormatUtils.formatObject(recMotivDevolOperaData.getValMarcDefe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recMotivDevolOperaData.getPaisOidPais() != null ? recMotivDevolOperaData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recMotivDevolOperaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
