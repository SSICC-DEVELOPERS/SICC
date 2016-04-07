
/*
    INDRA/CAR/mmg
    $Id: ZonRegioFormFormatter.java,v 1.1 2009/12/03 18:41:53 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonRegio" para Druida
 * 
 * @author Indra
 */
public class ZonRegioFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonRegioFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonRegioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonRegioList.size(); i++) {
		
			ZonRegioData zonRegioData = (ZonRegioData) zonRegioList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonRegioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonRegioData.getCodRegi() != null ? 
				FormatUtils.formatObject(zonRegioData.getCodRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getIndActi() != null ? 
				FormatUtils.formatObject(zonRegioData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonRegioData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonRegioData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonRegioData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonRegioData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getZsgvOidSubgVent() != null ? zonRegioData.getZsgvOidSubgVent().getId() : null));
			row.add((zonRegioData.getDesRegi() != null ? 
				FormatUtils.formatObject(zonRegioData.getDesRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonRegioData.getClieOidClie() != null ? zonRegioData.getClieOidClie().getId() : null));
			row.add((zonRegioData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonRegioData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonRegioData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
