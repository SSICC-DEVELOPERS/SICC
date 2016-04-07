
/*
    INDRA/CAR/mmg
    $Id: ZonValorEstruGeopoFormFormatter.java,v 1.1 2009/12/03 18:35:35 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonValorEstruGeopo" para Druida
 * 
 * @author Indra
 */
public class ZonValorEstruGeopoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonValorEstruGeopoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonValorEstruGeopoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonValorEstruGeopoList.size(); i++) {
		
			ZonValorEstruGeopoData zonValorEstruGeopoData = (ZonValorEstruGeopoData) zonValorEstruGeopoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonValorEstruGeopoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonValorEstruGeopoData.getCodUnidGeog() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getCodUnidGeog(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getDesGeog() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getDesGeog(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getCodPost() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getCodPost(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getIndActi() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getIndAsig() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getIndAsig(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde1() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde2() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde3() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde4() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde4(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde5() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde5(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde6() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde6(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde7() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde7(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde8() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde8(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getOrde9() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getOrde9(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getEgeoOidEstrGeop() != null ? zonValorEstruGeopoData.getEgeoOidEstrGeop().getId() : null));
			row.add((zonValorEstruGeopoData.getPaisOidPais() != null ? zonValorEstruGeopoData.getPaisOidPais().getId() : null));
			row.add((zonValorEstruGeopoData.getFecActu() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getFecActu(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonValorEstruGeopoData.getSgeoOidSubeGeop() != null ? zonValorEstruGeopoData.getSgeoOidSubeGeop().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonValorEstruGeopoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
