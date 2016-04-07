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

package es.indra.sicc.logicanegocio.bel;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.bel.DTOControlAlmacen;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocal;
import es.indra.sicc.entidades.bel.ControlesDeAlmacenLocalHome;
import es.indra.sicc.entidades.mae.MaestroProductosLocal;
import es.indra.sicc.entidades.mae.MaestroProductosPK;
import es.indra.sicc.entidades.seg.AccesoLocal;
import es.indra.sicc.entidades.seg.AccesoLocalHome;
import es.indra.sicc.entidades.seg.SubaccesoLocal;
import es.indra.sicc.entidades.seg.SubaccesoLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.entidades.mae.MaestroProductosLocalHome;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * MON para el caso de uso de Controles de Almacen. Contiene la logica
 * de negocio para actualizar, eliminar y recuperar los datos de un Control 
 * de Almacen así como buscar todos los controles en base a un criterio.
 * 
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    MONMantenimientoControlAlmacen
 * 
 * @author Emilio Iraola
 * @date 23/01/2006
 */
public class MONMantenimientoControlAlmacenBean implements SessionBean  {
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
    
    /**
     * Actualiza los datos de la entidad ControlesDeAlmacen si se la habia
     * seleccionado antes, sino crea una nueva con dichos datos.
     * @param dtoE contiene los datos con que se creará/actualizará la entidad
     * 
     * @author Emilio Iraola
     * @date 23/01/2006
     */
    public void actualizarControlAlmacen(DTOControlAlmacen dtoE) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.actualizarControlAlmacen: Entrada");
        ControlesDeAlmacenLocalHome homeCDA = null;
        ControlesDeAlmacenLocal localCDA = null;
        
        homeCDA = this.getControlesDeAlmacenLocalHome();
        
