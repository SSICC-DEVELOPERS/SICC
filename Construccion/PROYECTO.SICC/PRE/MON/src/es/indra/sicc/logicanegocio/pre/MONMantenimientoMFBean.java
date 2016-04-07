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

package es.indra.sicc.logicanegocio.pre;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.validacion.*;
import es.indra.sicc.dtos.ped.DTOTipifYUnidadAdminCliente;
import es.indra.sicc.dtos.ped.DTOTipificacion;
import es.indra.sicc.dtos.ped.applet.DTOBuscarProductosRegistro;
import es.indra.sicc.dtos.ped.applet.DTOInfoProducto;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOBuscarCodigoVentaPeriodo;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOECabeceraMF;
import es.indra.sicc.dtos.pre.DTOEConsultarMF;
import es.indra.sicc.dtos.pre.DTOECopiarMF;
import es.indra.sicc.dtos.pre.DTOEValidarCodigoVenta;
import es.indra.sicc.dtos.pre.DTOObtenerProductoRecuperacion;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProductoMatriz;
import es.indra.sicc.dtos.pre.DTOProductoReemplazo;
import es.indra.sicc.dtos.pre.DTOSValidarCodigoVenta;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocal;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.GrupoLocal;
import es.indra.sicc.entidades.pre.GrupoLocalHome;
import es.indra.sicc.entidades.pre.MatrizCodigosAternativosLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosAternativosLocalHome;
import es.indra.sicc.entidades.pre.MatrizCodigosRecuperacionLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosRecuperacionLocalHome;
import es.indra.sicc.entidades.pre.MatrizCodigosReemplazoLocal;
import es.indra.sicc.entidades.pre.MatrizCodigosReemplazoLocalHome;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocal;
import es.indra.sicc.entidades.pre.MatrizFacturacionLocalHome;
import es.indra.sicc.entidades.pre.OfertaLocal;
import es.indra.sicc.entidades.pre.OfertaLocalHome;
import es.indra.sicc.entidades.pre.PromocionLocal;
import es.indra.sicc.entidades.pre.PromocionLocalHome;
import es.indra.sicc.entidades.pre.RangosPromocionLocal;
import es.indra.sicc.entidades.pre.RangosPromocionLocalHome;
import es.indra.sicc.entidades.pre.VentaExclusivaLocal;
import es.indra.sicc.entidades.pre.VentaExclusivaLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.logicanegocio.cra.MONPeriodosHome;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.RecuperadorIdiomaDefectoServidor;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.Date;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.pre.DTOCabecCatal;

import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;

import es.indra.sicc.logicanegocio.ccc.DAOCCC;

import java.util.ArrayList;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
/**
 * MON de mantenimiento de la Matriz de Facturacion.
 * 
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia (logueo)
 */  
public class MONMantenimientoMFBean implements SessionBean {

    private SessionContext ctx;
    private final int CONSULTA_PERIODO_ACTUAL_Y_FUTURO = 0;
    private final int CONSULTA_PERIODO_ANTERIOR = 1;
    //private final Long TRUE = new Long(1);
    // vbongiov -- Cambio 20080746 -- 29/10/2008
    private static final long COD_VENTA_INICIAL = 95001;

    public void ejbCreate() {  }
    public void ejbActivate() {  }
    public void ejbPassivate() {  }
    public void ejbRemove() {   }
    
    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida buscarMFPeriodoActualYFuturo(DTOSiccPaginacion dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarMFPeriodoActualYFuturo(DTOSiccPaginacion dto): Entrada");
        
        DTOSalida dtos = new DTOSalida();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            String query = UtilidadesPaginacion.armarQueryPaginacion(this.generarConsulta(dto, this.CONSULTA_PERIODO_ACTUAL_Y_FUTURO), dto);
            rs = belcorpService.dbService.executeStaticQuery(query);
            dtos.setResultado(rs);
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            //UtilidadesLog.debug("entra por donde corresponde ");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.buscarMFPeriodoActualYFuturo(DTOSiccPaginacion dto): Salida");
        return dtos;
    }

    public DTOSalida buscarMFPeriodoAnterior(DTOSiccPaginacion dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarMFPeriodoAnterior(DTOSiccPaginacion dto): Entrada");
        
        DTOSalida dtos = new DTOSalida();
        RecordSet rs = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            String query = UtilidadesPaginacion.armarQueryPaginacion(this.generarConsulta(dto, this.CONSULTA_PERIODO_ANTERIOR), dto);

            rs = belcorpService.dbService.executeStaticQuery(query);
            dtos.setResultado(rs);
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            //UtilidadesLog.debug("entra por donde corresponde ");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.buscarMFPeriodoAnterior(DTOSiccPaginacion dto): Salida");
        return dtos;
    }

