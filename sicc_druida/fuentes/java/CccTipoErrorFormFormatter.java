
/*
    INDRA/CAR/mmg
    $Id: CccTipoErrorFormFormatter.java,v 1.1 2009/12/03 18:37:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoError" para Druida
 * 
 * @author Indra
 */
public class CccTipoErrorFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoErrorFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoErrorList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccTipoErrorList.size(); i++) {
		
			CccTipoErrorData cccTipoErrorData = (CccTipoErrorData) cccTipoErrorList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = cccTipoErrorData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((cccTipoErrorData.getCodErro() != null ? 
				FormatUtils.formatObject(cccTipoErrorData.getCodErro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoErrorData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccTipoErrorData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccTipoErrorData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
