
/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaTipoCargoFormFormatter.java,v 1.1 2009/12/03 18:42:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEtapaDeudaTipoCargo" para Druida
 * 
 * @author Indra
 */
public class CobEtapaDeudaTipoCargoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEtapaDeudaTipoCargoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEtapaDeudaTipoCargoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobEtapaDeudaTipoCargoList.size(); i++) {
		
			CobEtapaDeudaTipoCargoData cobEtapaDeudaTipoCargoData = (CobEtapaDeudaTipoCargoData) cobEtapaDeudaTipoCargoList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = cobEtapaDeudaTipoCargoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((cobEtapaDeudaTipoCargoData.getEtdeOidEtapDeud() != null ? cobEtapaDeudaTipoCargoData.getEtdeOidEtapDeud().getId() : null));
			row.add((cobEtapaDeudaTipoCargoData.getTcabOidTipoCargAbon() != null ? cobEtapaDeudaTipoCargoData.getTcabOidTipoCargAbon().getId() : null));
			row.add((cobEtapaDeudaTipoCargoData.getValDesc() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaTipoCargoData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobEtapaDeudaTipoCargoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
