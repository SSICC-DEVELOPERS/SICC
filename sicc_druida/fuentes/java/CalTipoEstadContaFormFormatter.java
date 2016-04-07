
/*
    INDRA/CAR/mmg
    $Id: CalTipoEstadContaFormFormatter.java,v 1.1 2009/12/03 18:35:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalTipoEstadConta" para Druida
 * 
 * @author Indra
 */
public class CalTipoEstadContaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalTipoEstadContaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calTipoEstadContaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calTipoEstadContaList.size(); i++) {
		
			CalTipoEstadContaData calTipoEstadContaData = (CalTipoEstadContaData) calTipoEstadContaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = calTipoEstadContaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((calTipoEstadContaData.getCodEsta() != null ? 
				FormatUtils.formatObject(calTipoEstadContaData.getCodEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calTipoEstadContaData.getDescripcion() != null ? 
				FormatUtils.formatObject(calTipoEstadContaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calTipoEstadContaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
