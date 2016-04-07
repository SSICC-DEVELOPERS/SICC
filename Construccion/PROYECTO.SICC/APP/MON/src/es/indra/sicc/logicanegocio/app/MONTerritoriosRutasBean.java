/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.app;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.validacion.MONValidacion;
import es.indra.sicc.cmn.negocio.validacion.MONValidacionHome;
import es.indra.sicc.dtos.app.DTOTerritorio;
import es.indra.sicc.dtos.app.DTOTerritorioRuta;
import es.indra.sicc.entidades.app.RutasTerritoriosLocal;
import es.indra.sicc.entidades.app.RutasTerritoriosLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.rmi.RemoteException;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONTerritoriosRutasBean implements SessionBean {
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

    public DTOSalida obtenerRutas(DTOBelcorp DTOE) throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.obtenerRutas(DTOBelcorp DTOE): Entrada ");
        DTOSalida DTOS = new DTOSalida();
		String usuario=ctx.getCallerPrincipal().getName();
        DAOAPP dao = new DAOAPP(usuario);

        DTOS.setResultado(dao.obtenerRutas(DTOE));

        UtilidadesLog.info("MONTerritoriosRutasBean.obtenerRutas(DTOBelcorp DTOE): Salida ");
        return DTOS;
    }

    public DTOSalida obtenerTerritoriosAsociados(DTOOID DTOE)
            throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.obtenerTerritoriosAsociados(DTOOID DTOE): Entrada ");
        DTOSalida DTOS = new DTOSalida();
		String usuario=ctx.getCallerPrincipal().getName();
        DAOAPP dao = new DAOAPP(usuario);

        DTOS.setResultado(dao.obtenerTerritoriosAsociados(DTOE));

        UtilidadesLog.info("MONTerritoriosRutasBean.obtenerTerritoriosAsociados(DTOOID DTOE): Salida ");
        return DTOS;
    }

    public DTOSalida buscarTerritoriosNoAsociados(DTOTerritorio DTOE)
        throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.buscarTerritoriosNoAsociados(DTOTerritorio DTOE): Entrada ");        
        DTOSalida DTOS = new DTOSalida();
		String usuario=ctx.getCallerPrincipal().getName();
        DAOAPP dao = new DAOAPP(usuario);

        RecordSet rs = new RecordSet();

        rs = (dao.buscarTerritoriosNoAsociados(DTOE));

        int contador = 0;

        if (rs != null) {
            while (contador < rs.getRecords().size()) {
                contador++;
            }
        }

        if (contador > 100) {
			throw new MareException(new Exception(), 
			UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APP, ErroresDeNegocio.NUMERO_TERRITORIOS_OBTENIDOS_MAYOR_QUE_100));
        } else {
            DTOS.setResultado(rs);
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.buscarTerritoriosNoAsociados(DTOTerritorio DTOE): Salida ");   
        return DTOS;
    }

    public DTOSalida consultarTerritoriosAsociados(DTOTerritorio DTOE)
        throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.consultarTerritoriosAsociados(DTOTerritorio DTOE): Entrada ");
        DTOSalida DTOS = new DTOSalida();
		String usuario=ctx.getCallerPrincipal().getName();
        DAOAPP dao = new DAOAPP(usuario);

        DTOS.setResultado(dao.consultarTerritoriosAsociados(DTOE));

        UtilidadesLog.info("MONTerritoriosRutasBean.consultarTerritoriosAsociados(DTOTerritorio DTOE): Salida ");
        return DTOS;
    }

    public void guardarTerritoriosAsociados(DTOSalida DTOE) throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.guardarTerritoriosAsociados(DTOSalida DTOE): Entrada");
        RecordSet rs = null;

        //Recorre cada registro del recordset DTOE.resultado. Si el valor del 
        //campo "oid" no es nulo, entonces hay que realizar una modificación puesto 
        //que el registro ya existe en la entidad APP:RutasTerritorios y si el "oid" 
        //es nulo, quiere decir que el registro es nuevo y se inserta un registro 
        //en la misma entidad 
        rs = DTOE.getResultado();

        if (rs != null) {
            for (int i = 0; i < rs.getRecords().size(); i++) {
                DTOTerritorioRuta dtoTerritorioRuta = new DTOTerritorioRuta();

                if (rs.getValueAt(i, 0) != null) {
                    dtoTerritorioRuta.setOidRuta(new Long(
                            rs.getValueAt(i, 0).toString()));
                }

                if (rs.getValueAt(i, 1) != null) {
                    dtoTerritorioRuta.setOid(new Long(
                            rs.getValueAt(i, 1).toString()));
                }
				if (rs.getValueAt(i, 2) != null) {
                    dtoTerritorioRuta.setNumeroSecuencia(new Long(
                            rs.getValueAt(i, 2).toString()));
                }
                if (rs.getValueAt(i, 3) != null) {
                    dtoTerritorioRuta.setOidTerritorio(new Long(
                            rs.getValueAt(i, 3).toString()));
                }


                if (dtoTerritorioRuta.getOid() != null){ //es un registro ya existente-->modificar

                    //llamar al metodo modificarTerritorioRuta(dtoTerritorioRuta)
                    try {
                        this.modificarTerritorioRuta(dtoTerritorioRuta);
                    } catch (MareException me) {
                        throw me;
                    }
                } else { //es un registro nuevo y hay que insertarlo
                         //Llamar al método insertarTerritorioRuta(dtoTerritorioRuta)

                    try {
                        this.insertarTerritorioRuta(dtoTerritorioRuta);
                    } catch (MareException me) {
                        throw me;
                    }
                }
            }
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.guardarTerritoriosAsociados(DTOSalida DTOE): Salida ");
    }

    public void insertarTerritorioRuta(DTOTerritorioRuta DTOE)
        throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.insertarTerritorioRuta(DTOTerritorioRuta DTOE): Entrada");

        RutasTerritoriosLocalHome rutasTerritoriosHome = null;
        rutasTerritoriosHome = this.getRutasTerritoriosLocalHome();

        try {
            rutasTerritoriosHome.create(DTOE.getNumeroSecuencia(), DTOE.getOidRuta(), DTOE.getOidTerritorio());
        } catch (PersistenceException ce) {
            UtilidadesLog.error("insertarTerritorioRuta: CreateException", ce);
            throw new MareException(ce,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_INTEGRIDAD_INSERCION));
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.insertarTerritorioRuta(DTOTerritorioRuta DTOE): Salida ");
    }

    public void modificarTerritorioRuta(DTOTerritorioRuta DTOE)
        throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.modificarTerritorioRuta(DTOTerritorioRuta DTOE): Entrada ");

        RutasTerritoriosLocalHome rutasTerritoriosHome = null;
        RutasTerritoriosLocal rutasTerritoriosLocal = null;
        rutasTerritoriosHome = this.getRutasTerritoriosLocalHome();

        try {
            rutasTerritoriosLocal = rutasTerritoriosHome.findByPrimaryKey(DTOE.getOid());
        } catch (NoResultException fe) {
            UtilidadesLog.error("modificarTerritorioRuta: FinderException", fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        rutasTerritoriosLocal.setNumeroSecuencia(DTOE.getNumeroSecuencia());
        rutasTerritoriosHome.merge(rutasTerritoriosLocal);
        UtilidadesLog.info("MONTerritoriosRutasBean.modificarTerritorioRuta(DTOTerritorioRuta DTOE): Salida ");

    }

    private void validaAcceso(Long pais, Long empresa, Long marca, Long canal,
        Long acceso, Long subgerencia, Long region, Long zona, Long seccion,
        Long territorio) throws RemoteException, MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.validaAcceso(Long pais, Long empresa, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");

        MONValidacion monValidacion = this.getMONValidacion();
        Boolean b = new Boolean(true);

        //Valida que el usuario tenga acceso al Pais, Marca y Canal que se pasan
        //como parametro.		
        UtilidadesLog.debug("****Llamada a validaAcceso(pais= " + pais +
            ", marca=" + marca + ", canal= " + canal + ", acceso=" + acceso +
            ", subgerencia=" + subgerencia + ", region=" + region + ", zona=" +
            zona + ", seccion=" + seccion + ", territorio=" + territorio);
        b = monValidacion.validarAccesos(pais, empresa, marca, canal, acceso,
                null, subgerencia, region, zona, seccion, territorio);
        UtilidadesLog.debug("****Retorno validaAcceso : " + b.toString());

        if (!b.booleanValue()) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(
                "****Metodo validaAcceso: validaAcceso : ERROR_ASOCIACION_ESTRUCTURAL");
            throw new MareException(new Exception(),
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_ASOCIACION_ESTRUCTURAL));
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.validaAcceso(Long pais, Long empresa, Long marca, Long canal, Long acceso, Long subgerencia, Long region, Long zona, Long seccion, Long territorio): Entrada");
    }

    private MONValidacion getMONValidacion() throws MareException {
        // Se obtiene el interfaz home
        UtilidadesLog.info("MONTerritoriosRutasBean.getMONValidacion: Entrada");

        MONValidacionHome home = (MONValidacionHome) UtilidadesEJB.getHome("MONValidacion",
                MONValidacionHome.class);

        // Se obtiene el interfaz remoto
        MONValidacion ejb = null;

        try {
            ejb = home.create();
        } catch (Exception e) {
            UtilidadesLog.error("*** Error en getMONValidacion", e);

            String codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
            throw new MareException(e,
                UtilidadesError.armarCodigoError(codigoError));
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.getMONValidacion: Salida");

        return ejb;
    }

    private RutasTerritoriosLocalHome getRutasTerritoriosLocalHome() throws MareException {
        return new RutasTerritoriosLocalHome();
    }

    public void eliminarTerritoriosAsociados(DTOOIDs DTOE)
        throws MareException {
        UtilidadesLog.info("MONTerritoriosRutasBean.eliminarTerritoriosAsociados(DTOOIDs DTOE): Entrada");

        Long[] oids = DTOE.getOids();
        RutasTerritoriosLocalHome rutasTerritoriosHome = null;
        RutasTerritoriosLocal rutasTerritoriosLocal = null;
        rutasTerritoriosHome = this.getRutasTerritoriosLocalHome();

        for (int i = 0; i < oids.length; i++) {
            try {
                rutasTerritoriosLocal = rutasTerritoriosHome.findByPrimaryKey(oids[i]);
            } catch (NoResultException fe) {
                UtilidadesLog.error("eliminarTerritoriosAsociados: FinderException",
                    fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }

            try {
                rutasTerritoriosHome.remove(rutasTerritoriosLocal);
            } catch (PersistenceException re) {
                UtilidadesLog.error("eliminarTerritoriosAsociados: RemoveException",
                    re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }

        UtilidadesLog.info("MONTerritoriosRutasBean.eliminarTerritoriosAsociados(DTOOIDs DTOE): Salida ");
    }
}
