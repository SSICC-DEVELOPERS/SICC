
/*
    INDRA/CAR/mmg
    $Id: EduFrecuCursoFormFormatter.java,v 1.1 2009/12/03 18:35:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduFrecuCurso" para Druida
 * 
 * @author Indra
 */
public class EduFrecuCursoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduFrecuCursoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduFrecuCursoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduFrecuCursoList.size(); i++) {
		
			EduFrecuCursoData eduFrecuCursoData = (EduFrecuCursoData) eduFrecuCursoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduFrecuCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduFrecuCursoData.getCodFrec() != null ? 
				FormatUtils.formatObject(eduFrecuCursoData.getCodFrec(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduFrecuCursoData.getDescripcion() != null ? 
				FormatUtils.formatObject(eduFrecuCursoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduFrecuCursoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
