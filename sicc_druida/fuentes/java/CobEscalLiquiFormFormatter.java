
/*
    INDRA/CAR/mmg
    $Id: CobEscalLiquiFormFormatter.java,v 1.1 2009/12/03 18:41:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEscalLiqui" para Druida
 * 
 * @author Indra
 */
public class CobEscalLiquiFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEscalLiquiFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEscalLiquiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobEscalLiquiList.size(); i++) {
		
			CobEscalLiquiData cobEscalLiquiData = (CobEscalLiquiData) cobEscalLiquiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEscalLiquiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEscalLiquiData.getNumOrdeEsca() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getNumOrdeEsca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getImpRangDesdImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpRangDesdImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getImpRangHastImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpRangHastImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getValRangDesdPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValRangDesdPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getValRangHastPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValRangHastPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getImpComiPorc() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpComiPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getImpComiImpo() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getImpComiImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getValObse() != null ? 
				FormatUtils.formatObject(cobEscalLiquiData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEscalLiquiData.getMelcOidMetoLiquCobr() != null ? cobEscalLiquiData.getMelcOidMetoLiquCobr().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobEscalLiquiData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
