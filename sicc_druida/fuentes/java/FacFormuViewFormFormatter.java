
/*
    INDRA/CAR/mmg
    $Id: FacFormuViewFormFormatter.java,v 1.1 2009/12/03 18:39:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacFormuView" para Druida
 * 
 * @author Indra
 */
public class FacFormuViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacFormuViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facFormuViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facFormuViewList.size(); i++) {
		
			FacFormuViewData facFormuViewData = (FacFormuViewData) facFormuViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facFormuViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facFormuViewData.getCodForm() != null ? 
				FormatUtils.formatObject(facFormuViewData.getCodForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuViewData.getDeimOidDestImpr() != null ? facFormuViewData.getDeimOidDestImpr().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facFormuViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
