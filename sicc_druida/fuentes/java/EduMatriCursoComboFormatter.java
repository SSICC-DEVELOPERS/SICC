
/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoComboFormatter.java,v 1.1 2009/12/03 18:35:55 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoComboFormatter.java,v 1.1 2009/12/03 18:35:55 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduMatriCurso" para Druida
 * 
 * @author Indra
 */
public class EduMatriCursoComboFormatter extends MMGDruidaFormatoObjeto {
	
	public EduMatriCursoComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduMatriCursoCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduMatriCursoCombo.size(); i++) {
		
			EduMatriCursoData eduMatriCursoData = (EduMatriCursoData) eduMatriCursoCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduMatriCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((eduMatriCursoData.getClclOidClieClasCapa() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getClclOidClieClasCapa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
