
/*
    INDRA/CAR/mmg
    $Id: CraActivFormFormatter.java,v 1.1 2009/12/03 18:43:13 pecbazalar Exp $
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
 * Clase de formateo de objetos "CraActiv" para Druida
 * 
 * @author Indra
 */
public class CraActivFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CraActivFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector craActivList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < craActivList.size(); i++) {
		
			CraActivData craActivData = (CraActivData) craActivList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = craActivData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((craActivData.getCodActi() != null ? 
				FormatUtils.formatObject(craActivData.getCodActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getNumDiasDesp() != null ? 
				FormatUtils.formatObject(craActivData.getNumDiasDesp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getNumCampAnte() != null ? 
				FormatUtils.formatObject(craActivData.getNumCampAnte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getIndEbel() != null ? 
				FormatUtils.formatObject(craActivData.getIndEbel(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getIndFest() != null ? 
				FormatUtils.formatObject(craActivData.getIndFest(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getIndLabo() != null ? 
				FormatUtils.formatObject(craActivData.getIndLabo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craActivData.getDescripcion() != null ? 
				FormatUtils.formatObject(craActivData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(craActivData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
