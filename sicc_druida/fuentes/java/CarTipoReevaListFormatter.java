
/*
    INDRA/CAR/mmg
    $Id: CarTipoReevaListFormatter.java,v 1.1 2009/12/03 18:40:20 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarTipoReeva" para Druida
 * 
 * @author Indra
 */
public class CarTipoReevaListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarTipoReevaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carTipoReevaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carTipoReevaList.size(); i++) {
		
			CarTipoReevaData carTipoReevaData = (CarTipoReevaData) carTipoReevaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carTipoReevaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carTipoReevaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
