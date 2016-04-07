package es.indra.sicc.logicanegocio.car;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.car.DTOBusquedaSolBloqueadas;
import es.indra.sicc.dtos.car.DTODatosLiberacion;
import es.indra.sicc.dtos.car.DTOPaginado;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocalHome;
import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ejb.FinderException;
import javax.ejb.CreateException;
import java.sql.Date;
import es.indra.sicc.logicanegocio.ped.DAOSolicitud;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.car.DTOSolicitudBloqueada;
import java.sql.Timestamp;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONSolicitudesBloqueadasBean implements SessionBean  {

	SessionContext ctx;
	
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


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Este metodo llama la metodo del mismo nombre en el DAOCAR pasandole el dtoin. 
	 * 				Con el RecordSet recibido construye y DTOSalida y lo retorna. 
     *              
     * 04/09/2006 - [1] pperanzola: mejoras por performance.
	 */
	public DTOSalida consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas dtoin) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas):Entrada");
		String user = ctx.getCallerPrincipal().getName();
		DAOCAR dao = new DAOCAR(user);
		RecordSet resultado = dao.consultarSolicitudesBloqueadas2(dtoin);//[1] dao.consultarSolicitudesBloqueadas(dtoin);
		if( resultado.esVacio() ){
			String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
		}
		DTOSalida dtoSalida = new DTOSalida(resultado);		
        UtilidadesLog.info("MONSolicitudesBloqueadas.consultarSolicitudesBloqueadas(DTOBusquedaSolBloqueadas):Salida");
		return dtoSalida;
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Realiza un findByPrimaryKey sobre la entidad CAR:SolicitudesEntregaBloqueadas. 
	 * 				Se hace un set sobre el atributo "Estatus" colocandole el valor ConstantesCAR.ESTATUS_RECHAZADO 
	 */
	public void rechazarSolicitud(DTOOID dtoin) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.rechazarSolicitud(DTOOID):Entrada");
		try{
			SolicitudesEntregaBloqueadasLocalHome solicitudesEntregaBloqueadasLH = this.getSolicitudesEntregaBloqueadasLocalHome();
			SolicitudesEntregaBloqueadasLocal solicitudesEntregaBloqueadas = 
					solicitudesEntregaBloqueadasLH.findByPrimaryKey(dtoin.getOid());
			solicitudesEntregaBloqueadas.setOidEstatusPedido(ConstantesCAR.ESTATUS_RECHAZADO);
                        
                        solicitudesEntregaBloqueadasLH.merge(solicitudesEntregaBloqueadas);
                        
		    } catch (NoResultException nre) {
                        ctx.setRollbackOnly();
                        throw new MareException(nre,        
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                    }
        UtilidadesLog.info("MONSolicitudesBloqueadas.rechazarSolicitud(DTOOID):Salida");
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Realiza un findByPrimaryKey sobre la entidad CAR:SolicitudesEntregaBloqueadas utilizando el oidSolicitudBloqueada 
	 * 				Se hace un set sobre el atributo "Estatus" colocandole el valor ConstantesCAR.ESTATUS_LIBERADO 
	 * 				Se hace un set sobre el atributo "Usuario" colocandole el valor dtoin.usuario 
	 * 				Se hace un set sobre el atributo "FechaHoraLiberacion" colocandole el valor de la fecha del sistema 
	 * 				Se hace un set sobre el atributo "codigoAprobacion" colocandole el valor dtoin.oidCodigoAprobacion 
	 * 				Se hace un set sobre el atributo "observacion" colocandole el valor dtoin.observaciones 
	 *              
	 *				Utilizando el atributo numSolicitudEntrega se hacen las siguientes Llamadas: 
	 * 				DAOSolicitud.actualizarEstatusCredito(numSolicitudEntrega,ConstantesCAR.ESTATUS_LIBERADO) 
	 *				DAOSolicitud.actualizarEstado(numSolicitudEntrega,ConstantesPED.ESTATUS_SOLICITUD_LIBERADO) 
	 */
	public void liberarSolicitud(DTODatosLiberacion dtoin) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.liberarSolicitud(DTODatosLiberacion):Entrada");
		try{
			SolicitudesEntregaBloqueadasLocalHome solicitudesEntregaBloqueadasLH = this.getSolicitudesEntregaBloqueadasLocalHome();
			SolicitudesEntregaBloqueadasLocal solicitudesEntregaBloqueadas = 
					solicitudesEntregaBloqueadasLH.findByPrimaryKey(dtoin.getOidSolicitudBloqueada());	
			solicitudesEntregaBloqueadas.setOidEstatusPedido(ConstantesCAR.ESTATUS_LIBERADO);
			solicitudesEntregaBloqueadas.setOidUsuarioLiberacion(dtoin.getOidEjecutivo());
			solicitudesEntregaBloqueadas.setFechaHoraLiberacion(new Timestamp(System.currentTimeMillis()));
			solicitudesEntregaBloqueadas.setOidCodigoAprobacion(dtoin.getOidCodigoAprobacion());
			solicitudesEntregaBloqueadas.setObservaciones(dtoin.getObservacion());
                        
                        solicitudesEntregaBloqueadasLH.merge(solicitudesEntregaBloqueadas);

			solicitudesEntregaBloqueadas.getOidSolcitudCabecera();
			DAOSolicitud dao = new DAOSolicitud();
			dao.actualizarEstatusCredito(solicitudesEntregaBloqueadas.getOidSolcitudCabecera(), ConstantesCAR.ESTATUS_LIBERADO);
			dao.actualizarEstado(solicitudesEntregaBloqueadas.getOidSolcitudCabecera(), 
					new Integer( ConstantesPED.ESTADO_SOLICITUD_LIBERADO.intValue() ) );
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONSolicitudesBloqueadas.liberarSolicitud(DTODatosLiberacion):Salida");
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Realiza un findByPrimaryKey sobre la entidad CAR:SolicitudesEntregaBloqueadas utilizando el oidSolicitudBloqueada 
	 *				Se hace un set sobre el atributo "Estatus" colocandole el valor ConstantesCAR.ESTATUS_REASIGNADO 
	 *				Se hace un set sobre el atributo "ejecutivo" colocandole el valor dtoin.oidEjecutivo 
	 *				Se hace un set sobre el atributo "observacion" colocandole el valor dtoin.observaciones 
	 */	
	public void reasignarSolicitud(DTODatosLiberacion dtoin) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.reasignarSolicitud(DTODatosLiberacion):Entrada");
		try{
			SolicitudesEntregaBloqueadasLocalHome solicitudesEntregaBloqueadasLH = this.getSolicitudesEntregaBloqueadasLocalHome();
			SolicitudesEntregaBloqueadasLocal solicitudesEntregaBloqueadas = 
					solicitudesEntregaBloqueadasLH.findByPrimaryKey(dtoin.getOidSolicitudBloqueada());
			solicitudesEntregaBloqueadas.setOidEstatusPedido(ConstantesCAR.ESTATUS_REASIGNADO);
			solicitudesEntregaBloqueadas.setOidEjecutivoCuenta(dtoin.getOidEjecutivo());
			solicitudesEntregaBloqueadas.setObservaciones(dtoin.getObservacion());
                        
		        solicitudesEntregaBloqueadasLH.merge(solicitudesEntregaBloqueadas);
                    
                } catch (NoResultException nre) {
                    ctx.setRollbackOnly();
                    throw new MareException(nre,        
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE) );         
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONSolicitudesBloqueadas.reasignarSolicitud(DTODatosLiberacion):Salida");
	}


	/**
	 * Sistema:     Belcorp
	 * Modulo:      CAR
	 * Fecha:       28/09/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Llama al metodo obtenerEjecutivosPaginado(dtoin : DTOPaginado) : RecordSet del DAOCAR. 
	 *				Con el recordSet obtenido crea un DTOSalida y lo retorna. 
	 * 				En caso de error genera una MAREException. 
	 */
	public DTOSalida obtenerNuevosEjecutivos(DTOPaginado dtoin) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.obtenerNuevosEjecutivos(DTOPaginado):Entrada");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOCAR dao = new DAOCAR(usuario);
		RecordSet rs = dao.obtenerEjecutivosPaginado(dtoin);
		DTOSalida dto = new DTOSalida(rs);
        UtilidadesLog.info("MONSolicitudesBloqueadas.obtenerNuevosEjecutivos(DTOPaginado):Salida");
		return dto;
	}


    /**
     * Sistema:     Belcorp
     * Modulo:      CAR
     * Fecha:       24/09/2004
     * @version     1.0
     * @autor       Viviana Bongiovanni
     */
    public void actualizarSolicitudesEntregaBloqueadas(DTOSolicitudBloqueada solBloqueada) throws MareException {
        UtilidadesLog.info("MONSolicitudesBloqueadas.actualizarSolicitudesEntregaBloqueadas(DTOSolicitudBloqueada):Entrada");
        try {
        
            Integer indDeudaVencida = null;
            Integer indLineaCredito = null;
            Integer notif = null;
            Integer indMontoMaximo = null;
            Integer indPorcentajeMaximo = null;
            SolicitudesEntregaBloqueadasLocalHome solEntregasBloqH = this.getSolicitudesEntregaBloqueadasLocalHome();
            notif = solBloqueada.getNotificado().booleanValue()?new Integer(1):new Integer(0);
            
            if (solBloqueada.getIndDeudaVencida()!=null)
                indDeudaVencida = solBloqueada.getIndDeudaVencida().booleanValue()?new Integer(1):new Integer(0);
            if (solBloqueada.getIndLineaCredito()!=null)
                indLineaCredito = solBloqueada.getIndLineaCredito().booleanValue()?new Integer(1):new Integer(0);
            if (solBloqueada.getIndMontoMaximo()!=null)
                indMontoMaximo = solBloqueada.getIndMontoMaximo().booleanValue()?new Integer(1):new Integer(0);
            if (solBloqueada.getIndPorcentajeMaximo()!=null)
                indPorcentajeMaximo = solBloqueada.getIndPorcentajeMaximo().booleanValue()?new Integer(1):new Integer(0);
                
            UtilidadesLog.debug("SCS, indDeudaVencida/indLineaCredito/indMontoMaximo/indPorcentajeMaximo, son: " +indDeudaVencida+"/"+indLineaCredito+"/"+indMontoMaximo+"/"+indPorcentajeMaximo);

            SolicitudesEntregaBloqueadasLocal solEntregasBloq = solEntregasBloqH.create(solBloqueada.getOidPais(), 
                    solBloqueada.getOidSubAcceso(), 
                    solBloqueada.getOidTipoSolPED(), 
                    solBloqueada.getOidSolicitud(), 
                    solBloqueada.getFechaSolicitud(), 
                    notif, 
                    solBloqueada.getMontoSolicitud(), 
                    solBloqueada.getMontoDeudaVencida(),
                    indDeudaVencida, 
                    indLineaCredito, 
                    indMontoMaximo, 
                    indPorcentajeMaximo,
                    solBloqueada.getOidJerarquia(), 
                    solBloqueada.getEstatus(), 
                    solBloqueada.getOidPeriodo(), 
                    solBloqueada.getOidCliente(), 
                    solBloqueada.getOidNivelRiesgo(), 
                    solBloqueada.getOidGrupoSolicitud(),
                    solBloqueada.getOidZona());
                    
            solEntregasBloq.setOidEjecutivoCuenta(solBloqueada.getOidEjecutivo());
            
            solEntregasBloqH.merge(solEntregasBloq);
            
            UtilidadesLog.debug("SCS, acabo de generar el regstro. en sol. entr. bloq. ...");
            
        } catch(PersistenceException e) {
             ctx.setRollbackOnly();
             throw new MareException(e,
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }     
        UtilidadesLog.info("MONSolicitudesBloqueadas.actualizarSolicitudesEntregaBloqueadas(DTOSolicitudBloqueada):Salida");              
    }
    
    private SolicitudesEntregaBloqueadasLocalHome getSolicitudesEntregaBloqueadasLocalHome() 
    {
        return new SolicitudesEntregaBloqueadasLocalHome();
    }
}