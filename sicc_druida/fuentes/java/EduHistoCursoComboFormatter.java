
/*
    INDRA/CAR/mmg
    $Id: EduHistoCursoComboFormatter.java,v 1.1 2009/12/03 18:34:05 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: EduHistoCursoComboFormatter.java,v 1.1 2009/12/03 18:34:05 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
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
public class EduHistoCursoComboFormatter extends MMGDruidaFormatoObjeto {
	
	public EduHistoCursoComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduHistoCursoCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduHistoCursoCombo.size(); i++) {
		
			EduHistoCursoData eduHistoCursoData = (EduHistoCursoData) eduHistoCursoCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduHistoCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((eduHistoCursoData.getIndAsis() != null ? 
				FormatUtils.formatObject(eduHistoCursoData.getIndAsis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
