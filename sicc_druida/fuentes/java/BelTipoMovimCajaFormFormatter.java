
/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimCajaFormFormatter.java,v 1.1 2009/12/03 18:42:59 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMovimCaja" para Druida
 * 
 * @author Indra
 */
public class BelTipoMovimCajaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMovimCajaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMovimCajaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belTipoMovimCajaList.size(); i++) {
		
			BelTipoMovimCajaData belTipoMovimCajaData = (BelTipoMovimCajaData) belTipoMovimCajaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMovimCajaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMovimCajaData.getCodCaja() != null ? 
				FormatUtils.formatObject(belTipoMovimCajaData.getCodCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimCajaData.getDesTipoMoviCaja() != null ? 
				FormatUtils.formatObject(belTipoMovimCajaData.getDesTipoMoviCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimCajaData.getValSign() != null ? 
				FormatUtils.formatObject(belTipoMovimCajaData.getValSign(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimCajaData.getIndAuto() != null ? 
				FormatUtils.formatObject(belTipoMovimCajaData.getIndAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belTipoMovimCajaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
