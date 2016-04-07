
/*
    INDRA/CAR/mmg
    $Id: SegTipoPerioFormFormatter.java,v 1.1 2009/12/03 18:35:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegTipoPerio" para Druida
 * 
 * @author Indra
 */
public class SegTipoPerioFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegTipoPerioFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segTipoPerioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segTipoPerioList.size(); i++) {
		
			SegTipoPerioData segTipoPerioData = (SegTipoPerioData) segTipoPerioList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segTipoPerioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segTipoPerioData.getCodTipoPeri() != null ? 
				FormatUtils.formatObject(segTipoPerioData.getCodTipoPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoPerioData.getDescripcion() != null ? 
				FormatUtils.formatObject(segTipoPerioData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoPerioData.getNumDias() != null ? 
				FormatUtils.formatObject(segTipoPerioData.getNumDias(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segTipoPerioData.getNumPeriAnio() != null ? 
				FormatUtils.formatObject(segTipoPerioData.getNumPeriAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segTipoPerioData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
