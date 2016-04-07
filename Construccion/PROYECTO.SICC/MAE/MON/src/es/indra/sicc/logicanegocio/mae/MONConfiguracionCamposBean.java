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

import es.indra.sicc.dtos.mae.DTOBusquedaConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOCombosConfiguracionCampos;
import es.indra.sicc.dtos.mae.DTOConfiguracionCampo;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposCliente;
import es.indra.sicc.dtos.mae.DTOConfiguracionCamposProducto;
import es.indra.sicc.dtos.mae.DTOConsultaConfiguracionCampos;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.entidades.mae.ConfiguracionCamposLocal;
import es.indra.sicc.entidades.mae.ConfiguracionCamposLocalHome;
import es.indra.sicc.logicanegocio.ped.DAOParametrosPedidos;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.MAEEjbLocators;
import es.indra.sicc.util.UtilidadesError;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/*
 * rgiorgi - 19/8/2005: se formatea la clase.
 * */
public class MONConfiguracionCamposBean implements SessionBean {
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

    public DTOConfiguracionCamposProducto obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionCampos.obtenerConfiguracionCamposProductos(DTOConfiguracionCamposProducto): Salida"); 
        return dao.obtenerConfiguracionCamposProductos(dto);
    }

    public DTOConfiguracionCamposCliente obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionCampos.obtenerConfiguracionCamposClientes(DTOConfiguracionCamposCliente): Salida"); 
        return dao.obtenerConfiguracionCamposClientes(dto);
    }

    public DTOSalida buscar(DTOBusquedaConfiguracionCampo dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.buscar(DTOBusquedaConfiguracionCampo): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionCampos.buscar(DTOBusquedaConfiguracionCampo): Salida"); 

        return dao.buscarConfiguracionCamposPorCriterios(dto);
    }

    public DTOConsultaConfiguracionCampos consultar(DTOOID oid) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.consultar(DTOOID): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionCampos.consultar(DTOOID): Salida"); 
        return dao.consultarConfiguracionCampos(oid);
    }

    /**
     * Se llama a DAOMAEConfiguracionClientes.obtenerTipoSubtipo y se pasa el  DTOTipoSubtipo
     * obtenido al constructor del DTOCombosConfiguracionCampos que  vamos a devolver.  Para
     * rellenar el atributo campos de dicho dto llamamos al método
     * obtenerAtributosEspecialesModulo de la interfaz IParametrosPedidos de PED  pasandole la
     * constante del módulo MAE: "16"
     */
    public DTOCombosConfiguracionCampos rellenarCombos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.rellenarCombos(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        DTOTipoSubtipo dtoS = dao.obtenerTipoSubtipo(dto);
        DTOCombosConfiguracionCampos dtoR = new DTOCombosConfiguracionCampos(dtoS);

        // MODULO PED
        DAOParametrosPedidos daoPED = new DAOParametrosPedidos();
        dtoR.setCampos(daoPED.obtenerAtributosEspecialesModulo("16"));
        UtilidadesLog.info("MONConfiguracionCampos.rellenarCombos(DTOBelcorp): Salida"); 

        return dtoR;
    }

    /**
     * Se llama al metodo create del entitybean ConfiguracionCampos y a  continuacion pasamos los
     * valores que contiene el dto  (salvo el campo tipoCliente, que no se tiene en cuenta)
     */
    public void insertar(DTOConfiguracionCampo dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.insertar(DTOConfiguracionCampo): Entrada"); 
        try {
            UtilidadesLog.debug("MONConfiguracionCampos.java - insertar");

            ConfiguracionCamposLocalHome cclh = this.getConfiguracionCamposLocalHome();

            Long ind_obl;
            Long ind_modi;

            if (dto.getObligatorio().booleanValue()) {
                ind_obl = new Long(1);
            } else {
                ind_obl = new Long(0);
            }

            if (dto.getModificable().booleanValue()) {
                ind_modi = new Long(1);
            } else {
                ind_modi = new Long(0);
            }

            //Long oid_conf_camp, Long pais_oid_pais, Long atre_oid_atri_espe, String val_defe, Long ind_obli, Long ind_modi
            ConfiguracionCamposLocal ccl = cclh.create( //dto.getOid(),
                dto.getOidPais(), dto.getCampo(), dto.getValorDefecto(), ind_obl, ind_modi);
            ccl.setSbti_oid_subt_clie(dto.getSubtipoCliente());
            cclh.merge(ccl);

            UtilidadesLog.info("MONConfiguracionCampos.insertar(DTOConfiguracionCampo): Salida"); 
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            String codigoError = "0170001";
            throw new MareException(pe, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
        }
    }

    /* Configuracion de Campos **/
    private ConfiguracionCamposLocalHome getConfiguracionCamposLocalHome() {
        return new ConfiguracionCamposLocalHome();
    }

    /**
     * Por cada elemento del dto llamamos al metodo remove del home del  entitybean
     * ConfiguracionCampos
     *
     * @param dto - DTOOIDs
     *
     * @throws MareException
     */
    public void eliminar(DTOOIDs dto) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.eliminar(DTOOIDs): Entrada"); 
        try {
            

            ConfiguracionCamposLocalHome cclh = this.getConfiguracionCamposLocalHome();
            UtilidadesLog.debug("2 + length: " + dto.getOids().length);

            for (int j = 0; j < dto.getOids().length; j++) {
                ConfiguracionCamposLocal ccl = cclh.findByPrimaryKey(dto.getOids()[j]);
                UtilidadesLog.debug("A punto de eliminar ConfiguracionCamposLocal con OID: " + dto.getOids()[j]);
                try {
                    cclh.remove(ccl);
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    String codigoError = "0170002";
                    throw new MareException(new Exception(), UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_MAE, "", codigoError));
                }
            }
            UtilidadesLog.info("MONConfiguracionCampos.eliminar(DTOOIDs): Salida"); 
        } catch (NoResultException nre) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(nre, UtilidadesError.armarCodigoError(error));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            String error = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(error));
        }
    }

    public void actualizar(DTOConfiguracionCampo dto) throws MareException {
        /** Hacemos un findByPrimaryKey del entity ConfiguracionCampos con
         * el oid del dto y actualizamos el entity con los
         * valores del dto.
         */
         UtilidadesLog.info("MONConfiguracionCampos.actualizar(DTOConfiguracionCampo): Entrada"); 
        ConfiguracionCamposLocalHome localHome = new ConfiguracionCamposLocalHome();

        try {
            ConfiguracionCamposLocal local = localHome.findByPrimaryKey(dto.getOid());
            local.setInd_modi(convertirBooleanANumber(dto.getModificable()));
            local.setInd_obli(convertirBooleanANumber(dto.getObligatorio()));
            local.setVal_defe(dto.getValorDefecto());
            try {
                localHome.merge(local);
            } catch (PersistenceException pe) {
                ctx.setRollbackOnly();
                String codigoError = CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS;
                throw new MareException(pe, UtilidadesError.armarCodigoError(codigoError));
            }
            UtilidadesLog.info("MONConfiguracionCampos.actualizar(DTOConfiguracionCampo): Salida"); 
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException pe) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
            throw new MareException(pe, UtilidadesError.armarCodigoError(codigoError));
        }
    }

    private static Long convertirBooleanANumber(Boolean aBoolean) {
        if (aBoolean == null) {
            return null;
        }

        if (aBoolean.booleanValue()) {
            return new Long(1);
        }

        return new Long(0);
    }

    public DTOSalida obtenerValoresDefectoClientes(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONConfiguracionCampos.obtenerValoresDefectoClientes(DTOBelcorp): Entrada"); 
        DAOMAEConfiguracionClientes dao = new DAOMAEConfiguracionClientes(ctx.getCallerPrincipal().getName());
        UtilidadesLog.info("MONConfiguracionCampos.obtenerValoresDefectoClientes(DTOBelcorp): Salida"); 
        return dao.obtenerValoresDefectoClientes( dtoe );
    }
}
