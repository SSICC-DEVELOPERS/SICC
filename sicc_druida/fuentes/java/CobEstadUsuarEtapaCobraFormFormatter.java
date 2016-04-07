
/*
    INDRA/CAR/mmg
    $Id: CobEstadUsuarEtapaCobraFormFormatter.java,v 1.1 2009/12/03 18:37:55 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEstadUsuarEtapaCobra" para Druida
 * 
 * @author Indra
 */
public class CobEstadUsuarEtapaCobraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEstadUsuarEtapaCobraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEstadUsuarEtapaCobraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobEstadUsuarEtapaCobraList.size(); i++) {
		
			CobEstadUsuarEtapaCobraData cobEstadUsuarEtapaCobraData = (CobEstadUsuarEtapaCobraData) cobEstadUsuarEtapaCobraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEstadUsuarEtapaCobraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEstadUsuarEtapaCobraData.getCodEstaUsuaEtapCobr() != null ? 
				FormatUtils.formatObject(cobEstadUsuarEtapaCobraData.getCodEstaUsuaEtapCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEstadUsuarEtapaCobraData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobEstadUsuarEtapaCobraData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobEstadUsuarEtapaCobraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
