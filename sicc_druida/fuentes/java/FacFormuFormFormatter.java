
/*
    INDRA/CAR/mmg
    $Id: FacFormuFormFormatter.java,v 1.1 2009/12/03 18:42:36 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacFormu" para Druida
 * 
 * @author Indra
 */
public class FacFormuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacFormuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facFormuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facFormuList.size(); i++) {
		
			FacFormuData facFormuData = (FacFormuData) facFormuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facFormuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facFormuData.getCodForm() != null ? 
				FormatUtils.formatObject(facFormuData.getCodForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getNumLine() != null ? 
				FormatUtils.formatObject(facFormuData.getNumLine(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getValTamaForm() != null ? 
				FormatUtils.formatObject(facFormuData.getValTamaForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getValRutiDiseForm() != null ? 
				FormatUtils.formatObject(facFormuData.getValRutiDiseForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getIndImpr() != null ? 
				FormatUtils.formatObject(facFormuData.getIndImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getIndPrei() != null ? 
				FormatUtils.formatObject(facFormuData.getIndPrei(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getIndSpooIndi() != null ? 
				FormatUtils.formatObject(facFormuData.getIndSpooIndi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getTeimOidTecn() != null ? facFormuData.getTeimOidTecn().getId() : null));
			row.add((facFormuData.getValNombForm() != null ? 
				FormatUtils.formatObject(facFormuData.getValNombForm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getIndActi() != null ? 
				FormatUtils.formatObject(facFormuData.getIndActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getIndNumOfic() != null ? 
				FormatUtils.formatObject(facFormuData.getIndNumOfic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getNumLineSaltPagi() != null ? 
				FormatUtils.formatObject(facFormuData.getNumLineSaltPagi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facFormuData.getTidoOidTipoDocu() != null ? facFormuData.getTidoOidTipoDocu().getId() : null));
			row.add((facFormuData.getDeimOidDestImpr() != null ? facFormuData.getDeimOidDestImpr().getId() : null));
			row.add((facFormuData.getTifoOidTipoForm() != null ? facFormuData.getTifoOidTipoForm().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facFormuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
