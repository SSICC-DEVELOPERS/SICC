
/*
    INDRA/CAR/mmg
    $Id: PedProceViewFormFormatter.java,v 1.1 2009/12/03 18:33:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedProceView" para Druida
 * 
 * @author Indra
 */
public class PedProceViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedProceViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedProceViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedProceViewList.size(); i++) {
		
			PedProceViewData pedProceViewData = (PedProceViewData) pedProceViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedProceViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedProceViewData.getCodProc() != null ? 
				FormatUtils.formatObject(pedProceViewData.getCodProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedProceViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedProceViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedProceViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
