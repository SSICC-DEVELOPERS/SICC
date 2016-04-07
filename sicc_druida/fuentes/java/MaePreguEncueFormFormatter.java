
/*
    INDRA/CAR/mmg
    $Id: MaePreguEncueFormFormatter.java,v 1.1 2009/12/03 18:35:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaePreguEncue" para Druida
 * 
 * @author Indra
 */
public class MaePreguEncueFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaePreguEncueFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maePreguEncueList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maePreguEncueList.size(); i++) {
		
			MaePreguEncueData maePreguEncueData = (MaePreguEncueData) maePreguEncueList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maePreguEncueData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maePreguEncueData.getCodPreg() != null ? 
				FormatUtils.formatObject(maePreguEncueData.getCodPreg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maePreguEncueData.getValPesoPreg() != null ? 
				FormatUtils.formatObject(maePreguEncueData.getValPesoPreg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maePreguEncueData.getEnseOidEncu() != null ? maePreguEncueData.getEnseOidEncu().getId() : null));
			row.add((maePreguEncueData.getDescripcion() != null ? 
				FormatUtils.formatObject(maePreguEncueData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maePreguEncueData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
