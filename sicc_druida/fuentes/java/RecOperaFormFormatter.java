
/*
    INDRA/CAR/mmg
    $Id: RecOperaFormFormatter.java,v 1.1 2009/12/03 18:41:13 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecOpera" para Druida
 * 
 * @author Indra
 */
public class RecOperaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public RecOperaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recOperaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < recOperaList.size(); i++) {
		
			RecOperaData recOperaData = (RecOperaData) recOperaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recOperaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recOperaData.getCodOper() != null ? 
				FormatUtils.formatObject(recOperaData.getCodOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getValDescLarg() != null ? 
				FormatUtils.formatObject(recOperaData.getValDescLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndAnul() != null ? 
				FormatUtils.formatObject(recOperaData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndIngrEnvi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndIngrEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getValIngrDevu() != null ? 
				FormatUtils.formatObject(recOperaData.getValIngrDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getValPerd() != null ? 
				FormatUtils.formatObject(recOperaData.getValPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndEspeMercFisi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndEspeMercFisi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndDevuFisiFact() != null ? 
				FormatUtils.formatObject(recOperaData.getIndDevuFisiFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getNumCampHist() != null ? 
				FormatUtils.formatObject(recOperaData.getNumCampHist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndEnviGeneDevu() != null ? 
				FormatUtils.formatObject(recOperaData.getIndEnviGeneDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getIndDevuGeneEnvi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndDevuGeneEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getAlmcOidAlma() != null ? recOperaData.getAlmcOidAlma().getId() : null));
			row.add((recOperaData.getPeciOidPeci() != null ? recOperaData.getPeciOidPeci().getId() : null));
			row.add((recOperaData.getMensOidMens() != null ? recOperaData.getMensOidMens().getId() : null));
			row.add((recOperaData.getPaisOidPais() != null ? recOperaData.getPaisOidPais().getId() : null));
			row.add((recOperaData.getTspaOidSoliPaisPerd() != null ? recOperaData.getTspaOidSoliPaisPerd().getId() : null));
			row.add((recOperaData.getTmalOidTipoMoviAlma() != null ? recOperaData.getTmalOidTipoMoviAlma().getId() : null));
			row.add((recOperaData.getMdefOidModoAbonDefe() != null ? recOperaData.getMdefOidModoAbonDefe().getId() : null));
			row.add((recOperaData.getPenvOidPrecioEnvia() != null ? recOperaData.getPenvOidPrecioEnvia().getId() : null));
			row.add((recOperaData.getTspaOidSoliPaisGene() != null ? recOperaData.getTspaOidSoliPaisGene().getId() : null));
			row.add((recOperaData.getMoblOidMotiBloq() != null ? recOperaData.getMoblOidMotiBloq().getId() : null));
			row.add((recOperaData.getIndFaltMerc() != null ? 
				FormatUtils.formatObject(recOperaData.getIndFaltMerc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((recOperaData.getTspaOidSoliSinStoc() != null ? recOperaData.getTspaOidSoliSinStoc().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(recOperaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
