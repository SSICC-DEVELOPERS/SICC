package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mgu.manager.Property;
import es.indra.mare.common.mgu.manager.UserIDImpl;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.dtos.seg.DTOSubaccesosPorAccesoYCanal;
import es.indra.sicc.entidades.fac.TipoDocumentoLegalLocalHome;
import es.indra.sicc.entidades.mae.ClienteDireccionLocalHome;
import es.indra.sicc.entidades.mae.TipoDocumentoLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocalHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.men.MONUsuarios;
import es.indra.sicc.logicanegocio.men.MONUsuariosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


public class MONGenerarSolicitudModulosExternosBean implements SessionBean {
    private SessionContext ctx;
    private String Paquete = " [PED] ";
    private String CU = " [Generar solicitud módulos externos] ";
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

    public DTOOID generaSolicitud(DTOCabeceraSolicitud dto) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generaSolicitud(DTOCabeceraSolicitud dto): Entrada ");
        dto = completarCabeceraSolicitud(dto);
        dto = completarPosicionesSolicitud(dto);
        
        try {
            dto.setIndicadorDigitacion(Boolean.FALSE);
            MONValidacionesGeneralesSolicitudLocal valGenLocal = this.getMONValidacionesGeneralesSolicitudLocalHome().create();
            
            dto = valGenLocal.validarSolicitud(dto);

            if (dto.getOK().equals(Boolean.TRUE)) {
                dto.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);                
                MONDigitacionInicialLocal digiLocal = this.getMONDigitacionInicialLocalHome().create();
                
                dto = digiLocal.grabarSolicitud(dto);
                
                if (dto.getOK().booleanValue()==false){
                    LogAPP.error("[PED] [Generar solicitud módulos externos] Error al generar las posiciones de la solicitud");                    
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED + ErroresNegocio.PED_042));   
                }
            } else {
                LogAPP.error("[PED] [Generar solicitud módulos externos] La validación de la cabecera de la solicitud no es correcta");                
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PED + ErroresNegocio.PED_016));
            }

            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(dto.getOidCabeceraSolicitud());
            UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generaSolicitud(DTOCabeceraSolicitud dto): Salida "); 
            return dtoOid;
        } catch (NamingException ne) {
            UtilidadesLog.error("Exception: ",ne);
            ctx.setRollbackOnly();
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException re) {
            UtilidadesLog.error("Exception: ",re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e){
            UtilidadesLog.error("Exception: ",e);
            ctx.setRollbackOnly();
            if (e instanceof MareException)
                throw (MareException)e;
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    //-----------------------------------------------------------------------

    /**
             * Autor : Hugo Mansi
             * Creado el : 11/08/2004
             * Recibe : DTOCabeceraSolicitud
             * Devuelve : DTOCabeceraSolicitud
             * Descripcion: Completa la información de la cabecera de la solicitud
    **/
    private DTOCabeceraSolicitud completarCabeceraSolicitud(DTOCabeceraSolicitud dtoe) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCabeceraSolicitud(DTOCabeceraSolicitud dtoe): Entrada ");    
        
        HashMap hashTiposSolicitud = this.obtenerValoresTiposSolicitud(dtoe.getTipoSolicitud());
        
        DTOTipoSolicitud dtoTipoSol = new DTOTipoSolicitud();
        DTOTipoSolicitudPais dtoTipoSolPais = new DTOTipoSolicitudPais();

        dtoTipoSol = (DTOTipoSolicitud)hashTiposSolicitud.get("TS");        
        dtoTipoSolPais = (DTOTipoSolicitudPais)hashTiposSolicitud.get("TSP");
        dtoTipoSol.setOidPais(dtoe.getOidPais());
        dtoTipoSol.setOidIdioma(dtoe.getOidIdioma());
        
        //dtoTipoSol.getIndSolNegativa()
        
        dtoe = completarTipoCliente(dtoe, dtoTipoSol);
        dtoe = completarMarca(dtoe, dtoTipoSol);
        dtoe = completarCanal(dtoe, dtoTipoSol);
        dtoe = completarAcceso(dtoe, dtoTipoSol);
        dtoe = completarSubacceso(dtoe, dtoTipoSol);
        dtoe = completarFecha(dtoe);
        dtoe = completarDestinatario(dtoe);
        dtoe = completarReceptor(dtoe);
        dtoe = completarPagador(dtoe);
        dtoe = completarMoneda(dtoe, dtoTipoSolPais);
        dtoe = completarGlosa(dtoe, dtoTipoSolPais);
        dtoe = completarDestino(dtoe);
        dtoe = completarTipoDocumento(dtoe);
        dtoe = completarTipoDocumentoLegal(dtoe, dtoTipoSolPais, dtoTipoSol);
        dtoe = completarTipoDespacho(dtoe);
        dtoe = completarProceso(dtoe);

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCabeceraSolicitud(DTOCabeceraSolicitud dtoe): Salida ");    
        return dtoe;
    }

    //-----------------------------------------------------------------------

    /**
             * Autor : Hugo Mansi
             * Creado el : 11/08/2004
             * Recibe : DTOCabeceraSolicitud
             * Devuelve : DTOCabeceraSolicitud
             * Descripcion: Completa la información de la cabecera de la solicitud
    **/
    private DTOTipoSolicitud obtenerValoresAsociadosTipoSolicitud(Long tipoSolicitud) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.obtenerValoresAsociadosTipoSolicitud(Long tipoSolicitud): Entrada ");
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(tipoSolicitud);
        
        DTOTipoSolicitud dtoTipoSol = new DTOTipoSolicitud();

        try {
            MONTiposSolicitudHome tipoSolHome = this.getMONTiposSolicitudHome();
            MONTiposSolicitud tipoSolLocal = tipoSolHome.create();
            dtoTipoSol = tipoSolLocal.obtenerValoresAsociadosTipoSolicitud(dtoOid);
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.obtenerValoresAsociadosTipoSolicitud(Long tipoSolicitud): Salida ");
        return dtoTipoSol;
    }

    //-----------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 11/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion: Completa la información de las posiciones de la solicitud recibida
         **/
    private DTOCabeceraSolicitud completarPosicionesSolicitud(DTOCabeceraSolicitud dtoe) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionesSolicitud(DTOCabeceraSolicitud dtoe): Entrada ");
        Long posicion;
        ArrayList miArray = dtoe.getPosiciones();
        int count = 0;
        DTOTipoSolicitudProceso dtoTipoSolicitudProceso = this.obtenerDatosTipoSolicitudProceso(dtoe.getOperacion(), dtoe.getOidTipoSolicitud());
        
        Iterator it = miArray.iterator();

        while (it.hasNext()) {
            DTOPosicionSolicitud dtoPos = (DTOPosicionSolicitud) it.next();
            dtoPos = completarPosicionSolicitud(dtoe, new Long(count), dtoTipoSolicitudProceso);
            //mdolce 20/09/06 la posicion debe comenzar en 1 y no en cero
           // dtoPos.setNumeroPosicion(new Long(count + 1));
            dtoe.getPosiciones().set(count, dtoPos);
            count++;
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionesSolicitud(DTOCabeceraSolicitud dtoe): Salida ");
        return dtoe;
    }

    // FIN completarPosicionesSolicitud
    //-----------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 11/08/2004
         * Recibe : DTOCabeceraSolicitud, Long
         * Devuelve : DTOPosicionSolicitud
         * Descripcion: Completa y valida la información de una posición de la solicitud
         *
    **/
    private DTOPosicionSolicitud completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion): Entrada ");

        DTOPosicionSolicitud miDtoPos = new DTOPosicionSolicitud();

        //obtiene posicion de la solicitud
        miDtoPos = (DTOPosicionSolicitud) dtoCabec.getPosiciones().get(posicion.intValue());

        //Tipo posición y Codigo Producto
        miDtoPos = completarTipoPosicionyCodigoProducto(dtoCabec, miDtoPos);

        // Esto se valida en Generar Posicion Solicitud
        //Unidades Demandadas 
      //  miDtoPos = completarSolicitudNegativa(dtoCabec, miDtoPos);

        //Unidades por atender
        miDtoPos = completarUnidadesAtender(dtoCabec, miDtoPos);

        //Unidades demanda real
        miDtoPos = completarUnidadesDemandaReal(dtoCabec, miDtoPos);
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion): Salida ");
        return miDtoPos;
    }

    private DTOPosicionSolicitud completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion, DTOTipoSolicitudProceso dtoTipoSolicitudProceso) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion,DTOTipoSolicitudProceso dtoTipoSolicitudProceso): Entrada ");

        DTOPosicionSolicitud miDtoPos = new DTOPosicionSolicitud();

        //obtiene posicion de la solicitud
        miDtoPos = (DTOPosicionSolicitud) dtoCabec.getPosiciones().get(posicion.intValue());

        //Tipo posición y Codigo Producto
        miDtoPos = completarTipoPosicionyCodigoProducto(dtoCabec, miDtoPos, dtoTipoSolicitudProceso);

        // Esto se valida en Generar Posicion Solicitud
        //Unidades Demandadas 
      //  miDtoPos = completarSolicitudNegativa(dtoCabec, miDtoPos);

        //Unidades por atender
        miDtoPos = completarUnidadesAtender(dtoCabec, miDtoPos);

        //Unidades demanda real
        miDtoPos = completarUnidadesDemandaReal(dtoCabec, miDtoPos);
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPosicionSolicitud(DTOCabeceraSolicitud dtoCabec, Long posicion,DTOTipoSolicitudProceso dtoTipoSolicitudProceso): Salida ");
        return miDtoPos;
    }


    //FIN completarPosicionSolicitud
    //-----------------------------------------------------------------------

    private DTOPosicionSolicitud completarTipoPosicionyCodigoProducto(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");
        BelcorpService bs = null;
        try {
            if(dtoPos.getTipoPosicion()==null && dtoPos.getSubtipoPosicion()==null){
                TiposSolicitudProcesoLocalHome miTipoSolProcH = new TiposSolicitudProcesoLocalHome();
                TiposSolicitudProcesoLocal miTipoSolProcL = miTipoSolProcH.findByUKProceso(dtoCabec.getOperacion(), dtoCabec.getTipoSolicitud());
                dtoPos.setTipoPosicion(miTipoSolProcL.getOidTipoPosicion());
                dtoPos.setSubtipoPosicion(miTipoSolProcL.getOidSubTipoPosicion());
                UtilidadesLog.debug("Se ha completado tipo de solicitud");
                if ((dtoPos.getProducto() == null) && (dtoPos.getCodigoVenta() == null)) {
                    if (miTipoSolProcL.getIndProducto().booleanValue()) {
                        dtoPos.setProducto(miTipoSolProcL.getOidProducto());
                        UtilidadesLog.debug("Se ha completado el código de producto");
                    } else {
                        LogAPP.error(Paquete + CU + " Error en código de venta o código producto ");
                        UtilidadesLog.debug("Error: no se pudo completar el código de producto...");
                    }
                }
            }
        } catch (NoResultException nre) {
            UtilidadesLog.debug("Error de Finder");
            UtilidadesLog.debug("No se completan los datos por falta de parametrizacion");
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         } catch (PersistenceException pe) {
             ctx.setRollbackOnly();
             UtilidadesLog.error("Error de persistencia: ", pe);
             throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
        return dtoPos;
    }
    
  
   private DTOPosicionSolicitud completarTipoPosicionyCodigoProducto(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos, DTOTipoSolicitudProceso dtoTipoSolicitudProceso) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos,DTOTipoSolicitudProceso dtoTipoSolicitudProceso): Entrada ");
        BelcorpService bs = null;

        if(dtoPos.getTipoPosicion()==null && dtoPos.getSubtipoPosicion()==null){
            if (dtoTipoSolicitudProceso != null){
               dtoPos.setTipoPosicion(dtoTipoSolicitudProceso.getTipoPosicion());
               dtoPos.setSubtipoPosicion(dtoTipoSolicitudProceso.getSubtipoPosicion());
               if ((dtoPos.getProducto() == null) && (dtoPos.getCodigoVenta() == null)) {
                  if (dtoTipoSolicitudProceso.getIndProducto().equals(Boolean.TRUE)) {
                    dtoPos.setProducto(dtoTipoSolicitudProceso.getOidProducto());
                  } else {
                    LogAPP.error(Paquete + CU + " Error en código de venta o código producto ");
                    UtilidadesLog.debug("Error: no se pudo completar el código de producto...");
                  }
               }            
            } else {
                 if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 24/03/2010                
                   UtilidadesLog.debug("Error de Finder");
                   UtilidadesLog.debug("No se completan los datos por falta de parametrizacion");
                 }  
            }
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos,DTOTipoSolicitudProceso dtoTipoSolicitudProceso): Salida ");
        return dtoPos;
    }
  
  
  
  
    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud, DTOPosicionSolicitud
         * Devuelve : DTOPosicionSolicitud
         * Descripcion:
         *
    **/
    