    /**
     * En primer lugar comprueba que el usuario tiene acceso al pais, marca
     * y canal recibidos como parametro. Realiza una llamada al metodo validarAcceso
     * del MONValidacion con oidPais, oidMarca y oidCanal, el resto a null.
     * Si se permite el acceso, continua con la ejecucion, caso contrario devuelve
     * una Excepcion.
     * Inserta una entrada en la entidad CabeceraMF con los parametros de entrada:
     * oidPeriodo
     * numeroPedidosEstimados
     * unidadesEstimada
     * clientesEstimados
     * valorEstimado
     * tipoCambio
     * registroEstadisticoGenerado
     * matrizFacturada
     * matrizGenerada
     */
    public DTOOID guardarCabeceraMF(DTOECabeceraMF dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.guardarCabeceraMF(DTOECabeceraMF dto): Entrada");
        
        //MONValidacion mONValidacion = null;
        CabeceraMFLocal cabeceraMFLocal = null;
        CabeceraMFLocalHome cabeceraMFLocalHome = new CabeceraMFLocalHome();        
        DTOOID dtoOID = null;
        Long oidMoneda = null;

        try {
            ConfiguracionMFPaisLocalHome configuracionMFLH = new ConfiguracionMFPaisLocalHome();
            Collection col = configuracionMFLH.findByPaisMarcaCanal(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());

            if ((col != null) && (col.size() == 0)) {
                ctx.setRollbackOnly();
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0042));
            } else {
                Iterator it = col.iterator();
                ConfiguracionMFPaisLocal configuracionMFL = (ConfiguracionMFPaisLocal) it.next();
                oidMoneda = configuracionMFL.getOidMoneda();

                if ((configuracionMFL.getOidMoneda() != null) && (dto.getTipoCambioPromedioPeriodo() == null)) {
                    ctx.setRollbackOnly();
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0045));
                }
            }
        } catch (NoResultException  e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception fx) {
            if (fx instanceof MareException) {
                throw (MareException) fx;
            }

            UtilidadesLog.error(fx);
            throw new MareException(fx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        //Crear entity
        try {
            cabeceraMFLocal = cabeceraMFLocalHome.create(dto.getOidPeriodo(), dto.getNumeroPedidosEstimado(), dto.getUnidadesEstimadas(), dto.getClientesEstimados(), dto.getTotalMontoVentaNeta());

            if (dto.getTipoCambioPromedioPeriodo() != null) {
                cabeceraMFLocal.setTipoCambio(dto.getTipoCambioPromedioPeriodo());                
            }
            
        } catch (PersistenceException  e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
        } 

        cabeceraMFLocal.setMoneda(oidMoneda);
        cabeceraMFLocal.setRegistroEstadisticoGenerado(dto.getRegistroEstadisticoGenerado());
        cabeceraMFLocal.setMatrizFacturada(dto.getMatrizFacturada());
        cabeceraMFLocal.setMatrizGenerada(dto.getMatrizGenerada());
        cabeceraMFLocalHome.merge(cabeceraMFLocal);

        //Preparar el DTO de retorno
        dtoOID = new DTOOID();
        dtoOID.setOid(cabeceraMFLocal.getOid());
        
        UtilidadesLog.info("MONMantenimientoMFBean.guardarCabeceraMF(DTOECabeceraMF dto): Salida");
        return dtoOID;
    }

    // ***************************************************************************
    // METODOS DE SERVICIO
    // ***************************************************************************

    /**
     * Arma la consulta a usarse en los metodos buscarMFPeriodoActualYFuturo
     * y buscarMFPeriodoAnterior.
     * El primer parametro es el mismo DTO que reciben los metodos antes mecionados.
     * El segundo parametro es un flag que indica si la consulta es para
     * buscarMFPeriodoActualYFuturo o para buscarMFPeriodoAnterior. Los valores
     * admitidos para este son:
     * CONSULTA_PERIODO_ACTUAL_Y_FUTURO y
     * CONSULTA_PERIODO_ANTERIOR.
     */
    private String generarConsulta(DTOSiccPaginacion dto, int tipoConsulta) {
        UtilidadesLog.info("MONMantenimientoMFBean.generarConsulta(DTOSiccPaginacion dto, int tipoConsulta): Entrada");
        
        StringBuffer query = new StringBuffer();
        Date today = new Date(System.currentTimeMillis());
        String user = ctx.getCallerPrincipal().getName();

        //user = "usuariopre"; //hardCode
        query.append("SELECT PRE_MATRI_FACTU_CABEC.OID_CABE OID, i.VAL_I18N PAIS, SEG_MARCA.DES_MARC, i3.VAL_I18N CANAL, CRA_PERIO.VAL_NOMB_PERI, CRA_PERIO.FEC_INIC ");
        query.append("FROM PRE_MATRI_FACTU_CABEC, CRA_PERIO, V_GEN_I18N_SICC i, V_GEN_I18N_SICC i3, SEG_MARCA ");
        query.append("WHERE   PRE_MATRI_FACTU_CABEC.PERD_OID_PERI = CRA_PERIO.OID_PERI AND");
        query.append("        i.ATTR_ENTI = 'SEG_PAIS' AND");
        query.append("        i.IDIO_OID_IDIO = ").append(dto.getOidIdioma().toString()).append(" AND");
        query.append("        i.VAL_OID = ").append(dto.getOidPais().toString()).append(" AND");

        //Modificado por jrivas 04/12/2004
        //falta filtrar por pais
        //PD: Esta con like porque sino tira un error
        query.append("        cra_perio.PAIS_OID_PAIS like ").append(dto.getOidPais().toString()).append(" AND");

        //----Fin Cambio---
        query.append("        i3.ATTR_ENTI = 'SEG_CANAL' AND");
        query.append("        i3.IDIO_OID_IDIO = ").append(dto.getOidIdioma()).append(" AND");
        query.append("        i3.VAL_OID = CRA_PERIO.CANA_OID_CANA AND ");

        if (tipoConsulta == this.CONSULTA_PERIODO_ACTUAL_Y_FUTURO) {
            query.append("        CRA_PERIO.FEC_FINA >= TO_DATE('").append(today.toString()).append("', 'YYYY-MM-DD') AND");
        } else if (tipoConsulta == this.CONSULTA_PERIODO_ANTERIOR) {
            query.append("        CRA_PERIO.FEC_FINA < TO_DATE('").append(today.toString()).append("', 'YYYY-MM-DD') AND");
        }

        query.append("        CRA_PERIO.PAIS_OID_PAIS IN (");
        query.append("                                    SELECT OID_PAIS");
        query.append("                                    FROM VCA_SEG_PAIS");

        query.append("                                    WHERE COD_USUA ='").append(user).append("' ) AND");

        //query.append( "                                    WHERE  COD_USUA = 'usuariopre') AND" ); //hard code de usuario para pruebas
        query.append("        SEG_MARCA.OID_MARC = CRA_PERIO.MARC_OID_MARC AND");
        query.append("        SEG_MARCA.OID_MARC      IN (");
        query.append("                                    SELECT OID_MARC");
        query.append("                                    FROM VCA_SEG_MARCA");

        query.append("                                    WHERE COD_USUA = '").append(user).append("' ) AND");

        //query.append( "                                    WHERE  COD_USUA = upper('usuariopre') AND" ); //hard code de usuario para pruebas
        query.append("        CRA_PERIO.CANA_OID_CANA IN (");
        query.append("                                    SELECT OID_CANA");
        query.append("                                    FROM VCA_SEG_CANAL");

        query.append("                                    WHERE COD_USUA = '").append(user).append("' )");

        //query.append( "                                    WHERE  COD_USUA = 'usuariopre')" ); //hard code de usuario para pruebas
        //UtilidadesLog.debug("query: " + query.toString());

        UtilidadesLog.info("MONMantenimientoMFBean.generarConsulta(DTOSiccPaginacion dto, int tipoConsulta): Salida");
        return query.toString();
    }
/**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * pperanzola 16/09/2005 se cambia para que filtre por estrategia segun diseño de CUV
     * gdmarzi 13/11/2006 in situ incidencia V-PRE-14 retorna oid oculto y paso la logica a la query.
     */
    public DTOSalida consultarMF(DTOEConsultarMF dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.consultarMF(DTOEConsultarMF dto): Entrada");
        
        try {
            DTOSalida resu = new DTOSalida();
            //RecordSet rec = new RecordSet();

            StringBuffer query = new StringBuffer();
            query.append(" select ");
                query.append(" detalleOferta.OID_DETA_OFER OID, ");
                query.append(" i5.VAL_I18N descEstrategia, ");
                query.append(" detalleOferta.VAL_CODI_VENT, ");
                query.append(" producto.COD_SAP codigoSAP, ");
                query.append(" i1.VAL_I18N descripcionSAP, ");
                query.append(" DECODE(detalleOferta.IND_PROD_PRIN,1,'S','N') productoPrincipal, ");
                query.append(" DECODE(detalleOferta.IND_PROD_PRIN,1,'N','S') productoAsociado, ");
                query.append(" grupoOferta.NUM_GRUP numeroGrupo, ");
                query.append(" i2.VAL_I18N descripcionTipoOferta, ");
                query.append(" i4.VAL_I18N descripcionCicloVida, ");
                query.append(" detalleOferta.IMP_PREC_CATA precioCatalogo, ");
                query.append(" detalleOferta.VAL_FACT_REPE factorRepeticion, ");
                query.append(" (detalleOferta.VAL_FACT_REPE * detalleOferta.IMP_PREC_CATA) valorTotal, ");
                query.append(" DECODE(tipoOferta.IND_COMI,1,'S','N') comisionable, ");
                query.append(" DECODE(tipoOferta.IND_ESTA,1,'S','N') estadisticable, ");
                query.append(" detalleOferta.NUM_UNID_ESTI unidadesEstimadas, ");
                query.append(" DECODE (ventaexclusiva.oid_vent_excl, (null), 'N', 'S') ventaexclusiva, ");
                query.append(" DECODE(detalleOferta.IND_DIGI,1,'S','N') digitable, ");
                query.append(" i3.VAL_I18N descripcionFormaPago ");
            query.append(" from  ");
                query.append(" pre_ofert oferta, "); //[1]
                query.append(" PRE_ESTRA estrat, ");//[1]
                query.append(" pre_matri_factu MF,  ");
                query.append(" mae_produ producto, ");
                query.append(" pre_ofert_detal detalleOferta,	  ");
                query.append(" pre_grupo_ofert grupoOferta, ");
                query.append(" pre_tipo_ofert tipoOferta, ");
                query.append(" pre_venta_exclu ventaExclusiva, ");
                query.append(" v_gen_i18n_sicc i1, ");
                query.append(" v_gen_i18n_sicc i2,	 ");
                query.append(" v_gen_i18n_sicc i3, ");
                query.append(" v_gen_i18n_sicc i4, ");
                query.append(" v_gen_i18n_sicc i5 ");
            query.append(" where ");
                query.append(" MF.MFCA_OID_CABE = " + dto.getOidCabeceraMF() + " ");
                query.append(" and MF.OFDE_OID_DETA_OFER = detalleOferta.OID_DETA_OFER ");
                query.append(" and producto.OID_PROD = detalleOferta.PROD_OID_PROD ");
    
                if ((dto.getCodigoVenta() != null) && !(dto.getCodigoVenta().equals(""))) {
                    UtilidadesLog.info("entro al codigo de venta");
                    query.append(" and detalleOferta.VAL_CODI_VENT LIKE  '" + dto.getCodigoVenta() + "' ");
                }
    
                if ((dto.getCodigoProducto() != null) && !(dto.getCodigoProducto().equals(""))) {
                    UtilidadesLog.info("entro a codigo de producto");
                    query.append(" and producto.COD_SAP LIKE  '" + dto.getCodigoProducto() + "'  ");
                }
    
                if ((dto.getOidTipoOferta() != null)) {
                    UtilidadesLog.info("entro a tipo oferta");
                    query.append(" and detalleOferta.TOFE_OID_TIPO_OFER = " + dto.getOidTipoOferta() + "  ");
                }
    
                if ((dto.getDescripcionProducto() != null) && !(dto.getDescripcionProducto().equals(""))) {
                    UtilidadesLog.info("entro a val i18 n");
                    query.append(" and i1.VAL_I18N LIKE  '" + dto.getDescripcionProducto() + "'  ");
                }
                
                 // /* [1]
                if (dto.getOidsEstrategia()!=null && !(dto.getOidsEstrategia().equals(""))){
                     query.append(" and estrat.OID_ESTR in ("+  dto.getOidsEstrategia() +") ");
                     
                }
                query.append(" and oferta.OID_OFER = detalleoferta.OFER_OID_OFER ");
                query.append(" and oferta.COES_OID_ESTR = estrat.OID_ESTR ");
                // */ [1]
                query.append(" and detalleOferta.GOFE_OID_GRUP_OFER = grupoOferta.OID_GRUP_OFER(+)  ");
                query.append(" and detalleOferta.TOFE_OID_TIPO_OFER = tipoOferta.OID_TIPO_OFER  ");
                query.append(" and detalleOferta.OFER_OID_OFER = ventaExclusiva.OFER_OID_OFER(+)  ");
                query.append(" and i1.IDIO_OID_IDIO =  " + dto.getOidIdioma() + " ");
                query.append(" and i1.ATTR_NUM_ATRI = '1'  ");
                query.append(" and i1.ATTR_ENTI = 'MAE_PRODU' ");
                query.append(" and i1.VAL_OID = detalleOferta.PROD_OID_PROD ");
                query.append(" and i2.IDIO_OID_IDIO =  " + dto.getOidIdioma() + " ");
                query.append(" and i2.ATTR_NUM_ATRI = '1'  ");
                query.append(" and i2.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
                query.append(" and i2.VAL_OID = detalleOferta.TOFE_OID_TIPO_OFER ");
                query.append(" and i3.IDIO_OID_IDIO(+) =  " + dto.getOidIdioma() + " ");
                query.append(" and i3.ATTR_NUM_ATRI(+) = '1' ");
                query.append(" and i3.ATTR_ENTI(+) = 'BEL_FORMA_PAGO' ");
                query.append(" and i3.VAL_OID(+) = detalleOferta.FOPA_OID_FORM_PAGO ");
                query.append(" and i4.IDIO_OID_IDIO =  " + dto.getOidIdioma() + " ");
                query.append(" and i4.ATTR_NUM_ATRI = '1' ");
                query.append(" and i4.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
                query.append(" and i4.VAL_OID = detalleOferta.CIVI_OID_CICLO_VIDA ");
                ///* [1]
                query.append(" AND i5.idio_oid_idio = "+ dto.getOidIdioma() + " ");
                query.append(" AND i5.attr_num_atri = '1' ");
                query.append(" AND i5.attr_enti = 'PRE_ESTRA' ");
                query.append(" AND i5.val_oid = estrat.OID_ESTR ");
                //*/ [1]

            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto));
            resu.setResultado(rs);
            UtilidadesLog.info("MONMantenimientoMFBean.consultarMF(DTOEConsultarMF dto): Salida");
            return resu;
            
        } catch (MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }


    //---------------------------------------------------------------------------------------------
    /**
     * 
     * @date 02-03-2004
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * El oid del dto se corresponde con un oid de cabecera matriz facturacion entidad pre_matri_factu_cabec 
     * 19/09/2005 - pperanzola - se modifica segun diseño de codigo unico de venta
     * 12/10/2005 - pperanzola - [2] se modifica según incidencia BELC300021196
     * 21/10/2005 - pperanzola - [3] se modifica porque los valores pueden llegar a ser nulos
     * 26/10/2005 - pperanzola - [4] se modifica segun DT PRE 2 
     * 21/02/2006 - enozigli - [5] incidencia SC-PRE-02-1
     */
    
    public void crearMF(DTOCabecCatal dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.crearMF(DTOOID dto): Entrada");
        
        Collection ofertas;
        boolean seGeneroAlgo = false;
        Long oidCatalogo = dto.getOidCatalogo();
        BigDecimal tmpPrecioCatal; //[4]
        int tmpFactorRepe;//[4]        

        try {
            OfertaLocalHome ofertaHome = new OfertaLocalHome();
           
            //busco aquellas que no estan generadas pasandole como segundo parametro 0   
            //ahora se busca solo por oid
            ofertas = ofertaHome.findByOidCabe(dto.getOidCabecera());
               //ofertaHome.findByMFGenerada(dto.getOidCabecera(), new Long(0));
            Iterator iteratorOfer = ofertas.iterator();
            //UtilidadesLog.info("Antes del while" + ofertas.size());
            while (iteratorOfer.hasNext()) {
                OfertaLocal ofertaLocal = (OfertaLocal) iteratorOfer.next();
                // /*[3]
                if (oidCatalogo !=null &&  !oidCatalogo.equals(ofertaLocal.getOidCatalogo())) {
                    continue;
                } else if (oidCatalogo ==null) {
                 
                }
                // */[3]
                DetalleOfertaLocalHome detalleOfertaLocalHome = new DetalleOfertaLocalHome();
                Collection detalles = null;
                detalles = detalleOfertaLocalHome.findByCodigoVentaMFNoGenerada(ofertaLocal.getOid());

                Iterator iteratorDet = detalles.iterator();

                DAOCCC dao = new DAOCCC();
                int numDe = dao.obtenerNumDeci(dto.getOidPais()); 
                
                // Iterator iterator = null;
                //UtilidadesLog.info("Entro a buscarDetalles, antes del while");
                while (iteratorDet.hasNext()) {
                    DetalleOfertaLocal detalleOfertaLocal = (DetalleOfertaLocal) iteratorDet.next();
                    
                    //UtilidadesLog.debug("oidDetalle = " + detalleOfertaLocal.getOid());
                    MatrizFacturacionLocalHome matrizFLHome = new MatrizFacturacionLocalHome();
                    MatrizFacturacionLocal matrizFL = null;
                    try {
                        matrizFL = matrizFLHome.findByUK(ofertaLocal.getOidCabe(), detalleOfertaLocal.getOid());
                    } catch (NoResultException fe) {
                        matrizFL = matrizFLHome.create(ofertaLocal.getOidCabe(), detalleOfertaLocal.getOid());
                    }
                    matrizFL.setEstado(Boolean.valueOf(true));
                    detalleOfertaLocal.setMatrizGenerada(Boolean.valueOf(true));
                    ///*[4]
                    if (detalleOfertaLocal.getPrecioCatalogo() != null && detalleOfertaLocal.getFactorRepeticion()!=null){
                         tmpPrecioCatal = detalleOfertaLocal.getPrecioCatalogo();
                        tmpFactorRepe = detalleOfertaLocal.getFactorRepeticion().intValue();
                        /*[5] cambio enozigli 21/02/2006 incidencia SC-PRE-02-1*/
                        if (tmpFactorRepe != 0){
                            BigDecimal divis = new BigDecimal(tmpFactorRepe);
                            BigDecimal res = tmpPrecioCatal.divide(divis,numDe,BigDecimal.ROUND_DOWN);
                            detalleOfertaLocal.setPrecioUnitario(res);
                        } else {
                            detalleOfertaLocal.setPrecioUnitario(tmpPrecioCatal);
                        }
                        /*[5] fin cambio enozigli 21/02/2006 incidencia SC-PRE-02-1*/
                    }
                    // */ [4]
                    // /* [2]
                    matrizFL.setProgramaFidelizacion(detalleOfertaLocal.getProgramaFidelizacion());
                    matrizFL.setPuntajeFijo(detalleOfertaLocal.getPuntajeFijo());
                    matrizFL.setVariante(detalleOfertaLocal.getVariante());
                    detalleOfertaLocalHome.merge(detalleOfertaLocal);
                    matrizFLHome.merge(matrizFL);
                    // */ [2]
                    seGeneroAlgo = true;
                }

                if (detalles.size() > 0) {
                    ofertaLocal.setMatrizFacturacionGenerada(Boolean.valueOf(true));
                    ofertaHome.merge(ofertaLocal);
                }
            }

            if (seGeneroAlgo) {
                CabeceraMFLocalHome cabeHome = new CabeceraMFLocalHome();
                cabeHome.findByPrimaryKey(dto.getOidCabecera()).setMatrizGenerada(Boolean.valueOf(true));
            }
            
        } catch (NoResultException fe) {
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
            ctx.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException ex) {
            ctx.setRollbackOnly();
            throw ex;
        }
        UtilidadesLog.info("MONMantenimientoMFBean.crearMF(DTOOID dto): Salida");
    }

    //Método eliminarMF
    //Recibe: 
    //devuelve: nada
    //Creado: 02-03-2004
    public void eliminarMF(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.eliminarMF(DTOOID dto): Entrada");
        
        try {
            CabeceraMFLocalHome cabeHome = new CabeceraMFLocalHome();
            CabeceraMFLocal cabecera = cabeHome.findByPrimaryKey(dto.getOid());

            if (cabecera.getMatrizFacturada() == null || !cabecera.getMatrizFacturada().booleanValue()) {
                Collection entradas;
                MatrizFacturacionLocalHome mFactura = new MatrizFacturacionLocalHome();
                entradas = mFactura.findByOidCabecera(dto.getOid());
                borrarMatricesAltRecupReemp(entradas);                
                Iterator iterator = entradas.iterator();
                while (iterator.hasNext()) {
                    mFactura.remove((MatrizFacturacionLocal) iterator.next());
                }                

                OfertaLocalHome ofertaLocalHome = new OfertaLocalHome();
                Collection ofertas = ofertaLocalHome.findByOidCabe(dto.getOid());
                Iterator it = ofertas.iterator();
                DetalleOfertaLocalHome detOfertHome = new DetalleOfertaLocalHome();

                while (it.hasNext()) {
                    OfertaLocal oferLocal = (OfertaLocal) it.next();
                    oferLocal.setMatrizFacturacionGenerada(Boolean.FALSE);
                    ofertaLocalHome.merge(oferLocal);
                    Collection detal = detOfertHome.findByOidOfer(oferLocal.getOid());
                    Iterator itd = detal.iterator();

                    while (itd.hasNext()) {
                        DetalleOfertaLocal dol = (DetalleOfertaLocal) itd.next();
                        dol.setMatrizGenerada(Boolean.FALSE);
                        detOfertHome.merge(dol);
                    }
                }

                cabecera.setMatrizGenerada(Boolean.valueOf(false));
                cabeHome.merge(cabecera);
            } else {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0022));
            }
            
        } catch (NoResultException fe) {
            ctx.setRollbackOnly();
            fe.printStackTrace();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException Re) {
            ctx.setRollbackOnly();
            throw new MareException(Re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        } 
        UtilidadesLog.info("MONMantenimientoMFBean.eliminarMF(DTOOID dto): Salida");
    }

    private void borrarMatricesAltRecupReemp(Collection oids) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.borrarMatricesAltRecupReemp(Collection oids): Entrada");
        
        try {
            Iterator it = oids.iterator();

            while (it.hasNext()) {
                MatrizFacturacionLocal matri = (MatrizFacturacionLocal) it.next();

                MatrizCodigosAternativosLocalHome codAltenativosH = new MatrizCodigosAternativosLocalHome();
                MatrizCodigosRecuperacionLocalHome codRecuperacionH = new MatrizCodigosRecuperacionLocalHome();
                MatrizCodigosReemplazoLocalHome codMatrizReemplazoH = new MatrizCodigosReemplazoLocalHome();

                /*------------------------- borro codigos alternativos ppal ----------------------*/
                try {
                    Vector codAlterna = new Vector(codAltenativosH.findByOidPpal(matri.getOid()));
                    MatrizCodigosAternativosLocal codMatrizAltenativosL = null;

                    for (int i = 0; i < codAlterna.size(); i++) {
                        codMatrizAltenativosL = (MatrizCodigosAternativosLocal) codAlterna.get(i);
                        codAltenativosH.remove(codMatrizAltenativosL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }

                /*------------------------- borro codigos alternativos alt ----------------------*/
                try {
                    Vector codAlterna = new Vector(codAltenativosH.findByOidAlte(matri.getOid()));
                    MatrizCodigosAternativosLocal codMatrizAltenativosL = null;

                    for (int i = 0; i < codAlterna.size(); i++) {
                        codMatrizAltenativosL = (MatrizCodigosAternativosLocal) codAlterna.get(i);
                        codAltenativosH.remove(codMatrizAltenativosL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }

                /*------------------------------- borro codigos de recuperacion ppal  ------------------*/
                try {
                    Vector codRecuperacion = new Vector(codRecuperacionH.findByOidPpal(matri.getOid()));
                    MatrizCodigosRecuperacionLocal codMatrizRecuperacionL = null;

                    for (int i = 0; i < codRecuperacion.size(); i++) {
                        codMatrizRecuperacionL = (MatrizCodigosRecuperacionLocal) codRecuperacion.get(i);
                        codRecuperacionH.remove(codMatrizRecuperacionL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }

                /*------------------------------- borro codigos de recuperacion oiderecu  ------------------*/
                try {
                    Vector codRecuperacion = new Vector(codRecuperacionH.findByOidRecu((matri.getOid())));
                    MatrizCodigosRecuperacionLocal codMatrizRecuperacionL = null;

                    for (int i = 0; i < codRecuperacion.size(); i++) {
                        codMatrizRecuperacionL = (MatrizCodigosRecuperacionLocal) codRecuperacion.get(i);
                        codRecuperacionH.remove(codMatrizRecuperacionL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }

                /*------------------------------ borro matriz de reemplazo ppal----------------*/
                try {
                    Vector codReemplazo = new Vector(codMatrizReemplazoH.findByOidPpal(matri.getOid()));
                    MatrizCodigosReemplazoLocal codMatrizReemplazoL = null;

                    for (int i = 0; i < codReemplazo.size(); i++) {
                        codMatrizReemplazoL = (MatrizCodigosReemplazoLocal) codReemplazo.get(i);
                        codMatrizReemplazoH.remove(codMatrizReemplazoL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }

                /*------------------------------ borro matriz de reemplazo cod reemplazo----------------*/
                try {
                    Vector codReemplazo = new Vector(codMatrizReemplazoH.findByOidReemp((matri.getOid())));
                    MatrizCodigosReemplazoLocal codMatrizReemplazoL = null;

                    for (int i = 0; i < codReemplazo.size(); i++) {
                        codMatrizReemplazoL = (MatrizCodigosReemplazoLocal) codReemplazo.get(i);
                        codMatrizReemplazoH.remove(codMatrizReemplazoL);
                    }
                } catch (NoResultException e) {
                    //No habia. OK.
                }
            }
            
        } catch (PersistenceException Ne) {
            ctx.setRollbackOnly();
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }      
        UtilidadesLog.info("MONMantenimientoMFBean.borrarMatricesAltRecupReemp(Collection oids): Salida");
    }

    public void eliminarMatrizYOfertas(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.eliminarMatrizYOfertas(DTOOID dto): Entrada");
        
        Collection ofertas;        

        try {
            eliminarMF(dto);

            CabeceraMFLocalHome cabeceras = new CabeceraMFLocalHome();
            OfertaLocalHome ofertaHome = new OfertaLocalHome();
            ofertas = ofertaHome.findByOidCabe(dto.getOid());

            Iterator iterator = ofertas.iterator();

            while (iterator.hasNext()) {
                OfertaLocal ofertaLocal = (OfertaLocal) iterator.next();
                DetalleOfertaLocalHome detOfertHome = new DetalleOfertaLocalHome();
                VentaExclusivaLocalHome ventaExclusiva = new VentaExclusivaLocalHome();
                GrupoLocalHome grupo = new GrupoLocalHome();
                PromocionLocalHome promocionHome = new PromocionLocalHome();

                Collection promociones = promocionHome.findByOidOferta(ofertaLocal.getOid());
                Iterator iterator2 = promociones.iterator();

                while (iterator2.hasNext()) {
                    PromocionLocal promoLocal = (PromocionLocal) iterator2.next();
                    RangosPromocionLocalHome rangosPromo = new RangosPromocionLocalHome();                    
                    Iterator iteratorRP =  rangosPromo.findByOidPromo(promoLocal.getOid()).iterator();
                    while (iteratorRP.hasNext()){
                        rangosPromo.remove((RangosPromocionLocal)iteratorRP.next());
                    }
                }

                Iterator iteratorPR = promociones.iterator();
                while (iteratorPR.hasNext()){
                    promocionHome.remove((PromocionLocal)iteratorPR.next());
                }
                Iterator iteratorDO = detOfertHome.findByOidOfer(ofertaLocal.getOid()).iterator();
                while (iteratorDO.hasNext()){
                    detOfertHome.remove((DetalleOfertaLocal)iteratorDO.next());
                } 
                Iterator iteratorGR = grupo.findByOidOferta(ofertaLocal.getOid()).iterator();
                while (iteratorGR.hasNext()){
                    grupo.remove((GrupoLocal)iteratorGR.next());
                }                 
                Iterator iteratorVE = ventaExclusiva.findByOidOferta(ofertaLocal.getOid()).iterator();
                while (iteratorVE.hasNext()){
                    ventaExclusiva.remove((VentaExclusivaLocal)iteratorVE.next());
                }                
            }

            Iterator iteratorOF = ofertas.iterator();
            while (iteratorOF.hasNext()){
                ofertaHome.remove((OfertaLocal)iteratorOF.next());
            }

            CabeceraMFLocal cabecera = cabeceras.findByPrimaryKey(dto.getOid());
            cabeceras.remove(cabecera);
            
        } catch (NoResultException fe) {
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoMFBean.eliminarMatrizYOfertas(DTOOID dto): Salida");
    }

    /**
     * @author Maximiliano Dello Russo	 
     * @date 15/03/04
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * pperanzola - 03/11/2005 - [1] se modifica según peer review inc=BELC300021579
     */
    public void copiarMF(DTOECopiarMF dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.copiarMF(DTOECopiarMF dto): Entrada");
        
        try {
            // vbongiov -- Cambio 20080746 -- 29/10/2008
            long codVentaOrdenado = COD_VENTA_INICIAL;
            long codVentaOrdenadoInicialOfer = 0;
            PREConsultas preConsultas = new PREConsultas();
            Boolean oidCabeYaExiste = Boolean.FALSE;
            HashMap oidEstrategias = new HashMap();
            Integer numOferta = null;
            Integer numOfertaUltimo = null;
            
            UtilidadesLog.debug("dto: " + dto);  
                        
            OfertaLocalHome ofertaHome = new OfertaLocalHome();

            Collection ofertas = ofertaHome.findByOidCabe(dto.getOidNueva());

             // Validaciones si la matriz ya existe
             if (!ofertas.isEmpty()) {
                 // vbongiov -- Cambio 20080794 -- 16/12/2008
                 if(dto.getCodigoProgramaFidelizacion()== null && dto.getVariante()==null && dto.getOidTipoOferta()== null) {
                     //No existen ofertas generadas en la cabecera destino
                     throw new MareException( null
                                             ,null
                                             ,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE
                                                                               , ""
                                                                               , ErroresNegocio.PRE_0053));
                 }
                 
                 // vbongiov -- Cambio 20080794 -- 16/12/2008
                 if(preConsultas.hayOfertasYaCopiadas(dto.getOidNueva(), dto.getCodigoProgramaFidelizacion(), 
                                                      dto.getVariante(), dto.getOidTipoOferta())) {
                                                      
                     throw new MareException( null
                                             ,null
                                             ,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE
                                                                               , ""
                                                                               , ErroresNegocio.PRE_0019));                                                     
                 } else {
                     if(dto.getIndOrdenarCodVenta().booleanValue()){
                         codVentaOrdenado = preConsultas.ultimoCodVentaMatrizFacturacion(dto.getOidNueva());
                     }
                     
                     oidCabeYaExiste = Boolean.TRUE;
                 }
             }

            ofertas.clear();
            
            UtilidadesLog.debug("codVentaOrdenado: " + codVentaOrdenado);
            
            // vbongiov -- Cambio 20080746 -- 29/10/2008
            if(dto.getCodigoProgramaFidelizacion()!= null && dto.getIndOrdenarCodVenta().booleanValue()) {
               ofertas = ofertaHome.findByOidCabeOrde(dto.getOidOrigen());
            } else {
               ofertas = ofertaHome.findByOidCabe(dto.getOidOrigen());
            }
           
            if (ofertas.isEmpty()) {
                //No hay ofertas para copiar
                throw new MareException(null
                                        , null
                                        , UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE
                                                                            , ""
                                                                            , ErroresNegocio.PRE_0043));
            }

            Iterator itOfertas = ofertas.iterator();
            OfertaLocal oferta = null;
            OfertaLocal ofertaNueva = null;
            
            boolean clubPrivNoIngresados = false;
            if (dto.getCodigoProgramaFidelizacion()==null&&
                dto.getVariante()==null){
                  //UtilidadesLog.debug("Copia sin criterios de priviledges.");
                  clubPrivNoIngresados = true;//si no elige en pantalla van todas.
                }

            while (itOfertas.hasNext()) {
                oferta = (OfertaLocal) itOfertas.next();
                
                UtilidadesLog.debug("oferta a evaluar: " + oferta.getOid());    
                                
                // vbongiov -- Cambio 20080746 -- 20/11/2008
                if(dto.getOidTipoOferta()== null || (dto.getOidTipoOferta()!= null && preConsultas.tieneDetallesTipoOferta(oferta.getOid(), dto.getOidTipoOferta()))) {            
                 
                    if (clubPrivNoIngresados||(incluirOfertaEnMatriz(oferta.getOid(),
                        dto.getCodigoProgramaFidelizacion(),dto.getVariante())))
                        {      
                          UtilidadesLog.debug("oferta a copiar: " + oferta.getOid());  
                        
                          // vbongiov -- Cambio 20080746 -- 29/10/2008
                          codVentaOrdenadoInicialOfer = codVentaOrdenado;
                          
                          // vbongiov -- Cambio 20080794 -- 16/12/2008
                          if(oidCabeYaExiste.booleanValue()){
                          
                              if(oidEstrategias.get(oferta.getOidEstr())!=null){                              
                                    numOfertaUltimo = (Integer)oidEstrategias.get(oferta.getOidEstr());
                                    numOferta = new Integer(numOfertaUltimo.intValue() + 1);
                                    oidEstrategias.put(oferta.getOidEstr(), numOferta);
                                    
                              } else {
                                  numOfertaUltimo = preConsultas.obtenerUltimoNumeroOferta(dto.getOidNueva(), oferta.getOidEstr());
                                  numOferta = new Integer(numOfertaUltimo.intValue() + 1);
                                  oidEstrategias.put(oferta.getOidEstr(), numOferta);
                              }
                              
                          } else {
                              numOferta = oferta.getNumeroOferta();
                          }
                          
                          UtilidadesLog.debug("numOferta: " + numOferta);    
                          
                          ofertaNueva = ofertaHome.create(oferta.getOidEstr()
                                                          , numOferta
                                                          , oferta.getOidArguVent()
                                                          , dto.getOidNueva()
                                                          , oferta.getOidCatalogo());
                          ofertaNueva.setCodigoVentaGenerado(oferta.getCodigoVentaGenerado());
                          ofertaNueva.setCondicionCondicionados(oferta.getCondicionCondicionados());
                          ofertaNueva.setCondicionCondicionantes(oferta.getCondicionCondicionantes());
                          ofertaNueva.setDespachoAutomatico(oferta.getDespachoAutomatico());
                          ofertaNueva.setDespachoCompleto(oferta.getDespachoCompleto());
                          ofertaNueva.setMatrizFacturacionGenerada(oferta.getMatrizFacturacionGenerada());
                          ofertaNueva.setNumeroGrupos(oferta.getNumeroGrupos());
                          ofertaNueva.setNumeroGruposCondicionados(oferta.getNumeroGruposCondicionados());
                          ofertaNueva.setNumeroGruposCondicionantes(oferta.getNumeroGruposCondicionantes());
                          ofertaNueva.setNumeroOrden(oferta.getNumeroOrden());
                          ofertaNueva.setNumeroPaquetes(oferta.getNumeroPaquetes());
                          ofertaNueva.setOidAcceso(oferta.getOidAcceso());
                          ofertaNueva.setOidFormPago(oferta.getOidFormPago());
                          ofertaNueva.setOidSbac(oferta.getOidSbac());
                          ofertaNueva.setPrimeraPosicionRanking(oferta.getPrimeraPosicionRanking());
                          ofertaNueva.setRecuperacionObligatoria(oferta.getRecuperacionObligatoria());
                          ofertaNueva.setRegistroEstadisticoGenerado(oferta.getRegistroEstadisticoGenerado());
                          ofertaNueva.setUltimaPosicionRanking(oferta.getUltimaPosicionRanking());
                          ofertaHome.merge(ofertaNueva);
          
                          // Obtengo el OID de la nueva oferta.
                          Long oidNuevaOferta = ofertaNueva.getOid();
          
                          GrupoLocalHome grupoHome = new GrupoLocalHome();
                          Collection grupos = grupoHome.findByOidOferta(oferta.getOid());
                          Iterator itGrupos = grupos.iterator();
                          GrupoLocal grupo = null;
                          GrupoLocal grupoNuevo = null;                      
          
                          while (itGrupos.hasNext()) {
                              grupo = (GrupoLocal) itGrupos.next();
                              
                              UtilidadesLog.debug("grupo a copiar: " + grupo.getOid());   
          
                              grupoNuevo = grupoHome.create(ofertaNueva.getOid()
                                                            , grupo.getNumeroGrupo()
                                                            , grupo.getIndicadorGrupo());
                              grupoNuevo.setCondicionado(grupo.getCondicionado());
                              grupoNuevo.setCondicionante(grupo.getCondicionante());
                              grupoNuevo.setFactorCuadre(grupo.getFactorCuadre());
                              grupoNuevo.setOidIndCuadTipoEstr(grupo.getOidIndCuadTipoEstr());
                              grupoHome.merge(grupoNuevo);
          
                              // Obtengo el OID del nuevo grupo
                              Long oidNuevoGrupo = grupoNuevo.getOid();
          
                              DetalleOfertaLocalHome detalleOferHome = new DetalleOfertaLocalHome();
                              
                              // vbongiov -- Cambio 20080746 -- 29/10/2008
                              Collection detalles = null;
                              if(dto.getCodigoProgramaFidelizacion()!= null && dto.getIndOrdenarCodVenta().booleanValue()) {
                                    detalles = detalleOferHome.findByOidOferOrde(oferta.getOid());
                              } else {
                                    detalles = detalleOferHome.findByOidOfer(oferta.getOid());
                              }                          
                              
                              Iterator itDetalles = detalles.iterator();
                              DetalleOfertaLocal detalle = null;
                              DetalleOfertaLocal detalleNuevo = null;
          
                              //detalleOferHome.parametrosAuditoria(dto);
                              while (itDetalles.hasNext()) {
                                  detalle = (DetalleOfertaLocal) itDetalles.next();
                                  
                                  UtilidadesLog.debug("detalle grupo: " + detalle.getOid());       
          
                                  if ((detalle.getOidGrupOfer() != null) 
                                          && (detalle.getOidGrupOfer().longValue() == grupo.getOid().longValue())) {
                                          
                                      UtilidadesLog.debug("detalle grupo a copiar: " + detalle.getOid());                                        
                                                     
                                      detalleNuevo = detalleOferHome.create(oidNuevaOferta
                                                                            , detalle.getOidProd()
                                                                            , detalle.getLineaOferta()
                                                                            , detalle.getFactorRepeticion()
                                                                            , detalle.getOidTipoOfer()
                                                                            , detalle.getOidCicloVida()
                                                                            , oidNuevoGrupo);
                                      detalleNuevo.setOidCatal(detalle.getOidCatal());
                                      detalleNuevo.setOidCondProm(detalle.getOidCondProm());
          
                                      //detalleNuevo.setOidGrupOfer(oidNuevoGrupo);
                                      detalleNuevo.setCentro(detalle.getCentro());
                                      
                                      // vbongiov -- Cambio 20080746 -- 29/10/2008
                                      if(dto.getCodigoProgramaFidelizacion()!= null && dto.getIndOrdenarCodVenta().booleanValue()) {
                                         detalleNuevo.setCodigoVenta(codVentaOrdenado + "");
                                      } else {
                                         detalleNuevo.setCodigoVenta(detalle.getCodigoVenta());
                                      }
                                      
                                      detalleNuevo.setCodigoVentaGenerado(detalle.getCodigoVentaGenerado());
                                      detalleNuevo.setCosteEstandar(detalle.getCosteEstandar());
                                      detalleNuevo.setDigitable(detalle.getDigitable());
                                      detalleNuevo.setImpresionGP(detalle.getImpresionGP());
                                      detalleNuevo.setMatrizGenerada(detalle.getMatrizGenerada());
                                      detalleNuevo.setNumeroPaginaCatalogo(detalle.getNumeroPaginaCatalogo());
                                      detalleNuevo.setOidFormPago(detalle.getOidFormPago());
                                      detalleNuevo.setOrigen(detalle.getOrigen());
                                      detalleNuevo.setPosicionPagina(detalle.getPosicionPagina());
                                      detalleNuevo.setPosicionRanking(detalle.getPosicionRanking());
                                      detalleNuevo.setPrecioCatalogo(detalle.getPrecioCatalogo());
                                      detalleNuevo.setPrecioPosicionamiento(detalle.getPrecioPosicionamiento());
                                      detalleNuevo.setProductoPrincipal(detalle.getProductoPrincipal());
                                      detalleNuevo.setTextoBreve(detalle.getTextoBreve());
                                      detalleNuevo.setUnidadesEstimadas(detalle.getUnidadesEstimadas());
                                      detalleNuevo.setVentaNetaEstimada(detalle.getVentaNetaEstimada());
                                      //pzerbino14/11/2006 Incidencia DBLG700000229
                                      UtilidadesLog.debug("pase a copiar ****");
                                      detalleNuevo.setVariante(detalle.getVariante());
                                      detalleNuevo.setProgramaFidelizacion(detalle.getProgramaFidelizacion());
                                      
                                      // Modificado por SICC 20070326 - Rafael Romero - 12/07/2007
                                      detalleNuevo.setPrecioUnitario(detalle.getPrecioUnitario());
                                      // Fin modificado por SICC 20070326
                                      detalleOferHome.merge(detalleNuevo);
                                      
                                      // Obtengo el OID del detalle oferta nuevo
                                      Long oidNuevoDetalleOferta = detalleNuevo.getOid();
          
                                      MatrizFacturacionLocalHome matrizFactHome = new MatrizFacturacionLocalHome();
                                      MatrizFacturacionLocal matrizFact = null;
                                      MatrizFacturacionLocal nuevaMF = null;
          
                                      try {
                                          matrizFact = matrizFactHome.findByOidDetaOfer(detalle.getOid());
                                          nuevaMF = matrizFactHome.create(dto.getOidNueva(), oidNuevoDetalleOferta);
                                          nuevaMF.setEstado(matrizFact.getEstado());
                                          matrizFactHome.merge(nuevaMF);
                                      } catch (NoResultException f) {
                                          //UtilidadesLog.debug("Como no tiene matriz generada no crear la matriz nueva");
                                      }
                                  }
                                  
                                  // vbongiov -- Cambio 20080746 -- 29/10/2008
                                  codVentaOrdenado ++;
                              }                          
                          }
          
                          DetalleOfertaLocalHome detalleOferHome = new DetalleOfertaLocalHome();
                          
                          // vbongiov -- Cambio 20080746 -- 29/10/2008
                          Collection detalles = null;
                          if(dto.getCodigoProgramaFidelizacion()!= null && dto.getIndOrdenarCodVenta().booleanValue()) {
                              detalles = detalleOferHome.findByOidOferOrde(oferta.getOid());
                          } else {
                              detalles = detalleOferHome.findByOidOfer(oferta.getOid());
                          }                      
                          
                          Iterator itDetalles = detalles.iterator();
                          DetalleOfertaLocal detalle = null;
                          DetalleOfertaLocal detalleNuevo = null;
          
                          while (itDetalles.hasNext()) {
                              detalle = (DetalleOfertaLocal) itDetalles.next();
                              
                              UtilidadesLog.debug("detalle sin grupo: " + detalle.getOid());   
          
                              if (detalle.getOidGrupOfer() == null) {
                              
                                  UtilidadesLog.debug("detalle no grupo a copiar: " + detalle.getOid());  
                                  
                                  detalleNuevo = detalleOferHome.create(oidNuevaOferta
                                                                        , detalle.getOidProd()
                                                                        , detalle.getLineaOferta()
                                                                        , detalle.getFactorRepeticion()
                                                                        , detalle.getOidTipoOfer()
                                                                        , detalle.getOidCicloVida()
                                                                        , detalle.getOidGrupOfer());
                                  detalleNuevo.setOidCatal(detalle.getOidCatal());
                                  detalleNuevo.setOidCondProm(detalle.getOidCondProm());
                                  detalleNuevo.setCentro(detalle.getCentro());
                                  
                                  // vbongiov -- Cambio 20080746 -- 29/10/2008
                                  if(dto.getCodigoProgramaFidelizacion()!= null && dto.getIndOrdenarCodVenta().booleanValue()) {
                                      detalleNuevo.setCodigoVenta(codVentaOrdenado + "");
                                  } else {
                                      detalleNuevo.setCodigoVenta(detalle.getCodigoVenta());
                                  }                                  
                                  
                                  detalleNuevo.setCodigoVentaGenerado(detalle.getCodigoVentaGenerado());
                                  detalleNuevo.setCosteEstandar(detalle.getCosteEstandar());
                                  detalleNuevo.setDigitable(detalle.getDigitable());
                                  detalleNuevo.setImpresionGP(detalle.getImpresionGP());
                                  detalleNuevo.setMatrizGenerada(detalle.getMatrizGenerada());
                                  detalleNuevo.setNumeroPaginaCatalogo(detalle.getNumeroPaginaCatalogo());
                                  detalleNuevo.setOidFormPago(detalle.getOidFormPago());
          
                                  //detalleNuevo.setOidGrupOfer(detalle.getOidGrupOfer());
                                  detalleNuevo.setOrigen(detalle.getOrigen());
                                  detalleNuevo.setPosicionPagina(detalle.getPosicionPagina());
                                  detalleNuevo.setPosicionRanking(detalle.getPosicionRanking());
                                  detalleNuevo.setPrecioCatalogo(detalle.getPrecioCatalogo());
                                  detalleNuevo.setPrecioPosicionamiento(detalle.getPrecioPosicionamiento());
                                  detalleNuevo.setProductoPrincipal(detalle.getProductoPrincipal());
                                  detalleNuevo.setTextoBreve(detalle.getTextoBreve());
                                  detalleNuevo.setUnidadesEstimadas(detalle.getUnidadesEstimadas());
                                  detalleNuevo.setVentaNetaEstimada(detalle.getVentaNetaEstimada());
                                  //pzerbino14/11/2006 Incidencia DBLG700000229
                                  UtilidadesLog.debug("pase a copiar22 ****");
                                  detalleNuevo.setVariante(detalle.getVariante());
                                  detalleNuevo.setProgramaFidelizacion(detalle.getProgramaFidelizacion()); 
    
                                  // Modificado por SICC 20070326 - Rafael Romero - 12/07/2007
                                  detalleNuevo.setPrecioUnitario(detalle.getPrecioUnitario());
                                  // Fin modificado por SICC 20070326
                                   detalleOferHome.merge(detalleNuevo);
    
                                  // Obtengo el OID del detalle oferta nuevo
                                  Long oidNuevoDetalleOferta = detalleNuevo.getOid();
          
                                  MatrizFacturacionLocalHome matrizFactHome = new MatrizFacturacionLocalHome();
                                  MatrizFacturacionLocal matrizFact = null;
                                  MatrizFacturacionLocal nuevaMF = null;
          
                                  try {
                                      //UtilidadesLog.debug("finder con...: " + detalle.getOid() + " ...!!!!!");
                                      matrizFact = matrizFactHome.findByOidDetaOfer(detalle.getOid());
                                      nuevaMF = matrizFactHome.create(dto.getOidNueva(), oidNuevoDetalleOferta);
                                      nuevaMF.setEstado(matrizFact.getEstado());
                                      matrizFactHome.merge(nuevaMF);
                                  } catch (NoResultException f) {
                                      UtilidadesLog.debug("Como no tiene matriz generada no crear la matriz nueva");
                                  }
                              }
                              
                              // vbongiov -- Cambio 20080746 -- 29/10/2008
                              codVentaOrdenado ++;
                          }
          
                          // 1.4 )                
                          PromocionLocalHome promocionHome = new PromocionLocalHome();
                          Collection promociones = promocionHome.findByOidOferta(oferta.getOid());
                          Iterator itPromociones = promociones.iterator();
                          PromocionLocal promocion = null;
                          PromocionLocal promocionNueva = null;                      
          
                          while (itPromociones.hasNext()) {
                              promocion = (PromocionLocal) itPromociones.next();
                              
                              UtilidadesLog.debug("promocion a copiar: " + promocion.getOid());  
          
                              promocionNueva = promocionHome.create(oidNuevaOferta
                                                                    , promocion.getNumeroCondicion()
                                                                    , promocion.getFactorCuadre()
                                                                    , promocion.getIndicadorCuadrePromocion());
          
                              // Obtengo el OID de la nueva promocion.
                              Long oidNuevaPromocion = promocionNueva.getOid();
          
                              RangosPromocionLocalHome rangosPromoHome = new RangosPromocionLocalHome();
                              Collection rangos = rangosPromoHome.findByOidPromo(promocion.getOid());
                              Iterator itRangos = rangos.iterator();                          
          
                              RangosPromocionLocal rango = null;
                              RangosPromocionLocal rangoNuevo = null;
          
                              while (itRangos.hasNext()) {
                              
                                  rango = (RangosPromocionLocal) itRangos.next();
                                  
                                  UtilidadesLog.debug("rango a copiar: " + rango.getOid());  
                                  
                                  rangoNuevo = rangosPromoHome.create(rango.getOidCata()
                                                                      , oidNuevaPromocion
                                                                      , rango.getTipoRango()
                                                                      , rango.getNumeroRangoInterno()
                                                                      , rango.getValorDesde());
                                                                      
                                  rangoNuevo.setIndicadorExclusion(rango.getIndicadorExclusion());
                                  rangoNuevo.setValorHasta(rango.getValorHasta());
                                  rangosPromoHome.merge(rangoNuevo);
                              }
                          }
          
                          VentaExclusivaLocalHome ventaExcHome = new VentaExclusivaLocalHome();
                          Collection ventas = ventaExcHome.findByOidOferta(oferta.getOid());
                          Iterator itVentas = ventas.iterator();
                          VentaExclusivaLocal venta = null;
                          VentaExclusivaLocal ventaNueva = null;
          
                          while (itVentas.hasNext()) {
                          
                              venta = (VentaExclusivaLocal) itVentas.next();    
                              
                              UtilidadesLog.debug("venta a copiar: " + venta.getOid());  
                              
                              ventaNueva = ventaExcHome.create(oidNuevaOferta
                                                              , venta.getOidSubtClie()
                                                              , venta.getOidEstaClie()
                                                              , venta.getOidClas()
                                                              , venta.getOidTipoClie()
                                                              , venta.getOidTipoClas());
                              ventaNueva.setOidRegion(venta.getOidRegion());
                              ventaNueva.setOidZona(venta.getOidZona());                                                              
                              ventaNueva.setEstatus2(venta.getEstatus2());
                              ventaExcHome.merge(ventaNueva);
                          }                      
                    }
                }
            }
            
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException Ce) {
            UtilidadesLog.error(Ce);
            ctx.setRollbackOnly();
            throw new MareException(Ce, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoMFBean.copiarMF(DTOECopiarMF dto): Salida");
    }

    private Integer obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia): Entrada");
        String codigoError;
        RecordSet ofe_numSec;
        BelcorpService belcorpService;

        Integer nextOfe = new Integer(1);

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        if (nMatriz !=null){
          try {
              StringBuffer query_aux = new StringBuffer();
              query_aux.append(" Select max(ofert.NUM_OFER) as OFER");
              query_aux.append(" FROM PRE_OFERT ofert");
              query_aux.append(" WHERE ofert.COES_OID_ESTR = " + nEstrategia);
              query_aux.append(" AND ofert.MFCA_OID_CABE = " + nMatriz);
    
              ofe_numSec = BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());
    
              if (!ofe_numSec.esVacio()) {
                  if (ofe_numSec.getValueAt(0, "OFER") != null) {
                      nextOfe = new Integer(ofe_numSec.getValueAt(0, 0).toString());
                      nextOfe = new Integer(nextOfe.intValue() + 1);
                  }
              }
          } catch (Exception e) {
              codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
              throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
          }
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia): Salida");
        return nextOfe;
    }

    public DTOSalida consultarCabeceraMF(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.consultarCabeceraMF(DTOOID dto): Entrada");
        
        try {
            CabeceraMFLocalHome cabeHome = new CabeceraMFLocalHome();
            CabeceraMFLocal cabecera = cabeHome.findByPrimaryKey(dto.getOid());
            PeriodoLocalHome periodoHome = this.getPeriodoLocalHome();
            PeriodoLocal periodo = periodoHome.findByPrimaryKey(cabecera.getOidPeri());
            MarcaLocalHome marcaHome = this.getMarcaLocalHome();
            MarcaLocal marca = marcaHome.findByPrimaryKey(periodo.getOidMarca());
            String descMarca = marca.getDes_marc();
            String descCanal = this.getDescCanal(dto.getOidIdioma(), periodo.getOidCanal(), cabecera.getOidPeri());
            String descPeriodo = this.getDescPeriodo(cabecera.getOidPeri());
            RecordSet rs = this.buildRecordSetCMF();
            Object[] values = {
                descMarca, descCanal, descPeriodo,
                cabecera.getNumeroPedidosEstimados().toString(),
                cabecera.getUnidadesEstimadas().toString(),
                cabecera.getClientesEstimados().toString(),
                cabecera.getTotalMontoVentaNeta().toString(),
                (cabecera.getTipoCambio() != null) ? cabecera.getTipoCambio().toString() : null
            };
            rs.addRow(values);

            DTOSalida dtoSal = new DTOSalida();
            dtoSal.setResultado(rs);
            
            UtilidadesLog.info("MONMantenimientoMFBean.consultarCabeceraMF(DTOOID dto): Salida");
            return dtoSal;
        } catch (MareException me) {
            throw me;
        } catch (NamingException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }

    private RecordSet buildRecordSetCMF() {
        UtilidadesLog.info("MONMantenimientoMFBean.buildRecordSetCMF(): Entrada");
        
        String[] colsId = {
            "descripcionMarca", "descripcionCanal", "descripcionPeriodo",
            "numeroPedidosEstimados", "unidadesEstimadas", "clientesEstimados",
            "totalMontoVentaNeta", "tipoCambioPromedioPeriodo"
        };
        RecordSet rs = new RecordSet();
        rs.setColumnCount(colsId.length);
        rs.setColumnIdentifiers(colsId);
        
        UtilidadesLog.info("MONMantenimientoMFBean.buildRecordSetCMF(): Salida");
        return rs;
    }

    private String getDescCanal(Long oidIdioma, Long oidCanal, Long oidPeri) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.getDescCanal(Long oidIdioma, Long oidCanal, Long oidPeri): Entrada");
        
        StringBuffer query = new StringBuffer();
        query.append("select val_i18n from V_GEN_I18N_SICC ");
        query.append("  where IDIO_OID_IDIO = " + oidIdioma);
        query.append("  and VAL_OID = " + oidCanal);
        query.append(" and ATTR_NUM_ATRI = 1");
        query.append(" and ATTR_ENTI= 'SEG_CANAL'  ");

        RecordSet rs = this.runQuery(query);
        
        UtilidadesLog.info("MONMantenimientoMFBean.getDescCanal(Long oidIdioma, Long oidCanal, Long oidPeri): Salida");
        return (String) rs.getValueAt(0, 0);
    }

    private String getDescPeriodo(Long oidPeri) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.getDescPeriodo(Long oidPeri): Entrada");
        
        StringBuffer query = new StringBuffer();
        query.append("SELECT  cra.VAL_NOMB_PERI ");
        query.append("FROM  cra_perio cra ");
        query.append("WHERE cra.OID_PERI = " + oidPeri);

        RecordSet rs = this.runQuery(query);
        
        UtilidadesLog.info("MONMantenimientoMFBean.getDescPeriodo(Long oidPeri): Salida");
        return (String) rs.getValueAt(0, 0);
    }

    private RecordSet runQuery(StringBuffer query) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.runQuery(StringBuffer query): Entrada");
        
        try {
            UtilidadesLog.info("MONMantenimientoMFBean.runQuery(StringBuffer query): Salida");
            return BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public void modificarCabeceraMF(DTOECabeceraMF dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.modificarCabeceraMF(DTOECabeceraMF dto): Entrada");
        
        try {
            CabeceraMFLocalHome cabeHome = new CabeceraMFLocalHome();
            CabeceraMFLocal cabecera = cabeHome.findByPrimaryKey(dto.getOid());
            PeriodoLocalHome periodoLH = getPeriodoLocalHome();
            PeriodoLocal periodoL = periodoLH.findByPrimaryKey(cabecera.getOidPeri());
            ConfiguracionMFPaisLocalHome configuracionMFLH = new ConfiguracionMFPaisLocalHome();
            Collection col = configuracionMFLH.findByPaisMarcaCanal(periodoL.getOidPais(), periodoL.getOidMarca(), periodoL.getOidCanal());

            if ((col != null) && (col.size() == 0)) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0042));
            } else {
                Iterator it = col.iterator();
                ConfiguracionMFPaisLocal configuracionMFL = (ConfiguracionMFPaisLocal) it.next();

                if ((configuracionMFL.getOidMoneda() != null) && (dto.getTipoCambioPromedioPeriodo() == null)) {
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0045));
                }
            }

            cabecera.setNumeroPedidosEstimados(dto.getNumeroPedidosEstimado());
            cabecera.setUnidadesEstimadas(dto.getUnidadesEstimadas());
            cabecera.setClientesEstimados(dto.getClientesEstimados());
            cabecera.setTotalMontoVentaNeta(dto.getTotalMontoVentaNeta());

            if (dto.getTipoCambioPromedioPeriodo() != null) {
                cabecera.setTipoCambio(dto.getTipoCambioPromedioPeriodo());
            }
            cabeHome.merge(cabecera);
        } catch (MareException me) {
            UtilidadesLog.error(me);
            ctx.setRollbackOnly();
            throw me;
        } catch (NoResultException ex) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (NamingException ex) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception ex) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoMFBean.modificarCabeceraMF(DTOECabeceraMF dto): Salida");
    }

    public Boolean buscarCodigoVenta(String codigoVenta, Long pais) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVenta(String codigoVenta, Long pais): Entrada");
        
        StringBuffer query = new StringBuffer();

        try {
            query.append("Select * ");
            query.append("from PRE_OFERT_DETAL pod, ");
            query.append("PRE_OFERT po, PRE_MATRI_FACTU_CABEC pmfc, CRA_PERIO cp ");
            query.append("where pod.VAL_CODI_VENT = '" + codigoVenta + "' and ");
            query.append("pod.OFER_OID_OFER = po.OID_OFER and ");
            query.append("po.MFCA_OID_CABE = pmfc.OID_CABE and ");
            query.append("pmfc.PERD_OID_PERI = cp.OID_PERI and ");
            query.append("cp.PAIS_OID_PAIS = '" + pais + "'");
            UtilidadesLog.info("query: " + query.toString());

            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVenta(String codigoVenta, Long pais): Salida");
            if (rs.getRowCount() > 0) {            
                return Boolean.valueOf(true);
            } else {
                return Boolean.valueOf(false);
            }
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

 /*   public DTOProductoMatriz buscaProductoEnMatriz(DTOProductoMatriz DTOE) throws RemoteException, MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Entrada");

        RecordSet rDetallesOferta = null;
        //se construye de acuerdo a inc. 5302
        //deacuerdo a inc.:5892, no filtramos x estrategia.....
        if ((DTOE == null) || (DTOE.getOidSAP() == null)) {
            return null;
        }

        // Agregado por ssantana, 23/6/2005
        // Inc. 14837
        if (DTOE.getOidPeriodoFin() == null) {
            DTOE.setOidPeriodoFin(DTOE.getOidPeriodo());
        }

        // Fin Agregado ssantana, 23/6/2005
        if ((DTOE.getOidPeriodo() != null) && (DTOE.getOidPeriodoFin() != null)) {
            try {
                Vector listaOidsPeriodos = new Vector();

                if ((DTOE.getOidPeriodo().longValue()) != (DTOE.getOidPeriodoFin().longValue())) {
                    DTOOIDs oids = new DTOOIDs();
                    oids = getMONPeriodosHome().create().obtienePeriodosEntre(DTOE.getOidPeriodo(), DTOE.getOidPeriodoFin());

                    Long[] oidsA = oids.getOids();
                    //UtilidadesLog.debug("Se encontraron " + oidsA.length + " periodos");

                    //mas de un periodo, los meto dentro del vector
                    for (int i = 0; i < oidsA.length; i++) {
                        //UtilidadesLog.debug("Periodo: " + oidsA[i]);
                        listaOidsPeriodos.add(oidsA[i]);
                    }
                } else {
                    //solo uno
                    listaOidsPeriodos.add(DTOE.getOidPeriodo());
                }

                RecordSet rs = new RecordSet();
                BelcorpService belcorpService = null;

                try {
                    belcorpService = BelcorpService.getInstance();
                } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                    throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
                }

                OfertaLocalHome ofertaHome = this.getOfertaLocalHome();

                //recorro todos los oids de periodo
                int nProductoEnMatrix;

                //recorro todos los oids de periodo
                int nProductoTotal;

                nProductoEnMatrix = 0;
                nProductoTotal = 0;

                boolean lYaTengoProducto;
                lYaTengoProducto = false;

                Enumeration elementosListaOids = listaOidsPeriodos.elements();

                while (elementosListaOids.hasMoreElements()) {
                    Long elementoListaOids = (Long) elementosListaOids.nextElement();
                    //UtilidadesLog.debug("******** Procesando Periodo " + elementoListaOids);
                    nProductoTotal++;
                    
                    //obtengo los oids de la cabecera 
                    StringBuffer query = new StringBuffer();
                    query.append("Select OID_CABE ");
                    query.append("from PRE_MATRI_FACTU_CABEC ");
                    query.append("where PERD_OID_PERI = '" + elementoListaOids.longValue() + "'");

                    rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
                    query = null;
                    //UtilidadesLog.debug("rs Cabecera: " + rs);

                    //obtengo la lista de ofertas, de acuerdo a la estrategia, oid de cabecera,
                    //acceso y subacceso.
                    if (rs.getRowCount() > 0) {
                        RecordSet rs1 = new RecordSet();
                        StringBuffer query1 = new StringBuffer();
                        
                        // Obtengo los Detalles de Oferta que corresponden con las
                        // ofertas de la cabecera. Obtengo el Producto y sus datos (si existe)
                        
                        String oidCabecera = rs.getValueAt(0, 0).toString();
                        Long oidAcceso = DTOE.getOidAcceso();
                        Long oidSubacceso = DTOE.getOidSubacceso();
                        Long oidProd = DTOE.getOidSAP();
                        Long oidCicloVida = DTOE.getOidCicloVida();
                        Long oidOferta = DTOE.getOidTipoOferta();
                        StringBuffer sqlQuery = new StringBuffer("");
                        sqlQuery.append(" SELECT ofdet.val_codi_vent, ofdet.civi_oid_ciclo_vida, ");
                        sqlQuery.append(" ofdet.tofe_oid_tipo_ofer, ofdet.fopa_oid_form_pago, ");
                        sqlQuery.append(" ofdet.imp_prec_cata, ofdet.imp_prec_posi ");
                        sqlQuery.append(" FROM pre_ofert_detal ofdet ");
                        sqlQuery.append(" WHERE ofdet.ofer_oid_ofer IN ( ");
                        sqlQuery.append(" SELECT oid_ofer ");
                        sqlQuery.append(" FROM pre_ofert ");
                        sqlQuery.append(" WHERE mfca_oid_cabe = " + oidCabecera);
                        if ( oidAcceso != null ) {
                          sqlQuery.append(" and ACCE_OID_ACCE = " + oidAcceso);
                        }
                        if ( oidSubacceso != null ) {
                          sqlQuery.append(" and SBAC_OID_SBAC = " + oidSubacceso);
                        }
                        
                        sqlQuery.append(" ) ");
                        sqlQuery.append(" AND ofdet.prod_oid_prod = " + oidProd);
                        sqlQuery.append(" AND ofdet.ind_matr_fact_gene = 1 ");
                        sqlQuery.append(" and ofdet.CIVI_OID_CICLO_VIDA = " + oidCicloVida);
                        sqlQuery.append(" and ofdet.OFER_OID_OFER = " + oidOferta);
                        
                        rDetallesOferta =
                              BelcorpService.getInstance().dbService.executeStaticQuery(sqlQuery.toString());
                        
                        if (rDetallesOferta != null && !rDetallesOferta.esVacio()) {
                          
                          
                        }
                        
                        
                        
                        
                        query1.append("Select OID_OFER ");
                        query1.append("from PRE_OFERT ");
                        query1.append("where MFCA_OID_CABE = '" + new Long(((BigDecimal) rs.getValueAt(0, 0)).toString()) + "'");

                        if (DTOE.getOidAcceso() != null) {
                            query1.append(" and ACCE_OID_ACCE = '" + DTOE.getOidAcceso().longValue() + "'");
                        }

                        if (DTOE.getOidSubacceso() != null) {
                            query1.append(" and SBAC_OID_SBAC = '" + DTOE.getOidSubacceso().longValue() + "'");
                        }

                        rs1 = BelcorpService.getInstance().dbService.executeStaticQuery(query1.toString());
                        query1 = null;

                        //UtilidadesLog.debug("RecordSet ofertas: " + rs1);

                        if (rs1.getRowCount() > 0) {
                            //recorro c/u de las potenciales ofertas (el recordset, anterior...)
                            Vector row = null;

                            for (int ii = 0; ii < rs1.getRowCount(); ii++) {
                                row = rs1.getRow(ii);

                                Long pos0 = ((row.get(0) == null) ? null : new Long(((BigDecimal) row.get(0)).toString()));
                                //UtilidadesLog.debug("---- OidOferta Procesado: " + pos0);

                                RecordSet rs2 = new RecordSet();
                                StringBuffer query2 = new StringBuffer();

                                // Query Modificada por ssantana, 24/6/2005 - Inc. 14837
                                query2.append(" SELECT ofdet.val_codi_vent, ofdet.civi_oid_ciclo_vida, ");
                                query2.append(" ofdet.tofe_oid_tipo_ofer, ofdet.fopa_oid_form_pago, ");
                                query2.append(" ofdet.imp_prec_cata, ofdet.imp_prec_posi ");
                                query2.append(" FROM pre_ofert_detal ofdet ");
                                query2.append(" WHERE ofdet.ofer_oid_ofer = " + pos0.longValue());
                                query2.append(" AND ofdet.prod_oid_prod = " + DTOE.getOidSAP().longValue());
                                query2.append(" AND ofdet.ind_matr_fact_gene = 1");

                                // Fin Modificacion ssantana, 24/6/2005 - Inc. 14837
                                rs2 = BelcorpService.getInstance().dbService.executeStaticQuery(query2.toString());
                                query2 = null;

                                //UtilidadesLog.debug("Rs Codigo Venta: " + rs2);

                                //si lo encontre significa que para el periodo tal tengo producto en matriz....
                                if (rs2 != null) {
                                    if (rs2.getRowCount() > 0) {
                                        nProductoEnMatrix++;
                                    }
                                }

                                if (lYaTengoProducto == false) {
                                    //me quedo con el 1er. producto hallado, del primer periodo ciclado.
                                    if ((rs2 != null) && (rs2.getRowCount() > 0)) {
                                        //UtilidadesLog.debug("Entro");

                                        Vector row1 = null;
                                        row1 = rs2.getRow(0);

                                        String pos01 = ((row1.get(0) == null) ? null : new String(row1.get(0).toString()));
                                        DTOE.setCodigoVenta(pos01);

                                        // ********* Agregado por ssantana, 24/6/2005 - Inc. 14837
                                        Long cicloVida = new Long(row1.get(1).toString()); // Es NOT NULL 
                                        Long tipoOferta = new Long(row1.get(2).toString()); // Es NOT NULL

                                        // Forma Pago (Admite NULL)
                                        Long formaPago = ((row1.get(3) == null) ? null : new Long(row1.get(3).toString()));

                                        // Precio Catalogo (admite NULL)
                                        BigDecimal bigPrecioCatalogo = (BigDecimal) row1.get(4);

                                        // Precio Posicionamiento (admite NULL)                                          
                                        BigDecimal bigPrecioPosicionamiento = (BigDecimal) row1.get(5);

                                        DTOE.setOidCicloVida(cicloVida);
                                        DTOE.setOidTipoOferta(tipoOferta);
                                        DTOE.setOidFormaPago(formaPago);
                                        DTOE.setPrecioCatalogo(bigPrecioCatalogo);
                                        DTOE.setPrecioContable(bigPrecioPosicionamiento);

                                        // Fin agregado ssantana, 24/6/2005 - Inc. 14837
                                        lYaTengoProducto = true;
                                    }
                                }
                            }

                            //for. ...
                        }
                    }
                }

                //controlo que la cantidad de periodos sea = a la cantidad de periodos que halle en
                //PRE_OFERT_DETAL, segun inc.: 5889 
                if (nProductoTotal == nProductoEnMatrix) {
                    //UtilidadesLog.debug("nProductoTotal == nProductoEnMatrix");
                    UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Salida");
                    return DTOE;
                } else {
                    //UtilidadesLog.debug("nProductoTotal != nProductoEnMatrix");
                    UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Salida");
                    return null;
                }
            } catch (Exception e) {
                UtilidadesLog.error(e);
                String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
                throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
            }
        } else {
            UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Salida");
            return null;
        }
    }*/
    
    public DTOProductoMatriz buscaProductoEnMatriz(DTOProductoMatriz DTOE) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Entrada");
        
        /* 
         * Método rehecho desde cero por ssantana, 30/05/2006,
         * para proveer la funcionalidad pedida por el DECU entre MAV y PRE 
         */ 
         
         
        /* Chequea la existencia del producto en PRE 
         * DTOE.cicloVida = CicloVida del DetalleMAV 
         * DTOE.tipoOferta = Tipo Oferta del DetalleMAV */ 
         
         /* Primero busca la Matriz de Facturacion correspondiente a la Cabecera 
          * usando el Periodo. */ 
         BelcorpService bs = BelcorpService.getInstance();
         RecordSet rCabecera = null;
         RecordSet rProductos = null;
         StringBuffer sqlQuery = new StringBuffer(""); 
         StringBuffer sqlQueryOferta = new StringBuffer("");
         Long oidAcceso = DTOE.getOidAcceso();
         Long oidSubacceso = DTOE.getOidSubacceso();
         String sOidCabecera = null;
         
         sqlQuery.append(" SELECT oid_cabe ");
         sqlQuery.append(" FROM pre_matri_factu_cabec ");
         sqlQuery.append(" WHERE perd_oid_peri = " + DTOE.getOidPeriodo()); 
         
         try {
            rCabecera = bs.dbService.executeStaticQuery(sqlQuery.toString());
         } catch (Exception ex) {
            ex.printStackTrace();
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
         }
         
         UtilidadesLog.debug("rCabecera: " + rCabecera);
         
         if (!rCabecera.esVacio() ) {
            sOidCabecera = rCabecera.getValueAt(0,0).toString();
           /* 
            * Ahora busco las Ofertas, y Detalles de Oferta para esa Cabecera
            * filtrando por Ciclo de Vida, Tipo Oferta, Producto, Acceso y Subacceso
            */  

            /* Armo la subquery de Oferta */           
            sqlQueryOferta = new StringBuffer("");

            sqlQueryOferta.append(" SELECT oid_ofer "); 
            sqlQueryOferta.append(" FROM pre_ofert ");
            sqlQueryOferta.append(" WHERE mfca_oid_cabe = " + sOidCabecera);
            if ( oidAcceso != null) {
              sqlQueryOferta.append(" AND acce_oid_acce = " + oidAcceso);
            }
            if ( oidSubacceso != null ) {
              sqlQueryOferta.append(" AND sbac_oid_sbac = " + oidSubacceso); 
            }
          
            /* Armo la query Principal */ 
            sqlQuery = new StringBuffer(""); 
            
            sqlQuery.append(" SELECT pre_ofert_detal.val_codi_vent, " );
            sqlQuery.append(" pre_ofert_detal.civi_oid_ciclo_vida, ");
            sqlQuery.append(" pre_ofert_detal.tofe_oid_tipo_ofer, " );
            sqlQuery.append(" pre_ofert_detal.fopa_oid_form_pago, ");
            sqlQuery.append(" pre_ofert_detal.imp_prec_cata, ");
            sqlQuery.append(" pre_ofert_detal.imp_prec_posi ");
            sqlQuery.append(" FROM pre_ofert_detal "); 
            sqlQuery.append(" WHERE pre_ofert_detal.prod_oid_prod = " + DTOE.getOidSAP() );
            sqlQuery.append(" AND pre_ofert_detal.ind_matr_fact_gene = 1 ");
            sqlQuery.append(" AND pre_ofert_detal.tofe_oid_tipo_ofer = " + DTOE.getOidTipoOferta());
            sqlQuery.append(" AND pre_ofert_detal.civi_oid_ciclo_vida = " + DTOE.getOidCicloVida());
            sqlQuery.append(" AND pre_ofert_detal.ofer_oid_ofer IN (" + sqlQueryOferta.toString() );
            sqlQuery.append(" ) ");
            
            try {
               rProductos = bs.dbService.executeStaticQuery(sqlQuery.toString());
            } catch (Exception ex) {
               ex.printStackTrace();
               String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
               throw new MareException(ex, UtilidadesError.armarCodigoError(codigoError));
            }
            UtilidadesLog.debug("rProductos: " + rProductos);
            
            /* Se toma el primer producto encontrado */ 
            if (!rProductos.esVacio() ) {
               String sCodigoVenta = rProductos.getValueAt(0,0).toString();
               Long cicloVida = Long.valueOf(rProductos.getValueAt(0,1).toString());
               Long tipoOferta = Long.valueOf(rProductos.getValueAt(0,2).toString()); 
               Long formaPago = null;
               if (rProductos.getValueAt(0,3) != null )  {
                  formaPago = Long.valueOf(rProductos.getValueAt(0,3).toString()); 
               }
               
               BigDecimal bigPrecioCatalogo = (BigDecimal)rProductos.getValueAt(0,4);
               BigDecimal bigPrecioPosicionamiento = 
                                           (BigDecimal) rProductos.getValueAt(0,5);
                                           
               DTOE.setCodigoVenta(sCodigoVenta);
               DTOE.setOidCicloVida(cicloVida);
               DTOE.setOidTipoOferta(tipoOferta);
               DTOE.setOidFormaPago(formaPago);
               DTOE.setPrecioCatalogo(bigPrecioCatalogo);
               DTOE.setPrecioContable(bigPrecioPosicionamiento);
               UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Salida");
               return DTOE;
               // Forma Pago (Admite NULL)
               // Precio Catalogo (admite NULL)
               // Precio Posicionamiento (admite NULL)                                          
 
               /*DTOE.setOidCicloVida(cicloVida);
               DTOE.setOidTipoOferta(tipoOferta);
               DTOE.setOidFormaPago(formaPago);
               DTOE.setPrecioCatalogo(bigPrecioCatalogo);
               DTOE.setPrecioContable(bigPrecioPosicionamiento);*/
            }
         } 
         UtilidadesLog.info("MONMantenimientoMFBean.buscaProductoEnMatriz(DTOProductoMatriz DTOE): Salida");
         return null;
          
    }    
    /**
     * 
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @throws java.rmi.RemoteException
     * @return String
     * @param dto
     * pperanzola 20/09/2005 - se modifica segun diseño de codigo unico de venta
     * pperanzola 21/09/2005 - se modifica segun inc 
     */
    public Hashtable insertarProductoEnMatrizAgregados(DTOProductoMatriz dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(DTOProductoMatriz dto): Entrada");
        Hashtable hs = new Hashtable();
        //UtilidadesLog.debug("********* DTOProductoMatriz: " + dto);

        //se const. segun inc.: 5276
        //Se elimina del if dto.getOidPeriodoFin() por incidencia 12257
        if ((dto == null) || (dto.getOidCanal() == null) || (dto.getOidCicloVida() == null) || (dto.getOidEstrategia() == null) || (dto.getOidMarca() == null) || (dto.getOidPeriodo() == null) || (dto.getOidSAP() == null) || (dto.getOidTipoOferta() == null) || (dto.getPrecioCatalogo() == null) || (dto.getPrecioContable() == null)) {
            //UtilidadesLog.debug("el dto de entrada, no esta completo...........!!");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0034));
        }

        //si hay mas de un periodo todo se aplica para todos los periodos q' hubiere, caso
        //contrario se aplica solo para el periodo inicial
        //para lo cual meto el/los periodos dentro de un array, se ciclara 1 vez, o mas de 1.
        try {
            Vector listaOidsPeriodos = new Vector();

            //if(dto.getOidPeriodoFin()!=null){ //Incidencia 12257
            if ((dto.getOidPeriodoFin() != null) && (dto.getOidPeriodoFin().longValue() != dto.getOidPeriodo().longValue())) {
                if (dto.getOidPeriodoFin().longValue() != dto.getOidPeriodo().longValue()) {                    

                    DTOOIDs oids = new DTOOIDs();
                    oids = getMONPeriodosHome().create().obtienePeriodosEntre(dto.getOidPeriodo(), dto.getOidPeriodoFin());

                    if (oids.getOids() == null) {
                        return null;
                    }

                    Long[] oidsA = oids.getOids();

                    //mas de un periodo, los meto dentro del vector
                    for (int i = 0; i < oidsA.length; i++) {                        
                        listaOidsPeriodos.add(oidsA[i]);
                    }
                }
            } else {
                //solo uno
                //UtilidadesLog.debug("--- Hay un solo periodo: " + dto.getOidPeriodo());
                listaOidsPeriodos.add(dto.getOidPeriodo());
            }

            //ahora recorro el vector, tendra 1 o mas de una posc. ....
            Enumeration elementosListaOids = listaOidsPeriodos.elements();
            /*Long cabecera = new Long(0);
            MONOfertaHome moh = this.getMONOfertaHome();
            MONOferta mo = moh.create();*/

            // Se descarta que haya al menos 1 período, por lo que la primera vez
            // se realiza la inserción correspondiente y de paso se obtiene el Codigo de Venta
            // que se usará luego en las Cabeceras posteriores, si existe más de 1 periodo.
            Long periodoP = (Long) elementosListaOids.nextElement();
            Object[] retorno = this.insertarProductoEnMatriz(periodoP, dto);

            //  4.- Creamos el producto en la matriz de facturacion correspondiente asignando un código de venta. 
            String codigoUnicoVenta = null;
            try{
               codigoUnicoVenta =   buscarMayorCUV(listaOidsPeriodos);
            }catch (MareException e){
                //cuvMax > ConstantesPRE.MAYOR_NUMERO_CUV        
                e.printStackTrace();
                ctx.setRollbackOnly();
                UtilidadesLog.error("cuvMax > ConstantesPRE.MAYOR_NUMERO_CUV");
                return null;
            }

            DTOOferta dtoOf = (DTOOferta) retorno[1];
            DetalleOfertaLocal lOidDOf = (DetalleOfertaLocal) retorno[0];
            OfertaLocalHome ofeLH = new OfertaLocalHome();
            OfertaLocal oferLocal = ofeLH.findByPrimaryKey(lOidDOf.getOidOfer());
            
            
            DTOOID dtoOidTmp = new DTOOID();
            dtoOidTmp.setOid(dto.getOidSAP());
            
            /*
            MONOferta monOferta = this.getMONOfertaHome().create();
            MONProductosHome monProductosHome = this.getMONProductosHome();
            MONProductos monProductos = monProductosHome.create();
            
            /* No figuraba construido esta parte. Se deja comentado hasta tanto se 
             * aclare el cambio de CUV pedido por Peru a ENoziglia - ssantana, 11/07/2006*/
            /*String sCUVProducto = monProductos.obtenerCUV(dtoOidTmp);
            
            cabecera = existeCMFparaPeriodo((Long) elementosListaOids.nextElement());
            if (monOferta.existeOtroProductoAsignado(sCUVProducto, cabecera)) {
               monOferta.asignarAdicional(sCUVProducto, lOidDOf,  oferLocal); 
            } else {
               lOidDOf.setCodigoVenta(sCUVProducto);
            }*/
            
            Long oidCabecera = dtoOf.getOidCabeceraMF();
            
            lOidDOf.setCodigoVenta(codigoUnicoVenta);
            lOidDOf.setCodigoVentaGenerado(Boolean.valueOf(true));

            //actualizo el estado: matrizFacturacionGenerada , dentro de la ent. oferta.
            lOidDOf.setMatrizGenerada(Boolean.valueOf(true));
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            dolh.merge(lOidDOf);
            
            oferLocal.setCodigoVentaGenerado(Boolean.valueOf(true));
            oferLocal.setMatrizFacturacionGenerada(Boolean.valueOf(true));
            ofeLH.merge(oferLocal);
            //guardo en matriz de f.
            MatrizFacturacionLocalHome matrizFLHome = new MatrizFacturacionLocalHome();
            MatrizFacturacionLocal matrizFL = matrizFLHome.create(dtoOf.getOidCabeceraMF(), 
                                                                  lOidDOf.getOid());
            hs.put(periodoP,matrizFL.getOid());
            if (listaOidsPeriodos.size() > 1) {
                while (elementosListaOids.hasMoreElements()) {
                    /*UtilidadesLog.debug(" *************************************** ");
                    UtilidadesLog.debug(" ***       Comienzo de Bucle         *** ");
                    UtilidadesLog.debug(" *************************************** ");*/

                    //DTOECabeceraMF dtoCMF = new DTOECabeceraMF();
                    Long elementoListaOids = (Long) elementosListaOids.nextElement();

                    oidCabecera = null;
                    retorno = this.insertarProductoEnMatriz(elementoListaOids, dto);

                    dtoOf = (DTOOferta) retorno[1];
                    oidCabecera = dtoOf.getOidCabeceraMF();

                    lOidDOf = (DetalleOfertaLocal) retorno[0];                    
                    lOidDOf.setCodigoVenta(codigoUnicoVenta);
                    lOidDOf.setCodigoVentaGenerado(Boolean.valueOf(true));

                    //actualizo el estado: matrizFacturacionGenerada , dentro de la ent. oferta.
                    lOidDOf.setMatrizGenerada(Boolean.valueOf(true));
                    //guardo en matriz de f.
                    matrizFLHome = new MatrizFacturacionLocalHome();
                    matrizFL = matrizFLHome.create(dtoOf.getOidCabeceraMF(), lOidDOf.getOid());
                    hs.put(elementoListaOids,matrizFL.getOid());
                    /* Para cada producto, en caso de haber creado más de uno,
                     * actualizamos su entrada correspondiente dentro de la entidad Oferta
                     */
                    oferLocal =  ofeLH.findByPrimaryKey(lOidDOf.getOidOfer());
                    oferLocal.setCodigoVentaGenerado(Boolean.valueOf(true));
                    oferLocal.setMatrizFacturacionGenerada(Boolean.valueOf(true));
                    ofeLH.merge(oferLocal);
                }
            }           
            
            UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(DTOProductoMatriz dto): Salida");            
            return hs;
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (MareException me) {
            UtilidadesLog.error(me);
            ctx.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            //UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
    /**
     * @author pperanzola
     * @date 21/09/2005
     * @return cuvMax
     * @param listadoPeriodos
     *
     */
    private String buscarMayorCUV (Vector listadoPeriodos) throws MareException{
        UtilidadesLog.info("MONMantenimientoMFBean.buscarMayorCUV (Vector listadoPeriodos):Entrada");
        try{
            Long cuvMax = new Long (0);
            Long cuvTmp = null;
            Long oidCabecera = null;
            int cantPeriodos = listadoPeriodos.size();
            int i;
            String sCodUnicoVenta = null;
            MONOferta monOferta = null;
            try {
                monOferta = this.getMONOfertaHome().create();
            }catch (NamingException e){
                UtilidadesLog.error(e);
                throw new MareException(e);
            }catch (CreateException e){
                UtilidadesLog.error(e);
                throw new MareException(e);
            }catch (RemoteException e){
                UtilidadesLog.error(e);
                throw new MareException(e);
            }
            //UtilidadesLog.debug("monOferta creado");
            for (i=0 ;i<cantPeriodos ;i++ ) {
                Long oidPeri = (Long) listadoPeriodos.get(i);
                oidCabecera = existeCMFparaPeriodo(oidPeri);
                //UtilidadesLog.debug("oidCabecera = " + oidCabecera);
                if (oidCabecera != null){
                    try{
                        sCodUnicoVenta = monOferta.obtenerUltimoCodigoVenta(oidCabecera);
                    }catch(RemoteException e){
                        UtilidadesLog.error(e);
                        throw new MareException(e);
                    }
                    //UtilidadesLog.debug("sCodUnicoVenta = " + sCodUnicoVenta);
                    cuvTmp = new Long (sCodUnicoVenta);
                    if (cuvMax.longValue() < cuvTmp.longValue()){
                        cuvMax = cuvTmp;
                    }
                }
            }
            //UtilidadesLog.debug("cuvMax = " + cuvMax);
            cuvMax = new Long (cuvMax.longValue() + 1);
            if (cuvMax.longValue() > ConstantesPRE.MAYOR_NUMERO_CUV.longValue()){
                throw new MareException(new Exception());
            }else if (cuvMax.longValue() < ConstantesPRE.MENOR_NUMERO_CUV.longValue()){
                cuvMax = ConstantesPRE.MENOR_NUMERO_CUV; 
            }
            UtilidadesLog.info("MONMantenimientoMFBean.buscarMayorCUV (Vector listadoPeriodos):Salida");
            return cuvMax.toString();
        
        }catch (Exception e){
            e.printStackTrace();
            throw new MareException(e);
        }
        
    }

    // ***********************************************************************************************
    // Autor: ssantana, 4/1/2005
    // Descripcion: Devuelve un String que es el Codigo de Venta, a partir de la Entrada.
    // Nota: Este método se hizo traspasando el código de generación de Codigo de Venta 
    //       que se encontraba en "insertarProductoEnMatriz".
    // ***********************************************************************************************           
    private String obtieneCodigoVentaMAV(Long pais, Long marca, Long canal, Long estrategia, Long oidCabeceraMF) throws NoResultException, Exception {
        UtilidadesLog.info("MONMantenimientoMFBean.obtieneCodigoVentaMAV(Long pais, Long marca, Long canal, Long estrategia, Long oidCabeceraMF): Entrada");
        
        Integer iLongTipo = new Integer(0);
        Integer iLongSerie = new Integer(0);

        MONConfiguracionMFHome mcmfh = this.getMONConfiguracionMFHome();
        MONConfiguracionMF mcmf = mcmfh.create();

        MONOfertaHome moh = this.getMONOfertaHome();
        MONOferta mo = moh.create();

        int iUltRanSerie;
        iUltRanSerie = 0;

        String codigoVenta = "";

        RecordSet rRangoTipoOrdenados = null;
        RecordSet rRangoSerieOrdenados = null;

        ConfiguracionMFPaisLocalHome cmfpHome = new ConfiguracionMFPaisLocalHome();        

        Collection cmfp1 = cmfpHome.findByPaisMarcaCanal(pais, marca, canal);

        if (cmfp1.isEmpty()) {
            UtilidadesLog.debug("Collection Empty");
        }

        //Obtener rangos asociados a la Estrategia de la oferta / 
        //coleccion de un solo dato.....   

        if ((rRangoTipoOrdenados == null) || (rRangoSerieOrdenados == null)) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0035));
        }

        String urts = new String("0");

        urts = this.obtenerUltimoRangoSerie(estrategia, iLongSerie);
        
        Long urs = new Long(0);

        if (urts != null) {
            urs = new Long(urts.toString());
            iUltRanSerie = urs.intValue();
            iUltRanSerie++;
        } else {
            //Incidencia 5755
            urs = new Long(rRangoSerieOrdenados.getValueAt(0, 1).toString());
            iUltRanSerie = urs.intValue();
        }

        String ultiRangoSerie = "" + iUltRanSerie;

        String ultiRangoTipo = this.obtenerUltimoRangoTipo(estrategia, iLongTipo);

        if (ultiRangoTipo != null) {
            UtilidadesLog.debug("se creo codigo de venta: " + ultiRangoTipo);
        } else {
            //Incidencia 5755				
            ultiRangoTipo = rRangoTipoOrdenados.getValueAt(0, 1).toString();
        }

        int largoTipoActual = ultiRangoTipo.length();
        int faltaATipo = iLongTipo.intValue() - largoTipoActual;
        int largoSerieActual = ultiRangoSerie.length();
        int faltaASerie = iLongSerie.intValue() - largoSerieActual;

        //genero los ceros que le faltan
        String cerosTipo = new String("");

        for (int k = 0; k < faltaATipo; k++)
            cerosTipo = cerosTipo.concat("0");

        String cerosSerie = new String("");

        for (int l = 0; l < faltaASerie; l++)
            cerosSerie = cerosSerie.concat("0");
        
        codigoVenta = cerosTipo.concat(ultiRangoTipo).concat(cerosSerie).concat(ultiRangoSerie);
        
        UtilidadesLog.info("MONMantenimientoMFBean.obtieneCodigoVentaMAV(Long pais, Long marca, Long canal, Long estrategia, Long oidCabeceraMF): Salida");
        return codigoVenta;
    }

    // Nuevo por ssantana, 4/1/2005
    private Object[] insertarProductoEnMatriz(Long oidPeriodo, DTOProductoMatriz dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(Long oidPeriodo, DTOProductoMatriz dto): Entrada");
        
        Long cabecera = new Long(0);
        DTOOID dtoOid1 = new DTOOID();
        DTOOID dtoOid = new DTOOID();
        Object[] retorno = new Object[2];
        /* 1.- Comprobar si existe una entrada en la entidad CabeceraMF para el pais, marca, canal y periodo recepcionados
         * . En caso contrario, se crea una nueva cabecera. Si el periodo fin recibido esta especificado y es distinto del periodo
         *  realizamos este proceso para todos los periodos.
         * */
        try {
            MONOfertaHome moh = this.getMONOfertaHome();
            MONOferta mo = moh.create();

            //1.- Comprobar si existe una entrada en la entidad CabeceraMF para ese periodo.....
            DTOECabeceraMF dtoCMF = new DTOECabeceraMF();

            //UtilidadesLog.debug("----- Comprobando entrada en Cabecera Matriz Facturacion para el periodo");

            try {
                cabecera = existeCMFparaPeriodo(oidPeriodo);

                if (cabecera != null) {
                    UtilidadesLog.debug("para periodo: " + oidPeriodo.toString() + "...existe Cabecera MF.....!! cabecera " + cabecera);
                } else {
                    UtilidadesLog.debug("para periodo: " + oidPeriodo.toString() + "... no existe Cabecera MF.....!! cabecera " + cabecera);
                }
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (cabecera == null) {
                dtoCMF.setOidPais(dto.getOidPais());
                dtoCMF.setOidMarca(dto.getOidMarca());
                dtoCMF.setOidCanal(dto.getOidCanal());
                dtoCMF.setOidPeriodo(oidPeriodo);
                dtoCMF.setMatrizGenerada(Boolean.valueOf(false));

                //******************** inc.: 5721
                dtoCMF.setNumeroPedidosEstimado(new Long(0));
                dtoCMF.setUnidadesEstimadas(new Long(0));
                dtoCMF.setClientesEstimados(new Long(0));
                dtoCMF.setTotalMontoVentaNeta(new Long(0));

                //dtoCMF.setTipoCambioPromedioPeriodo(new Integer(1));
                /* Llamamos al método guardarCabeceraMF(DTOECabeceraMF) 
                 * y recibimos un DTOOID con el identificador de la matriz creada (oidCabeceraMF) 
                 */
                dtoOid = this.guardarCabeceraMF(dtoCMF);
                //UtilidadesLog.debug("Se creo CabeceraMF, para periodo: " + oidPeriodo.toString());
            }

            /* 2.- Creamos una cabecera de oferta. Si el periodo fin recibido esta especificado 
             * y es distinto del periodo, realizamos este proceso para todos los periodos. 
             */
            //UtilidadesLog.debug("--- Creando cabecera de Oferta...");

            DTOOferta dtoOf = new DTOOferta();

            Integer lNumOfe = new Integer(0);

            try {
                if (cabecera == null) {
                    lNumOfe = new Integer(obtenerNumeroSecuencial(dtoOid.getOid(), dto.getOidEstrategia()).intValue());
                } else {
                    lNumOfe = new Integer(obtenerNumeroSecuencial(cabecera, dto.getOidEstrategia()).intValue());
                }
            } catch (Exception e) {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            if (cabecera == null) {
                dtoOf.setOidCabeceraMF(dtoOid.getOid());
                dtoOf.setNumeroOferta(lNumOfe);
            } else {
                dtoOf.setOidCabeceraMF(cabecera);
                dtoOf.setNumeroOferta(lNumOfe);
            }

            // Agregado ssantana, 17/8/2005
            // Esto estaba en el DMCO y no se hacía.
            /*DTOOID dtoOidEstrategia = new DTOOID();
            dtoOidEstrategia.setOid(dto.getOidEstrategia());

            MONConfiguracionMFHome mcmfh = this.getMONConfiguracionMFHome();
            MONConfiguracionMF mcmf = mcmfh.create();

            DTOOID dtoOidArgumVenta = mcmf.obtenerArgumentoVentaEstrategia(dtoOidEstrategia);
            dtoOf.setOidArgumentoVenta(dtoOidArgumVenta.getOid());          */
            // Fin agregado ssantana, 17/8/2005
            //dtoOf.setOidArgumentoVenta();
            dtoOf.setOidEstrategia(dto.getOidEstrategia());
            dtoOf.setDespachoCompleto(Boolean.valueOf(false)); // sapaza -- PER-SiCC-2011-0664 -- 11/04/2011
            dtoOf.setDespachoAutomatico(Boolean.valueOf(true));
            dtoOf.setNumeroGrupos(new Integer(0));
            dtoOf.setNumeroPaquetes(new Integer(0));
            dtoOf.setNumeroGruposCondicionados(new Integer(0));
            dtoOf.setNumeroGruposCondicionantes(new Integer(0));
            dtoOf.setOidFormaPago(dto.getOidFormaPago());
            dtoOf.setCodigoVentaGenerado(Boolean.valueOf(false));
            dtoOf.setMatrizFacturacionGenerada(Boolean.valueOf(false));

            /* Agregado por ssantana, 18/7/2005
               Se necesita porque al buscar en buscarProductoEnMatriz()
               se filtra por estos campos. */
            //UtilidadesLog.debug("Se setea Acceso y Subacceso");
            dtoOf.setOidAcceso(dto.getOidAcceso());
            dtoOf.setOidSubacceso(dto.getOidSubacceso());

            // Fin agregao por ssantana, 18/7/2005
            /* Ssantana, 29/08/2006 Figura en el DMCO y no se hacia hasta ahora */
            dtoOf.setOidCatalogo(dto.getOidCatalogo());
            /* Fin Ssantana, 29/08/2006 Figura en el DMCO y no se hacia hasta ahora */

            /*Creamos un DTOOID con: oidEstrategia.
              DTOOID = Llamar al método MONConfiguracionMF.obtenerArgumentoVentaEstrategia(DTOOID)
              oidArgumentoVenta = DTOOID.oid
            */
            DTOOID dtoEstrArg = new DTOOID();
            dtoEstrArg.setOid(dto.getOidEstrategia());

            DTOOID dtoArgume = getMONConfiguracionMFHome().create().obtenerArgumentoVentaEstrategia(dtoEstrArg);
            dtoOf.setOidArgumentoVenta(dtoArgume.getOid());

            OfertaLocal lOidOf = mo.guardarCabeceraOferta(dtoOf);
            //UtilidadesLog.debug("se creo cabecera oferta con oid cab. MF: " + dtoOf.getOidCabeceraMF() + " - y nº de of.: " + lNumOfe);

            /* 3.- Creamos una entrada en la entidad DetalleOferta correspondiente 
             * al producto que se va a insertar. Si el periodo fin recibido esta especificado
             * y es distinto del periodo, realizamos este proceso para todos los periodos. 
             */
            //UtilidadesLog.debug("----- Creando Detalle de Oferta...");

            DTODetalleOferta dtoDO = new DTODetalleOferta();

            dtoDO.setOidDetalleOferta(lOidOf.getOid());
            dtoDO.setLineaOferta(new Integer(1));
            dtoDO.setOidSAP(dto.getOidSAP());

            dtoOid1.setOidPais(dto.getOidPais());

            if (dto.getOidIdioma() == null) {
                RecuperadorIdiomaDefectoServidor recuperadorIdioma = new RecuperadorIdiomaDefectoServidor();
                Long idiomaPorDefecto = recuperadorIdioma.getIdiomaDefectoServidor();
                dto.setOidIdioma(idiomaPorDefecto);
            }

            dtoOid1.setOidIdioma(dto.getOidIdioma());
            dtoOid1.setOid(dto.getOidSAP());

            dtoDO.setDescripcion(obtenerDescripcionSAP(dtoOid1));

            //Esta const. trae 3 posc.: "MAV", el campo no se lo banca (COD_ORIG)
            dtoDO.setOrigen(ConstantesPRE.MAV); //inc.: 5837

            dtoDO.setFactorRepeticion(new Integer(1));

            // sapaza -- PER-SiCC-2010-0606 -- 18/10/2010
            dtoDO.setOidCatalogo(dto.getOidCatalogo());
            if(dto.getPrecioCatalogo().longValue()==0 && dto.getPrecioContable().longValue()>0)
                dtoDO.setOidCondicionPromocion(dto.getOidCondicionPromocion());
            
            dtoDO.setImpresionGP(Boolean.valueOf(false));
            dtoDO.setDigitable(Boolean.valueOf(false));
            dtoDO.setOidFormaPago(dtoOf.getOidFormaPago());
            dtoDO.setNumeroGrupo(new Integer(0));
            dtoDO.setPrecioCatalogo(dto.getPrecioCatalogo());
            dtoDO.setPrecioPosicionamiento(dto.getPrecioContable());

            dtoDO.setOidTipoOferta(dto.getOidTipoOferta());
            dtoDO.setOidCicloVida(dto.getOidCicloVida());

            /*ConfiguracionMFPaisLocalHome cmfpHome = new ConfiguracionMFPaisLocalHome();
            Collection cmfp = cmfpHome.findByPaisMarcaCanal(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());*/

            //coleccion de un solo dato.....   
            //Iterator iterator = cmfp.iterator();

            /*while (iterator.hasNext()) {
                ConfiguracionMFPaisLocal cmfpLocal = (ConfiguracionMFPaisLocal) iterator.next();
                dtoDO.setOidMoneda(cmfpLocal.getOidMoneda());
            }*/

            //
            DetalleOfertaLocal lOidDOf = mo.guardarDetalleOferta(dtoDO);
            retorno[0] = lOidDOf;
            retorno[1] = dtoOf;

            //UtilidadesLog.debug("se creo detalle oferta con oid de oferta: " + lOidOf.getOid().longValue());
        } catch (RemoteException rEx) {
            UtilidadesLog.error(rEx);
            throw new MareException(rEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NamingException nEx) {
            UtilidadesLog.error(nEx);
            throw new MareException(nEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException fEx) {
            UtilidadesLog.error(fEx);
            throw new MareException(fEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (CreateException cEx) {
            UtilidadesLog.error(cEx);
            throw new MareException(cEx, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (MareException mEx) {
            throw mEx;
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(Long oidPeriodo, DTOProductoMatriz dto): Salida");
        return retorno;
    }

    public DTOSValidarCodigoVenta validarCodigoVenta(DTOEValidarCodigoVenta DTOE) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Entrada");
        
        // Valida la existencia de un código de venta dentro de la matriz de facturación correpondiente a un periodo
        if ((DTOE == null) || (DTOE.getPeriodo() == null) || (DTOE.getCodigoVenta() == null)) {
            UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Salida");
            return null;
        }
        
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();        

        query = new StringBuffer();

        /* Modificacion por Performance alorenzo 21/07/2006 */
        
        query.append("");
        
        query.append(" SELECT POD.OID_DETA_OFER, POD.PROD_OID_PROD, POD.IND_DIGI ");
        query.append(" FROM PRE_OFERT_DETAL POD, ");
        query.append("      PRE_OFERT PO, ");
        query.append("      PRE_MATRI_FACTU_CABEC MFC ");
        query.append(" WHERE POD.OFER_OID_OFER = PO.OID_OFER ");
        
        if (DTOE.getAcceso() != null) {
          query.append("   AND (PO.ACCE_OID_ACCE = " + DTOE.getAcceso() + " OR PO.ACCE_OID_ACCE IS NULL) ");
        }
        if (DTOE.getSubacceso() != null) {
          query.append("   AND (PO.SBAC_OID_SBAC = " + DTOE.getSubacceso() + " OR PO.SBAC_OID_SBAC IS NULL) ");
        }
        
        query.append("   AND PO.MFCA_OID_CABE = MFC.OID_CABE ");        
        
        query.append("   AND MFC.PERD_OID_PERI = " + DTOE.getPeriodo().longValue());
        query.append("   AND POD.VAL_CODI_VENT = '" + DTOE.getCodigoVenta() + "' ");

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
          
            if (rs.getRowCount() > 0) {
                DTOSValidarCodigoVenta dtoVCV = new DTOSValidarCodigoVenta();
                dtoVCV.setOidDetalleOferta(this.bigDecimalToLong(rs.getValueAt(0, "OID_DETA_OFER")));
                dtoVCV.setProducto(this.bigDecimalToLong(rs.getValueAt(0, "PROD_OID_PROD")));
                dtoVCV.setIndicadorDigitableGP(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_DIGI")));
            
                UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Salida");
                return dtoVCV;
            }

          UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Salida");
          return null;
        } catch (MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /*
        StringBuffer query2 = new StringBuffer();
        RecordSet rec2 = new RecordSet();

        try {
            //obtengo oid de cabecera de matriz de facturacion....
            query.append("Select OID_CABE ");
            query.append("from PRE_MATRI_FACTU_CABEC ");
            query.append("where PERD_OID_PERI = '" + DTOE.getPeriodo().longValue() + "'");

            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            Long oidCabecera = ((rs.getValueAt(0, 0) == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, 0)).toString()));

            //UtilidadesLog.debug("el oidCabecera es: " + oidCabecera);

            if (oidCabecera == null) {
                return null;
            }

            //obtengo lo necesario de: PRE_OFERT_DETAL....
            query2.append("Select pod.OID_DETA_OFER, pod.PROD_OID_PROD, pod.IND_DIGI ");
            query2.append("from PRE_OFERT_DETAL pod, PRE_OFERT po, PRE_ESTRA pe ");
            query2.append("where pod.VAL_CODI_VENT = '" + DTOE.getCodigoVenta() + "' and ");
            query2.append("pod.OFER_OID_OFER in( ");

            //Modificado Por PABLO PEREZ 22/12/2004  incidencia 11674
            query2.append(" SELECT oid_ofer ");
            query2.append("   FROM pre_ofert ");
            query2.append("  WHERE 1=1  ");

            if (DTOE.getAcceso() != null) {
                query2.append("    and ( acce_oid_acce  =  " + DTOE.getAcceso());
                query2.append("   	   	OR acce_oid_acce IS NULL)  ");
            }

            if (DTOE.getSubacceso() != null) {
                query2.append("    AND (sbac_oid_sbac =  " + DTOE.getSubacceso());
                query2.append("    	    OR sbac_oid_sbac IS NULL)  ");
            }

            query2.append("    AND mfca_oid_cabe  =  " + oidCabecera.longValue() + " ) and ");

            //Modificado Por PABLO PEREZ 22/12/2004  incidencia 11674
            query2.append("pod.OFER_OID_OFER = po.OID_OFER and ");
            query2.append("po.COES_OID_ESTR = pe.OID_ESTR");

            RecordSet rs2 = BelcorpService.getInstance().dbService.executeStaticQuery(query2.toString());

            //UtilidadesLog.debug("este es el recordSet: " + rs2);

            if (rs2.getRowCount() > 0) {
                DTOSValidarCodigoVenta dtoVCV = new DTOSValidarCodigoVenta();

                dtoVCV.setOidDetalleOferta((rs2.getValueAt(0, 0) == null) ? null : new Long(((BigDecimal) rs2.getValueAt(0, 0)).toString()));
                dtoVCV.setProducto((rs2.getValueAt(0, 1) == null) ? null : new Long(((BigDecimal) rs2.getValueAt(0, 1)).toString()));

                if (rs2.getValueAt(0, 2) != null) {
                    BigDecimal valor = (BigDecimal) rs2.getValueAt(0, 2);

                    if (valor.equals(new BigDecimal(1))) {
                        dtoVCV.setIndicadorDigitableGP(new Boolean(true));
                    }

                    if (valor.equals(new BigDecimal(0))) {
                        dtoVCV.setIndicadorDigitableGP(new Boolean(false));
                    }
                }

                //UtilidadesLog.debug("saliendo....");
                
                UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Salida");
                return dtoVCV;
            }

            UtilidadesLog.info("MONMantenimientoMFBean.validarCodigoVenta(DTOEValidarCodigoVenta DTOE): Salida");
            return null;
            
        } catch (MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }*/
        
        /* Fin Modificacion por Performance alorenzo 21/07/2006 */
    }

    /**
     * @author mmaidana
     * @date 28/08/2006
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param DTOE
     * Creado por incidencia BELC300020520.
     */
    public DTOSValidarCodigoVenta validarCodVent(DTOEValidarCodigoVenta DTOE) throws MareException {
        UtilidadesLog.info("MONMantenimientoMF.validarCodVent(DTOEValidarCodigoVenta DTOE): ENTRADA");
        UtilidadesLog.debug("DTOE: " + DTOE);
        
        StringBuffer query = null;
        RecordSet rs = null;
        Long periodo = null;
        
        // Obtenemos el periodo con el que filtraremos en el paso 1.3.1 
        
        if (DTOE.getModulo() != null && DTOE.getModulo().equals(ConstantesPED.MODULO_RECLAMOS)){
            query = new StringBuffer();
            query.append("SELECT SC.PERD_OID_PERI PERIODO ");
            query.append("FROM PED_SOLIC_CABEC SC ");
            query.append("WHERE SC.OID_SOLI_CABE = " + DTOE.getOidDocumentoReferencia());
            
            UtilidadesLog.debug("query: " + query);
            
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
        } else {
            periodo = DTOE.getPeriodo();
        }
        
        UtilidadesLog.debug("periodo: " + periodo);
        
        // Valida la existencia de un código de venta dentro de la matriz de 
        //facturación correpondiente a un periodo
        
        query = new StringBuffer();
        query.append(" SELECT POD.OID_DETA_OFER, POD.PROD_OID_PROD, POD.IND_DIGI, C.COD_CATA, POD.NUM_PAGI_CATA ");
        query.append(" FROM PRE_OFERT_DETAL POD, ");
        query.append("      PRE_OFERT PO, ");
        query.append("      PRE_MATRI_FACTU_CABEC MFC, ");
        query.append("      PRE_CATAL C ");
        query.append(" WHERE POD.OFER_OID_OFER = PO.OID_OFER ");
        
        query.append("   AND PO.MFCA_OID_CABE = MFC.OID_CABE ");
        
        /* Modificado por ssantana, 30/08/2006,*/ 
        query.append("   AND POD.OCAT_OID_CATAL = C.OID_CATA(+) ");
        /* Fin Modificado por ssantana, 30/08/2006,*/ 
        
        if (DTOE.getAcceso() != null) {
          query.append("   AND (PO.ACCE_OID_ACCE = " + DTOE.getAcceso() + " OR PO.ACCE_OID_ACCE IS NULL) ");
        }
        if (DTOE.getSubacceso() != null) {
          query.append("   AND (PO.SBAC_OID_SBAC = " + DTOE.getSubacceso() + " OR PO.SBAC_OID_SBAC IS NULL) ");
        }
        
        query.append("   AND MFC.PERD_OID_PERI = " + periodo);
        query.append("   AND POD.VAL_CODI_VENT = '" + DTOE.getCodigoVenta() + "' ");

        UtilidadesLog.debug("query: " + query);

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
          
            UtilidadesLog.debug("rs: " + rs);
          
            if (rs.getRowCount() > 0) {
                DTOSValidarCodigoVenta dtoVCV = new DTOSValidarCodigoVenta();
                dtoVCV.setOidDetalleOferta(this.bigDecimalToLong(rs.getValueAt(0, "OID_DETA_OFER")));
                dtoVCV.setProducto(this.bigDecimalToLong(rs.getValueAt(0, "PROD_OID_PROD")));
                dtoVCV.setIndicadorDigitableGP(this.bigDecimalToBoolean(rs.getValueAt(0,"IND_DIGI")));

                if (rs.getValueAt(0, "NUM_PAGI_CATA") != null){
                    dtoVCV.setNumPagCatalogo(new Integer(rs.getValueAt(0, "NUM_PAGI_CATA").toString()));
                }
                
                dtoVCV.setCodigoCatalogo(this.bigDecimalToLong(rs.getValueAt(0, "COD_CATA")));
            
                UtilidadesLog.info("MONMantenimientoMF.validarCodVent(DTOEValidarCodigoVenta DTOE): SALIDA");
                return dtoVCV;
            }

            UtilidadesLog.info("MONMantenimientoMF.validarCodVent(DTOEValidarCodigoVenta DTOE): SALIDA");
            return null;
        } catch (MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }



    public Integer contarCodigoVenta(Long pais, Long marca, Long canal, Long acceso, Long subacceso, String codigoVenta, Long codigoCatalogo) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.contarCodigoVenta(Long pais, Long marca, Long canal, Long acceso, Long subacceso, String codigoVenta, Long codigoCatalogo): Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet();

        StringBuffer query1 = new StringBuffer();
        RecordSet rs1 = new RecordSet();

        try {
            //obtengo el catalogo......segun inc.: 6179, se agrega el catalogo a los parametros.
            query.append("Select OID_CATA ");
            query.append("from PRE_CATAL ");
            query.append("where COD_CATA = '" + codigoCatalogo + "' and ");
            query.append("PAIS_OID_PAIS = '" + pais + "'");

            rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            Long oidCatalogo = ((rs.getValueAt(0, 0) == null) ? null : new Long(((BigDecimal) rs.getValueAt(0, 0)).toString()));

            // Cuente el número de registros de la entidad MatrizFacturacion que cumplen los criterios recibidos 
            query1.append("Select pod.OID_DETA_OFER ");
            query1.append("from PRE_OFERT_DETAL pod ");
            query1.append("where pod.VAL_CODI_VENT = '" + codigoVenta + "' and ");
            query1.append("pod.OCAT_OID_CATAL = '" + oidCatalogo + "' and ");
            query1.append("pod.OFER_OID_OFER in (");
            query1.append(" Select OID_OFER from PRE_OFERT ");
            query1.append("where ACCE_OID_ACCE = '" + acceso.longValue() + "' and ");
            query1.append("SBAC_OID_SBAC = '" + subacceso.longValue() + "' and ");
            query1.append("MFCA_OID_CABE in (");
            query1.append(" Select OID_CABE from PRE_MATRI_FACTU_CABEC ");
            query1.append("where PERD_OID_PERI in( ");
            query1.append(" Select OID_PERI from CRA_PERIO ");
            query1.append("where PAIS_OID_PAIS = '" + pais.longValue() + "' and ");
            query1.append("MARC_OID_MARC = '" + marca.longValue() + "' and ");
            query1.append("CANA_OID_CANA = '" + canal.longValue() + "'");
            query1.append(" )))");

            rs1 = BelcorpService.getInstance().dbService.executeStaticQuery(query1.toString());

            UtilidadesLog.info("MONMantenimientoMFBean.contarCodigoVenta(Long pais, Long marca, Long canal, Long acceso, Long subacceso, String codigoVenta, Long codigoCatalogo): Salida");
            if (rs1 != null) {
                return new Integer(rs1.getRowCount());
            } else {
                return null;
            }
        } catch (MareException e) {
            UtilidadesLog.error(e);
            throw e;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }


    private String obtenerDescripcionSAP(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerDescripcionSAP(DTOOID dto): Entrada");
        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT b.VAL_I18N ");
            query.append(" FROM V_GEN_I18N_SICC b ");
            query.append(" WHERE ");
            query.append(" b.ATTR_ENTI = 'MAE_PRODU' ");
            query.append(" and b.ATTR_NUM_ATRI = 1 ");
            query.append(" and b.IDIO_OID_IDIO = " + dto.getOidIdioma());
            query.append(" and b.VAL_OID = " + dto.getOid());
            query.append(" ORDER BY b.VAL_I18N ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
            
            UtilidadesLog.info("MONMantenimientoMFBean.obtenerDescripcionSAP(DTOOID dto): Salida");
            return (String) resultado.getValueAt(0, 0);
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    //esto es suplantable x un finder.....
    private Long existeCMFparaPeriodo(Long lPeriodo) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.existeCMFparaPeriodo(Long lPeriodo): Entrada");
        
        try {
            StringBuffer query = new StringBuffer();
            query.append("Select OID_CABE from PRE_MATRI_FACTU_CABEC ");
            query.append("where PERD_OID_PERI = '" + lPeriodo + "'");

            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());

            UtilidadesLog.info("MONMantenimientoMFBean.existeCMFparaPeriodo(Long lPeriodo): Salida");
            if (rs.getRowCount() > 0) {
                return new Long(((BigDecimal) rs.getValueAt(0, 0)).toString());
            } else {
                return null;
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    public DTOSalida buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        Long periodo = dto.getPeriodo();
        String codigoVenta = dto.getCodigoVenta();
        Long catalogo = dto.getCatalogo();
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;        
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;

        if (periodo != null) {
            try {
                belcorpService = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            /*mdolce 18/12/2006 Se cambio la devolucion y filtro del campo val_posi_pagi por el NUM_PAGI_CATA
             * V_PED_10
             * 
             * */

            //Buscamos la matriz de facturacion correspondiente
            rs = null;
            query = new StringBuffer();
            query.append(" SELECT D.OID_DETA_OFER OID, D.VAL_CODI_VENT, C.COD_CATA, D.NUM_PAGI_CATA, MF.OID_MATR_FACT ");
            query.append(" FROM PRE_OFERT_DETAL D, PRE_CATAL C, PRE_OFERT O, PRE_MATRI_FACTU_CABEC M, PRE_MATRI_FACTU MF ");
            query.append(" WHERE D.OCAT_OID_CATAL = C.OID_CATA(+)");
            query.append(" AND M.PERD_OID_PERI = "+periodo);
            query.append(" AND M.OID_CABE = O.MFCA_OID_CABE ");
            query.append(" AND O.OID_OFER = D.OFER_OID_OFER ");
            query.append(" AND M.OID_CABE = O.MFCA_OID_CABE ");
            query.append(" AND MF.OFDE_OID_DETA_OFER = D.OID_DETA_OFER ");            
            query.append(" AND mf.MFCA_OID_CABE = m.OID_CABE  ");
 

            if ((codigoVenta != null) && (codigoVenta.length() > 0)) {
                query.append(" AND D.VAL_CODI_VENT LIKE '" + codigoVenta + "'");
            }

            if (catalogo != null) {
                query.append(" AND D.OCAT_OID_CATAL = " + catalogo.toString());
            }

            if (dto.getPaginaDesde() != null) {
                query.append(" AND D.NUM_PAGI_CATA >= " + dto.getPaginaDesde().toString());
            }

            if (dto.getPaginaHasta() != null) {
                query.append(" AND d.NUM_PAGI_CATA <= " + dto.getPaginaHasta().toString());
            }

            //Paginar la query

            /*DTOSiccPaginacion dtoSiccPaginacion = new DTOSiccPaginacion();
            dtoSiccPaginacion.setIndicadorSituacion( paginaDesde );
            dtoSiccPaginacion.setTamanioPagina( paginaHasta );
            String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion( query.toString(), dtoSiccPaginacion );
            */
            String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

            try {
                rs = belcorpService.dbService.executeStaticQuery(queryPaginada);
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            dtos = new DTOSalida();
            dtos.setResultado(rs);
        }

        if ((rs == null) || rs.esVacio()) {
            //UtilidadesLog.debug("Tirando mare exception");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.buscarCodigoVentaPeriodo(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return dtos;
    }

    public Long obtenerFormaPagoMF(Long oidPeriodo, String codigoVenta) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerFormaPagoMF(Long oidPeriodo, String codigoVenta): Entrada");
        
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();

        try {
            StringBuffer query = new StringBuffer();
            query.append(" select  distinct PRE_OFERT_DETAL.FOPA_OID_FORM_PAGO");
            query.append(" from  PRE_MATRI_FACTU_CABEC , PRE_OFERT, PRE_OFERT_DETAL  ");
            query.append(" WHERE ");
            query.append(" PERD_OID_PERI= " + oidPeriodo);
            query.append(" and OID_CABE= MFCA_OID_CABE ");
            query.append(" and OID_OFER=OFER_OID_OFER");
            query.append(" and  VAL_CODI_VENT = '" + codigoVenta + "'");
            /*UtilidadesLog.debug("--------------------------------------------");
            UtilidadesLog.debug("despues de armar la query");
            UtilidadesLog.debug(query);
            UtilidadesLog.debug("--------------------------------------------");*/

            resultado = bs.dbService.executeStaticQuery(query.toString());

            if ((resultado != null) && (!resultado.esVacio())) {
                UtilidadesLog.debug("--------------------------------------------");
                UtilidadesLog.debug("despues pedido de coneccion   " + resultado.getValueAt(0, 0));
                UtilidadesLog.debug("--------------------------------------------");
            } else {
                UtilidadesLog.debug("--------------------------------------------");
                UtilidadesLog.debug("despues pedido de coneccion  NO SE OBTUVIERON RESULTADOS ");
                UtilidadesLog.debug("--------------------------------------------");
            }
        } catch (Exception e) {
            
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        Long salida = null;

        if ((resultado != null) && (!resultado.esVacio()) && ((resultado.getValueAt(0, 0)) != null)) {
            BigDecimal resu = ((BigDecimal) resultado.getValueAt(0, 0));
            salida = new Long(resu.longValue());
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerFormaPagoMF(Long oidPeriodo, String codigoVenta): Salida");
        return salida;
    }

    public DTOSalida obtenerProductosAlternativos(Long oidPeriodo, String codigoVenta) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductosAlternativos(Long oidPeriodo, String codigoVenta): Entrada");
        
        Vector bindVars = new Vector();
        StringBuffer query = new StringBuffer();
        /*
         * DBLG400000395 - dmorello, 23/02/2006
         * Se modifica la siguiente query agregando joins entre MAE_PRODU y
         * PRE_OFERT_DETAL para poder recuperar el código SAP y la descripción
         * corta, tanto para el producto principal como para los alternativos.
         */
        query.append(" SELECT DTO2.VAL_CODI_VENT CV_ALTERNATIVO, DTO2.PROD_OID_PROD OID_PRODUCTO_ALTERNATIVO ");
        // Sig. 4 líneas agregada por DBLG400000395
        query.append(" , PROD_PRI.COD_SAP COD_PRINCIPAL ");
        query.append(" , PROD_PRI.DES_CORT DES_PRINCIPAL ");
        query.append(" , PROD_ALT.COD_SAP COD_ALTERNATIVO ");
        query.append(" , PROD_ALT.DES_CORT DES_ALTERNATIVO ");
        query.append(" , DTO2.OID_DETA_OFER  OID_DETA_OFER_ALTERNATIVO ");
        // Agregado por SICC20070334 - Rafael Romero - 07/08/2007
        query.append(" , CASE WHEN dto2.IMP_PREC_CATA > 0 THEN dto2.PRECIO_UNITARIO ELSE 0 END * ");
        query.append(" CASE WHEN NVL(cmf.MONE_OID_MONE,0) > 0 THEN NVL(cmf.VAL_TIPO_CAMB,0) ELSE 1 END PRECIO_CATALOGO ");
        query.append(" , CASE WHEN dto2.IMP_PREC_CATA > 0 THEN 0 ELSE dto2.IMP_PREC_POSI END * ");
        query.append(" CASE WHEN NVL(cmf.MONE_OID_MONE,0) > 0 THEN NVL(cmf.VAL_TIPO_CAMB,0) ELSE 1 END PRECIO_CONTABLE ");
        query.append(" , CASE WHEN dto2.IMP_PREC_CATA > 0 THEN dto2.PRECIO_UNITARIO ELSE 0 END * ");
        query.append(" CASE WHEN NVL(cmf.MONE_OID_MONE,0) > 0 THEN 1 ELSE 0 END PRECIO_CATALOGO_DOC ");
        query.append(" , CASE WHEN dto2.IMP_PREC_CATA > 0 THEN 0 ELSE dto2.IMP_PREC_POSI END * ");
        query.append(" CASE WHEN NVL(cmf.MONE_OID_MONE,0) > 0 THEN 1 ELSE 0 END PRECIO_CONTABLE_DOC ");
        query.append(" , dto1.VAL_FACT_REPE FAC_REP_PRIN ");
        query.append(" , dto2.VAL_FACT_REPE FAC_REP_ALTE ");
        // Fin agregado SICC20070334
        query.append(" FROM PRE_MATRI_CODIG_ALTER MA, PRE_MATRI_FACTU MF1, PRE_OFERT_DETAL DTO1, ");
        query.append(" PRE_MATRI_FACTU MF2, PRE_OFERT_DETAL DTO2, PRE_MATRI_FACTU_CABEC CMF ");
        // Sig. línea agregada por DBLG400000395
        query.append(" , MAE_PRODU PROD_PRI, MAE_PRODU PROD_ALT ");

        query.append(" WHERE MF1.OFDE_OID_DETA_OFER = DTO1.OID_DETA_OFER ");
        query.append(" AND CMF.OID_CABE = MF1.MFCA_OID_CABE ");
        query.append(" AND MA.MAFA_OID_COD_PPAL = MF1.OID_MATR_FACT ");
        query.append(" AND DTO2.OID_DETA_OFER = MF2.OFDE_OID_DETA_OFER ");
        query.append(" AND CMF.OID_CABE = MF2.MFCA_OID_CABE ");
        query.append(" AND MA.MAFA_OID_COD_ALTE = MF2.OID_MATR_FACT ");
        // Sig. 2 líneas agregadas por DBLG400000395
        query.append(" AND DTO1.PROD_OID_PROD = PROD_PRI.OID_PROD ");
        query.append(" AND DTO2.PROD_OID_PROD = PROD_ALT.OID_PROD ");

        if (oidPeriodo != null) {
            query.append(" AND CMF.PERD_OID_PERI = ? ");
            bindVars.addElement(oidPeriodo);
        }

        if ((codigoVenta != null) && (!codigoVenta.equals(""))) {
            query.append(" AND DTO1.VAL_CODI_VENT LIKE ? ");
            bindVars.addElement(codigoVenta);
        }
        
        //cvalenzu - 7/11/2006 -
        //query.append(" ORDER BY NUM_ORDE ASC ");
        query.append(" ORDER BY ma.NUM_ORDE ASC ");
        //cvalenzu - se cambio debido a que aparecia este error:
        //java.sql.SQLException: ORA-00918: column ambiguously defined

        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException ex) {
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        RecordSet r = null;

        try {
            r = bs.dbService.executePreparedQuery(query.toString(), bindVars);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida output = new DTOSalida();
        output.setResultado(r);
        
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductosAlternativos(Long oidPeriodo, String codigoVenta): Salida");
        return output;
    }

   /**
    * @autor jpbosnja
    * @modificado - 08/08/2005 - BELC300014487 - pperanzola
    **/
    public DTOProductoReemplazo obtenerProductoReemplazo(DTOProductoReemplazo dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoReemplazo(DTOProductoReemplazo dtoe): Entrada");
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT dto2.val_codi_vent cv_reemplazo, ");
            query.append(" ind_reem_ante_cuad ind_antes_cuadre, ind_mens ind_mensaje, ");
            query.append(" dto2.imp_prec_cata precio_catalogo, dto2.OID_DETA_OFER, dto2.PROD_OID_PROD ");
            query.append(" FROM ");
            query.append(" pre_matri_reemp ma, pre_matri_factu mf1, pre_ofert_detal dto1, pre_matri_factu mf2, ");
            query.append(" pre_ofert_detal dto2, pre_matri_factu_cabec cmf  ");
            query.append(" WHERE  ");
            query.append(" dto1.val_codi_vent LIKE '" + dtoe.getCvPrincipal() + "'");
            query.append(" AND cmf.perd_oid_peri = " + dtoe.getOidPeriodo());
            query.append(" AND cmf.oid_cabe = mf1.mfca_oid_cabe");
            query.append(" AND dto1.OID_DETA_OFER = mf1.OFDE_OID_DETA_OFER ");
            query.append(" AND ma.mafa_oid_cod_ppal = mf1.oid_matr_fact");
            query.append(" AND dto2.oid_deta_ofer = mf2.ofde_oid_deta_ofer");
            query.append(" AND cmf.oid_cabe = mf2.mfca_oid_cabe");
            query.append(" AND ma.mafa_oid_cod_reem = mf2.oid_matr_fact");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                return null;
            }

            DTOProductoReemplazo dto = new DTOProductoReemplazo();
            dto.setCvReemplazo((String) r.getValueAt(0, "CV_REEMPLAZO"));

            if (r.getValueAt(0, "IND_ANTES_CUADRE") != null) {
                if (((BigDecimal) r.getValueAt(0, "IND_ANTES_CUADRE")).longValue() == 1) {
                    dto.setIndAntesCuadre(Boolean.TRUE);
                } else {
                    dto.setIndAntesCuadre(Boolean.FALSE);
                }
            }

            if (r.getValueAt(0, "IND_MENSAJE") != null) {
                if (((BigDecimal) r.getValueAt(0, "IND_MENSAJE")).longValue() == 1) {
                    dto.setIndMensaje(Boolean.TRUE);
                } else {
                    dto.setIndMensaje(Boolean.FALSE);
                }
            }

            dto.setPrecioCatalogoReemplazo((BigDecimal) r.getValueAt(0, "PRECIO_CATALOGO"));
            //UtilidadesLog.debug("MONMantenimientoMF.obtenerProductoReemplazo a setear prod oid prod ");

            if (r.getValueAt(0, "PROD_OID_PROD") != null) {
                Long tmpOidProd = null;
                tmpOidProd = new Long(((BigDecimal) r.getValueAt(0, "PROD_OID_PROD")).longValue());
                //UtilidadesLog.debug("MONMantenimientoMF.obtenerProductoReemplazo tmpOidProd= " + tmpOidProd);
                dto.setOidProducto(tmpOidProd);
            }

            //UtilidadesLog.debug("MONMantenimientoMF.obtenerProductoReemplazo a setear OID_DETA_OFER ");

            if (r.getValueAt(0, "OID_DETA_OFER") != null) {
                Long tmpOidOfer = null;
                tmpOidOfer = new Long(((BigDecimal) r.getValueAt(0, "OID_DETA_OFER")).longValue());
                //UtilidadesLog.debug("MONMantenimientoMF.obtenerProductoReemplazo tmpOidOfer=" + tmpOidOfer);
                dto.setOidDetalleOferta(tmpOidOfer);
            }

            UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoReemplazo(DTOProductoReemplazo dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT DT1.VAL_CODI_VENT CODIGO_PRINCIPAL  ");
            query.append(" , MR.TICL_OID_TIPO_CLIE, MR.SBTI_OID_SUBTI_CLIEN, MR.TCCL_OID_TIPO_CLAS, MR.CLAS_OID_CLAS, MR.ZORG_OID_REGI, MR.ZZON_OID_ZONA ");            
            query.append(" FROM PRE_MATRI_FACTU_CABEC CM1, PRE_MATRI_FACTU_CABEC CM2, PRE_OFERT_DETAL DT1, ");
            query.append(" PRE_OFERT_DETAL DT2, PRE_MATRI_FACTU MF1, PRE_MATRI_FACTU MF2, PRE_MATRI_RECUP MR ");
            query.append(" where ");
            query.append(" MR.MAFA_OID_COD_PPAL = MF1.OID_MATR_FACT AND ");
            query.append(" MR.MAFA_OID_COD_RECU = MF2.OID_MATR_FACT AND ");
            query.append(" MF1.MFCA_OID_CABE = CM1.OID_CABE AND ");
            query.append(" MF2.MFCA_OID_CABE = CM2.OID_CABE AND ");

            if (dtoe.getPeriodoActual() != null) {
                query.append(" CM1.PERD_OID_PERI = " + dtoe.getPeriodoActual() + " AND ");
            }

            if (dtoe.getPeriodoFaltante() != null) {
                query.append(" CM2.PERD_OID_PERI = " + dtoe.getPeriodoFaltante() + " AND ");
            }

            if (dtoe.getCodigoVentaFaltante() != null) {
                query.append(" DT2.VAL_CODI_VENT = '" + dtoe.getCodigoVentaFaltante() + "' AND ");
            }

            query.append(" DT1.OID_DETA_OFER = MF1.OFDE_OID_DETA_OFER AND ");
            query.append(" DT2.OID_DETA_OFER = MF2.OFDE_OID_DETA_OFER ");
            
            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe): Salida");
                return null;
            }

            //filtrado de Reemplazos que no correspondan al cliente en cuestion dada su tipificacion y unidad administrativa
             DTOTipifYUnidadAdminCliente dtoTipifYUa = dtoe.getTipifYUa();
             
            UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo - comienza filtrado.");
            ArrayList posicOK = new ArrayList();
            for (int i = 0 ; i< r.getRowCount() ; i++){               
                
                Long oidTiCliR = bigDecimalToLong(r.getValueAt(i, "TICL_OID_TIPO_CLIE"));
                Long oidSbtCliR = bigDecimalToLong(r.getValueAt(i, "SBTI_OID_SUBTI_CLIEN"));
                Long oidTClasR = bigDecimalToLong(r.getValueAt(i, "TCCL_OID_TIPO_CLAS"));
                Long oidClasR = bigDecimalToLong(r.getValueAt(i, "CLAS_OID_CLAS"));                    
                Long oidRegR = bigDecimalToLong(r.getValueAt(i, "ZORG_OID_REGI"));
                Long oidZonR = bigDecimalToLong(r.getValueAt(i, "ZZON_OID_ZONA"));                    
                
                boolean tipifOK= false;
                ArrayList tipificaciones = dtoTipifYUa.getTipificaciones();                     
                
                //validamos tipificaciones si cumple con alguna de es OK
                for (int j=0; j<tipificaciones.size(); j++)  {
                
                    DTOTipificacion dtoTipif = (DTOTipificacion)tipificaciones.get(j);                        
                    Long oidTiCli = dtoTipif.getOidTipoCliente();
                    Long oidSbtCli = dtoTipif.getOidSubtipoCliente();
                    Long oidTClas = dtoTipif.getOidTipoClasificacion();                        
                    Long oidClas = dtoTipif.getOidClasificacion();                                               
                    
                    UtilidadesLog.debug("validando la tipificacion");
                    if (oidTiCliR == null) {
                        //Remplazo sin tipificacion definida, va siempre
                        tipifOK = true;
                    } else if (oidTiCliR.equals(oidTiCli)) {
                            if (oidSbtCliR == null) {                                    
                                tipifOK = true;
                            } else if (oidSbtCliR.equals(oidSbtCli)) {
                                if (oidTClasR == null) {                                    
                                    tipifOK = true;
                                } else if (oidTClasR.equals(oidTClas)) {
                                    if (oidClasR == null) {                                    
                                        tipifOK = true;
                                    } else if (oidClasR.equals(oidClas)) {
                                        tipifOK = true;
                                    }
                                }
                            }
                    }
                }//for tipif
                
                boolean uniAdmOK = false;
                ArrayList unidAdm = dtoTipifYUa.getUnidadesAdmin();
                
                if (tipifOK)  { //continuo validando la unidad administrativa, si cumple con alguna es OK
                    UtilidadesLog.debug("continuo validando la unidades administrativas");
                    for (int j=0; j<unidAdm.size(); j++)  {
                            DTOUnidadAdministrativa dtoUA = (DTOUnidadAdministrativa)unidAdm.get(j);                        
                            Long oidZon = dtoUA.getOidZona();
                            Long oidReg = dtoUA.getOidRegion();
                                                            
                            if (oidRegR == null) {
                                //Remplazo sin ua definida
                                uniAdmOK = true;
                            } else if (oidRegR.equals(oidReg)) {
                                    if (oidZonR == null) {                                    
                                        uniAdmOK = true;
                                    } else if (oidZonR.equals(oidZon)) {                                            
                                        uniAdmOK = true;
                                    }
                            }                                
                    }//for unidad admin
                }//if tipifOK
                
                if (uniAdmOK)  {
                    //posible reemplazo, solo falta validar si se repite                            
                    posicOK.add(new Integer(i));
                }                    
            }//for recordset
                        
            //filtro los repetidos
            UtilidadesLog.debug("filtro los repetidos");
            ArrayList posicOKFinal = new ArrayList();
            ArrayList codVentOK = new ArrayList();
            
            for (int i = 0 ; i< posicOK.size() ; i++){
                String cvPpal = (String) r.getValueAt(((Integer)posicOK.get(i)).intValue(), "CODIGO_PRINCIPAL");
                if (i==0)  {
                    codVentOK.add(cvPpal);
                    posicOKFinal.add(posicOK.get(i));
                } else {
                    if (!codVentOK.contains(cvPpal)) {
                        codVentOK.add(cvPpal);
                        posicOKFinal.add(posicOK.get(i));
                    }
                }                    
            }
            
            //se filtra el recordset.
            for(int i = r.getRowCount(); i>=0; i--) {
                if (!posicOKFinal.contains(new Integer(i))){
                    r.removeRow(i);
                }                
            }
            
            if (r.esVacio()) {
                UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe): Salida");
                return null;
            }            
                            
            UtilidadesLog.info("DAOReemplazoProductos.obtenerProductoReemplazo - finaliza filtrado.");                
            //FIN filtrado de Reemplazos que no correspondan al cliente en cuestion dada su tipificacion y unidad administrativa

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);

            UtilidadesLog.info("MONMantenimientoMFBean.obtenerProductoRecuperacion(DTOObtenerProductoRecuperacion dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public void actualizarMatrizFacturada(Long oidPeriodo, Boolean estado) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.actualizarMatrizFacturada(Long oidPeriodo, Boolean estado): Entrada");
        try {
        
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            CabeceraMFLocal instancia = cmflh.findByUK(oidPeriodo);
            
            if ((instancia.getMatrizFacturada() == null) || (instancia.getMatrizFacturada().booleanValue() != estado.booleanValue())){
                instancia.setMatrizFacturada(estado);
            }
            
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONMantenimientoMFBean.actualizarMatrizFacturada(Long oidPeriodo, Boolean estado): Salida");
    }

    private String obtenerUltimoRangoTipo(Long oidEstrategia, Integer longTipo) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoTipo(Long oidEstrategia, Integer longTipo): Entrada");

        try {
            //OfertaLocalHome olh = this.getOfertaLocalHome();
            BelcorpService bs = BelcorpService.getInstance();
            StringBuffer sql = new StringBuffer("");
            sql.append(" select p.OID_OFER from pre_ofert p where p.COES_OID_ESTR = " + oidEstrategia.toString());

            RecordSet r = bs.dbService.executeStaticQuery(sql.toString());
            //UtilidadesLog.debug("R: " + r);

            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            String resultado = null;
            long mayorTipo = 0;
            boolean entro = false;

            if (!r.esVacio()) {
                Vector v = new Vector();

                for (int i = 0; i < r.getRowCount(); i++) {
                    //UtilidadesLog.debug("Bucle " + i);

                    BigDecimal oidBuffer = (BigDecimal) r.getValueAt(i, 0);
                    Long oidPosta = new Long(oidBuffer.longValue());
                    v.add(oidPosta);
                }

                //UtilidadesLog.debug("obtiene iterator");

                Iterator itcol = v.iterator();

                while (itcol.hasNext()) {
                    Long oidOferta = (Long) itcol.next();
                    Collection colDet = dolh.findByOidOfer(oidOferta);

                    //UtilidadesLog.info("First While");
                    if (!colDet.isEmpty()) {
                        Iterator itDet = colDet.iterator();

                        while (itDet.hasNext()) {
                            //UtilidadesLog.info("Second While");                        
                            DetalleOfertaLocal dol = (DetalleOfertaLocal) itDet.next();

                            if ((dol.getCodigoVentaGenerado() != null) && (dol.getCodigoVentaGenerado().booleanValue() == true)) {
                                String tipoActual = dol.getCodigoVenta().substring(0, longTipo.intValue());
                                long ntipoActual = (new Long(tipoActual)).longValue();

                                //UtilidadesLog.info("Chequeo Mayor");
                                if (mayorTipo < ntipoActual) {
                                    mayorTipo = ntipoActual;
                                    entro = true;
                                }
                            }
                        }
                    } else {
                        UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoTipo(Long oidEstrategia, Integer longTipo): Salida");
                        return null;
                    }
                }
            } else {
                UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoTipo(Long oidEstrategia, Integer longTipo): Salida");
                return null;
            }

            resultado = (new Long(mayorTipo)).toString();

            UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoTipo(Long oidEstrategia, Integer longTipo): Salida");
            if (!entro) {
                return null;
            } else {
                return resultado;
            }
        } catch (NoResultException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    //Nota:
    private String obtenerUltimoRangoSerie(Long oidEstrategia, Integer longSerie) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoSerie(Long oidEstrategia, Integer longSerie): Entrada");
        
        //UtilidadesLog.debug("--- obtenerUltimoRangoSerie, longSerie: " + longSerie);

        try {
            //OfertaLocalHome olh = this.getOfertaLocalHome();

            //Collection colOfer = olh.findByOidCabeOidEstr(oidCabeceraMF, oidEstrategia);
            BelcorpService bs = BelcorpService.getInstance();
            StringBuffer sql = new StringBuffer("");
            sql.append(" select p.OID_OFER from pre_ofert p where p.COES_OID_ESTR = " + oidEstrategia.toString());

            RecordSet r = bs.dbService.executeStaticQuery(sql.toString());
            //UtilidadesLog.debug("r: " + r);

            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            String resultado = null;
            long mayorSerie = 0;
            boolean entro = false;

            if (!r.esVacio()) {
                Vector v = new Vector();
                //UtilidadesLog.debug("1");

                for (int i = 0; i < r.getRowCount(); i++) {
                    //UtilidadesLog.debug("Bucle " + i);

                    BigDecimal oidBuffer = (BigDecimal) r.getValueAt(i, 0);
                    Long oidPosta = new Long(oidBuffer.longValue());
                    v.add(oidPosta);
                }

                //UtilidadesLog.debug("Sale");
                //UtilidadesLog.debug("v: " + v);

                //Iterator itcol = v.iterator();

                for (int j = 0; j < v.size(); j++) {
                    

                    Long ol = (Long) v.get(j);
                    

                    Collection colDet = dolh.findByOidOfer(ol);

                    if (!colDet.isEmpty()) {
                        

                        Iterator itDet = colDet.iterator();

                        while (itDet.hasNext()) {
                            

                            DetalleOfertaLocal dol = (DetalleOfertaLocal) itDet.next();
                            //UtilidadesLog.debug("**** Oferta " + ol + " - DetalleOferta " + dol.getOid());

                            if ((dol.getCodigoVentaGenerado() != null) && (dol.getCodigoVentaGenerado().booleanValue() == true)) {
                                
                                

                                String serieActual = dol.getCodigoVenta().substring(((dol.getCodigoVenta().length()) - longSerie.intValue()), dol.getCodigoVenta().length());
                                

                                long nserieActual = (new Long(serieActual)).longValue();
                                

                                if (mayorSerie < nserieActual) {
                                    mayorSerie = nserieActual;
                                    entro = true;
                                }
                            }
                        }
                    } else {
                        UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoSerie(Long oidEstrategia, Integer longSerie): Salida");
                        return null;
                    }
                }
            } else {
                UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoSerie(Long oidEstrategia, Integer longSerie): Salida");
                return null;
            }

            resultado = (new Long(mayorSerie)).toString();

            UtilidadesLog.info("MONMantenimientoMFBean.obtenerUltimoRangoSerie(Long oidEstrategia, Integer longSerie): Salida");
            if (!entro) {
                return null;
            } else {
                return resultado;
            }
        } catch (NoResultException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }


    /**
    * Autor: Guido Pons
    * Fecha 02/05/2006
    * Modificación a la query según incidencia BELC300021639 
    */
    /**
     * Autor: Cortaberría
     * Fecha: 22/03/2005
     * Modificación a la query segun incidencia BELC300013377 (se agrego el campo
     * OID_DETA_OFER al select) y las condiciones:
     * 1.- oid del registro encontrado > DTOE.indicadorSituacion
     * 2.- ROWNUM <= DTOE.tamañoPagina
     */
    /**
    * Autor: Cortaberría
    * Fecha: 04/04/2005
    * Se modifica las consultas anidadas
    */
    public DTOSalida obtenerCodigosVenta(DTOInfoProducto dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerCodigosVenta(DTOInfoProducto dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
        
            StringBuffer query = new StringBuffer("SELECT deta.val_codi_vent, deta.val_text_brev, c.val_i18n, ");
            query.append ("b.val_i18n, deta.oid_deta_ofer OID ");
            query.append (" FROM pre_ofert_detal deta, v_gen_i18n_sicc b, v_gen_i18n_sicc c, pre_ofert ofe, pre_matri_factu_cabec mfc");
            query.append (" WHERE prod_oid_prod = " + dtoe.getOidProducto());
            query.append (" AND ind_digi = 1");
            query.append (" AND c.attr_enti = 'PRE_TIPO_OFERT'");
            query.append (" AND c.attr_num_atri = 1");
            query.append (" AND c.idio_oid_idio = " + dtoe.getOidIdioma());
            query.append (" AND c.val_oid = deta.tofe_oid_tipo_ofer");
            query.append (" AND b.attr_enti = 'PRE_CICLO_VIDA'");
            query.append (" AND b.idio_oid_idio = " + dtoe.getOidIdioma());
            query.append (" AND b.attr_num_atri = 1");
            query.append (" AND b.val_oid = deta.civi_oid_ciclo_vida");
            query.append (" AND val_codi_vent IS NOT NULL");
            query.append (" AND deta.ofer_oid_ofer = ofe.oid_ofer");
            if (dtoe.getAcceso() != null) {
                query.append (" AND (ofe.acce_oid_acce = " + dtoe.getAcceso() + " OR acce_oid_acce IS NULL)");
            }
            if (dtoe.getSubacceso() != null) {
                query.append (" AND (ofe.sbac_oid_sbac = " + dtoe.getSubacceso() + " OR sbac_oid_sbac IS NULL)");
            }
            query.append (" AND ofe.mfca_oid_cabe = mfc.oid_cabe");
            query.append (" AND mfc.perd_oid_peri = " + dtoe.getPeriodo());
            if (dtoe.getIndicadorSituacion() != null) {
                query.append (" AND deta.oid_deta_ofer > " + dtoe.getIndicadorSituacion());
            }   
            if (dtoe.getTamanioPagina() != null) {
                query.append (" AND ROWNUM <= " + dtoe.getTamanioPagina());
            }
            query.append (" ORDER BY deta.oid_deta_ofer");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                UtilidadesLog.info("MONMantenimientoMFBean.obtenerCodigosVenta(DTOInfoProducto dtoe): Salida");
                return null;
            }

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONMantenimientoMFBean.obtenerCodigosVenta(DTOInfoProducto dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
     * Autor Cortaberría
     * Fecha 4/4/05
     * Incidencia BELC300013377
     */
    public DTOSalida buscarProductosRegistro(DTOBuscarProductosRegistro dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarProductosRegistro(DTOBuscarProductosRegistro dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            // Si alguno de los criterios es Null, no se utilizará para la búsqueda 
            // Las descripciones pueden utilizar comodines. 
            StringBuffer query = new StringBuffer();
            /*
             * DBLG400000392 - dmorello, 21/03/2006
             * La query que recupera OID, CODIGO_VENTA, etc. pasa a ser una
             * subquery. Habrá cuatro niveles.
             */
            query.append(" SELECT * ");
            query.append(" FROM ( ");
            // dmorello, 15/03/2006: Se quita DISTINCT para adecuar al modelo.
            // DBLG400000392 - dmorello, 21/03/2006: Vuelve el DISTINCT
            query.append(" SELECT DISTINCT  ");
            query.append(" OD.OID_DETA_OFER OID_DETA_OFER, ");
            query.append(" OD.VAL_CODI_VENT CODIGO_VENTA, ");
            query.append(" OD.VAL_TEXT_BREV DESCRIPCION_CORTA, ");
            query.append(" MAE_I18N.VAL_I18N DESCRIPCION_LARGA, ");
            query.append(" ST.VAL_SALD CANTIDAD, ");
            query.append(" OD.IMP_PREC_CATA PRECIO ");

            query.append(" FROM ");
            query.append(" PRE_OFERT_DETAL OD, ");
            if (dtoe.getOidLineaProducto() != null) {
              query.append(" MAE_PRODU MP, ");
            }
            query.append(" GEN_I18N_SICC MAE_I18N, ");
            query.append(" BEL_STOCK ST, ");
            query.append(" BEL_ESTAD_MERCA ES, ");
            query.append(" PRE_OFERT O, ");
            query.append(" PRE_MATRI_FACTU_CABEC MFC, ");
            query.append(" PED_TIPO_SOLIC_PAIS PTS ");

            query.append(" WHERE 1=1");

            /* CATALOGO */
            if (dtoe.getOidCatalogo() != null) {
                query.append(" AND OD.OCAT_OID_CATAL = " + dtoe.getOidCatalogo());
            }

            /* PAGINA CATALOGO */
            if (dtoe.getPagina() != null) {
                query.append(" AND OD.NUM_PAGI_CATA = " + dtoe.getPagina());
            }

            /* LINEA PRODUCTO */
            query.append(" AND OD.PROD_OID_PROD = MAE_I18N.VAL_OID ");

            if (dtoe.getOidLineaProducto() != null) {
                query.append(" AND MP.LIPR_OID_LINE_PROD = " + dtoe.getOidLineaProducto());
                query.append(" AND MP.OID_PROD = OD.PROD_OID_PROD " );
            }

            /* DESCRIPCION MAE */            
            query.append(" AND MAE_I18N.ATTR_NUM_ATRI = 1  ");

            if (dtoe.getOidIdioma() != null) {
                query.append(" AND MAE_I18N.IDIO_OID_IDIO = " + dtoe.getOidIdioma());
            }

            query.append(" AND MAE_I18N.ATTR_ENTI = 'MAE_PRODU'");

            if (dtoe.getDescripcionLarga() != null) {
                query.append(" AND MAE_I18N.VAL_I18N LIKE '" + dtoe.getDescripcionLarga() + "'");
            }

            /* PRECIO CATALOGO */
            if (dtoe.getPrecioDesde() != null) {
                query.append(" AND OD.IMP_PREC_CATA >= " + dtoe.getPrecioDesde());
            }

            if (dtoe.getPrecioHasta() != null) {
                query.append(" AND OD.IMP_PREC_CATA <= " + dtoe.getPrecioHasta());
            }

            /* DESCRIPCION PRE */
            if (dtoe.getDescripcionCorta() != null) {
                query.append(" AND OD.VAL_TEXT_BREV LIKE '" + dtoe.getDescripcionCorta() + "'");
            }

            /* STOCK */

            //      if(dtoe.getOidAlmacen()!=null)
            //        query.append(" AND SC.OID_SOLI_CABE = " + dtoe.getOidAlmacen());
            if (dtoe.getOidAlmacen() != null) {
                query.append(" AND ST.ALMC_OID_ALMA = " + dtoe.getOidAlmacen());
            } 

            //query.append(" AND ST.ALMC_OID_ALMA = SC.ALMC_OID_ALMA");
            query.append(" AND ST.PROD_OID_PROD = OD.PROD_OID_PROD");
            query.append(" AND ST.ESME_OID_ESTA_MERC = ES.OID_ESTA_MERC");

            //if(ConstantesBEL.COD_EST_LIBRE_DISP!=null)
            query.append(" AND ES.COD_ESTA = '" + ConstantesBEL.COD_EST_LIBRE_DISP + "'");

            if (dtoe.getOidPais() != null) {
                query.append(" AND ES.PAIS_OID_PAIS = " + dtoe.getOidPais());
            }

            /* ACCESO, SUBACCESO */
            query.append(" AND O.OID_OFER = OD.OFER_OID_OFER ");

            if (dtoe.getAcceso() != null) {
                query.append(" AND (O.ACCE_OID_ACCE = ").append(dtoe.getAcceso()).append(" OR O.ACCE_OID_ACCE IS NULL) ");
            }

            if (dtoe.getSubacceso() != null) {
                query.append(" AND (O.SBAC_OID_SBAC = ").append(dtoe.getSubacceso()).append(" OR O.SBAC_OID_SBAC IS NULL) ");
            }

            /* PERIODO */
            if (dtoe.getPeriodo() != null) {
                query.append(" AND MFC.PERD_OID_PERI = ").append(dtoe.getPeriodo());
            }

            query.append(" AND MFC.OID_CABE = O.MFCA_OID_CABE ");

            /* DIGITABLE */
            query.append(" AND OD.IND_DIGI = 1 ");
            
            //INCIDENCIA DBLG400000393
            //No se muestran los productos que no tengan stock
            //disponible, ya que no se pueden seleccionar.
            query.append(" AND st.val_sald > 0");
            
            if(dtoe.getOidTipoSolicitud()!=null)  {
                query.append(" AND pts.PAIS_OID_PAIS = "+dtoe.getOidPais());
                //query.append(" AND pts.TSOL_OID_TIPO_SOLI = "+dtoe.getOidTipoSolicitud().toString());
                query.append(" AND pts.OID_TIPO_SOLI_PAIS = "+dtoe.getOidTipoSolicitud().toString());
                query.append(" AND st.ALMC_OID_ALMA = pts.ALMC_OID_ALMA "); 
            }else  {
                UtilidadesLog.debug("No tenia el tipo de solicitud, por lo que no se filtra por alamacen");
            }


            /*Incidencia BELC300013377*/
            /*
             * DBLG400000392 - dmorello, 21/03/2006
             * El OID_DETA_OFER ya no se usara para indicar situación
             */
            //if (dtoe.getIndicadorSituacion() != null) {
            //    query.append(" AND OD.OID_DETA_OFER > ").append(dtoe.getIndicadorSituacion());
            //}

            /*
            if(dtoe.getTamanioPagina() != null)
              query.append(" AND ROWNUM <= ").append(dtoe.getTamanioPagina());
              */
            // DBLG400000392 - dmorello, 21/03/2006: Cambia el ordenamiento
            query.append(" ORDER BY CODIGO_VENTA, DESCRIPCION_CORTA, ");
            query.append(" DESCRIPCION_LARGA, CANTIDAD, PRECIO ");
            
            query.append(" ) ");
            
            /*
             * DBLG400000392 - dmorello, 21/03/2006
             * Se usará el campo OID creado para indicar situación.
             */
            if (dtoe.getIndicadorSituacion() == null) {
                dtoe.setIndicadorSituacion(new Long(0));
            }
            query.append(" WHERE ROWNUM > ").append(dtoe.getIndicadorSituacion());
           

            if (dtoe.getTamanioPagina() == null) {
                dtoe.setTamanioPagina(new Integer(20));
            }
            query.append(" AND ROWNUM <= ").append(dtoe.getTamanioPagina());

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            DTOSalida dtos = new DTOSalida();
            dtos.setResultado(r);
            
            UtilidadesLog.info("MONMantenimientoMFBean.buscarProductosRegistro(DTOBuscarProductosRegistro dtoe): Salida");
            return dtos;
        } catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

   /**
    * @throws es.indra.mare.common.exception.MareException
    * @return Long
    * @param codigoVenta
    * @autor jpbosnja
    */
    public Long buscarProductoCV(String codigoVenta, Long periodo) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.buscarProductoCV(String codigoVenta, Long periodo): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            // Si alguno de los criterios es Null, no se utilizará para la búsqueda 
            // Las descripciones pueden utilizar comodines. 
            StringBuffer query = new StringBuffer(" SELECT ");
            query.append(" d.PROD_OID_PROD FROM ");
            query.append(" PRE_OFERT_DETAL d, PRE_OFERT o, PRE_MATRI_FACTU_CABEC c ");
            query.append(" where d.OFER_OID_OFER = o.OID_OFER and ");
            query.append(" d.VAL_CODI_VENT = '" + codigoVenta + "' AND");
            query.append(" o.MFCA_OID_CABE = c.OID_CABE and ");
            query.append(" c.PERD_OID_PERI = " + periodo);

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                UtilidadesLog.info("MONMantenimientoMFBean.buscarProductoCV(String codigoVenta, Long periodo): Salida");
                return null;
            }
            
            UtilidadesLog.info("MONMantenimientoMFBean.buscarProductoCV(String codigoVenta, Long periodo): Salida");
            return Long.valueOf(r.getValueAt(0, 0).toString());
            
        } catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }
    
   private MONValidacionHome getMONValidacionHome() throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.getMONValidacionHome(): Entrada");
        
        MONValidacionHome mONValidacionHome = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            mONValidacionHome = (MONValidacionHome) bs.ejbLocator.getHome("MONValidacion", MONValidacionHome.class);
        } catch (MareServiceException e) {
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONMantenimientoMFBean.getMONValidacionHome(): Salida");
        return mONValidacionHome;
    }

    private PeriodoLocalHome getPeriodoLocalHome() throws NamingException {
        return new PeriodoLocalHome();
    }
    
    private MarcaLocalHome getMarcaLocalHome() throws NamingException {
        return new MarcaLocalHome();
    }
    
    private MONPeriodosHome getMONPeriodosHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONPeriodosHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONPeriodos"), MONPeriodosHome.class);
    }

    private MONOfertaHome getMONOfertaHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONOfertaHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONOferta"), MONOfertaHome.class);
    }

    private MONConfiguracionMFHome getMONConfiguracionMFHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONConfiguracionMFHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConfiguracionMF"), MONConfiguracionMFHome.class);
    }
    
    private MONProductosHome getMONProductosHome() throws NamingException
    {
        final InitialContext context = new InitialContext();
        return (MONProductosHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONProductos"), MONProductosHome.class);
    }
    /**
     * @author pperanzola
     * @date 12/10/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dto
     * 
        Descripción: invoca al metodo del DAO que traera los datos necesarios para cargar el combo. 
        Implementación: 
        Llamar al método PREConsultas.obtenerVariante y se obtiene un Recorset 
        Crear dtos del tipo DTOSalida y a dtos.resultado asignarle el recorset obtenido 
        Devolver dtos 
     * 
     */
    public DTOSalida obtenerVariantes(DTOBelcorp dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerVariantes(DTOBelcorp dto): Entrada");
        PREConsultas prCon = new PREConsultas();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(prCon.obtenerVariantes(dto));
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerVariantes(DTOBelcorp dto): Salida");
        return dtoS;
    }
    
    private boolean incluirOfertaEnMatriz(Long oidOferta, Long programaFidelizacion, Long variante) {
      UtilidadesLog.info("MONMantenimientoMFBean.incluirOfertaEnMatriz(Long oidOferta, Long programaFidelizacion, Long variante):Entrada");
      try{
        DetalleOfertaLocalHome detalleOferHome = new DetalleOfertaLocalHome();
        Collection detalles = detalleOferHome.findByOidOfer(oidOferta);
        Iterator itDetalles = detalles.iterator();
        DetalleOfertaLocal detalle = null;        
        
        while (itDetalles.hasNext()) {
            detalle = (DetalleOfertaLocal) itDetalles.next();
            if (((programaFidelizacion!=null&&programaFidelizacion.equals(detalle.getProgramaFidelizacion()))||
                 (programaFidelizacion==null))&&
                ((variante!=null&&variante.equals(detalle.getVariante()))||
                 (variante==null))){
                   UtilidadesLog.debug("El detalle:"+detalle.getOid()+" cumple con los criterios de club priviledges ");
                   UtilidadesLog.debug("Prog.Fide.:"+programaFidelizacion+" variante:"+variante+" por lo tanto se ");
                   UtilidadesLog.debug("incluira la oferta:"+oidOferta+" en la nueva matriz.");
                   UtilidadesLog.info("MONMantenimientoMFBean.incluirOfertaEnMatriz(Long oidOferta, Long programaFidelizacion, Long variante):Salida");
                   return true;
                 }
        }
        UtilidadesLog.debug("La oferta:"+oidOferta+" no será incluida en la nueva matriz por no cumplir ninguno de ");
        UtilidadesLog.debug("sus detalles con los criterios: Progr. Fidel.:"+programaFidelizacion+" variante"+variante);
        UtilidadesLog.info("MONMantenimientoMFBean.incluirOfertaEnMatriz(Long oidOferta, Long programaFidelizacion, Long variante):Salida");
        return false;
        
      } catch (NoResultException fe) {
        UtilidadesLog.error("La oferta:"+oidOferta+" no posee Detalles.");
        return false;
      }   
    }
    
    private Long bigDecimalToLong(Object numero) {
    
        if (numero != null) {
            return new Long(((BigDecimal) numero).longValue());
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

    public String insertarProductoEnMatriz(DTOProductoMatriz dto) throws MareException{
        UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(DTOProductoMatriz dto): Entrada");
        //UtilidadesLog.debug("********* DTOProductoMatriz: " + dto);

        //se const. segun inc.: 5276
        //Se elimina del if dto.getOidPeriodoFin() por incidencia 12257
        if ((dto == null) || (dto.getOidCanal() == null) || (dto.getOidCicloVida() == null) || (dto.getOidEstrategia() == null) || (dto.getOidMarca() == null) || (dto.getOidPeriodo() == null) || (dto.getOidSAP() == null) || (dto.getOidTipoOferta() == null) || (dto.getPrecioCatalogo() == null) || (dto.getPrecioContable() == null)) {
            //UtilidadesLog.debug("el dto de entrada, no esta completo...........!!");
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0034));
        }

        //si hay mas de un periodo todo se aplica para todos los periodos q' hubiere, caso
        //contrario se aplica solo para el periodo inicial
        //para lo cual meto el/los periodos dentro de un array, se ciclara 1 vez, o mas de 1.
        try {
            Vector listaOidsPeriodos = new Vector();

            //if(dto.getOidPeriodoFin()!=null){ //Incidencia 12257
            if ((dto.getOidPeriodoFin() != null) && (dto.getOidPeriodoFin().longValue() != dto.getOidPeriodo().longValue())) {
                if (dto.getOidPeriodoFin().longValue() != dto.getOidPeriodo().longValue()) {
                    //UtilidadesLog.debug("--- Periodo Inicio es distinto de Periodo Fin");

                    DTOOIDs oids = new DTOOIDs();
                    oids = getMONPeriodosHome().create().obtienePeriodosEntre(dto.getOidPeriodo(), dto.getOidPeriodoFin());

                    if (oids.getOids() == null) {
                        return null;
                    }

                    Long[] oidsA = oids.getOids();

                    //mas de un periodo, los meto dentro del vector
                    for (int i = 0; i < oidsA.length; i++) {
                        //UtilidadesLog.debug(" Periodo a tratar: " + oidsA[i].toString());
                        listaOidsPeriodos.add(oidsA[i]);
                    }
                }
            } else {
                //solo uno
                //UtilidadesLog.debug("--- Hay un solo periodo: " + dto.getOidPeriodo());
                listaOidsPeriodos.add(dto.getOidPeriodo());
            }

            //ahora recorro el vector, tendra 1 o mas de una posc. ....
            Enumeration elementosListaOids = listaOidsPeriodos.elements();
            //Long cabecera = new Long(0);
            //MONOfertaHome moh = this.getMONOfertaHome();
            //MONOferta mo = moh.create();

            // Se descarta que haya al menos 1 período, por lo que la primera vez
            // se realiza la inserción correspondiente y de paso se obtiene el Codigo de Venta
            // que se usará luego en las Cabeceras posteriores, si existe más de 1 periodo.
            Long periodoP = (Long) elementosListaOids.nextElement();
            Object[] retorno = this.insertarProductoEnMatriz(periodoP, dto);

            //  4.- Creamos el producto en la matriz de facturacion correspondiente asignando un código de venta. 
            String codigoUnicoVenta = null;
            try{
               codigoUnicoVenta =   buscarMayorCUV(listaOidsPeriodos);
            }catch (MareException e){
                //cuvMax > ConstantesPRE.MAYOR_NUMERO_CUV        
                e.printStackTrace();
                ctx.setRollbackOnly();
                UtilidadesLog.error("cuvMax > ConstantesPRE.MAYOR_NUMERO_CUV");
                return null;
            }

            DTOOferta dtoOf = (DTOOferta) retorno[1];
            DetalleOfertaLocal lOidDOf = (DetalleOfertaLocal) retorno[0];
            OfertaLocalHome olh = new OfertaLocalHome();
            OfertaLocal oferLocal = olh.findByPrimaryKey(lOidDOf.getOidOfer());
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            
            
            DTOOID dtoOidTmp = new DTOOID();
            dtoOidTmp.setOid(dto.getOidSAP());
            
            //MONOferta monOferta = this.getMONOfertaHome().create();
            //MONProductosHome monProductosHome = this.getMONProductosHome();
            //MONProductos monProductos = monProductosHome.create();
            
            /* No figuraba construido esta parte. Se deja comentado hasta tanto se 
             * aclare el cambio de CUV pedido por Peru a ENoziglia - ssantana, 11/07/2006*/
            /*String sCUVProducto = monProductos.obtenerCUV(dtoOidTmp);
            
            cabecera = existeCMFparaPeriodo((Long) elementosListaOids.nextElement());
            if (monOferta.existeOtroProductoAsignado(sCUVProducto, cabecera)) {
               monOferta.asignarAdicional(sCUVProducto, lOidDOf,  oferLocal); 
            } else {
               lOidDOf.setCodigoVenta(sCUVProducto);
            }*/
            
            Long oidCabecera = dtoOf.getOidCabeceraMF();
            
            lOidDOf.setCodigoVenta(codigoUnicoVenta);
            lOidDOf.setCodigoVentaGenerado(Boolean.valueOf(true));

            //actualizo el estado: matrizFacturacionGenerada , dentro de la ent. oferta.
            lOidDOf.setMatrizGenerada(Boolean.valueOf(true));
            dolh.merge(lOidDOf);
            
            oferLocal.setCodigoVentaGenerado(Boolean.TRUE);
            oferLocal.setMatrizFacturacionGenerada(Boolean.valueOf(true));
            olh.merge(oferLocal);
            
            //guardo en matriz de f.
            MatrizFacturacionLocalHome matrizFLHome = new MatrizFacturacionLocalHome();
            MatrizFacturacionLocal matrizFL = matrizFLHome.create(dtoOf.getOidCabeceraMF(), 
                                                                  lOidDOf.getOid());
            if (listaOidsPeriodos.size() > 1) {
                while (elementosListaOids.hasMoreElements()) {
                    /*UtilidadesLog.debug(" *************************************** ");
                    UtilidadesLog.debug(" ***       Comienzo de Bucle         *** ");
                    UtilidadesLog.debug(" *************************************** ");*/

                    //DTOECabeceraMF dtoCMF = new DTOECabeceraMF();
                    Long elementoListaOids = (Long) elementosListaOids.nextElement();

                    oidCabecera = null;
                    retorno = this.insertarProductoEnMatriz(elementoListaOids, dto);

                    dtoOf = (DTOOferta) retorno[1];
                    oidCabecera = dtoOf.getOidCabeceraMF();

                    /*this.obtieneCodigoVentaMAV(dto.getOidPais(),
                                               dto.getOidMarca(),
                                               dto.getOidCanal(),
                                               dto.getOidEstrategia(),
                                               oidCabecera);*/
                    lOidDOf = (DetalleOfertaLocal) retorno[0];
                    //lOidDOf.setCodigoVenta(codigoVenta);
                    lOidDOf.setCodigoVenta(codigoUnicoVenta);
                    lOidDOf.setCodigoVentaGenerado(Boolean.valueOf(true));

                    //actualizo el estado: matrizFacturacionGenerada , dentro de la ent. oferta.
                    lOidDOf.setMatrizGenerada(Boolean.valueOf(true));                    
                    dolh.merge(lOidDOf);
                    //guardo en matriz de f.
                    matrizFLHome = new MatrizFacturacionLocalHome();
                    matrizFL = matrizFLHome.create(dtoOf.getOidCabeceraMF(), lOidDOf.getOid());
                    /* Para cada producto, en caso de haber creado más de uno,
                     * actualizamos su entrada correspondiente dentro de la entidad Oferta
                     */
                    oferLocal =  olh.findByPrimaryKey(lOidDOf.getOidOfer());
                    oferLocal.setCodigoVentaGenerado(Boolean.TRUE);
                    oferLocal.setMatrizFacturacionGenerada(Boolean.valueOf(true));
                    olh.merge(oferLocal);

                    //UtilidadesLog.debug("se creo Matriz F. con oid de cabecera: " + dtoOf.getOidCabeceraMF());
                }
            }

            //UtilidadesLog.debug(" ************************** Codigo de Venta a Retornar: " + codigoUnicoVenta);
            
            UtilidadesLog.info("MONMantenimientoMFBean.insertarProductoEnMatriz(DTOProductoMatriz dto): Salida");
            return codigoUnicoVenta;
        } catch (NamingException Ne) {
            UtilidadesLog.error("ERROR",Ne);
            ctx.setRollbackOnly();
            throw new MareException(Ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR",fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }catch (MareException me) {
            UtilidadesLog.error("ERROR",me);
            ctx.setRollbackOnly();
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOSalida buscarCodigoVentaPeriodo2(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException {

        UtilidadesLog.debug("MONMantenimientoMFBean.buscarCodigoVentaPeriodo2(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;        
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;

        if (dtoe.getPeriodo() != null) {
            try {
                belcorpService = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            //Buscamos la matriz de facturacion correspondiente
            rs = null;
            query = new StringBuffer();
            
            query.append(" SELECT d.oid_deta_ofer OID, d.VAL_CODI_VENT, p.COD_SAP, ");
            query.append("        (SELECT val_i18n ");
            query.append("           FROM gen_i18n_sicc i18 ");
            query.append("          WHERE i18.attr_enti = 'MAE_PRODU' ");
            query.append("            AND i18.attr_num_atri = 1 ");
            query.append("            AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
            query.append("            AND i18.val_oid = p.oid_prod) DES_SAP, ");
            query.append("        c.DES_CATA, d.num_pagi_cata, ");
            query.append("        d.IMP_PREC_CATA ");
            query.append("   FROM pre_ofert_detal d, ");
            query.append("        pre_catal c, ");
            query.append("        pre_ofert o, ");
            query.append("        pre_matri_factu_cabec m, ");
            query.append("        pre_matri_factu mf, ");
            query.append("        mae_produ p ");
            query.append("  WHERE d.ocat_oid_catal = c.oid_cata(+) ");
            query.append("    AND m.perd_oid_peri = "+dtoe.getPeriodo()+" ");
            query.append("    AND m.oid_cabe = o.mfca_oid_cabe ");
            query.append("    AND o.oid_ofer = d.ofer_oid_ofer ");
            query.append("    AND m.oid_cabe = o.mfca_oid_cabe ");
            query.append("    AND mf.ofde_oid_deta_ofer = d.oid_deta_ofer ");
            query.append("    AND mf.mfca_oid_cabe = m.oid_cabe ");
            query.append("    AND d.prod_oid_prod = p.oid_prod(+) ");
            if ((dtoe.getCodigoVenta() != null) && (dtoe.getCodigoVenta().length() > 0)) {
                query.append(" AND D.VAL_CODI_VENT LIKE '" + dtoe.getCodigoVenta() + "'");
            }
            if (dtoe.getCatalogo() != null) {
                query.append(" AND D.OCAT_OID_CATAL = " + dtoe.getCatalogo().toString());
            }
            if (dtoe.getPaginaDesde() != null) {
                query.append(" AND D.NUM_PAGI_CATA >= " + dtoe.getPaginaDesde().toString());
            }

            if (dtoe.getPaginaHasta() != null) {
                query.append(" AND d.NUM_PAGI_CATA <= " + dtoe.getPaginaHasta().toString());
            }
            if (dtoe.getCodigoSAP()!=null&&dtoe.getCodigoSAP().length()>0){
                query.append("    AND p.COD_SAP LIKE '" + dtoe.getCodigoSAP() + "'");
            }

            //Paginar la query
            String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);

            try {
                rs = belcorpService.dbService.executeStaticQuery(queryPaginada);
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            dtos = new DTOSalida();
            dtos.setResultado(rs);
        }

        if ((rs == null) || rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("MONMantenimientoMFBean.buscarCodigoVentaPeriodo2(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return dtos;

    }

    public DTOSalida buscarCodigoVentaPeriodo3(DTOBuscarCodigoVentaPeriodo dtoe) throws MareException {
        
        UtilidadesLog.debug("MONMantenimientoMFBean.buscarCodigoVentaPeriodo3(DTOBuscarCodigoVentaPeriodo dto): Entrada");
        
        StringBuffer query = new StringBuffer();
        RecordSet rs = null;        
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;

        if (dtoe.getPeriodo() != null) {
            try {
                belcorpService = BelcorpService.getInstance();
            } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
                UtilidadesLog.error(serviceNotFoundException);
                throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
            
            //Buscamos la matriz de facturacion correspondiente
            rs = null;
            query = new StringBuffer();
            
            query.append(" SELECT d.oid_deta_ofer OID, d.VAL_CODI_VENT || ' - ' || ");
            query.append("        (SELECT val_i18n ");
            query.append("           FROM gen_i18n_sicc i18 ");
            query.append("          WHERE i18.attr_enti = 'MAE_PRODU' ");
            query.append("            AND i18.attr_num_atri = 1 ");
            query.append("            AND i18.idio_oid_idio = "+dtoe.getOidIdioma()+" ");
            query.append("            AND i18.val_oid = p.oid_prod) DESCRIP ");
            query.append("   FROM pre_ofert_detal d, ");
            query.append("        pre_catal c, ");
            query.append("        pre_ofert o, ");
            query.append("        pre_matri_factu_cabec m, ");
            query.append("        pre_matri_factu mf, ");
            query.append("        mae_produ p ");
            query.append("  WHERE d.ocat_oid_catal = c.oid_cata(+) ");
            query.append("    AND m.perd_oid_peri = "+dtoe.getPeriodo()+" ");
            query.append("    AND m.oid_cabe = o.mfca_oid_cabe ");
            query.append("    AND o.oid_ofer = d.ofer_oid_ofer ");
            query.append("    AND m.oid_cabe = o.mfca_oid_cabe ");
            query.append("    AND mf.ofde_oid_deta_ofer = d.oid_deta_ofer ");
            query.append("    AND mf.mfca_oid_cabe = m.oid_cabe ");
            query.append("    AND d.prod_oid_prod = p.oid_prod(+) ");
            if ((dtoe.getCodigoVenta() != null) && (dtoe.getCodigoVenta().length() > 0)) {
                query.append(" AND D.VAL_CODI_VENT LIKE '" + dtoe.getCodigoVenta() + "'");
            }
            if (dtoe.getCatalogo() != null) {
                query.append(" AND D.OCAT_OID_CATAL = " + dtoe.getCatalogo().toString());
            }
            if (dtoe.getPaginaDesde() != null) {
                query.append(" AND D.NUM_PAGI_CATA >= " + dtoe.getPaginaDesde().toString());
            }

            if (dtoe.getPaginaHasta() != null) {
                query.append(" AND d.NUM_PAGI_CATA <= " + dtoe.getPaginaHasta().toString());
            }
            if (dtoe.getCodigoSAP()!=null&&dtoe.getCodigoSAP().length()>0){
                query.append("    AND p.COD_SAP LIKE '" + dtoe.getCodigoSAP() + "'");
            }

            //Paginar la query
            String queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dtoe);

            try {
                rs = belcorpService.dbService.executeStaticQuery(queryPaginada);
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            dtos = new DTOSalida();
            dtos.setResultado(rs);
        }

        if ((rs == null) || rs.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.debug("MONMantenimientoMFBean.buscarCodigoVentaPeriodo3(DTOBuscarCodigoVentaPeriodo dto): Salida");
        return dtos;
    }

    // vbongiov -- Cambio 20080746 -- 29/10/2008
    public DTOSalida obtenerTipoOfertaCopiar(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerTipoOfertaCopiar(DTOBelcorp dto): Entrada");
        PREConsultas prCon = new PREConsultas();
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(prCon.obtenerTipoOfertaCopiar(dtoe));
        UtilidadesLog.info("MONMantenimientoMFBean.obtenerTipoOfertaCopiar(DTOBelcorp dto): Salida");
        return dtoS;
    }
}
