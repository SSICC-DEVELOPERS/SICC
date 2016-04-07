
/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccFormFormatter.java,v 1.1 2009/12/03 18:33:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenDetaSicc" para Druida
 * 
 * @author Indra
 */
public class GenDetaSiccFormFormatter extends MMGDruidaFormatoObjeto {
	
	public GenDetaSiccFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genDetaSiccList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < genDetaSiccList.size(); i++) {
		
			GenDetaSiccData genDetaSiccData = (GenDetaSiccData) genDetaSiccList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genDetaSiccData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genDetaSiccData.getEnti() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getEnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccData.getEntiPk() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getEntiPk(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccData.getAtri() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccData.getDeta() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((genDetaSiccData.getIdioOidIdio() != null ? genDetaSiccData.getIdioOidIdio().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(genDetaSiccData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
