
/*
    INDRA/CAR/mmg
    $Id: ZonValorEstruGeopoComboFormatter.java,v 1.1 2009/12/03 18:34:58 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: ZonValorEstruGeopoComboFormatter.java,v 1.1 2009/12/03 18:34:58 pecbazalar Exp $
    fdsfdsf

    DRUIDATARGET=/install/cvsiniciales
*/

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import es.indra.belcorp.mso.*;
import es.indra.druida.DruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaFormatoObjeto;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.mare.common.dto.IMareDTO;

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "ZonValorEstruGeopo" para Druida
 * 
 * @author Indra
 */
public class ZonValorEstruGeopoComboFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonValorEstruGeopoComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonValorEstruGeopoCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		TreeMap orderBy = new TreeMap();
		for(int i=0; i< zonValorEstruGeopoCombo.size(); i++){
			ZonValorEstruGeopoData zonValorEstruGeopoData = (ZonValorEstruGeopoData)zonValorEstruGeopoCombo.get(i);
			String description = zonValorEstruGeopoData.getSgeoOidSubeGeop() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getSgeoOidSubeGeop(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), zonValorEstruGeopoData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			ZonValorEstruGeopoData zonValorEstruGeopoData = (ZonValorEstruGeopoData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonValorEstruGeopoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((zonValorEstruGeopoData.getSgeoOidSubeGeop() != null ? 
				FormatUtils.formatObject(zonValorEstruGeopoData.getSgeoOidSubeGeop(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
