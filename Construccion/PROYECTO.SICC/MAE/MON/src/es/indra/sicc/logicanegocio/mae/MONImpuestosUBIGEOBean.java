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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.dtos.mae.DTOCargaInicialTerritorios;
import es.indra.sicc.dtos.mae.DTOCombosImpuestos;
import es.indra.sicc.dtos.mae.DTOConsultaImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOImpuestoUBIGEO;
import es.indra.sicc.dtos.mae.DTOModificarImpuesto;
import es.indra.sicc.dtos.seg.DTOCAS;
import es.indra.sicc.dtos.seg.DTOCargaCAS;
import es.indra.sicc.dtos.seg.DTOFiltroCAS;
import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.entidades.mae.ImpuestoUBIGEOLocal;
import es.indra.sicc.entidades.mae.ImpuestoUBIGEOLocalHome;
import es.indra.sicc.logicanegocio.ped.DAOParametrosPedidos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.zon.MONEstructuraGeoPoliticaHome;
import es.indra.sicc.logicanegocio.zon.MONUnidadesGeograficasHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.ZONEjbLocators;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

import javax.rmi.PortableRemoteObject;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
/**
 * Sistema:           Belcorp - SICC
 * Modulo:            MAE
 * Componente:        MONImpuestosUBIGEOBean
 * Fecha:             07/1/2004
 * Documentacion:
 * Observaciones:
 *
 * @version           1.0
 * @author            Viviana Bongiovanni
 */
public class MONImpuestosUBIGEOBean implements SessionBean {
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

    public void inserta(DTOImpuestoUBIGEO datos) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.inserta(DTOImpuestoUBIGEO): Entrada"); 
        DAOMAEProductos daoMAEProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        Long codSAP = null;
        UtilidadesLog.info("entro al metodo de guardar");
        UtilidadesLog.info("DTOImpuestoUBIGEO: " + datos);

