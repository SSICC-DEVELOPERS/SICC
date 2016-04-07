
/*
    INDRA/CAR/mmg
    $Id: GenDetaSiccListFormatter.java,v 1.1 2009/12/03 18:33:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenDetaSicc" para Druida
 * 
 * @author Indra
 */
public class GenDetaSiccListFormatter extends MMGDruidaFormatoObjeto {
	
	public GenDetaSiccListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genDetaSiccList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < genDetaSiccList.size(); i++) {
		
			GenDetaSiccData genDetaSiccData = (GenDetaSiccData) genDetaSiccList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genDetaSiccData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genDetaSiccData.getEnti() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getEnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccData.getEntiPk() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getEntiPk(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccData.getAtri() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccData.getDeta() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genDetaSiccData.getIdioOidIdio() != null ? 
				FormatUtils.formatObject(genDetaSiccData.getIdioOidIdio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(genDetaSiccData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
