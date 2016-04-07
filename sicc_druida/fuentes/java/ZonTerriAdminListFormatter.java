
/*
    INDRA/CAR/mmg
    $Id: ZonTerriAdminListFormatter.java,v 1.1 2009/12/03 18:39:46 pecbazalar Exp $
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
public class ZonTerriAdminListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonTerriAdminListFormatter() {
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
			row.add((zonTerriAdminData.getZsccOidSecc() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getZsccOidSecc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriAdminData.getTerrOidTerr() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getTerrOidTerr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriAdminData.getFecRtz() != null ? 
				FormatUtils.formatObject(zonTerriAdminData.getFecRtz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonTerriAdminData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
