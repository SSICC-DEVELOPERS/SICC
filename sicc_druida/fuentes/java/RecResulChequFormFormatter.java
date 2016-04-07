
/*
    INDRA/CAR/mmg
    $Id: RecResulChequFormFormatter.java,v 1.1 2009/12/03 18:39:05 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecResulChequ" para Druida
 * 
 * @author Indra
 */
public class RecResulChequFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecResulChequFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recResulChequList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recResulChequList.size(); i++) {
		
			RecResulChequData recResulChequData = (RecResulChequData) recResulChequList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recResulChequData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recResulChequData.getPaisOidPais() != null ? recResulChequData.getPaisOidPais().getId() : null));
			row.add((recResulChequData.getCodResuCheq() != null ? 
				FormatUtils.formatObject(recResulChequData.getCodResuCheq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recResulChequData.getDescripcion() != null ? 
				FormatUtils.formatObject(recResulChequData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recResulChequData.getIndResu() != null ? 
				FormatUtils.formatObject(recResulChequData.getIndResu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recResulChequData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
