
/*
    INDRA/CAR/mmg
    $Id: SegVincuJerarFormFormatter.java,v 1.1 2009/12/03 18:38:21 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegVincuJerar" para Druida
 * 
 * @author Indra
 */
public class SegVincuJerarFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegVincuJerarFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segVincuJerarList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segVincuJerarList.size(); i++) {
		
			SegVincuJerarData segVincuJerarData = (SegVincuJerarData) segVincuJerarList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segVincuJerarData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segVincuJerarData.getMarcOidMarc() != null ? segVincuJerarData.getMarcOidMarc().getId() : null));
			row.add((segVincuJerarData.getCanaOidCana() != null ? segVincuJerarData.getCanaOidCana().getId() : null));
			row.add((segVincuJerarData.getAcceOidAcce() != null ? segVincuJerarData.getAcceOidAcce().getId() : null));
			row.add((segVincuJerarData.getSbacOidSbac() != null ? segVincuJerarData.getSbacOidSbac().getId() : null));
			row.add((segVincuJerarData.getPaisOidPais() != null ? segVincuJerarData.getPaisOidPais().getId() : null));
			row.add((segVincuJerarData.getSociOidSoci() != null ? segVincuJerarData.getSociOidSoci().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segVincuJerarData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
