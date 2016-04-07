
/*
    INDRA/CAR/mmg
    $Id: PreCicloVidaFormFormatter.java,v 1.1 2009/12/03 18:42:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreCicloVida" para Druida
 * 
 * @author Indra
 */
public class PreCicloVidaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreCicloVidaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preCicloVidaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preCicloVidaList.size(); i++) {
		
			PreCicloVidaData preCicloVidaData = (PreCicloVidaData) preCicloVidaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preCicloVidaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preCicloVidaData.getCodCiclVida() != null ? 
				FormatUtils.formatObject(preCicloVidaData.getCodCiclVida(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preCicloVidaData.getDescripcion() != null ? 
				FormatUtils.formatObject(preCicloVidaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preCicloVidaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
