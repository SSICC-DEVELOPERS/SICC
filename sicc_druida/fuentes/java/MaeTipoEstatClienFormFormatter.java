
/*
    INDRA/CAR/mmg
    $Id: MaeTipoEstatClienFormFormatter.java,v 1.1 2009/12/03 18:40:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoEstatClien" para Druida
 * 
 * @author Indra
 */
public class MaeTipoEstatClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoEstatClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoEstatClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoEstatClienList.size(); i++) {
		
			MaeTipoEstatClienData maeTipoEstatClienData = (MaeTipoEstatClienData) maeTipoEstatClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoEstatClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoEstatClienData.getCodTipoEsta() != null ? 
				FormatUtils.formatObject(maeTipoEstatClienData.getCodTipoEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoEstatClienData.getMarcOidMarc() != null ? maeTipoEstatClienData.getMarcOidMarc().getId() : null));
			row.add((maeTipoEstatClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoEstatClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoEstatClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
