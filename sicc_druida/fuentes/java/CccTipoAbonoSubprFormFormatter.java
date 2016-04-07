
/*
    INDRA/CAR/mmg
    $Id: CccTipoAbonoSubprFormFormatter.java,v 1.1 2009/12/03 18:40:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoAbonoSubpr" para Druida
 * 
 * @author Indra
 */
public class CccTipoAbonoSubprFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoAbonoSubprFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoAbonoSubprList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccTipoAbonoSubprList.size(); i++) {
		
			CccTipoAbonoSubprData cccTipoAbonoSubprData = (CccTipoAbonoSubprData) cccTipoAbonoSubprList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccTipoAbonoSubprData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccTipoAbonoSubprData.getSubpOidSubp() != null ? cccTipoAbonoSubprData.getSubpOidSubp().getId() : null));
			row.add((cccTipoAbonoSubprData.getTcabOidTcab() != null ? cccTipoAbonoSubprData.getTcabOidTcab().getId() : null));
			row.add((cccTipoAbonoSubprData.getCucoOidCuenCont() != null ? cccTipoAbonoSubprData.getCucoOidCuenCont().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccTipoAbonoSubprData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
