
/*
    INDRA/CAR/mmg
    $Id: FacTecnoImpreFormFormatter.java,v 1.1 2009/12/03 18:40:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacTecnoImpre" para Druida
 * 
 * @author Indra
 */
public class FacTecnoImpreFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacTecnoImpreFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facTecnoImpreList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facTecnoImpreList.size(); i++) {
		
			FacTecnoImpreData facTecnoImpreData = (FacTecnoImpreData) facTecnoImpreList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = facTecnoImpreData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((facTecnoImpreData.getDesTecn() != null ? 
				FormatUtils.formatObject(facTecnoImpreData.getDesTecn(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facTecnoImpreData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
