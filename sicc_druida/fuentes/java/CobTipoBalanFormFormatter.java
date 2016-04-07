
/*
    INDRA/CAR/mmg
    $Id: CobTipoBalanFormFormatter.java,v 1.1 2009/12/03 18:35:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobTipoBalan" para Druida
 * 
 * @author Indra
 */
public class CobTipoBalanFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobTipoBalanFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobTipoBalanList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobTipoBalanList.size(); i++) {
		
			CobTipoBalanData cobTipoBalanData = (CobTipoBalanData) cobTipoBalanList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobTipoBalanData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobTipoBalanData.getCodTipoBala() != null ? 
				FormatUtils.formatObject(cobTipoBalanData.getCodTipoBala(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobTipoBalanData.getDescripcion() != null ? 
				FormatUtils.formatObject(cobTipoBalanData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobTipoBalanData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
