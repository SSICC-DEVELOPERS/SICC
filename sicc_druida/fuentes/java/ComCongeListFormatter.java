
/*
    INDRA/CAR/mmg
    $Id: ComCongeListFormatter.java,v 1.1 2009/12/03 18:41:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "ComConge" para Druida
 * 
 * @author Indra
 */
public class ComCongeListFormatter extends MMGDruidaFormatoObjeto {
	
	public ComCongeListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector comCongeList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < comCongeList.size(); i++) {
		
			ComCongeData comCongeData = (ComCongeData) comCongeList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = comCongeData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((comCongeData.getFecDesd() != null ? 
				FormatUtils.formatObject(comCongeData.getFecDesd(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((comCongeData.getFecHast() != null ? 
				FormatUtils.formatObject(comCongeData.getFecHast(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((comCongeData.getImpCong() != null ? 
				FormatUtils.formatObject(comCongeData.getImpCong(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((comCongeData.getIndDescAuto() != null ? 
				FormatUtils.formatObject(comCongeData.getIndDescAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((comCongeData.getClieOidClie() != null ? 
				FormatUtils.formatObject(comCongeData.getClieOidClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(comCongeData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
