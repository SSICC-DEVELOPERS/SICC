
/*
    INDRA/CAR/mmg
    $Id: MaeEstatProduFormFormatter.java,v 1.1 2009/12/03 18:36:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeEstatProdu" para Druida
 * 
 * @author Indra
 */
public class MaeEstatProduFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeEstatProduFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeEstatProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeEstatProduList.size(); i++) {
		
			MaeEstatProduData maeEstatProduData = (MaeEstatProduData) maeEstatProduList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeEstatProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeEstatProduData.getPaisOidPais() != null ? maeEstatProduData.getPaisOidPais().getId() : null));
			row.add((maeEstatProduData.getCodEstaProd() != null ? 
				FormatUtils.formatObject(maeEstatProduData.getCodEstaProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeEstatProduData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeEstatProduData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeEstatProduData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
