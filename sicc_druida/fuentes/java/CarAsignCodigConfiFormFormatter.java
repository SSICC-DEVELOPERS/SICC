
/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiFormFormatter.java,v 1.1 2009/12/03 18:40:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarAsignCodigConfi" para Druida
 * 
 * @author Indra
 */
public class CarAsignCodigConfiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarAsignCodigConfiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carAsignCodigConfiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carAsignCodigConfiList.size(); i++) {
		
			CarAsignCodigConfiData carAsignCodigConfiData = (CarAsignCodigConfiData) carAsignCodigConfiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carAsignCodigConfiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carAsignCodigConfiData.getZsgvOidSubgVent() != null ? carAsignCodigConfiData.getZsgvOidSubgVent().getId() : null));
			row.add((carAsignCodigConfiData.getZorgOidRegi() != null ? carAsignCodigConfiData.getZorgOidRegi().getId() : null));
			row.add((carAsignCodigConfiData.getZzonOidZona() != null ? carAsignCodigConfiData.getZzonOidZona().getId() : null));
			row.add((carAsignCodigConfiData.getGrsoOidGrupSoli() != null ? carAsignCodigConfiData.getGrsoOidGrupSoli().getId() : null));
			row.add((carAsignCodigConfiData.getNiriOidNiveRies() != null ? carAsignCodigConfiData.getNiriOidNiveRies().getId() : null));
			row.add((carAsignCodigConfiData.getNiriOidNiveRiesInici() != null ? carAsignCodigConfiData.getNiriOidNiveRiesInici().getId() : null));
			row.add((carAsignCodigConfiData.getPacaOidParaCart() != null ? carAsignCodigConfiData.getPacaOidParaCart().getId() : null));
			row.add((carAsignCodigConfiData.getValLineCredInic() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getValLineCredInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carAsignCodigConfiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
