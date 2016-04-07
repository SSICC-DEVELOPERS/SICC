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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.pre.DTODatosEstrategia;
import es.indra.sicc.dtos.pre.DTOEConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOELeerConfiguracionMF;
import es.indra.sicc.dtos.pre.DTOSConfiguracionMF;
import es.indra.sicc.entidades.cra.PeriodoLocal;
import es.indra.sicc.entidades.cra.PeriodoLocalHome;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocal;
import es.indra.sicc.entidades.pre.ArgumentoVentaLocalHome;
import es.indra.sicc.entidades.pre.CabeceraMFLocal;
import es.indra.sicc.entidades.pre.CabeceraMFLocalHome;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocal;
import es.indra.sicc.entidades.pre.ConfiguracionMFPaisLocalHome;
import es.indra.sicc.entidades.pre.EstrategiaLocal;
import es.indra.sicc.entidades.pre.EstrategiaLocalHome;
import es.indra.sicc.entidades.pre.TipoEstrategiaLocal;
import es.indra.sicc.entidades.pre.TipoEstrategiaLocalHome;
import es.indra.sicc.logicanegocio.pre.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.rmi.RemoteException;

import java.util.Collection;
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

/*
 * rgiorgi - 19/08/2005: se formatea la clase
 * */
/**
* MON encargado de ABMC de la Configuracion de la Matriz de Facturacion.
*
* @version 3.6 - 12 Sep 2005
* @author Emilio Noziglia
*/ 
public class MONConfiguracionMFBean implements SessionBean {
    SessionContext ctx = null;

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

