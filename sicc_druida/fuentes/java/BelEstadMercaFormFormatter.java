
/*
    INDRA/CAR/mmg
    $Id: BelEstadMercaFormFormatter.java,v 1.1 2009/12/03 18:40:17 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelEstadMerca" para Druida
 * 
 * @author Indra
 */
public class BelEstadMercaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelEstadMercaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belEstadMercaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belEstadMercaList.size(); i++) {
		
			BelEstadMercaData belEstadMercaData = (BelEstadMercaData) belEstadMercaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belEstadMercaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belEstadMercaData.getPaisOidPais() != null ? belEstadMercaData.getPaisOidPais().getId() : null));
			row.add((belEstadMercaData.getCodEsta() != null ? 
				FormatUtils.formatObject(belEstadMercaData.getCodEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belEstadMercaData.getDescripcion() != null ? 
				FormatUtils.formatObject(belEstadMercaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belEstadMercaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
