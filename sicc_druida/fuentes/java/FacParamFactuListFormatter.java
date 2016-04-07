
/*
    INDRA/CAR/mmg
    $Id: FacParamFactuListFormatter.java,v 1.1 2009/12/03 18:34:59 pecbazalar Exp $
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
import java.util.HashMap;
import java.text.DecimalFormatSymbols;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.utils.*;

/**
 * Clase de formateo de objetos "FacParamFactu" para Druida
 * 
 * @author Indra
 */
public class FacParamFactuListFormatter extends MMGDruidaFormatoObjeto {
	
	public FacParamFactuListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector facParamFactuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
			row.add((facParamFactuData.getIndDocuMonoPagi() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndDocuMonoPagi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getValMontLimiUit() != null ? 
				FormatUtils.formatObject(facParamFactuData.getValMontLimiUit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getNumMaxiCampPrd() != null ? 
				FormatUtils.formatObject(facParamFactuData.getNumMaxiCampPrd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getIndTipoProyRegi() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndTipoProyRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getIndMostVencCupo() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndMostVencCupo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getNumMaxiPediProy() != null ? 
				FormatUtils.formatObject(facParamFactuData.getNumMaxiPediProy(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getCodModaDist() != null ? 
				FormatUtils.formatObject(facParamFactuData.getCodModaDist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((facParamFactuData.getIndCheqClieNuev() != null ? 
				FormatUtils.formatObject(facParamFactuData.getIndCheqClieNuev(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(facParamFactuData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
