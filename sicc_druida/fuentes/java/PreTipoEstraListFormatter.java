
/*
    INDRA/CAR/mmg
    $Id: PreTipoEstraListFormatter.java,v 1.1 2009/12/03 18:40:55 pecbazalar Exp $
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
 * Clase de formateo de objetos "PreTipoEstra" para Druida
 * 
 * @author Indra
 */
public class PreTipoEstraListFormatter extends MMGDruidaFormatoObjeto {
	
	public PreTipoEstraListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector preTipoEstraList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < preTipoEstraList.size(); i++) {
		
			PreTipoEstraData preTipoEstraData = (PreTipoEstraData) preTipoEstraList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = preTipoEstraData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((preTipoEstraData.getCodTipoEstr() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getCodTipoEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((preTipoEstraData.getDesTipoEstr() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getDesTipoEstr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((preTipoEstraData.getIndEstrGrup() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrGrup(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((preTipoEstraData.getIndEstrCond() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrCond(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((preTipoEstraData.getIndEstrVs() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrVs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((preTipoEstraData.getIndEstrPaqu() != null ? 
				FormatUtils.formatObject(preTipoEstraData.getIndEstrPaqu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(preTipoEstraData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
