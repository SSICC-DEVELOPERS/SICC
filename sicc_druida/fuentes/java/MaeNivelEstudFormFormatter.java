
/*
    INDRA/CAR/mmg
    $Id: MaeNivelEstudFormFormatter.java,v 1.1 2009/12/03 18:33:02 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeNivelEstud" para Druida
 * 
 * @author Indra
 */
public class MaeNivelEstudFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeNivelEstudFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeNivelEstudList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeNivelEstudList.size(); i++) {
		
			MaeNivelEstudData maeNivelEstudData = (MaeNivelEstudData) maeNivelEstudList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeNivelEstudData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeNivelEstudData.getPaisOidPais() != null ? maeNivelEstudData.getPaisOidPais().getId() : null));
			row.add((maeNivelEstudData.getCodNiveEstu() != null ? 
				FormatUtils.formatObject(maeNivelEstudData.getCodNiveEstu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeNivelEstudData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeNivelEstudData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeNivelEstudData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
