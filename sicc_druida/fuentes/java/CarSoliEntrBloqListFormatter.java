
/*
    INDRA/CAR/mmg
    $Id: CarSoliEntrBloqListFormatter.java,v 1.1 2009/12/03 18:36:14 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarSoliEntrBloq" para Druida
 * 
 * @author Indra
 */
public class CarSoliEntrBloqListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarSoliEntrBloqListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carSoliEntrBloqList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carSoliEntrBloqList.size(); i++) {
		
			CarSoliEntrBloqData carSoliEntrBloqData = (CarSoliEntrBloqData) carSoliEntrBloqList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carSoliEntrBloqData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carSoliEntrBloqData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getSbacOidSbac() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getSbacOidSbac(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getTsolOidTipoSoli() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getTsolOidTipoSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getSocaOidSoliCabe() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getSocaOidSoliCabe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getFecDocu() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getFecDocu(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getIndNoti() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getIndNoti(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getValMontOrde() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getValMontOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getValMontDeudVenc() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getValMontDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getIndVali1() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getIndVali1(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getIndVali2() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getIndVali2(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getIndVali3() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getIndVali3(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getIndVali4() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getIndVali4(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getFecHoraLibe() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getFecHoraLibe(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getValObse() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getValObse(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getJeraOidJera() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getJeraOidJera(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getEspeOidEstaPedi() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getEspeOidEstaPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getPerdOidPeri() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getPerdOidPeri(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getClieOidClie() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getClieOidClie(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getClieOidGereZona() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getClieOidGereZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getCuadOidClieUnidAdmi() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getCuadOidClieUnidAdmi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getCoapOidCodiApro() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getCoapOidCodiApro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getEjcuOidEjecCuen() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getEjcuOidEjecCuen(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getEjcuOidUsuaLibe() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getEjcuOidUsuaLibe(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getNiriOidNiveRies() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getNiriOidNiveRies(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carSoliEntrBloqData.getGrsoOidGrupSoli() != null ? 
				FormatUtils.formatObject(carSoliEntrBloqData.getGrsoOidGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carSoliEntrBloqData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
