
/*
    INDRA/CAR/mmg
    $Id: CccCuentCorriBancaFormFormatter.java,v 1.1 2009/12/03 18:35:12 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccCuentCorriBanca" para Druida
 * 
 * @author Indra
 */
public class CccCuentCorriBancaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccCuentCorriBancaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccCuentCorriBancaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccCuentCorriBancaList.size(); i++) {
		
			CccCuentCorriBancaData cccCuentCorriBancaData = (CccCuentCorriBancaData) cccCuentCorriBancaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccCuentCorriBancaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccCuentCorriBancaData.getCodCc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCodCc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getSociOidSoci() != null ? cccCuentCorriBancaData.getSociOidSoci().getId() : null));
			row.add((cccCuentCorriBancaData.getDesCc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getDesCc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getCucoOidCcTeso() != null ? cccCuentCorriBancaData.getCucoOidCcTeso().getId() : null));
			row.add((cccCuentCorriBancaData.getCucoOidCcPnte() != null ? cccCuentCorriBancaData.getCucoOidCcPnte().getId() : null));
			row.add((cccCuentCorriBancaData.getCodCcBanc() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getCodCcBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getSucuOidSucu() != null ? cccCuentCorriBancaData.getSucuOidSucu().getId() : null));
			row.add((cccCuentCorriBancaData.getValNumeSwif() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getValNumeSwif(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getValDire() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getValCont() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getValCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getValTele() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getValTele(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getValObse() != null ? 
				FormatUtils.formatObject(cccCuentCorriBancaData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccCuentCorriBancaData.getPaisOidPais() != null ? cccCuentCorriBancaData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccCuentCorriBancaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
