
/*
    INDRA/CAR/mmg
    $Id: EduRegalFormFormatter.java,v 1.1 2009/12/03 18:43:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduRegal" para Druida
 * 
 * @author Indra
 */
public class EduRegalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduRegalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduRegalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduRegalList.size(); i++) {
		
			EduRegalData eduRegalData = (EduRegalData) eduRegalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduRegalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduRegalData.getCodRega() != null ? 
				FormatUtils.formatObject(eduRegalData.getCodRega(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduRegalData.getProdOidProd() != null ? eduRegalData.getProdOidProd().getId() : null));
			row.add((eduRegalData.getDescripcion() != null ? 
				FormatUtils.formatObject(eduRegalData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduRegalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
