
/*
    INDRA/CAR/mmg
    $Id: CccCuentContaFormFormatter.java,v 1.1 2009/12/03 18:40:58 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentConta" para Druida
 * 
 * @author Indra
 */
public class CccCuentContaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentContaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentContaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccCuentContaList.size(); i++) {
		
			CccCuentContaData cccCuentContaData = (CccCuentContaData) cccCuentContaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentContaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccCuentContaData.getPaisOidPais() != null ? cccCuentContaData.getPaisOidPais().getId() : null));
			row.add((cccCuentContaData.getCodCuenCont() != null ? 
				FormatUtils.formatObject(cccCuentContaData.getCodCuenCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccCuentContaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaData.getCodCuenSap() != null ? 
				FormatUtils.formatObject(cccCuentContaData.getCodCuenSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaData.getValObse() != null ? 
				FormatUtils.formatObject(cccCuentContaData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccCuentContaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
