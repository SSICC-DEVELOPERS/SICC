
/*
    INDRA/CAR/mmg
    $Id: MaeProgrFidelFormFormatter.java,v 1.1 2009/12/03 18:38:23 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeProgrFidel" para Druida
 * 
 * @author Indra
 */
public class MaeProgrFidelFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeProgrFidelFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeProgrFidelList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeProgrFidelList.size(); i++) {
		
			MaeProgrFidelData maeProgrFidelData = (MaeProgrFidelData) maeProgrFidelList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeProgrFidelData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeProgrFidelData.getCodProgFide() != null ? 
				FormatUtils.formatObject(maeProgrFidelData.getCodProgFide(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProgrFidelData.getDesProgFide() != null ? 
				FormatUtils.formatObject(maeProgrFidelData.getDesProgFide(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProgrFidelData.getFactConv() != null ? 
				FormatUtils.formatObject(maeProgrFidelData.getFactConv(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProgrFidelData.getPaisOidPais() != null ? maeProgrFidelData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeProgrFidelData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
