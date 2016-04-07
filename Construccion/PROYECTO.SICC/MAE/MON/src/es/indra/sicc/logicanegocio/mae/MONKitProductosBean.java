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
import es.indra.mare.common.mii.services.ejbservice.*;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.i18n.MONI18nBean;
import es.indra.sicc.cmn.negocio.i18n.MONI18nHome;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.mae.DTOBusquedaKit;
import es.indra.sicc.dtos.mae.DTOBusquedaPeriodos;
import es.indra.sicc.dtos.mae.DTOCombosKit;
import es.indra.sicc.dtos.mae.DTOConsultaKit;
import es.indra.sicc.dtos.mae.DTOKit;
import es.indra.sicc.dtos.mae.DTOKitModificar;
import es.indra.sicc.dtos.mae.DTOProductoKit;
import es.indra.sicc.dtos.seg.DTOInternacional;
import es.indra.sicc.entidades.mae.KitProductosLocal;
import es.indra.sicc.entidades.mae.KitProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalle;
import es.indra.sicc.logicanegocio.bel.MONGestionFormasPagoDetalleHome;
import es.indra.sicc.logicanegocio.cra.DAOCRA;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.util.*;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesI18N;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONKitProductosBean implements SessionBean {
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

    public DTOCombosKit rellenarCombos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerTasasImpuesto(DTOBelcorp): Entrada"); 
        DTOCombosKit dtoCombosKit = new DTOCombosKit();
        RecordSet recordAux = null;
        RecordSet record = new RecordSet();

        try {
            // Mantenimiento SEG            
            UtilidadesLog.debug("Mantenimiento SEG...");

            MONMantenimientoSEG seg = SEGEjbLocators.getMONMantenimientoSEGHome().create();
            DAOMAEProductos daoMAEProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
            MONGestionFormasPagoDetalle monBel = this.getMONGestionFormasPagoDetalle().create();

            UtilidadesLog.debug("            // Marcas ");
            dtoCombosKit.setMarcas(seg.recuperarMarcas(dto).getResultado());

            UtilidadesLog.debug("            // Canales ");
            recordAux = seg.recuperarCanales(dto, Boolean.TRUE).getResultado();
            dtoCombosKit.setCanales(obtenerColumnasRecordSet(new String[] {
                        "VAL_OID", "VAL_I18N", "TIPE_OID_TIPO_PERI"
                    }, recordAux));

            UtilidadesLog.debug("            // Unidades de Negocio ");
            dtoCombosKit.setUnidadesNegocio(daoMAEProductos.buscarUnidadesNegocioPorPais(dto));

            UtilidadesLog.debug("            // Negocio ");
            dtoCombosKit.setNegocio(daoMAEProductos.buscarNegocioPorPais(dto));

            UtilidadesLog.debug("            // Unidades de Medida ");
            dtoCombosKit.setUnidadesMedida(daoMAEProductos.buscarUnidadesMedidaPorPais(dto));

            UtilidadesLog.debug("            // Estatus ");
            dtoCombosKit.setEstatus(daoMAEProductos.buscarEstatusPorPais(dto));

            UtilidadesLog.debug("            // Genericos ");
            dtoCombosKit.setGenericos(daoMAEProductos.buscarGenericosPorPais(dto));

            UtilidadesLog.debug("            // Supergenericos ");
            dtoCombosKit.setSupergenericos(daoMAEProductos.buscarSuperGenericoPorPais(dto));

            UtilidadesLog.debug("            // Lineas ");
            dtoCombosKit.setLineas(daoMAEProductos.buscarLineasProductoPorPais(dto));

            UtilidadesLog.debug("			// FormasPago ");
            dtoCombosKit.setFormasPago(monBel.obtenerFormasPagoPorPais(dto));
        } catch (RemoteException re) {
            re.printStackTrace();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            ce.printStackTrace();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(dtoCombosKit);
        UtilidadesLog.info("MONKitProductos.obtenerTasasImpuesto(DTOBelcorp): Salida"); 

        return dtoCombosKit;
    }

    private RecordSet obtenerColumnasRecordSet(String[] nombresCol, RecordSet recordSetEntrada) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerColumnasRecordSet(nombresCol,recordSetEntrada ): Entrada"); 
        RecordSet record = (RecordSet) UtilidadesBelcorp.deepCopy(recordSetEntrada);
        int borrar = 1;

        // Obtengo todas las columnas del recordSet y borro las que no solicitan
        for (int i = 0; i < recordSetEntrada.getColumnCount(); i++) {
            borrar = 1;

            for (int j = 0; j < nombresCol.length; j++) {
                if (nombresCol[j].equals(recordSetEntrada.getColumnName(i))) {
                    borrar = 0;

                    break;
                }
            }

            if (borrar == 1) {
                record.removeColumn(record.findColumn(recordSetEntrada.getColumnName(i)));
            }
        }
        UtilidadesLog.info("MONKitProductos.obtenerColumnasRecordSet(nombresCol,recordSetEntrada ): Salida"); 

        return record;
    }

    public DTOSalida buscarPeriodos(DTOBusquedaPeriodos dto) throws MareException {
        UtilidadesLog.info("MONKitProductos.buscarPeriodos(DTOBusquedaPeriodos ): Entrada"); 

        DTOSalida dtoSalida = new DTOSalida();

        DAOCRA daoCRA = new DAOCRA();

        RecordSet recordAux = daoCRA.obtienePeriodoPorTipo(dto.getOidPais(), dto.getMarca(), dto.getCanal(), dto.getTipoPeriodo());

        dtoSalida.setResultado(obtenerColumnasRecordSet(new String[] {
                    "OID_PERI", "VAL_NOMB_PERI"
                }, recordAux));
        UtilidadesLog.info("MONKitProductos.buscarPeriodos(DTOBusquedaPeriodos ): Salida"); 
        return dtoSalida;
    }

    public void inserta(DTOKit dtoKit) throws RemoteException, MareException {
        UtilidadesLog.info("MONKitProductos.inserta(DTOKit): Entrada"); 
        MaestroProductosPK mpPK = null;
        MaestroProductosLocal localMP = null;
        MONValidacion monValidacion;
        Boolean valido;

        try {
            monValidacion = this.getMONValidacionHome().create();
            UtilidadesLog.debug("insertar kit 1");

            valido = monValidacion.validarAccesos(dtoKit.getOidPais(), null, dtoKit.getMarca(), dtoKit.getCanal(), null, null, null, null, null, null, null);

            if (!valido.booleanValue()) {
                UtilidadesLog.debug("valido.booleanValue = false");
                ctx.setRollbackOnly();
                throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }
        } catch (CreateException ce) {
            UtilidadesLog.error("error: " + ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error("error: " + re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug("insertar kit 2");

        DAOMAEProductos daoProducto = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        Long oidProM = null;
        Long oidProK = null;
        oidProM = daoProducto.validarCodigoProducto(dtoKit.getCodSAP(), dtoKit.getOidPais());
        UtilidadesLog.debug("insertar kit 3 - oidProM=" + oidProM);

        if (oidProM == null) {
            MaestroProductosLocalHome localHome = MAEEjbLocators.getMaestroProductosLocalHome();
            localHome.parametrosAuditoria(dtoKit);

            //localHome.create(oid va nulo, codSAP, pais);
            try {
                UtilidadesLog.debug("insertar kit 3.1");

                UtilidadesLog.debug("dtoKit.getCodSAP(): " + dtoKit.getCodSAP());
                UtilidadesLog.debug("dtoKit.getOidPais(): " + dtoKit.getOidPais());
                UtilidadesLog.debug("dtoKit.getDescSapI18n(): " + dtoKit.getDescSapI18n());

                //                    UtilidadesLog.debug("dtoKit.getMarca(): " + );
                MaestroProductosLocal local = localHome.create(dtoKit.getCodSAP(), dtoKit.getOidPais(), dtoKit.getDescSapI18n(), null);

                //agregado
                MONI18nHome monI18nH = CMNEjbLocators.getMONI18nHome();
                MONI18n monI18n = monI18nH.create();
                monI18n.actualizaTraducciones(new String("MAE_PRODU"), local.getOid(), dtoKit.getDescSapI18n());

                //hasta aca
                UtilidadesLog.debug("insertar kit 4");

                local.setIndProductoServicio(dtoKit.getProductoServicio());
                local.setEsKit(Boolean.TRUE);
                local.setCodigoAntiguo(dtoKit.getCodAntiguo());
                local.setDescripcionCorta(dtoKit.getDescCorta());
                local.setEsLote(dtoKit.getIndLote());
                local.setMarcaProducto(dtoKit.getMarca());

                local.setUnidadNegocio(dtoKit.getUnidadNegocio());
                local.setNegocio(dtoKit.getNegocio());
                local.setGenerico(dtoKit.getGenerico());
                local.setSuperGenerico(dtoKit.getSupergenerico());
                local.setJerarquia1(dtoKit.getJerarquia1());
                local.setJerarquia2(dtoKit.getJerarquia2());
                local.setJerarquia3(dtoKit.getJerarquia3());
                local.setLineaDeProducto(dtoKit.getLineaProducto());
                local.setAtributo1(dtoKit.getAtributo1());
                local.setAtributo2(dtoKit.getAtributo2());
                local.setAtributo3(dtoKit.getAtributo3());
                local.setAlto(dtoKit.getAlto());
                local.setAncho(dtoKit.getAncho());
                local.setLargo(dtoKit.getLargo());
                local.setGrupoArticulos(dtoKit.getGrupoArticulos());
                local.setUnidadMedidaDimensiones(dtoKit.getUnidMedidaDimensiones());
                local.setVolumen(dtoKit.getVolumen());
                local.setUnidadMedidaVolumen(dtoKit.getUnidMedidaVolumen());
                local.setPeso(dtoKit.getPeso());
                local.setUnidadMedidaPeso(dtoKit.getUnidMedidaPeso());
                local.setUnidadesDentroPedido(dtoKit.getUnidDentroPedido());
                local.setUnidadesCaja(dtoKit.getUnidPorCaja());
                local.setCosteEstandard(dtoKit.getCosteEstandar());
                local.setPrecioPosicionamiento(dtoKit.getPrecioPosicionamiento());

                if (dtoKit.getSituacion() != null) {
                    local.setSituacion(dtoKit.getSituacion().toString());
                }

                if (dtoKit.getCajaBolsa() != null) {
                    local.setIndCajaBolsa(dtoKit.getCajaBolsa().toString());
                }

                local.setStatus(dtoKit.getEstatus());
                local.setFormaPago(dtoKit.getFormaPago());
                local.setCodigoImpuesto(dtoKit.getCodImpuesto());
                local.setPrecioCatalogo(dtoKit.getPrecioCatalogo());
                local.setPrecioContable(dtoKit.getPrecioContable());
                local.setPorcentajeUnidades(dtoKit.getPorcentajeUnidades());
                local.setPeriodoInicio(dtoKit.getPeriodoInicio());
                local.setPeriodoFin(dtoKit.getPeriodoFin());
                local.setGrupoArticulos(dtoKit.getGrupoArticulos());

                /*Para cada DTOProductoKit que tengamos en el atributo productos {
                Llamamos a validarCodigoProducto del DAOMAEProducto pasandole el atributo producto del DTOProductoKit y obtenemos el oid del producto
                si el oid de producto obtenido es null {
                marcamos la transaccion como rollback
                lanzamos una MareException con el código de error MAE-0023 (El producto que desea añadir al kit no existe: )y le anexamos el atributo producto
                }
                llamamos al create de KitProductos con los siguientes parametros:
                -productoPrincipal: el oid de la entidad MaestroProductos anteriormente
                -productoAdicional: el oid de producto obtenido de la llamada a validarCodigoProducto
                -numeroUnidades: el atributo numUnidades del dto
                }
                */
                DTOProductoKit dtoProduKit;
                ArrayList al = dtoKit.getProductos();

                if (al != null) {
                    UtilidadesLog.debug("insertar kit 5");

                    for (int i = 0; i < al.size(); i++) {
                        dtoProduKit = (DTOProductoKit) al.get(i);
                        oidProK = daoProducto.validarCodigoProducto(dtoProduKit.getProducto(), dtoKit.getOidPais());
                        UtilidadesLog.debug("insertar kit 5." + i);

                        if (oidProK != null) {
                            // VAlidación de kit
                            UtilidadesLog.debug("trza 1");
                            mpPK = new MaestroProductosPK(oidProK);

                            try {
                                localMP = localHome.findByPrimaryKey(mpPK);
                                UtilidadesLog.debug("trza 2");
                            } catch (FinderException d) {
                                //Seguro que lo encuentra porque exista, se valida arriba
                            }

                            if ((localMP.getEsKit() != null) && localMP.getEsKit().booleanValue()) {
                                UtilidadesLog.debug("trza 3");
                                ctx.setRollbackOnly();

                                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_YA_FORMA_KIT));

                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(dtoProduKit.getProducto());
                                UtilidadesLog.debug("trza 4");
                                throw ex;

                                /*                              throw new MareException(new MareException(), UtilidadesError.armarCodigoError(
                                                                  CodigosModulos.MAE, "",ErroresDeNegocio.PRODUCTO_YA_FORMA_KIT));  */
                            }

                            // validación de producto activo
                            UtilidadesLog.debug("trza 5");

                            if ((localMP.getSituacion() == null) || (!localMP.getSituacion().equals(ConstantesMAE.PRODUCTO_ACTIVO))) {
                                ctx.setRollbackOnly();

                                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_NO_ACTIVO));

                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(dtoProduKit.getProducto());
                                UtilidadesLog.debug("trza 6");
                                throw ex;

                                //throw new MareException(new MareException(), UtilidadesError.armarCodigoError(
                                //    CodigosModulos.MAE, "",ErroresDeNegocio.PRODUCTO_NO_ACTIVO));
                            }

                            UtilidadesLog.debug("trza 7");

                            KitProductosLocalHome localHomKit = new KitProductosLocalHome();

                            //KitProductosLocal localKit = localHomKit.create(dtoProduKit.getOidProducto(), oidProK);
                            KitProductosLocal localKit = localHomKit.create(oidProK, local.getOid());
                            UtilidadesLog.debug("insertar kit 6." + i);
                            localKit.setNumeroUnidades(dtoProduKit.getNumUnidades());
                        } else {
                            //marcamos la transaccion como rollback 
                            //lanzamos una MareException con el código de error MAE-0023 
                            //(El producto que desea añadir al kit no existe: )y le anexamos el atributo producto
                            ctx.setRollbackOnly();

                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE));
                            ex.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                            ex.addParameter(dtoProduKit.getProducto());

                                                   UtilidadesLog.debug("error: PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE");
                            throw ex;

                            /*                              throw new ExcepcionParametrizada(ErroresDeNegocio.PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE,
                                                                                 UtilidadesError.armarCodigoError(CodigosModulos.MAE, "",ErroresDeNegocio.PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE) );*/

                            //                            throw new MareException(new MareException(), UtilidadesError.armarCodigoError(
                            //                                CodigosModulos.MAE, "",ErroresDeNegocio.PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE)); 
                        }
                    }
                }

                UtilidadesLog.debug("insertar kit 8");
            } catch (CreateException e) {
                UtilidadesLog.error("insertar kit create exception");
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } else {
            //tirar mare exception MAE-0021 (El codigo SAP introducido ya existe). 
            UtilidadesLog.debug("exception CODIGO_SAP_INEXISTENTE");
            ctx.setRollbackOnly();
            throw new MareException(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.CODIGO_SAP_INTRODUCIDO_YA_EXISTE));
        }
        UtilidadesLog.info("MONKitProductos.inserta(DTOKit): Salida"); 
    }

    public DTOSalida busquedaPorCriterios(DTOBusquedaKit criterios) throws MareException {
        UtilidadesLog.info("MONKitProductos.busquedaPorCriterios(DTOBusquedaKit): Entrada"); 
        DAOMAEProductos objDao = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        DTOSalida dtoOut = new DTOSalida();
        dtoOut = objDao.buscarKitsPorCriterios(criterios);
        UtilidadesLog.info("MONKitProductos.busquedaPorCriterios(DTOBusquedaKit): Salida"); 
        return dtoOut;
    }

    public DTOConsultaKit consultar(DTOOID dto) throws MareException {
        /*
        Con el oid del dto se llama al método consultarKit de DAOMAEProductos
        y devolvemos el dto que obtenemos de la llamada
        */
        UtilidadesLog.info("MONKitProductos.consultar(DTOOID): Entrada"); 
        DAOMAEProductos objDao = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        DTOConsultaKit dtoOut = new DTOConsultaKit();
        dtoOut = objDao.consultarKit(dto);
        UtilidadesLog.info("MONKitProductos.consultar(DTOOID): Salida"); 

        return dtoOut;
    }

    public void actualiza(DTOKit dtoKit) throws RemoteException, MareException {
        UtilidadesLog.info("MONKitProductos.actualiza(DTOKit): Entrada"); 
        MaestroProductosPK mpPK = null;
        MaestroProductosLocal localMP = null;
        MONValidacion monValidacion;
        Boolean valido;

        try {
            monValidacion = this.getMONValidacionHome().create();

            valido = monValidacion.validarAccesos(dtoKit.getOidPais(), null, dtoKit.getMarca(), dtoKit.getCanal(), null, null, null, null, null, null, null);

            if (!valido.booleanValue()) {
                UtilidadesLog.debug("valido.booleanValue");
                throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
            }
        } catch (CreateException ce) {
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        /*
         * Con el oid del dto buscamos la entidad a actualizar con MaestroClientes.findByPrimaryKey con el oid del DTO, luego ponemos los valores
         * que hemos recibido en el dto; excepto los atributos canal, marca, tipoPeriodo y productos
         * */
        DAOMAEProductos daoProducto = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        MaestroProductosLocalHome localHome = MAEEjbLocators.getMaestroProductosLocalHome();
        localHome.parametrosAuditoria(dtoKit);

        Long oidProK = null;

        try {
            MaestroProductosPK maestroProduPK = new MaestroProductosPK(dtoKit.getOid());
            MaestroProductosLocal local = localHome.findByPrimaryKey(maestroProduPK);

            local.setTraducciones(dtoKit.getDescSapI18n());
            local.setIndProductoServicio(dtoKit.getProductoServicio());
            local.setEsKit(Boolean.TRUE);
            local.setCodigoAntiguo(dtoKit.getCodAntiguo());
            local.setDescripcionCorta(dtoKit.getDescCorta());
            local.setEsLote(dtoKit.getIndLote());
            local.setMarcaProducto(dtoKit.getMarca());

            local.setUnidadNegocio(dtoKit.getUnidadNegocio());
            local.setNegocio(dtoKit.getNegocio());
            local.setGenerico(dtoKit.getGenerico());
            local.setSuperGenerico(dtoKit.getSupergenerico());
            local.setJerarquia1(dtoKit.getJerarquia1());
            local.setJerarquia2(dtoKit.getJerarquia2());
            local.setJerarquia3(dtoKit.getJerarquia3());
            local.setLineaDeProducto(dtoKit.getLineaProducto());
            local.setAtributo1(dtoKit.getAtributo1());
            local.setAtributo2(dtoKit.getAtributo2());
            local.setAtributo3(dtoKit.getAtributo3());
            local.setAlto(dtoKit.getAlto());
            local.setAncho(dtoKit.getAncho());
            local.setLargo(dtoKit.getLargo());
            local.setGrupoArticulos(dtoKit.getGrupoArticulos());
            local.setUnidadMedidaDimensiones(dtoKit.getUnidMedidaDimensiones());
            local.setVolumen(dtoKit.getVolumen());
            local.setUnidadMedidaVolumen(dtoKit.getUnidMedidaVolumen());
            local.setPeso(dtoKit.getPeso());
            local.setUnidadMedidaPeso(dtoKit.getUnidMedidaPeso());
            local.setUnidadesDentroPedido(dtoKit.getUnidDentroPedido());
            local.setUnidadesCaja(dtoKit.getUnidPorCaja());
            local.setCosteEstandard(dtoKit.getCosteEstandar());
            local.setPrecioPosicionamiento(dtoKit.getPrecioPosicionamiento());

            if (dtoKit.getSituacion() != null) {
                local.setSituacion(dtoKit.getSituacion().toString());
            }

            if (dtoKit.getCajaBolsa() != null) {
                local.setIndCajaBolsa(dtoKit.getCajaBolsa().toString());
            }

            local.setStatus(dtoKit.getEstatus());
            local.setFormaPago(dtoKit.getFormaPago());
            local.setCodigoImpuesto(dtoKit.getCodImpuesto());
            local.setPrecioCatalogo(dtoKit.getPrecioCatalogo());
            local.setPrecioContable(dtoKit.getPrecioContable());
            local.setPorcentajeUnidades(dtoKit.getPorcentajeUnidades());
            local.setPeriodoInicio(dtoKit.getPeriodoInicio());
            local.setPeriodoFin(dtoKit.getPeriodoFin());
            local.setGrupoArticulos(dtoKit.getGrupoArticulos());

            /*
            Actualizamos las entidades KitProductos de la siguiente forma:
            -Llamamos al metodo vaciarProductosKit del home del entity KitProductos pasandole el oid del dto.
            -Creamos una entidad KitProducto por cada producto que contenga el array productos {
            Si el atributo oidProducto es null {
            Llamamos a validarCodigoProducto del DAOMAEProducto pasandole el atributo producto del DTOProductoKit y obtenemos el oid del producto
            si el oid de producto obtenido es null {
            marcamos la transaccion como rollback
            lanzamos una MareException con el código de error MAE-0023 (El producto que desea añadir al kit no existe: )y le anexamos el atributo producto
            }
            */
            DTOProductoKit dtoProduKit;
            KitProductosLocal localKit;
            ArrayList al = dtoKit.getProductos();

            KitProductosLocalHome localHomeK = new KitProductosLocalHome();

            localHomeK.vaciarProductosKit(dtoKit.getOid());

            if ((al != null) && !al.isEmpty()) {
                dtoProduKit = (DTOProductoKit) al.get(0);

                for (int i = 0; i < al.size(); i++) {
                    dtoProduKit = (DTOProductoKit) al.get(i);

                    if (dtoProduKit.getOidProducto() != null) {
                        /*
                         * Primero producto asociado luego producto principal
                         */
                        localKit = localHomeK.create(dtoProduKit.getOidProducto(), dtoKit.getOid());
                        localKit.setNumeroUnidades(dtoProduKit.getNumUnidades());
                        try {
                            localHomeK.merge(localKit);
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                        }
                    } else {
                        oidProK = daoProducto.validarCodigoProducto(dtoProduKit.getProducto(), dtoKit.getOidPais());

                        if (oidProK != null) {
                            // VAlidación de kit
                            mpPK = new MaestroProductosPK(oidProK);

                            try {
                                localMP = localHome.findByPrimaryKey(mpPK);
                            } catch (NoResultException d) {
                                //Seguro que lo encuentra porque exista, se valida arriba
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                            }

                            if ((localMP.getEsKit() != null) && localMP.getEsKit().booleanValue()) {
                                ctx.setRollbackOnly();

                                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_YA_FORMA_KIT));
                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(dtoProduKit.getProducto());
                                throw ex;
                            }

                            // validación de producto activo
                            if ((localMP.getSituacion() == null) || (!localMP.getSituacion().equals(ConstantesMAE.PRODUCTO_ACTIVO))) {
                                ctx.setRollbackOnly();

                                ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_NO_ACTIVO));
                                ex.setPosicion(ExcepcionParametrizada.POSICION_MEDIO);
                                ex.addParameter(dtoProduKit.getProducto());
                                throw ex;
                            }

                            localKit = localHomeK.create(oidProK, dtoKit.getOid());
                            localKit.setNumeroUnidades(dtoProduKit.getNumUnidades());
                            try {
                                localHomeK.merge(localKit);
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                            }
                        } else {
                            ctx.setRollbackOnly();
                            ExcepcionParametrizada ex = new ExcepcionParametrizada(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.PRODUCTO_QUE_DESEA_ANADIR_AL_KIT_NO_EXISTE));
                            ex.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                            ex.addParameter(dtoProduKit.getProducto());
                            throw ex;
                        }
                    }
                }
            }
        } catch (FinderException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONKitProductos.actualiza(DTOKit): Salida"); 
    }

    public DTOKitModificar obtenerKit(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerKit(DTOOID): Entrada"); 
        DTOKitModificar dtoKitModificar = new DTOKitModificar();
        Collection productos;
        Long oidProK = null;
        MaestroProductosLocalHome localHome = MAEEjbLocators.getMaestroProductosLocalHome();
        localHome.parametrosAuditoria(dto);

        try {
            //UtilidadesLog.debug("--Comienzo--");
            MaestroProductosPK maestroProduPK = new MaestroProductosPK(dto.getOid());

            //UtilidadesLog.debug("--Finder findByPrimaryKey--");
            MaestroProductosLocal localMaestroProductos = localHome.findByPrimaryKey(maestroProduPK);
            DTOKit dtoKit = new DTOKit();
            dtoKit.setProductoServicio(localMaestroProductos.getIndProductoServicio());

            //UtilidadesLog.debug("--CODIGO SAP = " + localMaestroProductos.getCodigoSAP() + "--");
            dtoKit.setCodSAP(localMaestroProductos.getCodigoSAP());

            // obtenemos valor de DescripcionSAP de tabla internalizacion.
            /* BELC300007133 - gPineda cdos 15/08/06
             * El atributo i18n no es obligatorio, se cambia para que devuelva "" si no lo encuentra. */
            //dtoKit.setDescSAP(obtenerDescrSAPByOID(dto.getOid(), dto.getOidIdioma()).getValueAt(0, 0).toString());
            RecordSet rs = obtenerDescrSAPByOID( dto.getOid(), dto.getOidIdioma() );
            if( rs.esVacio() ){
              dtoKit.setDescSAP("");
            }else{
              dtoKit.setDescSAP( rs.getValueAt(0, 0).toString() );
            }
            
            dtoKit.setCodAntiguo(localMaestroProductos.getCodigoAntiguo());
            dtoKit.setDescCorta(localMaestroProductos.getDescripcionCorta());
            dtoKit.setIndLote(localMaestroProductos.getEsLote());
            dtoKit.setUnidadNegocio(localMaestroProductos.getUnidadNegocio());
            dtoKit.setNegocio(localMaestroProductos.getNegocio());
            dtoKit.setGenerico(localMaestroProductos.getGenerico());
            dtoKit.setSupergenerico(localMaestroProductos.getSuperGenerico());
            dtoKit.setJerarquia1(localMaestroProductos.getJerarquia1());
            dtoKit.setJerarquia2(localMaestroProductos.getJerarquia2());
            dtoKit.setJerarquia3(localMaestroProductos.getJerarquia3());
            dtoKit.setLineaProducto(localMaestroProductos.getLineaDeProducto());
            dtoKit.setAtributo1(localMaestroProductos.getAtributo1());
            dtoKit.setAtributo2(localMaestroProductos.getAtributo2());
            dtoKit.setAtributo3(localMaestroProductos.getAtributo3());
            dtoKit.setAlto(localMaestroProductos.getAlto());
            dtoKit.setAncho(localMaestroProductos.getAncho());
            dtoKit.setLargo(localMaestroProductos.getLargo());
            UtilidadesLog.debug("######################################################");
            UtilidadesLog.debug("Esta es la jerarquia: " + localMaestroProductos.getJerarquia1());
            UtilidadesLog.debug("Este es el grupo Articulo!!!! " + localMaestroProductos.getGrupoArticulos());
            UtilidadesLog.debug("######################################################");
            UtilidadesLog.debug("######################################################");
            dtoKit.setGrupoArticulos(localMaestroProductos.getGrupoArticulos());
            dtoKit.setUnidMedidaDimensiones(localMaestroProductos.getUnidadMedidaDimensiones());
            dtoKit.setVolumen(localMaestroProductos.getVolumen());
            dtoKit.setUnidMedidaVolumen(localMaestroProductos.getUnidadMedidaVolumen());
            dtoKit.setPeso(localMaestroProductos.getPeso());
            dtoKit.setUnidMedidaPeso(localMaestroProductos.getUnidadMedidaPeso());
            dtoKit.setUnidDentroPedido(localMaestroProductos.getUnidadesDentroPedido());
            dtoKit.setUnidPorCaja(localMaestroProductos.getUnidadesCaja());
            dtoKit.setCosteEstandar(localMaestroProductos.getCosteEstandard());
            dtoKit.setPrecioPosicionamiento(localMaestroProductos.getPrecioPosicionamiento());

            if (localMaestroProductos.getSituacion() != null) {
                dtoKit.setSituacion(new Character(localMaestroProductos.getSituacion().charAt(0)));
            }

            if (localMaestroProductos.getIndCajaBolsa() != null) {
                dtoKit.setCajaBolsa(new Character(localMaestroProductos.getIndCajaBolsa().charAt(0)));
            }

            dtoKit.setEstatus(localMaestroProductos.getStatus());
            dtoKit.setFormaPago(localMaestroProductos.getFormaPago());
            dtoKit.setCodImpuesto(localMaestroProductos.getCodigoImpuesto());
            dtoKit.setPrecioCatalogo(localMaestroProductos.getPrecioCatalogo());
            dtoKit.setPrecioContable(localMaestroProductos.getPrecioContable());
            dtoKit.setPorcentajeUnidades(localMaestroProductos.getPorcentajeUnidades());
            dtoKit.setPeriodoInicio(localMaestroProductos.getPeriodoInicio());
            dtoKit.setPeriodoFin(localMaestroProductos.getPeriodoFin());
            dtoKit.setMarca(localMaestroProductos.getMarcaProducto());

            KitProductosLocalHome localHomeKitProductos = new KitProductosLocalHome();
            productos = localHomeKitProductos.findByKitOid(dto.getOid());

            DTOProductoKit dtoProductoKit;
            ArrayList al = new ArrayList();
            Iterator it = productos.iterator();

            while (it.hasNext()) {
                KitProductosLocal kitPsL = (KitProductosLocal) it.next();
                dtoProductoKit = new DTOProductoKit();
                dtoProductoKit.setOidProducto(kitPsL.getProductoAdicional());
                dtoProductoKit.setNumUnidades(kitPsL.getNumeroUnidades());
                maestroProduPK = new MaestroProductosPK(kitPsL.getProductoAdicional());

                MaestroProductosLocal MaestroProductosCodSAP = localHome.findByPrimaryKey(maestroProduPK);
                dtoProductoKit.setProducto(MaestroProductosCodSAP.getCodigoSAP());
                al.add(dtoProductoKit);
            }

            dtoKit.setProductos(al);

            if (localMaestroProductos.getPeriodoInicio() != null) {
                RecordSet rs_args = obtenerMCTPPorPeriodo(localMaestroProductos.getPeriodoInicio());

                if (rs_args.getValueAt(0, 0) != null) {
                    dtoKit.setMarcaPeriodo(new Long(((BigDecimal) rs_args.getValueAt(0, 0)).longValue()));
                }

                if (rs_args.getValueAt(0, 1) != null) {
                    dtoKit.setCanal(new Long(((BigDecimal) rs_args.getValueAt(0, 1)).longValue()));
                }

                if (rs_args.getValueAt(0, 2) != null) {
                    dtoKit.setTipoPeriodo(new Long(((BigDecimal) rs_args.getValueAt(0, 2)).longValue()));
                }
            }

            /*
             * Busco periodos
             */
            DTOBusquedaPeriodos dtoBusquedaPeriodos = new DTOBusquedaPeriodos();
            dtoBusquedaPeriodos.setMarca(dtoKit.getMarcaPeriodo());
            dtoBusquedaPeriodos.setCanal(dtoKit.getCanal());
            dtoBusquedaPeriodos.setTipoPeriodo(dtoKit.getTipoPeriodo());
            dtoBusquedaPeriodos.setOidPais(dto.getOidPais());

            DTOSalida dtos = buscarPeriodos(dtoBusquedaPeriodos);

            //----------------- DTOKitModificar --------------//
            dtoKitModificar.setPeriodos(dtos.getResultado());
            dtoKitModificar.setDatos(dtoKit);
        } catch (FinderException e) {
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONKitProductos.obtenerKit(DTOOID): Salida"); 

        return dtoKitModificar;
    }

    private RecordSet obtenerMCTPPorPeriodo(Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerMCTPPorPeriodo(oidPeriodo): Entrada"); 
        StringBuffer query = new StringBuffer();

        try {
            query.append(" select a.MARC_OID_MARC, ");
            query.append(" a.CANA_OID_CANA, ");
            query.append(" b.TIPE_OID_TIPO_PERI ");
            query.append(" from CRA_PERIO a, SEG_CANAL b ");
            query.append(" where a.CANA_OID_CANA = b.OID_CANA ");
            query.append(" and OID_PERI = " + oidPeriodo);
            
            UtilidadesLog.info("MONKitProductos.obtenerMCTPPorPeriodo(oidPeriodo): Salida"); 

            return BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private RecordSet obtenerDescrSAPByOID(Long oid, Long idioma) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerDescrSAPByOID(oid, idioma): Entrada"); 
        StringBuffer query = new StringBuffer();

        try {
            query.append(" select val_i18n ");
            query.append(" from v_gen_i18n_sicc ");
            query.append(" where attr_enti = 'MAE_PRODU' ");
            query.append(" and attr_num_atri = 1 ");
            query.append(" and idio_oid_idio = " + idioma);
            query.append(" and val_oid = " + oid);
            
            UtilidadesLog.info("MONKitProductos.obtenerDescrSAPByOID(oid, idioma): Salida"); 

            return BelcorpService.getInstance().dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            String codigoError = CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {
        UtilidadesLog.info("MONKitProductos.getMaestroProductosLocalHome(): Entrada"); 
        EJBLocator ejbLocator;
        MaestroProductosLocalHome maestroProductosLocalHome = null;
        BelcorpService belcorpService = null;

        try {
            belcorpService = BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException serviceNotFoundException) {
            ctx.setRollbackOnly();
            throw new MareException(serviceNotFoundException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }

        try {
            maestroProductosLocalHome = (MaestroProductosLocalHome) belcorpService.ejbLocator.getEntityLocalHome("java:comp/env/MaestroProductos");
        } catch (MareServiceException mareServiceException) {
            ctx.setRollbackOnly();
            throw new MareException(mareServiceException, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONKitProductos.getMaestroProductosLocalHome(): Salida"); 

        return maestroProductosLocalHome;
    }

    /* private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException {
         final InitialContext context = new InitialContext();
         return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
     }

     private KitProductosLocalHome getKitProductosLocalHome() throws NamingException {
         final InitialContext context = new InitialContext();
         return (KitProductosLocalHome)context.lookup("java:comp/env/KitProductos");
     }
    */
    private MONGestionFormasPagoDetalleHome getMONGestionFormasPagoDetalle() throws MareException {
        UtilidadesLog.info("MONKitProductos.getMONGestionFormasPagoDetalle(): Entrada"); 
        MONGestionFormasPagoDetalleHome localHome = (MONGestionFormasPagoDetalleHome) UtilidadesEJB.getHome("MONGestionFormasPagoDetalle", MONGestionFormasPagoDetalleHome.class);
        UtilidadesLog.info("MONKitProductos.getMONGestionFormasPagoDetalle(): Salida"); 

        return localHome;
    }

    private MONValidacionHome getMONValidacionHome() throws MareException {
        UtilidadesLog.info("MONKitProductos.getMONValidacionHome(): Entrada"); 
        MONValidacionHome localHome = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion", MONValidacionHome.class);
        UtilidadesLog.info("MONKitProductos.getMONValidacionHome(): Salida"); 
        return localHome;
    }

    /**
       * metodo usado para cargar un combo de marca producto
       * fecha: 01/04/2005
       * mdolce
       * param DTOBelcorp
       * return DTOSalida
       * */
    public DTOSalida obtenerMarcaProducto(DTOBelcorp dtoin) throws MareException {
        UtilidadesLog.info("MONKitProductos.obtenerMarcaProducto(DTOBelcorp): Entrada"); 
        DAOMAEProductos dao = new DAOMAEProductos();
        UtilidadesLog.info("MONKitProductos.obtenerMarcaProducto(DTOBelcorp): Salida"); 

        return dao.obtenerMarcaProducto(dtoin);
    }
}
