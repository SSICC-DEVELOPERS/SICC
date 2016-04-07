
/*
    INDRA/CAR/mmg
    $Id: ZonZonaView2FormFormatter.java,v 1.1 2009/12/03 18:34:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonZonaView2" para Druida
 * 
 * @author Indra
 */
public class ZonZonaView2FormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonZonaView2FormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonZonaView2List = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonZonaView2List.size(); i++) {
		
			ZonZonaView2Data zonZonaView2Data = (ZonZonaView2Data) zonZonaView2List.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonZonaView2Data.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonZonaView2Data.getMarcOidMarc() != null ? zonZonaView2Data.getMarcOidMarc().getId() : null));
			row.add((zonZonaView2Data.getCanaOidCana() != null ? zonZonaView2Data.getCanaOidCana().getId() : null));
			row.add((zonZonaView2Data.getCodZona() != null ? 
				FormatUtils.formatObject(zonZonaView2Data.getCodZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaView2Data.getPaisOidPais() != null ? zonZonaView2Data.getPaisOidPais().getId() : null));
			row.add((zonZonaView2Data.getIndActi() != null ? 
				FormatUtils.formatObject(zonZonaView2Data.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaView2Data.getIndBorr() != null ? 
				FormatUtils.formatObject(zonZonaView2Data.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonZonaView2Data.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
