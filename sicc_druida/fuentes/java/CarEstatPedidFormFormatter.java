
/*
    INDRA/CAR/mmg
    $Id: CarEstatPedidFormFormatter.java,v 1.1 2009/12/03 18:33:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarEstatPedid" para Druida
 * 
 * @author Indra
 */
public class CarEstatPedidFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarEstatPedidFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carEstatPedidList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carEstatPedidList.size(); i++) {
		
			CarEstatPedidData carEstatPedidData = (CarEstatPedidData) carEstatPedidList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carEstatPedidData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carEstatPedidData.getCodEsta() != null ? 
				FormatUtils.formatObject(carEstatPedidData.getCodEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carEstatPedidData.getDescripcion() != null ? 
				FormatUtils.formatObject(carEstatPedidData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carEstatPedidData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
