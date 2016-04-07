
/*
    INDRA/CAR/mmg
    $Id: PreTipoEstraFormFormatter.java,v 1.1 2009/12/03 18:33:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreTipoEstra" para Druida
 * 
 * @author Indra
 */
public class PreTipoEstraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreTipoEstraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preTipoEstraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preTipoEstraList.size(); i++) {
		
			PreTipoEstraData preTipoEstraData = (PreTipoEstraData) preTipoEstraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preTipoEstraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preTipoEstraData.getCodTipoEstr() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getCodTipoEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoEstraData.getDesTipoEstr() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getDesTipoEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoEstraData.getIndEstrGrup() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrGrup(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoEstraData.getIndEstrCond() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrCond(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoEstraData.getIndEstrVs() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrVs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoEstraData.getIndEstrPaqu() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrPaqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preTipoEstraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
