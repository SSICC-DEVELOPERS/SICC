
/*
    INDRA/CAR/mmg
    $Id: CalMotivTipoClienFormFormatter.java,v 1.1 2009/12/03 18:38:48 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalMotivTipoClien" para Druida
 * 
 * @author Indra
 */
public class CalMotivTipoClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalMotivTipoClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calMotivTipoClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calMotivTipoClienList.size(); i++) {
		
			CalMotivTipoClienData calMotivTipoClienData = (CalMotivTipoClienData) calMotivTipoClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calMotivTipoClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((calMotivTipoClienData.getMocoOidMotiCont() != null ? calMotivTipoClienData.getMocoOidMotiCont().getId() : null));
			row.add((calMotivTipoClienData.getTiclOidTipoClie() != null ? calMotivTipoClienData.getTiclOidTipoClie().getId() : null));
			row.add((calMotivTipoClienData.getPaisOidPais() != null ? calMotivTipoClienData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calMotivTipoClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
