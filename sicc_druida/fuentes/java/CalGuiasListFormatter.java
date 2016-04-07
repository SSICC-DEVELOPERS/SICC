
/*
    INDRA/CAR/mmg
    $Id: CalGuiasListFormatter.java,v 1.1 2009/12/03 18:42:34 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalGuias" para Druida
 * 
 * @author Indra
 */
public class CalGuiasListFormatter extends MMGDruidaFormatoObjeto {
	
	public CalGuiasListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calGuiasList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < calGuiasList.size(); i++) {
		
			CalGuiasData calGuiasData = (CalGuiasData) calGuiasList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = calGuiasData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((calGuiasData.getCodGuia() != null ? 
				FormatUtils.formatObject(calGuiasData.getCodGuia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((calGuiasData.getDpteOidDepa() != null ? 
				FormatUtils.formatObject(calGuiasData.getDpteOidDepa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((calGuiasData.getValTitu() != null ? 
				FormatUtils.formatObject(calGuiasData.getValTitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((calGuiasData.getFecInicVali() != null ? 
				FormatUtils.formatObject(calGuiasData.getFecInicVali(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((calGuiasData.getFecFinVali() != null ? 
				FormatUtils.formatObject(calGuiasData.getFecFinVali(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((calGuiasData.getValDescGuia() != null ? 
				FormatUtils.formatObject(calGuiasData.getValDescGuia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// A�adir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(calGuiasData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
