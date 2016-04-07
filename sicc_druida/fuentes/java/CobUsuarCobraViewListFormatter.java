
/*
    INDRA/CAR/mmg
    $Id: CobUsuarCobraViewListFormatter.java,v 1.1 2009/12/03 18:41:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobUsuarCobraView" para Druida
 * 
 * @author Indra
 */
public class CobUsuarCobraViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public CobUsuarCobraViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobUsuarCobraViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cobUsuarCobraViewList.size(); i++) {
		
			CobUsuarCobraViewData cobUsuarCobraViewData = (CobUsuarCobraViewData) cobUsuarCobraViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobUsuarCobraViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobUsuarCobraViewData.getFecUltiEsta() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getFecUltiEsta(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getIndJefeCobr() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndJefeCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getIndUsuaSupe() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndUsuaSupe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getIndUsuaExte() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndUsuaExte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getValTurnHoraEntr() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValTurnHoraEntr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getValTurnHoraSali() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValTurnHoraSali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getValObse() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getUserOidUsuaCobr() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getUserOidUsuaCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarCobraViewData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cobUsuarCobraViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
