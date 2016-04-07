
/*
    INDRA/CAR/mmg
    $Id: MaeUnidaMedidFormFormatter.java,v 1.1 2009/12/03 18:41:21 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeUnidaMedid" para Druida
 * 
 * @author Indra
 */
public class MaeUnidaMedidFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeUnidaMedidFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeUnidaMedidList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeUnidaMedidList.size(); i++) {
		
			MaeUnidaMedidData maeUnidaMedidData = (MaeUnidaMedidData) maeUnidaMedidList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeUnidaMedidData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeUnidaMedidData.getPaisOidPais() != null ? maeUnidaMedidData.getPaisOidPais().getId() : null));
			row.add((maeUnidaMedidData.getCodUnidMedi() != null ? 
				FormatUtils.formatObject(maeUnidaMedidData.getCodUnidMedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeUnidaMedidData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeUnidaMedidData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeUnidaMedidData.getDesAbre() != null ? 
				FormatUtils.formatObject(maeUnidaMedidData.getDesAbre(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeUnidaMedidData.getMagnOidMagn() != null ? maeUnidaMedidData.getMagnOidMagn().getId() : null));
			row.add((maeUnidaMedidData.getIndUmStnd() != null ? 
				FormatUtils.formatObject(maeUnidaMedidData.getIndUmStnd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeUnidaMedidData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
