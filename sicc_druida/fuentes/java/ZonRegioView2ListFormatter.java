
/*
    INDRA/CAR/mmg
    $Id: ZonRegioView2ListFormatter.java,v 1.1 2009/12/03 18:41:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonRegioView2" para Druida
 * 
 * @author Indra
 */
public class ZonRegioView2ListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonRegioView2ListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonRegioView2List = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < zonRegioView2List.size(); i++) {
		
			ZonRegioView2Data zonRegioView2Data = (ZonRegioView2Data) zonRegioView2List.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonRegioView2Data.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonRegioView2Data.getCodRegi() != null ? 
				FormatUtils.formatObject(zonRegioView2Data.getCodRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioView2Data.getCanaOidCana() != null ? 
				FormatUtils.formatObject(zonRegioView2Data.getCanaOidCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonRegioView2Data.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(zonRegioView2Data.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonRegioView2Data.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
