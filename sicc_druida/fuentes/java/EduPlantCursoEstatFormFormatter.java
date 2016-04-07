
/*
    INDRA/CAR/mmg
    $Id: EduPlantCursoEstatFormFormatter.java,v 1.1 2009/12/03 18:39:46 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduPlantCursoEstat" para Druida
 * 
 * @author Indra
 */
public class EduPlantCursoEstatFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduPlantCursoEstatFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduPlantCursoEstatList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduPlantCursoEstatList.size(); i++) {
		
			EduPlantCursoEstatData eduPlantCursoEstatData = (EduPlantCursoEstatData) eduPlantCursoEstatList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduPlantCursoEstatData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduPlantCursoEstatData.getMcurOidCurs() != null ? eduPlantCursoEstatData.getMcurOidCurs().getId() : null));
			row.add((eduPlantCursoEstatData.getDpcuOidDetaPlanCurs() != null ? eduPlantCursoEstatData.getDpcuOidDetaPlanCurs().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduPlantCursoEstatData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
