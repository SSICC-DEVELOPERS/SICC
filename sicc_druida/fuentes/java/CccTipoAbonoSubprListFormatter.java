
/*
    INDRA/CAR/mmg
    $Id: CccTipoAbonoSubprListFormatter.java,v 1.1 2009/12/03 18:38:46 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoAbonoSubpr" para Druida
 * 
 * @author Indra
 */
public class CccTipoAbonoSubprListFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoAbonoSubprListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoAbonoSubprList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < cccTipoAbonoSubprList.size(); i++) {
		
			CccTipoAbonoSubprData cccTipoAbonoSubprData = (CccTipoAbonoSubprData) cccTipoAbonoSubprList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = cccTipoAbonoSubprData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((cccTipoAbonoSubprData.getSubpOidSubp() != null ? 
				FormatUtils.formatObject(cccTipoAbonoSubprData.getSubpOidSubp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccTipoAbonoSubprData.getTcabOidTcab() != null ? 
				FormatUtils.formatObject(cccTipoAbonoSubprData.getTcabOidTcab(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((cccTipoAbonoSubprData.getCucoOidCuenCont() != null ? 
				FormatUtils.formatObject(cccTipoAbonoSubprData.getCucoOidCuenCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// A�adir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cccTipoAbonoSubprData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
