
/*
    INDRA/CAR/mmg
    $Id: MaeProduFormFormatter.java,v 1.1 2009/12/03 18:41:31 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeProdu" para Druida
 * 
 * @author Indra
 */
public class MaeProduFormFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeProduFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < maeProduList.size(); i++) {
		
			MaeProduData maeProduData = (MaeProduData) maeProduList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = maeProduData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((maeProduData.getPaisOidPais() != null ? maeProduData.getPaisOidPais().getId() : null));
			row.add((maeProduData.getCodSap() != null ? 
				FormatUtils.formatObject(maeProduData.getCodSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getCodiAnti() != null ? 
				FormatUtils.formatObject(maeProduData.getCodiAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getDesCort() != null ? 
				FormatUtils.formatObject(maeProduData.getDesCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValJera1() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValJera2() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValJera3() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValAtri1() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValAtri2() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValAtri3() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValDimeAlto() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeAlto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValDimeLarg() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValDimeAnch() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeAnch(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValPeso() != null ? 
				FormatUtils.formatObject(maeProduData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValVolu() != null ? 
				FormatUtils.formatObject(maeProduData.getValVolu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValCostEstd() != null ? 
				FormatUtils.formatObject(maeProduData.getValCostEstd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValPrecPosi() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValPrecCata() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getValPrecCont() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getNumUnidDentPedi() != null ? 
				FormatUtils.formatObject(maeProduData.getNumUnidDentPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getNumUnidCaja() != null ? 
				FormatUtils.formatObject(maeProduData.getNumUnidCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getCodImpu() != null ? 
				FormatUtils.formatObject(maeProduData.getCodImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getPctUnid() != null ? 
				FormatUtils.formatObject(maeProduData.getPctUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getGeneOidGene() != null ? maeProduData.getGeneOidGene().getId() : null));
			row.add((maeProduData.getSgenOidSupeGene() != null ? maeProduData.getSgenOidSupeGene().getId() : null));
			row.add((maeProduData.getUnmdOidUnidMedi() != null ? maeProduData.getUnmdOidUnidMedi().getId() : null));
			row.add((maeProduData.getUnmdOidUnidMediPeso() != null ? maeProduData.getUnmdOidUnidMediPeso().getId() : null));
			row.add((maeProduData.getUnmdOidUnidMediDime() != null ? maeProduData.getUnmdOidUnidMediDime().getId() : null));
			row.add((maeProduData.getNegoOidNego() != null ? maeProduData.getNegoOidNego().getId() : null));
			row.add((maeProduData.getMeudOidEstaProd() != null ? maeProduData.getMeudOidEstaProd().getId() : null));
			row.add((maeProduData.getLiprOidLineProd() != null ? maeProduData.getLiprOidLineProd().getId() : null));
			row.add((maeProduData.getUnegOidUnidNego() != null ? maeProduData.getUnegOidUnidNego().getId() : null));
			row.add((maeProduData.getPerdOidPeriInic() != null ? maeProduData.getPerdOidPeriInic().getId() : null));
			row.add((maeProduData.getPerdOidPeriFin() != null ? maeProduData.getPerdOidPeriFin().getId() : null));
			row.add((maeProduData.getIndLote() != null ? 
				FormatUtils.formatObject(maeProduData.getIndLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getIndProdServ() != null ? 
				FormatUtils.formatObject(maeProduData.getIndProdServ(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getCodIndSitu() != null ? 
				FormatUtils.formatObject(maeProduData.getCodIndSitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getCodIndDentCaja() != null ? 
				FormatUtils.formatObject(maeProduData.getCodIndDentCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getIndKit() != null ? 
				FormatUtils.formatObject(maeProduData.getIndKit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getFopaOidFormPago() != null ? maeProduData.getFopaOidFormPago().getId() : null));
			row.add((maeProduData.getMaprOidMarcProd() != null ? maeProduData.getMaprOidMarcProd().getId() : null));
			row.add((maeProduData.getValGrupArti() != null ? 
				FormatUtils.formatObject(maeProduData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getCodUnicVent() != null ? 
				FormatUtils.formatObject(maeProduData.getCodUnicVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((maeProduData.getPrfiOidProgFide() != null ? maeProduData.getPrfiOidProgFide().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(maeProduData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
