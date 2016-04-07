
/*
    INDRA/CAR/mmg
    $Id: CccTipoTransViewFormFormatter.java,v 1.1 2009/12/03 18:42:11 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoTransView" para Druida
 * 
 * @author Indra
 */
public class CccTipoTransViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoTransViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoTransViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccTipoTransViewList.size(); i++) {
		
			CccTipoTransViewData cccTipoTransViewData = (CccTipoTransViewData) cccTipoTransViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccTipoTransViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccTipoTransViewData.getPaisOidPais() != null ? cccTipoTransViewData.getPaisOidPais().getId() : null));
			row.add((cccTipoTransViewData.getCodTipoTranCheq() != null ? 
				FormatUtils.formatObject(cccTipoTransViewData.getCodTipoTranCheq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoTransViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccTipoTransViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccTipoTransViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
