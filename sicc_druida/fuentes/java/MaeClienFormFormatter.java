
/*
    INDRA/CAR/mmg
    $Id: MaeClienFormFormatter.java,v 1.1 2009/12/03 18:39:45 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClien" para Druida
 * 
 * @author Indra
 */
public class MaeClienFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClienFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeClienList.size(); i++) {
		
			MaeClienData maeClienData = (MaeClienData) maeClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeClienData.getCodClie() != null ? 
				FormatUtils.formatObject(maeClienData.getCodClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getIndFichInsc() != null ? 
				FormatUtils.formatObject(maeClienData.getIndFichInsc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getPaisOidPais() != null ? maeClienData.getPaisOidPais().getId() : null));
			row.add((maeClienData.getCodDigiCtrl() != null ? 
				FormatUtils.formatObject(maeClienData.getCodDigiCtrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValApe1() != null ? 
				FormatUtils.formatObject(maeClienData.getValApe1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValApe2() != null ? 
				FormatUtils.formatObject(maeClienData.getValApe2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValNom1() != null ? 
				FormatUtils.formatObject(maeClienData.getValNom1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValNom2() != null ? 
				FormatUtils.formatObject(maeClienData.getValNom2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValTrat() != null ? 
				FormatUtils.formatObject(maeClienData.getValTrat(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValCritBus1() != null ? 
				FormatUtils.formatObject(maeClienData.getValCritBus1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getValCritBus2() != null ? 
				FormatUtils.formatObject(maeClienData.getValCritBus2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getCodSexo() != null ? 
				FormatUtils.formatObject(maeClienData.getCodSexo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getFecIngr() != null ? 
				FormatUtils.formatObject(maeClienData.getFecIngr(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeClienData.getFopaOidFormPago() != null ? maeClienData.getFopaOidFormPago().getId() : null));
			row.add((maeClienData.getValApelCasa() != null ? 
				FormatUtils.formatObject(maeClienData.getValApelCasa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeClienData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
