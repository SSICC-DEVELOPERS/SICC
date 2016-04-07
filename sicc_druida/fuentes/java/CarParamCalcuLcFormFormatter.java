
/*
    INDRA/CAR/mmg
    $Id: CarParamCalcuLcFormFormatter.java,v 1.1 2009/12/03 18:37:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamCalcuLc" para Druida
 * 
 * @author Indra
 */
public class CarParamCalcuLcFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamCalcuLcFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamCalcuLcList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carParamCalcuLcList.size(); i++) {
		
			CarParamCalcuLcData carParamCalcuLcData = (CarParamCalcuLcData) carParamCalcuLcList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamCalcuLcData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamCalcuLcData.getNiriOidNiveRies() != null ? carParamCalcuLcData.getNiriOidNiveRies().getId() : null));
			row.add((carParamCalcuLcData.getValTope() != null ? 
				FormatUtils.formatObject(carParamCalcuLcData.getValTope(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCalcuLcData.getValFactCalc() != null ? 
				FormatUtils.formatObject(carParamCalcuLcData.getValFactCalc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCalcuLcData.getIndVariLineCred() != null ? 
				FormatUtils.formatObject(carParamCalcuLcData.getIndVariLineCred(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carParamCalcuLcData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
