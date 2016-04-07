
/*
    INDRA/CAR/mmg
    $Id: MaeSubtiClienViewFormFormatter.java,v 1.1 2009/12/03 18:34:23 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeSubtiClienView" para Druida
 * 
 * @author Indra
 */
public class MaeSubtiClienViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeSubtiClienViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeSubtiClienViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeSubtiClienViewList.size(); i++) {
		
			MaeSubtiClienViewData maeSubtiClienViewData = (MaeSubtiClienViewData) maeSubtiClienViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeSubtiClienViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeSubtiClienViewData.getTiclOidTipoClie() != null ? maeSubtiClienViewData.getTiclOidTipoClie().getId() : null));
			row.add((maeSubtiClienViewData.getCodSubtClie() != null ? 
				FormatUtils.formatObject(maeSubtiClienViewData.getCodSubtClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeSubtiClienViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeSubtiClienViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeSubtiClienViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
