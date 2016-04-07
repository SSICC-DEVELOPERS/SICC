
/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaListFormatter.java,v 1.1 2009/12/03 18:38:13 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentCorriBanca" para Druida
 * 
 * @author Indra
 */
public class CccCuentCorriBancaListFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentCorriBancaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentCorriBancaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cccCuentCorriBancaList.size(); i++) {
		
			CccCuentCorriBancaData cccCuentCorriBancaData = (CccCuentCorriBancaData) cccCuentCorriBancaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentCorriBancaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccCuentCorriBancaData.getCodCc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCodCc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getSociOidSoci() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getSociOidSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getDesCc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getDesCc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getCucoOidCcTeso() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCucoOidCcTeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getCucoOidCcPnte() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCucoOidCcPnte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getCodCcBanc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCodCcBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccCuentCorriBancaData.getSucuOidSucu() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getSucuOidSucu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cccCuentCorriBancaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
