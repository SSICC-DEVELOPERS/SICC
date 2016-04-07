
/*
    INDRA/CAR/mmg
    $Id: PreArgumVentaFormFormatter.java,v 1.1 2009/12/03 18:43:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreArgumVenta" para Druida
 * 
 * @author Indra
 */
public class PreArgumVentaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreArgumVentaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preArgumVentaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preArgumVentaList.size(); i++) {
		
			PreArgumVentaData preArgumVentaData = (PreArgumVentaData) preArgumVentaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preArgumVentaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preArgumVentaData.getCodArguVent() != null ? 
				FormatUtils.formatObject(preArgumVentaData.getCodArguVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preArgumVentaData.getDescripcion() != null ? 
				FormatUtils.formatObject(preArgumVentaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preArgumVentaData.getTiesOidTipoEstr() != null ? preArgumVentaData.getTiesOidTipoEstr().getId() : null));
			row.add((preArgumVentaData.getValFactRepe() != null ? 
				FormatUtils.formatObject(preArgumVentaData.getValFactRepe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preArgumVentaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