        if (dtoE.getOidControlAlmacen() == null) { // Es un control nuevo
            try {
                /* Creamos un nuevo Entity ControlesDeAlmacen con los datos del
                   dto */
                localCDA = homeCDA.create(dtoE.getOidSubacceso(),
                                          dtoE.getOidProducto(),
                                          dtoE.getOidAlmacen());
            } catch (PersistenceException ce) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(ce);
                throw new MareException(ce, 
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }

        } else { // Es una modificacion
            try {
                localCDA = homeCDA.findByPrimaryKey(dtoE.getOidControlAlmacen());

                /* Actualizamos los atributos Obligatorios del Entity 
                   ControlesDeAlmacen */
                localCDA.setProducto(dtoE.getOidProducto());
                localCDA.setSubAcceso(dtoE.getOidSubacceso());
                localCDA.setAlmacen(dtoE.getOidAlmacen());
            } catch (NoResultException fe) {
                UtilidadesLog.error(fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            }  catch (PersistenceException ce) {   
                UtilidadesLog.error("ERROR ", ce);
                throw new MareException(ce, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
            }
        }

        /* Actualizamos el resto de los atributos del Entity C
           controlesDeAlmacen */
        localCDA.setStockMinimo(dtoE.getStockMinimo());
        localCDA.setStockMaximo(dtoE.getStockMaximo());
        localCDA.setStockReposicion(dtoE.getStockReposicion());
        localCDA.setActivado(dtoE.getActivado());
        homeCDA.merge(localCDA);
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.actualizarControlAlmacen: Salida");
    }

    /**
     * Obtiene todas las entidades ControlesDeAlmacen que coincidan con los 
     * parametros de la busqueda que se pasan en el dto.
     * @param dtoE contiene los parametros que conformarán el criterio de
     * busqueda
     * @return todos los ControlesDeAlmacen en forma de RecordSet del DTOSalida
     * 
     * @author Emilio Iraola
     * @date 23/01/2006
     */
    public DTOSalida buscarControlesAlmacen(DTOControlAlmacen dtoE) 
            throws MareException {
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.buscarControlesAlmacen: Entrada");
        DAOControlAlmacen daoCA = new DAOControlAlmacen();
        RecordSet controles = daoCA.buscarControlesAlmacen(dtoE);

        /* Construimos un DTOSalida y lo devolvemos */
        DTOSalida dtoS = new DTOSalida(controles);
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.buscarControlesAlmacen: Salida");
        return dtoS;
    }

    /**
     * Obtiene los datos de una entidad ControlesDeAlmacen cuyo oid se recibe 
     * como parametro de entrada.
     * @param dtoE lleva el oid del ControlDeAlmacen que se desea recuperar
     * @return el ControlDeAlmacen cuyo oid se paso por parametro
     * 
     * @author Emilio Iraola
     * @date 23/01/2006
     */
    public DTOControlAlmacen obtenerControlAlmacen(DTOOID dtoE)
            throws MareException {
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.obtenerControlAlmacen: Entrada");
        ControlesDeAlmacenLocalHome homeCDA = null;
        ControlesDeAlmacenLocal localCDA = null;
        MaestroProductosLocalHome homeMP = null;
        MaestroProductosLocal localMP = null;
        MaestroProductosPK mpPK = null;
        
        try {
            homeCDA = this.getControlesDeAlmacenLocalHome();
            localCDA = homeCDA.findByPrimaryKey(dtoE.getOid());
            
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }


        try {
            mpPK = new MaestroProductosPK(localCDA.getProducto());
            homeMP = this.getMaestroProductosLocalHome();
            localMP = homeMP.findByPrimaryKey(mpPK);
            
        } catch (NamingException ne) {
            UtilidadesLog.error(ne);
            throw new MareException(ne,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (FinderException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        DTOControlAlmacen dtoCA = new DTOControlAlmacen();

        dtoCA.setOidControlAlmacen(localCDA.getOid());
        dtoCA.setOidSubacceso(localCDA.getSubAcceso());
        dtoCA.setOidProducto(localCDA.getProducto());
        dtoCA.setOidAlmacen(localCDA.getAlmacen());
        dtoCA.setStockMinimo(localCDA.getStockMinimo());
        dtoCA.setStockMaximo(localCDA.getStockMaximo());
        dtoCA.setStockReposicion(localCDA.getStockReposicion());
        dtoCA.setActivado(localCDA.getActivado());
        
        dtoCA.setCodigoProducto(localMP.getCodigoSAP());
        dtoCA.setDescripcionProducto(localMP.getDescripcionCorta());
    
        SubaccesoLocalHome homeSubacc = null;
        SubaccesoLocal localSubacc = null;
        
        AccesoLocalHome homeAcc = null;
        AccesoLocal localAcc = null;
        
        try {
            homeSubacc = this.getSubaccesoLocalHome();
            localSubacc = homeSubacc.findByPrimaryKey(localCDA.getSubAcceso());
            
            homeAcc = this.getAccesoLocalHome();
            localAcc = homeAcc.findByPrimaryKey(localSubacc.getOidAcceso());
            
        } catch (NoResultException fe) {
            UtilidadesLog.error(fe);
            throw new MareException(fe,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }  catch (PersistenceException ce) {   
            UtilidadesLog.error("ERROR ", ce);
            throw new MareException(ce, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }

    
        dtoCA.setOidAcceso(localAcc.getOid());
        dtoCA.setOidCanal(localAcc.getOidCanal()); 

        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.obtenerControlAlmacen: Salida");
        return dtoCA;
    }

    /**
     * Elimina las entidades ControlesDeAlmacen cuyos oid se pasan por parametro.
     * @param dtoE un objeto con una propiedad que es un array de oid
     * 
     * @author Emilio Iraola
     * @date 23/01/2006
     */
    public void eliminarControlAlmacen(DTOOIDs dtoE) throws MareException {
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.eliminarControlAlmacen: Entrada");
        ControlesDeAlmacenLocalHome homeCDA = null;
        ControlesDeAlmacenLocal localCDA = null;
        
        homeCDA = this.getControlesDeAlmacenLocalHome();
        
        Long oids[] = dtoE.getOids();
        int cantOids = oids.length;

        for (int i = 0; i < cantOids ; i++) {
            try {
                localCDA = homeCDA.findByPrimaryKey(oids[i]);
                homeCDA.remove(localCDA);
            } catch (NoResultException fe) {
                UtilidadesLog.error(fe);
                throw new MareException(fe,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
            } catch (PersistenceException re) {
                UtilidadesLog.error(re);
                throw new MareException(re,
                    UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
            
        }
        UtilidadesLog.info("****Metodo MONMantenimientoControlAlmacen.eliminarControlAlmacen: Salida");
    }
    
    /* Metodos para obtener la interfaz LocalHome de los EJB */
    private SubaccesoLocalHome getSubaccesoLocalHome() {
        return new SubaccesoLocalHome();
    }

    private AccesoLocalHome getAccesoLocalHome() {
        return new AccesoLocalHome();
    }

    private ControlesDeAlmacenLocalHome getControlesDeAlmacenLocalHome() {
        return new ControlesDeAlmacenLocalHome();
    }


    private MaestroProductosLocalHome getMaestroProductosLocalHome() throws NamingException {
    final InitialContext context = new InitialContext();
    return (MaestroProductosLocalHome)context.lookup("java:comp/env/MaestroProductos");
  }
}