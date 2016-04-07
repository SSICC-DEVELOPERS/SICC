
/*
    INDRA/CAR/mmg
    $Id: RecOperaListFormatter.java,v 1.1 2009/12/03 18:38:39 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecOpera" para Druida
 * 
 * @author Indra
 */
public class RecOperaListFormatter extends MMGDruidaFormatoObjeto {
	
	public RecOperaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recOperaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < recOperaList.size(); i++) {
		
			RecOperaData recOperaData = (RecOperaData) recOperaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recOperaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recOperaData.getCodOper() != null ? 
				FormatUtils.formatObject(recOperaData.getCodOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getValDescLarg() != null ? 
				FormatUtils.formatObject(recOperaData.getValDescLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndAnul() != null ? 
				FormatUtils.formatObject(recOperaData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndIngrEnvi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndIngrEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getValIngrDevu() != null ? 
				FormatUtils.formatObject(recOperaData.getValIngrDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getValPerd() != null ? 
				FormatUtils.formatObject(recOperaData.getValPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndEspeMercFisi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndEspeMercFisi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndDevuFisiFact() != null ? 
				FormatUtils.formatObject(recOperaData.getIndDevuFisiFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getNumCampHist() != null ? 
				FormatUtils.formatObject(recOperaData.getNumCampHist(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndEnviGeneDevu() != null ? 
				FormatUtils.formatObject(recOperaData.getIndEnviGeneDevu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndDevuGeneEnvi() != null ? 
				FormatUtils.formatObject(recOperaData.getIndDevuGeneEnvi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getAlmcOidAlma() != null ? 
				FormatUtils.formatObject(recOperaData.getAlmcOidAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getPeciOidPeci() != null ? 
				FormatUtils.formatObject(recOperaData.getPeciOidPeci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getMensOidMens() != null ? 
				FormatUtils.formatObject(recOperaData.getMensOidMens(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getTspaOidSoliPaisPerd() != null ? 
				FormatUtils.formatObject(recOperaData.getTspaOidSoliPaisPerd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getTmalOidTipoMoviAlma() != null ? 
				FormatUtils.formatObject(recOperaData.getTmalOidTipoMoviAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getMdefOidModoAbonDefe() != null ? 
				FormatUtils.formatObject(recOperaData.getMdefOidModoAbonDefe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getPenvOidPrecioEnvia() != null ? 
				FormatUtils.formatObject(recOperaData.getPenvOidPrecioEnvia(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getTspaOidSoliPaisGene() != null ? 
				FormatUtils.formatObject(recOperaData.getTspaOidSoliPaisGene(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getMoblOidMotiBloq() != null ? 
				FormatUtils.formatObject(recOperaData.getMoblOidMotiBloq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getIndFaltMerc() != null ? 
				FormatUtils.formatObject(recOperaData.getIndFaltMerc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recOperaData.getTspaOidSoliSinStoc() != null ? 
				FormatUtils.formatObject(recOperaData.getTspaOidSoliSinStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(recOperaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
