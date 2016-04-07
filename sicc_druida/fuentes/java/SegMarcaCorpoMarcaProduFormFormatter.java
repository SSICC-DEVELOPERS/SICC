
/*
    INDRA/CAR/mmg
    $Id: SegMarcaCorpoMarcaProduFormFormatter.java,v 1.1 2009/12/03 18:40:51 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegMarcaCorpoMarcaProdu" para Druida
 * 
 * @author Indra
 */
public class SegMarcaCorpoMarcaProduFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegMarcaCorpoMarcaProduFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segMarcaCorpoMarcaProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segMarcaCorpoMarcaProduList.size(); i++) {
		
			SegMarcaCorpoMarcaProduData segMarcaCorpoMarcaProduData = (SegMarcaCorpoMarcaProduData) segMarcaCorpoMarcaProduList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segMarcaCorpoMarcaProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segMarcaCorpoMarcaProduData.getMarcOidMarc() != null ? segMarcaCorpoMarcaProduData.getMarcOidMarc().getId() : null));
			row.add((segMarcaCorpoMarcaProduData.getMaprOidMarcProd() != null ? segMarcaCorpoMarcaProduData.getMaprOidMarcProd().getId() : null));
			row.add((segMarcaCorpoMarcaProduData.getPaisOidPais() != null ? segMarcaCorpoMarcaProduData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segMarcaCorpoMarcaProduData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
