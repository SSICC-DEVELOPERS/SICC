
/*
    INDRA/CAR/mmg
    $Id: ComTipoClienComisCabecFormFormatter.java,v 1.1 2009/12/03 18:32:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "ComTipoClienComisCabec" para Druida
 * 
 * @author Indra
 */
public class ComTipoClienComisCabecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ComTipoClienComisCabecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector comTipoClienComisCabecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < comTipoClienComisCabecList.size(); i++) {
		
			ComTipoClienComisCabecData comTipoClienComisCabecData = (ComTipoClienComisCabecData) comTipoClienComisCabecList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = comTipoClienComisCabecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((comTipoClienComisCabecData.getCodClas() != null ? 
				FormatUtils.formatObject(comTipoClienComisCabecData.getCodClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comTipoClienComisCabecData.getCodSubc() != null ? 
				FormatUtils.formatObject(comTipoClienComisCabecData.getCodSubc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((comTipoClienComisCabecData.getPaisOidPais() != null ? comTipoClienComisCabecData.getPaisOidPais().getId() : null));
			row.add((comTipoClienComisCabecData.getDescripcion() != null ? 
				FormatUtils.formatObject(comTipoClienComisCabecData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(comTipoClienComisCabecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
