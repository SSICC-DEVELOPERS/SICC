
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicViewFormFormatter.java,v 1.1 2009/12/03 18:39:43 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolicView" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedTipoSolicViewList.size(); i++) {
		
			PedTipoSolicViewData pedTipoSolicViewData = (PedTipoSolicViewData) pedTipoSolicViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoSolicViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTipoSolicViewData.getCodTipoSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getCodTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getIndCons() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getIndCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getIndSoliNega() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getIndSoliNega(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getIndDevo() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getIndDevo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getIndAnul() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getCodGrupSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getCodGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTipoSolicViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTipoSolicViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
