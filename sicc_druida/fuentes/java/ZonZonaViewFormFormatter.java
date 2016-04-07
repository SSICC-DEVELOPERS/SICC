
/*
    INDRA/CAR/mmg
    $Id: ZonZonaViewFormFormatter.java,v 1.1 2009/12/03 18:38:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonZonaView" para Druida
 * 
 * @author Indra
 */
public class ZonZonaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonZonaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonZonaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonZonaViewList.size(); i++) {
		
			ZonZonaViewData zonZonaViewData = (ZonZonaViewData) zonZonaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonZonaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonZonaViewData.getCodZona() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getIndRezo() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndRezo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getDesZona() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getDesZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getFecCambEsta() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getFecCambEsta(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaViewData.getMarcOidMarc() != null ? zonZonaViewData.getMarcOidMarc().getId() : null));
			row.add((zonZonaViewData.getCanaOidCana() != null ? zonZonaViewData.getCanaOidCana().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonZonaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
