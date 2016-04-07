
/*
    INDRA/CAR/mmg
    $Id: MaeTipoNivelSocecPersoFormFormatter.java,v 1.1 2009/12/03 18:35:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoNivelSocecPerso" para Druida
 * 
 * @author Indra
 */
public class MaeTipoNivelSocecPersoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoNivelSocecPersoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoNivelSocecPersoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoNivelSocecPersoList.size(); i++) {
		
			MaeTipoNivelSocecPersoData maeTipoNivelSocecPersoData = (MaeTipoNivelSocecPersoData) maeTipoNivelSocecPersoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoNivelSocecPersoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoNivelSocecPersoData.getCodNsep() != null ? 
				FormatUtils.formatObject(maeTipoNivelSocecPersoData.getCodNsep(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoNivelSocecPersoData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoNivelSocecPersoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoNivelSocecPersoData.getPaisOidPais() != null ? maeTipoNivelSocecPersoData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoNivelSocecPersoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
