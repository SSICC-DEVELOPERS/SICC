/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.DBService;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.ConstantesCMN;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacen;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenCabecera;
import es.indra.sicc.dtos.bel.DTOMovimientoAlmacenDetalle;
import es.indra.sicc.dtos.bel.DTOReportePedidos;
import es.indra.sicc.dtos.bel.DTOReversionMovimiento;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.dto.DTOSolicitudDescuento;
import es.indra.sicc.dtos.dto.DTOSolicitudPosicionDescuento;
import es.indra.sicc.dtos.fac.DTOFACProcesoCierre;
import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.dtos.msg.DTOBuzonMensajes;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPEDBloqueosClientes;
import es.indra.sicc.dtos.ped.DTODatosAnulacion;
import es.indra.sicc.dtos.ped.DTODatosFlete;
import es.indra.sicc.dtos.ped.DTODatosMontoMinimo;
import es.indra.sicc.dtos.ped.DTOEstatusSolicitud;
import es.indra.sicc.dtos.ped.DTOGenerarPosicionRecuperacion;
import es.indra.sicc.dtos.ped.DTOIndicadoresFlete;
import es.indra.sicc.dtos.ped.DTOLimVentaPosicion;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.dtos.ped.DTOPrecioPosicion;
import es.indra.sicc.dtos.ped.DTOPrecioPosiciones;
import es.indra.sicc.dtos.ped.DTOProceso;
import es.indra.sicc.dtos.ped.DTOProductosMontoMinimo;
import es.indra.sicc.dtos.ped.DTOSolicitudReversion;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.dtos.ped.DTOTipifYUnidadAdminCliente;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.dtos.pre.DTOObtenerProductoRecuperacion;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocal;
import es.indra.sicc.entidades.bel.EstadosMercanciaLocalHome;
import es.indra.sicc.entidades.bel.StockLocal;
import es.indra.sicc.entidades.bel.StockLocalHome;
import es.indra.sicc.entidades.inc.BolsaFantantesLocal;
import es.indra.sicc.entidades.inc.BolsaFantantesLocalHome;
import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.entidades.msg.MensajesLocalHome;
import es.indra.sicc.entidades.ped.SolicitudMensajesLocal;
import es.indra.sicc.entidades.ped.SolicitudMensajesLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.MONGenerarMovimientoAlmacenHome;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;
import es.indra.sicc.logicanegocio.car.MONValidarCreditosHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.cra.IDAOCRA;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.dto.MONCalcularDTOLocalHome;
import es.indra.sicc.logicanegocio.dto.MONRevertirDescuentos;
import es.indra.sicc.logicanegocio.dto.MONRevertirDescuentosHome;
import es.indra.sicc.logicanegocio.mae.ConstantesMAE;
import es.indra.sicc.logicanegocio.mav.DAOProcesoEnvioAgregadosSolicitud;
import es.indra.sicc.logicanegocio.mav.MONProcesoEnvioAgregadosSolicitudHome;
import es.indra.sicc.logicanegocio.msg.IMSG;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesHome;
import es.indra.sicc.logicanegocio.msg.MONGestionMensajesLocalHome;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMF;
import es.indra.sicc.logicanegocio.pre.MONMantenimientoMFHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CAREjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.PEDEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

