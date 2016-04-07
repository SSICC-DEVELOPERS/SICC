
/*
    INDRA/CAR/mmg
    $Id: BelFormaPagoTaponFormFormatter.java,v 1.1 2009/12/03 18:39:11 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelFormaPagoTapon" para Druida
 * 
 * @author Indra
 */
public class BelFormaPagoTaponFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelFormaPagoTaponFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belFormaPagoTaponList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belFormaPagoTaponList.size(); i++) {
		
			BelFormaPagoTaponData belFormaPagoTaponData = (BelFormaPagoTaponData) belFormaPagoTaponList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belFormaPagoTaponData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belFormaPagoTaponData.getCodFormPago() != null ? 
				FormatUtils.formatObject(belFormaPagoTaponData.getCodFormPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belFormaPagoTaponData.getDescripcion() != null ? 
				FormatUtils.formatObject(belFormaPagoTaponData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belFormaPagoTaponData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
