
/*
    INDRA/CAR/mmg
    $Id: MaeTipoDocumFormFormatter.java,v 1.1 2009/12/03 18:42:22 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoDocum" para Druida
 * 
 * @author Indra
 */
public class MaeTipoDocumFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoDocumFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoDocumList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeTipoDocumList.size(); i++) {
		
			MaeTipoDocumData maeTipoDocumData = (MaeTipoDocumData) maeTipoDocumList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeTipoDocumData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeTipoDocumData.getPaisOidPais() != null ? maeTipoDocumData.getPaisOidPais().getId() : null));
			row.add((maeTipoDocumData.getCodTipoDocu() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getCodTipoDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getIndObli() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getIndObli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getValSigl() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getValSigl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getValLong() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getValLong(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getIndDni() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getIndDni(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getIndDocIdenFisc() != null ? 
				FormatUtils.formatObject(maeTipoDocumData.getIndDocIdenFisc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeTipoDocumData.getTidoOidTipoDocu() != null ? maeTipoDocumData.getTidoOidTipoDocu().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeTipoDocumData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
