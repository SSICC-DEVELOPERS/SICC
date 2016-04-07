/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.logicanegocio.rec;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.rec.IReclamos;
import es.indra.sicc.logicanegocio.rec.DAORec;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.DTOSalida;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRecBean implements SessionBean, IReclamos {

	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
	}

	public DTOSalida obtenerMotivosRechazoDesbloqueo(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONRec.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Entrada");
		
		DAORec daoRec = new DAORec();
		RecordSet rs = daoRec.obtenerMotivosRechazoDesbloqueo(dto);
		DTOSalida dts = new DTOSalida();
		dts.setResultado(rs);
		
		UtilidadesLog.info("MONRec.obtenerMotivosRechazoDesbloqueo(DTOBelcorp):Salida");
		return dts;
	}

  public DTOSalida obtenerComboOperaciones(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONRec.obtenerComboOperaciones(DTOBelcorp):Entrada");
		
		DAORec daoRec = new DAORec();
		DTOSalida dtoSalida = new DTOSalida();
		dtoSalida = daoRec.obtenerComboOperaciones(dto);
				
		UtilidadesLog.info("MONRec.obtenerComboOperaciones(DTOBelcorp):Salida");
    return dtoSalida;
		
  }
}