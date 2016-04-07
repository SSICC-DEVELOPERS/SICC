
/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacFormFormatter.java,v 1.1 2009/12/03 18:34:18 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMovimAlmac" para Druida
 * 
 * @author Indra
 */
public class BelTipoMovimAlmacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMovimAlmacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMovimAlmacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belTipoMovimAlmacList.size(); i++) {
		
			BelTipoMovimAlmacData belTipoMovimAlmacData = (BelTipoMovimAlmacData) belTipoMovimAlmacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMovimAlmacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMovimAlmacData.getPaisOidPais() != null ? belTipoMovimAlmacData.getPaisOidPais().getId() : null));
			row.add((belTipoMovimAlmacData.getCodTipoMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodTipoMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getCodMoviSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodMoviSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getIndMoviEntrAlma() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndMoviEntrAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getIndMantMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndMantMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getIndSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getEsmeOidEstaMerc1() != null ? belTipoMovimAlmacData.getEsmeOidEstaMerc1().getId() : null));
			row.add((belTipoMovimAlmacData.getEsmeOidEstaMerc2() != null ? belTipoMovimAlmacData.getEsmeOidEstaMerc2().getId() : null));
			row.add((belTipoMovimAlmacData.getCodOper1() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodOper1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belTipoMovimAlmacData.getCodOper2() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodOper2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belTipoMovimAlmacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
