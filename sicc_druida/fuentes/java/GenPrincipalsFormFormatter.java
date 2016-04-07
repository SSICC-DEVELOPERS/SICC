
/*
    INDRA/CAR/mmg
    $Id: GenPrincipalsFormFormatter.java,v 1.1 2009/12/03 18:37:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenPrincipals" para Druida
 * 
 * @author Indra
 */
public class GenPrincipalsFormFormatter extends MMGDruidaFormatoObjeto {
	
	public GenPrincipalsFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genPrincipalsList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < genPrincipalsList.size(); i++) {
		
			GenPrincipalsData genPrincipalsData = (GenPrincipalsData) genPrincipalsList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genPrincipalsData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genPrincipalsData.getName() != null ? 
				FormatUtils.formatObject(genPrincipalsData.getName(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genPrincipalsData.getType() != null ? 
				FormatUtils.formatObject(genPrincipalsData.getType(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genPrincipalsData.getDescription() != null ? 
				FormatUtils.formatObject(genPrincipalsData.getDescription(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(genPrincipalsData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
