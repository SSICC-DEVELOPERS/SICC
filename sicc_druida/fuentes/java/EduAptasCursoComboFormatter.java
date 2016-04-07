
/*
    INDRA/CAR/mmg
    $Id: EduAptasCursoComboFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: EduAptasCursoComboFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduAptasCurso" para Druida
 * 
 * @author Indra
 */
public class EduAptasCursoComboFormatter extends MMGDruidaFormatoObjeto {
	
	public EduAptasCursoComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduAptasCursoCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduAptasCursoCombo.size(); i++) {
		
			EduAptasCursoData eduAptasCursoData = (EduAptasCursoData) eduAptasCursoCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduAptasCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((eduAptasCursoData.getIndPrue() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
