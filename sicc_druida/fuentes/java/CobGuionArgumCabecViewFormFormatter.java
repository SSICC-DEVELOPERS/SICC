
/*
    INDRA/CAR/mmg
    $Id: CobGuionArgumCabecViewFormFormatter.java,v 1.1 2009/12/03 18:37:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobGuionArgumCabecView" para Druida
 * 
 * @author Indra
 */
public class CobGuionArgumCabecViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobGuionArgumCabecViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobGuionArgumCabecViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobGuionArgumCabecViewList.size(); i++) {
		
			CobGuionArgumCabecViewData cobGuionArgumCabecViewData = (CobGuionArgumCabecViewData) cobGuionArgumCabecViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobGuionArgumCabecViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobGuionArgumCabecViewData.getCodGuiaArgu() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecViewData.getCodGuiaArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumCabecViewData.getValObse() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecViewData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumCabecViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumCabecViewData.getPaisOidPais() != null ? cobGuionArgumCabecViewData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobGuionArgumCabecViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
