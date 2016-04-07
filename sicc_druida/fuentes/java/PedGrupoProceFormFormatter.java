
/*
    INDRA/CAR/mmg
    $Id: PedGrupoProceFormFormatter.java,v 1.1 2009/12/03 18:33:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedGrupoProce" para Druida
 * 
 * @author Indra
 */
public class PedGrupoProceFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedGrupoProceFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedGrupoProceList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedGrupoProceList.size(); i++) {
		
			PedGrupoProceData pedGrupoProceData = (PedGrupoProceData) pedGrupoProceList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = pedGrupoProceData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((pedGrupoProceData.getCodGrupProc() != null ? 
				FormatUtils.formatObject(pedGrupoProceData.getCodGrupProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedGrupoProceData.getDesGrupProc() != null ? 
				FormatUtils.formatObject(pedGrupoProceData.getDesGrupProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// A�adir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedGrupoProceData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
