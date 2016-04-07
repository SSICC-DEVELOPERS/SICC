
/*
    INDRA/CAR/mmg
    $Id: CccCuentContaViewFormFormatter.java,v 1.1 2009/12/03 18:39:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentContaView" para Druida
 * 
 * @author Indra
 */
public class CccCuentContaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentContaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentContaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccCuentContaViewList.size(); i++) {
		
			CccCuentContaViewData cccCuentContaViewData = (CccCuentContaViewData) cccCuentContaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentContaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccCuentContaViewData.getPaisOidPais() != null ? cccCuentContaViewData.getPaisOidPais().getId() : null));
			row.add((cccCuentContaViewData.getCodCuenCont() != null ? 
				FormatUtils.formatObject(cccCuentContaViewData.getCodCuenCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccCuentContaViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaViewData.getCodCuenSap() != null ? 
				FormatUtils.formatObject(cccCuentContaViewData.getCodCuenSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentContaViewData.getValObse() != null ? 
				FormatUtils.formatObject(cccCuentContaViewData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccCuentContaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
