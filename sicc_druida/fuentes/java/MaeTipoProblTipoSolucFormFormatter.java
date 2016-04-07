
/*
    INDRA/CAR/mmg
    $Id: MaeTipoProblTipoSolucFormFormatter.java,v 1.1 2009/12/03 18:32:28 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoProblTipoSoluc" para Druida
 * 
 * @author Indra
 */
public class MaeTipoProblTipoSolucFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoProblTipoSolucFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoProblTipoSolucList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoProblTipoSolucList.size(); i++) {
		
			MaeTipoProblTipoSolucData maeTipoProblTipoSolucData = (MaeTipoProblTipoSolucData) maeTipoProblTipoSolucList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoProblTipoSolucData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoProblTipoSolucData.getTipbOidTipoProb() != null ? maeTipoProblTipoSolucData.getTipbOidTipoProb().getId() : null));
			row.add((maeTipoProblTipoSolucData.getTsocOidTipoSolu() != null ? maeTipoProblTipoSolucData.getTsocOidTipoSolu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoProblTipoSolucData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
