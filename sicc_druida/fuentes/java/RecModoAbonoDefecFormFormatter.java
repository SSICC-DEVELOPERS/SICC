
/*
    INDRA/CAR/mmg
    $Id: RecModoAbonoDefecFormFormatter.java,v 1.1 2009/12/03 18:35:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecModoAbonoDefec" para Druida
 * 
 * @author Indra
 */
public class RecModoAbonoDefecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecModoAbonoDefecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recModoAbonoDefecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recModoAbonoDefecList.size(); i++) {
		
			RecModoAbonoDefecData recModoAbonoDefecData = (RecModoAbonoDefecData) recModoAbonoDefecList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recModoAbonoDefecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recModoAbonoDefecData.getCodModoAbon() != null ? 
				FormatUtils.formatObject(recModoAbonoDefecData.getCodModoAbon(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recModoAbonoDefecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
