
/*
    INDRA/CAR/mmg
    $Id: EduHistoCursoFormFormatter.java,v 1.1 2009/12/03 18:36:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduHistoCurso" para Druida
 * 
 * @author Indra
 */
public class EduHistoCursoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduHistoCursoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduHistoCursoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduHistoCursoList.size(); i++) {
		
			EduHistoCursoData eduHistoCursoData = (EduHistoCursoData) eduHistoCursoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduHistoCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduHistoCursoData.getCtsuOidClieTipoSubt() != null ? eduHistoCursoData.getCtsuOidClieTipoSubt().getId() : null));
			row.add((eduHistoCursoData.getMcurOidCurs() != null ? eduHistoCursoData.getMcurOidCurs().getId() : null));
			row.add((eduHistoCursoData.getIndApta() != null ? 
				FormatUtils.formatObject(eduHistoCursoData.getIndApta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduHistoCursoData.getIndInvit() != null ? 
				FormatUtils.formatObject(eduHistoCursoData.getIndInvit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduHistoCursoData.getIndAsis() != null ? 
				FormatUtils.formatObject(eduHistoCursoData.getIndAsis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduHistoCursoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
