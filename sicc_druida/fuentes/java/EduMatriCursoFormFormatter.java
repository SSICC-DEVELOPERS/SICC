
/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoFormFormatter.java,v 1.1 2009/12/03 18:40:12 pecbazalar Exp $
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
 * Clase de formateo de objetos "EduMatriCurso" para Druida
 * 
 * @author Indra
 */
public class EduMatriCursoFormFormatter extends MMGDruidaFormatoObjeto {
	
	public EduMatriCursoFormFormatter() {
	}

	public void formatea(String s, Object obj) throws Exception {

		IMareDTO dto = (IMareDTO) obj;
		Vector eduMatriCursoList = (Vector) dto.getProperty("result");

		Vector result = new Vector();

		for (int i = 0; i < eduMatriCursoList.size(); i++) {
		
			EduMatriCursoData eduMatriCursoData = (EduMatriCursoData) eduMatriCursoList.elementAt(i);

			Vector row = new Vector();

			// Añadir la clave
			Hashtable primaryKey = eduMatriCursoData.mmgGetPrimaryKey();
			Enumeration keys = primaryKey.keys();
			
			while (keys.hasMoreElements()) {
				Object element = primaryKey.get(keys.nextElement());
				row.add((element != null ? element.toString() : ""));
			}

			// Añadir el resto de atributos
			row.add((eduMatriCursoData.getPaisOidPais() != null ? eduMatriCursoData.getPaisOidPais().getId() : null));
			row.add((eduMatriCursoData.getCplcOidCabePlanCurs() != null ? eduMatriCursoData.getCplcOidCabePlanCurs().getId() : null));
			row.add((eduMatriCursoData.getCodCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getCodCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getTerrOidTerr() != null ? eduMatriCursoData.getTerrOidTerr().getId() : null));
			row.add((eduMatriCursoData.getClasOidClas() != null ? eduMatriCursoData.getClasOidClas().getId() : null));
			row.add((eduMatriCursoData.getFrcuOidFrec() != null ? eduMatriCursoData.getFrcuOidFrec().getId() : null));
			row.add((eduMatriCursoData.getRegaOidRega() != null ? eduMatriCursoData.getRegaOidRega().getId() : null));
			row.add((eduMatriCursoData.getZsgvOidSubgVent() != null ? eduMatriCursoData.getZsgvOidSubgVent().getId() : null));
			row.add((eduMatriCursoData.getZorgOidRegi() != null ? eduMatriCursoData.getZorgOidRegi().getId() : null));
			row.add((eduMatriCursoData.getZzonOidZona() != null ? eduMatriCursoData.getZzonOidZona().getId() : null));
			row.add((eduMatriCursoData.getZsccOidSecc() != null ? eduMatriCursoData.getZsccOidSecc().getId() : null));
			row.add((eduMatriCursoData.getZtadOidTerrAdmi() != null ? eduMatriCursoData.getZtadOidTerrAdmi().getId() : null));
			row.add((eduMatriCursoData.getPerdOidPeriInicComp() != null ? eduMatriCursoData.getPerdOidPeriInicComp().getId() : null));
			row.add((eduMatriCursoData.getPerdOidPeriFinaComp() != null ? eduMatriCursoData.getPerdOidPeriFinaComp().getId() : null));
			row.add((eduMatriCursoData.getPerdOidPeriInicCons() != null ? eduMatriCursoData.getPerdOidPeriInicCons().getId() : null));
			row.add((eduMatriCursoData.getPerdOidPeriFinaCons() != null ? eduMatriCursoData.getPerdOidPeriFinaCons().getId() : null));
			row.add((eduMatriCursoData.getPerdOidPeriIngr() != null ? eduMatriCursoData.getPerdOidPeriIngr().getId() : null));
			row.add((eduMatriCursoData.getTicuOidTipoCurs() != null ? eduMatriCursoData.getTicuOidTipoCurs().getId() : null));
			row.add((eduMatriCursoData.getValPathFich() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getValPathFich(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getValObjeCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getValObjeCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getValContCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getValContCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getValRelaMateCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getValRelaMateCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getValMontVent() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getValMontVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecDispCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecDispCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecLanz() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecLanz(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecFinCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecFinCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecUltiCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecUltiCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecConcCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecConcCurs(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFecIngr() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFecIngr(), 
				 MMGDruidaHelper.getUserDatePattern(this, true), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getNumPart() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getNumPart(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getNumOrde() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getNumOrde(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getNumCampa() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getNumCampa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getNumUnid() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getNumUnid(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getDesCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getDesCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndAcceDmrt() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndAcceDmrt(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndAcceInfo() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndAcceInfo(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndAlcaGeog() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndAlcaGeog(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndBloqExte() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndBloqExte(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndMomeEntr() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndMomeEntr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndCondPedi() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndCondPedi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndCtrlMoro() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndCtrlMoro(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getIndCtrlFunc() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getIndCtrlFunc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getClclOidClieClasCapa() != null ? eduMatriCursoData.getClclOidClieClasCapa().getId() : null));
			
		
			// Añadir el atributo timestamp. Por ahora queda deshabilidato ya no hay bloqueos....
			//row.add(new Long(eduMatriCursoData.jdoGetTimeStamp()).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
