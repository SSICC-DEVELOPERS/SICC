
/*
    INDRA/CAR/mmg
    $Id: ZonEstruGeopoListFormatter.java,v 1.1 2009/12/03 18:36:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonEstruGeopo" para Druida
 * 
 * @author Indra
 */
public class ZonEstruGeopoListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonEstruGeopoListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonEstruGeopoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < zonEstruGeopoList.size(); i++) {
		
			ZonEstruGeopoData zonEstruGeopoData = (ZonEstruGeopoData) zonEstruGeopoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonEstruGeopoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonEstruGeopoData.getCodOrde() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getCodOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonEstruGeopoData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonEstruGeopoData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonEstruGeopoData.getDipoOidDiviPoli() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getDipoOidDiviPoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((zonEstruGeopoData.getFecActu() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getFecActu(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonEstruGeopoData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
