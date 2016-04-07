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


package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOActividad;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.mav.DTODatosMensaje;
import es.indra.sicc.dtos.mav.DTODetalleMAV;
import es.indra.sicc.dtos.mav.DTOEnvioIniFinPeriodo;
import es.indra.sicc.dtos.mav.DTOEnvioMAV;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.entidades.cra.ActividadLocal;
import es.indra.sicc.entidades.cra.ActividadLocalHome;
import es.indra.sicc.entidades.mav.EnvioMAVLocal;
import es.indra.sicc.entidades.mav.EnvioMAVLocalHome;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocal;
import es.indra.sicc.entidades.mav.ParametrizacionMAVLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividad;
import es.indra.sicc.logicanegocio.cra.MONMantenimientoActividadHome;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONClientesHome;
import es.indra.sicc.logicanegocio.mav.MONRegistroMAV;
import es.indra.sicc.logicanegocio.mav.MONRegistroMAVHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.mav.MONGenerarMensajesHome;
import es.indra.sicc.logicanegocio.mav.MONGenerarMensajes;

import es.indra.sicc.logicanegocio.mav.MONBusinessPlanning;
import es.indra.sicc.logicanegocio.mav.MONBusinessPlanningHome;

import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Date;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
public class MONEnvioIniFinPeriodoBean implements SessionBean {
    private SessionContext ctx = null;

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

    private static long fechaFict;

    private static long getFechaFict() {
      if(fechaFict==0){
       GregorianCalendar cal = new GregorianCalendar();
       cal.set(1900,0,1,0,0,0);
       fechaFict = cal.getTime().getTime();
      }
      return fechaFict;
    }


