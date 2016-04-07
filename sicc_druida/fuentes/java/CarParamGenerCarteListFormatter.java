
/*
    INDRA/CAR/mmg
    $Id: CarParamGenerCarteListFormatter.java,v 1.1 2009/12/03 18:41:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamGenerCarte" para Druida
 * 
 * @author Indra
 */
public class CarParamGenerCarteListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamGenerCarteListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamGenerCarteList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < carParamGenerCarteList.size(); i++) {
		
			CarParamGenerCarteData carParamGenerCarteData = (CarParamGenerCarteData) carParamGenerCarteList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamGenerCarteData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamGenerCarteData.getNireOidNiveRedo() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getNireOidNiveRedo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((carParamGenerCarteData.getNumPeriNuev() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getNumPeriNuev(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((carParamGenerCarteData.getNumPeriAnti() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getNumPeriAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((carParamGenerCarteData.getInijOidIndiNiveJera() != null ? 
				FormatUtils.formatObject(carParamGenerCarteData.getInijOidIndiNiveJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carParamGenerCarteData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
