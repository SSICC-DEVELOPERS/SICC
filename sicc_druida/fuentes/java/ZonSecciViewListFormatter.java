
/*
    INDRA/CAR/mmg
    $Id: ZonSecciViewListFormatter.java,v 1.1 2009/12/03 18:35:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonSecciView" para Druida
 * 
 * @author Indra
 */
public class ZonSecciViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonSecciViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonSecciViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < zonSecciViewList.size(); i++) {
		
			ZonSecciViewData zonSecciViewData = (ZonSecciViewData) zonSecciViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonSecciViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonSecciViewData.getCodSecc() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getCodSecc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getDesSecci() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getDesSecci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSecciViewData.getZzonOidZona() != null ? 
				FormatUtils.formatObject(zonSecciViewData.getZzonOidZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonSecciViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
