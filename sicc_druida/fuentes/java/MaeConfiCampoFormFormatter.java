
/*
    INDRA/CAR/mmg
    $Id: MaeConfiCampoFormFormatter.java,v 1.1 2009/12/03 18:43:44 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeConfiCampo" para Druida
 * 
 * @author Indra
 */
public class MaeConfiCampoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeConfiCampoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeConfiCampoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeConfiCampoList.size(); i++) {
		
			MaeConfiCampoData maeConfiCampoData = (MaeConfiCampoData) maeConfiCampoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeConfiCampoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeConfiCampoData.getPaisOidPais() != null ? maeConfiCampoData.getPaisOidPais().getId() : null));
			row.add((maeConfiCampoData.getSbtiOidSubtClie() != null ? maeConfiCampoData.getSbtiOidSubtClie().getId() : null));
			row.add((maeConfiCampoData.getAtreOidAtriEspe() != null ? maeConfiCampoData.getAtreOidAtriEspe().getId() : null));
			row.add((maeConfiCampoData.getValDefe() != null ? 
				FormatUtils.formatObject(maeConfiCampoData.getValDefe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeConfiCampoData.getIndObli() != null ? 
				FormatUtils.formatObject(maeConfiCampoData.getIndObli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeConfiCampoData.getIndModi() != null ? 
				FormatUtils.formatObject(maeConfiCampoData.getIndModi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeConfiCampoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
