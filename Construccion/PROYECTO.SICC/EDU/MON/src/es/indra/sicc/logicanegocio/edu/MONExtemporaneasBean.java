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
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.edu.DTOClienteInvitada;
import es.indra.sicc.dtos.edu.DTOConsultaCurso;
import es.indra.sicc.dtos.edu.DTOInvita;
import es.indra.sicc.dtos.edu.DTOOIDCurso;
import es.indra.sicc.entidades.edu.AptasACursosLocalHome;
import es.indra.sicc.logicanegocio.edu.ConstantesEDU;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.edu.DTOParticipante;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.sql.Date;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.edu.DTOParticipantesValidados;

import javax.persistence.PersistenceException;


public class MONExtemporaneasBean implements SessionBean  {

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
	
	public DTOSalida cargaRegistrarExtemporaneas(DTOConsultaCurso dtoe) throws MareException {
		/* Obtiene los cursos que están en funcionamiento y cumplen los siguientes
		 * criterios: marca, canal, tipo de curso, código de curso y nombre de curso. 
		*/
		UtilidadesLog.info(" MONExtemporaneas.cargaRegistrarExtemporaneas(DTOConsultaCurso): Entrada");
		//this.validaAcceso(dtoe.getOidPais(),null,dtoe.getMarca(),dtoe.getCanal(),null,null,null,null,null,null,null);
		String usuario =  ctx.getCallerPrincipal().getName();
		//String usuario="USUARIO1"; //para probar
		DAOExtemporaneas dao = new  DAOExtemporaneas(usuario);
		DTOSalida dtoS = new DTOSalida();
		dtoS = dao.consultaCursos(dtoe);
		RecordSet rs= null;
		rs=dtoS.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if (rs.esVacio()) {
           //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaRegistrarExtemporaneas: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }	
		UtilidadesLog.info(" MONExtemporaneas.cargaRegistrarExtemporaneas(DTOConsultaCurso): Salida");
		return dtoS;
	} // fin cargaRegistrarExtemporaneas

	public DTOSalida cargaExtemporaneas(DTOOIDCurso dtoe) throws MareException {
		/* Obtiene los participantes que no han asistido al curso,
		 * son aptos, son de segunda convocatoria y cumplen
		 * los siguientes criterios: oid del curso. 
		 */
		UtilidadesLog.info(" MONExtemporaneas.cargaExtemporaneas(DTOOIDCurso): Entrada");
		//this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		String usuario = ctx.getCallerPrincipal().getName();
		//String usuario = "USUARIO1"; //para probar
		DAOExtemporaneas dao = new  DAOExtemporaneas(usuario);
		DTOSalida dtoS = new DTOSalida();
		dtoS = dao.consultaExtemporaneas(dtoe);
		RecordSet rs= null;
		rs=dtoS.getResultado();
		if(rs == null){
			rs = new RecordSet();
		}
		if (rs.esVacio()) {
           //GEN-0007 --> 005
			UtilidadesLog.debug("****cargaExtemporaneas: no hay datos ");				
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }	
		UtilidadesLog.info(" MONExtemporaneas.cargaExtemporaneas(DTOOIDCurso): Salida");
		return dtoS;
	} // fin cargaExtemporaneas
  
	public void invitaCliente(DTOInvita dtoe) throws MareException  {
		/* Realiza la invitación de los clientes indicados al curso especificado. */
		UtilidadesLog.info(" MONExtemporaneas.invitaCliente(DTOInvita): Entrada");
		this.validaAcceso(dtoe.getOidPais(),null,null,null,null,null,null,null,null,null,null);
		DTOClienteInvitada[] invitadas = dtoe.getInvitadas();
		for(int i=0; i<invitadas.length;i++){
			AptasACursosLocalHome aptasHome = null;
			//AptasACursosLocal aptasLocal = null;
			
			aptasHome = new AptasACursosLocalHome();
			// datos del DTO
			Long oidCurso = dtoe.getOidCurso();
			Long oidCliente = invitadas[i].getOidCliente();
			Long oidSubtipo = invitadas[i].getOidSubtipo();
			Boolean dataMart = obtieneBoolean(ConstantesCMN.VAL_FALSE);
		 	Boolean apta = obtieneBoolean(ConstantesCMN.VAL_FALSE);
			Boolean invitadaCurso = obtieneBoolean(ConstantesCMN.VAL_TRUE);
			Integer asistenciaCurso = ConstantesEDU.NO_ASIS;
			Date fechaAsistencia = null;
			Boolean prueba = obtieneBoolean(ConstantesCMN.VAL_FALSE);
			Integer numConvocatoria = ConstantesEDU.PRIM_CONV;
		
			try{
				aptasHome.create(oidCurso, numConvocatoria, oidCliente, oidSubtipo, fechaAsistencia, dataMart, apta, invitadaCurso, asistenciaCurso, prueba);
			} catch(PersistenceException ex){
				UtilidadesLog.error("invitaCliente: CreateException",ex);
				ctx.setRollbackOnly();
				throw new MareException(ex,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
			}
		}
		UtilidadesLog.info(" MONExtemporaneas.invitaCliente(DTOInvita): Entrada");
	} // fin invitaCliente
	
	private Boolean obtieneBoolean(Integer constantes){

		if(constantes.equals(new Integer("0"))){
			return Boolean.FALSE;
		}else{
			if(constantes.equals(new Integer("1"))){
				return Boolean.TRUE;
			}
		}//si no es cero que devuelva true
		return Boolean.TRUE;
		
	}//

	private void validaAcceso(Long pais, Long sociedad, Long marca, Long canal, Long acceso, 
        Long subacceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio)
        throws MareException {
        UtilidadesLog.info(" MONExtemporaneas.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Entrada");

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

        UtilidadesLog.info(" MONExtemporaneas.validaAcceso(pais, sociedad, marca, canal, acceso, subacceso, subgerencia, region, zona, seccion, territorio): Salida");
    }


	private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
		    UtilidadesLog.info(" MONExtemporaneas.getMONValidacion(): Entrada");
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
		UtilidadesLog.info(" MONExtemporaneas.getMONValidacion(): Salida");
        return ejb;
	}


    /**
     * @author: wancho, vconte, 9/12/2005, SICC-GCC-EDU-2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOParticipantesValidos dtoe
     * @param dtoe
     */
  public DTOParticipantesValidados obtenerParticipantesValidos(DTOOIDs dtoe) 
                                                          throws MareException {
                                                          
    UtilidadesLog.info("MONExtemporaneas.obtenerParticipantesValidos" + 
                       "(DTOOIDs dtoe):Entrada");
         
    DTOParticipantesValidados dtoRetorno = new DTOParticipantesValidados();
    DTOParticipante dtoParticipante = null;
    DTOParticipante[] participantes = null;
    DAOExtemporaneas daoeExt =
                        new DAOExtemporaneas(ctx.getCallerPrincipal().getName());
                        
    RecordSet rs= daoeExt.obtenerParticipantesValidos(dtoe);
    UtilidadesLog.debug("rs: " + rs);
    
    int cantFilas = rs.getRowCount();
    participantes = new DTOParticipante[cantFilas];
    
    for (int i=0; i < cantFilas; i++) {
      UtilidadesLog.info("--- Bucle "  + i);
      dtoParticipante = new DTOParticipante();    
      BigDecimal oidAPTA = (BigDecimal) rs.getValueAt(i,0);
      BigDecimal oidCliente = (BigDecimal) rs.getValueAt(i,1);
      dtoParticipante.setOidCliente( Long.valueOf( oidCliente.toString() ) );
      dtoParticipante.setOidParticipante( Long.valueOf( oidAPTA.toString() ) );
      participantes[i] = dtoParticipante;
      UtilidadesLog.debug("dtoParticipantes: " + dtoParticipante );
    }
    
    dtoRetorno.setValidos(participantes);
    
    UtilidadesLog.info("MONExtemporaneas.obtenerParticipantesValidos" + 
                       "(DTOOIDs dtoe):Salida");
    return dtoRetorno;

  }
}