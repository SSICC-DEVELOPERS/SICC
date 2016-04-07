
/*
    INDRA/CAR/mmg
    $Id: MaeCriteBusquFormFormatter.java,v 1.1 2009/12/03 18:32:20 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeCriteBusqu" para Druida
 * 
 * @author Indra
 */
public class MaeCriteBusquFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeCriteBusquFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeCriteBusquList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeCriteBusquList.size(); i++) {
		
			MaeCriteBusquData maeCriteBusquData = (MaeCriteBusquData) maeCriteBusquList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeCriteBusquData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeCriteBusquData.getPaisOidPais() != null ? maeCriteBusquData.getPaisOidPais().getId() : null));
			row.add((maeCriteBusquData.getAtreOidAtriEsp1() != null ? maeCriteBusquData.getAtreOidAtriEsp1().getId() : null));
			row.add((maeCriteBusquData.getAtreOidAtriEsp2() != null ? maeCriteBusquData.getAtreOidAtriEsp2().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeCriteBusquData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
