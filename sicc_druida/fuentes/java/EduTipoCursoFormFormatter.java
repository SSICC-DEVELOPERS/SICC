
/*
    INDRA/CAR/mmg
    $Id: EduTipoCursoFormFormatter.java,v 1.1 2009/12/03 18:42:25 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduTipoCurso" para Druida
 * 
 * @author Indra
 */
public class EduTipoCursoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduTipoCursoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduTipoCursoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduTipoCursoList.size(); i++) {
		
			EduTipoCursoData eduTipoCursoData = (EduTipoCursoData) eduTipoCursoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduTipoCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduTipoCursoData.getMarcOidMarc() != null ? eduTipoCursoData.getMarcOidMarc().getId() : null));
			row.add((eduTipoCursoData.getCodTipoCurs() != null ? 
				FormatUtils.formatObject(eduTipoCursoData.getCodTipoCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduTipoCursoData.getDescripcion() != null ? 
				FormatUtils.formatObject(eduTipoCursoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduTipoCursoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
