
/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacListFormatter.java,v 1.1 2009/12/03 18:37:01 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMovimAlmac" para Druida
 * 
 * @author Indra
 */
public class BelTipoMovimAlmacListFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMovimAlmacListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMovimAlmacList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < belTipoMovimAlmacList.size(); i++) {
		
			BelTipoMovimAlmacData belTipoMovimAlmacData = (BelTipoMovimAlmacData) belTipoMovimAlmacList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMovimAlmacData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMovimAlmacData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getCodTipoMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodTipoMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getCodMoviSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodMoviSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getIndMoviEntrAlma() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndMoviEntrAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getIndMantMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndMantMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getIndSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getIndSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getEsmeOidEstaMerc1() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getEsmeOidEstaMerc1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getEsmeOidEstaMerc2() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getEsmeOidEstaMerc2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getCodOper1() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodOper1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacData.getCodOper2() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacData.getCodOper2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(belTipoMovimAlmacData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
