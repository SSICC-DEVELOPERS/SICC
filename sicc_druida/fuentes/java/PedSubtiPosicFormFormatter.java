
/*
    INDRA/CAR/mmg
    $Id: PedSubtiPosicFormFormatter.java,v 1.1 2009/12/03 18:38:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedSubtiPosic" para Druida
 * 
 * @author Indra
 */
public class PedSubtiPosicFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedSubtiPosicFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedSubtiPosicList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedSubtiPosicList.size(); i++) {
		
			PedSubtiPosicData pedSubtiPosicData = (PedSubtiPosicData) pedSubtiPosicList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedSubtiPosicData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedSubtiPosicData.getCodSubtPosi() != null ? 
				FormatUtils.formatObject(pedSubtiPosicData.getCodSubtPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedSubtiPosicData.getTposOidTipoPosi() != null ? pedSubtiPosicData.getTposOidTipoPosi().getId() : null));
			row.add((pedSubtiPosicData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedSubtiPosicData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedSubtiPosicData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
