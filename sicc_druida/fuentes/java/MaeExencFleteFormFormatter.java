
/*
    INDRA/CAR/mmg
    $Id: MaeExencFleteFormFormatter.java,v 1.1 2009/12/03 18:40:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeExencFlete" para Druida
 * 
 * @author Indra
 */
public class MaeExencFleteFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeExencFleteFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeExencFleteList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeExencFleteList.size(); i++) {
		
			MaeExencFleteData maeExencFleteData = (MaeExencFleteData) maeExencFleteList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeExencFleteData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeExencFleteData.getPaisOidPais() != null ? maeExencFleteData.getPaisOidPais().getId() : null));
			row.add((maeExencFleteData.getTiclOidTipoClie() != null ? maeExencFleteData.getTiclOidTipoClie().getId() : null));
			row.add((maeExencFleteData.getSbtiOidSubtClie() != null ? maeExencFleteData.getSbtiOidSubtClie().getId() : null));
			row.add((maeExencFleteData.getTcclOidTipoClas() != null ? maeExencFleteData.getTcclOidTipoClas().getId() : null));
			row.add((maeExencFleteData.getClasOidClas() != null ? maeExencFleteData.getClasOidClas().getId() : null));
			row.add((maeExencFleteData.getIndExenFlet() != null ? 
				FormatUtils.formatObject(maeExencFleteData.getIndExenFlet(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeExencFleteData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
