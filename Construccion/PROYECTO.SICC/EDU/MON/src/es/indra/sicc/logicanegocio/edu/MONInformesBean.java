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

package es.indra.sicc.logicanegocio.edu;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOConsultaPasoHistorico;
import es.indra.sicc.dtos.edu.DTOOIDCurso;
import es.indra.sicc.dtos.edu.DTORegistrarAsistencia;
import es.indra.sicc.dtos.edu.DTORegistrarHistorico;
import es.indra.sicc.entidades.edu.MatrizCursosLocalHome;
import es.indra.sicc.logicanegocio.edu.CNGenerarPasoHistorico;
import es.indra.sicc.logicanegocio.edu.CNRegistrarAsistencia;
import es.indra.sicc.logicanegocio.edu.DAOPasoHistorico;
import es.indra.sicc.logicanegocio.edu.DAORegistrarCurso;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONInformesBean implements SessionBean  {
	private SessionContext ctx;
	
	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
		this.ctx = ctx;
	}

	public DTOSalida cargaPasoHistorico(DTOConsultaPasoHistorico dtoe) throws RemoteException, MareException {
		UtilidadesLog.info(" MONInformes.cargaPasoHistorico(DTOConsultaPasoHistorico): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOPasoHistorico daoPasoHistorico = new DAOPasoHistorico(usuario);
		DTOSalida dtoSalida = daoPasoHistorico.consultaCursos(dtoe);
		RecordSet rs=null;
		rs=dtoSalida.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****CargaPasoHistorico: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		UtilidadesLog.info(" MONInformes.cargaPasoHistorico(DTOConsultaPasoHistorico): Salida");
		return (dtoSalida);
	}

	public void generaPasoHistorico(DTOOID dtoe) throws  RemoteException, MareException {
		UtilidadesLog.info(" MONInformes.generaPasoHistorico(DTOOID): Entrada");
		
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		CNGenerarPasoHistorico cnGenerarPasoHistorico = new CNGenerarPasoHistorico();
		cnGenerarPasoHistorico.setSessionContext(this.ctx);
		cnGenerarPasoHistorico.generarPasoHistorico(dtoe.getOid());
		UtilidadesLog.info(" MONInformes.generaPasoHistorico(DTOOID): Salida");
	}

	public DTOSalida cargaRegistrarCurso(DTOConsultaCurso dtoe) throws RemoteException, MareException {
		UtilidadesLog.info(" MONInformes.cargaRegistrarCurso(DTOConsultaCurso): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAORegistrarCurso daoRegistrarCurso = new DAORegistrarCurso(usuario);
		DTOSalida dtoSalida = daoRegistrarCurso.consultaCursos(dtoe);
		RecordSet rs=null;
		rs=dtoSalida.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaRegistrarCurso: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		UtilidadesLog.info(" MONInformes.cargaRegistrarCurso(DTOConsultaCurso): Salida");
		return (dtoSalida);
	}

	public DTOSalida cargaParticipantes(DTOOIDCurso dtoe) throws RemoteException, MareException {
		UtilidadesLog.info(" MONInformes.cargaParticipantes(DTOOIDCurso): Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAORegistrarCurso daoRegistrarCurso = new DAORegistrarCurso(usuario);
		DTOSalida dtoSalida = daoRegistrarCurso.consultaParticipantes(dtoe);
		RecordSet rs=null;
		rs=dtoSalida.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if (rs.esVacio()) {
            //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaParticipantes: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
		UtilidadesLog.info(" MONInformes.cargaParticipantes(DTOOIDCurso): Salida");
		return (dtoSalida);
	}

	public void registraAsistencia(DTORegistrarAsistencia dtoe) throws RemoteException, MareException {
		UtilidadesLog.info(" MONInformes.registraAsistencia(DTORegistrarAsistencia): Entrada");
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		CNRegistrarAsistencia cnRegistrarAsistencia = new CNRegistrarAsistencia();
		cnRegistrarAsistencia.setSessionContext(this.ctx);
		cnRegistrarAsistencia.registrarAsistencia(dtoe);
		UtilidadesLog.info(" MONInformes.registraAsistencia(DTORegistrarAsistencia): Salida");
	}


    private MatrizCursosLocalHome getMatrizCursosLocalHome() throws MareException {
		//final InitialContext context = new InitialContext();
		//return (MatrizCursosLocalHome)context.lookup("java:comp/env/MatrizCursos");
		return (MatrizCursosLocalHome)UtilidadesEJB.getLocalHome("java:comp/env/MatrizCursos");
	}
		

	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info(" MONInformes.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = Boolean.valueOf(true);

        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais + ",sociedad = " + sociedad +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso + ",subacceso = "
	        + subacceso +  ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);

        try {
            b = monValidacion.validarAccesos(pais, sociedad, marca, canal, acceso,
                    subacceso, subgerencia, region, zona, seccion, territorio);
        } catch (RemoteException rExc) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "**** validaAccesoVinculos: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info(" MONInformes.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Salida");
    }


	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		   UtilidadesLog.info("  MONInformes.getMONValidacion(): Entrada");				
        MONValidacionHome home = (MONValidacionHome)UtilidadesEJB.getHome(
            "MONValidacion", MONValidacionHome.class);
            
        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;
        try {
            ejb = home.create();
        } catch (Exception e) {
			UtilidadesLog.error("*** Error en getMONValidacion",e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } 
		UtilidadesLog.info("  MONInformes.getMONValidacion(): Salida");				
        return ejb;
	}	

  /**
   * @author: ssantana, 12/12/2005, SICC-GCC-EDU-009
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoOid
   */
 public void generaPasoHistoricoExtemporaneas(DTORegistrarHistorico dto) 
                                                       throws MareException {
     UtilidadesLog.info("MONInformes.generaPasoHistoricoExtemporaneas" + 
                        "(DTOOID dtoOid): Entrada");
                        
    // Long oid = dtoOid.getOid();
     CNGenerarPasoHistorico cnGenerarPasoHist = new CNGenerarPasoHistorico();
     cnGenerarPasoHist.setSessionContext(ctx);
     
     cnGenerarPasoHist.generaPasoHistoricoExtemporaneas(dto);
     
     UtilidadesLog.info("MONInformes.generaPasoHistoricoExtemporaneas" + 
                        "(DTOOID dtoOid): Salida");
 }


    /**
     * Este metodo se usa para realizar el paso a Historico de los clientes Registrados por Nuevas
     * 
     * @author Rafael Romero
     * @date 17/04/2007
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     */
    public void generaPasoHistorico(DTORegistrarHistorico dtoe) throws MareException {
        /*
         * public void generaPasoHistoricoExtemporaneas(DTORegistrarHistorico dto) throws MareException
         */
        UtilidadesLog.info("MONInformes.generaPasoHistorico(DTORegistrarHistorico): Entrada");
        CNGenerarPasoHistorico cnGenerarPasoHist = new CNGenerarPasoHistorico();
        cnGenerarPasoHist.setSessionContext(ctx);
        cnGenerarPasoHist.generaPasoHistorico(dtoe);
        UtilidadesLog.info("MONInformes.generaPasoHistorico(DTORegistrarHistorico): Salida");
    }
}