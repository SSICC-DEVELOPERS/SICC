
/*
    INDRA/CAR/mmg
    $Id: ZonDivisPolitListFormatter.java,v 1.1 2009/12/03 18:36:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonDivisPolit" para Druida
 * 
 * @author Indra
 */
public class ZonDivisPolitListFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonDivisPolitListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonDivisPolitList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonDivisPolitList.size(); i++) {
		
			ZonDivisPolitData zonDivisPolitData = (ZonDivisPolitData) zonDivisPolitList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonDivisPolitData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonDivisPolitData.getCodDiviPoli() != null ? 
				FormatUtils.formatObject(zonDivisPolitData.getCodDiviPoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonDivisPolitData.getOrde() != null ? 
				FormatUtils.formatObject(zonDivisPolitData.getOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(zonDivisPolitData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
