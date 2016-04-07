
/*
    INDRA/CAR/mmg
    $Id: BelParamBelceFormFormatter.java,v 1.1 2009/12/03 18:37:41 pecbazalar Exp $
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
 * Clase de formateo de objetos "BelParamBelce" para Druida
 * 
 * @author Indra
 */
public class BelParamBelceFormFormatter extends MMGDruidaFormatoObjeto {
	
	public BelParamBelceFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector belParamBelceList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

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
			row.add((belParamBelceData.getSbacOidSbac() != null ? belParamBelceData.getSbacOidSbac().getId() : null));
			row.add((belParamBelceData.getValDire() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValDire(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValTfno() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValTfno(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValMontMaxiDife() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValMontMaxiDife(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValLimiEfecCaja() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValLimiEfecCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getNumCaja() != null ? 
				FormatUtils.formatObject(belParamBelceData.getNumCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValNombLoca() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValNombLoca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValTiempRepo() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValTiempRepo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValFactLoca() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValFactLoca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getNumMaxiProd() != null ? 
				FormatUtils.formatObject(belParamBelceData.getNumMaxiProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValAlerStoc() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValAlerStoc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getValUsua() != null ? 
				FormatUtils.formatObject(belParamBelceData.getValUsua(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((belParamBelceData.getClieOidClie() != null ? belParamBelceData.getClieOidClie().getId() : null));
			row.add((belParamBelceData.getSociOidSoci() != null ? belParamBelceData.getSociOidSoci().getId() : null));
			row.add((belParamBelceData.getTtraOidTipoTran() != null ? belParamBelceData.getTtraOidTipoTran().getId() : null));
			row.add((belParamBelceData.getCcbaOidCuenCorrBanc() != null ? belParamBelceData.getCcbaOidCuenCorrBanc().getId() : null));
			row.add((belParamBelceData.getTmvcOidCobr() != null ? belParamBelceData.getTmvcOidCobr().getId() : null));
			row.add((belParamBelceData.getTmvcOidCier() != null ? belParamBelceData.getTmvcOidCier().getId() : null));
			row.add((belParamBelceData.getTmalOidConfStoc() != null ? belParamBelceData.getTmalOidConfStoc().getId() : null));
			row.add((belParamBelceData.getTmalOidConfStocTran() != null ? belParamBelceData.getTmalOidConfStocTran().getId() : null));
			row.add((belParamBelceData.getTmalOidStocTran() != null ? belParamBelceData.getTmalOidStocTran().getId() : null));
			row.add((belParamBelceData.getTmalOidStocDevo() != null ? belParamBelceData.getTmalOidStocDevo().getId() : null));
			row.add((belParamBelceData.getTmalOidRegu() != null ? belParamBelceData.getTmalOidRegu().getId() : null));
			row.add((belParamBelceData.getTmalOidReguSap() != null ? belParamBelceData.getTmalOidReguSap().getId() : null));
			row.add((belParamBelceData.getTmalOidDevoStoc() != null ? belParamBelceData.getTmalOidDevoStoc().getId() : null));
			row.add((belParamBelceData.getTmalOidPetiExis() != null ? belParamBelceData.getTmalOidPetiExis().getId() : null));
			row.add((belParamBelceData.getPaisOidPais() != null ? belParamBelceData.getPaisOidPais().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(belParamBelceData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
