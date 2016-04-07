
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicFormFormatter.java,v 1.1 2009/12/03 18:38:03 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolic" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicFormFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < pedTipoSolicList.size(); i++) {
		
			PedTipoSolicData pedTipoSolicData = (PedTipoSolicData) pedTipoSolicList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = pedTipoSolicData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((pedTipoSolicData.getCodTipoSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getCodTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getTiclOidTipoClie() != null ? pedTipoSolicData.getTiclOidTipoClie().getId() : null));
			row.add((pedTipoSolicData.getMarcOidMarc() != null ? pedTipoSolicData.getMarcOidMarc().getId() : null));
			row.add((pedTipoSolicData.getAcceOidAcce() != null ? pedTipoSolicData.getAcceOidAcce().getId() : null));
			row.add((pedTipoSolicData.getClsoOidClasSoli() != null ? pedTipoSolicData.getClsoOidClasSoli().getId() : null));
			row.add((pedTipoSolicData.getIndCons() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getIndSoliNega() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndSoliNega(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getGrsoOidGrupSoli() != null ? pedTipoSolicData.getGrsoOidGrupSoli().getId() : null));
			row.add((pedTipoSolicData.getIndDevo() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndDevo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getIndAnul() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getSbacOidSbac() != null ? pedTipoSolicData.getSbacOidSbac().getId() : null));
			row.add((pedTipoSolicData.getCodGrupSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getCodGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((pedTipoSolicData.getDescripcion() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(pedTipoSolicData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
