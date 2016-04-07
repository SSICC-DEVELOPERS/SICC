
/*
    INDRA/CAR/mmg
    $Id: CarParamCarteListFormatter.java,v 1.1 2009/12/03 18:33:57 pecbazalar Exp $
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
 * Clase de formateo de objetos "CarParamCarte" para Druida
 * 
 * @author Indra
 */
public class CarParamCarteListFormatter extends MMGDruidaFormatoObjeto {
	
	public CarParamCarteListFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector carParamCarteList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < carParamCarteList.size(); i++) {
		
			CarParamCarteData carParamCarteData = (CarParamCarteData) carParamCarteList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = carParamCarteData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((carParamCarteData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(carParamCarteData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getGrsoOidGrupSoli() != null ? 
				FormatUtils.formatObject(carParamCarteData.getGrsoOidGrupSoli(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getNiriOidNiveRies() != null ? 
				FormatUtils.formatObject(carParamCarteData.getNiriOidNiveRies(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getCodConf() != null ? 
				FormatUtils.formatObject(carParamCarteData.getCodConf(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getIndDeudVenc() != null ? 
				FormatUtils.formatObject(carParamCarteData.getIndDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getNumDiasDeudVenc() != null ? 
				FormatUtils.formatObject(carParamCarteData.getNumDiasDeudVenc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getIndLineCred() != null ? 
				FormatUtils.formatObject(carParamCarteData.getIndLineCred(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getFecVigeDesd() != null ? 
				FormatUtils.formatObject(carParamCarteData.getFecVigeDesd(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getFecVigeHast() != null ? 
				FormatUtils.formatObject(carParamCarteData.getFecVigeHast(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getValPorcVali() != null ? 
				FormatUtils.formatObject(carParamCarteData.getValPorcVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
		/*
			row.add((carParamCarteData.getIndVali() != null ? 
				FormatUtils.formatObject(carParamCarteData.getIndVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
				*/
				
				
			row.add((carParamCarteData.getIndMontMaxi() != null ? 
				FormatUtils.formatObject(carParamCarteData.getIndMontMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getValMontMaxiPerm() != null ? 
				FormatUtils.formatObject(carParamCarteData.getValMontMaxiPerm(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getIndPorcMaxi() != null ? 
				FormatUtils.formatObject(carParamCarteData.getIndPorcMaxi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getValPorc() != null ? 
				FormatUtils.formatObject(carParamCarteData.getValPorc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getNumDiasAdic() != null ? 
				FormatUtils.formatObject(carParamCarteData.getNumDiasAdic(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((carParamCarteData.getInvaOidIndiVali() != null ? 
				FormatUtils.formatObject(carParamCarteData.getInvaOidIndiVali(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(carParamCarteData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
