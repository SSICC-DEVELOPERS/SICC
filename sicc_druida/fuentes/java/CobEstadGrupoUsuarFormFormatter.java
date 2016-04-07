
/*
    INDRA/CAR/mmg
    $Id: CobEstadGrupoUsuarFormFormatter.java,v 1.1 2009/12/03 18:40:53 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEstadGrupoUsuar" para Druida
 * 
 * @author Indra
 */
public class CobEstadGrupoUsuarFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEstadGrupoUsuarFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEstadGrupoUsuarList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobEstadGrupoUsuarList.size(); i++) {
		
			CobEstadGrupoUsuarData cobEstadGrupoUsuarData = (CobEstadGrupoUsuarData) cobEstadGrupoUsuarList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEstadGrupoUsuarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEstadGrupoUsuarData.getCodEstaGrupUsua() != null ? 
				FormatUtils.formatObject(cobEstadGrupoUsuarData.getCodEstaGrupUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEstadGrupoUsuarData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobEstadGrupoUsuarData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobEstadGrupoUsuarData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
