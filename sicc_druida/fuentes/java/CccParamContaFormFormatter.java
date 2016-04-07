
/*
    INDRA/CAR/mmg
    $Id: CccParamContaFormFormatter.java,v 1.1 2009/12/03 18:32:18 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccParamConta" para Druida
 * 
 * @author Indra
 */
public class CccParamContaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccParamContaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccParamContaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccParamContaList.size(); i++) {
		
			CccParamContaData cccParamContaData = (CccParamContaData) cccParamContaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccParamContaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccParamContaData.getSubpOidSubp() != null ? cccParamContaData.getSubpOidSubp().getId() : null));
			row.add((cccParamContaData.getValDebeHabe() != null ? 
				FormatUtils.formatObject(cccParamContaData.getValDebeHabe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccParamContaData.getValObteCuen() != null ? 
				FormatUtils.formatObject(cccParamContaData.getValObteCuen(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccParamContaData.getCucoOidCuenContDire() != null ? cccParamContaData.getCucoOidCuenContDire().getId() : null));
			row.add((cccParamContaData.getValTextApun() != null ? 
				FormatUtils.formatObject(cccParamContaData.getValTextApun(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccParamContaData.getIndConcFech() != null ? 
				FormatUtils.formatObject(cccParamContaData.getIndConcFech(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccParamContaData.getValObse() != null ? 
				FormatUtils.formatObject(cccParamContaData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccParamContaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
