
/*
    INDRA/CAR/mmg
    $Id: ZonTerriViewFormFormatter.java,v 1.1 2009/12/03 18:33:36 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonTerriView" para Druida
 * 
 * @author Indra
 */
public class ZonTerriViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonTerriViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonTerriViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonTerriViewList.size(); i++) {
		
			ZonTerriViewData zonTerriViewData = (ZonTerriViewData) zonTerriViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonTerriViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonTerriViewData.getCodTerr() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getCodTerr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonTerriViewData.getFecRtz() != null ? 
				FormatUtils.formatObject(zonTerriViewData.getFecRtz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonTerriViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
