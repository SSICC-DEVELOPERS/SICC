
/*
    INDRA/CAR/mmg
    $Id: MaeCodigClienAnterListFormatter.java,v 1.1 2009/12/03 18:43:07 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeCodigClienAnter" para Druida
 * 
 * @author Indra
 */
public class MaeCodigClienAnterListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeCodigClienAnterListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeCodigClienAnterList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < maeCodigClienAnterList.size(); i++) {
		
			MaeCodigClienAnterData maeCodigClienAnterData = (MaeCodigClienAnterData) maeCodigClienAnterList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeCodigClienAnterData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeCodigClienAnterData.getClieOidClieNuev() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getClieOidClieNuev(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeCodigClienAnterData.getCodClieAnti() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getCodClieAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeCodigClienAnterData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeCodigClienAnterData.getValSistProc() != null ? 
				FormatUtils.formatObject(maeCodigClienAnterData.getValSistProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeCodigClienAnterData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
