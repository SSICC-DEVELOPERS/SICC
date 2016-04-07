
/*
    INDRA/CAR/mmg
    $Id: SegTipoViaFormFormatter.java,v 1.1 2009/12/03 18:33:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegTipoVia" para Druida
 * 
 * @author Indra
 */
public class SegTipoViaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegTipoViaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segTipoViaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segTipoViaList.size(); i++) {
		
			SegTipoViaData segTipoViaData = (SegTipoViaData) segTipoViaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segTipoViaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segTipoViaData.getCodTipoVia() != null ? 
				FormatUtils.formatObject(segTipoViaData.getCodTipoVia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoViaData.getDesAbrvTipoVia() != null ? 
				FormatUtils.formatObject(segTipoViaData.getDesAbrvTipoVia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoViaData.getDescripcion() != null ? 
				FormatUtils.formatObject(segTipoViaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segTipoViaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
