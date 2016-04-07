
/*
    INDRA/CAR/mmg
    $Id: FacParamFactuFormFormatter.java,v 1.1 2009/12/03 18:34:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "FacParamFactu" para Druida
 * 
 * @author Indra
 */
public class FacParamFactuFormFormatter extends MMGDruidaFormatoObjeto {
	
	public FacParamFactuFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facParamFactuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < facParamFactuList.size(); i++) {
		
			FacParamFactuData facParamFactuData = (FacParamFactuData) facParamFactuList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = facParamFactuData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((facParamFactuData.getPaisOidPais() != null ? facParamFactuData.getPaisOidPais().getId() : null));
			row.add((facParamFactuData.getIndDocuMonoPagi() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndDocuMonoPagi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getValMontLimiUit() != null ? 
				FormatUtils.formatObject(facParamFactuData.getValMontLimiUit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getNumMaxiCampPrd() != null ? 
				FormatUtils.formatObject(facParamFactuData.getNumMaxiCampPrd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getIndTipoProyRegi() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndTipoProyRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getIndMostVencCupo() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndMostVencCupo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getNumMaxiPediProy() != null ? 
				FormatUtils.formatObject(facParamFactuData.getNumMaxiPediProy(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getCodModaDist() != null ? 
				FormatUtils.formatObject(facParamFactuData.getCodModaDist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getIndCheqClieNuev() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndCheqClieNuev(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((facParamFactuData.getIndPrecCont() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(facParamFactuData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
