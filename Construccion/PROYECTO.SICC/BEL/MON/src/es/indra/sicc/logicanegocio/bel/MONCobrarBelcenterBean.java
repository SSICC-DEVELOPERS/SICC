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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.bel.DTOApplet;
import es.indra.sicc.dtos.bel.DTOCargaCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOCargaMedioPago;
import es.indra.sicc.dtos.bel.DTOCargaMoneda;
import es.indra.sicc.dtos.bel.DTOCobroBelcenter;
import es.indra.sicc.dtos.bel.DTOComprobarInicioCobro;
import es.indra.sicc.dtos.bel.DTOContinuarFacturacion;
import es.indra.sicc.dtos.bel.DTOMovimientoCaja;
import es.indra.sicc.dtos.bel.DTOMovimientoCajaDetalle;
import es.indra.sicc.dtos.bel.DTOObtenerNotasCreditoPendientes;
import es.indra.sicc.dtos.bel.DTOObtenerSolicitudCobro;
import es.indra.sicc.dtos.ccc.DTOMovimientoBancario;
import es.indra.sicc.dtos.ped.DTONumeroSolicitud;
import es.indra.sicc.dtos.ped.applet.DTODatosCombo;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocal;
import es.indra.sicc.entidades.bel.AsociacionMaquinaCajaLocalHome;
import es.indra.sicc.entidades.bel.CajaLocal;
import es.indra.sicc.entidades.bel.CajaLocalHome;
import es.indra.sicc.entidades.bel.MovimientosDeCajaCabeceraLocal;
import es.indra.sicc.entidades.bel.MovimientosDeCajaCabeceraLocalHome;
import es.indra.sicc.entidades.bel.MovimientosDeCajaDetalleLocal;
import es.indra.sicc.entidades.bel.MovimientosDeCajaDetalleLocalHome;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocal;
import es.indra.sicc.entidades.bel.ParametrosBelcenterLocalHome;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocal;
import es.indra.sicc.entidades.mae.ClienteDatosBasicosLocalHome;
import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.bel.DAOMediosPagoBelcenter;
import es.indra.sicc.logicanegocio.bel.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.bel.MONServicioBEL;
import es.indra.sicc.logicanegocio.bel.MONServicioBELHome;
import es.indra.sicc.logicanegocio.ccc.CCCConstantes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientes;
import es.indra.sicc.logicanegocio.ccc.MONCuentasCorrientesHome;
import es.indra.sicc.logicanegocio.fac.MONProcesosFacturacion;
import es.indra.sicc.logicanegocio.fac.MONProcesosFacturacionHome;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientes;
import es.indra.sicc.logicanegocio.mae.MONConfiguracionClientesHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ConstantesProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPED;
import es.indra.sicc.logicanegocio.ped.MONProcesosPEDHome;
import es.indra.sicc.logicanegocio.ped.applet.MONRegistroOnline;
import es.indra.sicc.logicanegocio.ped.applet.MONRegistroOnlineHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.Date;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;

import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;


/*
 * rgiorgi - 23/08/2005: inc. BEL-03. Además see formatea la clase.
 * */
public class MONCobrarBelcenterBean implements SessionBean {
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
    * @throws MareException
    * @return DTOComprobarInicioCobro
    * @param DTOComprobarInicioCobro
    * @autor pperanzola
    * @documentation
        // Compruebo el estado de la caja asociada al usuario
        asociacionMaquinaCaja = AsociacionMaquinaCaja.findByUK(DTOE.IP)
        caja = Caja.findByPrimaryKey(asociacionMaquinaCaja.oidCaja)

        Si caja.estadoCaja == ConstantesBEL.CAJA_CERRADA
        {
        Lanza una Excepción con código de error: BEL-0011
        }
        sino
        {
        DTOE.oidCaja = caja.oid
        entidadi18N = EntidadI18N.findByEntAtrIdioPK(ConstantesBEL.BEL_CAJA, 1, DTOE.idioma, caja.oid)
        DTOE.caja = entidadi18N.detalle
        }

        Si DTOE.cobrarBelcenter == True
        {
        // Comprueba que la solicitud se encuentra en GP5 y proceso P520
        Crea DTOOID con:
        - oid = DTOE.oidCabeceraSolicitud

        DTOSalida = IPedidosSolicitud.obtenerImportesCobro(DTOOID)
        resultado = DTOSalida.resultado
        Si resultado.getValueAt(0, "GRUPO_PROCESOS") == ConstantesPED.GP5 AND resultado.getValueAt(0, "PROCESO") == ConstantesProcesosPED.P520
        {
        DTOE.totalPagarLocal = resultado.getValueAt(0, "TOTAL_PAGAR_LOCAL")
        DTOE.totalPagarDocumento = resultado.getValueAt(0, "TOTAL_PAGAR_DOCUMENTO")
        }
        sino
        {
        Lanza una Excepción con código de error: BEL-0012
        }

        // Obtiene el límite de diferencia de pago
        pais = Pais.findByPrimaryKey(DTOE.pais)
        DTOE.montoMaximoDiferencia = pais.limiteDiferenciaPago
        }

        // Obtiene el tipo de movimiento a cobrar
        parametrosBelcenter = ParametrosBelcenter.findByUK(DTOE.pais, DTOE.oidSubacceso)
        DTOE.oidTipoMovimientoCobrar = parametrosBelcenter.tipoMovimientoCobrar

        Si DTOE.cobrarBelcenter == False
        {
        // Obtiene la cuenta corriente, la empresa y el tipo de transacción
        DTOE.oidCuentaCorriente = parametrosBelcenter.cuentaCorriente
        DTOE.oidEmpresa = parametrosBelcenter.empresa
        DTOE.oidTipoTransaccion = parametrosBelcenter.tipoTransaccion
        }

