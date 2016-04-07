
/*
    INDRA/CAR/mmg
    $Id: CobUsuarCobraViewFormFormatter.java,v 1.1 2009/12/03 18:36:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobUsuarCobraView" para Druida
 * 
 * @author Indra
 */
public class CobUsuarCobraViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobUsuarCobraViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobUsuarCobraViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobUsuarCobraViewList.size(); i++) {
		
			CobUsuarCobraViewData cobUsuarCobraViewData = (CobUsuarCobraViewData) cobUsuarCobraViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobUsuarCobraViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobUsuarCobraViewData.getFecUltiEsta() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getFecUltiEsta(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getIndJefeCobr() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndJefeCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getIndUsuaSupe() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndUsuaSupe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getIndUsuaExte() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getIndUsuaExte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getValTurnHoraEntr() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValTurnHoraEntr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getValTurnHoraSali() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValTurnHoraSali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getValObse() != null ? 
				FormatUtils.formatObject(cobUsuarCobraViewData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobUsuarCobraViewData.getUserOidUsuaCobr() != null ? cobUsuarCobraViewData.getUserOidUsuaCobr().getId() : null));
			row.add((cobUsuarCobraViewData.getPaisOidPais() != null ? cobUsuarCobraViewData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobUsuarCobraViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
