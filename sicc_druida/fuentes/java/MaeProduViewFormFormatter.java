
/*
    INDRA/CAR/mmg
    $Id: MaeProduViewFormFormatter.java,v 1.1 2009/12/03 18:37:44 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeProduView" para Druida
 * 
 * @author Indra
 */
public class MaeProduViewFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeProduViewFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeProduViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeProduViewList.size(); i++) {
		
			MaeProduViewData maeProduViewData = (MaeProduViewData) maeProduViewList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeProduViewData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeProduViewData.getPaisOidPais() != null ? maeProduViewData.getPaisOidPais().getId() : null));
			row.add((maeProduViewData.getCodSap() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getCodiAnti() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodiAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getDesCort() != null ? 
				FormatUtils.formatObject(maeProduViewData.getDesCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValJera1() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValJera2() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValJera3() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValAtri1() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValAtri2() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValAtri3() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValDimeAlto() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeAlto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValDimeLarg() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValDimeAnch() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeAnch(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValPeso() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValVolu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValVolu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValCostEstd() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValCostEstd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValPrecPosi() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValPrecCata() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValPrecCont() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getNumUnidDentPedi() != null ? 
				FormatUtils.formatObject(maeProduViewData.getNumUnidDentPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getNumUnidCaja() != null ? 
				FormatUtils.formatObject(maeProduViewData.getNumUnidCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getCodImpu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getPctUnid() != null ? 
				FormatUtils.formatObject(maeProduViewData.getPctUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getIndLote() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getIndProdServ() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndProdServ(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getCodIndSitu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodIndSitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getCodIndDentCaja() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodIndDentCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getIndKit() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndKit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduViewData.getValGrupArti() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeProduViewData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
