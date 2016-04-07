
/*
    INDRA/CAR/mmg
    $Id: CarIndicValidListFormatter.java,v 1.1 2009/12/03 18:32:38 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarIndicValid" para Druida
 * 
 * @author Indra
 */
public class CarIndicValidListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarIndicValidListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carIndicValidList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carIndicValidList.size(); i++) {
		
			CarIndicValidData carIndicValidData = (CarIndicValidData) carIndicValidList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carIndicValidData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carIndicValidData.getCodIndiVali() != null ? 
				FormatUtils.formatObject(carIndicValidData.getCodIndiVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carIndicValidData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
