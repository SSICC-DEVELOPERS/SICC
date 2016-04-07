
/*
    INDRA/CAR/mmg
    $Id: PedTipoDespaFormFormatter.java,v 1.1 2009/12/03 18:32:47 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoDespa" para Druida
 * 
 * @author Indra
 */
public class PedTipoDespaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoDespaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoDespaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedTipoDespaList.size(); i++) {
		
			PedTipoDespaData pedTipoDespaData = (PedTipoDespaData) pedTipoDespaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoDespaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTipoDespaData.getPaisOidPais() != null ? pedTipoDespaData.getPaisOidPais().getId() : null));
			row.add((pedTipoDespaData.getCodTipoDesp() != null ? 
				FormatUtils.formatObject(pedTipoDespaData.getCodTipoDesp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoDespaData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTipoDespaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoDespaData.getIndCron() != null ? 
				FormatUtils.formatObject(pedTipoDespaData.getIndCron(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTipoDespaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
