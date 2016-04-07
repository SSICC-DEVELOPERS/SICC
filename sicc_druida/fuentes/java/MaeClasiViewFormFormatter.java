
/*
    INDRA/CAR/mmg
    $Id: MaeClasiViewFormFormatter.java,v 1.1 2009/12/03 18:37:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClasiView" para Druida
 * 
 * @author Indra
 */
public class MaeClasiViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClasiViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClasiViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeClasiViewList.size(); i++) {
		
			MaeClasiViewData maeClasiViewData = (MaeClasiViewData) maeClasiViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClasiViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeClasiViewData.getTcclOidTipoClas() != null ? maeClasiViewData.getTcclOidTipoClas().getId() : null));
			row.add((maeClasiViewData.getCodClas() != null ? 
				FormatUtils.formatObject(maeClasiViewData.getCodClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClasiViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeClasiViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeClasiViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
