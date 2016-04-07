
/*
    INDRA/CAR/mmg
    $Id: ZonEstadZonaFormFormatter.java,v 1.1 2009/12/03 18:37:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "ZonEstadZona" para Druida
 * 
 * @author Indra
 */
public class ZonEstadZonaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public ZonEstadZonaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector zonEstadZonaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < zonEstadZonaList.size(); i++) {
		
			ZonEstadZonaData zonEstadZonaData = (ZonEstadZonaData) zonEstadZonaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = zonEstadZonaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((zonEstadZonaData.getPaisOidPais() != null ? zonEstadZonaData.getPaisOidPais().getId() : null));
			row.add((zonEstadZonaData.getCodEstaZona() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getCodEstaZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getMarcOidMarc() != null ? zonEstadZonaData.getMarcOidMarc().getId() : null));
			row.add((zonEstadZonaData.getDescripcion() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getIndInic() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getIndInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getImpoVentMini() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getImpoVentMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getNumConsMin() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getNumConsMin(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getNumPediZona() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getNumPediZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((zonEstadZonaData.getValoTiemMini() != null ? 
				FormatUtils.formatObject(zonEstadZonaData.getValoTiemMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(zonEstadZonaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
