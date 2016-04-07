
/*
    INDRA/CAR/mmg
    $Id: RecTiposOperaListFormatter.java,v 1.1 2009/12/03 18:32:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "RecTiposOpera" para Druida
 * 
 * @author Indra
 */
public class RecTiposOperaListFormatter extends MMGDruidaFormatoObjeto {
	
	public RecTiposOperaListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector recTiposOperaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < recTiposOperaList.size(); i++) {
		
			RecTiposOperaData recTiposOperaData = (RecTiposOperaData) recTiposOperaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = recTiposOperaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((recTiposOperaData.getValTipoOper() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getValTipoOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getIndCampRefeUnic() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndCampRefeUnic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getNumDiasHaciAtra() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getNumDiasHaciAtra(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getValInfoEbelNoti() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getValInfoEbelNoti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getIndDevuEstaFact() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndDevuEstaFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getIndEnviEstaFact() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getIndEnviEstaFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getRopeOidOper() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getRopeOidOper(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getMrdbOidMotiRechDesb() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getMrdbOidMotiRechDesb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getMoblOidBloqDife() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getMoblOidBloqDife(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getMoblOidReclAnte() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getMoblOidReclAnte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getMoblOidBloqImpo() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getMoblOidBloqImpo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((recTiposOperaData.getMoblOidBloqUnid() != null ? 
				FormatUtils.formatObject(recTiposOperaData.getMoblOidBloqUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(recTiposOperaData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
