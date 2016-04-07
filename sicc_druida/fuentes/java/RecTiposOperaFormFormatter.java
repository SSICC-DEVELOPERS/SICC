
/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaFormFormatter.java,v 1.1 2009/12/03 18:35:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecTiposOpera" para Druida
 * 
 * @author Indra
 */
public class RecTiposOperaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecTiposOperaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recTiposOperaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recTiposOperaList.size(); i++) {
		
			RecTiposOperaData recTiposOperaData = (RecTiposOperaData) recTiposOperaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recTiposOperaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recTiposOperaData.getValTipoOper() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getValTipoOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getIndCampRefeUnic() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndCampRefeUnic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getNumDiasHaciAtra() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getNumDiasHaciAtra(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getValInfoEbelNoti() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getValInfoEbelNoti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getIndDevuEstaFact() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndDevuEstaFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getIndEnviEstaFact() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndEnviEstaFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recTiposOperaData.getRopeOidOper() != null ? recTiposOperaData.getRopeOidOper().getId() : null));
			row.add((recTiposOperaData.getMrdbOidMotiRechDesb() != null ? recTiposOperaData.getMrdbOidMotiRechDesb().getId() : null));
			row.add((recTiposOperaData.getMoblOidBloqDife() != null ? recTiposOperaData.getMoblOidBloqDife().getId() : null));
			row.add((recTiposOperaData.getMoblOidReclAnte() != null ? recTiposOperaData.getMoblOidReclAnte().getId() : null));
			row.add((recTiposOperaData.getMoblOidBloqImpo() != null ? recTiposOperaData.getMoblOidBloqImpo().getId() : null));
			row.add((recTiposOperaData.getMoblOidBloqUnid() != null ? recTiposOperaData.getMoblOidBloqUnid().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recTiposOperaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
