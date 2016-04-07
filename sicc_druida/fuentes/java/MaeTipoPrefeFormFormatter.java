
/*
    INDRA/CAR/mmg
    $Id: MaeTipoPrefeFormFormatter.java,v 1.1 2009/12/03 18:35:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoPrefe" para Druida
 * 
 * @author Indra
 */
public class MaeTipoPrefeFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoPrefeFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoPrefeList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoPrefeList.size(); i++) {
		
			MaeTipoPrefeData maeTipoPrefeData = (MaeTipoPrefeData) maeTipoPrefeList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoPrefeData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoPrefeData.getPaisOidPais() != null ? maeTipoPrefeData.getPaisOidPais().getId() : null));
			row.add((maeTipoPrefeData.getCodTipoPref() != null ? 
				FormatUtils.formatObject(maeTipoPrefeData.getCodTipoPref(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoPrefeData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoPrefeData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoPrefeData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
