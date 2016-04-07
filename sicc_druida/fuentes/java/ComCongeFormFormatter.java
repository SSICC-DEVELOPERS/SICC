
/*
    INDRA/CAR/mmg
    $Id: ComCongeFormFormatter.java,v 1.1 2009/12/03 18:38:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "ComConge" para Druida
 * 
 * @author Indra
 */
public class ComCongeFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ComCongeFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector comCongeList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < comCongeList.size(); i++) {
		
			ComCongeData comCongeData = (ComCongeData) comCongeList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = comCongeData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((comCongeData.getCodCong() != null ? 
				FormatUtils.formatObject(comCongeData.getCodCong(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comCongeData.getFecDesd() != null ? 
				FormatUtils.formatObject(comCongeData.getFecDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comCongeData.getFecHast() != null ? 
				FormatUtils.formatObject(comCongeData.getFecHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comCongeData.getImpCong() != null ? 
				FormatUtils.formatObject(comCongeData.getImpCong(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comCongeData.getIndDescAuto() != null ? 
				FormatUtils.formatObject(comCongeData.getIndDescAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comCongeData.getClieOidClie() != null ? comCongeData.getClieOidClie().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(comCongeData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
