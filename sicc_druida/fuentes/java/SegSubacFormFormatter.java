
/*
    INDRA/CAR/mmg
    $Id: SegSubacFormFormatter.java,v 1.1 2009/12/03 18:43:35 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegSubac" para Druida
 * 
 * @author Indra
 */
public class SegSubacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegSubacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segSubacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segSubacList.size(); i++) {
		
			SegSubacData segSubacData = (SegSubacData) segSubacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segSubacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segSubacData.getAcceOidAcce() != null ? segSubacData.getAcceOidAcce().getId() : null));
			row.add((segSubacData.getCodSbac() != null ? 
				FormatUtils.formatObject(segSubacData.getCodSbac(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSubacData.getDescripcion() != null ? 
				FormatUtils.formatObject(segSubacData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segSubacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
