
/*
    INDRA/CAR/mmg
    $Id: ZonRegioViewListFormatter.java,v 1.1 2009/12/03 18:38:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonRegioView" para Druida
 * 
 * @author Indra
 */
public class ZonRegioViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonRegioViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonRegioViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < zonRegioViewList.size(); i++) {
		
			ZonRegioViewData zonRegioViewData = (ZonRegioViewData) zonRegioViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonRegioViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonRegioViewData.getCodRegi() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getCodRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getIndActi() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getCodNse1() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getCodNse1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getCodNse2() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getCodNse2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getCodNse3() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getCodNse3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getDesRegi() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getDesRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioViewData.getZsgvOidSubgVent() != null ? 
				FormatUtils.formatObject(zonRegioViewData.getZsgvOidSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonRegioViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
