
/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaViewFormFormatter.java,v 1.1 2009/12/03 18:32:15 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonSubGerenVentaView" para Druida
 * 
 * @author Indra
 */
public class ZonSubGerenVentaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonSubGerenVentaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonSubGerenVentaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonSubGerenVentaViewList.size(); i++) {
		
			ZonSubGerenVentaViewData zonSubGerenVentaViewData = (ZonSubGerenVentaViewData) zonSubGerenVentaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonSubGerenVentaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonSubGerenVentaViewData.getPaisOidPais() != null ? zonSubGerenVentaViewData.getPaisOidPais().getId() : null));
			row.add((zonSubGerenVentaViewData.getCodSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getDesSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getDesSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonSubGerenVentaViewData.getMarcOidMarc() != null ? zonSubGerenVentaViewData.getMarcOidMarc().getId() : null));
			row.add((zonSubGerenVentaViewData.getCanaOidCana() != null ? zonSubGerenVentaViewData.getCanaOidCana().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonSubGerenVentaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
