
/*
    INDRA/CAR/mmg
    $Id: MaeSubtiClienFormFormatter.java,v 1.1 2009/12/03 18:33:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeSubtiClien" para Druida
 * 
 * @author Indra
 */
public class MaeSubtiClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeSubtiClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeSubtiClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeSubtiClienList.size(); i++) {
		
			MaeSubtiClienData maeSubtiClienData = (MaeSubtiClienData) maeSubtiClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeSubtiClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeSubtiClienData.getTiclOidTipoClie() != null ? maeSubtiClienData.getTiclOidTipoClie().getId() : null));
			row.add((maeSubtiClienData.getCodSubtClie() != null ? 
				FormatUtils.formatObject(maeSubtiClienData.getCodSubtClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeSubtiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeSubtiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeSubtiClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
