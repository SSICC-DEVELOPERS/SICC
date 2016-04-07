
/*
    INDRA/CAR/mmg
    $Id: BelParamBelceListFormatter.java,v 1.1 2009/12/03 18:39:44 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelParamBelce" para Druida
 * 
 * @author Indra
 */
public class BelParamBelceListFormatter extends MMGDruidaFormatoObjeto {
	
	public BelParamBelceListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belParamBelceList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


		for (int i = 0; i < belParamBelceList.size(); i++) {
		
			BelParamBelceData belParamBelceData = (BelParamBelceData) belParamBelceList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = belParamBelceData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((belParamBelceData.getSbacOidSbac() != null ? 
				FormatUtils.formatObject(belParamBelceData.getSbacOidSbac(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValDire() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValTfno() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValTfno(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValMontMaxiDife() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValMontMaxiDife(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValLimiEfecCaja() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValLimiEfecCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getNumCaja() != null ? 
				FormatUtils.formatObject(belParamBelceData.getNumCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValNombLoca() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValNombLoca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValTiempRepo() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValTiempRepo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValFactLoca() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValFactLoca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getNumMaxiProd() != null ? 
				FormatUtils.formatObject(belParamBelceData.getNumMaxiProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValAlerStoc() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValAlerStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getValUsua() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getClieOidClie() != null ? 
				FormatUtils.formatObject(belParamBelceData.getClieOidClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getSociOidSoci() != null ? 
				FormatUtils.formatObject(belParamBelceData.getSociOidSoci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTtraOidTipoTran() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTtraOidTipoTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getCcbaOidCuenCorrBanc() != null ? 
				FormatUtils.formatObject(belParamBelceData.getCcbaOidCuenCorrBanc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmvcOidCobr() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmvcOidCobr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmvcOidCier() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmvcOidCier(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidConfStoc() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidConfStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidConfStocTran() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidConfStocTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidStocTran() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidStocTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidStocDevo() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidStocDevo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidRegu() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidRegu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidReguSap() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidReguSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidDevoStoc() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidDevoStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((belParamBelceData.getTmalOidPetiExis() != null ? 
				FormatUtils.formatObject(belParamBelceData.getTmalOidPetiExis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(belParamBelceData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
