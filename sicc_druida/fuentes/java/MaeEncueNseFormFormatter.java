
/*
    INDRA/CAR/mmg
    $Id: MaeEncueNseFormFormatter.java,v 1.1 2009/12/03 18:36:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeEncueNse" para Druida
 * 
 * @author Indra
 */
public class MaeEncueNseFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeEncueNseFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeEncueNseList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeEncueNseList.size(); i++) {
		
			MaeEncueNseData maeEncueNseData = (MaeEncueNseData) maeEncueNseList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeEncueNseData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeEncueNseData.getPaisOidPais() != null ? maeEncueNseData.getPaisOidPais().getId() : null));
			row.add((maeEncueNseData.getCodTipoEncu() != null ? 
				FormatUtils.formatObject(maeEncueNseData.getCodTipoEncu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeEncueNseData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeEncueNseData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeEncueNseData.getMarcOidMarc() != null ? maeEncueNseData.getMarcOidMarc().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeEncueNseData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
