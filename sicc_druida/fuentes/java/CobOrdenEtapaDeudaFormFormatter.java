
/*
    INDRA/CAR/mmg
    $Id: CobOrdenEtapaDeudaFormFormatter.java,v 1.1 2009/12/03 18:39:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobOrdenEtapaDeuda" para Druida
 * 
 * @author Indra
 */
public class CobOrdenEtapaDeudaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobOrdenEtapaDeudaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobOrdenEtapaDeudaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobOrdenEtapaDeudaList.size(); i++) {
		
			CobOrdenEtapaDeudaData cobOrdenEtapaDeudaData = (CobOrdenEtapaDeudaData) cobOrdenEtapaDeudaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobOrdenEtapaDeudaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobOrdenEtapaDeudaData.getCodOrdeEtapDeud() != null ? 
				FormatUtils.formatObject(cobOrdenEtapaDeudaData.getCodOrdeEtapDeud(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobOrdenEtapaDeudaData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobOrdenEtapaDeudaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobOrdenEtapaDeudaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
