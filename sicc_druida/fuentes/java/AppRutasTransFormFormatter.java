
/*
    INDRA/CAR/mmg
    $Id: AppRutasTransFormFormatter.java,v 1.1 2009/12/03 18:37:30 pecbazalar Exp $
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
 * Clase de formateo de objetos "AppRutasTrans" para Druida
 * 
 * @author Indra
 */
public class AppRutasTransFormFormatter extends MMGDruidaFormatoObjeto {
	
	public AppRutasTransFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector appRutasTransList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < appRutasTransList.size(); i++) {
		
			AppRutasTransData appRutasTransData = (AppRutasTransData) appRutasTransList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = appRutasTransData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((appRutasTransData.getPaisOidPais() != null ? appRutasTransData.getPaisOidPais().getId() : null));
			row.add((appRutasTransData.getCodRuta() != null ? 
				FormatUtils.formatObject(appRutasTransData.getCodRuta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((appRutasTransData.getDescripcion() != null ? 
				FormatUtils.formatObject(appRutasTransData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((appRutasTransData.getNumSecu() != null ? 
				FormatUtils.formatObject(appRutasTransData.getNumSecu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((appRutasTransData.getValObse() != null ? 
				FormatUtils.formatObject(appRutasTransData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(appRutasTransData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
