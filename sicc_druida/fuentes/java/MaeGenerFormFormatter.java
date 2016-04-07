
/*
    INDRA/CAR/mmg
    $Id: MaeGenerFormFormatter.java,v 1.1 2009/12/03 18:34:54 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeGener" para Druida
 * 
 * @author Indra
 */
public class MaeGenerFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeGenerFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeGenerList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeGenerList.size(); i++) {
		
			MaeGenerData maeGenerData = (MaeGenerData) maeGenerList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeGenerData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeGenerData.getPaisOidPais() != null ? maeGenerData.getPaisOidPais().getId() : null));
			row.add((maeGenerData.getCodGene() != null ? 
				FormatUtils.formatObject(maeGenerData.getCodGene(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeGenerData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeGenerData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeGenerData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
