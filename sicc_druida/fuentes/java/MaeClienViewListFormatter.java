
/*
    INDRA/CAR/mmg
    $Id: MaeClienViewListFormatter.java,v 1.1 2009/12/03 18:39:08 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClienView" para Druida
 * 
 * @author Indra
 */
public class MaeClienViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClienViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClienViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < maeClienViewList.size(); i++) {
		
			MaeClienViewData maeClienViewData = (MaeClienViewData) maeClienViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClienViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeClienViewData.getCodClie() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(maeClienViewData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getIndFichInsc() != null ? 
				FormatUtils.formatObject(maeClienViewData.getIndFichInsc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getCodDigiCtrl() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodDigiCtrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValApe1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApe1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValApe2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApe2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValNom1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValNom1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValNom2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValNom2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValTrat() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValTrat(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValCritBus1() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValCritBus1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getValCritBus2() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValCritBus2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getCodSexo() != null ? 
				FormatUtils.formatObject(maeClienViewData.getCodSexo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienViewData.getFecIngr() != null ? 
				FormatUtils.formatObject(maeClienViewData.getFecIngr(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((maeClienViewData.getValApelCasa() != null ? 
				FormatUtils.formatObject(maeClienViewData.getValApelCasa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeClienViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
