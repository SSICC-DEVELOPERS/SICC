package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.mav.DTOGenerarPagoIntercompanias;
import es.indra.sicc.dtos.mav.DTOInformeGeneracion;
import es.indra.sicc.dtos.ped.DTOCabeceraSolicitud;
import es.indra.sicc.dtos.ped.DTOPosicionSolicitud;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.mav.ActividadesMAVLocal;
import es.indra.sicc.entidades.mav.ActividadesMAVLocalHome;
import es.indra.sicc.entidades.mav.PeriodosRefenciaPagoLocalHome;
import es.indra.sicc.entidades.mav.ResumenPagoIntercompaniasLocal;
import es.indra.sicc.entidades.mav.ResumenPagoIntercompaniasLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudLocalHome;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudPaisLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONPeriodos;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternos;
import es.indra.sicc.logicanegocio.ped.MONGenerarSolicitudModulosExternosHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONGenerarPagoIntercompaniasBean implements SessionBean {
    private SessionContext ctx = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public void generarPagoIntercompanias(DTOGenerarPagoIntercompanias dto)
        throws MareException {
        
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarPagoIntercompanias(DTOGenerarPagoIntercompanias dto):Entrada");
        DAOGenerarPagoIntercompanias daogpi = new DAOGenerarPagoIntercompanias();
        RecordSet solicitudesEnvioMAV = daogpi.obtenerSolicitudesEnvioMAV(dto);

        if (!solicitudesEnvioMAV.esVacio()) {
            DTOInformeGeneracion informeGeneracion = this.generarSolicitud(dto, solicitudesEnvioMAV);
            Long resumenPagoIntercompanias = null;

            try {
               resumenPagoIntercompanias = this.genererResumenPagoIntercompanias(dto, informeGeneracion);
            } catch(Exception e) {
               UtilidadesLog.error(e);
               throw new MareException(e, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAV + ErroresNegocio.MAV_0010));
            }
            this.generarPeriodosRefenciaPago(dto, resumenPagoIntercompanias);
        }		
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarPagoIntercompanias(DTOGenerarPagoIntercompanias dto):Salida");
    }

    private DTOInformeGeneracion generarSolicitud(DTOGenerarPagoIntercompanias dto, RecordSet solicitudesEnvioMAV)
        throws MareException {
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarSolicitud(DTOGenerarPagoIntercompanias dto, RecordSet solicitudesEnvioMAV):Entrada");
        try {
            UtilidadesLog.debug("solicitudesEnvioMAV: " + solicitudesEnvioMAV);
            ActividadesMAVLocalHome actHome = new ActividadesMAVLocalHome();
            ActividadesMAVLocal actividadesMav = actHome.findByPrimaryKey(dto.getActividad());
            DAOGenerarPagoIntercompanias datoGenerarPago = 
                                            new DAOGenerarPagoIntercompanias();
            Long tipoDocumento = null;
            Long oidCliente = null;
            Long subtipoClientePPal = null;
            Long tipoClientePPal = null;
            Long oidDireccionPPal = null;
            Long[] arrayTipoSubtipoClientePPal = null;
            
            java.util.Date dateHoy = new java.util.Date(System.currentTimeMillis());
            

            DTOCabeceraSolicitud cabeceraSolicitud = new DTOCabeceraSolicitud();
            
            /* Modificacion por ssantana, 12/05/2006, inc. 23074 */
            oidCliente = actividadesMav.getOidClienteDatosBasicos();
            String sCodigoCliente = null;
            ClienteDatosBasicosLocalHome clienteDatosBasicoLH = 
                            new ClienteDatosBasicosLocalHome();            
            ClienteDatosBasicosLocal clienteDatosBasicosL = 
                            clienteDatosBasicoLH.findByPrimaryKey(oidCliente);
            sCodigoCliente = clienteDatosBasicosL.getCod_clie();
            cabeceraSolicitud.setOidCliente(oidCliente);
            cabeceraSolicitud.setCliente(sCodigoCliente);
            /* Fin Modificacion por ssantana, 12/05/2006, inc. 23074 */
            
            cabeceraSolicitud.setDestinatario(oidCliente);
            cabeceraSolicitud.setOidPais(actividadesMav.getOidPais());
            cabeceraSolicitud.setMarca(actividadesMav.getOidMarca());
            cabeceraSolicitud.setCanal(actividadesMav.getOidCanal());
            cabeceraSolicitud.setSociedad(actividadesMav.getOidEmpresa());
            cabeceraSolicitud.setOidPagadorFactura(oidCliente);
            cabeceraSolicitud.setOidReceptorFactura(oidCliente);
            cabeceraSolicitud.setTipoSolicitud(actividadesMav.getOidTipoSolicitudParaPago());
            cabeceraSolicitud.setOperacion(ConstantesBEL.MAV023);
            
            /** Direccion Principal */ 
            oidDireccionPPal = 
                    datoGenerarPago.obtieneDireccionPPalCliente(oidCliente);
            cabeceraSolicitud.setDestino(oidDireccionPPal);
            
            /** Tipo Documento Principal*/
            tipoDocumento = 
                  datoGenerarPago.obtieneTipoDocumentoPrincipalCliente(oidCliente);
                  
            if (tipoDocumento != null){
                cabeceraSolicitud.setTipoDocumento(tipoDocumento); 
                cabeceraSolicitud.setTipoDocumentoLegal(tipoDocumento);
            }
            
            /** Tipo y Subtipo Cliente */
            /* No contemplo nulidad porque siempre tiene que venir valores */ 
            arrayTipoSubtipoClientePPal = 
                    datoGenerarPago.obtieneTipoSubtipoPrincipalCliente(oidCliente);
                    
            tipoClientePPal = arrayTipoSubtipoClientePPal[0];
            subtipoClientePPal = arrayTipoSubtipoClientePPal[1];
            
            UtilidadesLog.debug("tipoCliente: " + tipoClientePPal);
            UtilidadesLog.debug("subtipoCliente: " + subtipoClientePPal);
            
            cabeceraSolicitud.setTipoCliente(tipoClientePPal);
            cabeceraSolicitud.setSubtipoCliente(subtipoClientePPal);
            
            /** Resto de valores */ 
            DTOPeriodo periodo = new DTOPeriodo();
            periodo.setOidPais(actividadesMav.getOidPais());
            periodo.setPais(actividadesMav.getOidPais());
            periodo.setMarca(actividadesMav.getOidMarca());
            periodo.setCanal(actividadesMav.getOidCanal());
            periodo.setFechaInicio(new java.sql.Date(System.currentTimeMillis()));

            MONPeriodosHome momPeriodosHome = this.getMONPeriodosHome();
            MONPeriodos momPeriodos = momPeriodosHome.create();
            DTOSalida dtoSalida = momPeriodos.obtienePeriodosFecha(periodo);
            UtilidadesLog.debug("Periodos obtenidos: " + dtoSalida);

            if(dtoSalida != null) {
                RecordSet recordSet = dtoSalida.getResultado();

                if(!recordSet.esVacio()) {
                    Long menorID = null;
                    java.sql.Date fechaMenor = null;
                    PeriodoLocalHome periodoHome = new PeriodoLocalHome();

                    for(int i = 0; i < recordSet.getRecords().size(); ++i) {
                        UtilidadesLog.debug("Obtengo Menor Fecha, bucle " + i);
                        PeriodoLocal periodoLocal = periodoHome.findByPrimaryKey(this.getLogFromResultSet(recordSet.getValueAt(0, "oid")));

                        if((fechaMenor == null) || periodoLocal.getFechainicio().before(fechaMenor)) {
                            fechaMenor = periodoLocal.getFechainicio();
                            menorID = periodoLocal.getOid();
                        }
                    }

                    cabeceraSolicitud.setPeriodo(menorID);

                    TiposSolicitudPaisLocalHome tiposSolicitudPaisLocalHome = new TiposSolicitudPaisLocalHome();
                    TiposSolicitudPaisLocal tiposSolicitudPaisLocal = tiposSolicitudPaisLocalHome.findByPrimaryKey(actividadesMav
                            .getOidTipoSolicitudParaPago());
                    TiposSolicitudLocalHome tiposSolicitudLocalHome = new TiposSolicitudLocalHome();
                    TiposSolicitudLocal tiposSolicitudLocal = tiposSolicitudLocalHome.findByPrimaryKey(tiposSolicitudPaisLocal
                            .getOidTipoSolicitud());

                    cabeceraSolicitud.setAcceso(tiposSolicitudLocal.getOidAcceso());
                    cabeceraSolicitud.setSubacceso(tiposSolicitudLocal.getOidSubacceso());
                    cabeceraSolicitud.setFecha(dateHoy);
                    
                    /* Agregado por ssantana, 06/07/2006 - No figura en el DECU pero debe pasarse */ 
                    Timestamp t = new Timestamp(dateHoy.getTime());
                    cabeceraSolicitud.setFechaPrevistaFacturacion(t);
                    /* Fin Agregado por ssantana, 06/07/2006 */ 

                    PaisLocalHome paisHome = new PaisLocalHome();
                    PaisLocal pais = paisHome.findByPrimaryKey(actividadesMav.getOidPais());
                    cabeceraSolicitud.setMoneda(pais.getMone_oid_mone());
                    cabeceraSolicitud.setModulo(new Long(ConstantesSEG.MODULO_MAV));

                    
                    SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
                    cabeceraSolicitud.setNumeroDocumentoOrigen(new Long(sdf.format(dateHoy)));
                    //cabeceraSolicitud.numeroDocumentoOrigen = se introduce la fecha como un número ej: 12/05/2004 => 12.052.004
                    Long numeroTotalUnidades = new Long(0);
                    BigDecimal numeroTotalMonto = new BigDecimal(0.0);
                    BigDecimal montoBuffer = null;
                    BigDecimal bigPrecioMedio = null;
                    BigDecimal bigUnidadesBuffer = null;
                    ArrayList posiciones = new ArrayList();

                    /*numeroTotalMonto = (BigDecimal) solicitudesEnvioMAV.getValueAt(0, "MONTO");*/
                    for(int i = 0; i < solicitudesEnvioMAV.getRecords().size(); ++i) {
                        UtilidadesLog.debug("Genero posicion a la solicitud, bucle " + i);
                        /* Obtengo el precio medio actual y las unidades */ 
                        bigPrecioMedio = (BigDecimal) solicitudesEnvioMAV.getValueAt(i, "MONTO");
                        bigUnidadesBuffer = (BigDecimal) solicitudesEnvioMAV.getValueAt(i, "NUM_UNID");                        
                        
                        /* Calculo el monto Total Actual */
                        montoBuffer = bigPrecioMedio.multiply(bigUnidadesBuffer);
                        
                        /* Acumulo el Total Actual en Monto Total */
                        numeroTotalMonto = numeroTotalMonto.add(montoBuffer);

                        /* Acumulo el total de Unidades de esta tupla */ 
                        numeroTotalUnidades = new Long(numeroTotalUnidades.longValue()
                                + this.getLogFromResultSet(bigUnidadesBuffer).longValue());
                        
                        DTOPosicionSolicitud posicion = new DTOPosicionSolicitud();

                        posicion.setSubtipoPosicion(actividadesMav.getOidSubtipoPosicionParaPago());
                        posicion.setCodigoVenta(this.getStringFromResultSet(solicitudesEnvioMAV.getValueAt(i, "VAL_CODI_VENT")));
                        posicion.setUnidadesDemandadas(this.getLogFromResultSet(bigUnidadesBuffer));
                        posicion.setUnidadesPorAtender(this.getLogFromResultSet(bigUnidadesBuffer));
                        posicion.setUnidadesDemandaReal(this.getLogFromResultSet(bigUnidadesBuffer));
                        
                        UtilidadesLog.debug(" Porcentaje sobre costo (actividadMAV): " +
                                actividadesMav.getPorcentajeSobreCosto());
                        bigPrecioMedio = bigPrecioMedio.multiply(
                                new BigDecimal(1 + (actividadesMav.getPorcentajeSobreCosto().floatValue() / 100)));
                        bigPrecioMedio = bigPrecioMedio.setScale(2, BigDecimal.ROUND_HALF_UP);                                
                        /*posicion.setPrecioCatalogoUnitarioLocal((bigPrecioMedio).multiply(
                                new BigDecimal(1 + (actividadesMav.getPorcentajeSobreCosto().intValue() / 100))));*/
                        posicion.setNumeroPosicion(new Long(i));       
                        posiciones.add(posicion);
                    }
                    UtilidadesLog.debug("Numero Total Unidades Generadas: " + numeroTotalUnidades.toString());
                    UtilidadesLog.debug("Monto Total: " + numeroTotalMonto.toString());

                    //fin for
                    cabeceraSolicitud.setPosiciones(posiciones);

                    MONGenerarSolicitudModulosExternosHome momGenSolExtHome = this.getMONGenerarSolicitudModulosExternosHome();
                    MONGenerarSolicitudModulosExternos momGenSolExt = momGenSolExtHome.create();

                    //Recuperar DTOOID de respuesta a la llamada anterior, que contiene el número de solicitud de la solicitud generada
                    UtilidadesLog.debug("DTOCabeceraSolicitud: " + cabeceraSolicitud);
                    UtilidadesLog.debug("Invoca a generaSolicitud()...");
                    DTOOID dtoId = momGenSolExt.generaSolicitud(cabeceraSolicitud);
                    UtilidadesLog.debug("Invoco a generaSolicitud()...");
                    
                    DTOInformeGeneracion informeGeneracion = new DTOInformeGeneracion();
                    informeGeneracion.setOidSolicitud(dtoId.getOid());
                    informeGeneracion.setNumeroTotalUnidades(numeroTotalUnidades);
                    informeGeneracion.setNumeroTotalMonto(numeroTotalMonto);
                    informeGeneracion.setAccesoSolicitud(cabeceraSolicitud.getAcceso());
                    informeGeneracion.setSubaccesoSolicitud(cabeceraSolicitud.getSubacceso());
                    informeGeneracion.setTipoSolicitud(cabeceraSolicitud.getTipoSolicitud());
                    informeGeneracion.setNumeroCodigosVenta(new Long(posiciones.size())); //número de posiciones creadas 
                    UtilidadesLog.debug("DTOInformeGeneracion a retornar: " + informeGeneracion );

                    UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarSolicitud(DTOGenerarPagoIntercompanias dto, RecordSet solicitudesEnvioMAV):Salida");
                    return informeGeneracion;
                }
            }
            UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarSolicitud(DTOGenerarPagoIntercompanias dto, RecordSet solicitudesEnvioMAV):Salida");
            return null;
        }catch(NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(RemoteException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    private Long genererResumenPagoIntercompanias(DTOGenerarPagoIntercompanias dto1, DTOInformeGeneracion dto2)
        throws MareException {
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.genererResumenPagoIntercompanias(DTOGenerarPagoIntercompanias dto1, DTOInformeGeneracion dto2):Entrada");
        try {
            ResumenPagoIntercompaniasLocalHome resumenHome = new ResumenPagoIntercompaniasLocalHome();
            ActividadesMAVLocalHome actividadesMAVHome = new ActividadesMAVLocalHome();
            ActividadesMAVLocal actividadesMAV = actividadesMAVHome.findByPrimaryKey(dto1.getActividad());

            ResumenPagoIntercompaniasLocal resumen = resumenHome.create(new Timestamp(System.currentTimeMillis()),
                    dto1.getFechaDesde(), dto1.getFechaHasta(), actividadesMAV.getOidMarca(), dto1.getActividad(),
                    actividadesMAV.getOidCanal(), dto2.getOidSolicitud(), dto2.getSubaccesoSolicitud());

            resumen.setItems(dto2.getNumeroCodigosVenta());
            resumen.setUnidadTotales(dto2.getNumeroTotalUnidades());
            resumen.setMontotal(dto2.getNumeroTotalMonto());
            resumenHome.merge(resumen);

            UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.genererResumenPagoIntercompanias(DTOGenerarPagoIntercompanias dto1, DTOInformeGeneracion dto2):Salida");
            return resumen.getOid();
        } catch(NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    private void generarPeriodosRefenciaPago(DTOGenerarPagoIntercompanias dto, Long resumenPagoIntercompañias)
        throws MareException {
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarPeriodosRefenciaPago(DTOGenerarPagoIntercompanias dto, Long resumenPagoIntercompañias):Entrada");
        try {
            DAOGenerarPagoIntercompanias dao = new DAOGenerarPagoIntercompanias();
            RecordSet recordSet = dao.obtenerPeriodosEntreFechas(dto.getFechaDesde(), dto.getFechaHasta());

            if(recordSet != null) {
                for(int i = 0; i < recordSet.getRecords().size(); ++i) {
                    PeriodosRefenciaPagoLocalHome periodosHome = new PeriodosRefenciaPagoLocalHome();
                    Long l = this.getLogFromResultSet(recordSet.getValueAt(i, "OID_PERI"));
                    periodosHome.create(l, resumenPagoIntercompañias);
                }
            }
        } catch(PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.generarPeriodosRefenciaPago(DTOGenerarPagoIntercompanias dto, Long resumenPagoIntercompañias):Salida");
    }

    private Long getLogFromResultSet(Object dato) {
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.getLogFromResultSet(Object dato):Entrada");
        Long l = null;

        if(dato != null)
            l = new Long(((BigDecimal)dato).toBigInteger().longValue());

        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.getLogFromResultSet(Object dato):Salida");
        return l;
    }

    private String getStringFromResultSet(Object dato) {
        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.getStringFromResultSet(Object dato):Entrada");
        String s = null;

        if(dato != null)
            s = (String)dato;

        UtilidadesLog.info("MONGenerarPagoIntercompaniasBean.getStringFromResultSet(Object dato):Salida");
        return s;
    }


    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome)PortableRemoteObject.narrow(context.lookup("MONPeriodos"), MONPeriodosHome.class);
    }

    private MONGenerarSolicitudModulosExternosHome getMONGenerarSolicitudModulosExternosHome()
        throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONGenerarSolicitudModulosExternosHome)PortableRemoteObject.narrow(context.lookup("MONGenerarSolicitudModulosExternos"),
            MONGenerarSolicitudModulosExternosHome.class);
    }


}
