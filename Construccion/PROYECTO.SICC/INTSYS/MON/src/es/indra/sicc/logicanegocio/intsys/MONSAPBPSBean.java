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
package es.indra.sicc.logicanegocio.intsys;

import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.enterprise.mln.BusinessFacadeLocalHome;

import es.indra.sicc.cmn.negocio.batch.DTOBatch;
import es.indra.sicc.cmn.negocio.batch.DTOSalidaBatch;
import es.indra.sicc.cmn.negocio.batch.util.BatchUtil;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.interfaces.IGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.comun.DTOINTError;
import es.indra.sicc.cmn.negocio.interfaces.comun.IRegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.cmn.negocio.interfaces.comun.RegistroSicc;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfaces;
import es.indra.sicc.cmn.negocio.interfaces.fachada.MONGestorInterfacesHome;
import es.indra.sicc.dtos.intsys.DTODatosPedSAP;
import es.indra.sicc.dtos.intsys.DTOEnviarPedidosSAP;
import es.indra.sicc.dtos.intsys.DTOINT;
import es.indra.sicc.dtos.intsys.DTOINTDemandaAnormal;
import es.indra.sicc.dtos.intsys.DTOINTEstimado;
import es.indra.sicc.dtos.intsys.DTOINTEstimadoFuenteVentas;
import es.indra.sicc.dtos.intsys.DTOINTEstrategia;
import es.indra.sicc.dtos.intsys.DTOINTPantallaSAPBPS;
import es.indra.sicc.dtos.intsys.DTOMaestroRegiones;
import es.indra.sicc.dtos.intsys.DTOMaestroTerritorios;
import es.indra.sicc.dtos.intsys.DTOMaestroZonas;
import es.indra.sicc.dtos.intsys.DTOVentaDiaProducto;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.entidades.bel.AlmacenesLocal;
import es.indra.sicc.entidades.bel.AlmacenesLocalHome;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.intsys.CanalBPSLocal;
import es.indra.sicc.entidades.intsys.CanalBPSLocalHome;
import es.indra.sicc.entidades.intsys.CodigoMedioSAPBPSLocal;
import es.indra.sicc.entidades.intsys.CodigoMedioSAPBPSLocalHome;
import es.indra.sicc.entidades.intsys.FacturacionProyectadaLocal;
import es.indra.sicc.entidades.intsys.FacturacionProyectadaLocalHome;
import es.indra.sicc.entidades.intsys.FuenteVentasPrevistaSAPLocal;
import es.indra.sicc.entidades.intsys.FuenteVentasPrevistaSAPLocalHome;
import es.indra.sicc.entidades.intsys.FuenteVentasRealLocalHome;
import es.indra.sicc.entidades.intsys.FuenteVentasRealVentaAcumuladaLocalHome;
import es.indra.sicc.entidades.intsys.VentaDiaPorProductoLocalHome;
import es.indra.sicc.entidades.intsys.VentasTotalesCampaniaLocal;
import es.indra.sicc.entidades.intsys.VentasTotalesCampaniaLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.TipoClienteLocal;
import es.indra.sicc.entidades.mae.TipoClienteLocalHome;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocal;
import es.indra.sicc.entidades.mav.BPSInterfaceMAVLocalHome;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocal;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocalHome;
import es.indra.sicc.entidades.pre.CatalogoLocal;
import es.indra.sicc.entidades.pre.CatalogoLocalHome;
import es.indra.sicc.entidades.pre.CicloVidaLocal;
import es.indra.sicc.entidades.pre.CicloVidaLocalHome;
import es.indra.sicc.entidades.pre.CondicionPromocionLocal;
import es.indra.sicc.entidades.pre.CondicionPromocionLocalHome;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocal;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocalHome;
import es.indra.sicc.entidades.pre.EstimadosVentaLocal;
import es.indra.sicc.entidades.pre.EstimadosVentaLocalHome;
import es.indra.sicc.entidades.pre.EstrategiaLocal;
import es.indra.sicc.entidades.pre.EstrategiaLocalHome;
import es.indra.sicc.entidades.pre.TipoEstrategiaLocal;
import es.indra.sicc.entidades.pre.TipoEstrategiaLocalHome;
import es.indra.sicc.entidades.pre.TipoOfertaLocal;
import es.indra.sicc.entidades.pre.TipoOfertaLocalHome;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.CanalLocal;
import es.indra.sicc.entidades.seg.CanalLocalHome;
import es.indra.sicc.entidades.seg.EmpresaLocal;
import es.indra.sicc.entidades.seg.EmpresaLocalHome;
import es.indra.sicc.entidades.seg.IdiomaLocal;
import es.indra.sicc.entidades.seg.IdiomaLocalHome;
import es.indra.sicc.entidades.seg.MarcaLocal;
import es.indra.sicc.entidades.seg.MarcaLocalHome;
import es.indra.sicc.entidades.seg.MarcaProductoLocal;
import es.indra.sicc.entidades.seg.MonedaLocal;
import es.indra.sicc.entidades.seg.MonedaLocalHome;
import es.indra.sicc.entidades.seg.PaisLocal;
import es.indra.sicc.entidades.seg.PaisLocalHome;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocal;
import es.indra.sicc.entidades.seg.PeriodoCorporativoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.zon.RegionLocal;
import es.indra.sicc.entidades.zon.RegionLocalHome;
import es.indra.sicc.entidades.zon.ZonaLocal;
import es.indra.sicc.entidades.zon.ZonaLocalHome;
import es.indra.sicc.logicanegocio.intsys.ISAPBPS;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBD;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.math.BigDecimal;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.Cronometrador;

import java.rmi.RemoteException;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Collection;
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
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.entidades.pre.VariantesLocalHome;
import es.indra.sicc.entidades.pre.VariantesLocal;
import es.indra.sicc.entidades.seg.MarcaProductoLocalHome;

import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.logicanegocio.cra.DAOCRA;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


/*
 * rgiorgi - 25/08-2005: se formatea la clase.
 * */
public class MONSAPBPSBean implements SessionBean {
    private SessionContext ctx;
    private DTOINTPantallaSAPBPS dtoe = null;
    private InterfazInfo interfaz = null;
    
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
     * 
     * @inicdencia 22861    se vuelve a utilizar el tipo de estrategia, vuelve para atras la incidencia 22113.
     */
    public void recepcionarArgumentosVenta(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarArgumentosVenta(DTOOID pais): Entrada");

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        String codigoIdioma = null;
        String descripcion = null;
        String estrategia = null;
        Integer factorRepeticion = null;
        Integer argumentoVenta = null;

        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB2, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB1, pais.getOid());

            IdiomaLocalHome idioma = this.getIdiomaLocalHome();
            IdiomaLocal idiomaLocal = null;

            TipoEstrategiaLocalHome tipoHome = this.getTipoEstrategiaLocalHome();
            TipoEstrategiaLocal tipoEstrategiaLocal = null;

            ArgumentoVentaLocalHome argumentoHome = this.getArgumentoVentaLocalHome();
            ArgumentoVentaLocal argumentoLocal = null;

            Entidadi18nLocalHome i18NHome = this.getEntidadi18nLocalHome();
            Entidadi18nLocal i18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                //**********************     ESTRATEGIA     *********************
                estrategia = (String) registro.obtenerCampo(ISAPBPS.SAB1_ESTRATEGIA);
                UtilidadesLog.debug("[cs]Recogemos de fichero---> codigo tipo de Estrategia " + estrategia);

                if ((estrategia != null) && !estrategia.trim().equals("")) {
                    try {
                        UtilidadesLog.debug("[cs]Antes de findByUK DE" + estrategia);
                        tipoEstrategiaLocal = tipoHome.findByUK(estrategia);
                        UtilidadesLog.debug("[cs]Despues de findByUK de " + estrategia);
                    } catch (NoResultException fe) {
                        //DTOINTError dtoError = new DTOINTError( info, registro, INT-0047 + estrategia ) 
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0047 + estrategia);
                        UtilidadesLog.debug("[cs]ha saltado finderException en TipoEstrategiaLocal con dato = " + estrategia);
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } // if(estrategia!=null

                //**********************         IDIOMA       **********************
                codigoIdioma = (String) registro.obtenerCampo(ISAPBPS.SAB1_CODIGO_IDIOMA);
                UtilidadesLog.debug("[cs]Recogemos de fichero--->codigoIdioma " + codigoIdioma);

                try {
                    UtilidadesLog.debug("[cs]Antes de findByUK DE= " + codigoIdioma);
                    idiomaLocal = idioma.findByCodigo(codigoIdioma);
                    UtilidadesLog.debug("[cs]Despues de findByUK de= " + codigoIdioma);
                } catch (NoResultException fe) {
                    //DTOINTError dtoError = new DTOINTError( info, registro, INT-001 + codigoIdioma ) 
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0001 + codigoIdioma);
                    UtilidadesLog.debug("[cs]ha saltado finderException en idiomaLocal con dato = " + codigoIdioma);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //**********************         FACTOR REPETICION       **********************
                // por incidencia 21433 se cambia la entrada del factor de repeticion de integer a string por restriccion tencnica
                String strFactorRepeticion = (String) registro.obtenerCampo(ISAPBPS.SAB1_FACTOR_REPETICION);
                UtilidadesLog.debug("[cs]Recogemos de fichero--->factorRepeticion " + strFactorRepeticion);

                if (strFactorRepeticion.trim().equals("")) {
                    UtilidadesLog.debug("FactorRepeticion viene null --> toma valor 1");
                    factorRepeticion = new Integer(1);
                } else {
                    UtilidadesLog.debug("FactorRepeticion toma valor de interface");
                    factorRepeticion = new Integer(strFactorRepeticion);
                }

                if (idiomaLocal.getOid().longValue() == ConstantesSEG.IDIOMA_DEFECTO.longValue()) {
                    UtilidadesLog.debug("EL idioma es ES");

                    //**********************         ARGUMENTO VENTA       **********************
                    argumentoVenta = (Integer) registro.obtenerCampo(ISAPBPS.SAB1_CODIGO);
                    descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB1_DESCRIPCION_EN_IDIOMA);
                    UtilidadesLog.debug("[cs]Recogemos de fichero--->ArgumentoVenta " + argumentoVenta);

