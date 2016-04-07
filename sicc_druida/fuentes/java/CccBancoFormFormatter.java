
/*
    INDRA/CAR/mmg
    $Id: CccBancoFormFormatter.java,v 1.1 2009/12/03 18:37:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccBanco" para Druida
 * 
 * @author Indra
 */
public class CccBancoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccBancoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccBancoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccBancoList.size(); i++) {
		
			CccBancoData cccBancoData = (CccBancoData) cccBancoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccBancoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccBancoData.getPaisOidPais() != null ? cccBancoData.getPaisOidPais().getId() : null));
			row.add((cccBancoData.getCodBanc() != null ? 
				FormatUtils.formatObject(cccBancoData.getCodBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccBancoData.getDesBanc() != null ? 
				FormatUtils.formatObject(cccBancoData.getDesBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccBancoData.getCodBrio() != null ? 
				FormatUtils.formatObject(cccBancoData.getCodBrio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccBancoData.getCodSwifInfo() != null ? 
				FormatUtils.formatObject(cccBancoData.getCodSwifInfo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccBancoData.getValObsBanc() != null ? 
				FormatUtils.formatObject(cccBancoData.getValObsBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccBancoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
