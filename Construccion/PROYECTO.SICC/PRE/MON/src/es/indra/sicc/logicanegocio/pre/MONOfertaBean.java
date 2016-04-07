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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.mae.DTOBuscarProductosOferta;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.dtos.pre.DTOComprobarOrden;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOEBuscarOfertas;
import es.indra.sicc.dtos.pre.DTOEBuscarProductos;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOEOrdenOfertas;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOModificarOferta;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTORangoPrecios;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOTextoOferta;
import es.indra.sicc.dtos.pre.DTOValidacionRecuperacion;
import es.indra.sicc.dtos.pre.DTOValidacionesOferta;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocal;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.pre.CatalogoLocal;
import es.indra.sicc.entidades.pre.CatalogoLocalHome;
import es.indra.sicc.entidades.pre.ConfiguracionGPPaisLocal;
import es.indra.sicc.entidades.pre.ConfiguracionGPPaisLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaLocal;
import es.indra.sicc.entidades.pre.DetalleOfertaLocalHome;
import es.indra.sicc.entidades.pre.DetalleOfertaPrecioLocal;
import es.indra.sicc.entidades.pre.EstimadosVentaLocal;
import es.indra.sicc.entidades.pre.EstimadosVentaLocalHome;
import es.indra.sicc.entidades.pre.GrupoLocal;
import es.indra.sicc.entidades.pre.GrupoLocalHome;
import es.indra.sicc.entidades.pre.IndicadorCuadrePorTipoEstrategiaLocal;
import es.indra.sicc.entidades.pre.IndicadorCuadrePorTipoEstrategiaLocalHome;
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
import es.indra.sicc.entidades.pre.TextosOfertasLocal;
import es.indra.sicc.entidades.pre.TextosOfertasLocalHome;
import es.indra.sicc.entidades.pre.VentaExclusivaLocal;
import es.indra.sicc.entidades.pre.VentaExclusivaLocalHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEProductos;
import es.indra.sicc.logicanegocio.pre.ErroresNegocio;
import es.indra.sicc.logicanegocio.pre.PREConsultas;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.Cronometrador;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.entidades.pre.DetalleOfertaPrecioLocalHome;


import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;

import es.indra.sicc.logicanegocio.ccc.DAOCCC;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase
 * */
/**
 * 
 * @version 3.6 - 12 Sep 2005
 * @author Emilio Noziglia
 */  
public class MONOfertaBean implements SessionBean {

    private SessionContext ctx;
    
    // Agregado por SICC20070375 - Rafael Romero - 02/08/2007
    private boolean indUpdFormaPago;
    // Fin agregado SICC20070375

