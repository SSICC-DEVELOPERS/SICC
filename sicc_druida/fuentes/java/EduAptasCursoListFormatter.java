
/*
    INDRA/CAR/mmg
    $Id: EduAptasCursoListFormatter.java,v 1.1 2009/12/03 18:42:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduAptasCurso" para Druida
 * 
 * @author Indra
 */
public class EduAptasCursoListFormatter extends MMGDruidaFormatoObjeto {
	
	public EduAptasCursoListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduAptasCursoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduAptasCursoList.size(); i++) {
		
			EduAptasCursoData eduAptasCursoData = (EduAptasCursoData) eduAptasCursoList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = eduAptasCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((eduAptasCursoData.getCtsuOidClieTipoSubt() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getCtsuOidClieTipoSubt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getMcurOidCurs() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getMcurOidCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getFecAsis() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getFecAsis(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getIndAcceDmrt() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndAcceDmrt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getIndAptaCurs() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndAptaCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getIndInvi() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndInvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getIndAsis() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndAsis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduAptasCursoData.getIndPrue() != null ? 
				FormatUtils.formatObject(eduAptasCursoData.getIndPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// A�adir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(eduAptasCursoData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
