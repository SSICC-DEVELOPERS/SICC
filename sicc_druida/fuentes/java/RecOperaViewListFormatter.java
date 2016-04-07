
/*
    INDRA/CAR/mmg
    $Id: RecOperaViewListFormatter.java,v 1.1 2009/12/03 18:33:40 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecOperaView" para Druida
 * 
 * @author Indra
 */
public class RecOperaViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public RecOperaViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recOperaViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < recOperaViewList.size(); i++) {
		
			RecOperaViewData recOperaViewData = (RecOperaViewData) recOperaViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recOperaViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recOperaViewData.getCodOper() != null ? 
				FormatUtils.formatObject(recOperaViewData.getCodOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getValDescLarg() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValDescLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndAnul() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndIngrEnvi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndIngrEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getValIngrDevu() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValIngrDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getValPerd() != null ? 
				FormatUtils.formatObject(recOperaViewData.getValPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndEspeMercFisi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndEspeMercFisi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndDevuFisiFact() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndDevuFisiFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getNumCampHist() != null ? 
				FormatUtils.formatObject(recOperaViewData.getNumCampHist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndEnviGeneDevu() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndEnviGeneDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndDevuGeneEnvi() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndDevuGeneEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaViewData.getIndFaltMerc() != null ? 
				FormatUtils.formatObject(recOperaViewData.getIndFaltMerc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(recOperaViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