/*Se reemplaza por completarTipoPosicionyCodigoProducto    
    private DTOPosicionSolicitud completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");
        try {
            TiposSolicitudProcesoLocalHome miTipoSolProcH = this.getTiposSolicitudProcesoLocalHome();
            TiposSolicitudProcesoLocal miTipoSolProcL = miTipoSolProcH.findByUKProceso(dtoCabec.getOperacion(), dtoCabec.getTipoSolicitud());
            dtoPos.setTipoPosicion(miTipoSolProcL.getOidTipoPosicion());
            dtoPos.setSubtipoPosicion(miTipoSolProcL.getOidSubTipoPosicion());
            UtilidadesLog.debug("Se ha completado tipo de solicitud");
        } catch (NamingException ne) {
            UtilidadesLog.debug("Error de Naming");
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.debug("Error de Finder");
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoPosicion(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
        return dtoPos;
    }

    //FIN completarTipoPosicion
    //-----------------------------------------------------------------------

    /**
        * Autor : Hugo Mansi
        * Creado el : 12/08/2004
        * Recibe : DTOCabeceraSolicitud, DTOPosicionSolicitud
        * Devuelve : DTOPosicionSolicitud
        * Descripcion:
        *
    **/
    
/*Se reemplaza por completarTipoPosicionyCodigoProducto    
    private DTOPosicionSolicitud completarCodigoProducto(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCodigoProducto(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");
        BelcorpService bs = null;

        try {
            /* if (dtoPos.getProducto() == null) {
                 TiposSolicitudProcesoLocalHome miTipoSolProcH = this.getTiposSolicitudProcesoLocalHome();
                 TiposSolicitudProcesoLocal miTipoSolProcL = miTipoSolProcH.findByUKProceso(dtoCabec.getOperacion(), dtoCabec.getTipoSolicitud());

                 if (miTipoSolProcL.getIndProducto().equals(Boolean.TRUE)) {
                     dtoPos.setProducto(miTipoSolProcL.getOidProducto());
                 } else if ((dtoPos.getCodigoVenta() == null) || dtoPos.getCodigoVenta().equals("")) {
                     bs = BelcorpService.getInstance();
                     bs.appLog.error(Paquete + CU + " Error en código de venta o código producto ");
                     UtilidadesLog.debug("Error: no se pudo completar el código de producto...");
                 }
             }

             UtilidadesLog.debug("Se ha completado el código de producto");

             return dtoPos;
             */

            //Por incidencia 10442, el código comentado precedentemente, fue reemplazado por el que sigue.
            //Se deja el código anterior para dejar sentado el cambio respectivo.
            //Corrigió: Hugo Mansi
            //Fecha: 22-11-2004
 /*           if ((dtoPos.getProducto() == null) && (dtoPos.getCodigoVenta() == null)) {
                TiposSolicitudProcesoLocalHome miTipoSolProcH = this.getTiposSolicitudProcesoLocalHome();
                TiposSolicitudProcesoLocal miTipoSolProcL = miTipoSolProcH.findByUKProceso(dtoCabec.getOperacion(), dtoCabec.getTipoSolicitud());

                if (miTipoSolProcL.getIndProducto().equals(Boolean.TRUE)) {
                    dtoPos.setProducto(miTipoSolProcL.getOidProducto());
                    UtilidadesLog.debug("Se ha completado el código de producto");
                } else {
                    bs = BelcorpService.getInstance();
                    bs.appLog.error(Paquete + CU + " Error en código de venta o código producto ");
                    UtilidadesLog.debug("Error: no se pudo completar el código de producto...");
                }
            }
            UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCodigoProducto(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
            return dtoPos;
        } catch (NamingException ne) {
            UtilidadesLog.debug("Excepción de Naming");
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.debug("Excepción de Finder");
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }*/

    //FIN completarCodigoProducto
    //-----------------------------------------------------------------------

    /**
        * Autor : Hugo Mansi
        * Creado el : 12/08/2004
        * Recibe : DTOCabeceraSolicitud, DTOPosicionSolicitud
        * Devuelve : DTOPosicionSolicitud
        * Descripcion:
        *
    **/
    private DTOPosicionSolicitud completarSolicitudNegativa(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarSolicitudNegativa(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");

        Boolean solicitudNegativa = null;
        Long unidadesDemandadas;
        BelcorpService bs = null;

        try {
            TiposSolicitudPaisLocalHome tipoSolPaisHome = new TiposSolicitudPaisLocalHome();
            TiposSolicitudPaisLocal tipoSolPaisLocal = tipoSolPaisHome.findByPrimaryKey(dtoCabec.getTipoSolicitud());
            TiposSolicitudLocalHome tipoSolHome = new TiposSolicitudLocalHome();
            TiposSolicitudLocal tiposSolLocal = tipoSolHome.findByPrimaryKey(tipoSolPaisLocal.getOidTipoSolicitud());
            solicitudNegativa = tiposSolLocal.getIndSolNegativa();
            unidadesDemandadas = dtoPos.getUnidadesDemandadas();
            
            UtilidadesLog.debug("OidTipoSol: " + tiposSolLocal.getOid().toString());
            UtilidadesLog.debug("Indicador de Solicitud Negativa: " + solicitudNegativa.toString());

            if (!solicitudNegativa.booleanValue()) {
                if (unidadesDemandadas.longValue() < 0) {
                    LogAPP.error(Paquete + CU + "Error en unidades demandadas");
                    UtilidadesLog.debug("Error en unidades demandadas");
          
                } 
            } else {
                if (unidadesDemandadas.longValue() > 0) {
                    LogAPP.error(Paquete + CU + "Error en unidades demandadas");
                    UtilidadesLog.debug("Error en unidades demandadas");
                }
            }

          
            UtilidadesLog.debug("Se ha completado solicitud negativa");
            UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarSolicitudNegativa(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
            return dtoPos;
        } catch (NoResultException nre) {
            UtilidadesLog.debug("No hay resultados: ", nre);
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            UtilidadesLog.debug("Excepción de persistencia: ", pe);
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    //FIN completarSolicitudNegativa
    //-----------------------------------------------------------------------

    /**
        * Autor : Hugo Mansi
        * Creado el : 12/08/2004
        * Recibe : DTOCabeceraSolicitud, DTOPosicionSolicitud
        * Devuelve : DTOPosicionSolicitud
        * Descripcion:
        *
        * Autor: Marcelo Maidana
        * Descripción: Se han agregado validaciones de nulos.
    **/
    private DTOPosicionSolicitud completarUnidadesAtender(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarUnidadesAtender(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");

        if( dtoPos != null && dtoPos.getUnidadesDemandadas() != null && !dtoPos.getUnidadesDemandadas().equals(new Long(0)) && dtoPos.getUnidadesPorAtender() != null && dtoPos.getUnidadesPorAtender().equals(new Long(0))) {
            dtoPos.setUnidadesPorAtender(dtoPos.getUnidadesDemandadas());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarUnidadesAtender(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
        return dtoPos;
    }

    //FIN completarUnidadesAtender
    //-----------------------------------------------------------------------

    /**
        * Autor : Hugo Mansi
        * Creado el : 12/08/2004
        * Recibe : DTOCabeceraSolicitud, DTOPosicionSolicitud
        * Devuelve : DTOPosicionSolicitud
        * Descripcion:
        *
    **/
    private DTOPosicionSolicitud completarUnidadesDemandaReal(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarUnidadesDemandaReal(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Entrada ");
        dtoPos.setUnidadesDemandaReal(dtoPos.getUnidadesPorAtender());
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarUnidadesDemandaReal(DTOCabeceraSolicitud dtoCabec, DTOPosicionSolicitud dtoPos): Salida ");
        return dtoPos;
    }

    //FIN completarUnidadesDemandaReal
    //-----------------------------------------------------------------------

    /**
        * Autor : Hugo Mansi
        * Creado el : 12/08/2004
        * Recibe : DTOCabeceraSolicitud, DTOTipoSolicitud
        * Devuelve : DTOCabeceraSolicitud
        * Descripcion:
        *
    **/
    private DTOCabeceraSolicitud completarTipoCliente(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol) throws MareException {

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoCliente(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Entrada ");

        if (dtoCabec.getTipoCliente() == null) {
            dtoCabec.setTipoCliente(dtoTipoSol.getTipoCliente());
        } else if (!dtoCabec.getTipoCliente().equals(dtoTipoSol.getTipoCliente())) {
            LogAPP.error(Paquete + CU + "Error en tipo de cliente");

            UtilidadesLog.debug("Error en tipo de cliente");
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoCliente(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Salida ");
        return dtoCabec;
    }

    //FIN completarTipoCliente
    //-----------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud, DTOTipoSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarMarca(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol) throws MareException {

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarMarca(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Entrada ");

        if ((dtoCabec.getMarca() == null) || (!dtoCabec.getMarca().equals(dtoTipoSol.getMarca()))) {
            LogAPP.error(Paquete + CU + "Error en marca");
            UtilidadesLog.debug("Error en marca");
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarMarca(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Salida ");
        return dtoCabec;
    }

    //FIN completarMarca
    //-------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud, DTOTipoSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarCanal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCanal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Entrada ");

        if ((dtoCabec.getCanal() == null) || (!dtoCabec.getCanal().equals(dtoTipoSol.getCanal()))) {
            LogAPP.error(Paquete + CU + "Error en canal");
            UtilidadesLog.debug("Error: No se pudo completar el canal");
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarCanal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud, DTOTipoSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarAcceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol) throws MareException {


        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarAcceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Entrada ");

        if ((dtoCabec.getAcceso() == null) || (!dtoCabec.getAcceso().equals(dtoTipoSol.getAcceso()))) {
            UtilidadesLog.debug("Error: No se pudo completar acceso");

            LogAPP.error(Paquete + CU + "Error en acceso");
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarAcceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Salida ");

        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud, DTOTipoSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarSubacceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarSubacceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Entrada ");

        try {
            if (dtoCabec.getSubacceso() != null) {
                if (dtoTipoSol.getSubacceso() != null) {
                    if (!dtoCabec.getSubacceso().equals(dtoTipoSol.getSubacceso())) {
                        LogAPP.error(Paquete + CU + "Error en subacceso");
                    }
                } else {
                    DTOSubaccesosPorAccesoYCanal dtoSubAcc = new DTOSubaccesosPorAccesoYCanal();
                    MONMantenimientoSEGHome segHome = this.getMONMantenimientoSEGHome();
                    MONMantenimientoSEG segLocal = segHome.create();
                    dtoSubAcc.setOidAcceso(dtoCabec.getAcceso());
                    dtoSubAcc.setOidCanal(dtoCabec.getCanal());
                    dtoSubAcc.setOidIdioma(dtoCabec.getOidIdioma());

                    DTOSalida dtoSalida = new DTOSalida();
                    dtoSalida = segLocal.recuperarSubaccesosPorAccesoCanal(dtoSubAcc);

                    RecordSet rs = dtoSalida.getResultado();
                    int rows = rs.getRowCount();
                    Boolean loEncontro = Boolean.FALSE;

                    //Búsqueda del subacceso en el resultado de la consulta de recuperarSubaccesosPorAccesoCanal
                    for (int i = 0; i < rows; i++) {
                        if (rs.getValueAt(i, 0) != null) {
                            if (new Long(rs.getValueAt(i, 0).toString()).equals(dtoCabec.getSubacceso())) {
                                loEncontro = Boolean.TRUE;
                            }
                        }
                    }

                    //si esta en el resultado lanza error al log
                    if (loEncontro.equals(Boolean.FALSE)) {
                        LogAPP.error(Paquete + CU + "Error en subacceso");
                    }
                }
            } else {
                if (dtoTipoSol.getSubacceso() != null) {
                    dtoCabec.setSubacceso(dtoTipoSol.getSubacceso());
                } else {
                    MONUsuarios monUsu = this.getMONUsuariosHome().create();
                    String uName = ctx.getCallerPrincipal().getName();
                    HashMap propiedades = monUsu.getProperties(new UserIDImpl(uName));
                    
                    Property subacceso = (Property) propiedades.get(ConstantesPED.SUBACCESO_DEFECTO);
                    dtoCabec.setSubacceso(new Long(subacceso.getValue().toString()));
                }
            }
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ce) {
            UtilidadesLog.error("Exception: ",ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } 

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarSubacceso(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitud dtoTipoSol): Salida ");

        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarFecha(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarFecha(DTOCabeceraSolicitud dtoCabec): Entrada ");

        if (dtoCabec.getFecha() == null) {
            dtoCabec.setFecha(new Date());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarFecha(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarDestinatario(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarDestinatario(DTOCabeceraSolicitud dtoCabec): Entrada ");
        if (dtoCabec.getDestinatario() == null) {
            dtoCabec.setDestinatario(dtoCabec.getOidCliente());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarDestinatario(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarReceptor(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarReceptor(DTOCabeceraSolicitud dtoCabec): Entrada ");

        if (dtoCabec.getOidReceptorFactura() == null) {
            dtoCabec.setOidReceptorFactura(dtoCabec.getOidCliente());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarReceptor(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarPagador(DTOCabeceraSolicitud dtoCabec) throws MareException {
    
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPagador(DTOCabeceraSolicitud dtoCabec): Entrada ");

        if (dtoCabec.getPagadorFactura() == null) {
            dtoCabec.setOidPagadorFactura(dtoCabec.getOidCliente());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarPagador(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud, DTOTipoSolicitudPais
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarMoneda(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais) throws MareException {

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarMoneda(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Entrada ");

        if (dtoCabec.getMoneda() == null) {
            dtoCabec.setMoneda(dtoPais.getMoneda());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarMoneda(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud, DTOTipoSolicitudPais
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarGlosa(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais) throws MareException {

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarGlosa(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Entrada ");

        if (dtoCabec.getObservaciones() == null) {
            dtoCabec.setObservaciones(dtoPais.getGlosa());
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarGlosa(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------

    /**
         * @Autor : Hugo Mansi
         * @Creado el : 12/08/2004
         * @Recibe : DTOCabeceraSolicitud
         * @Devuelve : DTOCabeceraSolicitud
         * @Descripcion: Completa el destino de la solicitud.
         * @Modifico: Cortaberria
         * @Fecha última modificación: 19/11/2004
         *
         * @Modifico: Cortaberria
         * @Fecha: 01/12/04
         * @Descripcion: se modifica el setDestino segun incidencia 11120
         * 
         * @Modifico: Hugo Mansi
         * @Fecha: 31/10/2006
         * @Descripción: Se invoca al método obtenerDireccionPrincipalUAActiva pasándole el oid del cliente para
         * recuperar la dirección principal de la unidad administrativa activa a la cual pertenece.
     **/
    private DTOCabeceraSolicitud completarDestino(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarDestino(DTOCabeceraSolicitud dtoCabec): Entrada ");

        //try {
            //ClienteDireccionLocalHome clienteLH = this.getClienteDireccionLocalHome();
            //Collection clienteDirC = clienteLH.findDireccionPrincipalCliente(dtoCabec.getOidCliente());

            //Agregado por Cortaberria 19/11/2004
            //if ((clienteDirC == null) || (clienteDirC.size() == 0)) {
            //    UtilidadesLog.debug("Excepción de Finder");

            //    throw new FinderException("No se encontro el cliente " + dtoCabec.getOidCliente());
            //}

            //Iterator it = clienteDirC.iterator();
            //ClienteDireccionLocal clienteDire = (ClienteDireccionLocal) it.next();
            //dtoCabec.setDestino(clienteDire.getTidc_oid_tipo_dire());
            dtoCabec.setDestino(obtenerDireccionPrincipalUAActiva(dtoCabec.getOidCliente()));
     
    /*    } catch (NamingException ne) {
            UtilidadesLog.debug("Excepción de Naming...");
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.debug("Excepción de Finder");
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }*/

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarDestino(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud, DTOTipoSolicitudPais
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarTipoDocumento(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDocumento(DTOCabeceraSolicitud dtoCabec): Entrada ");

        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(dtoCabec.getOidCliente());
        dtoOid.setOidIdioma(dtoCabec.getOidIdioma());

        RecordSet rs = null;

        try {
            MONConfiguracionClientesHome configClienteH = this.getMONConfiguracionClientesHome();
            MONConfiguracionClientes configCliente = configClienteH.create();
            DTOSalida dtoSalida = configCliente.obtenerTiposDocumentoCliente(dtoOid);
            rs = dtoSalida.getResultado();

            if (!rs.esVacio() && (rs.getRow(0).elementAt(0) != null)) {
                dtoCabec.setTipoDocumento(new Long(rs.getRow(0).elementAt(0).toString()));
            }
        } catch (NamingException ne) {
            UtilidadesLog.debug("Exception de Naming");
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.debug("Exception de Remote");
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.debug("Exception de Create");
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDocumento(DTOCabeceraSolicitud dtoCabec): Salida ");

        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud, DTOTipoSolicitudPais
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarTipoDocumentoLegal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais, DTOTipoSolicitud dtoTipo) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDocumentoLegal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Entrada ");

        //si se trata de una reclamación
        if (dtoCabec.getModulo().equals(new Long(ConstantesSEG.MODULO_REC)) &&  dtoTipo.getIndSolNegativa().booleanValue() ) {
            if (dtoPais.getTipoDocumentoLegal() != null) {
                dtoCabec.setTipoDocumentoLegal(dtoPais.getTipoDocumentoLegal());
            } else {
                dtoCabec.setTipoDocumentoLegal(this.obtenerTiposDocumentoLegalReclamos(dtoCabec.getOidDocumentoReferencia()));
      
                if (dtoCabec.getTipoDocumentoLegal() == null) {
                    LogAPP.error(Paquete + CU + "Error en tipo de documento legal");
                }
            }
        } else {
            if (dtoPais.getTipoDocumentoLegal() != null)  {
                dtoCabec.setTipoDocumentoLegal(dtoPais.getTipoDocumentoLegal());
            } else {
                dtoCabec.setTipoDocumentoLegal(this.obtenerTipoDocumentoLegal(dtoCabec.getTipoDocumento()));
                if (dtoCabec.getTipoDocumentoLegal() == null) {
                    LogAPP.error(Paquete + CU + "Error en tipo documento legal");
                    UtilidadesLog.debug("Error en tipo de documento legal");                
                }
            }                
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDocumentoLegal(DTOCabeceraSolicitud dtoCabec, DTOTipoSolicitudPais dtoPais): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------------
    private DTOCabeceraSolicitud completarTipoDespacho(DTOCabeceraSolicitud dtoCabec) throws MareException {
        /*Crea un DTOBelcorp con: - pais activo del sistema
          DTOOID = Llamar al método DAOPED.obtieneTipoDespachoCronogramaActivo(DTOBelcorp)
          DTOE.tipoDespacho = DTOOID.oid
          Devuelve DTOE   */
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDespacho(DTOCabeceraSolicitud dtoCabec): Entrada ");
        DTOBelcorp dtoBel = new DTOBelcorp();
        dtoBel.setOidPais(dtoCabec.getOidPais());

        String user = ctx.getCallerPrincipal().getName();
        DAOPED dao = new DAOPED(user);

        DTOOID dtoOid = dao.obtieneTipoDespachoCronogramaActivo(dtoBel);
        dtoCabec.setTipoDespacho(dtoOid.getOid());
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarTipoDespacho(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------------

    /**
         * Autor : Hugo Mansi
         * Creado el : 12/08/2004
         * Recibe : DTOCabeceraSolicitud
         * Devuelve : DTOCabeceraSolicitud
         * Descripcion:
         *
     **/
    private DTOCabeceraSolicitud completarProceso(DTOCabeceraSolicitud dtoCabec) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarProceso(DTOCabeceraSolicitud dtoCabec): Entrada ");
        DAOGruposProceso miDao = new DAOGruposProceso();
        dtoCabec.setProceso(miDao.obtenerUltimoProcesoGP(ConstantesPED.GP1, dtoCabec.getTipoSolicitud()));
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.completarProceso(DTOCabeceraSolicitud dtoCabec): Salida ");
        return dtoCabec;
    }

    //--------------------------------------------------------------------------------------------------
    private MONTiposSolicitudProcesoHome getMONTiposSolicitudProcesoHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONTiposSolicitudProcesoHome) PortableRemoteObject.narrow(context.lookup("MONTiposSolicitudProceso"), MONTiposSolicitudProcesoHome.class);
    }

    //-----------------------------------------------------------------------
    private MONTiposSolicitudHome getMONTiposSolicitudHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONTiposSolicitudHome) PortableRemoteObject.narrow(context.lookup("MONTiposSolicitud"), MONTiposSolicitudHome.class);
    }

    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------

    //-----------------------------------------------------------------------
    /*private MONValidacionesGeneralesSolicitudHome getMONValidacionesGeneralesSolicitudHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONValidacionesGeneralesSolicitudHome) PortableRemoteObject.narrow(context.lookup("MONValidacionesGeneralesSolicitud"), MONValidacionesGeneralesSolicitudHome.class);
    }*/

    //-----------------------------------------------------------------------
    /*private MONDigitacionInicialHome getMONDigitacionInicialHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONDigitacionInicialHome) PortableRemoteObject.narrow(context.lookup("MONDigitacionInicial"), MONDigitacionInicialHome.class);
    }*/

    //-----------------------------------------------------------------------
    private MONMantenimientoSEGHome getMONMantenimientoSEGHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONMantenimientoSEGHome) PortableRemoteObject.narrow(context.lookup("MONMantenimientoSEG"), MONMantenimientoSEGHome.class);
    }


    private MONTiposSolicitudPaisHome getMONTiposSolicitudPaisHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONTiposSolicitudPaisHome) PortableRemoteObject.narrow(context.lookup("MONTiposSolicitudPais"), MONTiposSolicitudPaisHome.class);
    }


    private MONConfiguracionClientesHome getMONConfiguracionClientesHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONConfiguracionClientesHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConfiguracionClientes"), MONConfiguracionClientesHome.class);
    }
    
    private MONGenerarPosicionSolicitudHome getMONGenerarPosicionSolicitudHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarPosicionSolicitudHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarPosicionSolicitud"), MONGenerarPosicionSolicitudHome.class);
    }

    

    public Vector generarSolicitudes(Vector dtosCabecera) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarSolicitudes(Vector dtosCabecera): Entrada ");
        if(dtosCabecera!=null){
            int largo =dtosCabecera.size();
            for(int posicion =0; posicion<largo;posicion++) {
                try{
                    //DTOOID salida = this.generaSolicitud((DTOCabeceraSolicitud)dtosCabecera.get(posicion));
                    //((DTOCabeceraSolicitud)dtosCabecera.get(posicion)).setOidCabeceraSolicitud(salida.getOid());
                    DTOCabeceraSolicitud dto = (DTOCabeceraSolicitud)dtosCabecera.get(posicion);
                    dto = completarCabeceraSolicitud(dto);
                    dto = completarPosicionesSolicitud(dto);
                    try {
                        dto.setIndicadorDigitacion(Boolean.FALSE);
                        MONValidacionesGeneralesSolicitudLocal valGenLocal = this.getMONValidacionesGeneralesSolicitudLocalHome().create();                        
                        
                        /*MONValidacionesGeneralesSolicitudHome valGenHome = this.getMONValidacionesGeneralesSolicitudHome();
                        MONValidacionesGeneralesSolicitud valGenLocal = valGenHome.create();*/
                        
                        dto = valGenLocal.validarSolicitud(dto);
                        if (dto.getOK().equals(Boolean.TRUE)) {
                            dto.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);                
                            MONDigitacionInicialLocal digiLocal = this.getMONDigitacionInicialLocalHome().create();
                            
                            /*MONDigitacionInicialHome digiHome = this.getMONDigitacionInicialHome();
                            MONDigitacionInicial digiLocal = digiHome.create();*/
                            
                            dto = digiLocal.grabarSolicitud(dto);
                            if (dto.getOK().booleanValue()==false){
                                LogAPP.error("[PED] [Generar solicitud módulos externos masivo] Error al generar las posiciones de la solicitud");                    
                            }
                        } else {
                            LogAPP.error("[PED] [Generar solicitud módulos externos masivo] La validación de la cabecera de la solicitud no es correcta");                
                        }
                        dtosCabecera.set(posicion,dto);
                    } catch (Exception e){
                        UtilidadesLog.error("Exception: ",e);
                 }
               }catch(Exception e) {
                    UtilidadesLog.error("Error al generar la solicitud: "+posicion+"\n",e);
               }
            }
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarSolicitudes(Vector dtosCabecera): Salida ");
        return dtosCabecera;
    }


    /*
     * Este metodo se agrega ante la necesidad de centralizar la logica del generar
     * posiciones, que es responsabilidad de ped.
     * Espera un Vector de DTOCabeceraSolicitud y devuelve un Vector de 
     * DTOCabeceraSolicitud con las posiciones validadas y guardadaes, segun corresponda.
     * */
    public Vector generarPosiciones(Vector dtosCabecera) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarPosiciones(Vector dtosCabecera): Entrada ");
        if(dtosCabecera!=null){
            try{
                int largo =dtosCabecera.size();
                MONGenerarPosicionSolicitudHome generarPosicionesHome = this.getMONGenerarPosicionSolicitudHome();
                MONGenerarPosicionSolicitud generarPosiciones = generarPosicionesHome.create();
                for(int cabecera =0; cabecera<largo;cabecera++) {
                    try{                   
                        DTOCabeceraSolicitud dto = (DTOCabeceraSolicitud)dtosCabecera.get(cabecera);
                        if(dto.getOidCabeceraSolicitud()!=null || !dto.getOidCabeceraSolicitud().equals(new Long("0"))){
                                dto.setEstado(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
                                int posic = dto.getPosiciones().size();
                                for(int posicion=0; posicion<posic;posicion++){
                                    dto = generarPosiciones.generarPosicion(dto,new Long(posicion),Boolean.TRUE);
                                    if(!dto.getOK().booleanValue()){
                                        UtilidadesLog.debug("No valido la posicion "+posicion+" de la cabecera "+dto.getOidCabeceraSolicitud().toString());
                                    }
                                }
                                dtosCabecera.set(cabecera,dto);
                        }else{
                             UtilidadesLog.debug("No se procesa la cabecera "+cabecera+" porque no tiene oid");   
                        }
                    }catch(Exception e){
                        UtilidadesLog.error("Error el grabar posicion (interno): ",e);
                    }
                }
            }catch(Exception e) {
                UtilidadesLog.error("Error el grabar posicion (externo): ",e);
            }
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternosBean.generarPosiciones(Vector dtosCabecera): Salida ");
        return dtosCabecera;
    }

    private MONValidacionesGeneralesSolicitudLocalHome getMONValidacionesGeneralesSolicitudLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONValidacionesGeneralesSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONValidacionesGeneralesSolicitud");
    }

    private MONDigitacionInicialLocalHome getMONDigitacionInicialLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONDigitacionInicialLocalHome)context.lookup("java:comp/env/ejb/local/MONDigitacionInicial");
    }

    private HashMap obtenerValoresTiposSolicitud(Long oidTipoSolicitudPais) throws MareException{
      HashMap hashTiposSolicitud = new HashMap();
      StringBuffer query = new StringBuffer();
      
      query.append(" SELECT PTS.OID_TIPO_SOLI, ");
	    query.append(" PTS.COD_TIPO_SOLI, ");
	    query.append(" PTS.CLSO_OID_CLAS_SOLI, ");
	    query.append(" PTS.IND_CONS, ");
	    query.append(" PTS.IND_SOLI_NEGA, ");
	    query.append(" PTS.IND_DEVO, ");
	    query.append(" PTS.IND_ANUL, ");
	    query.append(" PTS.MARC_OID_MARC, ");
	    query.append(" PTS.ACCE_OID_ACCE, ");
	    query.append(" PTS.SBAC_OID_SBAC, ");
	    query.append(" PTS.TICL_OID_TIPO_CLIE, ");
	    query.append(" ACC.CANA_OID_CANA, TSP.*	");   
      query.append(" FROM PED_TIPO_SOLIC_PAIS TSP, ");
      query.append("      PED_TIPO_SOLIC PTS, ");
      query.append("      SEG_ACCES ACC ");
      query.append(" WHERE TSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
      query.append("   AND ACC.OID_ACCE = PTS.ACCE_OID_ACCE ");
      query.append("   AND TSP.OID_TIPO_SOLI_PAIS = " + oidTipoSolicitudPais);

      RecordSet rs = null;
      
      rs = this.executeQuery(query.toString());
      
      if (rs != null && !rs.esVacio()){
          DTOTipoSolicitudPais dtoTipoSolicitudPais = new DTOTipoSolicitudPais();
          DTOTipoSolicitud dtoTipoSolicitud = new DTOTipoSolicitud();
          
          dtoTipoSolicitud.setOid(this.bigDecimalToLong(rs.getValueAt(0,"OID_TIPO_SOLI")));
          dtoTipoSolicitud.setCodigo(this.objectToString(rs.getValueAt(0,"COD_TIPO_SOLI")));
          dtoTipoSolicitud.setClaseSolicitud(this.bigDecimalToLong(rs.getValueAt(0,"CLSO_OID_CLAS_SOLI")));
          dtoTipoSolicitud.setIndConsolidado(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_CONS")));
          dtoTipoSolicitud.setIndSolNegativa(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_SOLI_NEGA")));
          dtoTipoSolicitud.setIndDevoluciones(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_DEVO")));
          dtoTipoSolicitud.setIndAnulacion(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_ANUL")));
          dtoTipoSolicitud.setMarca(this.bigDecimalToLong(rs.getValueAt(0,"MARC_OID_MARC")));
          dtoTipoSolicitud.setAcceso(this.bigDecimalToLong(rs.getValueAt(0,"ACCE_OID_ACCE")));
          dtoTipoSolicitud.setSubacceso(this.bigDecimalToLong(rs.getValueAt(0,"SBAC_OID_SBAC")));
          dtoTipoSolicitud.setTipoCliente(this.bigDecimalToLong(rs.getValueAt(0,"TICL_OID_TIPO_CLIE")));
          dtoTipoSolicitud.setCanal(this.bigDecimalToLong(rs.getValueAt(0,"CANA_OID_CANA")));
          
          dtoTipoSolicitudPais.setOid(this.bigDecimalToLong(rs.getValueAt(0,"OID_TIPO_SOLI_PAIS")));          
          dtoTipoSolicitudPais.setNumPorLote(this.bigDecimalToInteger(rs.getValueAt(0,"NUM_SOLI_LOTE")));
          dtoTipoSolicitudPais.setAlarmaNumUnidades(this.bigDecimalToInteger(rs.getValueAt(0,"NUM_UNID_ALAR")));
          dtoTipoSolicitudPais.setSujetoFlete(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_SUJE_FLET")));
          dtoTipoSolicitudPais.setPermiteUnionSolicitudes(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PERM_UNIO")));
          dtoTipoSolicitudPais.setReservaStock(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_RESE_STOC")));
          dtoTipoSolicitudPais.setPermiteReversion(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PERM_REVE")));
          dtoTipoSolicitudPais.setIndPedidoPrueba(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PEDI_PRUE")));
          dtoTipoSolicitudPais.setIndComisionable(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_COMI")));
          dtoTipoSolicitudPais.setIndPedGtZona(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PEDI_GT_ZONA")));
          dtoTipoSolicitudPais.setIndCambioVentaBEL(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_CAMB_VENT_BEL")));
          dtoTipoSolicitudPais.setIndVentaSAB14(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_VENT_INTE_SAB_14")));
          dtoTipoSolicitudPais.setSociedad(this.bigDecimalToLong(rs.getValueAt(0,"SOCI_OID_SOCI")));
          dtoTipoSolicitudPais.setFormaPago(this.bigDecimalToLong(rs.getValueAt(0,"FOPA_OID_FORM_PAGO")));
          dtoTipoSolicitudPais.setTipoDocumentoLegal(this.bigDecimalToLong(rs.getValueAt(0,"TIDO_OID_TIPO_DOCU")));
          dtoTipoSolicitudPais.setMoneda(this.bigDecimalToLong(rs.getValueAt(0,"MONE_OID_MONE")));
          dtoTipoSolicitudPais.setActividad(this.bigDecimalToLong(rs.getValueAt(0,"CACT_OID_ACTI")));
          dtoTipoSolicitudPais.setTipoMovReserva(this.bigDecimalToLong(rs.getValueAt(0,"TMAL_OID_TIPO_MOVI_RESE")));
          dtoTipoSolicitudPais.setTipoMovAsigna(this.bigDecimalToLong(rs.getValueAt(0,"TMAL_OID_TIPO_MOVI_ASIG")));
          dtoTipoSolicitudPais.setTipoMovFacturacion(this.bigDecimalToLong(rs.getValueAt(0,"TMAL_OID_TIPO_MOVI_FACT")));
          dtoTipoSolicitudPais.setOidPais(this.bigDecimalToLong(rs.getValueAt(0,"PAIS_OID_PAIS")));
          dtoTipoSolicitudPais.setTipoSolicitud(this.bigDecimalToLong(rs.getValueAt(0,"TSOL_OID_TIPO_SOLI")));
          dtoTipoSolicitudPais.setTipoConsolidado(this.bigDecimalToLong(rs.getValueAt(0,"TSOL_OID_TIPO_CONS")));
          dtoTipoSolicitudPais.setGlosa(this.objectToString(rs.getValueAt(0,"VAL_GLOS")));
          dtoTipoSolicitudPais.setAlmacen(this.bigDecimalToLong(rs.getValueAt(0,"ALMC_OID_ALMA")));
        
          StringBuffer query2 = new StringBuffer();
          
          query2.append("	SELECT * ");
          query2.append(" FROM V_GEN_I18N_SICC GEN ");
          query2.append(" WHERE GEN.ATTR_ENTI = 'PED_TIPO_SOLIC' ");
	 	      query2.append("   AND GEN.ATTR_NUM_ATRI = 1 ");
		      query2.append("   AND GEN.VAL_OID = " + dtoTipoSolicitud.getOid());
    
          rs = this.executeQuery(query2.toString());
          
          if (rs != null && !rs.esVacio()){
              DTOI18nSICC dtoI18n = null;
           		Vector vecDescripciones = new Vector();
              int lonRs = rs.getRowCount();
              for (int i = 0; i < lonRs; i++) {
                dtoI18n = new DTOI18nSICC();
                dtoI18n.setOidAtriuto(this.bigDecimalToLong(rs.getValueAt(i,"OID_I18N")));
                dtoI18n.setOidIdioma(this.bigDecimalToLong(rs.getValueAt(i,"IDIO_OID_IDIO")));
                dtoI18n.setValorI18n(this.objectToString(rs.getValueAt(i,"VAL_I18N")));
                vecDescripciones.add(dtoI18n);
              }
        			dtoTipoSolicitud.setAttriTraducible(vecDescripciones);		
          }          
          hashTiposSolicitud.put("TS", dtoTipoSolicitud);
          hashTiposSolicitud.put("TSP", dtoTipoSolicitudPais);        
      } else {
        throw new MareException("No se enxontraron datos para el Tipo de Solicitud " + oidTipoSolicitudPais.toString());
      }
      return hashTiposSolicitud;    
    }

     private RecordSet executeQuery(String query) throws MareException {
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.executeQuery(String query): Entrada");
        RecordSet rs = null;
        
        try {
          BelcorpService belcorpService = BelcorpService.getInstance();
          rs = belcorpService.dbService.executeStaticQuery( query );
        } catch ( Exception ex ) {
          throw new MareException( ex, 
              UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
        }       
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.executeQuery(String query): Salida");  
        return rs;
      }

      private Long bigDecimalToLong(Object numero) {
        
            if (numero != null) {
                return new Long(((BigDecimal) numero).longValue());
            } else {
                return null;
            }
        }
    
      private String objectToString(Object ob) {
               if (ob != null) {
                return (String) ob;
            } else {
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
    
    private Integer bigDecimalToInteger(Object numero) {        
            if (numero != null) {
                return new Integer(((BigDecimal) numero).intValue());
            } else {
                return null;
            }
   }
  
  
   private Long obtenerTiposDocumentoLegalReclamos(Long oidCabe) throws MareException {            
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerTiposDocumentoLegalReclamos(Long oidCabe): Entrada ");        
        StringBuffer query = new StringBuffer();
        RecordSet rs;        

        query.append(" SELECT CAB.IND_OC , FTD.TIDO_OID_TIPO_DOCU_CONT ");
        query.append(" FROM PED_SOLIC_CABEC CAB, ");
        query.append("      FAC_TIPO_DOCUM FTD ");
        query.append(" WHERE  CAB.SOCA_OID_SOLI_CABE = " + oidCabe);
      //  query.append("	  AND CAB.IND_OC = 1 ");inc de productivo SiCC 20070034
        query.append("    AND FTD.OID_TIPO_DOCU = CAB.TIDO_OID_TIPO_DOCU ");	    
        query.append("ORDER BY CAB.IND_OC DESC , CAB.VAL_NUME_SOLI ASC ");

        rs = this.executeQuery(query.toString());
        Long oidTipoDocumentoConta = null;
        if (!rs.esVacio()) {
           if(rs.getValueAt(0,"TIDO_OID_TIPO_DOCU_CONT")!=null){
                oidTipoDocumentoConta = this.bigDecimalToLong(rs.getValueAt(0,"TIDO_OID_TIPO_DOCU_CONT"));
           }
        }
        UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerTiposDocumentoLegalReclamos(Long oidCabe): Salida ");
        return oidTipoDocumentoConta;
    }  

    private Long obtenerTipoDocumentoLegal(Long oidDocu) throws MareException {
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerTipoDocumentoLegal(Long oidDocu): Entrada ");        
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      
      query.append(" SELECT MTD.TIDO_OID_TIPO_DOCU ");
      query.append(" FROM MAE_TIPO_DOCUM MTD ");
      query.append(" WHERE MTD.OID_TIPO_DOCU = " + oidDocu);
    
      rs = this.executeQuery(query.toString());
      
      Long oidTipoDocumentoLegal = null;
      
      if (!rs.esVacio()) {
          oidTipoDocumentoLegal = this.bigDecimalToLong(rs.getValueAt(0,"TIDO_OID_TIPO_DOCU"));
      }
      
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerTipoDocumentoLegal(Long oidDocu): Salida ");        
      return oidTipoDocumentoLegal;
    }
    
    private DTOTipoSolicitudProceso obtenerDatosTipoSolicitudProceso(Long oidOperacion, Long oidTipoSol) throws MareException {
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerDatosTipoSolicitudProceso(Long oidOperacion, Long oidTipoSol): Entrada ");        
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      
      query.append(" SELECT TSP.TPOS_OID_TIPO_POSI, ");
	    query.append("      TSP.STPO_OID_SUBT_POSI, ");
	    query.append("      TSP.IND_PROD, ");
	    query.append("      TSP.PROD_OID_PROD ");
      query.append(" FROM PED_TIPO_SOLIC_PROCE TSP ");
      query.append(" WHERE TSP.OPER_OID_OPER = " + oidOperacion);
      query.append("   AND TSP.TSPA_OID_TIPO_SOLI_PAIS = " + oidTipoSol);
      
      rs = this.executeQuery(query.toString());
      
      DTOTipoSolicitudProceso dtoTipoSolicitudProceso = null;
      if (!rs.esVacio()){
          dtoTipoSolicitudProceso = new DTOTipoSolicitudProceso ();
          dtoTipoSolicitudProceso.setTipoPosicion(this.bigDecimalToLong(rs.getValueAt(0,"TPOS_OID_TIPO_POSI")));
          dtoTipoSolicitudProceso.setSubtipoPosicion(this.bigDecimalToLong(rs.getValueAt(0,"STPO_OID_SUBT_POSI")));
          dtoTipoSolicitudProceso.setIndProducto(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_PROD")));
          dtoTipoSolicitudProceso.setOidProducto(this.bigDecimalToLong(rs.getValueAt(0,"PROD_OID_PROD")));
      }
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerDatosTipoSolicitudProceso(Long oidOperacion, Long oidTipoSol): Salida ");        
      return dtoTipoSolicitudProceso;
    } 

    
   /**@Author: Hugo Mansi
    * @Date: 31/10/2006
    * Description: Este método devuelve el oid de la dirección principal 
    * del cliente para la unidad administrativa activa del mismo
    * Si no encuentra registro se lanza MareException
    **/
   
    private Long obtenerDireccionPrincipalUAActiva(Long oidCliente) throws MareException{
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerDireccionPrincipalUAActiva(Long oidCliente): Entrada ");        
      StringBuffer query = new StringBuffer();
      RecordSet rs;
      query.append(" 	SELECT cd.OID_CLIE_DIRE	  ");
      query.append(" 	  FROM mae_clien_direc cd, 	  ");
      query.append(" 	       zon_terri_admin ta, 	  ");
      query.append(" 	       mae_clien_unida_admin ua	  ");
      query.append(" 	 WHERE cd.clie_oid_clie = " + oidCliente);
      query.append(" 	   AND cd.ind_dire_ppal = 1	  ");
      query.append("     AND cd.ind_elim = 0 "); //agregado por Sapaza, incidencia V_MAE_08      
      query.append(" 	   AND ua.clie_oid_clie = cd.clie_oid_clie	  ");
      query.append(" 	   AND ua.ztad_oid_terr_admi = ta.oid_terr_admi	  ");
      query.append(" 	   AND ta.terr_oid_terr = cd.terr_oid_terr	  ");
      rs = this.executeQuery(query.toString());
      Long oidDireccion = null;
      if (!rs.esVacio()){
          oidDireccion = new Long (((BigDecimal)rs.getValueAt(0,0)).longValue());
           
      }else{
       throw new MareException("No se enxontraron datos para el cliente " + oidCliente.toString());
      }
      UtilidadesLog.info("MONGenerarSolicitudModulosExternos.obtenerDireccionPrincipalUAActiva(Long oidCliente): Salida");        
      return oidDireccion;
    }

    /*
     * 
     * 
     * */



    //-----------------------------------------------------------------------

    private MONUsuariosHome getMONUsuariosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONUsuariosHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/MONUsuarios" ), MONUsuariosHome.class );
    }
}


//FIN MONGenerarSolicitudModulosExternos
