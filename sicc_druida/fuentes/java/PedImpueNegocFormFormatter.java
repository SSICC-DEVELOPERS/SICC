
/*
    INDRA/CAR/mmg
    $Id: PedImpueNegocFormFormatter.java,v 1.1 2009/12/03 18:37:12 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedImpueNegoc" para Druida
 * 
 * @author Indra
 */
public class PedImpueNegocFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedImpueNegocFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedImpueNegocList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedImpueNegocList.size(); i++) {
		
			PedImpueNegocData pedImpueNegocData = (PedImpueNegocData) pedImpueNegocList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedImpueNegocData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedImpueNegocData.getPaisOidPais() != null ? pedImpueNegocData.getPaisOidPais().getId() : null));
			row.add((pedImpueNegocData.getSbacOidSbac() != null ? pedImpueNegocData.getSbacOidSbac().getId() : null));
			row.add((pedImpueNegocData.getNegoOidNego() != null ? pedImpueNegocData.getNegoOidNego().getId() : null));
			row.add((pedImpueNegocData.getTaimOidTasaImpu() != null ? pedImpueNegocData.getTaimOidTasaImpu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedImpueNegocData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
