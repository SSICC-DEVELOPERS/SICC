
/*
    INDRA/CAR/mmg
    $Id: CalGuiasFormFormatter.java,v 1.1 2009/12/03 18:42:48 pecbazalar Exp $
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
 * Clase de formateo de objetos "CalGuias" para Druida
 * 
 * @author Indra
 */
public class CalGuiasFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CalGuiasFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector calGuiasList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < calGuiasList.size(); i++) {
		
			CalGuiasData calGuiasData = (CalGuiasData) calGuiasList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = calGuiasData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((calGuiasData.getCodGuia() != null ? 
				FormatUtils.formatObject(calGuiasData.getCodGuia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calGuiasData.getDpteOidDepa() != null ? calGuiasData.getDpteOidDepa().getId() : null));
			row.add((calGuiasData.getValTitu() != null ? 
				FormatUtils.formatObject(calGuiasData.getValTitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calGuiasData.getFecInicVali() != null ? 
				FormatUtils.formatObject(calGuiasData.getFecInicVali(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calGuiasData.getFecFinVali() != null ? 
				FormatUtils.formatObject(calGuiasData.getFecFinVali(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calGuiasData.getValDescGuia() != null ? 
				FormatUtils.formatObject(calGuiasData.getValDescGuia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((calGuiasData.getPaisOidPais() != null ? calGuiasData.getPaisOidPais().getId() : null));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(calGuiasData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
