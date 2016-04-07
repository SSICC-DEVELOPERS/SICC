
/*
    INDRA/CAR/mmg
    $Id: MaeTipoBloquFormFormatter.java,v 1.1 2009/12/03 18:41:23 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoBloqu" para Druida
 * 
 * @author Indra
 */
public class MaeTipoBloquFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoBloquFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoBloquList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoBloquList.size(); i++) {
		
			MaeTipoBloquData maeTipoBloquData = (MaeTipoBloquData) maeTipoBloquList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoBloquData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoBloquData.getCodTipoBloq() != null ? 
				FormatUtils.formatObject(maeTipoBloquData.getCodTipoBloq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoBloquData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoBloquData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoBloquData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
