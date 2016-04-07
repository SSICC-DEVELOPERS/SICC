
/*
    INDRA/CAR/mmg
    $Id: CraPerioListFormatter.java,v 1.1 2009/12/03 18:34:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "CraPerio" para Druida
 * 
 * @author Indra
 */
public class CraPerioListFormatter extends MMGDruidaFormatoObjeto {
	
	public CraPerioListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector craPerioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < craPerioList.size(); i++) {
		
			CraPerioData craPerioData = (CraPerioData) craPerioList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = craPerioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((craPerioData.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(craPerioData.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getCanaOidCana() != null ? 
				FormatUtils.formatObject(craPerioData.getCanaOidCana(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(craPerioData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getAcceOidAcce() != null ? 
				FormatUtils.formatObject(craPerioData.getAcceOidAcce(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getPeriOidPeri() != null ? 
				FormatUtils.formatObject(craPerioData.getPeriOidPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getFecInic() != null ? 
				FormatUtils.formatObject(craPerioData.getFecInic(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((craPerioData.getFecFina() != null ? 
				FormatUtils.formatObject(craPerioData.getFecFina(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((craPerioData.getValEsta() != null ? 
				FormatUtils.formatObject(craPerioData.getValEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getValNombPeri() != null ? 
				FormatUtils.formatObject(craPerioData.getValNombPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getIndPeriCort() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((craPerioData.getIndPeriCruc() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCruc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(craPerioData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
