
/*
    INDRA/CAR/mmg
    $Id: MaeProduViewListFormatter.java,v 1.1 2009/12/03 18:40:54 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeProduView" para Druida
 * 
 * @author Indra
 */
public class MaeProduViewListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeProduViewListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeProduViewList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
			row.add((maeProduViewData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(maeProduViewData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getCodSap() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getCodiAnti() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodiAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getDesCort() != null ? 
				FormatUtils.formatObject(maeProduViewData.getDesCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValJera1() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValJera2() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValJera3() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValJera3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValAtri1() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValAtri2() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValAtri3() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValAtri3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValDimeAlto() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeAlto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValDimeLarg() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValDimeAnch() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValDimeAnch(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValPeso() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValVolu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValVolu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValCostEstd() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValCostEstd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValPrecPosi() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValPrecCata() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValPrecCont() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getNumUnidDentPedi() != null ? 
				FormatUtils.formatObject(maeProduViewData.getNumUnidDentPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getNumUnidCaja() != null ? 
				FormatUtils.formatObject(maeProduViewData.getNumUnidCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getCodImpu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getPctUnid() != null ? 
				FormatUtils.formatObject(maeProduViewData.getPctUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getIndLote() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getIndProdServ() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndProdServ(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getCodIndSitu() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodIndSitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getCodIndDentCaja() != null ? 
				FormatUtils.formatObject(maeProduViewData.getCodIndDentCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getIndKit() != null ? 
				FormatUtils.formatObject(maeProduViewData.getIndKit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduViewData.getValGrupArti() != null ? 
				FormatUtils.formatObject(maeProduViewData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeProduViewData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
