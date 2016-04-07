
/*
    INDRA/CAR/mmg
    $Id: MaeTipoClasiClienFormFormatter.java,v 1.1 2009/12/03 18:39:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoClasiClien" para Druida
 * 
 * @author Indra
 */
public class MaeTipoClasiClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoClasiClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoClasiClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoClasiClienList.size(); i++) {
		
			MaeTipoClasiClienData maeTipoClasiClienData = (MaeTipoClasiClienData) maeTipoClasiClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoClasiClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoClasiClienData.getSbtiOidSubtClie() != null ? maeTipoClasiClienData.getSbtiOidSubtClie().getId() : null));
			row.add((maeTipoClasiClienData.getCodTipoClas() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienData.getCodTipoClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoClasiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoClasiClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
