
/*
    INDRA/CAR/mmg
    $Id: RecAutorFormFormatter.java,v 1.1 2009/12/03 18:42:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecAutor" para Druida
 * 
 * @author Indra
 */
public class RecAutorFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecAutorFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recAutorList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recAutorList.size(); i++) {
		
			RecAutorData recAutorData = (RecAutorData) recAutorList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recAutorData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recAutorData.getCodUsua() != null ? recAutorData.getCodUsua().getId() : null));
			row.add((recAutorData.getTiopOidTipoOper() != null ? recAutorData.getTiopOidTipoOper().getId() : null));
			row.add((recAutorData.getImpMaxi() != null ? 
				FormatUtils.formatObject(recAutorData.getImpMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recAutorData.getImpMontMaxiDife() != null ? 
				FormatUtils.formatObject(recAutorData.getImpMontMaxiDife(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recAutorData.getIndIngr() != null ? 
				FormatUtils.formatObject(recAutorData.getIndIngr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recAutorData.getIndDesb() != null ? 
				FormatUtils.formatObject(recAutorData.getIndDesb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recAutorData.getPaisOidPais() != null ? recAutorData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recAutorData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
