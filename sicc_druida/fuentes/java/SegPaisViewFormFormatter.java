
/*
    INDRA/CAR/mmg
    $Id: SegPaisViewFormFormatter.java,v 1.1 2009/12/03 18:33:15 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegPaisView" para Druida
 * 
 * @author Indra
 */
public class SegPaisViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegPaisViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segPaisViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segPaisViewList.size(); i++) {
		
			SegPaisViewData segPaisViewData = (SegPaisViewData) segPaisViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segPaisViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segPaisViewData.getCodPais() != null ? 
				FormatUtils.formatObject(segPaisViewData.getCodPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getMoneOidMone() != null ? segPaisViewData.getMoneOidMone().getId() : null));
			row.add((segPaisViewData.getMoneOidMoneAlt() != null ? segPaisViewData.getMoneOidMoneAlt().getId() : null));
			row.add((segPaisViewData.getDescripcion() != null ? 
				FormatUtils.formatObject(segPaisViewData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndInteGis() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndInteGis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValIden() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValIden(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndSaldUnic() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndSaldUnic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValProgEjec() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValProgEjec(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValPorcAlar() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValPorcAlar(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndCompAuto() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndCompAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumDiasMora() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumDiasMora(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndTratAcumDesc() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndTratAcumDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValTiemRezo() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValTiemRezo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValConfSecuCcc() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValConfSecuCcc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumDiasFact() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumDiasFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumLimiDifePago() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumLimiDifePago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndEmisVenc() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndEmisVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValMaxiDifeAnlsComb() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValMaxiDifeAnlsComb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumPosiNumeClie() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumPosiNumeClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValFormFech() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValFormFech(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValSepaMile() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValSepaMile(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValSepaDeci() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValSepaDeci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumPeriEgre() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumPeriEgre(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getNumPeriReti() != null ? 
				FormatUtils.formatObject(segPaisViewData.getNumPeriReti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getFopaOidFormPago() != null ? segPaisViewData.getFopaOidFormPago().getId() : null));
			row.add((segPaisViewData.getValCompTele() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValCompTele(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndFletZonaUbig() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndFletZonaUbig(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValIndiSecuMoni() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValIndiSecuMoni(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndSecu() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndSecu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getIndBalaAreaCheq() != null ? 
				FormatUtils.formatObject(segPaisViewData.getIndBalaAreaCheq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisViewData.getValUrl() != null ? 
				FormatUtils.formatObject(segPaisViewData.getValUrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segPaisViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
