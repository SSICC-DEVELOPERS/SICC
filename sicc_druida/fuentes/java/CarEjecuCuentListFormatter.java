
/*
    INDRA/CAR/mmg
    $Id: CarEjecuCuentListFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarEjecuCuent" para Druida
 * 
 * @author Indra
 */
public class CarEjecuCuentListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarEjecuCuentListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carEjecuCuentList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carEjecuCuentList.size(); i++) {
		
			CarEjecuCuentData carEjecuCuentData = (CarEjecuCuentData) carEjecuCuentList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carEjecuCuentData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carEjecuCuentData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(carEjecuCuentData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carEjecuCuentData.getCodEjecCuen() != null ? 
				FormatUtils.formatObject(carEjecuCuentData.getCodEjecCuen(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carEjecuCuentData.getJeraOidJera() != null ? 
				FormatUtils.formatObject(carEjecuCuentData.getJeraOidJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carEjecuCuentData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