    public void ejbCreate() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void ejbRemove() { }

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    public DTOSalida buscarProductosEstimados(DTOEBuscarProductos dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarProductosEstimados(DTOEBuscarProductos dto): Entrada");
        
        try {
            RecordSet rs = new RecordSet();

            DTOSalida dtos = new DTOSalida();

            //String usuario = ctx.getCallerPrincipal().getName();

            BelcorpService belcorpService = BelcorpService.getInstance();

            //Obtencion del oidPeriodo
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            CabeceraMFLocal cmfl = cmflh.findByPrimaryKey(dto.getOidCabeceraMF());

            Long periodo = cmfl.getOidPeri();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT * FROM ( ");
            query.append(" SELECT p.OID_ESTIM_VENT OID, ");
            query.append(" mp.COD_SAP, g3.VAL_I18N DES_SAP, ");
            query.append(" p.IMP_PREC_CATA, p.NUM_PAGI_CATA, g1.VAL_I18N DES_TIPO_OFER, g2.VAL_I18N DES_CICL_VIDA, ");
            query.append(" mp.VAL_ATRI_1, mp.VAL_ATRI_2, mp.VAL_ATRI_3, ");
            query.append(" p.VAL_POSI_PAGI, p.NUM_UNID_ESTI, av.VAL_FACT_REPE, ");
            query.append(" p.IMP_VENT_NETA_ESTI, p.IMP_PREC_POSI, p.VAL_COST_ESTA, p.OCAT_OID_CATA, ");
            query.append(" pc.DES_CATA, p.TOFE_OID_TIPO_OFER, ");
            query.append(" p.CIVI_OID_CICL_VIDA,  p.VAL_CENT ");
            query.append(" , mp.DES_CORT, mp.OID_PROD, p.CNDP_OID_COND_PROM, p.PRFI_OID_PROG_FIDE ");
            query.append(" FROM PRE_ESTIM_VENTA p, PRE_ARGUM_VENTA av, PRE_CATAL pc, GEN_I18N_SICC g1, GEN_I18N_SICC g2, ");
            query.append(" MAE_PRODU mp, GEN_I18N_SICC g3, CRA_PERIO pe ");
            query.append(" WHERE p.ARGV_OID_ARGU_VENT = av.OID_ARGU_VENT ");
            query.append(" AND p.OCAT_OID_CATA = pc.OID_CATA ");
            query.append(" AND g1.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
            query.append(" AND g1.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g1.VAL_OID = p.TOFE_OID_TIPO_OFER ");
            query.append(" AND g2.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
            query.append(" AND g2.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g2.VAL_OID =  p.CIVI_OID_CICL_VIDA ");
            query.append(" AND g3.ATTR_ENTI = 'MAE_PRODU' ");
            query.append(" AND g3.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g3.VAL_OID =  p.PROD_OID_PROD ");
            // CUV-40 - dmorello, 18/09/2006 - Se eliminan resultados con CUV nulo
            query.append(" AND mp.COD_UNIC_VENT IS NOT NULL ");

            query.append(" AND p.PERD_OID_PERI = pe.OID_PERI ");
            query.append(" AND pe.OID_PERI = " + periodo + " ");

            if (dto.getOidMarca() != null) {
                query.append(" AND mp.MAPR_OID_MARC_PROD = " + dto.getOidMarca() + " ");
            }

            //query.append(" AND p.COES_OID_ESTR = " + dto.getOidEstrategia() + " ");
            if (dto.getOidAcceso() != null) {
                query.append(" AND p.ACCE_OID_ACCE = " + dto.getOidAcceso() + " ");
            }

            if (dto.getOidSubacceso() != null) {
                query.append(" AND p.SBAC_OID_SBAC = " + dto.getOidSubacceso() + " ");
            }

            query.append(" AND p.PROD_OID_PROD = mp.OID_PROD ");
            query.append(" AND mp.PAIS_OID_PAIS = " + dto.getOidPais() + " ");

            if (dto.getCodSAP() != null) {
                query.append(" AND mp.COD_SAP LIKE '" + dto.getCodSAP() + "' ");
            }

            if (dto.getDescripcionSAP() != null) {
                query.append(" AND g3.VAL_I18N LIKE '" + dto.getDescripcionSAP() + "' ");
            }

            /* mdolce 22/06/2006 Comentado por requerimiento del cliente
             * No se debe filtrar por catalogo.
             * if (dto.getOidCatalogo() != null) {
                query.append(" AND p.OCAT_OID_CATA = " + dto.getOidCatalogo() + " ");
            }*/

            if (dto.getPaginaDesde() != null) {
                query.append(" AND  p.NUM_PAGI_CATA >= " + dto.getPaginaDesde() + " ");
            }

            if (dto.getPaginaHasta() != null) {
                query.append(" AND  p.NUM_PAGI_CATA <= " + dto.getPaginaHasta() + " ");
            }

            query.append("ORDER BY OID  )  WHERE ROWNUM <= " + dto.getTamanioPagina().intValue() + " and OID > " + dto.getIndicadorSituacion().intValue() + " ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if (rs.esVacio()) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            dtos.setResultado(rs);
            
            UtilidadesLog.info("MONOfertaBean.buscarProductosEstimados(DTOEBuscarProductos dto): Salida");
            return dtos;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException); 
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (NoResultException nre) {
            UtilidadesLog.error(nre); 
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception); 
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOSalida buscarProductosMaestro(DTOEBuscarProductos dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarProductosMaestro(DTOEBuscarProductos dto): Entrada");
        
        DTOBuscarProductosOferta bpo = new DTOBuscarProductosOferta();
        DTOSalida sal = new DTOSalida();
        RecordSet r = new RecordSet();
        String user = ctx.getCallerPrincipal().getName();
        DAOMAEProductos dmp = new DAOMAEProductos(user);

        try {
            bpo.setCodigoSAP(dto.getCodSAP());
            bpo.setDescripcion(dto.getDescripcionSAP());
            bpo.setMarca(dto.getOidMarca());
            bpo.setLineaProducto(dto.getOidLineaProducto());
            bpo.setUnidadNegocio(dto.getOidUnidadNegocio());
            bpo.setNegocio(dto.getOidNegocio());
            bpo.setGenerico(dto.getOidGenerico());
            bpo.setSupergenerico(dto.getOidSupergenerico());
            bpo.setIndicadorSituacion(dto.getIndicadorSituacion());
            bpo.setTamanioPagina(dto.getTamanioPagina());
            // vbongiov -- Cambio 20090930 -- 16/07/2009
            bpo.setIndPremio(dto.getIndPremio());

            bpo.setOidIdioma(dto.getOidIdioma());
            bpo.setOidPais(dto.getOidPais());

            r = dmp.buscarProductosParaOferta(bpo);
            
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (r.esVacio()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        sal.setResultado(r);
        
        UtilidadesLog.info("MONOfertaBean.buscarProductosMaestro(DTOEBuscarProductos dto): Salida");
        return sal;
    }
    /**
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     *     pperanzola - 29/09/2005 - se modifica según modelo de componentes SICC-DMCO-PRE-GCC-001
     * [2] pperanzola - 04/10/2005 - se modifica segun incidencia BELC300021154 
     *     pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    public void guardarOferta(DTOOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.guardarOferta(DTOOferta dto): Entrada");
                Vector vDetaOfer = null;
        int i;
        int cantDetaOfer;
        DTODetalleOferta dtoDetaOfer= null;
        try {
            
            dto = this.insertarDatosOferta(dto);
            //this.insertarDatosGrupo(dto); [2]
            this.actualizarDatosGrupo(dto);
            vDetaOfer = dto.getDetalleOferta();
            cantDetaOfer = vDetaOfer.size();
            
            DAOCCC dao = new DAOCCC();
            int numDe = dao.obtenerNumDeci(dto.getOidPais());
            
            for (i = 0; i< cantDetaOfer; i++){
                dtoDetaOfer = (DTODetalleOferta) vDetaOfer.get(i);
                this.insertarDatosDetalle(numDe, dto.getOidOferta(),dtoDetaOfer);
            }
            
            this.insertarDatosVentaExclusiva(dto.getOidOferta(),dto.getVentaExclusiva());

            this.insertarDatosPromocion(dto.getOidOferta(),dto.getPromocion());
            
            
        }catch (MareException me){
            ctx.setRollbackOnly();            
            throw new MareException(new Exception()
                                    ,UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE
                                    , ""
                                    , ErroresNegocio.PRE_0005));
        } 
        UtilidadesLog.info("MONOfertaBean.guardarOferta(DTOOferta dto): Salida");
    }
    /**
     * @date 
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * pperanzola - 30/09/2005 - se modifica según modelo de componentes SICC-DMCO-PRE-GCC-001
     * pperanzola - 30/09/2005  - se modifica segun incidencia BELC300021091 , el canal y la marca se obtiene del período
     *     pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */

    public void validarAcceso(DTOOferta dto) throws MareException {
      UtilidadesLog.info("MONOfertaBean.validarAcceso(DTOOferta dto): Entrada");
        MONValidacion monVal = null; // para acceder al método validarAccesos del mon
        CabeceraMFLocal cabecMF = null;//  para el findByPk del CabeceraMFLocalHome
        PeriodoLocal periodoLocal = null;//  para el findByPk del PeriodoLocalHome
        Boolean controlAcceso = null; //  para almacenar el resultado del método validarAccesos
       
        try {
            monVal = this.getMONValidacionHome().create();
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            cabecMF = cmflh.findByPrimaryKey(dto.getOidCabeceraMF());
            periodoLocal = this.getPeriodoLocalHome().findByPrimaryKey(cabecMF.getOidPeri());
            //UtilidadesLog.debug("a validarAccesos ");
            controlAcceso = monVal.validarAccesos(dto.getOidPais()
                                            ,null //sociedad
                                            ,periodoLocal.getOidMarca()//marca
                                            ,periodoLocal.getOidCanal() //canal
                                            ,dto.getOidAcceso()
                                            ,dto.getOidSubacceso()
                                            ,null //subgerencia
                                            ,null //region
                                            ,null //zona
                                            ,null //seccion
                                            ,null //territorio
                                            );
            UtilidadesLog.debug(" controlAcceso = " + controlAcceso);
        } catch(RemoteException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch(CreateException ce) {
            UtilidadesLog.error(ce);
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } 
        
        if (!controlAcceso.booleanValue()){ 
            
            throw new MareException (new Exception());
        }

      UtilidadesLog.info("MONOfertaBean.validarAcceso(DTOOferta dto): Salida");
    }

    public void registrarOfertasIndividuales(DTOCabecCatal dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.registrarOfertasIndividuales(DTOCabecCatal dto): Entrada");
        
        int INDEX_OID_PAIS = 0;
        //int INDEX_OID_MARCA = 1;
        //int INDEX_OID_CANAL = 2;
        //int INDEX_OID_TIPO_PERIODO = 3;
        int INDEX_OID_PERIODO = 4;
        int INDEX_OID_SAP = 5;
        int INDEX_DESC_CORTA = 6;
        int INDEX_OID_TIPO_OFERTA = 7;
        int INDEX_OID_CICLO_VIDA = 8;
        int INDEX_UNIDADES_ESTIMADAS = 9;
        int INDEX_OID_CATALOGO = 10;
        int INDEX_PAGINA_CATALOGO = 11;
        int INDEX_POSICION_PAGINA = 12;
        int INDEX_PRECIO_CATALOGO = 13;
        int INDEX_OID_ARG_VENTA = 14;
        int INDEX_OID_ESTRATEGIA = 15;
        int INDEX_PRECIO_POS = 16;
        int INDEX_OID_COND_PROM = 17;
        int INDEX_VENTA_NETA_EST = 18;
        int INDEX_OID_MONEDA = 19;
        int INDEX_COSTE_ESTANDAR = 20;
        int INDEX_OID_FORMA_PAGO = 21;
        int INDEX_CENTRO = 22;
        int OID_ESTIM_VENT = 23;
        int OID_ACCESO = 24;
        int OID_SUBACCESO = 25;
        /*
         * Modificacion por incidencia SiCC 20070321 - Rafael Romero - 21/06/2007
         */
        //int INDEX_CUV=26;
        int INDEX_PROG_FIDELIZACION = 26;
        int INDEX_VARIANTE = 27;
        // Fin modificacion incidencia SiCC 20070321

        OfertaLocalHome olh = null;
        DetalleOfertaLocalHome dolh = null;
        EstimadosVentaLocalHome evlh = null;
        OfertaLocal ol = null;
        DetalleOfertaLocal dol = null;
        EstimadosVentaLocal evl = null;
        Vector row = null;
        Long oidEstrategia = null;
        Integer numOferta = null;
        Long oidSubAcceso = null;
        Long oidArgumentoVenta = null;
        Long oidAcceso = null;
        Long oidCabecera = null;
        Long oidOfer = null;
        Long oidProd = null;
        Integer numLineOfer = null;
        Integer valFactRepe = null;
        Long oidCatal = null;
        Long oidTipoOfer = null;
        Long oidCicloVida = null;
        Long oidCondProm = null;
        Long oidMone = null;
        Long oidCatalogo = null;
        Long oidPeriodo = null;
        Long oidEstimadosVenta = null;
        ArgumentoVentaLocalHome avlh = null;
        ArgumentoVentaLocal avl = null;

        /**
         * existenEstrategias = Llamamos al método buscarEstrategiasIndividuales
         * Si existenEstrategias = False
         * {
         * Generamos una Excepcion con código de error PRE-0049
         * }
        **/
        Boolean existenEstrategias = buscarEstrategiasIndividuales();

        if (existenEstrategias.booleanValue()) {
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0049));
        }

        DTOSalida dtos = this.buscarProductosEstrategiaIndividual(dto);
        RecordSet rs = dtos.getResultado();
        olh = new OfertaLocalHome();
        
        avlh = new ArgumentoVentaLocalHome();        

        dolh = new DetalleOfertaLocalHome();

        //dolh.parametrosAuditoria(dto);
        for (int i = 0; i < rs.getRowCount(); i++) {
            row = rs.getRow(i);

            //1 Crear entidad Oferta------------------------------------------------
            oidEstrategia = (row.get(INDEX_OID_ESTRATEGIA) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_ESTRATEGIA)).toString());
            numOferta = obtenerNumOfertaSecuencial(oidEstrategia, dto.getOidCabecera());
            if (row.get(OID_SUBACCESO)!=null)
                oidSubAcceso = new Long(((BigDecimal) row.get(OID_SUBACCESO)).toString());
            if (row.get(INDEX_OID_ARG_VENTA)!=null)
                oidArgumentoVenta = new Long(((BigDecimal) row.get(INDEX_OID_ARG_VENTA)).toString());
            if (row.get(OID_ACCESO)!=null)
                oidAcceso = new Long(((BigDecimal) row.get(OID_ACCESO)).toString());
            oidCabecera = dto.getOidCabecera();
            if (row.get(INDEX_OID_CATALOGO)!=null)
                oidCatalogo = new Long(((BigDecimal) row.get(INDEX_OID_CATALOGO)).toString());

            try {
                ol = olh.create(oidEstrategia, numOferta, oidArgumentoVenta, oidCabecera, oidCatalogo);
                
                if (row.get(INDEX_OID_FORMA_PAGO) != null) {
                    ol.setOidFormPago(new Long(((BigDecimal) row.get(INDEX_OID_FORMA_PAGO)).toString()));
                    olh.merge(ol);
                }
            } catch (PersistenceException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //El oid de periodo se utiliza junto con el oid de producto para recuperar
            //el oid de Estimados Venta, debido a que esos dos campos forman la UK.
            //El oid de Estimados Venta se utilizara para identificar el entity 
            //Estimados Venta que corresponda y actualizar su atributo OfertaGenerada
            //a True.
            oidPeriodo = (row.get(INDEX_OID_PERIODO) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_PERIODO)).toString());
            oidOfer = ol.getOid(); //Se obtiene al guardar
            oidProd = this.getOidProducto((row.get(INDEX_OID_PAIS) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_PAIS)).toString()), (row.get(INDEX_OID_SAP) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_SAP)).toString()));
            numLineOfer = new Integer(1);
            oidEstimadosVenta = new Long(((BigDecimal) row.get(OID_ESTIM_VENT)).longValue()); //this.getOidEstimadosVenta(oidProd, oidPeriodo);

            //Se accede a la entidad ArgumentoVenta para recuperar el Factor de Repeticion
            try {
                avl = avlh.findByPrimaryKey(oidArgumentoVenta);
                valFactRepe = (avl.getFactorRepeticion() == null) ? null : avl.getFactorRepeticion();
            } catch (NoResultException fe) {
                UtilidadesLog.error(fe);
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            oidCatal = (row.get(INDEX_OID_CATALOGO) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_CATALOGO)).toString());
            oidTipoOfer = (row.get(INDEX_OID_TIPO_OFERTA) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_TIPO_OFERTA)).toString());
            oidCicloVida = (row.get(INDEX_OID_CICLO_VIDA) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_CICLO_VIDA)).toString());
            oidCondProm = (row.get(INDEX_OID_COND_PROM) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_COND_PROM)).toString());
            oidMone = (row.get(INDEX_OID_MONEDA) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_MONEDA)).toString());

            //2 Crear entidad Detalle Oferta----------------------------------------
            try {
                dol = dolh.create(oidOfer, oidProd, numLineOfer, valFactRepe, oidTipoOfer, oidCicloVida, null);
                dol.setOidCatal(oidCatal);
                dol.setOidCondProm(oidCondProm);
                dol.setOidProd((row.get(INDEX_OID_SAP) == null) ? null : new Long(((BigDecimal) row.get(INDEX_OID_SAP)).toString()));
                dol.setTextoBreve((row.get(INDEX_DESC_CORTA) == null) ? null : (String) row.get(INDEX_DESC_CORTA));
                dol.setUnidadesEstimadas((row.get(INDEX_UNIDADES_ESTIMADAS) == null) ? null : new Integer(((BigDecimal) row.get(INDEX_UNIDADES_ESTIMADAS)).toString()));
                dol.setPosicionRanking(null);
                dol.setProductoPrincipal(Boolean.TRUE); //Incidencia 10782 enozigli
                dol.setImpresionGP(Boolean.TRUE);
                dol.setDigitable(Boolean.TRUE);
                dol.setOrigen(ConstantesPRE.ESTIMADOS_VENTA);
                dol.setPrecioCatalogo((BigDecimal) row.get(INDEX_PRECIO_CATALOGO));
                dol.setPrecioPosicionamiento((BigDecimal) row.get(INDEX_PRECIO_POS));
                dol.setCosteEstandar((BigDecimal) row.get(INDEX_COSTE_ESTANDAR));
                dol.setVentaNetaEstimada((BigDecimal) row.get(INDEX_VENTA_NETA_EST));
                dol.setNumeroPaginaCatalogo((row.get(INDEX_PAGINA_CATALOGO) == null) ? null : new Integer(((BigDecimal) row.get(INDEX_PAGINA_CATALOGO)).toString()));
                dol.setPosicionPagina((row.get(INDEX_POSICION_PAGINA) == null) ? null : new Integer(((BigDecimal) row.get(INDEX_POSICION_PAGINA)).toString()));
                dol.setCentro((row.get(INDEX_CENTRO) == null) ? null : (String) row.get(INDEX_CENTRO));
                //Alorenzo. Se vuelve atras el cambio a pedido de Czdasiuk 04/01/2007               
                //Gacevedo. En respuesta a la incidencia V-PRE-015
                //dol.setCodigoVenta((String)row.get(INDEX_CUV));
                //dol.setCodigoVentaGenerado(new Boolean("True"));
                //
                
                /*
                 * Agregado por SiCC 20070321 - Rafael Romero - 21/06/2007
                 */
                dol.setProgramaFidelizacion((row.get(INDEX_PROG_FIDELIZACION) == null) ? null : new Long(((BigDecimal) row.get(INDEX_PROG_FIDELIZACION)).toString()));
                dol.setVariante((row.get(INDEX_VARIANTE) == null) ? null : new Long(((BigDecimal) row.get(INDEX_VARIANTE)).toString()));                
                // Fin modificacion incidencia SiCC 20070321
                dolh.merge(dol);
                
            } catch (PersistenceException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            //3 Actualizar Estimados Venta -----------------------------------------
            try {
                evlh = new EstimadosVentaLocalHome();
                evl = evlh.findByPrimaryKey(oidEstimadosVenta);
                evl.setOfertaGenerada(Boolean.TRUE);
                evlh.merge(evl);
            } catch (NoResultException fe) {
                UtilidadesLog.error(fe);
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
        UtilidadesLog.info("MONOfertaBean.registrarOfertasIndividuales(DTOCabecCatal dto): Salida");
    }

  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 07/09/2005
   * @Recibe: es.indra.sicc.dtos.pre.DTOCabecCatal dto
   * @Retorna: void 
   * @Descripción: metodo que asigna codigos de venta a los productos asignados a 
   *               una oferta. Estos codigos de venta serán unicos.
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   */ 
   public void asignarCodigosVenta(DTOCabecCatal dto) throws MareException {
      UtilidadesLog.info("MONOfertaBean.asignarCodigosVenta(DTOCabecCatal dto): Entrada");
      
      //UtilidadesLog.debug("Datos Entrada: DTOCabecCatal:"+dto);
      
      //Obtenemos el oidPais
      String oidPais = obtenerOidPais(dto.getOidCabecera());
      
      String indAsignarCUV =  obtenerValorParametroPais(oidPais, "PRE", "001");
      UtilidadesLog.info("indAsignarCUV :" + indAsignarCUV);
      
      if("S".equals(indAsignarCUV)) {
          BelcorpService bs = BelcorpService.getInstance();
          
          try {
              ArrayList params = new ArrayList();
              params.add(dto.getOidCabecera().toString());
              if(dto.getOidCatalogo()!=null)
                params.add(dto.getOidCatalogo().toString());
              else
                params.add(null);
              
              bs.dbService.executeProcedure("PQ_PLANI.PED_PR_ASIGNAR_CUV", params);
              
              UtilidadesLog.info("MONOfertaBean.asignarCodigosVenta(DTOCabecCatal dto): Salida ");
          } catch (Exception e) {
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
      } else {   
          RecordSet rsOfertas = this.buscarOfertasSinCodigoVenta(dto);
          
          String CUV = this.obtenerUltimoCodigoVenta(dto.getOidCabecera());      
          CUV = this.obtenerSiguienteCUV(CUV);
          
          if(ConstantesPRE.MENOR_NUMERO_CUV.compareTo(Long.valueOf(CUV))>0){ 
              CUV = String.valueOf(ConstantesPRE.MENOR_NUMERO_CUV.longValue()); 
          }
          
          int cantOfertas = rsOfertas.getRowCount();   
          try{
              for (int i=0; i<cantOfertas; i++) {
                  //String codigoProducto = (String)rsOfertas.getValueAt(i,"COD_PROD");//parece no usarse
                  String CUVProducto = (String)rsOfertas.getValueAt(i,"CUV");
                  Integer tipoEstra = BigToInteger(rsOfertas.getValueAt(i,"TIPOESTRA"));
                  Integer tipoProdu = BigToInteger(rsOfertas.getValueAt(i,"TIPOPRODU"));
                  Long oidDetalle = BigToLong(rsOfertas.getValueAt(i,"OIDDETALLE"));
                  DetalleOfertaLocalHome detalleOfertaLH  = new DetalleOfertaLocalHome();
                  DetalleOfertaLocal detalleOferta = detalleOfertaLH.findByPrimaryKey(oidDetalle);
                  OfertaLocalHome ofertaLH = new OfertaLocalHome();
                  OfertaLocal oferta = ofertaLH.findByPrimaryKey(detalleOferta.getOidOfer());
                    
                  if ((Integer.valueOf(String.valueOf(ConstantesPRE.COMPUESTA_FIJA)).equals(tipoEstra))||
                      (Integer.valueOf(String.valueOf(ConstantesPRE.COMPUESTA_FIJA_VS_GRUPO)).equals(tipoEstra))||
                       (Integer.valueOf(String.valueOf(ConstantesPRE.INDIVIDUAL)).equals(tipoEstra)&&
                        (!(Integer.valueOf(String.valueOf(ConstantesPRE.ORDEN_COMPRA)).equals(tipoProdu))))) {
                      this.asignarAdicional(CUV,detalleOferta,oferta);
                      CUV = this.obtenerSiguienteCUV(CUV);
                  } else {
                      if (existeOtroProductoAsignado(CUVProducto, dto.getOidCabecera())){
                          this.asignarAdicional(CUV,detalleOferta,oferta);
                          CUV = this.obtenerSiguienteCUV(CUV);
                      } else {
                          if (CUVProducto!=null){
                              detalleOferta.setCodigoVenta(CUVProducto);
                              detalleOferta.setCodigoVentaGenerado(Boolean.TRUE);
                              oferta.setCodigoVentaGenerado(Boolean.TRUE);
                          }else{
                              UtilidadesLog.info("NO EXISTE CODIGO UNICO DE VENTA EN MAE PARA EL PRODUCTO. POR LO TANTO NO SE ASIGNA para el detalle: "+detalleOferta.getOid());
                          }
                      }
                  }                          
                  detalleOfertaLH.merge(detalleOferta);
                  ofertaLH.merge(oferta);
              }
          } catch (NoResultException fe) {
                UtilidadesLog.error(fe);
                ctx.setRollbackOnly();
                throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          }
      }
      
      UtilidadesLog.info("MONOfertaBean.asignarCodigosVenta(DTOCabecCatal dto): Salida");
   }

    private Integer BigToInteger(Object num) {
        UtilidadesLog.info("MONOfertaBean.BigToInteger(Object num): Entrada");
        if (num != null) {
            UtilidadesLog.info("MONOfertaBean.BigToInteger(Object num): Salida");
            return (new Integer(((BigDecimal) num).intValue()));
        } else {
            UtilidadesLog.info("MONOfertaBean.BigToInteger(Object num): Salida");
            return null;
        }        
    }

    private Long BigToLong(Object num) {
        UtilidadesLog.info("MONOfertaBean.BigToLong(Object num): Entrada");
        if (num != null) {
            UtilidadesLog.info("MONOfertaBean.BigToLong(Object num): Salida");
            return (new Long(((BigDecimal) num).longValue()));
        } else {
            UtilidadesLog.info("MONOfertaBean.BigToLong(Object num): Salida");
            return null;
        }
    }

   /**
    * @Autor: Emilio Noziglia
    * @Fecha : 07/09/2005
    * @Recibe: es.indra.sicc.dtos.pre.DTOCabecCatal dto
    * @Retorna: RecordSet 
    * @Descripción: metodo que busca entre las ofertas las cuyos detalles (productos)
    *               aun no se le han asignado codigo de venta.
    * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
    */ 
   public RecordSet buscarOfertasSinCodigoVenta(DTOCabecCatal dto) throws MareException {
      UtilidadesLog.info("MONOfertaBean.buscarOfertasSinCodigoVenta(DTOCabecCatal dto): Entrada");
      
      //UtilidadesLog.debug("Datos Entrada: DTOCabecCatal:"+dto);           

      BelcorpService belcorpService = BelcorpService.getInstance();

      RecordSet rs = null;
      StringBuffer query = new StringBuffer();

      query.append(" select mp.COD_SAP COD_PROD, mp.COD_UNIC_VENT CUV, e.TIES_OID_TIPO_ESTR TIPOESTRA, ");
	         query.append(" e.TIPR_OID_TIPO_PROD TIPOPRODU, od.OID_DETA_OFER OIDDETALLE ");
      query.append(" from pre_ofert_detal od, ");
	       query.append(" pre_ofert o, ");
	       query.append(" mae_produ mp, ");
	       query.append(" pre_estra e, PRE_CATAL_ORDEN oc ");
      query.append(" where od.OFER_OID_OFER = o.OID_OFER ");
      query.append(" and od.PROD_OID_PROD = mp.OID_PROD ");
      query.append(" and o.COES_OID_ESTR = e.OID_ESTR ");
      query.append(" and oc.OCAT_OID_CATA = od.OCAT_OID_CATAL ");
      query.append(" and o.MFCA_OID_CABE = "+dto.getOidCabecera()+" ");      
      if (dto.getOidCatalogo()!=null){
        query.append(" and od.OCAT_OID_CATAL = "+dto.getOidCatalogo()+" ");
      }
      query.append(" and (od.IND_CODI_VENT_GENE = 0 or od.IND_CODI_VENT_GENE is null) ");
      query.append(" and (o.IND_CODI_VENT_GENE = 0 or o.IND_CODI_VENT_GENE is null) ");
      query.append(" order by mp.COD_SAP, oc.NUM_ORDE ,od.IND_IMPR_GP DESC, e.NUM_ORDE_ASIG_CUV ");

      try {
        rs = belcorpService.dbService.executeStaticQuery(query.toString());
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
            
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }
      
      if (rs==null||rs.esVacio()) {
         throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0032));
      }
      
      UtilidadesLog.info("MONOfertaBean.buscarOfertasSinCodigoVenta(DTOCabecCatal dto): Salida");
      return rs;
   }     
     
    public void guardarTextoOferta(DTOTextoOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.guardarTextoOferta(DTOTextoOferta dto): Entrada");
        //UtilidadesLog.debug("DTOTextoOferta " + dto );
        
        if (dto.getOid() == null) { //Nuevo
            //UtilidadesLog.debug("Voy a crear un texto nuevo");

            if (this.comprobarNumeroOrden(dto).booleanValue()) { //OK

                try {
                    TextosOfertasLocalHome textosOfertasLocalHome = new TextosOfertasLocalHome();                    
                    textosOfertasLocalHome.create(new Integer(dto.getNumeroOrden().toString()), dto.getOidCabeceraMF(), dto.getTexto(), dto.getOidCatalogo());
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } catch (Exception exception) {
                    UtilidadesLog.error(exception);
                    ctx.setRollbackOnly();

                    if (exception instanceof MareException) {
                        throw (MareException) exception;
                    }

                    throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
            } else { //Error
                
                ctx.setRollbackOnly();
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0030));
            }
        } else { //actualizando

            try {
                //UtilidadesLog.debug("Oid a Modificar= " + dto.getOid());
                //UtilidadesLog.debug("Voy a modificar un texto y/o catalogo");

                TextosOfertasLocalHome textosOfertasLocalHome = new TextosOfertasLocalHome();                

                TextosOfertasLocal textosOfertasLocal = textosOfertasLocalHome.findByPrimaryKey(dto.getOid());

                if (textosOfertasLocal.getNumeroOrden().intValue() != dto.getNumeroOrden().intValue()) {
                    //UtilidadesLog.debug("Cambio el Numero de Orden");

                    if (this.comprobarNumeroOrden(dto).booleanValue()) { //OK
                        textosOfertasLocalHome.remove(textosOfertasLocal);
                        textosOfertasLocalHome.create(new Integer(dto.getNumeroOrden().toString()), dto.getOidCabeceraMF(), dto.getTexto(), dto.getOidCatalogo());
                    } else {
                        //UtilidadesLog.debug("Numero de Orden Ya existe");
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0030));
                    }
                } else {
                    //UtilidadesLog.debug("No cambio el Numero de Orden");
                    textosOfertasLocal.setTexto(dto.getTexto());
                    textosOfertasLocal.setOidCatalogo(dto.getOidCatalogo());
                    textosOfertasLocalHome.merge(textosOfertasLocal);
                }
            } catch (NoResultException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_CLAVE_DUPLICADA));
            } catch (Exception exception) {
                UtilidadesLog.error(exception);
                ctx.setRollbackOnly();
                if (exception instanceof MareException) {
                    throw (MareException) exception;
                }
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONOfertaBean.guardarTextoOferta(DTOTextoOferta dto): Salida");
    }

    /**
     * Recibimos un dto con el oid del texto de oferta que se desea eliminar,
     * se hace un findByPrimaryKey sobre la entidad TextoOferta,
     * si no hay ningún problema se hace un remove para borrar el registro.
     */
    public void eliminarTextoOferta(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.eliminarTextoOferta(DTOOID dto): Entrada");
        
        try {
        
            TextosOfertasLocalHome textosOfertasLocalHome = new TextosOfertasLocalHome();
            
            TextosOfertasLocal textosOfertas = textosOfertasLocalHome.findByPrimaryKey(dto.getOid());
            textosOfertasLocalHome.remove(textosOfertas);
            
        } catch (NoResultException nre) {
            UtilidadesLog.error(nre);
            ctx.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            UtilidadesLog.error(pe);
            ctx.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONOfertaBean.eliminarTextoOferta(DTOOID dto): Salida");
    }

    public DTOComprobarOrden comprobarOrdenOfertas(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.comprobarOrdenOfertas(DTOOID dto): Entrada");
        StringBuffer sb = new StringBuffer(" select count(*) from pre_ofert o, pre_ofert_detal d ");
        sb.append(" where o.OID_OFER = d.OFER_OID_OFER ");
        sb.append(" and o.MFCA_OID_CABE = "+dto.getOid());
        sb.append(" and d.NUM_ORDE_DETA is not null ");
        
        BelcorpService belcorpService = BelcorpService.getInstance();

        RecordSet rs = null;

        try {
            rs = belcorpService.dbService.executeStaticQuery(sb.toString());
        }catch (Exception exception) {            
            UtilidadesLog.error("ERROR",exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        if (rs.getValueAt(0,0).toString().equals("0")){
            return this.generarDTOComprobarOrden(Boolean.FALSE);
        }else{
            return this.generarDTOComprobarOrden(Boolean.TRUE);
        }     
    }

    /**
     * Prepara el valor de retorno del metodo comprobarOrdenOfertas
     */
    private DTOComprobarOrden generarDTOComprobarOrden(Boolean b) {
        UtilidadesLog.info("MONOfertaBean.generarDTOComprobarOrden(Boolean b): Entrada");
        
        DTOComprobarOrden dTOComprobarOrden = new DTOComprobarOrden();
        dTOComprobarOrden.setOfertasOrdenadas(b);

        UtilidadesLog.info("MONOfertaBean.generarDTOComprobarOrden(Boolean b): Salida");
        return dTOComprobarOrden;
    }

    public void secuenciarOfertas(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.secuenciarOfertas(DTOOID dto): Entrada");
        
        BelcorpService belcorpService = null;
        StringBuffer query = new StringBuffer();
        Long lOidCabeceraMF = dto.getOid();        
        String oidCabeceraMF = lOidCabeceraMF.toString();
        RecordSet rs = null;
        Long oidPeri = null;
        CabeceraMFLocalHome cmflh = null;
        CabeceraMFLocal cmfl = null;
        PeriodoLocalHome plh = null;
        PeriodoLocal pl = null;
        Long oidPais = null;
        Long oidMarca = null;
        Long oidCanal = null;
        Integer incremento = null;
        ConfiguracionGPPaisLocalHome cgpplh = null;
        ConfiguracionGPPaisLocal cgpp = null;
        Collection textosOfertas = null;
        TextosOfertasLocalHome tolh = null;

        //Long numeroOrdenOferta = null;

        int secuencia;
        boolean textosOfertasTienenValorNumeroOrden;
        query.append(" select * from table(CAST(PQ_APL_PRE.OBTENER_SECUENCIA_OFERTAS(").append(oidCabeceraMF).append(") as OBJ_PRE_SECUE_OFER_TABLE)) ");
         
        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            rs = new RecordSet();

            try {
                rs = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception exception) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(exception);
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }

            //Se obtiene el oidPais correspondiente a la entidad CabeceraMF, 
            //haciendo un findByPrimaryKey con el oid de CabeceraMF recibido.
            //Obtencion del oidPeriodo
            cmflh = new CabeceraMFLocalHome();
            cmfl = cmflh.findByPrimaryKey(lOidCabeceraMF);
            oidPeri = cmfl.getOidPeri();

            //Se obtiene el atributo increment, de la entidad ConfiguracionGPPais, 
            //haciendo un find por oidPais, que debe ser clave unica en la intidad 
            //ConfiguracionGPPais.
            plh = this.getPeriodoLocalHome();
            pl = plh.findByPrimaryKey(oidPeri);

            oidPais = pl.getOidPais();
            oidMarca = pl.getOidMarca();
            oidCanal = pl.getOidCanal();

            Collection configuracionesGPPais = null;

            cgpplh = new ConfiguracionGPPaisLocalHome();
            
            configuracionesGPPais = cgpplh.findByPaisMarcaCanal(oidPais, oidMarca, oidCanal);

            if (!configuracionesGPPais.isEmpty()) {
                cgpp = (ConfiguracionGPPaisLocal) configuracionesGPPais.iterator().next();
            } else { //cambio por incidencia 16406 enozigli
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0051));
            }

            incremento = cgpp.getIncremento();
            secuencia = cgpp.getIncremento().intValue();//la secuencia debe inicial en el valor del incremento.

            //ArrayList ofertasOrdenadas = this.ordenarOfertas(rs);
            ArrayList ofertasOrdenadas = new ArrayList();
            for (int i = 0 ; i< rs.getRowCount();i++){
                Long oid = new Long(rs.getValueAt(i,0).toString());
                ofertasOrdenadas.add(oid);
            }
            
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();            
            
            if (!ofertasOrdenadas.isEmpty()) {
              int cantDetaOfer = ofertasOrdenadas.size();
              for (int i=0;i<cantDetaOfer;i++) {
                //Se verifica que no exista ningun TextoOferta cuyo numeroOrden sea 
                //igual que secuencia.
                //Flag para la condicion de salida del while
                textosOfertasTienenValorNumeroOrden = false;

                while (!textosOfertasTienenValorNumeroOrden) {
                    tolh = new TextosOfertasLocalHome();
                    
                    textosOfertas = tolh.findByNumeroOrdenYCabe(new Integer(secuencia), lOidCabeceraMF);

                    //Si la coleccion devuelta no esta vacia, significa que habia 
                    //TextosOfertas cuyo numero de orden es igual al valor de 'secuencia'.
                    //Esto significa que se debe incrementar 'secuencia' en el valor de la
                    //variable 'incremento'.
                    if (textosOfertas.isEmpty()) {
                        textosOfertasTienenValorNumeroOrden = true;
                    } else {
                        secuencia += incremento.intValue();
                    }
                }              
                Long oidDetalleOferta = (Long)ofertasOrdenadas.get(i);
                
                DetalleOfertaLocal detalle = dolh.findByPrimaryKey(oidDetalleOferta);
                
                detalle.setNumeroOrden(new Integer(secuencia));
                dolh.merge(detalle);
                
                secuencia += incremento.intValue();
              }
            }
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error("ERROR",serviceNotFoundException);
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (NoResultException fe) {
            UtilidadesLog.error("ERROR",fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException fe) {
            UtilidadesLog.error("ERROR",fe);
            ctx.setRollbackOnly();
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (Exception e) {
            UtilidadesLog.error("ERROR",e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONOfertaBean.secuenciarOfertas(DTOOID dto): Salida");
    }

    public DTOSalida consultarOrdenOfertas(DTOEOrdenOfertas dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.consultarOrdenOfertas(DTOEOrdenOfertas dto): Entrada");
        
        StringBuffer query = new StringBuffer();        
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;

        query.append(" SELECT * ");
        query.append(" FROM (SELECT x.*, ");
        query.append(" CASE ");
        query.append(" WHEN (("+dto.getTamanioPagina()+" - COUNT (*) OVER (PARTITION BY 1)) < 0 ");
        query.append(" ) ");
        query.append(" THEN 0 ");
        query.append(" ELSE 1 ");
        query.append(" END sicc_es_ultima_pagina ");
        query.append(" FROM ( ");
        query.append(" SELECT v_pre_orden_ofert.num_orde OID,  ");
        query.append(" v_pre_orden_ofert.num_ofer, v_pre_orden_ofert.cod_sap,  ");
        query.append(" v_pre_orden_ofert.val_codi_vent,  ");
        query.append(" v_pre_orden_ofert.desc_produ,  ");
        query.append(" v_pre_orden_ofert.IMP_PREC_CATA,  ");
        query.append(" v_pre_orden_ofert.val_fact_repe,  ");
        query.append(" v_pre_orden_ofert.ind_impr_gp,  ");
        query.append(" v_pre_orden_ofert.ind_digi ,v_pre_orden_ofert.oid_cabe ");
        query.append(" FROM v_pre_orden_ofert,  ");
        query.append(" mae_produ  ");
        query.append(" Where mae_produ.cod_sap(+) = v_pre_orden_ofert.cod_sap  ");
        query.append(" AND mae_produ.pais_oid_pais(+) = " + dto.getOidPais() );
        query.append(" and v_pre_orden_ofert.IDIO_OID_IDIO = " + dto.getOidIdioma() );
        if ((dto.getMostrarImprimibles() != null) && dto.getMostrarImprimibles().booleanValue()) {
            query.append(" AND V_PRE_ORDEN_OFERT.IND_IMPR_GP = 1");
        }
        query.append(" AND v_pre_orden_ofert.oid_cabe =  " + dto.getOidCabeceraMF());
        query.append(" ORDER BY num_orde, desc_produ  ");
        query.append(" ) x  ");
        query.append(" WHERE ROWNUM <= "+(dto.getTamanioPagina().intValue()+1)+" AND OID > "+dto.getIndicadorSituacion()+" ) y ");
        query.append(" WHERE ROWNUM <= "+dto.getTamanioPagina()+" AND OID > "+dto.getIndicadorSituacion());
        
        
        
        /*query.append(" SELECT * from ( ");
        query.append(" SELECT ROWNUM as OID,   xxx.* FROM (");

        //query.append("SELECT  v_pre_orden_ofert.linea OID, ");
        query.append("SELECT v_pre_orden_ofert.num_orde, ");
        query.append("v_pre_orden_ofert.num_ofer, v_pre_orden_ofert.cod_sap, ");
        query.append("v_pre_orden_ofert.val_codi_vent, ");
        query.append("v_pre_orden_ofert.desc_produ, ");
        query.append("v_pre_orden_ofert.IMP_PREC_CATA, ");
        query.append("v_pre_orden_ofert.val_fact_repe, ");
        query.append("v_pre_orden_ofert.ind_impr_gp, ");
        query.append("v_pre_orden_ofert.ind_digi ");
        query.append("FROM v_pre_orden_ofert, ");
        query.append("mae_produ ");

        query.append("Where mae_produ.cod_sap(+) = v_pre_orden_ofert.cod_sap ");

        query.append("AND mae_produ.pais_oid_pais(+) = " + dto.getOidPais() + " ");//BELC300021447 
        query.append("and v_pre_orden_ofert.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append("AND v_pre_orden_ofert.oid_cabe = " + dto.getOidCabeceraMF() + " ");

        if ((dto.getMostrarImprimibles() != null) && dto.getMostrarImprimibles().booleanValue()) {
            query.append(" AND V_PRE_ORDEN_OFERT.IND_IMPR_GP = 1");
        }

        query.append("ORDER BY num_orde, desc_produ ) ");
        query.append(" xxx ) ");
        query.append(" WHERE OID > " + dto.getIndicadorSituacion() + " AND ROWNUM <= " + dto.getTamanioPagina());*/

        //queryPaginada = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);
        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("MONOfertaBean.consultarOrdenOfertas(DTOEOrdenOfertas dto): Salida");
        return dtos;
    }

    public RecordSet obtenerProductosOfertaSinCV(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerProductosOfertaSinCV(Long oidOferta): Entrada");
        
        try {
            StringBuffer query = new StringBuffer();            
            RecordSet rs = new RecordSet();            
            BelcorpService belcorpService = null;

            query.append(" SELECT OID_DETA_OFER, VAL_TEXT_BREV, VAL_CODI_VENT, NUM_GRUP FROM ");
            query.append(" (SELECT * FROM (SELECT od.OID_DETA_OFER, od.VAL_TEXT_BREV, od.VAL_CODI_VENT, null NUM_GRUP, od.IND_PROD_PRIN,od.NUM_PAGI_CATA, od.VAL_POSI_PAGI, od.GOFE_OID_GRUP_OFER ");
            query.append(" FROM PRE_OFERT_DETAL od ");
            query.append(" WHERE ((od.IND_CODI_VENT_GENE = 0) OR (od.IND_CODI_VENT_GENE IS NULL)) ");
            query.append(" AND od.OFER_OID_OFER = " + oidOferta + " ");
            query.append(" AND od.GOFE_OID_GRUP_OFER IS NULL ");
            query.append(" UNION ");
            query.append(" SELECT od.OID_DETA_OFER, od.VAL_TEXT_BREV, od.VAL_CODI_VENT, g.NUM_GRUP NUM_GRUP, od.IND_PROD_PRIN, od.NUM_PAGI_CATA, od.VAL_POSI_PAGI, od.GOFE_OID_GRUP_OFER ");
            query.append(" FROM PRE_OFERT_DETAL od, PRE_GRUPO_OFERT g ");
            query.append(" WHERE ((od.IND_CODI_VENT_GENE = 0) OR (od.IND_CODI_VENT_GENE IS NULL)) ");
            query.append(" AND od.OFER_OID_OFER = " + oidOferta + " ");
            query.append(" AND od.GOFE_OID_GRUP_OFER = g.OID_GRUP_OFER) ");
            query.append(" ORDER BY IND_PROD_PRIN DESC, NUM_PAGI_CATA, VAL_POSI_PAGI, GOFE_OID_GRUP_OFER, VAL_TEXT_BREV) ");

            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            UtilidadesLog.info("MONOfertaBean.obtenerProductosOfertaSinCV(Long oidOferta): Salida");
            return rs;
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

   /**
    * @Modificado por Emilio Noziglia    
    * @Fecha : 01/09/2005
    * @Recibe: DTOCabecCatal dto
    * @Retorna: DTOSalida 
    * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
    * @Nota: Se cambia el parametro recibido por DTOCabecCatal y se agrega el filtro por catalogo.
    */     
    public DTOSalida buscarProductosEstrategiaIndividual(DTOCabecCatal dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarProductosEstrategiaIndividual(DTOCabecCatal dto): Entrada");
        
        //UtilidadesLog.debug("Datos Entrada: DTOCabecCatal:"+dto);
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append("SELECT  CRA_PERIO.PAIS_OID_PAIS, ");
        query.append("CRA_PERIO.MARC_OID_MARC, ");
        query.append("CRA_PERIO.CANA_OID_CANA, ");
        query.append("SEG_PERIO_CORPO.TIPE_OID_TIPO_PERI, ");
        query.append("PRE_ESTIM_VENTA.PERD_OID_PERI, ");
        query.append("MAE_PRODU.OID_PROD, ");
        query.append("MAE_PRODU.DES_CORT, ");
        query.append("PRE_ESTIM_VENTA.TOFE_OID_TIPO_OFER, ");
        query.append("PRE_ESTIM_VENTA.CIVI_OID_CICL_VIDA, ");
        query.append("PRE_ESTIM_VENTA.NUM_UNID_ESTI, ");
        query.append("PRE_ESTIM_VENTA.OCAT_OID_CATA, ");
        query.append("PRE_ESTIM_VENTA.NUM_PAGI_CATA, ");
        query.append("PRE_ESTIM_VENTA.VAL_POSI_PAGI, ");
        query.append("PRE_ESTIM_VENTA.IMP_PREC_CATA, ");
        query.append("PRE_ESTIM_VENTA.ARGV_OID_ARGU_VENT, ");

        //Queda repetido porque despues lo reemplazamos
        query.append("PRE_ESTIM_VENTA.ARGV_OID_ARGU_VENT, ");
        query.append("PRE_ESTIM_VENTA.IMP_PREC_POSI, ");
        query.append("PRE_ESTIM_VENTA.CNDP_OID_COND_PROM, ");
        query.append("PRE_ESTIM_VENTA.IMP_VENT_NETA_ESTI, ");
        query.append("PRE_ESTIM_VENTA.MONE_OID_MONE, ");
        query.append("PRE_ESTIM_VENTA.VAL_COST_ESTA, ");
        query.append("PRE_ESTIM_VENTA.FOPA_OID_FORM_PAGO, ");
        query.append("PRE_ESTIM_VENTA.VAL_CENT,  ");
        query.append("PRE_ESTIM_VENTA.OID_ESTIM_VENT,  ");
        query.append("PRE_ESTIM_VENTA.ACCE_OID_ACCE,  ");
        query.append("PRE_ESTIM_VENTA.SBAC_OID_SBAC  ");
        /*
         * Agregado por SiCC 20070321 - Rafael Romero - 21/06/2007
         */
        query.append(",PRE_ESTIM_VENTA.PRFI_OID_PROG_FIDE, PRE_ESTIM_VENTA.VARI_OID_VARI ");
        // fin agregado por SICC 20070321
        
        //Alorenzo. Se vuelve atras el cambio a pedido de Czdasiuk 04/01/2007
        //Gacevedo. Agregado en respuesta a la incidencia V-PRE-015
        //query.append(",MAE_PRODU.COD_UNIC_VENT ");
        //
        
        query.append("FROM PRE_ESTIM_VENTA, MAE_PRODU, CRA_PERIO, SEG_PERIO_CORPO ");
        query.append("WHERE PRE_ESTIM_VENTA.PROD_OID_PROD = MAE_PRODU.OID_PROD AND ");
        query.append("(PRE_ESTIM_VENTA.IND_OFER_GENE = 0 or  pre_estim_venta.ind_ofer_gene is null) AND ");
        query.append("PRE_ESTIM_VENTA.PERD_OID_PERI = CRA_PERIO.OID_PERI AND ");
        query.append("CRA_PERIO.PERI_OID_PERI = SEG_PERIO_CORPO.OID_PERI AND ");
        query.append("PRE_ESTIM_VENTA.PERD_OID_PERI IN ( ");
        query.append("     SELECT CRA_PERIO.OID_PERI ");
        query.append("     FROM CRA_PERIO, PRE_MATRI_FACTU_CABEC ");
        query.append("     WHERE PRE_MATRI_FACTU_CABEC.PERD_OID_PERI = CRA_PERIO.OID_PERI AND ");
        query.append("     PRE_MATRI_FACTU_CABEC.OID_CABE = " + dto.getOidCabecera() +" ");
        query.append("                                ) AND ");
        query.append(" PRE_ESTIM_VENTA.ARGV_OID_ARGU_VENT IN ( ");
        query.append("     SELECT PRE_ARGUM_VENTA.OID_ARGU_VENT ");
        query.append("     FROM PRE_ARGUM_VENTA, PRE_TIPO_ESTRA ");
        query.append("     WHERE PRE_ARGUM_VENTA.TIES_OID_TIPO_ESTR = PRE_TIPO_ESTRA.OID_TIPO_ESTR AND ");
        query.append("     PRE_TIPO_ESTRA.COD_TIPO_ESTR = 1 "); // Codigo correspondiente al tipo de estrategia 'Individual'
        query.append("                                )  ");
        if (dto.getOidCatalogo()!=null){
            query.append(" AND PRE_ESTIM_VENTA.OCAT_OID_CATA = "+dto.getOidCatalogo()+" ");
        }
        query.append(" ORDER BY PRE_ESTIM_VENTA.OCAT_OID_CATA, PRE_ESTIM_VENTA.NUM_PAGI_CATA, PRE_ESTIM_VENTA.VAL_POSI_PAGI, MAE_PRODU.DES_CORT");

        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        boolean noConsulte = true;
        RecordSet estrategias = null;
        int filas = rs.getRowCount();
        for (int i = 0; i < filas; i++) {
            if (noConsulte) {
                estrategias = buscarPrimerEstrategiaIndividual();
                noConsulte = false;
            }

            rs.setValueAt(estrategias.getValueAt(0, 0), i, 15);
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("MONOfertaBean.buscarProductosEstrategiaIndividual(DTOCabecCatal dto): Salida");
        return dtos;
    }

    private RecordSet buscarPrimerEstrategiaIndividual() throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarPrimerEstrategiaIndividual(): Entrada");
        
        String codigoError;
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            StringBuffer query_aux = new StringBuffer();

            query_aux.append(" select ES.OID_ESTR ");
            query_aux.append(" from PRE_ESTRA ES  ");
            query_aux.append(" where ES.TIES_OID_TIPO_ESTR = " + ConstantesPRE.INDIVIDUAL);
            query_aux.append(" ORDER BY ES.OID_ESTR");

            UtilidadesLog.info("MONOfertaBean.buscarPrimerEstrategiaIndividual(): Salida");
            return BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    /**
     * Se obtiene el OID_ESTIM_VENT de PRE_ESTIM_VENTA a partir de su UK, que es la combinacion
     * de los campos PROD_OID_PROD y PERD_OID_PERI.
     */
    private Long getOidEstimadosVenta(Long oidProd, Long oidPeri) throws MareException {
        UtilidadesLog.info("MONOfertaBean.getOidEstimadosVenta(Long oidProd, Long oidPeri): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();

        String query = "SELECT OID_ESTIM_VENT FROM PRE_ESTIM_VENTA WHERE PROD_OID_PROD = " + oidProd.toString() + " AND PERD_OID_PERI = " + oidPeri;

        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query);
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal bdOidEstimVenta = null;        

        if (rs != null) {
            //se toma el unico elemento recuperado
            bdOidEstimVenta = (BigDecimal) rs.getValueAt(0, 0);
            
            UtilidadesLog.info("MONOfertaBean.getOidEstimadosVenta(Long oidProd, Long oidPeri): Salida");
            return new Long(bdOidEstimVenta.toString());
        }
        
        UtilidadesLog.info("MONOfertaBean.getOidEstimadosVenta(Long oidProd, Long oidPeri): Salida");
        return null;
    }

    /**
     * Se obtiene el OID_PROD de MAE_PROD a partir de su UK, que es la combinacion
     * de los campos OID_PAIS y COD_SAP.
     */
    private Long getOidProducto(Long oidPais, Long codSAP) throws MareException {
        UtilidadesLog.info("MONOfertaBean.getOidProducto(Long oidPais, Long codSAP): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();

        String query = "SELECT OID_PROD FROM MAE_PRODU WHERE PAIS_OID_PAIS = " + oidPais.toString() + " AND OID_PROD = " + codSAP.toString();

        try {
        
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query);
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        BigDecimal bdOidProd = null;                

        if (rs != null) {
            //se toma el unico elemento recuperado
            bdOidProd = (BigDecimal) rs.getValueAt(0, 0);

            UtilidadesLog.info("MONOfertaBean.getOidProducto(Long oidPais, Long codSAP): Salida");
            return new Long(bdOidProd.toString());
        }

        UtilidadesLog.info("MONOfertaBean.getOidProducto(Long oidPais, Long codSAP): Salida");
        return null;
    }

    private Integer obtenerNumOfertaSecuencial(Long oidEstrategia, Long oidCabecera) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerNumOfertaSecuencial(Long oidEstrategia, Long oidCabecera): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = new RecordSet();
        String query = "SELECT MAX(NUM_OFER) FROM PRE_OFERT po WHERE po.COES_OID_ESTR =" + oidEstrategia + " AND po.MFCA_OID_CABE =" + oidCabecera;
        BigDecimal numOfer = null;
        Vector v = null;

        int iNumOfer;

        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query);
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if ((rs == null) || rs.esVacio()) {
            UtilidadesLog.info("MONOfertaBean.obtenerNumOfertaSecuencial(Long oidEstrategia, Long oidCabecera): Salida");
            return new Integer("1");
        } else {
            try {
                v = rs.getRow(0);
                numOfer = (BigDecimal) v.get(0);
                iNumOfer = numOfer.intValue();
                
                UtilidadesLog.info("MONOfertaBean.obtenerNumOfertaSecuencial(Long oidEstrategia, Long oidCabecera): Salida");
                return new Integer(++iNumOfer);
            } catch (Exception e) {
                UtilidadesLog.error(e);
                UtilidadesLog.info("MONOfertaBean.obtenerNumOfertaSecuencial(Long oidEstrategia, Long oidCabecera): Salida");
                return new Integer(1);
            }
        }
    }

    private Integer obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia): Entrada");
        
        String codigoError;
        RecordSet ofe_numSec;
        BelcorpService belcorpService;

        Integer nextOfe = new Integer(1);

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            StringBuffer query_aux = new StringBuffer();
            query_aux.append(" Select max(ofert.NUM_OFER) as maximo");
            query_aux.append(" FROM PRE_OFERT ofert");
            query_aux.append(" WHERE ofert.MFCA_OID_CABE = " + nMatriz);
            query_aux.append(" AND ofert.COES_OID_ESTR = " + nEstrategia);

            ofe_numSec = BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());

            if (!ofe_numSec.esVacio()) {
                if (ofe_numSec.getValueAt(0, "maximo") != null) {
                    nextOfe = new Integer(ofe_numSec.getValueAt(0, 0).toString());
                    nextOfe = new Integer(nextOfe.intValue() + 1);
                }
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONOfertaBean.obtenerNumeroSecuencial(Long nMatriz, Long nEstrategia): Salida");
        return nextOfe;
    }

    /**
     * @author Hugo Andres Mansi
     * @date el 16 de marzo de 2004
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     *     pperanzola - 29/09/2005 se crea para auxiliar otros métodos utilizados en cambios según modelo de componentes SICC-DMCO-PRE-GCC-001
     * [2] pperanzola - 20/10/2005 - se modifica segun incidencia BELC300021154 
     * [3] pperanzola - 21/10/2005 - se modifica para que no haya excepciones por valores nulos en los tipoOperacion
     *     pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */    

    public void modificarOferta(DTOOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.modificarOferta(DTOOferta dto): Entrada");
        
        try{
            dto  = verificarEstadoMF(dto);
            dto = this.insertarDatosOferta(dto);
            
            if (dto.getModificacionGrupo().booleanValue()){
                                               
                //dto = this.insertarDatosGrupo(dto); [2]
                dto = this.actualizarDatosGrupo(dto);
                
            }
            
            int i;//contador para el for
            int cantDeta; // auxiliar para el almacenamiento de la cantidad de detallesOferta
            Vector vDetaOfer = dto.getDetalleOferta();
            cantDeta  = vDetaOfer.size();
            DTODetalleOferta dtoDeta = null;
            UtilidadesLog.debug("pperez  -  Cantidad de detalles: " +  cantDeta);
            
            DAOCCC dao = new DAOCCC();
            int numDe = dao.obtenerNumDeci(dto.getOidPais());            
            
            for (i =0 ; i <cantDeta; i++){
                dtoDeta = (DTODetalleOferta) vDetaOfer.get(i);
                UtilidadesLog.debug("Dto numero  " + i + ":" + dtoDeta);
               if (ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoDeta.getTipoOperacion())){ //[3]
                    //UtilidadesLog.debug("getTipoOperacion en baja");
                    this.eliminarDatosDetalleOferta(dtoDeta.getOidDetalleOferta());
                }else {
                     // Modificado por SICC20070375 - Rafael Romero - 02/08/2007
                     if(indUpdFormaPago == true && dtoDeta.getOidDetalleOferta() != null){
                        dtoDeta.setOidFormaPago(dto.getOidFormaPago());
                         if(dtoDeta.getTipoOperacion()==null){
                            dtoDeta.setTipoOperacion(ConstantesPRE.OPERACION_MODIFICACION);
                         }
                     }
                    // Fin modificado SICC20070375
                    //UtilidadesLog.debug("getTipoOperacion en alta o modif");
                    UtilidadesLog.debug("pperez  -  procesando detalle: " + i);
                    this.insertarDatosDetalle(numDe, dto.getOidOferta(),dtoDeta,(cantDeta+i+1));
                }
            }
            //UtilidadesLog.debug("continua con venta exclusiva");
            if (dto.getModificacionVentaExclusiva().booleanValue()){
                this.eliminarDatosVentaExclusiva(dto.getVentaExclusiva());
                this.insertarDatosVentaExclusiva(dto.getOidOferta(),dto.getVentaExclusiva());
            }
            //UtilidadesLog.debug("continua con venta getModificacionRangoPromocion");
            if (dto.getModificacionRangoPromocion().booleanValue() 
                    || dto.getModificacionPromocion().booleanValue()){
                
                this.eliminarDatosPromocion(dto.getPromocion());
                this.insertarDatosPromocion(dto.getOidOferta(),dto.getPromocion());
            }
            
           /* if (Boolean.FALSE.equals(dto.getCodigoVentaGenerado())) { // INC. SICC 20070032 
            if(Boolean.FALSE.equals(dto.getMatrizFacturacionGenerada())){// INC. SICC 20070032 
                PREConsultas pre = new PREConsultas(ctx);
                pre.actualizaCVDetalles(dto.getOidOferta());
            }*/
            /*try {  */
            
              UtilidadesLog.debug("Voy a asignar numeros de linea = " + dto);
              this.asignarNumerosLinea(dto.getOidOferta());
              /*  pperez 31/10/2006   inc DBLG700000135    */
              /*DetalleOfertaLocalHome dolh = this.getDetalleOfertaLocalHome();
              Collection colDeta = dolh.findByOidOfer(dto.getOidOferta());
              Iterator itDeta = colDeta.iterator();
              UtilidadesLog.debug("Se encontraron "+colDeta.size()+" detalles de la oferta "+dto.getOidOferta());
              int numLinea = 1;
              while (itDeta.hasNext()) {
                DetalleOfertaLocal detalle = (DetalleOfertaLocal)itDeta.next();
                detalle.setLineaOferta(new Integer(numLinea));
                UtilidadesLog.debug("Se asigno la linea:"+numLinea+" al detalle:"+detalle.getOid());
                numLinea++;
              }*/
              
            /*} catch (NoResultException fe) {
              UtilidadesLog.debug("No se encontraron detalles no se pudo numerar lineas oferta.");
            } */
            
        }catch (MareException me){
            ctx.setRollbackOnly();
            UtilidadesLog.error(me);
            throw me;
        }        
        UtilidadesLog.info("MONOfertaBean.modificarOferta(DTOOferta dto): Salida");
    }

    /**
     * @author pperanzola
     * @date 29/09/2005
     * @params dto
     * @throws es.indra.mare.common.exception.MareException 
     * se según modelo de componentes SICC-DMCO-PRE-GCC-001
     * [3] pperanzola - 21/10/2005 - se modifica para que no haya excepciones por valores nulos en los tipoOperacion
     *     pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    private  DTOOferta verificarEstadoMF(DTOOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.verificarEstadoMF (DTOOferta dto): Entrada");
        int i;// contador para el for
        int canDetaOfer;// auxiliar para mantener la cantidad de detalle oferta que viene en el dto
        Vector vDetaOfer = dto.getDetalleOferta();
        canDetaOfer = 0;
        if (vDetaOfer != null){ //esto se hace poque si vDetaOfer viene null al hacer .size da excepcion
            canDetaOfer = vDetaOfer.size();
        }
        DTODetalleOferta dtoDeta = null;
        //UtilidadesLog.debug("canDetaOfer=" + canDetaOfer);
        for ( i = 0; i < canDetaOfer; i++){
            dtoDeta = (DTODetalleOferta) vDetaOfer.get(i);
            
            if (ConstantesPRE.OPERACION_ALTA.equalsIgnoreCase(dtoDeta.getTipoOperacion())){//[3]
                //UtilidadesLog.debug("entro en al menos una ");
                dto.setMatrizFacturacionGenerada(Boolean.FALSE);
                dto.setCodigoVentaGenerado(Boolean.FALSE);
                break;
            }
        }
        UtilidadesLog.info("MONOfertaBean.verificarEstadoMF (DTOOferta dto): Salida");
        return dto;
    }

    //Hugo Andres Mansi
    //Creado el 16 de marzo de 2004
    //Recibe un DTOOID
    //Devuelve nada
    //elimina todas las entradas de la oferta que llega en el dtoOid
    public Integer eliminarOferta(DTOOID dtoOid) throws MareException {
        UtilidadesLog.info("MONOfertaBean.eliminarOferta(DTOOID dtoOid): Entrada");
        
        try {
            Integer numeroOferta = null;
            Collection detallesHome = null;
            Collection promociones = null;
            Collection grupoLocal = null;
            Collection ventaExclusiva = null;
            Collection rangosPromociones = null;

            numeroOferta = this.obtenerNumeroOferta(dtoOid.getOid());

            PromocionLocalHome promocionLH = new PromocionLocalHome();
            
            promociones = promocionLH.findByOidOferta(dtoOid.getOid());

            if (!(promociones.isEmpty())) {
                Iterator iterador = promociones.iterator();

                RangosPromocionLocalHome rangoPromoLH = new RangosPromocionLocalHome();

                while (iterador.hasNext()) {
                    PromocionLocal miPromo = (PromocionLocal) iterador.next();
                    rangosPromociones = rangoPromoLH.findByOidPromo(miPromo.getOid());

                    if (!(rangosPromociones.isEmpty())) {                        
                        Iterator iterator = rangosPromociones.iterator();
                        while (iterator.hasNext()) {
                            rangoPromoLH.remove((RangosPromocionLocal)iterator.next());
                        }
                    }

                    promocionLH.remove(miPromo);
                }
            }

            VentaExclusivaLocalHome ventaExclusivaLH = new VentaExclusivaLocalHome();
            ventaExclusiva = ventaExclusivaLH.findByOidOferta(dtoOid.getOid());

            if (!(ventaExclusiva.isEmpty())) {                
                Iterator iterator = ventaExclusiva.iterator();
                while (iterator.hasNext()) {
                    ventaExclusivaLH.remove((VentaExclusivaLocal)iterator.next());
                }
            }

            DetalleOfertaLocalHome detalleHome = new DetalleOfertaLocalHome();
            detallesHome = detalleHome.findByOidOfer(dtoOid.getOid());

            if (!(detallesHome.isEmpty())) {
                Iterator iterador = detallesHome.iterator();
                MatrizFacturacionLocalHome MFacturacionLH = new MatrizFacturacionLocalHome();

                while (iterador.hasNext()) {
                    DetalleOfertaLocal detalleOfertaL = (DetalleOfertaLocal) iterador.next();

                    try {
                        MatrizFacturacionLocal MFacturacionL = MFacturacionLH.findByOidDetaOfer(detalleOfertaL.getOid());
                        
                        MFacturacionLH.remove(MFacturacionL);
                    }catch (NoResultException e) {
                        UtilidadesLog.error(e);
                        //UtilidadesLog.debug("no se encontro matriz");
                    } catch (PersistenceException e) {
                        UtilidadesLog.error(e);
                        throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0052));
                    } 
                    
                    /*inicio agregado enozigli COL-PRE-002*/
                    DetalleOfertaPrecioLocalHome doplh = new DetalleOfertaPrecioLocalHome();
                    Collection colDetaOferPrec = doplh.findByOidDetalle(detalleOfertaL.getOid());
                    if (!colDetaOferPrec.isEmpty()) {
                        Iterator rangosPrecios = colDetaOferPrec.iterator();
                        while (rangosPrecios.hasNext()) {
                            DetalleOfertaPrecioLocal detaOferPrec = (DetalleOfertaPrecioLocal)rangosPrecios.next();
                            doplh.remove(detaOferPrec);
                        }
                    }                    
                    /*fin agregado enozigli COL-PRE-002*/
                    
                    detalleHome.remove(detalleOfertaL);
                }
            }

            GrupoLocalHome gruposLH = new GrupoLocalHome();
            grupoLocal = gruposLH.findByOidOferta(dtoOid.getOid());

            if (!(grupoLocal.isEmpty())) {   
                Iterator iterator = grupoLocal.iterator();
                while (iterator.hasNext()) {
                    gruposLH.remove((GrupoLocal)iterator.next());
                }
            }

            OfertaLocalHome ofertaLH = new OfertaLocalHome();

            OfertaLocal oferta = ofertaLH.findByPrimaryKey(dtoOid.getOid());
            
            ofertaLH.remove(oferta);
            
            UtilidadesLog.info("MONOfertaBean.eliminarOferta(DTOOID dtoOid): Salida");
            return numeroOferta;
            
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException Re) {
            UtilidadesLog.error(Re);
            ctx.setRollbackOnly();
            throw new MareException(Re, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0011));
        }
    }

    //Hugo Andres Mansi
    //Creado el 16 de marzo de 2004
    //Recibe un DTOOID
    //Devuelve nada
    //elimina todas las entradas de la oferta que llega en el dtoOid
    public DTOSalida buscarOfertas(DTOEBuscarOfertas dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarOfertas(DTOEBuscarOfertas dto): Entrada");
        
        RecordSet resultado = new RecordSet();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        DTOSalida dtoOut = new DTOSalida();

        StringBuffer query = new StringBuffer();

        query.append("  SELECT detofer.oid_deta_ofer OID,  ");
        query.append("  ofert.num_ofer numerooferta,  ");
        //V_PRE_24 - cvalenzu - 4/12/2006
        //query.append("  detofer.num_orde numeroorden,  ");
        query.append("  detofer.NUM_ORDE_DETA numeroorden,  ");
        //V_PRE_24
        query.append("  vgen.val_i18n descripcionargumentoventa,  ");
        query.append("  produ.cod_sap codigoproducto,  ");
        query.append("      ( SELECT i18n.VAL_I18N ");
        query.append("        FROM V_GEN_I18N_SICC i18n ");
        query.append("        WHERE i18n.VAL_OID = ofert.COES_OID_ESTR ");
        query.append("         AND i18n.ATTR_ENTI = 'PRE_ESTRA'   ");
        query.append("         AND i18n.ATTR_NUM_ATRI = 1 ");
        query.append("         AND i18n.IDIO_OID_IDIO = " + dto.getOidIdioma());
        query.append("      ) descripcionEstrategia, ");
        query.append("  detofer.val_codi_vent codigoventa,  ");
        query.append("  detofer.VAL_TEXT_BREV descripcion,  ");
        query.append("  detofer.imp_prec_cata preciocatalogo,  ");
        query.append("  catalogo.des_cata descripcioncatalogo,  ");
        query.append("  detofer.num_pagi_cata paginacatalogo,  ");
        query.append("  produ.val_atri_1 atributo1,  ");
        query.append("  produ.val_atri_2 atributo2,  ");
        query.append("  produ.val_atri_3 atributo3,  ");
        query.append("  (SELECT NVL(SUM(mafa.ind_matr_fact),0) FROM PRE_MATRI_FACTU mafa ");
        query.append("   WHERE mafa.MFCA_OID_CABE = cabecera.oid_cabe ");
        query.append("   AND OFDE_OID_DETA_OFER = detofer.oid_deta_ofer) matrizfacturada,  ");
        query.append("  produ.des_cort textobreve, ");
        query.append("  ofert.oid_ofer oidOferta");
        query.append("  FROM pre_matri_factu_cabec cabecera,  ");
        query.append("  pre_ofert ofert,  ");
        query.append("  pre_ofert_detal detofer,  ");
        query.append("  v_gen_i18n_sicc vgen,  ");
        query.append("  pre_catal catalogo,  ");
        query.append("  mae_produ produ  ");

        if (dto.getOidLineaProducto() != null) {
            query.append(" , mae_linea_produ linea  ");
        }
/*CUV29
        if ((dto.getPaginaDesde() != null) || (dto.getPaginaHasta() != null)) {
            query.append("  ,pre_rango_promo rango,  ");
            query.append("  pre_promo promo  ");
        }
*/
        query.append("  WHERE cabecera.oid_cabe = " + dto.getOidCabeceraMF());
        query.append("  AND ofert.mfca_oid_cabe = cabecera.oid_cabe  ");
        query.append("  AND detofer.ofer_oid_ofer = ofert.oid_ofer  ");
        query.append("  AND vgen.idio_oid_idio = " + dto.getOidIdioma());
        query.append("  AND vgen.attr_num_atri = 1  ");
        query.append("  AND vgen.attr_enti = 'PRE_ARGUM_VENTA'  ");
        query.append("  AND vgen.val_oid = ofert.argv_oid_argu_vent  ");
        query.append("  AND produ.oid_prod = detofer.prod_oid_prod  ");
        query.append("  AND detofer.ocat_oid_catal = catalogo.oid_cata(+)  ");
        query.append("  AND produ.pais_oid_pais = " + dto.getOidPais());

        if (dto.getCodSAP() != null) {
            query.append("  AND produ.cod_sap LIKE '" + dto.getCodSAP().toUpperCase() + "'");
        }
        
        if (dto.getCodVta() != null) {
            query.append("  AND detofer.VAL_CODI_VENT LIKE '" + dto.getCodVta().toUpperCase() + "'");
        }

        if (dto.getDescripcionSAP() != null) {
            query.append("  AND detofer.val_text_brev LIKE '" + dto.getDescripcionSAP() + "'");
        }

        if (dto.getOidCatalogo() != null) {
            query.append("  AND catalogo.oid_cata = " + dto.getOidCatalogo());
        }

      //CUV29
      if ((dto.getPaginaDesde() != null) || (dto.getPaginaHasta() != null)) {
          // query.append("  AND ofert.oid_ofer = promo.ofer_oid_ofer  ");
          // query.append("  AND rango.pomo_oid_prom = promo.oid_prom  ");

            if (dto.getPaginaDesde() != null) {
                query.append("  AND detofer.NUM_PAGI_CATA >= " + dto.getPaginaDesde());
            }

            if (dto.getPaginaHasta() != null) {
                query.append("  AND detofer.NUM_PAGI_CATA <= " + dto.getPaginaHasta());
            }
        }

        if (dto.getOidMarca() != null) {
            query.append("  AND produ.MAPR_OID_MARC_PROD = " + dto.getOidMarca());
        }

        if (dto.getOidLineaProducto() != null) {
            query.append("  AND linea.oid_line_prod =  " + dto.getOidLineaProducto());
            query.append("  AND produ.lipr_oid_line_prod = linea.oid_line_prod  ");
        }

        if (dto.getOidUnidadNegocio() != null) {
            query.append("  AND produ.UNEG_OID_UNID_NEGO = " + dto.getOidUnidadNegocio());
        }

        if (dto.getOidNegocio() != null) {
            query.append("  AND produ.NEGO_OID_NEGO = " + dto.getOidNegocio());
        }

        if (dto.getOidGenerico() != null) {
            query.append("  AND produ.GENE_OID_GENE = " + dto.getOidGenerico());
        }

        if (dto.getOidSupergenerico() != null) {
            query.append("  AND produ.SGEN_OID_SUPE_GENE = " + dto.getOidSupergenerico());
        }

        if ((dto.getOidsEstrategias() != null) && (dto.getOidsEstrategias().length() > 0)) {
            query.append(" AND ofert.COES_OID_ESTR IN ( " + dto.getOidsEstrategias() + " )" );
        }
        
        try {
            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

            resultado = (bs.dbService.executeStaticQuery(queryStr));

            if (resultado.esVacio()) {
                String codigoError = null;
                codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                //UtilidadesLog.debug("entra por donde corresponde ");
                throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
            }

            dtoOut.setResultado(resultado);
            
            UtilidadesLog.info("MONOfertaBean.buscarOfertas(DTOEBuscarOfertas dto): Salida");
            return dtoOut;
        } catch (MareException e) {
            UtilidadesLog.error(e); 
            
            throw e;
        } catch (Exception e) {
            
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOOferta obtenerOferta(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerOferta(DTOOID dto): Entrada");
        
        try {
            OfertaLocalHome ofertaHome = new OfertaLocalHome();
            OfertaLocal ofertaLocal = ofertaHome.findByPrimaryKey(dto.getOid());

            Entidadi18nLocalHome idiomaHome = new Entidadi18nLocalHome();

            DTOOferta dtoOferta = new DTOOferta();

            //1 - Oferta
            dtoOferta.setOidOferta(ofertaLocal.getOid());
            //dtoOferta.setNumeroOrden(ofertaLocal.getNumeroOrden());se eliminar por pedido de cambio PRE-003
            dtoOferta.setNumeroOferta(ofertaLocal.getNumeroOferta());
            dtoOferta.setOidAcceso(ofertaLocal.getOidAcceso());
            dtoOferta.setOidCabeceraMF(ofertaLocal.getOidCabe());
            dtoOferta.setOidEstrategia(ofertaLocal.getOidEstr());
            dtoOferta.setCodigoVentaGenerado(ofertaLocal.getCodigoVentaGenerado());
            
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            
            CabeceraMFLocal cabecL = cmflh.findByPrimaryKey(ofertaLocal.getOidCabe());
            dtoOferta.setMatrizFacturada(cabecL.getMatrizFacturada());
            dtoOferta.setMatrizFacturacionGenerada(ofertaLocal.getMatrizFacturacionGenerada());

            Entidadi18nLocal idiomaLocal = null;

            if (ofertaLocal.getOidAcceso() != null) {
                idiomaLocal = idiomaHome.findByEntAtrIdioPK("SEG_ACCES", new Long(1), dto.getOidIdioma(), ofertaLocal.getOidAcceso());
                dtoOferta.setDescripcionAcceso(idiomaLocal.getDetalle());

                if (ofertaLocal.getOidSbac() != null) {
                    dtoOferta.setOidSubacceso(ofertaLocal.getOidSbac());

                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("SEG_SUBAC", new Long(1), dto.getOidIdioma(), ofertaLocal.getOidSbac());
                    dtoOferta.setDescripcionSubacceso(idiomaLocal.getDetalle());
                } else {
                    dtoOferta.setDescripcionSubacceso("");
                }
            } else {
                dtoOferta.setDescripcionAcceso("");
            }

            dtoOferta.setOidArgumentoVenta(ofertaLocal.getOidArguVent());

            idiomaLocal = idiomaHome.findByEntAtrIdioPK("PRE_ARGUM_VENTA", new Long(1), dto.getOidIdioma(), ofertaLocal.getOidArguVent());

            dtoOferta.setDescripcionArgumentoVenta(idiomaLocal.getDetalle());
            dtoOferta.setDespachoCompleto(ofertaLocal.getDespachoCompleto());
            dtoOferta.setDespachoAutomatico(ofertaLocal.getDespachoAutomatico());
            dtoOferta.setRecuperacionObligatoria(ofertaLocal.getRecuperacionObligatoria());
            dtoOferta.setNumeroGrupos(ofertaLocal.getNumeroGrupos());
            dtoOferta.setNumeroPaquetes(ofertaLocal.getNumeroPaquetes());
            dtoOferta.setNumeroGruposCondicionados(ofertaLocal.getNumeroGruposCondicionados());
            dtoOferta.setNumeroGruposCondicionantes(ofertaLocal.getNumeroGruposCondicionantes());
            dtoOferta.setCondicionCondicionados(ofertaLocal.getCondicionCondicionados());
            dtoOferta.setCondicionCondicionantes(ofertaLocal.getCondicionCondicionantes());
            dtoOferta.setUltimaPosicionRanking(ofertaLocal.getUltimaPosicionRanking());
            dtoOferta.setOidFormaPago(ofertaLocal.getOidFormPago());

            if (ofertaLocal.getOidFormPago() != null) {                
                idiomaLocal = idiomaHome.findByEntAtrIdioPK("BEL_FORMA_PAGO", new Long(1), dto.getOidIdioma(), ofertaLocal.getOidFormPago());
                dtoOferta.setDescripcionFormaPago(idiomaLocal.getDetalle());
            }

            dtoOferta.setOidCatalogo(ofertaLocal.getOidCatalogo());

            idiomaLocal = idiomaHome.findByEntAtrIdioPK("PRE_ESTRA", new Long(1), dto.getOidIdioma(), ofertaLocal.getOidEstr());
            dtoOferta.setDescripcionEstrategia(idiomaLocal.getDetalle());

            /* Modificado por ssantana, 19/05/2006. Segun DECU, cuando se inserta una
             * Oferta a traves MAV, el catalogo se setea en null. Si no se contempla,}
             * pincha al modificar dichas Ofertas*/
            if (ofertaLocal.getOidCatalogo() != null) {
                CatalogoLocalHome catalogoHome = new CatalogoLocalHome();
                CatalogoLocal catalogoLocal = catalogoHome.findByPrimaryKey(ofertaLocal.getOidCatalogo());
                dtoOferta.setDescripcionCatalogo(catalogoLocal.getDescripcion());
            }
            /* Fin Modificacion ssantana, 19/05/2006 */

            //2 - Detalle Oferta
            DetalleOfertaLocalHome detalleHome = new DetalleOfertaLocalHome();
            Collection coleccion = detalleHome.findByOidOfer(dto.getOid());

            Vector vectorDetalle = new Vector();
            Iterator iterador = coleccion.iterator();

            int i = 0;
            /* falta el ordenamiento por lineaOferta */
            while (iterador.hasNext()) {
                DTODetalleOferta detalle = new DTODetalleOferta();

                DetalleOfertaLocal detalleLocal = (DetalleOfertaLocal) iterador.next();
                detalle.setOidDetalleOferta(detalleLocal.getOid());
                detalle.setLineaOferta(detalleLocal.getLineaOferta());
                detalle.setOidSAP(detalleLocal.getOidProd());

                //idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_PRODU", new Long(1), dto.getOidIdioma(), detalleLocal.getOidProd());
                detalle.setDescripcion(detalleLocal.getTextoBreve());
                detalle.setUnidadesEstimadas(detalleLocal.getUnidadesEstimadas());
                detalle.setOrigen(detalleLocal.getOrigen());
                detalle.setFactorRepeticion(detalleLocal.getFactorRepeticion());

                MaestroProductosLocalHome maeProduHome = this.getMaestroProductosLocalHome();
                MaestroProductosPK clave = new MaestroProductosPK(detalleLocal.getOidProd());
                MaestroProductosLocal maeProduLocal = maeProduHome.findByPrimaryKey(clave);
                detalle.setAtributo1(maeProduLocal.getAtributo1());
                detalle.setCodigoSAP(maeProduLocal.getCodigoSAP());
                detalle.setAtributo2(maeProduLocal.getAtributo2());
                detalle.setAtributo3(maeProduLocal.getAtributo3());
                detalle.setImpresionGP(detalleLocal.getImpresionGP());
                detalle.setDigitable(detalleLocal.getDigitable());
                detalle.setPosicionRanking(detalleLocal.getPosicionRanking());
                detalle.setOidFormaPago(detalleLocal.getOidFormPago());
                detalle.setOidGrupo(detalleLocal.getOidGrupOfer()); //?
                detalle.setProductoPrincipal(detalleLocal.getProductoPrincipal());
                detalle.setPrecioCatalogo((detalleLocal.getPrecioCatalogo()));
                detalle.setPrecioPosicionamiento((detalleLocal.getPrecioPosicionamiento()));

                detalle.setCosteEstandar((detalleLocal.getCosteEstandar()));

                detalle.setVentaNetaEstimada(detalleLocal.getVentaNetaEstimada());
                detalle.setOidCatalogo(detalleLocal.getOidCatal());
                detalle.setPaginaCatalogo(detalleLocal.getNumeroPaginaCatalogo()); //?
                detalle.setPosicionPagina(detalleLocal.getPosicionPagina());
                detalle.setOidCondicionPromocion(detalleLocal.getOidCondProm());

                detalle.setOidTipoOferta(detalleLocal.getOidTipoOfer());
                detalle.setOidCicloVida(detalleLocal.getOidCicloVida());
                detalle.setCodigoVentaGenerado(detalleLocal.getCodigoVentaGenerado());
                detalle.setCentro(detalleLocal.getCentro());
                
                //club priviledges
                detalle.setProgramaFidelizacion(detalleLocal.getProgramaFidelizacion());
                detalle.setVariantes(detalleLocal.getVariante());
                detalle.setPuntajeFijo(detalleLocal.getPuntajeFijo());

                //enozigli 18/11/2004 cambio por incidencia 10451
                detalle.setCodigoVenta(detalleLocal.getCodigoVenta());

                /*inicio agregado enozigli COL-PRE-002*/
                DetalleOfertaPrecioLocalHome doplh = new DetalleOfertaPrecioLocalHome();
               
                try {
                    Collection colRangosPrecios = doplh.findByOidDetalle(detalleLocal.getOid());
                    
                    if (!colRangosPrecios.isEmpty()) {
                    
                        detalle.setRangosPrecios(new Vector());
                        Iterator itRangosPrecios = colRangosPrecios.iterator();
                        
                        while (itRangosPrecios.hasNext()) {
                            DTORangoPrecios dtoRango = new DTORangoPrecios();
                            
                            DetalleOfertaPrecioLocal rango = (DetalleOfertaPrecioLocal)itRangosPrecios.next();
                            
                            if (rango.getNumeroOrdenRango()!=null) {
                              dtoRango.setNumeroOrdenRango(new Integer(rango.getNumeroOrdenRango().intValue()));
                            }
                            dtoRango.setOidDetaOfer(detalleLocal.getOid());
                            dtoRango.setOidDetaOferPrec(rango.getOid());
                            dtoRango.setPrecioCatalogo(rango.getPrecioCatalogo());
                            dtoRango.setPrecioPosicionamiento(rango.getPrecioPosicionamiento());
                            dtoRango.setRangoDesde(rango.getRangoDesde());
                            dtoRango.setRangoHasta(rango.getRangoHasta());
                            
                            detalle.getRangosPrecios().add(dtoRango);
                        }
                    }
                    
                } catch (NoResultException ez) {
                    UtilidadesLog.debug("No se encontraron rangos de precios definidos para el detalle "+ detalleLocal.getOid());
                    UtilidadesLog.error(ez);
                }
                /*fin agregado enozigli COL-PRE-002*/
                
                if (detalleLocal.getOidGrupOfer() != null) {
                    GrupoLocalHome grupoHomeD = new GrupoLocalHome();

                    try {
                        GrupoLocal gl = grupoHomeD.findByPrimaryKey(detalleLocal.getOidGrupOfer());
                        detalle.setNumeroGrupo(gl.getNumeroGrupo());
                    } catch (NoResultException ez) {
                        UtilidadesLog.error(ez); 
                        ctx.setRollbackOnly();
                        throw new MareException(ez, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }
                }

                //  Agregado por HRCS - Fecha 19/03/2007 - Incidencia SICC 20070106
                detalle.setSecuencial( new Integer(i) );
                i++;
                
                vectorDetalle.add(detalle);
            }

            //  Agregado por HRCS - Fecha 19/03/2007 - Incidencia SICC 20070106
            dtoOferta.setUltimaSecuencia( new Integer( i ) );
            dtoOferta.setDetalleOferta(vectorDetalle);

            //3 - Venta Exclusiva
            VentaExclusivaLocalHome ventaHome = new VentaExclusivaLocalHome();
            Collection coleccion2 = ventaHome.findByOidOferta(dto.getOid());
            
            ZonaLocalHome zlh = new ZonaLocalHome();
            RegionLocalHome rlh = new RegionLocalHome();

            Vector vectorVenta = new Vector();
            Iterator iterador2 = coleccion2.iterator();

            while (iterador2.hasNext()) {
                DTOVentaExclusiva venta = new DTOVentaExclusiva();

                VentaExclusivaLocal ventaLocal = (VentaExclusivaLocal) iterador2.next();
                venta.setOidVentaExclusiva(ventaLocal.getOid());

                if (ventaLocal.getOidTipoClie() != null) {
                    venta.setOidTipoCliente(ventaLocal.getOidTipoClie());
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_TIPO_CLIEN", new Long(1), dto.getOidIdioma(), ventaLocal.getOidTipoClie());
                    venta.setDescripcionTipoCliente(idiomaLocal.getDetalle());
                }

                if (ventaLocal.getOidSubtClie() != null) {
                    venta.setOidSubtipoCliente(ventaLocal.getOidSubtClie());
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_SUBTI_CLIEN", new Long(1), dto.getOidIdioma(), ventaLocal.getOidSubtClie());
                    venta.setDescripcionSubtipoCliente(idiomaLocal.getDetalle());
                }

                if (ventaLocal.getOidTipoClas() != null) {
                    venta.setOidTipoClasificacion(ventaLocal.getOidTipoClas());
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_TIPO_CLASI_CLIEN", new Long(1), dto.getOidIdioma(), ventaLocal.getOidTipoClas());
                    venta.setDescripcionTipoClasificacion(idiomaLocal.getDetalle());
                }

                if (ventaLocal.getOidClas() != null) {
                    venta.setOidClasificacion(ventaLocal.getOidClas());
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_CLASI", new Long(1), dto.getOidIdioma(), ventaLocal.getOidClas());
                    venta.setDescripcionClasificacion(idiomaLocal.getDetalle());
                }

                if (ventaLocal.getOidEstaClie() != null) {
                    venta.setOidEstatus(ventaLocal.getOidEstaClie());
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_ESTAT_CLIEN", new Long(1), dto.getOidIdioma(), ventaLocal.getOidEstaClie());
                    venta.setDescripcionEstatus(idiomaLocal.getDetalle());
                }
                
                if (ventaLocal.getOidRegion() != null) {
                    venta.setOidRegion(ventaLocal.getOidRegion());
                    RegionLocal region = rlh.findByPrimaryKey(ventaLocal.getOidRegion());
                    venta.setDescripcionRegion(region.getDescripcionRegion());
                }

                if (ventaLocal.getOidZona() != null) {
                    venta.setOidZona(ventaLocal.getOidZona());
                    ZonaLocal zona = zlh.findByPrimaryKey(ventaLocal.getOidZona());
                    venta.setDescripcionZona(zona.getDescripcion());
                }                

                venta.setEstatus2(ventaLocal.getEstatus2());

                vectorVenta.add(venta);
            }

            dtoOferta.setVentaExvlusiva(vectorVenta);

            //4 - Grupo
            GrupoLocalHome grupoHome = new GrupoLocalHome();
            Collection coleccion3 = grupoHome.findByOidOferta(dto.getOid());

            Vector vectorGrupo = new Vector();
            Iterator iterador3 = coleccion3.iterator();

            while (iterador3.hasNext()) {
                DTOGrupo grupo = new DTOGrupo();

                GrupoLocal grupoLocal = (GrupoLocal) iterador3.next();
                grupo.setOidGrupo(grupoLocal.getOid());
                grupo.setNumeroGrupo(grupoLocal.getNumeroGrupo());

                if (grupoLocal.getFactorCuadre() != null) {
                    //SCS-EAN grupo.setFactorCuadre(new Integer(grupoLocal.getFactorCuadre().intValue()));
                    grupo.setFactorCuadre(grupoLocal.getFactorCuadre());
                }

                grupo.setIndicadorGrupo(grupoLocal.getIndicadorGrupo());
                grupo.setCondicionante(grupoLocal.getCondicionante());
                grupo.setCondicionado(grupoLocal.getCondicionado());

                if (grupoLocal.getOidIndCuadTipoEstr() != null) {
                    grupo.setOidIndicadorCuadre(grupoLocal.getOidIndCuadTipoEstr());

                    //PRE_INDIC_CUADR_TIPO_ESTRA
                    Long indCuadreTipoEstra = grupoLocal.getOidIndCuadTipoEstr();

                    IndicadorCuadrePorTipoEstrategiaLocalHome indCuadreLH = new IndicadorCuadrePorTipoEstrategiaLocalHome();
                    IndicadorCuadrePorTipoEstrategiaLocal indCuadreL = indCuadreLH.findByPrimaryKey(indCuadreTipoEstra);

                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("PRE_INDIC_CUADR", new Long(1), dto.getOidIdioma(), indCuadreL.getOidIndiCuad());
                    grupo.setDescripcionIndicadorCuadre(idiomaLocal.getDetalle());
                }

                vectorGrupo.add(grupo);
            }

            dtoOferta.setGrupo(vectorGrupo);

            //5 - Promocion
            PromocionLocalHome promoHome = new PromocionLocalHome();
            Collection coleccion4 = promoHome.findByOidOferta(dto.getOid());

            Vector vectorPromo = new Vector();
            Iterator iterador4 = coleccion4.iterator();

            while (iterador4.hasNext()) {
                DTOPromocion promo = new DTOPromocion();

                PromocionLocal promoLocal = (PromocionLocal) iterador4.next();
                promo.setOidPromocion(promoLocal.getOid());
                promo.setNumeroCondicion(promoLocal.getNumeroCondicion());
                promo.setOidIndicadorCuadre(promoLocal.getIndicadorCuadrePromocion());
                promo.setFactorCuadre((promoLocal.getFactorCuadre() == null) ? null : new Float(promoLocal.getFactorCuadre().floatValue()));

                if (promoLocal.getIndicadorCuadrePromocion() != null) {
                    idiomaLocal = idiomaHome.findByEntAtrIdioPK("PRE_INDIC_CUADR_PROMO", new Long(1), dto.getOidIdioma(), promoLocal.getIndicadorCuadrePromocion());
                    promo.setDescripcionIndicadorCuadre(idiomaLocal.getDetalle());
                }

                //6 - Rango Promocion
                RangosPromocionLocalHome rPromoHome = new RangosPromocionLocalHome();
                Collection coleccion5 = rPromoHome.findByOidPromo(promoLocal.getOid());

                Vector vectorRangoPromo = new Vector();
                Iterator iterador5 = coleccion5.iterator();

                while (iterador5.hasNext()) {
                    DTOLineaPromocion lPromo = new DTOLineaPromocion();

                    RangosPromocionLocal rPromoLocal = (RangosPromocionLocal) iterador5.next();
                    lPromo.setOidLineaPromocion(rPromoLocal.getOid());
                    lPromo.setOidCatalogo(rPromoLocal.getOidCata());
                    
                    CatalogoLocalHome clh = new CatalogoLocalHome();
                    
                    CatalogoLocal catLocal = clh.findByPrimaryKey(rPromoLocal.getOidCata());

                    lPromo.setDescripcionCatalogo(catLocal.getDescripcion());
                    lPromo.setTipoRango(rPromoLocal.getTipoRango().charAt(0));
                    lPromo.setNumeroRangoInterno(rPromoLocal.getNumeroRangoInterno());
                    lPromo.setIndicadorExclusion(rPromoLocal.getIndicadorExclusion());
                    lPromo.setValorDesde(rPromoLocal.getValorDesde());
                    lPromo.setValorHasta(rPromoLocal.getValorHasta());

                    if (rPromoLocal.getTipoRango().equalsIgnoreCase("P")) { //Producto

                        MaestroProductosPK pk = new MaestroProductosPK(new Long(lPromo.getValorDesde()));
                        MaestroProductosLocal mpl = getMaestroProductosLocalHome().findByPrimaryKey(pk);
                        lPromo.setDescripcionProducto(mpl.getDescripcionCorta());
                        lPromo.setCodigoProducto(mpl.getCodigoSAP());
                    }

                    if (rPromoLocal.getTipoRango().equalsIgnoreCase("L")) { //Linea de Producto                        
                        idiomaLocal = idiomaHome.findByEntAtrIdioPK("MAE_LINEA_PRODU", new Long(1), dto.getOidIdioma(), new Long(lPromo.getValorDesde()));
                        lPromo.setDescripcionLineaProducto(idiomaLocal.getDetalle());

                        String codigo = obtenerCodigoLineaProducto(new Long(lPromo.getValorDesde()), dto.getOidPais());
                        lPromo.setCodigoLineaProducto(codigo);
                    }

                    vectorRangoPromo.add(lPromo);
                }

                promo.setLineaPromocion(vectorRangoPromo);

                vectorPromo.add(promo);
            }

            dtoOferta.setPromocion(vectorPromo);
            
            UtilidadesLog.info("MONOfertaBean.obtenerOferta(DTOOID dto): Salida");
            return dtoOferta;
            
        } catch (NoResultException ez) {
            UtilidadesLog.error(ez);
            ctx.setRollbackOnly();
            throw new MareException(ez, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (NamingException ex) {
            UtilidadesLog.error(ex); 
            ctx.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception e) {
            ctx.setRollbackOnly();
            if (e instanceof MareException) {
                throw (MareException) e;
            } else {
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
    }

    public DTOModificarOferta obtenerOfertaModificacion(DTOOID dtoOId) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerOfertaModificacion(DTOOID dto): Entrada");
        
        DTOModificarOferta dtoModif = new DTOModificarOferta();

        try {
            DTOECargarCriteriosDefinirOferta dtoECargarCriterios = new DTOECargarCriteriosDefinirOferta();
            OfertaLocalHome ofertaLocalHome = new OfertaLocalHome();
            OfertaLocal ofertaLocal = ofertaLocalHome.findByPrimaryKey(dtoOId.getOid());
            dtoECargarCriterios.setOidCabeceraMF(ofertaLocal.getOidCabe());
            dtoECargarCriterios.setOidEstrategia(ofertaLocal.getOidEstr());
            dtoECargarCriterios.setOidIdioma(dtoOId.getOidIdioma());
            dtoECargarCriterios.setOidPais(dtoOId.getOidPais());

            PREConsultas pre = new PREConsultas(ctx);
            dtoModif.setDtoOferta(this.obtenerOferta(dtoOId));
            dtoModif.setDtoCargarCriterios(pre.cargarCriteriosDefinirOferta(dtoECargarCriterios));
        } catch (NoResultException ez) {
            UtilidadesLog.error(ez);
            throw new MareException(ez, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        
        UtilidadesLog.info("MONOfertaBean.obtenerOfertaModificacion(DTOOID dto): Salida");
        return dtoModif;
    }

    public DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.cargarCriteriosBusquedaProductos(DTOOID dto): Entrada");
        
        String usuario = ctx.getCallerPrincipal().getName();
        PREConsultas pcons = new PREConsultas(usuario);
                
        UtilidadesLog.info("MONOfertaBean.cargarCriteriosBusquedaProductos(DTOOID dto): Salida");
        return pcons.cargarCriteriosBusquedaProductos(dto);
    }
  public DTOSCargarCriteriosBusquedaProductos cargarCriteriosBusquedaProductosMinimo(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.cargarCriteriosBusquedaProductosMinimo(DTOOID dto): Entrada");
        
        String usuario = ctx.getCallerPrincipal().getName();
        PREConsultas pcons = new PREConsultas(usuario);
                
        UtilidadesLog.info("MONOfertaBean.cargarCriteriosBusquedaProductosMinimo(DTOOID dto): Salida");
        return pcons.cargarCriteriosBusquedaProductosMinimo(dto);
  }    

    public DTOSCargarCriteriosDefinirOferta cargarCriteriosDefinirOferta(DTOECargarCriteriosDefinirOferta dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.cargarCriteriosDefinirOferta(DTOECargarCriteriosDefinirOferta dto): Entrada");
        
        String usuario = ctx.getCallerPrincipal().getName();        
        PREConsultas pcons = new PREConsultas(usuario);

        UtilidadesLog.info("MONOfertaBean.cargarCriteriosDefinirOferta(DTOECargarCriteriosDefinirOferta dto): Salida");
        return pcons.cargarCriteriosDefinirOferta(dtoe);
    }

    public DetalleOfertaLocal guardarDetalleOferta(DTODetalleOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.guardarDetalleOferta(DTODetalleOferta dto): Salida");
        
        //El método crea una entrada en la entidad DetalleOferta con los datos recibidos en el DTODetalleOferta.
        if (dto == null) {
            return null;
        }

        try {
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            
            DetalleOfertaLocal dol = dolh.create(dto.getOidDetalleOferta(), dto.getOidSAP(), dto.getLineaOferta(), dto.getFactorRepeticion(), dto.getOidTipoOferta(), dto.getOidCicloVida(), null);

            dol.setOidCatal(dto.getOidCatalogo());
            dol.setOidCondProm(dto.getOidCondicionPromocion());
            dol.setTextoBreve(dto.getDescripcion());
            dol.setOrigen(dto.getOrigen());
            dol.setFactorRepeticion(dto.getFactorRepeticion());
            dol.setImpresionGP(dto.getImpresionGP());
            dol.setDigitable(dto.getDigitable());
            dol.setOidFormPago(dto.getOidFormaPago());

            //Como esto es una constraint no se setea, al no tener valor.....
            //dol.setOidGrupOfer(new Long(dto.getNumeroGrupo().longValue()));
            dol.setPrecioCatalogo(dto.getPrecioCatalogo());
            dol.setPrecioPosicionamiento(dto.getPrecioPosicionamiento());
            
            DAOCCC dao = new DAOCCC();
            int numDe = dao.obtenerNumDeci(dto.getOidPais());            
            
            // Agregado por SiCC 20070326 - Rafael Romero - 11/07/2007
            // Calculo de precio unitario
            if(dto.getFactorRepeticion()!=null && dto.getFactorRepeticion().intValue()!=0){
                BigDecimal precioUnitario = new BigDecimal(0);
                if(dto.getPrecioCatalogo()!=null){
                    precioUnitario = dto.getPrecioCatalogo().divide(new BigDecimal(dto.getFactorRepeticion().intValue()),numDe,BigDecimal.ROUND_DOWN);
                }
                dol.setPrecioUnitario(precioUnitario);
            }
            // Fin agregado SiCC 20070236
            dolh.merge(dol);
            
            UtilidadesLog.info("MONOfertaBean.guardarDetalleOferta(DTODetalleOferta dto): Salida");
            return dol;
            
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();            
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0032));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);            
            ctx.setRollbackOnly();            
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

    public OfertaLocal guardarCabeceraOferta(DTOOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.guardarCabeceraOferta(DTOOferta dto): Entrada");
        
        //El método crea una entrada en la entidad Oferta con los datos recibidos en el DTOOferta.
        if (dto == null) {
            return null;
        }

        try {
            OfertaLocalHome olh = new OfertaLocalHome();

            //olh.parametrosAuditoria(dto);
            OfertaLocal ol = olh.create(dto.getOidEstrategia(), dto.getNumeroOferta(), dto.getOidArgumentoVenta(), dto.getOidCabeceraMF(), dto.getOidCatalogo());

            //ol.setOidArguVent(dto.getOidArgumentoVenta());

            /*ol.setDespachoCompleto(dto.getDespachoCompleto());
            ol.setDespachoAutomatico(dto.getDespachoAutomatico());
            ol.setNumeroGrupos(dto.getNumeroGrupos());
            ol.setNumeroPaquetes(dto.getNumeroPaquetes());
            ol.setNumeroGruposCondicionados(dto.getNumeroGruposCondicionados());
            ol.setNumeroGruposCondicionantes(dto.getNumeroGruposCondicionantes());
            ol.setOidFormPago(dto.getOidFormaPago());
            ol.setCodigoVentaGenerado(dto.getCodigoVentaGenerado());
            ol.setMatrizFacturacionGenerada(dto.getMatrizFacturacionGenerada());*/

            // Agregado por ssantana, 18/7/2005
            // Faltaban setear campos.
            ol.setCodigoVentaGenerado(dto.getCodigoVentaGenerado());
            ol.setCondicionCondicionados(dto.getCondicionCondicionados());
            ol.setCondicionCondicionantes(dto.getCondicionCondicionantes());
            ol.setDespachoAutomatico(dto.getDespachoAutomatico());
            ol.setDespachoCompleto(dto.getDespachoCompleto());
            ol.setMatrizFacturacionGenerada(dto.getMatrizFacturacionGenerada());
            ol.setNumeroGrupos(dto.getNumeroGrupos());
            ol.setNumeroGruposCondicionados(dto.getNumeroGruposCondicionados());
            ol.setNumeroGruposCondicionantes(dto.getNumeroGruposCondicionantes());
            ol.setNumeroOferta(dto.getNumeroOferta());
            //ol.setNumeroOrden(dto.getNumeroOrden()); se elimina por pedido de cambio PRE-003
            ol.setNumeroPaquetes(dto.getNumeroPaquetes());
            ol.setOidAcceso(dto.getOidAcceso());
            ol.setOidArguVent(dto.getOidArgumentoVenta());
            ol.setOidCabe(dto.getOidCabeceraMF());
            ol.setOidEstr(dto.getOidEstrategia());
            ol.setOidFormPago(dto.getOidFormaPago());
            ol.setOidSbac(dto.getOidSubacceso());
            ol.setPrimeraPosicionRanking(dto.getPrimeraPosicionRanking());
            ol.setRecuperacionObligatoria(dto.getRecuperacionObligatoria());
            ol.setRegistroEstadisticoGenerado(dto.getRegistroEstadisticoGenerado());
            ol.setUltimaPosicionRanking(dto.getUltimaPosicionRanking());

            // Fin agregado ssantana, 18/7/2005
             olh.merge(ol);
            
            UtilidadesLog.info("MONOfertaBean.guardarCabeceraOferta(DTOOferta dto): Salida");
            return ol;
            
        } catch (PersistenceException ne) {
            UtilidadesLog.error(ne);
            ctx.setRollbackOnly();            
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0032));
        } catch (Exception exception) {
            UtilidadesLog.error(exception);
            ctx.setRollbackOnly();            
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
    }

   /*
    * Creado el 23 de junio de 2004
    * Autores Marta Montiel y Hugo Mansi
    * Recibe  Oid de la cabecera, el oid de la oferta y el  número de orden
    * Devuelve un objeto boolean
    * Descripción: Según la incidencia número 5944 del 15/06/2004 se agrega este método, que
    * valida el número de orden para que no esté repetido al querer guardar la oferta.
    */
    private Boolean validarNumeroOrden(Long oidCabecera, Integer nroOrden, Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.validarNumeroOrden(Long oidCabecera, Integer nroOrden, Long oidOferta): Entrada");
        
        Boolean objeto = Boolean.TRUE;

        RecordSet rs = new RecordSet();

        BelcorpService belcorpService = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        query.append("select * ");
        query.append("from PRE_OFERT ");
        query.append("where MFCA_OID_CABE = " + oidCabecera);
        query.append("and NUM_ORDE = " + nroOrden);
        query.append("and OID_OFER != " + oidOferta);

        try {
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if (!rs.esVacio()) {
            throw new MareException(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0030));

            //objeto = objeto.FALSE;
        } else {
            rs = new RecordSet();
            belcorpService = BelcorpService.getInstance();
            query = new StringBuffer();
            query.append("select * ");
            query.append("from PRE_TEXTO_OFERT ");
            query.append("where MFCA_OID_CABE = " + oidCabecera);
            query.append("and NUM_ORDE = " + nroOrden);

            try {
                rs = belcorpService.dbService.executeStaticQuery(query.toString());
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }

            if (!rs.esVacio()) {
                throw new MareException(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0029));

                // objeto = objeto.FALSE;
            } else {
                objeto = objeto.TRUE;
            }
        }
        
        UtilidadesLog.info("MONOfertaBean.validarNumeroOrden(Long oidCabecera, Integer nroOrden, Long oidOferta): Salida");
        return objeto;
    }

    /*
      Entrada: DTOOID (oid de Cabecera de Matriz de Facturación)
      Proceso:
      -> Se realiza una consulta sobre la tabla PRE_MATRI_FACTU_CABEC haciendo join con
      CRA_PERIO, para obtener los campos OID_PERI, MARC_OID_MARC, CANA_OID_CANA, PAIS_OID_PAIS
      de CRA_PERIO y sus respectivas descripciones internacionalizadas, se filtrará por el
      campo OID_CABE que será igual al atributo oidCabeceraMF del dto de entrada.

      Campos RecordSet:
      - oidPais
      - descripcionPais
      - oidMarca
      - descripcionMarca
      - oidCanal
      - descripcionCanal
      - oidPeriodo
      - descripcionPeriodo

      -> Devolver RecordSet obtenido en un DTOSalida
     */
    public DTOSalida cargarPaisMarcaCanalPeriodo(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.cargarPaisMarcaCanalPeriodo(DTOOID dto): Entrada");
        
        StringBuffer query = new StringBuffer();
        DTOSalida dtores = new DTOSalida();

        query.append("SELECT cp.PAIS_OID_PAIS, i18nPais.VAL_I18N DES_PAIS, cp.MARC_OID_MARC, sm.DES_MARC ,cp.CANA_OID_CANA, ");
        query.append("i18nCanal.VAL_I18N DES_CANAL, cp.OID_PERI, cp.VAL_NOMB_PERI ");
        query.append("FROM PRE_MATRI_FACTU_CABEC mfc, CRA_PERIO cp, V_GEN_I18N_SICC i18nCanal, ");
        query.append("V_GEN_I18N_SICC i18nPais, SEG_MARCA sm ");
        query.append("WHERE mfc.OID_CABE = " + dto.getOid() + " ");
        query.append("AND mfc.PERD_OID_PERI = cp.OID_PERI ");
        query.append("AND cp.MARC_OID_MARC = sm.OID_MARC ");
        query.append("AND i18nCanal.ATTR_ENTI = 'SEG_CANAL' ");
        query.append("AND i18nCanal.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18nCanal.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append("AND i18nCanal.VAL_OID = cp.CANA_OID_CANA ");
        query.append("AND i18nPais.ATTR_ENTI = 'SEG_PAIS' ");
        query.append("AND i18nPais.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18nPais.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append("AND i18nPais.VAL_OID = cp.PAIS_OID_PAIS ");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        dtores.setResultado(rSet);
        
        UtilidadesLog.info("MONOfertaBean.cargarPaisMarcaCanalPeriodo(DTOOID dto): Salida");
        return dtores;
    }

    /*
    El método accede a la tabla PRE_OFER filtrando por:

    - oidCabeceraMF
    - oidEstrategia

    y obtiene el mayor valor para numeroOferta de entre todas las ofertas recuperadas.

    Devuelve el valor encontrado.
     */
    public Integer obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia): Entrada");
        
        StringBuffer query = new StringBuffer();
        Integer res = null;

        query.append("SELECT MAX(po.NUM_OFER) NUM ");
        query.append("FROM PRE_OFERT po ");
        query.append("WHERE po.COES_OID_ESTR = " + oidEstrategia + " ");
        query.append("AND po.MFCA_OID_CABE = " + oidCabeceraMF + " ");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        res = BigToInteger(rSet.getValueAt(0, "NUM"));
        UtilidadesLog.debug("ultimo nro of de matr " + oidCabeceraMF + "estra" + oidEstrategia + ":" + res);
        
        UtilidadesLog.info("MONOfertaBean.obtenerUltimoNumeroOferta(Long oidCabeceraMF, Long oidEstrategia): Salida");
        return res;
    }

    public DTOSalida obtenerProductos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerProductos(DTOOID dto): Entrada");
        
        StringBuffer query = new StringBuffer();
        DTOSalida dtores = new DTOSalida();

        query.append("SELECT pev.PROD_OID_PROD, pev.IMP_PREC_CATA, pev.NUM_PAGI_CATA, pev.VAL_POSI_PAGI, pev.NUM_UNID_ESTI, ");
        query.append("av.VAL_FACT_REPE, pev.IMP_VENT_NETA_ESTI, pev.IMP_PREC_POSI, pev.VAL_COST_ESTA, pev.OCAT_OID_CATA, ");
        query.append("pev.TOFE_OID_TIPO_OFER, i18nTipoOferta.VAL_I18N DES_TIPO_OFER, pev.CIVI_OID_CICL_VIDA, i18nCicloVida.VAL_I18N DES_CICLO_VIDA, ");
        query.append("pev.VAL_CENT ");
        query.append("FROM PRE_ESTIM_VENTA pev, PRE_ARGUM_VENTA av, V_GEN_I18N_SICC i18nTipoOferta, V_GEN_I18N_SICC i18nCicloVida ");
        query.append("WHERE pev.PROD_OID_PROD = " + dto.getOid() + " ");
        query.append("AND pev.ARGV_OID_ARGU_VENT = av.OID_ARGU_VENT ");
        query.append("AND i18nTipoOferta.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
        query.append("AND i18nTipoOferta.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18nTipoOferta.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append("AND i18nTipoOferta.VAL_OID = pev.TOFE_OID_TIPO_OFER ");
        query.append("AND i18nCicloVida.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
        query.append("AND i18nCicloVida.ATTR_NUM_ATRI = 1 ");
        query.append("AND i18nCicloVida.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
        query.append("AND i18nCicloVida.VAL_OID = pev.CIVI_OID_CICL_VIDA ");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (rSet.esVacio()) {
            //en este caso busco en Maestro de Productos
            query.append("SELECT mp.OID_PROD, mp.COD_SAP, i18nSap.VAL_I18N DES_SAP, mp.VAL_PREC_CATA, null NUM_PAGI_CATA, null DES_TIPO_OFER, ");
            query.append("null DES_CICLO_VIDA, mp.VAL_ATRI_1, mp.VAL_ATRI_2, mp.VAL_ATRI_3, null VAL_POSI_PAGI, null NUM_UNID_ESTI, ");
            query.append("null VAL_FACT_REPE, null IMP_VENT_NETA_ESTI, mp.VAL_PREC_POSI, mp.VAL_COST_ESTD, null OCAT_OID_CATA, ");
            query.append("null TOFE_OID_TIPO_OFER, null CIVI_OID_CICL_VIDA, null VAL_CENT ");
            query.append("FROM MAE_PRODU mp, V_GEN_I18N_SICC i18nSap ");
            query.append("WHERE mp.OID_PROD = " + dto.getOid() + " ");
            query.append("AND i18nSap.ATTR_ENTI = 'MAE_PRODU' ");
            query.append("AND i18nSap.ATTR_NUM_ATRI = 1 ");
            query.append("AND i18nSap.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append("AND i18nSap.VAL_OID = mp.OID_PROD ");

            try {
                rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                UtilidadesLog.error(me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }
        }

        dtores.setResultado(rSet);
        
        UtilidadesLog.info("MONOfertaBean.obtenerProductos(DTOOID dto): Salida");
        return dtores;
    }

    public DTOTextoOferta obtenerTextoOferta(DTOTextoOferta dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerTextoOferta(DTOTextoOferta dtoe): Entrada");
        
        StringBuffer query = new StringBuffer();
        DTOTextoOferta dtores = new DTOTextoOferta();

        query.append(" SELECT OID_TEXT_OFER, VAL_TEXT, VAL_TEXT, OCAT_OID_CATA ");
        query.append(" FROM PRE_TEXTO_OFERT ");
        query.append(" WHERE MFCA_OID_CABE = " + dtoe.getOidCabeceraMF() );
        query.append(" AND NUM_ORDE = " + dtoe.getNumeroOrden() );

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (!rSet.esVacio()) { //inc. 7479 ok
            //en este caso seteo el dto
            //UtilidadesLog.debug("Existe El texto a Validar");
            dtores.setOid(BigToLong(rSet.getValueAt(0, "OID_TEXT_OFER")));
            dtores.setTexto((String) rSet.getValueAt(0, "VAL_TEXT"));
            dtores.setOidCatalogo(BigToLong(rSet.getValueAt(0, "OCAT_OID_CATA")));
        } else {
            //si esta vacio
            query = new StringBuffer();
            query.append(" SELECT OID_OFER ");
            query.append(" FROM PRE_OFERT ");
            query.append(" WHERE MFCA_OID_CABE = " + dtoe.getOidCabeceraMF() );
            query.append(" AND NUM_ORDE = " + dtoe.getNumeroOrden() );

            try {
                rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                UtilidadesLog.error(me);
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            if (!rSet.esVacio()) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.PRE_0030));
            }
         }
        UtilidadesLog.info("MONOfertaBean.obtenerTextoOferta(DTOTextoOferta dtoe): Salida");
        return dtores;
    }

    /**
     * Comprueba si existe el numero de orden para una matriz de facturacion. Retorna true si ya existe.
     * No se debe de tener en cuenta el catalogo, pues el numero de orden es unico en la matriz de facturacion. Incidencia 20891.
     */
    public Boolean comprobarNumeroOrden(DTOTextoOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.comprobarNumeroOrden(DTOTextoOferta dto): Entrada");
        
        StringBuffer query = new StringBuffer();        

        query.append(" SELECT OID_TEXT_OFER ");
        query.append(" FROM PRE_TEXTO_OFERT ");
        query.append(" WHERE MFCA_OID_CABE = " + dto.getOidCabeceraMF() );
        query.append(" AND NUM_ORDE = " + dto.getNumeroOrden() );

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        if (!rSet.esVacio()) { //inc. 7481 ok
            //en este caso seteo el dto
            return Boolean.valueOf(false);
        } else {
            //si esta vacio
            query = new StringBuffer();
            //cambia por pedido de cambio PRE-003 (el numero de orden ahora pertenece a los detalles de oferta)
            query.append(" SELECT OFE.OID_OFER ");
            query.append(" FROM PRE_OFERT_DETAL DET, PRE_OFERT OFE ");
            query.append(" WHERE OFE.MFCA_OID_CABE = " + dto.getOidCabeceraMF() );
            query.append(" AND OFE.OID_OFER = DET.OFER_OID_OFER ");
            query.append(" AND DET.NUM_ORDE_DETA = " + dto.getNumeroOrden() );

            try {
                rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
            } catch (MareException me) {
                UtilidadesLog.error(me);            
                throw me;
            } catch (Exception e) {
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
            }

            if (!rSet.esVacio()) {
                UtilidadesLog.info("MONOfertaBean.comprobarNumeroOrden(DTOTextoOferta dto): Salida");
                return Boolean.valueOf(false);
            } else {
                UtilidadesLog.info("MONOfertaBean.comprobarNumeroOrden(DTOTextoOferta dto): Salida");
                return Boolean.valueOf(true);
            }
        }
    }

    /**
      // Recupera los codigos de venta de los productos asociados a una oferta
      SELECT VAL_CODI_VENT
      FROM PRE_OFERT_DETAL
      WHERE
      OFER_OID_OFER = oidOferta

      Crea un DTOSalida con el resultado y lo devuelve
      Si no se obtienen resultados devuelve null
    *
    *@autor jpbosnja
    **/
    public DTOSalida obtenerProductosOferta(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerProductosOferta(Long oidOferta): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" Select VAL_CODI_VENT from PRE_OFERT_DETAL ");
            query.append("where OFER_OID_OFER = " + oidOferta);

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            if (r.esVacio()) {
                return null;
            }

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerProductosOferta(Long oidOferta): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      // Obtiene el factor de cuadre de los grupos de una oferta, ordenados por número de grupo

      select COD_FACT_CUAD
      from PRE_GRUPO_OFERT
      where OFER_OID_OFER = DTOOID.oidOferta
      order by NUM_GRUP asc

      DTOSalida.resultado = Resultado de la consulta

      Devuelve DTOSalida
    *
    *@autor jpbosnja
    **/
    public DTOSalida obtenerFactorCuadreGrupos(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerFactorCuadreGrupos(DTOOID dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" select COD_FACT_CUAD from PRE_GRUPO_OFERT  ");
            query.append("where OFER_OID_OFER = " + dtoe.getOid());
            query.append(" order by NUM_GRUP asc");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerFactorCuadreGrupos(DTOOID dtoe): Salida");
            return dto;
            
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      // Obtiene todas las ofertas de tipo VS (Promocion) para la matriz de facturación correspondiente al periodo recibido

      SELECT
      OID_OFER OFERTA, VAL_COND_G1_CNDT G1, COES_OID_ESTR ESTRATEGIA, IND_DESP_AUTO DESPACHO_AUTOMATICO, NUM_PAQU NUMERO_PAQUETES,
      OID_PROM PROMOCION, NUM_COND NUMERO_CONDICION, ICPR_OID_INDI_CUAD_PROM IND_CUADRE, VAL_FACT_CUAD FACTOR_CUADRE,
      OID_RANG_PROM RANGO_PROMOCION, OCAT_OID_CATA CATALOGO, COD_TIPO_RANG TIPO_RANGO, NUM_RANG_INTE NUMERO_RANGO, IND_EXCL EXCLUIR, VAL_DESD DESDE, VAL_HAST HASTA


      FROM PRE_MATRI_FACTU_CABEC CM, PRE_OFERT O, PRE_PROMO P, PRE_RANGO_PROMO RP, PRE_ESTRA E, PRE_TIPO_ESTRA TE

      WHERE
      CM.PERD_OID_PERI = DTOOID.oid AND
      O.MFCA_OID_CABE = CM.OID_CABE AND
      TE.IND_ESTR_VS = 1 AND
      TE.OID_TIPO_ESTR = E.TIES_OID_TIPO_ESTR AND
      O.COES_OID_ESTR = E.OID_ESTR AND
      P.OFER_OID_OFER = O.OID_OFER AND
      RP.POMO_OID_PROM = P.OID_PROM

      ORDER BY
      OID_OFER, OID_PROM, CATALOGO, TIPO_RANGO

      Devuelve DTOSalida con el resultado
    *
    *@autor jpbosnja
    * pperanzola - 17/10/2005 - [1](CUV)se modifica por un error que habia nombres ambiguos en la query para el campo OCAT_OID_CATA
    **/
    public DTOSalida obtenerOfertasPromocion(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerOfertasPromocion(DTOOID dtoe): Entrada");
        Cronometrador.startTransaction("MONOfertaBean.obtenerOfertasPromocion");
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT OID_OFER OFERTA, VAL_COND_G1_CNDT G1, COES_OID_ESTR ESTRATEGIA, IND_DESP_AUTO DESPACHO_AUTOMATICO, NUM_PAQU NUMERO_PAQUETES, ");
            query.append(" OID_PROM PROMOCION, NUM_COND NUMERO_CONDICION, ICPR_OID_INDI_CUAD_PROM IND_CUADRE, VAL_FACT_CUAD FACTOR_CUADRE, ");
            query.append(" OID_RANG_PROM RANGO_PROMOCION, RP.OCAT_OID_CATA CATALOGO, COD_TIPO_RANG TIPO_RANGO, NUM_RANG_INTE NUMERO_RANGO, IND_EXCL EXCLUIR, VAL_DESD DESDE, VAL_HAST HASTA  "); //[1]
            query.append(" FROM PRE_MATRI_FACTU_CABEC CM, PRE_OFERT O, PRE_PROMO P, PRE_RANGO_PROMO RP, PRE_ESTRA E, PRE_TIPO_ESTRA TE ");

            query.append("where CM.PERD_OID_PERI = " + dtoe.getOid());
            query.append(" AND O.MFCA_OID_CABE = CM.OID_CABE AND TE.IND_ESTR_VS = 1 AND ");
            query.append(" TE.OID_TIPO_ESTR = E.TIES_OID_TIPO_ESTR AND  O.COES_OID_ESTR = E.OID_ESTR AND ");
            query.append(" P.OFER_OID_OFER = O.OID_OFER AND RP.POMO_OID_PROM = P.OID_PROM ");

            query.append(" ORDER BY OID_OFER, OID_PROM, CATALOGO, TIPO_RANGO ");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerOfertasPromocion(DTOOID dtoe): Salida");
            Cronometrador.endTransaction("MONOfertaBean.obtenerOfertasPromocion");
            return dto;
            
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      // Obtiene los productos asociados a una oferta

      SELECT VAL_CODI_VENT CODIGO_VENTA
      FROM PRE_OFERT_DETAL
      WHERE
      OFER_OID_OFER = DTOOID.oid AND
      IND_PROD_PRIN = 0

      Devuelve un DTOSalida con el resultado
    *
    *@autor jpbosnja
    **/
    public DTOSalida obtenerProductosAsociados(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerProductosAsociados(DTOOID dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT VAL_CODI_VENT CODIGO_VENTA FROM PRE_OFERT_DETAL  ");
            query.append("where OFER_OID_OFER = " + dtoe.getOid());
            query.append(" AND IND_PROD_PRIN = 0 ");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerProductosAsociados(DTOOID dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    /**
      // Obtiene el factor de cuadre de los grupos de una oferta, ordenados por número de grupo

      - OID_IND_CUAD (Se obtiene de la siguiente forma)
      (Accede a la tabla PRE_GRUPO_OFERT con OFER_OID_OFER == DTOOID.oid y obtiene CUES_OID_IND_CUAD_TIPO_ESTR)
      (Accede a la tabla PRE_INDIC_CUADR_TIPO_ESTRA con PRE_GRUPO_OFERT.CUES_OID_IND_CUAD_TIPO_ESTR y obtiene INDC_OID_INDI_CUAD)
      (Accede a la tabla PRE_INDIC_CUADR con PRE_INDIC_CUADR_TIPO_ESTRA.INDC_OID_INDI_CUAD y obtiene OID_IND_CUAD)

      DTOSalida.resultado = Resultado de la consulta

      Devuelve DTOSalida
    *
    *@autor jpbosnja
    **/
    public DTOSalida obtenerIndicadorCuadreGrupos(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerIndicadorCuadreGrupos(DTOOID dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" select OID_IND_CUAD from PRE_GRUPO_OFERT gofert, ").append(" PRE_INDIC_CUADR_TIPO_ESTRA i, PRE_INDIC_CUADR ic ");
            query.append("where gofert.OFER_OID_OFER = " + dtoe.getOid());
            query.append(" AND i.OID_IND_CUAD_TIPO_ESTR = gofert.CUES_OID_IND_CUAD_TIPO_ESTR ");
            query.append(" AND i.INDC_OID_INDI_CUAD = ic.OID_IND_CUAD ");
            query.append(" order by NUM_GRUP asc");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerIndicadorCuadreGrupos(DTOOID dtoe): Salida");
            return dto;
            
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    private String obtenerCodigoLineaProducto(Long oidLinea, Long oidPais) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerCodigoLineaProducto(Long oidLinea, Long oidPais): Entrada");
        
        String codigoError;
        RecordSet lin_prod;
        BelcorpService belcorpService;

        String codigo = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            StringBuffer query_aux = new StringBuffer();
            query_aux.append(" SELECT m.COD_LINE_PROD CODIGO ");
            query_aux.append(" FROM MAE_LINEA_PRODU m ");
            query_aux.append(" WHERE m.OID_LINE_PROD = " + oidLinea + " ");
            query_aux.append(" AND m.PAIS_OID_PAIS =  " + oidPais + " ");

            lin_prod = BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());

            if (!lin_prod.esVacio()) {
                if (lin_prod.getValueAt(0, "CODIGO") != null) {
                    codigo = new String(lin_prod.getValueAt(0, 0).toString());
                }
            }
        } catch (Exception e) {
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONOfertaBean.obtenerCodigoLineaProducto(Long oidLinea, Long oidPais): Salida");
        return codigo;
    }

    private Boolean buscarEstrategiasIndividuales() throws MareException {
        UtilidadesLog.info("MONOfertaBean.buscarEstrategiasIndividuales(): Entrada");
        
        String codigoError;
        RecordSet result;
        BelcorpService belcorpService;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            StringBuffer query_aux = new StringBuffer();

            query_aux.append(" select count(*) ");
            query_aux.append(" from PRE_ESTRA ES  ");
            query_aux.append(" where ES.TIES_OID_TIPO_ESTR = " + ConstantesPRE.INDIVIDUAL);

            result = BelcorpService.getInstance().dbService.executeStaticQuery(query_aux.toString());

            long cant = ((BigDecimal) result.getValueAt(0, 0)).longValue();
            //UtilidadesLog.debug("Estrategias Tipo Individual encontradas: " + cant);

            if (cant > 0) {
                UtilidadesLog.info("MONOfertaBean.buscarEstrategiasIndividuales(): Salida");
                return Boolean.FALSE;
            }
        } catch (Exception e) {
            UtilidadesLog.error(e);
            codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONOfertaBean.buscarEstrategiasIndividuales(): Salida");
        return Boolean.TRUE;
    }



    public Integer obtenerNumeroOferta(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerNumeroOferta(Long oidOferta): Entrada");
        
        StringBuffer query = new StringBuffer();
        Integer res = null;

        query.append("SELECT po.NUM_OFER NUMERO_OFERTA ");
        query.append("FROM PRE_OFERT po ");
        query.append("WHERE po.OID_OFER = " + oidOferta + " ");

        RecordSet rSet = new RecordSet();
        BelcorpService belcorpService = null;

        try {
            rSet = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        res = BigToInteger(rSet.getValueAt(0, "NUMERO_OFERTA"));
        
        UtilidadesLog.info("MONOfertaBean.obtenerNumeroOferta(Long oidOferta): Salida");
        return res;
    }

    /**
     *
     * @date 11/08/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param numeroGrupo
     * @param oidOferta
     * @author pperanzola
     * Accede a la tabla PRE_OFERT_DETAL y obtiene los productos perteneciente a la oferta y grupo recibido.
        Para filtrar por el numero de grupo debemos hacer JOIN con la tabla PRE_GRUPO_OFERT mediante el campo PRE_OFERT_DETAL.GOFE_OID_GRUP_OFER y filtrar por el campo PRE_GRUPO_OFERT.NUM_GRUP

        Para cada producto encontrado recupera:
        - VAL_CODI_VENT
        - NUM_POSI_RANK

        La consulta se recupera ordenada de menor a mayor por el campo NUM_POSI_RANK
     */
    public RecordSet obtenerProductosGrupo(Long oidOferta, Long numeroGrupo) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerProductosGrupo(Long oidOferta, Long numeroGrupo): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        

        query.append(" select ");
        query.append(" VAL_CODI_VENT, NUM_POSI_RANK ");
        query.append(" from ");
        query.append(" pre_ofert_detal pod , pre_grupo_ofert pgo ");
        query.append(" where ");
        query.append(" pod.ofer_oid_ofer = " + oidOferta);
        query.append(" and gofe_oid_grup_ofer = pgo.oid_grup_ofer ");
        query.append(" and pgo.num_grup = " + numeroGrupo);
        query.append(" order by NUM_POSI_RANK ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
       
        UtilidadesLog.info("MONOfertaBean.obtenerProductosGrupo(Long oidOferta, Long numeroGrupo): Salida");
        return rs;
    }

    /**
     * @author pperanzola
     * @date
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidOferta
     * Obtiene los grupos condicionados a los que pertenecen los productos de la oferta
     * ordenados de menor a mayor por la posicion de ranking
     *      SELECT   g.num_grup
            FROM pre_ofert_detal od, pre_grupo_ofert g
            WHERE od.ofer_oid_ofer = LONG oidOferta
            AND od.gofe_oid_grup_ofer = g.oid_grup_ofer
            AND g.ind_cndo = 1
            ORDER BY od.num_posi_rank ASC
     */
    public RecordSet obtenerGrupoCondicionadoMenorRanking(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerGrupoCondicionadoMenorRanking(Long oidOferta): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        

        query.append(" SELECT ");
        query.append(" g.num_grup ");
        query.append(" FROM ");
        query.append(" pre_ofert_detal od, pre_grupo_ofert g ");
        query.append(" WHERE ");
        query.append(" od.ofer_oid_ofer = " + oidOferta);
        query.append(" AND od.gofe_oid_grup_ofer = g.oid_grup_ofer ");
        query.append(" AND g.ind_cndo = 1 ");
        query.append(" ORDER BY od.num_posi_rank ASC ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        UtilidadesLog.info("MONOfertaBean.obtenerGrupoCondicionadoMenorRanking(Long oidOferta): Salida");
        return rs;
    }

    /**
     *
     * @date
     * @throws es.indra.mare.common.exception.MareException
     * @return
     * @param oidOferta
     * @author pperanzola
     * Obtiene los grupos condicionados a los que pertenecen los productos
     * de la oferta ordenados de mayor a menor por la posicion de ranking
            SELECT   g.num_grup
            FROM pre_ofert_detal od, pre_grupo_ofert g
            WHERE od.ofer_oid_ofer = 1868
            AND od.gofe_oid_grup_ofer = g.oid_grup_ofer
            AND g.ind_cndo = 1
            ORDER BY od.num_posi_rank DESC
     */
    public RecordSet obtenerGrupoCondicionadoMayorRanking(Long oidOferta) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerGrupoCondicionadoMayorRanking(Long oidOferta): Entrada");
        
        BelcorpService belcorpService = null;
        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        

        query.append(" SELECT ");
        query.append(" g.num_grup ");
        query.append(" FROM ");
        query.append(" pre_ofert_detal od, pre_grupo_ofert g ");
        query.append(" WHERE ");
        query.append(" od.ofer_oid_ofer = " + oidOferta);
        query.append(" AND od.gofe_oid_grup_ofer = g.oid_grup_ofer ");
        query.append(" AND g.ind_cndo = 1 ");
        query.append(" ORDER BY od.num_posi_rank DESC ");

        try {
            rs = belcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            UtilidadesLog.error(me);
            throw me;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        UtilidadesLog.info("MONOfertaBean.obtenerGrupoCondicionadoMayorRanking(Long oidOferta): Salida");
        return rs;
    }

 /**
   * @Autor: Emilio Noziglia
   * @Fecha : 07/09/2005
   * @Recibe: Long oidCabecera
   * @Retorna: String con el codigo de venta 
   * @Descripción: obtiene el mayor codigo unico de venta generado para la matriz
   *               de facturacion indicada por parametro.
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   * pperanzola - 19/10/2005 - [1] se modifica porque el campo VAL_CODI_VENT es string y sino la funcion 
   *                               max no trae los valores correctamente
   */ 
   public String obtenerUltimoCodigoVenta(Long oidCabecera) throws MareException {
      UtilidadesLog.info("MONOfertaBean.obtenerUltimoCodigoVenta(Long oidOferta): Entrada");
      
      UtilidadesLog.debug("Datos Entrada: oidCabecera:"+oidCabecera);

      String CUV = null;
 
      BelcorpService belcorpService = BelcorpService.getInstance();

      RecordSet rs = null;
      StringBuffer query = new StringBuffer();

      query.append(" select max(to_number(od.VAL_CODI_VENT)) ");// [1] 
      query.append(" from pre_ofert_detal od, ");
           query.append(" pre_ofert o ");
      query.append(" where od.OFER_OID_OFER = o.OID_OFER ");
      //query.append(" and o.IND_CODI_VENT_GENE = 1 "); INC. SICC 20070032 sino no trae el ultimo CV
      query.append(" and od.IND_CODI_VENT_GENE = 1 ");
      query.append(" and o.MFCA_OID_CABE = "+oidCabecera+" ");
    
      try {
        rs = belcorpService.dbService.executeStaticQuery(query.toString());
      } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            
            UtilidadesLog.error(serviceNotFoundException);
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (Exception exception) {
            
            UtilidadesLog.error(exception);
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
      }

      if ((rs!=null)&&(!rs.esVacio())&&(rs.getValueAt(0,0)!=null)&&(!rs.getValueAt(0,0).equals(""))) {//BELC300021070
         CUV = ((BigDecimal)rs.getValueAt(0,0)).toString();//BELC300021285
      } else {
         //UtilidadesLog.debug("No hay ultimo codigo de venta o es null entonces asigno 0.");
         CUV = new String("0");
      }      
      UtilidadesLog.debug("Datos Salida: CUV:"+CUV);
      
      UtilidadesLog.info("MONOfertaBean.obtenerUltimoCodigoVenta(Long oidOferta): Salida");
      return CUV;
   }

   /**
    * @Autor: Emilio Noziglia
    * @Fecha : 07/09/2005
    * @Recibe: String CUV
    * @Retorna: String 
    * @Descripción: devuelve el CUV incrementado en 1 en formato String
    * @Referencia: Mejora SICC-DMCO-PRE-201-354-P0012-CUV
    */ 
    private String obtenerSiguienteCUV(String CUV) throws MareException {
        UtilidadesLog.info("MONOfertaBean.obtenerSiguienteCUV(String CUV): Entrada");
        
        UtilidadesLog.debug("Datos Entrada: CUV"+CUV);
        long lCUV = 0;
        try {
          lCUV = Long.valueOf(CUV).longValue();
          lCUV++;
          CUV = String.valueOf(lCUV);
        } catch (NumberFormatException ne) {
          UtilidadesLog.debug("El CUV recibido no es numerico.");
        }
        UtilidadesLog.debug("Datos Salida: CUV"+CUV);
        
        UtilidadesLog.info("MONOfertaBean.obtenerSiguienteCUV(String CUV): Salida");
        return String.valueOf(lCUV);
    }   

  /**
   * @Autor: Emilio Noziglia
   * @Fecha : 07/09/2005
   * @Recibe: String CUV, DetalleOfertaLocal detalleOferta
   * @Retorna: void 
   * @Descripción: metodo que asigna el codigo unico de venta recibido como parametro
   *               a la entidad DetalleOfertaLocal tambien recibida en caso que no supere
   *               la cte MAXIMO_CUV_ADICIONAL (1000000).
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   */ 
   public void asignarAdicional(String CUV, DetalleOfertaLocal detalleOferta, OfertaLocal oferta) throws MareException {
      UtilidadesLog.info("MONOfertaBean.asignarAdicional(String CUV, DetalleOfertaLocal detalleOferta, OfertaLocal oferta): Entrada");
      
      
      
      if (ConstantesPRE.MAXIMO_CUV_ADICIONAL.compareTo(Long.valueOf(CUV))>0){
          detalleOferta.setCodigoVenta(CUV);
          detalleOferta.setCodigoVentaGenerado(Boolean.TRUE);
          oferta.setCodigoVentaGenerado(Boolean.TRUE);
      } else {
          UtilidadesLog.debug("No se asigno el CUV:"+CUV+" a la entidad:"+
                detalleOferta.getOid()+" de la oferta:"+oferta.getOid()+
                " por superar el MAXIMO_CUV_ADICIONAL:"+
                ConstantesPRE.MAXIMO_CUV_ADICIONAL);
      }
      
      UtilidadesLog.info("MONOfertaBean.asignarAdicional(String CUV, DetalleOfertaLocal detalleOferta, OfertaLocal oferta): Salida");
   }

   /**
    * @Autor: Emilio Noziglia
    * @Fecha : 07/09/2005
    * @Recibe: String CUV, Long oidCabecera
    * @Retorna: boolean 
    * @Descripción: Obtiene el detalle de oferta correspondiente a la cabecera y 
    *               codigo de venta recibidos como parámetro, Se devuelve un 
    *               indicador si existe el CUV ya asignado.
    * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
    */ 
    public boolean existeOtroProductoAsignado(String CUV, Long oidCabecera) throws MareException {
        UtilidadesLog.info("MONOfertaBean.existeOtroProductoAsignado(String CUV, Long oidCabecera): Entrada");
        
        //UtilidadesLog.debug("Datos Entrada: CUV:"+CUV+" oidCabecera:"+oidCabecera);
        boolean resultado = false;

        BelcorpService belcorpService = BelcorpService.getInstance();

        RecordSet rs = null;
        StringBuffer query = new StringBuffer();

        query.append(" select count(*) from PRE_OFERT p, PRE_OFERT_DETAL d ");
        query.append(" where p.MFCA_OID_CABE = "+oidCabecera+" ");
        query.append(" and p.OID_OFER = d.OFER_OID_OFER ");
        query.append(" and d.VAL_CODI_VENT = '"+CUV+"' "); 
      
        try {
          rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()||Long.valueOf("0").equals(BigToLong(rs.getValueAt(0,0)))) {
           resultado = false;
        } else if(Long.valueOf("1").equals(BigToLong(rs.getValueAt(0,0)))) {
           resultado = true;
        } else {
           
           resultado = true;
        }
        UtilidadesLog.info("Datos Salida: resultado:"+resultado); 
        
        UtilidadesLog.info("MONOfertaBean.existeOtroProductoAsignado(String CUV, Long oidCabecera): Salida");
        return resultado;
    }
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param oidDetalleOferta
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     * Se elimina en la Entidad Detalle de oferta segun el oidDetalleOferta recibido y las entradas en las tablas relacionadas que corresponda
     * pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    private void eliminarDatosDetalleOferta(Long oidDetalleOferta)throws MareException {
        UtilidadesLog.info("MONOfertaBean.eliminarDatosDetalleOferta (Long oidDetalleOferta):Entrada");
        MatrizFacturacionLocal mFactura = null;
        DetalleOfertaLocal detaOfer = null;
                
        boolean encontroMF = true;//para saber si se encontro matriz de facturacion o no
        Vector cFacturas = new Vector();
        Iterator itFacturas = null;
        MatrizFacturacionLocalHome mflh = new MatrizFacturacionLocalHome();
        try{
            UtilidadesLog.debug("oidDetalleOferta A BORRAR  =" +oidDetalleOferta);
            //obtiene la matriz de facturacion asociada al detalle
            mFactura = mflh.findByOidDetaOfer(oidDetalleOferta); 
        } catch(NoResultException ex) {            
            encontroMF = false;
        }
        if (encontroMF) {
            try{
                cFacturas.add(mFactura);
                //intenta borrar la matriz de facturacion asociada al detalle
                borrarMatricesAltRecupReemp(cFacturas);
            }catch (MareException ex){
                throw ex;
            }
            itFacturas = cFacturas.iterator();
            while (itFacturas.hasNext()){
                try {
                    mflh.remove((MatrizFacturacionLocal) itFacturas.next());
                } catch(PersistenceException ex) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(ex);
                    throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }
        try{
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            detaOfer = dolh.findByPrimaryKey(oidDetalleOferta);
            /*inicio agregado enozigli COL-PRE-002*/
            DetalleOfertaPrecioLocalHome doplh = new DetalleOfertaPrecioLocalHome();
            Collection colDetaOferPrec = doplh.findByOidDetalle(oidDetalleOferta);
            if (!colDetaOferPrec.isEmpty()) {
                Iterator rangosPrecios = colDetaOferPrec.iterator();
                while (rangosPrecios.hasNext()) {
                    DetalleOfertaPrecioLocal detaOferPrec = (DetalleOfertaPrecioLocal)rangosPrecios.next();
                    doplh.remove(detaOferPrec);
                }
            }
            /*fin agregado enozigli COL-PRE-002*/
            dolh.remove(detaOfer);
        } catch(NoResultException fe) {
            //No tenia, continua.
            //UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        
        UtilidadesLog.info("MONOfertaBean.eliminarDatosDetalleOferta (Long oidDetalleOferta):Salida");

    }
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param datosPromocion
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     *  pperanzola - 30/09/2005 - se modifica según incidencia BELC300021090 ( se eliminan primero los rangos y despues las promocines)
     *  pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    private void eliminarDatosPromocion(Vector datosPromocion) throws MareException{
        UtilidadesLog.info("MONOfertaBean.eliminarDatosPromocion (Vector datosPromocion):Entrada");        
        DTOPromocion dtoPromo = null;//dto auxiliar para cada promocion dentro de datosPromocion
        int cantDatosPromo = 0;//contador del tamaño del vecotr datosPromocion
        if (datosPromocion!= null){
            cantDatosPromo = datosPromocion.size();
        }
        int i;
        PromocionLocal promocion = null;//auxiliar para obtener la promocion

        try {
            
            //obtengo cada uno a de las promociones dentro del vector datosPromocion
            for (i=0 ; i< cantDatosPromo ;i++ ) {
                dtoPromo = (DTOPromocion) datosPromocion.get(i);
                eliminarDatosRangoPromocion(dtoPromo.getOidPromocion());
                try{
                    PromocionLocalHome plh = new PromocionLocalHome();
                    promocion = plh.findByPrimaryKey(dtoPromo.getOidPromocion());                    
                    plh.remove(promocion);
                }catch (NoResultException fex){
                    UtilidadesLog.debug("no hay promocion asociada ");
                    //UtilidadesLog.error(fex);
                    //throw new MareException(fex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException rex) {
                    UtilidadesLog.error(rex);
                    ctx.setRollbackOnly();
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        }catch (MareException ex){
            ctx.setRollbackOnly();
            UtilidadesLog.error(ex);
            throw ex;
        }

        UtilidadesLog.info("MONOfertaBean.eliminarDatosPromocion (Vector datosPromocion):Salida");
    }
    
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param oidPromocion
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     * pperanzola - 21/10/2005 - [1] se modifica para que no haya excepciones por valores nulos en los tipoOperacion
     * pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    private void eliminarDatosRangoPromocion(Long oidPromocion) throws MareException{
        UtilidadesLog.info("MONOfertaBean.eliminarDatosRangoPromocion (Long oidPromocion):Entrada");
        RangosPromocionLocal rangoPromo = null;
        Collection colRango = null;
        Iterator iterRango = null;        
            
        try {
            RangosPromocionLocalHome rplh = new RangosPromocionLocalHome();
            colRango  = rplh.findByOidPromo(oidPromocion);
            iterRango = colRango.iterator();
            while(iterRango.hasNext()){
                rangoPromo = (RangosPromocionLocal)iterRango.next();                
                rplh.remove(rangoPromo);
            }                        
        } catch(NoResultException fe) {
            UtilidadesLog.debug("no se encontro ningun rango promocion");
            //UtilidadesLog.error(fe);
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch(PersistenceException re) {
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
           
        UtilidadesLog.info("MONOfertaBean.eliminarDatosRangoPromocion (Long oidPromocion):Salida");
        
    }
    
   /**
     * @author pperanzola 
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param ventaExclusiva
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     *  pperanzola - 26/10/2005 - se modifica segun incidencia BELC300021295 por peer review
     */
    private void eliminarDatosVentaExclusiva (Vector ventaExclusiva) throws MareException {
        UtilidadesLog.info("MONOfertaBean.eliminarDatosVentaExclusiva (Vector ventaExclusiva):Entrada");
        DTOVentaExclusiva dtoVtaEx = null; //auxiliar para inicializar con c/u de los DTO del vector parámetro
        int cantVtasEx = 0; //auxiliar para almacenar el tamaño del vector ventaExclusiva
        if (ventaExclusiva!=null){
            cantVtasEx = ventaExclusiva.size();
        }
        int i;
        VentaExclusivaLocal vtaExclusivaLocal = null;
        try {
            //UtilidadesLog.debug("cantVtasEx  = " + cantVtasEx);
            for (i = 0; i < cantVtasEx; i++ ){
                dtoVtaEx = (DTOVentaExclusiva) ventaExclusiva.get(i);
                VentaExclusivaLocalHome velh = new VentaExclusivaLocalHome();
                vtaExclusivaLocal = velh.findByPrimaryKey(dtoVtaEx.getOidVentaExclusiva());
                //UtilidadesLog.debug("remover vtaExclusivaLocal=" + vtaExclusivaLocal.getOid());
                velh.remove(vtaExclusivaLocal);
            }
        } catch (NoResultException fe) {
            UtilidadesLog.debug("no encontro venta exclusiva oid=" + dtoVtaEx.getOidVentaExclusiva());
            //UtilidadesLog.error(fe);
            //ctx.setRollbackOnly();
            //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, 
                                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
        UtilidadesLog.info("MONOfertaBean.eliminarDatosVentaExclusiva (Vector ventaExclusiva):Salida");
        
    }
    /**
     * @author enozigli
     * @date 06/06/06
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoDetalle
     * @param oidOferta
     * @param proxNumLine
     */    
    private void insertarDatosDetalle(int numDeci, Long oidOferta, DTODetalleOferta dtoDetalle, int proxNumLine) throws MareException {
      dtoDetalle.setLineaOferta(new Integer(proxNumLine));
      insertarDatosDetalle(numDeci, oidOferta, dtoDetalle);
    }
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoDetalle
     * @param oidOferta
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     * 05/10/2005 - pperanzola : [1] se modifica según incidencia BELC300021148 (Club Privilege)
     * pperanzola - 21/10/2005 - [2] se modifica para que no haya excepciones por valores nulos en los tipoOperacion
     * pperanzola - 26/10/2005 - [3] se modifica segun incidencia BELC300021295 por peer review
     * gdmarzi - 24/04/2007 - se recalcula el precio unitario al modificar un detalle de oferta, incidencia 20070226.
     * 
     */
    private void insertarDatosDetalle(int numDecim, Long oidOferta, DTODetalleOferta dtoDetalle) throws MareException {
        UtilidadesLog.info("MONOfertaBean.insertarDatosDetalle (Long oidOferta, DTODetalleOferta dtoDetalle):Entrada");
        /*Si (DTODetalleOferta.oidDetalle == null y DTODetalleOferta.tipoOperacion != "baja") { 
        Se añade una entrada a la entidad DetalleOferta  */
        DetalleOfertaLocal detaOferLoca = null;
        
        if (dtoDetalle.getOidDetalleOferta() == null 
                && !ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(
                                                        dtoDetalle.getTipoOperacion())){//[2]
            //UtilidadesLog.debug("entre por if true");
            
            try{      
            UtilidadesLog.info("MAD El oid Proig fide " + dtoDetalle.getProgramaFidelizacion());
            DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
            detaOferLoca = dolh.create(oidOferta //Long ofer_oid_ofer,
                                                                       , dtoDetalle.getOidSAP()    //Long prod_oid_prod, 
                                                                       , dtoDetalle.getLineaOferta()     //Integer num_line_ofer,
                                                                       ,dtoDetalle.getFactorRepeticion()//Integer val_fact_repe, 
                                                                       ,dtoDetalle.getOidTipoOferta()  //Long tofe_oid_tipo_ofer, 
                                                                       ,dtoDetalle.getOidCicloVida()   //Long civi_oid_ciclo_vida , 
                                                                       ,dtoDetalle.getOidGrupo());           //Long oid_grup_ofert 
            
            actualizarDatosDetalleOferta( detaOferLoca,  dtoDetalle, oidOferta); //[3]
            
            
            // Agregado por SiCC 20070326 - Rafael Romero - 11/07/2007
            // Calculo de precio unitario
             UtilidadesLog.debug("Calculo Precio unit.");            
            if(dtoDetalle.getFactorRepeticion()!=null && dtoDetalle.getFactorRepeticion().intValue()!=0){
                BigDecimal precioUnitario = new BigDecimal(0);
                if(dtoDetalle.getPrecioCatalogo()!=null){
                    precioUnitario = dtoDetalle.getPrecioCatalogo().divide(new BigDecimal(dtoDetalle.getFactorRepeticion().intValue()),numDecim,BigDecimal.ROUND_FLOOR);
                }
                UtilidadesLog.debug("--> Precio unit.= "+precioUnitario);
                detaOferLoca.setPrecioUnitario(precioUnitario);
            }
            // Fin agregado SiCC 20070236   
            
             dolh.merge(detaOferLoca);
            
            /*inicio agregado enozigli COL-PRE-002*/
            Vector rangosPrecios = dtoDetalle.getRangosPrecios();
            
            if (rangosPrecios!=null &&
                !rangosPrecios.isEmpty()) {
                Enumeration enRangosPrecios = rangosPrecios.elements();
                while (enRangosPrecios.hasMoreElements()) {
                      DTORangoPrecios dtoRangoPrecios = (DTORangoPrecios)enRangosPrecios.nextElement();
                      DetalleOfertaPrecioLocalHome detaOferPrecioLocaHome = new DetalleOfertaPrecioLocalHome();
                      Long numOrdeRang = new Long(dtoRangoPrecios.getNumeroOrdenRango().longValue());
                      Long numUnidDesd = dtoRangoPrecios.getRangoDesde();
                      Long numUnidHast = dtoRangoPrecios.getRangoHasta();
                      BigDecimal valPrecCata = dtoRangoPrecios.getPrecioCatalogo();
                      BigDecimal valPrecPosi = dtoRangoPrecios.getPrecioPosicionamiento();
                      Long ofdeOidDetaOfer = detaOferLoca.getOid();
                      detaOferPrecioLocaHome.create(numOrdeRang,  numUnidDesd,  numUnidHast,  valPrecCata,  valPrecPosi,  ofdeOidDetaOfer);
                     
                }
            }
            /*fin agregado enozigli COL-PRE-002*/
            
            //UtilidadesLog.debug("termino el seteado del detalle ");
            } catch(PersistenceException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
            }
        }else if (ConstantesPRE.OPERACION_MODIFICACION.equalsIgnoreCase(dtoDetalle.getTipoOperacion())){//[2]
            //UtilidadesLog.debug("entre por if false");
            try{
                DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
                detaOferLoca = dolh.findByPrimaryKey(dtoDetalle.getOidDetalleOferta());
                detaOferLoca.setOidOfer(oidOferta);
                detaOferLoca.setOidProd(dtoDetalle.getOidSAP());
                UtilidadesLog.debug("pperez  - Linea anterior: " + detaOferLoca.getLineaOferta());
                UtilidadesLog.debug("pperez  - Linea actualizada: " + dtoDetalle.getLineaOferta());
                detaOferLoca.setLineaOferta(dtoDetalle.getLineaOferta());
                detaOferLoca.setFactorRepeticion(dtoDetalle.getFactorRepeticion());
                detaOferLoca.setOidTipoOfer(dtoDetalle.getOidTipoOferta());
                detaOferLoca.setOidCicloVida(dtoDetalle.getOidCicloVida());
                detaOferLoca.setOidGrupOfer(dtoDetalle.getOidGrupo());

                actualizarDatosDetalleOferta(detaOferLoca, dtoDetalle,  oidOferta);//[3]
                
                
                /*inicio agregado enozigli COL-PRE-002*/
                DetalleOfertaPrecioLocalHome doplh = new DetalleOfertaPrecioLocalHome();
                
                Collection colRangosPrecios = doplh.findByOidDetalle(detaOferLoca.getOid());
                if (!colRangosPrecios.isEmpty()) {
                    Iterator rangosPrecios = colRangosPrecios.iterator();
                    while (rangosPrecios.hasNext()) {
                        DetalleOfertaPrecioLocal rango = (DetalleOfertaPrecioLocal)rangosPrecios.next();
                        doplh.remove(rango);
                    }
                }
                
                Vector vRangosPrecios = dtoDetalle.getRangosPrecios();
                
                if (vRangosPrecios!=null&&!vRangosPrecios.isEmpty()) {
                    Iterator rangosPrecios = vRangosPrecios.iterator();
                    while (rangosPrecios.hasNext()) {
                        DTORangoPrecios dtoRango = (DTORangoPrecios)rangosPrecios.next();
                        Long nroOrdenRango = new Long(dtoRango.getNumeroOrdenRango().longValue());
                        doplh.create(nroOrdenRango,dtoRango.getRangoDesde(),
                            dtoRango.getRangoHasta(),dtoRango.getPrecioCatalogo(),dtoRango.getPrecioPosicionamiento(),detaOferLoca.getOid());                        
                    }                  
                }
                
                /*fin agregado enozigli COL-PRE-002*/
                
                // Modificado por SiCC 20070326 - Rafael Romero - 11/07/2007
                // Calculo de precio unitario
                // detaOferLoca.setPrecioUnitario(this.recalcularPrecioUnitario(dtoDetalle));
                UtilidadesLog.debug("Calculo Precio unit. Modif.");
                if(dtoDetalle.getFactorRepeticion()!=null && dtoDetalle.getFactorRepeticion().intValue()!=0){
                    BigDecimal precioUnitario = new BigDecimal(0);
                    if(dtoDetalle.getPrecioCatalogo()!=null){
                        precioUnitario = dtoDetalle.getPrecioCatalogo().divide(new BigDecimal(dtoDetalle.getFactorRepeticion().intValue()),numDecim,BigDecimal.ROUND_FLOOR);
                    }
                    UtilidadesLog.debug("--> Precio unit. Modif.= "+precioUnitario);
                    detaOferLoca.setPrecioUnitario(precioUnitario);
                }
                // Fin agregado SiCC 20070236            
                
                dolh.merge(detaOferLoca);

                //UtilidadesLog.debug("termino seteo");
            } catch(NoResultException fe) {
                UtilidadesLog.debug("no se encontro el detalle");
                //UtilidadesLog.error(fe);
                //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch(PersistenceException ce) {
                UtilidadesLog.debug("no se pudo actualizar el rango de precios");
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));                
            }
        }
        UtilidadesLog.info("MONOfertaBean.insertarDatosDetalle (Long oidOferta, DTODetalleOferta dtoDetalle):Salida");

    
    }
    /**
     * @author pperanzola
     * @date 26/10/2005
     * @param oidOferta
     * @param dtoDetalle
     * @param detaOferLoca
     * pperanzola - 26/10/2005 - se crea segun incidencia BELC300021295 por peer review
     */
    private void actualizarDatosDetalleOferta(DetalleOfertaLocal detaOferLoca
                                              , DTODetalleOferta dtoDetalle
                                              , Long oidOferta){
                                              
            detaOferLoca.setProductoPrincipal(dtoDetalle.getProductoPrincipal());
            detaOferLoca.setTextoBreve(dtoDetalle.getDescripcion());
            detaOferLoca.setUnidadesEstimadas(dtoDetalle.getUnidadesEstimadas());
            detaOferLoca.setOrigen(dtoDetalle.getOrigen());
            detaOferLoca.setImpresionGP(dtoDetalle.getImpresionGP());
            detaOferLoca.setDigitable(dtoDetalle.getDigitable());
            detaOferLoca.setPosicionRanking(dtoDetalle.getPosicionRanking());
            detaOferLoca.setOidFormPago(dtoDetalle.getOidFormaPago());
            detaOferLoca.setPrecioCatalogo(dtoDetalle.getPrecioCatalogo());
            
            detaOferLoca.setPrecioPosicionamiento(dtoDetalle.getPrecioPosicionamiento());
            detaOferLoca.setCosteEstandar(dtoDetalle.getCosteEstandar());
            detaOferLoca.setVentaNetaEstimada(dtoDetalle.getVentaNetaEstimada());
            detaOferLoca.setOidCatal(dtoDetalle.getOidCatalogo());
            
            /* cambio enozigli 21/02/2007
              El cambio surge porque no secuencia ofertas en caso de que el precio de catalogo o
              la posicion de pagina vengan a null por lo que segun lo hablado con Emilio Portocarrero
              se ponia por defecto la pagina a 0 y la posicion a 1 en ese caso.
            */
            if (dtoDetalle.getPaginaCatalogo()!=null){
                detaOferLoca.setNumeroPaginaCatalogo(dtoDetalle.getPaginaCatalogo());
            } else {
                 detaOferLoca.setNumeroPaginaCatalogo(new Integer(0));
            }
            if (dtoDetalle.getPosicionPagina()!=null) {
                detaOferLoca.setPosicionPagina(dtoDetalle.getPosicionPagina());
            } else {
                detaOferLoca.setPosicionPagina(new Integer(1));
            }
            //fin cambio enozigli 21/02/2007
            
            detaOferLoca.setOidCondProm(dtoDetalle.getOidCondicionPromocion());
            detaOferLoca.setCodigoVentaGenerado(dtoDetalle.getCodigoVentaGenerado());
            detaOferLoca.setCentro(dtoDetalle.getCentro());
            //cambio enozigli 06/03/2006 inc. 22718 
            detaOferLoca.setMatrizGenerada(dtoDetalle.getMatrizFacturacionGenerada());
            //fin cambio enozigli 06/03/2006 inc. 22718 
            if (Boolean.TRUE.equals(dtoDetalle.getCodigoVentaGenerado())){
                //UtilidadesLog.debug("CodigoVentaGenerado true");
                detaOferLoca.setCodigoVenta(dtoDetalle.getCodigoVenta());
            }else {
                //UtilidadesLog.debug("CodigoVentaGenerado false");
                detaOferLoca.setCodigoVenta(null);
            }
                      
            UtilidadesLog.info("MAD Prog Fide " + dtoDetalle.getProgramaFidelizacion() );
            detaOferLoca.setProgramaFidelizacion(dtoDetalle.getProgramaFidelizacion());
            detaOferLoca.setVariante(dtoDetalle.getVariantes());
            detaOferLoca.setPuntajeFijo(dtoDetalle.getPuntajeFijo());
            //se hace el merge en el metodo llamador.
    }
    
    
    /**
     * Recalcula el precio unitario al modificar un detalle oferta.
     * precio unitario = precio catalogo / factor repeticion. Incidencia 20070226.
     * @autor gdmarzi
     */
    private BigDecimal recalcularPrecioUnitario(DTODetalleOferta dtoDetalle) throws MareException {
        UtilidadesLog.info("MONOfertaBean.recalcularPrecioUnitario():Entrada");
        BigDecimal precioUnitario = null;
        try {
            //verifica que el detalle oferta este en la matriz de facturacion.
            MatrizFacturacionLocalHome mflh =  new MatrizFacturacionLocalHome();
            mflh.findByOidDetaOfer(dtoDetalle.getOidDetalleOferta()); 

            if (dtoDetalle.getPrecioCatalogo() != null && dtoDetalle.getFactorRepeticion()!=null){
                if (dtoDetalle.getFactorRepeticion().intValue() != 0) {
                    BigDecimal divis = new BigDecimal(dtoDetalle.getFactorRepeticion().intValue());
                    precioUnitario = dtoDetalle.getPrecioCatalogo().divide(divis,2,BigDecimal.ROUND_UP);
                } else {
                    precioUnitario = dtoDetalle.getPrecioCatalogo();
                }
            }

        } catch(NoResultException ex) {
            ///si el detalle oferta NO esta en la matriz de facturacion no se recalcula el precio unitario.
            UtilidadesLog.debug("El detalle oferta" + dtoDetalle.getOidDetalleOferta() + " NO esta en la matriz de facturacion.");
            precioUnitario = null;
        }
        UtilidadesLog.info("MONOfertaBean.recalcularPrecioUnitario():Salida");
        return precioUnitario;
    }
    
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     * Descripción: guarda los datos correspondientes a los grupos. 
     * 
     * [1] - pperanzola - 30/09/2005  - se modifica según incidencia BELC300021090
     * [2] - pperanzola - 04/10/2005  - se modifica según incidencia BELC300021154
     * [3] - pperanzola - 26/10/2005  - se modifica segun incidencia BELC300021295 por peer review
     * [4] - pperanzola - 31/10/2005  - se modifica segun incidencia BELC300021539
     */
    private DTOOferta actualizarDatosGrupo(DTOOferta dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.actualizarDatosGrupo (DTOOferta dto):Entrada");
        Vector vDtoGrupo = dto.getGrupo();
        DTOGrupo dtoGrupo = null; //contiene los dtoGrupo que se contengan en dto
        GrupoLocal eGrupo = null;//auxiliar para obtener la entidad grupo
        int i;
        int cantGrupos = 0;
        if (vDtoGrupo != null){
            cantGrupos = vDtoGrupo.size();
        }
        int j;
        int cantDetaOfer;
        Vector vDtoDetaOfer = null;
        DTODetalleOferta dtoDetaOfer = null;
        GrupoLocalHome glh = new GrupoLocalHome();
        
        for (i = 0; i<cantGrupos; i++){
            dtoGrupo = (DTOGrupo) vDtoGrupo.get(i);
            if (dtoGrupo.getOidGrupo()== null && 
                !ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoGrupo.getTipoOperacion())){
                try{                    
                    eGrupo = glh.create(dto.getOidOferta()
                                                            ,dtoGrupo.getNumeroGrupo()
                                                            ,dtoGrupo.getIndicadorGrupo());
                    
                    //SCS-EAN eGrupo.setFactorCuadre(dtoGrupo.getFactorCuadre()!=null?Long.valueOf(dtoGrupo.getFactorCuadre().toString()):null);
                    
                    eGrupo.setFactorCuadre(dtoGrupo.getFactorCuadre()!=null?dtoGrupo.getFactorCuadre():null);
                    eGrupo.setCondicionante(dtoGrupo.getCondicionante());
                    eGrupo.setCondicionado(dtoGrupo.getCondicionado());
                    eGrupo.setOidIndCuadTipoEstr(dtoGrupo.getOidIndicadorCuadre());
                    glh.merge(eGrupo);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();
                    throw new MareException(ce, 
                                            UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
                }
                vDtoDetaOfer = dto.getDetalleOferta();
                cantDetaOfer = 0;
                // esto lo hago por si el vector viene como null, si no fue creado en la parte cliente
                if (vDtoDetaOfer!= null){
                    cantDetaOfer = vDtoDetaOfer.size();
                }
                //UtilidadesLog.debug("cantDetaOfer = " + cantDetaOfer);
                //UtilidadesLog.debug("Numero de grupo = " + dtoGrupo.getNumeroGrupo().intValue());
                for (j = 0 ; j< cantDetaOfer; j++){
                    dtoDetaOfer = (DTODetalleOferta) vDtoDetaOfer.get(j);
                    //asignarle el oidGrupo que le corresponda (DTODetalleOferta.numeroGrupo == DTOGrupo.numeroGrupo) 
                    if (dtoDetaOfer.getNumeroGrupo().intValue() == dtoGrupo.getNumeroGrupo().intValue()){
                            dtoDetaOfer.setOidGrupo(eGrupo.getOid());
                    }
                } // cierra for
            } else if (ConstantesPRE.OPERACION_MODIFICACION.equalsIgnoreCase(dtoGrupo.getTipoOperacion()) ){
                    // modificacion de grupo
                    //UtilidadesLog.debug("entre por modificacion de grupos");
                    try{
                        eGrupo = glh.findByPrimaryKey(dtoGrupo.getOidGrupo());
                       
                        eGrupo.setOidOferta(dto.getOidOferta());
                        eGrupo.setNumeroGrupo(dtoGrupo.getNumeroGrupo());
                        eGrupo.setIndicadorGrupo(dtoGrupo.getIndicadorGrupo());
                        if (dtoGrupo.getFactorCuadre() != null) {
                          //SCS-EAN eGrupo.setFactorCuadre(new Long (dtoGrupo.getFactorCuadre().longValue()));
                          eGrupo.setFactorCuadre(dtoGrupo.getFactorCuadre());
                        }
                        eGrupo.setCondicionante(dtoGrupo.getCondicionante());
                        eGrupo.setCondicionado(dtoGrupo.getCondicionado());
                        eGrupo.setOidIndCuadTipoEstr(dtoGrupo.getOidIndicadorCuadre());
                        glh.merge(eGrupo);
                        //UtilidadesLog.debug("eGrupo encontrado y seteado");
                        ///*[4]
                        vDtoDetaOfer = dto.getDetalleOferta();
                        cantDetaOfer = 0;
                        // esto lo hago por si el vector viene como null, si no fue creado en la parte cliente
                        if (vDtoDetaOfer!= null){
                            cantDetaOfer = vDtoDetaOfer.size();
                        }
                        //UtilidadesLog.debug("cantDetaOfer = " + cantDetaOfer);
                        //UtilidadesLog.debug("Numero de grupo = " + dtoGrupo.getNumeroGrupo().intValue());
                        for (j = 0 ; j< cantDetaOfer; j++){
                            dtoDetaOfer = (DTODetalleOferta) vDtoDetaOfer.get(j);
                            //asignarle el oidGrupo que le corresponda (DTODetalleOferta.numeroGrupo == DTOGrupo.numeroGrupo) 
                            if (dtoDetaOfer.getNumeroGrupo().intValue() == dtoGrupo.getNumeroGrupo().intValue()){
                                    dtoDetaOfer.setOidGrupo(eGrupo.getOid());
                            }
                        } // cierra for 
                        //*/[4]
                    } catch (NoResultException fe ) {
                        UtilidadesLog.debug("no se encontro el grupo");
                    } catch (PersistenceException re) {
                        UtilidadesLog.error(re);
                        ctx.setRollbackOnly();
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
            }else if (ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(dtoGrupo.getTipoOperacion())){
                    //UtilidadesLog.debug("entre por eliminacion de grupos");
                    try{
                    
                        DetalleOfertaLocal oDetaOfer = null;
                        Collection vODetaOfer = null;
                        Iterator itDetaOfer = null;
                        DetalleOfertaLocalHome dolh = new DetalleOfertaLocalHome();
                        
                        vODetaOfer = dolh.findByGrupo(dtoGrupo.getOidGrupo());
                        itDetaOfer = vODetaOfer.iterator();

                        while (itDetaOfer.hasNext()){
                            oDetaOfer = (DetalleOfertaLocal)itDetaOfer.next();
                            this.eliminarDatosDetalleOferta(oDetaOfer.getOid());
                        }
                    } catch (NoResultException fe ) {
                        UtilidadesLog.debug("vODetaOfer no fue encontrado para eliminarlo ");
                    }
                    try{
                        //UtilidadesLog.debug("vdetaOfer eliminados  ");
                        eGrupo = glh.findByPrimaryKey(dtoGrupo.getOidGrupo());
                        glh.remove(eGrupo);
                        //UtilidadesLog.debug("eGrupo eliminado ");
                    } catch (NoResultException fe ) {
                        UtilidadesLog.debug("eGrupo  no fue encontrado para eliminarlo ");
                    } catch (PersistenceException re) {
                        UtilidadesLog.error(re);
                        ctx.setRollbackOnly();
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
            }
            
        } // cierra la iteracion de los grupos
        UtilidadesLog.info("MONOfertaBean.actualizarDatosGrupo (DTOOferta dto):Salida");
        return dto; //[1]
    
    }

    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * modificacion según modelo de componentes SICC-DMCO-PRE-GCC-001
     * Descripción: guarda los datos referidos a la oferta. 
     * pperanzola - 26/10/2005  - se modifica segun incidencia BELC300021295 por peer review
     * 
     */
    private DTOOferta insertarDatosOferta(DTOOferta dto) throws MareException{
        UtilidadesLog.info("MONOfertaBean.insertarDatosOferta (DTOOferta dto):Entrada");
        validarAcceso(dto);
        OfertaLocal oferLocal = null;
        Integer numOferAux = null;
        OfertaLocalHome olh = new OfertaLocalHome();
        if (dto.getOidOferta()== null){
            UtilidadesLog.debug(" el oid de la oferta es nulo ");
            try {
                if (dto.getNumeroOferta()== null){
                    UtilidadesLog.debug(" NumeroOferta es nulo");
                    numOferAux =  obtenerUltimoNumeroOferta(dto.getOidCabeceraMF(),dto.getOidEstrategia());
                    if (numOferAux!= null){
                        numOferAux = new Integer (numOferAux.intValue() + 1);
                    }else {
                        numOferAux = new Integer (1);
                    }
                    //UtilidadesLog.debug(" numOferAux = " + numOferAux);
                }else {
                    numOferAux = dto.getNumeroOferta();
                }
                oferLocal = olh.create(dto.getOidEstrategia() //Long coes_oid_estr,
                                                        ,numOferAux //Integer num_ofer
                                                        ,dto.getOidArgumentoVenta() //Long argv_oid_argu_vent
                                                        ,dto.getOidCabeceraMF() //Long mfca_oid_cabe,
                                                        ,dto.getOidCatalogo()); //Long oidCatalogo
                

                oferLocal = this.actualizaOferta(dto,oferLocal);
                olh.merge(oferLocal);
                dto.setOidOferta(oferLocal.getOid());
                
            } catch (PersistenceException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
                
            }
            
        // splatas - DBLG700000131 - 01/11/2006
        /*
        }else if (dto.getNumeroOrden()!= null){ // Se valida el numero de orden de la oferta
            //UtilidadesLog.debug(" NumeroOrden != nul ");
            Boolean correcto = this.validarNumeroOrden(dto.getOidCabeceraMF()
                                                    ,dto.getNumeroOrden()
                                                    ,dto.getOidOferta());
            //UtilidadesLog.debug(" correcto = " + correcto);
            if (correcto.equals(Boolean.FALSE)){
                throw new MareException(new Exception(),
                                        UtilidadesError.armarCodigoError(
                                                                        ConstantesSEG.MODULO_PRE
                                                                        , ""
                                                                        , ErroresNegocio.PRE_0044));
            }
         */
         // fin DBLG700000131
         
         } else {
            
            try {
                oferLocal = olh.findByPrimaryKey(dto.getOidOferta());
                //UtilidadesLog.debug(" a actualizar oferta ");
                // Agregado por SICC20070375 - Rafael Romero - 02/08/2007
                if((oferLocal.getOidFormPago()==null && dto.getOidFormaPago()==null) 
                        || (oferLocal.getOidFormPago()!=null && dto.getOidFormaPago()!=null && dto.getOidFormaPago().equals(oferLocal.getOidFormPago()))){
                    indUpdFormaPago = false;
                }else{
                    indUpdFormaPago = true;
                }
                UtilidadesLog.debug("indUpdFormaPago:["+indUpdFormaPago+"]");
                // Fin agregado SICC20070375
                oferLocal = this.actualizaOferta(dto,oferLocal);
                oferLocal.setOidEstr(dto.getOidEstrategia());
                oferLocal.setNumeroOferta(dto.getNumeroOferta());
                oferLocal.setOidArguVent(dto.getOidArgumentoVenta());
                oferLocal.setOidCabe(dto.getOidCabeceraMF());
                oferLocal.setOidCatalogo(dto.getOidCatalogo());
                olh.merge(oferLocal);
            } catch(NoResultException fe) {
                //UtilidadesLog.error(fe);
                //ctx.setRollbackOnly();
                //throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ce) {
                UtilidadesLog.error(ce);
                ctx.setRollbackOnly();
                throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
                
            }
            
        
        }
        UtilidadesLog.info("MONOfertaBean.insertarDatosOferta (DTOOferta dto):Salida");
        return dto;
        
    }
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param dto
     * método auxiliar para la actualizacion de la oferta
     */
    private OfertaLocal actualizaOferta (DTOOferta dto,OfertaLocal oferLocal) throws MareException{
        UtilidadesLog.info("MONOfertaBean.actualizaOferta (DTOOferta dto,OfertaLocal oferLocal):Entrada");
        //oferLocal.setNumeroOrden(dto.getNumeroOrden());se elimina por pedido de cambio PRE-003
        oferLocal.setOidAcceso(dto.getOidAcceso());
        oferLocal.setOidSbac(dto.getOidSubacceso());
        oferLocal.setDespachoCompleto(dto.getDespachoCompleto());
        oferLocal.setDespachoAutomatico(dto.getDespachoAutomatico());
        oferLocal.setNumeroGrupos(dto.getNumeroGrupos());
        oferLocal.setNumeroPaquetes(dto.getNumeroPaquetes());
        oferLocal.setNumeroGruposCondicionados(dto.getNumeroGruposCondicionados());
        oferLocal.setNumeroGruposCondicionantes(dto.getNumeroGruposCondicionantes());
        oferLocal.setCondicionCondicionantes(dto.getCondicionCondicionantes());
        oferLocal.setCondicionCondicionados(dto.getCondicionCondicionados());
        oferLocal.setPrimeraPosicionRanking(dto.getPrimeraPosicionRanking());
        oferLocal.setUltimaPosicionRanking(dto.getUltimaPosicionRanking());
        oferLocal.setCodigoVentaGenerado(dto.getCodigoVentaGenerado());
        oferLocal.setMatrizFacturacionGenerada(dto.getMatrizFacturacionGenerada());
        oferLocal.setOidFormPago(dto.getOidFormaPago());
        oferLocal.setRecuperacionObligatoria(dto.getRecuperacionObligatoria());
        oferLocal.setRegistroEstadisticoGenerado(dto.getRegistroEstadisticoGenerado());
        //se hace el merge en el metodo llamador.
        UtilidadesLog.info("MONOfertaBean.actualizaOferta (DTOOferta dto,OfertaLocal oferLocal):Salida");
        return oferLocal;
    }
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param oidOferta
     * @param ventasExclusivas
     * según modelo de componentes SICC-DMCO-PRE-GCC-001
     * 
     * pperanzola - 04/10/2005 se modifica según incidencia BELC300021147
     */
    private void insertarDatosVentaExclusiva(Long oidOferta, Vector ventasExclusivas) throws MareException {
        UtilidadesLog.info("MONOfertaBean.insertarDatosVentaExclusiva (Long oidOferta, Vector ventasExclusivas):Entrada");
        int i;
        int cantVtas = 0;
        if (ventasExclusivas != null){
            cantVtas = ventasExclusivas.size();
        }
        VentaExclusivaLocal vtaExclu = null;
        DTOVentaExclusiva dtoVenta = null;
        VentaExclusivaLocalHome velh = new VentaExclusivaLocalHome();
        //UtilidadesLog.debug(" cantVtas = " + cantVtas);
        for (i=0; i < cantVtas ; i++){
        
           dtoVenta = (DTOVentaExclusiva) ventasExclusivas.get(i);
           if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(
                                                        dtoVenta.getTipoOperacion())){
               try{
                    vtaExclu = velh.create(oidOferta
                                            ,dtoVenta.getOidSubtipoCliente()
                                            ,dtoVenta.getOidEstatus()
                                            ,dtoVenta.getOidClasificacion()
                                            ,dtoVenta.getOidTipoCliente()
                                            ,dtoVenta.getOidTipoClasificacion()
                                        );
                   vtaExclu.setOidRegion(dtoVenta.getOidRegion());
                   vtaExclu.setOidZona(dtoVenta.getOidZona());
                   
                    //UtilidadesLog.debug(" vtaExclu generada = " + vtaExclu.getOid());
               } catch (PersistenceException ce) {
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
               }
               vtaExclu.setEstatus2(dtoVenta.getEstatus2());
               velh.merge(vtaExclu);
           }
        }
        UtilidadesLog.info("MONOfertaBean.insertarDatosVentaExclusiva (Long oidOferta, Vector ventasExclusivas):Salida");
    }

    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param oidOferta
     * @param promocion
     * se crea para auxiliar otros métodos utilizados en cambios según modelo de componentes SICC-DMCO-PRE-GCC-001
     * 
     * pperanzola - 04/10/2005 se modifica según incidencia BELC300021147
     * pperanzola - 26/10/2005  - se modifica segun incidencia BELC300021295 por peer review
     */    
    private void insertarDatosPromocion(Long oidOferta, Vector promocion) throws MareException{
        UtilidadesLog.info("MONOfertaBean.insertarDatosPromocion (Long oidOferta, Vector promocion):Entrada");
        int i;
        DTOPromocion dtoPromo = null;
        int cantPromo = 0;
        if (promocion != null){
            cantPromo = promocion.size();
        }
        PromocionLocal promoLocal = null;
        for (i = 0; i< cantPromo; i++){
            dtoPromo = (DTOPromocion) promocion.get(i);
            if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(
                                                        dtoPromo.getTipoOperacion())){
                try {
                    promoLocal = new PromocionLocalHome().create(oidOferta
                                                                    , dtoPromo.getNumeroCondicion()
                                                                    , new BigDecimal (dtoPromo.getFactorCuadre().floatValue())
                                                                    , dtoPromo.getOidIndicadorCuadre());
    
                } catch (PersistenceException ce) {
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
                    
               }
               //UtilidadesLog.debug(" promoLocal generada = " + promoLocal.getOid());
               this.insertarDatosRangoPromocion(promoLocal.getOid(),dtoPromo.getLineaPromocion());
            }
        }
        UtilidadesLog.info("MONOfertaBean.insertarDatosPromocion (Long oidOferta, Vector promocion):Salida");
    }
    
    /**
     * @author pperanzola
     * @date 30/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param lineasPromocion
     * @param oidPromocion
     * Descripción: guarda los datos de las lineas de promocion. 
     * pperanzola - 04/10/2005 se modifica según incidencia BELC300021147
     * pperanzola - 26/10/2005  - se modifica segun incidencia BELC300021295 por peer review
     */
    private void insertarDatosRangoPromocion(Long oidPromocion, Vector lineasPromocion) throws MareException {
        UtilidadesLog.info("MONOfertaBean.insertarDatosRangoPromocion (Long oidPromocion, Vector lineasPromocion):Entrada");
        DTOLineaPromocion dtoLinea = null;
        RangosPromocionLocal rangoPromo = null;
        int i;
        int cantLineas = 0;
        if (lineasPromocion != null){  
            cantLineas = lineasPromocion.size();
        }
        /*UtilidadesLog.debug("cantLineas = "+cantLineas);
        UtilidadesLog.debug("oidPromocion = "+oidPromocion);*/
        for (i =0; i < cantLineas; i++){
            dtoLinea = (DTOLineaPromocion) lineasPromocion.get(i);

            if (!ConstantesPRE.OPERACION_BAJA.equalsIgnoreCase(
                                                        dtoLinea.getTipoOperacion())){
                try{
                    RangosPromocionLocalHome rplh = new RangosPromocionLocalHome();
                    rangoPromo = rplh.create(dtoLinea.getOidCatalogo()
                                        , oidPromocion
                                        , String.valueOf(dtoLinea.getTipoRango())
                                        , dtoLinea.getNumeroRangoInterno()
                                        , dtoLinea.getValorDesde());
                    rangoPromo.setIndicadorExclusion(dtoLinea.getIndicadorExclusion());
                    rangoPromo.setValorHasta(dtoLinea.getValorHasta());
                    rplh.merge(rangoPromo);
                } catch (PersistenceException ce) {
                    UtilidadesLog.error(ce);
                    ctx.setRollbackOnly();
                    throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_INTEGRIDAD_INSERCION));
                }
            }
        }
        UtilidadesLog.info("MONOfertaBean.insertarDatosRangoPromocion (Long oidPromocion, Vector lineasPromocion):Salida");
    }
    
    
    
    /**
     * @author pperanzola
     * @date 29/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param oids
     * se crea para auxiliar otros métodos utilizados en cambios según modelo de componentes SICC-DMCO-PRE-GCC-001
     * 
     */
    private void borrarMatricesAltRecupReemp(Collection oids) throws MareException {
        UtilidadesLog.info("MONOfertaBean.borrarMatricesAltRecupReemp(Collection oids): Entrada");
        
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
                }
            }
            
        } catch (PersistenceException Re) {
            ctx.setRollbackOnly();
            throw new MareException(Re, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }        
        UtilidadesLog.info("MONOfertaBean.borrarMatricesAltRecupReemp(Collection oids): Salida");
    }
    
    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MaestroProductosLocalHome) context.lookup("java:comp/env/MaestroProductos");
    }


    private PeriodoLocalHome getPeriodoLocalHome() throws MareException {
        UtilidadesLog.info("MONOfertaBean.getPeriodoLocalHome(): Entrada");
        UtilidadesLog.info("MONOfertaBean.getPeriodoLocalHome(): Salida");
        return new PeriodoLocalHome();                 
    }

    private MONConfiguracionMFHome getMONConfiguracionMFHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONConfiguracionMFHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONConfiguracionMF"), MONConfiguracionMFHome.class);
    }

    private MONValidacionHome getMONValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (MONValidacionHome)PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacion"), MONValidacionHome.class);
    }
  /**
   * @author enoziglia
   * @date 03/07/2006
   * @throws es.indra.mare.common.exception.MareException
   * @param dtoE
   * @description obtiene el oid de programa de fidelizacion de un producto
   *              de Maestro de Productos. (puede ser nulo el resultado dentro 
   *              del DTOOID a devolver) 
   * @reference SC-PRE-MAE-INT-001-2, SC-PRE-MAE-INT-001-4, SICC-DECU-PRE-201-372b 
   */
    public DTOOID obtenerProgramaFidelizacion(DTOOID dtoE) throws MareException {
      UtilidadesLog.info("MONOfertaBean.obtenerProgramaFidelizacion(DTOOID dtoE): Entrada");
      DTOOID dtoRes = new DTOOID();
      try {
        MaestroProductosLocalHome lhMaeProdu = this.getMaestroProductosLocalHome();
        MaestroProductosPK pkMaeProdu = new MaestroProductosPK(dtoE.getOid());
        UtilidadesLog.info("MAD El oid de producto es " + dtoE.getOid());
        UtilidadesLog.info("MAD El oid de producto es " + pkMaeProdu);
        MaestroProductosLocal lMaeProdu = lhMaeProdu.findByPrimaryKey(pkMaeProdu);
        dtoRes.setOid(lMaeProdu.getProgramaFidelizacion());
      } catch (FinderException ez) {
          UtilidadesLog.error(ez);
          throw new MareException(ez, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (NamingException ex) {
          UtilidadesLog.error(ex); 
          throw new MareException(ex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      } 
      UtilidadesLog.info("MONOfertaBean.obtenerProgramaFidelizacion(DTOOID dtoE): Salida");
      return dtoRes;
    }

  public DTOSalida buscarProductosEstimadosPerf(DTOEBuscarProductos dto) throws MareException  {
    UtilidadesLog.info("MONOfertaBean.buscarProductosEstimadosPerf(DTOEBuscarProductos dto): Entrada");
        
        try {
            RecordSet rs = new RecordSet();

            DTOSalida dtos = new DTOSalida();

            //String usuario = ctx.getCallerPrincipal().getName();

            BelcorpService belcorpService = BelcorpService.getInstance();

            //Obtencion del oidPeriodo
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            CabeceraMFLocal cmfl = cmflh.findByPrimaryKey(dto.getOidCabeceraMF());

            Long periodo = cmfl.getOidPeri();

            StringBuffer query = new StringBuffer();

            query.append(" SELECT * FROM ( ");
            query.append(" SELECT p.OID_ESTIM_VENT OID, ");
            query.append(" mp.COD_SAP, g3.VAL_I18N DES_SAP, ");
            query.append(" p.IMP_PREC_CATA, p.NUM_PAGI_CATA, g1.VAL_I18N DES_TIPO_OFER, g2.VAL_I18N DES_CICL_VIDA, ");
            query.append(" mp.VAL_ATRI_1, mp.VAL_ATRI_2, mp.VAL_ATRI_3, ");
            query.append(" p.VAL_POSI_PAGI, p.NUM_UNID_ESTI, av.VAL_FACT_REPE, ");
            query.append(" p.IMP_VENT_NETA_ESTI, p.IMP_PREC_POSI, p.VAL_COST_ESTA, p.OCAT_OID_CATA, ");
            query.append(" pc.DES_CATA, p.TOFE_OID_TIPO_OFER, ");
            query.append(" p.CIVI_OID_CICL_VIDA,  p.VAL_CENT ");
            query.append(" , mp.DES_CORT, mp.OID_PROD, p.CNDP_OID_COND_PROM, p.PRFI_OID_PROG_FIDE, mp.PRFI_OID_PROG_FIDE PROG_FIDE_MAE");
            query.append(" FROM PRE_ESTIM_VENTA p, PRE_ARGUM_VENTA av, PRE_CATAL pc, GEN_I18N_SICC g1, GEN_I18N_SICC g2, ");
            query.append(" MAE_PRODU mp, GEN_I18N_SICC g3, CRA_PERIO pe ");
            query.append(" WHERE p.ARGV_OID_ARGU_VENT = av.OID_ARGU_VENT ");
            query.append(" AND p.OCAT_OID_CATA = pc.OID_CATA ");
            query.append(" AND g1.ATTR_ENTI = 'PRE_TIPO_OFERT' ");
            query.append(" AND g1.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g1.VAL_OID = p.TOFE_OID_TIPO_OFER ");
            query.append(" AND g2.ATTR_ENTI = 'PRE_CICLO_VIDA' ");
            query.append(" AND g2.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g2.VAL_OID =  p.CIVI_OID_CICL_VIDA ");
            query.append(" AND g3.ATTR_ENTI = 'MAE_PRODU' ");
            query.append(" AND g3.IDIO_OID_IDIO = " + dto.getOidIdioma() + " ");
            query.append(" AND g3.VAL_OID =  p.PROD_OID_PROD ");

            query.append(" AND p.PERD_OID_PERI = pe.OID_PERI ");
            query.append(" AND pe.OID_PERI = " + periodo + " ");

            if (dto.getOidMarca() != null) {
                query.append(" AND mp.MAPR_OID_MARC_PROD = " + dto.getOidMarca() + " ");
            }

            //query.append(" AND p.COES_OID_ESTR = " + dto.getOidEstrategia() + " ");
            if (dto.getOidAcceso() != null) {
                query.append(" AND p.ACCE_OID_ACCE = " + dto.getOidAcceso() + " ");
            }

            if (dto.getOidSubacceso() != null) {
                query.append(" AND p.SBAC_OID_SBAC = " + dto.getOidSubacceso() + " ");
            }

            query.append(" AND p.PROD_OID_PROD = mp.OID_PROD ");
            query.append(" AND mp.PAIS_OID_PAIS = " + dto.getOidPais() + " ");

            if (dto.getCodSAP() != null) {
                query.append(" AND mp.COD_SAP LIKE '" + dto.getCodSAP() + "' ");
            }

            if (dto.getDescripcionSAP() != null) {
                query.append(" AND g3.VAL_I18N LIKE '" + dto.getDescripcionSAP() + "' ");
            }

            /*
             * Disponible otra vez por cambio SiCC 20070317 - Rafael Romero - 26/06/2007
             */
            if (dto.getOidCatalogo() != null) {
                query.append(" AND p.OCAT_OID_CATA = " + dto.getOidCatalogo() + " ");
            }
            // Fin SiCC 20070317

            if (dto.getPaginaDesde() != null) {
                query.append(" AND  p.NUM_PAGI_CATA >= " + dto.getPaginaDesde() + " ");
            }

            if (dto.getPaginaHasta() != null) {
                query.append(" AND  p.NUM_PAGI_CATA <= " + dto.getPaginaHasta() + " ");
            }

            query.append("ORDER BY OID  )  WHERE ROWNUM <= " + dto.getTamanioPagina().intValue() + " and OID > " + dto.getIndicadorSituacion().intValue() + " ");

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if (rs.esVacio()) {
                throw new MareException(new Exception(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            dtos.setResultado(rs);
            
            UtilidadesLog.info("MONOfertaBean.buscarProductosEstimadosPerf(DTOEBuscarProductos dto): Salida");
            return dtos;
            
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            UtilidadesLog.error(serviceNotFoundException); 
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            UtilidadesLog.error(exception); 
            if (exception instanceof MareException) {
                throw (MareException) exception;
            } else {
                throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
            }
        }
  }
  
  /**    
   *@Author: pperez 
   *@Fecha: 31/10/2006
   *@throws: 
   *@return: 
   *@param: 
   *@Observaciones: Este metodo renumera los detalle de oferta de 1 a n. Incidencia DBLG700000135
  */ 
  
  public void asignarNumerosLinea(Long oidOferta) throws MareException {
    UtilidadesLog.info("MONOfertaBean.asignarNumerosLinea(Long oidOferta): Entrada");
  
    try {        
        BelcorpService belcorpService = BelcorpService.getInstance();
        StringBuffer query = new StringBuffer();
        
        
        query.append("  UPDATE pre_ofert_detal x   ");
        query.append("     SET num_line_ofer =   ");
        query.append("            (SELECT s.alias    ");
        query.append("               FROM (SELECT SUM (1) OVER (PARTITION BY ofer_oid_ofer ORDER BY num_line_ofer)   ");
        query.append("                                                                       AS alias,   ");
        query.append("                            oid_deta_ofer   ");
        query.append("                       FROM pre_ofert_detal p   ");
        query.append("                      WHERE p.ofer_oid_ofer = " + oidOferta + ") s   ");
        query.append("              WHERE s.oid_deta_ofer = x.oid_deta_ofer)   ");
        query.append("   WHERE ofer_oid_ofer = " + oidOferta);
 
        belcorpService.dbService.executeUpdate(query.toString());

        /*query.append("  SELECT   oid_deta_ofer  OID_DETALLE ");
        query.append("      FROM pre_ofert_detal   ");
        query.append("     WHERE pre_ofert_detal.ofer_oid_ofer =  " + oidOferta);
        query.append("  ORDER BY num_line_ofer   "); */
        
        
        /*StringBuffer update = new StringBuffer();
        
        int cant = rs.getRowCount();
        int pos;
        Long oidDetalle = null; 
        
        for (int i = 0; i<cant; i++)  {
            pos = i+1;
            oidDetalle = new Long(((BigDecimal) rs.getValueAt(i,"OID_DETALLE")).longValue());
            update.append("UPDATE pre_ofert_detal  ");
            update.append(" SET num_line_ofer = " + pos);
            update.append(" WHERE oid_deta_ofer = " + oidDetalle + ";");
        }
        
        belcorpService.dbService.executeProcedure("PQ_PLANI.EXECUTOR",update.toString());*/

        
    } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(serviceNotFoundException); 
        throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
    } catch (MareException me) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(me); 
        throw me;
    } catch (Exception e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error(e); 
        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
    }
    UtilidadesLog.info("MONOfertaBean.asignarNumerosLinea(Long oidOferta): Salida");
  
  }

  public ArrayList ordenarOfertas(RecordSet ofertas) throws MareException {
    UtilidadesLog.info("MONOfertaBean.ordenarOfertas(RecordSet ofertas): Entrada");
    ArrayList ofertasOrdenadas = new ArrayList();
    Long oidOfertaActual = null;
    Long oidTipoEstraActual = null;    
    
    if (ofertas!=null&&ofertas.getRowCount()>0) {
      int cantOfer = ofertas.getRowCount();
      Long oidOferta = BigToLong(ofertas.getValueAt(0,"OID_OFER"));
      Long oidTipoEstrategia = BigToLong(ofertas.getValueAt(0,"TIES_OID_TIPO_ESTR"));
      ArrayList ofertaAOrdenar = new ArrayList();
      for (int i=0;i<cantOfer;i++) {
      
        oidOfertaActual = BigToLong(ofertas.getValueAt(i,"OID_OFER"));
        oidTipoEstraActual = BigToLong(ofertas.getValueAt(i,"TIES_OID_TIPO_ESTR"));
        
        OfertaOrdenar detalleOfertaOrdenar = null;
        
        if (oidTipoEstraActual!=null&&(oidTipoEstraActual.intValue()==ConstantesPRE.COMPUESTA_FIJA)) {
          detalleOfertaOrdenar = new OfertaCompuestaFija();          
        } else if (oidTipoEstraActual!=null&&(oidTipoEstraActual.intValue()==ConstantesPRE.CONDICIONADA)) {
          detalleOfertaOrdenar = new OfertaCondicionada();
        } else {
          detalleOfertaOrdenar = new OfertaNoCompuestaFija();
        }
        detalleOfertaOrdenar.setTextoBreve((String)ofertas.getValueAt(i,"DES_CORT"));
        detalleOfertaOrdenar.setNumeroGrupo(BigToInteger(ofertas.getValueAt(i,"NUM_GRUP")));
        detalleOfertaOrdenar.setOidOferta(BigToLong(ofertas.getValueAt(i,"OID_OFER")));
        detalleOfertaOrdenar.setOidTipoEstrategia(BigToLong(ofertas.getValueAt(i,"TIES_OID_TIPO_ESTR")));
        detalleOfertaOrdenar.setProductoPrincipal(bigDecimalToBoolean(ofertas.getValueAt(i,"IND_PROD_PRIN")));
        detalleOfertaOrdenar.setIndicadorCondicionado(bigDecimalToBoolean(ofertas.getValueAt(i,"IND_CNDO")));
        detalleOfertaOrdenar.setIndicadorCondicionante(bigDecimalToBoolean(ofertas.getValueAt(i,"IND_CNDT")));
        detalleOfertaOrdenar.setOidDetalleOferta(BigToLong(ofertas.getValueAt(i,"OID_DETA_OFER")));
        
        if (oidOferta.equals(oidOfertaActual)) {
          ofertaAOrdenar.add(detalleOfertaOrdenar);
        } else {
          if (oidTipoEstraActual!=null&&(oidTipoEstraActual.intValue()!=ConstantesPRE.INDIVIDUAL&&oidTipoEstraActual.intValue()!=ConstantesPRE.INDIVIDUAL_VS_GRUPO)) {
            Collections.sort(ofertaAOrdenar);    
          }
          ofertasOrdenadas.addAll((Collection)ofertaAOrdenar.clone());
          oidOferta = BigToLong(ofertas.getValueAt(i,"OID_OFER"));
          oidTipoEstrategia = BigToLong(ofertas.getValueAt(i,"TIES_OID_TIPO_ESTR"));
          ofertaAOrdenar = new ArrayList();
          ofertaAOrdenar.add(detalleOfertaOrdenar);
        }
      }
      //modificacion por incidencia PRE-001 de cambio SICC-GCC-PRE-003
      if (oidTipoEstraActual!=null&&(oidTipoEstraActual.intValue()!=ConstantesPRE.INDIVIDUAL&&oidTipoEstraActual.intValue()!=ConstantesPRE.INDIVIDUAL_VS_GRUPO)) {
        Collections.sort(ofertaAOrdenar);    
      }
      ofertasOrdenadas.addAll((Collection)ofertaAOrdenar.clone());      
    }
    UtilidadesLog.info("MONOfertaBean.ordenarOfertas(RecordSet ofertas): Salida");
    return ofertasOrdenadas;
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

  public DTOSalida consultarOrdenOfertaFiltros(DTOEOrdenOfertas dto) throws MareException {
        UtilidadesLog.info("MONOfertaBean.consultarOrdenOfertaFiltros(DTOEOrdenOfertas dto): Entrada");
        dto.setTamanioPagina(new Integer(60));
        StringBuffer query = new StringBuffer();        
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        BelcorpService belcorpService = null;
        
  query.append(" SELECT y.oidtemp, ");
               query.append(" (CASE ");
                   query.append(" WHEN y.num_orden = 100000000 ");
                      query.append(" THEN NULL ");
                   query.append(" ELSE y.num_orden ");
                query.append(" END) num_orde, y.num_ofer, y.desc_estra, y.cod_sap, y.val_codi_vent, ");
               query.append(" y.desc_produ, y.imp_prec_cata, y.cod_tipo_ofer, y.val_fact_repe, ");
               query.append(" y.num_pagi_cata, y.ind_impr_gp, y.ind_digi, y.sicc_es_ultima_pagina ");
          query.append(" FROM (SELECT x.*, ");
                       query.append(" CASE ");
                          query.append(" WHEN (("+dto.getTamanioPagina()+" - COUNT (*) OVER (PARTITION BY 1)) < 0 ");
                               query.append(" ) ");
                             query.append(" THEN 0 ");
                          query.append(" ELSE 1 ");
                       query.append(" END sicc_es_ultima_pagina ");
                  query.append(" FROM (SELECT   ROWNUM oidtemp, ");
                                 query.append(" (NVL (v_pre_orden_ofert.num_orde, 100000000) ");
                                 query.append(" ) num_orden, ");
                                 query.append(" v_pre_orden_ofert.num_ofer, ");
                                 query.append(" v_pre_orden_ofert.desc_estra, ");
                                 query.append(" v_pre_orden_ofert.cod_sap, ");
                                 query.append(" v_pre_orden_ofert.val_codi_vent, ");
                                 query.append(" v_pre_orden_ofert.desc_produ, ");
                                 query.append(" v_pre_orden_ofert.imp_prec_cata, ");
                                 query.append(" v_pre_orden_ofert.cod_tipo_ofer, ");
                                 query.append(" v_pre_orden_ofert.val_fact_repe, ");
                                 query.append(" v_pre_orden_ofert.num_pagi_cata, ");
                                 query.append(" v_pre_orden_ofert.ind_impr_gp, ");
                                 query.append(" v_pre_orden_ofert.ind_digi ");
                            query.append(" FROM v_pre_orden_ofert, mae_produ ");
                           query.append(" WHERE mae_produ.cod_sap(+) = v_pre_orden_ofert.cod_sap ");
                             query.append(" AND mae_produ.pais_oid_pais(+) = " + dto.getOidPais() + " ");//BELC300021447 
                             query.append(" AND v_pre_orden_ofert.idio_oid_idio = " + dto.getOidIdioma() + " ");
                             query.append(" AND v_pre_orden_ofert.oid_cabe = " + dto.getOidCabeceraMF() + " ");
        if (dto.getOidCatalogo() != null) {
            query.append(" AND v_pre_orden_ofert.OCAT_OID_CATAL = " + dto.getOidCatalogo() + " ");
        }
        if (dto.getPaginaDesde() != null) {
            query.append(" AND  v_pre_orden_ofert.NUM_PAGI_CATA >= " + dto.getPaginaDesde() + " ");
        }

        if (dto.getPaginaHasta() != null) {
            query.append(" AND  v_pre_orden_ofert.NUM_PAGI_CATA <= " + dto.getPaginaHasta() + " ");
        }
        
        if (dto.getOidTipoOferta() != null) {
            query.append(" AND v_pre_orden_ofert.OID_TIPO_OFER = " + dto.getOidTipoOferta() + " ");
        }
        
        if ((dto.getMostrarImprimibles() != null) && dto.getMostrarImprimibles().booleanValue()) {
            query.append(" AND V_PRE_ORDEN_OFERT.IND_IMPR_GP = 1 ");
        }
                                                  
                        query.append(" ORDER BY linea, num_orde, desc_produ) x ");
                 query.append(" WHERE ROWNUM <= "+(dto.getTamanioPagina().intValue()+1)+" AND oidtemp > "+dto.getIndicadorSituacion()+") y ");
         query.append(" WHERE ROWNUM <= "+dto.getTamanioPagina()+" AND oidtemp >  "+dto.getIndicadorSituacion());
         
        try {
            belcorpService = BelcorpService.getInstance();
            rs = belcorpService.dbService.executeStaticQuery(query.toString());
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        } catch (Exception exception) {
            throw new MareException(exception, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (rs.esVacio()) {
            String codigoError = null;
            codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            
            throw new MareException(null, null, UtilidadesError.armarCodigoError(codigoError));
        }

        dtos.setResultado(rs);
        
        UtilidadesLog.info("MONOfertaBean.consultarOrdenOfertaFiltros(DTOEOrdenOfertas dto): Salida");
        return dtos;
  }
  
  public DTOSalida obtenerProductosAsociados(ArrayList dtos) throws MareException{
        UtilidadesLog.info("MONOfertaBean.obtenerProductosAsociados(DTOOID dtoe): Entrada");
        
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            StringBuffer query = new StringBuffer(" SELECT VAL_CODI_VENT CODIGO_VENTA , OFER_OID_OFER OFERTA FROM PRE_OFERT_DETAL  ");
            //query.append(" where OFER_OID_OFER IN (");
            query.append(" where 1 = 1 AND (");
            String ofertas = "";
            
            Iterator it = dtos.iterator();
            int count = 0;
            
             while (it.hasNext()){
                if (count == 0) {
                    ofertas = "'" + it.next().toString() + "'";
                } else { 
                    ofertas += ",'" + it.next().toString() + "'";
                }

                if (count == 999)  {
                    query.append(" OFER_OID_OFER IN (" + ofertas.toString() + ") ");                     
                    if (it.hasNext()){
                        query.append("  OR ");
                    }                    
                    count = 0;
                    ofertas = "";
                } else {
                    if (!it.hasNext()){
                        query.append(" OFER_OID_OFER IN (" + ofertas.toString() + ") ");        
                    }                    
                    count++;            
                }                 
                if (!it.hasNext()){              
                  query.append(")");
                }
            }

            
            /*
            for (int i = 0 ; i < dtos.size() ; i++ ){
                
                if (i ==(dtos.size()-1)){
                    query.append(dtos.get(i).toString());
                }else{
                    query.append(dtos.get(i).toString()+" , ");
                }
            }
            query.append(" ) ");
            */            
            query.append(" AND IND_PROD_PRIN = 0 ");

            RecordSet r = bs.dbService.executeStaticQuery(query.toString());

            DTOSalida dto = new DTOSalida();
            dto.setResultado(r);
            
            UtilidadesLog.info("MONOfertaBean.obtenerProductosAsociados(DTOOID dtoe): Salida");
            return dto;
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    // sapaza -- PER-SiCC-2013-1000 -- 14/10/2013
    private String obtenerOidPais(Long oidCabecera) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerOidPais(Long oidCabecera): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT cra.PAIS_OID_PAIS  ");
        consulta.append("   FROM PRE_MATRI_FACTU_CABEC cab, CRA_PERIO cra  ");
        consulta.append("  WHERE cab.PERD_OID_PERI = cra.OID_PERI  ");
        consulta.append("    AND cab.OID_CABE = " + oidCabecera.toString());
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOSolicitud.obtenerOidPais(Long oidCabecera): Salida");

        return null;
    }
    
    // sapaza -- PER-SiCC-2013-1000 -- 14/10/2013
    private String obtenerValorParametroPais(String oidPais, String codigoModulo, String codigoParametro) throws MareException {
        UtilidadesLog.info("DAOSolicitud.obtenerValorParametroPais(String oidPais, String codigoModulo, String codigoParametro): Entrada");
                      
        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT pp.val_para      ");
        consulta.append("   FROM bas_param_pais pp, bas_pais bp, seg_pais sp  ");
        consulta.append("  WHERE sp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND sp.oid_pais =  " + oidPais);
        consulta.append("    AND pp.cod_pais = bp.cod_pais  ");
        consulta.append("    AND pp.cod_sist = '" + codigoModulo + "'");
        consulta.append("    AND pp.cod_para = '" + codigoParametro + "'");
        consulta.append("    AND pp.ind_acti =  '1' ");
        
        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {        
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" obtenerIndicadorEquivalencias: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } 

        if (rs != null && !rs.esVacio()) {       
            return rs.getValueAt(0,0).toString();        
        }

        UtilidadesLog.info("DAOSolicitud.obtenerValorParametroPais(String oidPais, String codigoModulo, String codigoParametro): Salida");

        return null;
    }

    // sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
    public DTOString validarRestriccionesOferta(DTOValidacionesOferta dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.validarRestriccionesOferta(DTOValidacionesOferta dto): Entrada");
        DTOString dtos = new DTOString();

        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT PRE_PKG_PROCE.PRE_FN_VALID_RESTR_OFERT("+dto.getOidTipoOferta());
        consulta.append(",'" + dto.getCodigoProducto() + "'," + dto.getOidEstrategia() + ",");
        consulta.append(dto.getPrecioCatalogo() + "," + dto.getPrecioPosicionamiento() + ") FROM DUAL");

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" validarRestriccionesOferta: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if(rs.getValueAt(0,0)!=null)
            dtos.setCadena(rs.getValueAt(0,0).toString());

        UtilidadesLog.info("DAOSolicitud.validarRestriccionesOferta(DTOValidacionesOferta dto): Salida");
        return dtos;
    }

    // sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
    public DTOString validarProductoRecuperacion(DTOValidacionRecuperacion dto) throws MareException {
        UtilidadesLog.info("DAOSolicitud.validarProductoRecuperacion(DTOValidacionesOferta dto): Entrada");
        DTOString dtos = new DTOString();

        StringBuffer consulta = new StringBuffer();

        consulta.append(" SELECT PRE_PKG_PROCE.PRE_FN_VALID_PRODU_RECUP("+dto.getOidMatrizPrincipal());
        consulta.append("," + dto.getOidMatrizRecuperacion() + ") FROM DUAL");

        BelcorpService bs = BelcorpService.getInstance();
        RecordSet rs = null;

        try {
            rs = bs.dbService.executeStaticQuery(consulta.toString());
        } catch (Exception e) {
            UtilidadesLog.error(" validarProductoRecuperacion: Exception", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

        if(rs.getValueAt(0,0)!=null)
            dtos.setCadena(rs.getValueAt(0,0).toString());

        UtilidadesLog.info("DAOSolicitud.validarProductoRecuperacion(DTOValidacionesOferta dto): Salida");
        return dtos;
    }
    
}
