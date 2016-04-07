
/*
    INDRA/CAR/mmg
    $Id: CobUsuarEtapaCobraDetalFormFormatter.java,v 1.1 2009/12/03 18:38:26 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobUsuarEtapaCobraDetal" para Druida
 * 
 * @author Indra
 */
public class CobUsuarEtapaCobraDetalFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobUsuarEtapaCobraDetalFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobUsuarEtapaCobraDetalList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobUsuarEtapaCobraDetalList.size(); i++) {
		
			CobUsuarEtapaCobraDetalData cobUsuarEtapaCobraDetalData = (CobUsuarEtapaCobraDetalData) cobUsuarEtapaCobraDetalList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobUsuarEtapaCobraDetalData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobUsuarEtapaCobraDetalData.getUeccOidUsuaEtapCobr() != null ? cobUsuarEtapaCobraDetalData.getUeccOidUsuaEtapCobr().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getEdtcOidEtapDeudTipoCarg() != null ? cobUsuarEtapaCobraDetalData.getEdtcOidEtapDeudTipoCarg().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getZsgvOidSubgVent() != null ? cobUsuarEtapaCobraDetalData.getZsgvOidSubgVent().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getZorgOidRegi() != null ? cobUsuarEtapaCobraDetalData.getZorgOidRegi().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getZzonOidZona() != null ? cobUsuarEtapaCobraDetalData.getZzonOidZona().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getZsccOidSecc() != null ? cobUsuarEtapaCobraDetalData.getZsccOidSecc().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getTerrOidTerr() != null ? cobUsuarEtapaCobraDetalData.getTerrOidTerr().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getMelcOidMetoLiquCobr() != null ? cobUsuarEtapaCobraDetalData.getMelcOidMetoLiquCobr().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getEucoOidEstaUsuaEtapCobr() != null ? cobUsuarEtapaCobraDetalData.getEucoOidEstaUsuaEtapCobr().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getGacaOidGuioArguCabe() != null ? cobUsuarEtapaCobraDetalData.getGacaOidGuioArguCabe().getId() : null));
			row.add((cobUsuarEtapaCobraDetalData.getValObse() != null ? 
				FormatUtils.formatObject(cobUsuarEtapaCobraDetalData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobUsuarEtapaCobraDetalData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
