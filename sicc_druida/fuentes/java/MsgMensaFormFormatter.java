
/*
    INDRA/CAR/mmg
    $Id: MsgMensaFormFormatter.java,v 1.1 2009/12/03 18:34:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "MsgMensa" para Druida
 * 
 * @author Indra
 */
public class MsgMensaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgMensaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgMensaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < msgMensaList.size(); i++) {
		
			MsgMensaData msgMensaData = (MsgMensaData) msgMensaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = msgMensaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((msgMensaData.getCodMens() != null ? 
				FormatUtils.formatObject(msgMensaData.getCodMens(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMensaData.getDesMens() != null ? 
				FormatUtils.formatObject(msgMensaData.getDesMens(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMensaData.getValBloqGrupPerm() != null ? 
				FormatUtils.formatObject(msgMensaData.getValBloqGrupPerm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMensaData.getFecPermDesd() != null ? 
				FormatUtils.formatObject(msgMensaData.getFecPermDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMensaData.getFecPermHast() != null ? 
				FormatUtils.formatObject(msgMensaData.getFecPermHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((msgMensaData.getValText() != null ? 
				FormatUtils.formatObject(msgMensaData.getValText(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(msgMensaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
