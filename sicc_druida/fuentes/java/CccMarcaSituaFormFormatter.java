
/*
    INDRA/CAR/mmg
    $Id: CccMarcaSituaFormFormatter.java,v 1.1 2009/12/03 18:37:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccMarcaSitua" para Druida
 * 
 * @author Indra
 */
public class CccMarcaSituaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccMarcaSituaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccMarcaSituaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccMarcaSituaList.size(); i++) {
		
			CccMarcaSituaData cccMarcaSituaData = (CccMarcaSituaData) cccMarcaSituaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccMarcaSituaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccMarcaSituaData.getPaisOidPais() != null ? cccMarcaSituaData.getPaisOidPais().getId() : null));
			row.add((cccMarcaSituaData.getCodMarcSitu() != null ? 
				FormatUtils.formatObject(cccMarcaSituaData.getCodMarcSitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaSituaData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccMarcaSituaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaSituaData.getIndCuenCast() != null ? 
				FormatUtils.formatObject(cccMarcaSituaData.getIndCuenCast(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaSituaData.getValObse() != null ? 
				FormatUtils.formatObject(cccMarcaSituaData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccMarcaSituaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
