
/*
    INDRA/CAR/mmg
    $Id: MsgMensaListFormatter.java,v 1.1 2009/12/03 18:43:27 pecbazalar Exp $
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
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.utils.*;

/**
 * Clase de formateo de objetos "MsgMensa" para Druida
 * 
 * @author Indra
 */
public class MsgMensaListFormatter extends MMGDruidaFormatoObjeto {
	
	public MsgMensaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector msgMensaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
				symbols) : ""));
			row.add((msgMensaData.getDesMens() != null ? 
				FormatUtils.formatObject(msgMensaData.getDesMens(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((msgMensaData.getValBloqGrupPerm() != null ? 
				FormatUtils.formatObject(msgMensaData.getValBloqGrupPerm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((msgMensaData.getFecPermDesd() != null ? 
				FormatUtils.formatObject(msgMensaData.getFecPermDesd(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((msgMensaData.getFecPermHast() != null ? 
				FormatUtils.formatObject(msgMensaData.getFecPermHast(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((msgMensaData.getValText() != null ? 
				FormatUtils.formatObject(msgMensaData.getValText(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(msgMensaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
