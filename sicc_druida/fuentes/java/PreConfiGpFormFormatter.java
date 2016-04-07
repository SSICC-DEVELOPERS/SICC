
/*
    INDRA/CAR/mmg
    $Id: PreConfiGpFormFormatter.java,v 1.1 2009/12/03 18:34:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreConfiGp" para Druida
 * 
 * @author Indra
 */
public class PreConfiGpFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreConfiGpFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preConfiGpList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preConfiGpList.size(); i++) {
		
			PreConfiGpData preConfiGpData = (PreConfiGpData) preConfiGpList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preConfiGpData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preConfiGpData.getPaisOidPais() != null ? preConfiGpData.getPaisOidPais().getId() : null));
			row.add((preConfiGpData.getMarcOidMarc() != null ? preConfiGpData.getMarcOidMarc().getId() : null));
			row.add((preConfiGpData.getCanaOidCana() != null ? preConfiGpData.getCanaOidCana().getId() : null));
			row.add((preConfiGpData.getValIncr() != null ? 
				FormatUtils.formatObject(preConfiGpData.getValIncr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preConfiGpData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
