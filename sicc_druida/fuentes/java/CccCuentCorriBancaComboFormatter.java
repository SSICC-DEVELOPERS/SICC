
/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaComboFormatter.java,v 1.1 2009/12/03 18:35:38 pecbazalar Exp $
    DESC
*/


/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaComboFormatter.java,v 1.1 2009/12/03 18:35:38 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentCorriBanca" para Druida
 * 
 * @author Indra
 */
public class CccCuentCorriBancaComboFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentCorriBancaComboFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentCorriBancaCombo = (Vector) dto.getProperty("result");
		Vector result = new Vector();

		//Ordenamos los elementos
		//TreeMap orderBy = new TreeMap();
		TreeMap orderBy = new TreeMap(new Comparador());
		for(int i=0; i< cccCuentCorriBancaCombo.size(); i++){
			CccCuentCorriBancaData cccCuentCorriBancaData = (CccCuentCorriBancaData)cccCuentCorriBancaCombo.get(i);
			String description = cccCuentCorriBancaData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : "";
			
			orderBy.put(description.toUpperCase(), cccCuentCorriBancaData);
		}

		//Construimos cada fila con los valores de la clave y la descripción del elemento que se mostrará en el combo
		for (Iterator it = orderBy.entrySet().iterator() ; it.hasNext();) {
			CccCuentCorriBancaData cccCuentCorriBancaData = (CccCuentCorriBancaData)((Map.Entry)it.next()).getValue();
			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentCorriBancaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el atributo choice
			row.add((cccCuentCorriBancaData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			result.add(row);
		}

		setCampo(s, result);
	}
}
