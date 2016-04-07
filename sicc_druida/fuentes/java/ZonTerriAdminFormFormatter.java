
/*
    INDRA/CAR/mmg
    $Id: ZonTerriAdminFormFormatter.java,v 1.1 2009/12/03 18:35:03 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonTerriAdmin" para Druida
 * 
 * @author Indra
 */
public class ZonTerriAdminFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonTerriAdminFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonTerriAdminList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonTerriAdminList.size(); i++) {
		
			ZonTerriAdminData zonTerriAdminData = (ZonTerriAdminData) zonTerriAdminList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonTerriAdminData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonTerriAdminData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriAdminData.getZsccOidSecc() != null ? zonTerriAdminData.getZsccOidSecc().getId() : null));
			row.add((zonTerriAdminData.getTerrOidTerr() != null ? zonTerriAdminData.getTerrOidTerr().getId() : null));
			row.add((zonTerriAdminData.getFecRtz() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getFecRtz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonTerriAdminData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
