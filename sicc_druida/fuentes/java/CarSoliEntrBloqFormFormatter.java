
/*
    INDRA/CAR/mmg
    $Id: CarSoliEntrBloqFormFormatter.java,v 1.1 2009/12/03 18:32:52 pecbazalar Exp $
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
public class CarSoliEntrBloqFormFormatter extends MMGDruidaFormatoObjeto {
	
	public CarSoliEntrBloqFormFormatter() {
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
			row.add((carSoliEntrBloqData.getPaisOidPais() != null ? carSoliEntrBloqData.getPaisOidPais().getId() : null));
			row.add((carSoliEntrBloqData.getSbacOidSbac() != null ? carSoliEntrBloqData.getSbacOidSbac().getId() : null));
			row.add((carSoliEntrBloqData.getTsolOidTipoSoli() != null ? carSoliEntrBloqData.getTsolOidTipoSoli().getId() : null));
			row.add((carSoliEntrBloqData.getSocaOidSoliCabe() != null ? carSoliEntrBloqData.getSocaOidSoliCabe().getId() : null));
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
			row.add((carSoliEntrBloqData.getJeraOidJera() != null ? carSoliEntrBloqData.getJeraOidJera().getId() : null));
			row.add((carSoliEntrBloqData.getEspeOidEstaPedi() != null ? carSoliEntrBloqData.getEspeOidEstaPedi().getId() : null));
			row.add((carSoliEntrBloqData.getPerdOidPeri() != null ? carSoliEntrBloqData.getPerdOidPeri().getId() : null));
			row.add((carSoliEntrBloqData.getClieOidClie() != null ? carSoliEntrBloqData.getClieOidClie().getId() : null));
			row.add((carSoliEntrBloqData.getClieOidGereZona() != null ? carSoliEntrBloqData.getClieOidGereZona().getId() : null));
			row.add((carSoliEntrBloqData.getCuadOidClieUnidAdmi() != null ? carSoliEntrBloqData.getCuadOidClieUnidAdmi().getId() : null));
			row.add((carSoliEntrBloqData.getCoapOidCodiApro() != null ? carSoliEntrBloqData.getCoapOidCodiApro().getId() : null));
			row.add((carSoliEntrBloqData.getEjcuOidEjecCuen() != null ? carSoliEntrBloqData.getEjcuOidEjecCuen().getId() : null));
			row.add((carSoliEntrBloqData.getEjcuOidUsuaLibe() != null ? carSoliEntrBloqData.getEjcuOidUsuaLibe().getId() : null));
			row.add((carSoliEntrBloqData.getNiriOidNiveRies() != null ? carSoliEntrBloqData.getNiriOidNiveRies().getId() : null));
			row.add((carSoliEntrBloqData.getGrsoOidGrupSoli() != null ? carSoliEntrBloqData.getGrsoOidGrupSoli().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(carSoliEntrBloqData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
