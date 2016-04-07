
/*
    INDRA/CAR/mmg
    $Id: CobGrupoUsuarCobraFormFormatter.java,v 1.1 2009/12/03 18:37:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "CobGrupoUsuarCobra" para Druida
 * 
 * @author Indra
 */
public class CobGrupoUsuarCobraFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CobGrupoUsuarCobraFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cobGrupoUsuarCobraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cobGrupoUsuarCobraList.size(); i++) {
		
			CobGrupoUsuarCobraData cobGrupoUsuarCobraData = (CobGrupoUsuarCobraData) cobGrupoUsuarCobraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cobGrupoUsuarCobraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cobGrupoUsuarCobraData.getCodGrupUsua() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getCodGrupUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getValDesc() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getFecUltiEsta() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getFecUltiEsta(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getIndUsuaExte() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getIndUsuaExte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getValTurnHoraEntr() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getValTurnHoraEntr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getValTurnHoraSali() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getValTurnHoraSali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getValObse() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cobGrupoUsuarCobraData.getPaisOidPais() != null ? cobGrupoUsuarCobraData.getPaisOidPais().getId() : null));
			row.add((cobGrupoUsuarCobraData.getEsgrOidEstaGrupUsua() != null ? cobGrupoUsuarCobraData.getEsgrOidEstaGrupUsua().getId() : null));
			row.add((cobGrupoUsuarCobraData.getCodUsua() != null ? 
				FormatUtils.formatObject(cobGrupoUsuarCobraData.getCodUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cobGrupoUsuarCobraData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
