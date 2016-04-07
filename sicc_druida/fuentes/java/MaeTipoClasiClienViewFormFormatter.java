
/*
    INDRA/CAR/mmg
    $Id: MaeTipoClasiClienViewFormFormatter.java,v 1.1 2009/12/03 18:38:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoClasiClienView" para Druida
 * 
 * @author Indra
 */
public class MaeTipoClasiClienViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoClasiClienViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoClasiClienViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoClasiClienViewList.size(); i++) {
		
			MaeTipoClasiClienViewData maeTipoClasiClienViewData = (MaeTipoClasiClienViewData) maeTipoClasiClienViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoClasiClienViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoClasiClienViewData.getCodTipoClas() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienViewData.getCodTipoClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoClasiClienViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoClasiClienViewData.getSbtiOidSubtClie() != null ? maeTipoClasiClienViewData.getSbtiOidSubtClie().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoClasiClienViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
