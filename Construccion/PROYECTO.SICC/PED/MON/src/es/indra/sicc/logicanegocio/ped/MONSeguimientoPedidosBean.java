/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.entidades.ped.HitoSeguimientoLocal;
import java.math.BigDecimal;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.ped.DTOBuscarSeguimientoPedidos;
import es.indra.sicc.dtos.ped.DTOSeguimientoPedidos;
import es.indra.sicc.entidades.ped.SeguimientoPedidosLocal;
import es.indra.sicc.entidades.ped.SeguimientoPedidosLocalHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.DAOSeguimientoPedidos;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.sql.Timestamp;

import java.util.Date;
import java.util.Vector;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import es.indra.sicc.entidades.ped.HitoSeguimientoLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONSeguimientoPedidosBean implements SessionBean {
    private SessionContext sessionContext;
    private UtilidadesLog log = new UtilidadesLog();
    
    public void ejbCreate() {
    }

    public void ejbActivate() {
    }

    public void ejbPassivate() {
    }

    public void ejbRemove() {
    }

    /**
     * 
     * @cambio incidencia 18964
     * @autor gdmarzi
     */
    public void actualizarSeguimientoPedidos(DTOSeguimientoPedidos dto) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.actualizarSeguimientoPedidos(DTOSeguimientoPedidos dto): Entrada ");
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("DTOSeguimientoPedidos: " + dto);        

        // Guardo el código en la variable codigoHito
        Long codigoHito = dto.getHitoSeguimiento();

        if ((ConstantesPED.HITO_01.longValue() <= dto.getHitoSeguimiento().longValue()) & (ConstantesPED.HITO_04.longValue() >= dto.getHitoSeguimiento().longValue())) {
            dto.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_PEDIDO);
        }

        if ((ConstantesPED.HITO_05.longValue() <= dto.getHitoSeguimiento().longValue()) & (ConstantesPED.HITO_10.longValue() > dto.getHitoSeguimiento().longValue())) {
            dto.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_CONSOLIDADO);
        }

        if ((ConstantesPED.HITO_10.longValue() <= dto.getHitoSeguimiento().longValue()) & (ConstantesPED.HITO_15.longValue() >= dto.getHitoSeguimiento().longValue())) {            
            dto.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_LISTA_PICADO);
        }

        if (ConstantesPED.HITO_15.longValue() < dto.getHitoSeguimiento().longValue()) {
            dto.setTipoDocumento(ConstantesPED.TIPO_DOCUMENTO_ORDEN_TRANSPORTE);
        }

        if (dto.getHitoSeguimiento().longValue() <= 5) {
            dto.setIndCompleto(Boolean.TRUE);
        }

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("DTOSeguimientoPedidos pasados los rangos: " + dto);        
            
        try{            
            String strHito = dto.getHitoSeguimiento().toString();
            if (strHito.length() == 1){
                strHito = "0" + strHito;
            }
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("strHito: " + strHito);
              
            HitoSeguimientoLocal hsl = new HitoSeguimientoLocalHome().findByUK(strHito);
            dto.setHitoSeguimiento(hsl.getOid());
        }catch(NoResultException e){
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("No se pudo obtener el Oid Del HitoSeguimiento a partir del Codigo");
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }catch(PersistenceException e){
            sessionContext.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        guardarSeguimientoPedidos(dto.getSolicitud(), dto.getConsolidado(), dto.getHitoSeguimiento(), dto.getTipoDocumento(), dto.getNumeroDocumento(), dto.getFecha(), dto.getIndCompleto());

        if (codigoHito.equals(ConstantesPED.HITO_05)) {
            actualizarConsolidado(dto.getConsolidado());
        }
        UtilidadesLog.info("MONSeguimientoPedidosBean.actualizarSeguimientoPedidos(DTOSeguimientoPedidos dto): Salida ");
    }


    public void setSessionContext(SessionContext ctx) {
        sessionContext = ctx;
    }


    //29/03/2005: rgiorgi: inc. 15417.
    public void guardarSeguimientoPedidos(Long solicitud, Long consolidado, Long hitoSeguimiento, Long tipoDocumento, String numeroDocumento, Date fecha, Boolean indCompleto) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.guardarSeguimientoPedidos(Long solicitud, Long consolidado, Long hitoSeguimiento, Long tipoDocumento, String numeroDocumento, Date fecha, Boolean indCompleto): Entrada ");
        try {

            SeguimientoPedidosLocalHome seguiLH = new SeguimientoPedidosLocalHome();

            SeguimientoPedidosLocal seguiL = seguiLH.create(tipoDocumento, hitoSeguimiento, numeroDocumento);

            seguiL.setConsolidado(consolidado);

            if (fecha == null) {
              seguiL.setFecha(new Timestamp(System.currentTimeMillis()));
            } else {
              seguiL.setFecha(new Timestamp(fecha.getTime()));
            }
              
            seguiL.setHito(hitoSeguimiento);
            seguiL.setIndCompleto(indCompleto);
            seguiL.setNumeroDocumento(numeroDocumento);
            seguiL.setSolicitud(solicitud);
            
            seguiLH.merge(seguiL);
            
        } catch (PersistenceException ex) {
            UtilidadesLog.error("Exception: ",ex);
            sessionContext.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSeguimientoPedidosBean.guardarSeguimientoPedidos(Long solicitud, Long consolidado, Long hitoSeguimiento, Long tipoDocumento, String numeroDocumento, Date fecha, Boolean indCompleto): Salida ");
    }

    public void actualizarConsolidado(Long consolidado) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.actualizarConsolidado(Long consolidado): Entrada ");

        DAOSolicitud sol = new DAOSolicitud();

        int i = 0;
        int j = 0;
        Long solicitud = null;

        SeguimientoPedidosLocal segl = null;
        Vector solic = null;

        try {
            SeguimientoPedidosLocalHome selh = new SeguimientoPedidosLocalHome();

            RecordSet solicitudes = sol.obtenerSolicitudesPorConsolidado(consolidado);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("El recordSet obtenido solicitudes: " + solicitudes);

            Vector todo = solicitudes.getColumn(0);
            UtilidadesLog.debug("Despue de obtener la columna 0");

            while (todo.size() > i) {
                UtilidadesLog.debug("Entro al while con i = " + i);
                j = 0;
                solicitud = new Long (((BigDecimal) todo.elementAt(i)).longValue());
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("Solicitud: " + solicitud);
                  
                solic = new Vector(selh.findBySolicitud(solicitud));

                while (solic.size() > j) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("Entro al while con j = " + j);
                    
                    segl = (SeguimientoPedidosLocal) solic.elementAt(j);
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("segl.Hito: " + segl.getHito());
                      
                    if (segl.getHito().longValue() < ConstantesPED.HITO_05.longValue()) {
                        segl.setConsolidado(consolidado);
                        try {
                            selh.merge(segl);
                        } catch (PersistenceException pe) {
                            sessionContext.setRollbackOnly();
                            UtilidadesLog.error("Error al actualizar: ", pe);
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }

                    j++;
                }

                i++;
            }
        } catch (NoResultException e) {
            UtilidadesLog.error("Exception: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("Exception: ",e);
            sessionContext.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONSeguimientoPedidosBean.actualizarConsolidado(Long consolidado): Salida ");
        // Actualiza el número de consolidado para aquellas solicitudes que tienen hitos de seguimiento comprendidos entre 01 y 04 
        //solicitudes = Llama al método DAOSolicitud.obtenerSolicitudesPorConsolidado(consolidado) 
        //Recorre la lista de solicitudes obtenida 
        //{ 
        // Recupera la siguiente solicitud 
        //solicitud = Siguiente solicitud de la lista de solicitudes 
        // Busca la solicitud en la entidad SeguimientoPedidos 
        //seguimientoPedidos = SeguimientoPedidos.findBySolicitud(solicitud.oid) 
        //Si seguimientoPedidos.hito < ConstantesPED.HITO_05 
        //{ 
        //seguimientoPedidos.consolidado = consolidado 
        //} 
        //}
    }

    public DTOSalida buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos dto) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos dto): Entrada ");

        DAOSeguimientoPedidos seg = new DAOSeguimientoPedidos(sessionContext.getCallerPrincipal().getName());

        RecordSet fuera = seg.buscarSeguimientoPedidos(dto);

        DTOSalida vuelta = new DTOSalida(fuera);
        UtilidadesLog.info("MONSeguimientoPedidosBean.buscarSeguimientoPedidos(DTOBuscarSeguimientoPedidos dto): Salida ");
        return vuelta;
    }

    public DTOSalida obtenerTiposDocumentoSeguimiento(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.obtenerTiposDocumentoSeguimiento(DTOBelcorp dto): Entrada ");
        DAOSeguimientoPedidos seg = new DAOSeguimientoPedidos(sessionContext.getCallerPrincipal().getName());
        RecordSet fuera = seg.obtenerTiposDocumentoSeguimiento(dto);
        DTOSalida vuelta = new DTOSalida(fuera);
        UtilidadesLog.info("MONSeguimientoPedidosBean.obtenerTiposDocumentoSeguimiento(DTOBelcorp dto): Salida ");
        return vuelta;
    }

    public DTOSalida obtenerHitosSeguimiento(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONSeguimientoPedidosBean.obtenerHitosSeguimiento(DTOBelcorp dto): Entrada ");
        DAOSeguimientoPedidos seg = new DAOSeguimientoPedidos(sessionContext.getCallerPrincipal().getName());
        RecordSet fuera = seg.obtenerHitosSeguimiento(dto);
        DTOSalida vuelta = new DTOSalida(fuera);
        UtilidadesLog.info("MONSeguimientoPedidosBean.obtenerHitosSeguimiento(DTOBelcorp dto): Salida ");
        return vuelta;
    }

    public void eliminarHitosPosteriores(DTOSeguimientoPedidos DTOE) 
		throws MareException {
        
        UtilidadesLog.info("MONSeguimientoPedidosBean.eliminarHitosPosteriores(DTOSeguimientoPedidos DTOE) : Entrada ");
		SeguimientoPedidosLocalHome spLHome = null;
		SeguimientoPedidosLocal spLocal = null;
		
		DAOSeguimientoPedidos dao = new DAOSeguimientoPedidos(
								sessionContext.getCallerPrincipal().getName());
		DTOOIDs salida = dao.obtenerHitosPosteriores(DTOE);

        UtilidadesLog.debug("salida..: " + salida);

    if ((salida != null) && (salida.getOids() != null) && (salida.getOids().length>0)) {

        Long[] oids = salida.getOids();

        try{
          spLHome = new SeguimientoPedidosLocalHome();
		
          for (int i=0; i<oids.length; i++){
            //Recorre el DTOOIDs recibido y para cada oid recuperado:
            spLocal = spLHome.findByPrimaryKey(oids[i]);
            try {
                spLHome.remove(spLocal);
            } catch (PersistenceException pe) {
                sessionContext.setRollbackOnly();
                UtilidadesLog.error("Error al eliminar: ", pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
          }
              
        } catch (NoResultException nre) {
            UtilidadesLog.error("Exception: ",nre);
            sessionContext.setRollbackOnly();
            throw new MareException(nre, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            UtilidadesLog.error("Exception: ",pe);
            sessionContext.setRollbackOnly();
            throw new MareException(pe, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        }        
        UtilidadesLog.info("MONSeguimientoPedidosBean.eliminarHitosPosteriores(DTOSeguimientoPedidos DTOE) : Salida ");
    }

}
