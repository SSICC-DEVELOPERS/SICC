
/*
    INDRA/CAR/mmg
    $Id: RecParamNmperFormFormatter.java,v 1.1 2009/12/03 18:42:17 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecParamNmper" para Druida
 * 
 * @author Indra
 */
public class RecParamNmperFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecParamNmperFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recParamNmperList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recParamNmperList.size(); i++) {
		
			RecParamNmperData recParamNmperData = (RecParamNmperData) recParamNmperList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recParamNmperData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recParamNmperData.getTiclOidTipoClie() != null ? recParamNmperData.getTiclOidTipoClie().getId() : null));
			row.add((recParamNmperData.getPperOidPrecPerd() != null ? recParamNmperData.getPperOidPrecPerd().getId() : null));
			row.add((recParamNmperData.getValPorcReca() != null ? 
				FormatUtils.formatObject(recParamNmperData.getValPorcReca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recParamNmperData.getIndParaModi() != null ? 
				FormatUtils.formatObject(recParamNmperData.getIndParaModi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recParamNmperData.getPaisOidPais() != null ? recParamNmperData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recParamNmperData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
