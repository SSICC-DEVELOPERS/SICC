
/*
    INDRA/CAR/mmg
    $Id: SegSocieFormFormatter.java,v 1.1 2009/12/03 18:38:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegSocie" para Druida
 * 
 * @author Indra
 */
public class SegSocieFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegSocieFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segSocieList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segSocieList.size(); i++) {
		
			SegSocieData segSocieData = (SegSocieData) segSocieList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segSocieData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segSocieData.getPaisOidPais() != null ? segSocieData.getPaisOidPais().getId() : null));
			row.add((segSocieData.getCodSoci() != null ? 
				FormatUtils.formatObject(segSocieData.getCodSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieData.getValDeno() != null ? 
				FormatUtils.formatObject(segSocieData.getValDeno(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieData.getValDire() != null ? 
				FormatUtils.formatObject(segSocieData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieData.getValTlfn() != null ? 
				FormatUtils.formatObject(segSocieData.getValTlfn(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieData.getValFax() != null ? 
				FormatUtils.formatObject(segSocieData.getValFax(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieData.getValIdenFisc() != null ? 
				FormatUtils.formatObject(segSocieData.getValIdenFisc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segSocieData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
