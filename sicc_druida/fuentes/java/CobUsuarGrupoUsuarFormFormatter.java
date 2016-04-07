
/*
    INDRA/CAR/mmg
    $Id: CobUsuarGrupoUsuarFormFormatter.java,v 1.1 2009/12/03 18:41:36 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobUsuarGrupoUsuar" para Druida
 * 
 * @author Indra
 */
public class CobUsuarGrupoUsuarFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobUsuarGrupoUsuarFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobUsuarGrupoUsuarList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobUsuarGrupoUsuarList.size(); i++) {
		
			CobUsuarGrupoUsuarData cobUsuarGrupoUsuarData = (CobUsuarGrupoUsuarData) cobUsuarGrupoUsuarList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobUsuarGrupoUsuarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobUsuarGrupoUsuarData.getUscoOidUsuaCobr() != null ? cobUsuarGrupoUsuarData.getUscoOidUsuaCobr().getId() : null));
			row.add((cobUsuarGrupoUsuarData.getGucoOidGrupUsuaCobr() != null ? cobUsuarGrupoUsuarData.getGucoOidGrupUsuaCobr().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobUsuarGrupoUsuarData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
