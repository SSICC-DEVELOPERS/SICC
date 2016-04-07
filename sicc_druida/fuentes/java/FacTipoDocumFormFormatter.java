
/*
    INDRA/CAR/mmg
    $Id: FacTipoDocumFormFormatter.java,v 1.1 2009/12/03 18:35:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacTipoDocum" para Druida
 * 
 * @author Indra
 */
public class FacTipoDocumFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacTipoDocumFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facTipoDocumList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facTipoDocumList.size(); i++) {
		
			FacTipoDocumData facTipoDocumData = (FacTipoDocumData) facTipoDocumList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facTipoDocumData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facTipoDocumData.getCodTipoDocu() != null ? 
				FormatUtils.formatObject(facTipoDocumData.getCodTipoDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facTipoDocumData.getDesTipoDocu() != null ? 
				FormatUtils.formatObject(facTipoDocumData.getDesTipoDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facTipoDocumData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
