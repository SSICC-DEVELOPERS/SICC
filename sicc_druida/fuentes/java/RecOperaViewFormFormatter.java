
/*
    INDRA/CAR/mmg
    $Id: RecOperaViewFormFormatter.java,v 1.1 2009/12/03 18:33:14 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecOperaView" para Druida
 * 
 * @author Indra
 */
public class RecOperaViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecOperaViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recOperaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recOperaViewList.size(); i++) {
		
			RecOperaViewData recOperaViewData = (RecOperaViewData) recOperaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recOperaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recOperaViewData.getCodOper() != null ? 
				FormatUtils.formatObject(recOperaViewData.getCodOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getValDescLarg() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValDescLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndAnul() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndIngrEnvi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndIngrEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getValIngrDevu() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValIngrDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getValPerd() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndEspeMercFisi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndEspeMercFisi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndDevuFisiFact() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndDevuFisiFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getNumCampHist() != null ? 
				FormatUtils.formatObject(recOperaViewData.getNumCampHist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndEnviGeneDevu() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndEnviGeneDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getIndDevuGeneEnvi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndDevuGeneEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaViewData.getPaisOidPais() != null ? recOperaViewData.getPaisOidPais().getId() : null));
			row.add((recOperaViewData.getIndFaltMerc() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndFaltMerc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recOperaViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