public class MONPEDValidacionBean implements SessionBean {
    static String ENTIDAD_DESC_TRADU = "GEN_MENSA_TRADU";
    static Long MSG_MONTO_MINIMO = new Long(1);
    static Long MSG_FLETE = new Long(1);
    private SessionContext sessionContext;
    private SessionContext ctx = null;
    private UtilidadesLog log = new UtilidadesLog();
    
    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOEstatusSolicitud validarPreciosMatriz(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarPreciosMatriz(DTOSolicitudValidacion dto): Entrada ");
        DAOPEDIntegracion daopedIntegracion = new DAOPEDIntegracion();
        DAOPosicion daoposicion = new DAOPosicion();
        DTOPrecioPosiciones dtopreciosPosiciones = new DTOPrecioPosiciones();
        DTOPrecioPosicion dtopreciosPosicion = new DTOPrecioPosicion();
        DTOEstatusSolicitud dtoEstatuSolicitud = new DTOEstatusSolicitud();
        Vector vectorprecioPosicion = new Vector();

        dtopreciosPosiciones = daopedIntegracion.obtenerPreciosPosicionesMatriz(dto.getOidSolicitud(), dto.getNumDecimales());
        
        if ( (dtopreciosPosiciones != null) && (dtopreciosPosiciones.getPrecioPosiciones() != null)) {
          vectorprecioPosicion = dtopreciosPosiciones.getPrecioPosiciones();
          //UtilidadesLog.debug("el vector de precios por posicion, es: " + vectorprecioPosicion);
          Enumeration enumeration = vectorprecioPosicion.elements();
          int i = 0;
          Boolean continuar;
		  //doliva -- cambio Optimizacion Logs -- 09/04/2010
		  if(log.isDebugEnabled()){
			  UtilidadesLog.debug("la moneda parea este item, es: " + dto.getOidMoneda());
			  UtilidadesLog.debug("tipo de cambio, es: " + dto.getTipoCambio());
          }
          StringBuffer queryActualizaPrecios = new StringBuffer();
          StringBuffer queryActualizaEstados = new StringBuffer();
          while(enumeration.hasMoreElements()) {
              DTOPrecioPosicion aux = (DTOPrecioPosicion)vectorprecioPosicion.get(i);
              //UtilidadesLog.debug("precio posicion: " + aux);
              //se rediseña segun inc.: 11661
              if (aux.getIndVentaExclusivo().booleanValue() == true) {
                continuar = daopedIntegracion.validarClienteVentaExclusiva(dto.getOidCliente(), aux.getOidOferta());
              } else {
                continuar = Boolean.TRUE;
              }
              //UtilidadesLog.debug("indicador venta exclusiva: " + aux.getIndVentaExclusivo());
              if(continuar.booleanValue()) {
                  //UtilidadesLog.debug("precio unitario: " + aux.getPrecioUnitario().longValue());
                  if(aux.getPrecioUnitario().floatValue() > 0) {
                      if(dto.getOidMoneda() == null) {
                          //UtilidadesLog.debug("actualizo precios con: " + aux.getOidPosicion() + " " + 0 + " - " + aux.getPrecioUnitario() + " - " + aux.getPrecioUnitario() + " - " + 0 + " - " + dto.getNumDecimales());                           
                          String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(), new BigDecimal(0), aux.getPrecioUnitario(),
                                              aux.getPrecioUnitario(), new BigDecimal(0), dto.getNumDecimales());
                          queryActualizaPrecios.append(query).append(";");
                      } else {
                          //UtilidadesLog.debug("actualizo precios con: " + aux.getOidPosicion() + " - " + 0 + " - " + aux.getPrecioPosicion() + " - " + aux.getPrecioPosicion().multiply(dto.getTipoCambio()) + " - " + 0 + " - " + dto.getNumDecimales());                          
                          //UtilidadesLog.debug("actualizo precios con aux: " + aux);
                          //UtilidadesLog.debug("y con dto: " + dto);
                          /*
                           * BELC300024390 - dmorello, 24/11/2006
                           * El precio unitario está en moneda documento. Como tipoCambio = unidadesMonedaLocal/unidadMonedaDocu,
                           * se invierte el orden de los parámetros 3 y 4
                           */
                          //String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(), new BigDecimal(0), aux.getPrecioUnitario(),
                          //                aux.getPrecioUnitario().multiply(dto.getTipoCambio()), new BigDecimal(0), dto.getNumDecimales());
                          String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(), new BigDecimal(0), aux.getPrecioUnitario().multiply(dto.getTipoCambio()),
                                          aux.getPrecioUnitario(), new BigDecimal(0), dto.getNumDecimales());
                          queryActualizaPrecios.append(query).append(";");
                      }    
                  } else {
                      if (dto.getOidMoneda() == null) {
                        //UtilidadesLog.debug("actualizo precios con: " + aux.getOidPosicion() + " - " + aux.getPrecioContable() + " - " + 0 + " - " + 0 + " - " + aux.getPrecioContable() + " - " + dto.getNumDecimales());
                        /*daoposicion.actualizarPrecios(aux.getOidPosicion(), aux.getPrecioContable(), new BigDecimal(0),
                            new BigDecimal(0), aux.getPrecioContable(), dto.getNumDecimales());*/
                        String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(), aux.getPrecioContable(), new BigDecimal(0),
                            new BigDecimal(0), aux.getPrecioContable(), dto.getNumDecimales());
                        queryActualizaPrecios.append(query).append(";");
                      } else {
                        //UtilidadesLog.debug("actualizo precios con: " + aux.getOidPosicion() + " - " + aux.getPrecioContable() + " - " + 0 + " - " + 0 + " - " + aux.getPrecioContable().multiply(dto.getTipoCambio()) + " - " + dto.getNumDecimales());
                        /*daoposicion.actualizarPrecios(aux.getOidPosicion(), aux.getPrecioContable(), new BigDecimal(0),
                            new BigDecimal(0), aux.getPrecioContable().multiply(dto.getTipoCambio()), dto.getNumDecimales());*/
                        /*
                         * BELC300024390 - dmorello, 24/11/2006: tipoCambio = unidadesMonedaLocal/unidadMonedaDocu
                         * El precio contable viene en moneda documento, por lo cual no hará falta multiplicarlo
                         */
                        /*String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(), aux.getPrecioContable(), new BigDecimal(0),
                            //new BigDecimal(0), aux.getPrecioContable().multiply(dto.getTipoCambio()), dto.getNumDecimales());
                            new BigDecimal(0), aux.getPrecioContable(), dto.getNumDecimales());*/
                        
                        /* DBLG700000275 - eiraola, 26/12/2006
                         * Tomo como verdadero que el precio contable viene en moneda documento (alternativa)
                         * por lo cual debo convertirlo a su valor en moneda local para guardar precio contable local.
                         */
                        UtilidadesLog.debug(" ... Precio Contable desde Matriz Facturacion (ya es moneda Documento):" + aux.getPrecioContable());
                        String query = daoposicion.generarActualizarPrecios(aux.getOidPosicion(),
                                                                            aux.getPrecioContable().multiply(dto.getTipoCambio()),
                                                                            new BigDecimal(0),
                                                                            new BigDecimal(0),
                                                                            aux.getPrecioContable(),
                                                                            dto.getNumDecimales());
                        queryActualizaPrecios.append(query).append(";");
                      }  
                  }
              } else {
                  //daoposicion.actualizarEstado(aux.getOidPosicion(), ConstantesPED.ESTADO_POSICION_ANULADO);
                  //String query = daoposicion.generarActualizarEstado(aux.getOidPosicion(), ConstantesPED.ESTADO_POSICION_ANULADO);
                  String query = daoposicion.generarActualizarEstadoYNumCompr(aux.getOidPosicion(), ConstantesPED.ESTADO_POSICION_ANULADO);
                  queryActualizaEstados.append(query).append(";");
              }    
              i++;
              enumeration.nextElement();
          }
          try{
              DBService db = BelcorpService.getInstance().dbService;
              db.executeProcedure("PQ_PLANI.EXECUTOR", queryActualizaPrecios.toString());
              db.executeProcedure("PQ_PLANI.EXECUTOR", queryActualizaEstados.toString());
          }catch(Exception e){
              UtilidadesLog.error("Error al ejecutar PROCEDURE",e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        } 
        dtoEstatuSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarPreciosMatriz(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatuSolicitud;
    }

    /**
    * Se recuperan las solicitudes que no esten anuladas,
    * que no tengan relleno el codigo de venta y que tenga
    * no tengan relleno el precio Catalogo Unitario Local y el precio Contable Unitario Local
    * y se obtiene el precio de los productos en el maestro de productos
    */
    public DTOEstatusSolicitud validarPreciosMaestroProducto(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarPreciosMaestroProducto(DTOSolicitudValidacion dto): Entrada ");
        DAOPEDIntegracion daopedIntegracion = new DAOPEDIntegracion();
        DAOPosicion daoposicion = new DAOPosicion();
        DTOPrecioPosiciones dtopreciosPosiciones = new DTOPrecioPosiciones();
        DTOPrecioPosicion dtopreciosPosicion = new DTOPrecioPosicion();
        DTOEstatusSolicitud dtoEstatuSolicitud = new DTOEstatusSolicitud();
        Vector vectorprecioPosicion = new Vector();

        dtopreciosPosiciones = daopedIntegracion.obtenerPreciosPosicionesMaestro(dto.getOidSolicitud());
        UtilidadesLog.debug("precios posiciones maestro: " + dtopreciosPosiciones);
        vectorprecioPosicion = dtopreciosPosiciones.getPrecioPosiciones();
        UtilidadesLog.debug("vector de precios posicion " + vectorprecioPosicion);

        Enumeration enumeration = vectorprecioPosicion.elements();

        int i = 0;
        UtilidadesLog.debug("vectorprecioPosicion, mide: " + vectorprecioPosicion.size());    
        StringBuffer queryActualizaPrecios = new StringBuffer();

        while(enumeration.hasMoreElements()) {
            DTOPrecioPosicion auxPrecioPosicion = (DTOPrecioPosicion)vectorprecioPosicion.get(i);
            
            UtilidadesLog.debug("DTO precios posicion: " + auxPrecioPosicion);

            if (dto.getOidMoneda() == null) {
                UtilidadesLog.debug("actualizo precios, con : " + auxPrecioPosicion.getOidPosicion() + " - " + auxPrecioPosicion.getPrecioContable() + " - " + auxPrecioPosicion.getPrecioPosicion() + " - " + auxPrecioPosicion.getPrecioPosicion() + " - " + auxPrecioPosicion.getPrecioContable() + " - " + dto.getNumDecimales());
                String query = daoposicion.generarActualizarPrecios(auxPrecioPosicion.getOidPosicion(), auxPrecioPosicion.getPrecioContable(),
                    auxPrecioPosicion.getPrecioPosicion(), auxPrecioPosicion.getPrecioPosicion(),
                    auxPrecioPosicion.getPrecioContable(), dto.getNumDecimales());
                queryActualizaPrecios.append(query).append(";");
            } else {
                UtilidadesLog.debug("actualizo precios, con : " + auxPrecioPosicion.getOidPosicion() + " - " + auxPrecioPosicion.getPrecioContable() + " - " + auxPrecioPosicion.getPrecioPosicion() + " - " + auxPrecioPosicion.getPrecioPosicion().multiply(dto.getTipoCambio()) + " - " + auxPrecioPosicion.getPrecioContable().multiply(dto.getTipoCambio()) + " - " + dto.getNumDecimales());
                String query = daoposicion.generarActualizarPrecios(auxPrecioPosicion.getOidPosicion(), auxPrecioPosicion.getPrecioContable(),
                    auxPrecioPosicion.getPrecioPosicion(), auxPrecioPosicion.getPrecioPosicion().multiply(dto.getTipoCambio()),
                    /* BELC300024390 - dmorello, 15/12/2006: tipoCambio = unidadesMonedaLocal/unidadMonedaDocu */
                    //auxPrecioPosicion.getPrecioContable().multiply(dto.getTipoCambio()), dto.getNumDecimales());
                    auxPrecioPosicion.getPrecioContable().divide(dto.getTipoCambio(), BigDecimal.ROUND_HALF_EVEN), dto.getNumDecimales());
                queryActualizaPrecios.append(query).append(";");
            }
            i++;
            enumeration.nextElement();
        }
        
        try {
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.EXECUTOR", queryActualizaPrecios.toString());
        } catch(Exception e) {
            UtilidadesLog.error("Error al ejecutar PROCEDURE",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.debug("solicitud validada!");
        dtoEstatuSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarPreciosMaestroProducto(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatuSolicitud;
    }


    /**
    * Toma el oid de la solicitud del DTOSolicitudValidacion recibido y llama al metodo borrarPreciosSolicitud del DAOSolicitud
    */
    public DTOEstatusSolicitud revertirPrecios(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirPrecios(DTOSolicitudValidacion dto): Entrada ");
        DAOSolicitud daosolicitud = new DAOSolicitud();
        DTOEstatusSolicitud dtoestatussolicitud = new DTOEstatusSolicitud();
        daosolicitud.borrarPreciosSolicitud(dto.getOidSolicitud());
        dtoestatussolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirPrecios(DTOSolicitudValidacion dto): Salida ");
 
        //SCSreturn new DTOEstatusSolicitud();
        return dtoestatussolicitud;
    }

    /**
     * Realiza la validacion de los descuento asociados a una solictud.
     * Tambien actualizarMontoDescuento3, ademas de actualizarPorcentajeDescuento para cada posicion.
     * @autor gdmarzi
     */
    public DTOEstatusSolicitud validarDescuento(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarDescuento(DTOSolicitudValidacion dto): Entrada ");
        // -> Llamar al método "MONCalcularDTO.validarDescuentos(dto : DTOSolicitudValidacion) : DTOSolicidudDescuento" 
        // -> Guardar el dto de respuesta en una variable llamada "solicitudDescuento" 
        DTOSolicitudDescuento solicitudDescuento = new DTOSolicitudDescuento();

        try {
            solicitudDescuento = getMONCalcularDTOLocalHome().create().validarDescuentos(dto);
        } catch(NamingException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        //-> Tomar el valor de los atributos solicitudDescuento.oidSolicitud y solicitudDescuento.montoDescuento3 para la siguiente llamada 
        Long oidCabecera = solicitudDescuento.getOidSolicitud();
        BigDecimal montoDescuento3 = solicitudDescuento.getMontoDescuento3();

        //-> Llamar al método "DAOSolicitud.actualizarMontoDescuento3(oidCabecera : Long, montoDescuento3 : BigDecimal) : void" 
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        //Jrivas Inc. 17873  7/5/2005
        //Faltaba actualizar el valor del Documento.        
        
         // sapaza -- PER-SiCC-2012-0412 -- 23/05/2012
        daoSolicitud.actualizarMontoDescuento3(oidCabecera, montoDescuento3, dto.getOidMoneda(), dto.getTipoCambio(), 
                        solicitudDescuento.getMontoBaseCalculo());

        // -> Recorrer el atributo solicitudDescuento.posiciones, que es un array de objetos DTOSolicitudPosicionDescuento 
        // Para cada objeto DTOSolicitudPosicionDescuento contenido en el array hacer 
        Iterator iter = solicitudDescuento.getPosiciones().iterator();
        StringBuffer queryGeneral = new StringBuffer();
        while(iter.hasNext()) {
            DTOSolicitudPosicionDescuento solicitudPosicionDescuento = (DTOSolicitudPosicionDescuento)iter.next();
            /**
             * Se cambia por la ejecucion de las actualizaciones en una sola query para mejorar la performance
             * autor: jpbosnja
             */
            String query = daoSolicitud.generarActualizarPorcentajeDescuento(solicitudPosicionDescuento.getOidPosicion(),
                solicitudPosicionDescuento.getPorcentajeDescuento(), solicitudPosicionDescuento.getImporteDescuentoUnitarioLocal(), 
                dto.getOidMoneda(), dto.getTipoCambio(), solicitudPosicionDescuento.getOidBaseAplicacion(), solicitudPosicionDescuento.getOidEscala());
            queryGeneral.append(query);
        }
        try{
            if (queryGeneral.toString().length() > 0 ) {
                DBService db = BelcorpService.getInstance().dbService;
                db.executeProcedure("PQ_PLANI.EXECUTOR", queryGeneral.toString());
            }
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarDescuento(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }


    /**
     * Revierte el descuento para un oidSolicitud.
     * @autor gdmarzi
     */
    public DTOEstatusSolicitud revertirDescuentos(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirDescuentos(DTOSolicitudValidacion dto): Entrada ");
        //Se crea un DTOOID (con el oid de solicitud en el DTOSolicitudValidacion) 
        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(dto.getOidSolicitud());

        // -> Llamar al método "MONRevertirDescuentos.revertirDescuentos(dto : DTOOID) : void" pasando el dto de entrada
        try {
            MONRevertirDescuentosHome monRevertirDescuentosHome = this.getMONRevertirDescuentosHome();
            MONRevertirDescuentos monRevertirDescuentos = monRevertirDescuentosHome.create();
            monRevertirDescuentos.revertirDescuentos(dtoOID);
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        //Retornando un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirDescuentos(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    /**
     * Esta modalidad consiste en la inclusión automática y
     * obligatoria de los productos no atendidos en periodos anteriores.
     * @autor gdmarzi
     */
    public DTOEstatusSolicitud recuperacionObligatoria(DTOSolicitudValidacion dto)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoria(DTOSolicitudValidacion dto: Entrada ");
        Integer iFaltantes;
        Long oidPosicion;
        //Integer controlStock;
        //int unidadesdemandadas;
        int unidadesComprometidas;
        int unidadesatender;
        boolean existeProductoRecuperacion;
        RecordSet posicionesFaltantes;
        DTOCabeceraSolicitud dtoCabeceraSolicitud;
        ArrayList posiciones;

        try {
            // En primer lugar recupera la información de la cabecera de la solicitud 
            DAOSolicitud daoSolicitud = new DAOSolicitud();
            UtilidadesLog.debug("voy a: daoSolicitud.obtenerCabeceraSolicitud(....");
            dtoCabeceraSolicitud = daoSolicitud.obtenerCabeceraSolicitud(dto.getOidSolicitud());
            //doliva -- cambio Optimizacion Logs -- 09/04/2010
			if(log.isDebugEnabled())
				UtilidadesLog.debug("obtengo: " + dtoCabeceraSolicitud);
				
            dtoCabeceraSolicitud.setIndicadorDigitacion(Boolean.FALSE);

            // A continuación recupera las posiciones de la solicitud 
            posiciones = daoSolicitud.obtenerPosicionesSolicitud(dto.getOidSolicitud());
            //UtilidadesLog.debug("el arraylist de posiciones, es: " + posiciones); OJO al descomentar si vienen muchas posiciones pincha.
            dtoCabeceraSolicitud.setPosiciones(posiciones);

            // posicionesFaltantes = DAOPosicion.obtenerPosicionesFaltantes(dto) 
            DAOPosicion daoPosicion = new DAOPosicion();
            posicionesFaltantes = daoPosicion.obtenerPosicionesFaltantes(dto);
            
			//doliva -- cambio Optimizacion Logs -- 09/04/2010
			if(log.isDebugEnabled())
				UtilidadesLog.debug("las posiciones fttes., son: " + posicionesFaltantes);
            DAOProcesoEnvioAgregadosSolicitud daoProcesoEnvioAgregadosSolicitud = new DAOProcesoEnvioAgregadosSolicitud();
            BigDecimal ultCodPosi = daoProcesoEnvioAgregadosSolicitud.obtenerUltimaPosicion(dto.getOidSolicitud());     
            //Long lineaNumeroPosicion = new Long(dtoCabeceraSolicitud.getPosiciones().size()-1);
            Long lineaNumeroPosicion = new Long(ultCodPosi.longValue()+1);
            
            //enozigli 13/02/09 cambio por solic. PRE-012 1/4
            DTOTipifYUnidadAdminCliente dtoTyUA = null;
            
            dtoTyUA = daoSolicitud.obetenerTipifyUAClienSoli(dto.getOidSolicitud());
            //fin enozigli 13/02/09 cambio por solic. PRE-012 1/4

            // Por cada elemento en posicionesFaltantes
            for(int i = 0; i < posicionesFaltantes.getRowCount(); i++) {
				//doliva -- cambio Optimizacion Logs -- 09/04/2010
				if(log.isDebugEnabled())
					UtilidadesLog.debug("estoy recorriendo las posiciones, item: " + i);
                //pzerbino Incidencia BELC300024247 11/10/2006
                if (posicionesFaltantes.getValueAt(i,"indPedidoPrueba").equals("1")){
                    daoPosicion.actualizaFaltante(new Long(posicionesFaltantes.getValueAt(i,"oidposicion").toString()));
                }
                
                iFaltantes = new Integer(0);

                //enozigli - 29/04/2008 - Cambio por incidencia RI20080579_ Recuperación obligatoria de GP2
                // iFaltantes = posiciones(i).unidadesatender - posiciones(i).unidadescomprometidas //unidadesdemandarreal = unidadesatender
                unidadesatender = new BigDecimal(posicionesFaltantes.getValueAt(i, "UNIDADESATENDER").toString()).intValue();
                unidadesComprometidas = new BigDecimal(posicionesFaltantes.getValueAt(i, "UNIDADESCOMPROMETIDAS").toString()).intValue();
                iFaltantes = new Integer(unidadesatender - unidadesComprometidas);
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
				if(log.isDebugEnabled())
					UtilidadesLog.debug("RI20080579 - unidadesdemandarreal / unidadesComprometidas e iFaltantes, son: " + unidadesatender + " / " + unidadesComprometidas + " / " + iFaltantes);
                //fin enozigli - 29/04/2008 - Cambio por incidencia RI20080579_ Recuperación obligatoria de GP2

                // Crear un dtoGenerarPosicionRecuperacion mapeando el recorset obtenido, ademas de iFaltantes
                UtilidadesLog.debug("voy a crear un: dtoGenerarPosicionRecuperacion");
                DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion = new DTOGenerarPosicionRecuperacion();
                dtoGenerarPosicionRecuperacion.setOidPosicion(new Long(posicionesFaltantes.getValueAt(i, "OIDPOSICION").toString()));
                // - faltante = iFaltantes 
                dtoGenerarPosicionRecuperacion.setFaltante(iFaltantes);
                // - cvFicticio = posiciones(i).ventaficticia 
                dtoGenerarPosicionRecuperacion.setCvFicticio(bigDecimalToLong((BigDecimal)(posicionesFaltantes.getValueAt(i, "VENTAFICTICIA"))));
                dtoGenerarPosicionRecuperacion.setPorcentajeDescuento((BigDecimal)(posicionesFaltantes.getValueAt(i,
                        "PORCENTAJEDESCUENTO")));
                dtoGenerarPosicionRecuperacion.setImporteDescuentoUnitarioDocumento((BigDecimal)(posicionesFaltantes.getValueAt(i,
                        "DESCUENTOUNITARIODOCUMENTO")));
                // [1] Agregado por Rafael Romero - 23/05/2007 - SiCC 20070261
                dtoGenerarPosicionRecuperacion.setImporteDescuentoUnitarioLocal((BigDecimal)(posicionesFaltantes.getValueAt(i,
                        "DESCUENTOUNITARIOLOCAL")));
                // [1] Fin agregado
                dtoGenerarPosicionRecuperacion.setFormaPago(bigDecimalToLong(
                        (BigDecimal)(posicionesFaltantes.getValueAt(i, "FORMAPAGO"))));
                dtoGenerarPosicionRecuperacion.setPeriodo(new Long(posicionesFaltantes.getValueAt(i, "PERIODO").toString()));
                dtoGenerarPosicionRecuperacion.setCodigoVenta((String)posicionesFaltantes.getValueAt(i, "VENTA"));
                dtoGenerarPosicionRecuperacion.setOidProducto(bigDecimalToLong(
                        (BigDecimal)(posicionesFaltantes.getValueAt(i, "PRODUCTO"))));
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
				if(log.isDebugEnabled())        
					UtilidadesLog.debug("el dtoGenerarPosicionRecuperacion, tiene: " + dtoGenerarPosicionRecuperacion);       

                //El diseño pide que si se captura la excepcion de NO Existencia de Producto de Recuperacion
                try {
                    existeProductoRecuperacion = true;
                    // Llamar al método generarPosicionRecuperacion(dto, DTOGenerarPosicionRecuperacion) 
                    UtilidadesLog.debug("voy a: generarPosicionRecuperacion!");
                    //enozigli 13/02/09 cambio por solic. PRE-012 2/4
                    dtoCabeceraSolicitud = this.generarPosicionRecuperacion(dto, dtoGenerarPosicionRecuperacion, dtoCabeceraSolicitud,(lineaNumeroPosicion.longValue()+i), dtoTyUA);
                    //fin enozigli 13/02/09 cambio por solic. PRE-012 2/4
					//doliva -- cambio Optimizacion Logs -- 09/04/2010
					if(log.isDebugEnabled())
						UtilidadesLog.debug("luego de generarPosicionRecuperacion, obtengo: " + dtoCabeceraSolicitud);
                } catch(MareException me) {
                    if(me.getCode() == 666) {
                        existeProductoRecuperacion = false;
                        UtilidadesLog.debug("No exite un Producto de Recuperacion para la posicion "
                            + dtoGenerarPosicionRecuperacion.getOidPosicion()
                            + " por lo que no se graba la posicion de recuperacion, ni se actualiza faltante.");
                    } else
                        throw me;
                }

                // Si existe producto de recuperación, actualiza la linea de faltantes 
                // Si no captura una MareException 
                //doliva -- cambio Optimizacion Logs -- 09/04/2010
				if(log.isDebugEnabled())
					UtilidadesLog.debug("existeProductoRecuperacion..?????????: " + existeProductoRecuperacion);
                
                if(existeProductoRecuperacion) {
                    // Si dto.indSimulacion == False 
                    if(!dto.getIndSimulacion().booleanValue()) {
                        UtilidadesLog.debug("no es ind. de simulacion!!!...");
                        //DAOPosicion.actualizaFaltante( posiciones(i).oidposicion) 
                        oidPosicion = new Long(posicionesFaltantes.getValueAt(i, "OIDPOSICION").toString());
						//doliva -- cambio Optimizacion Logs -- 09/04/2010
						if(log.isDebugEnabled())
							UtilidadesLog.debug("oid de la pos. a act. fttes., es: " + oidPosicion);
                        daoPosicion.actualizaFaltante(oidPosicion);
                    }
                }
            }
             // fin posicionesFaltantes
        } catch(MareException me) {
            UtilidadesLog.error("Exception: ",me);
            throw me;
        } catch(Exception e) {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoria(DTOSolicitudValidacion dto: Salida ");
        return dtoEstatusSolicitud;
    }

    /**
     * Genera una posición de recuperación.
     * @autor gdmarzi
     */
    private DTOCabeceraSolicitud generarPosicionRecuperacion(DTOSolicitudValidacion dtoe,
        DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion, DTOCabeceraSolicitud dtoCabeceraSolicitud, long linea, DTOTipifYUnidadAdminCliente dtoTYUA)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.generarPosicionRecuperacion(DTOSolicitudValidacion dtoe, DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion, DTOCabeceraSolicitud dtoCabeceraSolicitud): Entrada ");
        DTOProceso dtoProceso;
        DTOObtenerProductoRecuperacion dtoObtenerProductoRecuperacion;
        DTOPosicionSolicitud dtoPosicionSolicitud;
        DTOSalida dtoSalidaProductoRecuperacion;
        RecordSet rsProductoRecuperacion;
        String cv = null;

        // Obtenemos los datos del proceso recibido 
        dtoProceso = dtoe.getProceso();
        UtilidadesLog.debug("dtoProceso, es: " + dtoProceso);

        // Creamos un DTOObtenerProductoRecuperacion con: 
        dtoObtenerProductoRecuperacion = new DTOObtenerProductoRecuperacion();
        // - periodoActual = DTOE.oidPeriodo 
        dtoObtenerProductoRecuperacion.setPeriodoActual(dtoe.getOidPeriodo());
        // - periodoFaltante = DTOGenerarPosicionRecuperacion.periodo 
        dtoObtenerProductoRecuperacion.setPeriodoFaltante(dtoGenerarPosicionRecuperacion.getPeriodo());
        // - codigoVentaFaltante = DTOGenerarPosicionRecuperacion.codigoVenta 
        dtoObtenerProductoRecuperacion.setCodigoVentaFaltante(dtoGenerarPosicionRecuperacion.getCodigoVenta());

        //enozigli 13/02/09 cambio por solic. PRE-012 3/4
        dtoObtenerProductoRecuperacion.setTipifYUa(dtoTYUA);        
        //fin enozigli 13/02/09 cambio por solic. PRE-012 3/4  (sigue en es.indra.sicc.logicanegocio.pre.MONMantenimientoMFBean)  
        
        UtilidadesLog.debug("el dtoObtenerProductoRecuperacion generado, es: " + dtoObtenerProductoRecuperacion);

        //DTOSalida = Llamar al método IServiceMF.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion) 
        try {
            MONMantenimientoMFHome monMantenimientoMFHome = this.getMONMantenimientoMFHome();
            MONMantenimientoMF monMantenimientoMF = monMantenimientoMFHome.create();
            dtoSalidaProductoRecuperacion = monMantenimientoMF.obtenerProductoRecuperacion(dtoObtenerProductoRecuperacion);
            
            UtilidadesLog.debug("he obtenido los productos en recuperacion, son: " + dtoSalidaProductoRecuperacion);
            
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        // cv = Primer valor de DTOSalida (si no hay ningun valor viene null el DTOSalida)
        if(dtoSalidaProductoRecuperacion != null) {
            rsProductoRecuperacion = dtoSalidaProductoRecuperacion.getResultado();
            cv = (String)rsProductoRecuperacion.getValueAt(0, 0);
            UtilidadesLog.debug("tengo: dtoSalidaProductoRecuperacion, el cv es: " + cv);
        }

        // Si cv == null entonces Lanza una MareException
        if(cv == null)
        {
            //666 "El codigo de venta del Producto de Recuperacion es nulo"
            UtilidadesLog.error("NO SE HA PODIDO HALLAR PRODUCTO DE RECUPERACION PARA EL MISMO PERIODO:::::MIRAR CONSULTA ANTERIOR");
            throw new MareException(new Exception(), 666);
        }  
        // Creamos un DTOPosicionSolicitud posicionSolicitud con los datos: 
        dtoPosicionSolicitud = new DTOPosicionSolicitud();
        // - estadoPosicion = ConstantesPED.ESTADO_POSICION_CORECTO 
        dtoPosicionSolicitud.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
        // - numeroPosicion: Tamaño del ArrayList DTOCabeceraSolicitud.posiciones.size (recordemos que va desde 0, entoces no es size + 1 ) 
        //dtoPosicionSolicitud.setNumeroPosicion(new Long(dtoCabeceraSolicitud.getPosiciones().size()));
        // - oidTipoPosicion: DTOProceso.oidTipoPosicion 
        dtoPosicionSolicitud.setTipoPosicion(dtoProceso.getOidTipoPosicion());
        // - oidSubtipoPosicion: DTOProceso.oidSubTipoPosicion 
        dtoPosicionSolicitud.setSubtipoPosicion(dtoProceso.getOidSubTipoPosicion());
        // - codigoVenta: cv 
        dtoPosicionSolicitud.setCodigoVenta(cv);
        // - unidadesDemandadas: DTOGenerarPosicionRecuperacion.faltante 
        dtoPosicionSolicitud.setUnidadesDemandadas(new Long(dtoGenerarPosicionRecuperacion.getFaltante().longValue()));
        // - unidadesPorAtender: DTOGenerarPosicionRecuperacion.faltante 
        dtoPosicionSolicitud.setUnidadesPorAtender(new Long(dtoGenerarPosicionRecuperacion.getFaltante().longValue()));
        // - codigoVentaFicticio = DTOGenerarPosicionRecuperacion.cvFicticio 
        dtoPosicionSolicitud.setCodigoVentaFicticio(dtoGenerarPosicionRecuperacion.getCvFicticio());
        // - precioCatalogoUnitarioLocal = 0 
        dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(new BigDecimal(0));
        // - precioCatalogoUnitarioDocumento = 0 
        dtoPosicionSolicitud.setPrecioCatalogoUnitarioDocumento(new BigDecimal(0));
        // - precioContableUnitaroLocal = 0 
        dtoPosicionSolicitud.setPrecioContableUnitarioLocal(new BigDecimal(0));
        // - precioContableUnitarioDocumento = 0 
        dtoPosicionSolicitud.setPrecioContableUnitarioDocumento(new BigDecimal(0));

        // - porcentajeDescuento = DTOGenerarPosicionRecuperacion.porcentajeDescuento 
        if(dtoGenerarPosicionRecuperacion.getPorcentajeDescuento() != null)
            dtoPosicionSolicitud.setPorcentajeDescuento(new Double(
                    dtoGenerarPosicionRecuperacion.getPorcentajeDescuento().doubleValue()));

        // - importeDescuentoUnitarioDocumento = DTOGenerarPosicionRecuperacion.importeDescuentoUnitarioDocumento 
        dtoPosicionSolicitud.setImporteDescuentoUnitarioDocumento(dtoGenerarPosicionRecuperacion.getImporteDescuentoUnitarioDocumento());
        
        // [1] Agregado por Rafael Romero - 23/05/2007 - SiCC 20070261
        dtoPosicionSolicitud.setImporteDescuentoUnitarioLocal(dtoGenerarPosicionRecuperacion.getImporteDescuentoUnitarioLocal());
        // [1] Fin agregar
        
        // - formaPago = DTOGenerarPosicionRecuperacion.formaPago 
        dtoPosicionSolicitud.setFormaPago(dtoGenerarPosicionRecuperacion.getFormaPago());
        //- posicionRecuperacion = DTOGenerarPosicionRecuperacion.oidPosicion 
        dtoPosicionSolicitud.setPosicionRecuperacion(dtoGenerarPosicionRecuperacion.getOidPosicion());
        //- producto = DTOGenerarPosicionRecuperacion.oidProducto
        dtoPosicionSolicitud.setProducto(dtoGenerarPosicionRecuperacion.getOidProducto());
        
        dtoPosicionSolicitud.setNumeroPosicion(new Long(linea));

        // Completamos la posición 
        // DTOCabeceraSolicitud.posiciones.add(DTOPosicionSolicitud) 
        
        UtilidadesLog.debug("el dtoPosicionSolicitud, me quedo asi: " + dtoPosicionSolicitud);
        
        dtoCabeceraSolicitud.getPosiciones().add(dtoPosicionSolicitud);

        // dtoCabeceraSolicitud = Llamar al método MONGenerarPosicionSolicitud.generarPosicion(DTOCabeceraSolicitud, DTOPosicionSolicitud.numeroPosicion) 
        // Le pasamos DTOPosicionSolicitud.numeroPosicion como parametro pues el metodo generarPosicion asi trabaja.
        try {
            MONGenerarPosicionSolicitudHome monGenerarPosicionSolicitudHome = this.getMONGenerarPosicionSolicitudHome();
            MONGenerarPosicionSolicitud monGenerarPosicionSolicitud = monGenerarPosicionSolicitudHome.create();
            //Long lineaNumeroPosicion = new Long(dtoPosicionSolicitud.getNumeroPosicion().longValue());
            
            dtoCabeceraSolicitud = monGenerarPosicionSolicitud.generarPosicion(dtoCabeceraSolicitud, new Long(linea), Boolean.TRUE);
            UtilidadesLog.debug("obtengo: " + dtoCabeceraSolicitud);
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        // Si DTOCabeceraSolicitud.OK == False
        if(!dtoCabeceraSolicitud.getOK().booleanValue()) {
            //DTOPosicionSolicitud.tipoPosicion == ConstantesPED.ESTADO_POSICION_ANULADO 
            // vbongiov - inc 19138
            //dtoPosicionSolicitud.setTipoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
            UtilidadesLog.debug("no es: dtoCabeceraSolicitud.getOK(), al dtoPosicionSolicitud.setTipoPosicion(, le pongo: " + ConstantesPED.ESTADO_POSICION_ANULADO); 
            // Utilizar el servicio APPLoggingService para generar un log de error: [PED] [Validar cuadre de ofertas] Posición solicitud anulada 
            String mensajeLog = " [PED] [Validar cuadre de ofertas] Posición solicitud anulada ";
            BelcorpService.getInstance().log.info(mensajeLog);
        }
        
        UtilidadesLog.debug("finalmente, retorno : " + dtoCabeceraSolicitud);
        UtilidadesLog.info("MONPEDValidacionBean.generarPosicionRecuperacion(DTOSolicitudValidacion dtoe, DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion, DTOCabeceraSolicitud dtoCabeceraSolicitud): Salida ");
        return dtoCabeceraSolicitud;
    }

    /**
     * Deshace el proceso de recuperación obligatoria.
     * @autor gdmarzi
     * modificaciones BELC300019136 - 28/07/2005 - pperanzola
     */
    public DTOEstatusSolicitud revertirRecuperacionObligatoria(DTOSolicitudValidacion dto)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionObligatoria(DTOSolicitudValidacion dto): Entrada ");
        RecordSet posiciones;
        Long posicionRecuperacion;
        Long oidposicion;

        // posiciones = DAOPosicion.obtenerPosicionesFaltantesReversion(dto.oidSolicitud, dto.proceso.oidTipoPosicion, dto.proceso.oidSubTipoPosicion) 
        // La incidencia 9038 aclara que el tipo de posicion determina cuales son la que ser revierten
        DAOPosicion daoPosicion = new DAOPosicion();
        posiciones = daoPosicion.obtenerPosicionesFaltantesReversion(dto.getOidSolicitud(), dto.getProceso().getOidTipoPosicion(),
                dto.getProceso().getOidSubTipoPosicion());

        // Por cada elemento en posiciones 
        for(int i = 0; i < posiciones.getRowCount(); i++) {
            // Si dto.indSimulacion == False 
            if(!dto.getIndSimulacion().booleanValue()) {
                //posicionRecuperacion  = new Long(((BigDecimal)posiciones.getValueAt(i, "POSICIONRECUPERACION")).longValue());
                //daoPosicion.eliminarPosicion(posicionRecuperacion);
                posicionRecuperacion  = new Long(posiciones.getValueAt(i, "POSICIONRECUPERACION").toString());
                daoPosicion.actualizaFaltanteReversion(posicionRecuperacion);
            }

            oidposicion = new Long(posiciones.getValueAt(i, "OIDPOSICION").toString());
            daoPosicion.eliminarPosicion(oidposicion);
        }

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO 
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionObligatoria(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    /**
     *
     * @autor lcanas
     */
    public DTOEstatusSolicitud recuperacionVoluntaria(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionVoluntaria(DTOSolicitudValidacion dtoin): Entrada ");
        Long lPeriodoAnterior;
        Integer iFaltantes;
        boolean bPrimera;
        RecordSet rsPosiciones;
        RecordSet rsFaltantes;
        

        DAOPosicion daoPosicion = new DAOPosicion();
        IDAOCRA daoCra = new DAOCRA();
        lPeriodoAnterior = daoCra.obtienePeriodoAnterior(dtoin.getOidPeriodo());
        //UtilidadesLog.debug("el lPeriodoAnterior recuperado, es: " + lPeriodoAnterior);

        try {
            rsPosiciones = (RecordSet)daoPosicion.obtienerPosicionesRecuperacion(dtoin.getOidSolicitud());
            UtilidadesLog.debug("las posiciones de recuperacion son: " + rsPosiciones);

            for(int i = 0; i < rsPosiciones.getRowCount(); i++) {
                rsFaltantes = (RecordSet)daoPosicion.obtienerPosicionesFaltantesVenta(dtoin.getOidCliente(), lPeriodoAnterior,
                        //new Long(((BigDecimal)rsPosiciones.getValueAt(i, "DETALLEOFERTAANTERIOR")).longValue()));
                        new Long(rsPosiciones.getValueAt(i, 1).toString()));

                bPrimera = true;

                if(!rsFaltantes.esVacio()) {
                   UtilidadesLog.debug("comienzo a ciclar en rsFaltantes");
                   
                    for(int j = 0; j < rsFaltantes.getRowCount(); j++) {
                    
                        UtilidadesLog.debug("control de stock, es: " + rsFaltantes.getValueAt(j, "CONTROLSTOCK").toString());
                                
                        if(new BigDecimal(rsFaltantes.getValueAt(j, "CONTROLSTOCK").toString()).intValue() == ConstantesCMN.VAL_TRUE.intValue()) {
                            Integer iUnidadesMandadas = 
                            new Integer(rsFaltantes.getValueAt(j, "UNIDADESDEMANDADAS").toString());
                            UtilidadesLog.debug("(A) iUnidadesMandadas, es: " + iUnidadesMandadas);
                            
                            Integer iUnidadesComprometidas = 
                            new Integer(rsFaltantes.getValueAt(j, "UNIDADESCOMPROMETIDAS").toString());
                            UtilidadesLog.debug("(A) iUnidadesComprometidas, es: " + iUnidadesComprometidas);

                            iFaltantes = new Integer(iUnidadesMandadas.intValue() - iUnidadesComprometidas.intValue());
                            UtilidadesLog.debug("(A) entonces el ffte., es: " + iFaltantes);
                        } else {
                            Integer iUnidadesAtender = new Integer(rsFaltantes.getValueAt(j, "UNIDADESATENDER").toString());
                            UtilidadesLog.debug("(B) iUnidadesAtender, es: " + iUnidadesAtender);
                            
                            Integer iUnidadesComprometidas = new Integer(rsFaltantes.getValueAt(j, "UNIDADESCOMPROMETIDAS").toString());
                            UtilidadesLog.debug("(A) iUnidadesComprometidas, es: " + iUnidadesComprometidas);

                            iFaltantes = new Integer(iUnidadesAtender.intValue() - iUnidadesComprometidas.intValue());
                            UtilidadesLog.debug("(A) iFaltantes, es: " + iFaltantes);
                        }

                        if(iFaltantes.intValue() > 0) {
                            UtilidadesLog.debug("iFaltantes.intValue() > 0....");
                            
                            UtilidadesLog.debug("el ind de simulacion, para la sol: " + dtoin.getOidSolicitud().longValue() + ", es: " + dtoin.getIndSimulacion().booleanValue());
                            
                            if(!dtoin.getIndSimulacion().booleanValue()) {
                                UtilidadesLog.debug("dtoin.getIndSimulacion() == Boolean.FALSE, voy a actualizarEstado....");
                                daoPosicion.actualizarEstado(new Long(rsFaltantes.getValueAt(j, "OIDPOSICION").toString()),
                                    ConstantesPED.ESTADO_POSICION_RECUPERACION);
                            }  
                            if(bPrimera == true) {
                                bPrimera = false;
                                UtilidadesLog.debug("voy a act. posicion recuperacion........");  
                                daoPosicion.actualizarPosicionRecuperacion(new Long(rsPosiciones.getValueAt(i, 0).toString()), iFaltantes,
                                    dtoin.getProceso().getOidTipoPosicion(), dtoin.getProceso().getOidSubTipoPosicion(),
                                    new Long(rsFaltantes.getValueAt(j, 0).toString()));
                            } else {
                                UtilidadesLog.debug("voy a crear posicion recuperacion........");
                                daoPosicion.crearPosicionRecuperacion(new Long( rsPosiciones.getValueAt(i, 0).toString()), 
                                        iFaltantes,
                                        j);
                            }                                         
                        }
                         // end iFaltantes > 0
                    }
                     // end 2 for
                }     
            }
             // end 1 for
        } catch(MareException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.debug("retorno estatus validado, dtos: " + dtos);
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionVoluntaria(DTOSolicitudValidacion dtoin): Salida ");
        return dtos;
    }

    /**
     *
     * @autor lcanas
     */
    public DTOEstatusSolicitud revertirRecuperacionVoluntaria(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionVoluntaria(DTOSolicitudValidacion dto): Entrada ");
        boolean bPrimera = false;
        Long lDetalleOferta = new Long(0);

        es.indra.mare.common.mii.services.jdbcservice.RecordSet rsPosiciones;
        es.indra.mare.common.mii.services.jdbcservice.RecordSet rsFaltantes;

        DAOPosicion daoPosicion = new DAOPosicion();
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        try {
            dtos = revertirRecuperacionVoluntariaVenta(dto, "");
            /*rsPosiciones = (RecordSet)daoPosicion.obtenerPosicionesReversionVoluntaria(dto.getOidSolicitud(),
                    dto.getProceso().getOidTipoPosicion(), dto.getProceso().getOidSubTipoPosicion());

            //Por cada elemento en posiciones
            if(!rsPosiciones.esVacio())
                for(int i = 0; i < rsPosiciones.getRowCount(); i++) {
                    int iDetalleOferta = ((BigDecimal)rsPosiciones.getValueAt(i, "DETALLEOFERTA")).intValue();

                    if(lDetalleOferta.intValue() != iDetalleOferta) {
                        lDetalleOferta = new Long(((BigDecimal)rsPosiciones.getValueAt(i, "DETALLEOFERTA")).longValue());
                        bPrimera = true;
                    }

                    if(bPrimera) {
                        bPrimera = false;
                        daoPosicion.actualizaReversionVoluntaria(new Long(
                                ((BigDecimal)rsPosiciones.getValueAt(i, "OIDPOSICION")).longValue()));
                    } else
                        daoPosicion.eliminarPosicion(new Long(((BigDecimal)rsPosiciones.getValueAt(i, "OIDPOSICION")).longValue()));
                }*/
                 
        }  catch(MareException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        
      //  dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionVoluntaria(DTOSolicitudValidacion dto): Salida ");
        return dtos;
    }    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOEstatusSolicitud
     * @param dto
     * modificaciones  - BELC300018046 - pperanzola 
     */
    public DTOEstatusSolicitud validarControlStock(DTOSolicitudValidacion dto)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.validarControlStock(DTOSolicitudValidacion dto): Entrada ");
        Boolean bPosicion = null;
        Boolean bValido = null;
        Long lStock = null;
        Long lControl = null;
        Hashtable hashventa = null;
        Hashtable hashposicion = null;

        //var Long para validar Stock
        Long region = null;
        Long zona = null;
        Long tipoCliente = null;
        Long subTipoCliente = null;
        Long tipoClasificacion = null;
        Long clasificacion = null;
        Long tmpVentasVenta = null;
        Long tmpPosicVenta = null;

        // almacena las condiciones de devolucion del registro del recordset
        boolean[] bool = new boolean[11];

        DAOSolicitud daoSolic = new DAOSolicitud();
        DAOPosicion daoPosic = new DAOPosicion();
        DAOGestionStock daoGStoock = new DAOGestionStock();
        RecordSet solicitudes = new RecordSet();
        RecordSet posiciones = new RecordSet();
        RecordSet ventas = new RecordSet();

    
        solicitudes = daoSolic.obtenerTipificacionClienteRegionZona(dto.getOidSolicitud());
        posiciones = daoPosic.obtenerPosicionesSolicitud(dto.getOidSolicitud());
        ventas = daoGStoock.obtieneVentasStock(dto.getOidPeriodo(), solicitudes);

        //Por cada uno de los elementos en posiciones 
        //nivel 1
         if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
            UtilidadesLog.debug("Por cada uno de los elementos en posiciones =" +  posiciones.getRowCount());
            
        for(int i = 0; i < posiciones.getRowCount(); i++) {
            bPosicion = Boolean.FALSE;
            lStock = new Long(0);
            hashposicion = this.armarRecordSet(posiciones, i);
            tmpPosicVenta = ((posiciones.getValueAt(i,"VENTA")!=null)
                                    ? new Long (( posiciones.getValueAt(i,"VENTA")).toString())
                                    : null);
            //Por cada uno de los elementos en ventas 
            //nivel 2
            region = null;
            zona = null;
            tipoCliente = null;
            subTipoCliente = null;
            tipoClasificacion = null;
            clasificacion = null;
            UtilidadesLog.debug("primer if ");
            if (tmpPosicVenta!=null){
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("tmpPosicVenta \n" + tmpPosicVenta);
                  UtilidadesLog.debug("Por cada uno de los elementos en ventas \n" + ventas.getRowCount());
                }
                
                for(int j = 0; j < ventas.getRowCount(); j++) {
    
                    //Carga la fila de los recordset
                    tmpVentasVenta = ((ventas.getValueAt(j,"VENTA") != null)
                                            ? new Long (( ventas.getValueAt(j,"VENTA")).toString())
                                            : null);
                    if (tmpVentasVenta!= null && tmpVentasVenta.longValue() == tmpPosicVenta.longValue()){
                        hashventa = this.armarRecordSet(ventas, j);
        
        
                        //Valida las columnas sobre la cual haremos condiciones
        
                        bool = this.cargarBooleano(ventas, posiciones, i, j);
        
        
                        //Carga los long que seran los parametros para la funcion validarStock
                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
                          UtilidadesLog.debug("booleano[1]= \n" + bool[1]);
                          UtilidadesLog.debug("booleano[2]= \n" + bool[2]);                    
                          UtilidadesLog.debug("booleano[3]= \n" + bool[3]);
                          UtilidadesLog.debug("booleano[4]= \n" + bool[4]);           
                          UtilidadesLog.debug("booleano[5]= \n" + bool[5]);
                          UtilidadesLog.debug("booleano[6]= \n" + bool[6]);
                        }
                        
                        if(bool[1]) //REGION
                            region = new Long(hashventa.get("REGION").toString());
                        
                        if(bool[2]) //ZONA
                            zona = new Long(hashventa.get("ZONA").toString());
                        
                        if(bool[3]) //TIPOCLIENTE
                            tipoCliente = new Long(hashventa.get("TIPOCLIENTE").toString());
                        
                        if(bool[4])//SUBTIPOCLIENTE
                            //esto esta muuuuuyyy mal (SCS) ==>> subTipoCliente = new Long(hashventa.get("REGION").toString());
                            //subTipoCliente = new Long(hashventa.get("REGION").toString());
                            subTipoCliente = new Long(hashventa.get("SUBTIPOCLIENTE").toString()); 
        
                        if(bool[5])//TIPOCLASIFICACION
                            tipoClasificacion = new Long(hashventa.get("TIPOCLASIFICACION").toString());
                        
                        if(bool[6])//CLASIFICACION
                            clasificacion = new Long(hashventa.get("CLASIFICACION").toString());
        
                        //nivel 3
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                          UtilidadesLog.debug("booleano[0]= \n" + bool[0]);
                          
                        if(bool[0])  {//VENTA
                            bValido = this.validarStock(region, zona, tipoCliente, subTipoCliente, tipoClasificacion, clasificacion,
                                    solicitudes);
                            UtilidadesLog.debug("bValido= \n" + bValido);
                            //nivel 3.1
                            if(bValido.booleanValue()) {
                                bPosicion = Boolean.TRUE;
        
                                // nivel 3.1.1
                                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                                  UtilidadesLog.debug("bool[7] -- bool[9] \n" + bool[7] + "-" + bool[9]);
                                  
                                if(!bool[7] && bool[9]) // !PORCENTAJE && UNIDADES
                                    lControl = new Long(hashventa.get("UNIDADES").toString());
                                else {
                                    // nivel 3.1.2
                                    UtilidadesLog.debug("bool[8] \n" + bool[8]);
                                    if(bool[8]) { // UNIDADESATENDER && PORCENTAJE
                                        double porcentaje = new Double(hashventa.get("PORCENTAJE").toString()).doubleValue();
                                        double unidades = new Double(hashposicion.get("UNIDADESATENDER").toString()).doubleValue();
                                        double value = ((porcentaje * unidades) / 100);
                                        
                                        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
                                          UtilidadesLog.debug("porcentaje \n" + porcentaje);
                                          UtilidadesLog.debug("unidades \n" + unidades);
                                          UtilidadesLog.debug("value \n" + value);
                                        }  
                                        value = Math.round(value);
        
        
                                        Double pase = new Double(value);
                                        lControl = new Long(pase.longValue());
        
                                        
                                    }
                                }// fin nivel  3.1.2
                                
                                if(lStock.longValue() < lControl.longValue())
                                    lStock = lControl;
                               
                                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010     
                                  UtilidadesLog.debug("lStock \n" + lStock);
                                  UtilidadesLog.debug("lControl \n" + lControl);
                                }   
                                //fin nivel 3.1
                            } // fin if(bValido.booleanValue()) {
        
                            
                        }//fin nivel 3   
                    } //fin if (tmpVentasVenta!= null && tmpVentasVenta.longValue() == tmpPosicVenta.longValue())
                    
                    //fin de nivel 2		
                } // fin for(int j = 0; j < ventas.getRowCount(); j++) {
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
              UtilidadesLog.debug("bPosicion \n" + bPosicion);
              
            if(bPosicion.booleanValue()) {
                if(bool[10]) {//UNIDADESATENDER
                    Long v = new Long(hashposicion.get("UNIDADESATENDER").toString());
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
                      UtilidadesLog.debug("v \n" + v);
                      UtilidadesLog.debug("lStock \n" + lStock);
                      UtilidadesLog.debug("hashposicion.get(POSICION).toString() \n" + hashposicion.get("POSICION").toString());
                    }
                    
                    if(v.longValue() > lStock.longValue())
                        daoPosic.actualizarControlStock(new Long(hashposicion.get("POSICION").toString()), lStock);
                }
            }

            //fin nivel 1		  
        }
        /* Segun la inc - BELC300019904 - no importa si se hizo o no el update en la tabla 
         * igualmente se debe setear el estado como ESTADO_SOLICITUD_VALIDADO para dejar
         * constancia que la solicitud ha pasado por la validacion 
         */
        DTOEstatusSolicitud dto1 = new DTOEstatusSolicitud();
        dto1.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarControlStock(DTOSolicitudValidacion dto): Salida ");
        return dto1;
    }

    private boolean[] cargarBooleano(RecordSet ventas, RecordSet posiciones, int i, int j) {
    
        UtilidadesLog.info("MONPEDValidacionBean.cargarBooleano(RecordSet ventas, RecordSet posiciones, int i, int j): Entrada ");
        boolean[] b = new boolean[11];

        Hashtable hashventa = this.armarRecordSet(ventas, j);
        Hashtable hashposicion = this.armarRecordSet(posiciones, i);

        for(int z = 10; z != -1; z--)
            b[z] = false;

        for(int k = 0; k <= 10; k++) {
            switch(k) {
                case 0:

                    if(hashventa.containsKey("VENTA") && hashposicion.containsKey("VENTA"))
                        b[k] = true;

                    break;
                case 1:

                    if(hashventa.containsKey("REGION"))
                        b[k] = true;

                    break;
                case 2:

                    if(hashventa.containsKey("ZONA"))
                        b[k] = true;

                    break;
                case 3:

                    if(hashventa.containsKey("TIPOCLIENTE"))
                        b[k] = true;

                    break;
                case 4:

                    if(hashventa.containsKey("SUBTIPOCLIENTE"))
                        b[k] = true;

                    break;
                case 5:

                    if(hashventa.containsKey("TIPOCLASIFICACION"))
                        b[k] = true;

                    break;
                case 6:

                    if(hashventa.containsKey("CLASIFICACION"))
                        b[k] = true;

                    break;
                case 7:

                    if(hashventa.containsKey("PORCENTAJE"))
                        b[k] = true;

                    break;
                case 8:

                    if(hashposicion.containsKey("UNIDADESATENDER") && hashventa.containsKey("PORCENTAJE"))
                        b[k] = true;

                    break;
                case 9:

                    if(hashventa.containsKey("UNIDADES"))
                        b[k] = true;

                    break;
                case 10:

                    if(hashposicion.containsKey("UNIDADESATENDER"))
                        b[k] = true;
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.cargarBooleano(RecordSet ventas, RecordSet posiciones, int i, int j): Salida ");
        return b;
    }

    public DTOEstatusSolicitud revertirControlStock(DTOSolicitudValidacion dto)
        throws MareException {
        
        

        UtilidadesLog.info("MONPEDValidacionBean.revertirControlStock(DTOSolicitudValidacion dto): Entrada ");
        
        // Se llama al método DAOPosicion.revertirControlStock pasándole como parámetro de entrada dto.oidSolicitud. 
        DAOPosicion daoPosicion = new DAOPosicion();
        daoPosicion.revertirControlStock(dto.getOidSolicitud());

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);

        UtilidadesLog.info("MONPEDValidacionBean.revertirControlStock(DTOSolicitudValidacion dto): Salida ");


        return dtoEstatusSolicitud;
    }

    /**
    * Se hace saber al inicio de la campaña qué códigos de venta son de Liquidación y
    * el stock de estos productos se asignará mientras haya existencias.
    * No se asegura que vaya a haber stock para todas las órdenes de compra de modo que
    * la consultora asume que sus unidades demandadas pueden no ser atendidas.
    * @author Guido Pons
    * fecha 27/08/04
    */
    public DTOEstatusSolicitud validarControlLiquidacion(DTOSolicitudValidacion dto)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.validarControlLiquidacion(DTOSolicitudValidacion dto): Entrada ");
        boolean bPosicion;
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        DAOPosicion daoPosicion = new DAOPosicion();
        DAOGestionStock daoGestionStock = new DAOGestionStock();


        RecordSet solicitud = daoSolicitud.obtenerTipificacionClienteRegionZona(dto.getOidSolicitud());

        RecordSet posiciones = daoPosicion.obtenerTipoPosicionesSolicitud(dto.getOidSolicitud());

        RecordSet ventas = daoGestionStock.obtieneVentasLiquidacion(new Long(solicitud.getValueAt(0, "PERIODO").toString()));

        
        for(int i = 0; i < posiciones.getRowCount(); i++) {
            UtilidadesLog.debug("entre a for de posiciones");
            bPosicion = false;

            for(int j = 0; j < ventas.getRowCount(); j++) {
                UtilidadesLog.debug("entre a for de ventas");
                if(ventas.getValueAt(j, "VENTA").equals(posiciones.getValueAt(i, "VENTA"))) {
                    UtilidadesLog.debug(">>>> venta: " + (String) ventas.getValueAt(j, "VENTA"));
                    bPosicion = validarStock(bigToLong(ventas.getValueAt(j, "REGION")), bigToLong(ventas.getValueAt(j, "ZONA")),
                            bigToLong(ventas.getValueAt(j, "TIPOCLIENTE")), bigToLong(ventas.getValueAt(j, "SUBTIPOCLIENTE")),
                            bigToLong(ventas.getValueAt(j, "TIPOCLASIFICACION")), bigToLong(ventas.getValueAt(j, "CLASIFICACION")),
                            solicitud).booleanValue();
                            
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                            
                      UtilidadesLog.debug(">>>> bPosicion: " + bPosicion);
                      
                    if(bPosicion)
                        break;
                }
            }

            if(bPosicion) {
                daoPosicion.actualizarControlLiquidacion(bigToLong(posiciones.getValueAt(i, "POSICION")));
            }    
        }

        DTOEstatusSolicitud dtoEstatusSolic = new DTOEstatusSolicitud();
        dtoEstatusSolic.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarControlLiquidacion(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolic;
        
    }

  /**
   * @author Emilio Noziglia
   * @since 25/10/2005
   * @param DTOSolicitudValidacion dto  
   * @return DTOEstatusSolicitud 
   * @throws MareException
   * @description descripcion
   * @reference UBEL004
   */ 
    public DTOEstatusSolicitud validarAsignacionStock(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarAsignacionStock(DTOSolicitudValidacion dto): Entrada ");
        DTOEstatusSolicitud retorno = new DTOEstatusSolicitud();
        

        try {
            DAODatosReclamo daoDatosReclamo = new DAODatosReclamo();
            RecordSet rDatosCliente = null;
            DAOSolicitud daosol = new DAOSolicitud();
            String user = ctx.getCallerPrincipal().getName();

            DAOPED daoped = new DAOPED(user);


            DAOPosicion daoposicion = new DAOPosicion();
            RecordSet alternativos = null;
            RecordSet otros = null;

            RecordSet solicitud = daosol.obtenerSolicitudAsignacionStock(dto.getOidSolicitud());

            BigDecimal mov_asig = (BigDecimal)solicitud.getValueAt(0, 5);

            if(mov_asig == null) {

                retorno.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);

                return retorno; //cambiar esto
            }
            
            // Agregado por ssantana, 26/9/2005, GCC-REC-003
            String  sOidModulo = solicitud.getValueAt(0,16).toString();
            //Long oidModulo = new Long( bigOidModulo.longValue());
            if ( sOidModulo.equals(ConstantesSEG.MODULO_REC) ) {
               //BigDecimal bigOidSolicitud = new BigDecimal( solicitud.getValueAt(0,0).toString());
               //BigDecimal bigOidPais = new BigDecimal(solicitud.getValueAt(0,9).toString());
               Long oidSolicitud = Long.valueOf( solicitud.getValueAt(0,0).toString());
               Long oidPais = Long.valueOf( solicitud.getValueAt(0,9).toString());
               
               rDatosCliente = daoDatosReclamo.obtenerDatosCliente(oidSolicitud,
                                                                   oidPais);  
            }
            // Fin agregado por ssantana, 26/9/2005, GCC-REC-003

            boolean bPedidos = false;
            boolean bIncentivos = false;

            BigDecimal orden = (BigDecimal)solicitud.getValueAt(0, 8);


            if( (orden != null) && 
                (orden.intValue() == ConstantesCMN.VAL_TRUE.intValue())) {
                bPedidos = true;
            }

            BigDecimal pais = (BigDecimal)solicitud.getValueAt(0, 9);
            BigDecimal almacen = (BigDecimal)solicitud.getValueAt(0, 2);

            /*RecordSet tipossolicitud = daoped.obtieneTipoSolicitudOperacion(Long.valueOf(pais.toString()));
            UtilidadesLog.debug("SCS........daoped.obtieneTipoSolicitudOperacion(, retorna.....: " + tipossolicitud);*/

            BigDecimal sol_tiposol = (BigDecimal)solicitud.getValueAt(0, 7);
            if (solicitud.getValueAt(0, 17)!=null){
                bIncentivos=solicitud.getValueAt(0, 17).toString().equals("1")?true:false;
            }
             
            BigDecimal oidperiodo = (BigDecimal)solicitud.getValueAt(0, 12);
            RecordSet tiposproceso = daoped.obtieneTipoPosicionProceso();
            
            
            RecordSet posiciones =  daoposicion.obtenerPosicionesAsignacionStock(dto.getOidSolicitud(), Long.valueOf(oidperiodo.toString()), 
                                                                                Long.valueOf(pais.toString()), Long.valueOf(almacen.toString()));
                                                                                
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                                                                                
              UtilidadesLog.debug("SCS........posiciones, es: " + posiciones);
            
            boolean bCompleto = true;
            boolean bStock = false;
            Long lTipoEstr = null;
            Long lNumOfer = null;
            Long lSaldo = null;
            RecordSet completos = null;
            RecordSet totales = new RecordSet();
            
            BigDecimal despacho = null;
            totales.addColumn("oidposicion");
            totales.addColumn("estado");
            totales.addColumn("numeroposicion");
            totales.addColumn("tipoposicion");
            totales.addColumn("subtipoposicion");
            totales.addColumn("venta");
            totales.addColumn("producto");
            totales.addColumn("unidadesdemandadas");
            totales.addColumn("unidadesatender");
            totales.addColumn("unidadescomprometidas");
            totales.addColumn("netototaldocumento");
            totales.addColumn("contabletotaldocumento");
            totales.addColumn("controlstock");
            totales.addColumn("tipooferta");
            totales.addColumn("despachocompleto");
            totales.addColumn("numerooferta");
            totales.addColumn("tipoestrategia");
            totales.addColumn("recuperacionautomatica");
            totales.addColumn("descripcion");
            totales.addColumn("detalleOferta"); //incidencia 9105
            totales.addColumn("val_sald");
            totales.addColumn("unidemandareal"); // Agregado por HRCS - Cambio 20070340

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("voy a recorrer posiciones, : " + posiciones);
              
            HashMap hashSaldosProductos = new HashMap();
            for(int i = 0; i < posiciones.getRowCount(); i++){
                hashSaldosProductos.put(this.bigDecimalToLong(posiciones.getValueAt(i,6)),this.bigDecimalToLong(posiciones.getValueAt(i,20)));
            }            
            //hashSaldosProductos = this.obtenerSaldosProducto(pais, almacen, arrayProductos);
            
            for(int i = 0; i < posiciones.getRowCount(); i++) {
                bCompleto = false;
                despacho = (BigDecimal)posiciones.getValueAt(i, 14);
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("posicion: " + i + ", codigo de vta.: " + 
                                    posiciones.getValueAt(i, 5));
                  UtilidadesLog.debug("posicion: " + i + ", despachocompleto : " + 
                                    despacho);
                  UtilidadesLog.debug("posicion: " + i + ", unidemandareal : " +  posiciones.getValueAt(i, 21));  //Agregado por HRCS 
                }
                
                if( (posiciones.getValueAt(i, 5) != null) &&
                    (despacho!=null) && 
                    (despacho.longValue() == ConstantesCMN.VAL_TRUE.longValue())) {
                
                    bCompleto = true;
                    bStock = true;
                    completos = new RecordSet();
                    
                    lTipoEstr = new Long(((BigDecimal)posiciones.getValueAt(i, 16)).longValue());
                    lNumOfer = new Long(((BigDecimal)posiciones.getValueAt(i, 15)).longValue());
                
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("posicion: " + i + ", lTipoEstr : " + 
                                        lTipoEstr);
                      UtilidadesLog.debug("posicion: " + i + ", lNumOfer : " + 
                                        lNumOfer);
                    }                    
                    
                    completos.addColumn("oidposicion");
                    completos.addColumn("estado");
                    completos.addColumn("numeroposicion");
                    completos.addColumn("tipoposicion");
                    completos.addColumn("subtipoposicion");
                    completos.addColumn("venta");
                    completos.addColumn("producto");
                    completos.addColumn("unidadesdemandadas");
                    completos.addColumn("unidadesatender");
                    completos.addColumn("unidadescomprometidas");
                    completos.addColumn("netototaldocumento");
                    completos.addColumn("contabletotaldocumento");
                    completos.addColumn("controlstock");
                    completos.addColumn("tipooferta");
                    completos.addColumn("despachocompleto");
                    completos.addColumn("numerooferta");
                    completos.addColumn("tipoestrategia");
                    completos.addColumn("recuperacionautomatica");
                    completos.addColumn("descripcion");
                    completos.addColumn("detalleOferta"); //incidencia 9105
                    completos.addColumn("val_sald");
                    completos.addColumn("unidemandareal"); // Agregado por HRCS - Cambio 20070340

                    while((i < posiciones.getRowCount()) && (posiciones.getValueAt(i, 16) != null) && 
                           (lTipoEstr != null) && (new BigDecimal(posiciones.getValueAt(i, 16).toString()).longValue() == lTipoEstr.longValue()) && 
                           (lNumOfer != null)  && (posiciones.getValueAt(i, 15) != null) && 
                           (new BigDecimal(posiciones.getValueAt(i, 15).toString()).longValue() == lNumOfer.longValue())) {
                           
                        if(bStock = true) {
                                                
                            //lSaldo = obtenerSaldo(Long.valueOf(pais.toString()), Long.valueOf(almacen.toString()),
                            //                      Long.valueOf(producto.toString()));
                              
                            if (hashSaldosProductos.containsKey(this.bigDecimalToLong(posiciones.getValueAt(i,6)))){
                                lSaldo = (Long)hashSaldosProductos.get(this.bigDecimalToLong(posiciones.getValueAt(i,6)));
                            } else {
                                lSaldo = new Long(0);
                            }
                            
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                              UtilidadesLog.debug("el saldo es: " + lSaldo);

                            //BigDecimal uni = new BigDecimal(posiciones.getValueAt(i, 8).toString());
                            Long unidades = new Long(((BigDecimal)posiciones.getValueAt(i, 8)).longValue());
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                              UtilidadesLog.debug("unidades a atender es: " + unidades);

                            if(lSaldo.longValue() < unidades.longValue()) {
                                bStock = false;                             //no tengo stock
                            } else {
                                completos.addRow(posiciones.getRow(i));
                            }
                        }

                        i++;
                    }

                    if(bStock == true) {
                        for (int p = 0; p < completos.getRowCount(); p++) {
                           totales.addRow(completos.getRow(p));
                        }
                    }
                    if (i < posiciones.getRowCount()){
                        if (!((posiciones.getValueAt(i, 16) != null) && 
                               (lTipoEstr != null) && (new BigDecimal(posiciones.getValueAt(i, 16).toString()).longValue() == lTipoEstr.longValue()) && 
                               (lNumOfer != null)  && (posiciones.getValueAt(i, 15) != null) && 
                               (new BigDecimal(posiciones.getValueAt(i, 15).toString()).longValue() == lNumOfer.longValue()))) {
                            i--;   
                        }
                    }
                }

                if (bCompleto == false) {
                   totales.addRow(posiciones.getRow(i));
                }
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("SCS totales aca es: " + totales); 
              
            ArrayList arrayOidPosiciones = new ArrayList();
            
            if (totales.getRowCount() != posiciones.getRowCount()){
                for (int i=0; i < posiciones.getRowCount();i++){
                   Long oidPosi = new Long(((BigDecimal)posiciones.getValueAt(i, 0)).longValue());;
                   Boolean existePosicion = Boolean.FALSE;                   
                   for (int z=0; z < totales.getRowCount();z++){
                      Long oidPosiTotales = new Long(((BigDecimal)totales.getValueAt(z, 0)).longValue());;
                      if (oidPosi.longValue() == oidPosiTotales.longValue()){
                           existePosicion = Boolean.TRUE;
                           break;
                      }                   
                   }
                   if (!existePosicion.booleanValue()){
                      arrayOidPosiciones.add(oidPosi);
                  }
                }    
            }
            
            if (arrayOidPosiciones.size() > 0){
                this.actualizarUnidadesComprometidas(arrayOidPosiciones);
            }
            arrayOidPosiciones.clear();
          
            if(totales.getRowCount() > 0) {
                UtilidadesLog.debug("voy a actualizarStock (A)");
                alternativos = actualizarStock(totales, 
                                               solicitud, 
                                               tiposproceso, 
                                               Boolean.valueOf(bPedidos), 
                                               Boolean.valueOf(bIncentivos), 
                                               Boolean.FALSE, 
                                               dto, 
                                               rDatosCliente);
                                               
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("alternativos, es : " + alternativos);        

                if(alternativos!=null && alternativos.getRowCount() > 0) {
                    UtilidadesLog.debug("voy a actualizarStock (B)");
                    otros = actualizarStock(alternativos, 
                                            solicitud, 
                                            tiposproceso, 
                                            Boolean.valueOf(bPedidos), 
                                            Boolean.valueOf(bIncentivos),
                                            Boolean.TRUE, 
                                            dto,
                                            rDatosCliente);
                                            
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                                            
                      UtilidadesLog.debug("otros, es : " + otros);     //supuestamente otros siempre vendra vacio!!           
                }  
                Long estado = null;

                for(int i = 0; i < totales.getRowCount(); i++) {
                    if (totales.getValueAt(i, 1) != null)  {
                       estado = Long.valueOf(totales.getValueAt(i, 1).toString());
                    }
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("estado, es : " + estado);                
                      
                    if( estado != null && estado.longValue() != ConstantesPED.ESTADO_POSICION_ANULADO.longValue()) {
                        
                       enviarMensajes(solicitud,
                                      totales.getRow(i), 
                                      tiposproceso, 
                                      Boolean.TRUE, 
                                      Boolean.TRUE, //  Modificado 01/04/2008 - Incidencia Sicc20080578
                                      Boolean.FALSE,
                                      dto);
                                      
                       UtilidadesLog.debug("envie mensaje!! (totales)");                    
                    }        
                }

                if (alternativos != null) {
                  if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                    UtilidadesLog.debug("alternativos != null, es: " + alternativos);                    
                    
                  for(int i = 0; i < alternativos.getRowCount(); i++) {
                      if(alternativos.getValueAt(i, 1)!=null)  {
                        estado = Long.valueOf( alternativos.getValueAt(i, 1).toString() );    
                      }
                      if( estado != null && estado.longValue() != ConstantesPED.ESTADO_POSICION_ANULADO.longValue()) {
                         enviarMensajes(solicitud, 
                                         alternativos.getRow(i), 
                                         tiposproceso, 
                                         Boolean.TRUE, 
                                         Boolean.TRUE,
                                         Boolean.FALSE, 
                                         dto);
                         UtilidadesLog.debug("envie mensaje!! (alternativos)");    
                      }        
                  }
                }   
            }

            retorno.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPEDValidacionBean.validarAsignacionStock(DTOSolicitudValidacion dto): Salida ");
        return retorno;
    }

  /**
   * @author Emilio Noziglia
   * @since 23/10/2005
   * @param DTOSolicitudValidacion dto
   * @return DTOEstatusSolicitud 
   * @throws MareException
   * @reference UBEL004
   */ 
    public DTOEstatusSolicitud revertirAsignacionStock(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirAsignacionStock(DTOSolicitudValidacion dto): Entrada ");

        UtilidadesLog.info("| dto " + dto);

        DTOEstatusSolicitud retorno = new DTOEstatusSolicitud();

        Boolean bReserva = Boolean.FALSE;
        Boolean bIncentivos = Boolean.FALSE;
        DAOSolicitud daoSolictud = new DAOSolicitud();
        String user = ctx.getCallerPrincipal().getName();
        DAOPED daoped = new DAOPED(user);
        DAOPosicion daoposicion = new DAOPosicion();
        RecordSet solicitud = daoSolictud.obtenerSolicitudAsignacionStock(dto.getOidSolicitud());
        UtilidadesLog.debug("solicitud: " + solicitud);

        BigDecimal pais = new BigDecimal(solicitud.getValueAt(0, 9).toString());
        RecordSet tiposSolicitud = daoped.obtieneTipoSolicitudOperacion(new Long(pais.longValue()));
        UtilidadesLog.debug("tiposSolicitud: " + tiposSolicitud);

        BigDecimal pasaje = new BigDecimal(1);

        for(int i = 0; i < tiposSolicitud.getRowCount(); i++) {
            pasaje = new BigDecimal(solicitud.getValueAt(0, 7).toString());
            Long sol_tiposol = new Long(pasaje.longValue());
            pasaje = new BigDecimal(tiposSolicitud.getValueAt(i, 0).toString());
            Long tip_tiposol = new Long(pasaje.longValue());
            if(sol_tiposol.longValue() == tip_tiposol.longValue()) {
                UtilidadesLog.debug("Match en " + sol_tiposol);
                bIncentivos = bIncentivos.TRUE;
                
            }
        }

        // Modificado por ssantana, 2/11/2005 
        // Estaban mal los índices. 
        /*if((solicitud.getValueAt(0, 6) != null) || (solicitud.getValueAt(0, 7) != null))
            bReserva = bReserva.TRUE;*/
        if((solicitud.getValueAt(0, 5) != null) || 
                                     (solicitud.getValueAt(0, 6) != null)) {
            UtilidadesLog.debug("bReserva se pone a TRUE");
            bReserva = bReserva.TRUE;                                  
        }
        // Fin modificacion x ssantana, 2/11/2005
            

        RecordSet posiciones = daoposicion.obtenerTipoPosicionesSolicitud(dto.getOidSolicitud());
        UtilidadesLog.debug("posiciones: " + posiciones);

        Long posicion = null;

        for(int i = 0; i < posiciones.getRowCount(); i++) {
            pasaje = new BigDecimal(posiciones.getValueAt(i, 0).toString());
            posicion = new Long(pasaje.longValue());

            try {
                daoposicion.actualizarUnidadesComprometidas(posicion, new Long(0));
            } catch(Exception e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            if(bIncentivos.booleanValue() == true) {
                try {
                    BolsaFantantesLocalHome bolsaLH = this.getBolsaFantantesLocalHome();
                    BolsaFantantesLocal bolsaL = bolsaLH.findByUK(posicion);
                    bolsaLH.remove(bolsaL);
                } catch(NoResultException e) {
                    /* no se coloca nada dado que en caso que no se encuentre registros no es*/
                } catch(PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ",e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }

        if(bReserva.booleanValue() == true)
            reversionMovimientosAlmacen(solicitud);

        String[] mensajes = new String[10];
        mensajes[0] = ConstantesMSG.MENSAJE_PED01;
        mensajes[1] = ConstantesMSG.MENSAJE_PED02;
        mensajes[2] = ConstantesMSG.MENSAJE_PED03;
        mensajes[3] = ConstantesMSG.MENSAJE_PED07;
        
        // Agregado por ssantana, 27/09/2005, GCC-REC-003
        mensajes[4] = ConstantesMSG.MENSAJE_REC02;
        mensajes[5] = ConstantesMSG.MENSAJE_REC03;
        mensajes[6] = ConstantesMSG.MENSAJE_REC04;
        mensajes[7] = ConstantesMSG.MENSAJE_REC05;
        mensajes[8] = ConstantesMSG.MENSAJE_REC06;
        mensajes[9] = ConstantesMSG.MENSAJE_REC07;
        // Fin agregado por ssantana, 27/09/2005, GCC-REC-003

        try {
            eliminarMensajes(dto.getOidSolicitud(), dto.getOidPais(), mensajes);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        daoSolictud.anularReporteFaltantes(dto.getOidSolicitud());


        retorno.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirAsignacionStock(DTOSolicitudValidacion dto): Salida ");
        return retorno;
    }


    /**
     * A cada consultora que pasa pedido le incluye los mensajes de faltantes anunciados ordenados por catálogo y página.
     * @author Fernando Coronel
     * Paquete SICC-DMCO-PED-201-354-N004
     * fecha 30/08/04
     * modificaciones - BELC300018048 - 25/07/2005 - pperanzola  se corrige la obtencion de los registros a mayusculas  
     *                                                           se corrige la declaracion de el vector ventas a String []           
     */
    public DTOEstatusSolicitud generarMensajesFaltantesAnunciados(DTOSolicitudValidacion dto)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.generarMensajesFaltantesAnunciados(DTOSolicitudValidacion dto): Entrada ");
        DTOEstatusSolicitud dtoRet = new DTOEstatusSolicitud();

        try {
            DAOSolicitud daoSolicitud = new DAOSolicitud();

            //  Se llama al método DAOSolicitud.obtenerTipificacionClienteRegionZona pasándole como parámetro de entrada dto.oidSolicitud 
            //  El método retorna un RecordSet (registro) que contiene tantos registros como tipificaciones tenga el cliente de la solicitud, con las columnas (donde las primeras columnas hasta oidcliente inclusive se repetirían en cada registro): 
            //    pais, 
            //    marca, 
            //    canal, 
            //    periodo, 
            //    region (puede ser null), 
            //    zona (puede ser null), 
            //    oidcliente, 
            //    tipocliente (puede ser null), 
            //    subtipocliente (puede ser null), 
            //    tipoclasificacion (puede ser null), 
            //    clasificacion (puede ser null) 
            RecordSet registro = daoSolicitud.obtenerTipificacionClienteRegionZona(dto.getOidSolicitud());

            if(!registro.getValueAt(0, "CANAL").toString().equals(ConstantesSEG.CANAL_VD)) { //  Si registro(0).canal <> ConstantesSEG.CANAL_VD  
                //    Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO 
                dtoRet.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);

                //    Se termina el caso de uso 
                return dtoRet;
            }

            //  Fin del Si 
            //  Se llama al método obtienePeriodoActual de la interface IPeriodos pasándole como entrada registro(0).pais, registro(0).marca y registro(0).canal. El método retorna DTOPeriodo (dtoP).    
            DTOPeriodo dtoP = getMONPeriodosHome().create().obtienePeriodoActual(new Long(registro.getValueAt(0, "PAIS").toString()),
                    new Long(registro.getValueAt(0, "MARCA").toString()), new Long(registro.getValueAt(0, "CANAL").toString()));

            DAOCRA daoCRA = new DAOCRA();

            //  Se llama al método obtienePeriodoSiguiente de la interface IDAOCRA pasándole como entrada dtoP.oid. El método retorna el oid del periodo siguiente al actual (oidSiguiente).     
            Long oidSiguiente = daoCRA.obtienePeriodoSiguiente(dtoP.getOid());

            //  Si oidSiguiente == null 
            //    Se genera un log con APPLoggingService y la siguiente información: 
            //        dto.oidSolicitud (solicitud para la que no se puede realizar el caso de uso), 
            //        dtoP.oid (oid del periodo para el que no se encuentra periodo siguiente) y 
            //        el mensaje "[PED] [Generar Mensajes de Faltantes Anunciados] No se encuentra el periodo siguiente." 
            //    Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_ERRONEO 
            //    Se termina el caso de uso. 
            //  Fin del Si 
            if(oidSiguiente == null) {
                String mensaje = dto.getOidSolicitud() + ", " + dtoP.getOid()
                    + "[PED] [Generar Mensajes de Faltantes Anunciados] No se encuentra el periodo siguiente.";
                LogAPP.info(mensaje);
                dtoRet.setEstatus(ConstantesPED.ESTADO_SOLICITUD_ERRONEO);

                return dtoRet;
            }

            //  Se llama al método DAOGestionStock.obtieneVentasPeriodo pasándole como parámetro de entrada oidSiguiente. El método retorna un RecordSet (registroV)
            DAOGestionStock daoGestionStock = new DAOGestionStock();
            RecordSet registroV = daoGestionStock.obtieneVentasPeriodo(oidSiguiente);

            Boolean bMensaje = null;
            Vector ventas = new Vector();
            String [] ventasAux = null;
            UtilidadesLog.debug("for :" );
            ArrayList dtosMensajes = new ArrayList();
            for(int i = 0; i < registroV.getRowCount(); i++) { //  Por cada uno de los elementos en registroV
                //  bMensaje = procesaVenta(registroV(i).venta, ventas) 
                ventasAux = null;
                ventasAux = new String [ventas.size()];
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                  UtilidadesLog.debug("ventas.size()" + ventas.size() );
                  
                ventas.toArray(ventasAux);
                bMensaje = procesaVenta(registroV.getValueAt(i, "VENTA").toString(), ventasAux);
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                  UtilidadesLog.debug("bMEnsaje :" + bMensaje );
                  
                if((bMensaje != null) && bMensaje.booleanValue()){
                    //  bMensaje = validarStock(registroV(i).region, registroV(i).zona, registroV(i).tipocliente, registroV(i).subtipocliente, registroV(i).tipoclasificacion, registroV(i).clasificacion, registro)
                    bMensaje = validarStock(getCampoLongRecordSet(registroV, i, "REGION"),
                            getCampoLongRecordSet(registroV, i, "ZONA"), getCampoLongRecordSet(registroV, i, "TIPOCLIENTE"),
                            getCampoLongRecordSet(registroV, i, "SUBTIPOCLIENTE"),
                            getCampoLongRecordSet(registroV, i, "TIPOCLASIFICACION"),
                            getCampoLongRecordSet(registroV, i, "CLASIFICACION"), registro);

                }//  Fin del Si 
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                  UtilidadesLog.debug("bMEnsaje 2 :" + bMensaje );
                  
                if((bMensaje != null) && bMensaje.booleanValue()) { //  Si bMensaje 

                    //  Se añade un elemento al array ventas con el valor registroV(i).venta
                    if(registroV.getValueAt(i, "VENTA") != null)
                        ventas.add(registroV.getValueAt(i, "VENTA").toString());
                    DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                      UtilidadesLog.debug("pais :" + dto.getOidPais() );
                      
                    dtoB.setOidPais(dto.getOidPais());
                    dtoB.setCodigoMensaje(ConstantesMSG.MENSAJE_PED04);
                    dtoB.setOidCliente(getCampoLongRecordSet(registro, 0, "OIDCLIENTE"));
                    dtoB.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                      UtilidadesLog.debug("seteado constanteSEG.ModuloPed" );
                       
                    dtoB.setDatoVariable1(registro.getValueAt(0, "PERIODO").toString());
                    dtoB.setDatoVariable2(((registroV.getValueAt(i, "VENTA") == null) ? null
                        : registroV.getValueAt(i, "VENTA").toString()));
                    dtoB.setDatoVariable3(registroV.getValueAt(i, "CATALOGO").toString());
                    dtoB.setDatoVariable4(((registroV.getValueAt(i, "PAGINACATALOGO") == null) ? null
                        : registroV.getValueAt(i, "PAGINACATALOGO").toString()));
                    dtoB.setListaConsultoras(ConstantesMSG.NO);
                    dtoB.setCodigoPatron(null);
                    dtosMensajes.add(dtoB);
                }
            }
            this.getMONGestionMensajesLocalHome().create().insertarDatosMensajesBatch((DTOBuzonMensajes[])dtosMensajes.toArray(new DTOBuzonMensajes[dtosMensajes.size()]));
        } catch(NamingException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException createException) {
            ctx.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e);
        }

        //  Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        dtoRet.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.generarMensajesFaltantesAnunciados(DTOSolicitudValidacion dto): Salida ");
        return dtoRet;
    }

    /**
     * getCampoLongRecordSet. Función auxiliar para obtener el valor Long de un campo NUMBER(x) de la BD,
     * teniendo en cuenta de que puede llegar a ser nulo.
     */
    private Long getCampoLongRecordSet(RecordSet rs, int row, String campo)
        throws Exception {
        if(rs.getValueAt(row, campo) == null)
            return null;

        return new Long(rs.getValueAt(row, campo).toString());
    }

    /**
     * Llama al caso de uso de BEL Revertir Movimientos de Almacén.
     * @author Mario Bobadilla
     * 02/09/04
     */
    private void reversionMovimientosAlmacen(RecordSet solicitud)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.reversionMovimientosAlmacen(RecordSet solicitud): Entrada ");

        UtilidadesLog.debug("| dto " + solicitud);
        DTOReversionMovimiento dto = new DTOReversionMovimiento();
        Hashtable tabla = this.armarRecordSet(solicitud, 0);

        if(tabla.isEmpty()) {}
        else {
            if(solicitud.getValueAt(0, 9) != null) {
                //BigDecimal pais = new BigDecimal(solicitud.getValueAt(0, 9).toString());
                dto.setPais(new Long(solicitud.getValueAt(0, 9).toString()));
            }

            if(solicitud.getValueAt(0, 14) != null) {
                //BigDecimal subacceso = (BigDecimal)solicitud.getValueAt(0, 14);
                dto.setSubacceso(new Long(solicitud.getValueAt(0, 14).toString()));
            }

            if(solicitud.getValueAt(0, 1) != null) {
                //BigDecimal numerosolitud = (BigDecimal)solicitud.getValueAt(0, 1);
                dto.setNumDocumento(solicitud.getValueAt(0, 1).toString());
            }

            dto.setNumLinea(null);
            dto.setOperacion(ConstantesBEL.PED001);


            try {
                MONGenerarMovimientoAlmacenHome mONGenerarMovimientoAlmacenHome = getMONGenerarMovimientoAlmacenHome();
                mONGenerarMovimientoAlmacenHome.create().reversionMovimientoAlmacen(dto);
            } catch(Exception ex) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",ex);
                throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.reversionMovimientosAlmacen(RecordSet solicitud): Salida ");
    }

  /**
   * @author Emilio Noziglia
   * @since 24/10/2005
   * @param RecordSet posiciones, RecordSet solicitud, RecordSet tiposproceso, Boolean pedidos,
   *        Boolean incentivos, Boolean alternativo, DTOSolicitudValidacion dtosv, RecordSet datosCliente
   * @return RecordSet 
   * @throws MareException
   * @reference UBEL004
   */ 
    private RecordSet actualizarStock(RecordSet posiciones, RecordSet solicitud, RecordSet tiposproceso, Boolean pedidos,
        Boolean incentivos, Boolean alternativo, DTOSolicitudValidacion dtosv, RecordSet datosCliente) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.actualizarStock(RecordSet posiciones, RecordSet solicitud, RecordSet tiposproceso, Boolean pedidos, Boolean incentivos, Boolean alternativo, DTOSolicitudValidacion dtosv): Entrada ");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("| posiciones" + posiciones);
          UtilidadesLog.debug("| solicitud" + solicitud);
          UtilidadesLog.debug("| tiposproceso" + tiposproceso);
          UtilidadesLog.debug("| pedidos " + pedidos + " incentivos " + incentivos + 
                            " alternativo " + alternativo);
        }

        try {
            // SPLATAS - INC.23198 - 06/06/2006
            Integer indicadorEbel = null;
            
            RecordSet nuevo = null;
            BigDecimal pais = new BigDecimal(solicitud.getValueAt(0, 9).toString());
            DAOPosicion daoposi = new DAOPosicion();
            RecordSet alternativos = new RecordSet();
            Integer iFaltantes = null;
            Boolean bBolsa = null;
            DTOMovimientoAlmacen dto = new DTOMovimientoAlmacen();
            DTOMovimientoAlmacenCabecera dtoCabe = new DTOMovimientoAlmacenCabecera();
            dtoCabe.setNumeroDocumento(null);
            dtoCabe.setOidTipoMovimientoAlmacen(null);
            dtoCabe.setFecha(new Date(System.currentTimeMillis()));
            dtoCabe.setOidAlmacenEntrada(null);
            dtoCabe.setOidAlmacenSalida(null);
            /*            ArrayList miArray = new ArrayList();
                        for(int i = 0; i<posiciones.getRowCount();i++){
                          miArray.add(posiciones.getRow(i).get(13));
                        }
               dto.setDetalle(miArray);*/
            //BigDecimal marca = null;
            
            // Agregado por ssantana, 27/09/2005, GCC-REC-003
            String sOidModulo = solicitud.getValueAt(0, 16).toString();
            // Fin agregado por ssantana, 27/09/2005, GCC-REC-003
            
            if(solicitud.getValueAt(0, 10) != null) {
                //marca = new BigDecimal(solicitud.getValueAt(0, 10).toString());
                dtoCabe.setOidMarca(Long.valueOf(solicitud.getValueAt(0, 10).toString()));
            } else {
                dtoCabe.setOidMarca(null);
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("la marca quedo seteada, a: " + dtoCabe.getOidMarca()); 
             
            //BigDecimal canal = null;
            if(solicitud.getValueAt(0, 11) != null) {
                //canal = (BigDecimal)solicitud.getValueAt(0, 11);
                dtoCabe.setOidCanal(Long.valueOf(solicitud.getValueAt(0, 11).toString()));
            } else {
                dtoCabe.setOidCanal(null);
            }
              
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
              UtilidadesLog.debug("el canal quedo seteado, a: " + dtoCabe.getOidCanal());     

            BigDecimal acceso = null;
            if(solicitud.getValueAt(0, 13) != null) {
                acceso = new BigDecimal(solicitud.getValueAt(0, 13).toString());
                dtoCabe.setOidAcceso(Long.valueOf(solicitud.getValueAt(0, 13).toString()));
            } else {
                dtoCabe.setOidAcceso(null);
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
              UtilidadesLog.debug("el acceso quedo seteado, a: " + dtoCabe.getOidAcceso());         

            BigDecimal subacceso = null;

            if(solicitud.getValueAt(0, 14) != null) {
                subacceso = new BigDecimal(solicitud.getValueAt(0, 14).toString());
                dtoCabe.setOidSubacceso(Long.valueOf(solicitud.getValueAt(0, 14).toString()));
            } else {
                dtoCabe.setOidSubacceso(null);
            }
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("el SUBacceso quedo seteado, a: " + dtoCabe.getOidSubacceso());    

            //BigDecimal periodo = null;

            if(solicitud.getValueAt(0, 12) != null) {
                //periodo = (BigDecimal)solicitud.getValueAt(0, 12);
                dtoCabe.setOidPeriodo(Long.valueOf(solicitud.getValueAt(0, 12).toString()));
            } else {
                dtoCabe.setOidPeriodo(null);
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("el periodo quedo seteado, a: " + dtoCabe.getOidPeriodo());        

            if(solicitud.getValueAt(0, 15) != null) {
                dtoCabe.setObservaciones(solicitud.getValueAt(0, 15).toString());
            } else {
                dtoCabe.setObservaciones(null);
            }

            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                
              UtilidadesLog.debug("las observ. quedaron seteadas, a: " + dtoCabe.getObservaciones());            

            /*if (solicitud.getValueAt(0, 16) != null) {
                         dtoCabe.setOidTipoMovimientoAlmacen((String) solicitud.getValueAt(0, 16));
                     } else {
                         dtoCabe.setOidTipoMovimientoAlmacen(null);
                     }*/
            BigDecimal movimientoasignacion = new BigDecimal(solicitud.getValueAt(0, 5).toString());
            BigDecimal almacen = new BigDecimal(solicitud.getValueAt(0, 2).toString());
            BigDecimal numerosolicitud = new BigDecimal(solicitud.getValueAt(0, 1).toString());
            dtoCabe.setIndicadorNoGenerarCabecera(Boolean.FALSE);
            
            if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("almacen, es: " + almacen);
              UtilidadesLog.debug("dtoCabe, es: " + dtoCabe);
            }  
            
            dto.setCabecera(dtoCabe);

            ArrayList datos = new ArrayList();
            DTOMovimientoAlmacenDetalle deta = null;
            pais = new BigDecimal(solicitud.getValueAt(0, 9).toString());
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("las posiciones son: " + posiciones);

            for(int i = 0; i < posiciones.getRowCount(); i++) {
                deta = new DTOMovimientoAlmacenDetalle();
                if(dtoCabe.getOidCanal() != null) {
                    deta.setOidCanal(dtoCabe.getOidCanal());
                } else {
                    deta.setOidCanal(null);
                }

                if(acceso != null) {
                    deta.setOidAcceso(Long.valueOf(acceso.toString()));
                } else {
                    deta.setOidAcceso(null);
                }
                   
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                   
                  UtilidadesLog.debug("seteo el acceso a: " + deta.getOidAcceso());

                if(subacceso != null) {
                    deta.setOidSubacceso(Long.valueOf(subacceso.toString()));
                } else {
                    deta.setOidSubacceso(null);
                }
                  
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
                  UtilidadesLog.debug("seteo el SUBacceso a: " + deta.getOidSubacceso());    

                deta.setNumeroMovimiento(null);

                if(movimientoasignacion != null) {
                    deta.setOidTipoMovimientoAlmacen(Long.valueOf(movimientoasignacion.toString()));
                } else {
                    deta.setOidTipoMovimientoAlmacen(null);
                }
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
                  UtilidadesLog.debug("seteo el TipoMovimientoAlmacen a: " + deta.getOidTipoMovimientoAlmacen());         
                    

                if(almacen != null) {
                    deta.setOidAlmacenSalida(Long.valueOf(almacen.toString()));
                } else {
                    deta.setOidAlmacenSalida(null);
                }
                deta.setOidAlmacenEntrada(null);

                if(posiciones.getValueAt(i, 6) != null) {
                    BigDecimal producto = new BigDecimal(posiciones.getValueAt(i, 6).toString());
                    deta.setOidProducto(Long.valueOf(producto.toString()));
                } else {
                    deta.setOidProducto(null);
                }

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                    
                  UtilidadesLog.debug("seteo el producto a: " + deta.getOidProducto());             

                if(posiciones.getValueAt(i, 8) != null) {
                    BigDecimal unidadesatender = new BigDecimal(posiciones.getValueAt(i, 8).toString());
                    deta.setCantidad(Long.valueOf(unidadesatender.toString()));
                } else {
                    deta.setCantidad(null);
                }
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                    
                  UtilidadesLog.debug("seteo la cantidad a: " + deta.getCantidad());                 

                if(posiciones.getValueAt(i, 10) != null) {
                    BigDecimal netototaldocumento = new BigDecimal(posiciones.getValueAt(i, 10).toString());
                    deta.setPrecioVentaNeto(netototaldocumento);
                } else {
                    deta.setPrecioVentaNeto(null);
                }
                
                BigDecimal contabletotaldocumento = new BigDecimal(posiciones.getValueAt(i, 11).toString());

                if(contabletotaldocumento != null) {
                    deta.setPrecioContable(contabletotaldocumento);
                } else {
                    deta.setPrecioContable(null);
                }

                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                    
                  UtilidadesLog.debug("seteo el PrecioContable a: " + deta.getPrecioContable());                     

                if(posiciones.getValueAt(i, 13) != null) {
                    BigDecimal tipoOferta = new BigDecimal(posiciones.getValueAt(i, 13).toString());
                } else {
                    deta.setOidTipoOferta(null);
                }

                if (posiciones.getValueAt(i, 2) != null) {
                    BigDecimal numeroposicion = new BigDecimal(posiciones.getValueAt(i, 2).toString());
                    deta.setNumeroPosicionReferencia(Integer.valueOf(numeroposicion.toString()));
                } else {
                    deta.setNumeroPosicionReferencia(null);
                }
                    
                // Agregado por ssantana, inc. 21023, 27/09/2005
                String sCodigoVenta = null;
                if(posiciones.getValueAt(i,5)!=null){
                    sCodigoVenta = posiciones.getValueAt(i,5).toString();
                }
                deta.setCodigoVenta(sCodigoVenta);
                // Fin Agregado por ssantana, inc. 21023, 27/09/2005

                deta.setOidIdioma(ConstantesSEG.IDIOMA_DEFECTO);
                deta.setNumeroDocumentoReferencia(Long.valueOf(numerosolicitud.toString()));
                deta.setOperacion(ConstantesBEL.COD_PED001);
                deta.setOidPais(Long.valueOf(pais.toString()));
                // esto esta harcodeado por incidencia 8497
                deta.setOidIdioma(new Long(1));
                datos.add(deta);
            }

            dtoCabe.setOidIdioma(new Long(1));
            dto.setDetalle(datos);
            dtoCabe.setOidPais(Long.valueOf(pais.toString()));
            dto.setCabecera(dtoCabe);
            dto.setOidPais(Long.valueOf(pais.toString()));
            // esto esta harcodeado por incidencia 8497
            dto.setOidIdioma(new Long(1));

            MONGenerarMovimientoAlmacenHome almacenLH = getMONGenerarMovimientoAlmacenHome();
            DTOReportePedidos dtos = almacenLH.create().grabarMovimientoAlmacenYStock(dto);

            DTOMovimientoAlmacenDetalle registro = null;
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
              UtilidadesLog.debug("las LineasDetalle son: " + dtos.getLineasDetalle());                     
            
            DAODatosReclamo daoDatosReclamo = new DAODatosReclamo();
            StringBuffer sCodigoVenta = new StringBuffer();
            StringBuffer sOidProducto = new StringBuffer();
            for(int i = 0; i < dtos.getLineasDetalle().size(); i++) {
                registro = (DTOMovimientoAlmacenDetalle)dtos.getLineasDetalle().get(i);
                bBolsa = bBolsa.TRUE;
                // ---- CodigoVenta 
                //String sCodigoVenta = (String) solicitud.getValueAt(0,)
                if(registro.getCodigoVenta()!=null){
                    sCodigoVenta.append(registro.getCodigoVenta()).append(", ");
                }
                if(registro.getOidProducto()!=null){
                    sOidProducto.append(registro.getOidProducto()).append(", ");
                }
            }
            if (sCodigoVenta.length()>0){
                // SPLATAS - Inc. Bloq : SC-REC-03-1 - 03/05/2006
                sCodigoVenta.delete(sCodigoVenta.length()-2,sCodigoVenta.length());
            }
            if (sOidProducto.length()>0){
                sOidProducto.delete(sOidProducto.length()-2,sOidProducto.length());
            }
            // Agregado por ssantana, 26/9/2005, GCC-REC-003
            // ----- Oid Solicitud
            BigDecimal bigOidSolicitud = new BigDecimal(solicitud.getValueAt(0,0).toString());
            Long oidSolicitud = Long.valueOf(bigOidSolicitud.toString());
            
            // ---- Pais 
            BigDecimal bigPaisSolicitud = new BigDecimal( solicitud.getValueAt(0,9).toString());
            Long oidPaisSolicitud = null;
            if ( bigPaisSolicitud != null ) {
               oidPaisSolicitud = Long.valueOf(bigPaisSolicitud.toString());
            }
            
            // ---- Canal
            BigDecimal bigCanal = new BigDecimal(solicitud.getValueAt(0,11).toString());
            Long oidCanalSolicitud = null;
            if ( bigCanal != null ) {
               oidCanalSolicitud = Long.valueOf(bigCanal.toString());
            }
            
            // ---- Acceso
            BigDecimal bigAcceso = new BigDecimal( solicitud.getValueAt(0,13).toString());
            Long oidAccesoSolicitud = null;
            if ( bigAcceso != null ) {
               oidAccesoSolicitud = Long.valueOf(bigAcceso.toString());
            }
            
            // ---- Subacceso 
            BigDecimal bigSubacceso = new BigDecimal( solicitud.getValueAt(0,14).toString());
            Long oidSubaccesoSolicitud = null;
            if ( bigSubacceso != null ) {
              oidSubaccesoSolicitud = Long.valueOf(bigSubacceso.toString());
            }
            
            //se modifica el orden de los parametros, en base al orden de los parametros del procedure
            RecordSet rDatosMensaje = daoDatosReclamo.obtenerDatosMensaje(oidSolicitud,
                                                                         oidPaisSolicitud,
                                                                         oidSubaccesoSolicitud,
                                                                         oidAccesoSolicitud,
                                                                         oidCanalSolicitud,
                                                                         sCodigoVenta.toString(),
                                                                         sOidProducto.toString());                                                                       
                                                                                                 
            // Fin agregado por ssantana, 26/9/2005, GCC-REC-003
            for(int i = 0; i < dtos.getLineasDetalle().size(); i++) {
                registro = (DTOMovimientoAlmacenDetalle)dtos.getLineasDetalle().get(i);
                
                RecordSet rDatosMensajeFinal = new RecordSet();
                if(registro.getCodigoVenta()!=null){
                   rDatosMensajeFinal = filtrarRecorsetDatosMensajes(rDatosMensaje, registro.getCodigoVenta());
                }else{
                   rDatosMensajeFinal = filtrarRecorsetDatosMensajes(rDatosMensaje, registro.getOidProducto()!=null?
                                                                registro.getOidProducto().toString():null);
                }
                // SPLATAS -  INC.23198 - 06/06/2006
                if ( !rDatosMensajeFinal.esVacio() ) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("indicador "+rDatosMensajeFinal.getValueAt(0, 11));
                      
                    if(rDatosMensajeFinal.getValueAt(0, 11)!=null){
                        indicadorEbel = new Integer(rDatosMensajeFinal.getValueAt(0, 11).toString());
                    }
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("indicadorEbel = " + indicadorEbel);
                }
                
                Long oidposicion = new Long(posiciones.getValueAt(i, 0).toString());
                
                //if ( !rDatosMensaje.esVacio() ) {
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("la cantidad, es: " + registro.getCantidad());     
                  UtilidadesLog.debug("registro, es: " + registro);     
                }  
                
                //if ( rDatosMensaje.esVacio() ) {
                if ( (registro.getMovimientoOk().booleanValue() == true) || 
                     ( (registro.getMovimientoOk().booleanValue() == false) &&
                         (registro.getCantidad().intValue() >=0) ) ) {
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("voy a actualizar UnidadesComprometidas, con: " +
                                        oidposicion + 
                                        " --- " + registro.getCantidad());                     
                    
                    daoposi.actualizarUnidadesComprometidas(oidposicion,
                                                            registro.getCantidad());
                    posiciones.setValueAt(registro.getCantidad(), i, 9);  
                    if ( !rDatosMensajeFinal.esVacio() ) {
                        // Agregado por ssantana, 26/09/2005, GCC-REC-003
                        if (sOidModulo.equals(ConstantesSEG.MODULO_REC)  &&  
                            // SPLATAS - INC.23198 - 06/06/2006
                            indicadorEbel != null  &&
                            indicadorEbel.toString().equals("1")) {
                        
                            DTOBuzonMensajes dtoBuzonMensajes = 
                                this.armaDTOBuzonMensajes(oidPaisSolicitud,
                                    datosCliente,
                                    //rDatosMensaje,
                                    rDatosMensajeFinal,
                                    solicitud,
                                    posiciones,
                                    registro,
                                    i, 
                                    true);
                            
                            String sCodigoMensaje = dtoBuzonMensajes.getCodigoMensaje();
                           
                            dtoBuzonMensajes = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtoBuzonMensajes);
                                    
                            this.crearSolicitudMensajes(oidSolicitud, 
                                oidPaisSolicitud, 
                                sCodigoMensaje,
                                dtoBuzonMensajes.getOid());
                                                                    
                        }
                        
                        if ( sOidModulo.equals(ConstantesSEG.MODULO_REC)  && 
                             !registro.getMovimientoOk().booleanValue()  &&
                             registro.getCantidad().intValue() == 0  &&
                             // SPLATAS - INC.23198 - 06/06/2006
                             indicadorEbel !=  null  &&  
                             indicadorEbel.toString().equals("1")){
                             
                            DTOBuzonMensajes dtoBuzonMensajes = 
                                this.armaDTOBuzonMensajes(oidPaisSolicitud,
                                    datosCliente,
                                    //rDatosMensaje,
                                    rDatosMensajeFinal,
                                    solicitud,
                                    posiciones,
                                    registro,
                                    i, 
                                    false);
                                                                  
                            String sCodigoMensaje = dtoBuzonMensajes.getCodigoMensaje();
                           
                            dtoBuzonMensajes = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtoBuzonMensajes);
                                    
                            this.crearSolicitudMensajes(oidSolicitud, oidPaisSolicitud,sCodigoMensaje,dtoBuzonMensajes.getOid());
                                                                  
                        }
                        // Fin agregado por ssantana, 26/9/2005, GCC-REC-003
                    }else {
                      UtilidadesLog.debug("rDatosMensaje es vacío. No se genera Mensaje.");
                    }
               } 
                
                // Se agrega a la clausula del If, "(bigOidModulo.longValue() != 15)",
                // por cambio GCC-REC-003. (ssantana, 27/09/2005)
                if ( (!sOidModulo.equals(ConstantesSEG.MODULO_REC))  && 
                     (registro.getMovimientoOk().booleanValue() == false) &&
                     (registro.getCantidad().longValue() == 0) &&
                     (posiciones.getValueAt(i,5) != null)) { 

                    if (alternativo.booleanValue() == false) {
                    
                      UtilidadesLog.debug("es alternativo, lo obtengo.....");                     
                      nuevo = obtenerProductoAlternativo(posiciones.getRow(i),
                                                         solicitud, 
                                                         tiposproceso, 
                                                         dtosv);
                                                         
                      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                                                              
                        UtilidadesLog.debug("el nuevo, es: " + nuevo);                     
                        
                      if (nuevo != null) {
                        if(nuevo.getRowCount() == 1) {
                            bBolsa = bBolsa.FALSE;
                            //tengo que definir las columnas del record-set destino, para lo q' recorro el origen..
                            int limite = nuevo.getColumnCount(); 
                            for (int j=0; j<limite; j++) {
                                alternativos.addColumn(new Long(j).toString());        
                            }
                            alternativos.addRow(nuevo.getRow(0));
                            
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                              UtilidadesLog.debug("el alternativo (registro 0!), es: " + alternativos.getRow(0));                                                 
                        }
                      }                       
                    } else {
                      UtilidadesLog.debug("no es alternativo, anulo posicion.....");
                      daoposi.anularPosicion(oidposicion);
                      posiciones.setValueAt(ConstantesPED.ESTADO_POSICION_ANULADO, i, 1);
                      UtilidadesLog.debug("envio mensaje.....");
                      enviarMensajes(solicitud, 
                                     posiciones.getRow(i), 
                                     tiposproceso, 
                                     Boolean.TRUE, 
                                     Boolean.FALSE, 
                                     Boolean.TRUE, dtosv);
                    }
                }
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("veo tema de recuperacion automatica registro.getMovimientoOk().booleanValue() / pedidos.booleanValue() / posiciones.getValueAt(i,5): " + registro.getMovimientoOk().booleanValue() + " - " + pedidos.booleanValue() + " - " + posiciones.getValueAt(i,5));
                  
                if ((registro.getMovimientoOk().booleanValue() == false) &&
                    (pedidos.booleanValue() == true) &&
                    (posiciones.getValueAt(i,5) != null)) {
                    //recuperacion automatica!
                    UtilidadesLog.debug("es recuperacion automatica.....");
                    BigDecimal recuperacionAutomatica = (posiciones.getValueAt(i, 17) == null) ? new BigDecimal(0)
                    : new BigDecimal(posiciones.getValueAt(i, 17).toString());                        
                    
                    // Se agrega a la clausula del If, "(bigOidModulo.longValue() != 15)",
                    // por cambio GCC-REC-003. (ssantana, 27/09/2005)
                    if ( (!sOidModulo.equals(ConstantesSEG.MODULO_REC)) && 
                         (recuperacionAutomatica.intValue() == ConstantesCMN.VAL_TRUE.intValue()) ) {           
                      UtilidadesLog.debug("voy a activarRecuperacionObligatoria.....");
                      daoposi.activarRecuperacionObligatoria(oidposicion);
                    }
                }    

                BigDecimal unidadesatender = (posiciones.getValueAt(i, 8) == null) ? new BigDecimal(0)
                : new BigDecimal(posiciones.getValueAt(i, 8).toString());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("unidades por atender, es: " + unidadesatender);

                BigDecimal unidadescomprometidas = (posiciones.getValueAt(i, 9) == null) ? new BigDecimal(0)
                : new BigDecimal(posiciones.getValueAt(i, 9).toString());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("unidades unidadescomprometidas, es: " + unidadescomprometidas);

                iFaltantes = new Integer(unidadesatender.intValue() - unidadescomprometidas.intValue());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("los faltantes que tengo, son: " + iFaltantes);
                // Se agrega a la clausula del If, "(bigOidModulo.longValue() != 15)",
                // por cambio GCC-REC-003. (ssantana, 27/09/2005)
                if( (!sOidModulo.equals(ConstantesSEG.MODULO_REC)) && 
                    (incentivos.booleanValue() == true) && 
                    (iFaltantes.intValue() > 0) && 
                    (bBolsa.booleanValue() == true) ) {
                      BolsaFantantesLocalHome bolsaLH = this.getBolsaFantantesLocalHome();
                      Timestamp fecha = new Timestamp(System.currentTimeMillis());
                      UtilidadesLog.debug("cree bolsa de faltantes...............");
                      BolsaFantantesLocal bolsaL = bolsaLH.create(Long.valueOf(iFaltantes.toString()),
                                                                  fecha,
                                                                  oidposicion);
                      bolsaL.setOidSolicitudPosicion(oidposicion);
                      bolsaL.setNumeroUnidadesFaltantes(Long.valueOf(iFaltantes.toString()));
                      bolsaL.setFechaAlta(new Timestamp(System.currentTimeMillis()));
                }
            } //lazo, for!!
            
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
              UtilidadesLog.debug("retorno alternativos.....: " + alternativos);
            
            UtilidadesLog.info("MONPEDValidacionBean.actualizarStock(RecordSet posiciones, RecordSet solicitud, RecordSet tiposproceso, Boolean pedidos, Boolean incentivos, Boolean alternativo, DTOSolicitudValidacion dtosv): Entrada ");
            return alternativos;
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
    
    private RecordSet filtrarRecorsetDatosMensajes (RecordSet r, String cv){
        RecordSet rSalida = new RecordSet();
        Vector column = new Vector();
        column = r.getColumnIdentifiers();
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("COLUMNAS -> "+column);
          
        rSalida.setColumnIdentifiers(column);
        
         if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010      
           UtilidadesLog.info("rSalida vacio "+rSalida);
           
        for ( int i = 0 ; i < r.getRowCount() ; i++ ){
            if (r.getValueAt(i,10) != null) {
              if (r.getValueAt(i,10).toString().equals(cv)){
                  rSalida.addRow(r.getRow(i));
              }
            }
        }
        
        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                        
          UtilidadesLog.debug("rSalida "+rSalida);
          
       return rSalida;    
        
    }
 /*    private RecordSet filtrarRecorsetDatosMensajes (RecordSet r, String cv){
        RecordSet rSalida = new RecordSet();
        for ( int i = 0 ; i < r.getRowCount() ; i++ ){
            if (r.getValueAt(i,10).toString().equals(cv)){
                rSalida.addRow(r.getRow(i));
            }
        }
        return rSalida;    
    }*/

    private Long obtenerSaldo(Long pais, Long almacen, Long producto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.obtenerSaldo(Long pais, Long almacen, Long producto): Entrada ");

        try {
            EstadosMercanciaLocalHome estadoLH = new EstadosMercanciaLocalHome();
            EstadosMercanciaLocal estadoL = estadoLH.findByUK(pais, ConstantesBEL.COD_EST_LIBRE_DISP);
            StockLocalHome stockLH = new StockLocalHome();

            StockLocal stockL = stockLH.findByClaveUnica(almacen, estadoL.getOid(), producto);
            UtilidadesLog.info("MONPEDValidacionBean.obtenerSaldo(Long pais, Long almacen, Long producto): Salida ");
            return stockL.getSaldo();
        } catch(NoResultException e) {
            return 0L;
            //ctx.setRollbackOnly();
            //UtilidadesLog.error("Exception: ",e);
            //throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private RecordSet obtenerProductoAlternativo(Object posicion, RecordSet solicitud, RecordSet tiposproceso, DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.debug("MONPEDValidacionBean.obtenerProductoAlternativo(Object posicion, RecordSet solicitud, RecordSet tiposproceso, DTOSolicitudValidacion dto): Entrada ");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
          UtilidadesLog.debug("| posicion" + posicion);
          UtilidadesLog.debug("| solicitud" + solicitud);
          UtilidadesLog.debug("| tiposproceso" + tiposproceso);
        }  

        Vector posi = (Vector)posicion;
        RecordSet productoalternativo = null;
        Boolean bstock = Boolean.FALSE;
        BigDecimal perio = (BigDecimal)solicitud.getValueAt(0, 12);
        Long lsaldo = null;
        DAOPosicion daoposicion = new DAOPosicion();

        try {
            MONMantenimientoMFHome matriz = getMONMantenimientoMFHome();
            DTOSalida dtos = matriz.create().obtenerProductosAlternativos(new Long(perio.longValue()), (String)posi.get(5));

            RecordSet salida = dtos.getResultado();
            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
              UtilidadesLog.debug("PRODUCTOS ALTERNATIVOS obtenidos: " + salida);
             
            BigDecimal pais = null;
            BigDecimal almacen = null;
            BigDecimal prod_alter = null;
            BigDecimal unidadesAtender = null;
            BigDecimal oidPosi = null;
            BigDecimal periodo = null;

            // Modificado por SICC20070334 - Rafael Romero - 07/09/2007
            if ((salida != null) && (salida.getRowCount() > 0)) {
                unidadesAtender = (BigDecimal)posi.get(8);
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                  UtilidadesLog.debug("unidadesAtender es: " + unidadesAtender);
                  
                for(int i = 0; i < salida.getRowCount(); i++) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                      UtilidadesLog.debug("Recorriendo alternativo["+i+"]");
                    
                    pais = (BigDecimal)solicitud.getValueAt(0, 9);
                    almacen = (BigDecimal)solicitud.getValueAt(0, 2);
                    periodo = (BigDecimal)solicitud.getValueAt(0, 12); // Se requiere para buscar a la Matriz de Facturacion
                    prod_alter = (BigDecimal)salida.getValueAt(i, 1);
                    
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010
                      UtilidadesLog.debug("OIDPRD.ALTERNATIVO["+salida.getValueAt(i, 1)+"], CODPROD.ALTERNATIVO["+salida.getValueAt(i, 0)+"]");
                      UtilidadesLog.debug("idioma["+dto.getOidIdioma()+"], pais["+pais+"], almacen["+almacen+"], periodo["+periodo+"]");
                    }  
                      
                    lsaldo = obtenerSaldo(new Long(pais.longValue()), new Long(almacen.longValue()), new Long(prod_alter.longValue()));
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                      UtilidadesLog.debug("lsaldo es: " + lsaldo);
                    
                    if (lsaldo.longValue() >= unidadesAtender.longValue() && unidadesAtender.longValue()>0) {
                      
                        bstock = bstock.TRUE;
                        
                        // Modificado por SICC20070334 - Rafael Romero - 08/08/2007
                        productoalternativo = daoposicion.insertarAlternativo(Long.valueOf(posi.get(0).toString()),
                                                                            new Long(periodo.longValue()), 
                                                                            (Vector)salida.getRow(i),
                                                                            new Long(pais.longValue()),
                                                                            dto.getOidIdioma(),
                                                                            new Long(almacen.longValue())
                                                                            );
                        // Fin modificado SICC20070334
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                          UtilidadesLog.debug("el productoalternativo obtenido es: " + productoalternativo);

                        // [2] Modificado por SICC20070334 - Rafael Romero - 13/09/2007
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010
                          UtilidadesLog.debug("voy a anular posicion con el oid de posicion: " + Long.valueOf(posi.get(0).toString()));
                        daoposicion.anularPosicion( Long.valueOf(posi.get(0).toString()) );
                        posi.set(1, ConstantesPED.ESTADO_POSICION_ANULADO);
                        UtilidadesLog.debug("anule posicion!!");
                        // [2] Fin Modificado SICC20070334 - 13/09/2007
                        
                        break;
                    }
                }
            }
            // Fin modifcado SICC20070334 - 07/09/2007
            
            posicion = posi;

            if(bstock.booleanValue() == false)
                enviarMensajes(solicitud, posicion, tiposproceso, Boolean.TRUE, Boolean.FALSE, Boolean.TRUE, dto);   //  Modificado 01/04/2008 - Incidencia Sicc20080578
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug("MONPEDValidacionBean.obtenerProductoAlternativo(Object posicion, RecordSet solicitud, RecordSet tiposproceso, DTOSolicitudValidacion dto): Salida ");
        return productoalternativo;
    }

    private void enviarMensajes(RecordSet solicitud, Object posicion, RecordSet tiposproceso, Boolean recuperacion,
        Boolean controlstock, Boolean anulacion, DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.enviarMensajes(RecordSet solicitud, Object posicion, RecordSet tiposproceso, Boolean recuperacion, Boolean controlstock, Boolean anulacion, DTOSolicitudValidacion dto): Entrada ");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("| posicion" + posicion);
          UtilidadesLog.debug("| solicitud" + solicitud);
          UtilidadesLog.debug("| tiposproceso" + tiposproceso);
          UtilidadesLog.debug("| recuperacion " + recuperacion + " controlstock " + controlstock + " anulacion " + anulacion);
        }  

        Vector posici = (Vector)posicion;
        BigDecimal tip_tipoposicion = null;
        BigDecimal tip_subtipoposicion = null;
        BigDecimal pos_tipoposicion = null;
        BigDecimal pos_subtipoposicion = null;

        try {
            if(recuperacion.booleanValue()) {
                BigDecimal lproceso = new BigDecimal(0);


                for(int i = 0; i < tiposproceso.getRowCount(); i++) {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("recorriendo tiposproceso: " + i); 
                    
                    if(tiposproceso.getValueAt(i, 1)!=null){
                        tip_tipoposicion = new BigDecimal(tiposproceso.getValueAt(i, 1).toString());
                    }
                    if(tiposproceso.getValueAt(i, 2)!=null){
                        tip_subtipoposicion = new BigDecimal(tiposproceso.getValueAt(i, 2).toString());
                    }
                    if(posici.get(3)!=null){
                        pos_tipoposicion = new BigDecimal(posici.get(3).toString());    
                    }
                    if(posici.get(4)!=null){
                        pos_subtipoposicion = new BigDecimal(posici.get(4).toString());
                    }
                    
                    if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                        UtilidadesLog.debug("tip_tipoposicion: " + tip_tipoposicion); 
                        UtilidadesLog.debug("tip_subtipoposicion: " + tip_subtipoposicion); 
                        UtilidadesLog.debug("pos_tipoposicion: " + pos_tipoposicion); 
                        UtilidadesLog.debug("pos_subtipoposicion: " + pos_subtipoposicion); 
                    }
                    
                    if((tip_tipoposicion != null) && (pos_tipoposicion != null) && (tip_subtipoposicion != null)
                        && (pos_subtipoposicion != null)) {
                        
                        if((tip_tipoposicion.longValue() == pos_tipoposicion.longValue())
                            & (tip_subtipoposicion.longValue() == pos_subtipoposicion.longValue())) {
                            
                            if(tiposproceso.getValueAt(i, 0)!=null) {
                                lproceso = new BigDecimal(tiposproceso.getValueAt(i, 0).toString());    
                            }
                            if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                              UtilidadesLog.debug("lproceso: " + lproceso); 
                            
                            break;
                        }
                    }
                }


                if (lproceso != null) {
                  if(lproceso.longValue() == ConstantesProcesosPED.PROCESO_P205.longValue()) {
                      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                        UtilidadesLog.debug("voy a generarMensajeRecuperacion (1), con (solic.-posic.): " + solicitud + " - " + posicion); 
                        
                      generarMensajeRecuperacion(ConstantesMSG.MENSAJE_PED01, solicitud, posicion);

                      if(anulacion.booleanValue() == true)
                          //esto estaba taponado SCS (26/08/2005)
                          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                            UtilidadesLog.debug("voy a reversionRecuperacionObligatoriaMismoPeriodo, con: " + dto);
                            
                          this.reversionRecuperacionObligatoriaMismoPeriodo(dto);
                  }

                  if(lproceso.longValue() == ConstantesProcesosPED.PROCESO_P210.longValue()) {
                      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                        UtilidadesLog.debug("voy a generarMensajeRecuperacion (2), con (solic.-posic.): " + solicitud + " - " + posicion); 
                        
                      generarMensajeRecuperacion(ConstantesMSG.MENSAJE_PED02, solicitud, posicion);

                      if(anulacion.booleanValue() == true)
                          //tapon.reversionRecuperacionVoluntariaMismoPeriodo();
                        //Inc. 9212
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                          UtilidadesLog.debug("voy a revertirRecuperacionVoluntaria, con: " + dto); 
                          
                        this.revertirRecuperacionVoluntaria(dto);
                  }

                  if(lproceso.longValue() == ConstantesProcesosPED.PROCESO_P215.longValue()) {
                      if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                        UtilidadesLog.debug("voy a generarMensajeRecuperacion (3), con (solic.-posic.): " + solicitud + " - " + posicion); 
                        
                      generarMensajeRecuperacion(ConstantesMSG.MENSAJE_PED03, solicitud, posicion);

                      if(anulacion.booleanValue() == true)
                          //tapon.reversionRecuperacionObligatoria();
                        //Inc. 9212	
                        if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                          UtilidadesLog.debug("voy a revertirRecuperacionObligatoria, con: " + dto); 
                          
                        this.revertirRecuperacionObligatoria(dto);
                  }

                  if(lproceso.longValue() == ConstantesProcesosPED.PROCESO_P235.longValue()) {
                      if(anulacion.booleanValue() == true){
                          //tapon.reversionAgregados();
                          //Incidencia 9105
                          DTOSolicitudReversion dtoSR = new DTOSolicitudReversion();
                          Vector posi = (Vector)posicion;
                          BigDecimal det = new BigDecimal(posi.get(19).toString());
                          dtoSR = cargarSolicitudReversion(dto);
                          dtoSR.setOidDetalleOferta(new Long(det.longValue()));
                          
                          if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                            UtilidadesLog.debug("voy a revertirAgregadosCV, con: " + dtoSR); 
                            
                          this.revertirAgregadosCV(dtoSR);
                      }
                  }
              }
              
            }

            
            if(controlstock.booleanValue() == true) {
                posici = (Vector)posicion;
                
                BigDecimal valor1 = null;
                BigDecimal valor2 = null;
           
                if (posici.get(8) instanceof java.lang.Long) {
                  valor1 = new BigDecimal(posici.get(8).toString());
                }  
                if (posici.get(8) instanceof BigDecimal) {
                  valor1 = new BigDecimal(posici.get(8).toString());
                }  
 
                if (posici.get(9) instanceof java.lang.Long) {
                  valor2 = new BigDecimal(posici.get(9).toString());
                }  
                if (posici.get(9) instanceof BigDecimal) {
                  valor2 = new BigDecimal(posici.get(9).toString());
                }
                
                //  Agregado por HRCS - Fecha 17/07/2007 - Cambio Sicc20070340
                //  OJO: posicion 21 es 'unidadesdemandareal'
                BigDecimal valor3 = null;
                if (posici.get(21) instanceof java.lang.Long) {
                  valor3 = new BigDecimal(posici.get(21).toString());
                }  
                if (posici.get(21) instanceof BigDecimal) {
                  valor3 = new BigDecimal(posici.get(21).toString());
                }
                
                if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("Valor 1 aca: " + valor1);
                  UtilidadesLog.debug("Valor 2 aca: " + valor2);
                  UtilidadesLog.debug("Valor 3 aca: " + valor3);
                } 
                Long lfaltante = new Long(valor3.longValue() - valor2.longValue()); //  Modificado por HRCS - Cambio Sicc20070340
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("Valor Faltante aca: " + lfaltante);
                
                if (posici.get(12)!=null) {
                  valor1 = new BigDecimal(posici.get(12).toString());
                }  
                
                // Modificado por HRCS - Fecha 05/03/2007 - Incidencia SiCC 20070081
                // Se quito las validaciones: (valor!=null y valor1==Activo) del control de sotck (posicion 12) - Fecha 07/03/2007
                if(lfaltante != null && lfaltante.longValue() > 0)    {
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("voy a generarMensajeControlStock, con (sol./pos./lftte.): " +solicitud+"/"+posicion+"/"+lfaltante); 
                      
                    generarMensajeControlStock(solicitud, posicion, lfaltante);
                }
            }
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPEDValidacionBean.enviarMensajes(RecordSet solicitud, Object posicion, RecordSet tiposproceso, Boolean recuperacion, Boolean controlstock, Boolean anulacion, DTOSolicitudValidacion dto): Salida ");
    }
    
   private DTOSolicitudReversion cargarSolicitudReversion(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.cargarSolicitudReversion(DTOSolicitudValidacion dto): Entrada ");
      DTOSolicitudReversion aux = new DTOSolicitudReversion();
   
      aux.setIndOrdenCompra(dto.getIndOrdenCompra()); 
      aux.setIndPedGTZona(dto.getIndPedGTZona()); 
      aux.setIndSimulacion(dto.getIndSimulacion()); 
      aux.setIndUnionSolicitud(dto.getIndUnionSolicitud()); 
      aux.setNumDecimales(dto.getNumDecimales()); 
      aux.setNumSolicitud(dto.getNumSolicitud()); 
      aux.setOidAcceso(dto.getOidAcceso()); 
      aux.setOidCanal(dto.getOidCanal()); 
      aux.setOidCliente(dto.getOidCliente());
      aux.setOidMarca(dto.getOidMarca());
      aux.setOidModulo(dto.getOidModulo());
      aux.setOidMoneda(dto.getOidMoneda());
      aux.setOidPeriodo(dto.getOidPeriodo());
      aux.setOidSolicitud(dto.getOidSolicitud());
      aux.setOidSubAcceso(dto.getOidSubAcceso());
      aux.setOidTipoSolPais(dto.getOidTipoSolPais());
      aux.setOrden(dto.getOrden());
      aux.setOrdenMonitor(dto.getOrdenMonitor());
      aux.setProceso(dto.getProceso());
      aux.setTipoCambio(dto.getTipoCambio());
      aux.setUbigeo(dto.getUbigeo());
      aux.setZona(dto.getZona());
      aux.setOidPais(dto.getOidPais());
      aux.setOidIdioma(dto.getOidIdioma());
        UtilidadesLog.info("MONPEDValidacionBean.cargarSolicitudReversion(DTOSolicitudValidacion dto): Salida ");
    return aux;
   } 
    

    private void eliminarMensajes(Long oidSolicitud, Long oidPais, String[] mensajes)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.eliminarMensajes(Long oidSolicitud, Long oidPais, String[] mensajes): Entrada ");

        UtilidadesLog.debug("| oidSolicitud" + oidSolicitud);
        UtilidadesLog.debug("| oidpais" + oidPais);

        for(int i = 0; i < mensajes.length; i++)
            UtilidadesLog.debug("| mensajes [" + i + "] " + mensajes[i]);

        UtilidadesLog.debug("-------------------------------------------------");

        DTOBuzonMensajes dto = new DTOBuzonMensajes();
        IMSG imsg = null;
        int i = mensajes.length;

        /* 
         * Modificado por ssantana, 30/9/2005.
         * Si no se encuentra mensaje en MSG_MENSA para Pais y Codigo, continua
         * la ejecución en la sig. iteración en lugar de pinchar.
         */
        try {
            boolean bContinuar = true;
            for(int k = 0; k < i; k++) {
                UtilidadesLog.debug("oidPais,mensajes[" + k + "]" + oidPais + " - " + mensajes[k]);
                bContinuar = true;
                MensajesLocalHome msjLocalHome = new MensajesLocalHome();
                MensajesLocal msjLocal = null;
                try { 
                   msjLocal = msjLocalHome.findByUk(oidPais, mensajes[k]);
                } catch (NoResultException fEx) {
                   UtilidadesLog.debug("FinderException...");
                   UtilidadesLog.debug("Se continua con la sig. iteracion. ");
                   bContinuar = false;
                }  catch (PersistenceException ce) {
                     ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                
                if ( bContinuar ) {
                   MONGestionMensajesHome mensaje = getMONGestionMensajesHome();
    
                   SolicitudMensajesLocalHome solicMsjeLocalHome = new SolicitudMensajesLocalHome();
                   Collection solicLocal = solicMsjeLocalHome.findBySolicitudMensaje(oidSolicitud, msjLocal.getOid());
   
                   Iterator it = solicLocal.iterator();
   
                   while(it.hasNext()) {
                      SolicitudMensajesLocal solic = (SolicitudMensajesLocal)it.next();
                      dto.setOid(solic.getValorBuzonMensaje());
                      dto.setOidPais(oidPais);
                      UtilidadesLog.debug(" dto de eliminaDatosMensaje(dto)" + dto);
                      mensaje.create().eliminaDatosMensaje(dto);
                      UtilidadesLog.debug("borra");
                      try {
                        solicMsjeLocalHome.remove(solic);
                      } catch (PersistenceException pe) {
                          ctx.setRollbackOnly();
                          throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                      }
                   }
                }
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch(Exception e) {
            if(e instanceof MareException) {
                UtilidadesLog.error("Exception: ",e);
                throw (MareException)e;
            } else {
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.eliminarMensajes(Long oidSolicitud, Long oidPais, String[] mensajes): Salida ");
    }

    private void generarMensajeRecuperacion(String codMensaje, RecordSet solicitud, Object posicion)
        throws MareException {

        UtilidadesLog.info("MONPEDValidacionBean.generarMensajeRecuperacion(String codMensaje, RecordSet solicitud, Object posicion): Entrada ");
        
        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("| codMensaje" + codMensaje);
          UtilidadesLog.debug("| solicitud" + solicitud);
          UtilidadesLog.debug("| posicion" + posicion);
        }  

        try {
            DTOBuzonMensajes dtob = new DTOBuzonMensajes();
            Vector posi = (Vector)posicion;
            BigDecimal valores = (BigDecimal)solicitud.getValueAt(0, 9);
            dtob.setOidPais(new Long(valores.longValue()));
            dtob.setCodigoMensaje(codMensaje);
            dtob.setOidPais(new Long(1));
            dtob.setCodigoMensaje("RG003");
            valores = (BigDecimal)solicitud.getValueAt(0, 3);
            dtob.setOidCliente(new Long((valores == null) ? 0 : valores.longValue()));
            dtob.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
            dtob.setDatoVariable1((String)posi.get(5));
            dtob.setDatoVariable2((String)posi.get(18));

            UtilidadesLog.debug(posi.get(18));
            UtilidadesLog.debug(posi.get(9).toString());

            dtob.setDatoVariable3(posi.get(7).toString());
            dtob.setDatoVariable4(posi.get(9).toString());
            dtob.setDatoVariable5(solicitud.getValueAt(0, 12).toString());
            dtob.setListaConsultoras(ConstantesMSG.NO);
            dtob.setCodigoPatron(null);

            DTOBuzonMensajes dtos = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtob);
            BigDecimal valor2 = (BigDecimal)solicitud.getValueAt(0, 0);
            crearSolicitudMensajes(new Long(valor2.longValue()), new Long(valores.longValue()), codMensaje, dtos.getOid());
        } catch(CreateException createException) {
            ctx.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPEDValidacionBean.generarMensajeRecuperacion(String codMensaje, RecordSet solicitud, Object posicion): Salida ");
    }

    private void generarMensajeControlStock(RecordSet solicitud, Object posicion, Long faltante)
        throws MareException {

        UtilidadesLog.info("MONPEDValidacionBean.generarMensajeControlStock(RecordSet solicitud, Object posicion, Long faltante): Entrada ");

        if(log.isDebugEnabled()) {//sapaza -- cambio Optimizacion Logs -- 23/03/2010                
          UtilidadesLog.debug("| faltante: " + faltante);
          UtilidadesLog.debug("| solicitud: " + solicitud);
          UtilidadesLog.debug("| posicion: " + posicion);
        }   

        try {
            DTOBuzonMensajes dtob = new DTOBuzonMensajes();
            BigDecimal oid = new BigDecimal(solicitud.getValueAt(0, 0).toString());
            BigDecimal pais = new BigDecimal(solicitud.getValueAt(0, 9).toString());
            Vector posi = (Vector)posicion;
            dtob.setOidPais(new Long(pais.longValue()));
            //dtob.setOidMensaje(new Long(ConstantesMSG.MENSAJE_PED07));
            dtob.setCodigoMensaje(ConstantesMSG.MENSAJE_PED07);

            BigDecimal oidcliente = (BigDecimal)solicitud.getValueAt(0, 3);
            dtob.setOidCliente(new Long(oidcliente.longValue()));
            dtob.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
            dtob.setDatoVariable1(posi.get(5)!=null?posi.get(5).toString():"");
            dtob.setDatoVariable2(posi.get(18).toString());
            dtob.setDatoVariable3(faltante.toString());
            dtob.setListaConsultoras(ConstantesMSG.NO);
            dtob.setCodigoPatron(null);

            DTOBuzonMensajes dtos = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtob);
            crearSolicitudMensajes(new Long(oid.longValue()), new Long(pais.longValue()), ConstantesMSG.MENSAJE_PED07, dtos.getOid());
        } catch(CreateException createException) {
            ctx.setRollbackOnly();
            throw new MareException(createException, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPEDValidacionBean.generarMensajeControlStock(RecordSet solicitud, Object posicion, Long faltante): Salida ");
    }

    /*    private void crearSolicitudMensajes(Long oidSolicitud, Long oidMensaje,
            Integer secuencia, Date fecha) {
        }*/

    /**
    * Observa si ya está en el array de ventas la venta indicada.
    * Si es así, se retorna False que indica que no hay que volver a procesar esa venta.
    * @author Guido Pons
    * fecha 27/08/04
    */
    private Boolean procesaVenta(String codVenta, String[] ventas) {
        UtilidadesLog.info("MONPEDValidacionBean.procesaVenta(String codVenta, String[] ventas): Entrada ");
        boolean bProcesa = true;

        for(int i = 0; i < ventas.length; i++) {
            if(ventas[i].equals(codVenta)) {
                bProcesa = false;

                break;
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.procesaVenta(String codVenta, String[] ventas): Salida ");
        return Boolean.valueOf(bProcesa);
    }

    /**
    * Valida si se comple la tipología de cliente y la region/zona parametrizadas en Gestión de Stock.
    * @author Mario Bobadilla
    * fecha 25/08/04
    * modificado  - BELC300018046 - pperanzola  - NO SE AJUSTA CON EL DMCO
    */
    private Boolean validarStock(Long region, Long zona, Long tipoCliente, Long subtipoCliente, Long tipoClasificacion,
        Long clasificacion, RecordSet solicitud) {

        UtilidadesLog.info("MONPEDValidacionBean.validarStock(Long region, Long zona, Long tipoCliente, Long subtipoCliente, Long tipoClasificacion, Long clasificacion, RecordSet solicitud): Entrada ");       
        Boolean bValido = Boolean.FALSE;
        Hashtable tabla = this.armarRecordSet(solicitud, 0);


        if(tabla.containsKey("REGION")) {

            Long v = new Long(tabla.get("REGION").toString());
            bValido = this.validarRegion(region, v);

        }

        if(bValido.booleanValue()) {

            if(tabla.containsKey("ZONA")) {
                Long v = new Long(tabla.get("ZONA").toString());
                bValido = this.validarZona(zona, v);

            }
        }

        if(tabla.containsKey("TIPOCLIENTE")) {
            bValido = this.validarTipoCliente(tipoCliente, solicitud);
        }    
        if(bValido.booleanValue()) {
            if(tabla.containsKey("SUBTIPOCLIENTE")) {
                bValido = this.validarSubtipoCliente(subtipoCliente, solicitud);
            }    
        }
        if(bValido.booleanValue()) {
            if(tabla.containsKey("TIPOCLASIFICACION")) {
                bValido = this.validarTipoClasificacion(tipoClasificacion, solicitud);
            }    
        }
        if(bValido.booleanValue()) {
                if(tabla.containsKey("CLASIFICACION")) {
                    bValido = this.validarClasificacion(clasificacion, solicitud);
                }    
        }
    
        UtilidadesLog.info("MONPEDValidacionBean.validarStock(Long region, Long zona, Long tipoCliente, Long subtipoCliente, Long tipoClasificacion, Long clasificacion, RecordSet solicitud): Salida ");       
        return bValido;
    }

    /**
    * Valida si la Solicitud es de la región especificada en Gestión de Stock
    * @author Mario Bobadilla
    * fecha 25/08/04
    */
    private Boolean validarRegion(Long regionStock, Long regionSolicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarRegion(Long regionStock, Long regionSolicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;

        if(regionStock != null) {
            if(regionSolicitud == null)
                bValido = Boolean.FALSE;
            else {
                if(regionSolicitud.longValue() != regionStock.longValue())
                    bValido = Boolean.FALSE;
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.validarRegion(Long regionStock, Long regionSolicitud): Salida ");
        return bValido;
    }

    /**
    * Valida si la Solicitud es de la zona especificada en Gestión de Stock.
    * @author Mario Bobadilla
    * fecha 25/08/04
    */
    private Boolean validarZona(Long zonaStock, Long zonaSolicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarZona(Long zonaStock, Long zonaSolicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;

        if(zonaStock != null) {
            if(zonaSolicitud == null)
                bValido = Boolean.FALSE;
            else {
                if(zonaSolicitud.longValue() != zonaStock.longValue())
                    bValido = Boolean.FALSE;
            }
        }
        UtilidadesLog.info("MONPEDValidacionBean.validarZona(Long zonaStock, Long zonaSolicitud): Salida ");
        return bValido;
    }

    /**
    * Valida si la Solicitud es del tipo de cliente especificado en Gestión de Stock
    * @author Mario Bobadilla
    * fecha 25/08/04
    * modificaciones  - pperanzola: - no se ajusta segun lo que dice el decu
    *                               - se cambia para que no arme un HashMap cada vez que se hace el for
    */
    private Boolean validarTipoClasificacion(Long tipoStock, RecordSet solicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarTipoClasificacion(Long tipoStock, RecordSet solicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;
        Boolean bEncontrado = Boolean.FALSE;
        Object obj = null;
        Long tmpSoliTipoClasi = null;
        if(tipoStock != null) {
            for(int i = 0; i < solicitud.getRowCount(); i++) {
                //Hashtable tabla = this.armarRecordSet(solicitud, i);
                
                //if(tabla.containsKey(new String("TIPOCLASIFICACION"))) {
                tmpSoliTipoClasi = ((solicitud.getValueAt(i,"TIPOCLASIFICACION")!=null)
                                        ? new Long (solicitud.getValueAt(i,"TIPOCLASIFICACION").toString())
                                        : null );
                if (tmpSoliTipoClasi != null){
                    UtilidadesLog.debug("    tmpSoliTipoClasi es = " + tmpSoliTipoClasi );
                    //Long v = new Long(tabla.get("TIPOCLASIFICACION").toString());

                    if(tmpSoliTipoClasi.longValue() == tipoStock.longValue()) {
                        bEncontrado = Boolean.TRUE;
                        break;
                    }
                }
            }
            bValido = bEncontrado;
        }
        UtilidadesLog.debug("bValido sale con  = " + bValido );
        UtilidadesLog.info("MONPEDValidacionBean.validarTipoClasificacion(Long tipoStock, RecordSet solicitud): Salida ");
        return bValido;
    }

    /**
    * Valida si la Solicitud es del subtipo de cliente especificado en Gestión de Stock.
    * @author Mario Bobadilla
    * fecha 25/08/04
    * modificaciones  - pperanzola: - no se ajusta segun lo que dice el decu
    *                               - se cambia para que no arme un HashMap cada vez que se hace el for
    */
    private Boolean validarSubtipoCliente(Long subtipoStock, RecordSet solicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarSubtipoCliente(Long subtipoStock, RecordSet solicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;
        Boolean bEncontrado = Boolean.FALSE;
        Object obj = null;
        Long tmpSoliSubTipoClie = null;
        UtilidadesLog.debug("Entro a validarSubtipoCliente\n");
        
        if(subtipoStock != null) {
            for(int i = 0; i < solicitud.getRowCount(); i++) {
                //Hashtable tabla = this.armarRecordSet(solicitud, i);
                tmpSoliSubTipoClie = ((solicitud.getValueAt(i,"SUBTIPOCLIENTE")!=null)
                        ? new Long (solicitud.getValueAt(i,"SUBTIPOCLIENTE").toString())
                        : null );
                if (tmpSoliSubTipoClie!=null){
                    UtilidadesLog.debug("    tmpSoliSubTipoClie es = " + tmpSoliSubTipoClie );
                //if(tabla.containsKey(new String("SUBTIPOCLIENTE"))) {
                //   Long v = new Long(tabla.get("SUBTIPOCLIENTE").toString());
                    if(tmpSoliSubTipoClie.longValue() == subtipoStock.longValue()) {
                        bEncontrado = Boolean.TRUE;
                        break;
                    }
                }
            }
            bValido = bEncontrado;
        }
        UtilidadesLog.debug("bValido sale con  = " + bValido );
        UtilidadesLog.info("MONPEDValidacionBean.validarSubtipoCliente(Long subtipoStock, RecordSet solicitud): Salida ");
        return bValido;
    }

    /**
    * Valida si la Solicitud es del tipo de clasificacion especificado en Gestión de Stock.
    * @author Mario Bobadilla
    * fecha 25/08/04
    * modificaciones  - pperanzola: - no se ajusta segun lo que dice el decu
    *                               - se cambia para que no arme un HashMap cada vez que se hace el for
    */
    private Boolean validarTipoCliente(Long tipoStock, RecordSet solicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarTipoCliente(Long tipoStock, RecordSet solicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;
        Boolean bEncontrado = Boolean.FALSE;
        Object obj = null;
        Long tmpSoliTipoClie = null;

        if(tipoStock != null) {
            for(int i = 0; i < solicitud.getRowCount(); i++) {
               // Hashtable tabla = this.armarRecordSet(solicitud, i);
                tmpSoliTipoClie = ((solicitud.getValueAt(i,"TIPOCLIENTE")!=null)
                        ? new Long (solicitud.getValueAt(i,"TIPOCLIENTE").toString())
                        : null );
                if (tmpSoliTipoClie!=null){
                    UtilidadesLog.debug("    tmpSoliTipoClie es = " + tmpSoliTipoClie );
                //if(tabla.containsKey(new String("TIPOCLIENTE"))) {
                //    Long v = new Long(tabla.get("TIPOCLIENTE").toString());
                    if(tmpSoliTipoClie.longValue() == tipoStock.longValue()) {
                        bEncontrado = Boolean.TRUE;
                        break;
                    }
                }
            }
            bValido = bEncontrado;
        }
        UtilidadesLog.debug("bValido sale con  = " + bValido );
        UtilidadesLog.info("MONPEDValidacionBean.validarTipoCliente(Long tipoStock, RecordSet solicitud): Salida ");
        return bValido;
    }

    /**
    * Valida si la Solicitud es de la clasificación especificada en Gestión de Stock.
    * @author Mario Bobadilla
    * fecha 25/08/04
    * modificaciones  - pperanzola: - no se ajusta segun lo que dice el decu
    *                               - se cambia para que no arme un HashMap cada vez que se hace el for
    */
    private Boolean validarClasificacion(Long clasificacionStock, RecordSet solicitud) {
        UtilidadesLog.info("MONPEDValidacionBean.validarClasificacion(Long clasificacionStock, RecordSet solicitud): Entrada ");
        Boolean bValido = Boolean.TRUE;
        Boolean bEncontrado = Boolean.FALSE;
        Object obj = null;
        Long tmpSoliClasi = null;

        
        if(clasificacionStock != null) {
            for(int i = 0; i < solicitud.getRowCount(); i++) {
                //Hashtable tabla = this.armarRecordSet(solicitud, i);
                tmpSoliClasi = ((solicitud.getValueAt(i,"CLASIFICACION")!=null)
                        ? new Long (solicitud.getValueAt(i,"CLASIFICACION").toString())
                        : null );
                if (tmpSoliClasi!=null){
                //if(tabla.containsKey(new String("CLASIFICACION"))) {
                //    Long v = new Long(tabla.get("CLASIFICACION").toString());
                    UtilidadesLog.debug("    tmpSoliClasi es = " + tmpSoliClasi );
                    if(tmpSoliClasi.longValue() == clasificacionStock.longValue()) {
                        bEncontrado = Boolean.TRUE;
                        break;
                    }
                }
            }
            bValido = bEncontrado;
        }
        UtilidadesLog.debug("bValido sale con  = " + bValido );
        UtilidadesLog.info("MONPEDValidacionBean.validarClasificacion(Long clasificacionStock, RecordSet solicitud): Salida ");
        return bValido;
    }

    public DTOEstatusSolicitud revertirControlLiquidacion(DTOSolicitudValidacion dto)
        throws MareException {

        UtilidadesLog.info("MONPEDValidacionBean.revertirControlLiquidacion(DTOSolicitudValidacion dto): Entrada ");
        
        // Se llama al método DAOPosicion.revertirControlLiquidacion pasándole como parámetro de entrada dto.oidSolicitud.
        DAOPosicion daoPosicion = new DAOPosicion();
        daoPosicion.revertirControlLiquidacion(dto.getOidSolicitud());

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);

        UtilidadesLog.info("MONPEDValidacionBean.revertirControlLiquidacion(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    /**
    * Metodo de apoyo a la clase que devuelve un hashtable con las filas del Recordset
    * en pares [clave(Colinmname de la tabla),valor(valor de la columna)]
    * no se encuentra definido en el diseño
    * @author Mario Bobadilla
    * fecha 28/05/04
    */
    private Hashtable armarRecordSet(RecordSet rs, int i) {
        UtilidadesLog.info("MONPEDValidacionBean.armarRecordSet(RecordSet rs, int i): Entrada ");
        Hashtable tabla = new Hashtable();
        Vector tupla = new Vector();
        Vector columnas = new Vector();
        Object obj = null;
        tupla = rs.getRow(i);
        columnas = rs.getColumnIdentifiers();

        for(int j = 0; j < tupla.size(); j++) {
            if(tupla.get(j) != obj)
                tabla.put(columnas.get(j), tupla.get(j));
        }
        UtilidadesLog.info("MONPEDValidacionBean.armarRecordSet(RecordSet rs, int i): Salida ");
        return tabla;
    }

    private MONGestionMensajesHome getMONGestionMensajesHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGestionMensajesHome)PortableRemoteObject.narrow(context.lookup("MONGestionMensajes"), MONGestionMensajesHome.class);
    }

    private void crearSolicitudMensajes(Long oidSolicitud, Long oidPais, String codMensaje, Long oidBuzon)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.crearSolicitudMensajes(Long oidSolicitud, Long oidPais, String codMensaje, Long oidBuzon): Entrada ");

        /*UtilidadesLog.debug("| oidSolicitud " + oidSolicitud);
        UtilidadesLog.debug("| oidPais  " + oidPais);
        UtilidadesLog.debug("| codMensaje " + codMensaje);
        UtilidadesLog.debug("| oidBuzon" + oidBuzon);*/


        try {
            /*  inicio pperez CAMBIO MSG-002  */ 
            if (oidBuzon != null)  {
                MensajesLocalHome mensajeLH = new MensajesLocalHome();
                MensajesLocal mensajesL = mensajeLH.findByUk(oidPais, codMensaje);
                SolicitudMensajesLocalHome solicitudLH = new SolicitudMensajesLocalHome();
                SolicitudMensajesLocal solicitudL = solicitudLH.create(oidSolicitud, mensajesL.getOid(), oidBuzon);
                solicitudL.setOidSolicitudCabecera(oidSolicitud);
                solicitudL.setOidMensaje(mensajesL.getOid());
                solicitudL.setValorBuzonMensaje(oidBuzon);
                
                solicitudLH.merge(solicitudL);
            }
            /*  fin pperez CAMBIO MSG-002  */ 
            
        } catch(NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        } catch(PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONPEDValidacionBean.crearSolicitudMensajes(Long oidSolicitud, Long oidPais, String codMensaje, Long oidBuzon): Salida ");
    }
    /**
     * 
     * @return Long
     * @param num
     * modificaciones  - BELC300018047 - 22/07/2005 - pperanzola el método no contempla los valores nulos y causa una excepción.
     */
    private Long bigToLong(Object num) {
        Long tmp=null;
        if (num != null){
            tmp = new Long(num.toString());
        }
        return tmp;
        //return new Long(((BigDecimal)num).longValue());
    }

    private MONGenerarMovimientoAlmacenHome getMONGenerarMovimientoAlmacenHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarMovimientoAlmacenHome)PortableRemoteObject.narrow(context.lookup("MONGenerarMovimientoAlmacen"),
            MONGenerarMovimientoAlmacenHome.class);
    }

    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("MONPeriodos"), MONPeriodosHome.class);
    }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONGenerarSolicitudModulosExternosHome)PortableRemoteObject.narrow(context.lookup("MONGenerarSolicitudModulosExternos"), MONGenerarSolicitudModulosExternosHome.class);
    }




    /**
     * // Inicializa los valores relacionados con el calculo del flete
     * Llama al método reversarCalculoFlete del DAOSolicitud, pasandole el oidSolicitud contenido en el dtoin.
     *
     * //Elimina los mensajes enviado si estos existiesen
     * Se llama al metodo eliminarMensajes(oidSolicitud : Long, mensajes : Long[]) : void pasandole el oidSolicitud y en el arreglo de mensajes la constante ConstantesMSG.PED08
     *
     *
     * Retorna un DTOEstatusSolicitud indicando como estado de retorno:
     * ESTADO_SOLICITUD_VALIDADO.
     */
    public DTOEstatusSolicitud revertirFlete(DTOSolicitudValidacion dtoin)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.revertirFlete(DTOSolicitudValidacion dtoin): Entrada ");
        DAOSolicitud dtos = new DAOSolicitud();

        try {
            dtos.reversarCalculoFlete(dtoin.getOidSolicitud());
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        String[] mensajes = new String[1];
        mensajes[0] = ConstantesMSG.MENSAJE_PED08;

        try {
            this.eliminarMensajes(dtoin.getOidSolicitud(), dtoin.getOidPais(), mensajes);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        //jrivas 21/9/2006 se agrega la reversion del acumulador de calctulosTotales.
        //jrivas 23/11/2006 ya no se llama mas a calcularTotales desde calcularFletes
        /*DAOSolicitud daosolicitud = new DAOSolicitud();
        daosolicitud.revertirAcumulador(dtoin);*/

        DTOEstatusSolicitud dtoe = new DTOEstatusSolicitud();
        dtoe.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirFlete(DTOSolicitudValidacion dtoin): Salida ");
        return dtoe;
    }

    /**
         * @Autor: Hugo Mansi
         * @Fecha: 2/09/2004
         * @DMCO: SICC-DMCO-PED-201-354-N002b
         * @Recibe un DTOSolicitudValidacion
         * @Devuelve un DTOEstatusSolicitud
         * 
         * @cambio incidencia DBLG700000199 se elimina la llamada al proceso Calcular Totales.
         */
    public DTOEstatusSolicitud validarFlete(DTOSolicitudValidacion dtoin) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarFlete(DTOSolicitudValidacion dtoin): Entrada ");
        
        Boolean varExentoFlete;
        DTOOID miDto = new DTOOID();
        miDto.setOid(dtoin.getOidSolicitud());
        Long varOidMensaje;
        BigDecimal totalFleteLocal;
        BigDecimal importeFleteTotalLocal;
        BigDecimal importeFleteLocal;
        BigDecimal otrosRecargosLocal;
        BigDecimal importeFleteDocumento;
        BigDecimal otrosRecargosDocumento;
        BigDecimal totalFleteDocumento;
        BigDecimal importeFleteTotalDocumento;

        DAOSolicitud miDaoPSol = new DAOSolicitud();
        DAOPEDIntegracion miDaoPedInt = new DAOPEDIntegracion();
        DTOIndicadoresFlete dtoFlete = miDaoPedInt.obtenerIndicadoresFlete(dtoin.getOidSolicitud(), dtoin.getOidCliente());

        //Se verifica si el tipo de solicitud esta sujeto a Flete 
        //Se verifique si la solicitud esta exento de flete por monto minimo 
        // Se verifica si el cliente esta exento por su tipificacion 
        if(dtoFlete.getIndTipoSolicitud().booleanValue()) {
            if(!dtoFlete.getIndSolicitud().booleanValue()) {
                if(!dtoFlete.getIndTipoCliExencion().booleanValue()) {
                    varExentoFlete = Boolean.FALSE;
                } else {
                    varExentoFlete = Boolean.TRUE;
                }
            } else {
                varExentoFlete = Boolean.TRUE;
            }
        } else {
            varExentoFlete = Boolean.TRUE;
        }

        //actualiza los valores del flete en la base de datos
        if (varExentoFlete.booleanValue()) {
            miDaoPSol.actualizarCalculoFleteExento(dtoin.getOidSolicitud(), dtoin.getTipoCambio(), dtoin.getNumDecimales());
        } else {
            ArrayList miArray = miDaoPedInt.obtenerValoreFlete(dtoin.getOidSolicitud());

            if (miArray == null) {
                //si viene null se asume que está exento de flete
                miDaoPSol.actualizarCalculoFleteExento(dtoin.getOidSolicitud(), dtoin.getTipoCambio(), dtoin.getNumDecimales());
            } else {
                DTODatosFlete dtoFleteSet = calcularFlete(miArray);
                // dtoFleteSet
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("Flete es: " + dtoFleteSet.getFlete());
                  
                importeFleteLocal = dtoFleteSet.getFlete();
                
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("importeFleteLocal: " + importeFleteLocal);
                  
                otrosRecargosLocal = dtoFleteSet.getContraEntrega();

                totalFleteLocal = importeFleteLocal.add(otrosRecargosLocal).add(dtoFleteSet.getSolRecargoFleteLocal());
                if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                  UtilidadesLog.debug("totalFleteLocal: " + totalFleteLocal);

                importeFleteTotalLocal = totalFleteLocal;
                int cantDecimales = (dtoin.getNumDecimales() == null)? 2 : dtoin.getNumDecimales().intValue(); // eiraola DBLG700000274
                
                if (dtoin.getOidMoneda() != null) {
                    UtilidadesLog.debug("moneda != null");
                    importeFleteDocumento = importeFleteLocal.divide(dtoin.getTipoCambio(), cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    otrosRecargosDocumento = otrosRecargosLocal.divide(dtoin.getTipoCambio(), cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    totalFleteDocumento = totalFleteLocal.divide(dtoin.getTipoCambio(), cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    importeFleteTotalDocumento = importeFleteTotalLocal.divide(dtoin.getTipoCambio(), cantDecimales, BigDecimal.ROUND_HALF_EVEN);

                } else {
                    UtilidadesLog.debug("moneda == null");
                    importeFleteDocumento = new BigDecimal(importeFleteLocal.floatValue()).setScale(cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    otrosRecargosDocumento = new BigDecimal(otrosRecargosLocal.floatValue()).setScale(cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    totalFleteDocumento = new BigDecimal(totalFleteLocal.floatValue()).setScale(cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                    importeFleteTotalDocumento = new BigDecimal(importeFleteTotalLocal.floatValue()).setScale(cantDecimales, BigDecimal.ROUND_HALF_EVEN);
                }

                importeFleteLocal = new BigDecimal(importeFleteLocal.floatValue()).setScale(cantDecimales,BigDecimal.ROUND_HALF_EVEN);
                otrosRecargosLocal = new BigDecimal(otrosRecargosLocal.floatValue()).setScale(cantDecimales,BigDecimal.ROUND_HALF_EVEN);
                totalFleteLocal = new BigDecimal(totalFleteLocal.floatValue()).setScale(cantDecimales,BigDecimal.ROUND_HALF_EVEN);
                importeFleteTotalLocal = new BigDecimal(importeFleteTotalLocal.floatValue()).setScale(cantDecimales,BigDecimal.ROUND_HALF_EVEN);

                //fin si
                UtilidadesLog.debug("antes de: miDaoPSol.actualizarCalculoFlete...");
                miDaoPSol.actualizarCalculoFlete(dtoin.getOidSolicitud(), importeFleteLocal, otrosRecargosLocal, totalFleteLocal,
                    importeFleteTotalLocal, dtoFleteSet.getTipoClasificacion(), dtoFleteSet.getClasificacion(), importeFleteDocumento,
                    otrosRecargosDocumento, totalFleteDocumento, importeFleteTotalDocumento, dtoFleteSet.getSolbaseFleteLocal());
                    
                UtilidadesLog.debug("luego de: miDaoPSol.actualizarCalculoFlete..."); 

                //envía mensajes
                try {
                    MensajesLocalHome mensajeLH = new MensajesLocalHome();
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("busco esto en mensaje (pais y constante!): " + dtoin.getOidPais() + " - " + ConstantesMSG.MENSAJE_PED08);
                      
                    MensajesLocal mensajeLocal = mensajeLH.findByUk(dtoin.getOidPais(), ConstantesMSG.MENSAJE_PED08);
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("oid de msg obtenido: " + mensajeLocal.getOid().longValue());
                      
                    varOidMensaje = new Long(mensajeLocal.getOid().longValue());
                    UtilidadesLog.debug("enviare mensaje........");
                } catch(NoResultException fe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ",fe);
                    throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }  catch (PersistenceException ce) {
                     ctx.setRollbackOnly();
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                try {
                    Entidadi18nLocalHome i18n = new Entidadi18nLocalHome();
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("busco en: i18n: " + ENTIDAD_DESC_TRADU + " - " + MSG_FLETE + " - 1" + " - " + ConstantesSEG.IDIOMA_DEFECTO);
                      
                    Entidadi18nLocal i18NLocal = i18n.findByEntAtrIdioPK(ENTIDAD_DESC_TRADU, MSG_FLETE, new Long(1), ConstantesSEG.IDIOMA_DEFECTO);
                    String varMensajeFlete = i18NLocal.getDetalle();
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("varMensajeFlete: " + varMensajeFlete);        
                      
                    // Se setean los atribvutos del mensaje
                    DTOBuzonMensajes miDtoBuzon = new DTOBuzonMensajes();
                    miDtoBuzon.setOidPais(dtoin.getOidPais());
                    miDtoBuzon.setOidMensaje(varOidMensaje);
                    miDtoBuzon.setCodigoMensaje(ConstantesMSG.MENSAJE_PED08);
                    miDtoBuzon.setOidCliente(dtoin.getOidCliente());
                    miDtoBuzon.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
                    miDtoBuzon.setDatoVariable1(dtoFleteSet.getCodCliente());
                    miDtoBuzon.setDatoVariable2(dtoFleteSet.getCodTipoSolicitud());
                    miDtoBuzon.setDatoVariable3(varMensajeFlete);
                    miDtoBuzon.setDatoVariable4(otrosRecargosDocumento.toString());
                    miDtoBuzon.setListaConsultoras(ConstantesMSG.NO);
                    
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010    
                      UtilidadesLog.debug("DTOBuzonMensajes: " + miDtoBuzon);
                      
                    // Llama al metodo enviarMensajeValidaciones pasandole el DTOBuzonMensajes creado y el dtoin.oidSolicitud.  
                    this.enviarMensajeValidaciones(dtoin.getOidSolicitud(), miDtoBuzon);
                    UtilidadesLog.debug("envie mensaje.........");
                } catch(NoResultException nre) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ",nre);
                    throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch(PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Exception: ",pe);
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
                }
            } //fin si
        } //fin si

        DTOEstatusSolicitud dtoEstatus = new DTOEstatusSolicitud();
        dtoEstatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarFlete(DTOSolicitudValidacion dtoin): Salida ");
        return dtoEstatus;
    }


    /**
     * CHANGELOG
     * ---------
     * 14/07/2009 - dmorello, Cambio 20090916
     *    Si un flete tiene monto fijo cero o nulo, se busca el detalle de ese flete
     *    tal que el importe base flete local este comprendido entre rango inferior y rango superior
     *    de ese registro; del mismo se tomara el monto fijo a usar en los calculos.
     *    Si el flete tiene monto fijo no nulo y distinto de cero, se usara ese valor.
     */
    protected DTODatosFlete calcularFlete(ArrayList miArray)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.calcularFlete(ArrayList miArray): Entrada ");
        BigDecimal varImporteFleteLocal = new BigDecimal(0);
        DTODatosFlete varDatosSel = new DTODatosFlete();
        BigDecimal varFlete;
        DTODatosFlete dtoFlete;
        
        DAOPEDIntegracion dao = null;
        
        for(int i = 0; i < miArray.size(); i++) {
            dtoFlete = (DTODatosFlete)miArray.get(i);
            UtilidadesLog.debug("dtoFlete recibido: " + dtoFlete);
            
            BigDecimal montoFijo = dtoFlete.getMontoFijo();
            UtilidadesLog.debug("montoFijo: " + montoFijo);
            
            if (montoFijo == null || montoFijo.equals(new BigDecimal("0"))) {
                Long oidFlete = dtoFlete.getOidFlete();
                BigDecimal impBaseFleteLocal = dtoFlete.getSolbaseFleteLocal();
                if (dao == null) {
                    dao = new DAOPEDIntegracion();
                }
                montoFijo = dao.obtenerMontoFijoDetalleFlete(oidFlete, impBaseFleteLocal);
                UtilidadesLog.debug("montoFijo obtenido de detalle: " + montoFijo);
            }

            if(dtoFlete.getTasa().doubleValue() == 0) {
                UtilidadesLog.debug("entra por tasa == 0!!!!!!!!!!!!");
                if(varImporteFleteLocal.longValue() != 0) {
                    UtilidadesLog.debug("comparo montoFijo.longValue() < varImporteFleteLocal.longValue() :" + montoFijo.longValue() + " - " + varImporteFleteLocal.longValue());
                    if(montoFijo.longValue() < varImporteFleteLocal.longValue()) {
                        varImporteFleteLocal = montoFijo;
                        varDatosSel = dtoFlete;
                    } else {
                        //no se hace nada, este else se pone para hacer mas claro el código 
                    }
                } else {
                    UtilidadesLog.debug("varImporteFleteLocal.longValue() == 0!!");
                    varImporteFleteLocal = montoFijo;
                    varDatosSel = dtoFlete;
                }
            } else {
                UtilidadesLog.debug("entra por tasa <> 0!!!!!!!!!!!!");
                UtilidadesLog.debug("dtoFlete.getTasa().doubleValue() != 0!!");

                //la tasa es porcentaje
                Double tasa = new Double((dtoFlete.getTasa().doubleValue() / 100));
                BigDecimal aux = dtoFlete.getSolbaseFleteLocal().multiply(new BigDecimal(tasa.toString()));

                UtilidadesLog.debug("aux, es: " + aux);
                varFlete = aux.add(dtoFlete.getMontoFijo());
                UtilidadesLog.debug("varFlete, es: " + varFlete);
                
                if (dtoFlete.getFleteMinimo() != null && varFlete.doubleValue() < dtoFlete.getFleteMinimo().doubleValue()) {
                  varFlete = dtoFlete.getFleteMinimo();
                } else if (dtoFlete.getFleteMaximo() != null && varFlete.doubleValue() > dtoFlete.getFleteMaximo().doubleValue()) {
                  varFlete = dtoFlete.getFleteMaximo();
                }

                varImporteFleteLocal = varFlete;
                UtilidadesLog.debug("varImporteFleteLocal, quedo con: " + varImporteFleteLocal);
                varDatosSel = dtoFlete;
                
                /* Se modifica por Incidencia SiCC 20070059  ---- Alorenzo 22/02/2007                 
                  
                varImporteFleteLocal = varFlete;

                if(varFlete.compareTo(dtoFlete.getFleteMinimo()) < 0) {
                    varFlete = dtoFlete.getFleteMinimo();
                }

                //if(varFlete.compareTo(dtoFlete.getFleteMinimo()) > 0)
                if(varFlete.compareTo(dtoFlete.getFleteMaximo()) > 0) {
                    varFlete = dtoFlete.getFleteMaximo();
                }
                  
                UtilidadesLog.debug("comparo varFlete.compareTo(varImporteFleteLocal) < 0: " + varFlete + " - " + varImporteFleteLocal);  
                    
                if(varFlete.compareTo(varImporteFleteLocal) < 0) {
                    UtilidadesLog.debug("varFlete.compareTo(varImporteFleteLocal) < 0!!");
                    varImporteFleteLocal = varFlete;
                }
                
                UtilidadesLog.debug("varImporteFleteLocal, quedo con: " + varImporteFleteLocal);
                varDatosSel = dtoFlete;
                */
            }
        }

        varDatosSel.setFlete(varImporteFleteLocal);

        UtilidadesLog.debug("varDatosSel a retornar: " + varDatosSel);  
        UtilidadesLog.info("MONPEDValidacionBean.calcularFlete(ArrayList miArray): Salida ");
        return varDatosSel;
    }
    //Fin calcularFlete
    /**
          * @Autor: Hugo Mansi
          * @Fecha: 6/09/2004
          * @DMCO: SICC-DMCO-PED-201-354-N002b
          * @Recibe un OID  de la solicitud, DTOBuzonMensajes
          * @Devuelve nada
    */
    protected void enviarMensajeValidaciones(Long oidSolicitud, DTOBuzonMensajes dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.enviarMensajeValidaciones(Long oidSolicitud, DTOBuzonMensajes dtoin): Entrada ");
        DTOBuzonMensajes dtoS = new DTOBuzonMensajes();

        // Se envia el mensaje al buzon 
        try {
            dtoS = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtoin);
        } catch(Exception ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 

        // Se guarda una referencia al mensaje enviado 
        crearSolicitudMensajes(oidSolicitud, dtoin.getOidPais(), dtoin.getCodigoMensaje(), dtoS.getOid());
        UtilidadesLog.info("MONPEDValidacionBean.enviarMensajeValidaciones(Long oidSolicitud, DTOBuzonMensajes dtoin): Salida ");
    }

    //FIN enviarMensajeValidaciones

    /**
          * @Autor: Hugo Mansi
          * @Fecha: 6/09/2004
          * @DMCO: SICC-DMCO-PED-201-354-N002b
          * @Recibe un ArrayList
          * @Devuelve un DTODatosFlete
    */
    public DTOEstatusSolicitud recuperarDatosAnulaciones(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.recuperarDatosAnulaciones(DTOSolicitudValidacion dtoin): Entrada ");
        DTOEstatusSolicitud dtoEstat = new DTOEstatusSolicitud();
        DAOSolicitud miDao = new DAOSolicitud();

        UtilidadesLog.debug("solicitud original: " + dtoin.getOidSolicitud());

        //Se valida que la solicitud es una anulación y se obtiene el documento de referencia de la solicitud
        DTODatosAnulacion dtoDatos = miDao.obtenerDatosAnulacion(dtoin.getOidSolicitud());
        UtilidadesLog.debug("obtengo: " + dtoDatos);
        
        //en el marco del cambio: AG 26/12/2007 (SCS - 30/06/2008)
        boolean aplicaCup3 = miDao.aplicaCupTres(dtoin.getOidPais().longValue());

         if((dtoDatos.getIndAnulacion().booleanValue() == true)&&
                (dtoDatos.getOidConcurso()==null && dtoDatos.getNumeroPremio()==null && dtoDatos.getOidTipoPrograma()==null))
        { 
            // Se copian los datos necesario de la cabecera y de las posiciones
            miDao.copiarDatosAnulacion(dtoDatos.getOidSolicitudReferencia(), dtoin.getOidSolicitud());
            if (aplicaCup3){
                UtilidadesLog.debug("aplica cupón 3, procedo: (blanqueo oid de consolidado en detalle).....");    
                miDao.blanqueoSolCab(dtoDatos.getOidSolicitudReferencia());
                
            }
            //se anula estado de solicitud de referencia
            miDao.anularSolRef(dtoDatos.getOidSolicitudReferencia());
        }
            
        dtoEstat.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.recuperarDatosAnulaciones(DTOSolicitudValidacion dtoin): Salida ");
        return dtoEstat;
    }
    //FIN recuperarDatosAnulaciones    
    
    private MONRevertirDescuentosHome getMONRevertirDescuentosHome()
        throws MareException {
        MONRevertirDescuentosHome home = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            home = (MONRevertirDescuentosHome)bs.ejbLocator.getHome("MONRevertirDescuentos", MONRevertirDescuentosHome.class);
        } catch(MareServiceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return home;
    }

    public DTOEstatusSolicitud revertirLimiteVenta(DTOSolicitudValidacion dtoin)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.revertirLimiteVenta(DTOSolicitudValidacion dtoin): Entrada ");
        DAOPosicion daoPosicion = new DAOPosicion();
        

        try {
            UtilidadesLog.debug("llamando a: daoPosicion.revertirLimiteVenta(...");    
            daoPosicion.revertirLimiteVenta(dtoin.getOidSolicitud());
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);

            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        String[] mensajes = new String[1];
        mensajes[0] = ConstantesMSG.MENSAJE_PED05;
        
        try {
            UtilidadesLog.debug("voy a eliminar mensajes...");    
            this.eliminarMensajes(dtoin.getOidSolicitud(), dtoin.getOidPais(), mensajes);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);

            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        mensajes = null;

        // Retorna un DTOEstatusSolicitud indicando como estado de retorno
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirLimiteVenta(DTOSolicitudValidacion dtoin): Salida ");
        return dtos;
    }

    /**
     * //Inicializa los atruibutos exentoFlete, recargoFleteLocal y recargoFleteDocumento, y si el estado de la
     * solicitud="Rechazado" entonces asigna al estado de la solicitud = "Validado" Llama al metodo actualizarValoresFlete del
     * DAOSolicitud pasandole dtoin.oidSolicitud, y 0 para recargoFleteLocal y recargoFleteDocumento. Llama al metodo
     * revertirEstadoSolicitud del DAOSolicitud pasandole el oidSolicitud y las constantes
     * ConstantesPED.ESTADO_SOLICITUD_RECHAZADA y ConstantesPED.ESTADO_SOLICITUD_VALIDADA, en este orden. //Elimina los
     * mensajes enviado si estos existiesen Se llama al metodo eliminarMensajes(oidSolicitud : Long, mensajes : Long[]) : void
     * pasandole el oidSolicitud y en el arreglo de mensajes la constante ConstantesMSG.PED10 Retorna un DTOEstatusSolicitud
     * indicando como estado de retorno: ESTADO_SOLICITUD_VALIDADO.
     */
    public DTOEstatusSolicitud revertirMontoMinimo(DTOSolicitudValidacion dtoin)
        throws MareException {
        
        UtilidadesLog.info("MONPEDValidacionBean.revertirMontoMinimo(DTOSolicitudValidacion dtoin): Entrada ");
        // Inicializa los atruibutos exentoFlete, recargoFleteLocal y
        // recargoFleteDocumento, y si el estado de la solicitud="Rechazado"
        // entonces asigna al estado de la solicitud = "Validado"
        // Llama al metodo actualizarValoresFlete del DAOSolicitud
        // pasandole dtoin.oidSolicitud, y 0 para recargoFleteLocal
        // y recargoFleteDocumento.
        DAOSolicitud daoSolicitud = new DAOSolicitud();

        try {
            daoSolicitud.actualizarValoresFlete(dtoin.getOidSolicitud(), new BigDecimal(0), new BigDecimal(0), dtoin.getNumDecimales());
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        //  Llama al metodo revertirEstadoSolicitud del DAOSolicitud
        //	pasandole el oidSolicitud y las constantes ConstantesPED.ESTADO_SOLICITUD_RECHAZADA
        // 	y ConstantesPED.ESTADO_SOLICITUD_VALIDADA, en este orden.
        try {
            daoSolicitud.revertirEstadoSolicitud(dtoin.getOidSolicitud(), ConstantesPED.ESTADO_SOLICITUD_VALIDADO,
                ConstantesPED.ESTADO_SOLICITUD_RECHAZADO);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        // Se llama al metodo eliminarMensajes(oidSolicitud : Long, mensajes : Long[]) : void
        // pasandole el oidSolicitud y en el arreglo de mensajes la constante ConstantesMSG.PED10
        String[] mensajes = new String[1];
        mensajes[0] = ConstantesMSG.MENSAJE_PED10;

        try {
            this.eliminarMensajes(dtoin.getOidSolicitud(), dtoin.getOidPais(), mensajes);
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        mensajes = null;
        daoSolicitud = null;
        // Retorna un DTOEstatusSolicitud indicando como estado de retorno
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirMontoMinimo(DTOSolicitudValidacion dtoin): Salida ");
        return dtos;
    }

    /**
     * Se llama al metodo obtenerValoresMontoMinimo del DAOPEDIntegracion.
     * Si el valor retornado es NULL entoces
     * Se retorna un DTOEstatusSolicitud con estado=ConstantesPED.ESTADO_SOLICITUD_VALIDADO
     * termina la ejecucion del metodo.
     * Sino entonces:
     * {
     * // Se recorren todos los DTODatosMontoMinimo para determinar cual es el más conveniente al cliente
     * Se crean dos variables Integer nivel=0 y BigDecimal varRecargo=0.
     * Para cada DTODatosMontoMinimo
     * {
     * Mientra nivel<4 entonces
     * {
     * Si DTODatosMontoMinimo.solPreCatalogoTotalLocal < DTODatosMontoMinimo.nivel1 entoces
     * Si nivel=0 entonces nivel=1
     * Sino {
     * Si DTODatosMontoMinimo.solPreCatalogoTotalLocal < DTODatosMontoMinimo.nivel2 entoces
     * Si nivel=<2 entonces nivel=2
     * Si varRecargo=0 entonces varRecargo=DTODatosMontoMinimo.recargo
     * Sino
     * Si DTODatosMontoMinimo.recargo<varRecargo entonces varRecargo=DTODatosMontoMinimo.recargo
     * Sino {
     * Si DTODatosMontoMinimo.solPreCatalogoTotalLocal < DTODatosMontoMinimo.nivel3 entoces
     * Si nivel=<3 entonces nivel=3
     * Sino {
     * Si DTODatosMontoMinimo.solPreCatalogoTotalLocal >= DTODatosMontoMinimo.nivel3 entoces
     * nivel=4
     * }
     * }
     * }
     * }
     * }
     * }
     *
     *
     *
     *
     * Case (nivel)
     * {
     * nivel=1:
     * //Coloca la solicitud como rechazada
     * Retorna un DTOEstatusSolicitud indicando como estado de retorno: ConstantesPED.ESTADO_SOLICITUD_RECHAZADO
     * termina la ejecucion del metodo
     * nivel=2:
     * // Se calculan los montos de recargoFleteLocal y recargoFleteDocumento
     * Si dtoin.oidMonedo=NULL entonces
     * {
     * recargoFleteLocal=varRecargo
     * recargoFleteDocumento=varRecargo
     * }
     * Sino
     * {
     * recargoFleteLocal=varRecargo
     * recargoFleteDocumento=varRecargo*dtoin.tipoCambio //Se le aplica el tipo de cambio
     * }
     *
     * //Se actualizan los campos recargoFleteLocal y recargoFleteDocumento
     * Llama al metodo actualizarValoresFlete del DAOSolicitud pasandole dtoin.oidSolicitud, el valor calculado para recargoFleteLocal y recargoFleteDocumento y el valor dtoin.numDecimales
     * //Envia mensaje a la consulltora
     * Se hace un (findByUk) en la entidad MSG:Mensaje con el dtoin.oidPais y la constante ConstantesMSG.PED10 se obtiene el varOidMensaje.
     * Se hace un findByEntAtrIdioPK en la entidad EntidadI18n utilizando las constantes ENTIDAD_DESC_TRADU y MSG_MONTO_MINIMO (entidadPK), con atributo=1 e idioma=ConstantesSEG.IDIOMA_DEFECTO, obteniendo la descripción en la variable varMensajeMontoMinimo.
     * Se crea un DTOBuzonMensajes
     * .- pais = dtoin.oidPais
     * .- oidMensaje= varOidMensaje.
     * .- oidCliente = dtoin.oidCliente
     * .- ModuloOrgien= ConstantesSEG.MODULO_PED
     * .- datoVariable1 = varMensajeMontoMinimo
     * .- datoVariable2 = recargoFleteDocumento
     * .- listaConsultoras= ConstantesMSG.NO
     * Llama al metodo enviarMensajeValidaciones pasandole el DTOBuzonMensajes creado y el dtoin.oidSolicitud.
     * nivel=3:
     * //No se hace nada
     * nivel=4:
     * //Coloca la solicitud como exenta de Flete
     * actualizarExentoFlete(oidSolicitud , TRUE)
     * }
     *
     * Se retorna un DTOEstatusSolicitud con estado=ConstantesPED.ESTADO_SOLICITUD_VALIDADO
     */
     public DTOEstatusSolicitud validarMontoMinimo(DTOSolicitudValidacion dtoin) throws MareException {
         UtilidadesLog.info("MONPEDValidacionBean.validarMontoMinimo(DTOSolicitudValidacion dtoin): Entrada ");
         DTODatosMontoMinimo[] dtoDatosMontoMinimo;

         DAOSolicitud daoSolicitud = new DAOSolicitud();

         Integer iNivel = new Integer(0);
         BigDecimal bgdRecargo = new BigDecimal(0);
         BigDecimal montoNivel1 = new BigDecimal(0);

         // sapaza -- PER-SiCC-2011-0726 -- 25/01/2012
         if(dtoin.getIndRecepcionOnline()!=null && dtoin.getIndRecepcionOnline()) {
             UtilidadesLog.debug("esRecepcionOnline.....");
             daoSolicitud.generarProductosAlternativos(dtoin.getOidSolicitud());
         }

         DAOPEDIntegracion daoPedIntegracion = new DAOPEDIntegracion();
         //doliva -- cambio Optimizacion Logs -- 09/04/2010
		 if(log.isDebugEnabled())
			UtilidadesLog.debug("el DTOSolicitudValidacion recibidos, es: " + dtoin);

         dtoDatosMontoMinimo = daoPedIntegracion.obtenerValoresMontoMinimo(dtoin.getOidSolicitud());
         if (dtoDatosMontoMinimo == null) {
           UtilidadesLog.debug("no se obtuvieron valores de monto minimo, se retorna nada....");
           DTOEstatusSolicitud dtoes = new DTOEstatusSolicitud();
           dtoes.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
           return dtoes;        
         }
         dtoin.setPreCatalogoTotalLocal( dtoDatosMontoMinimo[0].getSolPreCatalogoTotalLocal() );
        
         for (int i = 0; i < dtoDatosMontoMinimo.length; i++) {
			 //doliva -- cambio Optimizacion Logs -- 09/04/2010
			 if(log.isDebugEnabled()){
				 UtilidadesLog.debug("analizo item: " + i);
				 UtilidadesLog.debug("valores obtenidos: " + dtoDatosMontoMinimo[i]);
			 }
             if (iNivel.intValue() < 5 ) {
                 if(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal().compareTo(dtoDatosMontoMinimo[i].getMontoMinimoNomi())==-1) {
                     //doliva -- cambio Optimizacion Logs -- 09/04/2010
					 if(log.isDebugEnabled()){
						 UtilidadesLog.debug(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal() + " < " + dtoDatosMontoMinimo[i].getMontoMinimoNomi());                
						 UtilidadesLog.debug("nivel: " + iNivel.intValue());
					 }
                     if(iNivel.intValue() == 0) 
                         iNivel = new Integer(1);
                 } else if(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal().compareTo(dtoDatosMontoMinimo[i].getNivel1())==-1) {
                     //doliva -- cambio Optimizacion Logs -- 09/04/2010
					 if(log.isDebugEnabled()){
						 UtilidadesLog.debug(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal() + " < " + dtoDatosMontoMinimo[i].getNivel1());                
						 UtilidadesLog.debug("nivel: " + iNivel.intValue());
					 }
                     if(iNivel.intValue() <= 2) {
                         iNivel = new Integer(2);
                         bgdRecargo = new BigDecimal(dtoDatosMontoMinimo[i].getRecargo().doubleValue());
                         montoNivel1 = new BigDecimal(dtoDatosMontoMinimo[i].getNivel1().doubleValue());
                     }
                 } else if(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal().compareTo(dtoDatosMontoMinimo[i].getNivel2())==-1) {
                     //doliva -- cambio Optimizacion Logs -- 09/04/2010
					 if(log.isDebugEnabled()){
						 UtilidadesLog.debug(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal() + " < " + dtoDatosMontoMinimo[i].getNivel2());
						 UtilidadesLog.debug("nivel aca es: " + iNivel.intValue());
					 }
                     if(iNivel.intValue() <= 3) {
                         iNivel = new Integer(3);
                         bgdRecargo = new BigDecimal(dtoDatosMontoMinimo[i].getRecargo().doubleValue());  
                     }
                 } else if(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal().compareTo(dtoDatosMontoMinimo[i].getNivel3())==-1) {
                     //doliva -- cambio Optimizacion Logs -- 09/04/2010
					 if(log.isDebugEnabled()){
						 UtilidadesLog.debug(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal() + " < " + dtoDatosMontoMinimo[i].getNivel3());
						 UtilidadesLog.debug("iNivel es: " + iNivel.intValue());
					 }
                     if(iNivel.intValue() <= 4)
                          iNivel = new Integer(4);                      
                 } else if(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal().compareTo(dtoDatosMontoMinimo[i].getNivel3())>=0) {
                     //doliva -- cambio Optimizacion Logs -- 09/04/2010
					 if(log.isDebugEnabled())
						UtilidadesLog.debug(dtoDatosMontoMinimo[i].getSolPreCatalogoTotalLocal() + " >= " + dtoDatosMontoMinimo[i].getNivel3()); 
                     iNivel = new Integer(5);
                 }    
             }
         }

		 //doliva -- cambio Optimizacion Logs -- 09/04/2010
	     if(log.isDebugEnabled())
			UtilidadesLog.debug("el iNivel con el que salgo es: " + iNivel.intValue());

         switch(iNivel.intValue()) {
             case 1:
                 DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
                 dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_RECHAZADO);
                 /* Agregado por Brecha COL-BLO-001 ------ AL */
                 try {
                     this.getMONPEDValidacionLocalHome().create().bloquearCliente(dtoin);
                 } catch(Exception ce) {
                     ctx.setRollbackOnly();
                     UtilidadesLog.error("Exception: ",ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                 }                 
                 /* Agregado por Brecha COL-BLO-001 ------ AL */
                 UtilidadesLog.debug("case 1, rechazo y retorno....");
                 return dtos;
             case 2:
             UtilidadesLog.debug("case 2, analisis de monto minimo nivel 2....");
             try {
               ArrayList arrayProductos = (ArrayList)this.recuperarProductosParaAgregar(dtoin.getOidPeriodo()); 
               Long oidMensaje = (Long)this.recuperarOidMensaje(dtoin.getOidPais());
               if (arrayProductos.size() > 0) {
                   boolean insertoPosiciones = false;
                   ArrayList arrayProductosAgregados = new ArrayList();
                   Iterator it = arrayProductos.iterator();
                   double montoCompletar = montoNivel1.doubleValue() - dtoin.getPreCatalogoTotalLocal().doubleValue();                      
                   while (it.hasNext()) {
                       DTOProductosMontoMinimo dtoProductosMontoMinimo = (DTOProductosMontoMinimo)it.next();
                       arrayProductosAgregados.add(dtoProductosMontoMinimo);
                       //doliva -- cambio Optimizacion Logs -- 09/04/2010
					   if(log.isDebugEnabled()){
						   UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - Producto a Agregar - Codigo Venta ---> " + dtoProductosMontoMinimo.getCodigoVenta());    
						   UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - Producto a Agregar - Precio Unitario ---> " + dtoProductosMontoMinimo.getPrecioUnitario());    
						   UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - Monto a Completar antes de Agregar Producto ---> " + montoCompletar);    
                       }
					   montoCompletar = montoCompletar - dtoProductosMontoMinimo.getPrecioUnitario().doubleValue();
                       UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - Monto a Completar despues de Agregar Producto ---> " + montoCompletar);    
                       if (montoCompletar <= 0) {
                           insertoPosiciones = true;        
                           break;
                       }                        
                   }             
                   if (insertoPosiciones) {
                       StringBuffer cadenaInserciones = new StringBuffer();                        
                       ArrayList arrayMensajes = new ArrayList();
                       it = arrayProductosAgregados.iterator();
                       BigDecimal montoSolicitud = dtoin.getPreCatalogoTotalLocal();
                       while (it.hasNext()) {
                           DTOProductosMontoMinimo dtoProductosMontoMinimo = (DTOProductosMontoMinimo)it.next();
                           arrayMensajes.add((DTOBuzonMensajes)this.armaBuzonMensajeProdMontoMinimo(oidMensaje, dtoin, dtoProductosMontoMinimo));    
                           cadenaInserciones.append(this.generarCadenaInsercionPosiciones(dtoin, dtoProductosMontoMinimo).toString());
                           montoSolicitud = new BigDecimal(montoSolicitud.floatValue() + dtoProductosMontoMinimo.getPrecioUnitario().floatValue());
                           
                       }
                       cadenaInserciones.append(this.generarUpdateCabecera(dtoin, montoSolicitud).toString());
                       cadenaInserciones.append(this.generarUpdateCabeceraAcum2(dtoin, montoSolicitud).toString());
                       int sizeArrayMensajes = arrayMensajes.size();
                       DTOBuzonMensajes[] dtoBuzonMensajes = new DTOBuzonMensajes[sizeArrayMensajes];
                       for(int i=0; i < sizeArrayMensajes; i++) {
                          dtoBuzonMensajes[i] = (DTOBuzonMensajes)arrayMensajes.get(i);
                       }
                       this.enviarMensajesMontoMinimo(dtoBuzonMensajes);
                       cadenaInserciones.append(this.generarCadenaInsercionMensajes(dtoin, oidMensaje, dtoBuzonMensajes));
                       cadenaInserciones.append(this.generarUpdateRecargo(dtoin.getOidSolicitud(), bgdRecargo));
                       this.insertarPosicionesYMensajes(cadenaInserciones);
                   } else {
                       UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - Los productos existentes no alcanzan para llegar al siguiente nivel");    
                       this.rechazarSolicitud();
                   }
               } else {
                   UtilidadesLog.debug("[MONPEDValidacionBean.validarMontoMinimo] - No existen productos para agregar al nivel 2");
                   this.rechazarSolicitud();
               }
             } catch(Exception e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
             }
               break;
             case 3: // Cobra Recargo
                 UtilidadesLog.debug("case3, Cobra Recargo...");
                 this.insertarPosicionesYMensajes(this.generarUpdateRecargo(dtoin.getOidSolicitud(), bgdRecargo));                
                 break;                
             case 4: // No hace nada
                 UtilidadesLog.debug("case4, nada...");
                 break;
             case 5:
                 UtilidadesLog.debug("case 5, act. exento flete, con: " + dtoin.getOidSolicitud() + " y true!"); 
                 daoSolicitud.actualizarExentoFlete(dtoin.getOidSolicitud(), new Boolean(true));
                 break;
         } // end case

         DTOEstatusSolicitud dtoes = new DTOEstatusSolicitud();
         dtoes.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
         UtilidadesLog.info("MONPEDValidacionBean.validarMontoMinimo(DTOSolicitudValidacion dtoin): Salida ");
         return dtoes;
     }
     
    private StringBuffer generarUpdateRecargo (Long oidSolicitud, BigDecimal valorRecargo) {
        UtilidadesLog.info("MONPEDValidacionBean.generarUpdateRecargo(Long oidSolicitud, BigDecimal valorRecargo): Entrada ");
        StringBuffer query = new StringBuffer();
        
        query.append("UPDATE PED_SOLIC_CABEC SET VAL_RECA_FLET_LOCA = ").append(valorRecargo).append(" WHERE OID_SOLI_CABE = ").append(oidSolicitud).append(";");
        
        UtilidadesLog.info("MONPEDValidacionBean.generarUpdateRecargo(Long oidSolicitud, BigDecimal valorRecargo): Salida ");
        return query;
    }
    
    public DTOEstatusSolicitud validarLimiteVenta(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarLimiteVenta(DTOSolicitudValidacion dtoin): Entrada ");
        
        // sapaza -- PER-SiCC-2012-0805 -- 11/09/2012
        if(dtoin.getIndValidacionPROL() != null && dtoin.getIndValidacionPROL()) {
            UtilidadesLog.debug("IndValidacionPROL activo.....");
            
            DTOEstatusSolicitud dtoE = new DTOEstatusSolicitud();
            dtoE.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            UtilidadesLog.info("MONPEDValidacionBean.validarLimiteVenta(DTOSolicitudValidacion dtoin): Salida ");
            return dtoE;
        }
        
        
        DAOPEDIntegracion daoPedIntegracion = new DAOPEDIntegracion();
        
        UtilidadesLog.debug("dentro de metodo: validarLimiteVenta");
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        DAOPosicion daoPosicion = new DAOPosicion();
        DTOLimVentaPosicion dtoLimiteVentaPosicion = new DTOLimVentaPosicion();
        ArrayList arrLimiteVentaPosicion = new ArrayList();

        arrLimiteVentaPosicion = (ArrayList)daoPedIntegracion.obtenerPosicionesLimiteVentas(dtoin.getOidSolicitud(),
                dtoin.getOidCliente(), dtoin.getOidPeriodo(), dtoin.getOidIdioma());
        //doliva -- cambio Optimizacion Logs -- 09/04/2010
		if(log.isDebugEnabled())        
			UtilidadesLog.debug("array de posiciones: " + arrLimiteVentaPosicion);        
        //boolean demandadasMayorLimite = false;
        String codVata = new String();
        String numLimVta = new String();

        //Para cada DTOLimVentaPosicion en el arreglo:
        if(arrLimiteVentaPosicion != null) {
            StringBuffer queryGeneral = new StringBuffer();
            Long lngOidMensaje;
            try {
                MensajesLocalHome msjLocalHome = new MensajesLocalHome();
                MensajesLocal msjLocal = msjLocalHome.findByUk(dtoin.getOidPais(), ConstantesMSG.MENSAJE_PED05);
                lngOidMensaje = msjLocal.getOid();
            } catch(NoResultException nre) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",nre);
                throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException pe) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",pe);
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
            for(int i = 0; i < arrLimiteVentaPosicion.size(); i++) {

                dtoLimiteVentaPosicion = (DTOLimVentaPosicion)arrLimiteVentaPosicion.get(i);

                if(dtoLimiteVentaPosicion.getNumLimVenta() != null) {
                    
                    //  Modificado por HRCS - Fecha 13/07/2007 - Cambio Sicc20070325
                    //if(dtoLimiteVentaPosicion.getNumUniDemandadas().intValue() <= dtoLimiteVentaPosicion.getNumLimVenta().intValue()) {
                    if(dtoLimiteVentaPosicion.getNumUniPorAtender().intValue() <= dtoLimiteVentaPosicion.getNumLimVenta().intValue()) {

                        //String query = daoPosicion.generarActualizarLimiteVenta(dtoLimiteVentaPosicion.getOidPosicion(),
                        //          dtoLimiteVentaPosicion.getNumUniDemandadas(), dtoLimiteVentaPosicion.getNumUniDemandadas());
                        String query = daoPosicion.generarActualizarLimiteVenta2(dtoLimiteVentaPosicion.getOidPosicion(), 
                                                                                 dtoLimiteVentaPosicion.getNumUniPorAtender() );
                        queryGeneral.append(query).append(";");

                    } else {
                            //doliva -- cambio Optimizacion Logs -- 09/04/2010
			    if(log.isDebugEnabled())
                                UtilidadesLog.debug("demandadas mayor que limite, actualizo limite con: " + dtoLimiteVentaPosicion.getOidPosicion() + " - " + dtoLimiteVentaPosicion.getNumLimVenta() + " - " + dtoLimiteVentaPosicion.getNumUniPorAtender());

                        String query = daoPosicion.generarActualizarLimiteVenta(dtoLimiteVentaPosicion.getOidPosicion(),
                                       dtoLimiteVentaPosicion.getNumLimVenta(), dtoLimiteVentaPosicion.getNumLimVenta());
                        queryGeneral.append(query).append(";");

                        //demandadasMayorLimite = true;
                        codVata = dtoLimiteVentaPosicion.getCodVenta()+ " " +dtoLimiteVentaPosicion.getDescripcionProducto();
                        //  Modificado por HRCS - Fecha 18/07/2007 - Cambio Sicc20070325
                        numLimVta = new Long(dtoLimiteVentaPosicion.getNumUniPorAtender().longValue()-dtoLimiteVentaPosicion.getNumLimVenta().longValue()).toString();
                        //  Si se dio demandadas mayor que limite; mando mensaje
                        DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
                        dtoBuzonMensajes.setOidPais(dtoin.getOidPais());
                        dtoBuzonMensajes.setOidMensaje(lngOidMensaje);
                        dtoBuzonMensajes.setOidCliente(dtoin.getOidCliente());
                        dtoBuzonMensajes.setCodigoMensaje(ConstantesMSG.MENSAJE_PED05);
                        dtoBuzonMensajes.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
                        dtoBuzonMensajes.setDatoVariable1(codVata);
                        dtoBuzonMensajes.setDatoVariable2(numLimVta);
                        dtoBuzonMensajes.setListaConsultoras(ConstantesMSG.NO);
                        try {
                            this.enviarMensajeValidaciones(dtoin.getOidSolicitud(), dtoBuzonMensajes);
                        } catch(Exception e) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("Exception: ",e);
                            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                        }
                    } // end if 2
                     
                } // end if 1
                dtoLimiteVentaPosicion = null;
            } // end for
            
            try{
                DBService db = BelcorpService.getInstance().dbService;
                db.executeProcedure("PQ_PLANI.EXECUTOR", queryGeneral.toString());
            }catch(Exception e){
                ctx.setRollbackOnly();
                UtilidadesLog.error("Exception: ",e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }     
        UtilidadesLog.debug("solicitud validada.........");
        DTOEstatusSolicitud dtoes = new DTOEstatusSolicitud();
        dtoes.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.validarLimiteVenta(DTOSolicitudValidacion dtoin): Salida ");
        return dtoes;
    }

    public DTOEstatusSolicitud calcularTotales(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.calcularTotales(DTOSolicitudValidacion dtoin): Entrada ");
        DAOSolicitud dao = new DAOSolicitud();
        dao.calcularTotales(dtoin.getOidSolicitud(), dtoin.getNumDecimales(), dtoin.getOidMoneda(), 
                        dtoin.getTipoCambio(), dtoin.getIndRecepcionOnline());

        DTOEstatusSolicitud dtoE = new DTOEstatusSolicitud();
        dtoE.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.calcularTotales(DTOSolicitudValidacion dtoin): Salida ");
        return dtoE;
    }

    private MONMantenimientoMFHome getMONMantenimientoMFHome()
        throws MareException {
        MONMantenimientoMFHome home = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            home = (MONMantenimientoMFHome)bs.ejbLocator.getHome("MONMantenimientoMF", MONMantenimientoMFHome.class);
        } catch(MareServiceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return home;
    }

    private MONGenerarPosicionSolicitudHome getMONGenerarPosicionSolicitudHome()
        throws MareException {
        MONGenerarPosicionSolicitudHome home = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            home = (MONGenerarPosicionSolicitudHome)bs.ejbLocator.getHome("MONGenerarPosicionSolicitud",
                    MONGenerarPosicionSolicitudHome.class);
        } catch(MareServiceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        return home;
    }

    public DTOEstatusSolicitud validarAgregados(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarAgregados(DTOSolicitudValidacion dto): Entrada ");
        try {
            UtilidadesLog.info("MONPEDValidacionBean.validarAgregados(DTOSolicitudValidacion dto): Salida ");
            DTOEstatusSolicitud dtoS = this.getMONProcesoEnvioAgregadosSolicitudHome().create().validarAgregados(dto);
            return dtoS;
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
    }

    public DTOEstatusSolicitud revertirAgregados(DTOSolicitudValidacion dto)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirAgregados(DTOSolicitudValidacion dto): Entrada ");
        try {
            DTOSolicitudReversion dtoSR = cargarSolicitudReversion(dto);
            UtilidadesLog.info("MONPEDValidacionBean.revertirAgregados(DTOSolicitudValidacion dto): Salida ");
            return this.getMONProcesoEnvioAgregadosSolicitudHome().create().revertirAgregados(dtoSR);
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    private MONProcesoEnvioAgregadosSolicitudHome getMONProcesoEnvioAgregadosSolicitudHome()
        throws MareException {
        MONProcesoEnvioAgregadosSolicitudHome home = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch(MareMiiServiceNotFoundException e) {
            String codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            home = (MONProcesoEnvioAgregadosSolicitudHome)bs.ejbLocator.getHome("MONProcesoEnvioAgregadosSolicitud",
                    MONProcesoEnvioAgregadosSolicitudHome.class);
        } catch(MareServiceException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("getMONProcesoEnvioAgregadosSolicitudHome() finalizo");

        return home;
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       24/09/2004
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOEstatusSolicitud validarLineaCredito(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarLineaCredito(DTOSolicitudValidacion dtoin): Entrada ");
        DTOEstatusSolicitud estatus = new DTOEstatusSolicitud();
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        Long estatusCredito = null;

        // Obtiene el estatus de la solicitud
        Long varEstadoSolicitud = daoSolicitud.obtenerEstadoSolicitud(dtoin.getOidSolicitud());

        if(varEstadoSolicitud.equals(ConstantesPED.ESTADO_SOLICITUD_LIBERADO)) {
            estatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_LIBERADO);
            UtilidadesLog.info("MONPEDValidacionBean.validarLineaCredito(DTOSolicitudValidacion dtoin): Salida ");
            return estatus;
        }

        // Valida la linea de credito
         try{
           estatusCredito = CAREjbLocators.getMONValidarCreditosHome().create().validarLineaCredito(dtoin);
         } catch(RemoteException e){
             ctx.setRollbackOnly();
             throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }catch(CreateException e){
             ctx.setRollbackOnly();
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }
         
        // Valida el estado
        if(estatusCredito.equals(ConstantesCAR.ESTATUS_APROBADO)) {
            // Estatus aprobado
            daoSolicitud.actualizarEstatusCredito(dtoin.getOidSolicitud(), ConstantesCAR.ESTATUS_APROBADO);
            estatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
            UtilidadesLog.info("MONPEDValidacionBean.validarLineaCredito(DTOSolicitudValidacion dtoin): Salida ");
            return estatus;
        } else {
            // Estatus bloqueado
            estatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_BLOQUEADO);
            UtilidadesLog.info("MONPEDValidacionBean.validarLineaCredito(DTOSolicitudValidacion dtoin): Salida ");
            return estatus;
        }
    }

    /**
    * Sistema:     Belcorp
    * Modulo:      CAR
    * Fecha:       24/09/2004
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
    public DTOEstatusSolicitud reversionLineaCredito(DTOSolicitudValidacion dtoin)
        throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.reversionLineaCredito(DTOSolicitudValidacion dtoin): Entrada ");
        DTOEstatusSolicitud estatus = new DTOEstatusSolicitud();
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        Long estatusCredito = null;

        // Reversion de la linea de credito

         try{
             UtilidadesLog.debug("busco==>>getMONValidarCreditosHome().create().reversionLineaCredito(...");
             estatusCredito = CAREjbLocators.getMONValidarCreditosHome().create().reversionLineaCredito(dtoin);
         } catch(RemoteException e){
             ctx.setRollbackOnly();
             throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }catch(CreateException e){
             ctx.setRollbackOnly();
             throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
         }

        // Valida el estado
        if(estatusCredito.equals(ConstantesCAR.ESTATUS_APROBADO))
            // Estatus aprobado
            daoSolicitud.actualizarEstatusCredito(dtoin.getOidSolicitud(), null);

        // Estatus aprobado
        estatus.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.reversionLineaCredito(DTOSolicitudValidacion dtoin): Salida ");
        return estatus;
    }

    private Long bigDecimalToLong(BigDecimal number) throws Exception {
        if(number == null)
            return null;

        return new Long(number.longValue());
    }

    private Integer bigDecimalToInteger(BigDecimal number) throws Exception {
        if(number == null)
            return null;

        return new Integer(number.intValue());
    }

    private Boolean bigDecimalToBoolean(BigDecimal number) throws Exception {
        if(number == null)
            return null;

        if(number.longValue() == 0)
            return Boolean.FALSE;
        else if(number.longValue() == 1)
            return Boolean.TRUE;
        else
            return null;
    }

   private MONValidarCreditosHome getMONValidarCreditosHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MONValidarCreditosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidarCreditos"), MONValidarCreditosHome.class);
  }
  
  /**
   * Paola Cabrera
   */

	public DTOEstatusSolicitud recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws MareException {
      try {
          UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto): Entrada ");
          UtilidadesLog.debug("se recibe dto (DTOSolicitudValidacion): " + dto);
          
          Integer iFaltantes;
          Integer controlStock;
          
          Long oidPosicion;	
         
          int unidadesdemandadas;
          int unidadesComprometidas;
          int unidadesatender;
          int faltanteU;
          int faltanteC;
          int valorFaltante;		
          
          boolean existeProductoRecuperacion;		
          RecordSet posicionesF;		
          //DTOCabeceraSolicitud dtoCabeceraSolicitud = null;		
          ArrayList posiciones = null;		
       
          DAOPosicion daoPosicion = new DAOPosicion();
          
          posicionesF = daoPosicion.obtenerPosicionesFaltantesMismoPeriodo(dto);
          UtilidadesLog.debug("GGG despues de obtenerPosiciones>>>>> " + posicionesF);			
          
          /*
          if (!posicionesF.esVacio()){
              DAOSolicitud daoSolicitud = new DAOSolicitud();
              dtoCabeceraSolicitud = daoSolicitud.obtenerCabeceraSolicitud(dto.getOidSolicitud());
              UtilidadesLog.debug(" dtoCabeceraSolicitud >>>>>" + dtoCabeceraSolicitud.toString());
            
              // A continuación recupera las posiciones de la solicitud 
              posiciones = daoSolicitud.obtenerPosicionesSolicitud(dto.getOidSolicitud());
              UtilidadesLog.debug("Cantidad de Posiciones de la solicitud : "+posiciones.size());
              dtoCabeceraSolicitud.setPosiciones(posiciones);
          }*/
          
          // Por cada elemento en posicionesFaltantes
          for(int i = 0; i < posicionesF.getRowCount(); i++) {

              if (!dto.getIndSimulacion().booleanValue()){
                UtilidadesLog.debug("SCS, se act. estado de posicion: " + posicionesF.getValueAt(i, "OIDPOSICION") + ", a ConstantesPED.ESTADO_POSICION_RECUPERACION....");
                daoPosicion.actualizarEstado(new Long(posicionesF.getValueAt(i, "OIDPOSICION").toString()), ConstantesPED.ESTADO_POSICION_RECUPERACION );
              }

              DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion = new DTOGenerarPosicionRecuperacion();			
              
              //Seteo de Valores al dtoGenerarPosicionRecuperacion
              
              // - oid
              dtoGenerarPosicionRecuperacion.setOidPosicion(new Long(posicionesF.getValueAt(i, "OIDPOSICION").toString()));
              
                      // - faltante 
              
              faltanteU = new BigDecimal(posicionesF.getValueAt(i, "UNIDADESATENDER").toString()).intValue();
              faltanteC = new BigDecimal(posicionesF.getValueAt(i, "UNIDADESCOMPROMETIDAS").toString()).intValue();
              
              iFaltantes = new Integer(faltanteU - faltanteC);
                     
              dtoGenerarPosicionRecuperacion.setFaltante(iFaltantes);
              
              // - cvFicticio = posiciones(i).ventaficticia 
              dtoGenerarPosicionRecuperacion.setCvFicticio(new Long(posicionesF.getValueAt(i, "VENTAFICTICIA").toString()));
              
              // - porecentaje descuento
              dtoGenerarPosicionRecuperacion.setPorcentajeDescuento(new BigDecimal(posicionesF.getValueAt(i, "PORCENTAJEDESCUENTO").toString()));
              
              // - importe descuento unitario documento
              dtoGenerarPosicionRecuperacion.setImporteDescuentoUnitarioDocumento(new BigDecimal(posicionesF.getValueAt(i, "DESCUENTOUNITARIODOCUMENTO").toString()));
                      
              // - forma pago
              dtoGenerarPosicionRecuperacion.setFormaPago(bigDecimalToLong(new BigDecimal(posicionesF.getValueAt(i, "FORMAPAGO").toString())));
              
              // - periodo
              //dtoGenerarPosicionRecuperacion.setPeriodo(new Long(((BigDecimal)posicionesF.getValueAt(i, "PERIODO")).toString()));
              dtoGenerarPosicionRecuperacion.setPeriodo(dto.getOidPeriodo());
              
              // - codigo de venta 
              dtoGenerarPosicionRecuperacion.setCodigoVenta((posicionesF.getValueAt(i, "VENTA")).toString());
              
              // - producto 
              dtoGenerarPosicionRecuperacion.setOidProducto(new Long(posicionesF.getValueAt(i, "PRODUCTO").toString()));
              
              // - detalle oferta detalleOferta
              dtoGenerarPosicionRecuperacion.setDetalleOferta(new Long(posicionesF.getValueAt(i, "DETALLEOFERTA").toString()));
              
              // - precio catalogo unitario local precioCatalogoUnitarioLocal
              dtoGenerarPosicionRecuperacion.setPrecioCatalogoUnitarioLocal(new BigDecimal(posicionesF.getValueAt(i, "PRECIOCATALOGOUNITARIOLOCAL").toString()));
              
              // - precio contable unitario local precioContableUnitarioLocal
              dtoGenerarPosicionRecuperacion.setPrecioContableUnitarioLocal(new BigDecimal(posicionesF.getValueAt(i, "PRECIOCONTABLEUNITARIOLOCAL").toString()));
              
              // - precio catalogo unitario documento precioCatalUnitarioDoc
              dtoGenerarPosicionRecuperacion.setPrecioCatalogoUnitarioDocumento(new BigDecimal(posicionesF.getValueAt(i, "PRECIOCATALUNITARIODOC").toString()));
              
              // - precio contable unitario documento precioContableUnitarioDoc
              dtoGenerarPosicionRecuperacion.setPrecioContableUnitarioDocumento(new BigDecimal(posicionesF.getValueAt(i, "PRECIOCONTABLEUNITARIODOC").toString()));
              
              
              this.generarPosicionRecuperacion2(dto, dtoGenerarPosicionRecuperacion);
              //dtoCabeceraSolicitud = this.generarPosicionRecuperacion(dto, dtoGenerarPosicionRecuperacion, dtoCabeceraSolicitud);
              
          }
             // fin posicionesFaltantes
      } catch(MareException me) {
          UtilidadesLog.error("Exception: ",me);
          throw me;
      } catch(Exception e) {
          UtilidadesLog.error("Exception: ",e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.debug(" GGG contenido de dtoEstatusSolicitud**** " + dtoEstatusSolicitud.toString());
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

	 /**
     * Genera una posición de recuperación.
     * @autor pcabrera
     * NO SE USA MAS!!!! jpbosnja
     * se uitiliza!, ver inc.: BELC300022017
     */
    private void generarPosicionRecuperacion2(DTOSolicitudValidacion dtoe, DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion) throws MareException{

        UtilidadesLog.info("MONPEDValidacionBean.generarPosicionRecuperacion2(DTOSolicitudValidacion dtoe, DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion): Entrada ");
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        
        ArrayList posiciones;	
        RecordSet rsProductoRecuperacion;
        String cv = null;
        
        DTOProceso dtoProceso;
        DTOSalida dtoSalidaProductoRecuperacion;
        DTOCabeceraSolicitud dtoCabeceraSolicitud;	
        DTOPosicionSolicitud dtoPosicionSolicitud;
        DTOObtenerProductoRecuperacion dtoObtenerProductoRecuperacion;
       		

        try {
            dtoCabeceraSolicitud = daoSolicitud.obtenerCabeceraSolicitud(dtoe.getOidSolicitud());
            UtilidadesLog.debug(" dtoCabeceraSolicitud >>>>>" + dtoCabeceraSolicitud);
            
            // A continuación recupera las posiciones de la solicitud 
            posiciones = daoSolicitud.obtenerPosicionesSolicitud(dtoe.getOidSolicitud());
            UtilidadesLog.debug("Cantidad de Posiciones de la solicitud : "+posiciones.size());
            dtoCabeceraSolicitud.setPosiciones(posiciones);
            
            //prueba SCS
            dtoCabeceraSolicitud.setIndicadorDigitacion(Boolean.FALSE);
            
            // Obtenemos los datos del proceso recibido 
            dtoProceso = dtoe.getProceso();
            
            UtilidadesLog.debug("dtoGenerarPosicionRecuperacion>>>>" + dtoGenerarPosicionRecuperacion);
            
            if (dtoGenerarPosicionRecuperacion.getOidProducto() == null) {
                //Se crea un DTOObtenerProductoRecuperacion
                dtoObtenerProductoRecuperacion = new DTOObtenerProductoRecuperacion();
                
                // - periodoActual = DTOE.oidPeriodo 
                dtoObtenerProductoRecuperacion.setPeriodoActual(dtoe.getOidPeriodo());
                // - periodoFaltante = DTOGenerarPosicionRecuperacion.periodo 
                dtoObtenerProductoRecuperacion.setPeriodoFaltante(dtoGenerarPosicionRecuperacion.getPeriodo());
                // - codigoVentaFaltante = DTOGenerarPosicionRecuperacion.codigoVenta 
                dtoObtenerProductoRecuperacion.setCodigoVentaFaltante(dtoGenerarPosicionRecuperacion.getCodigoVenta());
                //DTOSalida = Llamar al método IServiceMF.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion) 
                try {
                    UtilidadesLog.debug("voy a matriz de recuperacion.....");
                    MONMantenimientoMFHome monMantenimientoMFHome = this.getMONMantenimientoMFHome();
                    MONMantenimientoMF monMantenimientoMF = monMantenimientoMFHome.create();
                    dtoSalidaProductoRecuperacion = monMantenimientoMF.obtenerProductoRecuperacion(dtoObtenerProductoRecuperacion);
                    UtilidadesLog.debug("dtoSalidaProductoRecuperacion>>>>" + dtoSalidaProductoRecuperacion);
                } catch(RemoteException e) {
                    UtilidadesLog.error("Exception: ",e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch(CreateException e) {
                    UtilidadesLog.error("Exception: ",e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                if (dtoSalidaProductoRecuperacion!=null && dtoSalidaProductoRecuperacion.getResultado()!=null
                    && !dtoSalidaProductoRecuperacion.getResultado().esVacio()){
                    cv = dtoSalidaProductoRecuperacion.getResultado().getValueAt(0,0).toString();
                    // Si cv == null entonces Lanza una MareException
                    if(cv == null){
                        //666 "El codigo de venta del Producto de Recuperacion es nulo"
                        ctx.setRollbackOnly();
                        throw new MareException(new Exception(), 666);
                    }    
                }else{
                    //666 "El codigo de venta del Producto de Recuperacion es nulo"
                    ctx.setRollbackOnly();
                    throw new MareException(new Exception(), 666);
                }
            }else{
                cv = dtoGenerarPosicionRecuperacion.getCodigoVenta();
            }
            
            UtilidadesLog.debug("cv +++ " + cv);
            
            // Creamos un DTOPosicionSolicitud posicionSolicitud con los datos: 
            dtoPosicionSolicitud = new DTOPosicionSolicitud();
            
            // - estadoPosicion = ConstantesPED.ESTADO_POSICION_CORECTO 
            dtoPosicionSolicitud.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_CORRECTO);
            
            //Incidencia BELC300013305::::>>>>Se modifica el envio del numero de posiciones.
            // - numeroPosicion: Tamaño del ArrayList DTOCabeceraSolicitud.posiciones + 1 
            //dtoPosicionSolicitud.setNumeroPosicion(new Long(dtoCabeceraSolicitud.getPosiciones().size()));   
            
            // - oidTipoPosicion: DTOProceso.oidTipoPosicion 
            dtoPosicionSolicitud.setTipoPosicion(dtoProceso.getOidTipoPosicion());
            
            // - oidSubtipoPosicion: DTOProceso.oidSubTipoPosicion 
            dtoPosicionSolicitud.setSubtipoPosicion(dtoProceso.getOidSubTipoPosicion());
            
            // - codigoVenta: cv 
            dtoPosicionSolicitud.setCodigoVenta(cv);
            
            // - unidadesDemandadas: DTOGenerarPosicionRecuperacion.faltante 
            dtoPosicionSolicitud.setUnidadesDemandadas(new Long(dtoGenerarPosicionRecuperacion.getFaltante().longValue()));
            
            // - unidadesPorAtender: DTOGenerarPosicionRecuperacion.faltante 
            dtoPosicionSolicitud.setUnidadesPorAtender(new Long(dtoGenerarPosicionRecuperacion.getFaltante().longValue()));
            
            // - codigoVentaFicticio = DTOGenerarPosicionRecuperacion.cvFicticio          
            if (dtoGenerarPosicionRecuperacion.getCvFicticio() != null)
                dtoPosicionSolicitud.setCodigoVentaFicticio(dtoGenerarPosicionRecuperacion.getCvFicticio());
            
            // - precioCatalogoUnitarioLocal = DTOGenerarPosicionRecuperacion.precioCatalogoUnitarioLocal          
            if (dtoGenerarPosicionRecuperacion.getPrecioCatalogoUnitarioLocal() != null)
                dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(dtoGenerarPosicionRecuperacion.getPrecioCatalogoUnitarioLocal());	
            
            // - precioCatalogoUnitarioDocumento = DTOGenerarPosicionRecuperacion.precioCatalogoUnitarioDocumento           
            if (dtoGenerarPosicionRecuperacion.getPrecioContableUnitarioDocumento() !=null)
                dtoPosicionSolicitud.setPrecioCatalogoUnitarioLocal(new BigDecimal(dtoGenerarPosicionRecuperacion.getPrecioCatalogoUnitarioDocumento().longValue()));
            
            // - precioContableUnitaroLocal = DTOGenerarPosicionRecuperacion.precioContableUnitarioLocal 
            if(dtoGenerarPosicionRecuperacion.getPrecioContableUnitarioLocal() !=null)
                dtoPosicionSolicitud.setPrecioContableUnitarioLocal(new BigDecimal(dtoGenerarPosicionRecuperacion.getPrecioContableUnitarioLocal().longValue()));
            
            // - precioContableUnitarioDocumento = DTOGenerarPosicionRecuperacion.precioContableUnitarioDocumento 
            if (dtoGenerarPosicionRecuperacion.getPrecioContableUnitarioDocumento() !=null){
                dtoPosicionSolicitud.setPrecioContableUnitarioDocumento(new BigDecimal(dtoGenerarPosicionRecuperacion.getPrecioContableUnitarioDocumento().longValue()));
            }            
            
            // - porcentajeDescuento = DTOGenerarPosicionRecuperacion.porcentajeDescuento
            if(dtoGenerarPosicionRecuperacion.getPorcentajeDescuento() != null){
                dtoPosicionSolicitud.setPorcentajeDescuento(new Double(dtoGenerarPosicionRecuperacion.getPorcentajeDescuento().doubleValue()));
            }
            
            // - importeDescuentoUnitarioDocumento = DTOGenerarPosicionRecuperacion.importeDescuentoUnitarioDocumento 
            if(dtoGenerarPosicionRecuperacion.getImporteDescuentoUnitarioDocumento() != null)                                       
                dtoPosicionSolicitud.setImporteDescuentoUnitarioDocumento(new BigDecimal(dtoGenerarPosicionRecuperacion.getImporteDescuentoUnitarioDocumento().longValue()));
            
            // - formaPago = DTOGenerarPosicionRecuperacion.formaPago         
            if(dtoGenerarPosicionRecuperacion.getFormaPago()!=null)
                dtoPosicionSolicitud.setFormaPago(dtoGenerarPosicionRecuperacion.getFormaPago());
            
            // - posicionRecuperacion = DTOGenerarPosicionRecuperacion.oidPosicion         
            if(dtoGenerarPosicionRecuperacion.getOidPosicion() !=null)
                dtoPosicionSolicitud.setPosicionRecuperacion(dtoGenerarPosicionRecuperacion.getOidPosicion());
            
            //---Agregado------ //- producto = DTOGenerarPosicionRecuperacion.oidProducto
            if (dtoGenerarPosicionRecuperacion.getOidProducto() != null){
                dtoPosicionSolicitud.setOidProducto(dtoGenerarPosicionRecuperacion.getOidProducto());
                dtoPosicionSolicitud.setProducto(dtoGenerarPosicionRecuperacion.getOidProducto());    
            }     
            // Se completa la posición 	
            dtoCabeceraSolicitud.getPosiciones().add(dtoPosicionSolicitud);        
            try {
                MONGenerarPosicionSolicitudHome monGenerarPosicionSolicitudHome = this.getMONGenerarPosicionSolicitudHome();
                MONGenerarPosicionSolicitud monGenerarPosicionSolicitud = monGenerarPosicionSolicitudHome.create();
                
                //Long lineaNumeroPosicion = new Long(dtoPosicionSolicitud.getNumeroPosicion().longValue());
                Long lineaNumeroPosicion = new Long(dtoCabeceraSolicitud.getPosiciones().size()-1);
                dtoCabeceraSolicitud = monGenerarPosicionSolicitud.generarPosicion(dtoCabeceraSolicitud, lineaNumeroPosicion, Boolean.TRUE);
            } catch(RemoteException e) {
                UtilidadesLog.error("Exception: ",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch(CreateException e) {
                UtilidadesLog.error("Exception: ",e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
            
            
            // Si DTOCabeceraSolicitud.OK == False
            if(!dtoCabeceraSolicitud.getOK().booleanValue()) {
                dtoPosicionSolicitud.setEstadoPosicion(ConstantesPED.ESTADO_POSICION_ANULADO);
                // Utilizar el servicio APPLoggingService para generar un log de error: [PED] [Validar cuadre de ofertas] Posición solicitud anulada 
                String mensajeLog = " [PED] [Validar cuadre de ofertas] Posición solicitud anulada ";
                BelcorpService.getInstance().log.info(mensajeLog);
            }		                       
            UtilidadesLog.info("MONPEDValidacionBean.generarPosicionRecuperacion2(DTOSolicitudValidacion dtoe, DTOGenerarPosicionRecuperacion dtoGenerarPosicionRecuperacion): Salida ");
            //return dtoCabeceraSolicitud;
        }catch(MareException e){
           ctx.setRollbackOnly();
           UtilidadesLog.error("Exception: ",e);
           throw e;
        }catch (Exception e){
           ctx.setRollbackOnly();
           UtilidadesLog.error("Exception: ",e);
           throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }
	
    /**
	 * Deshace el proceso de validación de recuperaciones. 
	 * autor: paola cabrera
	 * 
	 */

	public DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto) throws MareException {

            UtilidadesLog.info("MONPEDValidacionBean.reversionRecuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto): Entrada ");
			DTOEstatusSolicitud dtoe = new DTOEstatusSolicitud();
      
            dtoe = this.reversionRecuperacionObligatoriaMismoPeriodoVenta(dto, null);        
            UtilidadesLog.info("MONPEDValidacionBean.reversionRecuperacionObligatoriaMismoPeriodo(DTOSolicitudValidacion dto): Salida ");
			return dtoe;	 
	}


	/**
	 * Deshace el proceso de validación de recuperaciones.
	 * autor: Paola Cabrera
	 */

    public DTOEstatusSolicitud reversionRecuperacionObligatoriaMismoPeriodoVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException {
    
        UtilidadesLog.info("MONPEDValidacionBean.reversionRecuperacionObligatoriaMismoPeriodoVenta(DTOSolicitudValidacion dto, String codigoVenta): Entrada ");
        RecordSet posicionesF = null;		
        DTOCabeceraSolicitud dtoCabeceraSolicitud;		
        ArrayList posiciones;		
        
        DAOPosicion daoPosicion = new DAOPosicion();
        
        /**Anteriormente se pasaba el oidProceso... en tipoPosicion, pero se sabe que si es el
        * tipo posicion se debe pasar el tipo posicion como parametro, se habla con DT
        * */	
        posicionesF = daoPosicion.obtenerPosicionesFaltantesReversion(dto.getOidSolicitud(), dto.getProceso().getOidTipoPosicion(), dto.getProceso().getOidSubTipoPosicion(), codigoVenta);
        
        
        // Por cada elemento en posicionesFaltantes
        for(int i = 0; i < posicionesF.getRowCount(); i++) {
            if (dto.getIndSimulacion().equals("false")){
                daoPosicion.actualizarEstado(new Long(
                      posicionesF.getValueAt(i, "OIDPOSICION").toString()), ConstantesPED.ESTADO_POSICION_NO_ATENDIDA );
            }
        
            daoPosicion.eliminarPosicion(new Long(posicionesF.getValueAt(i, "OIDPOSICION").toString()));
            }
        
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.reversionRecuperacionObligatoriaMismoPeriodoVenta(DTOSolicitudValidacion dto, String codigoVenta): Salida ");
        return dtoEstatusSolicitud;  
    }

	/**
	* Deshace el proceso de recuperacion voluntaria 
	* Paola Cabrera 
	*/

	public DTOEstatusSolicitud revertirRecuperacionVoluntariaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException {


    UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionVoluntariaVenta(DTOSolicitudValidacion dto, String codigoVenta): Entrada ");
      boolean bPrimera = false;
      Long lDetalleOferta = new Long(0);

     RecordSet rsPosiciones;
     RecordSet rsFaltantes;

     DAOPosicion daoPosicion = new DAOPosicion();

    try {
            rsPosiciones = (RecordSet)daoPosicion.obtenerPosicionesReversionVoluntaria(dto.getOidSolicitud(),
                    dto.getProceso().getOidTipoPosicion(), dto.getProceso().getOidSubTipoPosicion());

            //Por cada elemento en posiciones
            if(!rsPosiciones.esVacio())
                for(int i = 0; i < rsPosiciones.getRowCount(); i++) {
                    int iDetalleOferta = new BigDecimal(rsPosiciones.getValueAt(i, "DETALLEOFERTA").toString()).intValue();

                    if(lDetalleOferta.intValue() != iDetalleOferta) {
                        lDetalleOferta = new Long(rsPosiciones.getValueAt(i, "DETALLEOFERTA").toString());
                        bPrimera = true;
                    }


                    /*
                     * Si dto.indSimulacion == False 
                    DAOPosicion.actualizarEstado( posiciones(i).posicionrecuperacion, ConstantesPED.ESTADO_POSICION_NO_ATENDIDA) 
                    Fin del Si 
                     * */
                    if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
                      UtilidadesLog.debug("dto.getIndSimulacion() " + dto.getIndSimulacion());
                      
                    if(!dto.getIndSimulacion().booleanValue()){
                        daoPosicion.actualizarEstado(new Long(rsPosiciones.getValueAt(i, "POSICIONRECUPERACION").toString())
                        ,ConstantesPED.ESTADO_POSICION_NO_ATENDIDA );
                    }
                    
                    //new Long((BigDecimal)dto.getValueAt(i, "OIDPOSICION"))
                    if(bPrimera) {
                        bPrimera = false;
                        daoPosicion.actualizaReversionVoluntaria(new Long(
                                rsPosiciones.getValueAt(i, "OIDPOSICION").toString()));
                    } else
                        daoPosicion.eliminarPosicion(new Long(rsPosiciones.getValueAt(i, "OIDPOSICION").toString()));
                        
                }//fin for
                
                
                
        } catch(MareException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        //Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
        dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionVoluntariaVenta(DTOSolicitudValidacion dto, String codigoVenta): Salida ");
        return dtos;
    }


   /**
	 * Deshace el proceso de recuperacion  obligatoria
	 * Paola Cabrera
	 *  
	 */

	public DTOEstatusSolicitud revertirRecuperacionObligatoriaVenta(DTOSolicitudValidacion dto, String codigoVenta) throws MareException {

        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionObligatoriaVenta(DTOSolicitudValidacion dto, String codigoVenta): Entrada ");
        RecordSet posiciones;
        Long posicionRecuperacion;

        DAOPosicion daoPosicion = new DAOPosicion();
		UtilidadesLog.debug("**********");
		UtilidadesLog.debug("antes de obtenerPosicionesFaltantesReversion");
		UtilidadesLog.debug("***********");
		UtilidadesLog.debug("dto.getOidSolicitud()>>>>>" + dto.getOidSolicitud());
		UtilidadesLog.debug("***********");
		UtilidadesLog.debug("dto.getProceso().getOidTipoPosicion() " + dto.getProceso().getOidTipoPosicion());
		UtilidadesLog.debug("************");
		UtilidadesLog.debug("dto.getProceso().getOidSubTipoPosicion() " + dto.getProceso().getOidSubTipoPosicion());
		UtilidadesLog.debug("*************");
		UtilidadesLog.debug("codigoVenta  " + codigoVenta);
		UtilidadesLog.debug("**************");
		
        posiciones = daoPosicion.obtenerPosicionesFaltantesReversion(dto.getOidSolicitud(), dto.getProceso().getOidTipoPosicion(),
                dto.getProceso().getOidSubTipoPosicion(), codigoVenta);
		UtilidadesLog.debug("despues de obtener posiciones-----");		

        // Por cada elemento en posiciones 
        for(int i = 0; i < posiciones.getRowCount(); i++) {
            // Si dto.indSimulacion == False 
            if(!dto.getIndSimulacion().booleanValue()) {
                // DAOPosicion.actualizaFaltanteReversion( posiciones(i).posicionrecuperacion) 
                posicionRecuperacion = new Long(posiciones.getValueAt(i, "POSICIONRECUPERACION").toString());
                daoPosicion.actualizaFaltanteReversion(posicionRecuperacion);
				UtilidadesLog.debug("despues de actualizaFaltanteReversion ");
            }

             daoPosicion.eliminarPosicion(new Long(posiciones.getValueAt(i, "OIDPOSICION").toString()));
        }

        // Se retorna un DTOEstatusSolicitud con estatus=ESTADO_SOLICITUD_VALIDADO 
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
		UtilidadesLog.debug("Contenido del DTOEstatusSolicitud::: " + dtoEstatusSolicitud.toString());
        UtilidadesLog.info("MONPEDValidacionBean.revertirRecuperacionObligatoriaVenta(DTOSolicitudValidacion dto, String codigoVenta): Salida ");
        return dtoEstatusSolicitud;
		
	}

  /*
  * @author Sergio Saavedra
  * fecha 23/12/04
  */  
  public DTOEstatusSolicitud reversionMensajesFaltantesAnunciados(DTOSolicitudValidacion dto) throws MareException  {
    UtilidadesLog.info("MONPEDValidacionBean.reversionMensajesFaltantesAnunciados(DTOSolicitudValidacion dto): Entrada ");
    DTOBuzonMensajes dtoB = new DTOBuzonMensajes();
    dtoB.setOidPais(dto.getOidPais());
    dtoB.setCodigoMensaje(ConstantesMSG.MENSAJE_PED04);
    dtoB.setOidCliente(dto.getOidCliente());
    dtoB.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
    dtoB.setDatoVariable1(new String(dto.getOidPeriodo().toString()));
    UtilidadesLog.debug("dtoB, cargado....: " + dtoB);
    
    DTOEstatusSolicitud dtoEstatuSolicitud = new DTOEstatusSolicitud();
    
    //IMSG imsg = null;
    try {
      MONGestionMensajesHome mensaje = getMONGestionMensajesHome();
      UtilidadesLog.debug("antes de eliminaMensajesFaltantesAnunciados...");
      mensaje.create().eliminaMensajesFaltantesAnunciados(dtoB);
      //imsg.eliminaMensajesFaltantesAnunciados(dtoB);
      UtilidadesLog.debug("luego de eliminaMensajesFaltantesAnunciados...");
    
      dtoEstatuSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
      UtilidadesLog.debug("solicitud validada.....");
      
    } catch(Exception e) {
        if(e instanceof MareException) {
            UtilidadesLog.error("Exception: ",(MareException) e);
            throw (MareException)e;
        } else {
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }
    UtilidadesLog.info("MONPEDValidacionBean.reversionMensajesFaltantesAnunciados(DTOSolicitudValidacion dto): Salida ");
    return dtoEstatuSolicitud;
  }

  public DTOEstatusSolicitud revertirAgregadosCV(DTOSolicitudReversion dto) throws MareException{
        UtilidadesLog.info("MONPEDValidacionBean.revertirAgregadosCV(DTOSolicitudReversion dto): Entrada ");
        try {
            UtilidadesLog.info("MONPEDValidacionBean.revertirAgregadosCV(DTOSolicitudReversion dto): Salida ");
            return this.getMONProcesoEnvioAgregadosSolicitudHome().create().revertirAgregados(dto);
        } catch(RemoteException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
  }


    /**
     * Genera los pedidos de servicio de recuperacion segun dtoProcesoCierre.
     * Obtiene solicitudes con lineas faltantes, pudiendo generarse mensajes.
     * Ademas puede que se actulicen posiciones con faltantes y se generan solicitudes por modulos externos.
     * @autor gdmarzi
     */
    public void generarPedidosServicioRecuperaciones(DTOFACProcesoCierre dtoProcesoCierre) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.generarPedidosServicioRecuperaciones(DTOFACProcesoCierre dtoProcesoCierre): Entrada ");
        DAOPED daoPED = new DAOPED(); 
        DAOSolicitud daoSolicitud = new DAOSolicitud();
        DTOTipoSolicitudProceso tipoSolicitud = new DTOTipoSolicitudProceso();
        DTOBuzonMensajes dtoMensaje = new DTOBuzonMensajes();
        DTOCabeceraSolicitud lineaFaltante = new DTOCabeceraSolicitud();
        DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();

        try {
            // Se recuperan las líneas faltantes de solicitudes no recuperadas en el proceso de facturación: 
            ArrayList lineasFaltantes = daoPED.obtenerLineasFaltantes(dtoProcesoCierre);
    
            // mientras( lineasFaltantes.tieneElementos ) 
            Iterator iterLineasFaltantes = lineasFaltantes.iterator();
            while (iterLineasFaltantes.hasNext()) {
                lineaFaltante = (DTOCabeceraSolicitud)iterLineasFaltantes.next();
                // Se obtiene el tipo de solicitud a generar 
                tipoSolicitud = daoPED.obtenerTipoSolicitud(lineaFaltante);
                // - si no se ha recuperado registro, se hace log del error, y se pasa a procesar el 
                // siguiente registro de lineasFaltantes 
                if (tipoSolicitud == null) {
                    // Informar "No se encontro el tipo se solicitud para el proceso PED215 para la solicitud: " + lineaFaltante.numeroSolicitud
                    String mensajeLog = " No se encontro el tipo se solicitud para el proceso PED215 para la solicitud: ";
                    mensajeLog = mensajeLog + lineaFaltante.getNumeroSolicitud();
                    BelcorpService.getInstance().log.info(mensajeLog);
               
                } else {
                    lineaFaltante.setOperacion(ConstantesBEL.PED215);
                    lineaFaltante.setTipoSolicitud(tipoSolicitud.getTipoSolicitud());
                    
                    //lineaFaltante.setNumeroDocumentoOrigen(new Long(lineaFaltante.getNumeroSolicitud()));
                    
                    lineaFaltante.setFecha(new Date(System.currentTimeMillis()));
                    
                    //jrivas 24/10/2005 Inc bloqueante FAC-01 V3.5
                    lineaFaltante.setFechaPrevistaFacturacion(new Timestamp(System.currentTimeMillis()));

                    lineaFaltante.setPeriodo(dtoProcesoCierre.getPeriodo());
                    lineaFaltante.setObservaciones(ConstantesPED.PED_090_OBSERV);
                    lineaFaltante.setOidIdioma(dtoProcesoCierre.getOidIdioma());
                    lineaFaltante.setOidPais(dtoProcesoCierre.getOidPais());
                    // mientras( lineaFaltante.posiciones.tieneElementos ) 
                    Iterator iterPosiciones = lineaFaltante.getPosiciones().iterator();
                    while (iterPosiciones.hasNext()) {
                        posicion = (DTOPosicionSolicitud)iterPosiciones.next(); 
                        posicion.setTipoPosicion(tipoSolicitud.getTipoPosicion());
                        posicion.setSubtipoPosicion(tipoSolicitud.getSubtipoPosicion());
                        if (posicion.getUnidadesComprometidas() == null) {
                            posicion.setUnidadesComprometidas(new Long(0));
                        }
                        if ( (posicion.getControlStock() != null ) && (posicion.getControlStock().booleanValue()) ) {
                            posicion.setUnidadesDemandadas(new Long(posicion.getUnidadesDemandadas().longValue() - posicion.getUnidadesComprometidas().longValue()));
                        } else {
                            posicion.setUnidadesDemandadas(new Long(posicion.getUnidadesPorAtender().longValue() - posicion.getUnidadesComprometidas().longValue()));
                        }
                        posicion.setUnidadesPorAtender(posicion.getUnidadesDemandadas());
                        posicion.setCodigoVenta(posicion.getCodigoVentaActual());
                    }     
                    // SCS modificado por inc.: BELC300022758
                        
                    if ( (lineaFaltante.getIndPedidoPrueba() != null) && ( ! lineaFaltante.getIndPedidoPrueba().booleanValue() ) ) {
                        // Se actualizan las posiciones 
                        UtilidadesLog.debug("lineaFaltante actualizando posicion: " + lineaFaltante);
                        // daoSolicitud.actualizarPosicionFaltante( cabecera, ConstantesPED.ESTADO_POSICION_RECUPERACION, false ) 
                        daoSolicitud.actualizarPosicionFaltante( lineaFaltante, ConstantesPED.ESTADO_POSICION_RECUPERACION, Boolean.FALSE);
                    }
                    
                    //Ahora que ya lo use, lo quito para que genere una nueva solicitud.
                    lineaFaltante.setOidCabeceraSolicitud(null);
                    
                    // Se invoca al CU "Generar Solicitud por Módulos Externos": 
                    UtilidadesLog.debug("vamos a Generar Solicitud por Módulos Externos");
                    //MONGenerarSolicitudModulosExternosHome monGenerarSolicitudModulosExternosHome = this.getMONGenerarSolicitudModulosExternosHome();
                    //DTOOID oidSolicitudGenerada = monGenerarSolicitudModulosExternosHome.create().generaSolicitud( lineaFaltante );
                    DTOOID oidSolicitudGenerada = getMONGenerarSolicitudModulosExternosLocalHome().create().generaSolicitud(lineaFaltante);
                     
                    Iterator iterPosiciones1 = lineaFaltante.getPosiciones().iterator();    
                    while (iterPosiciones1.hasNext()) {    
                        posicion = (DTOPosicionSolicitud)iterPosiciones1.next(); 
    
                        // Se genera un mensaje 
                        dtoMensaje.setCodigoMensaje(ConstantesPED.MENSAJE_PED03 );
                        dtoMensaje.setOidCliente(lineaFaltante.getOidCliente()); 
                        dtoMensaje.setModuloOrigen(ConstantesPED.MODULO_PEDIDOS);
                        dtoMensaje.setDatoVariable1(posicion.getCodigoVenta());
                        dtoMensaje.setDatoVariable2(posicion.getDescripcionProducto());
                        dtoMensaje.setDatoVariable3(posicion.getUnidadesDemandadas().toString());
                        dtoMensaje.setDatoVariable4(posicion.getUnidadesComprometidas().toString());
                        dtoMensaje.setDatoVariable5(lineaFaltante.getPeriodo().toString());  
                        dtoMensaje.setListaConsultoras(Boolean.FALSE.toString());
                        dtoMensaje.setCodigoPatron(null);
                        dtoMensaje.setOidIdioma(dtoProcesoCierre.getOidIdioma());
                        dtoMensaje.setOidPais(dtoProcesoCierre.getOidPais());
                        UtilidadesLog.debug(" antes create dtoMensaje:  " + dtoMensaje);
                        //  Se llama al método insertaDatosMensaje de la interface IMSG pasándole dtoB como parámetro de entrada.
                        dtoMensaje = this.getMONGestionMensajesLocalHome().create().insertaDatosMensajeBatch(dtoMensaje);
    
                        //Solo se inserta en "Solicitud Mensajes" si se pudo insertar el mensaje en el Buzón de Mensajes
                        /*  inicio pperez CAMBIO MSG-002  */
                        /* Se añade un registro en la entidad "Solicitud Mensajes": */
                        // Obtenemos el oid del mensaje a partir de su código: 
                        if (dtoMensaje.getOid() != null)  {
                            MensajesLocalHome mensajesLocalHome = new MensajesLocalHome();
                            MensajesLocal mensajesLocal = mensajesLocalHome.findByUk(lineaFaltante.getOidPais(), ConstantesPED.MENSAJE_PED03);
                            UtilidadesLog.debug("antes de create solicitudMensajes  dtoMensaje:  " + dtoMensaje);
                            SolicitudMensajesLocalHome solicitudMensajesHome = new SolicitudMensajesLocalHome();
                            try {
                                solicitudMensajesHome.create( oidSolicitudGenerada.getOid(),
                                                              mensajesLocal.getOid(),
                                                              dtoMensaje.getOid());                        
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                UtilidadesLog.debug("Error al insertar en SolicitudMensajes: ", pe);
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }                        
                        /*  fin pperez CAMBIO MSG-002  */
                    } // Fin lineasFaltantes.posiciones 

                } // Fin tipo de solicitud
    
            } // Fin lineas faltantes
         }  catch (NoResultException fe) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(fe);
              throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
         }  catch (PersistenceException ce) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", ce);
              throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch(Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",e);
            throw new MareException(e);
        }        
        UtilidadesLog.info("MONPEDValidacionBean.generarPedidosServicioRecuperaciones(DTOFACProcesoCierre dtoProcesoCierre): Salida ");
    } 
    
    
  /**
   * @author: ssantana, 27/9/2005
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOBuzonMensajes 
   * @param int i
   * @param DTOMovimientoAlmacenDetalle registro
   * @param RecordSet posiciones
   * @param RecordSet solicitud
   * @param RecordSet rDatosMensaje
   * @param RecordSet datosCliente
   * @param Long oidPaisSolicitud
   */
    private DTOBuzonMensajes armaDTOBuzonMensajes(Long oidPaisSolicitud, RecordSet datosCliente,
                                                  RecordSet rDatosMensaje, RecordSet solicitud,
                                                  RecordSet posiciones, DTOMovimientoAlmacenDetalle registro,
                                                  int i, boolean bTipoChequeoMensaje) 
                                                    throws MareException, Exception {
                                               
       UtilidadesLog.info("MONPEDValidacion.armaDTOBuzonMensajes()");   
       DTOBuzonMensajes dtoBuzonMensajes = new DTOBuzonMensajes();
       // --------- Pais ----------------
       dtoBuzonMensajes.setOidPais(oidPaisSolicitud);
       

       // --------- Cliente -------------
       //BigDecimal bigOidCliente = (BigDecimal) solicitud.getValueAt(0,3);
       Long oidCliente = null;
       if ( solicitud.getValueAt(0,3) != null ) {
          oidCliente = new Long( solicitud.getValueAt(0,3).toString() );
       }
       
       // -------- Modulo Origen ----------
       Long oidModuloOrigen = new Long(1);
       
       // -------- Variable 1 (Cliente)-------------
       String variable1 = datosCliente.getValueAt(0,0).toString();
       
       // -------- Variable 2 (Nombre 1 + 2) -------------
       String variable2 = null;
       String sNombreUno = null;
       String sNombreDos = null;
       if(datosCliente.getValueAt(0,4)!=null){
           sNombreUno = datosCliente.getValueAt(0,4).toString();
       }
       if(datosCliente.getValueAt(0,5)!=null) {
        sNombreDos = datosCliente.getValueAt(0,5).toString();
       }
       if (sNombreUno == null) {
         sNombreUno = "";
       }
       if (sNombreDos == null) {
         sNombreDos = "";
       }
       variable2 = sNombreUno + " " + sNombreDos;
       
       // -------- Variable 3 (Apellido 1 + 2) ------------
       String variable3 = null;
       String sApellidoUno = "";
       String sApellidoDos = "";
        if(datosCliente.getValueAt(0,6)!=null) {
         sApellidoUno = datosCliente.getValueAt(0,6).toString();
        }
        if(datosCliente.getValueAt(0,7)!=null) {
            sApellidoDos = datosCliente.getValueAt(0,7).toString();
        }

       variable3 = sApellidoUno + " " + sApellidoDos;
       
       // ------ Variable 4 (Solic. Referencia) -------------
       String variable4 = null;
       if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010     
         UtilidadesLog.debug("SOL REF "+rDatosMensaje.getValueAt(0,0));
       
       if ( rDatosMensaje.getValueAt(0,0) != null) {
         variable4 = rDatosMensaje.getValueAt(0,0).toString();
       }
       
       // ------ Variable 5 (Periodo Referencia) -------------
       String variable5 = null;
       
       if ( datosCliente.getValueAt(0,1) != null ) {
         variable5 = datosCliente.getValueAt(0,1).toString();
       }
       
       // ------ Variable 6 (Periodo) -----------------
       String variable6 = null;
       String Periodo = null;
       if ( datosCliente.getValueAt(0,3) != null ) {
         variable6 = datosCliente.getValueAt(0,3).toString();
         Periodo = datosCliente.getValueAt(0,3).toString();
       }
       
       // ------ Variable 7 (Nro Reclamo) --------------
       String variable7 = null;
       //BigDecimal bigNroReclamo = (BigDecimal) rDatosMensaje.getValueAt(0,1);
       if ( rDatosMensaje.getValueAt(0,1) != null ) {
         variable7 = rDatosMensaje.getValueAt(0,1).toString();
       }
       
       // ----- Variable 8 (COD. operacion) ------------
       String variable8 = null;
       
       if (rDatosMensaje.getValueAt(0,4) != null) {
         variable8 = rDatosMensaje.getValueAt(0,4).toString();
       }
       
       // ----- Variable 9 (Nombre Corto Operacion) --------
       String variable9 = null;
       if(rDatosMensaje.getValueAt(0,9)!=null){
            variable9 = rDatosMensaje.getValueAt(0,9).toString();
       }
           
       
       // ----- Variable 10 (Venta) ------------------------
       String variable10 = null;
       if(posiciones.getValueAt(i, 5)!=null){
            variable10 = posiciones.getValueAt(i, 5).toString();
       }
       
       
       // ----- Variable 11 (Descripcion) ------------------
       String variable11 = null;
       if(posiciones.getValueAt(i, 18)!=null){
        variable11 = posiciones.getValueAt(i, 18).toString();
       }
       
       // ----- Variable 12 (Unid. Reclamados) ------------*
       String variable12 = null;
       //BigDecimal bigUnidReclamadas = (BigDecimal) rDatosMensaje.getValueAt(0,3);
       if ( rDatosMensaje.getValueAt(0,3) != null) {
         variable12 = rDatosMensaje.getValueAt(0,3).toString();
       }
       
       // ----- Variable 13 (Cantidad) --------------
       String variable13 = registro.getCantidad().toString();
       //Long cantidad = registro.getCantidad();
       //variable13 = registro.getCantidad().toString(); // No deberia venir nulo.
       
       // ----- Variable 14 (Motivo Rechazo) -----------
       String variable14 = null;
       if(rDatosMensaje.getValueAt(0,5)!=null){
            variable14 = rDatosMensaje.getValueAt(0,5).toString();   
       }
        
       
       // ----- Variable 15 (Estado Operacion) ------------
       String variable15 = null;
       if(rDatosMensaje.getValueAt(0,6)!=null){
            variable15 = rDatosMensaje.getValueAt(0,6).toString();
       }
       
       // ----- Variable 16 (Unid. Atender - Cantidad)
       String variable16 = null;
       BigDecimal bigUnidadesAtender = null;
       if(posiciones.getValueAt(i,8)!=null){
        bigUnidadesAtender = new BigDecimal(posiciones.getValueAt(i,8).toString());
       }else{
        bigUnidadesAtender = new BigDecimal("0");
       }
       long calculo = bigUnidadesAtender.longValue() - registro.getCantidad().longValue();
       variable16 = String.valueOf(calculo);
       
       // ----- Lista Consultoras ---------------
       String listaConsultoras = "N";
       
       // ----- CodigoPatron --------------------
       String codigoPatron = null;
       
       // ----- Mensaje -------------------------
       
       String codigoMensaje = null;
       
       if ( bTipoChequeoMensaje ) {
          if ( bigUnidadesAtender.longValue() == registro.getCantidad().longValue()) {
             codigoMensaje = "REC02";
          } else {
             String sPrecioMensaje = rDatosMensaje.getValueAt(0,7).toString();
             if ( sPrecioMensaje.equals("P") ) {
               codigoMensaje = "REC06";
             }
             if ( sPrecioMensaje.equals("I")) {
               codigoMensaje = "REC07";
             }
          }
       } else {
            if(rDatosMensaje.getValueAt(0, 8)!=null){
                codigoMensaje = rDatosMensaje.getValueAt(0, 8).toString();      
            }
          
       }
       
       // ---- ARMO EL DTO ---------------------
       dtoBuzonMensajes.setOidCliente(oidCliente);
       dtoBuzonMensajes.setModuloOrigen(oidModuloOrigen);
       dtoBuzonMensajes.setDatoVariable1(variable1);
       dtoBuzonMensajes.setDatoVariable2(variable2);
       dtoBuzonMensajes.setDatoVariable3(variable3);
       dtoBuzonMensajes.setDatoVariable4(variable4);
       dtoBuzonMensajes.setDatoVariable5(variable5);
       dtoBuzonMensajes.setDatoVariable6(variable6);
       dtoBuzonMensajes.setDatoVariable7(variable7);
       dtoBuzonMensajes.setDatoVariable8(variable8);
       dtoBuzonMensajes.setDatoVariable9(variable9);
       dtoBuzonMensajes.setDatoVariable10(variable10);
       dtoBuzonMensajes.setDatoVariable11(variable11);
       dtoBuzonMensajes.setDatoVariable12(variable12);
       dtoBuzonMensajes.setDatoVariable13(variable13);
       dtoBuzonMensajes.setDatoVariable14(variable14);
       dtoBuzonMensajes.setDatoVariable15(variable15);
       dtoBuzonMensajes.setDatoVariable16(variable16);
       dtoBuzonMensajes.setListaConsultoras(listaConsultoras);
       dtoBuzonMensajes.setCodigoPatron(codigoPatron);
       dtoBuzonMensajes.setCodigoMensaje(codigoMensaje);
       
       if(log.isDebugEnabled()) //sapaza -- cambio Optimizacion Logs -- 23/03/2010                
         UtilidadesLog.debug("dtoBuzonMensajes: " + dtoBuzonMensajes);   
         
       return dtoBuzonMensajes;
      
    }
    
    
    private HashMap obtenerSaldosProducto(BigDecimal oidPais, BigDecimal oidAlmacen, ArrayList arrayProductos) throws MareException{
        UtilidadesLog.info("MONPEDValidacion.obtenerSaldosProducto (BigDecimal oidPais, BigDecimal oidAlmacen, ArrayList arrayProductos): Entrada ");
        HashMap hashSaldoProductos = new HashMap();
        StringBuffer query = new StringBuffer("");
        
        query.append(" SELECT BS.PROD_OID_PROD, ");
        query.append("        BS.VAL_SALD ");
        query.append(" FROM BEL_STOCK BS, ");
        query.append("      BEL_ESTAD_MERCA BEM ");
        query.append(" WHERE BS.ESME_OID_ESTA_MERC = BEM.OID_ESTA_MERC ");
        query.append("   AND BEM.COD_ESTA = 'LD' ");
        query.append("   AND BEM.PAIS_OID_PAIS = " + oidPais);
        query.append("   AND BS.ALMC_OID_ALMA = " + oidAlmacen);
        query.append("  AND (");
        int count = 0;
        String oidsProducto = "";
        Iterator it = arrayProductos.iterator();            
        while (it.hasNext()){
            BigDecimal oidProducto = new BigDecimal( it.next().toString());
            if (oidProducto != null){
                if (count == 0) {
                    oidsProducto = oidProducto.toString();
                } else { 
                    oidsProducto += "," + oidProducto.toString();
                }
            }                    
            if (count == 999)  {
                query.append(" BS.PROD_OID_PROD IN (" + oidsProducto.toString() + ") ");                     
                if (it.hasNext()){
                    query.append("  OR ");
                }                    
                count = 0;
                oidsProducto = "";             
            } else {
                if (!it.hasNext()){
                    query.append(" BS.PROD_OID_PROD IN (" + oidsProducto.toString() + ") ");        
                }                    
                count++;            
            } 
            
            if (!it.hasNext()){              
              query.append(")");
            }
        }
        RecordSet rs = null;
        rs = this.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()){
            for (int i =0; i<rs.getRowCount();i++){
                hashSaldoProductos.put(this.bigDecimalToLong(rs.getValueAt(i,"PROD_OID_PROD")),this.bigDecimalToLong(rs.getValueAt(i,"VAL_SALD")));
            }
        }
        
        UtilidadesLog.info("MONPEDValidacion.obtenerSaldosProducto (BigDecimal oidPais, BigDecimal oidAlmacen, ArrayList arrayProductos): Salida ");
        return hashSaldoProductos;
    }
    
   private RecordSet executeQuery(String query) throws MareException {
    UtilidadesLog.info("MONPEDValidacion.executeQuery(String query): Entrada");
    RecordSet rs = null;
    
    try {
      BelcorpService belcorpService = BelcorpService.getInstance();
      rs = belcorpService.dbService.executeStaticQuery( query );
    } catch ( Exception ex ) {
      throw new MareException( ex, 
          UtilidadesError.armarCodigoError(
            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
    }       
    UtilidadesLog.info("MONPEDValidacion.executeQuery(String query): Salida");  
    return rs;
  }
  
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long( numero.toString());
        } else {
            return null;
        }
    }
    
    private MONGenerarSolicitudModulosExternosLocalHome getMONGenerarSolicitudModulosExternosLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarSolicitudModulosExternos");
    }

    private MONGenerarPosicionSolicitudLocalHome getMONGenerarPosicionSolicitudLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGenerarPosicionSolicitudLocalHome)context.lookup("java:comp/env/ejb/local/MONGenerarPosicionSolicitud");
    }

    private MONCalcularDTOLocalHome getMONCalcularDTOLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONCalcularDTOLocalHome)context.lookup("java:comp/env/ejb/local/MONCalcularDTO");
    }
    
    //jrivas 21/9/2006 se agrega la reversion del acumulador de calctulosTotales.
    public DTOEstatusSolicitud revertirCalcularTotales(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.revertirCalcularTotales(DTOSolicitudValidacion dto): Entrada ");
        DAOSolicitud daosolicitud = new DAOSolicitud();
        daosolicitud.revertirAcumulador(dto);
        DTOEstatusSolicitud dtoestatussolicitud = new DTOEstatusSolicitud();
        dtoestatussolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        UtilidadesLog.info("MONPEDValidacionBean.revertirCalcularTotales(DTOSolicitudValidacion dto): Salida ");
 
        return dtoestatussolicitud;
    }

    private void actualizarUnidadesComprometidas (ArrayList arrayOidPosiciones) throws MareException{
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("UPDATE PED_SOLIC_POSIC SET NUM_UNID_COMPR = 0 WHERE OID_SOLI_POSI IN (");
        for (int i = 0; i < arrayOidPosiciones.size(); i++){
          if (i==0){
            buffer.append(arrayOidPosiciones.get(i));
          } else {
            buffer.append("," + arrayOidPosiciones.get(i));
          }          
        }
        buffer.append(");");
        try {
            BelcorpService belcorpService = BelcorpService.getInstance();
            belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", buffer.toString());
        } catch ( Exception ex ) {
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }          
    }

    private MONGestionMensajesLocalHome getMONGestionMensajesLocalHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONGestionMensajesLocalHome)context.lookup("java:comp/env/ejb/local/MONGestionMensajes");
    }

   private ArrayList recuperarProductosParaAgregar(Long oidPeriodo) throws MareException {
      UtilidadesLog.info("MONPEDValidacion.recuperarProductosParaAgregar(Long oidPeriodo): Entrada");
      ArrayList arrayProductos = new ArrayList();
      StringBuffer query = new StringBuffer();
      
      query.append("SELECT POD.VAL_CODI_VENT, ");
	    query.append("       POD.PROD_OID_PROD, ");
	    query.append("       POD.OID_DETA_OFER, ");
	    query.append("       POD.PRECIO_UNITARIO, ");
	    query.append("       POD.IMP_PREC_POSI, ");
      query.append("       POD.FOPA_OID_FORM_PAGO, ");
      query.append("       PQ_APL_AUX.Valor_Gen_I18n_Sicc(" + ConstantesSEG.IDIOMA_DEFECTO + ", POD.PROD_OID_PROD, 'MAE_PRODU') DESC_PROD ");
      query.append("FROM PRE_MATRI_FACTU_CABEC PMFC, ");
	    query.append("     PRE_OFERT PO, ");
	    query.append("     PRE_OFERT_DETAL POD, ");
      query.append("     PRE_ESTRA PE ");
      query.append("WHERE PMFC.PERD_OID_PERI = " + oidPeriodo);
      query.append("  AND PMFC.OID_CABE = PO.MFCA_OID_CABE ");
      query.append("  AND PO.COES_OID_ESTR = PE.OID_ESTR ");
      query.append("  AND PE.COD_ESTR = '"+ ConstantesPED.CODIGO_ESTRAT_INDIVIDUAL_MONTO_MINIMO +"' ");
      query.append("  AND PO.OID_OFER = POD.OFER_OID_OFER ");
      query.append("ORDER BY POD.PRECIO_UNITARIO ");  
      
      RecordSet rs;
      rs = this.executeQuery(query.toString());
      
      if (rs != null && !rs.esVacio()) {
        int longRS = rs.getRowCount();
        for (int i = 0; i < longRS; i++ ){
          DTOProductosMontoMinimo dtoProductosMontoMinimo = new DTOProductosMontoMinimo();
          if (rs.getValueAt(i,"VAL_CODI_VENT") != null) {
            dtoProductosMontoMinimo.setCodigoVenta(rs.getValueAt(i,"VAL_CODI_VENT").toString());
          }
          dtoProductosMontoMinimo.setOidProducto(this.bigDecimalToLong(rs.getValueAt(i,"PROD_OID_PROD")));
          dtoProductosMontoMinimo.setOidDetalleOferta(this.bigDecimalToLong(rs.getValueAt(i,"OID_DETA_OFER")));
          if (rs.getValueAt(i,"PRECIO_UNITARIO") != null) {
            dtoProductosMontoMinimo.setPrecioUnitario(new BigDecimal(rs.getValueAt(i,"PRECIO_UNITARIO").toString()));
          } else {
            dtoProductosMontoMinimo.setPrecioUnitario(new BigDecimal(0));
          }
          if (rs.getValueAt(i,"IMP_PREC_POSI") != null) {
            dtoProductosMontoMinimo.setImpPrecioPosi(new BigDecimal(rs.getValueAt(i,"IMP_PREC_POSI").toString()));
          } else {
            dtoProductosMontoMinimo.setImpPrecioPosi(new BigDecimal(0));
          }
          dtoProductosMontoMinimo.setOidFormaPago(this.bigDecimalToLong(rs.getValueAt(i,"FOPA_OID_FORM_PAGO")));
          if (rs.getValueAt(i,"DESC_PROD") != null) {
            dtoProductosMontoMinimo.setDescripcionProducto(rs.getValueAt(i,"DESC_PROD").toString());
          }          
          arrayProductos.add(dtoProductosMontoMinimo);          
        }
      }
      UtilidadesLog.info("MONPEDValidacion.recuperarProductosParaAgregar(Long oidPeriodo): Salida");
      return arrayProductos;
   }
   
   private StringBuffer generarCadenaInsercionPosiciones(DTOSolicitudValidacion dtoin, DTOProductosMontoMinimo dtoProductosMontoMinimo) {
      UtilidadesLog.info("MONPEDValidacion.generarCadenaInsercionPosiciones(DTOSolicitudValidacion dtoin, DTOProductosMontoMinimo dtoProductosMontoMinimo): Entrada");
      StringBuffer cadena = new StringBuffer();
      
      cadena.append(" INSERT INTO PED_SOLIC_POSIC ( ");
      cadena.append(" OID_SOLI_POSI, ");
      cadena.append(" COD_POSI, ");
      cadena.append(" VAL_LOTE_PROD, ");
      cadena.append(" NUM_UNID_DEMA, ");
      cadena.append(" NUM_UNID_POR_ATEN, ");      
      cadena.append(" VAL_TASA_IMPU, ");
      cadena.append(" SOCA_OID_SOLI_CABE, ");
      cadena.append(" TAIM_OID_TASA_IMPU, ");
      cadena.append(" TPOS_OID_TIPO_POSI, ");
      cadena.append(" PROD_OID_PROD, ");
      cadena.append(" FOPA_OID_FORM_PAGO, ");
      cadena.append(" IND_LIMI_VENT, ");
      cadena.append(" IND_CTRL_STOC, ");
      cadena.append(" IND_CTRL_LIQU, ");
      cadena.append(" VAL_PREC_CATA_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_CONT_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_CATA_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_CONTA_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_FACT_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_FACT_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_SIN_IMPU_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_SIN_IMPU_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_SIN_IMPU_TOTA_DOCU, ");
      cadena.append(" VAL_IMPO_DESC_UNIT_LOCA, ");
      cadena.append(" VAL_IMPO_DESC_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_NETO_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_NETO_TOTA_DOCU, ");
      cadena.append(" VAL_PREC_NETO_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_TOTA_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_TOTA_TOTA_DOCU, ");
      cadena.append(" VAL_IMPO_IMPU_UNIT_LOCA, ");
      cadena.append(" VAL_IMPO_IMPU_UNIT_DOCU, ");
      cadena.append(" VAL_IMPO_DESC_TOTA_DOCU, ");
      cadena.append(" VAL_IMPO_IMPU_TOTA_LOCA, ");
      cadena.append(" VAL_IMPO_IMPU_TOTA_DOCU, ");
      cadena.append(" VAL_IMPO_DESC_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_TOTA_UNIT_LOCA, ");
      cadena.append(" VAL_PREC_TOTA_UNIT_DOCU, ");
      cadena.append(" VAL_PREC_CONT_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_CATA_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_CATA_TOTA_DOCU, ");
      cadena.append(" VAL_PREC_CONT_TOTA_DOCU, ");
      cadena.append(" VAL_PORC_DESC, ");
      cadena.append(" VAL_PREC_CATA_TOTA_LOCA_UNID, ");
      cadena.append(" NUM_UNID_DEMA_REAL, ");
      cadena.append(" NUM_UNID_COMPR, ");
      cadena.append(" NUM_UNID_CAMB, ");
      cadena.append(" NUM_UNID_VENT, ");
      cadena.append(" NUM_UNID_ATEN, ");
      cadena.append(" VAL_CODI_VENT_FICT, ");
      cadena.append(" VAL_PREC_FACT_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_FACT_TOTA_DOCU, ");
      cadena.append(" VAL_PREC_SIN_IMPU_TOTA_LOCA, ");
      cadena.append(" VAL_PREC_NETO_TOTA_LOCA, ");
      cadena.append(" OFDE_OID_DETA_OFER , ");
      cadena.append(" ESPO_OID_ESTA_POSI , ");
      cadena.append(" STPO_OID_SUBT_POSI , ");
      cadena.append(" IND_RECU_OBLI, ");
      cadena.append(" VAL_CODI_VENT, ");
      cadena.append(" SOPO_OID_SOLI_POSI , ");
      cadena.append(" IND_NO_IMPR , ");
      cadena.append(" IND_DENT_FUER_CAJA_BOLS  , ");
      cadena.append(" VAL_CATA  , ");
      cadena.append(" NUM_PAGI_CATA  , ");
      cadena.append(" NUM_CONS  , ");
      cadena.append(" NUM_DOCU_CONT_INTE  , ");
      cadena.append(" VAL_EJER_DOCU_CONT_INTE  , ");
      cadena.append(" VAL_IMPO_DES_SIN_IMP_UNIT_LOCA  , ");
      cadena.append(" VAL_IMPO_DES_SIN_IMP_UNIT_DOCU  , ");
      cadena.append(" VAL_IMPO_DES_SIN_IMP_TOTA  , ");
      cadena.append(" VAL_IMPO_DES_SIN_IMP_TOTA_DOCU  , ");
      cadena.append(" VAL_OBSE ");
      cadena.append(" ) VALUES ( ");
      cadena.append("PED_SOPO_SEQ.NEXTVAL,");
      cadena.append("(SELECT NVL((MAX(COD_POSI))+1,0) FROM PED_SOLIC_POSIC P WHERE P.SOCA_OID_SOLI_CABE = " + dtoin.getOidSolicitud() + " ),");
      cadena.append(" NULL, ");
      cadena.append(" 0, ");
      cadena.append(" 1, ");
      cadena.append(" 0, "); // Igual que que las otras posiciones //NO: (SELECT VAL_TASA_IMPU FROM PED_TASA_IMPUE WHERE VAL_INDI_IMPU = 'IGV' AND PAIS_OID_PAIS = " + dtoin.getOidPais() + ")
      cadena.append(dtoin.getOidSolicitud() + ", ");
      cadena.append(" NULL, "); // Igual que que las otras posiciones  //NO: (SELECT OID_TASA_IMPU FROM PED_TASA_IMPUE WHERE VAL_INDI_IMPU = 'IGV' AND PAIS_OID_PAIS = " + dtoin.getOidPais() + ")
      // Aca va el Codigo de Tipo de Posicion de Monto Minimo - Cambio Sicc20070217
      cadena.append("(SELECT OID_TIPO_POSI FROM PED_TIPO_POSIC WHERE COD_TIPO_POSI = '"+ ConstantesPED.CODIGO_TIPO_POSICION_MONTO_MINIMO +"'), ");
      cadena.append(dtoProductosMontoMinimo.getOidProducto() + ", ");
      cadena.append(dtoProductosMontoMinimo.getOidFormaPago() + ", ");
      cadena.append(" NULL, ");
      cadena.append(" NULL, ");
      cadena.append(" NULL, ");
      cadena.append(dtoProductosMontoMinimo.getPrecioUnitario() + ", ");
      if (dtoProductosMontoMinimo.getPrecioUnitario()!=null && dtoProductosMontoMinimo.getPrecioUnitario().intValue()!=0) {
        cadena.append("0, ");
      }
      else  {
        cadena.append(dtoProductosMontoMinimo.getImpPrecioPosi() + ", ");
      }
      cadena.append(dtoProductosMontoMinimo.getPrecioUnitario() + ", ");
      if (dtoProductosMontoMinimo.getPrecioUnitario()!=null && dtoProductosMontoMinimo.getPrecioUnitario().intValue()!=0) {
        cadena.append("0, ");
      }
      else  {
        cadena.append(dtoProductosMontoMinimo.getImpPrecioPosi() + ", ");
      }
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("1, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("NULL, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append(dtoProductosMontoMinimo.getOidDetalleOferta() + ", ");
      cadena.append( ConstantesPED.ESTADO_POSICION_CORRECTO + ", ");
      // Aca primero va el Codigo de Subtipo de Posicion y Despues el Codigo de Tipo de Posicion - Cambio Sicc20070217
      cadena.append("(SELECT OID_SUBT_POSI FROM PED_SUBTI_POSIC WHERE COD_SUBT_POSI = '"+ ConstantesPED.CODIGO_SUBTIPO_POSICION_MONTO_MINIMO +"' AND TPOS_OID_TIPO_POSI = (SELECT OID_TIPO_POSI FROM PED_TIPO_POSIC WHERE COD_TIPO_POSI = '"+ ConstantesPED.CODIGO_TIPO_POSICION_MONTO_MINIMO +"')), ");
      cadena.append("0, ");
      cadena.append("'"+dtoProductosMontoMinimo.getCodigoVenta() + "', ");
      cadena.append("NULL , ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("NULL, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("0, ");
      cadena.append("NULL");
      cadena.append("); ");
      
      UtilidadesLog.info("MONPEDValidacion.generarCadenaInsercionPosiciones(DTOSolicitudValidacion dtoin, DTOProductosMontoMinimo dtoProductosMontoMinimo): Salida");
      return cadena;
   }
   
     private void insertarPosicionesYMensajes(StringBuffer cadenaInserciones) throws MareException {
       UtilidadesLog.info("MONPEDValidacion.insertarPosiciones(StringBuffer cadenaInserciones): Entrada");   
       try {
         BelcorpService belcorpService = BelcorpService.getInstance();
         belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", cadenaInserciones.toString());
       } catch ( Exception ex ) {
         throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
       }          
       UtilidadesLog.info("MONPEDValidacion.insertarPosiciones(StringBuffer cadenaInserciones): Salida");   
     }


   private DTOEstatusSolicitud rechazarSolicitud () {
     UtilidadesLog.info("MONPEDValidacion.rechazarSolicitud(): Entrada");   
     DTOEstatusSolicitud dtos = new DTOEstatusSolicitud();
     dtos.setEstatus(ConstantesPED.ESTADO_SOLICITUD_RECHAZADO);
     UtilidadesLog.debug("Case 2, rechazo y retorno....");
     UtilidadesLog.info("MONPEDValidacion.rechazarSolicitud(): Salida");   
     return dtos;
   }
   
   private StringBuffer generarCadenaInsercionMensajes(DTOSolicitudValidacion dtoin, Long oidMensaje, DTOBuzonMensajes[] dtoMensajes) throws MareException{
      UtilidadesLog.info("MONPEDValidacion.generarCadenaInsercionMensajes(DTOSolicitudValidacion dtoin, Long oidMensaje, DTOBuzonMensajes[] dtoMensajes): Entrada");
      StringBuffer cadena = new StringBuffer();

      int longMensajes = dtoMensajes.length;
      for (int i = 0; i < longMensajes ; i++) {
        cadena.append("INSERT INTO PED_SOLIC_MENSA (");
        cadena.append("OID_SOLI_MENS, ");
        cadena.append("SOCA_OID_SOLI_CABE, ");
        cadena.append("MENS_OID_MENS, ");       
        cadena.append("VAL_BUZO_MENS 	");
        cadena.append(") VALUES (");
        cadena.append("PED_SOME_SEQ.NEXTVAL, ");
        cadena.append(dtoin.getOidSolicitud() + ", ");
        cadena.append(oidMensaje + ", ");
        cadena.append(dtoMensajes[i].getOid());
        cadena.append(");");
      }
      UtilidadesLog.info("MONPEDValidacion.generarCadenaInsercionMensajes(DTOSolicitudValidacion dtoin, Long oidMensaje, DTOBuzonMensajes[] dtoMensajes): Salida");
      return cadena;
   }
   
    private String ajustarVariable(String dato) {
        String retorno = "''";
        if (dato != null && dato.length() > 100 ) {
            retorno = retorno.replaceAll("'","''");
            retorno = "'" + dato.substring(0, 100) + "'";
        } else if (dato!=null){
            retorno = retorno.replaceAll("'","''");
            retorno = "'"+dato+"'";
        }
        return retorno;
    }
    
   private Long recuperarOidMensaje(Long oidPais) throws MareException {
    UtilidadesLog.debug("MONPEDValidacion.recuperarOidMensaje(Long oidPais): Entrada");
    Long oidMensaje = null;
    StringBuffer query = new StringBuffer();
    
    query.append("SELECT OID_MENS ");
	  query.append("FROM MSG_MENSA MM ");
	  query.append("WHERE MM.PAIS_OID_PAIS = " + oidPais);
	  query.append("  AND MM.COD_MENS = '"+ ConstantesPED.MENSAJE_PED09 +"' ");
    
    RecordSet rs = null;
    
    rs = this.executeQuery(query.toString());

    if (rs != null && !rs.esVacio()) {
      oidMensaje = this.bigDecimalToLong(rs.getValueAt(0, "OID_MENS"));
    }
    
    UtilidadesLog.debug("MONPEDValidacion.recuperarOidMensaje(Long oidPais): Salida");
    return oidMensaje;
   } 
   
    private StringBuffer generarUpdateCabecera(DTOSolicitudValidacion dtoin, BigDecimal montoSolicitud) {
      UtilidadesLog.debug("MONPEDValidacion.generarUpdateCabecera(DTOSolicitudValidacion dtoin, Integer montoSolicitud): Entrada");
      StringBuffer query = new StringBuffer();
      query.append("UPDATE PED_SOLIC_CABEC SET VAL_TOTA_PAGA_LOCA = "+ montoSolicitud +", ");
      query.append(" VAL_PREC_CATA_TOTA_LOCA = "+ montoSolicitud +", ");
      query.append(" VAL_PREC_CATA_TOTA_LOC_UNI_DEM = "+ montoSolicitud +" ");
      query.append(" WHERE OID_SOLI_CABE = " + dtoin.getOidSolicitud() + ";");
      UtilidadesLog.debug("MONPEDValidacion.generarUpdateCabecera(DTOSolicitudValidacion dtoin, Integer montoSolicitud): Salida");
      return query;
    }

    protected void enviarMensajesMontoMinimo(DTOBuzonMensajes[] dtoin) throws MareException {
        UtilidadesLog.debug("MONPEDValidacionBean.enviarMensajesMontoMinimo(DTOBuzonMensajes[] dtoin): Entrada ");

        try {
            this.getMONGestionMensajesLocalHome().create().insertarDatosMensajesBatch(dtoin);
        } catch(Exception ce) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } 
        UtilidadesLog.debug("MONPEDValidacionBean.enviarMensajesMontoMinimo(DTOBuzonMensajes[] dtoin): Salida ");
    }

    private StringBuffer generarUpdateCabeceraAcum2(DTOSolicitudValidacion dtoin, BigDecimal montoSolicitud) {
      UtilidadesLog.debug("MONPEDValidacion.generarUpdateCabeceraAcum2(DTOSolicitudValidacion dtoin, Integer montoSolicitud): Entrada");
      StringBuffer query = new StringBuffer();
      query.append(" UPDATE PED_SOLIC_CABEC_ACUM2 SET VAL_MONT_TOTA = "+ montoSolicitud +" ");
      query.append(" WHERE CLIE_OID_CLIE = " + dtoin.getOidCliente());
      query.append(" AND PERD_OID_PERI = " + dtoin.getOidPeriodo() + ";");
      UtilidadesLog.debug("MONPEDValidacion.generarUpdateCabeceraAcum2(DTOSolicitudValidacion dtoin, Integer montoSolicitud): Salida");
      return query;
    }
    
    private DTOBuzonMensajes armaBuzonMensajeProdMontoMinimo(Long oidMensaje, DTOSolicitudValidacion dtoin, DTOProductosMontoMinimo dtoProductosMontoMinimo) throws MareException  {
        DTOBuzonMensajes dtoBuzonTemporal = new DTOBuzonMensajes();
        dtoBuzonTemporal.setOidPais(dtoin.getOidPais());
        dtoBuzonTemporal.setOidMensaje(oidMensaje);
        dtoBuzonTemporal.setCodigoMensaje( ConstantesPED.MENSAJE_PED09 );
        dtoBuzonTemporal.setOidCliente(dtoin.getOidCliente());
        dtoBuzonTemporal.setModuloOrigen(new Long(ConstantesSEG.MODULO_PED));
        dtoBuzonTemporal.setDatoVariable1(dtoProductosMontoMinimo.getCodigoVenta());
        dtoBuzonTemporal.setDatoVariable2(dtoProductosMontoMinimo.getDescripcionProducto());
        dtoBuzonTemporal.setDatoVariable3("1");
        dtoBuzonTemporal.setDatoVariable4(dtoProductosMontoMinimo.getPrecioUnitario().toString());
        dtoBuzonTemporal.setListaConsultoras(ConstantesMSG.NO);
        return dtoBuzonTemporal;
    }

   /**5.3.25	Caso de uso Desbloqueo automático monto mínimo
   * PED-148, SCS (09/10/2007)
   * */
    public void desbloquearMM(Long oidPais, Long oidMarca) throws MareException
    {
        UtilidadesLog.info("MONCierreFacturacionBean.desbloquearMM(long periodo): Entrada");
        
        String user = ctx.getCallerPrincipal().getName();
        DAOPED daoped = new DAOPED(user);
        DTOPEDBloqueosClientes daoPBC = new DTOPEDBloqueosClientes();
        //String indEjMM = daoped.buscoIndMM(oidPais.longValue());
        daoPBC = daoped.recuperarDatosBloqueos(oidPais);
        Integer nivelGrav = null;
        
        if (!(daoPBC==null)) {
            if (!(daoPBC.getIndicadorEjecMM()==null)){
                nivelGrav = daoPBC.getNivelGravedadBloqueo();
                if (!(nivelGrav==null)) {
                    //3. Buscar clientes bloqueados por Monto mínimo.
                    //Si Variable-Nivel-Gravedad-Bloqueo-MM > 0 (recuperada en actividad anterior)
                    if (nivelGrav.longValue()>0){    
                        this.generarUpdateClienBloq(daoped.desblCltes(oidPais.longValue(), oidMarca.longValue()));
                    }
                }else{
                    UtilidadesLog.info("fin c.u.");    
                }
            }else{
                UtilidadesLog.info("fin c.u.");    
            }
        }
        UtilidadesLog.info("MONCierreFacturacionBean.desbloquearMM(long periodo): Salida");
    }
    
   private void generarUpdateClienBloq(StringBuffer cadenaUpdate) throws MareException {
     UtilidadesLog.info("MONPEDValidacion.generarUpdateClienBloqu(StringBuffer cadenaUpdate): Entrada");   
     try {
       BelcorpService belcorpService = BelcorpService.getInstance();
       belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR", cadenaUpdate.toString());
     } catch ( Exception ex ) {
       throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
     }          
     UtilidadesLog.info("MONPEDValidacion.generarUpdateClienBloqu(StringBuffer cadenaUpdate): Salida");   
   }

    /* Agregado por Brecha COL-BLO-001 ------ AL */
    public void bloquearCliente(DTOSolicitudValidacion dtoin) throws MareException {
      UtilidadesLog.info("MONPEDValidacionBean.bloquearCliente(DTOSolicitudValidacion dtoin): Entrada ");
      String user = ctx.getCallerPrincipal().getName();
      DAOPED daoPed = new DAOPED(user);
      DTOPEDBloqueosClientes dtoBloqueos = daoPed.recuperarDatosBloqueos(dtoin.getOidPais());
      
      if (dtoBloqueos.getIndicadorEjecMM().booleanValue()) {
         daoPed.realizarBloqueos(dtoin.getOidCliente(), dtoBloqueos.getNivelGravedadBloqueo());             
      }       
      UtilidadesLog.info("MONPEDValidacionBean.bloquearCliente(DTOSolicitudValidacion dtoin): Salida ");
    }

    private MONPEDValidacionLocalHome getMONPEDValidacionLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPEDValidacionLocalHome)context.lookup("java:comp/env/ejb/local/MONPEDValidacion");
    }

    /* Agregado por Brecha COL-BLO-001 ------ AL */
    
    //jrivas 2007437 
    public DTOEstatusSolicitud actualizarPeriodoPrimerContacto(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacion.actualizarPeriodoPrimerContacto(StringBuffer cadenaUpdate): Entrada");   
        
        StringBuffer query = new StringBuffer();
        
        query.append(" SELECT COUNT(CDA.ESTA_OID_ESTA_CLIE) ESTATUS ");
        query.append("   FROM MAE_CLIEN_DATOS_ADICI CDA, MAE_ESTAT_CLIEN EC ");
        query.append("  WHERE CDA.CLIE_OID_CLIE = " + dto.getOidCliente());
        query.append("    AND CDA.ESTA_OID_ESTA_CLIE = EC.OID_ESTA_CLIE ");
        query.append("    AND EC.COD_ESTA_CLIE IN ('" + ConstantesMAE.ESTATUS_REGISTRADO + "', ");
        query.append("        '" + ConstantesMAE.ESTATUS_RETIRADO + "') ");
        
        RecordSet rs = null;
        rs = this.executeQuery(query.toString());
		//doliva -- cambio Optimizacion Logs -- 09/04/2010
		if(log.isDebugEnabled())
			UtilidadesLog.debug("actualizarPeriodoPrimerContacto Rs " + rs);
        
        if (!rs.getValueAt(0, "ESTATUS").toString().equals("0")) {
            //Es Registrada o Retirada
            
            UtilidadesLog.debug("getIndOrdenCompra " + dto.getIndOrdenCompra());
            UtilidadesLog.debug("getIndSimulacion " + dto.getIndSimulacion());
            UtilidadesLog.debug("getIndDevoAnul " + dto.getIndDevoAnul());
            UtilidadesLog.debug("getIndNoConso " + dto.getIndNoConso());
            UtilidadesLog.debug("getOidModulo " + dto.getOidModulo());
            
            if (dto.getIndOrdenCompra().booleanValue() &&
                !dto.getIndSimulacion().booleanValue() &&
                !dto.getIndDevoAnul().booleanValue() &&
                (dto.getIndNoConso() != null && dto.getIndNoConso().equals(new Long(1))) &&
                (dto.getOidModulo() == null || !dto.getOidModulo().equals(ConstantesPED.MODULO_RECLAMOS))) {
                    
                    //Hay que procesarlo.
                    //Le agrego 1 año a la fecha.
                    GregorianCalendar gC = new GregorianCalendar();
                    gC.setTime(dto.getFechaProceso());
                    gC.add(Calendar.YEAR, 1);

                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");        
                    
                    query = new StringBuffer();
                    query.append(" UPDATE MAE_CLIEN_PRIME_CONTA ");
                    query.append(" SET PERD_OID_PERI = " + dto.getOidPeriodo());
                    query.append(" , FEC_CONT = TO_DATE('"+df.format(dto.getFechaProceso())+"', 'dd/MM/yyyy') ");
                    query.append(" , FEC_SIGU_CONT = TO_DATE('"+df.format(gC.getTime())+"', 'dd/MM/yyyy') ");
                    query.append(" WHERE CLIE_OID_CLIE = " + dto.getOidCliente());
                    
                    try {
                      BelcorpService belcorpService = BelcorpService.getInstance();
                      int aux = belcorpService.dbService.executeUpdate( query.toString() );
                      UtilidadesLog.debug("actualizarPeriodoPrimerContacto aux " + aux);
                    } catch ( Exception ex ) {
                      throw new MareException( ex, 
                          UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS ));
                    }                     
                    
            }
        } 
        
        UtilidadesLog.info("MONPEDValidacion.actualizarPeriodoPrimerContacto(StringBuffer cadenaUpdate): Salida");           
        
        DTOEstatusSolicitud dtoestatussolicitud = new DTOEstatusSolicitud();
        dtoestatussolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        return dtoestatussolicitud;
    } 
    
    private BolsaFantantesLocalHome getBolsaFantantesLocalHome() {
            return new BolsaFantantesLocalHome();
    }

    // sapaza -- PER-SiCC-2011-0214 -- 11/04/2011
    public DTOEstatusSolicitud validarDescuento2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarDescuento2(DTOSolicitudValidacion dto): Entrada ");

        try{
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PED_PKG_CUADR_OFERT.PED_PR_CALCU_DESC", dto.getOidSolicitud().toString());
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.validarDescuento2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2011-0214 -- 11/04/2011
    public DTOEstatusSolicitud validarCuadreOfertas2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas2(DTOSolicitudValidacion dto): Entrada ");

        try{
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PED_PKG_CUADR_OFERT.PED_PR_CUADR_OFERT", dto.getOidSolicitud().toString());
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2012-0130 -- 20/02/2011
    public DTOEstatusSolicitud recuperacionObligatoria2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoria2(DTOSolicitudValidacion dto): Entrada ");

        try{
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PED_PKG_CUADR_OFERT.PED_PR_RECUP_OBLIG", dto.getOidSolicitud().toString());
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.recuperacionObligatoria2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
    public DTOEstatusSolicitud calcularMontoMaximo2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMaximo2(DTOSolicitudValidacion dto): Entrada ");

        try {
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(ctx.getCallerPrincipal().getName());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_monto_maxim", params);
            
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMaximo2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
    public DTOEstatusSolicitud calcularMontoMinimo2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMinimo2(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(ctx.getCallerPrincipal().getName());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_monto_minim", params);
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMinimo2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2012-0919 -- 17/10/2012
    public DTOEstatusSolicitud insertarOfertasEspeciales(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.insertarOfertasEspeciales(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_ofert_espec", params);
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.insertarOfertasEspeciales(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2013-0076 -- 06/02/2013
    public DTOEstatusSolicitud validarAgregados2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarAgregados2(DTOSolicitudValidacion dto): Entrada ");

        try{
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("MAV_PKG_PROCE.MAV_PR_VALID_AGREG", dto.getOidSolicitud().toString());
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.validarAgregados2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;

    }

    // sapaza -- PER-SiCC-2013-0123 -- 12/02/2013
    public DTOEstatusSolicitud calcularMontoMinimoIncentivos(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMinimoIncentivos(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(ctx.getCallerPrincipal().getName());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_monto_minim_incen", params);
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.calcularMontoMinimoIncentivos(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2013-0123 -- 12/02/2013
    public DTOEstatusSolicitud insertarOfertasEspeciales2(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.insertarOfertasEspeciales2(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_ofert_espec2", params);
        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.insertarOfertasEspeciales2(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2014-0564 -- 15/09/2014
    public DTOEstatusSolicitud validarCuadreOfertas3(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas3(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_cuadr_revis", params);

        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas3(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2014-0750 -- 09/10/2014
    public DTOEstatusSolicitud validarCuadreOfertas4(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas4(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_cuadr_nx", params);

        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.validarCuadreOfertas4(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2015-0228 -- 05/05/2015
    public DTOEstatusSolicitud eliminarProductosFaltantesProlIndividual(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.eliminarProductosFaltantesProlIndividual(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_elim_falt_prol_indi", params);

        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.eliminarProductosFaltantesProlIndividual(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- PER-SiCC-2015-0228 -- 05/05/2015
    public DTOEstatusSolicitud eliminarProductosFaltantesProlCompuesta(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.eliminarProductosFaltantesProlCompuesta(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.ped_pr_elim_falt_prol_cfija", params);

        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.eliminarProductosFaltantesProlCompuesta(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }

    // sapaza -- GR-851 -- 01/04/2016
    public DTOEstatusSolicitud evaluarExigenciasVentas(DTOSolicitudValidacion dto) throws MareException {
        UtilidadesLog.info("MONPEDValidacionBean.evaluarExigenciasVentas(DTOSolicitudValidacion dto): Entrada ");

        try{
            ArrayList params = new ArrayList();
            params.add(dto.getOidSolicitud().toString());
            params.add(dto.getOidPais().toString());
            params.add(dto.getOidPeriodo().toString());
            
            DBService db = BelcorpService.getInstance().dbService;
            db.executeProcedure("PQ_PLANI.nvs_pr_evalu_exige_nueva", params);

        }catch (Exception e){
            UtilidadesLog.error("Error al ejecutar el procedure",e);
            throw new MareException (e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        // retornando un DTOEstatusSolicitud con estatus = ESTADO_SOLICITUD_VALIDADO
        DTOEstatusSolicitud dtoEstatusSolicitud = new DTOEstatusSolicitud();
        dtoEstatusSolicitud.setEstatus(ConstantesPED.ESTADO_SOLICITUD_VALIDADO);
        
        UtilidadesLog.info("MONPEDValidacionBean.evaluarExigenciasVentas(DTOSolicitudValidacion dto): Salida ");
        return dtoEstatusSolicitud;
    }
    
}
