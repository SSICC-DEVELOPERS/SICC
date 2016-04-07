
/*
    INDRA/CAR/mmg
    $Id: MaeCicloVidaFormFormatter.java,v 1.1 2009/12/03 18:40:55 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeCicloVida" para Druida
 * 
 * @author Indra
 */
public class MaeCicloVidaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeCicloVidaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeCicloVidaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeCicloVidaList.size(); i++) {
		
			MaeCicloVidaData maeCicloVidaData = (MaeCicloVidaData) maeCicloVidaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeCicloVidaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeCicloVidaData.getPaisOidPais() != null ? maeCicloVidaData.getPaisOidPais().getId() : null));
			row.add((maeCicloVidaData.getCodCiclVida() != null ? 
				FormatUtils.formatObject(maeCicloVidaData.getCodCiclVida(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeCicloVidaData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeCicloVidaData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeCicloVidaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
