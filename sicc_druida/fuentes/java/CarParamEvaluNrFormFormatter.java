
/*
    INDRA/CAR/mmg
    $Id: CarParamEvaluNrFormFormatter.java,v 1.1 2009/12/03 18:39:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamEvaluNr" para Druida
 * 
 * @author Indra
 */
public class CarParamEvaluNrFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamEvaluNrFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamEvaluNrList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carParamEvaluNrList.size(); i++) {
		
			CarParamEvaluNrData carParamEvaluNrData = (CarParamEvaluNrData) carParamEvaluNrList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamEvaluNrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamEvaluNrData.getCodPara() != null ? 
				FormatUtils.formatObject(carParamEvaluNrData.getCodPara(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamEvaluNrData.getDesPara() != null ? 
				FormatUtils.formatObject(carParamEvaluNrData.getDesPara(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamEvaluNrData.getValPeso() != null ? 
				FormatUtils.formatObject(carParamEvaluNrData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carParamEvaluNrData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
