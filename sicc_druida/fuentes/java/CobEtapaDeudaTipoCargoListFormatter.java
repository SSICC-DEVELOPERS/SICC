
/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaTipoCargoListFormatter.java,v 1.1 2009/12/03 18:38:21 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEtapaDeudaTipoCargo" para Druida
 * 
 * @author Indra
 */
public class CobEtapaDeudaTipoCargoListFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEtapaDeudaTipoCargoListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEtapaDeudaTipoCargoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cobEtapaDeudaTipoCargoList.size(); i++) {
		
			CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoData = (CobEtapaDeudaTipoCargoData) cobEtapaDeudaTipoCargoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEtapaDeudaTipoCargoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEtapaDeudaTipoCargoData.getEtdeOidEtapDeud() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaTipoCargoData.getEtdeOidEtapDeud(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEtapaDeudaTipoCargoData.getTcabOidTipoCargAbon() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaTipoCargoData.getTcabOidTipoCargAbon(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cobEtapaDeudaTipoCargoData.getValDesc() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaTipoCargoData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cobEtapaDeudaTipoCargoData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
