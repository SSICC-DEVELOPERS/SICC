
/*
    INDRA/CAR/mmg
    $Id: EduTipoCursoComboFormatter.java,v 1.1 2009/12/03 18:42:51 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: EduTipoCursoComboFormatter.java,v 1.1 2009/12/03 18:42:51 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
*/

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

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
public class EduTipoCursoComboFormatter extends MMGDruidaFormatoObjeto {
	
	public EduTipoCursoComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduTipoCursoCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< eduTipoCursoCombo.size(); i++){
			EduTipoCursoData eduTipoCursoData = (EduTipoCursoData)eduTipoCursoCombo.get(i);
			String description = eduTipoCursoData.getDescripcion() != null ? 
				FormatUtils.formatObject(eduTipoCursoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), eduTipoCursoData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			EduTipoCursoData eduTipoCursoData = (EduTipoCursoData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduTipoCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((eduTipoCursoData.getDescripcion() != null ? 
				FormatUtils.formatObject(eduTipoCursoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
