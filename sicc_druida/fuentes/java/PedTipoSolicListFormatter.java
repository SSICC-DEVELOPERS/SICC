
/*
    INDRA/CAR/mmg
    $Id: PedTipoSolicListFormatter.java,v 1.1 2009/12/03 18:41:10 pecbazalar Exp $
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
 * Clase de formateo de objetos "PedTipoSolic" para Druida
 * 
 * @author Indra
 */
public class PedTipoSolicListFormatter extends MMGDruidaFormatoObjeto {
	
	public PedTipoSolicListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector pedTipoSolicList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
				symbols) : ""));
			row.add((pedTipoSolicData.getTiclOidTipoClie() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getTiclOidTipoClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getMarcOidMarc() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getMarcOidMarc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getAcceOidAcce() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getAcceOidAcce(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getClsoOidClasSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getClsoOidClasSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getIndCons() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getIndSoliNega() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndSoliNega(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getGrsoOidGrupSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getGrsoOidGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getIndDevo() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndDevo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getIndAnul() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getIndAnul(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getSbacOidSbac() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getSbacOidSbac(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((pedTipoSolicData.getCodGrupSoli() != null ? 
				FormatUtils.formatObject(pedTipoSolicData.getCodGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(pedTipoSolicData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
