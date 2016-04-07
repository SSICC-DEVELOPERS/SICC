
/*
    INDRA/CAR/mmg
    $Id: ZonEstruGeopoFormFormatter.java,v 1.1 2009/12/03 18:42:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonEstruGeopo" para Druida
 * 
 * @author Indra
 */
public class ZonEstruGeopoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonEstruGeopoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonEstruGeopoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonEstruGeopoList.size(); i++) {
		
			ZonEstruGeopoData zonEstruGeopoData = (ZonEstruGeopoData) zonEstruGeopoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonEstruGeopoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonEstruGeopoData.getCodOrde() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getCodOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstruGeopoData.getIndBorr() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getIndBorr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstruGeopoData.getPaisOidPais() != null ? zonEstruGeopoData.getPaisOidPais().getId() : null));
			row.add((zonEstruGeopoData.getDipoOidDiviPoli() != null ? zonEstruGeopoData.getDipoOidDiviPoli().getId() : null));
			row.add((zonEstruGeopoData.getFecActu() != null ? 
				FormatUtils.formatObject(zonEstruGeopoData.getFecActu(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonEstruGeopoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
