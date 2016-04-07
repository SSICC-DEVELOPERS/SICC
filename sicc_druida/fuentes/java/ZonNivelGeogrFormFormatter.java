
/*
    INDRA/CAR/mmg
    $Id: ZonNivelGeogrFormFormatter.java,v 1.1 2009/12/03 18:39:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonNivelGeogr" para Druida
 * 
 * @author Indra
 */
public class ZonNivelGeogrFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonNivelGeogrFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonNivelGeogrList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonNivelGeogrList.size(); i++) {
		
			ZonNivelGeogrData zonNivelGeogrData = (ZonNivelGeogrData) zonNivelGeogrList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonNivelGeogrData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonNivelGeogrData.getCodDiviPoli() != null ? 
				FormatUtils.formatObject(zonNivelGeogrData.getCodDiviPoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonNivelGeogrData.getDescripcion() != null ? 
				FormatUtils.formatObject(zonNivelGeogrData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonNivelGeogrData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
