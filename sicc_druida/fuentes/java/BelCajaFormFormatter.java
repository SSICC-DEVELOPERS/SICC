
/*
    INDRA/CAR/mmg
    $Id: BelCajaFormFormatter.java,v 1.1 2009/12/03 18:38:02 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelCaja" para Druida
 * 
 * @author Indra
 */
public class BelCajaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelCajaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belCajaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belCajaList.size(); i++) {
		
			BelCajaData belCajaData = (BelCajaData) belCajaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belCajaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belCajaData.getPaisOidPais() != null ? belCajaData.getPaisOidPais().getId() : null));
			row.add((belCajaData.getSbacOidSbac() != null ? belCajaData.getSbacOidSbac().getId() : null));
			row.add((belCajaData.getCodCaja() != null ? 
				FormatUtils.formatObject(belCajaData.getCodCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belCajaData.getValEstaCaja() != null ? 
				FormatUtils.formatObject(belCajaData.getValEstaCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belCajaData.getFecCier() != null ? 
				FormatUtils.formatObject(belCajaData.getFecCier(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belCajaData.getUserOidUser() != null ? belCajaData.getUserOidUser().getId() : null));
			row.add((belCajaData.getTicjOidTipoCaja() != null ? belCajaData.getTicjOidTipoCaja().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belCajaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
