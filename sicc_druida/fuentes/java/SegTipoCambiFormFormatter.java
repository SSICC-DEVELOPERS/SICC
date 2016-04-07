
/*
    INDRA/CAR/mmg
    $Id: SegTipoCambiFormFormatter.java,v 1.1 2009/12/03 18:38:13 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegTipoCambi" para Druida
 * 
 * @author Indra
 */
public class SegTipoCambiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegTipoCambiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segTipoCambiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segTipoCambiList.size(); i++) {
		
			SegTipoCambiData segTipoCambiData = (SegTipoCambiData) segTipoCambiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segTipoCambiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segTipoCambiData.getMoneOidMon1() != null ? segTipoCambiData.getMoneOidMon1().getId() : null));
			row.add((segTipoCambiData.getMoneOidMon2() != null ? segTipoCambiData.getMoneOidMon2().getId() : null));
			row.add((segTipoCambiData.getFecDesd() != null ? 
				FormatUtils.formatObject(segTipoCambiData.getFecDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoCambiData.getValTipoCamb() != null ? 
				FormatUtils.formatObject(segTipoCambiData.getValTipoCamb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoCambiData.getFecHast() != null ? 
				FormatUtils.formatObject(segTipoCambiData.getFecHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segTipoCambiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
