
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicPaisFormFormatter.java,v 1.1 2009/12/03 18:32:30 pecbazalar Exp $
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

import es.indra.utils.*;

/**
 * Clase de formateo de objetos "PedTipoSolicPais" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicPaisFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicPaisFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicPaisList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

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
			row.add((pedTipoSolicPaisData.getPaisOidPais() != null ? pedTipoSolicPaisData.getPaisOidPais().getId() : null));
			row.add((pedTipoSolicPaisData.getTsolOidTipoSoli() != null ? pedTipoSolicPaisData.getTsolOidTipoSoli().getId() : null));
			row.add((pedTipoSolicPaisData.getNumSoliLote() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getNumSoliLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getNumUnidAlar() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getNumUnidAlar(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getFopaOidFormPago() != null ? pedTipoSolicPaisData.getFopaOidFormPago().getId() : null));
			row.add((pedTipoSolicPaisData.getIndSujeFlet() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndSujeFlet(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndReseStoc() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndReseStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndPermReve() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPermReve(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndPediPrue() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPediPrue(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndComi() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndComi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndVentInteSab14() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndVentInteSab14(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getCactOidActi() != null ? pedTipoSolicPaisData.getCactOidActi().getId() : null));
			row.add((pedTipoSolicPaisData.getMoneOidMone() != null ? pedTipoSolicPaisData.getMoneOidMone().getId() : null));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviAsig() != null ? pedTipoSolicPaisData.getTmalOidTipoMoviAsig().getId() : null));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviRese() != null ? pedTipoSolicPaisData.getTmalOidTipoMoviRese().getId() : null));
			row.add((pedTipoSolicPaisData.getTmalOidTipoMoviFact() != null ? pedTipoSolicPaisData.getTmalOidTipoMoviFact().getId() : null));
			row.add((pedTipoSolicPaisData.getTidoOidTipoDocu() != null ? pedTipoSolicPaisData.getTidoOidTipoDocu().getId() : null));
			row.add((pedTipoSolicPaisData.getIndPermUnio() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPermUnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndPediGtZona() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndPediGtZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getIndCambVentBel() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getIndCambVentBel(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getAlmcOidAlma() != null ? pedTipoSolicPaisData.getAlmcOidAlma().getId() : null));
			row.add((pedTipoSolicPaisData.getSociOidSoci() != null ? pedTipoSolicPaisData.getSociOidSoci().getId() : null));
			row.add((pedTipoSolicPaisData.getValGlos() != null ? 
				FormatUtils.formatObject(pedTipoSolicPaisData.getValGlos(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicPaisData.getTsolOidTipoCons() != null ? pedTipoSolicPaisData.getTsolOidTipoCons().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTipoSolicPaisData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
