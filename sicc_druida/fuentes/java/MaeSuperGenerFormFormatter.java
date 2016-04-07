
/*
    INDRA/CAR/mmg
    $Id: MaeSuperGenerFormFormatter.java,v 1.1 2009/12/03 18:41:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeSuperGener" para Druida
 * 
 * @author Indra
 */
public class MaeSuperGenerFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeSuperGenerFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeSuperGenerList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeSuperGenerList.size(); i++) {
		
			MaeSuperGenerData maeSuperGenerData = (MaeSuperGenerData) maeSuperGenerList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeSuperGenerData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeSuperGenerData.getPaisOidPais() != null ? maeSuperGenerData.getPaisOidPais().getId() : null));
			row.add((maeSuperGenerData.getCodSupeGene() != null ? 
				FormatUtils.formatObject(maeSuperGenerData.getCodSupeGene(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeSuperGenerData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeSuperGenerData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeSuperGenerData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
