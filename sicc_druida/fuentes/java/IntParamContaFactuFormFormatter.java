
/*
    INDRA/CAR/mmg
    $Id: IntParamContaFactuFormFormatter.java,v 1.1 2009/12/03 18:35:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "IntParamContaFactu" para Druida
 * 
 * @author Indra
 */
public class IntParamContaFactuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public IntParamContaFactuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector intParamContaFactuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < intParamContaFactuList.size(); i++) {
		
			IntParamContaFactuData intParamContaFactuData = (IntParamContaFactuData) intParamContaFactuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = intParamContaFactuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((intParamContaFactuData.getCodApun() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getCodApun(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getValTipoAsie() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValTipoAsie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getValIdenCabeDeta() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValIdenCabeDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getValDesc() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getValGrupArti() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getMaprOidMarcProd() != null ? intParamContaFactuData.getMaprOidMarcProd().getId() : null));
			row.add((intParamContaFactuData.getNegoOidNego() != null ? intParamContaFactuData.getNegoOidNego().getId() : null));
			row.add((intParamContaFactuData.getProdOidProd() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getProdOidProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getCucoOidCuenCont() != null ? intParamContaFactuData.getCucoOidCuenCont().getId() : null));
			row.add((intParamContaFactuData.getValIndiDebeHabe() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValIndiDebeHabe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((intParamContaFactuData.getImcfOidImpoContFact() != null ? intParamContaFactuData.getImcfOidImpoContFact().getId() : null));
			row.add((intParamContaFactuData.getPaisOidPais() != null ? intParamContaFactuData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(intParamContaFactuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