        Devuelve DTOE
    */
    /**
    * Autor: Cortaberria
    * Fecha: 14/3/2005
    * Modificación por cambios indicados en incidencia BELC300014681
    *
    * Fecha: 05/05/2005
    * En el último if se estaba compararndo belcenter == true cuando el diseño dice que sea false.
    *
    * Fecha: 13/05/2005
    * MOdificaciones indicadas en incidencia 17879
    *
    * Fecha: 15/07/2005
    * Se cambia el tipo de excepcion lanzada por una parametrizada
    */
    public DTOComprobarInicioCobro comprobarInicioCobro(DTOComprobarInicioCobro dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.comprobarInicioCobro(DTOComprobarInicioCobro dtoE):Entrada");
        AsociacionMaquinaCajaLocalHome asociacionMaquinaCajaLocalHome = null;
        CajaLocalHome cajaLocalHome = null;
        Entidadi18nLocalHome i18LH = null;
        CajaLocal caja = null;
        AsociacionMaquinaCajaLocal asociacionMaquinaCaja = null;

        cajaLocalHome = this.getCajaLocalHome();
        asociacionMaquinaCajaLocalHome = this.getAsociacionMaquinaCajaLocalHome();

        try {
            asociacionMaquinaCaja = asociacionMaquinaCajaLocalHome.findByUK(dtoE.getIP());
            caja = cajaLocalHome.findByPrimaryKey(asociacionMaquinaCaja.getOidCaja());
        } catch (NoResultException fex) {
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (ConstantesBEL.CAJA_CERRADA.equals(caja.getEstadoCaja())) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0011));
        } else {
            dtoE.setOidCaja(caja.getOid());
            dtoE.setCaja(caja.getCodigoCaja());
        }

        if (Boolean.TRUE.equals(dtoE.getCobrarBelcenter())) {
            DTOOID dtoOID = new DTOOID();
            dtoOID.setOid(dtoE.getOidCabeceraSolicitud());
            dtoOID.setOidIdioma(dtoE.getOidIdioma());
            dtoOID.setOidPais(dtoE.getOidPais());

            MONRegistroOnlineHome monRegistroOnlineHome = null;
            MONRegistroOnline monRegistroOnline = null;
            monRegistroOnlineHome = this.geMONRegistroOnlineHome();

            try {
                monRegistroOnline = monRegistroOnlineHome.create();
            } catch (Exception exept) {
                throw new MareException(exept, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            DTOSalida dtoSalida = null;

            try {
                dtoSalida = monRegistroOnline.obtenerImportesCobro(dtoOID);
            } catch (RemoteException rmEx) {
                throw new MareException(rmEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            RecordSet rsResultado = dtoSalida.getResultado();

            if (rsResultado.esVacio()) {
                //no se encontro el consolidado
                //throw new MareException (new Exception(),
                //                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));                  
                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0020));

                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                ex.addParameter(dtoE.getOidCabeceraSolicitud().toString());
                throw ex;
            }

            String procesos = (String) rsResultado.getValueAt(0, "PROCESO");
            Long grpProcesos = ((rsResultado.getValueAt(0, "GRUPO_PROCESOS") == null) ? null : new Long(((BigDecimal) rsResultado.getValueAt(0, "GRUPO_PROCESOS")).longValue()));

            if (ConstantesPED.GP5.equals(grpProcesos) && ConstantesProcesosPED.PROCESO_P520.equals(procesos)) {
                dtoE.setOidCabeceraSolicitud((rsResultado.getValueAt(0, "OID_CONSOLIDADO") != null) ? new Long(((BigDecimal) rsResultado.getValueAt(0, "OID_CONSOLIDADO")).longValue()) : null);
                dtoE.setNumeroConsolidado((rsResultado.getValueAt(0, "NUMERO_CONSOLIDADO") != null) ? new Long(((BigDecimal) rsResultado.getValueAt(0, "NUMERO_CONSOLIDADO")).longValue()) : null);

                dtoE.setTotalPagarLocal(((rsResultado.getValueAt(0, "TOTAL_PAGAR_LOCAL") != null) ? (BigDecimal) rsResultado.getValueAt(0, "TOTAL_PAGAR_LOCAL") : null));
                dtoE.setTotalPagarDocumento(((rsResultado.getValueAt(0, "TOTAL_PAGAR_DOCUMENTO") != null) ? (BigDecimal) rsResultado.getValueAt(0, "TOTAL_PAGAR_DOCUMENTO") : null));
                
                dtoE.setDivisa(((rsResultado.getValueAt(0, "DIVISA") != null) ? (String) rsResultado.getValueAt(0, "DIVISA") : null));                
                
            } else {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0012));
            }

            // Obtiene el límite de diferencia de pago 
            PaisLocalHome paisLH = this.getPaisLocalHome();
            PaisLocal paisL = null;

            try {
                paisL = paisLH.findByPrimaryKey(dtoE.getOidPais());
            } catch (NoResultException fex) {
                throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            Long limitePago = paisL.getNum_limi_dife_pago();
            dtoE.setMontoMaximoDiferencia((limitePago != null) ? new BigDecimal(paisL.getNum_limi_dife_pago().toString()) : null);
        }

        // Obtiene el tipo de movimiento a cobrar 
        ParametrosBelcenterLocalHome paramLH = this.getParametrosBelcenterLocalHome();
        ParametrosBelcenterLocal paramBelcenter = null;

        try {
            paramBelcenter = paramLH.findByUK(dtoE.getOidPais(), dtoE.getOidSubacceso());
        } catch (NoResultException fex) {
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        dtoE.setOidTipoMovimientoCobrar(paramBelcenter.getTipoMovimientoCobrar());

        if (Boolean.FALSE.equals(dtoE.getCobrarBelcenter())) {
            // Obtiene la cuenta corriente, la empresa y el tipo de transacción 
            dtoE.setOidCuentaCorriente(paramBelcenter.getCuentaCorriente());
            dtoE.setOidEmpresa(paramBelcenter.getEmpresa());
            dtoE.setOidTipoTransaccion(paramBelcenter.getTipoTransaccion());
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.comprobarInicioCobro(DTOComprobarInicioCobro dtoE):Salida");
        return dtoE;
    }

    /**
    * @throws MareException
    * @return DTOCargaCobroBelcenter
    * @param DTOOID
    * @autor jquiroga
    * @documentation
        // Carga inicial de la página Cobrar en Belcenter
        Crear DTOCargaCobroBelcenter

        // MEDIO PAGO
        resultado = DAOMediosPagoBelcenter.obtenerMediosPagoSubacceso(DTOOID)
        DTOCargaCobroBelcenter.medioPago = crearDTOCargaMedioPago(resultado)

        // MONEDA
        pais = Pais.findByPrimaryKey(DTOBelcorp.pais)
        entidadi18N = EntidadI18N.findByEntAtrIdioPK(ConstantesSEG.SEG_MONED, 1, DTOE.idioma, pais.monedaAlternativa)
        moneda = Moneda.findByPrimaryKey(pais.moneda)
        DTOCargaCobroBelcenter.moneda.oid = pais.monedaAlternativa
        DTOCargaCobroBelcenter.moneda.descripcion = entidadi18N.detalle
        DTOCargaCobroBelcenter.moneda.decimales = moneda.numeroDecimales

        // TIPO CAMBIO
        DTOCargaCobroBelcenter.tipoCambio = IServicioSEG.obtenerTipoCambio(pais.moneda, pais.monedaAlternativa)
        Si DTOCargaCobroBelcenter.tipoCambio == null o vacío
        {
        DTOCargaCobroBelcenter.tipoCambio = IServicioSEG.obtenerTipoCambioAnterior(pais.moneda, pais.monedaAlternativa, Fecha sistema)
        }

        // BANCOS
        resultado = IDAOCCC.obtieneBancos(DTOOID)
        DTOCargaCobroBelcenter.banco = crearDTODatosCombo(resultado)

        // TIPOS TARJETA
        DTOSalida = IConfiguracionClientes.obtenerTiposTarjeta(DTOOID)
        DTOCargaCobroBelcenter.tipoTarjeta = crearDTODatosCombo(DTOSalida.resultado)

        Devuelve DTOCargaCobroBelcenter
    */
    public DTOCargaCobroBelcenter cargaInicialCobro(DTOApplet dtoa) throws MareException {
        // Carga inicial de la página Cobrar en Belcenter 
        UtilidadesLog.info("MONCobrarBelcenterBean.cargaInicialCobro(DTOApplet dtoa):Entrada");
        DTOCargaCobroBelcenter dtoCargaCobroBelcenter = new DTOCargaCobroBelcenter();
        String nombreUsuario = dtoa.getUserName();

        //DAOMediosPagoBelcenter daoMediosPagoBelcenter=new DAOMediosPagoBelcenter("PRUEBAS");
        //DAOMediosPagoBelcenter daoMediosPagoBelcenter=new DAOMediosPagoBelcenter(ctx.getCallerPrincipal().getName());
        DAOMediosPagoBelcenter daoMediosPagoBelcenter = new DAOMediosPagoBelcenter(nombreUsuario);
        DTOOID dtoE = (DTOOID) dtoa.getDto();
        RecordSet resultado = null;
        DTOSalida dtoSalida = null;

        PaisLocalHome paisLocalHome = null;
        PaisLocal paisLocal = null;
        Entidadi18nLocalHome entidadi18nLocalHome = null;
        Entidadi18nLocal entidadi18nLocal = null;
        MonedaLocalHome monedaLocalHome = null;
        MonedaLocal monedaLocal = null;

        MONMantenimientoSEGHome monMantenimientoSEGHome = null;
        MONMantenimientoSEG monMantenimientoSEG = null;
        MONCuentasCorrientesHome monCuentasCorrientesHome = null;
        MONCuentasCorrientes monCuentasCorrientes = null;
        MONConfiguracionClientesHome monConfiguracionClientesHome = null;
        MONConfiguracionClientes monConfiguracionClientes = null;

        // MEDIO PAGO 
        resultado = daoMediosPagoBelcenter.obtenerMediosPagoSubacceso(dtoE);
        dtoCargaCobroBelcenter.setMedioPago(crearDTOCargaMedioPago(resultado));

        // MONEDA
        try {
            paisLocalHome = getPaisLocalHome();
            paisLocal = paisLocalHome.findByPrimaryKey(dtoE.getOidPais());
            entidadi18nLocalHome = getEntidadi18nLocalHome();
            entidadi18nLocal = entidadi18nLocalHome.findByEntAtrIdioPK(ConstantesSEG.SEG_MONED, new Long(1), dtoE.getOidIdioma(), paisLocal.getMone_oid_mone_alt());
            monedaLocalHome = getMonedaLocalHome();
            monedaLocal = monedaLocalHome.findByPrimaryKey(paisLocal.getMone_oid_mone());

            dtoCargaCobroBelcenter.setMoneda(new DTOCargaMoneda());
            dtoCargaCobroBelcenter.getMoneda().setOid(paisLocal.getMone_oid_mone_alt());
            dtoCargaCobroBelcenter.getMoneda().setDescripcion(entidadi18nLocal.getDetalle());
            dtoCargaCobroBelcenter.getMoneda().setDecimales(LongToInteger(monedaLocal.getNumDeci()));

            // TIPO CAMBIO
            monMantenimientoSEGHome = (MONMantenimientoSEGHome) UtilidadesEJB.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
            monMantenimientoSEG = monMantenimientoSEGHome.create();

            dtoCargaCobroBelcenter.setTipoCambio(monMantenimientoSEG.obtenerTipoCambio(paisLocal.getMone_oid_mone(), paisLocal.getMone_oid_mone_alt()));

            if (dtoCargaCobroBelcenter.getTipoCambio() == null) {
                dtoCargaCobroBelcenter.setTipoCambio(monMantenimientoSEG.obtenerTipoCambioAnterior(paisLocal.getMone_oid_mone(), paisLocal.getMone_oid_mone_alt(), new Date()));
            }

            // BANCOS
            monCuentasCorrientesHome = (MONCuentasCorrientesHome) UtilidadesEJB.getHome("MONCuentasCorrientes", MONCuentasCorrientesHome.class);
            monCuentasCorrientes = monCuentasCorrientesHome.create();

            dtoSalida = monCuentasCorrientes.obtieneBancos(dtoE);
            dtoCargaCobroBelcenter.setBanco(crearDTODatosCombo(dtoSalida.getResultado()));

            // TIPOS TARJETA      
            monConfiguracionClientesHome = (MONConfiguracionClientesHome) UtilidadesEJB.getHome("MONConfiguracionClientes", MONConfiguracionClientesHome.class);
            monConfiguracionClientes = monConfiguracionClientesHome.create();

            dtoSalida = monConfiguracionClientes.obtenerTiposTarjeta(dtoE);
            dtoCargaCobroBelcenter.setTipoTarjeta(crearDTODatosCombo(dtoSalida.getResultado()));
        } catch (NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.debug(ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.cargaInicialCobro(DTOApplet dtoa):Salida");
        return dtoCargaCobroBelcenter;
    }

    /**
    * @throws MareException
    * @return DTOOID
    * @param DTOObtenerSolicitudCobro
    * @autor jquiroga
    * @documentation
        DTOE = IPedidosSolicitud.obtenerSolicitudCobro(DTOE)

        Si DTOE == null
        {
        Genera una Excepción con código: BEL-0013
        }
        sino
        {
        Si DTOE.oidMoneda == null
        {
        // El consolidado está en moneda local
        Si DTOE.totalPagarLocal * (-1) != DTOE.importe
        {
        Genera una Excepción con código: BEL-0015
        }
        }
        sino
        {
        Si DTOE.totalPagarDocumento * (-1) != DTOE.importeDivisa
        {
        Genera una Excepción con código: BEL-0016
        }
        }
        }

        Crea DTOOID con:
        - oid: DTOE.oidSolicitud

        Devuelve DTOOID
    */
    /**
     * Autor Cortaberria
     * Fecha 17/3/05
     * Modificaciones por lo indicado en incidencia BELC300014584
     */
    public DTOOID obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE):Entrada");
        MONRegistroOnlineHome monRegistroOnlineHome = null;
        MONRegistroOnline monRegistroOnline = null;
        DTOOID dtoOId = null;

        try {
            monRegistroOnlineHome = (MONRegistroOnlineHome) UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
            monRegistroOnline = monRegistroOnlineHome.create();
            dtoE = monRegistroOnline.obtenerSolicitudCobro(dtoE);

            // Clausula "If" modificada por ssantana, 17/8/2005. 
            if (dtoE == null){
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0013));
            }
            if (((dtoE.getTotalPagarLocal() == null) || (dtoE.getTotalPagarDocumento() == null)) && ((dtoE.getImporte() == null) && (dtoE.getImporteDivisa() == null))) {
                //Genera una Excepción con código: BEL_0013
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0013));
            } else {

                if (dtoE.getOidMoneda() == null) {
                    // El consolidado está en moneda local 

                    if ((dtoE.getImporte() == null ) || ((dtoE.getTotalPagarLocal().longValue() * -1) != dtoE.getImporte().longValue())) {
                        //Genera una Excepción con código: BEL_0015
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0015));
                    }
                } else {
                    //if( (dtoE.getTotalPagarLocal().longValue() * -1) != dtoE.getTotalPagarDocumento().longValue() ) { 
                    //ver incidencia 14584
                    if ((dtoE.getImporteDivisa() == null) || ((dtoE.getTotalPagarDocumento().longValue() * -1) != dtoE.getImporteDivisa().longValue())) {
                        //Genera una Excepción con código: BEL_0016 
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_BEL, "", ErroresDeNegocio.BEL_0016));
                    }
                }
            }
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.debug(ex);
            throw new MareException(ex);
        }

        dtoOId = new DTOOID();
        dtoOId.setOid(dtoE.getOidSolicitud());
        UtilidadesLog.info("MONCobrarBelcenterBean.obtenerSolicitudCobro(DTOObtenerSolicitudCobro dtoE):Salida");
        return dtoOId;
    }

    /**
    * @throws MareException
    * @return void
    * @param DTOCobroBelcenter
    * @autor jquiroga
    * @documentation
        // Graba los movimientos de caja generados por el cobro de una solicitud

        // Graba la cabecera
        DTOE = grabarCabeceraMovimientos(DTOE)

        // Graba los movimientos de caja
        DTOE = grabarDetalleMovimientos(DTOE)

        // Envía un mensaje al administrador
        Si DTOE.enviarMensaje == True
        {
        caja = DTOE.movimientoCaja.oidCaja
        saldoEfectivo = DTOE.totalImporte
        MONServicioBEL.emitirMensajeAdministrador(caja, saldoEfectivo)
        }

        Si DTOE.generarMovimiento == True
        {
        // Genera un movimiento bancario
        generarMovimientoCCC(DTOE)
        }
    */

    /*
     * Autor: Cortaberria
     * Fecha: 13/05/2005
     * Se aplican cambios indicadosn en la incidencia 17879, para continuar el proceso de facturacion
     */
    public void grabarCobro(DTOCobroBelcenter dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarCobro(DTOCobroBelcenter dtoE):Entrada");
        MONServicioBEL monServicioBEL = null;
        MONServicioBELHome monServicioBELHome = null;

        // Graba la cabecera 
        dtoE.setMovimientoCaja(grabarCabeceraMovimientos(dtoE));

        // Graba los movimientos de caja 
        dtoE.setMovimientoCaja(grabarDetalleMovimientos(dtoE));

        try {
            // Envía un mensaje al administrador 
            if (Boolean.TRUE.equals(dtoE.getEnviarMensaje())) {
                monServicioBELHome = (MONServicioBELHome) UtilidadesEJB.getHome("MONServicioBEL", MONServicioBELHome.class);
                monServicioBEL = monServicioBELHome.create();

                //VER INC. BELC300014381 
                //monServicioBEL.emitirMensajeAdministrador(dtoE.getMovimientoCaja().getOidCaja(), dtoE.getTotalImporte(), dtoE.getLimiteEfectivoCaja());
                monServicioBEL.emitirMensajeAdministrador(dtoE.getMovimientoCaja().getCaja(), dtoE.getTotalImporte());
            }
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (Boolean.TRUE.equals(dtoE.getGenerarMovimiento())) { //CAMBIAR IS POR GET

            // Genera un movimiento bancario 
            generarMovimientoCCC(dtoE);
        }

        // Despues de grabar el cobro se debe continuar con la facturación 
        DTOContinuarFacturacion dtoContFac = new DTOContinuarFacturacion();
        dtoContFac.setOidConsolidado(dtoE.getMovimientoCaja().getOidSolicitudCabecera());
        dtoContFac.setEstado(Boolean.TRUE);

        if (dtoE.getContinuaFacturacion() != null && dtoE.getContinuaFacturacion().booleanValue()) {
            this.continuarFacturacion(dtoContFac);
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarCobro(DTOCobroBelcenter dtoE):Salida");
    }

    /**
    * @throws MareException
    * @return DTOSalida
    * @param DTOObtenerNotasCreditoPendientes
    * @autor jquiroga
    * @documentation
        DTOSalida = IPedidosSolicitud.obtenerNotasCreditoPendientes(DTOE)

        Devuelve DTOSalida
    */
    public DTOSalida obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE):Entrada");
        DTOSalida dtoSalida = null;
        MONRegistroOnlineHome monRegistroOnlineHome = null;
        MONRegistroOnline monRegistroOnline = null;

        try {
            monRegistroOnlineHome = (MONRegistroOnlineHome) UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
            monRegistroOnline = monRegistroOnlineHome.create();
            dtoSalida = monRegistroOnline.obtenerNotasCreditoPendientes(dtoE);
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.obtenerNotasCreditoPendientes(DTOObtenerNotasCreditoPendientes dtoE):Salida");
        return dtoSalida;
    }

    /**
    * @throws MareException
    * @return DTODatosCombo[]
    * @param RecordSet
    * @autor jquiroga
    * @documentation
        Crea un DTODatosCombo por cada fila del RecordSet recibido y los devuelve

        DTODatosCombo.oid = resultado.getValueAt(fila, 0)
        DTODatosCombo.desc = resultado.getValueAt(fila, 1)

        Devuelve DTODatosCombo[]
    */
    private DTODatosCombo[] crearDTODatosCombo(RecordSet resultado) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.crearDTODatosCombo(RecordSet resultado):Entrada");
        DTODatosCombo[] dtoDatosCombos = new DTODatosCombo[resultado.getRowCount()];

        for (int i = 0; i < resultado.getRowCount(); i++) {
            dtoDatosCombos[i] = new DTODatosCombo();
            dtoDatosCombos[i].setOid(objectToLong(resultado.getValueAt(i, 0)));
            dtoDatosCombos[i].setDesc(objectToString(resultado.getValueAt(i, 1)));
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.crearDTODatosCombo(RecordSet resultado):Salida");
        return dtoDatosCombos;
    }

    /**
    * @throws MareException
    * @return DTOCargaMedioPago[]
    * @param RecordSet
    * @autor jquiroga
    * @documentation
        Crea un DTOCargaMedioPago por cada fila del RecordSet recibido y los devuelve

        DTOCargaMedioPago.oid = resultado.getValueAt(fila, 0)
        DTOCargaMedioPago.descripcion = resultado.getValueAt(fila, 1)
        DTOCargaMedioPago.oidTipoMedioPago = resultado.getValueAt(fila, 2)

        Devuelve DTOCargaMedioPago[]
    */
    private DTOCargaMedioPago[] crearDTOCargaMedioPago(RecordSet resultado) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.crearDTOCargaMedioPago(RecordSet resultado):Entrada");
        DTOCargaMedioPago[] dtoCargaMedioPagos = new DTOCargaMedioPago[resultado.getRowCount()];

        for (int i = 0; i < resultado.getRowCount(); i++) {
            dtoCargaMedioPagos[i] = new DTOCargaMedioPago();
            dtoCargaMedioPagos[i].setOid(objectToLong(resultado.getValueAt(i, "OID_MEDIO_PAGO")));
            dtoCargaMedioPagos[i].setDescripcion(objectToString(resultado.getValueAt(i, "MEDIO_PAGO")));
            dtoCargaMedioPagos[i].setOidTipoMedioPago(objectToLong(resultado.getValueAt(i, "TIPO_MEDIO_PAGO")));
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.crearDTOCargaMedioPago(RecordSet resultado):Salida");
        return dtoCargaMedioPagos;
    }

    /**
    * @throws MareException
    * @return DTOMovimientoCaja
    * @param DTOCobroBelcenter
    * @autor jquiroga
    * @documentation
        // Graba la cabecera del movimiento

        cabecera = DTOE.movimientoCaja

        // Primero genera el número de movimiento
        cabecera.numeroMovimiento = generarNumeroMovimiento(DTOE)

        Crea una entrada en la entidad MovimientosDeCajaCabecera con:
        - caja = cabecera.oidCaja
        - numeroMovimiento = cabecera.numeroMovimiento
        - cliente = cabecera.oidCliente
        - oidSolicitudCabecera = cabecera.oidSolicitudCabecera
        - diferenciaVuelto = cabecera.diferenciaVuelto
        - usuario = cabecera.usuario
        - fecha = cabecera.fecha
        - observaciones = cabecera.observaciones

        Guarda el oid generado en cabecera.oidMovimientoCaja

        DTOE.movimientoCaja = cabecera

        Devuelve DTOE
    */
    private DTOMovimientoCaja grabarCabeceraMovimientos(DTOCobroBelcenter dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarCabeceraMovimientos(DTOCobroBelcenter dtoE):Entrada");
        DTOMovimientoCaja cabecera = null;
        MovimientosDeCajaCabeceraLocalHome movimientosDeCajaCabeceraLocalHome = null;
        MovimientosDeCajaCabeceraLocal movimientosDeCajaCabeceraLocal = null;
        UtilidadesLog.debug("MONCobrarBelcenter.grabarCabeceraMovimientos: Entrada - Datos: " + dtoE);

        try {
            // Graba la cabecera del movimiento
            cabecera = dtoE.getMovimientoCaja();

            // Primero genera el número de movimiento 
            cabecera.setNumeroMovimiento(generarNumeroMovimiento(dtoE));

            //Crea una entrada en la entidad MovimientosDeCajaCabecera
            movimientosDeCajaCabeceraLocalHome = getMovimientosDeCajaCabeceraLocalHome();

            //create()->[Long caja, Long numeroMovimiento, Timestamp fecha, String usuario]
            //numeroMovimiento Long o String?
            movimientosDeCajaCabeceraLocal = movimientosDeCajaCabeceraLocalHome.create(cabecera.getOidCaja(), new Long(cabecera.getNumeroMovimiento()), new Timestamp(cabecera.getFecha().getTime()), cabecera.getUsuario());
            movimientosDeCajaCabeceraLocal.setOidCliente(cabecera.getOidCliente());
            movimientosDeCajaCabeceraLocal.setOidSoliCabe(cabecera.getOidSolicitudCabecera());
            movimientosDeCajaCabeceraLocal.setDiferenciaVuelto(cabecera.getDiferenciaVuelto());
            movimientosDeCajaCabeceraLocal.setObservaciones(cabecera.getObservaciones());
            
            movimientosDeCajaCabeceraLocalHome.merge(movimientosDeCajaCabeceraLocal);

            //Guarda el oid generado en cabecera.oidMovimientoCaja 
            cabecera.setCaja(cabecera.getOidCaja());
            cabecera.setOidCaja(movimientosDeCajaCabeceraLocal.getOid());

            dtoE.setMovimientoCaja(cabecera);
        } catch (NoResultException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException nex) {
            UtilidadesLog.debug(nex);
            throw new MareException(nex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.debug(ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarCabeceraMovimientos(DTOCobroBelcenter dtoE):Salida");
        return dtoE.getMovimientoCaja();
    }

    /**
    * @throws MareException
    * @return String
    * @param DTOCobroBelcenter
    * @autor jquiroga
    * @documentation
        Crear un DTONumeroSolicitud con:
        - oidCanal = DTOE.oidCanal
        - oidAcceso = DTOE.oidAcceso
        - oidSubacceso = DTOE.oidSubacceso
        - operacion = ConstantesBEL.BEL005

        // Obtiene el número de solicitud
        numeroSolicitud = IGenerarNumeroDocumento.generaNumeroDocumento(DTONumeroSolicitud)

        Devuelve numeroSolicitud
    */
    private String generarNumeroMovimiento(DTOCobroBelcenter dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.generarNumeroMovimiento(DTOCobroBelcenter dtoE):Entrada");
        String numeroSolicitud = null;

        DTONumeroSolicitud dtoNumeroSolicitud = new DTONumeroSolicitud();
        dtoNumeroSolicitud.setOidCanal(dtoE.getOidCanal());
        dtoNumeroSolicitud.setOidAcceso(dtoE.getOidAcceso());
        dtoNumeroSolicitud.setOidSubacceso(dtoE.getOidSubacceso());
        dtoNumeroSolicitud.setOperacion(ConstantesBEL.BEL005.toString());
        dtoNumeroSolicitud.setOidPais(dtoE.getOidPais());

        MONProcesosPEDHome monProcesosPEDHome;
        MONProcesosPED monProcesosPED;

        try {
            monProcesosPEDHome = (MONProcesosPEDHome) UtilidadesEJB.getHome("MONProcesosPED", MONProcesosPEDHome.class);
            monProcesosPED = monProcesosPEDHome.create();

            numeroSolicitud = monProcesosPED.generaNumeroDocumento(dtoNumeroSolicitud);
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.debug(ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.generarNumeroMovimiento(DTOCobroBelcenter dtoE):Salida");
        return numeroSolicitud;
    }

    /**
    * @throws MareException
    * @return DTOMovimientoCaja
    * @param DTOCobroBelcenter
    * @autor jquiroga
    * @documentation
        // Graba los movimientos de caja realizados

        Recorre el ArrayList DTOE.movimientoCajaDetalle
        {
        detalle = Siguiente elemento de DTOE.movimientoCajaDetalle

        Crea una entrada en la entidad MovimientosDeCajaDetalle con:
        - movimientoDeCajaCabecera = DTOE.movimientoCaja.oidMovimientoCaja
        - medioDePagoBelcenter = detalle.oidMedioPagoBelcenter
        - numeroLinea = detalle.numeroLinea
        - tipoMovimientoCaja = detalle.oidTipoMovimientoCaja
        - monedaAlternativa = detalle.oidMonedaAlternativa
        - importe = detalle.importe
        - importaDivisa = detalle.importeDivisa
        - banco = detalle.oidBanco
        - numeroCheque = detalle.numeroCheque
        - tipoTarjeta = detalle.oidTipoTarjeta
        - numeroTarjeta = detalle.numeroTarjeta
        - numeroValeCompra = detalle.numeroValeCompra
        - solicitudCabeceraNotaCredito = detalle.oidSolicitudNotaCredito
        - solicitudCabecera = detalle.oidSolicitudCabecera
        - fecha = detalle.fecha

        Guarda el oid generado en DTOE.movimientoCajaDetalle.oidMovimientoDeCajaDetalle

        // Si ha introducido nota de crédito
        Si detalle.oidSolicitudNotaCredito != null
        {
        Crea un DTOOID con:
        - oid: detalle.oidSolicitudNotaCredito
        IPedidosSolicitud.actualizarAplicacionManual(DTOOID)
        }
        }

        Devuelve DTOE
    */
    private DTOMovimientoCaja grabarDetalleMovimientos(DTOCobroBelcenter dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarDetalleMovimientos(DTOCobroBelcenter dtoE):Entrada");
        DTOMovimientoCajaDetalle detalle = null;
        MovimientosDeCajaDetalleLocal movimientosDeCajaDetalleLocal = null;
        MovimientosDeCajaDetalleLocalHome movimientosDeCajaDetalleLocalHome = null;
        DTOOID dtoOId = null;
        MONRegistroOnlineHome monRegistroOnlineHome = null;
        MONRegistroOnline monRegistroOnline = null;
        UtilidadesLog.debug("MONCobrarBelcenter.grabarDetalleMovimientos: Entrada - Datos: " + dtoE);

        try {
            movimientosDeCajaDetalleLocalHome = getMovimientosDeCajaDetalleLocalHome();

            monRegistroOnlineHome = (MONRegistroOnlineHome) UtilidadesEJB.getHome("MONRegistroOnline", MONRegistroOnlineHome.class);
            monRegistroOnline = monRegistroOnlineHome.create();

            ArrayList detalles = dtoE.getMovimientoCajaDetalle();

            if (detalles != null) {
                for (int i = 0; i < detalles.size(); i++) {
                    detalle = (DTOMovimientoCajaDetalle) detalles.get(i);

                    //ejbCreate(Long movimientoDeCajaCabecera, Long medioPagoBelcenter, Integer numeroLinea, Long tipoMovimientoCaja)
                    movimientosDeCajaDetalleLocal = movimientosDeCajaDetalleLocalHome.create(dtoE.getMovimientoCaja().getOidCaja(), detalle.getOidMedioPagoBelcenter(), detalle.getNumeroLinea(), detalle.getOidTipoMovimientoCaja());

                    movimientosDeCajaDetalleLocal.setMonedaAlternativa(detalle.getOidMonedaAlternativa());
                    movimientosDeCajaDetalleLocal.setImporte(detalle.getImporte());
                    movimientosDeCajaDetalleLocal.setImporteDivisa(detalle.getImporteDivisa());
                    movimientosDeCajaDetalleLocal.setOidBanco(detalle.getOidBancos());
                    movimientosDeCajaDetalleLocal.setNumeroCheque(detalle.getNumeroCheque());
                    movimientosDeCajaDetalleLocal.setTipoTarjeta(detalle.getOidTipoTarjeta());
                    movimientosDeCajaDetalleLocal.setNumeroTarjeta(detalle.getNumeroTarjeta());
                    movimientosDeCajaDetalleLocal.setNumeroValeCompra(detalle.getNumeroValeCompra());
                    movimientosDeCajaDetalleLocal.setOidSolicitudCabeceraNota(detalle.getOidSolicitudNotaCredito());
                    movimientosDeCajaDetalleLocal.setOidSolicitudCabecera(detalle.getOidSolicitudCabecera());
                    movimientosDeCajaDetalleLocal.setFecha(new Timestamp(detalle.getFecha().getTime()));
                    
                    movimientosDeCajaDetalleLocalHome.merge(movimientosDeCajaDetalleLocal);

                    detalle.setOidMovimientoDeCajaDetalle(movimientosDeCajaDetalleLocal.getOid());

                    //dtoE.getMovimientoCajaDetalle().set(i, detalle);  //CREO QUE NO HACE FALTA
                    if (detalle.getOidSolicitudNotaCredito() != null) {
                        dtoOId = new DTOOID();
                        dtoOId.setOid(detalle.getOidSolicitudNotaCredito());
                        monRegistroOnline.actualizarAplicacionManual(dtoOId);
                    }
                }
            }
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (PersistenceException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) { //ERROR NO DOCUMENTADO
            UtilidadesLog.debug(ex);
            throw new MareException(ex);
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.grabarDetalleMovimientos(DTOCobroBelcenter dtoE):Salida");
        return dtoE.getMovimientoCaja();
    }

    /**
    * @throws MareException
    * @return Long
    * @param Long
    * @autor jquiroga
    * @documentation
        // Se crea una referencia al subsistema de interfaces
        MONGestorInterfaces gi = MONGestorInterfacesHome.create()

        // La llamada a 'obtenerInterfazInfo' retorna un objeto InterfazInfo, uno de cuyos atributos es el número de lote
        InterfazInfo info = gi.obtenerInterfazInfo(IGestorInterfaces.INTERFAZ_GIS_VIA, oidPais)

        Devuelve info.numLote
    */
    private Long generarNumeroLote(Long oidPais) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.generarNumeroLote(Long oidPais):Entrada");
        MONGestorInterfaces monGestorInterfaces = null;
        MONGestorInterfacesHome monGestorInterfacesHome = null;
        InterfazInfo info = null;

        try {
            monGestorInterfacesHome = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            monGestorInterfaces = monGestorInterfacesHome.create();
            info = monGestorInterfaces.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_GIS6, oidPais);
            UtilidadesLog.info("MONCobrarBelcenterBean.generarNumeroLote(Long oidPais):Salida");
            return new Long(info.getNumeroLote());
        } catch (InterfacesException iex) {
            UtilidadesLog.debug(iex);
            throw new MareException(iex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    /**
    * @throws MareException
    * @return void
    * @param DTOCobroBelcenter
    * @autor jquiroga
    * @documentation
        // Genera un movimiento bancario

        clienteDatosBasicosLocal = ClienteDatosBasicos.findByPrimaryKey(DTOE.oidCliente)
        cabecera = dtoE.getMovimientoCaja()

        // Obtiene el número de lote accediendo a la interfaz BAN1
        // Se crea una referencia al subsistema de interfaces
        MONGestorInterfaces gi = MONGestorInterfacesHome.create()

        // La llamada a 'obtenerInterfazInfo' retorna un objeto InterfazInfo, uno de cuyos atributos es el número de lote
        InterfazInfo info = gi.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_BAN1, DTOE.pais)

        Crea un DTOMovimientoBancario con:
        - pais = DTOE.pais
        - empresa = DTOE.oidEmpresa
        - numeroLote = info.numLote
        - importePago = DTOE.totalImporte
        - cuentaCorrienteBancaria = DTOE.oidCuentaCorriente
        - codConsultoraReal = consultora.codigoCliente
        - nombreOficina = CCCConstantes.OFICINA_BELCENTER
        - oficinaRecaudadora =
        - tipoTransaccion = DTOE.oidTipoTransaccion
        - usuarioProceso = DTOE.movimientoCaja.usuario
        - codigoError = CCCConstantes.TIPOERROR_NO_ERROR
        - oidConsultoraReal = clienteDatosBasicosLocal.oid //consultora.oid
        - estatusMovimientoTesoreria = CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO
        - codigoIdentProceso = CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO
        - oidSubacceso = DTOE.oidSubacceso
        - movimientoCaja = cabecera.numeroMovimiento

        Llamar al método IServiceCCC.generarMovimientoBEL(DTOMovimientoBancario)
    */
    private void generarMovimientoCCC(DTOCobroBelcenter dtoE) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.generarMovimientoCCC(DTOCobroBelcenter dtoE):Entrada");
        ClienteDatosBasicosLocal clienteDatosBasicosLocal = null;
        ClienteDatosBasicosLocalHome clienteDatosBasicosLocalHome = null;
        MONGestorInterfaces monGestorInterfaces = null;
        MONGestorInterfacesHome monGestorInterfacesHome = null;
        MONCuentasCorrientes monCuentasCorrientes = null;
        MONCuentasCorrientesHome monCuentasCorrientesHome = null;
        InterfazInfo info = null;
        DTOMovimientoBancario dtoMovimientoBancario = null;

        // Genera un movimiento bancario
        try {
            clienteDatosBasicosLocalHome = getClienteDatosBasicosLocalHome();
            clienteDatosBasicosLocal = clienteDatosBasicosLocalHome.findByPrimaryKey(dtoE.getOidEmpresa());
        } catch (NoResultException fex) {
            UtilidadesLog.debug(fex);
            throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Obtiene el número de lote accediendo a la interfaz BAN1 
        // Se crea una referencia al subsistema de interfaces 
        //MONGestorInterfaces gi = MONGestorInterfacesHome.create()
        try {
            monGestorInterfacesHome = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);
            monGestorInterfaces = monGestorInterfacesHome.create();
            info = monGestorInterfaces.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_BAN1, dtoE.getOidPais());

            //Crea un DTOMovimientoBancario y lo llena
            dtoMovimientoBancario = new DTOMovimientoBancario();
            dtoMovimientoBancario.setOidPais(dtoE.getOidPais());
            dtoMovimientoBancario.setEmpresa(dtoE.getOidEmpresa());
            dtoMovimientoBancario.setNumeroLote(new Long(info.getNumeroLote()));
            dtoMovimientoBancario.setImportePago(dtoE.getTotalImporte());
            dtoMovimientoBancario.setCuentaCorrienteBancaria(dtoE.getOidCuentaCorriente());
            dtoMovimientoBancario.setCodConsultoraReal(clienteDatosBasicosLocal.getCod_clie());
            dtoMovimientoBancario.setNombreOficina(CCCConstantes.OFICINA_BELCENTER);
            dtoMovimientoBancario.setOficinaRecaudadora(null);
            dtoMovimientoBancario.setTipoTransaccion(dtoE.getOidTipoTransaccion());
            dtoMovimientoBancario.setUsuarioProceso(dtoE.getMovimientoCaja().getUsuario());
            dtoMovimientoBancario.setCodError(CCCConstantes.TIPOERROR_NO_ERROR);
            dtoMovimientoBancario.setOidConsultoraReal(clienteDatosBasicosLocal.getOid());
            dtoMovimientoBancario.setEstatusMovimientoTesoreria(str2Char(CCCConstantes.MOVIMIENTO_BANCARIO_PROCESADO, 0));
            dtoMovimientoBancario.setIdentificadorProceso(CCCConstantes.MOVIMIENTO_BANCARIO_TRANSMITIDO);
            dtoMovimientoBancario.setSubacceso(dtoE.getOidSubacceso());
            dtoMovimientoBancario.setOidMovimientoCaja(dtoE.getMovimientoCaja().getOidCaja());

            monCuentasCorrientesHome = (MONCuentasCorrientesHome) UtilidadesEJB.getHome("MONCuentasCorrientes", MONCuentasCorrientesHome.class);
            monCuentasCorrientes = monCuentasCorrientesHome.create();
            monCuentasCorrientes.generarMovimientoBEL(dtoMovimientoBancario);
        } catch (InterfacesException iex) {
            UtilidadesLog.debug(iex);
            throw new MareException(iex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException rex) {
            UtilidadesLog.debug(rex);
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException cex) {
            UtilidadesLog.debug(cex);
            throw new MareException(cex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONCobrarBelcenterBean.generarMovimientoCCC(DTOCobroBelcenter dtoE):Salida");
    }


    private MONRegistroOnlineHome geMONRegistroOnlineHome() throws MareException {
        try {
            final InitialContext context = new InitialContext();
            MONRegistroOnlineHome moNRegistroOnlineHome = (MONRegistroOnlineHome) PortableRemoteObject.narrow(context.lookup("MONRegistroOnline"), MONRegistroOnlineHome.class);

            //MONRegistroOnlineHome moNRegistroOnlineHome = (MONRegistroOnlineHome) UtilidadesEJB.getLocalHome("java:comp/env/MONRegistroOnline");
            return moNRegistroOnlineHome;
        } catch (NamingException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
    }

    /* ------------ METODOS AUXILIARES ------------ */
    private Long objectToLong(Object obj) {
        if (obj != null) {
            Long result = new Long(((BigDecimal) obj).longValue());

            return result;
        } else {
            return null;
        }
    }

    private String objectToString(Object obj) {
        if (obj != null) {
            return obj.toString();
        } else {
            return null;
        }
    }

    private Integer objectToInteger(Object obj) {
        if (obj != null) {
            Integer result = new Integer((String) obj);

            return result;
        } else {
            return null;
        }
    }

    private Integer LongToInteger(Long obj) {
        if (obj != null) {
            Integer result = new Integer(obj.intValue());

            return result;
        } else {
            return null;
        }
    }

    private BigDecimal objectToBigDecimal(Object obj) {
        if (obj != null) {
            return (BigDecimal) obj;
        } else {
            return null;
        }
    }

    private Character str2Char(String str, int charPos) {
        if (str != null) {
            return new Character(str.charAt(charPos));
        } else {
            return null;
        }
    }





    public void continuarFacturacion(DTOContinuarFacturacion dto) throws MareException {
        UtilidadesLog.info("MONCobrarBelcenterBean.continuarFacturacion(DTOContinuarFacturacion dto):Entrada");
        try {
            // Continua con la facturación 
            MONProcesosFacturacion fac = this.getMONProcesosFacturacioHome().create();
            fac.continuarFacturacion(dto.getOidConsolidado(), dto.getEstado());

            //Llama al método IContinuarFacturacion.continuarFacturacion(DTOE.oidSolicitud, DTOE.estado)
        } catch (NamingException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONCobrarBelcenterBean.continuarFacturacion(DTOContinuarFacturacion dto):Salida");
    }

    /* ------------ METODOS AUXILIARES ------------ */
    
     private Entidadi18nLocalHome getEntidadi18nLocalHome()  {
         return new Entidadi18nLocalHome();
     }

     private AsociacionMaquinaCajaLocalHome getAsociacionMaquinaCajaLocalHome() {
         return new AsociacionMaquinaCajaLocalHome();
     }
     
    private CajaLocalHome getCajaLocalHome() {
        return new CajaLocalHome();
    }
     
    private ClienteDatosBasicosLocalHome getClienteDatosBasicosLocalHome() {
        return new ClienteDatosBasicosLocalHome();
    }

    private MonedaLocalHome getMonedaLocalHome() {
        return new MonedaLocalHome();
    }

    private MONProcesosFacturacionHome getMONProcesosFacturacioHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONProcesosFacturacionHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProcesosFacturacion"), MONProcesosFacturacionHome.class);
    }


    private PaisLocalHome getPaisLocalHome() {
        return new PaisLocalHome();
    }

    private ParametrosBelcenterLocalHome getParametrosBelcenterLocalHome() {
        return new ParametrosBelcenterLocalHome();
    }

    private MovimientosDeCajaCabeceraLocalHome getMovimientosDeCajaCabeceraLocalHome() {
        return new MovimientosDeCajaCabeceraLocalHome();
    }

    private MovimientosDeCajaDetalleLocalHome getMovimientosDeCajaDetalleLocalHome() {
        return new MovimientosDeCajaDetalleLocalHome();
    }

    
}
