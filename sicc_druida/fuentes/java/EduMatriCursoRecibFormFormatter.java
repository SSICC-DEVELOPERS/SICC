
/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoRecibFormFormatter.java,v 1.1 2009/12/03 18:33:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduMatriCursoRecib" para Druida
 * 
 * @author Indra
 */
public class EduMatriCursoRecibFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduMatriCursoRecibFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduMatriCursoRecibList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduMatriCursoRecibList.size(); i++) {
		
			EduMatriCursoRecibData eduMatriCursoRecibData = (EduMatriCursoRecibData) eduMatriCursoRecibList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduMatriCursoRecibData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduMatriCursoRecibData.getMcurOidCurs() != null ? eduMatriCursoRecibData.getMcurOidCurs().getId() : null));
			row.add((eduMatriCursoRecibData.getMcurOidCursRequ() != null ? eduMatriCursoRecibData.getMcurOidCursRequ().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduMatriCursoRecibData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
