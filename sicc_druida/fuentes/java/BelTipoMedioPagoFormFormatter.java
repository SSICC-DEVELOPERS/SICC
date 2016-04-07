
/*
    INDRA/CAR/mmg
    $Id: BelTipoMedioPagoFormFormatter.java,v 1.1 2009/12/03 18:32:46 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMedioPago" para Druida
 * 
 * @author Indra
 */
public class BelTipoMedioPagoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMedioPagoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMedioPagoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belTipoMedioPagoList.size(); i++) {
		
			BelTipoMedioPagoData belTipoMedioPagoData = (BelTipoMedioPagoData) belTipoMedioPagoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMedioPagoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMedioPagoData.getDescripcion() != null ? 
				FormatUtils.formatObject(belTipoMedioPagoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belTipoMedioPagoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
