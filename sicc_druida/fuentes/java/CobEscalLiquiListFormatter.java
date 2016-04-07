
/*
    INDRA/CAR/mmg
    $Id: CobEscalLiquiListFormatter.java,v 1.1 2009/12/03 18:43:24 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEscalLiqui" para Druida
 * 
 * @author Indra
 */
public class CobEscalLiquiListFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEscalLiquiListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEscalLiquiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cobEscalLiquiList.size(); i++) {
		
			CobEscalLiquiData cobEscalLiquiData = (CobEscalLiquiData) cobEscalLiquiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEscalLiquiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEscalLiquiData.getNumOrdeEsca() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getNumOrdeEsca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getImpRangDesdImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpRangDesdImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getImpRangHastImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpRangHastImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getValRangDesdPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValRangDesdPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getValRangHastPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValRangHastPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getImpComiPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpComiPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getImpComiImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpComiImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getValObse() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEscalLiquiData.getMelcOidMetoLiquCobr() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getMelcOidMetoLiquCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cobEscalLiquiData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
