
/*
    INDRA/CAR/mmg
    $Id: CobMotivIncobFormFormatter.java,v 1.1 2009/12/03 18:33:11 pecbazalar Exp $
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

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "CobMotivIncob" para Druida
 * 
 * @author Indra
 */
public class CobMotivIncobFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobMotivIncobFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobMotivIncobList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobMotivIncobList.size(); i++) {
		
			CobMotivIncobData cobMotivIncobData = (CobMotivIncobData) cobMotivIncobList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobMotivIncobData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobMotivIncobData.getCodMotiCobr() != null ? 
				FormatUtils.formatObject(cobMotivIncobData.getCodMotiCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMotivIncobData.getValDescMotiCobr() != null ? 
				FormatUtils.formatObject(cobMotivIncobData.getValDescMotiCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobMotivIncobData.getPaisOidPais() != null ? cobMotivIncobData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobMotivIncobData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
