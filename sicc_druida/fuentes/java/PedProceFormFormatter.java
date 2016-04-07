
/*
    INDRA/CAR/mmg
    $Id: PedProceFormFormatter.java,v 1.1 2009/12/03 18:42:43 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedProce" para Druida
 * 
 * @author Indra
 */
public class PedProceFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedProceFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedProceList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedProceList.size(); i++) {
		
			PedProceData pedProceData = (PedProceData) pedProceList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedProceData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedProceData.getCodProc() != null ? 
				FormatUtils.formatObject(pedProceData.getCodProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedProceData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedProceData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedProceData.getGrprOidGrupProc() != null ? pedProceData.getGrprOidGrupProc().getId() : null));
			row.add((pedProceData.getProgOidProg() != null ? pedProceData.getProgOidProg().getId() : null));
			row.add((pedProceData.getProcOidProc() != null ? pedProceData.getProcOidProc().getId() : null));
			row.add((pedProceData.getTposOidTipoPosi() != null ? pedProceData.getTposOidTipoPosi().getId() : null));
			row.add((pedProceData.getStpoOidSubtPosi() != null ? pedProceData.getStpoOidSubtPosi().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedProceData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
