
/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoRecibListFormatter.java,v 1.1 2009/12/03 18:32:18 pecbazalar Exp $
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
public class EduMatriCursoRecibListFormatter extends MMGDruidaFormatoObjeto {
	
	public EduMatriCursoRecibListFormatter() {
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
			row.add((eduMatriCursoRecibData.getMcurOidCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoRecibData.getMcurOidCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoRecibData.getMcurOidCursRequ() != null ? 
				FormatUtils.formatObject(eduMatriCursoRecibData.getMcurOidCursRequ(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(eduMatriCursoRecibData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
