
/*
    INDRA/CAR/mmg
    $Id: PedImpueGenerFormFormatter.java,v 1.1 2009/12/03 18:33:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedImpueGener" para Druida
 * 
 * @author Indra
 */
public class PedImpueGenerFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedImpueGenerFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedImpueGenerList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedImpueGenerList.size(); i++) {
		
			PedImpueGenerData pedImpueGenerData = (PedImpueGenerData) pedImpueGenerList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedImpueGenerData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedImpueGenerData.getPaisOidPais() != null ? pedImpueGenerData.getPaisOidPais().getId() : null));
			row.add((pedImpueGenerData.getSbacOidSbac() != null ? pedImpueGenerData.getSbacOidSbac().getId() : null));
			row.add((pedImpueGenerData.getTaimOidTasaImpu() != null ? pedImpueGenerData.getTaimOidTasaImpu().getId() : null));
			row.add((pedImpueGenerData.getTaimOidTasaImpuFlet() != null ? pedImpueGenerData.getTaimOidTasaImpuFlet().getId() : null));
			row.add((pedImpueGenerData.getIndTasaUnic() != null ? 
				FormatUtils.formatObject(pedImpueGenerData.getIndTasaUnic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedImpueGenerData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
