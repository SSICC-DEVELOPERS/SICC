
/*
    INDRA/CAR/mmg
    $Id: CccSucurFormFormatter.java,v 1.1 2009/12/03 18:43:23 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccSucur" para Druida
 * 
 * @author Indra
 */
public class CccSucurFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccSucurFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccSucurList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccSucurList.size(); i++) {
		
			CccSucurData cccSucurData = (CccSucurData) cccSucurList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccSucurData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccSucurData.getCbanOidBanc() != null ? cccSucurData.getCbanOidBanc().getId() : null));
			row.add((cccSucurData.getCodSucu() != null ? 
				FormatUtils.formatObject(cccSucurData.getCodSucu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValDire() != null ? 
				FormatUtils.formatObject(cccSucurData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValCiud() != null ? 
				FormatUtils.formatObject(cccSucurData.getValCiud(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValDepa() != null ? 
				FormatUtils.formatObject(cccSucurData.getValDepa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValDist() != null ? 
				FormatUtils.formatObject(cccSucurData.getValDist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValCont() != null ? 
				FormatUtils.formatObject(cccSucurData.getValCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValTfno() != null ? 
				FormatUtils.formatObject(cccSucurData.getValTfno(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccSucurData.getValObse() != null ? 
				FormatUtils.formatObject(cccSucurData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccSucurData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
