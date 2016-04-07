
/*
    INDRA/CAR/mmg
    $Id: SegMarcaFormFormatter.java,v 1.1 2009/12/03 18:35:33 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegMarca" para Druida
 * 
 * @author Indra
 */
public class SegMarcaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegMarcaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segMarcaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segMarcaList.size(); i++) {
		
			SegMarcaData segMarcaData = (SegMarcaData) segMarcaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segMarcaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segMarcaData.getCodMarc() != null ? 
				FormatUtils.formatObject(segMarcaData.getCodMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMarcaData.getDesMarc() != null ? 
				FormatUtils.formatObject(segMarcaData.getDesMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segMarcaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
