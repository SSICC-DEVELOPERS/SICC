
/*
    INDRA/CAR/mmg
    $Id: CccProceFormFormatter.java,v 1.1 2009/12/03 18:37:20 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccProce" para Druida
 * 
 * @author Indra
 */
public class CccProceFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccProceFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccProceList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccProceList.size(); i++) {
		
			CccProceData cccProceData = (CccProceData) cccProceList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccProceData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccProceData.getPaisOidPais() != null ? cccProceData.getPaisOidPais().getId() : null));
			row.add((cccProceData.getCodProc() != null ? 
				FormatUtils.formatObject(cccProceData.getCodProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccProceData.getDesProc() != null ? 
				FormatUtils.formatObject(cccProceData.getDesProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccProceData.getIndCvDire() != null ? 
				FormatUtils.formatObject(cccProceData.getIndCvDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccProceData.getValObse() != null ? 
				FormatUtils.formatObject(cccProceData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccProceData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
