package es.indra.sicc.logicanegocio.ped;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.ejbservice.EJBLocator;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudProceso;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocal;
import es.indra.sicc.entidades.ped.TiposSolicitudProcesoLocalHome;
import es.indra.sicc.logicanegocio.mae.MONProductos;
import es.indra.sicc.logicanegocio.mae.MONProductosBean;
import es.indra.sicc.logicanegocio.mae.MONProductosHome;
import es.indra.sicc.logicanegocio.ped.ErroresNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudOperacion;

import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;
import es.indra.sicc.dtos.ped.DTOTipoPosicionOperacion;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONTiposSolicitudProcesoBean implements SessionBean {
    private Long oid;
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

    public void guarda(DTOTipoSolicitudProceso dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.guarda(DTOTipoSolicitudProceso dto): Entrada ");
        try {
            UtilidadesLog.debug("ENTRO A GUARDA CON OID = " + dto.getOid());
            if (dto.getOid() != null) {
                UtilidadesLog.debug("Entro a modificar");
                TiposSolicitudProcesoLocalHome solicProc = new TiposSolicitudProcesoLocalHome();
                TiposSolicitudProcesoLocal solLocal = solicProc.findByPrimaryKey(dto.getOid());
                //solLocal.setOidTipoSolicitud(dto.getTipoSolicitud());
                solLocal.setOidTipoPosicion(dto.getTipoPosicion());
                UtilidadesLog.debug("4   " + dto.getTipoPosicion());
                solLocal.setIndProducto(dto.getIndProducto());
                UtilidadesLog.debug("5   " + dto.getIndProducto());
                //solLocal.setOidOperacion(dto.getOperacion());
                solLocal.setOidSubTipoPosicion(dto.getSubtipoPosicion());
                UtilidadesLog.debug("6   " + dto.getSubtipoPosicion());
                if ((dto.getProducto() != null) &&
                        !dto.getProducto().equals("")) {
                    UtilidadesLog.debug("entro a MAE 1");
                    MONProductosHome produHome = MAEEjbLocators.getMONProductosHome();
                    oid = produHome.create().obtenerOidProducto(dto.getOidPais(),
                            dto.getProducto());

                    //si el producto no existe se corta el proceso de guardar
                    if (oid == null) {
                        UtilidadesLog.debug("Entro a oidMAE = null"); 
                        ctx.setRollbackOnly();
                        throw new MareException(null, null,
                            UtilidadesError.armarCodigoError(
                                ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_018));
                    }
                    UtilidadesLog.debug("20");
                    solLocal.setOidProducto(oid);
                } else {
                    UtilidadesLog.debug("entro a 21");
                    solLocal.setOidProducto(null);
                }

                Entidadi18nLocalHome entidadI18NLocalHome = new Entidadi18nLocalHome();
                UtilidadesLog.debug("22");
                Entidadi18nLocal entidadI18N;
                UtilidadesLog.debug("23");
                UtilidadesLog.debug("24");
                Vector vecDescripciones = dto.getAttriTraducible();
                UtilidadesLog.debug("25");
                Iterator it = vecDescripciones.iterator();
                UtilidadesLog.debug("26");
                DTOI18nSICC dtoI18N = null;
                UtilidadesLog.debug("27");
                int count = 0;
                while (it.hasNext()) {
                    count ++;
                    UtilidadesLog.debug("28   " + count); 
                    dtoI18N = (DTOI18nSICC) it.next();
                    UtilidadesLog.debug("29   " + count); 
                    try{
                        entidadI18N = entidadI18NLocalHome.findByEntAtrIdioPK("PED_TIPO_SOLIC_PROCE",
                        dtoI18N.getOidAtriuto(), dtoI18N.getOidIdioma(),
                        dto.getOid());
                        if( dtoI18N.getValorI18n().equals(" ") ){
                            try {
                                entidadI18NLocalHome.remove(entidadI18N);
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                            }
                            
                        }else{
                            entidadI18N.setDetalle(dtoI18N.getValorI18n());
                            try {
                                entidadI18NLocalHome.merge(entidadI18N);
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }
                    }catch(NoResultException nre){
                        if( !dtoI18N.getValorI18n().equals(" ") ){
                            try {
                                entidadI18NLocalHome.create("PED_TIPO_SOLIC_PROCE", dtoI18N.getOidAtriuto(), dtoI18N.getOidIdioma(),
                                                                                    dtoI18N.getValorI18n(), dto.getOid());
                            } catch (PersistenceException pe) {
                                ctx.setRollbackOnly();
                                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                            }
                        }
                    } catch (PersistenceException pe) {
                        ctx.setRollbackOnly();
                        throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                    }
                } 
                UtilidadesLog.debug("31"); 
                solLocal.setOidProducto(oid);
				UtilidadesLog.debug("32"); 
                                
                try {
                    solicProc.merge(solLocal);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
            } else {
                Entidadi18nLocalHome entidadi18LH = new Entidadi18nLocalHome();
                TiposSolicitudProcesoLocalHome solicProcH = new TiposSolicitudProcesoLocalHome();

                // se le pasa por parámetros los valores de por ser UK:
                //  TSPA_OID_TIPO_SOLI_PAIS 
                //  IND_PROD
                //  OPER_OID_OPER
                TiposSolicitudProcesoLocal tipoLocal = null;
                try {
                    tipoLocal = solicProcH.create(dto.getTipoSolicitud(),dto.getIndProducto(),dto.getOperacion());
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }


                //seteo de campos que no son parte de la UK   
                tipoLocal.setOidSubTipoPosicion(dto.getSubtipoPosicion()); 
                
                //agregar cuando pablo haga el entidades jar  
                tipoLocal.setOidTipoPosicion(dto.getTipoPosicion()); 

                if ((dto.getProducto() != null) &&
                        !dto.getProducto().equals("")) {
                    MONProductosHome produHome = MAEEjbLocators.getMONProductosHome();
                    oid = produHome.create().obtenerOidProducto(dto.getOidPais(),
                            dto.getProducto());

                    //si el producto no existe se corta el proceso de guardar
                    if (oid == null) {
                        ctx.setRollbackOnly();
                        throw new MareException(null, null,
                            UtilidadesError.armarCodigoError(
                                ConstantesSEG.MODULO_PED, "", ErroresNegocio.PED_018));
                    } else {
                        tipoLocal.setOidProducto(oid);
                    }
                } else {
                    tipoLocal.setOidProducto(null);
                }
                
                try {
                    solicProcH.merge(tipoLocal);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                Vector vec = dto.getAttriTraducible();
                Iterator it = vec.iterator();
                DTOI18nSICC dtoI18 = null;

                while (it.hasNext()) {
                    dtoI18 = (DTOI18nSICC) it.next();
                    if( !dtoI18.getValorI18n().equals(" ") ){
                        try {
                            entidadi18LH.create("PED_TIPO_SOLIC_PROCE", dtoI18.getOidAtriuto(), 
                                            dtoI18.getOidIdioma(), dtoI18.getValorI18n(), tipoLocal.getOid());
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }
                    }
                }
            }

        } catch (NoResultException ex) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException ex) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Exception: ",ex);
            throw new MareException(ex,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception e) {
            ctx.setRollbackOnly();
            if (e instanceof MareException) {
                throw (MareException) e;
            } else {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.guarda(DTOTipoSolicitudProceso dto): Salida ");
    }


    private MONProductosHome getMONProductosHome() throws NamingException {
        final InitialContext context = new InitialContext();

        return (MONProductosHome) PortableRemoteObject.narrow(context.lookup(
                "java:comp/env/MONProductos"), MONProductosHome.class);
    }


    // Obtiene los tipos de solicitud proceso. 
    public DTOSalida consulta(DTOTipoSolicitudProceso dto)
        throws MareException {
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.consulta(DTOTipoSolicitudProceso dto): Entrada ");
        // 1.- Devuelve el resultado de DAOPED.obtieneTiposSolicitudProceso(dto).
        UtilidadesLog.debug("### Entro en consulta ###");

        DTOSalida dtoSalida = new DTOSalida();
        String user = ctx.getCallerPrincipal().getName();
        DAOPED dao = new DAOPED(user);
        dtoSalida = dao.obtieneTiposSolicitudProceso(dto);
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.consulta(DTOTipoSolicitudProceso dto): Salida ");
        return dtoSalida;
    }

    public DTOTipoSolicitudProceso consultaDetalles(DTOOID dto)
        throws MareException {
        
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.consultaDetalles(DTOOID dto): Entrada ");
        DTOTipoSolicitudProceso dtos = new DTOTipoSolicitudProceso();

        try {

            TiposSolicitudProcesoLocalHome solicProcH = new TiposSolicitudProcesoLocalHome();
            TiposSolicitudProcesoLocal tipoSolProce = solicProcH.findByPrimaryKey(dto.getOid());
            dtos.setSubtipoPosicion(tipoSolProce.getOidSubTipoPosicion());
            dtos.setTipoPosicion(tipoSolProce.getOidTipoPosicion());
            dtos.setOperacion(tipoSolProce.getOidOperacion());
            dtos.setTipoSolicitud(tipoSolProce.getOidTipoSolicitud());
            dtos.setIndProducto(tipoSolProce.getIndProducto());
            dtos.setOidPais(dto.getOidPais());
            dtos.setOidIdioma(dto.getOidIdioma());
            dtos.setOid(dto.getOid());
            UtilidadesLog.debug("dto......>  " + dtos);

            if (tipoSolProce.getOidProducto() != null) {
                UtilidadesLog.debug("entro a MAEE");

                MaestroProductosPK maePK = new MaestroProductosPK(tipoSolProce.getOidProducto());
                MaestroProductosLocalHome produHome = MAEEjbLocators.getMaestroProductosLocalHome();
                MaestroProductosLocal produLocal = produHome.findByPrimaryKey(maePK);
                dtos.setProducto(produLocal.getCodigoSAP());
            }

            Entidadi18nLocalHome i18NLH = new Entidadi18nLocalHome();
            Collection desc = i18NLH.findByEntAtrPK("PED_TIPO_SOLIC_PROCE",
                    new Long(1), dto.getOid());
            Iterator it = desc.iterator();
            Vector descripciones = new Vector();
            Entidadi18nLocal entidadI18N;
            DTOI18nSICC dtoI18n = null;

            while (it.hasNext()) {
                entidadI18N = (Entidadi18nLocal) it.next();
                dtoI18n = new DTOI18nSICC();
                dtoI18n.setOidAtriuto(entidadI18N.getAtributo());
                dtoI18n.setOidIdioma(entidadI18N.getIdioma());
                dtoI18n.setValorI18n(entidadI18N.getDetalle());
                descripciones.add(dtoI18n);
            }

            dtos.setAttriTraducible(descripciones);
            UtilidadesLog.debug("salio de consultar detalle");
            UtilidadesLog.debug("dto......>  " + dtos);
        } catch (NoResultException nre) {
            UtilidadesLog.error("Exception: ",nre);
            throw new MareException(nre,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            UtilidadesLog.error("Exception: ",pe);
            throw new MareException(pe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (FinderException ez) {
            UtilidadesLog.error("Exception: ",ez);
            throw new MareException(ez,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (Exception e) {
            if (e instanceof MareException) {
                throw (MareException) e;
            } else {
                throw new MareException(e,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }
        }
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.consultaDetalles(DTOOID dto): Salida ");
        return dtos;
    }

    private MaestroProductosLocalHome getMaestroProductosLocalHome()
        throws NamingException {
        final InitialContext context = new InitialContext();

        return (MaestroProductosLocalHome) context.lookup(
            "java:comp/env/MaestroProductos");
    }

    public void elimina(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.elimina(DTOOIDs dto): Entrada ");
        Long[] dtos = dto.getOids();
        DTOOID dtoOid;

        if (dtos != null) {
            int len = dtos.length;

            try {
                for (int i = 0; i < len; i++) {
                    if (dtos[i] != null) {
                        Long oid;
                        oid = dtos[i];

                        TiposSolicitudProcesoLocalHome regLH = new TiposSolicitudProcesoLocalHome();
                        TiposSolicitudProcesoLocal reg = regLH.findByPrimaryKey(oid);
                        try {
                            regLH.remove(reg);
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                        }
                        

                        Entidadi18nLocalHome ei18LH = new Entidadi18nLocalHome();
                        Collection tradu = ei18LH.findByEntAtrPK("PED_TIPO_SOLIC_PROCE",
                                new Long(1), oid);
                        Iterator it = tradu.iterator();

                        try {
                            while (it.hasNext()) {
                                Entidadi18nLocal i18L = (Entidadi18nLocal) it.next();
                                ei18LH.remove(i18L);
                            }
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                        }
                    }
                }
            } catch (NoResultException nre) {
                UtilidadesLog.error("Exception: ",nre);
                throw new MareException(nre,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException ex) {
                UtilidadesLog.error("Exception: ",ex);
                throw new MareException(ex,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            } catch (Exception e) {
                if (e instanceof MareException) {
                    throw (MareException) e;
                } else {
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                }
            }
        }
        UtilidadesLog.info("MONTiposSolicitudProcesoBean.elimina(DTOOIDs dto): Salida ");
    }

  // Autor: ssantana
  // Inc. BELC300010413
  public DTOSalida obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto) throws MareException  {
    
  /*  Proceso:
      -> Llamar la método "DAOPED.obtieneTipoSolicitudProceso(dto : DTOTipoSolicitudOperacion) : DTOSalida"
      pasando el dto de entrada
      -> Devolver DTOSalida obtenido de la llamada anterior*/
      UtilidadesLog.info("MONTiposSolicitudProcesoBean.obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto): Entrada ");
      DTOSalida dtoSalida = null;

      DAOPED daoPed = new DAOPED(ctx.getCallerPrincipal().getName());
      //daoPed.obtieneTipoSolicitudOperacion(dto)
      dtoSalida = daoPed.obtieneTipoSolicitudProceso(dto);
      UtilidadesLog.info("MONTiposSolicitudProcesoBean.obtieneTipoSolicitudProceso(DTOTipoSolicitudOperacion dto): Salida ");
      return dtoSalida;
  }
}
