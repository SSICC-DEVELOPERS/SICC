
/*
    INDRA/CAR/mmg
    $Id: CccSubprFormFormatter.java,v 1.1 2009/12/03 18:36:32 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccSubpr" para Druida
 * 
 * @author Indra
 */
public class CccSubprFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccSubprFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccSubprList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccSubprList.size(); i++) {
		
			CccSubprData cccSubprData = (CccSubprData) cccSubprList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccSubprData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccSubprData.getCcprOidProc() != null ? cccSubprData.getCcprOidProc().getId() : null));
			row.add((cccSubprData.getCodSubp() != null ? 
				FormatUtils.formatObject(cccSubprData.getCodSubp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getDesSubp() != null ? 
				FormatUtils.formatObject(cccSubprData.getDesSubp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getValIndiGestMarc() != null ? 
				FormatUtils.formatObject(cccSubprData.getValIndiGestMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getValIndiActuCuot() != null ? 
				FormatUtils.formatObject(cccSubprData.getValIndiActuCuot(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getValIndiTipoAbon() != null ? 
				FormatUtils.formatObject(cccSubprData.getValIndiTipoAbon(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getValIndiCons() != null ? 
				FormatUtils.formatObject(cccSubprData.getValIndiCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSubprData.getValObse() != null ? 
				FormatUtils.formatObject(cccSubprData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccSubprData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
