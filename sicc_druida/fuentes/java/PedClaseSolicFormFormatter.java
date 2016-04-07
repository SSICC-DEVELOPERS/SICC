
/*
    INDRA/CAR/mmg
    $Id: PedClaseSolicFormFormatter.java,v 1.1 2009/12/03 18:34:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedClaseSolic" para Druida
 * 
 * @author Indra
 */
public class PedClaseSolicFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedClaseSolicFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedClaseSolicList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedClaseSolicList.size(); i++) {
		
			PedClaseSolicData pedClaseSolicData = (PedClaseSolicData) pedClaseSolicList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedClaseSolicData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedClaseSolicData.getCodClasSoli() != null ? 
				FormatUtils.formatObject(pedClaseSolicData.getCodClasSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedClaseSolicData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedClaseSolicData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedClaseSolicData.getIndOrdeComp() != null ? 
				FormatUtils.formatObject(pedClaseSolicData.getIndOrdeComp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedClaseSolicData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
