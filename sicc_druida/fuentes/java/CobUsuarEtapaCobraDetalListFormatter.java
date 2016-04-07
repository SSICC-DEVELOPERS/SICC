
/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraDetalListFormatter.java,v 1.1 2009/12/03 18:41:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobUsuarEtapaCobraDetal" para Druida
 * 
 * @author Indra
 */
public class CobUsuarEtapaCobraDetalListFormatter extends MMGDruidaFormatoObjeto {
	
	public CobUsuarEtapaCobraDetalListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobUsuarEtapaCobraDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cobUsuarEtapaCobraDetalList.size(); i++) {
		
			CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalData = (CobUsuarEtapaCobraDetalData) cobUsuarEtapaCobraDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobUsuarEtapaCobraDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobUsuarEtapaCobraDetalData.getUeccOidUsuaEtapCobr() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getUeccOidUsuaEtapCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getEdtcOidEtapDeudTipoCarg() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getEdtcOidEtapDeudTipoCarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getZsgvOidSubgVent() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getZsgvOidSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getZorgOidRegi() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getZorgOidRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getZzonOidZona() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getZzonOidZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getZsccOidSecc() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getZsccOidSecc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getTerrOidTerr() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getTerrOidTerr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getMelcOidMetoLiquCobr() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getMelcOidMetoLiquCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getEucoOidEstaUsuaEtapCobr() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getEucoOidEstaUsuaEtapCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getGacaOidGuioArguCabe() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getGacaOidGuioArguCabe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobUsuarEtapaCobraDetalData.getValObse() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cobUsuarEtapaCobraDetalData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
