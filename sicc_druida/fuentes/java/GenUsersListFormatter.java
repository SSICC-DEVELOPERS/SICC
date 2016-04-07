
/*
    INDRA/CAR/mmg
    $Id: GenUsersListFormatter.java,v 1.1 2009/12/03 18:43:27 pecbazalar Exp $
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
 * Clase de formateo de objetos "GenUsers" para Druida
 * 
 * @author Indra
 */
public class GenUsersListFormatter extends MMGDruidaFormatoObjeto {
	
	public GenUsersListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector genUsersList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < genUsersList.size(); i++) {
		
			GenUsersData genUsersData = (GenUsersData) genUsersList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = genUsersData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((genUsersData.getMyid() != null ? 
				FormatUtils.formatObject(genUsersData.getMyid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genUsersData.getCredential() != null ? 
				FormatUtils.formatObject(genUsersData.getCredential(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genUsersData.getSetdate() != null ? 
				FormatUtils.formatObject(genUsersData.getSetdate(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((genUsersData.getRetries() != null ? 
				FormatUtils.formatObject(genUsersData.getRetries(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((genUsersData.getBlocked() != null ? 
				FormatUtils.formatObject(genUsersData.getBlocked(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(genUsersData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
