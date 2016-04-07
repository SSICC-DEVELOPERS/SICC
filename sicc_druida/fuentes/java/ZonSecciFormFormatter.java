
/*
    INDRA/CAR/mmg
    $Id: ZonSecciFormFormatter.java,v 1.1 2009/12/03 18:33:14 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonSecci" para Druida
 * 
 * @author Indra
 */
public class ZonSecciFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonSecciFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonSecciList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonSecciList.size(); i++) {
		
			ZonSecciData zonSecciData = (ZonSecciData) zonSecciList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonSecciData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonSecciData.getZzonOidZona() != null ? zonSecciData.getZzonOidZona().getId() : null));
			row.add((zonSecciData.getCodSecc() != null ? 
				FormatUtils.formatObject(zonSecciData.getCodSecc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getIndActi() != null ? 
				FormatUtils.formatObject(zonSecciData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonSecciData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getClieOidClie() != null ? zonSecciData.getClieOidClie().getId() : null));
			row.add((zonSecciData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonSecciData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonSecciData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonSecciData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getDesSecci() != null ? 
				FormatUtils.formatObject(zonSecciData.getDesSecci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSecciData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonSecciData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonSecciData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
