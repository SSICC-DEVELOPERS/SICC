
/*
    INDRA/CAR/mmg
    $Id: MaeCodigClienAnterFormFormatter.java,v 1.1 2009/12/03 18:38:44 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeCodigClienAnter" para Druida
 * 
 * @author Indra
 */
public class MaeCodigClienAnterFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeCodigClienAnterFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeCodigClienAnterList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeCodigClienAnterList.size(); i++) {
		
			MaeCodigClienAnterData maeCodigClienAnterData = (MaeCodigClienAnterData) maeCodigClienAnterList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeCodigClienAnterData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeCodigClienAnterData.getClieOidClieNuev() != null ? maeCodigClienAnterData.getClieOidClieNuev().getId() : null));
			row.add((maeCodigClienAnterData.getCodClieAnti() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getCodClieAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeCodigClienAnterData.getPaisOidPais() != null ? maeCodigClienAnterData.getPaisOidPais().getId() : null));
			row.add((maeCodigClienAnterData.getValSistProc() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getValSistProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeCodigClienAnterData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
