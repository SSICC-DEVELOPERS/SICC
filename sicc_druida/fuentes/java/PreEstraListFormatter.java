
/*
    INDRA/CAR/mmg
    $Id: PreEstraListFormatter.java,v 1.1 2009/12/03 18:34:36 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreEstra" para Druida
 * 
 * @author Indra
 */
public class PreEstraListFormatter extends MMGDruidaFormatoObjeto {
	
	public PreEstraListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preEstraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preEstraList.size(); i++) {
		
			PreEstraData preEstraData = (PreEstraData) preEstraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preEstraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preEstraData.getCodEstr() != null ? 
				FormatUtils.formatObject(preEstraData.getCodEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getDescripcion() != null ? 
				FormatUtils.formatObject(preEstraData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getTiesOidTipoEstr() != null ? 
				FormatUtils.formatObject(preEstraData.getTiesOidTipoEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(preEstraData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
