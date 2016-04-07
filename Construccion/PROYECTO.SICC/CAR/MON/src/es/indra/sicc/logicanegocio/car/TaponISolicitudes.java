package es.indra.sicc.logicanegocio.car;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.car.DTOCreditoRiesgo;

import java.math.BigDecimal;

public class TaponISolicitudes  {
	public TaponISolicitudes() {}

	public DTOCreditoRiesgo obtenerCreditoRiesgoConsultoraNueva (	Long pais, 
							Long territorioAdministrativo ) throws MareException{

		DTOCreditoRiesgo dtoS = new DTOCreditoRiesgo();
		dtoS.setMontoLineaCredito(new BigDecimal(0));
		dtoS.setNivelRiesgo(new Long(1));
		return dtoS;
	}
}