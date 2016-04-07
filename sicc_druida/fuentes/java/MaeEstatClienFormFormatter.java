
/*
    INDRA/CAR/mmg
    $Id: MaeEstatClienFormFormatter.java,v 1.1 2009/12/03 18:40:53 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeEstatClien" para Druida
 * 
 * @author Indra
 */
public class MaeEstatClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeEstatClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeEstatClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeEstatClienList.size(); i++) {
		
			MaeEstatClienData maeEstatClienData = (MaeEstatClienData) maeEstatClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeEstatClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeEstatClienData.getTescOidTipoEsta() != null ? maeEstatClienData.getTescOidTipoEsta().getId() : null));
			row.add((maeEstatClienData.getCodEstaClie() != null ? 
				FormatUtils.formatObject(maeEstatClienData.getCodEstaClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeEstatClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeEstatClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeEstatClienData.getEstaOidEstaClie() != null ? maeEstatClienData.getEstaOidEstaClie().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeEstatClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
