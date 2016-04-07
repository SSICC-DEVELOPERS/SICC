
/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoDetalFormFormatter.java,v 1.1 2009/12/03 18:32:32 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduPlantCursoDetal" para Druida
 * 
 * @author Indra
 */
public class EduPlantCursoDetalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduPlantCursoDetalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduPlantCursoDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduPlantCursoDetalList.size(); i++) {
		
			EduPlantCursoDetalData eduPlantCursoDetalData = (EduPlantCursoDetalData) eduPlantCursoDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduPlantCursoDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduPlantCursoDetalData.getCplcOidCabe() != null ? eduPlantCursoDetalData.getCplcOidCabe().getId() : null));
			row.add((eduPlantCursoDetalData.getValDeta() != null ? 
				FormatUtils.formatObject(eduPlantCursoDetalData.getValDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduPlantCursoDetalData.getIndVisi() != null ? 
				FormatUtils.formatObject(eduPlantCursoDetalData.getIndVisi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduPlantCursoDetalData.getIndModi() != null ? 
				FormatUtils.formatObject(eduPlantCursoDetalData.getIndModi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduPlantCursoDetalData.getIndObli() != null ? 
				FormatUtils.formatObject(eduPlantCursoDetalData.getIndObli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduPlantCursoDetalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
