package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.dtos.mav.DTOActividadMAV;
import es.indra.sicc.logicanegocio.mav.DAOActividadesMAV;
import es.indra.sicc.logicanegocio.mav.DAOServicioMAV;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;


public class MONServicioMAVBean implements SessionBean {
    SessionContext ctx = null;
    private DAOServicioMAV dsm = new DAOServicioMAV();
    private DAOActividadesMAV dam = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida obtenerTiposDespacho() throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespacho():Entrada");
        dam = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        UtilidadesLog.debug("Entro en obtenerTiposDespacho()");
        DTOSalida dtos = new DTOSalida();

        try {
            UtilidadesLog.debug("Entrando a DAO");
            dtos = dsm.obtenerTiposDespacho();
            UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespacho():Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);
            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerEstadosMAV(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerEstadosMAV(DTOBelcorp dto):Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtenerEstadosMAV(dto);
            UtilidadesLog.info("MONServicioMAVBean.obtenerEstadosMAV(DTOBelcorp dto):Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerTiposCondicionPago() throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposCondicionPago():Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtenerTiposCondicionPago();
            UtilidadesLog.info("MONServicioMAVBean.obtenerTiposCondicionPago():Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerCriteriosAsignacion() throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerCriteriosAsignacion():Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtenerCriteriosAsignacion();
            UtilidadesLog.info("MONServicioMAVBean.obtenerCriteriosAsignacion():Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerFormaCobro(DTOOID dtoOid) throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerFormaCobro():Entrada");
        DTOSalida dtos = new DTOSalida();

        /*  
         *  Modificado por ssantana, 22/11/2005. Inc. BELC300021444.
         *   - Ahora Se recibe el Oid de la Actividad en DTOOID
         */
        try {
            dtos = dsm.obtenerFormaCobro(dtoOid);
            UtilidadesLog.info("MONServicioMAVBean.obtenerFormaCobro():Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneMensajesTipoDespacho(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtieneMensajesTipoDespacho(DTOOID dto):Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtieneMensajesTipoDespacho(dto);
            UtilidadesLog.info("MONServicioMAVBean.obtieneMensajesTipoDespacho(DTOOID dto):Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneActividadesMAV(DTOActividadMAV dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtieneActividadesMAV(DTOActividadMAV dto):Entrada");
        dam = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dam.obtieneActividadesMAV(dto);
            UtilidadesLog.info("MONServicioMAVBean.obtieneActividadesMAV(DTOActividadMAV dto):Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneSubcriteriosPorCriterio(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtieneSubcriteriosPorCriterio(DTOOID dto):Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtieneSubcriteriosPorCriterio(dto);
            UtilidadesLog.info("MONServicioMAVBean.obtieneSubcriteriosPorCriterio(DTOOID dto):Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerEnvioConSolicitud() throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerEnvioConSolicitud():Entrada");
        DTOSalida dtos = new DTOSalida();

        try {
            dtos = dsm.obtenerEnvioConSolicitud();
            UtilidadesLog.info("MONServicioMAVBean.obtenerEnvioConSolicitud():Salida");
            return dtos;
        } catch(Exception exception) {
            UtilidadesLog.error(exception);

            if(exception instanceof MareException)
                throw (MareException)exception;
            else
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtieneTiposEstadoProceso(DTOBelcorp dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerEnvioConSolicitud():Entrada");
        DAOServicioMAV dao = new DAOServicioMAV();
        DTOSalida dtoSalida = dao.obtieneTiposEstadoProceso(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtenerEnvioConSolicitud():Salida");
        return dtoSalida;
    }

    public DTOSalida obtieneEstadosEnvio(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtieneEstadosEnvio(DTOBelcorp dto):Entrada");
        DAOServicioMAV dao = new DAOServicioMAV();
        DTOSalida dtoSalida = dao.obtieneEstadosEnvio(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtieneEstadosEnvio(DTOBelcorp dto):Salida");
        return dtoSalida;
    }

    /**
* @Autor: Hugo Andrés Mansi
* @Creado: 30/09/2004
* @Recibe: DTOOID 
* @Retorna: DTOSalida
* @DMCO : ver incidencia 8054
*/
    public DTOSalida obtenerEstadosMAVActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerEstadosMAVActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOServicioMAV miDao = new DAOServicioMAV();
        dtoSalida = miDao.obtenerEstadosMAVActividad(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtenerEstadosMAVActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
* @Autor: Hugo Andrés Mansi
* @Creado: 30/09/2004
* @Recibe: DTOOID 
* @Retorna: DTOSalida
* @DMCO : ver incidencia 8054
**/
    public DTOSalida obtenerTiposOfertaActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposOfertaActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOServicioMAV miDao = new DAOServicioMAV();
        dtoSalida = miDao.obtenerTiposOfertaActividad(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposOfertaActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
* @Autor: Hugo Andrés Mansi
* @Creado: 30/09/2004
* @Recibe: DTOOID 
* @Retorna: DTOSalida
* @DMCO : ver incidencia 8054
*/
    public DTOSalida obtenerCiclosVidaActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerCiclosVidaActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOServicioMAV miDao = new DAOServicioMAV();
        dtoSalida = miDao.obtenerCiclosVidaActividad(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtenerCiclosVidaActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

    /**
* @Autor: Hugo Andrés Mansi
* @Creado: 30/09/2004
* @Recibe: DTOOID 
* @Retorna: DTOSalida
* @DMCO : ver incidencia 8054
*/
    public DTOSalida obtenerTiposDespachoActividad(DTOOID dto)
        throws MareException {
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespachoActividad(DTOOID dto):Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        DAOServicioMAV miDao = new DAOServicioMAV();
        dtoSalida = miDao.obtenerTiposDespachoActividad(dto);
        UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespachoActividad(DTOOID dto):Salida");
        return dtoSalida;
    }

  public DTOSalida obtieneTiposClienteActividad(DTOOID dto) throws MareException {
     UtilidadesLog.info("MONServicioMAVBean.obtieneTiposClienteActividad(DTOOID dto):Entrada");
    
     DAOActividadesMAV daoActividad = new DAOActividadesMAV(ctx.getCallerPrincipal().getName());
     DTOSalida dtoSalida = null;
     dtoSalida = daoActividad.obtieneTiposClienteActividad(dto);
     
     UtilidadesLog.info("MONServicioMAVBean.obtieneTiposClienteActividad(DTOOID dto):Salida");
     return dtoSalida;
  }

  /**
   * @author: ssantana, 23/11/2005, inc. 21444.
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOOID dtoOid
   */
  public DTOSalida obtieneFormasPagoActividad(DTOOID dtoOid) throws MareException {
    UtilidadesLog.info("MONServicioMAV.obtieneFormasPagoActividad(DTOOID dtoOid): Entrada");
    DTOSalida dtoSalida = dsm.obtieneFormasPagoActividad(dtoOid);
    UtilidadesLog.info("MONServicioMAV.obtieneFormasPagoActividad(DTOOID dtoOid): Salida");
    return dtoSalida;
  }

  public DTOSalida obtenerTiposDespachoIniFinPeriodo() throws MareException {
    UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespachoIniFinPeriodo():Entrada");
    DTOSalida dtoSalida = null;
    
    UtilidadesLog.debug("Busca TiposDespacho 1");
    dtoSalida = dsm.obtenerTiposDespachoIniFinPeriodo();
    UtilidadesLog.debug("Busca TiposDespacho 2");        
    UtilidadesLog.debug("dtoSalida: " + dtoSalida);
    
    UtilidadesLog.info("MONServicioMAVBean.obtenerTiposDespachoIniFinPeriodo():Salida");
    return dtoSalida;
  }
  
}