
/*
    INDRA/CAR/mmg
    $Id: CarJerarFormFormatter.java,v 1.1 2009/12/03 18:37:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarJerar" para Druida
 * 
 * @author Indra
 */
public class CarJerarFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarJerarFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carJerarList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carJerarList.size(); i++) {
		
			CarJerarData carJerarData = (CarJerarData) carJerarList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carJerarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carJerarData.getCodJera() != null ? 
				FormatUtils.formatObject(carJerarData.getCodJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carJerarData.getNumDias() != null ? 
				FormatUtils.formatObject(carJerarData.getNumDias(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carJerarData.getValPorcLineCred() != null ? 
				FormatUtils.formatObject(carJerarData.getValPorcLineCred(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carJerarData.getValPorcMontMaxi() != null ? 
				FormatUtils.formatObject(carJerarData.getValPorcMontMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carJerarData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
