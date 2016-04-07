
/*
    INDRA/CAR/mmg
    $Id: CarNivelRiesgFormFormatter.java,v 1.1 2009/12/03 18:37:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarNivelRiesg" para Druida
 * 
 * @author Indra
 */
public class CarNivelRiesgFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarNivelRiesgFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carNivelRiesgList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carNivelRiesgList.size(); i++) {
		
			CarNivelRiesgData carNivelRiesgData = (CarNivelRiesgData) carNivelRiesgList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carNivelRiesgData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carNivelRiesgData.getCodNiveRies() != null ? 
				FormatUtils.formatObject(carNivelRiesgData.getCodNiveRies(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carNivelRiesgData.getDescripcion() != null ? 
				FormatUtils.formatObject(carNivelRiesgData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carNivelRiesgData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
