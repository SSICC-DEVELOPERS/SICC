
/*
    INDRA/CAR/mmg
    $Id: BelTipoMovimAlmacViewListFormatter.java,v 1.1 2009/12/03 18:43:38 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelTipoMovimAlmacView" para Druida
 * 
 * @author Indra
 */
public class BelTipoMovimAlmacViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public BelTipoMovimAlmacViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belTipoMovimAlmacViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < belTipoMovimAlmacViewList.size(); i++) {
		
			BelTipoMovimAlmacViewData belTipoMovimAlmacViewData = (BelTipoMovimAlmacViewData) belTipoMovimAlmacViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belTipoMovimAlmacViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belTipoMovimAlmacViewData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getCodTipoMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodTipoMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getCodMoviSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodMoviSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getIndMoviEntrAlma() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndMoviEntrAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getIndMantMovi() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndMantMovi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getIndSap() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getIndSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getCodOper1() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodOper1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belTipoMovimAlmacViewData.getCodOper2() != null ? 
				FormatUtils.formatObject(belTipoMovimAlmacViewData.getCodOper2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(belTipoMovimAlmacViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
