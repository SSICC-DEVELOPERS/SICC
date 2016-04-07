
/*
    INDRA/CAR/mmg
    $Id: BelFormaPagoFormFormatter.java,v 1.1 2009/12/03 18:39:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelFormaPago" para Druida
 * 
 * @author Indra
 */
public class BelFormaPagoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelFormaPagoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belFormaPagoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belFormaPagoList.size(); i++) {
		
			BelFormaPagoData belFormaPagoData = (BelFormaPagoData) belFormaPagoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belFormaPagoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belFormaPagoData.getCodFormPago() != null ? 
				FormatUtils.formatObject(belFormaPagoData.getCodFormPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belFormaPagoData.getDescripcion() != null ? 
				FormatUtils.formatObject(belFormaPagoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belFormaPagoData.getPaisOidPais() != null ? belFormaPagoData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belFormaPagoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
