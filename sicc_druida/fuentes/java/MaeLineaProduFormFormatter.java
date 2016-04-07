
/*
    INDRA/CAR/mmg
    $Id: MaeLineaProduFormFormatter.java,v 1.1 2009/12/03 18:34:56 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeLineaProdu" para Druida
 * 
 * @author Indra
 */
public class MaeLineaProduFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeLineaProduFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeLineaProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeLineaProduList.size(); i++) {
		
			MaeLineaProduData maeLineaProduData = (MaeLineaProduData) maeLineaProduList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeLineaProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeLineaProduData.getPaisOidPais() != null ? maeLineaProduData.getPaisOidPais().getId() : null));
			row.add((maeLineaProduData.getCodLineProd() != null ? 
				FormatUtils.formatObject(maeLineaProduData.getCodLineProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeLineaProduData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeLineaProduData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeLineaProduData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
