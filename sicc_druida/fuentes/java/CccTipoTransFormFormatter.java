
/*
    INDRA/CAR/mmg
    $Id: CccTipoTransFormFormatter.java,v 1.1 2009/12/03 18:36:28 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoTrans" para Druida
 * 
 * @author Indra
 */
public class CccTipoTransFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoTransFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoTransList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccTipoTransList.size(); i++) {
		
			CccTipoTransData cccTipoTransData = (CccTipoTransData) cccTipoTransList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccTipoTransData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccTipoTransData.getPaisOidPais() != null ? cccTipoTransData.getPaisOidPais().getId() : null));
			row.add((cccTipoTransData.getCodTipoTran() != null ? 
				FormatUtils.formatObject(cccTipoTransData.getCodTipoTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoTransData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccTipoTransData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoTransData.getCodTipoTranCheq() != null ? 
				FormatUtils.formatObject(cccTipoTransData.getCodTipoTranCheq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccTipoTransData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
