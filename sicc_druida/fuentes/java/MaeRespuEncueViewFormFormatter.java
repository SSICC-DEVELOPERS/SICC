
/*
    INDRA/CAR/mmg
    $Id: MaeRespuEncueViewFormFormatter.java,v 1.1 2009/12/03 18:37:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeRespuEncueView" para Druida
 * 
 * @author Indra
 */
public class MaeRespuEncueViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeRespuEncueViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeRespuEncueViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeRespuEncueViewList.size(); i++) {
		
			MaeRespuEncueViewData maeRespuEncueViewData = (MaeRespuEncueViewData) maeRespuEncueViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeRespuEncueViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeRespuEncueViewData.getCodResp() != null ? 
				FormatUtils.formatObject(maeRespuEncueViewData.getCodResp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeRespuEncueViewData.getValPeso() != null ? 
				FormatUtils.formatObject(maeRespuEncueViewData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeRespuEncueViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeRespuEncueViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeRespuEncueViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
