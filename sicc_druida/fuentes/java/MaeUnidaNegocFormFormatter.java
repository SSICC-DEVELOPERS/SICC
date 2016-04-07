
/*
    INDRA/CAR/mmg
    $Id: MaeUnidaNegocFormFormatter.java,v 1.1 2009/12/03 18:43:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeUnidaNegoc" para Druida
 * 
 * @author Indra
 */
public class MaeUnidaNegocFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeUnidaNegocFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeUnidaNegocList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeUnidaNegocList.size(); i++) {
		
			MaeUnidaNegocData maeUnidaNegocData = (MaeUnidaNegocData) maeUnidaNegocList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = maeUnidaNegocData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((maeUnidaNegocData.getPaisOidPais() != null ? maeUnidaNegocData.getPaisOidPais().getId() : null));
			row.add((maeUnidaNegocData.getCodUnidNego() != null ? 
				FormatUtils.formatObject(maeUnidaNegocData.getCodUnidNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeUnidaNegocData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeUnidaNegocData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeUnidaNegocData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
