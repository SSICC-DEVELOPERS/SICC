
/*
    INDRA/CAR/mmg
    $Id: MaeRespuEncueFormFormatter.java,v 1.1 2009/12/03 18:34:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeRespuEncue" para Druida
 * 
 * @author Indra
 */
public class MaeRespuEncueFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeRespuEncueFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeRespuEncueList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeRespuEncueList.size(); i++) {
		
			MaeRespuEncueData maeRespuEncueData = (MaeRespuEncueData) maeRespuEncueList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeRespuEncueData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeRespuEncueData.getPrenOidPreg() != null ? maeRespuEncueData.getPrenOidPreg().getId() : null));
			row.add((maeRespuEncueData.getCodResp() != null ? 
				FormatUtils.formatObject(maeRespuEncueData.getCodResp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeRespuEncueData.getValPeso() != null ? 
				FormatUtils.formatObject(maeRespuEncueData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeRespuEncueData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeRespuEncueData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeRespuEncueData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
