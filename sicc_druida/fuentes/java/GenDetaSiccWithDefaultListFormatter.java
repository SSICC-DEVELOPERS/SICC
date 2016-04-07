
/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccWithDefaultListFormatter.java,v 1.1 2009/12/03 18:32:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenDetaSiccWithDefault" para Druida
 * 
 * @author Indra
 */
public class GenDetaSiccWithDefaultListFormatter extends MMGDruidaFormatoObjeto {
	
	public GenDetaSiccWithDefaultListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genDetaSiccWithDefaultList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < genDetaSiccWithDefaultList.size(); i++) {
		
			GenDetaSiccWithDefaultData genDetaSiccWithDefaultData = (GenDetaSiccWithDefaultData) genDetaSiccWithDefaultList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genDetaSiccWithDefaultData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genDetaSiccWithDefaultData.getEnti() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getEnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccWithDefaultData.getEntiPk() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getEntiPk(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccWithDefaultData.getAtri() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccWithDefaultData.getDeta() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccWithDefaultData.getIdioOidIdio() != null ? 
				FormatUtils.formatObject(genDetaSiccWithDefaultData.getIdioOidIdio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(genDetaSiccWithDefaultData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
