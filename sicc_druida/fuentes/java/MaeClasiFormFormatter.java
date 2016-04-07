
/*
    INDRA/CAR/mmg
    $Id: MaeClasiFormFormatter.java,v 1.1 2009/12/03 18:40:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClasi" para Druida
 * 
 * @author Indra
 */
public class MaeClasiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClasiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClasiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeClasiList.size(); i++) {
		
			MaeClasiData maeClasiData = (MaeClasiData) maeClasiList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = maeClasiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((maeClasiData.getTcclOidTipoClas() != null ? maeClasiData.getTcclOidTipoClas().getId() : null));
			row.add((maeClasiData.getCodClas() != null ? 
				FormatUtils.formatObject(maeClasiData.getCodClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClasiData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeClasiData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeClasiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
