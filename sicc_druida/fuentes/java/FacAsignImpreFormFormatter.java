
/*
    INDRA/CAR/mmg
    $Id: FacAsignImpreFormFormatter.java,v 1.1 2009/12/03 18:43:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacAsignImpre" para Druida
 * 
 * @author Indra
 */
public class FacAsignImpreFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacAsignImpreFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facAsignImpreList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facAsignImpreList.size(); i++) {
		
			FacAsignImpreData facAsignImpreData = (FacAsignImpreData) facAsignImpreList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facAsignImpreData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facAsignImpreData.getImviOidImpr() != null ? facAsignImpreData.getImviOidImpr().getId() : null));
			row.add((facAsignImpreData.getSbacOidSbac() != null ? facAsignImpreData.getSbacOidSbac().getId() : null));
			row.add((facAsignImpreData.getForsOidForm() != null ? facAsignImpreData.getForsOidForm().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facAsignImpreData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
