
/*
    INDRA/CAR/mmg
    $Id: SegSocieViewFormFormatter.java,v 1.1 2009/12/03 18:32:52 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegSocieView" para Druida
 * 
 * @author Indra
 */
public class SegSocieViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegSocieViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segSocieViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segSocieViewList.size(); i++) {
		
			SegSocieViewData segSocieViewData = (SegSocieViewData) segSocieViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segSocieViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segSocieViewData.getPaisOidPais() != null ? segSocieViewData.getPaisOidPais().getId() : null));
			row.add((segSocieViewData.getCodSoci() != null ? 
				FormatUtils.formatObject(segSocieViewData.getCodSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieViewData.getValDeno() != null ? 
				FormatUtils.formatObject(segSocieViewData.getValDeno(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieViewData.getValDire() != null ? 
				FormatUtils.formatObject(segSocieViewData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieViewData.getValTlfn() != null ? 
				FormatUtils.formatObject(segSocieViewData.getValTlfn(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieViewData.getValFax() != null ? 
				FormatUtils.formatObject(segSocieViewData.getValFax(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segSocieViewData.getValIdenFisc() != null ? 
				FormatUtils.formatObject(segSocieViewData.getValIdenFisc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segSocieViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
