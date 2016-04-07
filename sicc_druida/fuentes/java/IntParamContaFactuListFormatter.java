
/*
    INDRA/CAR/mmg
    $Id: IntParamContaFactuListFormatter.java,v 1.1 2009/12/03 18:33:29 pecbazalar Exp $
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
 * Clase de formateo de objetos "IntParamContaFactu" para Druida
 * 
 * @author Indra
 */
public class IntParamContaFactuListFormatter extends MMGDruidaFormatoObjeto {
	
	public IntParamContaFactuListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector intParamContaFactuList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
				symbols) : ""));
			row.add((intParamContaFactuData.getValTipoAsie() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValTipoAsie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getValIdenCabeDeta() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValIdenCabeDeta(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getValDesc() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getValGrupArti() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getMaprOidMarcProd() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getMaprOidMarcProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getNegoOidNego() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getNegoOidNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getProdOidProd() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getProdOidProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getCucoOidCuenCont() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getCucoOidCuenCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getValIndiDebeHabe() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getValIndiDebeHabe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((intParamContaFactuData.getImcfOidImpoContFact() != null ? 
				FormatUtils.formatObject(intParamContaFactuData.getImcfOidImpoContFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(intParamContaFactuData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
