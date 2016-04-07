
/*
    INDRA/CAR/mmg
    $Id: MaeClienViewFormFormatter.java,v 1.1 2009/12/03 18:39:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClienView" para Druida
 * 
 * @author Indra
 */
public class MaeClienViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClienViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClienViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeClienViewList.size(); i++) {
		
			MaeClienViewData maeClienViewData = (MaeClienViewData) maeClienViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClienViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeClienViewData.getCodClie() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getPaisOidPais() != null ? maeClienViewData.getPaisOidPais().getId() : null));
			row.add((maeClienViewData.getIndFichInsc() != null ? 
				FormatUtils.formatObject(maeClienViewData.getIndFichInsc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getCodDigiCtrl() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodDigiCtrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValApe1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApe1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValApe2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApe2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValNom1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValNom1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValNom2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValNom2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValTrat() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValTrat(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValCritBus1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValCritBus1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValCritBus2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValCritBus2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getCodSexo() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodSexo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getFecIngr() != null ? 
				FormatUtils.formatObject(maeClienViewData.getFecIngr(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienViewData.getValApelCasa() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApelCasa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeClienViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
