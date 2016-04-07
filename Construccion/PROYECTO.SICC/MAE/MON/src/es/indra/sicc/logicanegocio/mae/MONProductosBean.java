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

package es.indra.sicc.logicanegocio.mae;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.cal.DTOBuscarInformacionProductos;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.dtos.mae.DTOCombosBusquedaMateriales;
import es.indra.sicc.dtos.mae.DTOCombosMateriales;
import es.indra.sicc.dtos.mae.DTOProducto;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalle;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalleHome;
import es.indra.sicc.logicanegocio.mae.DAOMAEProductos;
import es.indra.sicc.logicanegocio.mae.IMateriales;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;


import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONProductosBean implements SessionBean, IMateriales {
    private SessionContext ctx;

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

    /** Rellena el DTOCombosBusquedaMateriales
     * @param DTOBelcorp
          * @throws MareException
     * @return DTOCombosBusquedaMateriales
     */
    public DTOCombosBusquedaMateriales rellenarCombosBusquedaMateriales(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.rellenarCombosBusquedaMateriales(DTOBelcorp): Entrada"); 
        DTOCombosBusquedaMateriales busq = new DTOCombosBusquedaMateriales();
        DAOMAEProductos dao = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        try {
            MONMantenimientoSEGHome segHome = getMantenimientoSEGHome();
            MONMantenimientoSEG manteSEG = segHome.create();

            DTOSalida dtosMarcasProducto = manteSEG.recuperarMarcasProducto(dto);

            busq.setMarcasProducto(((dtosMarcasProducto == null) ? null : dtosMarcasProducto.getResultado()));
            busq.setUnidadNegocio(dao.buscarUnidadesNegocioPorPais(dto));
            busq.setNegocio(dao.buscarNegocioPorPais(dto));
            busq.setGenerico(dao.buscarGenericosPorPais(dto));
            busq.setSupergenerico(dao.buscarSuperGenericoPorPais(dto));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONProductos.rellenarCombosBusquedaMateriales(DTOBelcorp): Salida"); 
        return busq;
    }

    /** Rellena el DTOCombosBusquedaMateriales
     * @param DTOBelcorp
          * @throws MareException
     * @return DTOCombosBusquedaMateriales
     */
    public DTOSalida buscar(DTOBusquedaMateriales dto) throws MareException {
        UtilidadesLog.info("MONProductos.buscar(DTOBusquedaMateriales): Entrada"); 
        String user = ctx.getCallerPrincipal().getName();

        DAOMAEProductos dao = new DAOMAEProductos(user);

        //DAOMAEProductos dao = new DAOMAEProductos();
        UtilidadesLog.info("MONProductos.buscar(DTOBusquedaMateriales): Salida"); 
        return dao.buscarProductosPorCriterios(dto);
    }

    /** Modifica el producto con el DTO que viene como parametro
     * @param DTOProducto
          * @throws MareException
     * @return
     * pperanzola - 06/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
     */
    public void actualizar(DTOProducto dto) throws MareException {
        UtilidadesLog.info("MONProductos.actualizar(DTOProducto): Entrada"); 
        String codigoError;
        MaestroProductosLocalHome maeProducLocalHome = getMaeProducLocalHome();
        MaestroProductosPK pk = new MaestroProductosPK(dto.getOid());
        MaestroProductosLocal maeProduc = null;        
        DAOMAEProductos daoMaeProd = new DAOMAEProductos();

        try {
            maeProduc = maeProducLocalHome.findByPrimaryKey(pk);
        } catch (FinderException fe) {
            codigoError = ErroresDeNegocio.MANTENIMIENTO_MATERIALES_PROD_INEXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
        }
        
        /*
         * Cambio SiCC 20070317 - Rafael Romero - 26/06/2007
         * Eliminar validaciones para actualizar atributo programa de fidelizacion.
         * 
        // [1]
        //Se hace un findByProducto con producto.oid en la entidad DetalleOferta y se obtiene "detalleOferta"
        //Se cambia por la incidencia SiCC 20070220
        boolean hayOfertas = daoMaeProd.existenOfertasConProgFideParaProducto(maeProduc.getOid());
        
        // Hay que validar que si el producto tiene oferta y esa oferta tiene el
        // mismo programa de fidelizacion que el del producto de MAE_PRODU
        // para el periodo actual no se pueda modificar el valor de programaFidelizacion 
       
        UtilidadesLog.debug("hayOfertas = " + hayOfertas);
        if (hayOfertas){
            if (maeProduc.getProgramaFidelizacion()== null){
                this.actualizarDatosMaestroProductos(maeProduc,dto);
            }else{ // si producto.programaFidelizacion es distinto de nulo 
                if (!maeProduc.getProgramaFidelizacion().equals(dto.getProgramaFidelizacion())){
                     UtilidadesLog.debug("entro a tirar exception ");
                    throw new MareException(new Exception(), 
                                            UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE
                                            , "", ErroresDeNegocio.MAE_0035));
                }else{// si es el mismo valor se guarda 
                    this.actualizarDatosMaestroProductos(maeProduc,dto);
                }
            }
        }else{// Si no se recupera detalleOferta 
            this.actualizarDatosMaestroProductos(maeProduc,dto);
        }
        // [1]

        // Fin de validaciones eliminadas SiCC 20070317 - Rafael Romero
         */

        // Insertado por SiCC 20070317 - Rafael Romero - 26/06/2007
        this.actualizarDatosMaestroProductos(maeProduc,dto);
        // Fin insertado SiCC 20070317
        
        UtilidadesLog.info("MONProductos.actualizar(DTOProducto): Salida"); 
    }

    /**
     * @author pperanzola
     * @date 06/10/2005
     * @throws es.indra.mare.common.exception.MareException
     * @param maeProduc
     * [1] modificaciones segun SICC-DMCO-PRE_MAE_INT-GCC-001
     * se crea como método auxiliar para la actualizacion de la entidad maestro de productos
     * 
     */
    private void actualizarDatosMaestroProductos(MaestroProductosLocal maeProduc, DTOProducto dto) throws MareException{
    
         UtilidadesLog.info("MONProductos.actualizarDatosMaestroProductos(MaestroProductosLocal maeProduc, DTOProducto dto): Entrada"); 
        try {
            UtilidadesLog.debug("actualizar() dto: " + dto);

            maeProduc.setCodigoAntiguo(dto.getCodAntiguo());
            maeProduc.setDescripcionCorta(dto.getDescCorta());
            maeProduc.setJerarquia1(dto.getJerarquia1());
            maeProduc.setJerarquia2(dto.getJerarquia2());
            maeProduc.setJerarquia3(dto.getJerarquia3());
            maeProduc.setAtributo1(dto.getAtributo1());
            maeProduc.setAtributo2(dto.getAtributo2());
            maeProduc.setAtributo3(dto.getAtributo3());
            maeProduc.setAlto(dto.getAlto());
            maeProduc.setLargo(dto.getLargo());
            maeProduc.setAncho(dto.getAncho());
            maeProduc.setPeso(dto.getPeso());
            maeProduc.setVolumen(dto.getVolumen());
            maeProduc.setCosteEstandard(dto.getCosteEstandar());
            maeProduc.setPrecioPosicionamiento(dto.getPrecioPosicionamiento());
            maeProduc.setPrecioCatalogo(dto.getPrecioCatalogo());
            maeProduc.setPrecioContable(dto.getPrecioContable());
            maeProduc.setUnidadesDentroPedido(dto.getUnidDentroPedido());
            maeProduc.setUnidadesCaja(dto.getUnidPorCaja());
            maeProduc.setFormaPago(dto.getFormaPago());
            maeProduc.setCodigoImpuesto(dto.getCodImpuesto());

            //maeProduc.setPorcentajeUnidades();
            maeProduc.setGenerico(dto.getGenerico());
            maeProduc.setSuperGenerico(dto.getSupergenerico());
            maeProduc.setUnidadMedidaVolumen(dto.getUnidMedidaVolumen());
            maeProduc.setUnidadMedidaPeso(dto.getUnidMedidaPeso());
            maeProduc.setUnidadMedidaDimensiones(dto.getUnidMedidaDimensiones());
            maeProduc.setNegocio(dto.getNegocio());
            maeProduc.setMarcaProducto(dto.getOidMarca());
            maeProduc.setStatus(dto.getEstatus());
            maeProduc.setLineaDeProducto(dto.getLineaProducto());
            maeProduc.setUnidadNegocio(dto.getUnidadNegocio());

            //maeProduc.setPeriodoInicio(dto.getP);
            //maeProduc.setPeriodoFin(dto.getP);
            maeProduc.setEsLote(dto.getIndLote());
            maeProduc.setIndProductoServicio(dto.getProductoServicio());

            if (dto.getSituacion() != null) {
                maeProduc.setSituacion(dto.getSituacion().toString()); //Cambiado por incidencias
            } else {
                maeProduc.setSituacion(null);
            }

            if (dto.getCajaBolsa() != null) {
                maeProduc.setIndCajaBolsa(dto.getCajaBolsa().toString()); //Cambiado por incidencias
            } else {
                maeProduc.setIndCajaBolsa(null);
            }

            maeProduc.setGrupoArticulos(dto.getGrupoArticulos());

            // /* [1]
            maeProduc.setProgramaFidelizacion(dto.getProgramaFidelizacion());
            //  [1] */
            //Asignar desc sap, internacionalizado
            this.guardarI18N(dto, maeProduc.getOid());

            UtilidadesLog.info("MONProductos.actualizarDatosMaestroProductos(MaestroProductosLocal maeProduc, DTOProducto dto): Salida"); 

        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

    }

    private void guardarI18N(DTOProducto dto, Long oidRegistro) throws MareException {
        UtilidadesLog.info("MONProductos.guardarI18N(DTOProducto, oidregistro): Entrada"); 

        Long oidIdioma = null;
        String descripcion = null;
        Entidadi18nLocalHome e18nLH = null;
        Entidadi18nLocal e18nL = null;

        e18nLH = getEntidadi18nLocalHome();

        for (int i = 0; i < dto.getDescSapI18n().size(); i++) { //.getAttriTraducible().size();i++){

            try {
                DTOI18nSICC dtoTraduccion = (DTOI18nSICC) dto.getDescSapI18n().elementAt(i); //getAttriTraducible().elementAt(i);//devuelve los datos de la traduccion
                oidIdioma = (Long) dtoTraduccion.getOidIdioma();
                descripcion = (String) dtoTraduccion.getValorI18n();

                e18nL = e18nLH.findByEntAtrIdioPK("MAE_PRODU", dtoTraduccion.getOidAtriuto(), oidIdioma, dto.getOid());

                try {
                    if ((descripcion != null) && !descripcion.trim().equals("")) {
                        e18nL.setDetalle(descripcion);
                        e18nLH.merge(e18nL);
                    } else {
                        e18nLH.remove(e18nL);
                    }
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (NoResultException nre) {
                UtilidadesLog.debug("MONProductos - FinderException");

                try {
                    if ((descripcion != null) && !descripcion.equals("")) {
                        e18nLH.create("MAE_PRODU", new Long("1"), oidIdioma, descripcion, oidRegistro);
                    }
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("MONProductos - CreateException");
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
       UtilidadesLog.info("MONProductos.guardarI18N(DTOProducto, oidregistro): Salida"); 
    }

    /** Consulta un producto
     * @param DTOOID
          * @throws MareException
     * @return DTOProducto
     * 
     * @author pperanzola
     * @date 06/09/2005
     *      [1] se modifica el método segun el Dt de Cod unico de venta
     * pperanzola - 05/10/2005 - [2] se modifica segun SICC-DMCO-PRE_MAE_INT-GCC-001
     */
     
    public DTOProducto consultar(DTOOID dto) throws MareException {
    /*inicio Modificado ciglesias Incidencia DBLG70000094*/
        UtilidadesLog.info("MONProductos.consultar(DTOOID): Entrada"); 
        String user = ctx.getCallerPrincipal().getName();
        
        DAOMAEProductos dao = new DAOMAEProductos(user);
        
        UtilidadesLog.info("MONProductos.consultar(DTOOID): Salida"); 
        return dao.consultar(dto);
    /*fin Modificado ciglesias Incidencia DBLG70000094*/
    }

/*inicio Modificado ciglesias Incidencia DBLG70000094
    
    public DTOProducto consultar(DTOOID dto) throws MareException {
         UtilidadesLog.info("MONProductos.consultar(DTOOID): Entrada"); 

        String codigoError;
        MaestroProductosLocalHome maeProducLocalHome = getMaeProducLocalHome();
        MaestroProductosPK pk = new MaestroProductosPK(dto.getOid());
        MaestroProductosLocal maeProduc = null;

        try {
            maeProduc = maeProducLocalHome.findByPrimaryKey(pk);
        } catch (FinderException fe) {
            codigoError = ErroresDeNegocio.MANTENIMIENTO_MATERIALES_PROD_INEXISTENTE;
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
        }

        DTOProducto dtoProd = new DTOProducto();

        //DAOMAEProductos dao = new DAOMAEProductos();
        //String descSAP = dao.obtenerDescSAP(dto);
        //dtoProd.setDescSAP(descSAP);
        Vector vecDesSap = new Vector();
        vecDesSap = obtenerDescripcionSAP(dto);
        dtoProd.setDescSapI18n(vecDesSap);

        dtoProd.setOid(maeProduc.getOid());
        dtoProd.setCodSAP(maeProduc.getCodigoSAP());

        dtoProd.setCodAntiguo(maeProduc.getCodigoAntiguo());
        dtoProd.setDescCorta(maeProduc.getDescripcionCorta());
        dtoProd.setJerarquia1(maeProduc.getJerarquia1());
        dtoProd.setJerarquia2(maeProduc.getJerarquia2());
        dtoProd.setJerarquia3(maeProduc.getJerarquia3());
        dtoProd.setAtributo1(maeProduc.getAtributo1());
        dtoProd.setAtributo2(maeProduc.getAtributo2());
        dtoProd.setAtributo3(maeProduc.getAtributo3());
        dtoProd.setAlto(maeProduc.getAlto());
        dtoProd.setLargo(maeProduc.getLargo());
        dtoProd.setAncho(maeProduc.getAncho());
        dtoProd.setPeso(maeProduc.getPeso());
        dtoProd.setVolumen(maeProduc.getVolumen());
        dtoProd.setCosteEstandar(maeProduc.getCosteEstandard());
        dtoProd.setPrecioPosicionamiento(maeProduc.getPrecioPosicionamiento());
        dtoProd.setPrecioCatalogo(maeProduc.getPrecioCatalogo());
        dtoProd.setPrecioContable(maeProduc.getPrecioContable());
        dtoProd.setUnidDentroPedido(maeProduc.getUnidadesDentroPedido());
        dtoProd.setUnidPorCaja(maeProduc.getUnidadesCaja());
        dtoProd.setFormaPago(maeProduc.getFormaPago());
        dtoProd.setCodImpuesto(maeProduc.getCodigoImpuesto());

        //        maeProduc.setPorcentajeUnidades();
        dtoProd.setGenerico(maeProduc.getGenerico());
        dtoProd.setSupergenerico(maeProduc.getSuperGenerico());
        dtoProd.setUnidMedidaVolumen(maeProduc.getUnidadMedidaVolumen());
        dtoProd.setUnidMedidaPeso(maeProduc.getUnidadMedidaPeso());
        dtoProd.setUnidMedidaDimensiones(maeProduc.getUnidadMedidaDimensiones());
        dtoProd.setNegocio(maeProduc.getNegocio());
        dtoProd.setOidMarca(maeProduc.getMarcaProducto());
        dtoProd.setEstatus(maeProduc.getStatus());
        dtoProd.setLineaProducto(maeProduc.getLineaDeProducto());
        dtoProd.setUnidadNegocio(maeProduc.getUnidadNegocio());

        //maeProduc.setPeriodoInicio(dtoProd.getP);
        //maeProduc.setPeriodoFin(dtoProd.getP);
        dtoProd.setIndLote(maeProduc.getEsLote());
        dtoProd.setProductoServicio(maeProduc.getIndProductoServicio());
        dtoProd.setGrupoArticulos(maeProduc.getGrupoArticulos());

        if ((maeProduc.getSituacion() != null) && (maeProduc.getSituacion().length() > 0)) {
            dtoProd.setSituacion(new Character(maeProduc.getSituacion().charAt(0)));
        }

        if ((maeProduc.getIndCajaBolsa() != null) && (maeProduc.getIndCajaBolsa().length() > 0)) {
            dtoProd.setCajaBolsa(new Character(maeProduc.getIndCajaBolsa().charAt(0)));
        }
        
        dtoProd.setCodigoUnicoVenta(maeProduc.getCodigoUnicoVenta()); //[1]
        //maeProduc.setEsKit(dtoProd.get);
        UtilidadesLog.info("MONProductos.consultar(DTOOID): Salida"); 
        return dtoProd;
    }
fin Modificado ciglesias Incidencia DBLG70000094*/
    

    private Vector obtenerDescripcionSAP(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerDescripcionSAP(DTOOID): Entrada"); 
        BelcorpService bs;
        Vector vecRes = new Vector();
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

            if ((resultado.getRowCount()) != 0) {
                vecRes.add((String) resultado.getValueAt(0, 0));
            }
            
            UtilidadesLog.info("MONProductos.obtenerDescripcionSAP(DTOOID): Salida"); 

            return vecRes;
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
    }

    public DTOCombosMateriales relllenarCombosMateriales(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.relllenarCombosMateriales(DTOBelcorp): Entrada"); 
        DTOCombosBusquedaMateriales dtoBusq = rellenarCombosBusquedaMateriales(dto);
        DTOCombosMateriales dtoMat = new DTOCombosMateriales(dtoBusq);
        DTOInternacional dtoInter = new DTOInternacional();
        dtoInter.setOidIdioma(dto.getOidIdioma());
        dtoInter.setOidPais(dto.getOidPais());

        DAOMAEProductos dao = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        //DAOMAEProductos dao = new DAOMAEProductos();
        dtoMat.setLineaProducto(dao.buscarLineasProductoPorPais(dtoInter));
        dtoMat.setUnidadesMedida(dao.buscarUnidadesMedidaPorPais(dto));
        dtoMat.setEstatus(dao.buscarEstatusPorPais(dto));

        //FormasPago
        try {
            MONGestionFormasPagoDetalle monBel = this.getMONGestionFormasPagoDetalle().create();
            dtoMat.setFormasPago(monBel.obtenerFormasPagoPorPais(dto));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONProductos.relllenarCombosMateriales(DTOBelcorp): Salida"); 

        return dtoMat;
    }

    /** PRIVADOS **/
    /** Obtiene la home de MONMantenimientoSEG
    * @param
    * @throws MareException
    * @return MONMantenimientoSEGHome
    */
    private MONMantenimientoSEGHome getMantenimientoSEGHome() throws MareException {
        UtilidadesLog.info("MONProductos.getMantenimientoSEGHome(): Entrada"); 
        String codigoError;
        MONMantenimientoSEGHome localHome = null;
        BelcorpService miBerlcorpService = null;

        try {
            miBerlcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            //            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MONMantenimientoSEGHome) miBerlcorpService.ejbLocator.getHome("MONMantenimientoSEG", MONMantenimientoSEGHome.class);
        } catch (MareServiceException e) {
            //            ctx.setRollbackOnly();
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONProductos.getMantenimientoSEGHome(): Salida"); 

        return localHome;
    }

    /** Maestro de Productos **/
    private MaestroProductosLocalHome getMaeProducLocalHome() throws MareException {
        UtilidadesLog.info("MONProductos.getMaeProducLocalHome(): Entrada"); 
        String codigoError;
        MaestroProductosLocalHome localHome = null;
        BelcorpService bs = null;

        try {
            bs = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException e) {
            codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        try {
            localHome = (MaestroProductosLocalHome) bs.ejbLocator.getEntityLocalHome("java:comp/env/MaestroProductos");
        } catch (MareServiceException e) {
            e.printStackTrace();
            ;
            codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONProductos.getMaeProducLocalHome(): Salida"); 
        return localHome;
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException {
        UtilidadesLog.info("MONProductos.getMaestroProductosLocalHome(): Entrada"); 
        final InitialContext context = new InitialContext();
        UtilidadesLog.info("MONProductos.getMaestroProductosLocalHome(): Salida"); 
        return (MaestroProductosLocalHome) context.lookup("java:comp/env/MaestroProductos");
    }

    private MONGestionFormasPagoDetalleHome getMONGestionFormasPagoDetalle() throws MareException {
        UtilidadesLog.info("MONProductos.getMONGestionFormasPagoDetalle(): Entrada"); 
        MONGestionFormasPagoDetalleHome localHome = (MONGestionFormasPagoDetalleHome) UtilidadesEJB.getHome("MONGestionFormasPagoDetalle", MONGestionFormasPagoDetalleHome.class);
        UtilidadesLog.info("MONProductos.getMONGestionFormasPagoDetalle(): Salida"); 

        return localHome;
    }

    public DTOSalida obtenerGenericosPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerGenericosPorPais(DTOBelcorp): Entrada"); 
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();

        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        try {
            rs = daoProductos.buscarGenericosPorPais(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerGenericosPorPais(DTOBelcorp): Salida"); 

        return dtoS;
    }

    public DTOSalida obtenerSuperGenericosPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerSuperGenericosPorPais(DTOBelcorp): Entrada"); 
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();

        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        try {
            rs = daoProductos.buscarSuperGenericoPorPais(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerSuperGenericosPorPais(DTOBelcorp): Salida"); 

        return dtoS;
    }

    public DTOSalida obtenerUnidadesNegocioPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerUnidadesNegocioPorPais(DTOBelcorp): Entrada"); 
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();

        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        try {
            rs = daoProductos.buscarUnidadesNegocioPorPais(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerUnidadesNegocioPorPais(DTOBelcorp): Salida"); 

        return dtoS;
    }

    public DTOSalida obtenerNegocioPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerNegocioPorPais(DTOBelcorp): Entrada"); 
        DTOSalida dtoS = new DTOSalida();
        RecordSet rs = new RecordSet();

        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());

        try {
            rs = daoProductos.buscarNegocioPorPais(dto);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        dtoS.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerNegocioPorPais(DTOBelcorp): Salida"); 

        return dtoS;
    }

    public Long obtenerOidProducto(Long pais, String codigoSAP) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerOidProducto(pais, codigoSap): Entrada"); 
        MaestroProductosLocalHome mpLocalHome;
        MaestroProductosLocal mpLocalocal;
        MaestroProductosPK mpPK;
        Long oidProducto = null;

        try {
            mpLocalHome = getMaestroProductosLocalHome();
        } catch (NamingException ne) {
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        try {
            mpPK = new MaestroProductosPK(pais);
            mpLocalocal = mpLocalHome.findByUK(pais, codigoSAP);
            oidProducto = mpLocalocal.getOid();
        } catch (FinderException fe) {
            oidProducto = null;
        }
        
        UtilidadesLog.info("MONProductos.obtenerOidProducto(pais, codigoSap): Salida"); 

        return oidProducto;
    }

    public RecordSet obtenerProductosPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerProductosPais(DTOBelcorp): Entrada"); 
        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONProductos.obtenerProductosPais(DTOBelcorp): Salida"); 

        return daoProductos.obtenerProductosPais(dto);
    }

    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
        return new Entidadi18nLocalHome();
    }

    public DTOSalida obtenerEstatusPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerEstatusPorPais(DTOBelcorp): Entrada"); 
        //Se delega la solicitud en el método buscarEstatusPorPais del DAOMAEProductos
        DTOSalida dtoSal = new DTOSalida();
        RecordSet rs;
        DAOMAEProductos dao = new DAOMAEProductos();
        rs = dao.buscarEstatusPorPais(dto);
        dtoSal.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerEstatusPorPais(DTOBelcorp): Salida"); 

        return dtoSal;
    }

    public DTOSalida obtenerLineasProductoPorPais(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerLineasProductoPorPais(DTOBelcorp): Entrada"); 
        //Se delega la solicitud en el método buscarLineasProductoPorPais del DAOMAEProductos
        DTOSalida dtoSal = new DTOSalida();
        RecordSet rs;
        DAOMAEProductos dao = new DAOMAEProductos();
        rs = dao.buscarLineasProductoPorPais(dto);
        dtoSal.setResultado(rs);
        UtilidadesLog.info("MONProductos.obtenerLineasProductoPorPais(DTOBelcorp): Salida"); 

        return dtoSal;
    }

    public DTOSalida buscarInformacionProductos(DTOBuscarInformacionProductos dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerLineasProductoPorPais(DTOBuscarInformacionProductos): Entrada"); 
        DTOSalida dtoSal = new DTOSalida();
        DAOMAEProductos dao = new DAOMAEProductos();
        dtoSal = dao.buscarInformacionProductos(dto);
        UtilidadesLog.info("MONProductos.obtenerLineasProductoPorPais(DTOBuscarInformacionProductos): Salida"); 

        return dtoSal;
    }

    public DTOSalida detalleInformacionProducto(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONProductos.detalleInformacionProducto(DTOOID): Entrada"); 
        DTOSalida dtoSal = new DTOSalida();
        DAOMAEProductos dao = new DAOMAEProductos();
        dtoSal = dao.detalleInformacionProducto(dto);
        UtilidadesLog.info("MONProductos.detalleInformacionProducto(DTOOID): Salida"); 
        return dtoSal;
    }

    public DTOSalida obtenerProductosPais2(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerProductosPais2(DTOBelcorp): Entrada"); 
        DAOMAEProductos daoProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        DTOSalida dtoS = new DTOSalida();
        dtoS.setResultado(daoProductos.obtenerProductosPais(dto));
        UtilidadesLog.info("MONProductos.obtenerProductosPais2(DTOBelcorp): Salida"); 

        return dtoS;
    }

/**
     * @author pperanzola
     * @date 06/09/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return String
     * @param dto
     * select codigoUnicoVenta 
        from MaestroDeProductos 
        where 
        OIDProducto = dto.oid 
        devolver el codigoUnicoVenta.

     */
    public String obtenerCUV(DTOOID dto) throws MareException  {
        UtilidadesLog.info("MONProductos.obtenerCUV(DTOOID): Entrada"); 
        BelcorpService bs;
        RecordSet resultado = new RecordSet();
        bs = UtilidadesEJB.getBelcorpService();
        String retorno = null;

        try {
            StringBuffer query = new StringBuffer();
            query.append(" SELECT ");
                query.append(" COD_UNIC_VENT ");
            query.append(" FROM ");
                query.append(" MAE_PRODU ");
            query.append(" WHERE ");
            query.append(" OID_PROD = " + dto.getOid());

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
        
        retorno =(String) resultado.getValueAt(0, 0);
        UtilidadesLog.info("MONProductos.obtenerCUV(DTOOID): Entrada"); 
        return retorno;
        
    }
    
        /**
     * 
     * @author pperanzola
     * @date 05/10/2005
     * @throws es.indra.mare.common.exception.MareException
     * @return DTOSalida
     * @param dto
     * se crea segun  GCC-PRE-MAE-INT-001 
     * Descripcion: Hace una llamada al DAO para obetenr los valores para cargar en la combo Implementación 
     * Llamar al método DAOMAEProductos.obtenerProgramasFidelizacion(dto) y se obtiene un Recorset 
        Crear dtos del tipo DTOSalida y a dtos.resultado asignarle el recorset obtenido 
        Devolver dtos 
     * 
     */
    public DTOSalida obtenerProgramasFidelizacion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONProductos.obtenerProgramasFidelizacion(DTOBelcorp dto):Entrada");
        DAOMAEProductos daoMaeProd = new DAOMAEProductos();
        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(daoMaeProd.obtenerProgramasFidelizacion(dto));
        UtilidadesLog.info("MONProductos.obtenerProgramasFidelizacion(DTOBelcorp dto):Salida");
        return dtos;
        
    }


}