    public DTOSConfiguracionMF leerConfiguracion(DTOELeerConfiguracionMF dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.leerConfiguracion(DTOELeerConfiguracionMF dto): Entrada");
        DTOSConfiguracionMF dtoS = new DTOSConfiguracionMF();
        Collection col = null;

        try {
            ConfiguracionMFPaisLocalHome cmfplh = new ConfiguracionMFPaisLocalHome();
            col = cmfplh.findByPaisMarcaCanal(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal());
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        if (col.size() == 1) {
            Iterator it = col.iterator();
            ConfiguracionMFPaisLocal cMFL = (ConfiguracionMFPaisLocal) it.next();
            dtoS.setOidConfiguracionMF(cMFL.getOid());
            dtoS.setOidMoneda(cMFL.getOidMoneda());
            //dtoS.setLongitudSerie(cMFL.getLongitudSerie());
            //dtoS.setLongitudTipo(cMFL.getLongitudTipo());
        }

        BelcorpService belcorpService;
        RecordSet rs;

        try {
            belcorpService = BelcorpService.getInstance();

            StringBuffer query = new StringBuffer();

            query.append(" select P.MONE_OID_MONE_ALT, V.VAL_I18N");
            query.append(" from GEN_I18N_SICC V , SEG_PAIS P");
            query.append(" where V.IDIO_OID_IDIO = '" + dto.getOidIdioma() + "' ");
            query.append(" and V.ATTR_NUM_ATRI = 1 ");
            query.append(" and V.ATTR_ENTI = 'SEG_MONED' ");
            query.append(" and V.VAL_OID = P.MONE_OID_MONE_ALT ");
            query.append(" and P.OID_PAIS = " + dto.getOidPais());

            rs = belcorpService.dbService.executeStaticQuery(query.toString());

            if (!rs.esVacio()) {
                dtoS.setOidMonedaAlternativa(new Long(((BigDecimal) rs.getValueAt(0, "MONE_OID_MONE_ALT")).longValue()));
                dtoS.setDescripcionMoneda((String) rs.getValueAt(0, "VAL_I18N"));
            }

            //dtoS.setMonedas(rs);
        } catch (Exception e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONConfiguracionMFBean.leerConfiguracion(DTOELeerConfiguracionMF dto): Salida");
        return dtoS;
    }

    public void guardarConfiguracion(DTOEConfiguracionMF dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.guardarConfiguracion(DTOEConfiguracionMF dto): Entrada");
        Boolean valido = Boolean.FALSE;

        try {
            //Modificado por jrivas 04/12/2004
            //Estan mal pasados los parametros
            //pais, sociedad, marca y canal 
            // y estaban pais, marca y canal
            //valido = getMONValidacionHome().create().validarAccesos(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal(),null,null,null,null, null,null,null,null);
            valido = getMONValidacionHome().create().validarAccesos(dto.getOidPais(), null, dto.getOidMarca(), dto.getOidCanal(), null, null, null, null, null, null, null);
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (valido.booleanValue()) {
            try {
                if (dto.getOidConfiguracionMF() != null) { //Modifico

                    ConfiguracionMFPaisLocalHome cLh = new ConfiguracionMFPaisLocalHome();                    

                    ConfiguracionMFPaisLocal cL = cLh.findByPrimaryKey(dto.getOidConfiguracionMF());
                    cLh.remove(cL);
                }

                ConfiguracionMFPaisLocalHome cLh = new ConfiguracionMFPaisLocalHome();                

                cLh.create(dto.getOidPais(), dto.getOidMarca(), dto.getOidCanal(), dto.getOidMoneda());
                
            } catch (NoResultException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } 
        } else {
            ctx.setRollbackOnly();
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.NO_VALIDO_ACCESOS));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.guardarConfiguracion(DTOEConfiguracionMF dto): Salida");
    }
    
    private boolean valida(Integer numero, Integer longitud) {
        UtilidadesLog.info("MONConfiguracionMFBean.valida(Integer numero, Integer longitud): Entrada");
        String n = numero.toString();
        
        if (n.length() > longitud.longValue()) {
            UtilidadesLog.info("MONConfiguracionMFBean.valida(Integer numero, Integer longitud): Salida");
            return false;
        } else {
            UtilidadesLog.info("MONConfiguracionMFBean.valida(Integer numero, Integer longitud): Salida");
            return true;
        }
    }
 
  /**
   * @modificado: Emilio Noziglia
   * @Fecha : 09/09/2005
   * @Recibe: DTODatosEstrategia dto
   * @Retorna: void 
   * @Descripción: el metodo guarda una estrategia segun los parametros recibidos
   *               modificacion: se agrega el campo OrdenAsignacionCUV
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   */ 
    public void guardarEstrategia(DTODatosEstrategia dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.guardarEstrategia(DTODatosEstrategia dto): Entrada");
        
        UtilidadesLog.debug("Datos de entrada: DTODatosEstrategia:"+dto);
        
        Boolean valido = Boolean.FALSE;

        try {
            valido = getMONValidacionHome().create().validarAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null);
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (valido.booleanValue()) {
            try {
                EstrategiaLocalHome estlh = new EstrategiaLocalHome();                

                EstrategiaLocal estl = estlh.create(dto.getOidPais(), dto.getOidTipoEstrategia(), dto.getCodigo().toUpperCase());

                estl.setMaxGrupos(dto.getMaxGrupos());
                estl.setMaxGruposCondicionados(dto.getMaxGruposCondicionados());
                estl.setMaxGruposCondicionantes(dto.getMaxGruposCondicionantes());
                estl.setListaRanking(dto.getListaRanking());
                estl.setCuadreGrupos(dto.getCuadreGrupos());
                estl.setOidTipoProd(dto.getOidTipoProducto());
                estl.setCvImprimible(dto.getCvImprimible());
                estl.setModificableImprimible(dto.getModificableImprimible());
                estl.setCvDespachoAutomatico(dto.getCvDespachoAutomatico());
                estl.setModificableDespachoAutomatico(dto.getModificableDespachoAutomatico());
                estl.setCvDigitable(dto.getCvDigitable());
                estl.setModificableDigitable(dto.getModificableDigitable());
                //modificado enozigli 09/09/2005 se agrega el campo ordenAsignacionCUV y se guarda.
                //segun DMCO gmiotti SICC-DMCO-PRE-201-354-P0012-CUV
                estl.setOrdenAsignacionCUV(dto.getOrdenAsignacionCUV());
                
                estlh.merge(estl);

                actualizarDescripcion(dto.getAttriTraducible(), estl.getOid());
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            } catch (RemoteException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        } else {
            ctx.setRollbackOnly();
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.NO_VALIDO_ACCESOS));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.guardarEstrategia(DTODatosEstrategia dto): Salida");
    }

  /**
   * @modificado: Emilio Noziglia
   * @Fecha : 09/09/2005
   * @Recibe: DTODatosEstrategia dto
   * @Retorna: void 
   * @Descripción: el metodo modifica una estrategia segun los parametros recibidos
   *               modificacion: se agrega el campo OrdenAsignacionCUV
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   */ 
    public void modificarEstrategia(DTODatosEstrategia dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.modificarEstrategia(DTODatosEstrategia dto): Entrada");
        
        //UtilidadesLog.debug("Datos Entrada: DTODatosEstrategia:"+dto);
    
        Boolean valido = Boolean.FALSE;

        try {
            valido = getMONValidacionHome().create().validarAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null);
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (valido.booleanValue()) {
            try {
                //UtilidadesLog.debug("dto ESTRATEGIAS " + dto);

                EstrategiaLocalHome estlh = new EstrategiaLocalHome();                

                EstrategiaLocal estl = estlh.findByPrimaryKey(dto.getOid());
                estl.setMaxGrupos(dto.getMaxGrupos());
                estl.setMaxGruposCondicionados(dto.getMaxGruposCondicionados());
                estl.setMaxGruposCondicionantes(dto.getMaxGruposCondicionantes());

                //estl.setOidTipoEstr(dto.getOidTipoEstrategia());
                estl.setListaRanking(dto.getListaRanking());
                estl.setCuadreGrupos(dto.getCuadreGrupos());
                estl.setOidTipoProd(dto.getOidTipoProducto());
                estl.setCvImprimible(dto.getCvImprimible());
                estl.setModificableImprimible(dto.getModificableImprimible());
                estl.setCvDespachoAutomatico(dto.getCvDespachoAutomatico());
                estl.setModificableDespachoAutomatico(dto.getModificableDespachoAutomatico());
                estl.setCvDigitable(dto.getCvDigitable());
                estl.setModificableDigitable(dto.getModificableDigitable());
                //modificado enozigli 09/09/2005 se agrega el campo OrdenAsignacionCUV
                //segun DMCO gmiotti SICC-DMCO-PRE-201-354-P0012-CUV
                estl.setOrdenAsignacionCUV(dto.getOrdenAsignacionCUV());
                estlh.merge(estl);

                actualizarDescripcion(dto.getAttriTraducible(), dto.getOid());
            } catch (RemoteException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (NoResultException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } else {
            ctx.setRollbackOnly();
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.NO_VALIDO_ACCESOS));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.modificarEstrategia(DTODatosEstrategia dto): Salida");
    }

    public void eliminarEstrategia(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.eliminarEstrategia(DTOOIDs dto): Entrada");
        Boolean valido = Boolean.FALSE;

        try {
            valido = getMONValidacionHome().create().validarAccesos(dto.getOidPais(), null, null, null, null, null, null, null, null, null, null);
        } catch (NamingException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

        if (valido.booleanValue()) {
            try {
                Long[] oids = dto.getOids();
                EstrategiaLocalHome estlh = new EstrategiaLocalHome();

                for (int i = 0; i < oids.length; i++) {
                    //estlh.parametrosAuditoria(dto);
                    EstrategiaLocal estl = estlh.findByPrimaryKey(oids[i]);
                    estlh.remove(estl);
                    eliminarDescripcion(oids[i]);
                }
            } catch (NoResultException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } else {
            ctx.setRollbackOnly();
            throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_PRE, "", ErroresNegocio.NO_VALIDO_ACCESOS));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.eliminarEstrategia(DTOOIDs dto): Salida");
    }
  /**
   * @modificado: Emilio Noziglia
   * @Fecha : 09/09/2005
   * @Recibe: DTOOID dto
   * @Retorna: DTODatosEstrategia 
   * @Descripción: el metodo obtiene una estrategia segun el oid de estrategia recibido
   *               modificacion: se agrega el campo OrdenAsignacionCUV
   * @Referencia: SICC-DMCO-PRE-201-354-P0012-CUV
   */ 
    public DTODatosEstrategia obtenerDetalleEstrategia(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.obtenerDetalleEstrategia(DTOOID dto): Entrada");
        
        //UtilidadesLog.debug("Datos Entrada: DTOOID:"+dto);
       
        StringBuffer strBuf = new StringBuffer();        
        
        strBuf.append(" SELECT pe.oid_estr, pe.cod_estr, pe.ties_oid_tipo_estr, pte.ind_estr_grup, ");
               strBuf.append(" pte.ind_estr_cond, pte.ind_estr_vs, pte.ind_estr_paqu, ");
               strBuf.append(" pe.num_maxi_grup, pe.num_maxi_grup_cndt, pe.num_maxi_grup_cndo, ");
               strBuf.append(" pe.ind_list_rank, pe.ind_cuad_grup, pe.tipr_oid_tipo_prod, ");
               strBuf.append(" pe.ind_cv_impr, pe.ind_modi_impr, pe.ind_cv_desp_auto, ");
               strBuf.append(" pe.ind_modi_desp, pe.ind_cv_digi, pe.ind_modi_digi, ");
               strBuf.append(" pe.num_orde_asig_cuv ");
          strBuf.append(" FROM pre_estra pe, pre_tipo_estra pte ");
         strBuf.append(" WHERE oid_estr = "+dto.getOid()+" ");
         strBuf.append(" AND pte.oid_tipo_estr = pe.ties_oid_tipo_estr ");
 
        DTODatosEstrategia dtEst = null;

        try {
            RecordSet rs = BelcorpService.getInstance().dbService.executeStaticQuery(strBuf.toString());

            if (rs.esVacio()) {
                return null;
            }

            dtEst = new DTODatosEstrategia();

            dtEst.setOid(getLong(rs.getValueAt(0, 0)));
            dtEst.setCodigo((String) rs.getValueAt(0, 1));
            dtEst.setOidTipoEstrategia(getLong(rs.getValueAt(0, 2)));

            Object i1 = rs.getValueAt(0, 3);

            if (i1 != null) {
                dtEst.setIndGrupos(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 4);

            if (i1 != null) {
                dtEst.setIndCondicionada(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 5);

            if (i1 != null) {
                dtEst.setIndVS(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 6);

            if (i1 != null) {
                dtEst.setIndPaquetes(getBoole(getLong(i1)));
            }

            Object o1 = rs.getValueAt(0, 7);

            if (o1 != null) {
                dtEst.setMaxGrupos(new Integer(getLong(o1).intValue()));
            }

            Object o2 = rs.getValueAt(0, 8);

            if (o2 != null) {
                dtEst.setMaxGruposCondicionantes(new Integer(getLong(o2).intValue()));
            }

            Object o3 = rs.getValueAt(0, 9);

            if (o3 != null) {
                dtEst.setMaxGruposCondicionados(new Integer(getLong(o3).intValue()));
            }

            i1 = rs.getValueAt(0, 10);

            if (i1 != null) {
                dtEst.setListaRanking(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 11);

            if (i1 != null) {
                dtEst.setCuadreGrupos(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 12);

            if (i1 != null) {
                dtEst.setOidTipoProducto(getLong(i1));
            }

            i1 = rs.getValueAt(0, 13);

            if (i1 != null) {
                dtEst.setCvImprimible(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 14);

            if (i1 != null) {
                dtEst.setModificableImprimible(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 15);

            if (i1 != null) {
                dtEst.setCvDespachoAutomatico(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 16);

            if (i1 != null) {
                dtEst.setModificableDespachoAutomatico(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 17);

            if (i1 != null) {
                dtEst.setCvDigitable(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 18);

            if (i1 != null) {
                dtEst.setModificableDigitable(getBoole(getLong(i1)));
            }

            i1 = rs.getValueAt(0, 19);

            if (i1 != null) {
                dtEst.setOrdenAsignacionCUV(new Integer(getLong(i1).intValue()));
            }            

            //        - Llama a EntidadI18N.findByEntAtrIdioPK pasandole como parámetros ENT_ESTRATEGIA,1,dtoin.getOidIdioma y DTODatosEstrategia.oid 
            //          Se crea un DTOI18nSICC y con el entity obtenido se le asignan el detalle al atributo valI18n del DTOI18nSICC, y el entidad_pk al atributo oidAtributo del mismo DTO. 
            //          Este DTOI18nSICC se añade al vector attriTraducible del DTODatosEstrategia
            Entidadi18nLocalHome i18nlh = new Entidadi18nLocalHome();
            Entidadi18nLocal i18nl = i18nlh.findByEntAtrIdioPK("PRE_ESTRA", new Long(1), dto.getOidIdioma(), dtEst.getOid());
            DTOI18nSICC dtoi18n = new DTOI18nSICC();
            dtoi18n.setOidIdioma(i18nl.getIdioma());
            dtoi18n.setValorI18n(i18nl.getDetalle());
            dtoi18n.setOidAtriuto(i18nl.getEntidad_pk());

            Vector attrVec = new Vector();
            attrVec.add(dtoi18n);

            dtEst.setAttriTraducible(attrVec);
        } catch (MareException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }        
        //UtilidadesLog.debug("Datos salida: estrategia:"+dtEst);
        
        UtilidadesLog.info("MONConfiguracionMFBean.obtenerDetalleEstrategia(DTOOID dto): Salida");
        return dtEst;
    }

    private Long getLongFromBigDecimal(BigDecimal object) {
        UtilidadesLog.info("MONConfiguracionMFBean.getLongFromBigDecimal(BigDecimal object): Entrada");
        UtilidadesLog.info("MONConfiguracionMFBean.getLongFromBigDecimal(BigDecimal object): Salida");
        return new Long(object.longValue());
    }

    private Long getLong(Object obj) {
        UtilidadesLog.info("MONConfiguracionMFBean.getLong(Object obj): Entrada");
        UtilidadesLog.info("MONConfiguracionMFBean.getLong(Object obj): Salida");
        return getLongFromBigDecimal((BigDecimal) obj);
    }

    private Boolean getBoole(Long num) {
        UtilidadesLog.info("MONConfiguracionMFBean.getBoole(Long num): Entrada");
        UtilidadesLog.info("MONConfiguracionMFBean.getBoole(Long num): Salida");
        return (num.intValue() == 1) ? Boolean.TRUE : Boolean.FALSE;
    }

    public DTOOID obtenerArgumentoVentaEstrategia(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.obtenerArgumentoVentaEstrategia(DTOOID dtoe): Entrada");
        /*
            // Accede a entidad 'argumentos de venta' con el tipo de estrategia correspondiente
            a la estrategia de entrada. Si hay varias entradas,
            se toma la de código mas bajo. Si no se encuentra ninguna, se devuelve Null.

            estrategia = Llama al método Estrategia.findByPrimaryKey(DTOE.oid)
            tipoEstrategia = Llama al método TipoEstrategia.findByPrimaryKey(estrategia.oidTipoEstrategia)
            argumentoVenta = Llama al método ArgumentoVenta.findByTipoEstrategia(tipoEstrategia.oid)
            Si argumentoVenta != null
            {
            Crea un DTOOID con:
            - oid: argumentoVenta..oid
            }
            sino
            {
            Devuelve null
            }
         */
        try {            
            EstrategiaLocalHome elh =  new EstrategiaLocalHome();
            TipoEstrategiaLocalHome telh = new TipoEstrategiaLocalHome();
            ArgumentoVentaLocalHome avlh = new ArgumentoVentaLocalHome();
            
            EstrategiaLocal estrategiaL = elh.findByPrimaryKey(dtoe.getOid());
            //UtilidadesLog.debug("Obtuvo la estrategia " + dtoe.getOid());
            TipoEstrategiaLocal tipoEstratL = telh.findByPrimaryKey(estrategiaL.getOidTipoEstr());
            //UtilidadesLog.debug("Obtuvo el tipo de Estrategia");
            Collection argVentaL = avlh.findByTipoEstrategia(tipoEstratL.getOid());
            //UtilidadesLog.debug("Obtuvo los Argumentos de Venta");
            Iterator it = argVentaL.iterator();
            Integer menorCodigoArgumento = new Integer(9999999);
            Long menorArguemnto = null;

            while (it.hasNext()) {
                //Busco la de menor codigo
                ArgumentoVentaLocal argVL = (ArgumentoVentaLocal) it.next();

                if (argVL.getCodigoArgumento().intValue() < menorCodigoArgumento.intValue()) {
                    menorCodigoArgumento = argVL.getCodigoArgumento();
                    menorArguemnto = argVL.getOid();
                }
            }

            if (menorArguemnto != null) {
                DTOOID dtooid = new DTOOID();
                dtooid.setOid(menorArguemnto);
                UtilidadesLog.info("MONConfiguracionMFBean.obtenerArgumentoVentaEstrategia(DTOOID dtoe): Salida");
                return dtooid;
            } else {
                UtilidadesLog.info("MONConfiguracionMFBean.obtenerArgumentoVentaEstrategia(DTOOID dtoe): Salida");
                return null;
            }
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }

    public DTOOID obtenerMarcaMF(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.obtenerMarcaMF(DTOOID dtoe): Entrada");
        /*
            Obtiene la marca asociada a la cabecera de matriz de facturación recibida
            cabeceraMF = Llamar al método CabeceraMF.findByPrimaryKey(DTOE.oid)
            periodo = Llamar al método Periodo.findByPrimaryKey(cabeceraMF.oidPeriodo)
            Crear un DTOOID con:
            - oid = periodo.oidMarca
            Devuelve DTOOID
         */
        try {
            CabeceraMFLocalHome cmflh = new CabeceraMFLocalHome();
            CabeceraMFLocal cmfL = cmflh.findByPrimaryKey(dtoe.getOid());
            PeriodoLocal periodoL = this.getPeriodoLocalHome().findByPrimaryKey(cmfL.getOidPeri());
            DTOOID dtooid = new DTOOID();
            dtooid.setOid(periodoL.getOidMarca());
            dtooid.setOidPais(dtoe.getOidPais());
            dtooid.setOidIdioma(dtoe.getOidIdioma());
            
            UtilidadesLog.info("MONConfiguracionMFBean.obtenerMarcaMF(DTOOID dtoe): Salida");
            return dtooid;
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
    }

    private void eliminarDescripcion(Long oid) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.eliminarDescripcion(Long oid): Entrada");
        try {
            Entidadi18nLocalHome i18nlh = new Entidadi18nLocalHome();
            Collection i18ncol = i18nlh.findByEntAtrPK("PRE_ESTRA", new Long(1), oid);
            Iterator iter = i18ncol.iterator();

            while (iter.hasNext()) {
                Entidadi18nLocal l = (Entidadi18nLocal) iter.next();
                i18nlh.remove(l);
            }
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.eliminarDescripcion(Long oid): Salida");
    }

    private void actualizarDescripcion(Vector attriTraducible, Long oid) throws MareException, RemoteException {
        UtilidadesLog.info("MONConfiguracionMFBean.actualizarDescripcion(Vector attriTraducible, Long oid): Entrada");
        try {
            MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
            i18n.actualizaTraducciones("PRE_ESTRA", oid, attriTraducible);
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONConfiguracionMFBean.actualizarDescripcion(Vector attriTraducible, Long oid): Salida");
    }

    public DTOSalida buscarEstrategias(DTODatosEstrategia dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionMFBean.buscarEstrategias(DTODatosEstrategia dto): Entrada");
        
        String query = "	select      " + "		   pe.OID_ESTR OID,        " + "		   pte.DES_TIPO_ESTR,   " + "		   pe.COD_ESTR,         " + "		   i.VAL_I18N           " + "	from                        " + "		   PRE_ESTRA pe,        " + "		   V_GEN_I18N_SICC i,   " + "		   PRE_TIPO_ESTRA pte   " + "	WHERE  1=1                     " + "		   AND pe.PAIS_OID_PAIS =  " + dto.getOidPais() + ((dto.getCodigo() != null) ? ("		   AND UPPER(pe.COD_ESTR) like '" + dto.getCodigo().trim().toUpperCase() + "%'") : "") + "		   AND i.VAL_OID = pe.OID_ESTR      " + "		   AND i.ATTR_ENTI = 'PRE_ESTRA'    " + "		   AND i.ATTR_NUM_ATRI = 1          " + "		   AND i.IDIO_OID_IDIO = " + dto.getOidIdioma() + ((dto.getDescripcion() != null) ? (" AND i.VAL_I18N  like '" + dto.getDescripcion().trim() + "'") : "") + "		   AND pte.OID_TIPO_ESTR  = pe.TIES_OID_TIPO_ESTR 	";


        String sqlPag = UtilidadesPaginacion.armarQueryPaginacion(query, dto);
        RecordSet rs = null;

        try {
            rs = BelcorpService.getInstance().dbService.executeStaticQuery(sqlPag);

            if (rs.esVacio()) {
                throw new MareException(new NoResultException(), UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        } catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            }

            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        DTOSalida dtos = new DTOSalida();
        dtos.setResultado(rs);

        UtilidadesLog.info("MONConfiguracionMFBean.buscarEstrategias(DTODatosEstrategia dto): Salida");
        return dtos;
    }

    private String getDescByIdioma(Vector attrTrad, Long idioma) {
        UtilidadesLog.info("MONConfiguracionMFBean.getDescByIdioma(Vector attrTrad, Long idioma): Entrada");
        if (attrTrad == null) {
            UtilidadesLog.info("MONConfiguracionMFBean.getDescByIdioma(Vector attrTrad, Long idioma): Salida");
            return "";
        }

        Iterator iter = attrTrad.iterator();

        while (iter.hasNext()) {
            DTOI18nSICC i18n = (DTOI18nSICC) iter.next();

            if (i18n.getOidIdioma().equals(idioma)) {
                UtilidadesLog.info("MONConfiguracionMFBean.getDescByIdioma(Vector attrTrad, Long idioma): Salida");
                return i18n.getValorI18n();
            }
        }
        UtilidadesLog.info("MONConfiguracionMFBean.getDescByIdioma(Vector attrTrad, Long idioma): Salida");
        return "";
    }

    private PeriodoLocalHome getPeriodoLocalHome() {
       return new PeriodoLocalHome();
    }

    private MONValidacionHome getMONValidacionHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONValidacionHome) PortableRemoteObject.narrow(context.lookup("java:comp/env/MONValidacion"), MONValidacionHome.class);
    }

}
