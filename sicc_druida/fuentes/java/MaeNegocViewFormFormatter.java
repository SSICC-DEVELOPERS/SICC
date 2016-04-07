
/*
    INDRA/CAR/mmg
    $Id: MaeNegocViewFormFormatter.java,v 1.1 2009/12/03 18:41:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeNegocView" para Druida
 * 
 * @author Indra
 */
public class MaeNegocViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeNegocViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeNegocViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeNegocViewList.size(); i++) {
		
			MaeNegocViewData maeNegocViewData = (MaeNegocViewData) maeNegocViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeNegocViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeNegocViewData.getPaisOidPais() != null ? maeNegocViewData.getPaisOidPais().getId() : null));
			row.add((maeNegocViewData.getCodNego() != null ? 
				FormatUtils.formatObject(maeNegocViewData.getCodNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeNegocViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeNegocViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeNegocViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
