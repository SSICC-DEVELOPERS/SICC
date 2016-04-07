
/*
    INDRA/CAR/mmg
    $Id: FacImpreVirtuFormFormatter.java,v 1.1 2009/12/03 18:34:28 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacImpreVirtu" para Druida
 * 
 * @author Indra
 */
public class FacImpreVirtuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacImpreVirtuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facImpreVirtuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facImpreVirtuList.size(); i++) {
		
			FacImpreVirtuData facImpreVirtuData = (FacImpreVirtuData) facImpreVirtuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facImpreVirtuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facImpreVirtuData.getCodImpr() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getCodImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getDesImpr() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getDesImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getTiimOidTipo() != null ? facImpreVirtuData.getTiimOidTipo().getId() : null));
			row.add((facImpreVirtuData.getIndEstaActi() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getIndEstaActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getValAtr1() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getValAtr1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getValAtr2() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getValAtr2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getValAtr3() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getValAtr3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getValAtr4() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getValAtr4(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getValTamaBuff() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getValTamaBuff(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facImpreVirtuData.getNumSecu() != null ? 
				FormatUtils.formatObject(facImpreVirtuData.getNumSecu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facImpreVirtuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
