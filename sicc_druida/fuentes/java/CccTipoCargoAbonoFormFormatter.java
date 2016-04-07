
/*
    INDRA/CAR/mmg
    $Id: CccTipoCargoAbonoFormFormatter.java,v 1.1 2009/12/03 18:33:54 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccTipoCargoAbono" para Druida
 * 
 * @author Indra
 */
public class CccTipoCargoAbonoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccTipoCargoAbonoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccTipoCargoAbonoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccTipoCargoAbonoList.size(); i++) {
		
			CccTipoCargoAbonoData cccTipoCargoAbonoData = (CccTipoCargoAbonoData) cccTipoCargoAbonoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccTipoCargoAbonoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccTipoCargoAbonoData.getPaisOidPais() != null ? cccTipoCargoAbonoData.getPaisOidPais().getId() : null));
			row.add((cccTipoCargoAbonoData.getCodTipoCargAbon() != null ? 
				FormatUtils.formatObject(cccTipoCargoAbonoData.getCodTipoCargAbon(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoCargoAbonoData.getDescripcion() != null ? 
				FormatUtils.formatObject(cccTipoCargoAbonoData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccTipoCargoAbonoData.getValObse() != null ? 
				FormatUtils.formatObject(cccTipoCargoAbonoData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccTipoCargoAbonoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
