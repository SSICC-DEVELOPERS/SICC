
/*
    INDRA/CAR/mmg
    $Id: SegMarcaProduFormFormatter.java,v 1.1 2009/12/03 18:36:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegMarcaProdu" para Druida
 * 
 * @author Indra
 */
public class SegMarcaProduFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegMarcaProduFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segMarcaProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segMarcaProduList.size(); i++) {
		
			SegMarcaProduData segMarcaProduData = (SegMarcaProduData) segMarcaProduList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segMarcaProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segMarcaProduData.getCodMarcProd() != null ? 
				FormatUtils.formatObject(segMarcaProduData.getCodMarcProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segMarcaProduData.getDesMarcProd() != null ? 
				FormatUtils.formatObject(segMarcaProduData.getDesMarcProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segMarcaProduData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
