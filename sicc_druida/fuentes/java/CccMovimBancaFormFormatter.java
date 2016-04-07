
/*
    INDRA/CAR/mmg
    $Id: CccMovimBancaFormFormatter.java,v 1.1 2009/12/03 18:34:37 pecbazalar Exp $
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
 * Clase de formateo de objetos "CccMovimBanca" para Druida
 * 
 * @author Indra
 */
public class CccMovimBancaFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CccMovimBancaFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector cccMovimBancaList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < cccMovimBancaList.size(); i++) {
		
			CccMovimBancaData cccMovimBancaData = (CccMovimBancaData) cccMovimBancaList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = cccMovimBancaData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((cccMovimBancaData.getSociOidSoci() != null ? cccMovimBancaData.getSociOidSoci().getId() : null));
			row.add((cccMovimBancaData.getSubpOidMarcUlti() != null ? cccMovimBancaData.getSubpOidMarcUlti().getId() : null));
			row.add((cccMovimBancaData.getSubpOidMarcCrea() != null ? cccMovimBancaData.getSubpOidMarcCrea().getId() : null));
			row.add((cccMovimBancaData.getTcabOidAbonUlti() != null ? cccMovimBancaData.getTcabOidAbonUlti().getId() : null));
			row.add((cccMovimBancaData.getTcabOidAbonCrea() != null ? cccMovimBancaData.getTcabOidAbonCrea().getId() : null));
			row.add((cccMovimBancaData.getTtraOidTipoTrans() != null ? cccMovimBancaData.getTtraOidTipoTrans().getId() : null));
			row.add((cccMovimBancaData.getCcbaOidCcBanc() != null ? cccMovimBancaData.getCcbaOidCcBanc().getId() : null));
			row.add((cccMovimBancaData.getNumConsTran() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getNumConsTran(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getNumLote() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getNumLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getCodCons() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getCodCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getCodConsReal() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getCodConsReal(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getCodErro() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getCodErro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDigiCheqFact() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDigiCheqFact(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuApliAnio() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuApliAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuApliMesSeri() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuApliMesSeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuApliNume() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuApliNume(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuCreaAnio() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuCreaAnio(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuCreaMesSeri() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuCreaMesSeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValDocuCreaNume() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValDocuCreaNume(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValEstaMoviPend() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValEstaMoviPend(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getFecCont() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getFecCont(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getFecPago() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getFecPago(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getFecProc() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getFecProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValHoraProc() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValHoraProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValHoraNormAdic() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValHoraNormAdic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getCodIdenProc() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getCodIdenProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getImpPago() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getImpPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValNombOfic() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValNombOfic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getNumCupo() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getNumCupo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValNumeDocu() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValNumeDocu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getNumFactBole() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getNumFactBole(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValNumeLoteCont() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValNumeLoteCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValObse() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getCodOficReca() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getCodOficReca(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getValUsuaProc() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getValUsuaProc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((cccMovimBancaData.getFecMoviApli() != null ? 
				FormatUtils.formatObject(cccMovimBancaData.getFecMoviApli(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(cccMovimBancaData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
