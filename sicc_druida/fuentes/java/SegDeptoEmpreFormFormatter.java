
/*
    INDRA/CAR/mmg
    $Id: SegDeptoEmpreFormFormatter.java,v 1.1 2009/12/03 18:41:12 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegDeptoEmpre" para Druida
 * 
 * @author Indra
 */
public class SegDeptoEmpreFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegDeptoEmpreFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segDeptoEmpreList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segDeptoEmpreList.size(); i++) {
		
			SegDeptoEmpreData segDeptoEmpreData = (SegDeptoEmpreData) segDeptoEmpreList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segDeptoEmpreData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segDeptoEmpreData.getCodDpto() != null ? 
				FormatUtils.formatObject(segDeptoEmpreData.getCodDpto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segDeptoEmpreData.getDesCortDpto() != null ? 
				FormatUtils.formatObject(segDeptoEmpreData.getDesCortDpto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segDeptoEmpreData.getDescripcion() != null ? 
				FormatUtils.formatObject(segDeptoEmpreData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segDeptoEmpreData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
