
/*
    INDRA/CAR/mmg
    $Id: CccMarcaTipoAbonoListFormatter.java,v 1.1 2009/12/03 18:41:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccMarcaTipoAbono" para Druida
 * 
 * @author Indra
 */
public class CccMarcaTipoAbonoListFormatter extends MMGDruidaFormatoObjeto {
	
	public CccMarcaTipoAbonoListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccMarcaTipoAbonoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccMarcaTipoAbonoList.size(); i++) {
		
			CccMarcaTipoAbonoData cccMarcaTipoAbonoData = (CccMarcaTipoAbonoData) cccMarcaTipoAbonoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccMarcaTipoAbonoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccMarcaTipoAbonoData.getValObse() != null ? 
				FormatUtils.formatObject(cccMarcaTipoAbonoData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaTipoAbonoData.getMasiOidMarcSali() != null ? 
				FormatUtils.formatObject(cccMarcaTipoAbonoData.getMasiOidMarcSali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaTipoAbonoData.getTaspOidTipoAbonSubp() != null ? 
				FormatUtils.formatObject(cccMarcaTipoAbonoData.getTaspOidTipoAbonSubp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMarcaTipoAbonoData.getIndEntrSali() != null ? 
				FormatUtils.formatObject(cccMarcaTipoAbonoData.getIndEntrSali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(cccMarcaTipoAbonoData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
