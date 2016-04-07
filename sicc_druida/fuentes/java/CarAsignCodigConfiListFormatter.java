
/*
    INDRA/CAR/mmg
    $Id: CarAsignCodigConfiListFormatter.java,v 1.1 2009/12/03 18:43:42 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarAsignCodigConfi" para Druida
 * 
 * @author Indra
 */
public class CarAsignCodigConfiListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarAsignCodigConfiListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carAsignCodigConfiList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carAsignCodigConfiList.size(); i++) {
		
			CarAsignCodigConfiData carAsignCodigConfiData = (CarAsignCodigConfiData) carAsignCodigConfiList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carAsignCodigConfiData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carAsignCodigConfiData.getZsgvOidSubgVent() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getZsgvOidSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getZorgOidRegi() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getZorgOidRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getZzonOidZona() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getZzonOidZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getGrsoOidGrupSoli() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getGrsoOidGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getNiriOidNiveRies() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getNiriOidNiveRies(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getNiriOidNiveRiesInici() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getNiriOidNiveRiesInici(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getPacaOidParaCart() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getPacaOidParaCart(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carAsignCodigConfiData.getValLineCredInic() != null ? 
				FormatUtils.formatObject(carAsignCodigConfiData.getValLineCredInic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carAsignCodigConfiData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
