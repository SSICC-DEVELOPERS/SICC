
/*
    INDRA/CAR/mmg
    $Id: MaeNegocFormFormatter.java,v 1.1 2009/12/03 18:38:44 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeNegoc" para Druida
 * 
 * @author Indra
 */
public class MaeNegocFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeNegocFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeNegocList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeNegocList.size(); i++) {
		
			MaeNegocData maeNegocData = (MaeNegocData) maeNegocList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeNegocData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeNegocData.getPaisOidPais() != null ? maeNegocData.getPaisOidPais().getId() : null));
			row.add((maeNegocData.getCodNego() != null ? 
				FormatUtils.formatObject(maeNegocData.getCodNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeNegocData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeNegocData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeNegocData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