    /*
     * 2/6/2005 - rgiorgi: inc. 18835
     * */
    public void procesarEnvioIniFinPeriodoCierre(DTOFACProcesoCierre dtoProcesoCierre) throws MareException {
    
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoCierre(DTOFACProcesoCierre dtoProcesoCierre):Entrada");
        MareDTO dto = new MareDTO();

        dto.addProperty(ConstantesCRA.DATO_MARCA, dtoProcesoCierre.getMarca());
        dto.addProperty(ConstantesCRA.DATO_CANAL, dtoProcesoCierre.getCanal());
        dto.addProperty(ConstantesCRA.DATO_PAIS, dtoProcesoCierre.getOidPais());
        dto.addProperty(ConstantesCRA.DATO_PERIODO, dtoProcesoCierre.getPeriodo());
        dto.addProperty(ConstantesCRA.DATO_ZONA, dtoProcesoCierre.getZona());
        dto.addProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_FAC));

        this.procesarEnvioIniFinPeriodo(dto);
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoCierre(DTOFACProcesoCierre dtoProcesoCierre):Salida");
    }

  /**
   * 19-06-2007    modificado por Sapaza, incidencia SiCC-20070288. El modulo MAV ejecutara este proceso
   *               en batch, que es ejecutado desde pantalla. Se filtra los detalles MAV y Envios MAV
   *               por actividades MAV
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoin
   */
    public void procesarEnvioIniFinPeriodo(MareDTO dtoin) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodo(MareDTO dtoin):Entrada");
        MareDTO dto = new MareDTO();
        ArrayList actividadesMAV = new ArrayList();
        
        try {
            if (dtoin instanceof DTOFACProcesoCierre){
                //Vengo del cierre
                DTOFACProcesoCierre dtoProcesoCierre = (DTOFACProcesoCierre)dtoin; 
                dto.addProperty(ConstantesCRA.DATO_MARCA, dtoProcesoCierre.getMarca());
                dto.addProperty(ConstantesCRA.DATO_CANAL, dtoProcesoCierre.getCanal());
                dto.addProperty(ConstantesCRA.DATO_PAIS, dtoProcesoCierre.getOidPais());
                dto.addProperty(ConstantesCRA.DATO_PERIODO, dtoProcesoCierre.getPeriodo());
                dto.addProperty(ConstantesCRA.DATO_ZONA, dtoProcesoCierre.getZona());
                dto.addProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_FAC));
            }else if (dtoin instanceof DTOEnvioIniFinPeriodo){
                //Vengo de pantalla MAV
                DTOEnvioIniFinPeriodo dtoEnvioIniFinPeriodo = (DTOEnvioIniFinPeriodo)dtoin; 
                dto.addProperty(ConstantesCRA.DATO_MARCA, dtoEnvioIniFinPeriodo.getMarca());
                dto.addProperty(ConstantesCRA.DATO_CANAL, dtoEnvioIniFinPeriodo.getCanal());
                dto.addProperty(ConstantesCRA.DATO_PAIS, dtoEnvioIniFinPeriodo.getOidPais());
                dto.addProperty(ConstantesCRA.DATO_PERIODO, dtoEnvioIniFinPeriodo.getPeriodo());
                dto.addProperty(ConstantesCRA.DATO_ZONA, null);
                dto.addProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_MAV));
                actividadesMAV = dtoEnvioIniFinPeriodo.getActividades();
            }else{
                //Vengo de Quartz
                dto = dtoin;
            }
            //Primero obtenemos los argumentos de entrada: 
            RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor();
            Long marca = new Long(dto.getLong(ConstantesCRA.DATO_MARCA));
            Long canal = new Long(dto.getLong(ConstantesCRA.DATO_CANAL));
            Long pais = new Long(dto.getLong(ConstantesCRA.DATO_PAIS));
            Long periodo = new Long(dto.getLong(ConstantesCRA.DATO_PERIODO));
            Long zona = null;
            Long oidIdioma = recuperadorIdioma.getIdiomaDefectoServidor();

            try {
                zona = new Long(dto.getLong(ConstantesCRA.DATO_ZONA));
            } catch (NullPointerException npe) {
                UtilidadesLog.debug("[MAV][procesarEnvioIniFinPeriodo] zona nula.");
            } catch (NoSuchElementException e) {
                UtilidadesLog.debug("[MAV][procesarEnvioIniFinPeriodo] zona nula.");
            }

            Long modulo = new Long(dto.getLong(ConstantesCRA.DATO_MODULO));
            UtilidadesLog.debug("Modulo: "+modulo);
            UtilidadesLog.debug("ActividadesMAV: "+actividadesMAV);

            MONValidacionHome monValidacionHome = this.getMONValidacionHome();
            MONValidacion monValidacion = monValidacionHome.create();
            Boolean correcto = monValidacion.validarVinculos(pais, null, marca, canal, null, null);

            if (correcto.booleanValue()) {
                DAOEnvioIniFinPeriodo daoEnvioIniFinPeriodo = new DAOEnvioIniFinPeriodo();
                RecordSet rRetorno = 
                        daoEnvioIniFinPeriodo.obtenerCondicionesNoEvaluadas(modulo, 
                                                                            periodo,
                                                                            marca,
                                                                            pais,
                                                                            canal,
                                                                            actividadesMAV);
                UtilidadesLog.debug("rRetorno (DetallesMAV): " + rRetorno);
                // Agregado por ssantana, 23/8/2005
                MONRegistroMAVHome monRegistroMAVHome = this.getMONRegistroMAVHome();
                MONBusinessPlanningHome monBPHome = this.getMONBusinessPlanningHome();
                MONBusinessPlanning monBP = monBPHome.create();
                DTOOID dtoOid = null;
                
                if (!rRetorno.esVacio() ) {
                  int cantReg = rRetorno.getRowCount();
                  DTODetalleMAV dtoCondicion = null;
                  for (int i = 0; i<cantReg; i++) { 
                      UtilidadesLog.debug("Bucle " + i);
                      Long oidDetalleMAV = Long.valueOf(rRetorno.getValueAt(i,0).toString());
                      UtilidadesLog.debug("--- DetalleMAV " + oidDetalleMAV);
                      
                      // Modificado por ssantana, 23/8/2005
                      // Se obtienen TODOS los datos inherentes al DetalleMAV.
                      dtoOid = new DTOOID();
                      dtoOid.setOidPais(pais);
                      dtoOid.setOid(oidDetalleMAV);
                      
                      dtoCondicion = monBP.obtieneDetalleMAV(dtoOid);
                      // Fin Modificacion por ssantana, 23/8/2005
                      
                      dtoCondicion.setOidPais(pais);
                      dtoCondicion.setMarca(marca);
                      dtoCondicion.setCanal(canal);
  
                      // Agregado por ssantana, inc. 15618
                      MONRegistroMAV monRegistroMAV = monRegistroMAVHome.create();
                      dtoCondicion = monRegistroMAV.comprobarCodigoVenta(dtoCondicion, periodo);
                      // Fin Agregado por ssantana, inc. 15618
                      DTOEnvioMAV[] dtoEnviosMAV = daoEnvioIniFinPeriodo.obtenerClienteCondicion(dtoCondicion, periodo);
                      Long oidCodigoVenta = dtoCondicion.getCodigoVenta();
                      Long oidCliente = null;
                      for (int j = 0;
                              (dtoEnviosMAV != null) && (j < dtoEnviosMAV.length);
                              ++j) {
                          DTOEnvioMAV dtoEnvioCliente = dtoEnviosMAV[j];
                          //EnvioMAVLocalHome envioMAVLocalHome = this.getEnvioMAVLocalHome();
                          oidCliente = dtoEnvioCliente.getOidCliente();
                          UtilidadesLog.debug("      --- Procesa Cliente " +oidCliente + " ---");
                          UtilidadesLog.debug(" Busca envio con... ");
                          UtilidadesLog.debug("  - Cliente: " + oidCliente);
                          UtilidadesLog.debug("  - DetalleMAV: " + dtoEnvioCliente.getOidDetalle());
                          UtilidadesLog.debug("  - CodigoVenta: " + oidCodigoVenta);
                          
                          /*Collection envioMAVCollection = 
                               envioMAVLocalHome.findByClienteDetalleMatriz(oidCliente,
                                                                           dtoEnvioCliente.getOidDetalle(),
                                                                            oidCodigoVenta);*/
                            if (!existeEnvioClienteDetalleMatriz(oidCliente, dtoEnvioCliente.getOidDetalle(),
                                                                            oidCodigoVenta)){
                           /*if ((envioMAVCollection == null) || 
                                      (envioMAVCollection.size() == 0)) {*/
                              // Agregado por ssantana, inc. 15618
                              dtoEnvioCliente.setOidMatrizFact(oidCodigoVenta);
                              // FIn agregado ssantana, inc. 15618                                  
                              dtoEnvioCliente = this.obtenerClienteEnvioMAV(dtoEnvioCliente, 
                                                                            dtoCondicion, 
                                                                            periodo);
                              if (dtoEnvioCliente != null) {
                                 UtilidadesLog.debug("Se genera Envio para este cliente");
                                 this.insertarEnvioMAV(dtoEnvioCliente);    
                              } else {
                                 UtilidadesLog.debug("No se genera Envio para este Cliente");
                              }
                           } else {
                              UtilidadesLog.debug("Se encontro Envio existente, no se genera Envio");
                           }
                      }
                  }
                }

                //fin Para cada "dtoCondicion" encontrado en dtoCondicionesDetalle
                UtilidadesLog.debug("Idioma: " + oidIdioma);
                this.generarSolicitudCliente(pais, 
                                             modulo, 
                                             periodo, 
                                             marca, 
                                             canal, 
                                             oidIdioma,
                                             actividadesMAV);
                UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodo(MareDTO dtoin):Salida");
            } else {
                //mostrar el mensaje GEN-0030
                throw new MareException(new Exception(), 
                                        UtilidadesError.armarCodigoError(CodigosError.ERROR_VINCULOS_INVALIDOS));
            }
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
    }
    
    private boolean existeEnvioClienteDetalleMatriz(Long cliente, Long detalle, Long matriz) throws MareException{
        StringBuffer sb = new StringBuffer();
        sb.append(" select count(*) from MAV_ENVIO M ");
        sb.append(" where M.CLIE_OID_CLIE = "+cliente);
        sb.append(" and m.DENV_OID_DETA_MAV = "+detalle);
        sb.append(" and m.MAFA_OID_MATR_FACT = "+matriz);
        RecordSet r = null;
        
        try{
            r = BelcorpService.getInstance().dbService.executeStaticQuery(sb.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        if (r==null || r.getValueAt(0,0).toString().equals("0")){
            return false;
        }else{
            return true;
        }
    }

    private DTOEnvioMAV obtenerClienteEnvioMAV(DTOEnvioMAV dtoEnvioCliente, DTODetalleMAV dtoCondicion, Long periodo) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.obtenerClienteEnvioMAV(DTOEnvioMAV dtoEnvioCliente, DTODetalleMAV dtoCondicion, Long periodo):Entrada");
        try {
            // 5/4/2005 - ssantana - Inc. MAV-12 PERU (15881)
            // Se obtiene la UA del cliente para luego obtener la Zona.
             /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */
             /*MONClientesHome monClientesHome = this.getMONClientesHome();
             MONClientes clientes = monClientesHome.create();*/
             /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */

            Long oidCliente = dtoEnvioCliente.getOidCliente();
            /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */
            //DTOUnidadAdministrativa unidadAdministrativa = clientes.obtenerUnidadAdministrativa(oidCliente, periodo);
            /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */
            /* Agregado por SiCC20080750 ----- 06/10/2008 ------ AL */
            DAOEnvioIniFinPeriodo daoActivo = new DAOEnvioIniFinPeriodo();
            DTOUnidadAdministrativa unidadAdministrativa = daoActivo.obtenerUnidadAdministrativa(oidCliente, periodo);
            /* Agregado por SiCC20080750 ----- 06/10/2008 ------ AL */
            UtilidadesLog.debug("unidadAdministrativa: " + unidadAdministrativa);
            if (unidadAdministrativa == null) {
                UtilidadesLog.debug("No se encontró Unidad Administrativa para Cliente " + oidCliente);
                UtilidadesLog.debug(" - periodo " + periodo + " --- Se retorna NULL");
                dtoEnvioCliente = null;
            } else {
                Long oidZona = unidadAdministrativa.getOidZona();
                Date fechaEntrega = this.obtenerFechaEntrega(periodo, oidZona);
                dtoEnvioCliente.setFechaEntrega(((fechaEntrega != null) ? new Timestamp(fechaEntrega.getTime()) : null));
                dtoEnvioCliente.setOidActividad(dtoCondicion.getActividad());
                dtoEnvioCliente.setNumeroUnidades((dtoCondicion.getUnidadesPorCliente() != null) ? new Long(dtoCondicion.getUnidadesPorCliente().longValue()) : null);
                dtoEnvioCliente.setOidFormaCobro(dtoCondicion.getFormaCobro());
    
                if (dtoEnvioCliente.getOidFormaCobro() == ConstantesMAV.FORMA_COBRO_FACTURADO) {
                    dtoEnvioCliente.setOidFormaPago(dtoCondicion.getFormaPago());
                } else {
                    dtoEnvioCliente.setOidFormaPago(null);
                }
    
                dtoEnvioCliente.setOidActividadTipoDespacho(dtoCondicion.getTipoDespacho());
    
                ParametrizacionMAVLocalHome parametrizacionHome = new ParametrizacionMAVLocalHome();
                ParametrizacionMAVLocal parametrizacion = parametrizacionHome.findByUK(dtoCondicion.getOidPais());
    
                if (parametrizacion.getRequerirAutorizacion().booleanValue() &&
                          (dtoEnvioCliente.getOidFormaCobro() != ConstantesMAV.FORMA_COBRO_GRATIS)) {
                    dtoEnvioCliente.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                } else {
                    if ((dtoCondicion.getPrecioEstandar() != null) && 
                          (dtoCondicion.getPrecio().doubleValue() > parametrizacion.getLimitePrecioAutorizacion().doubleValue())) {
                        dtoEnvioCliente.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_PENDIENTE);
                    } else {
                        dtoEnvioCliente.setTipoEstadoEnvio(ConstantesMAV.ESTADO_ENVIO_SIN_AUTORIZACION);
                    }
                }
    
                dtoEnvioCliente.setIndEnvio(ConstantesMAV.INDICADOR_PENDIENTE_ENVIO.toString());
                dtoEnvioCliente.setOidSolicitudEnvio(ConstantesMAV.ENVIO_SOLICITUD_TODAS); //aunque en este caso de uso no se va a consultar 
                dtoEnvioCliente.setPrecioEstandar((dtoCondicion.getPrecioEstandar() != null) ? new BigDecimal(dtoCondicion.getPrecioEstandar().doubleValue()) : null);
                dtoEnvioCliente.setPrecio((dtoCondicion.getPrecio() != null) ? new BigDecimal(dtoCondicion.getPrecio().doubleValue()) : null);
                dtoEnvioCliente.setPrecioContable((dtoCondicion.getPrecioContable() != null) ? new BigDecimal(dtoCondicion.getPrecioContable().doubleValue()) : null);
                dtoEnvioCliente.setOidMatrizFact(dtoCondicion.getCodigoVenta());
                
                /*
                 * Agregado por ssantana, 06/03/2006, inc. 22717
                 */
                dtoEnvioCliente.setOidMensaje(dtoCondicion.getMensaje());
                /*
                 * Fin Agregado por ssantana, 06/03/2006, inc. 22717
                 */
            }            
            UtilidadesLog.info("MONEnvioIniFinPeriodoBean.obtenerClienteEnvioMAV(DTOEnvioMAV dtoEnvioCliente, DTODetalleMAV dtoCondicion, Long periodo):Salida");
            return dtoEnvioCliente;
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */
        /*} catch (RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }*/
        /* Eliminado por SiCC20080750 ----- 06/10/2008 ------ AL */
    }

  /**
   * 14-06-2007   modificado por Sapaza, incidencia SiCC-20070306. Se procesa la 
   *              ultima combinacion cliente, fechaEntrega.
   * 27-06-2007   modificado por Sapaza, incidencia SiCC-20070310. Se añade la actividad
   *              como combinacion para crear solicitudes de pedido.
   * @throws es.indra.mare.common.exception.MareException
   * @param actividadesMAV
   * @param oidIdioma
   * @param canal
   * @param marca
   * @param periodo
   * @param modulo
   * @param pais
   */
    private void generarSolicitudCliente(Long pais, Long modulo, 
                                         Long periodo, Long marca, 
                                         Long canal, Long oidIdioma,
                                         ArrayList actividadesMAV) throws MareException {
      UtilidadesLog.info("MONEnvioIniFinPeriodoBean.generarSolicitudCliente(Long pais, Long modulo, Long periodo, Long marca, Long canal):Entrada");
      try {
        DAOEnvioIniFinPeriodo daoEnvio = new DAOEnvioIniFinPeriodo();
        RecordSet r = null;
        //DTOEnvioSolicitudCliente[] dtoSolicitudes = null;
        MONGenerarSolicitudModulosExternosHome monGenSolExtHome = this.getMONGenerarSolicitudModulosExternosHome();
        MONGenerarSolicitudModulosExternos monGenSolExt = monGenSolExtHome.create();
        MONGenerarMensajesHome monGenerarMensajesHome = this.getMONGenerarMensajesHome();
        MONGenerarMensajes monGenerarMensajes = monGenerarMensajesHome.create();

        //19-06-2007, modificado por incidencia SiCC-20070288 (Sapaza), se agrega lista de actividades MAV
        r = daoEnvio.obtenerDatosSolicitudCliente(pais, modulo, periodo, actividadesMAV);        
        //UtilidadesLog.debug("r: " + r);
        
        if (!r.esVacio()) {
            int n = r.getRowCount();
            //lo primero que se hace es poner un valor fictisio
            //a la fecha de entrega que se usa para agrupar.
            for(int i=0; i<n; i++) {
                if(r.getValueAt(i,1)==null) {
                    r.setValueAt(new java.sql.Date(getFechaFict()),i,1);
                }
            }
            Vector vDTOPosicion = new Vector();
            Vector vFila = null;
            Vector vOidsEnvioMAV = new Vector();
            //DTOPosicionSolicitud dtoPosicion = null;
            //DTOCabeceraSolicitud dtoCabecera = null;
            DTODatosMensaje dtoDatosMensaje = null;
            DTOBuzonMensajes dtoBuzon = null;
            //DTOOID dtoOid = null;
            DTOOIDs dtoOidsEnvioMAV = new DTOOIDs();
            Long clienteActual = Long.valueOf(r.getValueAt(0,0).toString());
            Long clienteAnterior = Long.valueOf(r.getValueAt(0,0).toString());
            Long oidEnvioTemp = null;
            Long numSecuencial = null;
            
            Vector vectorCabeceras = new Vector();
            Vector agrupados = new Vector();
            
            
            java.sql.Date fechaEntregaActual = (java.sql.Date)r.getValueAt(0,1);
            java.sql.Date fechaEntregaAnterior = (java.sql.Date)r.getValueAt(0,1);

            //27-06-2007, modificado por incidencia SiCC-20070310 (Sapaza), se agrega filtro a la actividad MAV              
            Long actividadActual = Long.valueOf(r.getValueAt(0,8).toString());
            Long actividadAnterior = Long.valueOf(r.getValueAt(0,8).toString());
            //Long detalleMAVActual = Long.valueOf(r.getValueAt(0,7).toString());
            //Long detalleMAVAnterior = Long.valueOf(r.getValueAt(0,7).toString());
            StringBuffer sb = new StringBuffer();
            for (int i = 0 ;  i < n ; i++ ){
                clienteActual = Long.valueOf(r.getValueAt(i,0).toString());
                fechaEntregaActual = (java.sql.Date) r.getValueAt(i,1);
                actividadActual = Long.valueOf(r.getValueAt(i,8).toString());
                
                if (clienteActual.equals(clienteAnterior) && fechaEntregaActual.equals(fechaEntregaAnterior)
                    && actividadActual.equals(actividadAnterior)){
                    vFila = r.getRow(i);    
                    oidEnvioTemp = Long.valueOf(r.getValueAt(i,2).toString());
                    vOidsEnvioMAV.add(oidEnvioTemp);
                    // Obtengo el DTOPosicion 
                    DTOPosicionSolicitud dtoPosicion = this.generaDTOPosicion(vFila);
                    // Obtengo el DTODatosMensaje 
                    dtoDatosMensaje = this.manejoMensaje(vFila, pais, canal, marca);
                    UtilidadesLog.debug("dtoDatosMensaje: " + dtoDatosMensaje);
                    numSecuencial = null;
                    if (dtoDatosMensaje != null ) {
                        // Genero el Mensaje, si aplica 
                        dtoBuzon = monGenerarMensajes.generarMensaje(dtoDatosMensaje);
                        numSecuencial = dtoBuzon.getNumeroSecuencial();
                    }
                    //this.actualizarEnvioMAV(oidEnvioTemp, numSecuencial);
                    sb.append(this.generaActualizarEnvioMAV(oidEnvioTemp, numSecuencial));
                    vDTOPosicion.add(dtoPosicion);
                }else{
                    i--;
                    BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", sb.toString());
                    sb = new StringBuffer();
                    clienteAnterior = clienteActual;
                    fechaEntregaAnterior = fechaEntregaActual;
                    actividadAnterior = actividadActual;
                    DTOCabeceraSolicitud dtoCabecera = this.generaDTOCabecera(vFila, 
                                                          pais,
                                                          periodo,
                                                          marca,
                                                          canal,
                                                          vDTOPosicion);
                     dtoCabecera.setOidIdioma(oidIdioma);
                     UtilidadesLog.info("Cabecera "+(vectorCabeceras.size()+1)+" con posiciones solicitud en MAV: "+vDTOPosicion.size());
                     vectorCabeceras.add(dtoCabecera);
                     vDTOPosicion.clear();
                     Long[] arrayOidsEnvios = (Long[])vOidsEnvioMAV.toArray(new Long[vOidsEnvioMAV.size()]);
                     dtoOidsEnvioMAV = new DTOOIDs();
                     dtoOidsEnvioMAV.setOids(arrayOidsEnvios);
                     agrupados.add(dtoOidsEnvioMAV);
                     vOidsEnvioMAV.clear();
                }
            }
            
            //14-07-2007, agregado por Sapaza, incidencia SiCC-20070306
            //se procesa laultima combinacion cliente, fechaEntrega
            if(vDTOPosicion.size() > 0) {
                UtilidadesLog.info("Ultima Agrupacion ");
                BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", sb.toString());
                DTOCabeceraSolicitud dtoCabecera = this.generaDTOCabecera(vFila, 
                                                      pais,
                                                      periodo,
                                                      marca,
                                                      canal,
                                                      vDTOPosicion);
                 dtoCabecera.setOidIdioma(oidIdioma);
                 UtilidadesLog.info("Cabecera "+(vectorCabeceras.size()+1)+" con posiciones solicitud en MAV: "+vDTOPosicion.size());
                 vectorCabeceras.add(dtoCabecera);
                 vDTOPosicion.clear();
                 
                 Long[] arrayOidsEnvios = (Long[])vOidsEnvioMAV.toArray(new Long[vOidsEnvioMAV.size()]);
                 dtoOidsEnvioMAV = new DTOOIDs();
                 dtoOidsEnvioMAV.setOids(arrayOidsEnvios);
                 agrupados.add(dtoOidsEnvioMAV);
                 vOidsEnvioMAV.clear();
            }
            
            /*          
           
           while (i < n) {
              while (i<n && clienteActual.equals(clienteAnterior))  {
                  //vectorCabeceras.clear();
                  //agrupados.clear();
                  while (i<n && clienteActual.equals(clienteAnterior) && (fechaEntregaActual!=null &&
                                        fechaEntregaActual.equals(fechaEntregaAnterior))) {
                                        
                     clienteActual = Long.valueOf(r.getValueAt(i,0).toString());
                     fechaEntregaActual = (java.sql.Date) r.getValueAt(i,1);
                     //detalleMAVActual = Long.valueOf(r.getValueAt(i,7).toString());
                     StringBuffer sb = new StringBuffer();
                     while (i<n && clienteActual.equals(clienteAnterior) && (fechaEntregaActual!=null &&
                                          fechaEntregaActual.equals(fechaEntregaAnterior)) && 
                                          detalleMAVActual.equals(detalleMAVAnterior/) {
                         clienteActual = Long.valueOf(r.getValueAt(i,0).toString());
                         fechaEntregaActual = (java.sql.Date) r.getValueAt(i,1);
                         //detalleMAVActual = Long.valueOf(r.getValueAt(i,7).toString());                
                         if ((i<n && clienteActual.equals(clienteAnterior) && 
                                              (fechaEntregaActual!=null && fechaEntregaActual.equals(fechaEntregaAnterior)) && 
                                              detalleMAVActual.equals(detalleMAVAnterior)) || i == n) {
                            vFila = r.getRow(i);
                            oidEnvioTemp = Long.valueOf(r.getValueAt(i,2).toString());
                            vOidsEnvioMAV.add(oidEnvioTemp);
                            // Obtengo el DTOPosicion 
                            DTOPosicionSolicitud dtoPosicion = this.generaDTOPosicion(vFila);
                            // Obtengo el DTODatosMensaje 
                            dtoDatosMensaje = this.manejoMensaje(vFila, pais, canal, marca);
                            UtilidadesLog.debug("dtoDatosMensaje: " + dtoDatosMensaje);
                            numSecuencial = null;
                            if (dtoDatosMensaje != null ) {
                                // Genero el Mensaje, si aplica 
                                dtoBuzon = monGenerarMensajes.generarMensaje(dtoDatosMensaje);
                                numSecuencial = dtoBuzon.getNumeroSecuencial();
                            }
                            //this.actualizarEnvioMAV(oidEnvioTemp, numSecuencial);
                            sb.append(this.generaActualizarEnvioMAV(oidEnvioTemp, numSecuencial));
                            vDTOPosicion.add(dtoPosicion);
                            i++;                                                        
                        }
                     }
                     BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", sb.toString());
                     sb = null;
                     clienteAnterior = clienteActual;
                     fechaEntregaAnterior = fechaEntregaActual;
                     //detalleMAVAnterior = detalleMAVActual;
                     DTOCabeceraSolicitud dtoCabecera = this.generaDTOCabecera(vFila, 
                                                          pais,
                                                          periodo,
                                                          marca,
                                                          canal,
                                                          vDTOPosicion);
                     dtoCabecera.setOidIdioma(oidIdioma);
                     UtilidadesLog.info("Cabecera "+(vectorCabeceras.size()+1)+" con posiciones solicitud en MAV: "+vDTOPosicion.size());
                     vectorCabeceras.add(dtoCabecera);
                     vDTOPosicion.clear();
                     Long[] arrayOidsEnvios = (Long[])vOidsEnvioMAV.toArray(new Long[vOidsEnvioMAV.size()]);
                     dtoOidsEnvioMAV = new DTOOIDs();
                     dtoOidsEnvioMAV.setOids(arrayOidsEnvios);
                     agrupados.add(dtoOidsEnvioMAV);
                     vOidsEnvioMAV.clear();
                     
                 }
                 //vectorCabeceras=new Vector();
                 //vOidsEnvioMAV = new Vector();
                 //vDTOPosicion = new Vector();
                 //agrupados = new Vector();
             }
          }*/
         
             UtilidadesLog.debug("Enviando Cabeceras Solicitud, en total: "+vectorCabeceras.size()); 
             vectorCabeceras = monGenSolExt.generarSolicitudes(vectorCabeceras);
             int largo = vectorCabeceras.size();
             UtilidadesLog.debug("Se han recibido un total de Cabeceras Solicitud desde PED: "+largo);
             for(int posicion = 0; posicion<largo;posicion++){
                 DTOCabeceraSolicitud cabeceratemp= (DTOCabeceraSolicitud)vectorCabeceras.get(posicion);
                 if(cabeceratemp.getOidCabeceraSolicitud()!=null) {
                    this.insertarSolicitudEnvioMAV(cabeceratemp.getOidCabeceraSolicitud(), 
                                                    (DTOOIDs)agrupados.get(posicion) );
                 }
             }
          
        } 
      } catch (NamingException nEx) {
         nEx.printStackTrace();
         UtilidadesLog.error(nEx);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(nEx, UtilidadesError.armarCodigoError(sCodigoError) );
      } catch (RemoteException rEx) {
         rEx.printStackTrace();
         UtilidadesLog.error(rEx);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(rEx, UtilidadesError.armarCodigoError(sCodigoError) );
      } catch (CreateException cEx) {
         cEx.printStackTrace();
         UtilidadesLog.error(cEx);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(cEx, UtilidadesError.armarCodigoError(sCodigoError) );
      } catch (MareException mEx) {
         throw mEx;
      } catch (Exception ex) {
         ex.printStackTrace();
         UtilidadesLog.error(ex);
         String sCodigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
         throw new MareException(ex, UtilidadesError.armarCodigoError(sCodigoError) );
      }
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.generarSolicitudCliente(Long pais, Long modulo, Long periodo, Long marca, Long canal):Salida");
}


    private void actualizarEnvioMAV(Long oidEnvio, Long numSecuencia) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.actualizarEnvioMAV(Long oidEnvio, Long oidBuzon):Entrada");
        try {
            EnvioMAVLocalHome envioHome = new EnvioMAVLocalHome();
            EnvioMAVLocal envio = envioHome.findByPrimaryKey(oidEnvio);

            envio.setNumeroSecuencia(numSecuencia); //puede ser nulo 
            envio.setIndicadorEnvio(ConstantesMAV.INDICADOR_ENVIADO);
            envioHome.merge(envio);
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.actualizarEnvioMAV(Long oidEnvio, Long oidBuzon):Salida");
    }    
    
    private StringBuffer generaActualizarEnvioMAV(Long oidEnvio, Long numSecuencia) throws MareException {
        StringBuffer sb = new StringBuffer();
        sb.append("UPDATE MAV_ENVIO M SET ");
        if (numSecuencia!=null){
            sb.append(" M.NUM_SECU = "+numSecuencia+" ,");
        }
        sb.append(" M.IND_ENVI = '"+ConstantesMAV.INDICADOR_ENVIADO.toString()+"' ");
        sb.append(" WHERE M.OID_ENVI = "+oidEnvio);
        sb.append(";");
        return sb;
    }  

    private void insertarSolicitudEnvioMAV(Long oidSolicitudCabecera, DTOOIDs oidsEnvioMAV) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.insertarSolicitudEnvioMAV(Long oidSolicitudCabecera, DTOOIDs oidsEnvioMAV):Entrada");
        try {
            //SolicitudEnvioMAVLocalHome solicitudHome = this.getSolicitudEnvioMAVLocalHome();
            //solicitudHome.parametrosAuditoria(oidsEnvioMAV);
            String insert = "insert into MAV_SOLIC_ENVIO (soca_oid_soli_cabe, ind_gene, oid_soli_envi, menv_oid_envi) "+
                            " values ("+oidSolicitudCabecera.toString()+", 1, ";
            for (int i = 0; i < oidsEnvioMAV.getOids().length; ++i) {
                //SolicitudEnvioMAVLocal solicitud = solicitudHome.create(oidsEnvioMAV.getOids()[i], oidSolicitudCabecera);
                //solicitud.setGenerada(new Boolean(true));
                StringBuffer buff = new StringBuffer(insert);
                buff.append(SecuenciadorOID.obtenerSiguienteValor("MAV_SOEN_SEQ")+", ");
                buff.append(oidsEnvioMAV.getOids()[i]+" ) ");
                UtilidadesLog.info("insert: "+buff.toString());
                BelcorpService.getInstance().dbService.executeUpdate(buff.toString());
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } /*catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }*/
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.insertarSolicitudEnvioMAV(Long oidSolicitudCabecera, DTOOIDs oidsEnvioMAV):Salida");
    }


    private MONValidacionHome getMONValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONValidacionHome) PortableRemoteObject.narrow(context.lookup("MONValidacion"), MONValidacionHome.class);
    }

    private MONMantenimientoActividadHome getMONMantenimientoActividadHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONMantenimientoActividadHome) PortableRemoteObject.narrow(context.lookup("MONMantenimientoActividad"), MONMantenimientoActividadHome.class);
    }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarSolicitudModulosExternosHome) PortableRemoteObject.narrow(context.lookup("MONGenerarSolicitudModulosExternos"), MONGenerarSolicitudModulosExternosHome.class);
    }

    private MONGestionMensajesHome getMONGestionMensajesHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGestionMensajesHome) PortableRemoteObject.narrow(context.lookup("MONGestionMensajes"), MONGestionMensajesHome.class);
    }


    public void insertarEnvioMAV(DTOEnvioMAV DTOE) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.insertarEnvioMAV(DTOEnvioMAV DTOE):Entrada");
        try {
            EnvioMAVLocalHome envioHome = new EnvioMAVLocalHome();

            UtilidadesLog.debug(" DTOEnvioMAV a insertar: " + DTOE);

            Double precioEstandar = ((DTOE.getPrecioEstandar() != null) ? new Double(DTOE.getPrecioEstandar().doubleValue()) : null);
            Double precio = ((DTOE.getPrecio() != null) ? new Double(DTOE.getPrecio().doubleValue()) : null);
            Double precioContable = ((DTOE.getPrecioContable() != null) ? new Double(DTOE.getPrecioContable().doubleValue()) : null);
            Character indicadorEnvio = ((DTOE.getIndEnvio() != null) ? new Character(DTOE.getIndEnvio().charAt(0)) : null);

            /* ejbCreate(
             *   Long numeroUnidades,
             *   Double precioEstandar,
             *   Double precio,
             *   Double precioContable,
             *   Long oidDetalleMAV,
             *   Long oidMatrizFacturacion,
             *   Long oidCliente,
             *   Long oidActividad,
             *   Long oidEstadoEnvio,
             *   Long oidFormaCobro,
             *   Long oidTipoDespacho,
             *   Character indicadorEnvio) 
             *   */

            // Modificado by ssantana, 20/1/2005
            // Luego de DTOE.getOidCliente(), se obtiene la Actividad.
            /*EnvioMAVLocal envio = envioHome.create(DTOE.getNumeroUnidades(), 
                                                   precioEstandar, 
                                                   precio, 
                                                   precioContable, 
                                                   DTOE.getOidDetalle(), 
                                                   DTOE.getOidMatrizFact(), 
                                                   DTOE.getOidCliente(), 
                                                   DTOE.getOidActividad(), 
                                                   DTOE.getTipoEstadoEnvio(), 
                                                   DTOE.getOidFormaCobro(), 
                                                   DTOE.getOidActividadTipoDespacho(), 
                                                   indicadorEnvio);*/

            /*envio.setFechaEntrega(DTOE.getFechaEntrega());
            envio.setOidPagoFraccionado(DTOE.getOidFormaPago());*/
            
            /*
             * Agregado por ssantana, 03/03/2006, inc. 22717
             */
            /* envio.setOidBuzonMensajes(DTOE.getOidMensaje());*/
            /*
             * Fin Agregado por ssantana, 03/03/2006, inc. 22717
             */

            /* 
             * Modificado por ssantana, 03/05/2006 
             * Se usa nuevo create con todos los campos, para que se reflejen
             * en la BD los cambios al momento de crear (y no usar el atributo 
             * de transaccion en el descrpitor de la Entidad)
             */   
            UtilidadesLog.debug(" Justo antes de Insertar Envio");
             envioHome.create(DTOE.getNumeroUnidades(), 
                                                   precioEstandar, 
                                                   precio, 
                                                   precioContable, 
                                                   DTOE.getOidDetalle(), 
                                                   DTOE.getOidMatrizFact(), 
                                                   DTOE.getOidCliente(), 
                                                   DTOE.getOidActividad(), 
                                                   DTOE.getTipoEstadoEnvio(), 
                                                   DTOE.getOidFormaCobro(), 
                                                   DTOE.getOidActividadTipoDespacho(), 
                                                   indicadorEnvio,
                                                   DTOE.getFechaEntrega(),
                                                   DTOE.getOidFormaPago(),
                                                   DTOE.getOidMensaje());
             
            UtilidadesLog.debug(" Justo despues de Insertar Envio");
            
        } catch (PersistenceException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e);
        }
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.insertarEnvioMAV(DTOEnvioMAV DTOE):Salida");
    }

    public Date obtenerFechaEntrega(Long periodo, Long zona) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.obtenerFechaEntrega(Long periodo, Long zona):Entrada");
        try {
            //Crear un array dtoActi del tipo DTOActividad[]:
            DTOActividad[] dtoActi = null;

            ActividadLocalHome actividadHome = new ActividadLocalHome();
            Collection dtoActiCollection = actividadHome.findByClaseActividad(ConstantesCRA.CLASE_ACTIVIDAD_REPARTO);

            if (dtoActiCollection != null) {
                dtoActi = new DTOActividad[dtoActiCollection.size()];

                ActividadLocal actividad = null;
                Iterator it = dtoActiCollection.iterator();

                for (int i = 0; it.hasNext(); ++i) {
                    actividad = (ActividadLocal) it.next();

                    DTOActividad dto = new DTOActividad();

                    //dto.setOidActividadOrigen(actividad.getOidActividadOrigen());
                    dto.setOid(actividad.getOid());
                    dtoActi[i] = dto;
                }
            }

            if (dtoActi[0] == null) {
                dtoActi[0] = new DTOActividad();
            }

            dtoActi[0].setOidPeriodo(periodo);
            dtoActi[0].setOidZona(zona);

            MONMantenimientoActividadHome monActividadHome = this.getMONMantenimientoActividadHome();
            MONMantenimientoActividad monActividad = monActividadHome.create();
            java.util.Date fechaEntrega = monActividad.obtieneSiguienteFechaActividad(dtoActi[0]);
            java.util.Date fechaEntregaActual = null;

            for (int i = 1; i < dtoActi.length; ++i) {
                if (dtoActi[i] == null) {
                    dtoActi[i] = new DTOActividad();
                }

                dtoActi[i].setOidPeriodo(periodo);
                dtoActi[i].setOidZona(zona);
                fechaEntregaActual = monActividad.obtieneSiguienteFechaActividad(dtoActi[i]);

                //Si fechaEntregaActual < fechaEntrega 
                if ((fechaEntregaActual != null) && fechaEntregaActual.before(fechaEntrega)) {
                    fechaEntrega = fechaEntregaActual;
                }
            }
            UtilidadesLog.info("MONEnvioIniFinPeriodoBean.obtenerFechaEntrega(Long periodo, Long zona):Salida");
            return ((fechaEntrega != null) ? new Date(fechaEntrega.getTime()) : null);
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    private MONClientesHome getMONClientesHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONClientesHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONClientes"), MONClientesHome.class);
    }

    private MONRegistroMAVHome getMONRegistroMAVHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONRegistroMAVHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONRegistroMAV"), MONRegistroMAVHome.class);
    }

    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONPeriodosHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }

    /*
     * rgiorgi - 20/8/2005: mav-01
     * */
    public void procesarEnvioIniFinPeriodoCierre(MareDTO dto) throws MareException {
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoCierre(MareDTO dto):Entrada");
        if (dto instanceof DTOFACProcesoCierre) {
            DTOFACProcesoCierre dto2 = (DTOFACProcesoCierre) dto;
            dto = new MareDTO();

            if (dto2.containsKey("marca")) {
                dto.addProperty(ConstantesCRA.DATO_MARCA, dto2.getProperty("marca"));
            }

            if (dto2.containsKey("canal")) {
                dto.addProperty(ConstantesCRA.DATO_CANAL, dto2.getProperty("canal"));
            }

            if (dto2.containsKey("periodo")) {
                dto.addProperty(ConstantesCRA.DATO_PERIODO, dto2.getProperty("periodo"));
            }

            if (dto2.containsKey("zona")) {
                dto.addProperty(ConstantesCRA.DATO_ZONA, dto2.getProperty("zona"));
            }
            
            // Agregado por ssantana, 22/8/2005 - A pedido de Juan Pablo. 
            dto.addProperty("oidPais", dto2.getOidPais()); //Se agrega esto            
            // Fin Agregado por ssantana, 22/8/2005
        }

        dto.addProperty(ConstantesCRA.DATO_MODULO, new Long(ConstantesSEG.MODULO_FAC));

        this.procesarEnvioIniFinPeriodo(dto);
        UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoCierre(MareDTO dto):Entrada");
    }

  private MONBusinessPlanningHome getMONBusinessPlanningHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONBusinessPlanningHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONBusinessPlanning"), MONBusinessPlanningHome.class);
  }
  
  
  private DTOPosicionSolicitud generaDTOPosicion(Vector vFila) throws MareException {
      DTOPosicionSolicitud dtoPosicion = new DTOPosicionSolicitud();
      
      Long tipoPosicion = Long.valueOf(vFila.get(10).toString());
      Long subtipoPosicion = Long.valueOf(vFila.get(11).toString());
      String sCodigoVenta = (String)vFila.get(21);
      Long unidadesEnvio = Long.valueOf(vFila.get(3).toString());
      BigDecimal bigTipoCambio = (BigDecimal) vFila.get(25);
      BigDecimal bigPrecio = (BigDecimal) vFila.get(5);
      BigDecimal bigPrecioContable = (BigDecimal) vFila.get(4);
      BigDecimal bigPrecioEstandar = (BigDecimal) vFila.get(6);
      Long oidDetalleOferta = Long.valueOf(vFila.get(22).toString());
      Long oidProducto = Long.valueOf(vFila.get(12).toString());
      
      dtoPosicion.setTipoPosicion(tipoPosicion);
      dtoPosicion.setSubtipoPosicion(subtipoPosicion);
      dtoPosicion.setCodigoVenta(sCodigoVenta);
      dtoPosicion.setUnidadesDemandadas(new Long(0));
      dtoPosicion.setUnidadesPorAtender(unidadesEnvio);
      dtoPosicion.setUnidadesDemandaReal(unidadesEnvio);
      //Se agregan las unidades comprometidas, ya que deben ser informadas en la posicion
      dtoPosicion.setUnidadesComprometidas(unidadesEnvio);
      //--------------------------------------------------------------------------------->
      dtoPosicion.setOidDetalleOferta(oidDetalleOferta);
      dtoPosicion.setOidProducto(oidProducto);
      dtoPosicion.setProducto(oidProducto);
      
      if (bigPrecio.doubleValue() > 0){
         BigDecimal bigCero = new BigDecimal(0);
         BigDecimal bigPrecioCatalogoUnitDoc = new BigDecimal(0);
         
         if (bigTipoCambio != null && bigTipoCambio.doubleValue() > 0) {
            bigPrecioCatalogoUnitDoc = 
                   bigPrecio.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);
         }
         
         dtoPosicion.setPrecioContableUnitarioDocumento(bigCero);
         dtoPosicion.setPrecioContableUnitarioLocal(bigCero);
         dtoPosicion.setPrecioCatalogoUnitarioLocal(bigPrecio);
         dtoPosicion.setPrecioCatalogoUnitarioDocumento(bigPrecioCatalogoUnitDoc);
        
      } else {
         BigDecimal bigCero = new BigDecimal(0);
         BigDecimal bigPrecioContableUnitDoc = new BigDecimal(0);
         
         if (bigTipoCambio != null && bigTipoCambio.doubleValue() > 0) {
            bigPrecioContableUnitDoc = 
                  bigPrecioContable.divide(bigTipoCambio, BigDecimal.ROUND_HALF_UP);
         }
         
         dtoPosicion.setPrecioCatalogoUnitarioDocumento(bigCero);
         dtoPosicion.setPrecioCatalogoUnitarioLocal(bigCero);
         dtoPosicion.setPrecioContableUnitarioLocal(bigPrecioContable);
         dtoPosicion.setPrecioContableUnitarioDocumento(bigPrecioContableUnitDoc);
      }
      
      return dtoPosicion;
  }
  
  
  private DTOCabeceraSolicitud generaDTOCabecera (Vector vFila, 
                                                  Long oidPais,
                                                  Long oidPeriodo,
                                                  Long oidMarca,
                                                  Long oidCanal,
                                                  Vector vDTOPosicion) throws MareException {
      UtilidadesLog.info("MONEnvioIniFinPeriodo.generaDTOCabecera(): Entrada");
      UtilidadesLog.debug("vFila a usar para generar cabecera: " + vFila);
      
      DAOGenerarPagoIntercompanias daoGenerarPago = new DAOGenerarPagoIntercompanias();
      
      
      DTOPosicionSolicitud dtoPosicion = null;                                                  
      DTOCabeceraSolicitud dtoCabecera = new DTOCabeceraSolicitud();
      dtoCabecera.setOidPais(oidPais);
      dtoCabecera.setMarca(oidMarca);
      dtoCabecera.setCanal(oidCanal);
      dtoCabecera.setPeriodo(oidPeriodo);
      dtoCabecera.setModulo(new Long(ConstantesSEG.MODULO_MAV));
      dtoCabecera.setOperacion(ConstantesBEL.MAV012);
      dtoCabecera.setFecha(new java.util.Date());
     
      Long oidCliente = Long.valueOf(vFila.get(0).toString());
      Long tipoCliente = Long.valueOf(vFila.get(13).toString());
      Long subtipoCliente = Long.valueOf(vFila.get(24).toString());
      Long tipoSolicitud = Long.valueOf(vFila.get(9).toString());
      Long acceso = Long.valueOf(vFila.get(18).toString());
      java.sql.Date fechaHoy = (java.sql.Date) vFila.get(19);
      java.sql.Date fechaPago = (java.sql.Date) vFila.get(1); 
      Long oidMoneda = Long.valueOf(vFila.get(20).toString());
      Long oidDetalleMAV = Long.valueOf(vFila.get(7).toString());
      Long oidDireccionPpal = 
              daoGenerarPago.obtieneDireccionPPalCliente(oidCliente);
      
      dtoCabecera.setOidCliente(oidCliente);
      dtoCabecera.setTipoCliente(tipoCliente);
      dtoCabecera.setSubtipoCliente(subtipoCliente);
      dtoCabecera.setDestinatario(oidCliente);
      dtoCabecera.setDestino(oidDireccionPpal);
      dtoCabecera.setOidReceptorFactura(oidCliente);
      dtoCabecera.setOidPagadorFactura(oidCliente);
      
      dtoCabecera.setTipoSolicitud(tipoSolicitud);
      dtoCabecera.setAcceso(acceso);
      dtoCabecera.setFecha(fechaHoy);
      if(fechaPago!=null && fechaPago.getTime()!=getFechaFict()){
          dtoCabecera.setFechaPrevistaFacturacion(new Timestamp(fechaPago.getTime()));        
      }
      dtoCabecera.setMoneda(oidMoneda);
      dtoCabecera.setNumeroDocumentoOrigen(oidDetalleMAV);
      
      /* Recorre el Vector de Posiciones (vFila) y genera un ArrayList*/ 
      ArrayList aList = new ArrayList();
      
      int cantRegistros = vDTOPosicion.size();
      for (int i=0; i < cantRegistros; i++) {
         dtoPosicion = (DTOPosicionSolicitud) vDTOPosicion.get(i);
         aList.add(dtoPosicion);
      }
      dtoCabecera.setPosiciones(aList);
      
      UtilidadesLog.info("MONEnvioIniFinPeriodo.generaDTOCabecera(): Salida");
      return dtoCabecera;    
  }
  
  

  /**
   * @author: ssantana, 15/06/2006
   * @throws es.indra.mare.common.exception.MareException
   * @return DTODatosMensaje
   * @param  marca
   * @param  canal
   * @param  pais
   * @param  vFila
   */
  private DTODatosMensaje manejoMensaje(Vector vFila, Long pais, 
                                         Long canal, Long marca) throws MareException  {
    
     DTODatosMensaje dtoDatosMensaje = null;
     Object objMensaje = vFila.get(26);
     Long indMensaje = new Long(0);
     if (objMensaje != null) {
        indMensaje = Long.valueOf(objMensaje.toString());
     }
     
     if (indMensaje.longValue() == 1){ 
        
        Long oidCliente = Long.valueOf(vFila.get(0).toString());
        Long oidActividad = Long.valueOf(vFila.get(8).toString());
        Long oidPeriodoInicio = Long.valueOf(vFila.get(29).toString());
        Long oidPeriodoFin = null;
        if (vFila.get(30) != null ) {
           oidPeriodoFin = Long.valueOf(vFila.get(30).toString());
        }
        String sCodigoCliente = (String) vFila.get(23);
        String sCodigoMensaje = (String) vFila.get(27);
        String sCodigoVenta = (String) vFila.get(21);
        String sDescProd = (String) vFila.get(28);
        Long unidDemandadas = Long.valueOf(vFila.get(3).toString());
        BigDecimal bigPrecioPosic = (BigDecimal) vFila.get(6);
        BigDecimal bigPrecioCatalogo = (BigDecimal) vFila.get(5);
        BigDecimal bigPrecio = (BigDecimal) vFila.get(5);
        Long oidTipoCliente = Long.valueOf(vFila.get(13).toString());
        Long subtipoCliente = Long.valueOf(vFila.get(24).toString());
        Long oidTipoClasificacion = Long.valueOf(vFila.get(15).toString());
        Long oidClasificacion = Long.valueOf(vFila.get(16).toString());
        Long oidEstadoMAV = Long.valueOf(vFila.get(17).toString());
        
        dtoDatosMensaje.setOidPais(pais);
        dtoDatosMensaje.setOidMarca(marca);
        dtoDatosMensaje.setOidCanal(canal);
        dtoDatosMensaje.setOidAcceso(null);
        dtoDatosMensaje.setOidSubacceso(null);
        dtoDatosMensaje.setOidActividad(oidActividad);
        dtoDatosMensaje.setOidPeriodoInicio(oidPeriodoInicio);
        dtoDatosMensaje.setOidPeriodoFin(oidPeriodoFin);
        dtoDatosMensaje.setCodigoCliente(sCodigoCliente);
        dtoDatosMensaje.setCodigoMensaje(sCodigoMensaje);
        
        dtoDatosMensaje.setCodigoVenta(sCodigoVenta);
        dtoDatosMensaje.setDescripcionProducto(sDescProd);
        dtoDatosMensaje.setUnidadesDemandadas(unidDemandadas);
        
        if (sCodigoMensaje == null || !sCodigoMensaje.equals(ConstantesMSG.MENSAJE_MAV05) ) {
           dtoDatosMensaje.setPrecioPosicionamiento(bigPrecioPosic);
           dtoDatosMensaje.setPrecioCatalogo(bigPrecioCatalogo);
           dtoDatosMensaje.setPrecioVenta(bigPrecio);
           dtoDatosMensaje.setOidRegion(null);
           dtoDatosMensaje.setOidZona(null);
           dtoDatosMensaje.setOidTerritorio(null);
           dtoDatosMensaje.setOidTipoCliente(oidTipoCliente);
           dtoDatosMensaje.setOidSubtipoCliente(subtipoCliente);
           dtoDatosMensaje.setOidTipoClasificacion(oidTipoClasificacion);
           dtoDatosMensaje.setOidClasificacion(oidClasificacion);
           dtoDatosMensaje.setOidEstatusMAV(oidEstadoMAV);
        }
     }
     return dtoDatosMensaje;
     
  }

  private MONGenerarMensajesHome getMONGenerarMensajesHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONGenerarMensajesHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONGenerarMensajes"), MONGenerarMensajesHome.class);
  }

  /**
   * 21-06-2007   agregado por Sapaza, incidencia Sicc-20070288. Se ejecuta el proceso de
   *              Envio Inicio Fin Periodo como proceso batch
   * @throws es.indra.mare.common.exception.MareException
   * @return 
   * @param dtoin
   */
  public DTOSalidaBatch procesarEnvioIniFinPeriodoBatch(DTOBatch dtoin) throws MareException {
      UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoBatch(DTOBatch dtoin): Entrada");  

      DTOEnvioIniFinPeriodo dtoe = null;
      try{
          dtoe = (DTOEnvioIniFinPeriodo)dtoin.getDTOOnline();
      }catch (Exception e){
          UtilidadesLog.error("procesarEnvioIniFinPeriodo - No se ha recibido el DTO esperado");
          return new DTOSalidaBatch("DTO NO VALIDO");
      }
      UtilidadesLog.debug("dtoin: " + dtoin);
      UtilidadesLog.debug("proceso Batch: " + dtoin.getProcessID());

      this.procesarEnvioIniFinPeriodo(dtoe);
      UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoBatch(DTOBatch dtoin): Salida");
      
      return new DTOSalidaBatch(0, "procesarEnvioIniFinPeriodo OK");
  }

  /**
   * 21-07-2006   agregado por Sapaza, incidencia Sicc-20070288. Se ejecuta el proceso
   *              Envio Inicio/Fin periodo como proceso batch
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoe
   */
  public void procesarEnvioIniFinPeriodoMenu(DTOEnvioIniFinPeriodo dtoe) throws MareException {
      UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoMenu(DTOEnvioIniFinPeriodo dtoe): Entrada");  
      try {
          DTOBatch dtoBatch = new DTOBatch("EnvioIniFinPeriodo",new MareBusinessID("MAVProcesarEnvioIniFinPeriodoBatch"),dtoe);
          BatchUtil.executeMLN( dtoBatch, new MareBusinessID( "ZONRezonificacion" ));

      }catch (Exception e){
            UtilidadesLog.error("procesarEnvioIniFinPeriodo: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }        
      
      UtilidadesLog.info("MONEnvioIniFinPeriodoBean.procesarEnvioIniFinPeriodoMenu(DTOEnvioIniFinPeriodo dtoe): Salida");
  }
                                              
}
