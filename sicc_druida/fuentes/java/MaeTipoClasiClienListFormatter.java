
/*
    INDRA/CAR/mmg
    $Id: MaeTipoClasiClienListFormatter.java,v 1.1 2009/12/03 18:40:27 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeTipoClasiClien" para Druida
 * 
 * @author Indra
 */
public class MaeTipoClasiClienListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeTipoClasiClienListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeTipoClasiClienList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < maeTipoClasiClienList.size(); i++) {
		
			MaeTipoClasiClienData maeTipoClasiClienData = (MaeTipoClasiClienData) maeTipoClasiClienList.elementAt(i);

			Vector row = new Vector();

			// A�adir la clave
			Hashtable primaryKey = maeTipoClasiClienData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// A�adir el resto de atributos
			row.add((maeTipoClasiClienData.getSbtiOidSubtClie() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienData.getSbtiOidSubtClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeTipoClasiClienData.getCodTipoClas() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienData.getCodTipoClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeTipoClasiClienData.getDescripcion() != null ? 
				FormatUtils.formatObject(maeTipoClasiClienData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// A�adir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeTipoClasiClienData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
