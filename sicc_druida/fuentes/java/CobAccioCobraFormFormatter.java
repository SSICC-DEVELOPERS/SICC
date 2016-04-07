
/*
    INDRA/CAR/mmg
    $Id: CobAccioCobraFormFormatter.java,v 1.1 2009/12/03 18:40:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobAccioCobra" para Druida
 * 
 * @author Indra
 */
public class CobAccioCobraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobAccioCobraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobAccioCobraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobAccioCobraList.size(); i++) {
		
			CobAccioCobraData cobAccioCobraData = (CobAccioCobraData) cobAccioCobraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobAccioCobraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobAccioCobraData.getCodAcciCobr() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getCodAcciCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getValDesc() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getSaccOidSubtAcci() != null ? cobAccioCobraData.getSaccOidSubtAcci().getId() : null));
			row.add((cobAccioCobraData.getIndFechHoraSegu() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndFechHoraSegu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndFechImpoComp() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndFechImpoComp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndFechHoraNuevSegu() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndFechHoraNuevSegu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndAporPrue() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndAporPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndDescPrue() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndDescPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndNumeDocuSopo() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndNumeDocuSopo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndTipoDocuPago() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndTipoDocuPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndBancSucu() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndBancSucu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndNuevDire() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndNuevDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndNuevTelf() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndNuevTelf(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndPasaAdmi() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndPasaAdmi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndPetiBloqAdmi() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndPetiBloqAdmi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndPetiDesbAdmi() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndPetiDesbAdmi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndAcciMensReco() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndAcciMensReco(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getIndObse() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getIndObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getValObse() != null ? 
				FormatUtils.formatObject(cobAccioCobraData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobAccioCobraData.getPaisOidPais() != null ? cobAccioCobraData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobAccioCobraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
