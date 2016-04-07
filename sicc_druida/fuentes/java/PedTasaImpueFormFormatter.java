
/*
    INDRA/CAR/mmg
    $Id: PedTasaImpueFormFormatter.java,v 1.1 2009/12/03 18:40:02 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTasaImpue" para Druida
 * 
 * @author Indra
 */
public class PedTasaImpueFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTasaImpueFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTasaImpueList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedTasaImpueList.size(); i++) {
		
			PedTasaImpueData pedTasaImpueData = (PedTasaImpueData) pedTasaImpueList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTasaImpueData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTasaImpueData.getValIndiImpu() != null ? 
				FormatUtils.formatObject(pedTasaImpueData.getValIndiImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTasaImpueData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTasaImpueData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTasaImpueData.getValTasaImpu() != null ? 
				FormatUtils.formatObject(pedTasaImpueData.getValTasaImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTasaImpueData.getPaisOidPais() != null ? pedTasaImpueData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTasaImpueData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
