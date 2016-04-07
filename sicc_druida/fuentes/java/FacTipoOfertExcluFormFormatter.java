
/*
    INDRA/CAR/mmg
    $Id: FacTipoOfertExcluFormFormatter.java,v 1.1 2009/12/03 18:38:03 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacTipoOfertExclu" para Druida
 * 
 * @author Indra
 */
public class FacTipoOfertExcluFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacTipoOfertExcluFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facTipoOfertExcluList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facTipoOfertExcluList.size(); i++) {
		
			FacTipoOfertExcluData facTipoOfertExcluData = (FacTipoOfertExcluData) facTipoOfertExcluList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = facTipoOfertExcluData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((facTipoOfertExcluData.getPaisOidPais() != null ? facTipoOfertExcluData.getPaisOidPais().getId() : null));
			row.add((facTipoOfertExcluData.getFecDesd() != null ? 
				FormatUtils.formatObject(facTipoOfertExcluData.getFecDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facTipoOfertExcluData.getFecHast() != null ? 
				FormatUtils.formatObject(facTipoOfertExcluData.getFecHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facTipoOfertExcluData.getTofeOidTipoOfer() != null ? facTipoOfertExcluData.getTofeOidTipoOfer().getId() : null));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facTipoOfertExcluData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
