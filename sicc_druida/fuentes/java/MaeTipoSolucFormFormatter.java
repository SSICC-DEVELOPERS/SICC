
/*
    INDRA/CAR/mmg
    $Id: MaeTipoSolucFormFormatter.java,v 1.1 2009/12/03 18:38:33 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoSoluc" para Druida
 * 
 * @author Indra
 */
public class MaeTipoSolucFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoSolucFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoSolucList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoSolucList.size(); i++) {
		
			MaeTipoSolucData maeTipoSolucData = (MaeTipoSolucData) maeTipoSolucList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoSolucData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoSolucData.getPaisOidPais() != null ? maeTipoSolucData.getPaisOidPais().getId() : null));
			row.add((maeTipoSolucData.getCodTipoSolu() != null ? 
				FormatUtils.formatObject(maeTipoSolucData.getCodTipoSolu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoSolucData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoSolucData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoSolucData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
