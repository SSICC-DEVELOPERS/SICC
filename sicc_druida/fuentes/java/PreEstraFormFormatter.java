
/*
    INDRA/CAR/mmg
    $Id: PreEstraFormFormatter.java,v 1.1 2009/12/03 18:40:19 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreEstra" para Druida
 * 
 * @author Indra
 */
public class PreEstraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreEstraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preEstraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preEstraList.size(); i++) {
		
			PreEstraData preEstraData = (PreEstraData) preEstraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preEstraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preEstraData.getPaisOidPais() != null ? preEstraData.getPaisOidPais().getId() : null));
			row.add((preEstraData.getCodEstr() != null ? 
				FormatUtils.formatObject(preEstraData.getCodEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getDescripcion() != null ? 
				FormatUtils.formatObject(preEstraData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getTiesOidTipoEstr() != null ? preEstraData.getTiesOidTipoEstr().getId() : null));
			row.add((preEstraData.getNumMaxiGrup() != null ? 
				FormatUtils.formatObject(preEstraData.getNumMaxiGrup(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getNumMaxiGrupCndt() != null ? 
				FormatUtils.formatObject(preEstraData.getNumMaxiGrupCndt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getNumMaxiGrupCndo() != null ? 
				FormatUtils.formatObject(preEstraData.getNumMaxiGrupCndo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndListRank() != null ? 
				FormatUtils.formatObject(preEstraData.getIndListRank(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndCuadGrup() != null ? 
				FormatUtils.formatObject(preEstraData.getIndCuadGrup(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getTiprOidTipoProd() != null ? preEstraData.getTiprOidTipoProd().getId() : null));
			row.add((preEstraData.getIndCvImpr() != null ? 
				FormatUtils.formatObject(preEstraData.getIndCvImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndModiImpr() != null ? 
				FormatUtils.formatObject(preEstraData.getIndModiImpr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndCvDespAuto() != null ? 
				FormatUtils.formatObject(preEstraData.getIndCvDespAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndModiDesp() != null ? 
				FormatUtils.formatObject(preEstraData.getIndModiDesp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndCvDigi() != null ? 
				FormatUtils.formatObject(preEstraData.getIndCvDigi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preEstraData.getIndModiDigi() != null ? 
				FormatUtils.formatObject(preEstraData.getIndModiDigi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preEstraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
