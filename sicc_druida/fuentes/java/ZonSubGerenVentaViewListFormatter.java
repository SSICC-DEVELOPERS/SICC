
/*
    INDRA/CAR/mmg
    $Id: ZonSubGerenVentaViewListFormatter.java,v 1.1 2009/12/03 18:37:05 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonSubGerenVentaView" para Druida
 * 
 * @author Indra
 */
public class ZonSubGerenVentaViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonSubGerenVentaViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonSubGerenVentaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
			row.add((zonSubGerenVentaViewData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getCodSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getDesSubgVent() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getDesSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonSubGerenVentaViewData.getCanaOidCana() != null ? 
				FormatUtils.formatObject(zonSubGerenVentaViewData.getCanaOidCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonSubGerenVentaViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
