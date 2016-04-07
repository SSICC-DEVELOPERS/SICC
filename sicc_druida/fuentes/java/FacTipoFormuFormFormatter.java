
/*
    INDRA/CAR/mmg
    $Id: FacTipoFormuFormFormatter.java,v 1.1 2009/12/03 18:41:17 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacTipoFormu" para Druida
 * 
 * @author Indra
 */
public class FacTipoFormuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacTipoFormuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facTipoFormuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facTipoFormuList.size(); i++) {
		
			FacTipoFormuData facTipoFormuData = (FacTipoFormuData) facTipoFormuList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = facTipoFormuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((facTipoFormuData.getCodTipoForm() != null ? 
				FormatUtils.formatObject(facTipoFormuData.getCodTipoForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facTipoFormuData.getValDesc() != null ? 
				FormatUtils.formatObject(facTipoFormuData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facTipoFormuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
