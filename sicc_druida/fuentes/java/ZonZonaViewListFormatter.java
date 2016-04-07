
/*
    INDRA/CAR/mmg
    $Id: ZonZonaViewListFormatter.java,v 1.1 2009/12/03 18:43:10 pecbazalar Exp $
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
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.utils.*;

/**
 * Clase de formateo de objetos "ZonZonaView" para Druida
 * 
 * @author Indra
 */
public class ZonZonaViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonZonaViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonZonaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
				symbols) : ""));
			row.add((zonZonaViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getIndRezo() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndRezo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getDesZona() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getDesZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getFecCambEsta() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getFecCambEsta(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((zonZonaViewData.getFecRezo() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getFecRezo(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((zonZonaViewData.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonZonaViewData.getCanaOidCana() != null ? 
				FormatUtils.formatObject(zonZonaViewData.getCanaOidCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonZonaViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
