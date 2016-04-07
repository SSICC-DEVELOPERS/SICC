
/*
    INDRA/CAR/mmg
    $Id: MsgParamMensaFormFormatter.java,v 1.1 2009/12/03 18:43:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgParamMensa" para Druida
 * 
 * @author Indra
 */
public class MsgParamMensaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgParamMensaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgParamMensaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgParamMensaList.size(); i++) {
		
			MsgParamMensaData msgParamMensaData = (MsgParamMensaData) msgParamMensaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = msgParamMensaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((msgParamMensaData.getPaisOidPais() != null ? msgParamMensaData.getPaisOidPais().getId() : null));
			row.add((msgParamMensaData.getCodDatoVari() != null ? 
				FormatUtils.formatObject(msgParamMensaData.getCodDatoVari(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgParamMensaData.getDesDatoVari() != null ? 
				FormatUtils.formatObject(msgParamMensaData.getDesDatoVari(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgParamMensaData.getFecSist() != null ? 
				FormatUtils.formatObject(msgParamMensaData.getFecSist(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgParamMensaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
