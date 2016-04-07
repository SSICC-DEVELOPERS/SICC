
/*
    INDRA/CAR/mmg
    $Id: BelMedioPagoFormFormatter.java,v 1.1 2009/12/03 18:41:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelMedioPago" para Druida
 * 
 * @author Indra
 */
public class BelMedioPagoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelMedioPagoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belMedioPagoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belMedioPagoList.size(); i++) {
		
			BelMedioPagoData belMedioPagoData = (BelMedioPagoData) belMedioPagoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belMedioPagoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belMedioPagoData.getPaisOidPais() != null ? belMedioPagoData.getPaisOidPais().getId() : null));
			row.add((belMedioPagoData.getCodMediPago() != null ? 
				FormatUtils.formatObject(belMedioPagoData.getCodMediPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belMedioPagoData.getDescripcion() != null ? 
				FormatUtils.formatObject(belMedioPagoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belMedioPagoData.getTmepOidTipoMediPago() != null ? belMedioPagoData.getTmepOidTipoMediPago().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belMedioPagoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
