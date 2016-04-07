
/*
    INDRA/CAR/mmg
    $Id: CraPerioFormFormatter.java,v 1.1 2009/12/03 18:32:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "CraPerio" para Druida
 * 
 * @author Indra
 */
public class CraPerioFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CraPerioFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector craPerioList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < craPerioList.size(); i++) {
		
			CraPerioData craPerioData = (CraPerioData) craPerioList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = craPerioData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((craPerioData.getMarcOidMarc() != null ? craPerioData.getMarcOidMarc().getId() : null));
			row.add((craPerioData.getCanaOidCana() != null ? craPerioData.getCanaOidCana().getId() : null));
			row.add((craPerioData.getPaisOidPais() != null ? craPerioData.getPaisOidPais().getId() : null));
			row.add((craPerioData.getAcceOidAcce() != null ? craPerioData.getAcceOidAcce().getId() : null));
			row.add((craPerioData.getPeriOidPeri() != null ? craPerioData.getPeriOidPeri().getId() : null));
			row.add((craPerioData.getFecInic() != null ? 
				FormatUtils.formatObject(craPerioData.getFecInic(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craPerioData.getFecFina() != null ? 
				FormatUtils.formatObject(craPerioData.getFecFina(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craPerioData.getValEsta() != null ? 
				FormatUtils.formatObject(craPerioData.getValEsta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craPerioData.getValNombPeri() != null ? 
				FormatUtils.formatObject(craPerioData.getValNombPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craPerioData.getIndPeriCort() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((craPerioData.getIndPeriCruc() != null ? 
				FormatUtils.formatObject(craPerioData.getIndPeriCruc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(craPerioData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
