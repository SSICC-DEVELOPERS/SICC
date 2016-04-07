
/*
    INDRA/CAR/mmg
    $Id: EduMatriCursoListFormatter.java,v 1.1 2009/12/03 18:35:10 pecbazalar Exp $
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
public class EduMatriCursoListFormatter extends MMGDruidaFormatoObjeto {
	
	public EduMatriCursoListFormatter() {
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
			row.add((eduMatriCursoData.getPaisOidPais() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPaisOidPais(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getCplcOidCabePlanCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getCplcOidCabePlanCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getCodCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getCodCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getTerrOidTerr() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getTerrOidTerr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getClasOidClas() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getClasOidClas(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getFrcuOidFrec() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getFrcuOidFrec(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getRegaOidRega() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getRegaOidRega(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getZsgvOidSubgVent() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getZsgvOidSubgVent(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getZorgOidRegi() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getZorgOidRegi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getZzonOidZona() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getZzonOidZona(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getZsccOidSecc() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getZsccOidSecc(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getZtadOidTerrAdmi() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getZtadOidTerrAdmi(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getPerdOidPeriInicComp() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPerdOidPeriInicComp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getPerdOidPeriFinaComp() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPerdOidPeriFinaComp(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getPerdOidPeriInicCons() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPerdOidPeriInicCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getPerdOidPeriFinaCons() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPerdOidPeriFinaCons(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getPerdOidPeriIngr() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getPerdOidPeriIngr(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			row.add((eduMatriCursoData.getTicuOidTipoCurs() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getTicuOidTipoCurs(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
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
			row.add((eduMatriCursoData.getClclOidClieClasCapa() != null ? 
				FormatUtils.formatObject(eduMatriCursoData.getClclOidClieClasCapa(), 
				 MMGDruidaHelper.getUserDecimalFormatPattern(this), 
				MMGDruidaHelper.getUserDecimalFormatSymbols(this)) : ""));
			

			// Añadir el atributo timestamp. Por ahora queda deshabilitado (ponemos un 0) ya que no hay bloqueos....
			//row.add(new Long(eduMatriCursoData.jdoGetTimeStamp()).toString());		
			row.add(new Long(0).toString());		
			
			result.add(row);
		}

		setCampo(s, result);
	}
}
