
/*
    INDRA/CAR/mmg
    $Id: BelAlmacFormFormatter.java,v 1.1 2009/12/03 18:32:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelAlmac" para Druida
 * 
 * @author Indra
 */
public class BelAlmacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelAlmacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belAlmacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belAlmacList.size(); i++) {
		
			BelAlmacData belAlmacData = (BelAlmacData) belAlmacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belAlmacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belAlmacData.getPaisOidPais() != null ? belAlmacData.getPaisOidPais().getId() : null));
			row.add((belAlmacData.getCodAlma() != null ? 
				FormatUtils.formatObject(belAlmacData.getCodAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belAlmacData.getDescripcion() != null ? 
				FormatUtils.formatObject(belAlmacData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belAlmacData.getIndInfoSap() != null ? 
				FormatUtils.formatObject(belAlmacData.getIndInfoSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belAlmacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
