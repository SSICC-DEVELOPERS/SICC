
/*
    INDRA/CAR/mmg
    $Id: MaeTipoVincuFormFormatter.java,v 1.1 2009/12/03 18:39:09 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoVincu" para Druida
 * 
 * @author Indra
 */
public class MaeTipoVincuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoVincuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoVincuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoVincuList.size(); i++) {
		
			MaeTipoVincuData maeTipoVincuData = (MaeTipoVincuData) maeTipoVincuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoVincuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoVincuData.getPaisOidPais() != null ? maeTipoVincuData.getPaisOidPais().getId() : null));
			row.add((maeTipoVincuData.getCodTipoVinc() != null ? 
				FormatUtils.formatObject(maeTipoVincuData.getCodTipoVinc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoVincuData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoVincuData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoVincuData.getIndReco() != null ? 
				FormatUtils.formatObject(maeTipoVincuData.getIndReco(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoVincuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
