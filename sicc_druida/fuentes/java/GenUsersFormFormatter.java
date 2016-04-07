
/*
    INDRA/CAR/mmg
    $Id: GenUsersFormFormatter.java,v 1.1 2009/12/03 18:34:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenUsers" para Druida
 * 
 * @author Indra
 */
public class GenUsersFormFormatter extends MMGDruidaFormatoObjeto {
	
	public GenUsersFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genUsersList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < genUsersList.size(); i++) {
		
			GenUsersData genUsersData = (GenUsersData) genUsersList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genUsersData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genUsersData.getMyid() != null ? genUsersData.getMyid().getId() : null));
			row.add((genUsersData.getCredential() != null ? 
				FormatUtils.formatObject(genUsersData.getCredential(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genUsersData.getSetdate() != null ? 
				FormatUtils.formatObject(genUsersData.getSetdate(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genUsersData.getRetries() != null ? 
				FormatUtils.formatObject(genUsersData.getRetries(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genUsersData.getBlocked() != null ? 
				FormatUtils.formatObject(genUsersData.getBlocked(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(genUsersData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
