
/*
    INDRA/CAR/mmg
    $Id: PedUmbraFaltaFormFormatter.java,v 1.1 2009/12/03 18:42:33 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedUmbraFalta" para Druida
 * 
 * @author Indra
 */
public class PedUmbraFaltaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedUmbraFaltaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedUmbraFaltaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedUmbraFaltaList.size(); i++) {
		
			PedUmbraFaltaData pedUmbraFaltaData = (PedUmbraFaltaData) pedUmbraFaltaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedUmbraFaltaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedUmbraFaltaData.getPaisOidPais() != null ? pedUmbraFaltaData.getPaisOidPais().getId() : null));
			row.add((pedUmbraFaltaData.getNegoOidNego() != null ? pedUmbraFaltaData.getNegoOidNego().getId() : null));
			row.add((pedUmbraFaltaData.getValUmbrFalt() != null ? 
				FormatUtils.formatObject(pedUmbraFaltaData.getValUmbrFalt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedUmbraFaltaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
