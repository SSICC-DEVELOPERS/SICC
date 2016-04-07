
/*
    INDRA/CAR/mmg
    $Id: PreTipoOfertFormFormatter.java,v 1.1 2009/12/03 18:37:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreTipoOfert" para Druida
 * 
 * @author Indra
 */
public class PreTipoOfertFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PreTipoOfertFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preTipoOfertList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < preTipoOfertList.size(); i++) {
		
			PreTipoOfertData preTipoOfertData = (PreTipoOfertData) preTipoOfertList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preTipoOfertData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preTipoOfertData.getCanaOidCana() != null ? preTipoOfertData.getCanaOidCana().getId() : null));
			row.add((preTipoOfertData.getCodTipoOfer() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getCodTipoOfer(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getDescripcion() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndComi() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndComi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndPunt() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndPunt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndEsta() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndMontMini() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndMontMini(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndAporMontEsca() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndAporMontEsca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((preTipoOfertData.getIndGrat() != null ? 
				FormatUtils.formatObject(preTipoOfertData.getIndGrat(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(preTipoOfertData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
