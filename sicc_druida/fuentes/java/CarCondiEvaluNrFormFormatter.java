
/*
    INDRA/CAR/mmg
    $Id: CarCondiEvaluNrFormFormatter.java,v 1.1 2009/12/03 18:38:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarCondiEvaluNr" para Druida
 * 
 * @author Indra
 */
public class CarCondiEvaluNrFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarCondiEvaluNrFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carCondiEvaluNrList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carCondiEvaluNrList.size(); i++) {
		
			CarCondiEvaluNrData carCondiEvaluNrData = (CarCondiEvaluNrData) carCondiEvaluNrList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carCondiEvaluNrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carCondiEvaluNrData.getPenrOidParaEvalNr() != null ? carCondiEvaluNrData.getPenrOidParaEvalNr().getId() : null));
			row.add((carCondiEvaluNrData.getValMini() != null ? 
				FormatUtils.formatObject(carCondiEvaluNrData.getValMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carCondiEvaluNrData.getValMaxi() != null ? 
				FormatUtils.formatObject(carCondiEvaluNrData.getValMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carCondiEvaluNrData.getValEscaMini() != null ? 
				FormatUtils.formatObject(carCondiEvaluNrData.getValEscaMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carCondiEvaluNrData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
