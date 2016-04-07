
/*
    INDRA/CAR/mmg
    $Id: ZonRegioView2FormFormatter.java,v 1.1 2009/12/03 18:40:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonRegioView2" para Druida
 * 
 * @author Indra
 */
public class ZonRegioView2FormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonRegioView2FormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonRegioView2List = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonRegioView2List.size(); i++) {
		
			ZonRegioView2Data zonRegioView2Data = (ZonRegioView2Data) zonRegioView2List.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonRegioView2Data.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonRegioView2Data.getCodRegi() != null ? 
				FormatUtils.formatObject(zonRegioView2Data.getCodRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioView2Data.getCanaOidCana() != null ? zonRegioView2Data.getCanaOidCana().getId() : null));
			row.add((zonRegioView2Data.getMarcOidMarc() != null ? zonRegioView2Data.getMarcOidMarc().getId() : null));
			row.add((zonRegioView2Data.getPaisOidPais() != null ? zonRegioView2Data.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonRegioView2Data.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
