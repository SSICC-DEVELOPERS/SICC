
/*
    INDRA/CAR/mmg
    $Id: IncPartiConcuCabecFormFormatter.java,v 1.1 2009/12/03 18:32:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "IncPartiConcuCabec" para Druida
 * 
 * @author Indra
 */
public class IncPartiConcuCabecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IncPartiConcuCabecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector incPartiConcuCabecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < incPartiConcuCabecList.size(); i++) {
		
			IncPartiConcuCabecData incPartiConcuCabecData = (IncPartiConcuCabecData) incPartiConcuCabecList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = incPartiConcuCabecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((incPartiConcuCabecData.getValGrupClie() != null ? 
				FormatUtils.formatObject(incPartiConcuCabecData.getValGrupClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((incPartiConcuCabecData.getPaisOidPais() != null ? incPartiConcuCabecData.getPaisOidPais().getId() : null));
			row.add((incPartiConcuCabecData.getDiriOidDiri() != null ? incPartiConcuCabecData.getDiriOidDiri().getId() : null));
			row.add((incPartiConcuCabecData.getDesDesc() != null ? 
				FormatUtils.formatObject(incPartiConcuCabecData.getDesDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(incPartiConcuCabecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
