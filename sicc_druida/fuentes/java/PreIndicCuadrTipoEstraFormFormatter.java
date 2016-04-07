
/*
    INDRA/CAR/mmg
    $Id: PreIndicCuadrTipoEstraFormFormatter.java,v 1.1 2009/12/03 18:37:46 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreIndicCuadrTipoEstra" para Druida
 * 
 * @author Indra
 */
public class PreIndicCuadrTipoEstraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreIndicCuadrTipoEstraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preIndicCuadrTipoEstraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preIndicCuadrTipoEstraList.size(); i++) {
		
			PreIndicCuadrTipoEstraData preIndicCuadrTipoEstraData = (PreIndicCuadrTipoEstraData) preIndicCuadrTipoEstraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preIndicCuadrTipoEstraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preIndicCuadrTipoEstraData.getIndcOidIndiCuad() != null ? preIndicCuadrTipoEstraData.getIndcOidIndiCuad().getId() : null));
			row.add((preIndicCuadrTipoEstraData.getTiesOidTipoEstr() != null ? preIndicCuadrTipoEstraData.getTiesOidTipoEstr().getId() : null));
			row.add((preIndicCuadrTipoEstraData.getIndOferMonoGrup() != null ? 
				FormatUtils.formatObject(preIndicCuadrTipoEstraData.getIndOferMonoGrup(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preIndicCuadrTipoEstraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
