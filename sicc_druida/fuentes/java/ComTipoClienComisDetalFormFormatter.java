
/*
    INDRA/CAR/mmg
    $Id: ComTipoClienComisDetalFormFormatter.java,v 1.1 2009/12/03 18:35:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "ComTipoClienComisDetal" para Druida
 * 
 * @author Indra
 */
public class ComTipoClienComisDetalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ComTipoClienComisDetalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector comTipoClienComisDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < comTipoClienComisDetalList.size(); i++) {
		
			ComTipoClienComisDetalData comTipoClienComisDetalData = (ComTipoClienComisDetalData) comTipoClienComisDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = comTipoClienComisDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((comTipoClienComisDetalData.getTcccOidTipoClieComiCabe() != null ? comTipoClienComisDetalData.getTcccOidTipoClieComiCabe().getId() : null));
			row.add((comTipoClienComisDetalData.getClasOidClas() != null ? comTipoClienComisDetalData.getClasOidClas().getId() : null));
			row.add((comTipoClienComisDetalData.getDescripcion() != null ? 
				FormatUtils.formatObject(comTipoClienComisDetalData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(comTipoClienComisDetalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
