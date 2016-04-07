
/*
    INDRA/CAR/mmg
    $Id: SegIdiomFormFormatter.java,v 1.1 2009/12/03 18:41:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegIdiom" para Druida
 * 
 * @author Indra
 */
public class SegIdiomFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegIdiomFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segIdiomList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segIdiomList.size(); i++) {
		
			SegIdiomData segIdiomData = (SegIdiomData) segIdiomList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segIdiomData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segIdiomData.getCodIdio() != null ? 
				FormatUtils.formatObject(segIdiomData.getCodIdio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segIdiomData.getDescripcion() != null ? 
				FormatUtils.formatObject(segIdiomData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segIdiomData.getIndIdioTrad() != null ? 
				FormatUtils.formatObject(segIdiomData.getIndIdioTrad(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segIdiomData.getCodIsoIdio() != null ? 
				FormatUtils.formatObject(segIdiomData.getCodIsoIdio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segIdiomData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
