
/*
    INDRA/CAR/mmg
    $Id: ZonZonaListFormatter.java,v 1.1 2009/12/03 18:34:11 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonZona" para Druida
 * 
 * @author Indra
 */
public class ZonZonaListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonZonaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonZonaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonZonaList.size(); i++) {
		
			ZonZonaData zonZonaData = (ZonZonaData) zonZonaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonZonaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonZonaData.getClieOidClie() != null ? 
				FormatUtils.formatObject(zonZonaData.getClieOidClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getZorgOidRegi() != null ? 
				FormatUtils.formatObject(zonZonaData.getZorgOidRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getCodZona() != null ? 
				FormatUtils.formatObject(zonZonaData.getCodZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getIndActi() != null ? 
				FormatUtils.formatObject(zonZonaData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getIndRezo() != null ? 
				FormatUtils.formatObject(zonZonaData.getIndRezo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonZonaData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonZonaData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonZonaData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonZonaData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getEszoOidEstaZona() != null ? 
				FormatUtils.formatObject(zonZonaData.getEszoOidEstaZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getDesZona() != null ? 
				FormatUtils.formatObject(zonZonaData.getDesZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getFecCambEsta() != null ? 
				FormatUtils.formatObject(zonZonaData.getFecCambEsta(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonZonaData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonZonaData.getFecRezo(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonZonaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
