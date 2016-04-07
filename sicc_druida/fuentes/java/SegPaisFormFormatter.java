
/*
    INDRA/CAR/mmg
    $Id: SegPaisFormFormatter.java,v 1.1 2009/12/03 18:38:06 pecbazalar Exp $
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
 * Clase de formateo de objetos "SegPais" para Druida
 * 
 * @author Indra
 */
public class SegPaisFormFormatter extends MMGDruidaFormatoObjeto {
	
	public SegPaisFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector segPaisList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < segPaisList.size(); i++) {
		
			SegPaisData segPaisData = (SegPaisData) segPaisList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = segPaisData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((segPaisData.getCodPais() != null ? 
				FormatUtils.formatObject(segPaisData.getCodPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getMoneOidMone() != null ? segPaisData.getMoneOidMone().getId() : null));
			row.add((segPaisData.getMoneOidMoneAlt() != null ? segPaisData.getMoneOidMoneAlt().getId() : null));
			row.add((segPaisData.getDescripcion() != null ? 
				FormatUtils.formatObject(segPaisData.getDescripcion(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndInteGis() != null ? 
				FormatUtils.formatObject(segPaisData.getIndInteGis(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValIden() != null ? 
				FormatUtils.formatObject(segPaisData.getValIden(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndSaldUnic() != null ? 
				FormatUtils.formatObject(segPaisData.getIndSaldUnic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValProgEjec() != null ? 
				FormatUtils.formatObject(segPaisData.getValProgEjec(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValPorcAlar() != null ? 
				FormatUtils.formatObject(segPaisData.getValPorcAlar(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndCompAuto() != null ? 
				FormatUtils.formatObject(segPaisData.getIndCompAuto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumDiasMora() != null ? 
				FormatUtils.formatObject(segPaisData.getNumDiasMora(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndTratAcumDesc() != null ? 
				FormatUtils.formatObject(segPaisData.getIndTratAcumDesc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValTiemRezo() != null ? 
				FormatUtils.formatObject(segPaisData.getValTiemRezo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValConfSecuCcc() != null ? 
				FormatUtils.formatObject(segPaisData.getValConfSecuCcc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumDiasFact() != null ? 
				FormatUtils.formatObject(segPaisData.getNumDiasFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumLimiDifePago() != null ? 
				FormatUtils.formatObject(segPaisData.getNumLimiDifePago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndEmisVenc() != null ? 
				FormatUtils.formatObject(segPaisData.getIndEmisVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValMaxiDifeAnlsComb() != null ? 
				FormatUtils.formatObject(segPaisData.getValMaxiDifeAnlsComb(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumPosiNumeClie() != null ? 
				FormatUtils.formatObject(segPaisData.getNumPosiNumeClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValFormFech() != null ? 
				FormatUtils.formatObject(segPaisData.getValFormFech(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValSepaMile() != null ? 
				FormatUtils.formatObject(segPaisData.getValSepaMile(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValSepaDeci() != null ? 
				FormatUtils.formatObject(segPaisData.getValSepaDeci(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumPeriEgre() != null ? 
				FormatUtils.formatObject(segPaisData.getNumPeriEgre(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getNumPeriReti() != null ? 
				FormatUtils.formatObject(segPaisData.getNumPeriReti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getFopaOidFormPago() != null ? segPaisData.getFopaOidFormPago().getId() : null));
			row.add((segPaisData.getValCompTele() != null ? 
				FormatUtils.formatObject(segPaisData.getValCompTele(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndFletZonaUbig() != null ? 
				FormatUtils.formatObject(segPaisData.getIndFletZonaUbig(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValIndiSecuMoni() != null ? 
				FormatUtils.formatObject(segPaisData.getValIndiSecuMoni(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndSecu() != null ? 
				FormatUtils.formatObject(segPaisData.getIndSecu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndBalaAreaCheq() != null ? 
				FormatUtils.formatObject(segPaisData.getIndBalaAreaCheq(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getValUrl() != null ? 
				FormatUtils.formatObject(segPaisData.getValUrl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((segPaisData.getIndImpuIncl() != null ? 
				FormatUtils.formatObject(segPaisData.getIndImpuIncl(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(segPaisData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
