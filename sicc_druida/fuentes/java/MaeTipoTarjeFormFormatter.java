
/*
    INDRA/CAR/mmg
    $Id: MaeTipoTarjeFormFormatter.java,v 1.1 2009/12/03 18:40:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoTarje" para Druida
 * 
 * @author Indra
 */
public class MaeTipoTarjeFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoTarjeFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoTarjeList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoTarjeList.size(); i++) {
		
			MaeTipoTarjeData maeTipoTarjeData = (MaeTipoTarjeData) maeTipoTarjeList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoTarjeData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoTarjeData.getCodTipoTarj() != null ? 
				FormatUtils.formatObject(maeTipoTarjeData.getCodTipoTarj(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoTarjeData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoTarjeData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoTarjeData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
