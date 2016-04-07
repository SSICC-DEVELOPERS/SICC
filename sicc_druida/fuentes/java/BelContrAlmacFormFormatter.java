
/*
    INDRA/CAR/mmg
    $Id: BelContrAlmacFormFormatter.java,v 1.1 2009/12/03 18:36:02 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelContrAlmac" para Druida
 * 
 * @author Indra
 */
public class BelContrAlmacFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelContrAlmacFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belContrAlmacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < belContrAlmacList.size(); i++) {
		
			BelContrAlmacData belContrAlmacData = (BelContrAlmacData) belContrAlmacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belContrAlmacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belContrAlmacData.getSbacOidSbac() != null ? belContrAlmacData.getSbacOidSbac().getId() : null));
			row.add((belContrAlmacData.getProdOidProd() != null ? belContrAlmacData.getProdOidProd().getId() : null));
			row.add((belContrAlmacData.getAlmcOidAlma() != null ? belContrAlmacData.getAlmcOidAlma().getId() : null));
			row.add((belContrAlmacData.getValStocMini() != null ? 
				FormatUtils.formatObject(belContrAlmacData.getValStocMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belContrAlmacData.getValStocMaxi() != null ? 
				FormatUtils.formatObject(belContrAlmacData.getValStocMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belContrAlmacData.getValStocRepo() != null ? 
				FormatUtils.formatObject(belContrAlmacData.getValStocRepo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belContrAlmacData.getIndActi() != null ? 
				FormatUtils.formatObject(belContrAlmacData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belContrAlmacData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
