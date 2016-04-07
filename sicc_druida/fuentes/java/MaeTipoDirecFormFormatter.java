
/*
    INDRA/CAR/mmg
    $Id: MaeTipoDirecFormFormatter.java,v 1.1 2009/12/03 18:43:18 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoDirec" para Druida
 * 
 * @author Indra
 */
public class MaeTipoDirecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoDirecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoDirecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoDirecList.size(); i++) {
		
			MaeTipoDirecData maeTipoDirecData = (MaeTipoDirecData) maeTipoDirecList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = maeTipoDirecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((maeTipoDirecData.getCodTipoDire() != null ? 
				FormatUtils.formatObject(maeTipoDirecData.getCodTipoDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDirecData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoDirecData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoDirecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
