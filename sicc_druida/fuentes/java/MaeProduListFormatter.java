
/*
    INDRA/CAR/mmg
    $Id: MaeProduListFormatter.java,v 1.1 2009/12/03 18:35:16 pecbazalar Exp $
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
 * Clase de formateo de objetos "MaeProdu" para Druida
 * 
 * @author Indra
 */
public class MaeProduListFormatter extends MMGDruidaFormatoObjeto {
	
	public MaeProduListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector maeProduList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		HashMap propiedades = this.getUserProperties();
		Property propiedadFecha = (Property)propiedades.get("FormatoFecha");
		Property propiedadMiles = (Property)propiedades.get("FormatoNumericoSeparadorMiles");
		Property propiedadDecimal = (Property)propiedades.get("FormatoNumericoSeparadorDecimales");		
		DecimalFormatSymbols symbols = new  DecimalFormatSymbols();
		symbols.setDecimalSeparator(propiedadDecimal.getValue().toString().charAt(0));
		symbols.setGroupingSeparator(propiedadMiles.getValue().toString().charAt(0));


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
			row.add((maeProduData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(maeProduData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodSap() != null ? 
				FormatUtils.formatObject(maeProduData.getCodSap(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodiAnti() != null ? 
				FormatUtils.formatObject(maeProduData.getCodiAnti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getDesCort() != null ? 
				FormatUtils.formatObject(maeProduData.getDesCort(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValJera1() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValJera2() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValJera3() != null ? 
				FormatUtils.formatObject(maeProduData.getValJera3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValAtri1() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValAtri2() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValAtri3() != null ? 
				FormatUtils.formatObject(maeProduData.getValAtri3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValDimeAlto() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeAlto(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValDimeLarg() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeLarg(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValDimeAnch() != null ? 
				FormatUtils.formatObject(maeProduData.getValDimeAnch(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValPeso() != null ? 
				FormatUtils.formatObject(maeProduData.getValPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValVolu() != null ? 
				FormatUtils.formatObject(maeProduData.getValVolu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValCostEstd() != null ? 
				FormatUtils.formatObject(maeProduData.getValCostEstd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValPrecPosi() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecPosi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValPrecCata() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecCata(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValPrecCont() != null ? 
				FormatUtils.formatObject(maeProduData.getValPrecCont(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getNumUnidDentPedi() != null ? 
				FormatUtils.formatObject(maeProduData.getNumUnidDentPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getNumUnidCaja() != null ? 
				FormatUtils.formatObject(maeProduData.getNumUnidCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodImpu() != null ? 
				FormatUtils.formatObject(maeProduData.getCodImpu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getPctUnid() != null ? 
				FormatUtils.formatObject(maeProduData.getPctUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getGeneOidGene() != null ? 
				FormatUtils.formatObject(maeProduData.getGeneOidGene(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getSgenOidSupeGene() != null ? 
				FormatUtils.formatObject(maeProduData.getSgenOidSupeGene(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getUnmdOidUnidMedi() != null ? 
				FormatUtils.formatObject(maeProduData.getUnmdOidUnidMedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getUnmdOidUnidMediPeso() != null ? 
				FormatUtils.formatObject(maeProduData.getUnmdOidUnidMediPeso(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getUnmdOidUnidMediDime() != null ? 
				FormatUtils.formatObject(maeProduData.getUnmdOidUnidMediDime(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getNegoOidNego() != null ? 
				FormatUtils.formatObject(maeProduData.getNegoOidNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getMeudOidEstaProd() != null ? 
				FormatUtils.formatObject(maeProduData.getMeudOidEstaProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getLiprOidLineProd() != null ? 
				FormatUtils.formatObject(maeProduData.getLiprOidLineProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getUnegOidUnidNego() != null ? 
				FormatUtils.formatObject(maeProduData.getUnegOidUnidNego(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getPerdOidPeriInic() != null ? 
				FormatUtils.formatObject(maeProduData.getPerdOidPeriInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getPerdOidPeriFin() != null ? 
				FormatUtils.formatObject(maeProduData.getPerdOidPeriFin(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getIndLote() != null ? 
				FormatUtils.formatObject(maeProduData.getIndLote(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getIndProdServ() != null ? 
				FormatUtils.formatObject(maeProduData.getIndProdServ(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodIndSitu() != null ? 
				FormatUtils.formatObject(maeProduData.getCodIndSitu(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodIndDentCaja() != null ? 
				FormatUtils.formatObject(maeProduData.getCodIndDentCaja(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getIndKit() != null ? 
				FormatUtils.formatObject(maeProduData.getIndKit(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getFopaOidFormPago() != null ? 
				FormatUtils.formatObject(maeProduData.getFopaOidFormPago(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getMaprOidMarcProd() != null ? 
				FormatUtils.formatObject(maeProduData.getMaprOidMarcProd(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getValGrupArti() != null ? 
				FormatUtils.formatObject(maeProduData.getValGrupArti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getCodUnicVent() != null ? 
				FormatUtils.formatObject(maeProduData.getCodUnicVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			row.add((maeProduData.getPrfiOidProgFide() != null ? 
				FormatUtils.formatObject(maeProduData.getPrfiOidProgFide(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				symbols) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(maeProduData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
