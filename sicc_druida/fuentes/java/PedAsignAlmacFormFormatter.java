
/*
    INDRA/CAR/mmg
    $Id: PedAsignAlmacFormFormatter.java,v 1.1 2009/12/03 18:36:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedAsignAlmac" para Druida
 * 
 * @author Indra
 */
public class PedAsignAlmacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedAsignAlmacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedAsignAlmacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedAsignAlmacList.size(); i++) {
		
			PedAsignAlmacData pedAsignAlmacData = (PedAsignAlmacData) pedAsignAlmacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedAsignAlmacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedAsignAlmacData.getPaisOidPais() != null ? pedAsignAlmacData.getPaisOidPais().getId() : null));
			row.add((pedAsignAlmacData.getMarcOidMarc() != null ? pedAsignAlmacData.getMarcOidMarc().getId() : null));
			row.add((pedAsignAlmacData.getSbacOidSbac() != null ? pedAsignAlmacData.getSbacOidSbac().getId() : null));
			row.add((pedAsignAlmacData.getAlmcOidAlma() != null ? pedAsignAlmacData.getAlmcOidAlma().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedAsignAlmacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
