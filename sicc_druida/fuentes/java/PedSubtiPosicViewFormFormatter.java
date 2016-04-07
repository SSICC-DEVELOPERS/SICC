
/*
    INDRA/CAR/mmg
    $Id: PedSubtiPosicViewFormFormatter.java,v 1.1 2009/12/03 18:39:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedSubtiPosicView" para Druida
 * 
 * @author Indra
 */
public class PedSubtiPosicViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedSubtiPosicViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedSubtiPosicViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedSubtiPosicViewList.size(); i++) {
		
			PedSubtiPosicViewData pedSubtiPosicViewData = (PedSubtiPosicViewData) pedSubtiPosicViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedSubtiPosicViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedSubtiPosicViewData.getCodSubtPosi() != null ? 
				FormatUtils.formatObject(pedSubtiPosicViewData.getCodSubtPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedSubtiPosicViewData.getTposOidTipoPosi() != null ? pedSubtiPosicViewData.getTposOidTipoPosi().getId() : null));
			row.add((pedSubtiPosicViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedSubtiPosicViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedSubtiPosicViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
