
/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaFormFormatter.java,v 1.1 2009/12/03 18:41:05 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonSubGerenVenta" para Druida
 * 
 * @author Indra
 */
public class ZonSubGerenVentaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonSubGerenVentaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonSubGerenVentaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonSubGerenVentaList.size(); i++) {
		
			ZonSubGerenVentaData zonSubGerenVentaData = (ZonSubGerenVentaData) zonSubGerenVentaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonSubGerenVentaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonSubGerenVentaData.getPaisOidPais() != null ? zonSubGerenVentaData.getPaisOidPais().getId() : null));
			row.add((zonSubGerenVentaData.getMarcOidMarc() != null ? zonSubGerenVentaData.getMarcOidMarc().getId() : null));
			row.add((zonSubGerenVentaData.getCanaOidCana() != null ? zonSubGerenVentaData.getCanaOidCana().getId() : null));
			row.add((zonSubGerenVentaData.getCodSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getCodSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getIndActi() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getDesSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getDesSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaData.getClieOidClie() != null ? zonSubGerenVentaData.getClieOidClie().getId() : null));
			row.add((zonSubGerenVentaData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonSubGerenVentaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
