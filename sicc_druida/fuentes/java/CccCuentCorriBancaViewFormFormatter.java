
/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaViewFormFormatter.java,v 1.1 2009/12/03 18:39:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentCorriBancaView" para Druida
 * 
 * @author Indra
 */
public class CccCuentCorriBancaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentCorriBancaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentCorriBancaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccCuentCorriBancaViewList.size(); i++) {
		
			CccCuentCorriBancaViewData cccCuentCorriBancaViewData = (CccCuentCorriBancaViewData) cccCuentCorriBancaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentCorriBancaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccCuentCorriBancaViewData.getSociOidSoci() != null ? cccCuentCorriBancaViewData.getSociOidSoci().getId() : null));
			row.add((cccCuentCorriBancaViewData.getDesCc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaViewData.getDesCc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaViewData.getPaisOidPais() != null ? cccCuentCorriBancaViewData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccCuentCorriBancaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
