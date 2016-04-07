
/*
    INDRA/CAR/mmg
    $Id: CobGuionArgumCabecFormFormatter.java,v 1.1 2009/12/03 18:38:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobGuionArgumCabec" para Druida
 * 
 * @author Indra
 */
public class CobGuionArgumCabecFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobGuionArgumCabecFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobGuionArgumCabecList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobGuionArgumCabecList.size(); i++) {
		
			CobGuionArgumCabecData cobGuionArgumCabecData = (CobGuionArgumCabecData) cobGuionArgumCabecList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobGuionArgumCabecData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobGuionArgumCabecData.getCodGuiaArgu() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecData.getCodGuiaArgu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumCabecData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGuionArgumCabecData.getPaisOidPais() != null ? cobGuionArgumCabecData.getPaisOidPais().getId() : null));
			row.add((cobGuionArgumCabecData.getValObse() != null ? 
				FormatUtils.formatObject(cobGuionArgumCabecData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobGuionArgumCabecData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
