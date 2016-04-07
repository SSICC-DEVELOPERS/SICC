
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisViewFormFormatter.java,v 1.1 2009/12/03 18:34:49 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolicPaisView" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicPaisViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicPaisViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicPaisViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedTipoSolicPaisViewList.size(); i++) {
		
			PedTipoSolicPaisViewData pedTipoSolicPaisViewData = (PedTipoSolicPaisViewData) pedTipoSolicPaisViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoSolicPaisViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTipoSolicPaisViewData.getPaisOidPais() != null ? pedTipoSolicPaisViewData.getPaisOidPais().getId() : null));
			row.add((pedTipoSolicPaisViewData.getTsolOidTipoSoli() != null ? pedTipoSolicPaisViewData.getTsolOidTipoSoli().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTipoSolicPaisViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
