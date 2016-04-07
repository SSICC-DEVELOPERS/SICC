
/*
    INDRA/CAR/mmg
    $Id: SegVincuJerarListFormatter.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegVincuJerar" para Druida
 * 
 * @author Indra
 */
public class SegVincuJerarListFormatter extends MMGDruidaFormatoObjeto {
	
	public SegVincuJerarListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segVincuJerarList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < segVincuJerarList.size(); i++) {
		
			SegVincuJerarData segVincuJerarData = (SegVincuJerarData) segVincuJerarList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = segVincuJerarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((segVincuJerarData.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(segVincuJerarData.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((segVincuJerarData.getCanaOidCana() != null ? 
				FormatUtils.formatObject(segVincuJerarData.getCanaOidCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((segVincuJerarData.getAcceOidAcce() != null ? 
				FormatUtils.formatObject(segVincuJerarData.getAcceOidAcce(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((segVincuJerarData.getSbacOidSbac() != null ? 
				FormatUtils.formatObject(segVincuJerarData.getSbacOidSbac(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((segVincuJerarData.getSociOidSoci() != null ? 
				FormatUtils.formatObject(segVincuJerarData.getSociOidSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// A�adir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(segVincuJerarData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
