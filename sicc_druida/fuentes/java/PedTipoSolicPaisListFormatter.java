
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisListFormatter.java,v 1.1 2009/12/03 18:39:50 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolicPais" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicPaisListFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicPaisListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicPaisList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < pedTipoSolicPaisList.size(); i++) {
		
			PedTipoSolicPaisData pedTipoSolicPaisData = (PedTipoSolicPaisData) pedTipoSolicPaisList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoSolicPaisData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTipoSolicPaisData.getTsolOidTipoSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTsolOidTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getNumSoliLote() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getNumSoliLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getNumUnidAlar() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getNumUnidAlar(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getFopaOidFormPago() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getFopaOidFormPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndSujeFlet() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndSujeFlet(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndReseStoc() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndReseStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndPermReve() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPermReve(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndPediPrue() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPediPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndComi() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndComi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndVentInteSab14() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndVentInteSab14(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getCactOidActi() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getCactOidActi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getMoneOidMone() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getMoneOidMone(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviAsig() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTmalOidTipoMoviAsig(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviRese() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTmalOidTipoMoviRese(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviFact() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTmalOidTipoMoviFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getTidoOidTipoDocu() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTidoOidTipoDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndPermUnio() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPermUnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndPediGtZona() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPediGtZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getIndCambVentBel() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndCambVentBel(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getAlmcOidAlma() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getAlmcOidAlma(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getSociOidSoci() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getSociOidSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getValGlos() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getValGlos(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicPaisData.getTsolOidTipoCons() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getTsolOidTipoCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(pedTipoSolicPaisData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
