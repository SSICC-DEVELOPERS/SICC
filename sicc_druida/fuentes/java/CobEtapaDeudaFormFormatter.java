
/*
    INDRA/CAR/mmg
    $Id: CobEtapaDeudaFormFormatter.java,v 1.1 2009/12/03 18:37:14 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobEtapaDeuda" para Druida
 * 
 * @author Indra
 */
public class CobEtapaDeudaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobEtapaDeudaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobEtapaDeudaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobEtapaDeudaList.size(); i++) {
		
			CobEtapaDeudaData cobEtapaDeudaData = (CobEtapaDeudaData) cobEtapaDeudaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobEtapaDeudaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobEtapaDeudaData.getCodEtapDeud() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getCodEtapDeud(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getValDesc() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getIndExcl() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getIndExcl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getValEdadInic() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getValEdadInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getValEdadFina() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getValEdadFina(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getIndTelf() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getIndTelf(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getImpDesd() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getImpDesd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getImpHast() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getImpHast(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getNumDiasGracCompPago() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getNumDiasGracCompPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getValPorcIncu() != null ? 
				FormatUtils.formatObject(cobEtapaDeudaData.getValPorcIncu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobEtapaDeudaData.getMensOidMens() != null ? cobEtapaDeudaData.getMensOidMens().getId() : null));
			row.add((cobEtapaDeudaData.getMelcOidMetoLiquCobr() != null ? cobEtapaDeudaData.getMelcOidMetoLiquCobr().getId() : null));
			row.add((cobEtapaDeudaData.getTbalOidTipoBala() != null ? cobEtapaDeudaData.getTbalOidTipoBala().getId() : null));
			row.add((cobEtapaDeudaData.getGacaOidGuioArguCabe() != null ? cobEtapaDeudaData.getGacaOidGuioArguCabe().getId() : null));
			row.add((cobEtapaDeudaData.getPaisOidPais() != null ? cobEtapaDeudaData.getPaisOidPais().getId() : null));
			row.add((cobEtapaDeudaData.getOredOidEtapDeu1() != null ? cobEtapaDeudaData.getOredOidEtapDeu1().getId() : null));
			row.add((cobEtapaDeudaData.getOredOidEtapDeu2() != null ? cobEtapaDeudaData.getOredOidEtapDeu2().getId() : null));
			row.add((cobEtapaDeudaData.getOredOidEtapDeu3() != null ? cobEtapaDeudaData.getOredOidEtapDeu3().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobEtapaDeudaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
