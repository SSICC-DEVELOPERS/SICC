
/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccWithDefaultFormFormatter.java,v 1.1 2009/12/03 18:34:38 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenDetaSiccWithDefault" para Druida
 * 
 * @author Indra
 */
public class GenDetaSiccWithDefaultFormFormatter extends MMGDruidaFormatoObjeto {
	
	public GenDetaSiccWithDefaultFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genDetaSiccWithDefaultList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < genDetaSiccWithDefaultList.size(); i++) {
		
			GenDetaSiccWithDefaultData genDetaSiccWithDefaultData = (GenDetaSiccWithDefaultData) genDetaSiccWithDefaultList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genDetaSiccWithDefaultData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genDetaSiccWithDefaultData.getEnti() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getEnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccWithDefaultData.getEntiPk() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getEntiPk(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccWithDefaultData.getAtri() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccWithDefaultData.getDeta() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccWithDefaultData.getIdioOidIdio() != null ? genDetaSiccWithDefaultData.getIdioOidIdio().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(genDetaSiccWithDefaultData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
