
/*
    INDRA/CAR/mmg
    $Id: PedAtribEspecFormFormatter.java,v 1.1 2009/12/03 18:32:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedAtribEspec" para Druida
 * 
 * @author Indra
 */
public class PedAtribEspecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedAtribEspecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedAtribEspecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedAtribEspecList.size(); i++) {
		
			PedAtribEspecData pedAtribEspecData = (PedAtribEspecData) pedAtribEspecList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedAtribEspecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedAtribEspecData.getCodAtri() != null ? 
				FormatUtils.formatObject(pedAtribEspecData.getCodAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedAtribEspecData.getDesAtri() != null ? 
				FormatUtils.formatObject(pedAtribEspecData.getDesAtri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedAtribEspecData.getValForm() != null ? 
				FormatUtils.formatObject(pedAtribEspecData.getValForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedAtribEspecData.getModuOidModu() != null ? pedAtribEspecData.getModuOidModu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedAtribEspecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
