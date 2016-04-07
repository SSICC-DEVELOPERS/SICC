
/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuDetalFormFormatter.java,v 1.1 2009/12/03 18:40:28 pecbazalar Exp $
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
 * Clase de formateo de objetos "IncPartiConcuDetal" para Druida
 * 
 * @author Indra
 */
public class IncPartiConcuDetalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IncPartiConcuDetalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector incPartiConcuDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < incPartiConcuDetalList.size(); i++) {
		
			IncPartiConcuDetalData incPartiConcuDetalData = (IncPartiConcuDetalData) incPartiConcuDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = incPartiConcuDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((incPartiConcuDetalData.getPaciOidPartConcCabe() != null ? incPartiConcuDetalData.getPaciOidPartConcCabe().getId() : null));
			row.add((incPartiConcuDetalData.getTiclOidTipoClie() != null ? incPartiConcuDetalData.getTiclOidTipoClie().getId() : null));
			row.add((incPartiConcuDetalData.getSbtiOidSubtClie() != null ? incPartiConcuDetalData.getSbtiOidSubtClie().getId() : null));
			row.add((incPartiConcuDetalData.getTcclOidTipoClas() != null ? incPartiConcuDetalData.getTcclOidTipoClas().getId() : null));
			row.add((incPartiConcuDetalData.getClasOidClas() != null ? incPartiConcuDetalData.getClasOidClas().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(incPartiConcuDetalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