        // Busca el código SAP
        if ((codSAP = daoMAEProductos.validarCodigoProducto(datos.getMaterial(), datos.getOidPais())) == null) {
            throw new MareException(new MareException(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", ErroresDeNegocio.CODIGO_SAP_INEXISTENTE));
        } else {
            UtilidadesLog.info("insercion");

            try {
                UtilidadesLog.info("Antes de MAEEjbLocators"  + datos.getTasaImpuesto());    
                ImpuestoUBIGEOLocalHome localHome = new ImpuestoUBIGEOLocalHome();
                UtilidadesLog.info("despues MAEEjbLocators"  + datos.getTasaImpuesto());    
                UtilidadesLog.info("Despues de Auditoria"  + datos.getTasaImpuesto());    

                UtilidadesLog.info("Antes de create SAP"  + codSAP );
                UtilidadesLog.info("Antes de create"  + datos );
                ImpuestoUBIGEOLocal local = localHome.create(codSAP, datos.getSubacceso(), datos.getTasaImpuesto());
                UtilidadesLog.info("tasaimpuesto"  + datos.getTasaImpuesto());    
                //local.setOidTasaImpuesto(datos.getTasaImpuesto());
                UtilidadesLog.info("MONImpuestosUBIGEO.inserta(DTOImpuestoUBIGEO): Salida"); 
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        }
    }

    public DTOCombosImpuestos rellenarCombos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.rellenarCombos(DTOBelcorp): Entrada"); 
        RecordSet record = null;
        MONMantenimientoSEGHome mmsHome = null;
        MONMantenimientoSEG mms = null;

        DTOCombosImpuestos dtoCombosImpuestos = new DTOCombosImpuestos();
        DTOCargaCAS dtoCarga = new DTOCargaCAS();
        DTOFiltroCAS dtoFiltro = new DTOFiltroCAS();
        dtoCarga.setOidIdioma(dto.getOidIdioma());

        // Obtiene Tasa de Impuestos por Pais
        DAOParametrosPedidos daoParametrosPedidos = new DAOParametrosPedidos();
        record = daoParametrosPedidos.obtenerTasasImpuestoPorPais(dto);

        try {
            mmsHome = SEGEjbLocators.getMONMantenimientoSEGHome();
            UtilidadesLog.debug("Paso 1");
            mms = mmsHome.create();
            UtilidadesLog.debug("Paso 2");
            dtoFiltro.setBcanales(new Boolean(true));
            UtilidadesLog.debug("Paso 3");
            dtoFiltro.setBaccesos(new Boolean(true));
            UtilidadesLog.debug("Paso 4");
            dtoFiltro.setBsubaccesos(new Boolean(true));
            UtilidadesLog.debug("Paso 5");

            dtoCarga.setFiltro(dtoFiltro);
            dtoCarga.setTodos(dtoFiltro);
            UtilidadesLog.debug("Paso 6 " + dtoFiltro.getBaccesos());
            UtilidadesLog.debug("Paso 6 " + dtoFiltro.getBcanales());
            UtilidadesLog.debug("Paso 6 " + dtoFiltro.getBsubaccesos());

            DTOCAS dtoCAS = mms.obtieneCanalAccesoSubacceso(dtoCarga);
            UtilidadesLog.debug("Paso 7");

            dtoCombosImpuestos.setTasasImpuestos(record);
            UtilidadesLog.debug("Paso 8 y tasas " + record);
            dtoCombosImpuestos.setCanales(dtoCAS.getCanales());
            UtilidadesLog.debug("Paso 9 y canales " + dtoCAS.getCanales());
            dtoCombosImpuestos.setAccesos(dtoCAS.getAccesos());
            UtilidadesLog.debug("Paso 10 y accesos " + dtoCAS.getAccesos());
            dtoCombosImpuestos.setSubaccesos(dtoCAS.getSubaccesos());
            UtilidadesLog.debug("Paso 11 y subaccesos " + dtoCAS.getSubaccesos());
        } catch (CreateException ce) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONImpuestosUBIGEO.rellenarCombos(DTOBelcorp): Salida"); 

        return dtoCombosImpuestos;
    }

    public DTOCargaInicialTerritorios cargaInicialTerritorios(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.cargaInicialTerritorios(DTOBelcorp): Entrada"); 
        DTOCargaInicialTerritorios dtoCargaIncTer = new DTOCargaInicialTerritorios();

        try {
            DTOPais dtoPais = new DTOPais();
            dtoPais.setOidPais(dto.getOidPais());
            dtoPais.setOidIdioma(dto.getOidIdioma());
            dtoPais.setPais(dto.getOidPais());

            // Estructura Geopolitica
            DTOEstructuraGeopoliticaPais estGeo = new DTOEstructuraGeopoliticaPais();
            estGeo = ZONEjbLocators.getMONEstructuraGeoPoliticaHome().create().obtenerEstructuraGeoPolitica(dtoPais);

            dtoCargaIncTer.setNiveles(estGeo.getDescripcionDivPol());

            // Nivel Geografico Padre
            DTOUG dtoUG = new DTOUG();
            dtoUG.setOidPais(dto.getOidPais());
            dtoUG.setFiltroActiva(Boolean.FALSE);

            DTOSalida dtoSalida = new DTOSalida();

            dtoSalida = ZONEjbLocators.getMONUnidadesGeograficasHome().create().obtenerUnidadesGeograficas(dtoUG);

            RecordSet record = dtoSalida.getResultado();

            // Eliminacion de las columnas innecesarias
            record.removeColumn(record.findColumn("COD_UNID_GEOG"));
            record.removeColumn(record.findColumn("IND_ACTI"));
            record.removeColumn(record.findColumn("COD_NSE1"));
            record.removeColumn(record.findColumn("COD_NSE2"));
            record.removeColumn(record.findColumn("COD_NSE3"));
            record.removeColumn(record.findColumn("COD_POST"));
            record.removeColumn(record.findColumn("UBIGEO"));

            dtoCargaIncTer.setNivelGeograficoPadre(record);
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONImpuestosUBIGEO.cargaInicialTerritorios(DTOBelcorp): Salida"); 

        return dtoCargaIncTer;
    }

    public DTOSalida obtenerTerritorio(DTOOID dto) throws MareException {
        return null;
    }

    public DTOSalida obtenerNivelGeografico(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.obtenerNivelGeografico(DTOOID): Entrada"); 
        DTOSalida dtoSalida = new DTOSalida();

        try {
            // Nivel Geografico 
            DTOUG dtoUG = new DTOUG();
            dtoUG.setOidPais(dto.getOidPais());
            dtoUG.setOidUG(dto.getOid());
            dtoUG.setFiltroActiva(Boolean.TRUE);

            dtoSalida = ZONEjbLocators.getMONUnidadesGeograficasHome().create().obtenerUnidadesGeograficas(dtoUG);

            RecordSet record = dtoSalida.getResultado();

            // Eliminacion de las columnas innecesarias
            record.removeColumn(record.findColumn("COD_UNID_GEOG"));
            record.removeColumn(record.findColumn("IND_ACTI"));
            record.removeColumn(record.findColumn("COD_NSE1"));
            record.removeColumn(record.findColumn("COD_NSE2"));
            record.removeColumn(record.findColumn("COD_NSE3"));
            record.removeColumn(record.findColumn("COD_POST"));
            record.removeColumn(record.findColumn("UBIGEO"));

            dtoSalida.setResultado(record);
        } catch (MareException me) {
            if (me.getCode() == Integer.parseInt(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE)) {
                dtoSalida.setResultado(new RecordSet());
            } else {
                throw me;
            }
        } catch (RemoteException re) {
            throw new MareException(re, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (CreateException ce) {
            throw new MareException(ce, UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        
        UtilidadesLog.info("MONImpuestosUBIGEO.obtenerNivelGeografico(DTOOID): Salida"); 

        return dtoSalida;
    }

    public void actualiza(DTOModificarImpuesto dto) throws MareException {
         UtilidadesLog.info("MONImpuestosUBIGEO.actualiza(DTOModificarImpuesto): Entrada"); 
        // Actualización
        try {
            ImpuestoUBIGEOLocalHome localHome = new ImpuestoUBIGEOLocalHome();

            ImpuestoUBIGEOLocal local = localHome.findByPrimaryKey(dto.getOid());
            local.setOidTasaImpuesto(dto.getImpuesto());
            UtilidadesLog.info("MONImpuestosUBIGEO.actualiza(DTOModificarImpuesto): Salida"); 
            try {
                localHome.merge(local);
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
    }

    public void elimina(DTOOIDs oids) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.elimina(DTOOIDs): Entrada"); 
        Long[] oid = oids.getOids();

        ImpuestoUBIGEOLocalHome localHome = new ImpuestoUBIGEOLocalHome();

        UtilidadesLog.debug("Cantidad de registros a borrar: " + oid.length);

        for (int i = 0; i < oid.length; i++) {
            try {
                ImpuestoUBIGEOLocal local = localHome.findByPrimaryKey(oid[i]);
                try {
                    localHome.remove(local);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            } catch (NoResultException nre) {
                ctx.setRollbackOnly();
                throw new MareException(nre, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException pe) {
                throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }
        }
        UtilidadesLog.info("MONImpuestosUBIGEO.elimina(DTOOIDs): Salida"); 
    }

    public DTOConsultaImpuestoUBIGEO consultar(DTOOID oid) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.consultar(DTOOID): Entrada"); 
        DTOConsultaImpuestoUBIGEO dtoConsImp = new DTOConsultaImpuestoUBIGEO();

        DAOMAEProductos daoMAEProductos = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONImpuestosUBIGEO.consultar(DTOOID): Salida"); 

        return daoMAEProductos.consultarImpuestoUbigeo(oid);
    }

    public DTOSalida buscarPorCriterios(DTOImpuestoUBIGEO dto) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.buscarPorCriterios(DTOImpuestoUBIGEO): Entrada"); 
        DAOMAEProductos daoMAEProdu = new DAOMAEProductos(ctx.getCallerPrincipal().getName());
        DTOSalida dtos = new DTOSalida();

        dtos = daoMAEProdu.buscarImpuestosUbigeo(dto);

        if (dtos.getResultado().esVacio()) {
           throw new MareException(new Exception(),
                                    UtilidadesError.armarCodigoError(
                                          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));       
        }
        
        UtilidadesLog.info("MONImpuestosUBIGEO.buscarPorCriterios(DTOImpuestoUBIGEO): Salida"); 

        return dtos;
    }

    public DTOSalida obtenerTasasImpuesto(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONImpuestosUBIGEO.obtenerTasasImpuesto(DTOBelcorp): Entrada"); 

        DAOParametrosPedidos daoPED = new DAOParametrosPedidos();
        RecordSet rs = new RecordSet();
        DTOSalida dtos = new DTOSalida();
        UtilidadesLog.debug("entro al  mon");
        UtilidadesLog.debug("el pais es " + dto.getOidPais());
        UtilidadesLog.debug("el idioma es " + dto.getOidIdioma());

        rs = daoPED.obtenerTasasImpuestoPorPais(dto);
        UtilidadesLog.debug("ejecuto metodo del dap de ped");

        if (rs.esVacio()) {
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        UtilidadesLog.debug("le resultado es " + rs);
        dtos.setResultado(rs);
                UtilidadesLog.info("MONImpuestosUBIGEO.obtenerTasasImpuesto(DTOBelcorp): Salida"); 
        return dtos;
    }
}
