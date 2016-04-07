
/*
    INDRA/CAR/mmg
    $Id: CarAsignEjecuCuentFormFormatter.java,v 1.1 2009/12/03 18:34:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarAsignEjecuCuent" para Druida
 * 
 * @author Indra
 */
public class CarAsignEjecuCuentFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarAsignEjecuCuentFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carAsignEjecuCuentList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carAsignEjecuCuentList.size(); i++) {
		
			CarAsignEjecuCuentData carAsignEjecuCuentData = (CarAsignEjecuCuentData) carAsignEjecuCuentList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carAsignEjecuCuentData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carAsignEjecuCuentData.getNiriOidNiveRies() != null ? carAsignEjecuCuentData.getNiriOidNiveRies().getId() : null));
			row.add((carAsignEjecuCuentData.getZsgvOidSubgVent() != null ? carAsignEjecuCuentData.getZsgvOidSubgVent().getId() : null));
			row.add((carAsignEjecuCuentData.getZorgOidRegi() != null ? carAsignEjecuCuentData.getZorgOidRegi().getId() : null));
			row.add((carAsignEjecuCuentData.getZzonOidZona() != null ? carAsignEjecuCuentData.getZzonOidZona().getId() : null));
			row.add((carAsignEjecuCuentData.getEjcuOidEjecCuen() != null ? carAsignEjecuCuentData.getEjcuOidEjecCuen().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carAsignEjecuCuentData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
