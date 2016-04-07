
/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacViewFormFormatter.java,v 1.1 2009/12/03 18:39:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMovimAlmacView" para Druida
 * 
 * @author Indra
 */
public class BelTipoMovimAlmacViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMovimAlmacViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMovimAlmacViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belTipoMovimAlmacViewList.size(); i++) {
		
			BelTipoMovimAlmacViewData belTipoMovimAlmacViewData = (BelTipoMovimAlmacViewData) belTipoMovimAlmacViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMovimAlmacViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMovimAlmacViewData.getPaisOidPais() != null ? belTipoMovimAlmacViewData.getPaisOidPais().getId() : null));
			row.add((belTipoMovimAlmacViewData.getCodTipoMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodTipoMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getCodMoviSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodMoviSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getIndMoviEntrAlma() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndMoviEntrAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getIndMantMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndMantMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getIndSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getCodOper1() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodOper1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacViewData.getCodOper2() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodOper2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belTipoMovimAlmacViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
