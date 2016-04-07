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

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.entidades.ped.ProcesoPedidosLocal;
import es.indra.sicc.entidades.ped.ProcesoPedidosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.rmi.RemoteException;

import java.util.ArrayList;
import java.math.BigDecimal;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import es.indra.sicc.util.Cronometrador;
import java.util.HashMap;

import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONGenerarPosicionSolicitudBean implements SessionBean {
    private SessionContext ctx;
    private UtilidadesLog log = new UtilidadesLog();
    
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
      // Pongo a False el estado de la solicitud 
      DTOE.OK = False 

      // Recupero la posicion de la solicitud 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 

      // Pongo su estado a False 
      DTOPosicionSolicitud.OK = False 
      DTOPosicionSolicitud.cvOK = False 

      // Añade el mensaje de error 
      DTOPosicionSolicitud.mensajeError = PED-0012 

      // Vuelvo a insertar la posición en la solicitud 
      DTOE.posiciones(linea) = DTOPosicionSolicitud 


      Devuelve DTOE
    *
    **/
    private DTOCabeceraSolicitud codigoVentaKO(DTOCabeceraSolicitud DTOE, DTOPosicionSolicitud dtop) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.codigoVentaKO(DTOCabeceraSolicitud DTOE, Long linea): Entrada ");
        UtilidadesLog.debug("Entro con DTOCabeceraSolicitud: " + DTOE);
        
        // Pongo a False el estado de la solicitud 
        DTOE.setOK(Boolean.FALSE);

        // Recupero la posicion de la solicitud 
        //DTOPosicionSolicitud dtop = (DTOPosicionSolicitud) DTOE.getPosiciones().get(linea.intValue());

        // Pongo su estado a False 
        dtop.setOK(Boolean.FALSE);
        dtop.setCvOK(Boolean.FALSE);

        // Añade el mensaje de error 
        dtop.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_012 ); //Inc. 7494

        // Vuelvo a insertar la posición en la solicitud 
        //DTOE.getPosiciones().set(linea.intValue(), dtop);
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.codigoVentaKO(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
        return DTOE;
    }
    
    private void codigoVentaKO(DTOCabeceraSolicitud DTOE, ArrayList pos) throws MareException {
        DTOE.setOK(Boolean.FALSE);
        for (int i = 0 ; i < pos.size() ; i++ ){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)pos.get(i);
            dtoP.setOK(Boolean.FALSE);
            dtoP.setCvOK(Boolean.FALSE);
            dtoP.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_012 ); //Inc. 7494
        }
    }
    
    /**
      // Valida que el código de venta recibido existe y es digitable en el periodo vigente 

      DTOPosicionSolicitud = DTOE.posiciones(linea) 

      Crea un DTOEValidarCodigoVenta con: 

      - periodo = DTOE.periodo 
      - acceso = DTOE.acceso 
      - subacceso = DTOE.subacceso 
      - codigoVenta = DTOPosicionSolicitud.codigoVenta 

      DTOSValidarCodigoVenta = IServiceMF.validarCodigoVenta(DTOEValidarCodigoVenta) 

      Si DTOSValidarCodigoVenta != null 
      { 
      Si DTOE.indicadorDigitacion == True AND DTOSValidarCodigoVenta.indicadorDigitableGP == False 
      { 
      DTOE = codigoVentaKO(DTOE, linea) 
      Devuelve DTOE 
      } 
      sino 
      { 
      // Actualiza el DTOPosicionSolicitud y lo vuelve a incorporar al DTOCabeceraSolicitud 
      DTOPosicionSolicitud.oidDetalleOferta = DTOSValidarCodigoVenta.producto 
      DTOPosicionSolicitud.producto = DTOSValidarCodigoVenta.producto 

      DTOE.posiciones(linea) = DTOPosicionSolicitud 
      } 
      } 
      sino 
      { 
      DTOE = codigoVentaKO(DTOE, linea) 
      Devuelve DTOE 
      } 
      Devuelve DTOE 
    *
    **/
    private DTOCabeceraSolicitud validarCodigoVenta(DTOCabeceraSolicitud DTOE, DTOPosicionSolicitud dtop) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea): Entrada ");
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("Entro con DTOCabeceraSolicitud: " + DTOE);
        
        // Valida que el código de venta recibido existe y es digitable en el periodo vigente 
        DTOEValidarCodigoVenta dtovcv = new DTOEValidarCodigoVenta();
        dtovcv.setPeriodo(DTOE.getPeriodo());
        dtovcv.setAcceso(DTOE.getAcceso());
        dtovcv.setSubacceso(DTOE.getSubacceso());
        dtovcv.setCodigoVenta(dtop.getCodigoVenta());
        
        // 25/08/2006 - mmaidana - Agregado por inc. 20520
        dtovcv.setModulo(DTOE.getModulo());
        dtovcv.setOidDocumentoReferencia(DTOE.getOidDocumentoReferencia());
        
        DTOSValidarCodigoVenta dtosvcv = null;
        try {
            //dtosvcv = PREEjbLocators.getMONMantenimientoMFHome().create().validarCodVent(dtovcv);
            dtosvcv = getMONMantenimientoMFLocalHome().create().validarCodVent(dtovcv);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("luego de validarCodigoVenta, obtengo: " + dtosvcv);
        } catch (NamingException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }catch (CreateException e) {
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 
        if (dtosvcv != null) {
			if (dtosvcv.getIndicadorDigitableGP() == null)
				dtosvcv.setIndicadorDigitableGP(Boolean.FALSE);
            if ((DTOE.getIndicadorDigitacion().booleanValue()) && (!dtosvcv.getIndicadorDigitableGP().booleanValue())) {
                DTOE = codigoVentaKO(DTOE, dtop);
                UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
                return DTOE;
            } else {
                // Actualiza el DTOPosicionSolicitud y lo vuelve a incorporar al DTOCabeceraSolicitud 
                dtop.setProducto(dtosvcv.getProducto());
                dtop.setOidDetalleOferta(dtosvcv.getOidDetalleOferta());

                // 25/08/2006 - mmaidana - Agregado por inc. 20520
                dtop.setPagina(dtosvcv.getNumPagCatalogo());
                dtop.setCatalogo(dtosvcv.getCodigoCatalogo());
                //Fin agregado mmaidana
                
                //DTOE.getPosiciones().set(linea.intValue(), dtop);
            }
        } else {
            DTOE = codigoVentaKO(DTOE, dtop);
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
            return DTOE;
        }
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
        return DTOE;
    }

    /**
      // Completa los datos de una posición 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 
      Añadimos a DTOPosicionSolicitud los siguientes datos: 
      Si DTOE.indicadorDigitacion == True 
      - numeroPosicion = linea * 10 
      sino 
      - numeroPosicion = linea 

      - Si DTOPosicionSolicitud.estadoPosicion == null 
      DTOPosicionSolicitud.estadoPosicion = ConstantesPED.ESTADO_POSICION_CORRECTO 

      - Si DTOPosicionSolicitud.unidadesPorAtender != 0 AND DTOPosicionSolicitud.unidadesDemandadas == 0 
      DTOPosicionSolicitud.unidadesDemandadas = DTOPosicionSolicitud.unidadesPorAtender 

      - Si DTOPosicionSolicitud.unidadesDemandadas != 0 AND DTOPosicionSolicitud.unidadesPorAtender == 0 
      DTOPosicionSolicitud.unidadesPorAtender = DTOPosicionSolicitud.unidadesDemandadas 

      - Si DTOPosicionSolicitud.unidadesDemandaReal == 0 AND DTOPosicionSolicitud.unidadesPorAtender != 0 
      DTOPosicionSolicitud.unidadesDemandaReal = DTOPosicionSolicitud.unidadesPorAtender 

      - Si DTOPosicionSolicitud.formaPago == null 
      { 
      cv = DTOPosicionSolicitud.codigoVenta 
      DTOPosicionSolicitud.formaPago = Llamar al método obtenerFormaPagoMF(DTOE.periodo, cv) 
      } 

      // Inserta la posición en la solicitud 
      DTOE.posiciones(linea) = DTOPosicionSolicitud 
    *
    **/
    private DTOCabeceraSolicitud completarPosicion(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud posicion) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.completarPosicion(DTOCabeceraSolicitud dtoe, Long linea): Entrada ");
        
        
        
        if (posicion.getEstadoPosicion() == null) {
            posicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
        }

        if (posicion.getUnidadesPorAtender()==null)
            posicion.setUnidadesPorAtender(new Long(0));

        if (posicion.getUnidadesDemandaReal()==null)
            posicion.setUnidadesDemandaReal(new Long(0));

        if (posicion.getUnidadesDemandadas()==null)
            posicion.setUnidadesDemandadas(new Long(0));

        if ((posicion.getUnidadesDemandadas() != null && posicion.getUnidadesDemandadas().longValue() != 0) && 
                (posicion.getUnidadesPorAtender() == null || posicion.getUnidadesPorAtender().longValue() == 0)) {
            posicion.setUnidadesPorAtender(posicion.getUnidadesDemandadas());
        }

        if ((posicion.getUnidadesDemandaReal() == null || posicion.getUnidadesDemandaReal().longValue() == 0) && 
                (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
            posicion.setUnidadesDemandaReal(posicion.getUnidadesPorAtender());
        }

        posicion.setUnidadesComprometidas(posicion.getUnidadesDemandaReal());
        		
		if (posicion.getPrecioCatalogoUnitarioLocal() == null )
			posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal("0"));
      
		if (posicion.getPrecioContableUnitarioLocal() == null)
			posicion.setPrecioContableUnitarioLocal(new BigDecimal("0"));
		
		if (posicion.getPrecioCatalogoUnitarioDocumento() == null)
			posicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal("0"));

		if (posicion.getPrecioContableUnitarioDocumento() == null)
			posicion.setPrecioContableUnitarioDocumento(new BigDecimal("0"));

        if (posicion.getFormaPago() == null) {
            String cv = posicion.getCodigoVenta();
            try {
            
                UtilidadesLog.debug("forma pago es null");
            
                MONMantenimientoMFHome mmMFHome = (MONMantenimientoMFHome) UtilidadesEJB.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
                MONMantenimientoMF mmMF = mmMFHome.create();

                UtilidadesLog.debug("creo MONMantenimientoMF");

                Long pago = mmMF.obtenerFormaPagoMF(dtoe.getPeriodo(), cv);
                
                UtilidadesLog.debug("despues de obtenerFormaPagoMF");
                
                posicion.setFormaPago(pago);
            } catch (RemoteException ne) {
                UtilidadesLog.error("Exception: ",ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_NO_ACCESO_SESSION));
            } catch (CreateException ne) {
                UtilidadesLog.error("Exception: ",ne);
                throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        
        // BELC300018886 gPineda 15/08/06
        UtilidadesLog.debug("antes de seteo de tipo/subtipo de posicion");
        if( dtoe.getIndicadorDigitacion().booleanValue() 
            && posicion.getTipoPosicion() == null 
            && posicion.getSubtipoPosicion() == null ){
            
            try{
              ProcesoPedidosLocalHome localHome = new ProcesoPedidosLocalHome();
              ProcesoPedidosLocal procesoPedidos = localHome.findByUK(ConstantesProcesosPED.PROCESO_P115);
              
              if( procesoPedidos.getOidTiposPosicion() != null ){
                posicion.setTipoPosicion( procesoPedidos.getOidTiposPosicion() );
              }
              if( procesoPedidos.getOidSubtiposPosicion() != null ){
                posicion.setSubtipoPosicion( procesoPedidos.getOidSubtiposPosicion() );
              }
              
            }catch(NoResultException nre){
              ctx.setRollbackOnly();
              UtilidadesLog.error("No se encontró proceso ConstantesProcesosPED.PORCESO_P115("+ ConstantesProcesosPED.PROCESO_P115 +")");
              UtilidadesLog.error(nre);
              throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }catch(PersistenceException pe){
              ctx.setRollbackOnly();
              UtilidadesLog.error("Error: ", pe);
              UtilidadesLog.error(pe);
              throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        }
        UtilidadesLog.debug("despues de seteo de tipo/subtipo de posicion");
        // BELC300018886 - FIN
        
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.completarPosicion(DTOCabeceraSolicitud dtoe, Long linea): Salida ");
        return dtoe;
    }

    /**
      // Pongo a False el estado de la solicitud 
      DTOE.OK = False 

      // Recupero la posicion de la solicitud 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 

      // Pongo su estado a False 
      DTOPosicionSolicitud.OK = False 

      // Añade el mensaje de error 
      DTOPosicionSolicitud.mensajeError = PED-0026 

      // Vuelvo a insertar la posición en la solicitud 
      DTOE.posiciones(linea) = DTOPosicionSolicitud 

      Devuelve DTOE 
    *
    **/
    private DTOCabeceraSolicitud solicitudNegativaKO(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud pos) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.solicitudNegativaKO(DTOCabeceraSolicitud dtoe, Long linea): Entrada ");
        dtoe.setOK(Boolean.FALSE);

        pos.setOK(Boolean.FALSE);
        //pos.setMensajeError("Las unidades demandadas son incorrectas");
        pos.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_026);
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.solicitudNegativaKO(DTOCabeceraSolicitud dtoe, Long linea): Salida ");
        return dtoe;
    }

    /**
      DTOE.OK = True 
      Devuelve DTOE
    *
    **/
    private DTOCabeceraSolicitud validacionOK(DTOCabeceraSolicitud dto) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validacionOK(DTOCabeceraSolicitud dto): Entrada ");
        
        // gPineda - 22/02/2007 - SiCC 20070058
        if( dto.getOK() == null ){
            dto.setOK(Boolean.TRUE);
        }
        
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validacionOK(DTOCabeceraSolicitud dto): Salida ");
        return dto;
    }
    
    private void validacionOK(DTOCabeceraSolicitud dto, boolean OK) throws MareException {
        dto.setOK(Boolean.valueOf(OK));
    }

    /**
      // Validamos que el indicador de solicitud negativa no se encuentre activado 
      tipoSolicitudPais = TiposSolicitudPais.findByPrimayKey(DTOE.tipoSolicitud) 
      tipoSolicitud = TiposSolicitud.findByPrimayKey(tipoSolicitudPais.oidTipoSolicitud) 

      // Obtiene el indicador de solicitud negativa 
      solicitudNegativa = tipoSolicitud.indSolNegativa 

      // Obtiene las unidades demandadas 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 
      unidadesDemandadas = DTOPosicionSolicitud.unidadesDemandadas 

      Si solicitudNegativa == False 
      { 
      Si unidadesDemandadas <= 0 
      { 
      DTOE = solicitudNegativaKO(DTOE, linea) 
      Devolver DTOE 
      } 
      } 
      sino 
      { 
      Si unidadesDemandadas => 0 
      { 
      DTOE = solicitudNegativaKO(DTOE, linea) 
      Devolver DTOE 
      } 
      } 
      Devolver DTOE
    *
    **/
    private DTOCabeceraSolicitud validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud solicitud) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea): Entrada ");
        UtilidadesLog.debug("Entro con DTOCabeceraSolicitud: " + dtoe);
        
        TiposSolicitudPaisLocalHome soli_pais = new TiposSolicitudPaisLocalHome();

        TiposSolicitudLocalHome soli = new TiposSolicitudLocalHome();
        long unidades_demand = 0;
        boolean solicitud_neg = true;

        try {
            TiposSolicitudPaisLocal solicitud_pais = soli_pais.findByPrimaryKey(dtoe.getTipoSolicitud());
            TiposSolicitudLocal tipo_solicitud = soli.findByPrimaryKey(solicitud_pais.getOidTipoSolicitud());
            solicitud_neg = tipo_solicitud.getIndSolNegativa().booleanValue();
            
            unidades_demand = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0);
            UtilidadesLog.info("unidades_demand " + unidades_demand );
            if (!solicitud_neg) {
                if (unidades_demand < 0) {
                    UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand < 0 - soliNeg = false");
                    dtoe = solicitudNegativaKO(dtoe, solicitud);
                    UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea): Salida ");
                    return dtoe;
                }
            } else {
                if (unidades_demand > 0) {
                    UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand > 0 - soliNeg = true");
                    dtoe = solicitudNegativaKO(dtoe, solicitud);
                }
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",nre);
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",pe);
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea): Salida ");
        return dtoe;
    }

    /**
      // Validamos que el número de unidades demandadas sea superior al valor de alarma 
      tipoSolicitud = TiposSolicitudPais.findByPrimayKey(DTOE.tipoSolicitud) 
      // Obtiene el valor de alarma numero de unidades 
      alarma = tipoSolicitud.alarmaNumUnidades 

      // Obtiene las unidades demandadas 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 
      unidadesDemandadas = DTOPosicionSolicitud.unidadesDemandadas 

      Si alarma != 0 
      { 
      // Comprobamos si el valor absoluto de unidades demandadas es mayor que el valor de alarma 
      // En ese caso, falla la validación 
      Si Math.abs(unidadesDemandadas) > alarma 
      { 
      DTOE = numeroUnidadesKO(DTOE, linea, alarma) 
      Devolver DTOE 
      } 
      } 
      Devolver DTOE
    *
    **/
    private DTOCabeceraSolicitud validarNumeroUnidades(DTOCabeceraSolicitud dtos, DTOPosicionSolicitud solicitud) throws MareException {
    
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarNumeroUnidades(DTOCabeceraSolicitud dtos, Integer linea): Entrada ");
        UtilidadesLog.debug("Entro con DTOCabeceraSolicitud: " + dtos);
        
        long unidades = 0;
        long alarma = 0;
        TiposSolicitudPaisLocalHome soli_pais = new TiposSolicitudPaisLocalHome();

        try {
            UtilidadesLog.debug("voy a buscar en TiposSolicitudPaisLocaL: " + dtos.getTipoSolicitud());
            TiposSolicitudPaisLocal solicitud_pais = soli_pais.findByPrimaryKey(dtos.getTipoSolicitud());
            UtilidadesLog.debug("luego de hallar la sol. pais, su alarma es: " + solicitud_pais.getAlarmaNumUnidades());
            // si el valor de alarma es nulo, toma por defecto 0.
            if (solicitud_pais.getAlarmaNumUnidades() != null) {
                alarma = solicitud_pais.getAlarmaNumUnidades().longValue();
            }
            
            unidades = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0); //REC-12 10/01/06
            //unidades = solicitud.getUnidadesDemandadas().longValue();
            UtilidadesLog.debug("unidades, es: " + unidades);

            if (alarma != 0) {
                // dmorello, 11/05/2006: Se preguntará por > y no por >= para seguir lo indicado en el DMCO
                if (Math.abs(unidades) > alarma) {
                    dtos = this.numeroUnidadesKO(dtos, solicitud, new Long(alarma));
                    UtilidadesLog.debug("luego de this.numeroUnidadesKO(, obtengo: " + dtos);
                }
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",nre);
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",pe);
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarNumeroUnidades(DTOCabeceraSolicitud dtos, Integer linea): Salida ");
        
        return dtos;
    }

    /**
        // Valida una posicion de una solicitud 
        // Inicial la validación 
        validacionOK(DTOE) 

        // VALIDAR CODIGO VENTA 
        // El codigo de venta se valida si viene especificado y el módulo origen no es reclamos 
        // Si el codigo de venta no esta especificado, saltamos esta validación 
        DTOPosicionSolicitud = DTOE.posiciones(linea) 
        Si DTOPosicionSolicitud.codigoVenta != null 
        { 
        Si DTOE.modulo != ConstantesPED.MODULO_RECLAMOS 
        { 
        // Se valida el codigo de venta. Si falla, finaliza el método 
        DTOE = validarCodigoVenta(DTOE, linea) 
        Si DTOE.OK == False 
        Devuelve DTOE 
        } 
        } 
        // VALIDAR NUMERO UNIDADES 
        DTOE = validarNumeroUnidades(DTOE, linea) 
        Si DTOE.OK == False 
        Devuelve DTOE 
        // VALIDAR SOLICITUD NEGATIVA 
        DTOE = validarSolicitudNegativa(DTOE, linea) 
        Si DTOE.OK == False 
        Devuelve DTOE 
        // Si ha pasado todas las validaciones, completamos los datos de la posición 
        DTOE = completarPosicion(DTOE, linea) 

        // Comprueba si debe guardar la posicion 
        Si indGuardar == True { 
        DTOPosicionSolicitud = DTOE.posiciones(linea) 
        DTOPosicionSolicitud = Llamar al método DAOSolicitud.guardarPosicion(DTOPosicionSolicitud, DTOE.oidCabeceraSolicitud) 
        } 
        Devuelve DTOE 
    *
    **/
    public DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado): Entrada ");
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("Entro con DTOCabeceraSolicitud: " + dto);
          UtilidadesLog.debug("linea: " + linea);
          UtilidadesLog.debug("indGuardado: " + indGuardado);
        }  
        
        DAOSolicitud daoSolicitud = new DAOSolicitud();

        // Inicial la validación
        validacionOK(dto);
        
        // VALIDAR CODIGO VENTA 
        DTOPosicionSolicitud pos = null;
        ArrayList sacar = dto.getPosiciones();
       // eliminado por inc 20090840
       
        if(dto.getModificarPosiciones() == null || !dto.getModificarPosiciones().booleanValue() ){
            for (int i = 0 ; i< sacar.size() ; i++){
                 if (((DTOPosicionSolicitud)sacar.get(i)).getNumeroPosicion()!=null &&((DTOPosicionSolicitud)sacar.get(i)).getNumeroPosicion().longValue() == linea.longValue()){
                    pos = (DTOPosicionSolicitud) sacar.get(i);
                     break;
                 }
            }
        }
        if (pos == null){
            pos = (DTOPosicionSolicitud) sacar.get(linea.intValue());
        }
        
        
        if (pos.getCodigoVenta() != null) {
            UtilidadesLog.debug("SCS pos.getCodigoVenta() != null");
            
            // 25/08/2006 - mmaidana - eliminado por inc 20520
            //if ( (dto.getModulo() == null) || (dto.getModulo().longValue() != ConstantesPED.MODULO_RECLAMOS.longValue())) {
                
            //dto = this.validarCodigoVenta(dto, new Long(linea.longValue()));
            dto = this.validarCodigoVenta(dto, pos);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("luego de:validarCodigoVenta, el dto es: " + dto);
              
            if (dto.getOK().booleanValue() == false) {
                UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false");
                UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado): Salida ");
                return dto;
            }

            // 25/08/2006 - mmaidana - eliminado por inc 20520
            //}
            
        }
        
        // VALIDAR NUMERO UNIDADES 
        dto = validarNumeroUnidades(dto, pos);
        if (dto.getOK().booleanValue() == false) {
            UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false AA");
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado): Salida ");
            // vbongiov - inc 19138
            //return dto;
        }

        // VALIDAR SOLICITUD NEGATIVA 
        dto = validarSolicitudNegativa(dto, pos);
        if (dto.getOK().booleanValue() == false) {
            UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false BB");
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado): Salida ");
            // vbongiov - inc 19138
            //return dto;
        }
        // Si ha pasado todas las validaciones, completamos los datos de la posición 
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("dto.getOK().booleanValue(): " + dto.getOK().booleanValue());

        dto = completarPosicion(dto, pos);
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("despues dto.getOK().booleanValue(): " + dto.getOK().booleanValue());

        // Comprueba si debe guardar la posicion 
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("el indicador de guardado, es: " + indGuardado.booleanValue());
        if (indGuardado.booleanValue()) { 
        
            // vbongiov - inc 19138
            if (dto.getOK().booleanValue() == false) {
              pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
            } else {
              pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
            }
            
            UtilidadesLog.debug("voy a guardar la new posicion......");
            pos = daoSolicitud.guardarPosicion(pos, dto.getOidCabeceraSolicitud(), dto.getIndicadorDigitacion());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("guarde la posicion, obtuve: " + pos);
        } 
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado): Salida ");
        return dto;
    }



    /**
      // Pongo a False el estado de la solicitud 
      DTOE.OK = False 

      // Recupero la posicion de la solicitud 
      DTOPosicionSolicitud = DTOE.posiciones(linea) 

      // Pongo su estado a False 
      DTOPosicionSolicitud.OK = False 

      // Añade el mensaje de error 
      // Al mensaje le concatenamos el parámetro unidadesMaximas para que quede como el siguiente ejemplo: 
      // "El número de unidades máximas es: 6" 
      DTOPosicionSolicitud.mensajeError = PED-0020 + unidadesMaximas 

      // Vuelvo a insertar la posición en la solicitud 
      DTOE.posiciones(linea) = DTOPosicionSolicitud 

      Devuelve DTOE 
    *
    **/
    private DTOCabeceraSolicitud numeroUnidadesKO(DTOCabeceraSolicitud dto, DTOPosicionSolicitud dtoPos, Long unidadesMaximas) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.numeroUnidadesKO(DTOCabeceraSolicitud dto, Long linea, Long unidadesMaximas): Entrada ");    
        // Pongo a False el estado de la solicitud 
        dto.setOK(Boolean.FALSE);

        // Recupero la posicion de la solicitud 
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("la posic. de la sol. recuperada es: " + dtoPos);
          
        // Pongo su estado a False 
        dtoPos.setOK(Boolean.FALSE);

        // Añade el mensaje de error 
        // Al mensaje le concatenamos el parámetro unidadesMaximas para que quede como el siguiente ejemplo: 
        // "El número de unidades máximas es: 6" 
        dtoPos.setMensajeError( ConstantesSEG.MODULO_PED + ErroresNegocio.PED_020); //inc. 7494
        dtoPos.setUnidadesMaximas( unidadesMaximas ); //inc. 7494
        // Vuelvo a insertar la posición en la solicitud 
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.numeroUnidadesKO(DTOCabeceraSolicitud dto, Long linea, Long unidadesMaximas): Salida ");    
        return dto;
    }


    public DTOCabeceraSolicitud generarPosicion(DTOCabeceraSolicitud dtoCabecera, Long linea, Boolean indGuardado, HashMap hashCodigosVenta) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Entrada ");
        
        Cronometrador.startTransaction("Generar Posicion");
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        TiposSolicitudPaisLocal solicitudPaisLocal = null;
        TiposSolicitudLocal tipoSolicitudLocal = null;


        validacionOK(dtoCabecera);

        DTOPosicionSolicitud pos = null;
        ArrayList sacar = dtoCabecera.getPosiciones();
        if(dtoCabecera.getModificarPosiciones() == null || !dtoCabecera.getModificarPosiciones().booleanValue() ){
        for (int i = 0 ; i< sacar.size() ; i++){
            if (((DTOPosicionSolicitud)sacar.get(i)).getNumeroPosicion()!=null &&((DTOPosicionSolicitud)sacar.get(i)).getNumeroPosicion().longValue() == (linea.longValue()+1)){
                pos = (DTOPosicionSolicitud) sacar.get(i);
                break;
            }
        }
        }
        if (pos == null){
            pos = (DTOPosicionSolicitud) sacar.get(linea.intValue());
        }
        
        if (hashCodigosVenta != null){
            if (pos.getCodigoVenta() != null) {
                UtilidadesLog.debug("SCS pos.getCodigoVenta() != null");
              
                // 25/08/2006 - mmaidana - eliminado por inc 20520
                if ( (dtoCabecera.getModulo() == null) || (dtoCabecera.getModulo().longValue() != ConstantesPED.MODULO_RECLAMOS.longValue())) {
                  
                dtoCabecera = this.validarCodigoVenta(dtoCabecera, new Long(linea.longValue()), hashCodigosVenta);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                  UtilidadesLog.debug("luego de:validarCodigoVenta, el dto es: " + dtoCabecera);
                if (dtoCabecera.getOK().booleanValue() == false) {
                    UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false");
                    UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
                    Cronometrador.endTransaction("Generar Posicion");
                    return dtoCabecera;
                }

                // 25/08/2006 - mmaidana - eliminado por inc 20520
                }
              
            }
        } else {
            // Cuando es digitacion da validacion KO codigo de venta. NO se aplica si viene por modulos externos.
            if ((dtoCabecera.getIndicadorDigitacion() != null ) && (dtoCabecera.getIndicadorDigitacion().booleanValue())) {
                /*16/08/06 mdolce
                 * Este else se agrego porque cuando se ingresaba por pantalla un codigo de venta
                 * que NO existe, sigue ejecutando y tira error de escritura en BBDD, dado que
                 * intenta insertar sin producto. En el caso de que el codigo de venta no exista
                 * el comportamiento debe ser el mismo que en el caso de que el codigo de venta 
                 * tenga el indicador de digitable en 0
                 * */
                dtoCabecera = codigoVentaKO(dtoCabecera, pos);
                UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea): Salida ");
                return dtoCabecera;
            }
        }
        
        if (linea.intValue()==0){
           try {              
              TiposSolicitudPaisLocalHome solicitudPaisLocalHome = new TiposSolicitudPaisLocalHome();        
              solicitudPaisLocal = solicitudPaisLocalHome.findByPrimaryKey(dtoCabecera.getTipoSolicitud());
              TiposSolicitudLocalHome soli = new TiposSolicitudLocalHome();
              tipoSolicitudLocal = soli.findByPrimaryKey(solicitudPaisLocal.getOidTipoSolicitud());  
           } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            solicitudPaisLocal = null;
            tipoSolicitudLocal = null;
            UtilidadesLog.error("Exception: ",e);
            String codigoError = (e instanceof NoResultException)?
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE : CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
           }       
        }        
        dtoCabecera = validarNumeroUnidades(dtoCabecera, pos, solicitudPaisLocal);
        if (dtoCabecera.getOK().booleanValue() == false) {
            UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false AA");
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
        }

        
        // VALIDAR SOLICITUD NEGATIVA 
        dtoCabecera = validarSolicitudNegativa(dtoCabecera, pos, tipoSolicitudLocal);
        if (dtoCabecera.getOK().booleanValue() == false) {
            UtilidadesLog.debug("retorno por: dto.getOK().booleanValue() == false BB");
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
        }


        dtoCabecera = completarPosicion(dtoCabecera, pos, hashCodigosVenta);

        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
          UtilidadesLog.debug("el indicador de guardado, es: " + indGuardado.booleanValue());
          
        if (indGuardado.booleanValue()) { 
            if (dtoCabecera.getOK().booleanValue() == false) {
              pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
            } else {
              pos.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
            }
            UtilidadesLog.debug("voy a guardar la new posicion......");
            pos = daoSolicitud.guardarPosicion(pos, dtoCabecera.getOidCabeceraSolicitud(), dtoCabecera.getIndicadorDigitacion());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("guarde la posicion, obtuve: " + pos);
        } 
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosicion(DTOCabeceraSolicitud dto, Long linea, Boolean indGuardado, HashMap hashCodigosVenta): Salida ");
        Cronometrador.endTransaction("Generar Posicion");
        return dtoCabecera;
  }
  
      private DTOCabeceraSolicitud validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea, HashMap hashCodigosVenta) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea, HashMap hashCodigosVenta): Entrada ");
        
        // Valida que el código de venta recibido existe y es digitable en el periodo vigente 
        DTOPosicionSolicitud dtop = (DTOPosicionSolicitud) DTOE.getPosiciones().get(linea.intValue());
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("plp: " + linea.intValue());
          UtilidadesLog.debug("plp validarCodigoVenta: " + dtop);
          UtilidadesLog.debug("hashCodigosVenta:  " + hashCodigosVenta);
        }
        
        DTOSValidarCodigoVenta dtosvcv = null;
        dtosvcv = (DTOSValidarCodigoVenta)hashCodigosVenta.get(dtop.getCodigoVenta().toString());
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                        
          UtilidadesLog.debug("plp dtosvcv: " + dtosvcv);
        
        if (dtosvcv != null) {
			  if (dtosvcv.getIndicadorDigitableGP() == null)
				    dtosvcv.setIndicadorDigitableGP(Boolean.FALSE);
            if ((DTOE.getIndicadorDigitacion().booleanValue()) && (!dtosvcv.getIndicadorDigitableGP().booleanValue())) {
                DTOE = codigoVentaKO(DTOE, dtop);
                UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea, HashMap hashCodigosVenta): Salida ");
                return DTOE;
            } else {
                dtop.setProducto(dtosvcv.getProducto());
                dtop.setOidDetalleOferta(dtosvcv.getOidDetalleOferta());    
                DTOE.getPosiciones().set(linea.intValue(), dtop);
            }
        } else {
            DTOE = codigoVentaKO(DTOE, dtop);
            UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea, HashMap hashCodigosVenta): Salida ");
            return DTOE;
        }
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarCodigoVenta(DTOCabeceraSolicitud DTOE, Long linea, HashMap hashCodigosVenta): Salida ");
        return DTOE;
    }
    
    
    private DTOCabeceraSolicitud completarPosicion(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud posicion, HashMap hashCodigosVenta) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.completarPosicion(DTOCabeceraSolicitud dtoe, Long linea, HashMap hashCodigosVenta): Entrada ");
        
        UtilidadesLog.info("-a-");
        
        UtilidadesLog.debug("completarPosicion " + dtoe);
        
        if (posicion.getEstadoPosicion() == null) {
            posicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
        }

        UtilidadesLog.debug("unidades por atender");
        if (posicion.getUnidadesPorAtender()==null)
            posicion.setUnidadesPorAtender(new Long(0));

        UtilidadesLog.debug("unidades demanda real");
        if (posicion.getUnidadesDemandaReal()==null)
            posicion.setUnidadesDemandaReal(new Long(0));

        UtilidadesLog.debug("unidades demandadas");
        if (posicion.getUnidadesDemandadas()==null)
            posicion.setUnidadesDemandadas(new Long(0));

        /* BELC300023753 - gPineda 22/08/06
        UtilidadesLog.debug("unidades demandadas 2");
        if ((posicion.getUnidadesDemandadas() == null || posicion.getUnidadesDemandadas().longValue() == 0) && 
                (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
            posicion.setUnidadesDemandadas(posicion.getUnidadesPorAtender());
        }
        */

        UtilidadesLog.debug("unidades por atender 2");
        if ((posicion.getUnidadesDemandadas() != null && posicion.getUnidadesDemandadas().longValue() != 0) && 
                (posicion.getUnidadesPorAtender() == null || posicion.getUnidadesPorAtender().longValue() == 0)) {
            posicion.setUnidadesPorAtender(posicion.getUnidadesDemandadas());
        }

        UtilidadesLog.debug("unidades demanda real 2");
        if ((posicion.getUnidadesDemandaReal() == null || posicion.getUnidadesDemandaReal().longValue() == 0) && 
                (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
            posicion.setUnidadesDemandaReal(posicion.getUnidadesPorAtender());
        }
        
        UtilidadesLog.debug("unidades comprometidas");
        posicion.setUnidadesComprometidas(posicion.getUnidadesDemandaReal());

        UtilidadesLog.debug("precio catalogo unitario");
		if (posicion.getPrecioCatalogoUnitarioLocal() == null )
			posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal("0"));

        UtilidadesLog.debug("precio contable unitario");
		if (posicion.getPrecioContableUnitarioLocal() == null)
			posicion.setPrecioContableUnitarioLocal(new BigDecimal("0"));

        UtilidadesLog.debug("precio catalogo unitario documento");
		if (posicion.getPrecioCatalogoUnitarioDocumento() == null)
			posicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal("0"));

        UtilidadesLog.debug("precio contable unitario documento");
		if (posicion.getPrecioContableUnitarioDocumento() == null)
			posicion.setPrecioContableUnitarioDocumento(new BigDecimal("0"));

        UtilidadesLog.debug("if forma pago");
        if (posicion.getFormaPago() == null) {
        
            UtilidadesLog.debug("forma pago es null");
        
            String codigoVenta = posicion.getCodigoVenta();
            DTOSValidarCodigoVenta dtoSVCV = null;

            UtilidadesLog.debug("antes de hashCodigosVenta.get");
            
            if (hashCodigosVenta != null){
                dtoSVCV = (DTOSValidarCodigoVenta)hashCodigosVenta.get(codigoVenta != null ? codigoVenta.toString() : null);
            }

            UtilidadesLog.debug("despues de hashCodigosVenta.get");
            
            if (dtoSVCV != null){
                posicion.setFormaPago(dtoSVCV.getOidFormaPago());
            }
       }

        
        // BELC300018886 gPineda 15/08/06
        UtilidadesLog.debug("antes de seteo de tipo/subtipo de posicion");
        if( dtoe.getIndicadorDigitacion().booleanValue() 
            && posicion.getTipoPosicion() == null 
            && posicion.getSubtipoPosicion() == null ){
            
            try{
              ProcesoPedidosLocal procesoPedidos = new ProcesoPedidosLocalHome().findByUK(ConstantesProcesosPED.PROCESO_P115);
              
              if( procesoPedidos.getOidTiposPosicion() != null ){
                posicion.setTipoPosicion( procesoPedidos.getOidTiposPosicion() );
              }
              if( procesoPedidos.getOidSubtiposPosicion() != null ){
                posicion.setSubtipoPosicion( procesoPedidos.getOidSubtiposPosicion() );
              }
            }catch(NoResultException nre){
              ctx.setRollbackOnly();
              UtilidadesLog.error("No se encontró proceso ConstantesProcesosPED.PORCESO_P115("+ ConstantesProcesosPED.PROCESO_P115 +")");
              UtilidadesLog.error(nre);
              throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }catch(PersistenceException pe){
              ctx.setRollbackOnly();
              UtilidadesLog.error("Error: ", pe);
              throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
            
        }
        UtilidadesLog.debug("despues de seteo de tipo/subtipo de posicion");
        // BELC300018886 - FIN
        
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.completarPosicion(DTOCabeceraSolicitud dtoe, Long linea): Salida ");
        return dtoe;
    }
    
    private DTOCabeceraSolicitud validarNumeroUnidades(DTOCabeceraSolicitud dtos, DTOPosicionSolicitud solicitud, TiposSolicitudPaisLocal solicitudPaisLocal) throws MareException {
    
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarNumeroUnidades(DTOCabeceraSolicitud dtos, Integer linea, TiposSolicitudPaisLocal solicitudPaisLocal): Entrada ");
        
        long unidades = 0;
        long alarma = 0;
        if (!(solicitudPaisLocal == null)){
            // si el valor de alarma es nulo, toma por defecto 0.
            if (solicitudPaisLocal.getAlarmaNumUnidades() != null) {
                alarma = solicitudPaisLocal.getAlarmaNumUnidades().longValue();
            }
            
            unidades = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0); //REC-12 10/01/06
            //unidades = solicitud.getUnidadesDemandadas().longValue();
             if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("unidades, es: " + unidades);

            if (alarma != 0) {
                // dmorello, 11/05/2006: Se preguntará por > y no por >= para seguir lo indicado en el DMCO
                if (Math.abs(unidades) > alarma) {
                    UtilidadesLog.debug("voy a....this.numeroUnidadesKO(..........");
                    dtos = this.numeroUnidadesKO(dtos, solicitud, new Long(alarma));
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                      UtilidadesLog.debug("luego de this.numeroUnidadesKO(, obtengo: " + dtos);
                }
            }
        } 
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarNumeroUnidades(DTOCabeceraSolicitud dtos, Integer linea, TiposSolicitudPaisLocal solicitudPaisLocal): Salida ");
        return dtos;
    }   
    
    private DTOCabeceraSolicitud validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, DTOPosicionSolicitud solicitud, TiposSolicitudLocal tipoSolicitudLocal) throws MareException {
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea, TiposSolicitudLocal tipoSolicitudLocal): Entrada ");
        
        long unidades_demand = 0;
        boolean solicitud_neg = true;
        
        if (!(tipoSolicitudLocal == null)){
            solicitud_neg = tipoSolicitudLocal.getIndSolNegativa().booleanValue();
                
            unidades_demand = (solicitud.getUnidadesDemandadas()!=null?solicitud.getUnidadesDemandadas().longValue():0);
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 24/03/2010                
              UtilidadesLog.debug("unidades_demand " + unidades_demand );
              
            if (solicitud_neg == false) {
                 if (unidades_demand < 0) {
                     UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand < 0 - soliNeg = false");
                     dtoe = solicitudNegativaKO(dtoe, solicitud);
                     UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea, TiposSolicitudLocal tipoSolicitudLocal): Salida ");
                     return dtoe;
                 }
            } else {
                 if (unidades_demand > 0) {
                     UtilidadesLog.debug("SolicitudNegativaKO - unidades_demand > 0 - soliNeg = true");
                     dtoe = solicitudNegativaKO(dtoe, solicitud);
                 }
            }
        }
        UtilidadesLog.info("MONGenerarPosicionSolicitudBean.validarSolicitudNegativa(DTOCabeceraSolicitud dtoe, Integer linea, TiposSolicitudLocal tipoSolicitudLocal): Salida ");
        return dtoe;
    }


    private MONMantenimientoMFLocalHome getMONMantenimientoMFLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONMantenimientoMFLocalHome)context.lookup("java:comp/env/ejb/local/MONMantenimientoMF");
    }

  public DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dtoSolicitudCabecera, HashMap hashCodigoVenta) throws MareException {
     UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosiciones(DTOCabeceraSolicitud dtoCabecera, HashMap hashCodigosVenta): Entrada ");        
      for (int numeroPosicion=0; numeroPosicion < dtoSolicitudCabecera.getPosiciones().size(); numeroPosicion++){ 
            dtoSolicitudCabecera = this.generarPosicion(dtoSolicitudCabecera, new Long(numeroPosicion), Boolean.FALSE, hashCodigoVenta);
      }      
      UtilidadesLog.info("MONGenerarPosicionSolicitudBean.generarPosiciones(DTOCabeceraSolicitud dtoCabecera, HashMap hashCodigosVenta): Salida ");        
      return dtoSolicitudCabecera;
  }

  public DTOCabeceraSolicitud generarPosiciones(DTOCabeceraSolicitud dto) throws MareException {
     UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarPosiciones(Vector dtosCabecera): Entrada ");
      try{                   
          
          if(dto.getOidCabeceraSolicitud()!=null || !dto.getOidCabeceraSolicitud().equals(new Long("0"))){
                  dto.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
                  int posic = dto.getPosiciones().size();
                  for(int posicion=0; posicion<posic;posicion++){
                      dto = this.generarPosicion(dto,new Long(posicion),Boolean.TRUE);
                      if(!dto.getOK().booleanValue()){
                          UtilidadesLog.debug("No valido la posicion "+posicion+" de la cabecera "+dto.getOidCabeceraSolicitud().toString());
                          throw new MareException(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS);
                      }
                  }
          }else{
               UtilidadesLog.debug("No se procesa la cabecera porque no tiene oid");   
          }
      }catch(Exception e){
          UtilidadesLog.error("Error el grabar posicion (interno): ",e);
      }
      UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarPosiciones(Vector dtosCabecera): Salida ");
      return dto;
  }

    public ArrayList generarPosicionesCuadre(DTOCabeceraSolicitud dto, ArrayList posiciones) throws MareException{
        
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        
        this.validarTodosCodigoVenta(dto, posiciones);

        this.validarNumeroUnidadesYSolicitudNegativa(dto, posiciones);
        
        this.validarNumeroUnidadesYSolicitudNegativa(dto, posiciones);

        completarPosiciones(dto, posiciones);        
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ; i < posiciones.size() ; i++ ){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posiciones.get(i);
            if (dto.getOK()!=null && dto.getOK().booleanValue() == false) {
              dtoP.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
            } else {
              dtoP.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
            }
            sb.append(daoSolicitud.generarGuardarPosicion(dtoP, dto.getOidCabeceraSolicitud(), dto.getIndicadorDigitacion()));
        }
        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR",sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR: "+sb.toString(),e);
            throw new MareException(e);
        }
        
        return posiciones;
    }
    
    private void validarTodosCodigoVenta (DTOCabeceraSolicitud dto, ArrayList posiciones) throws MareException{
        ArrayList codigosVenta = new ArrayList();
        for (int i = 0 ; i < posiciones.size() ; i++ ){
            DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posiciones.get(i);
            codigosVenta.add(dtoP.getCodigoVenta());
        }
                
        DTOSValidarCodigoVenta[] dtosvcv = null;
        dtosvcv = this.validarCodVent(dto.getPeriodo(), dto.getAcceso(), dto.getSubacceso(), dto.getModulo(), dto.getOidDocumentoReferencia(), codigosVenta);

        if (dtosvcv != null) {
			for (int i = 0 ; i < posiciones.size() ; i++ ){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posiciones.get(i);
                if (dtoP.getCodigoVenta()!=null){
                    for (int x = 0 ; x < dtosvcv.length ; x++ ){
                        if (dtoP.getCodigoVenta().equals(dtosvcv[x].getCodigoVenta())){
                            if (dtosvcv[x].getIndicadorDigitableGP() == null)
                                dtosvcv[x].setIndicadorDigitableGP(Boolean.FALSE);
                            if ((dto.getIndicadorDigitacion().booleanValue()) && (!dtosvcv[x].getIndicadorDigitableGP().booleanValue())) {
                                dto = codigoVentaKO(dto, dtoP);
                                return;
                            } else {
                                dtoP.setProducto(dtosvcv[x].getProducto());
                                dtoP.setOidDetalleOferta(dtosvcv[x].getOidDetalleOferta());
                                dtoP.setPagina(dtosvcv[x].getNumPagCatalogo());
                                dtoP.setCatalogo(dtosvcv[x].getCodigoCatalogo());
                                dtoP.setFormaPago(dtosvcv[x].getOidFormaPago());
                                break;
                            }
                        }
                    }
                }
            }
        }else{
            codigoVentaKO(dto,posiciones);
        }    
    }  
    
    private DTOSValidarCodigoVenta[] validarCodVent(Long periodo, Long acceso, Long subacceso, Long modulo, Long oidDocumentoReferencia, ArrayList cv) throws MareException {
        StringBuffer query = null;
        RecordSet rs = null;
        if (!(cv.size()>0)){
            return null;
        }
        if (modulo != null && modulo.equals(ConstantesPED.MODULO_RECLAMOS)){
            query = new StringBuffer();
            query.append("SELECT SC.PERD_OID_PERI PERIODO ");
            query.append("FROM PED_SOLIC_CABEC SC ");
            query.append("WHERE SC.OID_SOLI_CABE = " + oidDocumentoReferencia);
            
            try {
                rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
    
                if (rs != null && !rs.esVacio() && rs.getValueAt(0, "PERIODO") != null){
                    periodo = Long.valueOf(rs.getValueAt(0, "PERIODO").toString());
                }
            } catch (MareException e) {
                UtilidadesLog.error(e);
                throw e;
            } catch (Exception e) {
                UtilidadesLog.error("ERROR",e);
                String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        }
        
        query = new StringBuffer();
        query.append(" SELECT POD.OID_DETA_OFER, POD.PROD_OID_PROD, POD.IND_DIGI, C.COD_CATA, POD.NUM_PAGI_CATA, POD.VAL_CODI_VENT, POD.FOPA_OID_FORM_PAGO ");
        query.append(" FROM PRE_OFERT_DETAL POD, ");
        query.append("      PRE_OFERT PO, ");
        query.append("      PRE_MATRI_FACTU_CABEC MFC, ");
        query.append("      PRE_CATAL C ");
        query.append(" WHERE POD.OFER_OID_OFER = PO.OID_OFER ");
        
        query.append("   AND PO.MFCA_OID_CABE = MFC.OID_CABE ");
        
        /* Modificado por ssantana, 30/08/2006,*/ 
        query.append("   AND POD.OCAT_OID_CATAL = C.OID_CATA(+) ");
        /* Fin Modificado por ssantana, 30/08/2006,*/ 
        
        // sapaza -- PER-SiCC-2015-0444 -- 25/08/2015
        /*if (acceso!= null) {
          query.append("   AND (PO.ACCE_OID_ACCE = " + acceso + " OR PO.ACCE_OID_ACCE IS NULL) ");
        }*/
        
        if (subacceso != null) {
          query.append("   AND (PO.SBAC_OID_SBAC = " +subacceso + " OR PO.SBAC_OID_SBAC IS NULL) ");
        }
        
        query.append("   AND MFC.PERD_OID_PERI = " + periodo);
        query.append("   AND POD.VAL_CODI_VENT in ( ");
        for (int i = 0 ; i < cv.size() ; i++ ){
            if (i == (cv.size()-1)){
                query.append("'"+cv.get(i).toString()+"'");
            }else{
                query.append("'"+cv.get(i).toString()+"' , ");
            }
        }
        query.append(")");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error("ERROR: "+query.toString(),e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        DTOSValidarCodigoVenta[] dtoVCV = new DTOSValidarCodigoVenta[rs.getRowCount()];
        if (rs.getRowCount()>0){
            for (int i = 0 ; i < rs.getRowCount() ; i++ ){         
                dtoVCV[i] = new DTOSValidarCodigoVenta();
                dtoVCV[i].setOidDetalleOferta(this.bigDecimalToLong(rs.getValueAt(i, "OID_DETA_OFER")));
                dtoVCV[i].setProducto(this.bigDecimalToLong(rs.getValueAt(i, "PROD_OID_PROD")));
                dtoVCV[i].setIndicadorDigitableGP(this.bigDecimalToBoolean(rs.getValueAt(i,"IND_DIGI")));
    
                if (rs.getValueAt(i, "NUM_PAGI_CATA") != null){
                    dtoVCV[i].setNumPagCatalogo(new Integer(rs.getValueAt(i, "NUM_PAGI_CATA").toString()));
                }
                
                dtoVCV[i].setCodigoCatalogo(this.bigDecimalToLong(rs.getValueAt(i, "COD_CATA")));
                dtoVCV[i].setCodigoVenta(rs.getValueAt(i, "VAL_CODI_VENT").toString());
                dtoVCV[i].setOidFormaPago(bigDecimalToLong(rs.getValueAt(i, "FOPA_OID_FORM_PAGO")));
            
                UtilidadesLog.info("MONMantenimientoMF.validarCodVent(DTOEValidarCodigoVenta DTOE): SALIDA");
            }
            return dtoVCV;
        }else{
            return null;
        }
    }
    
    private Boolean bigDecimalToBoolean(Object indicador) {    
        if (indicador != null) {
            if (((BigDecimal) indicador).intValue() == 1)  { 
                return Boolean.TRUE;
            } else {
                return Boolean.FALSE;           
            }           
        } else {
            return Boolean.FALSE;
        }
    }
    
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
        } else {
            return null;
        }
    }
    
    private void completarPosiciones(DTOCabeceraSolicitud dtoe, ArrayList arrayPosicion) throws MareException {
        Long tipoPosicion = null;
        Long subTipoPosicion = null;
        for (int i = 0 ; i < arrayPosicion.size() ; i++ ){
            DTOPosicionSolicitud posicion = (DTOPosicionSolicitud)arrayPosicion.get(i);
            if (posicion.getEstadoPosicion() == null) {
                posicion.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
            }
    
            if (posicion.getUnidadesPorAtender()==null){
                posicion.setUnidadesPorAtender(new Long(0));
            }
    
            if (posicion.getUnidadesDemandaReal()==null){
                posicion.setUnidadesDemandaReal(new Long(0));
            }
    
            if (posicion.getUnidadesDemandadas()==null){
                posicion.setUnidadesDemandadas(new Long(0));
            }
    
            if ((posicion.getUnidadesDemandadas() != null && posicion.getUnidadesDemandadas().longValue() != 0) && 
                    (posicion.getUnidadesPorAtender() == null || posicion.getUnidadesPorAtender().longValue() == 0)) {
                posicion.setUnidadesPorAtender(posicion.getUnidadesDemandadas());
            }
    
            if ((posicion.getUnidadesDemandaReal() == null || posicion.getUnidadesDemandaReal().longValue() == 0) && 
                    (posicion.getUnidadesPorAtender() != null && posicion.getUnidadesPorAtender().longValue() != 0)) {
                posicion.setUnidadesDemandaReal(posicion.getUnidadesPorAtender());
            }
    
            posicion.setUnidadesComprometidas(posicion.getUnidadesDemandaReal());
                    
            if (posicion.getPrecioCatalogoUnitarioLocal() == null ){
                posicion.setPrecioCatalogoUnitarioLocal(new BigDecimal("0"));
            }
          
            if (posicion.getPrecioContableUnitarioLocal() == null){
                posicion.setPrecioContableUnitarioLocal(new BigDecimal("0"));
            }
            
            if (posicion.getPrecioCatalogoUnitarioDocumento() == null){
                posicion.setPrecioCatalogoUnitarioDocumento(new BigDecimal("0"));
            }
    
            if (posicion.getPrecioContableUnitarioDocumento() == null){
                posicion.setPrecioContableUnitarioDocumento(new BigDecimal("0"));
            }

            // BELC300018886 gPineda 15/08/06
            UtilidadesLog.debug("antes de seteo de tipo/subtipo de posicion");
            if( dtoe.getIndicadorDigitacion().booleanValue() 
                && posicion.getTipoPosicion() == null 
                && posicion.getSubtipoPosicion() == null ){
                try{
                    if (tipoPosicion == null && subTipoPosicion == null){
                        ProcesoPedidosLocal procesoPedidos = new ProcesoPedidosLocalHome().findByUK(ConstantesProcesosPED.PROCESO_P115);
                        tipoPosicion =   procesoPedidos.getOidTiposPosicion();
                        subTipoPosicion =   procesoPedidos.getOidSubtiposPosicion();
                         UtilidadesLog.debug("tipoPosicion--->"+tipoPosicion);
                         UtilidadesLog.debug("subTipoPosicion--->"+subTipoPosicion);
                    }
                }catch( NoResultException e ){
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("ERROR",e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }catch( PersistenceException fe ){
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("ERROR",fe);
                  throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
                posicion.setTipoPosicion( tipoPosicion);
                posicion.setSubtipoPosicion( subTipoPosicion );                
            }
        }
    }
    
    private void validarNumeroUnidadesYSolicitudNegativa (DTOCabeceraSolicitud dtoe, ArrayList posicion) throws MareException{
        long unidades = 0;
        long alarma = 0;
        boolean solicitud_neg = true;
        try {
            TiposSolicitudPaisLocalHome soli_pais = new TiposSolicitudPaisLocalHome();
            TiposSolicitudPaisLocal solicitud_pais = soli_pais.findByPrimaryKey(dtoe.getTipoSolicitud());
            TiposSolicitudLocal tipo_solicitud = new TiposSolicitudLocalHome().findByPrimaryKey(solicitud_pais.getOidTipoSolicitud());
            solicitud_neg = tipo_solicitud.getIndSolNegativa().booleanValue();
            if (solicitud_pais.getAlarmaNumUnidades() != null) {
                alarma = solicitud_pais.getAlarmaNumUnidades().longValue();
            }
            for (int i = 0 ; i < posicion.size() ; i++ ){
                DTOPosicionSolicitud dtoP = (DTOPosicionSolicitud)posicion.get(i);
                unidades = (dtoP.getUnidadesDemandadas()!=null?dtoP.getUnidadesDemandadas().longValue():0);
                if (alarma != 0) {
                    if (Math.abs(unidades) > alarma) {
                        dtoe = this.numeroUnidadesKO(dtoe, dtoP, new Long(alarma));
                    }
                }
                if (solicitud_neg == false) {
                    if (unidades < 0) {
                        dtoe = solicitudNegativaKO(dtoe, dtoP);
                    }
                } else {
                    if (unidades > 0) {
                        dtoe = solicitudNegativaKO(dtoe, dtoP);
                    }
                }
            }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
}
