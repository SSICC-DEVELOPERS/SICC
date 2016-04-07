
/*
    INDRA/CAR/mmg
    $Id: MaeTipoPerfiPsicoFormFormatter.java,v 1.1 2009/12/03 18:33:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoPerfiPsico" para Druida
 * 
 * @author Indra
 */
public class MaeTipoPerfiPsicoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoPerfiPsicoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoPerfiPsicoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoPerfiPsicoList.size(); i++) {
		
			MaeTipoPerfiPsicoData maeTipoPerfiPsicoData = (MaeTipoPerfiPsicoData) maeTipoPerfiPsicoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoPerfiPsicoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoPerfiPsicoData.getCodTipoPerfPsic() != null ? 
				FormatUtils.formatObject(maeTipoPerfiPsicoData.getCodTipoPerfPsic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoPerfiPsicoData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoPerfiPsicoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoPerfiPsicoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
