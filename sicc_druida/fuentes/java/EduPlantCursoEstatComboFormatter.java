
/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoEstatComboFormatter.java,v 1.1 2009/12/03 18:32:41 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoEstatComboFormatter.java,v 1.1 2009/12/03 18:32:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduPlantCursoEstat" para Druida
 * 
 * @author Indra
 */
public class EduPlantCursoEstatComboFormatter extends MMGDruidaFormatoObjeto {
	
	public EduPlantCursoEstatComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduPlantCursoEstatCombo = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduPlantCursoEstatCombo.size(); i++) {
		
			EduPlantCursoEstatData eduPlantCursoEstatData = (EduPlantCursoEstatData) eduPlantCursoEstatCombo.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduPlantCursoEstatData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((eduPlantCursoEstatData.getDpcuOidDetaPlanCurs() != null ? 
				FormatUtils.formatObject(eduPlantCursoEstatData.getDpcuOidDetaPlanCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