                    try {
                        UtilidadesLog.debug("[cs]Antes de findByUK DE   argumentoVenta " + argumentoVenta);
                        argumentoLocal = argumentoHome.findByUK(argumentoVenta); // 1
                        UtilidadesLog.debug("[cs]Despues de findByUK de argumentoVenta " + argumentoVenta);
                        argumentoLocal.setFactorRepeticion(factorRepeticion);
                        UtilidadesLog.debug("Se asocia el oid tipo estrategia ");
                        argumentoLocal.setOidTipoEstr(tipoEstrategiaLocal.getOid());
                        
                        argumentoHome.merge(argumentoLocal);
                        //Para meter la descripcion internacinaliable tengo que hacer...
                        //***************ENCONTRAMOS****************** LUEGO METEMOS EN I18N
                        try {
                            UtilidadesLog.debug("[cs]Antes de create de  I18N "); //2
                            i18nLocal = i18NHome.findByEntAtrIdioPK("PRE_ARGUM_VENTA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), argumentoLocal.getOid());

                            UtilidadesLog.debug("DESCRIPCION + " + descripcion);
                            i18nLocal.setDetalle(descripcion);
                            i18NHome.merge(i18nLocal);
                        } catch (NoResultException Fe) { //HEMOS BUSCADO EN I18N Y NO TIENE.

                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n cicloVida");
                                i18nLocal = i18NHome.create("PRE_ARGUM_VENTA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, argumentoLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n cicloVida");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarArgumentoVenta: create i18n de Argumento venta  ha Fallado ");

                                //DTOINTError dtoError = new DTOINTError( info, registro, INT-0013 + "ArgumentoVenta" ) 
                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "ArgumentoVenta");
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        } //HEMOS BUSCADO EN I18N Y NO TIENE.
                    } catch (NoResultException fe) {
                        //********************NO ENCONTRAMOS
                        // El código no existe -> hay que insertar un registro 
                        try {
                            argumentoLocal = argumentoHome.create(argumentoVenta);
                            UtilidadesLog.debug("hemos hecho create en tabla ya que no encontro en 1");
                            argumentoLocal.setFactorRepeticion(factorRepeticion);
                            UtilidadesLog.debug("Se hace el set de factor repeticion" + factorRepeticion);
                            UtilidadesLog.debug("Se asocia el oid tipo estrategia ");
                            argumentoLocal.setOidTipoEstr(tipoEstrategiaLocal.getOid());
                            
                            argumentoHome.merge(argumentoLocal);

                            //descripcion = registro.obtenerCampo( ISAPBPS.DESCRIPCION_EN_IDIOMA ) 
                            //factorRepeticion = factorRepeticion ) 
                            UtilidadesLog.debug("Inserta en i18n argumentoVenta");
                            i18nLocal = i18NHome.create("PRE_ARGUM_VENTA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, argumentoLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n cicloVida");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarArgumentoVenta: create de Argumento Venta ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "ArgumentoVenta");

                            gi.registrarError(dtoError);

                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } //if grande.
                } else {
                    UtilidadesLog.debug("OTRO IDIOMA");

                    //TaponINTGEN tapon=new TaponINTGEN();
                    //ConstantesPRE.ENTIDAD_CICLO_VIDA
                    argumentoVenta = (Integer) registro.obtenerCampo(ISAPBPS.SAB1_CODIGO);
                    descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB1_DESCRIPCION_EN_IDIOMA);

                    try {
                        argumentoLocal = argumentoHome.findByUK(argumentoVenta);

                        //tapon.generarDescripcionIdiomaNoES(argumentoLocal.getOid(),ConstantesPRE.ENTIDAD_ARGUMENTO_VENTA,idiomaLocal.getOid(),descripcion);                        
                        argumentoLocal.setFactorRepeticion(factorRepeticion);
                        UtilidadesLog.debug("Se hace el set de factor repeticion" + factorRepeticion);
                        UtilidadesLog.debug("Se asocia el oid tipo estrategia ");
                        argumentoLocal.setOidTipoEstr(tipoEstrategiaLocal.getOid());
                        
                        argumentoHome.merge(argumentoLocal);

                        try {
                            UtilidadesLog.debug("Antes de buscar la en i18n de otro idioma");    
                            i18nLocal = i18NHome.findByEntAtrIdioPK("PRE_ARGUM_VENTA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), argumentoLocal.getOid());
                            UtilidadesLog.debug("despues de buscar la en i18n de otro idioma");   
                            UtilidadesLog.debug("DESCRIPCION No ES + " + descripcion);
                            i18nLocal.setDetalle(descripcion);
                            
                            i18NHome.merge(i18nLocal);
                        } catch (NoResultException fe) {
                            try {
                                UtilidadesLog.debug("Inserta en i18n argumentoventa NO ESP");
                                i18nLocal = i18NHome.create("PRE_ARGUM_VENTA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, argumentoLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n argumentoventa NO ESP");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarArgumentoVenta: create i18n de Argumento venta  ha Fallado NO ES");
    
                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "ArgumentoVenta\n" + ce.getMessage());
                                gi.registrarError(dtoError);
    
                                continue;
                            }
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  recepcionarArgumentoVenta: Fider de  Argumento de venta   ha Fallado En tro Idioma ");
                        //ver incidencia 21432
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0113 + registro.obtenerCampo(ISAPBPS.SAB1_CODIGO));
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } //FIN DEL ELSE
            } // FIN WHILE
        } catch (RemoteException re) {            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug(" Error InterfacesException recepcionarArgumentosVenta");

            return;
        }
        
        UtilidadesLog.info("MONSAPBPSBean.recepcionarArgumentosVenta(DTOOID pais): Salida");
    }

    public DTOSalidaBatch recepcionarArgumentosVentaBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarArgumentosVentaBatch(DTOBatch dtoBatch): Entrada");
        /*
          * Documentation
         IMareDTO dto = dtoe.getDTOOnline()
         - se obtiene el oid del pais, a partir del código:
         Pais pais = PaisHome.findByUK( dto.getProperty( "cadena" ) )
         MONSAPBPS.recepcionarArgumentosVenta( new DTOOID( pais.oid ) )
         Retornar new DTOSalidaBatch( 0, "recepcionarArgumentosVentaBatch finalizado" )

          * */
        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarArgumentosVenta(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarArgumentosVentaBatch(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "recepArguVentaBatch fin");
    }

    public DTOSalidaBatch recepcionarCicloVidaBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarCicloVidaBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarCicloVida(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarCicloVidaBatch(DTOBatch dtoBatch): Salida");        
        return new DTOSalidaBatch(0, "recepCicloVidaBatch fin");
    }

    public DTOSalidaBatch recepcionarMedioCatalogoBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarMedioCatalogoBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarMedioCatalogo(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarMedioCatalogoBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recepMedioCatalBatch fin");
    }

    public DTOSalidaBatch recepcionarCondicionPromocionBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarCondicionPromocionBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarCondicionPromocion(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarCondicionPromocionBatch(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "recepCondPromBatch fin");
    }

    public DTOSalidaBatch recepcionarTiposOfertaBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarTiposOfertaBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarTiposOferta(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarTiposOfertaBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recepTipOferBatch fin");
    }

    public DTOSalidaBatch recepcionarDescripcionTiposOfertaPorIdiomaBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarDescripcionTiposOfertaPorIdiomaBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarDescripcionTiposOfertaPorIdioma(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.generarEntradaSAP: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarDescripcionTiposOfertaPorIdiomaBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recepTipOferIdiBatch fin");
    }

    public void recepcionarCicloVida(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarCicloVida(DTOOID pais): Entrada");        

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        String codigoCicloVida = null;
        String codigoIdioma = null;
        String descripcion = null;

        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB2, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB2, pais.getOid());

            IdiomaLocalHome idioma = this.getIdiomaLocalHome();
            IdiomaLocal idiomaLocal = null;

            CicloVidaLocalHome cicloVidaHome = this.getCicloVidaLocalHome();
            CicloVidaLocal cicloVidaLocal = null;

            Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
            Entidadi18nLocal e18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                codigoIdioma = (String) registro.obtenerCampo(ISAPBPS.SAB2_CODIGO_IDIOMA);

                try {
                    idiomaLocal = idioma.findByCodigo(codigoIdioma);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if (idiomaLocal.getOid().longValue() == ConstantesSEG.IDIOMA_DEFECTO.longValue()) {
                    UtilidadesLog.debug("IDIOMA POR DEFECTO");

                    try {
                        codigoCicloVida = (String) registro.obtenerCampo(ISAPBPS.SAB2_CODIGO_CICLO_VIDA);
                        cicloVidaLocal = cicloVidaHome.findByUK(codigoCicloVida);

                        try {
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_CICLO_VIDA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), cicloVidaLocal.getOid());

                            //cicloVida.descripcion = registro.obtenerCampo( ISAPBPS.SAB2_DESCRIPCION_EN_IDIOMA )                         
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB2_DESCRIPCION_EN_IDIOMA);
                            e18nLocal.setDetalle(descripcion);
                            
                            e18nLH.merge(e18nLocal); 
                        } catch (NoResultException fe) {
                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n cicloVida");
                                descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB2_DESCRIPCION_EN_IDIOMA);
                                e18nLocal = e18nLH.create("PRE_CICLO_VIDA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, cicloVidaLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n cicloVida");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarCicloVida: create i18n de Ciclo Vida  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "CicloVida\n" + ce.getMessage());
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    } catch (NoResultException fex) {
                        try {
                            // No existe ciclo vida --> insertar
                            UtilidadesLog.debug("Antes Create en cicloVida");
                            UtilidadesLog.debug("Valor campo: " + codigoCicloVida);
                            cicloVidaLocal = cicloVidaHome.create(codigoCicloVida);
                            UtilidadesLog.debug("Despues Create en cicloVida");

                            // Crear si descripcion
                            UtilidadesLog.debug("Inserta en i18n cicloVida");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB2_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_CICLO_VIDA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, cicloVidaLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n cicloVida");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarCicloVida: create de Ciclo Vida  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "CicloVida\n" + ce.getMessage());
                            gi.registrarError(dtoError);

                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    // El código recibido ya existe -> hay que actualizar 
                } else {
                    UtilidadesLog.debug("OTRO IDIOMA");

                    //TaponINTGEN tapon=new TaponINTGEN();
                    codigoCicloVida = (String) registro.obtenerCampo(ISAPBPS.SAB2_CODIGO_CICLO_VIDA);

                    try {
                        cicloVidaLocal = cicloVidaHome.findByUK(codigoCicloVida);

                        //tapon.generarDescripcionIdiomaNoES(cicloVidaLocal.getOid(),ConstantesPRE.ENTIDAD_CICLO_VIDA,idiomaLocal.getOid(),descripcion);                        
                        try {
                            UtilidadesLog.debug("Inserta en i18n cicloVida");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB2_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_CICLO_VIDA", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, cicloVidaLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n cicloVida");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarCicloVida: create i18n de Ciclo Vida  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "CicloVida\n" + ce.getMessage());
                            gi.registrarError(dtoError);

                            continue;
                        }
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  recepcionarCicloVida: create de Ciclo Vida  ha Fallado ");

                        DTOINTError dtoError = new DTOINTError(interfaz, registro,  ErroresDeNegocio.INT_0050 + fe.getMessage());
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            } // FIN WHILE
        } catch (RemoteException re) {            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug(" Error InterfacesException RecepcionarCicloVida");

            return;
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarCicloVida(DTOOID pais): Salida");
    }

    public void recepcionarMedioCatalogo(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarMedioCatalogo(DTOOID pais): Entrada");

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        Integer catalogo = null;
        String codigoIdioma = null;
        String codigoPais = null;
        String descripcion = null;

        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB3, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB3, pais.getOid());

            IdiomaLocalHome idioma = this.getIdiomaLocalHome();
            IdiomaLocal idiomaLocal = null;

            PaisLocalHome paisLocalHome = this.getPaisLocalHome();
            PaisLocal paisLocal = null;

            CatalogoLocalHome catalogoLocalHome = this.getCatalogoLocalHome();
            CatalogoLocal catalogoLocal = null;

            Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
            Entidadi18nLocal e18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                codigoPais = (String) registro.obtenerCampo(ISAPBPS.SAB3_CODIGO_PAIS);

                try {
                    paisLocal = paisLocalHome.findByUk(codigoPais);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003 + codigoPais);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                codigoIdioma = (String) registro.obtenerCampo(ISAPBPS.SAB3_CODIGO_IDIOMA);

                try {
                    idiomaLocal = idioma.findByCodigo(codigoIdioma);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if (idiomaLocal.getOid().longValue() == ConstantesSEG.IDIOMA_DEFECTO.longValue()) {
                    UtilidadesLog.debug("IDIOMA POR DEFECTO");

                    try {
                        catalogo = (Integer) registro.obtenerCampo(ISAPBPS.SAB3_CODIGO_MEDIO_CATALOGO);
                        catalogoLocal = catalogoLocalHome.findByUK(paisLocal.getOid(), catalogo);
                        descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                        catalogoLocal.setDescripcion(descripcion);
                        
                        catalogoLocalHome.merge(catalogoLocal);

                        try {
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_CATAL", new Long(1), (Long) idiomaLocal.getPrimaryKey(), catalogoLocal.getOid());
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                            UtilidadesLog.debug("Actualizamos i18n");
                            e18nLocal.setDetalle(descripcion);
                            
                            e18nLH.merge(e18nLocal);
                        } catch (NoResultException fe) {
                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n PRE_CATAL");
                                descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                                e18nLocal = e18nLH.create("PRE_CATAL", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, catalogoLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n PRE_CATAL");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarCatalogo: create i18n de catalogo  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "Catalogo");
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }
                    } catch (NoResultException fex) {
                        try {
                            UtilidadesLog.debug("Antes Create en catalogo");
                            UtilidadesLog.debug("Valor campo: " + catalogo);
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                            catalogoLocal = catalogoLocalHome.create(catalogo, descripcion, paisLocal.getOid());
                            UtilidadesLog.debug("Despues Create en catalogo");
                            UtilidadesLog.debug("Inserta en i18n PRE_CATAL");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_CATAL", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, catalogoLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n PRE_CATAL");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarCatalogo: create de catalogo  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "Catalogo");
                            gi.registrarError(dtoError);

                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    UtilidadesLog.debug("OTRO IDIOMA");

                    //ConstantesPRE.ENTIDAD_CATALOGO
                    catalogo = (Integer) registro.obtenerCampo(ISAPBPS.SAB3_CODIGO_MEDIO_CATALOGO);

                    try {
                        catalogoLocal = catalogoLocalHome.findByUK(paisLocal.getOid(), catalogo);
                        descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);

                        try {
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_CATAL", new Long(1), (Long) idiomaLocal.getPrimaryKey(), catalogoLocal.getOid());
                            UtilidadesLog.debug("Actualizamos i18n");
                            e18nLocal.setDetalle(descripcion);
                            
                            e18nLH.merge(e18nLocal);
                        } catch (NoResultException fe) {
                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n PRE_CATAL");
                                descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB3_DESCRIPCION_EN_IDIOMA);
                                e18nLocal = e18nLH.create("PRE_CATAL", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, catalogoLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n PRE_CATAL");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarCatalogo: create i18n de catalogo  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "Catalogo");
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }
                    } catch (NoResultException fe) {
                        // INCIDENCIA 17895
                        UtilidadesLog.debug("*Metodo  recepcionarCicloVida: FE SALTO ");

                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0088 + catalogo);
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            } // FIN WHILE
        } catch (RemoteException re) {            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            
            UtilidadesLog.debug(" Error InterfacesException recepcionarMedioCatalogo");

            return;
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarMedioCatalogo(DTOOID pais): Salida");
    }

    public void recepcionarCondicionPromocion(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarCondicionPromocion(DTOOID pais): Entrada");

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        String codigoPromocion = null;
        String codigoIdioma = null;
        String descripcion = null;

        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB4, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB4, pais.getOid());

            IdiomaLocalHome idioma = this.getIdiomaLocalHome();
            IdiomaLocal idiomaLocal = null;

            CondicionPromocionLocalHome condicionPromocionHome = this.getCondicionPromocionLocalHome();
            CondicionPromocionLocal condicionPromocionLocal = null;

            Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
            Entidadi18nLocal e18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                codigoIdioma = (String) registro.obtenerCampo(ISAPBPS.SAB4_CODIGO_IDIOMA);

                try {
                    idiomaLocal = idioma.findByCodigo(codigoIdioma);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if (idiomaLocal.getOid().longValue() == ConstantesSEG.IDIOMA_DEFECTO.longValue()) {
                    UtilidadesLog.debug("IDIOMA POR DEFECTO");

                    try {
                        codigoPromocion = (String) registro.obtenerCampo(ISAPBPS.SAB4_CODIGO_CONDICION_PROMOCION);
                        condicionPromocionLocal = condicionPromocionHome.findByUK(codigoPromocion);

                        // El código recibido ya existe -> hay que actualizar 
                        try {
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_CONDI_PROMO", new Long(1), (Long) idiomaLocal.getPrimaryKey(), condicionPromocionLocal.getOid());

                            //cicloVida.descripcion = registro.obtenerCampo( ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA )                         
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA);
                            e18nLocal.setDetalle(descripcion);
                            
                            e18nLH.merge(e18nLocal);
                        } catch (NoResultException fe) {
                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n codigoPromocion");
                                descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA);
                                e18nLocal = e18nLH.create("PRE_CONDI_PROMO", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, condicionPromocionLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n codigoPromocion");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  recepcionarCondicionPromocion: create i18n de Ciclo Vida  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "codigoPromocion\n" + ce.getMessage());
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    } catch (NoResultException fex) {
                        try {
                            // No existe ciclo vida --> insertasab
                            UtilidadesLog.debug("Antes Create en codigoPromocion");
                            UtilidadesLog.debug("Valor campo: " + codigoPromocion);
                            condicionPromocionLocal = condicionPromocionHome.create(codigoPromocion);
                            UtilidadesLog.debug("Despues Create en codigoPromocion");

                            // Crear si descripcion
                            UtilidadesLog.debug("Inserta en i18n codigoPromocion");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_CONDI_PROMO", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, condicionPromocionLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n codigoPromocion");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarCondicionPromocion: create de codigoPromocion  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "codigoPromocion\n" + ce.getMessage());
                            gi.registrarError(dtoError);

                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    UtilidadesLog.debug("OTRO IDIOMA");

                    //TaponINTGEN tapon=new TaponINTGEN();
                    codigoPromocion = (String) registro.obtenerCampo(ISAPBPS.SAB4_CODIGO_CONDICION_PROMOCION);

                    try {
                        condicionPromocionLocal = condicionPromocionHome.findByUK(codigoPromocion);

                        //tapon.generarDescripcionIdiomaNoES(condicionPromocionLocal.getOid(),ConstantesPRE.ENTIDAD_CONDICION_PROMOCION,idiomaLocal.getOid(),descripcion);                        
                        try {
                            UtilidadesLog.debug("Inserta en i18n codigoPromocion");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_CONDI_PROMO", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, condicionPromocionLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n codigoPromocion");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarCondicionPromocion: create i18n de Ciclo Vida  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "codigoPromocion");
                            gi.registrarError(dtoError);

                            continue;
                        }
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  recepcionarCondicionPromocion: finder de codigoPromocion  ha Fallado ");

                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0051 + codigoPromocion);
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            } // FIN WHILE
        } catch (RemoteException re) {            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug(" Error InterfacesException CondicionPromocion");

            return;
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarCondicionPromocion(DTOOID pais): Salida");
    }

    public void recepcionarTiposOferta(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarTiposOferta(DTOOID pais): Entrada");

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        String codigoCanal = null;
        String comosionable = null;
        String puntaje = null;
        String estadistable = null;
        String montominimo = null;
        String aportaMontoEscala = null;
        String codigoTipoDeOferta = null;
        String gratis = null;
        Integer formaVenta = null;
        
        
        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB2, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB5, pais.getOid());

            TipoOfertaLocalHome tipoOfertaHome = this.getTipoOfertaLocalHome();
            TipoOfertaLocal tipoOfertalocal = null;

            CanalLocalHome canalHome = this.getCanalLocalHome();
            CanalLocal canalLocal = null;

            Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
            Entidadi18nLocal e18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                // codigoCanal = registro.obtenerCampo( ISAPBPS.SAB5_CODIGO_CANAL )       
                codigoCanal = (String) registro.obtenerCampo(ISAPBPS.SAB5_CANAL);

                try {
                    //diseño:canal = CanalHome.findByClaveUnica( codigoCanal ) 
                    canalLocal = canalHome.findByClaveUnica(codigoCanal);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0035 + codigoCanal);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                comosionable = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_DESCUENTO);
                UtilidadesLog.debug("\n String comosionable = " + comosionable);

                Boolean comision = retornaBoolean(comosionable);

                puntaje = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_PUNTAJE);
                UtilidadesLog.debug("\n puntaje = " + puntaje);

                estadistable = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_ESTADISTICA);
                UtilidadesLog.debug("\n estadistable = " + estadistable);

                montominimo = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_PEDIDO_MINIMO);
                UtilidadesLog.debug("\n montominimo = " + montominimo);

                aportaMontoEscala = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_MONTO_ESCALA);
                UtilidadesLog.debug("\n aportaMontoEscala = " + aportaMontoEscala);

                gratis = (String) registro.obtenerCampo(ISAPBPS.SAB5_FLAG_GRATIS);
                UtilidadesLog.debug("\n gratis = " + gratis);
                
                
                //añadido Por 15790
                formaVenta = (Integer) registro.obtenerCampo(ISAPBPS.SAB5_CODIGO_FORMA_VENTA);
                UtilidadesLog.debug("\n formaVenta = " + formaVenta);

                /*
                    * tipoOferta = TipoOfertaHome.create( canal = canal.oid,
                           codigoTipoOferta = registro.obtenerCampo( ISAPBPS.SAB5_CODIGO_TIPO_OFERTA ),
                           comisionable = Boolean.FALSE,
                           puntaje = Boolean.FALSE,
                           estadisticable = Boolean.FALSE,
                           montoMinimo = Boolean.FALSE,
                           aportaMontoEscala = Boolean.FALSE,
                           gratis = registro.obtenerCampo( ISAPBPS.SAB5_FLAG_GRATIS ),
                           formaVenta = registro.obtenerCampo( ISAPBPS.SAB5_CODIGO_FORMA_VENTA ) )
                    *
                    * */
                try {
                    codigoTipoDeOferta = (String) registro.obtenerCampo(ISAPBPS.SAB5_CODIGO);
                    tipoOfertalocal = tipoOfertaHome.findByUK(canalLocal.getOid(), codigoTipoDeOferta);

                    // El código recibido ya existe -> hay que actualizar 
                    tipoOfertalocal.setComisionable(comision);
                    tipoOfertalocal.setPuntaje(retornaBoolean(puntaje));
                    tipoOfertalocal.setEstadisticable(retornaBoolean(estadistable));
                    tipoOfertalocal.setMontoMinimo(retornaBoolean(montominimo));
                    tipoOfertalocal.setAportaMontoEscala(retornaBoolean(aportaMontoEscala));
                    tipoOfertalocal.setGratis(retornaBoolean(gratis));
                    tipoOfertalocal.setValorFormaVenta(formaVenta);        
                    
                    tipoOfertaHome.merge(tipoOfertalocal);
             
                } catch (NoResultException fex) {
                    try {
                        UtilidadesLog.debug("Antes Create en TipoOferta");
                        UtilidadesLog.debug("Valor campo: " + codigoTipoDeOferta);
                        tipoOfertalocal = tipoOfertaHome.create(canalLocal.getOid(), codigoTipoDeOferta);
                        UtilidadesLog.debug("Despues Create en TipoOferta");

                        tipoOfertalocal.setComisionable(Boolean.FALSE);
                        tipoOfertalocal.setPuntaje(Boolean.FALSE);
                        tipoOfertalocal.setEstadisticable(Boolean.FALSE);
                        tipoOfertalocal.setMontoMinimo(Boolean.FALSE);
                        tipoOfertalocal.setAportaMontoEscala(Boolean.FALSE);
                        tipoOfertalocal.setGratis(retornaBoolean(gratis));
                        tipoOfertalocal.setValorFormaVenta(formaVenta); 
                        
                        tipoOfertaHome.merge(tipoOfertalocal);

                        try { //buscamos por si ya estuviera                                //*********ATENCION**  IDIOMA********* BELC300014435
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_TIPO_OFERT", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, tipoOfertalocal.getOid());
                            //e18nLocal.setDetalle("Descriocion pendiente");
                        } catch (NoResultException fe) {
                            UtilidadesLog.debug("Inserta en i18n TipoOferta");

                            try { //*********ATENCION**  IDIOMA*********BELC300014435
                                e18nLocal = e18nLH.create("PRE_TIPO_OFERT", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, "Descripcion Pendiente", tipoOfertalocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n TipoOferta");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  TipoOferta: create de i18n TipoOferta  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "TipoOferta\n" + ce.getMessage());
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }
                    } catch (PersistenceException ce) {
                        UtilidadesLog.debug("*Metodo  RecepcioanrTipoOferta: create de TipoOferta  ha Fallado ");

                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "TipoOferta\n" + ce.getMessage());
                        gi.registrarError(dtoError);

                        continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
            } // FIN WHILE
        } catch (RemoteException re) {            
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug(" Error InterfacesException recepcionarTiposOferta");

            return;
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarTiposOferta(DTOOID pais): Salida");
    }

    public void recepcionarDescripcionTiposOfertaPorIdioma(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarDescripcionTiposOfertaPorIdioma(DTOOID pais): Entrada");

        MONGestorInterfaces gi = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;

        String codigoTipoOferta = null;
        String codigoIdioma = null;
        String codigoCanal = null;
        String descripcion = null;

        CanalLocal canal = null;

        gi = this.getMONGestorInterfaces();

        try {
            //InterfazInfo interfaz = gestor.importarInterfaz( IGestorInterfaces.COD_INTERFAZ_SAB4, pais.oid ) 
            interfaz = gi.importarInterfaz(IGestorInterfaces.COD_INTERFAZ_SAB6, pais.getOid());

            IdiomaLocalHome idioma = this.getIdiomaLocalHome();
            IdiomaLocal idiomaLocal = null;

            CanalLocalHome canalLocalHome = this.getCanalLocalHome();

            TipoOfertaLocalHome tipoOfertaLocalHome = this.getTipoOfertaLocalHome();
            TipoOfertaLocal tipoOfertaLocal = null;

            Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
            Entidadi18nLocal e18nLocal = null;

            //Mientras tenga registros
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                codigoCanal = (String) registro.obtenerCampo(ISAPBPS.SAB6_CODIGO_CANAL);

                try {
                    canal = canalLocalHome.findByClaveUnica(codigoCanal);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0035 + codigoCanal);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                codigoIdioma = (String) registro.obtenerCampo(ISAPBPS.SAB6_CODIGO_IDIOMA);

                try {
                    idiomaLocal = idioma.findByCodigo(codigoIdioma);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0001 + codigoIdioma);
                    gi.registrarError(dtoError);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if (idiomaLocal.getOid().longValue() == ConstantesSEG.IDIOMA_DEFECTO.longValue()) {
                    UtilidadesLog.debug("IDIOMA POR DEFECTO");

                    try {
                        codigoTipoOferta = (String) registro.obtenerCampo(ISAPBPS.SAB6_CODIGO_TIPO_OFERTA);
                        tipoOfertaLocal = tipoOfertaLocalHome.findByUK(canal.getOid(), codigoTipoOferta);

                        // El código recibido ya existe -> hay que actualizar 
                        try {
                            e18nLocal = e18nLH.findByEntAtrIdioPK("PRE_TIPO_OFERT", new Long(1), (Long) idiomaLocal.getPrimaryKey(), tipoOfertaLocal.getOid());

                            //cicloVida.descripcion = registro.obtenerCampo( ISAPBPS.SAB4_DESCRIPCION_EN_IDIOMA )                         
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB6_DESCRIPCION_EN_IDIOMA);
                            e18nLocal.setDetalle(descripcion);
                            
                            e18nLH.merge(e18nLocal);
                        } catch (NoResultException fe) {
                            // No encuentra descripcion para actualizar --> Creamos
                            try {
                                UtilidadesLog.debug("Inserta en i18n TipoOfertaPorIdioma");
                                descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB6_DESCRIPCION_EN_IDIOMA);
                                e18nLocal = e18nLH.create("PRE_TIPO_OFERT", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, tipoOfertaLocal.getOid());
                                UtilidadesLog.debug("Ha insertado en i18n codigoPromocion");
                            } catch (PersistenceException ce) {
                                UtilidadesLog.debug("*Metodo  TipoOfertaPorIdioma: create i18n de Ciclo Vida  ha Fallado ");

                                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "TipoOfertaPorIdioma\n" + ce.getMessage());
                                gi.registrarError(dtoError);

                                continue;
                            }
                        }
                    } catch (NoResultException fex) {
                        try {
                            // No existe ciclo vida --> insertar
                            UtilidadesLog.debug("Antes Create en codigoTipoOferta");
                            UtilidadesLog.debug("Valor campo: " + codigoTipoOferta);
                            tipoOfertaLocal = tipoOfertaLocalHome.create(canal.getOid(), codigoTipoOferta);
                            UtilidadesLog.debug("Despues Create en codigoTipoOferta");

                            // Crear si descripcion
                            UtilidadesLog.debug("Inserta en i18n codigoTipoOferta");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB6_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_TIPO_OFERT", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, tipoOfertaLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n codigoTipoOferta");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  recepcionarTipoOfertaPorIdioma: create de codigoTipoOferta  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "codigoTipoOferta\n" + ce.getMessage());
                            gi.registrarError(dtoError);

                            continue;
                        }
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    UtilidadesLog.debug("OTRO IDIOMA");

                    //TaponINTGEN tapon=new TaponINTGEN();
                    codigoTipoOferta = (String) registro.obtenerCampo(ISAPBPS.SAB6_CODIGO_TIPO_OFERTA);

                    try {
                        tipoOfertaLocal = tipoOfertaLocalHome.findByUK(canal.getOid(), codigoTipoOferta);

                        try {
                            UtilidadesLog.debug("Inserta en i18n TipoOfertaPorIdioma");
                            descripcion = (String) registro.obtenerCampo(ISAPBPS.SAB6_DESCRIPCION_EN_IDIOMA);
                            e18nLocal = e18nLH.create("PRE_TIPO_OFERT", new Long(1), (Long) idiomaLocal.getPrimaryKey(), descripcion, tipoOfertaLocal.getOid());
                            UtilidadesLog.debug("Ha insertado en i18n codigoPromocion");
                        } catch (PersistenceException ce) {
                            UtilidadesLog.debug("*Metodo  TipoOfertaPorIdioma: create i18n de Ciclo Vida  ha Fallado ");

                            DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0013 + "TipoOfertaPorIdioma\n" + ce.getMessage());
                            gi.registrarError(dtoError);

                            continue;
                        }

                        //tapon.generarDescripcionIdiomaNoES(tipoOfertaLocal.getOid(),ConstantesPRE.ENTIDAD_TIPO_OFERTA,idiomaLocal.getOid(),descripcion);                        
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  recepcionarTipoOfertaPorIdioma: create de TipoOfertaPorIdioma  ha Fallado ");
                      //  Modificado por  Cnoziglia 21321
                       // 
                      //  El código de Tipo Oferta no existe” + Nombre del Fichero + nº de línea del fichero
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, "El código de Tipo Oferta "+codigoTipoOferta+" no existe" + fe.getMessage());              
                        gi.registrarError(dtoError);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
            } // FIN WHILE
        } catch (RemoteException re) {
            UtilidadesLog.debug("Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug(" Error InterfacesException recepcionarDescripcionTiposOfertaPorIdioma");

            return;
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarDescripcionTiposOfertaPorIdioma(DTOOID pais): Salida");
    }




    private MONGestorInterfaces getMONGestorInterfaces() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONSAPBPSBean.getMONGestorInterfaces(): Entrada");

        MONGestorInterfacesHome home = (MONGestorInterfacesHome) UtilidadesEJB.getHome("MONGestorInterfaces", MONGestorInterfacesHome.class);

        // Se obtiene el interfaz remoto
        MONGestorInterfaces ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONGestorInterfaces", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.getMONGestorInterfaces(): Salida");

        return ejb;
    }


    private Boolean retornaBoolean(String cadena) throws MareException {
        //si viene un "1" devolvemos true sino devolmemos false 
        UtilidadesLog.info("MONSAPBPSBean.retornaBoolean(String cadena): Entrada");
        Boolean retornoboolean = Boolean.FALSE;
        UtilidadesLog.debug("\n RetornaBoolean \n paramnetro de entrada CADENA =  " + cadena);

        if ((cadena != null) && (!cadena.trim().equals(""))) {
          
            //int igual = cadena.compareTo("1");
           

           // if (igual == 0) { //si entra dentro quiere decir que devolvio un cero es decir que son iguales
            if( cadena.equals("1")){
                 UtilidadesLog.debug("Igual a 1 ");
                //son iguales ha llegado un uno
                UtilidadesLog.info("MONSAPBPSBean.retornaBoolean(String cadena): Salida");
                retornoboolean = Boolean.TRUE;
            }
            if( cadena.equals("S")){
                retornoboolean = Boolean.TRUE;
            }
            if( cadena.equals("N")){
                retornoboolean = Boolean.FALSE;
            }
        }

        UtilidadesLog.debug("\n RetornaBoolean \n paramnetro de SALIDA  retornoboolean=  " + retornoboolean);
        UtilidadesLog.info("MONSAPBPSBean.retornaBoolean(String cadena): Salida");
        return retornoboolean;
    }

	/*
	 * rgiorgi - 25/08-2005: se modifica el método por inc. bloq. de Perú.
	 * */
    public DTOSalidaBatch recepcionarEstimadosVentas(DTOBatch dtoBatch) throws MareException {
        // DT DEL METODO ESTA EN LA INCIDENCIA: 14981 
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentas(DTOBatch dtoBatch): Entrada");

        MONGestorInterfaces gi = null;
        DTOINT dtoINT = null;
        InterfazInfo interfaz = null;
        EstrategiaLocal estrategiaLocal = null;
        EstrategiaLocalHome estrategiaLocalHome = this.getEstrategiaLocalHome();

        IRegistroSicc registro = null;
        DTOINTEstimado dtoEstimado = null;

        try {
            dtoINT = (DTOINT) dtoBatch.getDTOOnline();
            UtilidadesLog.debug("\n RECIBIDO dtoInt  " + dtoINT);
        } catch (ClassCastException cce) {
            UtilidadesLog.debug("**** ClassCastException  en   recepcionarEstimadosVentas salimos del metodo : ");

            return null;
        }

        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAB9, dtoINT.getNumeroLote().toString(), dtoINT.getOidPais());
        info.setDescripcionLote(dtoINT.getDescripcionLote());
        info.setObservaciones(dtoINT.getObservaciones());

        gi = this.getMONGestorInterfaces();

        try {
            interfaz = gi.importarInterfaz(info);
        } catch (RemoteException re) {            
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            UtilidadesLog.debug("**** INTERFACES EXCEPTION importarInterfaz ");
            

            return new DTOSalidaBatch(0, "recEstiVen fin con error");
        }

        try {
            int reg = 0;
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                UtilidadesLog.debug("************* SAB-09 - Inicio proceso del REGISTRO_" + (++reg) );
                dtoEstimado = new DTOINTEstimado();

                dtoEstimado.setNumeroLoteTransaccion(((Long) registro.obtenerCampo(ISAPBPS.SAB9_NUMERO_LOTE_TRANSACCION)));
                dtoEstimado.setPais((String) registro.obtenerCampo(ISAPBPS.SAB9_PAIS));
                dtoEstimado.setSociedad((String) registro.obtenerCampo(ISAPBPS.SAB9_SOCIEDAD));
                dtoEstimado.setCanal((String) registro.obtenerCampo(ISAPBPS.SAB9_CANAL));
                dtoEstimado.setAcceso((String) registro.obtenerCampo(ISAPBPS.SAB9_ACCESO));
                dtoEstimado.setSubacceso((String) registro.obtenerCampo(ISAPBPS.SAB9_SUBACCESO));
                dtoEstimado.setTipoPeriodo((String) registro.obtenerCampo(ISAPBPS.SAB9_TIPO_PERIODO));
                dtoEstimado.setPeriodo((String) registro.obtenerCampo(ISAPBPS.SAB9_PERIODO));
                dtoEstimado.setCodigoProductoSAP((String) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_PRODUCTO_SAP));
                dtoEstimado.setTipoOferta(((String) registro.obtenerCampo(ISAPBPS.SAB9_TIPO_OFERTA)));
                dtoEstimado.setCicloVida(((String) registro.obtenerCampo(ISAPBPS.SAB9_CICLO_VIDA)));
                dtoEstimado.setUnidadesEstimadas(((Long) registro.obtenerCampo(ISAPBPS.SAB9_UNIDADES_ESTIMADAS)));
                dtoEstimado.setVentaNetaEstimada(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_VENTA_NETA_ESTIMADA)));
                dtoEstimado.setPrecioCatalogo(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_PRECIO_CATALOGO)));
                dtoEstimado.setPrecioPosicionamiento(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_PRECIO_POSICIONAMIENTO)));                
                dtoEstimado.setMonedaTransaccion((String) registro.obtenerCampo(ISAPBPS.SAB9_MONEDA_TRANSACCION));
                if (dtoEstimado.getMonedaTransaccion().trim().length()<=0){
                    dtoEstimado.setMonedaTransaccion(null);
                }
                dtoEstimado.setCatalogo(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_CATALOGO)));
                dtoEstimado.setNumeroPaginaCatalogo(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_NUMERO_PAGINA_CATALOGO)));
                dtoEstimado.setPosicionDentroPagina(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_POSICION_DENTRO_PAGINA)));
                dtoEstimado.setArgumento(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_ARGUMENTO)));
                dtoEstimado.setEstrategia((String) registro.obtenerCampo(ISAPBPS.SAB9_ESTRATEGIA));
                dtoEstimado.setCondicionPromocion(((String) registro.obtenerCampo(ISAPBPS.SAB9_CONDICION_PROMOCION)));
                dtoEstimado.setCodigoFormaVenta(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_FORMA_VENTA)));
                dtoEstimado.setCosteEstandar(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_COSTE_ESTANDAR)));
                dtoEstimado.setCodigoFormaPago(((String) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_FORMA_PAGO)));
                dtoEstimado.setCentro(((String) registro.obtenerCampo(ISAPBPS.SAB9_CENTRO)));

                UtilidadesLog.debug("CodigoProductoSAP SAB-9 entrada " + dtoEstimado.getCodigoProductoSAP()  );
                UtilidadesLog.debug("dtoestimado SAB-9 entrada " + dtoEstimado );

                //ArrayList listaGrupos = this.agrupaPorPais(listaDtos);
                //ArrayList listaPais = null;
                PaisLocalHome paisLocalHome = this.getPaisLocalHome();
                PaisLocal paisLocal = null;
                MonedaLocalHome monedaLocalHome = this.getMonedaLocalHome();
                MonedaLocal monedaLocal = null;
                String codigoMoneda = null;

                //String monedaTemp = null;
                String codigoPais = null;
                codigoPais = dtoEstimado.getPais();

                try {
                    paisLocal = paisLocalHome.findByUk(codigoPais);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003);
                    gi.registrarError(dtoError);
                    gi.cerrarInterfaz(interfaz);
                    return new DTOSalidaBatch(0, "recEstiVen fin con error");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CODIGO MONEDA                        
                codigoMoneda = dtoEstimado.getMonedaTransaccion();

                if (codigoMoneda != null && codigoMoneda.length()>0) {
                    try {
                        monedaLocal = monedaLocalHome.findByUK(codigoMoneda);
                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "recEstiVen fin con error");
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    monedaLocal = null;
                }

                if ((monedaLocal != null) && (monedaLocal.getOid().longValue() != paisLocal.getMone_oid_mone().longValue()) && (monedaLocal.getOid().longValue() != paisLocal.getMone_oid_mone_alt().longValue())) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                    gi.cerrarInterfaz(interfaz);
                    return new DTOSalidaBatch(0, "recEstiVen fin con error");
                }

                // Se comprueba la marca
                MarcaLocalHome marcaLocalHome = this.getMarcaLocalHome();
                MarcaLocal marcaLocal = null;

                try {
                    marcaLocal = marcaLocalHome.findByUK(ConstantesSEG.COD_MARCA_EB);
                } catch (NoResultException fex) {
                    try {
                        marcaLocal = marcaLocalHome.findByUK(ConstantesSEG.COD_MARCA_T);
                    } catch (NoResultException fexm) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0003 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "recepcionarEstimadosVentas finalizado con error");
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }

                // TERMINADA DE COMPROBAR EL IDIOMA
                CanalLocalHome canalHome = this.getCanalLocalHome();
                CanalLocal canalLocal = null;
                MaestroProductosLocalHome maestroProductosHome = this.getMaestroProductosLocalHome();
                MaestroProductosLocal maestroProductosLocal = null;
                TipoOfertaLocalHome tipoOfertaHome = this.getTipoOfertaLocalHome();
                TipoOfertaLocal tipoOfertaLocal = null;
                CicloVidaLocalHome cicloVidaHome = this.getCicloVidaLocalHome();
                CicloVidaLocal cicloVidaLocal = null;
                CatalogoLocalHome catalogoLocalHome = this.getCatalogoLocalHome();
                CatalogoLocal catalogoLocal = null;
                ArgumentoVentaLocalHome argumentoVentaLocalHome = this.getArgumentoVentaLocalHome();
                ArgumentoVentaLocal argumentoVentaLocal = null;
                CondicionPromocionLocalHome condicionPromocionLocalHome = this.getCondicionPromocionLocalHome();
                CondicionPromocionLocal condicionPromocionLocal = null;
                PeriodoCorporativoLocalHome periodoCorporativoHome = this.getPeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal periodoCorporativoLocal = null;
                EstimadosVentaLocalHome estimadosVentaLocalHome = this.getEstimadosVentaLocalHome();
                ConfiguracionMFPaisLocalHome configuracionMFPaisLocalHome = this.getConfiguracionMFPaisLocalHome();
                ConfiguracionMFPaisLocal configuracionMFPaisLocal = null;
                Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
                Entidadi18nLocal e18nLocal = null;
                PeriodoLocal periodoLocal = null;
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                /*cambio incidencia CUV-24 1/6*/
                AccesoLocalHome accesoLocalHome = this.getAccesoLocalHome();
                AccesoLocal accesoLocal = null;
                SubaccesoLocalHome subaccesoLocalHome = this.getSubaccesoLocalHome();
                SubaccesoLocal subaccesoLocal = null;    
                /*fin cambio incidencia CUV-24 1/6*/

                /*-----------------*/
                Long monedaTemp = null;
                BigDecimal costeEstandarTemp = null;
                DTOINTEstrategia estrategiaTemp = null;

                try {
                    paisLocal = paisLocalHome.findByUk(dtoEstimado.getPais()); //buscamos por codigo de pais
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0003 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CANAL       
                try {
                    canalLocal = canalHome.findByClaveUnica(dtoEstimado.getCanal());
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0035 + dtoEstimado.getCanal(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                /*cambio incidencia CUV-24 2/6*/
                //ACCESO       
                try {
                      //pzerbino 2/8/2006 DBLG500001109
                      UtilidadesLog.debug("Acceso SAB-9 entrada**" + dtoEstimado.getAcceso() + "******");
                      if ((!dtoEstimado.getAcceso().equals("") ) ) {
                          accesoLocal = accesoLocalHome.findByClaveUnica(dtoEstimado.getAcceso(),canalLocal.getOid());
                         //SUBACCESO       
                        try {
                              //pzerbino 2/8/2006 DBLG500001109
                              UtilidadesLog.debug("SubAcceso SAB-9 entrada**" + dtoEstimado.getSubacceso() + "******");
                                //if( (!dtoEstimado.getSubacceso().equals("")) && (accesoLocal != null)){
                                if( ( accesoLocal != null) && (!dtoEstimado.getSubacceso().equals("")) ){
                                  subaccesoLocal = subaccesoLocalHome.findByUK(dtoEstimado.getSubacceso(),accesoLocal.getOid());                     
                                }         
                        } catch (NoResultException fe) {
                            this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0021 + dtoEstimado.getSubacceso(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);      
                            continue;
                            }  catch (PersistenceException ce) {   
                                UtilidadesLog.error("ERROR ", ce);
                                throw new MareException(ce, 
                                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }      
                      }                    
                } catch (NoResultException fe) {

                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0111 + dtoEstimado.getAcceso(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                

                //MAESTRO PRODUCTOS
                try {
                    UtilidadesLog.debug(" dtoEstimado.getCodigoProductoSAP() antes findByUK : " + dtoEstimado.getCodigoProductoSAP());
                    maestroProductosLocal = maestroProductosHome.findByUK(paisLocal.getOid(), dtoEstimado.getCodigoProductoSAP());
                } catch (FinderException fe) {
                    UtilidadesLog.debug("Error de find: " + fe);
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0005 + dtoEstimado.getCodigoProductoSAP(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);

                    continue;
                }

                // TIPO OFERTA
                Long tipoOfertaTEMP = null;

                if (dtoEstimado.getTipoOferta() != null) {
                    try {
                        tipoOfertaLocal = tipoOfertaHome.findByUK(canalLocal.getOid(), dtoEstimado.getTipoOferta());
                        tipoOfertaTEMP = tipoOfertaLocal.getOid();
                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0053 + dtoEstimado.getTipoOferta(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    tipoOfertaTEMP = ConstantesPRE.TIPO_OFERTA_00;
                }

                // CICLO VIDA
                try {
                    cicloVidaLocal = cicloVidaHome.findByUK(dtoEstimado.getCicloVida());
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0050 + dtoEstimado.getCicloVida(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CATALOGO
                try {
                    catalogoLocal = catalogoLocalHome.findByUK(paisLocal.getOid(), dtoEstimado.getCatalogo());
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro el Catalogo_" + dtoEstimado.getCatalogo() + " ...Vamos a crearlo en PRE_CATAL con Descripcion Pendiente");
                        String descripcion = "Descripcion pendiente";
                        catalogoLocal = catalogoLocalHome.create(dtoEstimado.getCatalogo(), descripcion, paisLocal.getOid());
                        UtilidadesLog.debug(" PRE_CATAL creado con oid_" + catalogoLocal.getOid());
                        e18nLocal = e18nLH.create("PRE_CATAL", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, descripcion, catalogoLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Catalogo");
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de catalogo  ha Fallado ");
                        continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //ARGUMENTO VENTA
                try {
                    argumentoVentaLocal = argumentoVentaLocalHome.findByUK(dtoEstimado.getArgumento());
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro el Argumento de Venta_" + dtoEstimado.getArgumento() + " ...Vamos a crearlo en PRE_ARGUM_VENTA con Descripcion Pendiente");
                        argumentoVentaLocal = argumentoVentaLocalHome.create(dtoEstimado.getArgumento());
                        UtilidadesLog.debug(" PRE_ARGUM_VENTA creado con oid_" + argumentoVentaLocal.getOid());
                        e18nLocal = e18nLH.create("PRE_ARGUM_VENTA", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, "Descripcion Pendiente", argumentoVentaLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Argumento de Venta");
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de catalogo  ha Fallado ");
                        continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CONDICION PROMOCION
                try {
                    condicionPromocionLocal = condicionPromocionLocalHome.findByUK(dtoEstimado.getCondicionPromocion());
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro Condicion Promocion_" + dtoEstimado.getCondicionPromocion() + " ...Vamos a crearla en PRE_CONDI_PROMO con Descripcion Pendiente");
                        condicionPromocionLocal = condicionPromocionLocalHome.create(dtoEstimado.getCondicionPromocion().toString());
                        UtilidadesLog.debug(" PRE_CONDI_PROMO creada con oid_" + condicionPromocionLocal.getOid());
                        String descripcion = "Descripcion pendiente";
                        e18nLocal = e18nLH.create("PRE_CONDI_PROMO", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, descripcion, condicionPromocionLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Condicion Promocion");
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de condicionPromocion  ha Fallado ");
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0051 + dtoEstimado.getCondicionPromocion(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);

                        continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //SEG PERIODO CORPORATIVO             
                try {
                    periodoCorporativoLocal = periodoCorporativoHome.findByUK(dtoEstimado.getPeriodo());

                    //oidPeriodoCorporativo = ?1 oidMarca = ?2 oidPais = ?3 oidCanal = ?4
                    periodoLocal = periodoLocalHome.findByUk(periodoCorporativoLocal.getOid(), marcaLocal.getOid(), paisLocal.getOid(), canalLocal.getOid());
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0054 + dtoEstimado.getPeriodo(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                /*
                 * INSERCION EN ENTIDAD ESTIMADOS VENTAS
                 */
                Collection configuracionMF = null;

                try {
                    configuracionMF = configuracionMFPaisLocalHome.findByPaisMarcaCanal(paisLocal.getOid(), marcaLocal.getOid(), canalLocal.getOid());
                } catch (NoResultException fe) {
                    UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder confmf ");
                    continue;
                }

                if ((configuracionMF == null) || (configuracionMF.size() == 0)) {
                    UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder confmf ");
                    continue;
                }

                //Incidencia 17836
                if (codigoMoneda != null) {
                    try {
                        monedaLocal = monedaLocalHome.findByUK(dtoEstimado.getMonedaTransaccion());
                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "Metodo recepcionarEstimadosVentas finalizado con error");
                    }
                }

                Iterator itConfiguracionMF = configuracionMF.iterator();
                configuracionMFPaisLocal = (ConfiguracionMFPaisLocal) itConfiguracionMF.next();

                if ((monedaLocal != null) && (monedaLocal.getOid().longValue() == configuracionMFPaisLocal.getOid().longValue())) {
                    monedaTemp = null;
                    UtilidadesLog.debug("MONEDA VA A NULL porque coincide con Configuración MF por país");
                } else {
                    if (monedaLocal != null){
                      monedaTemp = monedaLocal.getOid();
                      UtilidadesLog.debug("MONEDA TIENE VALOR: " + monedaTemp);
                    } else {
                      monedaTemp = null;
                      UtilidadesLog.debug("MONEDATEMP VA A NULL");	
                    }
                }

                if ((dtoEstimado.getEstrategia() == null) || (dtoEstimado.getEstrategia().trim().equals(""))) {
                    DAOINTSAPBPS dao = new DAOINTSAPBPS();
                    //V_INT-SAB-9
                    if (argumentoVentaLocal.getOidTipoEstr()!=null){
                        estrategiaTemp = (DTOINTEstrategia) dao.obtenerEstrategia(paisLocal.getOid(), argumentoVentaLocal.getOidTipoEstr(), new Long(ConstantesPRE.ORDEN_COMPRA)).get(0);
                        UtilidadesLog.debug("Estrategia vacia -> se va a calcular la nueva: " + estrategiaTemp.getOid());
                    } else {
                        estrategiaTemp = new DTOINTEstrategia();
                        UtilidadesLog.debug("El argumento de venta no posee tipo de estrategia");
                    }
                } else {
                    try {
                        //Cleal - 22213
                       // tipoEstrategiaLocal = tipoEstrategiaLocalHome.findByUK(dtoEstimado.getEstrategia());
                       UtilidadesLog.debug("*** dtoEstimado.getEstrategia(): "+dtoEstimado.getEstrategia());
                       estrategiaLocal = estrategiaLocalHome.findByUK(dtoEstimado.getEstrategia(), paisLocal.getOid());
                        estrategiaTemp = new DTOINTEstrategia();
                        //jsilva - 22042
                        estrategiaTemp.setOid(estrategiaLocal.getOid());
                        
                        estrategiaLocalHome.merge(estrategiaLocal);
                        UtilidadesLog.debug("COD Estrategia tiene valor -> se busca su oid: " + estrategiaTemp.getOid());
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder EstrategiaLocal ");
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0112 + dtoEstimado.getEstrategia());
                        UtilidadesLog.debug("ha saltado finderException en EstrategiaLocal con dato = " + dtoEstimado.getEstrategia());
                        gi.registrarError(dtoError);
                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }

                UtilidadesLog.debug("CosteEstandar (BigDecimal) leido del archivo -> " + dtoEstimado.getCosteEstandar());
                UtilidadesLog.debug("CosteEstandar (BigDecimal) doubleValue() -> " + dtoEstimado.getCosteEstandar().doubleValue());
                if ((dtoEstimado.getCosteEstandar() == null) || (dtoEstimado.getCosteEstandar().doubleValue() <= 0.0d)) {
                    costeEstandarTemp = maestroProductosLocal.getCosteEstandard();
                    UtilidadesLog.debug("Coste vacio en archivo entrada -> se va a tomar de Mae-produ: " + costeEstandarTemp);
                } else {
                    costeEstandarTemp = dtoEstimado.getCosteEstandar();
                    UtilidadesLog.debug("CosteEstandar trajo valor en archivo entrada: " + costeEstandarTemp);
                }

                //incidencia BELC300022648
                Long oidFidelizacion = null;
                oidFidelizacion = maestroProductosLocal.getProgramaFidelizacion();
                Long oidVariante = null;
                if  (oidFidelizacion != null) {
                    VariantesLocalHome variantesLocalHome = this.getVariantesLocalHome();
                    try {
                        VariantesLocal variantesLocal = variantesLocalHome.findByUK(ConstantesINT.COD_VARIANTE_02); 
                        oidVariante = variantesLocal.getOid();
                    } catch (NoResultException fe) {
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }
                
                UtilidadesLog.debug("Producto " + maestroProductosLocal.getOid());
                UtilidadesLog.debug("periodoCorporativoLocal " + periodoLocal.getOid());
                UtilidadesLog.debug("maestroProductosLocal " + maestroProductosLocal.getFormaPago());
                UtilidadesLog.debug("argumentoVentaLocal " + argumentoVentaLocal.getOid());
                UtilidadesLog.debug("condicionPromocionLocal " + condicionPromocionLocal.getOid());
                UtilidadesLog.debug("estrategiaTemp " + estrategiaTemp.getOid());
                UtilidadesLog.debug("monedaLocal " + monedaLocal);
                UtilidadesLog.debug("tipoOfertaTEMP " + tipoOfertaTEMP);
                UtilidadesLog.debug("cicloVidaLocal " + cicloVidaLocal.getOid());
                UtilidadesLog.debug("catalogoLocal " + catalogoLocal.getOid());
                //UtilidadesLog.debug("accesoLocal " + accesoLocal.getOid());
                //UtilidadesLog.debug("subaccesoLocal " + subaccesoLocal.getOid());
                UtilidadesLog.debug("oidFidelizacion " + oidFidelizacion);
                UtilidadesLog.debug("oidVariante " + oidVariante);

                //LLAMAMOS PARA HACER UNA NUEVA TRANSACCION
                ArrayList array = new ArrayList();
                array.add(estimadosVentaLocalHome);
                array.add(maestroProductosLocal.getOid());
                array.add(periodoLocal.getOid());
                array.add(maestroProductosLocal.getFormaPago());
                array.add(argumentoVentaLocal.getOid());
                array.add(condicionPromocionLocal.getOid());
                array.add(estrategiaTemp.getOid());
                array.add(monedaTemp);
                array.add(tipoOfertaTEMP);
                array.add(cicloVidaLocal.getOid());
                array.add(catalogoLocal.getOid());
                array.add(costeEstandarTemp);
                /*cambio incidencia CUV-24 3/6*/
                //pzerbino Incidencia DBLG500001109 17/8/2006
                if (accesoLocal != null) {
                      array.add(accesoLocal.getOid());
                }else{
                  array.add(null);
                }
                if (subaccesoLocal != null){
                    array.add(subaccesoLocal.getOid());
                }else{
                    array.add(null);
                }
                /*fin cambio incidencia CUV-24 3/6*/
                //incidencia BELC300022648
                array.add(oidFidelizacion);
                array.add(oidVariante);
                
                if (((dtoEstimado.getEstrategia() == null) || (dtoEstimado.getEstrategia().trim().equals("")))&&          
                    (argumentoVentaLocal.getOidTipoEstr()==null)){//V_INT-SAB-9                 
                        UtilidadesLog.error("Error de interfaz SAB-9 no existe el tipo de estrategia en el argumento de venta y");
                        UtilidadesLog.error(" tampoco estrategia en el registro."+array.toString());
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, "" + dtoEstimado);                        
                        gi.registrarError(dtoError);                        
                    } else {//V_INT-SAB-9
                        try {
                            this.getMONSAPBPSLocal().realizarCreate(dtoEstimado, array, interfaz, gi);
                        } catch (Exception e) {                    
                            UtilidadesLog.debug("Fallo al realizar create en estimados ventas");
                        }                        
                    }

                registro.vaciar();
            } //while
        } catch (RemoteException re) {
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            UtilidadesLog.debug("**** INTERFACES EXCEPTION cargarRegistro ");            

            return new DTOSalidaBatch(0, "recEstiVen fin con error");
        }


        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "recEstiVen finalizado");
    }

    public DTOSalidaBatch recepcionarEstimadosVentasManualBatch(DTOINT dtoInt) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasManualBatch(DTOINT dtoInt): Entrada");

        IMareDTO DTOOnline = dtoInt;

        MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarEstimadosVentas");
        DTOBatch dtoBatch = new DTOBatch("recepcionarEstimadosVentas", IDOnline, DTOOnline); // modificado por incidencia BELC300012778

        try {
            UtilidadesLog.debug(" **** Antes de BatchUtil ***");
            BatchUtil.executeMLN(dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosVentasManualBatch", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasManualBatch(DTOINT dtoInt): Salida");

        return new DTOSalidaBatch(0, "recEstiVenBatch finalizado");
    }

    public DTOSalidaBatch recepcionarEstimadosVentasAutomaticoBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasAutomaticoBatch(DTOBatch dtoBatch): Entrada");

        DTOString dtoPais = (DTOString) dtoBatch.getDTOOnline();

        //DTOOID dtoOid = new DTOOID();
        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONSAPBPS.recepcionarEstimadosVentasAutomaticoBatch: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        MONGestorInterfaces gi = this.getMONGestorInterfaces();

        InterfazInfo interfaz = null;

        try {
            interfaz = gi.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAB9, paisLocal.getOid());
        } catch (InterfacesException ie) {            
            UtilidadesLog.error("  MONSAPBPS.recepcionarEstimadosVentasAutomaticoBatch Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);
        } catch (RemoteException re) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosVentasAutomaticoBatch", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOINT dtoINT = new DTOINT();
        dtoINT.setNumeroLote(new Long(interfaz.getNumeroLote()));
        dtoINT.setDescripcionLote(interfaz.getDescripcionLote());
        dtoINT.setOidIdioma(dtoPais.getOidIdioma());
        dtoINT.setOidPais(paisLocal.getOid());

        MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarEstimadosVentas");
        DTOBatch dtoBatchExe = new DTOBatch("recepcionarEstimadosVentas", IDOnline, dtoINT); // modificado por incidencia BELC300012778

        try {
            UtilidadesLog.debug(" **** Antes de BatchUtil ***");
            UtilidadesLog.debug("Idioma: " + dtoINT.getOidIdioma());
            UtilidadesLog.debug("Pais: " + dtoINT.getOidPais());
            BatchUtil.executeMLN(dtoBatchExe, new MareBusinessID("INTProcesoInterfaces"));
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosVentasAutomaticoBatch", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasAutomaticoBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recepEVABatch fin");
    }

	/*
	 * rgiorgi - 25/08-2005: se modifica el método por inc. bloq. de Perú.
	 * */
    public DTOSalidaBatch recepcionarEstimadosMAV(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAV(DTOBatch dtoBatch): Entrada");

        MONGestorInterfaces gi = null;
        DTOINT dtoINT = null;
        InterfazInfo interfaz = null;
        IRegistroSicc registro = null;
        DTOINTEstimado dtoE = null;

        try {
            dtoINT = (DTOINT) dtoBatch.getDTOOnline();
            UtilidadesLog.debug("\n RECIBIDO dtoInt  " + dtoINT);
        } catch (ClassCastException cce) {
            UtilidadesLog.debug("**** ClassCastException  en   recepcionarEstimadosMAV salimos del metodo : ");

            // return null;
            return new DTOSalidaBatch(0, "Fallo recogerDTO");
        }

        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAB10, dtoINT.getNumeroLote().toString(), dtoINT.getOidPais());
        info.setDescripcionLote(dtoINT.getDescripcionLote());
        info.setObservaciones(dtoINT.getObservaciones());

        //UtilidadesLog.debug("interfaz creada + "+ interfaz.toString());
        gi = this.getMONGestorInterfaces();

        try {
            interfaz = gi.importarInterfaz(info);
            UtilidadesLog.debug("[CS]MIMPORTAMOS INTERFAZ : ");
        } catch (RemoteException re) {            
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            UtilidadesLog.debug("**** 1.- INTERFACES EXCEPTION importarInterfaz ");
            

            return new DTOSalidaBatch(0, "recEstiMAV fin con error");
        }

        try {
            while ((registro = gi.cargarRegistro(interfaz, false)) != null) {
                dtoE = new DTOINTEstimado();

                dtoE.setPais((String) registro.obtenerCampo(ISAPBPS.SAB10_PAIS));
                dtoE.setCanal((String) registro.obtenerCampo(ISAPBPS.SAB10_CANAL));
                dtoE.setMarca((String) registro.obtenerCampo(ISAPBPS.SAB10_MARCA));
                dtoE.setCatalogo((Integer) registro.obtenerCampo(ISAPBPS.SAB10_CATALOGO));
                dtoE.setEjercicio((Integer) registro.obtenerCampo(ISAPBPS.SAB10_EJERCICIO));
                dtoE.setPeriodo((String) registro.obtenerCampo(ISAPBPS.SAB10_PERIODO));
                dtoE.setCicloVida((String) registro.obtenerCampo(ISAPBPS.SAB10_CICLO_VIDA));
                dtoE.setTipoOferta(((String) registro.obtenerCampo(ISAPBPS.SAB10_TIPO_OFERTA)));
                dtoE.setCodigoProductoSAP(((String) registro.obtenerCampo(ISAPBPS.SAB10_CODIGO_ARTICULO)));
                dtoE.setDescripcionCriterio(((String) registro.obtenerCampo(ISAPBPS.SAB10_DESCRIPCION_CRITERIO)));
                dtoE.setTipoCliente(((String) registro.obtenerCampo(ISAPBPS.SAB10_TIPO_CLIENTE)));
                dtoE.setBaseDestinatarios(((Long) registro.obtenerCampo(ISAPBPS.SAB10_BASE_DESTINATARIOS)));
                dtoE.setFactorCorreccion(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB10_FACTOR_CORRECCION)));
                dtoE.setPromedioUnidadesDestinatarios((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB10_PROMEDIO_UNIDADES_DESTINATARIOS));
                dtoE.setUnidades(((Long) registro.obtenerCampo(ISAPBPS.SAB10_UNIDADES)));
                dtoE.setAtributoConsulta(((String) registro.obtenerCampo(ISAPBPS.SAB10_ATRIBUTO_CONSULTA)));
                dtoE.setPrecioEstandar(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB10_PRECIO_ESTANDAR)));

                PaisLocalHome paisHome = this.getPaisLocalHome();
                PaisLocal paisLocal = null;
                CanalLocalHome canalHome = this.getCanalLocalHome();
                CanalLocal canalLocal = null;
                MarcaLocalHome marcaHome = this.getMarcaLocalHome();
                MarcaLocal marcaLocal = null;
                PeriodoCorporativoLocalHome periodoCorporativoHome = this.getPeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal periodoCorporativoLocal = null;
                CicloVidaLocalHome cicloVidaHome = this.getCicloVidaLocalHome();
                CicloVidaLocal cicloVidaLocal = null;

                TipoOfertaLocalHome tipoOfertaHome = this.getTipoOfertaLocalHome();
                TipoOfertaLocal tipoOfertaLocal = null;
                MaestroProductosLocalHome maestroProductosHome = this.getMaestroProductosLocalHome();
                MaestroProductosLocal maestroProductosLocal = null;
                TipoClienteLocalHome tipoClienteHome = this.getTipoClienteLocalHome();
                TipoClienteLocal tipoClienteLocal = null;
                BPSInterfaceMAVLocalHome bPSInterfacesMAVHome = new BPSInterfaceMAVLocalHome();
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                PeriodoLocal periodoLocal = null;

                //PAIS
                try {
                    paisLocal = paisHome.findByUk(dtoE.getPais()); //buscamos por codigo de pais
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0003 + dtoE.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CANAL       
                try {
                    canalLocal = canalHome.findByClaveUnica(dtoE.getCanal());
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0035 + dtoE.getCanal(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                try {
                    marcaLocal = marcaHome.findByUK(dtoE.getMarca());
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0004 + dtoE.getMarca(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //SEG PERIODO CORPORATIVO             
                try {
                    periodoCorporativoLocal = periodoCorporativoHome.findByUK(dtoE.getPeriodo());

                    //oidPeriodoCorporativo = ?1 oidMarca = ?2 oidPais = ?3 oidCanal = ?4
                    periodoLocal = periodoLocalHome.findByUk(periodoCorporativoLocal.getOid(), marcaLocal.getOid(), paisLocal.getOid(), canalLocal.getOid());
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0054 + dtoE.getPeriodo(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                Long cicloVidaTemp = null;

                // if((dtoEstimado.getEstrategia()==null)||(dtoEstimado.getEstrategia().trim().equals(""))) {
                if ((dtoE.getCicloVida() != null) && (!dtoE.getCicloVida().trim().equals(""))) {
                    try {
                        cicloVidaLocal = cicloVidaHome.findByUK(dtoE.getCicloVida());
                        cicloVidaTemp = cicloVidaLocal.getOid();
                    } catch (NoResultException fe) {
                        this.registrarError(dtoE, ErroresDeNegocio.INT_0050 + dtoE.getCicloVida(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    cicloVidaTemp = ConstantesPRE.CICLO_VIDA_00;
                }

                try {
                    tipoOfertaLocal = tipoOfertaHome.findByUK(canalLocal.getOid(), dtoE.getTipoOferta());
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0053 + dtoE.getTipoOferta(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                try {
                    maestroProductosLocal = maestroProductosHome.findByUK(paisLocal.getOid(), dtoE.getCodigoProductoSAP());
                } catch (FinderException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0005 + dtoE.getCodigoProductoSAP(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }

                try {
                    tipoClienteLocal = tipoClienteHome.findByUK(dtoE.getTipoCliente());
                } catch (NoResultException fe) {
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0055 + dtoE.getTipoCliente(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }


                // Al create de BPS
                ArrayList array = new ArrayList();
                array.add(periodoLocal.getOid());
                array.add(maestroProductosLocal.getOid());
                array.add(cicloVidaTemp);
                array.add(tipoClienteLocal.getOid());
                array.add(tipoOfertaLocal.getOid());
                array.add(bPSInterfacesMAVHome);

                UtilidadesLog.debug("Llamamos al metodo del CREATE dtoE = " + dtoE);

                try {
                    this.getMONSAPBPSLocal().realizarCreate(dtoE, array, interfaz, gi);
                } catch (Exception e) {                    
                    UtilidadesLog.debug("Fallo al realizar create en BPS Interface MAV");
                }

                registro.vaciar();
            } //while
            //gi.cerrarInterfaz(info);
        } catch (RemoteException re) {
            UtilidadesLog.debug("error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            UtilidadesLog.debug("**** 2.-INTERFACES EXCEPTION cargarRegistro ");
            return new DTOSalidaBatch(0, "recEstiAMV fin con error");
        }
        //  Agregado por HRCS - Incidencia SiCC20080604
        finally {
            try {
                gi.cerrarInterfaz(interfaz);
            } catch(Exception e) {
                UtilidadesLog.error("Error cerrando interfaz: " + e.getMessage(), e);
            }
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAV(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recEstiMAV finalizado");
    }

    public DTOSalidaBatch recepcionarEstimadosMAVManualBatch(DTOINT dtoInt) throws MareException {
        /*      // Este método es invocado desde una pantalla
                DTOBatch dtoBatch = new DTOBatch( "recepcionarEstimadosMAV",
                new MareBusinessID( "INTRecepcionarEstimadosMAV" ),
                dtoINT )
                BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" )
                return new DTOSalidaBatch( 0, "recepcionarEstimadosMAVManualBatch finalizado" )
         */
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAVManualBatch(DTOINT dtoInt): Entrada");

        IMareDTO DTOOnline = dtoInt;

        MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarEstimadosMAV");
        DTOBatch dtoBatch = new DTOBatch("recepcionarEstimadosMAV", IDOnline, DTOOnline); // modificado por incidencia BELC300012778

        try {
            UtilidadesLog.debug(" **** Antes de BatchUtil ***");
            BatchUtil.executeMLN(dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosMAVManualBatch", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAVManualBatch(DTOINT dtoInt): Salida");

        return new DTOSalidaBatch(0, "recEstiMAV Batch finalizado");
    }

    public DTOSalidaBatch recepcionarEstimadosMAVAutomaticoBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAVAutomaticoBatch(DTOBatch dtoBatch): Entrada");

        DTOString dtoPais = (DTOString) dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONSAPBPS.recepcionarEstimadosMAVAutomaticoBatch: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        /*
        MONGestorInterfaces gestor = MONGestorInterfacesHome.create()
        InterfazInfo interfaz = gestor.obtenerInterfazInfo( IGestorInterfaces.COD_INTERFAZ_SAB10, pais.oid )
        DTOINT dtoINT = new DTOINT( numeroLote = interfaz.numeroLote,
        descripcionLote = interfaz.descripcionLote )

        DTOBatch dtoBatch = new DTOBatch( "recepcionarEstimadosMAV",
        new MareBusinessID( "INTRecepcionarEstimadosMAV" ),
        dtoINT )
        BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" )


        Retornar new DTOSalidaBatch( 0, "recepcionarEstimadosMAVAutomaticoBatch finalizado" )

        */
        MONGestorInterfaces gi = this.getMONGestorInterfaces();

        InterfazInfo interfaz = null;

        try {
            interfaz = gi.obtenerInterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAB10, paisLocal.getOid());
        } catch (InterfacesException ie) {            
            UtilidadesLog.error("  MONSAPBPS.recepcionarEstimadosMAVAutomaticoBatch Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);
        } catch (RemoteException re) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosMAVAutomaticoBatch", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }

        DTOINT dtoINT = new DTOINT();
        dtoINT.setNumeroLote(new Long(interfaz.getNumeroLote()));
        dtoINT.setDescripcionLote(interfaz.getDescripcionLote());
        dtoINT.setOidIdioma(dtoPais.getOidIdioma());
        dtoINT.setOidPais(paisLocal.getOid());

        MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarEstimadosMAV");
        DTOBatch dtoBatchExe = new DTOBatch("recepcionarEstimadosMAV", IDOnline, dtoINT); // modificado por incidencia BELC300012778

        try {
            UtilidadesLog.debug(" **** Antes de BatchUtil ***");
            UtilidadesLog.debug("Idioma: " + dtoINT.getOidIdioma());
            UtilidadesLog.debug("Pais: " + dtoINT.getOidPais());
            BatchUtil.executeMLN(dtoBatchExe, new MareBusinessID("INTProcesoInterfaces"));
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosVentasAutomaticoBatch", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosMAVAutomaticoBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "RECPEMAVauto fin");
    }

    private void registrarError(DTOINTEstimado dtoEstimado, String mensaje, InterfazInfo interfaz, MONGestorInterfaces gi, String indicadorSAB) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.registrarError(DTOINTEstimado dtoEstimado, String mensaje, InterfazInfo interfaz, MONGestorInterfaces gi, String indicadorSAB): Entrada");

        /*
         * IRegistroSicc registro = new RegistroSicc()

            1- se cargan los valores contenidos en 'dtoEstimado' en 'registro, haciendo uso de las constantes SAB9 o SAB10, en función
            del parámetro de entrada 'indicadorSAB'
            Ejemplo: registro.anyadirCampo( SAB9_PAIS, dtoEstimado.pais )

            2- se crea un objeto DTOINTError, con 'interfaz', el objeto RegistroSicc anterior y el parámetro de entrada 'mensaje'

            3- gestor.registrarError( DTOINTError creado )

         * */
        IRegistroSicc registro = new RegistroSicc();

        try {
            //FALTAN COSAS HABRA QUE DIFERENCIAR COM VA EL ASUNTO.
            if (indicadorSAB.compareTo(IGestorInterfaces.COD_INTERFAZ_SAB9) == 0) {
                //SAB-9
                registro.anyadirCampo(ISAPBPS.SAB9_NUMERO_LOTE_TRANSACCION, dtoEstimado.getNumeroLoteTransaccion());
                registro.anyadirCampo(ISAPBPS.SAB9_PAIS, dtoEstimado.getPais());
                registro.anyadirCampo(ISAPBPS.SAB9_SOCIEDAD, dtoEstimado.getSociedad());
                registro.anyadirCampo(ISAPBPS.SAB9_CANAL, dtoEstimado.getCanal());
                registro.anyadirCampo(ISAPBPS.SAB9_ACCESO, dtoEstimado.getAcceso());
                registro.anyadirCampo(ISAPBPS.SAB9_SUBACCESO, dtoEstimado.getSubacceso());
                registro.anyadirCampo(ISAPBPS.SAB9_TIPO_PERIODO, dtoEstimado.getTipoPeriodo());
                registro.anyadirCampo(ISAPBPS.SAB9_PERIODO, dtoEstimado.getPeriodo());
                registro.anyadirCampo(ISAPBPS.SAB9_CODIGO_PRODUCTO_SAP, dtoEstimado.getCodigoProductoSAP());
                registro.anyadirCampo(ISAPBPS.SAB9_TIPO_OFERTA, dtoEstimado.getTipoOferta());
                registro.anyadirCampo(ISAPBPS.SAB9_CICLO_VIDA, dtoEstimado.getCicloVida());
                registro.anyadirCampo(ISAPBPS.SAB9_UNIDADES_ESTIMADAS, dtoEstimado.getUnidadesEstimadas());
                registro.anyadirCampo(ISAPBPS.SAB9_VENTA_NETA_ESTIMADA, dtoEstimado.getVentaNetaEstimada());
                registro.anyadirCampo(ISAPBPS.SAB9_PRECIO_CATALOGO, dtoEstimado.getPrecioCatalogo());
                registro.anyadirCampo(ISAPBPS.SAB9_PRECIO_POSICIONAMIENTO, dtoEstimado.getPrecioPosicionamiento());
                registro.anyadirCampo(ISAPBPS.SAB9_MONEDA_TRANSACCION, dtoEstimado.getMonedaTransaccion());
                registro.anyadirCampo(ISAPBPS.SAB9_CATALOGO, dtoEstimado.getCatalogo());
                registro.anyadirCampo(ISAPBPS.SAB9_NUMERO_PAGINA_CATALOGO, dtoEstimado.getNumeroPaginaCatalogo());
                registro.anyadirCampo(ISAPBPS.SAB9_POSICION_DENTRO_PAGINA, dtoEstimado.getPosicionDentroPagina());
                registro.anyadirCampo(ISAPBPS.SAB9_ARGUMENTO, dtoEstimado.getAtributoConsulta());
                registro.anyadirCampo(ISAPBPS.SAB9_ESTRATEGIA, dtoEstimado.getEstrategia());
                registro.anyadirCampo(ISAPBPS.SAB9_CONDICION_PROMOCION, dtoEstimado.getCondicionPromocion());
                registro.anyadirCampo(ISAPBPS.SAB9_CODIGO_FORMA_VENTA, dtoEstimado.getCodigoFormaVenta());
                registro.anyadirCampo(ISAPBPS.SAB9_COSTE_ESTANDAR, dtoEstimado.getCosteEstandar());
                registro.anyadirCampo(ISAPBPS.SAB9_CODIGO_FORMA_PAGO, dtoEstimado.getCodigoFormaPago());
                registro.anyadirCampo(ISAPBPS.SAB9_CENTRO, dtoEstimado.getCentro());
            } else {
                if (indicadorSAB.compareTo(IGestorInterfaces.COD_INTERFAZ_SAB10) == 0) {
                    //SAB-10
                    registro.anyadirCampo(ISAPBPS.SAB10_PAIS, dtoEstimado.getPais());
                    registro.anyadirCampo(ISAPBPS.SAB10_CANAL, dtoEstimado.getCanal());
                    registro.anyadirCampo(ISAPBPS.SAB10_MARCA, dtoEstimado.getAcceso());
                    registro.anyadirCampo(ISAPBPS.SAB10_CATALOGO, dtoEstimado.getSubacceso());
                    registro.anyadirCampo(ISAPBPS.SAB10_EJERCICIO, dtoEstimado.getEjercicio());
                    registro.anyadirCampo(ISAPBPS.SAB10_PERIODO, dtoEstimado.getPeriodo());
                    registro.anyadirCampo(ISAPBPS.SAB10_TIPO_OFERTA, dtoEstimado.getTipoOferta());
                    registro.anyadirCampo(ISAPBPS.SAB10_CICLO_VIDA, dtoEstimado.getCicloVida());
                    registro.anyadirCampo(ISAPBPS.SAB10_CODIGO_ARTICULO, dtoEstimado.getCodigoProductoSAP());
                    registro.anyadirCampo(ISAPBPS.SAB10_DESCRIPCION_CRITERIO, dtoEstimado.getDescripcionCriterio());
                    registro.anyadirCampo(ISAPBPS.SAB10_TIPO_CLIENTE, dtoEstimado.getTipoCliente());
                    registro.anyadirCampo(ISAPBPS.SAB10_BASE_DESTINATARIOS, dtoEstimado.getBaseDestinatarios());
                    registro.anyadirCampo(ISAPBPS.SAB10_FACTOR_CORRECCION, dtoEstimado.getFactorCorreccion());
                    registro.anyadirCampo(ISAPBPS.SAB10_PROMEDIO_UNIDADES_DESTINATARIOS, dtoEstimado.getPromedioUnidadesDestinatarios());
                    registro.anyadirCampo(ISAPBPS.SAB10_UNIDADES, dtoEstimado.getUnidades());
                    registro.anyadirCampo(ISAPBPS.SAB10_ATRIBUTO_CONSULTA, dtoEstimado.getAtributoConsulta());
                    registro.anyadirCampo(ISAPBPS.SAB10_PRECIO_ESTANDAR, dtoEstimado.getPrecioEstandar());
                }
            }

            DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
            gi.registrarError(dtoError);
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug("*** Error MONSAPBPS.registrarError: Fallo al llamar a gi.registrarError()", ie);
        } catch (RemoteException re) {            
            UtilidadesLog.debug("*** Error MONSAPBPS.registrarError", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.registrarError(DTOINTEstimado dtoEstimado, String mensaje, InterfazInfo interfaz, MONGestorInterfaces gi, String indicadorSAB): Salida");
    }

    private ArrayList agrupaPorPais(ArrayList listaDtos) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.agrupaPorPais(ArrayList listaDtos): Entrada");
        ArrayList listaGrupos = new ArrayList();
        ArrayList arrTemporal = null;
        Iterator it = listaDtos.iterator();
        DTOINTEstimado dtoProcesandose;
        DTOINTEstimado dtoTemporal = null;

        while (it.hasNext()) {
            boolean insertado = false;
            dtoProcesandose = (DTOINTEstimado) it.next();

            if (listaGrupos.size() == 0) { // Si el arraylist de grupos esta vacio metemos nueva lista

                ArrayList temporal = new ArrayList();
                temporal.add(dtoProcesandose);
                listaGrupos.add(temporal);
                insertado = true;
            }

            int i = 0;

            while ((i < listaGrupos.size()) && (!insertado)) {
                arrTemporal = (ArrayList) listaGrupos.get(i);
                dtoTemporal = (DTOINTEstimado) arrTemporal.get(0);

                if (dtoProcesandose.getPais().compareTo(dtoTemporal.getPais()) == 0) {
                    arrTemporal.add(dtoProcesandose);
                    insertado = true;
                }

                i++;
            }

            if (!insertado) {
                ArrayList temporal = new ArrayList();
                temporal.add(dtoProcesandose);
                listaGrupos.add(temporal);
            }
        }

        UtilidadesLog.info("MONSAPBPSBean.agrupaPorPais(ArrayList listaDtos): Salida");
        return listaGrupos;
    }







    private BusinessFacadeLocalHome getBusinessFacadeLocalHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (BusinessFacadeLocalHome) context.lookup("java:comp/env/BusinessFacadeBATCH");
    }

    public void realizarCreate(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.realizarCreate(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Entrada");

        if (interfaz.getCodigoInterfaz().compareTo(IGestorInterfaces.COD_INTERFAZ_SAB9) == 0) {
            UtilidadesLog.debug("--> CREATE DE LA INTERFAZ SAB-9");

            //Long producto, Long periodo, Long tipoOferta, Long cicloVida
            EstimadosVentaLocal estimadosVentaLocal = null;
            EstimadosVentaLocalHome estimadosVentaLocalHome = (EstimadosVentaLocalHome) array.get(0);

            Long formaPago = null;
            Long mone = null;

            if (array.get(3) != null) {
                formaPago = (Long) array.get(3);
            }

            if (array.get(7) != null) {
                mone = (Long) array.get(7);
            }

            UtilidadesLog.debug("Parametro 1:Long prod_oid_prod " + (Long) array.get(1));
            UtilidadesLog.debug("Parametro 2:Long perd_oid_peri " + (Long) array.get(2));

            if (formaPago != null) {
                UtilidadesLog.debug("Parametro 3Long fopa_oid_form_pago: " + formaPago);
            } else {
                UtilidadesLog.debug("Parametro 3(Forma pago): NULL");
            }

            UtilidadesLog.debug("Parametro 4:Long argv_oid_argu_vent " + (Long) array.get(4));
            UtilidadesLog.debug("Parametro 5:Long cndp_oid_cond_prom " + (Long) array.get(5));
            UtilidadesLog.debug("Parametro 6:Long coes_oid_estr " + (Long) array.get(6));

            if (mone != null) {
                UtilidadesLog.debug("Parametro 7:Long mone_oid_mone " + mone);
            } else {
                UtilidadesLog.debug("Parametro 7(Moneda): NULL");
            }

            UtilidadesLog.debug("Parametro 8:Long tofe_oid_tipo_ofer " + (Long) array.get(8));
            UtilidadesLog.debug("Parametro 9:Long civi_oid_cicl_vida " + (Long) array.get(9));
            UtilidadesLog.debug("Parametro 10:Long ocat_oid_cata " + (Long) array.get(10));

            if (array.get(11) != null) {
                UtilidadesLog.debug("Parametro 11:CosteEstandar " + (BigDecimal) array.get(11));
            } else {
                UtilidadesLog.debug("Parametro 11:CosteEstandar Null");
            }
            
            /*cambio incidencia CUV-24 4/6*/
            if (array.get(12) != null) {//acceso
                UtilidadesLog.debug("Parametro 12:acceso " + (Long) array.get(12));
            } else {
                UtilidadesLog.debug("Parametro 12:acceso Null");
            }

            if (array.get(13) != null) {//subacceso
                UtilidadesLog.debug("Parametro 13:subacceso " + (Long) array.get(13));
            } else {
                UtilidadesLog.debug("Parametro 13:subacceso Null");
            }
            /*fin cambio incidencia CUV-24 4/6*/

            //incidencia 22648
            if (array.get(14) != null) {//oidFidelizacion
                UtilidadesLog.debug("Parametro 14:oidFidelizacion " + (Long) array.get(14));
            } else {
                UtilidadesLog.debug("Parametro 14:oidFidelizacion Null");
            }
            if (array.get(15) != null) {//subacceso
                UtilidadesLog.debug("Parametro 15:variante " + (Long) array.get(15));
            } else {
                UtilidadesLog.debug("Parametro 15:variante Null");
            }

            try {
                UtilidadesLog.debug("ANTES DE FINDER");
                estimadosVentaLocal = estimadosVentaLocalHome.findByUK((Long) array.get(1), (Long) array.get(2), (Long) array.get(8), (Long) array.get(9));

                // Campos a insertar BELC300015060
                UtilidadesLog.debug("DESPUES DE FINDER... (significa que estoy ACTUALIZANDO una Estimacion de Ventas para el Producto)");
                
                estimadosVentaLocal.setOidFormPago(formaPago);                  // DBLG400000821 07/07/2006
                estimadosVentaLocal.setOidCondProm((Long)array.get(5));//NotNull// DBLG400000821 07/07/2006
                estimadosVentaLocal.setOidEstr((Long)array.get(6));             // DBLG400000821 07/07/2006
                estimadosVentaLocal.setOidMoneda(mone);                         // DBLG400000821 07/07/2006
                
                
                if (array.get(4) != null) {
                    estimadosVentaLocal.setOidArguVent((Long)array.get(4));
                }
                if (array.get(10) != null) {
                    estimadosVentaLocal.setOidCata((Long)array.get(10));
                }
                if (array.get(11) != null) {
                    estimadosVentaLocal.setCosteEstandar(new Double(((BigDecimal) array.get(11)).doubleValue()));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setCosteEstandar(null);                 // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006

                estimadosVentaLocal.setUnidadesEstimadas(dtoE.getUnidadesEstimadas());
                estimadosVentaLocal.setPaginaCatalogo(dtoE.getNumeroPaginaCatalogo());
                estimadosVentaLocal.setPosicionPagina(dtoE.getPosicionDentroPagina());

                if (dtoE.getPrecioCatalogo() != null) {
                    estimadosVentaLocal.setPrecioCatalogo(new Double(dtoE.getPrecioCatalogo().doubleValue()));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setPrecioCatalogo(null);                // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006

                if (dtoE.getVentaNetaEstimada() != null) {
                    estimadosVentaLocal.setVentaNetaEstimada(new Double(dtoE.getVentaNetaEstimada().doubleValue()));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setVentaNetaEstimada(null);             // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006

                if (dtoE.getPrecioPosicionamiento() != null) {
                    estimadosVentaLocal.setPrecioPosicionamiento(new Double(dtoE.getPrecioPosicionamiento().doubleValue()));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setPrecioPosicionamiento(null);         // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006
                /* eiraola - Inc.BELC300022042 - No actualizaba en Pre_estim_venta el 'CostoEstandar' con
                 * el valor de Mae_produ cuando en el archivo entrada venia vacio.
                if (dtoE.getCosteEstandar() != null) {
                    estimadosVentaLocal.setCosteEstandar(new Double(dtoE.getCosteEstandar().doubleValue()));
                }
                */
                estimadosVentaLocal.setCentro(dtoE.getCentro());
                
                /*cambio incidencia CUV-24 5/6*/
                if (array.get(12) != null) {//acceso
                    estimadosVentaLocal.setOidAcceso((Long) array.get(12));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setOidAcceso(null);                     // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006
                    
                if (array.get(13) != null) {//subacceso
                    estimadosVentaLocal.setOidSbac((Long) array.get(13));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setOidSbac(null);                       // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006
                /*fin cambio incidencia CUV-24 5/6*/

                //incidencia 22648
                if (array.get(14) != null) {//oidFidelizacion
                    estimadosVentaLocal.setProgramaFidelizacion((Long) array.get(14));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setProgramaFidelizacion(null);          // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006
                if (array.get(15) != null) {//oidVariante
                    estimadosVentaLocal.setVariante((Long) array.get(15));
                } else {                                                        // DBLG400000821 07/07/2006
                    estimadosVentaLocal.setVariante(null);                      // DBLG400000821 07/07/2006
                }                                                               // DBLG400000821 07/07/2006
                
                 estimadosVentaLocalHome.merge(estimadosVentaLocal);
            
            } catch (NoResultException ex) {
                try {
                    UtilidadesLog.debug("ANTES DE CREATE");
                    estimadosVentaLocal = estimadosVentaLocalHome.create((Long) array.get(1), //Long prod_oid_prod
                            (Long) array.get(2), //Long perd_oid_peri
                            formaPago, //Long fopa_oid_form_pago
                            (Long) array.get(4), //Long argv_oid_argu_vent
                            (Long) array.get(5), //Long cndp_oid_cond_prom
                            (Long) array.get(6), //Long coes_oid_estr
                            mone, //Long mone_oid_mone
                            (Long) array.get(8), //Long tofe_oid_tipo_ofer
                            (Long) array.get(9), //Long civi_oid_cicl_vida
                            (Long) array.get(10) //Long ocat_oid_cata
                        );

                    // Campos a insertar BELC300015060
                    UtilidadesLog.debug("DESPUES DE CREATE");

                    if (array.get(11) != null) {
                        estimadosVentaLocal.setCosteEstandar(new Double(((BigDecimal) array.get(11)).doubleValue()));
                    }

                    estimadosVentaLocal.setUnidadesEstimadas(dtoE.getUnidadesEstimadas());
                    estimadosVentaLocal.setPaginaCatalogo(dtoE.getNumeroPaginaCatalogo());
                    estimadosVentaLocal.setPosicionPagina(dtoE.getPosicionDentroPagina());

                    if (dtoE.getPrecioCatalogo() != null) {
                        estimadosVentaLocal.setPrecioCatalogo(new Double(dtoE.getPrecioCatalogo().doubleValue()));
                    }

                    if (dtoE.getVentaNetaEstimada() != null) {
                        estimadosVentaLocal.setVentaNetaEstimada(new Double(dtoE.getVentaNetaEstimada().doubleValue()));
                    }

                    if (dtoE.getPrecioPosicionamiento() != null) {
                        estimadosVentaLocal.setPrecioPosicionamiento(new Double(dtoE.getPrecioPosicionamiento().doubleValue()));
                    }
                    /* eiraola - Inc.BELC300022042 - No actualizaba en Pre_estim_venta el 'CostoEstandar' con
                     * el valor de Mae_produ cuando en el archivo entrada venia vacio.
                    if (dtoE.getCosteEstandar() != null) {
                        estimadosVentaLocal.setCosteEstandar(new Double(dtoE.getCosteEstandar().doubleValue()));
                    }
                    */
                    estimadosVentaLocal.setCentro(dtoE.getCentro());
                    
                    /*cambio incidencia CUV-24 6/6*/
                    if (array.get(12) != null) {//acceso
                        estimadosVentaLocal.setOidAcceso((Long) array.get(12));
                    }
                        
                    if (array.get(13) != null) {//subacceso
                        estimadosVentaLocal.setOidSbac((Long) array.get(13));
                    }
                    /*fin cambio incidencia CUV-24 6/6*/                    

                    //incidencia 22648
                    if (array.get(14) != null) {//oidFidelizacion
                        estimadosVentaLocal.setProgramaFidelizacion((Long) array.get(14));
                    }
                    if (array.get(15) != null) {//oidVariante
                        estimadosVentaLocal.setVariante((Long) array.get(15));
                    }
                    
                    estimadosVentaLocalHome.merge(estimadosVentaLocal);

                } catch (PersistenceException ce) {                    
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0013, interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } else {
            UtilidadesLog.debug(" --> CREATE DE LA INTERFAZ SAB-10");

            Long periodoCorporativo = (Long) array.get(0);
            Long maestroProductos = (Long) array.get(1);
            Long cicloVidaTemp = (Long) array.get(2);
            Long tipoCliente = (Long) array.get(3);
            Long tipoOferta = (Long) array.get(4);
            UtilidadesLog.debug("\n periodoCorporativo " + periodoCorporativo);
            UtilidadesLog.debug("\nmaestroProductos " + maestroProductos);
            UtilidadesLog.debug("\ncicloVidaTemp " + cicloVidaTemp);
            UtilidadesLog.debug("\ntipoCliente " + tipoCliente);
            UtilidadesLog.debug("\ntipoOferta " + tipoOferta);

            BPSInterfaceMAVLocalHome bPSInterfacesMAVHome = (BPSInterfaceMAVLocalHome) array.get(5);
            BPSInterfaceMAVLocal bPSInterfacesMAVLocal = null;

            Double factorCorreccion = null;

            if (dtoE.getFactorCorreccion() != null) {
                factorCorreccion = new Double(dtoE.getFactorCorreccion().doubleValue());
                UtilidadesLog.debug("\n factorCorreccion " + factorCorreccion);
            }

            Double promedioUnidadesDestinatarios = null;

            if (dtoE.getPromedioUnidadesDestinatarios() != null) {
                promedioUnidadesDestinatarios = new Double(dtoE.getPromedioUnidadesDestinatarios().doubleValue());
                UtilidadesLog.debug("\n promedioUnidadesDestinatarios " + promedioUnidadesDestinatarios);
            }

            Double precioEstandar = null;

            if (dtoE.getPrecioEstandar() != null) {
                precioEstandar = new Double(dtoE.getPrecioEstandar().doubleValue());
                UtilidadesLog.debug("\n precioEstandar " + precioEstandar);
            } else {
                precioEstandar = new Double("0"); //Poner una incidencia 
            }

            try {
                UtilidadesLog.debug("ANTES DE FINDER");

                //Long periodo, Long producto, Long cicloVida, Long tipoCliente, Long tipoOferta) 
                bPSInterfacesMAVLocal = bPSInterfacesMAVHome.findByUK(periodoCorporativo, maestroProductos, cicloVidaTemp, tipoCliente, tipoOferta);
                UtilidadesLog.debug("\n hemos Encontrado en el finder ");
                bPSInterfacesMAVLocal.setBaseDestinatarios(dtoE.getBaseDestinatarios());
                bPSInterfacesMAVLocal.setFactorCorreccion(factorCorreccion);
                bPSInterfacesMAVLocal.setPromedio(promedioUnidadesDestinatarios);
                bPSInterfacesMAVLocal.setPrecioStandar(precioEstandar);
                bPSInterfacesMAVLocal.setUnidades(dtoE.getUnidades());
                bPSInterfacesMAVLocal.setCriterio(dtoE.getDescripcionCriterio());
                bPSInterfacesMAVLocal.setObservaciones(dtoE.getAtributoConsulta());
            } catch (NoResultException fe) {
                //BPSInterfaceMAVLocal create(Double precioStandar, Long oidTipoOferta, Long oidProducto, Long oidTipoCliente, Long oidPeriodo, Long oidCicloVida) throws MareException, CreateException;
                UtilidadesLog.debug("\n NO hemos Encontrado en el finder  hacemos EL CREATE ");

                try {
                    bPSInterfacesMAVLocal = bPSInterfacesMAVHome.create(precioEstandar, tipoOferta, maestroProductos, tipoCliente, periodoCorporativo, cicloVidaTemp);

                    bPSInterfacesMAVLocal.setBaseDestinatarios(dtoE.getBaseDestinatarios());
                    bPSInterfacesMAVLocal.setPromedio(promedioUnidadesDestinatarios);
                    bPSInterfacesMAVLocal.setUnidades(dtoE.getUnidades());
                    bPSInterfacesMAVLocal.setFactorCorreccion(factorCorreccion);
                    bPSInterfacesMAVLocal.setCriterio(dtoE.getDescripcionCriterio());
                    bPSInterfacesMAVLocal.setObservaciones(dtoE.getAtributoConsulta());
                    bPSInterfacesMAVHome.merge(bPSInterfacesMAVLocal);
                } catch (PersistenceException ce) {
                    UtilidadesLog.debug("Excepcion en bPSInterfacesMAVHome.create falla el create en el registro  dtoE = " + dtoE);                    
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0013, interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB10);
                }
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        UtilidadesLog.info("MONSAPBPSBean.realizarCreate(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Salida");
    }

    private void grabarRegistroVtaDiaProducto(StringBuffer total) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.grabarRegistroVtaDiaProducto(StringBuffer total): Entrada");
        if (total!=null){
            UtilidadesLog.debug("grabo....: " + total.toString());        
            //se envia a BD  
            BelcorpService bs = UtilidadesEJB.getBelcorpService();
            try {      
                bs.dbService.executeProcedure("PQ_PLANI.EXECUTOR", total.toString());
            } catch (Exception e) {
              throw new MareException(e,
              UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }            
        }
        UtilidadesLog.info("MONSAPBPSBean.grabarRegistroVtaDiaProducto(StringBuffer total): Salida");        
    }
        
    private StringBuffer armadoStrInsert(DTOVentaDiaProducto rec, java.sql.Date fecha, Long oidMonePaisLocal) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.armadoStrInsert(DTOVentaDiaProducto rec, java.sql.Date fecha): Entrada");
        StringBuffer cadena = new StringBuffer();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd-MM-yyyy");
        
        cadena.append("INSERT INTO INT_VENTA_DIAPR_PRODU ( ");
        cadena.append(" OID_VENT_DIAP_PROD, ");
        cadena.append(" FEC_FECH, ");
        cadena.append(" SBAC_OID_SBAC, ");
        cadena.append(" PERD_OID_PERI, ");
        cadena.append(" ALMC_OID_ALMA, ");
        cadena.append(" TICL_OID_TIPO_CLIE, ");
        cadena.append(" SOCI_OID_SOCI, ");
        cadena.append(" PROD_OID_PROD, ");
        cadena.append(" TOFE_OID_TIPO_OFER, ");
        cadena.append(" CNDP_OID_COND_PROM, ");
        cadena.append(" MONE_OID_MONE, ");
        cadena.append(" CIVI_OID_CICL_VIDA, ");
        cadena.append(" TSPA_OID_TIPO_SOLI_PAIS, ");
        cadena.append(" COD_VENT, ");
        cadena.append(" TERR_OID_TERR, "); // 17/01/2007
        cadena.append(" IND_FLAG_VENT ");
        
        if ((rec.getUnidadesVendidas() != null) && (rec.getUnidadesVendidas().booleanValue())) {
            cadena.append(", NUM_UNID_VEND, ");
            cadena.append(" IMP_VENT_NETA_ATEN, ");
            cadena.append(" IMP_VENT_BRUT_REAL ");
        }

        if ((rec.getUnidadesFaltantes() != null) && (rec.getUnidadesFaltantes().booleanValue())) {
            cadena.append(", NUM_UNID_FALT, ");
            cadena.append(" IMP_VENT_NETA_FALT, ");
            cadena.append(" IMP_VENT_BRUT_FALT ");
        }        
        
        if ((rec.getUnidadesDevueltas() != null) && (rec.getUnidadesDevueltas().booleanValue())) {
            cadena.append(", UNID_DEVU, ");
            cadena.append(" IMP_VENT_NETA_DEVU ");
        }
        
        if ((rec.getUnidadesAnuladas() != null) && (rec.getUnidadesAnuladas().booleanValue())) {
            cadena.append(", NUM_UNID_ANUL, ");
            cadena.append(" IMP_VENT_NETA_ANUL ");
        }
        
        if ((rec.getUnidadesCanje() != null) && (rec.getUnidadesCanje().booleanValue())) {
            cadena.append(", NUM_UNID_CANJ, ");
            cadena.append(" IMP_VENT_NETA_CANJ ");
        }
        
        if ((rec.getUnidadesTrueque() != null) && (rec.getUnidadesTrueque().booleanValue())) {
            cadena.append(", NUM_UNID_TRUE, ");
            cadena.append(" IMP_VENT_NETA_TRUE ");
        }
        
        /* SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 */
        cadena.append(" , ZORG_OID_REGI ");
        cadena.append(" , ZZON_OID_ZONA ");
        
        cadena.append(" ) VALUES ( ");
        cadena.append("INT_VDPP_SEQ.NEXTVAL, ");
        cadena.append(" TO_Date( '" + simpledateformat.format(fecha) +
                      "', 'DD-MM-YYYY'), ");
        cadena.append(rec.getOidSubAcceso() +  ",");
        cadena.append(rec.getOidPeriodo() +  ",");
        cadena.append(rec.getOidAlmacen() +  ",");
        cadena.append(rec.getOidTipoCliente() +  ",");
        cadena.append(rec.getOidSociedad() +  ",");
        cadena.append(rec.getOidProducto() +  ",");
        cadena.append(rec.getOidTipoOferta() +  ",");
        cadena.append(rec.getOidCondicionPromocion() +  ",");
        cadena.append(oidMonePaisLocal +  ",");
        cadena.append(rec.getOidCicloVida() +  ",");
        cadena.append(rec.getOidTipoSolicitudPais() +  ",");
        cadena.append("'"+ rec.getCodVenta() +  "',");

        cadena.append(rec.getOidTerritorio() +  ","); //17/01/2007
        
        if (rec.getFlagVenta().booleanValue())
            cadena.append(1);
        else
            cadena.append(0);
            
        if ((rec.getUnidadesVendidas() != null) && (rec.getUnidadesVendidas().booleanValue())) {
            /* BELC300024603 - dmorello, 08/01/2007 */
            //cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            //cadena.append(rec.getVentaNeta() +  ",");
            //cadena.append(rec.getPrecioCatalogoTotalLocal());
            cadena.append("," + rec.getUnidadesAtendidasVendidas() +  ",");
            cadena.append(rec.getVentaNetaVendidas() +  ",");
            cadena.append(rec.getPrecioCatalogoTotalLocalVendidas());
            /* Fin BELC300024603 - dmorello, 08/01/2007 */
        }

        if ((rec.getUnidadesFaltantes() != null) && (rec.getUnidadesFaltantes().booleanValue())) {
            /* SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 - Cambia el valor a asignar */
            //cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            /* BELC300024603 - dmorello, 08/01/2007 */
            //long unidadesFaltantes = rec.getUnidadesPorAtender().longValue() - rec.getUnidadesAtendidas().longValue();
            long unidadesFaltantes = rec.getUnidadesPorAtender().longValue() - rec.getUnidadesAtendidasFaltantes().longValue();
            cadena.append("," + unidadesFaltantes +  ",");
            //cadena.append(rec.getVentaNeta() +  ",");
            cadena.append(rec.getVentaNetaFaltantes() +  ",");
            //cadena.append(rec.getPrecioCatalogoTotalLocal());
            cadena.append(rec.getPrecioCatalogoTotalLocalFaltantes());
            /* Fin BELC300024603 - dmorello, 08/01/2007 */
        }        
        
        if ((rec.getUnidadesDevueltas() != null) && (rec.getUnidadesDevueltas().booleanValue())) {
            cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            cadena.append(rec.getVentaNeta());
        }
        
        if ((rec.getUnidadesAnuladas() != null) && (rec.getUnidadesAnuladas().booleanValue())) {
            /* BELC300024603 - dmorello, 08/01/2007 */
            //cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            cadena.append("," + rec.getUnidadesAtendidasAnuladas() +  ",");
            //cadena.append(rec.getVentaNeta());
            cadena.append(rec.getVentaNetaAnuladas());
            /* Fin BELC300024603 - dmorello, 08/01/2007 */
        }
        
        if ((rec.getUnidadesCanje() != null) && (rec.getUnidadesCanje().booleanValue())) {
            /* BELC300024603 - dmorello, 08/01/2007 */
            //cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            cadena.append("," + rec.getUnidadesAtendidasCanje() +  ",");
            //cadena.append(rec.getVentaNeta());
            cadena.append(rec.getVentaNetaCanje());
            /* Fin BELC300024603 - dmorello, 08/01/2007 */
        }
        
        if ((rec.getUnidadesTrueque() != null) && (rec.getUnidadesTrueque().booleanValue())) {
            /* BELC300024603 - dmorello, 08/01/2007 */
            //cadena.append("," + rec.getUnidadesAtendidas() +  ",");
            cadena.append("," + rec.getUnidadesAtendidasTrueque() +  ",");
            //cadena.append(rec.getVentaNeta());
            cadena.append(rec.getVentaNetaTrueque());
            /* Fin BELC300024603 - dmorello, 08/01/2007 */
        }
        
        /* SICC-GCC-INT-SAB-004 - dmorello, 04/12/2006 */
        cadena.append(',').append(rec.getOidRegion());
        cadena.append(',').append(rec.getOidZona());
        
        cadena.append(") ");
        UtilidadesLog.info("MONSAPBPSBean.armadoStrInsert(DTOVentaDiaProducto rec, java.sql.Date fecha): Salida");
        return cadena;
    }    
    
    /**
    * @param dtoBatch: Encapsula el objeto de tipo  DTOEnviarPedidosSAP.
    * @exception MareException
    * @return DTOSalidaBatch, con el mensaje si la interfaz fue ejecutada con
    *         exito o con error.
    */
    public DTOSalidaBatch enviarVentaDiaProducto(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarVentaDiaProducto(DTOBatch dtoBatch): Entrada");
        Cronometrador.startTransaction("MONSAPBPSBean.enviarVentaDiaProducto");
        String codigo = ISAPBPS.COD_INTERFAZ_SAB14;
        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarVentaDiaProducto  " + "---->Entrada\n\n\n  dtoBatch   " + dtoBatch);

        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        
        DTOEnviarPedidosSAP dtoe = null;
        DTOVentaDiaProducto dtoVentaDiaProductoTotales = new DTOVentaDiaProducto();

        try {
            dtoe = (DTOEnviarPedidosSAP) dtoBatch.getDTOOnline();
            UtilidadesLog.debug(" [ " + codigo + " ] RECIBIDO dtoInt  " + dtoe);
        } catch (ClassCastException cce) {
            UtilidadesLog.debug(" [ " + codigo + " ]**** ClassCastException  en  " + "enviarVentaDiaProducto salimos del método : ");
            throw new MareException("ClassCastException en enviarVentaDiaProducto", cce);
        }

        PeriodoLocalHome periodoHome = new PeriodoLocalHome();
        PeriodoLocal periodoLocal = null;
        try {
            periodoLocal = periodoHome.findByPrimaryKey(dtoe.getOidPeriodo());
        } catch (NoResultException fex) {
            UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos periodo");

            String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        InterfazInfo info = new InterfazInfo(codigo, dtoe.getNumeroLote().toString(), dtoe.getOidPais());
        info.setDescripcionLote(dtoe.getDescripcionLote());
        info.setObservaciones(dtoe.getObservaciones());

        interfaz = null;

        try {
            interfaz = gi.crearInterfaz(info);
            interfaz.setDescripcionLote(dtoe.getDescripcionLote());
            interfaz.setObservaciones(dtoe.getObservaciones());
        } catch (InterfacesException iex) {            
            UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException en " + "enviarVentaDiaProducto  ");
            UtilidadesLog.debug("Motivo: " + iex.getMotivo());
            throw new MareException("InterfacesException en enviarVentaDiaProducto", iex);
        } catch (RemoteException rex) {
            UtilidadesLog.debug(" [ " + codigo + " ] \n\n 2.-RemoteException en enviarVentaDiaProducto");            
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

//        this.borrarVentaDiaPorProducto(dtoe.getOidPeriodo(), dtoe.getFechaFacturacion());

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;
        try {
            paisLocal = paisHome.findByPrimaryKey(dtoe.getOidPais());
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONINTBatch.calcularVentaDiaProducto: FinderException, " + "no existe Pais = " + dtoe.getOidPais(), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        /* SICC-GCC-INT-SAB-004 - dmorello, 05/12/2006: Se genera el maestro de territorios */
        try {
            InterfazInfo interfaz29 = gi.obtenerInterfazInfo(ISAPBPS.COD_INTERFAZ_SAB29, dtoe.getOidPais());
        } catch (InterfacesException ie) {            
            UtilidadesLog.error("  MONSAPBPS.recepcionarEstimadosMAVAutomaticoBatch Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);
        } catch (RemoteException re) {
            UtilidadesLog.debug("*** Error MONSAPBPS.recepcionarEstimadosMAVAutomaticoBatch", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        
        this.dtoe = new DTOINTPantallaSAPBPS();
        this.dtoe.setDescripcionLote(dtoe.getDescripcionLote());
        this.dtoe.setObservaciones(dtoe.getObservaciones());
        this.dtoe.setOidPais(dtoe.getOidPais());
        this.dtoe.setMarca(periodoLocal.getOidMarca());
        this.dtoe.setCanal(periodoLocal.getOidCanal());
        this.dtoe.setPeriodo(periodoLocal.getOid());
        this.dtoe.setCodigo(ISAPBPS.COD_INTERFAZ_SAB29);
        this.dtoe.setNumeroLote(new Long(interfaz.getNumeroLote()));
        this.dtoe.setFechaFacturacion( dtoe.getFechaFacturacion() );
        
        DTOBatch dtoBatch29 = new DTOBatch("enviarMaestroTerritorios", new MareBusinessID("INTEnviarMaestroTerritoriosSAPBPS"), this.dtoe);
        try {
            BatchUtil.executeMLN(dtoBatch29, "INTProcesoInterfaces");
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** Error MONSAPBPS.enviarVentaDiaProducto", e);
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        /* Fin SAB-004 dmorello 05/12/2006 */

        
        /* IF agregado por dmorello, 08/01/2007 */
        //if (! listaVentaProductos.isEmpty()) { //gPineda - 17/01/2007 - Performance
        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        
        RecordSet rs = null;//dao.calcularVentaDia( dtoe, codigo );
        
         //19-01-2011 PER-SiCC-2011-0044 DOliva
         String indicadorEquivalencia = dao.obtenerIndicadorEquivalencias(this.dtoe.getOidPais());         
                 
         if(dao.obtenerCantidadEquivalencias() != 0){
             if(indicadorEquivalencia.equals("1")){
                 UtilidadesLog.warn("Equivalencia con datos - Indicador del bas_pais prendido, se ejecuta con equivalencia");
                 // logica de reemplazos
                 // 1.- Se inserta el resultado obtenido en una tabla temporal
                 dao.cargarTemporalVentaDia(dtoe, codigo);
                 // 2.- Se ejecuta el proceso de reemplazo x las equivalencias
                 dao.ejecutarProcesoEquivalencia(this.dtoe.getOidPais());
                 // 3.- Se llena el RecordSet con la data de la tabla temporal agrupada por los criterios del decu
                 rs =  dao.obtenerEquivalenciaVentaDia(); 
             }
             else{
                 //Como lo hace siempre
                  UtilidadesLog.warn("Equivalencia con datos - Indicador del bas_pais apagado, se ejecuta como siempre");
                 rs = dao.calcularVentaDia( dtoe, codigo );
             }
         }                        
         else{
             UtilidadesLog.warn("Equivalencia sin datos - se ejecuta como siempre");
             //Como lo hace siempre
             rs = dao.calcularVentaDia( dtoe, codigo );
         }
        
        boolean conRegistros = false;
        if (! rs.esVacio() ) {

        PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal periodoCorporativoLocal = null;

        try {
            periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        } catch (NoResultException fex) {
            UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos periodoCorporativo  ");

            String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        String codigoPeriodo = periodoCorporativoLocal.getCodigoPeriodo();
        String campania = codigoPeriodo.substring(codigoPeriodo.length() - 2);
        
        //BELC300016789
        Integer anioComercial = null;
        if (periodoCorporativoLocal != null) {
            anioComercial = new Integer(periodoCorporativoLocal.getAnio().toString());
        }
        MonedaLocalHome monedaLocalHome = this.getMonedaLocalHome();
        MonedaLocal monedaLocal = null;

        try {
            monedaLocal = monedaLocalHome.findByPrimaryKey(paisLocal.getMone_oid_mone());
        } catch (NoResultException e) {
            UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos moneda  ");

            String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0081;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DTOVentaDiaProducto dtoVentaDiaProducto = null;
        RegistroSicc registro = new RegistroSicc();
                
        boolean tomarDatosRegistro = true;
        
        //gPineda - 17/01/2007 - Performance
        int total = rs.getRowCount();
        UtilidadesLog.debug(" [ " + codigo + " ] Total registros a procesar"+ total);
        for( int i = 0; i < total ; i++){
            dtoVentaDiaProducto = this.crearDTOVentaDiaProducto( rs, i );
            
            codigoPeriodo= dao.obtenerCodigoPeriodo(dtoVentaDiaProducto.getOidPeriodo());
            anioComercial= new Integer(codigoPeriodo.substring(0,4));
            campania = codigoPeriodo.substring(codigoPeriodo.length() - 2);

            if (dtoVentaDiaProducto.getCodSociedad()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos empresa  ");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0070;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }
            
            if (dtoVentaDiaProducto.getCodAlmacen()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos almacenes  ");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0074;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }

            if (dtoVentaDiaProducto.getMedio()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos CodigoMedioSAPBPS ");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0071;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }
            
            if (dtoVentaDiaProducto.getCanalBPS()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos canalBPS");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0075;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }

            if (dtoVentaDiaProducto.getCodPerio()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos periodoCorporativo");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0061;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }
            
            if (dtoVentaDiaProducto.getCodSAP()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + "salimos maestroProductos");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0005;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }
            
            if (dtoVentaDiaProducto.getCodCicloVida()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos cicloVida");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0050;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }

            if (dtoVentaDiaProducto.getCodTipoOfer()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos tipoOferta");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0053;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }
            
            if (dtoVentaDiaProducto.getCodMarca()==null){
                UtilidadesLog.debug(" FinderException en enviarVentaDiaProducto nos " + " salimos Marca");
                String mensaje = "enviarVentaDiaProducto: " + ErroresDeNegocio.INT_0060;
                DTOINTError dtoError = new DTOINTError(interfaz, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);    
                continue; 
            } 
            
            if (tomarDatosRegistro) {
                tomarDatosRegistro = false;
                dtoVentaDiaProductoTotales.setOidPais(paisLocal.getOid());
                dtoVentaDiaProductoTotales.setOidSociedad(dtoVentaDiaProducto.getOidSociedad());
                dtoVentaDiaProductoTotales.setOidAlmacen(dtoVentaDiaProducto.getOidAlmacen());
                dtoVentaDiaProductoTotales.setCanalBPS(dtoVentaDiaProducto.getCanalBPS());
                dtoVentaDiaProductoTotales.setMedio(dtoVentaDiaProducto.getMedio());
                dtoVentaDiaProductoTotales.setAnioComercial(anioComercial);
                dtoVentaDiaProductoTotales.setOidPeriodo(dtoVentaDiaProducto.getOidPeriodo());
                dtoVentaDiaProductoTotales.setFechaFacturacion(dtoVentaDiaProducto.getFechaFacturacion());  
                dtoVentaDiaProductoTotales.setOidMoneda(monedaLocal.getOid()); 
            }
            
            Long unidadesVendidas = new Long(0);
            BigDecimal ventaNetaAtendida = new BigDecimal(0);
            BigDecimal ventaBrutaReal = new BigDecimal(0);

            Long unidadesFaltantes = new Long(0);
            BigDecimal ventaNetaFaltante = new BigDecimal(0);
            BigDecimal ventaBrutaFaltante = new BigDecimal(0);

            Long unidadesDevueltas = new Long(0);
            BigDecimal ventaNetaDevueltas = new BigDecimal(0);

            Long unidadesAnuladas = new Long(0);
            BigDecimal ventaNetaAnuladas = new BigDecimal(0);

            Long unidadesCanje = new Long(0);
            BigDecimal ventaNetaCanje = new BigDecimal(0);

            Long unidadesTrueque = new Long(0);
            BigDecimal ventaNetaTrueque = new BigDecimal(0);

            unidadesVendidas = dtoVentaDiaProducto.getUnidadesAtendidasVendidas();
            unidadesFaltantes = dtoVentaDiaProducto.getUnidadesAtendidasFaltantes();
            unidadesDevueltas = dtoVentaDiaProducto.getUnidadesAtendidasDevueltas();
            unidadesAnuladas = dtoVentaDiaProducto.getUnidadesAtendidasAnuladas();
            unidadesCanje = dtoVentaDiaProducto.getUnidadesAtendidasCanje();
            unidadesTrueque = dtoVentaDiaProducto.getUnidadesAtendidasTrueque();

            ventaNetaAtendida = dtoVentaDiaProducto.getVentaNetaVendidas();
            ventaNetaFaltante = dtoVentaDiaProducto.getVentaNetaFaltantes();
            ventaNetaDevueltas = dtoVentaDiaProducto.getVentaNetaDevueltas();
            ventaNetaAnuladas = dtoVentaDiaProducto.getVentaNetaAnuladas();
            ventaNetaCanje = dtoVentaDiaProducto.getVentaNetaCanje();
            ventaNetaTrueque = dtoVentaDiaProducto.getVentaNetaTrueque();
            ventaBrutaReal = dtoVentaDiaProducto.getPrecioCatalogoTotalLocalVendidas();
            ventaBrutaFaltante = dtoVentaDiaProducto.getPrecioCatalogoTotalLocalFaltantes();

            try {
                registro.vaciar();
                registro.anyadirCampo(ISAPBPS.SAB14_PAIS, paisLocal.getCod_pais());
                registro.anyadirCampo(ISAPBPS.SAB14_SOCIEDAD, dtoVentaDiaProducto.getCodSociedad());
                registro.anyadirCampo(ISAPBPS.SAB14_CENTRO, dtoVentaDiaProducto.getCodAlmacen());
                registro.anyadirCampo(ISAPBPS.SAB14_CANAL, dtoVentaDiaProducto.getCanalBPS());
                registro.anyadirCampo(ISAPBPS.SAB14_MEDIO, dtoVentaDiaProducto.getMedio());
                registro.anyadirCampo(ISAPBPS.SAB14_ANIO_COMERCIAL, anioComercial);
                registro.anyadirCampo(ISAPBPS.SAB14_CAMPANIA, new Integer(campania));

                // Modificado Incidencia BELC300016961
                registro.anyadirCampo(ISAPBPS.SAB14_CODIGO_PRODUCTO, dtoVentaDiaProducto.getCodSAP());
                registro.anyadirCampo(ISAPBPS.SAB14_CICLO_VIDA, dtoVentaDiaProducto.getCodCicloVida());

                //BELC300017189
                registro.anyadirCampo(ISAPBPS.SAB14_TIPO_OFERTA, dtoVentaDiaProducto.getCodTipoOfer());

                // INC. BELC300023428
                if (dtoVentaDiaProducto.getCodCondProm()!=null){
                    registro.anyadirCampo(ISAPBPS.SAB14_CONDICION_PROMOCION, dtoVentaDiaProducto.getCodCondProm());
                } else {
                    registro.anyadirCampo(ISAPBPS.SAB14_CONDICION_PROMOCION, "0");// se envia cero si no da error en el sistema que recepciona
                }
                
                //Modificado por BELC300016963
                registro.anyadirCampo(ISAPBPS.SAB14_FECHA, dtoVentaDiaProducto.getFechaFacturacion());

                Integer flag = new Integer(0);
                if (dtoVentaDiaProducto.getFlagVenta().booleanValue()) {
                    flag = new Integer(1);
                }

                registro.anyadirCampo(ISAPBPS.SAB14_FLAG_VENTA, flag);
                registro.anyadirCampo(ISAPBPS.SAB14_MONEDA_TRANSACCION, monedaLocal.getCodMoneda());
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_PROYECTADAS, new Long(0));
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_VENDIDAS, unidadesVendidas);
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_FALTANTES, unidadesFaltantes);
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_DEVUELTAS, unidadesDevueltas);
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_ANULADAS, unidadesAnuladas);
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_CANJE, unidadesCanje);
                registro.anyadirCampo(ISAPBPS.SAB14_UNIDADES_TRUEQUE, unidadesTrueque);
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_PROYECTADA, "0.00");

                //INT-SAP-03 GACEVEDO ----------------------------------------------->
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_ATENDIDAS, ventaNetaAtendida.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_FALTANTE, ventaNetaFaltante.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_DEVOLUCIONES, ventaNetaDevueltas.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_ANULACIONES, ventaNetaAnuladas.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_CANJES, ventaNetaCanje.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_NETA_TRUEQUES, ventaNetaTrueque.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_BRUTA_REAL, ventaBrutaReal.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_VENTA_BRUTA_FALTANTE, ventaBrutaFaltante.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB14_MARCA_PRODUCTO, dtoVentaDiaProducto.getCodMarca());
                registro.anyadirCampo(ISAPBPS.SAB14_TERRITORIO, dtoVentaDiaProducto.getTerritorio());
                
                try {
                    gi.anyadirRegistro(interfaz, registro);
                    conRegistros = true;
                } catch (RemoteException re) {                    
                    UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                registro.vaciar();
            } catch (InterfacesException fex) {
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En " + " enviarVentaDiaProducto  ");                
                registro.vaciar();
                continue;
            }
        } //Fin del bucle lista
        } /* Fin IF agregado dmorello 08/01/2007 */
        
        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        if (conRegistros) {
            this.generarInsertTotales(dtoVentaDiaProductoTotales);
        }
        
        Cronometrador.endTransaction("MONSAPBPSBean.enviarVentaDiaProducto");
        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarVentaDiaProducto  " + "---->SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.enviarVentaDiaProducto(DTOBatch dtoBatch): Salida");
             
        /* dmorello, 08/01/2007: Devuelvo el mensaje correspondiente segun se hayan enviado o no registros */
        //if (listaVentaProductos.isEmpty()) {
        if( !conRegistros ){
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        } else {
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
        }
    }

    public void enviarVentaDiaProductoBatch(DTOEnviarPedidosSAP dtoe) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarVentaDiaProductoBatch(DTOEnviarPedidosSAP dtoe): Entrada");

        DTOBatch dtoBatch = new DTOBatch("Enviar Venta Día Producto", new MareBusinessID("INTEnviarVentaDiaProducto"), dtoe);

        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        } catch (RemoteException re) {
            UtilidadesLog.error("#*ERROR*# MONSAPBPS:enviarVentaDiaProductoBatch", re);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONSAPBPSBean.enviarVentaDiaProductoBatch(DTOEnviarPedidosSAP dtoe): Salida");
    }

    public DTOSalidaBatch enviarPedidosDiaMarca(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosDiaMarca(DTOBatch dtoBatch): Entrada");

        String codigo = ISAPBPS.COD_INTERFAZ_SAB13;

        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        DTOEnviarPedidosSAP dtoe = null;
        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        DAOCRA daoCra = new DAOCRA();
        DTOOID dtoOid = new DTOOID();
        Integer anioComercial = null;
        
        try {
            //Extraer el DTOEnviarPedidosSAP del DTOBatch recibido 
            dtoe = (DTOEnviarPedidosSAP) dtoBatch.getDTOOnline();
            UtilidadesLog.debug(" [ " + codigo + " ] RECIBIDO dtoInt  " + dtoe);
        } catch (ClassCastException cce) {
            UtilidadesLog.debug(" [ " + codigo + " ]**** ClassCastException  en   enviarPedidosDiaMarca salimos del metodo : ");
            throw new MareException(" ClassCastException  en   enviarPedidosDiaMarca  ", cce);
        }

        // Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
        // handle de la interfaz que se va a procesar 
        InterfazInfo info = new InterfazInfo(codigo, dtoe.getNumeroLote().toString(), dtoe.getOidPais());

        //Rellenamos los atributos descripcionLote y observaciones del objeto info con los atributos descripcionLote y observaciones del dto 
        info.setDescripcionLote(dtoe.getDescripcionLote());
        info.setObservaciones(dtoe.getObservaciones());

        InterfazInfo interfaz = null;

        try {
            interfaz = gi.crearInterfaz(info); //crear un interfaz con el numeroLote recibido. 
            interfaz.setDescripcionLote(dtoe.getDescripcionLote());
            interfaz.setObservaciones(dtoe.getObservaciones());
        } catch (InterfacesException e) {
            UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarPedidosDiaMarca  ");
            throw new MareException("InterfacesException en enviarPedidosDiaMarca ", e);
        } catch (RemoteException e) {
            UtilidadesLog.debug(" [ " + codigo + " ] \n\n 2.-RemoteException En enviarPedidosDiaMarca  ");
            throw new MareException("RemoteException en enviarPedidosDiaMarca ", e);
        }

        //Calculamos el año comercial 
        dtoOid.setOid(dtoe.getOidPeriodo());
        DTOPeriodo dtoPeriodo = daoCra.obtenerPeriodo(dtoOid);
        if (dtoPeriodo == null) {            
            UtilidadesLog.debug(" en enviarPedidosDiaMarca nos salimos periodo ");
            String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);
        }

        dtoOid.setOid(dtoPeriodo.getOidPeriodoCorporativo());
        DTOPeriodo dtoPeriodoCorpo = dao.obtenerPeriodoCorporativo(dtoOid);
        anioComercial = dtoPeriodoCorpo.getAnio();

        ArrayList datosPedSAP = dao.obtenerDatosPedidosSAP( dtoe, codigo );
        this.enviarPedidosTotalesDia(anioComercial, (ArrayList)UtilidadesBelcorp.deepCopy( datosPedSAP ), dtoe);
        
        DTODatosPedSAP dtoDatosPedidosSAP = null;
        RegistroSicc registro = new RegistroSicc();

        //vamos a generar el interfaz 
        int tamano = datosPedSAP.size();

        for (int i = 0; i < tamano; i++) {
            dtoDatosPedidosSAP = (DTODatosPedSAP) datosPedSAP.get(i);

            PaisLocalHome paisLocalHome = this.getPaisLocalHome();
            PaisLocal paisLocal = null;

            try {
                paisLocal = paisLocalHome.findByPrimaryKey(dtoDatosPedidosSAP.getOidPais()); // de la entidad SEG:Pais 
            } catch (NoResultException fex) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0072;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            EmpresaLocalHome sociedadLocalHome = this.getEmpresaLocalHome();
            EmpresaLocal sociedadLocal = null;

            try {
                sociedadLocal = sociedadLocalHome.findByPrimaryKey(dtoDatosPedidosSAP.getOidSociedad()); //llamar al método findByPk(dtoDatosPedidosSAP.oidSociedad) de la entidad SEG:Empresa 
            } catch (NoResultException fex) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0070;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            AlmacenesLocalHome almacenLocalHome = this.getAlmacenesLocalHome();
            AlmacenesLocal almacenLocal = null;

            try {
                almacenLocal = almacenLocalHome.findByPrimaryKey(dtoDatosPedidosSAP.getOidAlmacen()); //llamar al método findByPk(dtoDatosPedidosSAP.almacen) de la entidad BEL: Almacen 
            } catch (NoResultException e) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0074;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            CanalBPSLocalHome canalBPSLocalHome = this.getCanalBPSLocalHome();
            CanalBPSLocal canalBPSLocal = null;

            try {
                canalBPSLocal = canalBPSLocalHome.findByUk(dtoDatosPedidosSAP.getOidTipoCliente(), dtoDatosPedidosSAP.getOidTipoSolicitud()); //llamar al método findByUk(dtoDatosPedidosSAP.oidTipoCliente, dtoDatosPedidosSAP.oidTipoSolicitudPais) de la entidad INT: CanalBPS 
            } catch (NoResultException fex) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0075;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            CodigoMedioSAPBPSLocalHome cMedioSAPBPSLocalHome = this.getCodigoMedioSAPBPSLocalHome();
            CodigoMedioSAPBPSLocal cMedioSAPBPSLocal = null;

            try {
                cMedioSAPBPSLocal = cMedioSAPBPSLocalHome.findByUk(dtoDatosPedidosSAP.getOidPais(), dtoDatosPedidosSAP.getOidSubAcceso()); // llamar al método findByUk(dtoDatosPedidosSAP.pais, dtoDatosPedidosSAP.oidSubAcceso) de la entidad INT: CodigoMedioSAPBPS 
            } catch (NoResultException fex) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0071;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
                continue;
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            dtoOid.setOid(dtoDatosPedidosSAP.getOidPeriodo());
            dtoPeriodo = daoCra.obtenerPeriodo(dtoOid);
            if (dtoPeriodo == null) {            
                UtilidadesLog.debug("en enviarPedidosDiaMarca nos salimos  periodo");
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0060;
                DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
            }

            dtoOid.setOid(dtoPeriodo.getOidPeriodoCorporativo());
            dtoPeriodoCorpo = dao.obtenerPeriodoCorporativo(dtoOid);

            MarcaLocalHome marcaLocalHome = this.getMarcaLocalHome();
            MarcaLocal marcaLocal = null;

            try {
                marcaLocal = marcaLocalHome.findByPrimaryKey(dtoPeriodo.getMarca());
            } catch (NoResultException fex) {
                UtilidadesLog.debug(" FinderException en enviarPedidosDiaMarca nos salimos  marca  ");

                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0073;
                DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            MarcaProductoLocalHome marcaprodLocalHome = this.getMarcaProductoLocalHome();
            MarcaProductoLocal marcaProdLocal = null;

            try {
                marcaProdLocal = marcaprodLocalHome.findByPrimaryKey( dtoDatosPedidosSAP.getOidMarcaProducto() ); 
            } catch (NoResultException fex) {
                UtilidadesLog.debug(" FinderException en enviarPedidosDiaMarca nos salimos  marca  ");

                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0073;
                DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            try {
                registro.vaciar();
                registro.anyadirCampo(ISAPBPS.SAB13_PAIS, paisLocal.getCod_pais());
                registro.anyadirCampo(ISAPBPS.SAB13_SOCIEDAD, sociedadLocal.getCodigo());
                registro.anyadirCampo(ISAPBPS.SAB13_CENTRO, almacenLocal.getCodigoAlmacen());
                registro.anyadirCampo(ISAPBPS.SAB13_CANAL, canalBPSLocal.getCanalBPS());
                registro.anyadirCampo(ISAPBPS.SAB13_MEDIO, cMedioSAPBPSLocal.getMedio());
                registro.anyadirCampo(ISAPBPS.SAB13_ANIO_COMERCIAL, anioComercial);

                String cod = dtoPeriodoCorpo.getCodigoPeriodo(); 
                String campCod = cod.substring(codigo.length() - 2);
                Integer campania = new Integer(campCod);
                registro.anyadirCampo(ISAPBPS.SAB13_CAMPANIA, campania); //Tomar las dos ultimas posiciones del string: PeriodoCorporativo.codigo y convertirlo a Integer) 
                
                //registro.anyadirCampo(ISAPBPS.SAB13_MARCA, marcaLocal.getCod_marc()); //Incidencia 16869
                registro.anyadirCampo(ISAPBPS.SAB13_MARCA, marcaProdLocal.getCodigo() ); //Incidencia 16869
                
                registro.anyadirCampo(ISAPBPS.SAB13_FECHA_FACTURACION, dtoe.getFechaFacturacion());
                
                /* BELC300024598 - dmorello, 04/01/2007: Paso a tomar #ordenes y #pedidos del DTO */
                //registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_ORDENES_DIA, new Long(numOrdenesDia.intValue())); //Se hace un Long por incidencia 16869 
                //registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_PEDIDOS_ACUMULADOS, new Long(numPedidosAcumulados.intValue())); //Se hace un Long por incidencia 16869 
                registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_ORDENES_DIA, dtoDatosPedidosSAP.getNumOrdenesDia());
                registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_PEDIDOS_ACUMULADOS, dtoDatosPedidosSAP.getNumPedidosAcumulados());

                try {
                    gi.anyadirRegistro(interfaz, registro);
                    UtilidadesLog.debug(" [ " + codigo + " ] hemos añadido el registro numero i= " + i);
                } catch (RemoteException re) {                    
                    UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                registro.vaciar();
            } catch (InterfacesException fex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarPedidosDiaMarca");                
                registro.vaciar();

                continue;
            }
        } //Fin del bucle lista

        // Agregado por cambio SiCC 20070125
        if(tamano < 1){
    
            PaisLocalHome paisLocalHome = this.getPaisLocalHome();
            PaisLocal paisLocal = null;

            try {
                paisLocal = paisLocalHome.findByPrimaryKey(dtoe.getOidPais()); // de la entidad SEG:Pais 
            } catch (NoResultException fex) {
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0072;
                DTOINTError dtoError = new DTOINTError(info, registro, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            
            dtoOid.setOid(dtoe.getOidPeriodo());
            dtoPeriodo = daoCra.obtenerPeriodo(dtoOid);
            if (dtoPeriodo == null) {            
                UtilidadesLog.debug("en enviarPedidosDiaMarca nos salimos  periodo");
                String mensaje = "enviarPedidosDiaMarca: " + ErroresDeNegocio.INT_0060;
                DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
                this.privadaregistrarError(dtoError, codigo, gi);
            }

            dtoOid.setOid(dtoPeriodo.getOidPeriodoCorporativo());
            dtoPeriodoCorpo = dao.obtenerPeriodoCorporativo(dtoOid);

        try {
                registro.vaciar();
                registro.anyadirCampo(ISAPBPS.SAB13_PAIS, paisLocal.getCod_pais());
                registro.anyadirCampo(ISAPBPS.SAB13_SOCIEDAD, "PE01" );
                registro.anyadirCampo(ISAPBPS.SAB13_CENTRO, "A01" );
                registro.anyadirCampo(ISAPBPS.SAB13_CANAL, "1");
                registro.anyadirCampo(ISAPBPS.SAB13_MEDIO, "0");
                registro.anyadirCampo(ISAPBPS.SAB13_ANIO_COMERCIAL, anioComercial);

                String cod = dtoPeriodoCorpo.getCodigoPeriodo();
                String campCod = cod.substring(codigo.length() - 2);
                Integer campania = new Integer(campCod);

                registro.anyadirCampo(ISAPBPS.SAB13_CAMPANIA, campania); 
                registro.anyadirCampo(ISAPBPS.SAB13_MARCA, "" ); 
                registro.anyadirCampo(ISAPBPS.SAB13_FECHA_FACTURACION, dtoe.getFechaFacturacion());
                registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_ORDENES_DIA, new Long(0));
                registro.anyadirCampo(ISAPBPS.SAB13_NUMERO_PEDIDOS_ACUMULADOS, new Long(0));

                try {
                    gi.anyadirRegistro(interfaz, registro);
                    UtilidadesLog.debug(" [ " + codigo + " ] hemos añadido el registro Con Valores 0 por no haber valores en la base de datos SiCC 20070125 " );
                } catch (RemoteException re) {                    
                    UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                registro.vaciar();
            } catch (InterfacesException fex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarPedidosDiaMarca");                
                registro.vaciar();

                
            }
        }
        // fin Agregado por cambio SiCC 20070125


    
        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosDiaMarca(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }
    
    
    /**
     * 25-07-2007   (Sapaza)modificado por incidencia SiCC-20070355, se agrega validacion de la fecha 
     *              de facturacion ingresada por el usuario este dentro del rango del periodo
     * @throws es.indra.mare.common.exception.MareException
     * @param dtoe
     */
    public void enviarPedidosDiaMarcaBatch(DTOEnviarPedidosSAP dtoe) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosDiaMarcaBatch(DTOEnviarPedidosSAP dtoe): Entrada");

        IMareDTO DTOOnline = dtoe;
        UtilidadesLog.debug("***MONAdam.DTOOnline: DTOOnline " + DTOOnline);
        //Obtenemos la fecha inicio y fin del periodo seleccionado    
        PeriodoLocalHome periodoCraLocalHome= new PeriodoLocalHome();
        PeriodoLocal periodo = null;
        try{
            periodo = periodoCraLocalHome.findByPrimaryKey(dtoe.getOidPeriodo());
        }catch(NoResultException fe){
              throw new MareException("FinderException EN procesarInterfaz PeriodoCorporativo ", fe);               
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        java.sql.Date fFactura =new java.sql.Date(dtoe.getFechaFacturacion().getTime());
        
        UtilidadesLog.debug("SCS fFactura: " + fFactura);
        UtilidadesLog.debug("SCS periodo.getFechainicio(): " + periodo.getFechainicio());
        UtilidadesLog.debug("SCS periodo.getFechaFin(): " + periodo.getFechaFin());

        //Validamos que la fecha de facturacion ingresada por el usuario este dentro del rango del periodo        
        if (! ((periodo.getFechainicio().getTime() <= fFactura.getTime()) && (periodo.getFechaFin().getTime() >= fFactura.getTime())) ) {
            UtilidadesLog.debug("la fecha no corrsponde con el periodo tirar excepcion");
            int codigoerr = UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                    ErroresDeNegocio.INT_0118);
            UtilidadesLog.debug("La fecha seleccionada esta fuera del periodo lanza "+codigoerr );
            throw new MareException(new Exception(),UtilidadesError.armarCodigoError( ConstantesSEG.MODULO_INT, "", 
                    ErroresDeNegocio.INT_0118 ));           
        }


        MareBusinessID IDOnline = new MareBusinessID("INTEnviarPedidosMarca");
        DTOBatch dtoBatch = new DTOBatch("Enviar Pedidos del día por marca", IDOnline, DTOOnline);

        try {
            UtilidadesLog.debug(" **** Antes de BatchUtil ***");
            BatchUtil.executeMLN(dtoBatch, new MareBusinessID("INTProcesoInterfaces"));
        } catch (RemoteException e) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosDiaMarcaBatch(DTOEnviarPedidosSAP dtoe): Salida");
    }

    /**
    * 
    * @cambio Se obtienen de manera correcta las unidades, las ventas netas, las zonas, las ordenes y los pedidos.
    * @autor gdmarzi (in istu)
    * 
    * Criterio de agrupacion: canal, pais, sociedad, centro(almacen), medio(canalbps), añoComercial, campaña.
    */
    public DTOSalidaBatch enviarVentasTotalesCampania(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarVentasTotalesCampania(DTOBatch dtoBatch): Entrada");
        String codigo = ISAPBPS.COD_INTERFAZ_SAB17;

        MONGestorInterfaces gi = this.getMONGestorInterfaces();        

        try {
            init(dtoBatch, codigo);
        } catch (MareException e) {            
            UtilidadesLog.error(" [ " + codigo + " ] Fallo al realizar init en  " + " enviarVentasTotalesCampania ");

            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        dao.borrarVentasTotalesCampania(dtoe.getPeriodo());

        ArrayList listaRegs = dao.obtenerDatosTotalesSAM17(dtoe.getPeriodo());
        
        //ArrayList listaRegs = dao.obtenerVentasTotalesCampania(dtoe.getPeriodo());

        if (listaRegs.isEmpty()) {
            /* dmorello, 08/01/2007 - Para que el archivo vacío no quede en carpeta temporal */
            try {
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
            } catch (RemoteException re) {            
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            /* Fin dmorello 08/01/2007 */
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        }

        PeriodoLocalHome pHome = new PeriodoLocalHome();
        PeriodoLocal pLocal = null;

        try {
            pLocal = pHome.findByPrimaryKey(this.dtoe.getPeriodo());
        } catch (NoResultException fe) {
            UtilidadesLog.debug(" FinderException en enviarVentasTotalesCampania " + " nos salimos  periodo  ");

            String mensaje = "enviarResumenTxPorSeccion: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PeriodoCorporativoLocalHome pcorpHome = this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal pCorpLocal = null;

        try {
            pCorpLocal = pcorpHome.findByPrimaryKey(pLocal.getOidPeriodoCorporativo());
        } catch (NoResultException fe) {
            UtilidadesLog.debug(" FinderException en enviarVentasTotalesCampania " + " nos salimos  periodoCorporativo ");

            String mensaje = "enviarResumenTxPorSeccion: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByPrimaryKey(dtoe.getOidPais());
        } catch (NoResultException fe) {
            UtilidadesLog.debug(" FinderException en enviarVentasTotalesCampania " + " nos salimos  periodoCorporativo  ");

            String mensaje = "enviarResumenTxPorSeccion: " + ErroresDeNegocio.INT_0003;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        MonedaLocalHome monedaLocalHome = this.getMonedaLocalHome();
        MonedaLocal monedaLocal = null;

        try {
            monedaLocal = monedaLocalHome.findByPrimaryKey(paisLocal.getMone_oid_mone());
        } catch (NoResultException e) {
            UtilidadesLog.debug(" FinderException en enviarVentasTotalesCampania nos " + " salimos moneda  ");

            String mensaje = "enviarVentasTotalesCampania: " + ErroresDeNegocio.INT_0081;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        RegistroSicc registro = new RegistroSicc();
        VentaTotalCampania ventaTotal = null;
        int n = listaRegs.size();

        for (int i = 0; i < n; i++) {
            ventaTotal = (VentaTotalCampania) listaRegs.get(i);

            try {
                registro.vaciar();
                registro.anyadirCampo(ISAPBPS.SAB17_CODIGO_PAIS, ventaTotal.getCodigoPais());
                registro.anyadirCampo(ISAPBPS.SAB17_CODIGO_SOCIEDAD, ventaTotal.getCodigoSociedad());
                registro.anyadirCampo(ISAPBPS.SAB17_CODIGO_ALMACEN, ventaTotal.getCodigoAlmacen());
                registro.anyadirCampo(ISAPBPS.SAB17_CANAL_BPS, ventaTotal.getCanalBPS());
                registro.anyadirCampo(ISAPBPS.SAB17_MEDIO, ventaTotal.getCodigoMedio());
                registro.anyadirCampo(ISAPBPS.SAB17_ANIO_COMERCIAL, new Integer(pCorpLocal.getAnio().intValue()));
                int corta = pCorpLocal.getCodigoPeriodo().length() - 2;
                String campa = pCorpLocal.getCodigoPeriodo().substring(corta);
                registro.anyadirCampo(ISAPBPS.SAB17_CAMPANIA, new Integer(campa));
                registro.anyadirCampo(ISAPBPS.SAB17_MONEDA_TRANSACCION, monedaLocal.getCodMoneda());

                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_VENDIDAS, ventaTotal.getUnidadesVendidasVendidas());
                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_FALTANTES, ventaTotal.getUnidadesVendidasFaltantes());
                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_DEVUELTAS, ventaTotal.getUnidadesVendidasDevueltas());
                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_ANULADAS, ventaTotal.getUnidadesVendidasAnuladas());
                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_CANJE, ventaTotal.getUnidadesVendidasCanje());
                registro.anyadirCampo(ISAPBPS.SAB17_UNIDADES_TRUEQUE, ventaTotal.getUnidadesVendidasTrueque());

                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_ATENDIDA, ventaTotal.getPrecioFacturaTotalLocalVendidas().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_FALTANTE, ventaTotal.getPrecioFacturaTotalLocalFaltantes().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_DEVOLUCIONES, ventaTotal.getPrecioFacturaTotalLocalDevueltas().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_ANULACIONES, ventaTotal.getPrecioFacturaTotalLocalAnuladas().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_CANJES, ventaTotal.getPrecioFacturaTotalLocalCanje().setScale(2, BigDecimal.ROUND_HALF_UP).toString());
                registro.anyadirCampo(ISAPBPS.SAB17_VENTA_NETA_TRUEQUES, ventaTotal.getPrecioFacturaTotalLocalTrueque().setScale(2, BigDecimal.ROUND_HALF_UP).toString());

                registro.anyadirCampo(ISAPBPS.SAB17_NUMERO_ZONAS, ventaTotal.getNumeroZonas());
                registro.anyadirCampo(ISAPBPS.SAB17_NUMERO_ORDENES, ventaTotal.getNumeroOrdenes());
                registro.anyadirCampo(ISAPBPS.SAB17_NUMERO_PEDIDOS, ventaTotal.getNumeroPedidos());
                registro.anyadirCampo(ISAPBPS.SAB17_FECHA_CIERRE,  pLocal.getFechaFin() );

                this.guardarVentaTotalCampania(ventaTotal, pLocal.getFechaFin(), paisLocal.getMone_oid_mone(), pLocal.getOid());

                try {
                    gi.anyadirRegistro(interfaz, registro);
                    UtilidadesLog.debug(" [ " + codigo + " ] hemos añadido el registro " + " numero i= " + i);
                } catch (RemoteException re) {                    
                    UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                registro.vaciar();
            } catch (InterfacesException fex) {
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException " + " En enviarResumenTxPorSeccion  ");                
                registro.vaciar();
                continue;
            }
        }

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]" + "Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.enviarVentasTotalesCampania(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }


    public DTOSalidaBatch enviarDemandaAnormal(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarDemandaAnormal(DTOBatch dtoBatch): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();

        String codigo = ISAPBPS.COD_INTERFAZ_SAB16;

        try {
            init(dtoBatch, codigo);
        } catch (MareException e) {            
            UtilidadesLog.error(" [ " + codigo + " ] Fallo al realizar init en enviarDemandaAnormal ");

            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();

        ArrayList listaRegs = dao.obtenerDemandaAnormal(dtoe.getPeriodo());

        if (listaRegs.isEmpty()) {
            /* dmorello, 08/01/2007 - Para que el archivo vacío no quede en carpeta temporal */
            try {
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
            } catch (RemoteException re) {            
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            /* Fin dmorello 08/01/2007 */
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        }

        PeriodoLocal periodo = null;

        try {
            periodo = new PeriodoLocalHome().findByPrimaryKey(dtoe.getPeriodo());
        } catch (NoResultException fe) {
            String mensaje = "enviarDemandaAnormal: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);

            try {
                gi.registrarError(dtoError);
            } catch (InterfacesException iex) {
                UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
            } catch (RemoteException rex) {                
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PeriodoCorporativoLocal periodoCorporativo = null;

        try {
            periodoCorporativo = this.getPeriodoCorporativoLocalHome().findByPrimaryKey(periodo.getOidPeriodoCorporativo());
        } catch (NoResultException fe) {
            String mensaje = "enviarDemandaAnormal: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);

            try {
                gi.registrarError(dtoError);
            } catch (InterfacesException iex) {
                UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
            } catch (RemoteException rex) {                
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        for (int i = 0; i < listaRegs.size(); i++) {
            DTOINTDemandaAnormal dto = (DTOINTDemandaAnormal) listaRegs.get(i);

            try {
                registro.vaciar();
                registro.anyadirCampo(ISAPBPS.SAB16_CODIGO_PAIS, dto.getCodigoPais());
                registro.anyadirCampo(ISAPBPS.SAB16_CODIGO_SOCIEDAD, dto.getCodigoSociedad());
                registro.anyadirCampo(ISAPBPS.SAB16_CODIGO_ALMACEN, dto.getCodigoAlmacen());
                registro.anyadirCampo(ISAPBPS.SAB16_CANAL_BPS, dto.getCanalBPS());
                registro.anyadirCampo(ISAPBPS.SAB16_MEDIO, dto.getMedio());
                registro.anyadirCampo(ISAPBPS.SAB16_ANIO_COMERCIAL, new Integer(periodoCorporativo.getAnio().intValue()));
                registro.anyadirCampo(ISAPBPS.SAB16_CAMPANIA, new Integer(periodoCorporativo.getCodigoPeriodo()));
                registro.anyadirCampo(ISAPBPS.SAB16_CODIGO_PRODUCTO, dto.getCodigoProducto());
                registro.anyadirCampo(ISAPBPS.SAB16_CICLO_VIDA, dto.getCodigoCicloVida());
                registro.anyadirCampo(ISAPBPS.SAB16_TIPO_OFERTA, dto.getCodigoTipoOferta());
                registro.anyadirCampo(ISAPBPS.SAB16_CODIGO_DEMANDA_ANORMAL, dto.getCodigoDemandaAnormal());
            } catch (InterfacesException iex) {
                UtilidadesLog.error(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarDemandaAnormal  ");                
                registro.vaciar();

                continue;
            }

            try {
                gi.anyadirRegistro(interfaz, registro);
            } catch (RemoteException re) {                
                UtilidadesLog.error(" [ " + codigo + " ] Error RemoteException en enviarDemandaAnormal");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (InterfacesException iex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.error(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarDemandaAnormal  ");                
            }

            registro.vaciar();
        }

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException iex) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);            
        } catch (RemoteException re) {            
            UtilidadesLog.error(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.enviarDemandaAnormal(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    public void enviarInterfacesDemandaAnormal(DTOINTPantallaSAPBPS dtoe) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarInterfacesDemandaAnormal(DTOINTPantallaSAPBPS dtoe): Entrada");
        DTOBatch dtoBatch = new DTOBatch("enviarDemandaAnormal", new MareBusinessID("INTEnviarDemandaAnormal"), dtoe);

        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        } catch (RemoteException e) {
            UtilidadesLog.debug("RemoteException MONSAPBPS:enviarInterfacesDemandaAnormal");            
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        dtoBatch = new DTOBatch("enviarVentasTotalesCampania", new MareBusinessID("INTEnviarVentasTotalesCampania"), dtoe);

        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        } catch (RemoteException e) {
            UtilidadesLog.debug("RemoteException MONSAPBPS:enviarInterfacesDemandaAnormal");            
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONSAPBPSBean.enviarInterfacesDemandaAnormal(DTOINTPantallaSAPBPS dtoe): Salida");
    }

    public DTOSalidaBatch enviarFuenteVentaReal(DTOBatch dtoBatch) throws MareException {
        //incidencias: 17106, 17112, 17735
        UtilidadesLog.warn("MONSAPBPSBean.enviarFuenteVentaReal(DTOBatch dtoBatch): Entrada");        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();
        String codigo = ISAPBPS.COD_INTERFAZ_SAB27;
        
        try {
            this.dtoe = (DTOINTPantallaSAPBPS) dtoBatch.getDTOOnline();
            //UtilidadesLog.debug(" [ " + codigo + " ] RECIBIDO dtoInt  " + dtoe);
        } catch (ClassCastException cce) {
            //UtilidadesLog.debug(" [ " + codigo + " ]**** ClassCastException  en   init salimos del metodo : ");
            throw new MareException(" ClassCastException  en   init  ", cce);
        }
        
        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        dao.borrarRegistrosFuenteVentas(this.dtoe.getPeriodo());

        ArrayList listaFVRA = calcularFuenteVentaReal(this.dtoe.getPeriodo());
        //UtilidadesLog.debug("listaFVRA: " + listaFVRA);
        
        /*
         * dmorello, 08/01/2007: Se quita este bloque para que se ejecuten las
         * 3 interfaces siguientes aunque en esta no haya registros. El mensaje a
         * devolver si no hay registros se retornara al final del codigo de este metodo.
         */
        //if (listaFVRA.isEmpty()) {
        //    return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        //}

        PeriodoLocalHome pHome = new PeriodoLocalHome();
        PeriodoLocal pLocal = null;

        try {
            pLocal = pHome.findByPrimaryKey(this.dtoe.getPeriodo());
        } catch (NoResultException fe) {
            //UtilidadesLog.debug(" FinderException en enviarFuenteVentaReal nos salimos  periodo  ");
            UtilidadesLog.warn(" FinderException en enviarFuenteVentaReal nos salimos  periodo  ");

            String mensaje = "enviarFuenteVentaReal: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        /* gPineda - 03/03/2007 
         * Esta validacion permite que solo se genere archivo para cuando sea fin de periodo.
         * Pedido expresamente por cambio .
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        String fechaActual = df.format( new Date() );
        UtilidadesLog.warn("pLocal.getFechaFin(): "+ df.format( pLocal.getFechaFin() ) );
        //UtilidadesLog.debug("fechaActual: "+ fechaActual );
        if( ! df.format( pLocal.getFechaFin() ).equals( fechaActual ) ){
            UtilidadesLog.warn("Interfaces SAP-BPS finalizadas sin generar archivos - Fecha distinta de fin de Periodo" );
            this.registrarLote( codigo );
            return new DTOSalidaBatch(0, "Interfaces SAP-BPS finalizadas sin generar archivos - Fecha Sistema distinta de fin de Periodo");
        }
        
        try {
            init(dtoBatch, codigo);
        } catch (MareException e) {            
            //UtilidadesLog.debug(" [ " + codigo + " ] Fallo al realizar init en enviarFuenteVentaReal ");
            UtilidadesLog.warn(" [ " + codigo + " ] Fallo al realizar init en enviarFuenteVentaReal ");
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        PeriodoCorporativoLocalHome pcorpHome = this.getPeriodoCorporativoLocalHome();
        PeriodoCorporativoLocal pCorpLocal = null;

        try {
            pCorpLocal = pcorpHome.findByPrimaryKey(pLocal.getOidPeriodoCorporativo());
        } catch (NoResultException fe) {
            //UtilidadesLog.debug(" FinderException en enviarFuenteVentaReal " + " nos salimos  periodoCorporativo  ");
            UtilidadesLog.warn(" FinderException en enviarFuenteVentaReal " + " nos salimos  periodoCorporativo  ");

            String mensaje = "enviarFuenteVentaReal: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PaisLocalHome paisLocalHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisLocalHome.findByPrimaryKey(this.dtoe.getOidPais());
        } catch (NoResultException fex) {
            UtilidadesLog.debug(" FinderException en enviarFuenteVentaReal " + " nos salimos  pais  ");
            UtilidadesLog.warn(" FinderException en enviarFuenteVentaReal " + " nos salimos  pais  ");

            String mensaje = "enviarFuenteVentaReal: " + ErroresDeNegocio.INT_0072 + " País no encontrado ";
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        MonedaLocalHome monedaLocalHome = this.getMonedaLocalHome();
        MonedaLocal monedaLocal = null;

        try {
            monedaLocal = monedaLocalHome.findByPrimaryKey(paisLocal.getMone_oid_mone());
        } catch (NoResultException fex) {
            UtilidadesLog.debug(" FinderException en enviarFuenteVentaReal " + " nos salimos  pais  ");
            UtilidadesLog.warn(" FinderException en enviarFuenteVentaReal " + " nos salimos  pais  ");

            String mensaje = "enviarFuenteVentaReal: " + ErroresDeNegocio.INT_0081 + " Moneda no encontrado ";
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);
            this.privadaregistrarError(dtoError, codigo, gi);

            return new DTOSalidaBatch(0, mensaje);
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        int tamLisCom = listaFVRA.size();
        UtilidadesLog.warn("tamLisCom: " + tamLisCom);
        for (int j = 0; j < tamLisCom; j++) {
            FuenteVentasRealAcumulada dto = (FuenteVentasRealAcumulada) listaFVRA.get(j);
            UtilidadesLog.debug("Posicion " + j + ": " + dto);
            if(dto.getCanalBPS() != null)
            {
                UtilidadesLog.debug(" -------- Canal bps = " + dto.getCanalBPS() );
                try {
                    registro.vaciar();
                    registro.anyadirCampo(ISAPBPS.SAB27_CODIGO_PAIS, dto.getCodigoPais());
                    registro.anyadirCampo(ISAPBPS.SAB27_CODIGO_SOCIEDAD, dto.getCodigoSociedad());
                    registro.anyadirCampo(ISAPBPS.SAB27_CODIGO_ALMACEN, dto.getCodigoAlmacen());
                    registro.anyadirCampo(ISAPBPS.SAB27_CANAL_BPS, dto.getCanalBPS());
                    registro.anyadirCampo(ISAPBPS.SAB27_ANIO_COMERCIAL, new Integer(pCorpLocal.getAnio().intValue())); //Incidencia 17112
                    registro.anyadirCampo(ISAPBPS.SAB27_MONEDA, monedaLocal.getCodMoneda());
                    int corta = pCorpLocal.getCodigoPeriodo().length() - 2;
                    String campa = pCorpLocal.getCodigoPeriodo().substring(corta);
                    registro.anyadirCampo(ISAPBPS.SAB27_CAMPANIA, new Integer(campa));
                    //registro.anyadirCampo(ISAPBPS.SAB27_CODIGO_ZONA, dto.getCodigoZona());
                    //registro.anyadirCampo(ISAPBPS.SAB27_CODIGO_REGION, dto.getCodigoRegion());
                    registro.anyadirCampo(ISAPBPS.SAB27_ACTIVAS_INICIALES, dto.getActivasIniciales());
                    registro.anyadirCampo(ISAPBPS.SAB27_ACTIVAS_FINALES, dto.getActivasFinales());
                    registro.anyadirCampo(ISAPBPS.SAB27_INGRESOS, dto.getIngresos());
                    registro.anyadirCampo(ISAPBPS.SAB27_REINGRESOS, dto.getReingresos());
                    registro.anyadirCampo(ISAPBPS.SAB27_EGRESOS, dto.getEgresos());
                    registro.anyadirCampo(ISAPBPS.SAB27_REZONIFICADAS_RECIBIDAS, dto.getRezonificadasRecibidas());
                    registro.anyadirCampo(ISAPBPS.SAB27_REZONIFICADAS_ENTREGADAS, dto.getRezonificadasEntregadas());
                    registro.anyadirCampo(ISAPBPS.SAB27_NUMERO_ORDENES, dto.getNumeroOrdenes());
                    registro.anyadirCampo(ISAPBPS.SAB27_NUMERO_PEDIDOS, dto.getNumeroPedidos());
                    registro.anyadirCampo(ISAPBPS.SAB27_UNIDADES_VENDIDAS, dto.getUnidadesVendidas());
                    registro.anyadirCampo(ISAPBPS.SAB27_NUMERO_CLIENTES, dto.getNumeroClientes());
                    // 23122 - dmorello, 16/05/2006: Seteo en marca producto el código de marca
                    registro.anyadirCampo(ISAPBPS.SAB27_MARCA_PRODUCTO, dto.getCodMarca());
                    registro.anyadirCampo(ISAPBPS.SAB27_TERRITORIO, dto.getTerritorio());

                    BigDecimal ventaNeta = dto.getVentaNetaEstadisticable();
    
                    if (ventaNeta != null) {
                        registro.anyadirCampo(ISAPBPS.SAB27_VENTA_NETA, ventaNeta.setScale(2).toString()); //17112
                        UtilidadesLog.debug("Venta Neta: " + ventaNeta.setScale(2).toString());
                    } else {
                        registro.anyadirCampo(ISAPBPS.SAB27_VENTA_NETA, null);
                    }
    
                    if(dto.getFechaCierre()!=null){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                        String sFechaCierre = sdf.format(dto.getFechaCierre());
                        registro.anyadirCampo(ISAPBPS.SAB27_FECHA_CIERRE, sFechaCierre );
                    }else{
                        registro.anyadirCampo(ISAPBPS.SAB27_FECHA_CIERRE, null );
                    }
                    try {
                        gi.anyadirRegistro(interfaz, registro);
                        UtilidadesLog.debug(" [ " + codigo + " ] hemos añadido el registro numero i= " + j);
                    } catch (RemoteException re) {                    
                        UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
    
                    registro.vaciar();
                     
                } catch (InterfacesException fex) {
                    //- se registra la excepción con el servicio MareLogging
                    UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarFuenteVentaReal  ");                
                    UtilidadesLog.warn(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarFuenteVentaReal  ");
                    registro.vaciar();
    
                    continue;
                }
            }//fin del if
        } //Fin del bucle lista

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            UtilidadesLog.warn(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        //modificado por eamores CAMBIO SAB-001
        //enviar maestroZonas
        dtoBatch = new DTOBatch( "enviarMaestroZonas",  new MareBusinessID( "INTEnviarMaestroZonas" ), this.dtoe );
        try
        {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        }
        catch (RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        // "Enviar Maestro de Regiones"
        dtoBatch = new DTOBatch( "enviarMaestroRegiones", new MareBusinessID( "INTEnviarMaestroRegiones" ), this.dtoe );
        try
        {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        } catch (RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        // "Enviar Maestro de Territorios"
        dtoBatch = new DTOBatch( "enviarMaestroTerritorios", new MareBusinessID( "INTEnviarMaestroTerritoriosSAPBPS" ), this.dtoe );
        try
        {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
        } catch (RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.warn("MONSAPBPSBean.enviarFuenteVentaReal(DTOBatch dtoBatch): Salida");
        /* dmorello, 08/01/2007 */
        //return new DTOSalidaBatch(0, "Interfaz " + codigo + " Procesada");
        if (listaFVRA.isEmpty()) {
            UtilidadesLog.warn("Interfaz " + codigo + " finalizado sin registros");
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        } else {
            UtilidadesLog.warn("Interfaz " + codigo + " Procesada");
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " Procesada");
        }
        /* Fin dmorello 08/01/2007 */
    }

    public DTOSalidaBatch enviarMaestroRegiones(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroRegiones(DTOBatch dtoBatch): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();
        
        String codigo = ISAPBPS.COD_INTERFAZ_SAB26;
        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarMaestroRegiones -> ENTRADA ");
        UtilidadesLog.debug("  dtoBatch   " + dtoBatch);

        try {
            init(dtoBatch, codigo);
        } catch (Exception ex) {            
            UtilidadesLog.error(" [ " + codigo + " ] Fallo al realizar init en enviarMaestroRegiones ");

            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        ArrayList listaRegiones = dao.obtenerMaestroRegiones(this.dtoe.getOidPais(), this.dtoe.getMarca(), this.dtoe.getCanal(), new Boolean(true), this.dtoe.getOidIdioma(), dtoe.getPeriodo());

        if ((listaRegiones == null) || listaRegiones.isEmpty()) {
            /* dmorello, 08/01/2007 - Para que el archivo vacío no quede en carpeta temporal */
            try {
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
            } catch (RemoteException re) {            
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            /* Fin dmorello 08/01/2007 */
            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado sin registros");
        }

        int n = listaRegiones.size();

        for (int i = 0; i < n; i++) {
            DTOMaestroRegiones dtoRegion = (DTOMaestroRegiones) listaRegiones.get(i);

            try {
                registro.anyadirCampo(ISAPBPS.SAB26_CODIGO_PAIS, dtoRegion.getCodPais());
                registro.anyadirCampo(ISAPBPS.SAB26_CODIGO_REGION, dtoRegion.getCodRegion());
                registro.anyadirCampo(ISAPBPS.SAB26_DESCRIPCION_REGION, dtoRegion.getDescripcionRegion());
                registro.anyadirCampo(ISAPBPS.SAB26_CODIGO_SOCIEDAD, dtoRegion.getCodSociedad() ); 
                registro.anyadirCampo(ISAPBPS.SAB26_MARCA, dtoRegion.getMarcaEstructural() ); 
                registro.anyadirCampo(ISAPBPS.SAB26_CANAL_BPS, dtoRegion.getCanalBPS() ); 
                registro.anyadirCampo(ISAPBPS.SAB26_SUBGERENCIA_VENTAS,dtoRegion.getSubgerenciaVentas());

                // Se añade el registro al fichero de interfaz
                try {
                    gi.anyadirRegistro(interfaz, registro);
                    ;
                } catch (RemoteException rex) {
                    UtilidadesLog.debug("RemoteException [" + codigo + "] MONSAPBPS:enviarMaestroRegiones");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                registro.vaciar();
            } catch (InterfacesException iex) {
                UtilidadesLog.debug("InterfacesException [" + codigo + "] MONSAPBPS:enviarMaestroRegiones");                

                continue;
            }
        } //Fin del bucle

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException iex) {
            UtilidadesLog.debug("InterfacesException [" + codigo + "] MONSAPBPS:enviarMaestroRegiones");            
        } catch (RemoteException rex) {
            UtilidadesLog.debug("RemoteException [" + codigo + "] MONSAPBPS:enviarMaestroRegiones");            
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarMaestroRegiones -> SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroRegiones(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    public DTOSalidaBatch enviarMaestroZonas(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroZonas(DTOBatch dtoBatch): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();
        String codigo = ISAPBPS.COD_INTERFAZ_SAB25;

        try {
            init(dtoBatch, codigo);
        } catch (MareException e) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Fallo al realizar init en enviarMaestroZonas ");

            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        ArrayList listaZonas = dao.obtenerMaestroZonas(dtoe.getOidPais(), dtoe.getMarca(), dtoe.getCanal(), Boolean.TRUE, dtoe.getOidIdioma(), dtoe.getPeriodo());

        if (listaZonas.isEmpty()) {
            String mensaje = "enviarMaestroZonas SinRegistros";
            /* dmorello, 08/01/2007 - Para que el archivo vacío no quede en carpeta temporal */
            try {
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
            } catch (RemoteException re) {            
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            /* Fin dmorello 08/01/2007 */
            return new DTOSalidaBatch(0, mensaje);
        }

        DTOMaestroZonas dtoZona = null;
        Iterator itlista = listaZonas.iterator(); 
        while(itlista.hasNext()){
            dtoZona = (DTOMaestroZonas) itlista.next(); 
            try{ 
            
            registro.vaciar();
            
            registro.anyadirCampo( ISAPBPS.SAB25_CODIGO_PAIS, dtoZona.getCodPais() ); 
            registro.anyadirCampo( ISAPBPS.SAB25_CODIGO_ZONA, dtoZona.getCodZona() ); 
            registro.anyadirCampo( ISAPBPS.SAB25_CODIGO_REGION, dtoZona.getCodRegion() );
            registro.anyadirCampo( ISAPBPS.SAB25_DESCRIPCION_ZONA, dtoZona.getDescripcionZona() );
            registro.anyadirCampo( ISAPBPS.SAB25_CODIGO_SOCIEDAD, dtoZona.getCodSociedad() );
            registro.anyadirCampo( ISAPBPS.SAB25_MARCA, dtoZona.getMarcaEstructural() ); 
            registro.anyadirCampo( ISAPBPS.SAB25_CANAL_BPS, dtoZona.getCanalBPS() ); 
            registro.anyadirCampo( ISAPBPS.SAB25_SUBGERENCIA_VENTAS, dtoZona.getSubgerenciaVentas() ); 
        
                // Se añade el registro al fichero de interfaz 
                gi.anyadirRegistro(interfaz, registro);
                registro.vaciar();
            } catch (RemoteException e) {                
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (InterfacesException e) {
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarMaestroZonas ");                
                continue;
            }
        }

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException e) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + e.getMotivo() + " ( " + e.getEx() + " )", e);            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarMaestroZonas  ---->SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroZonas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    public void enviarInterfacesFuenteVentaReal(DTOINTPantallaSAPBPS dtoe) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarInterfacesFuenteVentaReal(DTOINTPantallaSAPBPS dtoe): Entrada");
        UtilidadesLog.debug("DTOINTPantallaSAPBPS -> " + dtoe);

        
        /*
         * dmorello, 07/12/2006
         * Los CUs Enviar maestro de regiones, de zonas y de territorios son}
         * invocados por el CU Enviar fuente de ventas real (segun DECU y DMCO),
         * por lo cual se encuentra incorrecto llamarlos antes que este ultimo.
         */
        //DTOBatch dtoBatch = new DTOBatch("enviarMaestroZonas", new MareBusinessID("INTEnviarMaestroZonas"), dtoe);
        DTOBatch dtoBatch = null;
        
        //try {
        //    BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        //} catch (RemoteException re) {
        //    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        //    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        //}
        
        //dtoBatch = new DTOBatch("enviarMaestroTerritorios", new MareBusinessID("INTEnviarMaestroTerritoriosSAPBPS"), dtoe);

        //try {
        //    BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        //} catch (RemoteException re) {
        //    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        //    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        //}
        
        //dtoBatch = new DTOBatch("enviarMaestroRegiones", new MareBusinessID("INTEnviarMaestroRegiones"), dtoe);

        //try {
        //    BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        //} catch (RemoteException re) {
        //    String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        //    throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        //}
        /* Fin dmorello 07/12/2006 */

        dtoBatch = new DTOBatch("enviarFuenteVentaReal", new MareBusinessID("INTEnviarFuenteVentaReal"), dtoe);

        try {
            BatchUtil.executeMLN(dtoBatch, "INTProcesoInterfaces");
        } catch (RemoteException re) {
            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(re, UtilidadesError.armarCodigoError(codigoError));
        }
        UtilidadesLog.info("MONSAPBPSBean.enviarInterfacesFuenteVentaReal(DTOINTPantallaSAPBPS dtoe): Salida");
    }

    private void init(DTOBatch dtoBatch, String codigoInterfaz) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.init(DTOBatch dtoBatch, String codigoInterfaz): Entrada");
        UtilidadesLog.debug(" [ " + codigoInterfaz + " ] MONSAPBPS:init  ---->Entrada \n dtoBatch   " + dtoBatch + " String codigoInterfaz -->" + codigoInterfaz);
        MONGestorInterfaces gi = this.getMONGestorInterfaces();

        /*
            - en este método, si se produce una excepción, se encapsula en una MareException, y se lanza esta última

            dtoe = (DTOINTPantallaSAPBPS)dtoBatch.dtoOnline

            dao = new DAOINTSAPBPS()

            gestor = MONGestorInterfacesHome.create()

            interfaz = new InterfazInfo( codigoInterfaz,
            dtoe.numeroLote,
            dtoe.pais )
            interfaz.setObservaciones( dtoe.observaciones )
            interfaz.setDescripcion( dtoe.descripcionLote )

            info = gestor.crearInterfaz( info )

            registro = new RegistroSicc()

            * */
        ArrayList listaDtos = new ArrayList();

        //IRegistroSicc registro=null;
        try {
            this.dtoe = (DTOINTPantallaSAPBPS) dtoBatch.getDTOOnline();
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ] RECIBIDO dtoInt  " + dtoe);
        } catch (ClassCastException cce) {
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]**** ClassCastException  en   init salimos del metodo : ");
            throw new MareException(" ClassCastException  en   init  ", cce);
        }

        InterfazInfo interfazInfo = new InterfazInfo(codigoInterfaz, dtoe.getNumeroLote().toString(), dtoe.getOidPais());
        interfazInfo.setDescripcionLote(dtoe.getDescripcionLote());
        interfazInfo.setObservaciones(dtoe.getObservaciones());

        //UtilidadesLog.debug("interfaz creada + "+ interfaz.toString());
        gi = this.getMONGestorInterfaces();

        try {
            interfaz = gi.importarInterfaz(interfazInfo);
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]MIMPORTAMOS INTERFAZ : ");
        } catch (RemoteException re) {            
            UtilidadesLog.error(re);
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]**** 1.- INTERFACES EXCEPTION importarInterfaz ");            
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]===============================================");
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]ERROR: " + ie.getMotivo());
            UtilidadesLog.debug(" [ " + codigoInterfaz + " ]===============================================");

            //UtilidadesLog.debug("ERROR: "+ie.getEx().getMessage());
            throw new MareException("1.- INTERFACES EXCEPTION importarInterfaz ", ie);

            //return new DTOSalidaBatch( 0, "recEstiMAV fin con error" );
        }
    
        UtilidadesLog.debug(" [ " + codigoInterfaz + " ] MONSAPBPS:init  ---->SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.init(DTOBatch dtoBatch, String codigoInterfaz): Salida");
    }

    public DTOSalidaBatch recepcionarFuenteVentasPrevistaBatch(DTOBatch dtoBatch) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarFuenteVentasPrevistaBatch(DTOBatch dtoBatch): Entrada");

        IMareDTO dtoPais = dtoBatch.getDTOOnline();
        DTOOID dtoOid = new DTOOID();

        PaisLocalHome paisHome = this.getPaisLocalHome();
        PaisLocal paisLocal = null;

        try {
            paisLocal = paisHome.findByUk(dtoPais.getString("cadena"));
            dtoOid.setOid(paisLocal.getOid());
            this.recepcionarFuenteVentasPrevista(dtoOid);
        } catch (NoResultException fe) {
            UtilidadesLog.error("MONSAPBPSBean.recepcionarFuenteVentasPrevistaBatch: FinderException, no existe Pais = " + dtoPais.getString("cadena"), fe);
            throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarFuenteVentasPrevistaBatch(DTOBatch dtoBatch): Salida");

        return new DTOSalidaBatch(0, "recepcionarTiposOfertaBatch finalizado");
    }

    public void recepcionarFuenteVentasPrevista(DTOOID pais) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.recepcionarFuenteVentasPrevista(DTOOID pais): Entrada");
        UtilidadesLog.debug("pais -> " + pais);

        MONGestorInterfaces gi = this.getMONGestorInterfaces();

        InterfazInfo interfaz = null;

        try {
            interfaz = gi.importarInterfaz(ISAPBPS.COD_INTERFAZ_SAB11, pais.getOid());
        } catch (RemoteException re) {            
            UtilidadesLog.debug("***** Error RemoteException en MONSAPBPS.recepcionarFuenteVentasPrevista");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {            
            UtilidadesLog.debug("***** Error InterfacesException en MONSAPBPS.recepcionarFuenteVentasPrevista--> No hay Archivo");
            return;
            //throw new MareException(ie, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }



        IRegistroSicc registro = null;
        ArrayList listaRegs = null;
        HashMap listaGrupos = new HashMap();

        try {
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                String strPais = (String) registro.obtenerCampo(ISAPBPS.SAB11_PAIS);
                PaisLocal paisLocal = null;

                try {
                    paisLocal = this.getPaisLocalHome().findByUk(strPais);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003 + strPais);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                   
                String strSociedad = (String) registro.obtenerCampo(ISAPBPS.SAB11_SOCIEDAD);
                EmpresaLocal sociedad = null;

                try {
                    sociedad = this.getEmpresaLocalHome().findByUK(strSociedad);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0015 + strSociedad);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                String strAlmacen = (String) registro.obtenerCampo(ISAPBPS.SAB11_CENTRO);
                AlmacenesLocal almacen = null;

                try {
                    almacen = this.getAlmacenesLocalHome().findByUK(paisLocal.getOid(), strAlmacen);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0006 + strAlmacen);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                    //  Cambio SAPBPS001
                    String strMarca = (String) registro.obtenerCampo(ISAPBPS.SAB11_MARCA);
                    MarcaLocalHome marcaHome = this.getMarcaLocalHome();
                     MarcaLocal marca = null;

                         try {
                            marca = marcaHome.findByUK( strMarca );
                        } catch (NoResultException ex) {
                            try {
                                marca = marcaHome.findByUK(ConstantesSEG.COD_MARCA_T);
                            } catch (NoResultException fex) {
                                // - se registra con MareLogging el mensaje de error INT-0067   
                                String mensaje = "recepcionarFuenteVentasPrevista: " + ErroresDeNegocio.INT_0067; //--> hay que poner el 67
                                UtilidadesLog.debug(mensaje);
                
                                continue;
                            }
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                // fin Cambio SAPBPS001
                
                String strCanal = (String) registro.obtenerCampo(ISAPBPS.SAB11_CANAL);
                CanalLocal canal = null;

                try {
                    canal = this.getCanalLocalHome().findByUK(strCanal);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0035 + strCanal);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                UtilidadesLog.log("PeriodoCorporativo" + registro.obtenerCampo(ISAPBPS.SAB11_CAMPANIA_PERIODO));

                String strPeriodoCorporativo = registro.obtenerCampo(ISAPBPS.SAB11_CAMPANIA_PERIODO).toString();
                PeriodoCorporativoLocal periodoCorporativo = null;

                try {
                    periodoCorporativo = this.getPeriodoCorporativoLocalHome().findByUK(strPeriodoCorporativo);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0061 + strPeriodoCorporativo);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }

                PeriodoLocal periodo = null;

                try {
                    periodo = new PeriodoLocalHome().findByUk(periodoCorporativo.getOid(), marca.getOid(), paisLocal.getOid(), canal.getOid());
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0054 + strPeriodoCorporativo);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                String strRegion = (String) registro.obtenerCampo(ISAPBPS.SAB11_REGION);
                RegionLocal region = null;

                //BELC300016878
                try {
                    region = this.getRegionLocalHome().findByPaisMarcaCanalYCodigo(paisLocal.getOid(), marca.getOid(), canal.getOid(), strRegion);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0068 + strRegion);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                String strZona = (String) registro.obtenerCampo(ISAPBPS.SAB11_ZONA);
                ZonaLocal zona = null;

                Collection colZona = null;

                try {
                    colZona = this.getZonaLocalHome().findByCodigo(region.getOid(), strZona);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0027 + strZona);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if (colZona.isEmpty()) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0027 + strZona);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }

                Iterator itZona = colZona.iterator();
                zona = (ZonaLocal) itZona.next();

                if (zona.getOidRegion().compareTo(region.getOid()) != 0) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0027 + strZona);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }

                String strMoneda = (String) registro.obtenerCampo(ISAPBPS.SAB11_MONEDA);
                MonedaLocal moneda = null;

                try {
                    moneda = this.getMonedaLocalHome().findByUK(strMoneda);
                } catch (NoResultException fe) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0056 + strCanal);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                DTOINTEstimadoFuenteVentas dtoEstimado = new DTOINTEstimadoFuenteVentas();
                dtoEstimado.setZona(zona.getOid());
                dtoEstimado.setRegion(region.getOid());
                dtoEstimado.setPeriodo(periodo.getOid());
                dtoEstimado.setCanal(canal.getOid());
                dtoEstimado.setEmpresa(sociedad.getOid());
                dtoEstimado.setOidPais(paisLocal.getOid());
                dtoEstimado.setMoneda(moneda.getOid());

                dtoEstimado.setAnioComercial((Integer) registro.obtenerCampo(ISAPBPS.SAB11_ANIO_COMERCIAL));
                dtoEstimado.setActivasIniciales((Long) registro.obtenerCampo(ISAPBPS.SAB11_ACTIVAS_INICIALES));
                dtoEstimado.setActivasFinales((Long) registro.obtenerCampo(ISAPBPS.SAB11_ACTIVAS_FINALES));
                dtoEstimado.setIngresos((Long) registro.obtenerCampo(ISAPBPS.SAB11_INGRESOS));
                dtoEstimado.setReingresos((Long) registro.obtenerCampo(ISAPBPS.SAB11_REINGRESOS));
                dtoEstimado.setEgresos((Long) registro.obtenerCampo(ISAPBPS.SAB11_EGRESOS));
                dtoEstimado.setRezonificadasRecibidas((Long) registro.obtenerCampo(ISAPBPS.SAB11_REZONIFICADAS_RECIBIDAS));
                dtoEstimado.setRezonificadasEntregadas((Long) registro.obtenerCampo(ISAPBPS.SAB11_REZONIFICADAS_ENTREGADAS));
                dtoEstimado.setNumeroOrdenes((Long) registro.obtenerCampo(ISAPBPS.SAB11_NUMERO_ORDENES));
                dtoEstimado.setNumeroPedidos((Long) registro.obtenerCampo(ISAPBPS.SAB11_NUMERO_PEDIDOS));
                dtoEstimado.setUnidadesVendidas((Long) registro.obtenerCampo(ISAPBPS.SAB11_UNIDADES_VENDIDAS));
                dtoEstimado.setNumeroClientes((Long) registro.obtenerCampo(ISAPBPS.SAB11_NUMERO_CLIENTES));
                
                UtilidadesLog.debug("Venta Neta : "+  registro.obtenerCampo(ISAPBPS.SAB11_VENTA_NETA) +" "+ registro.obtenerCampo(ISAPBPS.SAB11_VENTA_NETA).getClass().getName() );
                //dtoEstimado.setVentaNetaEstadisticable((Long) registro.obtenerCampo(ISAPBPS.SAB11_VENTA_NETA));
                dtoEstimado.setVentaNetaEstadisticable((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB11_VENTA_NETA));
                
                dtoEstimado.setFechaCierre((Date) registro.obtenerCampo(ISAPBPS.SAB11_FECHA_CIERRE));
                dtoEstimado.setCentro(almacen.getOid());

                // Cambio SiCC 20070511 - dmorello
                dtoEstimado.setActividadInfladaZona((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB11_ACTIVIDAD_INFLADA_ZONA));
                dtoEstimado.setNroConsultorasClientesPrivilege((Long) registro.obtenerCampo(ISAPBPS.SAB11_NRO_CONSULTORAS_CLIENTES_PRIVILEGE));
                dtoEstimado.setNroClientesInscritosPrivilege((Long) registro.obtenerCampo(ISAPBPS.SAB11_NRO_CLIENTES_INSCRITOS_PRIVILEGE));
                dtoEstimado.setNroClientesTransaccionesPrivilege((Long) registro.obtenerCampo(ISAPBPS.SAB11_NRO_CLIENTES_TRANSACCIONES_PRIVILEGE));
                dtoEstimado.setRetencion2doPedido((Long) registro.obtenerCampo(ISAPBPS.SAB11_RETENCION_2DO_PEDIDO));
                dtoEstimado.setRetencion3erPedido((Long) registro.obtenerCampo(ISAPBPS.SAB11_RETENCION_3ER_PEDIDO));
                dtoEstimado.setRetencion4toPedido((Long) registro.obtenerCampo(ISAPBPS.SAB11_RETENCION_4TO_PEDIDO));
                dtoEstimado.setRetencionActivas((Long) registro.obtenerCampo(ISAPBPS.SAB11_RETENCION_ACTIVAS));
                dtoEstimado.setPorcentajeRotacion((BigDecimal)registro.obtenerCampo(ISAPBPS.SAB11_PORCENTAJE_ROTACION));
                dtoEstimado.setPosiblesEgresos((Long) registro.obtenerCampo(ISAPBPS.SAB11_POSIBLES_EGRESOS));
                dtoEstimado.setRetencionPosiblesEgresos((Long) registro.obtenerCampo(ISAPBPS.SAB11_RETENCION_POSIBLES_EGRESOS));
                dtoEstimado.setPorcentajeEgresos((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB11_PORCENTAJE_EGRESOS));
                dtoEstimado.setPup((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB11_PUP));
                dtoEstimado.setPpu((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB11_PPU));
                // Fin cambio SiCC 20070511 - dmorello

                listaRegs = (ArrayList) listaGrupos.get(paisLocal.getOid().toString());

                if (listaRegs == null) {
                    listaRegs = new ArrayList();
                    listaGrupos.put(paisLocal.getOid().toString(), listaRegs);
                }

                listaRegs.add(dtoEstimado);
            }
        } catch (RemoteException re) {           
            UtilidadesLog.debug("***** Error RemoteException en MONSAPBPS.recepcionarFuenteVentasPrevista");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (InterfacesException ie) {
            // - si la carga del registro produce una InterfacesException, se registra mediante MareLogging, 
            // y se continúa con el registro siguiente            
            UtilidadesLog.debug(ie);

            // continue;
        }

        Iterator itGrupos = listaGrupos.values().iterator();

        while (itGrupos.hasNext()) {
            listaRegs = (ArrayList) itGrupos.next();

            DTOINTEstimadoFuenteVentas dto = (DTOINTEstimadoFuenteVentas) listaRegs.get(0);

            PaisLocal paisLocal = null;

            try {
                paisLocal = this.getPaisLocalHome().findByPrimaryKey(dto.getOidPais());
            } catch (NoResultException fe) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003 + dto.getOidPais());

                try {
                    gi.registrarError(dtoError);
                } catch (InterfacesException iex) {
                    UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                } catch (RemoteException rex) {                    
                    UtilidadesLog.debug("error RemoteException");
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            if ((dto.getMoneda() != null) && (dto.getMoneda().compareTo(paisLocal.getMone_oid_mone()) != 0)) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0056);

                try {
                    gi.registrarError(dtoError);
                } catch (InterfacesException iex) {
                    UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                } catch (RemoteException rex) {
                    
                    UtilidadesLog.debug("error RemoteException");
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                continue;
            }

            Long oidMoneda = dto.getMoneda();

            for (int i = 1; i < listaRegs.size(); i++) {
                dto = (DTOINTEstimadoFuenteVentas) listaRegs.get(i);

                if (dto.getMoneda().compareTo(oidMoneda) != 0) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0056);

                    try {
                        gi.registrarError(dtoError);
                    } catch (InterfacesException iex) {
                        UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                    } catch (RemoteException rex) {                        
                        UtilidadesLog.debug("error RemoteException");
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }

                    continue;
                }
            }
        }

        itGrupos = listaGrupos.values().iterator();

        while (itGrupos.hasNext()) {
            listaRegs = (ArrayList) itGrupos.next();

            for (int i = 0; i < listaRegs.size(); i++) {
                DTOINTEstimadoFuenteVentas dto = (DTOINTEstimadoFuenteVentas) listaRegs.get(i);
                FuenteVentasPrevistaSAPLocal fuenteVentas = null;
                FuenteVentasPrevistaSAPLocalHome fvpLH = this.getFuenteVentasPrevistaSAPLocalHome();

                try {
                    //Pendiente de BELC300016951. Actualmente con Ñapa para que medio funcione.
                    fuenteVentas = fvpLH.findByUK(dto.getZona(), dto.getPeriodo(), dto.getEmpresa(), dto.getCentro());
                } catch (NoResultException fe) {
                    try {
                        fuenteVentas = fvpLH.create(dto.getZona(), dto.getPeriodo(), dto.getEmpresa(), dto.getCentro());
                    } catch (PersistenceException e) {
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0069); //hay que poner el 69
                        try {
                            gi.registrarError(dtoError);
                        } catch (InterfacesException iex) {
                            UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
                        } catch (RemoteException rex) {
                            
                            UtilidadesLog.debug("error RemoteException");
                            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }
                    }
                }  catch (PersistenceException ce) {
                     UtilidadesLog.error("ERROR ", ce);
                     throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                //Incidencia BELC300016956
                fuenteVentas.setMoneda(dto.getMoneda());

                /*fuenteVentas.setEmpresa(dto.getEmpresa());
                fuenteVentas.setCentro(dto.getCentro());*/
                fuenteVentas.setRegion(dto.getRegion());
                fuenteVentas.setAnnioComercial(dto.getAnioComercial());
                fuenteVentas.setActivasIniciales(dto.getActivasIniciales());
                fuenteVentas.setActivasFinales(dto.getActivasFinales());
                fuenteVentas.setIngresos(dto.getIngresos());
                fuenteVentas.setReingresos(dto.getReingresos());
                fuenteVentas.setEgresos(dto.getEgresos());
                fuenteVentas.setRezonificadasRecibidas(dto.getRezonificadasRecibidas());
                fuenteVentas.setRezonificadasEntregadas(dto.getRezonificadasEntregadas());
                fuenteVentas.setNumeroOrdenes(dto.getNumeroOrdenes());
                fuenteVentas.setNumeroPedidos(dto.getNumeroPedidos());
                fuenteVentas.setUnidadesVendidas(dto.getUnidadesVendidas());
                fuenteVentas.setNumeroClientes(dto.getNumeroClientes());
                
                //fuenteVentas.setVentaNetaEstadisticable(new Double(dto.getVentaNetaEstadisticable().longValue()));
                fuenteVentas.setVentaNetaEstadisticable(new Double( dto.getVentaNetaEstadisticable().doubleValue() ));
                
                fuenteVentas.setFechaCierre(new java.sql.Date(dto.getFechaCierre().getTime()));

                // Cambio SiCC 20070511 - dmorello
                fuenteVentas.setActividadInfladaZona(dto.getActividadInfladaZona());
                fuenteVentas.setNroConsultorasClientesPrivilege(dto.getNroConsultorasClientesPrivilege());
                fuenteVentas.setNroClientesInscritosPrivilege(dto.getNroClientesInscritosPrivilege());
                fuenteVentas.setNroClientesTransaccionesPrivilege(dto.getNroClientesTransaccionesPrivilege());
                fuenteVentas.setRetencion2doPedido(dto.getRetencion2doPedido());
                fuenteVentas.setRetencion3erPedido(dto.getRetencion3erPedido());
                fuenteVentas.setRetencion4toPedido(dto.getRetencion4toPedido());
                fuenteVentas.setRetencionActivas(dto.getRetencionActivas());
                fuenteVentas.setPorcentajeRotacion(dto.getPorcentajeRotacion());
                fuenteVentas.setPosiblesEgresos(dto.getPosiblesEgresos());
                fuenteVentas.setRetencionPosiblesEgresos(dto.getRetencionPosiblesEgresos());
                fuenteVentas.setPorcentajeEgresos(dto.getPorcentajeEgresos());
                fuenteVentas.setPup(dto.getPup());
                fuenteVentas.setPpu(dto.getPpu());
                // Fin cambio SiCC 20070511 - dmorello
                fvpLH.merge(fuenteVentas);

            }
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarFuenteVentasPrevista(DTOOID pais): Salida");
    }



    private void privadaregistrarError(DTOINTError dtoError, String codigo, MONGestorInterfaces gestor) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.privadaregistrarError(DTOINTError dtoError, String codigo, MONGestorInterfaces gestor): Entrada");
        UtilidadesLog.debug("\n PRIVADO registrarError   Entrada");

        try {
            gestor.registrarError(dtoError);
        } catch (InterfacesException ie) {
            UtilidadesLog.error("\n\n InterfacesException PRIVATE registrarError");
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException En PRIVATE registrarError");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.info("MONSAPBPSBean.privadaregistrarError(DTOINTError dtoError, String codigo, MONGestorInterfaces gestor): Salida");
    }



    // Incidencia BELC300016794
    //public void enviarPedidosTotalesDia(Integer anioComercial, Date fechaFacturacion, ArrayList datosPedSAP, Integer numOrdenesDia, Integer numPedidosAcumulado, Long pais) throws MareException {
    //incidencias 21944-5
    /* BELC300024598 - dmorello, 04/01/2007: Se quitan los parámetros numOrdenesDia y numPedidosAcumulado */
    public void enviarPedidosTotalesDia(Integer anioComercial, ArrayList datosPedSAP, DTOEnviarPedidosSAP dtoe) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosTotalesDia(Integer anioComercial, Date fechaFacturacion, ArrayList datosPedSAP, Integer numOrdenesDia, Integer numPedidosAcumulado, Long pais): Entrada");
        String codigo = ISAPBPS.COD_INTERFAZ_SAB12;
        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarPedidosTotalesDia ----> Entrada ");
        Long pais = dtoe.getOidPais();
        Date fechaFacturacion = dtoe.getFechaFacturacion();
        
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();
        // Se construye un objeto InterfazInfo con los valores que llegan a la entrada, para utilizarlo como 
        // handle de la interfaz que se va a procesar
        

        try {
            InterfazInfo info = new InterfazInfo(ISAPBPS.COD_INTERFAZ_SAB12, dtoe.getNumeroLote().toString(), pais);
            info.setDescripcionLote(dtoe.getDescripcionLote());
            info.setObservaciones(dtoe.getObservaciones());
            //creamos una interfaz con el numeroLote recibido.
            interfaz = gi.crearInterfaz(info);
            interfaz.setDescripcionLote(dtoe.getDescripcionLote());
            interfaz.setObservaciones(dtoe.getObservaciones());
        } catch (InterfacesException iex) {
            UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);            
        } catch (RemoteException rex) {
            UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");            
            throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        // Vamos a generar la interfaz
        DTODatosPedSAP dtoDatosPedSAP = null;

        datosPedSAP = new DAOINTSAPBPS().obtenerDatosPedidosSAP( dtoe, codigo);
        //datosPedSAP = this.reagruparSAB12(datosPedSAP);

        int tamanio = datosPedSAP.size();

        for (int i = 0; tamanio > i; i++) {
            dtoDatosPedSAP = (DTODatosPedSAP) datosPedSAP.get(i);

            PaisLocalHome paisLocalHome = this.getPaisLocalHome();
            PaisLocal paisLocal = null;

            try {
                paisLocal = paisLocalHome.findByPrimaryKey(dtoDatosPedSAP.getOidPais());
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0072);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);                    
                }

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            EmpresaLocalHome sociedadLocalHome = this.getEmpresaLocalHome();
            EmpresaLocal sociedadLocal = null;

            try {
                sociedadLocal = sociedadLocalHome.findByPrimaryKey(dtoDatosPedSAP.getOidSociedad()); //de la entidad SEG:Empresa 
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0070);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);                    
                }

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            AlmacenesLocalHome almacenesLocalHome = this.getAlmacenesLocalHome();
            AlmacenesLocal almacenesLocal = null;

            try {
                almacenesLocal = almacenesLocalHome.findByPrimaryKey(dtoDatosPedSAP.getOidAlmacen()); //de la entidad BEL: Almacen 
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0074);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);
                }

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }

            CanalBPSLocalHome canalBPSLocalHome = this.getCanalBPSLocalHome();
            CanalBPSLocal canalBPSLocal = null;

            try {
                canalBPSLocal = canalBPSLocalHome.findByUk(dtoDatosPedSAP.getOidTipoCliente(), dtoDatosPedSAP.getOidTipoSolicitud()); // de la entidad INT: CanalBPS 
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0075);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);                    
                }

                continue;
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            CodigoMedioSAPBPSLocalHome codigoMedioSAPBPSLocalHome = this.getCodigoMedioSAPBPSLocalHome();
            CodigoMedioSAPBPSLocal codigoMedioSAPBPSLocal = null;

            try {
                codigoMedioSAPBPSLocal = codigoMedioSAPBPSLocalHome.findByUk(dtoDatosPedSAP.getOidPais(), dtoDatosPedSAP.getOidSubAcceso()); //de la entidad INT: CodigoMedioSAPBPS 
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0071);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);                    
                }

                continue;
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

            PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
            PeriodoLocal periodoLocal = null;

            PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
            PeriodoCorporativoLocal periodoCorporativoLocal = null;

            try {
                periodoLocal = periodoLocalHome.findByPrimaryKey(dtoDatosPedSAP.getOidPeriodo()); // de la entidad CRA: Periodo 
                periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo()); // de la entidad SEG: Periodo 
            } catch (NoResultException fex) {
                DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0060);

                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug("[ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia " + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);
                }

                continue;
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            MarcaLocalHome marcaHome = this.getMarcaLocalHome();
            MarcaLocal marcaLocal = null;
            try { 
                    marcaLocal = marcaHome.findByPrimaryKey(periodoLocal.getOidMarca());
                }catch( NoResultException fex ) { 
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0060);
                try {
                    gi.registrarError(dtoError);
                } catch (RemoteException rex) {
                    UtilidadesLog.debug("[ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                    throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                } catch (InterfacesException iex) {
                    UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia " + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);
                }

                continue; 
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } 
            try {
                registro.vaciar();

                registro.anyadirCampo(ISAPBPS.SAB12_PAIS, paisLocal.getCod_pais());
                registro.anyadirCampo(ISAPBPS.SAB12_SOCIEDAD, sociedadLocal.getCodigo());
                registro.anyadirCampo(ISAPBPS.SAB12_CENTRO, almacenesLocal.getCodigoAlmacen());
                registro.anyadirCampo(ISAPBPS.SAB12_CANAL, canalBPSLocal.getCanalBPS());
                registro.anyadirCampo(ISAPBPS.SAB12_MEDIO, codigoMedioSAPBPSLocal.getMedio());
                registro.anyadirCampo(ISAPBPS.SAB12_ANIO_COMERCIAL, anioComercial);

                // Obtenemos los 2 ultimos caracteres y los transformamos a Integer
                int longitud = periodoCorporativoLocal.getCodigoPeriodo().length();
                String periodo = periodoCorporativoLocal.getCodigoPeriodo().substring(longitud - 2);

                registro.anyadirCampo(ISAPBPS.SAB12_CAMPANIA, new Integer(periodo));
                registro.anyadirCampo(ISAPBPS.SAB12_FECHA_FACTURACION, fechaFacturacion);

                // Incidencia Tipo de los campos en la Interface (BELC300016886)
                /* BELC300024598 - dmorello, 04/01/2007: tomare #ordens y #pedidos del DTODatosPedSAP */
                //registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_ORDENES_DIA, new Long(numOrdenesDia.intValue()));
                //registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_PEDIDOS_ACUMULADOS, new Long(numPedidosAcumulado.intValue()));
                registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_ORDENES_DIA, dtoDatosPedSAP.getNumOrdenesDia());
                registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_PEDIDOS_ACUMULADOS, dtoDatosPedSAP.getNumPedidosAcumulados());
                /* Fin dmorello 04/01/2007 */
                registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_PEDIDOS_PROYECTADOS, new Long(0));
                registro.anyadirCampo(ISAPBPS.SAB12_MARCA, marcaLocal.getCod_marc());
                
                try {
                    gi.anyadirRegistro(interfaz, registro);
                    UtilidadesLog.debug(" hemos añadido el registro numero i= " + i);
                } catch (RemoteException re) {                    
                    UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                    throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                registro.vaciar();
            } catch (InterfacesException fex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarPedidosTotalesDia  " + fex.getMotivo() + " ( " + fex.getEx() + " )", fex);                
                registro.vaciar();

                continue;
            }
        }
        
        // Agregado por Cambio SiCC 20070125
        if(tamanio < 1){
             PaisLocalHome paisLocalHome = this.getPaisLocalHome();
                PaisLocal paisLocal = null;
    
                try {
                    paisLocal = paisLocalHome.findByPrimaryKey(pais);
                } catch (NoResultException fex) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0072);
    
                    try {
                        gi.registrarError(dtoError);
                    } catch (RemoteException rex) {
                        UtilidadesLog.debug(" [ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } catch (InterfacesException iex) {
                        UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia" + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);                    
                    }

                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                PeriodoLocal periodoLocal = null;
    
                PeriodoCorporativoLocalHome periodoCorporativoLocalHome = this.getPeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal periodoCorporativoLocal = null;
    
                try {
                    periodoLocal = periodoLocalHome.findByPrimaryKey(dtoe.getOidPeriodo()); // de la entidad CRA: Periodo 
                    periodoCorporativoLocal = periodoCorporativoLocalHome.findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo()); // de la entidad SEG: Periodo 
                } catch (NoResultException fex) {
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0060);
    
                    try {
                        gi.registrarError(dtoError);
                    } catch (RemoteException rex) {
                        UtilidadesLog.debug("[ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } catch (InterfacesException iex) {
                        UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia " + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);
                    }
    
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                }
                MarcaLocalHome marcaHome = this.getMarcaLocalHome();
                MarcaLocal marcaLocal = null;
                try { 
                        marcaLocal = marcaHome.findByPrimaryKey(periodoLocal.getOidMarca());
                    }catch( NoResultException fex ) { 
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0060);
                    try {
                        gi.registrarError(dtoError);
                    } catch (RemoteException rex) {
                        UtilidadesLog.debug("[ " + codigo + " ] RemoteException MONSAPBPS:enviarPedidosTotalesDia");                    
                        throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    } catch (InterfacesException iex) {
                        UtilidadesLog.debug(" [ " + codigo + " ] InterfacesException MONSAPBPS:enviarPedidosTotalesDia " + iex.getMotivo() + " ( " + iex.getEx() + " )", iex);
                    }
    
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                  
                } 
         
                try{
                    registro.vaciar();
    
                    registro.anyadirCampo(ISAPBPS.SAB12_PAIS, paisLocal.getCod_pais() );
                    registro.anyadirCampo(ISAPBPS.SAB12_SOCIEDAD, "PE01" );
                    registro.anyadirCampo(ISAPBPS.SAB12_CENTRO, "A01" );
                    registro.anyadirCampo(ISAPBPS.SAB12_CANAL, "1" );
                    registro.anyadirCampo(ISAPBPS.SAB12_MEDIO, "0" );
                    registro.anyadirCampo(ISAPBPS.SAB12_ANIO_COMERCIAL, anioComercial);
    
                    // Obtenemos los 2 ultimos caracteres y los transformamos a Integer
                    int longitud = periodoCorporativoLocal.getCodigoPeriodo().length();
                    String periodo = periodoCorporativoLocal.getCodigoPeriodo().substring(longitud - 2);
    
                    registro.anyadirCampo(ISAPBPS.SAB12_CAMPANIA, new Integer(periodo));
                    registro.anyadirCampo(ISAPBPS.SAB12_FECHA_FACTURACION, fechaFacturacion);
    
                    registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_ORDENES_DIA, new Long(0));
                    registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_PEDIDOS_ACUMULADOS, new Long(0));
                    registro.anyadirCampo(ISAPBPS.SAB12_NUMERO_PEDIDOS_PROYECTADOS, new Long(0));
                    registro.anyadirCampo(ISAPBPS.SAB12_MARCA, marcaLocal.getCod_marc());
                    
                    try {
                        gi.anyadirRegistro(interfaz, registro);
                        UtilidadesLog.debug(" hemos añadido el registro con Valores en 0 por no haber registos en base de datos (SiCC 20070125)");
                    } catch (RemoteException re) {                    
                        UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                        throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
    
                    registro.vaciar();
                } catch (InterfacesException fex) {
                //- se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarPedidosTotalesDia  " + fex.getMotivo() + " ( " + fex.getEx() + " )", fex);                
                registro.vaciar();

             
            }
        }
        
        //FIN Agregado por Cambio SiCC 20070125
        
        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException ie) {
            UtilidadesLog.error(" [ " + codigo + " ] \n\n InterfacesException [CS]Excepcion de la Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
        } catch (RemoteException re) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.debug(" [ " + codigo + " ] MONINTDAT:enviarPedidosTotalesDia  ---->SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.enviarPedidosTotalesDia(Integer anioComercial, Date fechaFacturacion, ArrayList datosPedSAP, Integer numOrdenesDia, Integer numPedidosAcumulado, Long pais): Salida");
    }



    /**
    * 
    */
    private void guardarVentaTotalCampania(VentaTotalCampania v, Date fechaCierre, Long oidMoneda, Long oidPeriodo) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.guardarVentaTotalCampania(VentaTotalCampania v, Date fechaCierre, Long oidMoneda, Long oidPeriodo): Entrada");
        VentasTotalesCampaniaLocalHome home = this.getVentasTotalesCampaniaLocalHome();
        VentasTotalesCampaniaLocal local;
        try {
            local = home.create(oidPeriodo, v.getSociedad(), v.getAlmacen(), oidMoneda);

            local.setUnidadesVendidas(v.getUnidadesVendidasVendidas());
            local.setUnidadesFaltantes(v.getUnidadesVendidasFaltantes());
            local.setUnidadesDevueltas(v.getUnidadesVendidasDevueltas());
            local.setUnidadesAnuladas(v.getUnidadesVendidasAnuladas());
            local.setUnidadesCanje(v.getUnidadesVendidasCanje());
            local.setUnidadesTrueque(v.getUnidadesVendidasTrueque());

            local.setVentaNetaAtendida(v.getPrecioFacturaTotalLocalVendidas());
            local.setVentaNetaFaltante(v.getPrecioFacturaTotalLocalFaltantes());
            local.setVentaNetaDevolucion(v.getPrecioFacturaTotalLocalDevueltas());
            local.setVentaNetaAnulacion(v.getPrecioFacturaTotalLocalAnuladas());
            local.setVentaNetaCanje(v.getPrecioFacturaTotalLocalCanje());
            local.setVentaNetaTrueque(v.getPrecioFacturaTotalLocalTrueque());

            local.setVentaBrutaReal(v.getPrecioCatalogoTotalLocalVendidas());
            local.setVentaBrutaFaltante(v.getPrecioCatalogoTotalLocalFaltantes());

            local.setNumeroOrdenes(v.getNumeroOrdenes());
            local.setNumeroPedidos(v.getNumeroPedidos());
            local.setNumeroZonas(v.getNumeroZonas());
            local.setFechaCierre(new java.sql.Date(fechaCierre.getTime()));
            home.merge(local);

        } catch (PersistenceException ne) {            
            throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONSAPBPSBean.guardarVentaTotalCampania(VentaTotalCampania v, Date fechaCierre, Long oidMoneda, Long oidPeriodo): Salida");
    }




    public ArrayList calcularFuenteVentaReal(Long periodo) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.calcularFuenteVentaReal(Long periodo): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        ArrayList listaCompleta = new ArrayList();

        PeriodoLocal periodoLocal = null;

        try {
            periodoLocal = new PeriodoLocalHome().findByPrimaryKey(periodo);
        } catch (NoResultException fe) {
            String mensaje = "calcularFuenteVentaReal: " + ErroresDeNegocio.INT_0060;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);

            try {
                gi.registrarError(dtoError);

                return listaCompleta;
            } catch (InterfacesException iex) {
                UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
            } catch (RemoteException rex) {                
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        PeriodoCorporativoLocal periodoCorporativo = null;

        try {
            periodoCorporativo = this.getPeriodoCorporativoLocalHome().findByPrimaryKey(periodoLocal.getOidPeriodoCorporativo());
        } catch (NoResultException fe) {
            String mensaje = "calcularFuenteVentaReal: " + ErroresDeNegocio.INT_0061;
            DTOINTError dtoError = new DTOINTError(interfaz, null, mensaje);

            try {
                gi.registrarError(dtoError);

                return listaCompleta;
            } catch (InterfacesException iex) {
                UtilidadesLog.error("Excepcion de la Interfaz: " + iex.getMotivo(), iex);
            } catch (RemoteException rex) {                
                UtilidadesLog.debug("error RemoteException");
                throw new MareException(rex, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        ArrayList listaFVR = dao.obtenerFuenteVentaReal(this.dtoe.getPeriodo());
        //UtilidadesLog.debug("listaFVR: "+ listaFVR );
        //20090063 jrivas 18/3/09
        //dao.guardarFuenteVentaReal(listaFVR, periodoCorporativo.getAnio() + "");
        dao.guardarFuenteVentaRealMasivo(listaFVR, periodoCorporativo.getAnio() + "");
        
        ArrayList listaFVRA = dao.obtenerFuenteVentaRealAcumulada(periodo);
        //UtilidadesLog.debug("listaFVRA: "+ listaFVRA );
        //20090063 jrivas 18/3/09
        //dao.guardarFuenteVentaRealAcumulada(listaFVRA);
        dao.guardarFuenteVentaRealAcumuladaMasivo(listaFVRA);
        
        boolean encontroAcumulado=false;
        //boolean esGrupocorrespondiente=false;

        if (!listaFVR.isEmpty()) {
            int tamano = listaFVR.size();
            UtilidadesLog.debug("inicia busqueda");
            UtilidadesLog.debug("tamano: " +tamano);
            for (int i = 0; i < tamano; i++) {
                //UtilidadesLog.warn("procesando... : "+i);
                FuenteVentasRealAcumulada fVentaReal = (FuenteVentasRealAcumulada) listaFVR.get(i);
                //se inicia "encontroAcumulado" en false
                encontroAcumulado = false;
                int j = 0;
                int tam = listaFVRA.size();
                //UtilidadesLog.debug("tam:"+tam);
                //Se inicia "esGrupocorrespondiente" en false
                //esGrupocorrespondiente = false;
                
                // 23122 - dmorello, 17/05/2006: Se agrega verificación de territorio no nulo
                if ((fVentaReal.getCodigoRegion() != null) && (fVentaReal.getCodigoZona() != null) && (fVentaReal.getPeriodo() != null)
                        && fVentaReal.getTerritorio() != null) {
                    if (!listaFVRA.isEmpty()) {
                        while (encontroAcumulado == false && j < tam){
                            FuenteVentasRealAcumulada fVentaRealAcum = (FuenteVentasRealAcumulada) listaFVRA.get(j);
                            // 23122 - dmorello, 17/05/2006 - Se agrega la verificación de coincidencia del territorio
                            if ((fVentaRealAcum.getCodigoRegion() != null) && (fVentaRealAcum.getCodigoZona() != null) && (fVentaRealAcum.getPeriodo() != null) && (fVentaRealAcum.getTerritorio() != null)) {
                                if (fVentaRealAcum.getCodigoRegion().equals(fVentaReal.getCodigoRegion()) && fVentaRealAcum.getCodigoZona().equals(fVentaReal.getCodigoZona()) && fVentaRealAcum.getPeriodo().equals(fVentaReal.getPeriodo())
                                        && fVentaRealAcum.getTerritorio().equals(fVentaReal.getTerritorio())) {
                                    //EN CASO ENCUENTRE UN ACUMULADO, INMEDIATAMENTE SE INDICA EN EL FLAG "encontroAcumulado"
                                    //EN CASO NO ENCUENTRA SE DEBE GENERAR EL REGISTRO CON VALORES DEFAULT PARA ACUMULADO.
                                    encontroAcumulado = true;

                                    fVentaRealAcum.setActivasIniciales(fVentaReal.getActivasIniciales());
                                    fVentaRealAcum.setActivasFinales(fVentaReal.getActivasFinales());
                                    fVentaRealAcum.setIngresos(fVentaReal.getIngresos());
                                    fVentaRealAcum.setEgresos(fVentaReal.getEgresos());
                                    fVentaRealAcum.setReingresos(fVentaReal.getReingresos());
                                    fVentaRealAcum.setRezonificadasEntregadas(fVentaReal.getRezonificadasEntregadas());
                                    fVentaRealAcum.setRezonificadasRecibidas(fVentaReal.getRezonificadasRecibidas());
                                    /*
                                     * 23122 - dmorello, 17/05/2006: Se escribe código de marca en vez de marca de producto.
                                     */
                                    fVentaRealAcum.setCodMarca(fVentaReal.getCodMarca());//cambio P2
                                    fVentaRealAcum.setTerritorio(fVentaReal.getTerritorio()); //cambio P2
                                    
                                    listaFVRA.set(j,fVentaRealAcum);        
                                    //UtilidadesLog.debug("i acum:"+i);                                    
                                }
                            }
                            j = j+1;
                        }
                        //// 20070185 - hhernandez, 09/04/2007
                        //YA TERMINO DE RECORRER TODAS VENTAS REALES ACUMULADAS Y PREGUNTAMOS SI ES DEL 
                        //GRUPO CORRESPONDIENTE(MISMO Region,CodigoZona,Periodo)
                        //Y SI ES KE NO ENCONTRO VENTA REAL ACUMULADA (encontroAcumulado = true)
                        if(!encontroAcumulado){ //&& esGrupocorrespondiente
                            fVentaReal.setNumeroClientes(new Long("0"));
                            fVentaReal.setNumeroOrdenes(new Long("0"));
                            fVentaReal.setNumeroPedidos(new Long("0"));
                            fVentaReal.setUnidadesVendidas(new Long("0"));
                            fVentaReal.setVentaNetaEstadisticable(new BigDecimal("0.00"));
                            //UtilidadesLog.debug("i or:"+i);
                            listaFVRA.add(fVentaReal);
                        }
                    }
                }
            }
        }
        UtilidadesLog.info("MONSAPBPSBean.calcularFuenteVentaReal(Long periodo): Salida");
        return listaFVRA;
    }



    public DTOSalidaBatch enviarMaestroTerritorios(DTOBatch dtoBatch)throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroTerritorios(DTOBatch dtoBatch): Entrada");
        MONGestorInterfaces gi = this.getMONGestorInterfaces();
        RegistroSicc registro = new RegistroSicc();
        /* SICC-GCC-INT-SAB-004 - dmorello, 05/12/2006 */
        //String codigo = ISAPBPS.COD_INTERFAZ_SAB28;
        DTOINTPantallaSAPBPS dto = (DTOINTPantallaSAPBPS)dtoBatch.getDTOOnline();
        String codigo;
        if (dto.getCodigo() != null) {
            codigo = dto.getCodigo();
        } else {
            codigo = ISAPBPS.COD_INTERFAZ_SAB28;
        }

        try {
            init(dtoBatch, codigo);
        } catch (MareException e) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Fallo al realizar init en enviarMaestroTerritorios ");

            return new DTOSalidaBatch(0, "Interfaz " + codigo + " finalizado con error");
        }

        DAOINTSAPBPS dao = new DAOINTSAPBPS();
        /*gPineda - 17/10/2007
        /ArrayList listaZonas = dao.obtenerMaestroTerritorios(dtoe.getOidPais(), dtoe.getMarca(), dtoe.getCanal(), Boolean.TRUE, dtoe.getOidIdioma(), dtoe.getPeriodo(), codigo);
        if (listaZonas.isEmpty()) {*/        
         RecordSet rs = dao.obtenerMaestroTerritorios(dto, codigo, Boolean.TRUE);        
        int tamanio = rs.getRowCount();
        if( tamanio == 0 ){
            String mensaje = "EnviarMaestroTerritorios Finalizo Sin Registros";
            /* dmorello, 08/01/2007 - Para que el archivo vacío no quede en carpeta temporal */
            try {
                gi.enviarInterfaz(interfaz);
            } catch (InterfacesException ie) {
                UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la " + " Interfaz " + ie.getMotivo() + " ( " + ie.getEx() + " )", ie);            
            } catch (RemoteException re) {            
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
            /* Fin dmorello 08/01/2007 */
            return new DTOSalidaBatch(0, mensaje);
        }

        DTOMaestroTerritorios dtoTerritorio = null;
        /*Iterator itlista = listaZonas.iterator(); 
        while(itlista.hasNext()){
            dtoTerritorio = (DTOMaestroTerritorios) itlista.next(); */
        for( int i = 0; i < tamanio ; i++){
            dtoTerritorio = this.crearDTOMaestroTerritorios( rs, i );
            try{ 
            
            registro.vaciar();
            registro.anyadirCampo( ISAPBPS.SAB28_CODIGO_PAIS, dtoTerritorio.getCodPais() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_CODIGO_ZONA, dtoTerritorio.getCodZona() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_CODIGO_REGION, dtoTerritorio.getCodRegion() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_TERRITORIO, dtoTerritorio.getTerritorio() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_CODIGO_SOCIEDAD, dtoTerritorio.getCodSociedad() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_MARCA, dtoTerritorio.getMarcaEstructural() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_CANAL_BPS, dtoTerritorio.getCanalBPS() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_SUBGERENCIA_VENTAS, dtoTerritorio.getSubgerenciaVentas() ); 
            registro.anyadirCampo( ISAPBPS.SAB28_SECCION, dtoTerritorio.getSeccion() ); 

            
        
                // Se añade el registro al fichero de interfaz 
                gi.anyadirRegistro(interfaz, registro);
                registro.vaciar();
            } catch (RemoteException e) {                
                UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (InterfacesException e) {
                // Se registra la excepción con el servicio MareLogging
                UtilidadesLog.debug(" [ " + codigo + " ] \n\n 1.-InterfacesException En enviarMaestroTerritorios ");                
                continue;
            }
        }
        
        UtilidadesLog.debug("Info de la interfaz a enviar");
        UtilidadesLog.debug("pais: " + interfaz.getPais());
        UtilidadesLog.debug("codigoInterfaz: " + interfaz.getCodigoInterfaz());
        UtilidadesLog.debug("numeroLote: " + interfaz.getNumeroLote());

        try {
            gi.enviarInterfaz(interfaz);
        } catch (InterfacesException e) {
            UtilidadesLog.error("\n\n InterfacesException [CS]Excepcion de la Interfaz " + e.getMotivo() + " ( " + e.getEx() + " )", e);            
        } catch (RemoteException e) {            
            UtilidadesLog.debug(" [ " + codigo + " ] Error RemoteException");
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        UtilidadesLog.debug(" [ " + codigo + " ] MONSAPBPS:enviarMaestroTerritorios  ---->SALIDA ");
        UtilidadesLog.info("MONSAPBPSBean.enviarMaestroTerritorios(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "Interfaz " + codigo + " procesada");
    }

    
    private void borrarVentaDiaPorProducto(Long oidPeriodo, Date fecha) throws MareException {
        UtilidadesLog.info("DAOINTSAPBPS.borrarVentaDiaPorProducto(Long oidPeriodo, Date fecha): Entrada");
        
        StringBuffer sqlBorrar = new StringBuffer();
        Vector parametros = new Vector();
        sqlBorrar.append(" DELETE FROM INT_VENTA_DIAPR_PRODU ");
        sqlBorrar.append(" WHERE PERD_OID_PERI = ? ");
        parametros.add(oidPeriodo);
        sqlBorrar.append(" AND FEC_FECH = TO_DATE(?, 'DD/MM/YYYY') ");
        parametros.add(new SimpleDateFormat("dd/MM/yyyy").format(fecha));

        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        try {      
            bs.dbService.executePreparedUpdate(sqlBorrar.toString(), parametros);
        } catch (Exception e) {
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }

        UtilidadesLog.info("DAOINTSAPBPS.borrarVentaDiaPorProducto(Long oidPeriodo, Date fecha): Salida");
    }

    private DTOVentaDiaProducto crearDTOVentaDiaProducto( RecordSet rs, int i) throws MareException{
        DTOVentaDiaProducto dto = new DTOVentaDiaProducto();
        Object obj = null;
        
        obj = rs.getValueAt(i,"PAIS");
        if ( obj != null){
        dto.setOidPais(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDPERIODO") ;
        if ( obj != null) {
        dto.setOidPeriodo(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDALMACEN") ;
        if ( obj != null) {
        dto.setOidAlmacen(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDSOCIEDAD") ;
        if ( obj != null) {
        dto.setOidSociedad(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDPRODUCTO") ;
        if ( obj != null) {
        dto.setOidProducto(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"FECHAFACTURACION") ;
        if ( obj != null) {
        dto.setFechaFacturacion((Date)obj);
        }
        obj = rs.getValueAt(i,"UNID_ATEN_VENDIDAS") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasVendidas(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"UNID_ATEN_FALTANTES") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasFaltantes(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"UNID_ATEN_DEVUELTAS") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasDevueltas(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"UNID_ATEN_ANULADAS") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasAnuladas(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"UNID_ATEN_CANJE") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasCanje(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"UNID_ATEN_TRUEQUE") ;
        if ( obj != null) {
        dto.setUnidadesAtendidasTrueque(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"VENTA_NETA_VENDIDAS") ;
        if ( obj != null) {
        dto.setVentaNetaVendidas((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"VENTA_NETA_FALTANTES") ;
        if ( obj != null) {
        dto.setVentaNetaFaltantes((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"VENTA_NETA_DEVUELTAS") ;
        if ( obj != null) {
        dto.setVentaNetaDevueltas((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"VENTA_NETA_ANULADAS") ;
        if ( obj != null) {
        dto.setVentaNetaAnuladas((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"VENTA_NETA_CANJE") ;
        if ( obj != null) {
        dto.setVentaNetaCanje((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"VENTA_NETA_TRUEQUE") ;
        if ( obj != null) {
        dto.setVentaNetaTrueque((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"PREC_CATA_VENDIDAS") ;
        if ( obj != null) {
        dto.setPrecioCatalogoTotalLocalVendidas((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"PREC_CATA_FALTANTES") ;
        if ( obj != null) {
        dto.setPrecioCatalogoTotalLocalFaltantes((BigDecimal)obj);
        }
        obj = rs.getValueAt(i,"OIDCICLOVIDA") ;
        if ( obj != null) {
        dto.setOidCicloVida(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDTIPOOFERTA") ;
        if ( obj != null) {
        dto.setOidTipoOferta(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"OIDCONDICIONPROMOCION") ;
        if ( obj != null) {
        dto.setOidCondicionPromocion(new Long(obj.toString()));
        }
        obj = rs.getValueAt(i,"FLAGVENTA") ;
        if ( obj != null) {
        dto.setFlagVenta(new Boolean(
        obj.toString().equals("1") ? true : false));
        }
        obj = rs.getValueAt(i,"TERRITORIO") ;
        if ( obj != null) {
        dto.setTerritorio(obj.toString());
        }
        // 17/01/2007
        obj = rs.getValueAt(i, "OIDTERRITORIO") ;
        if ( obj != null) {
        dto.setOidTerritorio( new Long(((BigDecimal)obj).longValue()));
        }        
        //scs
        obj = rs.getValueAt(i,"CODIGOSOCIEDAD") ;
        if ( obj != null) {
        dto.setCodSociedad(obj.toString());
        }
        obj = rs.getValueAt(i,"CODIGOALMACEM") ;
        if ( obj != null) {
        dto.setCodAlmacen(obj.toString());
        }
        obj = rs.getValueAt(i,"MEDIO") ;
        if ( obj != null) {
        dto.setMedio(obj.toString());
        }
        obj = rs.getValueAt(i,"CANALBPS") ;
        if ( obj != null) {
        dto.setCanalBPS(obj.toString());
        }
        obj = rs.getValueAt(i,"CODPERIODO") ;
        if ( obj != null) {
        dto.setCodPerio(obj.toString());
        }
        obj = rs.getValueAt(i,"CODSAP") ;
        if ( obj != null) {
        dto.setCodSAP(obj.toString());
        }
        obj = rs.getValueAt(i,"CODCICLOVIDA") ;
        if ( obj != null) {
        dto.setCodCicloVida(obj.toString());
        }
        obj = rs.getValueAt(i,"CODTIPOOFER") ;
        if ( obj != null) {
        dto.setCodTipoOfer(obj.toString());
        }
        obj = rs.getValueAt(i,"CODCONDPROM") ;
        if ( obj != null) {
        dto.setCodCondProm(obj.toString());
        }
        obj = rs.getValueAt(i,"CODMARCA") ;
        if ( obj != null) {
        dto.setCodMarca(obj.toString());
        }
        obj = rs.getValueAt(i, "NUM_UNID_POR_ATEN") ;
        if ( obj != null) {
        dto.setUnidadesPorAtender(new Long(((BigDecimal)obj).longValue()));
        }
        return dto;
    }
    private DTOMaestroTerritorios crearDTOMaestroTerritorios(RecordSet rs, int i){
        DTOMaestroTerritorios dto = new DTOMaestroTerritorios();                  
        if(rs.getValueAt(i,"CODPAIS")!=null){
            dto.setCodPais(rs.getValueAt(i,"CODPAIS").toString());
        }
        if(rs.getValueAt(i,"CANALBPS")!=null){
            dto.setCanalBPS(rs.getValueAt(i,"CANALBPS").toString());
        }
        if(rs.getValueAt(i,"CODREGI")!=null){
            dto.setCodRegion(rs.getValueAt(i,"CODREGI").toString());
        }
        if(rs.getValueAt(i,"CODSOCI")!=null){
            dto.setCodSociedad(rs.getValueAt(i,"CODSOCI").toString());
        }
        if(rs.getValueAt(i,"CODZONA")!=null){
            dto.setCodZona(rs.getValueAt(i,"CODZONA").toString());
        }
        if(rs.getValueAt(i,"CODSECCION")!=null){
            dto.setSeccion(rs.getValueAt(i,"CODSECCION").toString());
        }
        if(rs.getValueAt(i,"MARCA")!=null){
            dto.setMarcaEstructural(rs.getValueAt(i,"MARCA").toString());
        }
        if(rs.getValueAt(i,"CODSUBGERENTEV")!=null){
            dto.setSubgerenciaVentas(rs.getValueAt(i,"CODSUBGERENTEV").toString());
        }
        if(rs.getValueAt(i,"CODTERR")!=null){
            dto.setTerritorio(rs.getValueAt(i,"CODTERR").toString());
        }
        return dto;
    }

    
    /**
     * Se reagrupa segun los criterios indicados en el DECU.
     * Segun cambio SAB-006 la estructura recibida se encuentra agrupada 
     * por mas criterios de lo que este CU necesita.
     * 
     * @return 
     * @param datosPed
     */
    private ArrayList reagruparSAB12( ArrayList datosPed ) {
        UtilidadesLog.debug("MONSAPBPSBean.reagruparSAB12(ArrayList datosPed):Entrada");
        HashMap hash = new HashMap();        
        DTODatosPedSAP actual;
        DTODatosPedSAP agrupado;
        String key;

        int tamanio = datosPed.size();
        for( int i = 0 ; i < tamanio ; i++ ){
            actual = (DTODatosPedSAP)datosPed.get( i );
            key  = "|"+ actual.getOidPais();
            key += "|"+ actual.getOidPeriodo();
            key += "|"+ actual.getOidSubAcceso();
            key += "|"+ actual.getOidAlmacen();
            key += "|"+ actual.getOidSociedad();
            key += "|"+ actual.getOidTipoSolicitud();
            key += "|"+ actual.getOidTipoCliente();

            agrupado = (DTODatosPedSAP)hash.get( key );
            
            if( agrupado == null ){
                hash.put( key, actual );
            }else{
                agrupado.setNumOrdenesDia( new Long( agrupado.getNumOrdenesDia().longValue() + actual.getNumOrdenesDia().longValue() ) );
                agrupado.setNumPedidosAcumulados( new Long( agrupado.getNumPedidosAcumulados().longValue() + actual.getNumPedidosAcumulados().longValue() ) );
            }
        }
        
        UtilidadesLog.debug("MONSAPBPSBean.reagruparSAB12(ArrayList datosPed):Salida");
        return new ArrayList( hash.values() );
    }

    
    /**
     * CHANGELOG
     * ---------
     * dmorello, 01/07/2009 - Se reemplaza uso de entity bean HistoricoLotesLocal por JDBC
     */
    private void registrarLote(String codigoInterfaz ) throws MareException{
        UtilidadesLog.debug("MONSAPBPSBean.registrarLote(String codigoInterfaz ):Entrada");
        
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        StringBuffer insert = new StringBuffer();
        Vector params = new Vector();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        insert.append("INSERT INTO INT_HISTO_LOTES");
        insert.append("(COD_INTE");
        insert.append(",NUM_LOTE");
        insert.append(",PAIS_OID_PAIS");
        insert.append(",VAL_DESC_LOTE");
        insert.append(",FEC_INIC_PROC");
        insert.append(",FEC_FIN_PROC");
        insert.append(",NUM_REGI_PROC");
        insert.append(",NUM_REGI_ERRO");
        insert.append(",VAL_OBSE");
        insert.append(") VALUES");
        insert.append("(?");
        params.add(codigoInterfaz);
        insert.append(",?");
        params.add(this.dtoe.getNumeroLote().toString());
        insert.append(",?");
        params.add(this.dtoe.getOidPais());
        insert.append(",?");
        params.add(this.dtoe.getDescripcionLote());
        insert.append(", TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS')");
        params.add(sdf.format(new Date(System.currentTimeMillis())));
        insert.append(", TO_DATE(?, 'DD/MM/YYYY HH24:MI:SS')");
        params.add(sdf.format(new Date(System.currentTimeMillis())));
        insert.append(",?");
        params.add(Integer.valueOf(0));
        insert.append(",?");
        params.add(Integer.valueOf(0));
        insert.append(",?");
        params.add(this.dtoe.getObservaciones());
        insert.append(")");
        
        try {
            bs.dbService.executePreparedUpdate(insert.toString(), params);
        } catch (Exception e) {
            String error = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
            throw new MareException(e, UtilidadesError.armarCodigoError(error));
        }
        
        UtilidadesLog.debug("MONSAPBPSBean.registrarLote(String codigoInterfaz ):Salida");
    }


    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoINT
     */
    public DTOSalidaBatch recepcionarEstimadosVentasProyectadasBatch(DTOINT dtoINT) throws MareException 
    {
       UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasProyectadasBatch(DTOINT dtoINT): Entrada");
        
        MareBusinessID IDOnline = new MareBusinessID("INTRecepcionarEstimadosVentasProyectadas");        
        DTOBatch dtoBatch = new DTOBatch("recepcionarEstimadosProyectadas", IDOnline, dtoINT);
        
        try {
            BatchUtil.executeMLN( dtoBatch, "INTProcesoInterfaces" );
            
        } catch (RemoteException e) {
            UtilidadesLog.debug("*** RemoteException en MONSAPBPS.recepcionarEstimadosVentasProyectadasBatch", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        }
        
        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasProyectadasBatch(DTOINT dtoINT): Salida");
        return new DTOSalidaBatch( 0, "recepcionarEstimadosVentasProyectadasBatch finalizado" ); 
    
    }

    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @return 
     * @param dtoBatch
     * Descripcion: Tiene la misma funcionalidad que 'recepcionarEstimadosVentas' pero se usa 
     * con la interfaz 'SAB-18' (entidad 'FacturacionProyectada')     
     * 
     */
    public DTOSalidaBatch recepcionarEstimadosVentasProyectadas(DTOBatch dtoBatch) throws MareException 
    {
       UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasProyectadas(DTOBatch dtoBatch): Entrada");

        MONGestorInterfaces gi = null;
        DTOINT dtoINT = null;
        InterfazInfo interfaz = null;
        EstrategiaLocal estrategiaLocal = null;
        EstrategiaLocalHome estrategiaLocalHome = this.getEstrategiaLocalHome();

        IRegistroSicc registro = null;
        DTOINTEstimado dtoEstimado = null;

        try {
            dtoINT = (DTOINT) dtoBatch.getDTOOnline();
            UtilidadesLog.debug("\n RECIBIDO dtoInt  " + dtoINT);
        
        } catch (ClassCastException cce) {
            UtilidadesLog.debug("\n     ClassCastException en recepcionarEstimadosVentasProyectadas()!!");

            return null;
        }

        InterfazInfo info = new InterfazInfo(IGestorInterfaces.COD_INTERFAZ_SAB18, dtoINT.getNumeroLote().toString(), dtoINT.getOidPais());
        info.setDescripcionLote(dtoINT.getDescripcionLote());
        info.setObservaciones(dtoINT.getObservaciones());

        gi = this.getMONGestorInterfaces();

        try {
            interfaz = gi.importarInterfaz(info);
            
        } catch (RemoteException re) {            
            
            UtilidadesLog.debug("\n     RemoteException en recepcionarEstimadosVentasProyectadas()!!");
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        
        } catch (InterfacesException ie) {

            UtilidadesLog.debug("\n     InterfacesException importarInterfaz()!! ");
            return new DTOSalidaBatch(0, "recEstiVen fin con error");
        }

        try {
            int reg = 0;
            while ((registro = gi.cargarRegistro(interfaz)) != null) {
                
                UtilidadesLog.debug("\n     SAB-18: Inicio proceso del REGISTRO_" + (++reg) );
                dtoEstimado = new DTOINTEstimado();

                dtoEstimado.setNumeroLoteTransaccion(((Long) registro.obtenerCampo(ISAPBPS.SAB9_NUMERO_LOTE_TRANSACCION)));
                dtoEstimado.setPais((String) registro.obtenerCampo(ISAPBPS.SAB9_PAIS));
                dtoEstimado.setSociedad((String) registro.obtenerCampo(ISAPBPS.SAB9_SOCIEDAD));
                dtoEstimado.setCanal((String) registro.obtenerCampo(ISAPBPS.SAB9_CANAL));
                dtoEstimado.setAcceso((String) registro.obtenerCampo(ISAPBPS.SAB9_ACCESO));
                dtoEstimado.setSubacceso((String) registro.obtenerCampo(ISAPBPS.SAB9_SUBACCESO));
                dtoEstimado.setTipoPeriodo((String) registro.obtenerCampo(ISAPBPS.SAB9_TIPO_PERIODO));
                dtoEstimado.setPeriodo((String) registro.obtenerCampo(ISAPBPS.SAB9_PERIODO));
                dtoEstimado.setCodigoProductoSAP((String) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_PRODUCTO_SAP));
                dtoEstimado.setTipoOferta(((String) registro.obtenerCampo(ISAPBPS.SAB9_TIPO_OFERTA)));
                dtoEstimado.setCicloVida(((String) registro.obtenerCampo(ISAPBPS.SAB9_CICLO_VIDA)));
                dtoEstimado.setUnidadesEstimadas(((Long) registro.obtenerCampo(ISAPBPS.SAB9_UNIDADES_ESTIMADAS)));
                dtoEstimado.setVentaNetaEstimada(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_VENTA_NETA_ESTIMADA)));
                dtoEstimado.setPrecioCatalogo(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_PRECIO_CATALOGO)));
                dtoEstimado.setPrecioPosicionamiento(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_PRECIO_POSICIONAMIENTO)));                
                dtoEstimado.setMonedaTransaccion((String) registro.obtenerCampo(ISAPBPS.SAB9_MONEDA_TRANSACCION));
                
                if (dtoEstimado.getMonedaTransaccion().trim().length()<=0){
                    dtoEstimado.setMonedaTransaccion(null);
                }
                
                dtoEstimado.setCatalogo(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_CATALOGO)));
                dtoEstimado.setNumeroPaginaCatalogo(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_NUMERO_PAGINA_CATALOGO)));
                dtoEstimado.setPosicionDentroPagina(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_POSICION_DENTRO_PAGINA)));
                dtoEstimado.setArgumento(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_ARGUMENTO)));
                dtoEstimado.setEstrategia((String) registro.obtenerCampo(ISAPBPS.SAB9_ESTRATEGIA));
                dtoEstimado.setCondicionPromocion(((String) registro.obtenerCampo(ISAPBPS.SAB9_CONDICION_PROMOCION)));
                dtoEstimado.setCodigoFormaVenta(((Integer) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_FORMA_VENTA)));
                dtoEstimado.setCosteEstandar(((BigDecimal) registro.obtenerCampo(ISAPBPS.SAB9_COSTE_ESTANDAR)));
                dtoEstimado.setCodigoFormaPago(((String) registro.obtenerCampo(ISAPBPS.SAB9_CODIGO_FORMA_PAGO)));
                dtoEstimado.setCentro(((String) registro.obtenerCampo(ISAPBPS.SAB9_CENTRO)));

                UtilidadesLog.debug("\n     CodigoProductoSAP SAB-18 entrada = " + dtoEstimado.getCodigoProductoSAP()  );
                UtilidadesLog.debug("\n     dtoestimado SAB-18 entrada = " + dtoEstimado );

                PaisLocalHome paisLocalHome = this.getPaisLocalHome();
                PaisLocal paisLocal = null;
                MonedaLocalHome monedaLocalHome = this.getMonedaLocalHome();
                MonedaLocal monedaLocal = null;
                String codigoMoneda = null;

                String codigoPais = null;
                codigoPais = dtoEstimado.getPais();

                try {
                    paisLocal = paisLocalHome.findByUk(codigoPais);
                } catch (NoResultException fe) {
                
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0003);
                    gi.registrarError(dtoError);
                    gi.cerrarInterfaz(interfaz);
                    return new DTOSalidaBatch(0, "recEstiVen fin con error");
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                //CODIGO MONEDA                        
                codigoMoneda = dtoEstimado.getMonedaTransaccion();

                if (codigoMoneda != null && codigoMoneda.length()>0) {
                    try {
                        monedaLocal = monedaLocalHome.findByUK(codigoMoneda);

                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB9);
                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "recEstiVen fin con error");
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                    
                } else {
                    monedaLocal = null;
                }

                if ((monedaLocal != null) && 
                    (monedaLocal.getOid().longValue() != paisLocal.getMone_oid_mone().longValue()) && 
                    (monedaLocal.getOid().longValue() != paisLocal.getMone_oid_mone_alt().longValue())) {
                    
                    DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0056);
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + 
                                        dtoEstimado.getPais(), interfaz, gi, 
                                        IGestorInterfaces.COD_INTERFAZ_SAB18);
                                        
                    gi.cerrarInterfaz(interfaz);
                    return new DTOSalidaBatch(0, "recEstiVen fin con error");
                }

                MarcaLocalHome marcaLocalHome = this.getMarcaLocalHome();
                MarcaLocal marcaLocal = null;

                try {
                    marcaLocal = marcaLocalHome.findByUK(ConstantesSEG.COD_MARCA_EB);
                    
                } catch (NoResultException fex) {
                    try {
                        marcaLocal = marcaLocalHome.findByUK(ConstantesSEG.COD_MARCA_T);
                        
                    } catch (NoResultException fexm) {
                        
                        this.registrarError(dtoEstimado, 
                                            ErroresDeNegocio.INT_0003 + 
                                            dtoEstimado.getPais(), 
                                            interfaz, gi, 
                                            IGestorInterfaces.COD_INTERFAZ_SAB18);

                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "recepcionarEstimadosVentas finalizado con error");
                        
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                CanalLocalHome canalHome = this.getCanalLocalHome();
                CanalLocal canalLocal = null;
                MaestroProductosLocalHome maestroProductosHome = this.getMaestroProductosLocalHome();
                MaestroProductosLocal maestroProductosLocal = null;
                TipoOfertaLocalHome tipoOfertaHome = this.getTipoOfertaLocalHome();
                TipoOfertaLocal tipoOfertaLocal = null;
                CicloVidaLocalHome cicloVidaHome = this.getCicloVidaLocalHome();
                CicloVidaLocal cicloVidaLocal = null;
                CatalogoLocalHome catalogoLocalHome = this.getCatalogoLocalHome();
                CatalogoLocal catalogoLocal = null;
                ArgumentoVentaLocalHome argumentoVentaLocalHome = this.getArgumentoVentaLocalHome();
                ArgumentoVentaLocal argumentoVentaLocal = null;
                CondicionPromocionLocalHome condicionPromocionLocalHome = this.getCondicionPromocionLocalHome();
                CondicionPromocionLocal condicionPromocionLocal = null;
                PeriodoCorporativoLocalHome periodoCorporativoHome = this.getPeriodoCorporativoLocalHome();
                PeriodoCorporativoLocal periodoCorporativoLocal = null;

                FacturacionProyectadaLocalHome factProyectLocalHome = this.getFacturacionProyectadaLocalHome();
                FacturacionProyectadaLocal factProyectLocal = null;
                
                ConfiguracionMFPaisLocalHome configuracionMFPaisLocalHome = this.getConfiguracionMFPaisLocalHome();
                ConfiguracionMFPaisLocal configuracionMFPaisLocal = null;
                TipoEstrategiaLocalHome tipoEstrategiaLocalHome = this.getTipoEstrategiaLocalHome();
                TipoEstrategiaLocal tipoEstrategiaLocal = null;
                Entidadi18nLocalHome e18nLH = this.getEntidadi18nLocalHome();
                Entidadi18nLocal e18nLocal = null;
                PeriodoLocal periodoLocal = null;
                PeriodoLocalHome periodoLocalHome = new PeriodoLocalHome();
                AccesoLocalHome accesoLocalHome = this.getAccesoLocalHome();
                AccesoLocal accesoLocal = null;
                SubaccesoLocalHome subaccesoLocalHome = this.getSubaccesoLocalHome();
                SubaccesoLocal subaccesoLocal = null;    

                Long monedaTemp = null;
                BigDecimal costeEstandarTemp = null;
                DTOINTEstrategia estrategiaTemp = null;

                try {
                    paisLocal = paisLocalHome.findByUk(dtoEstimado.getPais()); 
                
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, 
                                        ErroresDeNegocio.INT_0003 + dtoEstimado.getPais(), 
                                        interfaz, gi, 
                                        IGestorInterfaces.COD_INTERFAZ_SAB18);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                try {
                    canalLocal = canalHome.findByClaveUnica(dtoEstimado.getCanal());
                    
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, 
                                        ErroresDeNegocio.INT_0035 + dtoEstimado.getCanal(), 
                                        interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB18);

                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try {
                      UtilidadesLog.debug("Acceso SAB-18 entrada**" + dtoEstimado.getAcceso() + "******");
                      if ((!dtoEstimado.getAcceso().equals("") ) ) {
                          accesoLocal = accesoLocalHome.findByClaveUnica(dtoEstimado.getAcceso(),canalLocal.getOid());

                        try {
                            UtilidadesLog.debug("SubAcceso SAB-18 entrada**" + dtoEstimado.getSubacceso() + "******");
                            
                            if( ( accesoLocal != null) && (!dtoEstimado.getSubacceso().equals("")) ){
                                subaccesoLocal = subaccesoLocalHome.findByUK(dtoEstimado.getSubacceso(),
                                                                             accesoLocal.getOid());                     
                            }         
                            
                        } catch (NoResultException fe) {
                            
                            this.registrarError(dtoEstimado, 
                                                ErroresDeNegocio.INT_0021 + dtoEstimado.getSubacceso(), 
                                                interfaz, gi, 
                                                IGestorInterfaces.COD_INTERFAZ_SAB18);      
                            continue;
                        }  catch (PersistenceException ce) {   
                            UtilidadesLog.error("ERROR ", ce);
                            throw new MareException(ce, 
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                        }      
                      }                    
                } catch (NoResultException fe) {

                    this.registrarError(dtoEstimado, 
                                        ErroresDeNegocio.INT_0111 + dtoEstimado.getAcceso(), 
                                        interfaz, gi, 
                                        IGestorInterfaces.COD_INTERFAZ_SAB18);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }
                
                try {
                    UtilidadesLog.debug("\n Antes del findByUK : " + dtoEstimado.getCodigoProductoSAP());
                    maestroProductosLocal = maestroProductosHome.findByUK(paisLocal.getOid(), dtoEstimado.getCodigoProductoSAP());
                
                } catch (FinderException fe) {
                    UtilidadesLog.debug("Error de find: " + fe);
                    this.registrarError(dtoEstimado, 
                                        ErroresDeNegocio.INT_0005 + dtoEstimado.getCodigoProductoSAP(), 
                                        interfaz, gi, 
                                        IGestorInterfaces.COD_INTERFAZ_SAB18);

                    continue;
                }

                Long tipoOfertaTEMP = null;

                if (dtoEstimado.getTipoOferta() != null) {
                    try {
                        tipoOfertaLocal = tipoOfertaHome.findByUK(canalLocal.getOid(), dtoEstimado.getTipoOferta());
                        tipoOfertaTEMP = tipoOfertaLocal.getOid();
                    
                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, 
                                            ErroresDeNegocio.INT_0053 + dtoEstimado.getTipoOferta(), 
                                            interfaz, gi, 
                                            IGestorInterfaces.COD_INTERFAZ_SAB18);

                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                } else {
                    tipoOfertaTEMP = ConstantesPRE.TIPO_OFERTA_00;
                }

                try {
                    cicloVidaLocal = cicloVidaHome.findByUK(dtoEstimado.getCicloVida());
                
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro el CicloDeVida_" + dtoEstimado.getCicloVida() + " ...Vamos a crearlo en PRE_CICLO_VIDA con Descripcion Pendiente");
                        String descripcion = "Descripcion pendiente";
                        cicloVidaLocal = cicloVidaHome.create(dtoEstimado.getCicloVida());
                        UtilidadesLog.debug(" PRE_CICLO_VIDA creado con oid_" + cicloVidaLocal.getOid());
                        e18nLocal = e18nLH.create("PRE_CICLO_VIDA", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, descripcion, cicloVidaLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Catalogo");
                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de Ciclo De Vida ha Fallado ");
                        continue;
                    }
                }

                try {
                    catalogoLocal = catalogoLocalHome.findByUK(paisLocal.getOid(), 
                                                               dtoEstimado.getCatalogo());
                
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro el Catalogo_" + dtoEstimado.getCatalogo() + " ...Vamos a crearlo en PRE_CATAL con Descripcion Pendiente");
                        String descripcion = "Descripcion pendiente";
                        catalogoLocal = catalogoLocalHome.create(dtoEstimado.getCatalogo(), descripcion, paisLocal.getOid());
                        UtilidadesLog.debug(" PRE_CATAL creado con oid_" + catalogoLocal.getOid());
                        e18nLocal = e18nLH.create("PRE_CATAL", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, descripcion, catalogoLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Catalogo");
                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de catalogo  ha Fallado ");
                        continue;
                    }
                }

                try {
                    argumentoVentaLocal = argumentoVentaLocalHome.findByUK(dtoEstimado.getArgumento());
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro el Argumento de Venta_" + dtoEstimado.getArgumento() + " ...Vamos a crearlo en PRE_ARGUM_VENTA con Descripcion Pendiente");
                        argumentoVentaLocal = argumentoVentaLocalHome.create(dtoEstimado.getArgumento());
                        UtilidadesLog.debug(" PRE_ARGUM_VENTA creado con oid_" + argumentoVentaLocal.getOid());
                        e18nLocal = e18nLH.create("PRE_ARGUM_VENTA", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, "Descripcion Pendiente", argumentoVentaLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Argumento de Venta");
                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de Argumento De Venta  ha Fallado ");
                        continue;
                    }
                }

                try {
                    condicionPromocionLocal = condicionPromocionLocalHome.findByUK(dtoEstimado.getCondicionPromocion());
                } catch (NoResultException fe) {
                    try {
                        UtilidadesLog.debug("NO se encontro Condicion Promocion_" + dtoEstimado.getCondicionPromocion() + " ...Vamos a crearla en PRE_CONDI_PROMO con Descripcion Pendiente");
                        condicionPromocionLocal = condicionPromocionLocalHome.create(dtoEstimado.getCondicionPromocion().toString());
                        UtilidadesLog.debug(" PRE_CONDI_PROMO creada con oid_" + condicionPromocionLocal.getOid());
                        String descripcion = "Descripcion pendiente";
                        e18nLocal = e18nLH.create("PRE_CONDI_PROMO", new Long(1), ConstantesSEG.IDIOMA_DEFECTO, descripcion, condicionPromocionLocal.getOid());
                        UtilidadesLog.debug(" I18N actualizada para el Condicion Promocion");
                        
                    } catch (PersistenceException ce) {
                        UtilidadesLog.error("*Metodo  RecepcionarEstimadosVenta: create de condicionPromocion  ha Fallado ");
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0051 + dtoEstimado.getCondicionPromocion(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB18);

                        continue;
                    }
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                try {
                    UtilidadesLog.debug("   - SAP601:  antes de periodoCorporativoHome.findByUK = " + dtoEstimado.getPeriodo());
                    periodoCorporativoLocal = periodoCorporativoHome.findByUK(dtoEstimado.getPeriodo());

                    //oidPeriodoCorporativo = ?1 oidMarca = ?2 oidPais = ?3 oidCanal = ?4
                    UtilidadesLog.debug("   - SAP601:  antes de periodoLocalHome.findByUk = "
                        + periodoCorporativoLocal.getOid() + ", " 
                        + marcaLocal.getOid() + ", "
                        + paisLocal.getOid() + ", "
                        + canalLocal.getOid());
                        
                    periodoLocal = periodoLocalHome.findByUk(periodoCorporativoLocal.getOid(), marcaLocal.getOid(), paisLocal.getOid(), canalLocal.getOid());
                    
                } catch (NoResultException fe) {
                    this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0054 + dtoEstimado.getPeriodo(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB18);
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                Collection configuracionMF = null;

                try {
                    configuracionMF = configuracionMFPaisLocalHome.findByPaisMarcaCanal(paisLocal.getOid(), marcaLocal.getOid(), canalLocal.getOid());
                } catch (NoResultException fe) {
                    UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder confmf ");
                    continue;
                }  catch (PersistenceException ce) {   
                    UtilidadesLog.error("ERROR ", ce);
                    throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                }

                if ((configuracionMF == null) || (configuracionMF.size() == 0)) {
                    UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder confmf ");
                    continue;
                }

                if (codigoMoneda != null) {
                    try {
                        monedaLocal = monedaLocalHome.findByUK(dtoEstimado.getMonedaTransaccion());
                    } catch (NoResultException fe) {
                        this.registrarError(dtoEstimado, ErroresDeNegocio.INT_0056 + dtoEstimado.getPais(), interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB18);
                        gi.cerrarInterfaz(interfaz);
                        return new DTOSalidaBatch(0, "Metodo recepcionarEstimadosVentas finalizado con error");
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }

                Iterator itConfiguracionMF = configuracionMF.iterator();
                configuracionMFPaisLocal = (ConfiguracionMFPaisLocal) itConfiguracionMF.next();

                if ((monedaLocal != null) && (monedaLocal.getOid().longValue() == configuracionMFPaisLocal.getOid().longValue())) {
                    monedaTemp = null;
                    UtilidadesLog.debug("MONEDA VA A NULL porque coincide con Configuración MF por país");
                } else {
                    if (monedaLocal != null){
                      monedaTemp = monedaLocal.getOid();
                      UtilidadesLog.debug("MONEDA TIENE VALOR: " + monedaTemp);
                    } else {
                      monedaTemp = null;
                      UtilidadesLog.debug("MONEDATEMP VA A NULL");	
                    }
                }

                if ((dtoEstimado.getEstrategia() == null) || (dtoEstimado.getEstrategia().trim().equals(""))) {
                    DAOINTSAPBPS dao = new DAOINTSAPBPS();

                    if (argumentoVentaLocal.getOidTipoEstr()!=null){
                        estrategiaTemp = (DTOINTEstrategia) dao.obtenerEstrategia(
                                paisLocal.getOid(), 
                                argumentoVentaLocal.getOidTipoEstr(), 
                                new Long(ConstantesPRE.ORDEN_COMPRA)).get(0);
                                
                        UtilidadesLog.debug("Estrategia vacia -> se va a calcular la nueva: " + estrategiaTemp.getOid());
                    
                    } else {
                        estrategiaTemp = new DTOINTEstrategia();
                        UtilidadesLog.debug("El argumento de venta no posee tipo de estrategia");
                    }
                
                } else {
                    try {
                        UtilidadesLog.debug("*** dtoEstimado.getEstrategia(): "+dtoEstimado.getEstrategia());
                        estrategiaLocal = estrategiaLocalHome.findByUK(dtoEstimado.getEstrategia(), paisLocal.getOid());
                        estrategiaTemp = new DTOINTEstrategia();
                        estrategiaTemp.setOid(estrategiaLocal.getOid());
                        
                        UtilidadesLog.debug("COD Estrategia tiene valor -> se busca su oid: " + estrategiaTemp.getOid());
                    
                    } catch (NoResultException fe) {
                        UtilidadesLog.debug("*Metodo  RecepcionarEstimadosVenta: finder EstrategiaLocal ");
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, ErroresDeNegocio.INT_0112 + dtoEstimado.getEstrategia());
                        UtilidadesLog.debug("ha saltado finderException en EstrategiaLocal con dato = " + dtoEstimado.getEstrategia());
                        gi.registrarError(dtoError);
                        continue;
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                }

                UtilidadesLog.debug("CosteEstandar (BigDecimal) leido del archivo -> " + dtoEstimado.getCosteEstandar());
                UtilidadesLog.debug("CosteEstandar (BigDecimal) doubleValue() -> " + dtoEstimado.getCosteEstandar().doubleValue());
                
                if ((dtoEstimado.getCosteEstandar() == null) || (dtoEstimado.getCosteEstandar().doubleValue() <= 0.0d)) {
                    costeEstandarTemp = maestroProductosLocal.getCosteEstandard();
                    UtilidadesLog.debug("Coste vacio en archivo entrada -> se va a tomar de Mae-produ: " + costeEstandarTemp);
                
                } else {
                    costeEstandarTemp = dtoEstimado.getCosteEstandar();
                    UtilidadesLog.debug("CosteEstandar trajo valor en archivo entrada: " + costeEstandarTemp);
                }

                Long oidFidelizacion = null;
                oidFidelizacion = maestroProductosLocal.getProgramaFidelizacion();
                Long oidVariante = null;
                if  (oidFidelizacion != null) {
                    
                    VariantesLocalHome variantesLocalHome = this.getVariantesLocalHome();
                    try {
                        VariantesLocal variantesLocal = variantesLocalHome.findByUK(ConstantesINT.COD_VARIANTE_02); 
                        oidVariante = variantesLocal.getOid();
                    
                    } catch (NoResultException fe) {
                        throw new MareException(fe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }  catch (PersistenceException ce) {   
                        UtilidadesLog.error("ERROR ", ce);
                        throw new MareException(ce, 
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
                    }
                
                }
                
                UtilidadesLog.debug("Producto " + maestroProductosLocal.getOid());
                UtilidadesLog.debug("periodoCorporativoLocal " + periodoLocal.getOid());
                UtilidadesLog.debug("maestroProductosLocal " + maestroProductosLocal.getFormaPago());
                UtilidadesLog.debug("argumentoVentaLocal " + argumentoVentaLocal.getOid());
                UtilidadesLog.debug("condicionPromocionLocal " + condicionPromocionLocal.getOid());
                UtilidadesLog.debug("estrategiaTemp " + estrategiaTemp.getOid());
                UtilidadesLog.debug("monedaLocal " + monedaLocal);
                UtilidadesLog.debug("tipoOfertaTEMP " + tipoOfertaTEMP);
                UtilidadesLog.debug("cicloVidaLocal " + cicloVidaLocal.getOid());
                UtilidadesLog.debug("catalogoLocal " + catalogoLocal.getOid());
                UtilidadesLog.debug("oidFidelizacion " + oidFidelizacion);
                UtilidadesLog.debug("oidVariante " + oidVariante);

                ArrayList array = new ArrayList();
                array.add(factProyectLocalHome);
                array.add(maestroProductosLocal.getOid());
                array.add(periodoLocal.getOid());
                array.add(maestroProductosLocal.getFormaPago());
                array.add(argumentoVentaLocal.getOid());
                array.add(condicionPromocionLocal.getOid());
                array.add(estrategiaTemp.getOid());
                array.add(monedaTemp);
                array.add(tipoOfertaTEMP);
                array.add(cicloVidaLocal.getOid());
                array.add(catalogoLocal.getOid());
                array.add(costeEstandarTemp);

                if (accesoLocal != null) {
                      array.add(accesoLocal.getOid());
                }else{
                  array.add(null);
                }
                if (subaccesoLocal != null){
                    array.add(subaccesoLocal.getOid());

                }else{
                    array.add(null);
                }

                array.add(oidFidelizacion);
                array.add(oidVariante);
                

                if (((dtoEstimado.getEstrategia() == null) || (dtoEstimado.getEstrategia().trim().equals(""))) &&          
                    (argumentoVentaLocal.getOidTipoEstr()==null)){
                    
                        UtilidadesLog.error("Error de interfaz SAB-18 no existe el tipo de estrategia en el argumento de venta y");
                        UtilidadesLog.error(" tampoco estrategia en el registro."+array.toString());
                        
                        DTOINTError dtoError = new DTOINTError(interfaz, registro, "" + dtoEstimado);                        
                        gi.registrarError(dtoError);                        
                    
                    } else {
                        try {
                            this.getMONSAPBPSLocal().realizarCreate2(dtoEstimado, array, interfaz, gi);
                        } catch (Exception e) {                    
                            UtilidadesLog.debug("Fallo al realizar create en Facturacion Proyectada: " + e);
                        }                        
                    }

                registro.vaciar();
            
            } // Fin while
            
        } catch (RemoteException re) {

            UtilidadesLog.debug("\n     RemoteException. ");
            throw new MareException(re, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            
        } catch (InterfacesException ie) {

            UtilidadesLog.debug("\n     InterfacesException: cargarRegistro ");            
            return new DTOSalidaBatch(0, "recepcionarEstimadosVentasProyectada fin con error");
        }
        //  Agregado por HRCS - Incidencia SiCC20080604
        finally {
            try {
                gi.cerrarInterfaz(interfaz);
            } catch(Exception e) {
                UtilidadesLog.error("Error cerrando interfaz: " + e.getMessage(), e);
            }
        }

        UtilidadesLog.info("MONSAPBPSBean.recepcionarEstimadosVentasProyectadas(DTOBatch dtoBatch): Salida");
        return new DTOSalidaBatch(0, "recepcionarEstimadosVentasProyectada ejecutado");
    
    }

    /**
     * @author SPLATAS
     * @throws es.indra.mare.common.exception.MareException
     * @param gi
     * @param interfaz
     * @param array
     * @param dtoE
     * 
     * Descripcion: Este método realiza el create para la interfaz SAB-18 
     * en la entidad FacturaciónProyectada
     */
    public void realizarCreate2(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi) throws MareException 
    {
        UtilidadesLog.info("MONSAPBPSBean.realizarCreate2(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Entrada");
        
         if (interfaz.getCodigoInterfaz().compareTo(IGestorInterfaces.COD_INTERFAZ_SAB18) == 0) {
            UtilidadesLog.debug("--> CREATE DE LA INTERFAZ SAB-18");

            FacturacionProyectadaLocal facturacionLocal = null;
            
            UtilidadesLog.debug("   - SAP601: 1 ");
            FacturacionProyectadaLocalHome facturacionLocalHome = (FacturacionProyectadaLocalHome) array.get(0);

            Long formaPago = null;
            Long mone = null;
            
            UtilidadesLog.debug("   - SAP601: 2 ");
            if (array.get(3) != null) {
                formaPago = (Long) array.get(3);
            }
            
            UtilidadesLog.debug("   - SAP601: 3 ");
            if (array.get(7) != null) {
                mone = (Long) array.get(7);
            }
            

            UtilidadesLog.debug("Parametro 1:Long prod_oid_prod " + (Long) array.get(1));
            UtilidadesLog.debug("Parametro 2:Long perd_oid_peri " + (Long) array.get(2));

            if (formaPago != null) {
                UtilidadesLog.debug("Parametro 3Long fopa_oid_form_pago: " + formaPago);
            } else {
                UtilidadesLog.debug("Parametro 3(Forma pago): NULL");
            }

            UtilidadesLog.debug("Parametro 4:Long argv_oid_argu_vent " + (Long) array.get(4));
            UtilidadesLog.debug("Parametro 5:Long cndp_oid_cond_prom " + (Long) array.get(5));
            UtilidadesLog.debug("Parametro 6:Long coes_oid_estr " + (Long) array.get(6));

            if (mone != null) {
                UtilidadesLog.debug("Parametro 7:Long mone_oid_mone " + mone);
            } else {
                UtilidadesLog.debug("Parametro 7(Moneda): NULL");
            }

            UtilidadesLog.debug("Parametro 8:Long tofe_oid_tipo_ofer " + (Long) array.get(8));
            UtilidadesLog.debug("Parametro 9:Long civi_oid_cicl_vida " + (Long) array.get(9));
            UtilidadesLog.debug("Parametro 10:Long ocat_oid_cata " + (Long) array.get(10));

            if (array.get(11) != null) {
                UtilidadesLog.debug("Parametro 11:CosteEstandar " + (BigDecimal) array.get(11));
            } else {
                UtilidadesLog.debug("Parametro 11:CosteEstandar Null");
            }
            
            if (array.get(12) != null) {//acceso
                UtilidadesLog.debug("Parametro 12:acceso " + (Long) array.get(12));
            } else {
                UtilidadesLog.debug("Parametro 12:acceso Null");
            }

            if (array.get(13) != null) {//subacceso
                UtilidadesLog.debug("Parametro 13:subacceso " + (Long) array.get(13));
            } else {
                UtilidadesLog.debug("Parametro 13:subacceso Null");
            }

            if (array.get(14) != null) {//oidFidelizacion
                UtilidadesLog.debug("Parametro 14:oidFidelizacion " + (Long) array.get(14));
            } else {
                UtilidadesLog.debug("Parametro 14:oidFidelizacion Null");
            }
            if (array.get(15) != null) {//subacceso
                UtilidadesLog.debug("Parametro 15:variante " + (Long) array.get(15));
            } else {
                UtilidadesLog.debug("Parametro 15:variante Null");
            }

            try {
                UtilidadesLog.debug("ANTES DE FINDER");
                facturacionLocal = facturacionLocalHome.findByUK((Long) array.get(1), (Long) array.get(2), (Long) array.get(8), (Long) array.get(9));

                UtilidadesLog.debug("DESPUES DE FINDER... ACTUALIZANDO");
                
                facturacionLocal.setFopaOidFormPago(formaPago);                 
                facturacionLocal.setCndpOidCondProm((Long)array.get(5));
                facturacionLocal.setCoesOidEstr((Long)array.get(6));    
                facturacionLocal.setMoneOidMone(mone);                  
                
                
                if (array.get(4) != null) {
                    facturacionLocal.setArgvOidArguVent((Long)array.get(4));
                }
                if (array.get(10) != null) {
                    facturacionLocal.setOcatOidCata((Long)array.get(10));
                }
                if (array.get(11) != null) {
                    facturacionLocal.setValCostEsta(((BigDecimal) array.get(11)));
                } else {                                                        
                    facturacionLocal.setValCostEsta(null);
                }                                         

                facturacionLocal.setNumUnidProy(new Integer(dtoE.getUnidadesEstimadas().toString()));
                facturacionLocal.setNumPagiCata(dtoE.getNumeroPaginaCatalogo());
                facturacionLocal.setValPosiPagi(dtoE.getPosicionDentroPagina());

                if (dtoE.getPrecioCatalogo() != null) {
                    facturacionLocal.setImpPrecCata(dtoE.getPrecioCatalogo());
                } else {                                            
                    facturacionLocal.setImpPrecCata(null);       
                }                                                   

                if (dtoE.getVentaNetaEstimada() != null) {
                    facturacionLocal.setImpVentNetaEsti(dtoE.getVentaNetaEstimada());
                } else {                                                      
                    facturacionLocal.setImpVentNetaEsti(null);             
                }                                                          

                if (dtoE.getPrecioPosicionamiento() != null) {
                    facturacionLocal.setImpPrecPosi(dtoE.getPrecioPosicionamiento());
                } else {                                                    
                    facturacionLocal.setImpPrecPosi(null);   
                }                                            
                
                facturacionLocal.setValCent(dtoE.getCentro());
                
                if (array.get(12) != null) {//acceso
                    facturacionLocal.setAcceOidAcce((Long) array.get(12));
                } else {                                                        
                    facturacionLocal.setAcceOidAcce(null);                     
                }                                                              
                    
                if (array.get(13) != null) {//subacceso
                    facturacionLocal.setSbacOidSbac((Long) array.get(13));
                } else {                                                       
                    facturacionLocal.setSbacOidSbac(null);                     
                }                                                              
                
                if (array.get(14) != null) {//oidFidelizacion
                    facturacionLocal.setPrfiOidProgFide((Long) array.get(14));
                } else {                                                        
                    facturacionLocal.setPrfiOidProgFide(null);          
                }                                                            
                if (array.get(15) != null) {//oidVariante
                    facturacionLocal.setVariOidVari((Long) array.get(15));
                    
                } else {                                                     
                    facturacionLocal.setVariOidVari(null);                      
                } 
                facturacionLocalHome.merge(facturacionLocal);
            
            } catch (NoResultException ex) {
                try {
                    UtilidadesLog.debug("ANTES DE CREATE");
                    facturacionLocal = facturacionLocalHome.create(
                            (Long) array.get(9), //Long civi_oid_cicl_vida
                            (Long) array.get(8), //Long tofe_oid_tipo_ofer                            
                            (Long) array.get(1), //Long prod_oid_prod
                            (Long) array.get(2), //Long perd_oid_peri
                            (Long) array.get(14), //Long PRFI_OID_PROG_FIDE
                            (Long) array.get(5), //Long cndp_oid_cond_prom
                            (Long) array.get(10), //Long ocat_oid_cata
                            (Long) array.get(15), //Long VARI_OID_VARI
                            mone, //Long mone_oid_mone 
                            (Long) array.get(4) //Long argv_oid_argu_vent
                            
                        );

                    UtilidadesLog.debug("DESPUES DE CREATE");

                    if (array.get(11) != null) {
                        facturacionLocal.setValCostEsta((BigDecimal) array.get(11));
                    }
                    
                    facturacionLocal.setCoesOidEstr((Long) array.get(6));
                    facturacionLocal.setFopaOidFormPago(formaPago);
                    
                    facturacionLocal.setNumUnidProy(new Integer(dtoE.getUnidadesEstimadas().toString()));
                    facturacionLocal.setNumPagiCata(dtoE.getNumeroPaginaCatalogo());
                    facturacionLocal.setValPosiPagi(dtoE.getPosicionDentroPagina());

                    if (dtoE.getPrecioCatalogo() != null) {
                        facturacionLocal.setImpPrecCata(dtoE.getPrecioCatalogo());
                    }

                    if (dtoE.getVentaNetaEstimada() != null) {
                        facturacionLocal.setImpVentNetaEsti(dtoE.getVentaNetaEstimada());
                    }

                    if (dtoE.getPrecioPosicionamiento() != null) {
                        facturacionLocal.setImpPrecPosi(dtoE.getPrecioPosicionamiento());
                    }
                  
                    facturacionLocal.setValCent(dtoE.getCentro());
                    
                    if (array.get(12) != null) {//acceso
                        facturacionLocal.setAcceOidAcce((Long) array.get(12));
                    }
                        
                    if (array.get(13) != null) {//subacceso
                        facturacionLocal.setSbacOidSbac((Long) array.get(13));
                    }

                    if (array.get(14) != null) {//oidFidelizacion
                        facturacionLocal.setPrfiOidProgFide((Long) array.get(14));
                    }
                    if (array.get(15) != null) {//oidVariante
                        facturacionLocal.setVariOidVari((Long) array.get(15));
                    }
                    facturacionLocalHome.merge(facturacionLocal);

                } catch (PersistenceException ce) {                    
                    this.registrarError(dtoE, ErroresDeNegocio.INT_0013, interfaz, gi, IGestorInterfaces.COD_INTERFAZ_SAB18);
                }
            }  catch (PersistenceException ce) {
                 UtilidadesLog.error("ERROR ", ce);
                 throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
        
        UtilidadesLog.info("MONSAPBPSBean.realizarCreate2(DTOINTEstimado dtoE, ArrayList array, InterfazInfo interfaz, MONGestorInterfaces gi): Salida");
    
    
    }  
    
    
    private void generarInsertTotales (DTOVentaDiaProducto dtoVentaDiaProductoTotales) throws MareException {
        UtilidadesLog.info("MONSAPBPSBean.generarInsertTotales(DTOVentaDiaProducto dtoVentaDiaProductoTotales): Entrada");  
        StringBuffer query = new StringBuffer();
        SimpleDateFormat simpledateformat = new SimpleDateFormat("dd/MM/yyyy");
        Integer cantidadZonas = new Integer(0);
        Integer cantidadSolicitudes = new Integer(0);
        Integer cantidadClientes = new Integer(0);
        
        query.append("SELECT COUNT(DISTINCT ZZON_OID_ZONA) CANT_ZONAS, ");
        query.append("       COUNT(OID_SOLI_CABE) CANT_SOLI,   ");
        query.append("       COUNT(DISTINCT CLIE_OID_CLIE) CANT_CLIE  ");
        query.append("FROM PED_SOLIC_CABEC PSC, ");
        query.append("     SEG_MODUL SM, ");
        query.append("     PED_TIPO_SOLIC_PAIS TSP, ");
        query.append("     PED_TIPO_SOLIC PTS ");
        query.append("WHERE PSC.PERD_OID_PERI = ").append(dtoVentaDiaProductoTotales.getOidPeriodo());
        query.append("  AND PSC.FEC_FACT = TO_DATE('").append(simpledateformat.format(dtoVentaDiaProductoTotales.getFechaFacturacion())).append("', 'DD-MM-YYYY') ");
        query.append("  AND PSC.IND_TS_NO_CONSO = 1 ");
        query.append("  AND PSC.IND_OC = 1 ");
        query.append("  AND PSC.IND_PEDI_PRUE <> 1   ");
        query.append("  AND PSC.MODU_OID_MODU = SM.OID_MODU ");
        query.append("  AND SM.COD_MODU <> 15 ");
        query.append("  AND PSC.TSPA_OID_TIPO_SOLI_PAIS = TSP.OID_TIPO_SOLI_PAIS ");
        query.append("  AND TSP.TSOL_OID_TIPO_SOLI = PTS.OID_TIPO_SOLI ");
        query.append("  AND PTS.IND_ANUL <> 1 ");
        query.append("  AND PTS.IND_DEVO <> 1 ");
        
        RecordSet rs = null;
        rs = UtilidadesBD.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()) {
            cantidadZonas = UtilidadesBD.convertirAInteger(rs.getValueAt(0, "CANT_ZONAS"));
            cantidadSolicitudes = UtilidadesBD.convertirAInteger(rs.getValueAt(0, "CANT_SOLI"));
            cantidadClientes = UtilidadesBD.convertirAInteger(rs.getValueAt(0, "CANT_CLIE"));
        }
        
        query = new StringBuffer();
        query.append("SELECT SUM(CASE WHEN PT.NUM_UNID_VEND = 1 AND SC.IND_OC = 1 THEN SP.NUM_UNID_ATEN ELSE 0 END) AS UNID_ATEN_VENDIDAS_TOTAL, ");
        query.append(" 	   SUM(CASE WHEN PT.NUM_UNID_FALT = 1 AND SC.IND_OC = 1 THEN (SP.NUM_UNID_DEMA_REAL - SP.NUM_UNID_COMPR) ELSE 0 END)  AS UNID_ATEN_FALTANTES_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_DEVU = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" THEN SP.NUM_UNID_ATEN ELSE 0 END) ) AS UNID_ATEN_DEVUELTAS_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_ANUL = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" THEN SP.NUM_UNID_ATEN ELSE 0 END) ) AS UNID_ATEN_ANULADAS_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_CANJ = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" THEN SP.NUM_UNID_ATEN ELSE 0 END) ) AS UNID_ATEN_CANJE_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_TRUE = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" THEN SP.NUM_UNID_ATEN ELSE 0 END) ) AS UNID_ATEN_TRUEQUE_TOTAL,  ");
        query.append("	   SUM(CASE WHEN PT.NUM_UNID_VEND = 1 AND SC.IND_OC = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN SP.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END)  AS VENTA_NETA_VENDIDAS_TOTAL,  ");
        query.append("	   SUM(CASE WHEN PT.NUM_UNID_FALT = 1 AND SC.IND_OC = 1 AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN (SP.NUM_UNID_DEMA_REAL - SP.NUM_UNID_COMPR) * SP.VAL_PREC_NETO_UNIT_LOCA ELSE 0 END)  AS VENTA_NETA_FALTANTES_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_DEVU = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN SP.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) ) AS VENTA_NETA_DEVUELTAS_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_ANUL = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN SP.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) ) AS VENTA_NETA_ANULADAS_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_CANJ = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN SP.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) ) AS VENTA_NETA_CANJE_TOTAL,  ");
        query.append("	   ABS(SUM(CASE WHEN PT.NUM_UNID_TRUE = 1 AND SC.MODU_OID_MODU = ").append(ConstantesSEG.MODULO_REC).append(" AND SP.VAL_PREC_CATA_UNIT_LOCA<>0 THEN SP.VAL_PREC_NETO_TOTA_LOCA ELSE 0 END) ) AS VENTA_NETA_TRUEQUE_TOTAL,  ");
        query.append("	   SUM(CASE WHEN PT.NUM_UNID_VEND = 1 AND SC.IND_OC = 1 THEN SP.VAL_PREC_CATA_TOTA_LOCA ELSE 0 END)  AS PREC_CATA_VENDIDAS_TOTAL,  ");
        query.append("	   SUM(CASE WHEN PT.NUM_UNID_FALT = 1 AND SC.IND_OC = 1 THEN (SP.NUM_UNID_DEMA_REAL - SP.NUM_UNID_COMPR) * SP.VAL_PREC_CATA_UNIT_LOCA ELSE 0 END)  AS PREC_CATA_FALTANTES_TOTAL ");
        query.append("FROM PED_SOLIC_CABEC SC,  ");
        query.append("	 PED_SOLIC_POSIC SP,  ");
        query.append("	 PED_TIPO_SOLIC_PAIS TS,  ");
        query.append("	 INT_PARAM_TIPO_SOLIC PT,  ");
        query.append("	 (SELECT POD.OID_DETA_OFER, POD.VAL_CODI_VENT, POD.CIVI_OID_CICLO_VIDA, POD.TOFE_OID_TIPO_OFER,  ");
        query.append("     		 (CASE WHEN POD.CNDP_OID_COND_PROM IS NULL  ");
        query.append("          	 	   THEN (SELECT OID_COND_PROM FROM PRE_CONDI_PROMO WHERE COD_COND_PROM = '00')  ");
        query.append("			      ELSE POD.CNDP_OID_COND_PROM  ");
        query.append("	     END) CNDP_OID_COND_PROM  ");
        query.append("  	  FROM PRE_OFERT_DETAL POD) OD,  ");
        query.append("     ZON_TERRI TER,          ");
        query.append("	 SEG_PAIS PAIS,  ");
        query.append("	 SEG_SOCIE SOCIEDAD, ");         
        query.append("	 BEL_ALMAC ALMACEN,      ");  
        query.append("	 INT_CODIG_MEDIO_SAPBP CODMEDIOSAP,  ");
        query.append("	 INT_CANAL_BPS CANALBPS, ");
        query.append("	 CRA_PERIO PERIODO,  ");
        query.append("	 SEG_PERIO_CORPO PERIODOCORPO,  ");
        query.append("	 MAE_PRODU MAEPROD, ");
        query.append("	 PRE_CICLO_VIDA CICLOVIDA,  ");
        query.append("	 PRE_TIPO_OFERT TIPOOFERTA,  ");
        query.append("	 PRE_CONDI_PROMO CONDPROM, ");
        query.append("	 SEG_MARCA MARCA,  ");
        query.append("	 PED_TIPO_SOLIC TSOL  ");
        query.append("WHERE SP.SOCA_OID_SOLI_CABE = SC.OID_SOLI_CABE  ");
        query.append("  AND SP.OFDE_OID_DETA_OFER = OD.OID_DETA_OFER (+)  ");
        query.append("  AND SC.TSPA_OID_TIPO_SOLI_PAIS = TS.OID_TIPO_SOLI_PAIS  ");
        query.append("  AND PT.TSPA_OID_TIPO_SOLI_PAIS = TS.OID_TIPO_SOLI_PAIS  ");
        query.append("  AND SC.PAIS_OID_PAIS = ").append(dtoVentaDiaProductoTotales.getOidPais());
        query.append("  AND SC.PAIS_OID_PAIS = PAIS.OID_PAIS  ");
        query.append("  AND SC.PERD_OID_PERI = ").append(dtoVentaDiaProductoTotales.getOidPeriodo());
        query.append("  AND SC.FEC_FACT = TO_DATE('").append(simpledateformat.format(dtoVentaDiaProductoTotales.getFechaFacturacion())).append("' ,'DD/MM/YYYY')  ");
        query.append("  AND SC.IND_TS_NO_CONSO = 1   ");
        query.append("  AND SC.IND_PEDI_PRUE = 0   ");
        query.append("  AND SP.ESPO_OID_ESTA_POSI <> ").append(ConstantesPED.ESTADO_POSICION_ANULADO); 
        query.append("  AND SP.VAL_CODI_VENT = OD.VAL_CODI_VENT (+)  ");
        query.append("  AND TER.OID_TERR = SC.TERR_OID_TERR  ");
        query.append("  AND SC.SOCI_OID_SOCI = SOCIEDAD.OID_SOCI "); 
        query.append("  AND SC.ALMC_OID_ALMA =  ALMACEN.OID_ALMA   ");
        query.append("  AND SC.PAIS_OID_PAIS = CODMEDIOSAP.PAIS_OID_PAIS AND SC.SBAC_OID_SBAC = CODMEDIOSAP.SBAC_OID_SBAC  ");
        query.append("  AND SC.TICL_OID_TIPO_CLIE = CANALBPS.TICL_OID_TIPO_CLIE AND SC.TSPA_OID_TIPO_SOLI_PAIS = CANALBPS.TSPA_OID_TIPO_SOLI_PAIS  ");
        query.append("  AND SC.PERD_OID_PERI = PERIODO.OID_PERI  ");
        query.append("  AND PERIODO.PERI_OID_PERI = PERIODOCORPO.OID_PERI  ");
        query.append("  AND SP.PROD_OID_PROD = MAEPROD.OID_PROD  ");
        query.append("  AND OD.CIVI_OID_CICLO_VIDA = CICLOVIDA.OID_CICL_VIDA (+)  ");
        query.append("  AND OD.TOFE_OID_TIPO_OFER = TIPOOFERTA.OID_TIPO_OFER (+)   ");
        query.append("  AND OD.CNDP_OID_COND_PROM = CONDPROM.OID_COND_PROM (+)  ");
        query.append("  AND PERIODO.MARC_OID_MARC = MARCA.OID_MARC  ");
        query.append("  AND TS.TSOL_OID_TIPO_SOLI = TSOL.OID_TIPO_SOLI  ");
        query.append("  AND (  ");
        query.append("       (  ");
        query.append("          PT.NUM_UNID_VEND = 1  ");
        query.append("          AND TSOL.IND_ANUL = 0  ");
        query.append("          AND TSOL.IND_DEVO = 0  ");
        query.append("          AND SC.IND_OC = 1  ");
        query.append("       ) OR (  ");
        query.append("          PT.NUM_UNID_FALT = 1   ");
        query.append("          AND TSOL.IND_ANUL = 0  ");
        query.append("          AND TSOL.IND_DEVO = 0  ");
        query.append("          AND SC.IND_OC = 1  ");
        query.append("       ) OR (  ");
        query.append("          PT.NUM_UNID_DEVU = 1   ");
        query.append("          AND SC.IND_OC = 1  ");
        query.append("          AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, SP.OID_SOLI_POSI)>0          ");
        query.append("       ) OR (  ");
        query.append("          PT.NUM_UNID_ANUL = 1   ");
        query.append("          AND SC.IND_OC = 1  ");
        query.append("          AND FN_DAT_VALIDAR_PROD_SOLI_DEVO(SC.OID_SOLI_CABE, SP.OID_SOLI_POSI)>0          ");
        query.append("       ) OR (  ");
        query.append("          PT.NUM_UNID_CANJ = 1   ");
        query.append("          AND TSOL.IND_ANUL = 0  ");
        query.append("          AND TSOL.IND_DEVO = 0  ");
        query.append("          AND SC.IND_OC = 0  ");
        query.append("       ) OR (  ");
        query.append("          PT.NUM_UNID_TRUE = 1  ");
        query.append("          AND TSOL.IND_ANUL = 0  ");
        query.append("          AND TSOL.IND_DEVO = 0  ");
        query.append("          AND SC.IND_OC = 0  ");
        query.append("       )  ");
        query.append(") ");

        rs = null;
        rs = UtilidadesBD.executeQuery(query.toString());
        
        if (rs != null && !rs.esVacio()) {
            dtoVentaDiaProductoTotales.setUnidadesAtendidasVendidas(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_VENDIDAS_TOTAL")));
            dtoVentaDiaProductoTotales.setUnidadesAtendidasFaltantes(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_FALTANTES_TOTAL")));
            dtoVentaDiaProductoTotales.setUnidadesAtendidasDevueltas(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_DEVUELTAS_TOTAL")));
            dtoVentaDiaProductoTotales.setUnidadesAtendidasAnuladas(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_ANULADAS_TOTAL")));
            dtoVentaDiaProductoTotales.setUnidadesAtendidasCanje(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_CANJE_TOTAL")));
            dtoVentaDiaProductoTotales.setUnidadesAtendidasTrueque(UtilidadesBD.convertirALong(rs.getValueAt(0, "UNID_ATEN_TRUEQUE_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaVendidas(validarDato(rs.getValueAt(0, "VENTA_NETA_VENDIDAS_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaFaltantes(validarDato(rs.getValueAt(0, "VENTA_NETA_FALTANTES_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaDevueltas(validarDato(rs.getValueAt(0, "VENTA_NETA_DEVUELTAS_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaAnuladas(validarDato(rs.getValueAt(0, "VENTA_NETA_ANULADAS_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaCanje(validarDato(rs.getValueAt(0, "VENTA_NETA_CANJE_TOTAL")));
            dtoVentaDiaProductoTotales.setVentaNetaTrueque(validarDato(rs.getValueAt(0, "VENTA_NETA_TRUEQUE_TOTAL")));
            dtoVentaDiaProductoTotales.setPrecioCatalogoTotalLocalVendidas(validarDato(rs.getValueAt(0, "PREC_CATA_VENDIDAS_TOTAL")));
            dtoVentaDiaProductoTotales.setPrecioCatalogoTotalLocalFaltantes(validarDato(rs.getValueAt(0, "PREC_CATA_FALTANTES_TOTAL")));
        }        
        
        query = new StringBuffer();
        query.append("DELETE INT_VENTA_DIARI_TOTAL WHERE PERD_OID_PERI = ").append(dtoVentaDiaProductoTotales.getOidPeriodo());
        query.append(" AND FEC_FACT = ").append("TO_DATE( '").append(simpledateformat.format(dtoVentaDiaProductoTotales.getFechaFacturacion())).append("', 'DD/MM/YYYY');");        
        query.append("INSERT INTO INT_VENTA_DIARI_TOTAL (");
        query.append("OID_INT_VENT_DIAR_TOTA, ");
        query.append("VAL_NUME_UNID_PROY, ");
        query.append("VAL_NUME_UNID_VEND, ");
        query.append("VAL_NUME_UNID_FALT, ");
        query.append("VAL_NUME_UNID_DEVU, ");
        query.append("VAL_NUME_UNID_ANUL, ");
        query.append("VAL_NUME_UNID_CANJ, ");
        query.append("VAL_NUME_UNID_TRUE, ");
        query.append("VAL_IMPO_VENT_NETA_PROY, ");
        query.append("VAL_IMPO_VENT_NETA_ATEN, ");
        query.append("VAL_IMPO_VENT_NETA_FALT, ");
        query.append("VAL_IMPO_VENT_NETA_DEVO, ");
        query.append("VAL_IMPO_VENT_NETA_ANUL, ");
        query.append("VAL_IMPO_VENT_NETA_CANJ, ");
        query.append("VAL_IMPO_VENT_NETA_TRUE, ");
        query.append("VAL_IMPO_VENT_BRUT_REAL, ");
        query.append("VAL_IMPO_VENT_BRUT_FALT, ");
        query.append("VAL_NUME_ZONA, ");
        query.append("VAL_NUME_ORDE, ");
        query.append("VAL_NUME_PEDI, ");
        query.append("FEC_FACT, ");
        query.append("PERD_OID_PERI, ");
        query.append("ALMC_OID_ALMA, ");
        query.append("SOCI_OID_SOCI, ");
        query.append("MONE_OID_MONE, ");
        query.append("PAIS_OID_PAIS, ");
        query.append("VAL_CANA_BPS, ");
        query.append("VAL_MEDI, ");
        query.append("VAL_ANIO");
        query.append(")VALUES ( ");
        query.append("INT_IVDT_SEQ.NEXTVAL, ");
        query.append("0, ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasVendidas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasFaltantes()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasDevueltas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasAnuladas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasCanje()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getUnidadesAtendidasTrueque()).append(", ");
        query.append("0, ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaVendidas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaFaltantes()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaDevueltas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaAnuladas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaCanje()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getVentaNetaTrueque()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getPrecioCatalogoTotalLocalVendidas()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getPrecioCatalogoTotalLocalFaltantes()).append(", ");
        query.append(cantidadZonas).append(", ");
        query.append(cantidadSolicitudes).append(", ");
        query.append(cantidadClientes).append(", ");
        query.append("TO_DATE( '").append(simpledateformat.format(dtoVentaDiaProductoTotales.getFechaFacturacion())).append("', 'DD/MM/YYYY'), ");        
        query.append(dtoVentaDiaProductoTotales.getOidPeriodo()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getOidAlmacen()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getOidSociedad()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getOidMoneda()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getOidPais()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getCanalBPS()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getMedio()).append(", ");
        query.append(dtoVentaDiaProductoTotales.getAnioComercial()).append(");");

        try{
            BelcorpService.getInstance().dbService.executeProcedure("PQ_PLANI.EXECUTOR", query.toString());
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }    

        UtilidadesLog.info("MONSAPBPSBean.generarInsertTotales(DTOVentaDiaProducto dtoVentaDiaProductoTotales): Salida");
    
    }
    
    private BigDecimal validarDato(Object obj) {
        if ( obj != null) {
            return ((BigDecimal)obj);
        } else {
            return new BigDecimal(0);    
        }
    }


    // SAB-18
    private FacturacionProyectadaLocalHome getFacturacionProyectadaLocalHome() throws MareException {

        FacturacionProyectadaLocalHome home = (FacturacionProyectadaLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/FacturacionProyectada");

        return home;
    } 
    
    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws MareException {

        MaestroProductosLocalHome home = (MaestroProductosLocalHome) UtilidadesEJB.getLocalHome("java:comp/env/MaestroProductos");

        return home;
    }


    private IdiomaLocalHome getIdiomaLocalHome() {
            return new IdiomaLocalHome();
    }

    private CicloVidaLocalHome getCicloVidaLocalHome() {
            return new CicloVidaLocalHome();
    }

    private TipoEstrategiaLocalHome getTipoEstrategiaLocalHome() {
            return new TipoEstrategiaLocalHome();
    }

    private ArgumentoVentaLocalHome getArgumentoVentaLocalHome() {
            return new ArgumentoVentaLocalHome();
    }

    private Entidadi18nLocalHome getEntidadi18nLocalHome() {
            return new Entidadi18nLocalHome();
    }

    private CatalogoLocalHome getCatalogoLocalHome() {
            return new CatalogoLocalHome();
    }

    private CondicionPromocionLocalHome getCondicionPromocionLocalHome() {
            return new CondicionPromocionLocalHome();
    }

    private CanalLocalHome getCanalLocalHome() {
            return new CanalLocalHome();
    }

    private TipoOfertaLocalHome getTipoOfertaLocalHome() {
            return new TipoOfertaLocalHome();
    }

    private EstrategiaLocalHome getEstrategiaLocalHome() {
            return new EstrategiaLocalHome();
    }

    private MonedaLocalHome getMonedaLocalHome() {
            return new MonedaLocalHome();
    }

    private PaisLocalHome getPaisLocalHome() {
            return new PaisLocalHome();
    }

    private PeriodoCorporativoLocalHome getPeriodoCorporativoLocalHome() {
            return new PeriodoCorporativoLocalHome();
    }

    private EstimadosVentaLocalHome getEstimadosVentaLocalHome() {
            return new EstimadosVentaLocalHome();
    }

    private ConfiguracionMFPaisLocalHome getConfiguracionMFPaisLocalHome() {
            return new ConfiguracionMFPaisLocalHome();
    }

    private AccesoLocalHome getAccesoLocalHome() {
            return new AccesoLocalHome();
    }

    private SubaccesoLocalHome getSubaccesoLocalHome() {
            return new SubaccesoLocalHome();
    }

    private VariantesLocalHome getVariantesLocalHome() {
            return new VariantesLocalHome();
    }

    private TipoClienteLocalHome getTipoClienteLocalHome() {
            return new TipoClienteLocalHome();
    }
    
    private MarcaLocalHome getMarcaLocalHome() {
            return new MarcaLocalHome();
    }

    private EmpresaLocalHome getEmpresaLocalHome() {
            return new EmpresaLocalHome();
    }

    private AlmacenesLocalHome getAlmacenesLocalHome() {
            return new AlmacenesLocalHome();
    }

    private MarcaProductoLocalHome getMarcaProductoLocalHome() {
            return new MarcaProductoLocalHome();
    }

    private RegionLocalHome getRegionLocalHome() {
            return new RegionLocalHome();
    }

    private ZonaLocalHome getZonaLocalHome() {
            return new ZonaLocalHome();
    }
    
    private CanalBPSLocalHome getCanalBPSLocalHome() {
            return new CanalBPSLocalHome();
    }

    private CodigoMedioSAPBPSLocalHome getCodigoMedioSAPBPSLocalHome() {
            return new CodigoMedioSAPBPSLocalHome();
    }

    private FuenteVentasPrevistaSAPLocalHome getFuenteVentasPrevistaSAPLocalHome() {
            return new FuenteVentasPrevistaSAPLocalHome();
    }

    private VentasTotalesCampaniaLocalHome getVentasTotalesCampaniaLocalHome() {
            return new VentasTotalesCampaniaLocalHome();
    }

    private MONSAPBPSLocal getMONSAPBPSLocal() throws NamingException, MareException {     
      MONSAPBPSLocalHome localHome = this.getMONSAPBPSLocalHome();
      MONSAPBPSLocal ejb = null;
      try {
        ejb = localHome.create();
      } catch (Exception e) {
        UtilidadesLog.error("*** Error en getMONSAPBPSLocal",e);
        String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
        throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
      } 
      return ejb;
    }

     private MONSAPBPSLocalHome getMONSAPBPSLocalHome() throws NamingException {
      final InitialContext context = new InitialContext();
      return (MONSAPBPSLocalHome)context.lookup("java:comp/env/MONSAPBPS");
    }
    

    

    

    
    
    
}
