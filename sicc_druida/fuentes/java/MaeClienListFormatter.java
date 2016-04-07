
/*
    INDRA/CAR/mmg
    $Id: MaeClienListFormatter.java,v 1.1 2009/12/03 18:35:00 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeClien" para Druida
 * 
 * @author Indra
 */
public class MaeClienListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeClienListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < maeClienList.size(); i++) {
		
			MaeClienData maeClienData = (MaeClienData) maeClienList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeClienData.getCodClie() != null ? 
				FormatUtils.formatObject(maeClienData.getCodClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getIndFichInsc() != null ? 
				FormatUtils.formatObject(maeClienData.getIndFichInsc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(maeClienData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getCodDigiCtrl() != null ? 
				FormatUtils.formatObject(maeClienData.getCodDigiCtrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValApe1() != null ? 
				FormatUtils.formatObject(maeClienData.getValApe1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValApe2() != null ? 
				FormatUtils.formatObject(maeClienData.getValApe2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValNom1() != null ? 
				FormatUtils.formatObject(maeClienData.getValNom1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValNom2() != null ? 
				FormatUtils.formatObject(maeClienData.getValNom2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValTrat() != null ? 
				FormatUtils.formatObject(maeClienData.getValTrat(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValCritBus1() != null ? 
				FormatUtils.formatObject(maeClienData.getValCritBus1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValCritBus2() != null ? 
				FormatUtils.formatObject(maeClienData.getValCritBus2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getCodSexo() != null ? 
				FormatUtils.formatObject(maeClienData.getCodSexo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getFecIngr() != null ? 
				FormatUtils.formatObject(maeClienData.getFecIngr(), 
				 propiedadFecha.getValue().toString(), 
				symbols) : ""));
			row.add((maeClienData.getFopaOidFormPago() != null ? 
				FormatUtils.formatObject(maeClienData.getFopaOidFormPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeClienData.getValApelCasa() != null ? 
				FormatUtils.formatObject(maeClienData.getValApelCasa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeClienData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
