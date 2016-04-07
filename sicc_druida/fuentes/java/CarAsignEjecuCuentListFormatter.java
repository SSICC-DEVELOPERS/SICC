
/*
    INDRA/CAR/mmg
    $Id: CarAsignEjecuCuentListFormatter.java,v 1.1 2009/12/03 18:43:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarAsignEjecuCuent" para Druida
 * 
 * @author Indra
 */
public class CarAsignEjecuCuentListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarAsignEjecuCuentListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carAsignEjecuCuentList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carAsignEjecuCuentList.size(); i++) {
		
			CarAsignEjecuCuentData carAsignEjecuCuentData = (CarAsignEjecuCuentData) carAsignEjecuCuentList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carAsignEjecuCuentData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carAsignEjecuCuentData.getNiriOidNiveRies() != null ? 
				FormatUtils.formatObject(carAsignEjecuCuentData.getNiriOidNiveRies(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignEjecuCuentData.getZsgvOidSubgVent() != null ? 
				FormatUtils.formatObject(carAsignEjecuCuentData.getZsgvOidSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignEjecuCuentData.getZorgOidRegi() != null ? 
				FormatUtils.formatObject(carAsignEjecuCuentData.getZorgOidRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignEjecuCuentData.getZzonOidZona() != null ? 
				FormatUtils.formatObject(carAsignEjecuCuentData.getZzonOidZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignEjecuCuentData.getEjcuOidEjecCuen() != null ? 
				FormatUtils.formatObject(carAsignEjecuCuentData.getEjcuOidEjecCuen(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carAsignEjecuCuentData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
