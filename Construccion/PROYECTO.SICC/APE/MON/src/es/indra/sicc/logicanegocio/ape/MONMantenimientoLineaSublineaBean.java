/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 */
package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.dtos.ape.DTOBuscarLineasArmado;
import es.indra.sicc.dtos.ape.DTOBuscarSublineaArmado;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOInsertarLineaArmado;
import es.indra.sicc.dtos.ape.DTOLineaArmado;
import es.indra.sicc.dtos.ape.DTOSublineaArmado;
import es.indra.sicc.dtos.ape.DTOTipoCajaProducto;
import es.indra.sicc.dtos.ape.DTOTipoCajaSublinea;
import es.indra.sicc.dtos.ape.DTOTipoSolicitudLinea;
import es.indra.sicc.entidades.ape.AsignacionImpresoraAPELocal;
import es.indra.sicc.entidades.ape.AsignacionImpresoraAPELocalHome;
import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.entidades.ape.LineaArmadoLocalHome;
import es.indra.sicc.entidades.ape.SublineaArmadoLocal;
import es.indra.sicc.entidades.ape.SublineaArmadoLocalHome;
import es.indra.sicc.entidades.ape.TipoCajaSublineaLocal;
import es.indra.sicc.entidades.ape.TipoCajaSublineaLocalHome;
import es.indra.sicc.entidades.ape.TipoSolicitudLineaLocal;
import es.indra.sicc.entidades.ape.TipoSolicitudLineaLocalHome;
import es.indra.sicc.entidades.ape.UsuarioAlarmaLineaLocal;
import es.indra.sicc.entidades.ape.UsuarioAlarmaLineaLocalHome;
import es.indra.sicc.entidades.app.TipoCajaProductoLocal;
import es.indra.sicc.entidades.app.TipoCajaProductoLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.dtos.ape.DTOSublineasLineaOrdenacion;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;


public class MONMantenimientoLineaSublineaBean implements SessionBean {
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

    public void insertarTipoCajaProducto(DTOTipoCajaProducto dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarTipoCajaProducto(DTOTipoCajaProducto dtoe): Entrada");
        UtilidadesLog.debug(" DTOTipoCajaProducto recibido: " + dtoe);
        
        try {
            TipoCajaProductoLocalHome tcpLH = new TipoCajaProductoLocalHome();
            TipoCajaProductoLocal tcpL = null;
                        
            MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
            
            if (dtoe.getOid() == null) { // Insercion
                UtilidadesLog.debug("...creando Entidad TipoCajaProducto");
                try {
                    tcpL = tcpLH.create(dtoe.getCodigoCaja().toUpperCase(), dtoe.getOidPais()); // Requisito general: Mayuscula para codigos alfanumericos
                 } catch (EntityExistsException ex) {
                     UtilidadesLog.error(ex);
                     ctx.setRollbackOnly();
                     throw new MareException(ex, UtilidadesError.armarCodigoError(
                         CodigosError.ERROR_DE_CLAVE_DUPLICADA));
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                UtilidadesLog.debug("...insertando Descripcion internacionalizable");
                i18n.insertarTraducciones("APP_TIPO_CAJA_PRODU", tcpL.getOid(), dtoe.getAttriTraducible());
            } else {  // Modificacion
                UtilidadesLog.debug("...actualizando Entidad TipoCajaProducto");
                try {
                    tcpL = tcpLH.findByPrimaryKey(dtoe.getOid());
                } catch (NoResultException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
                } catch (PersistenceException e) {
                    UtilidadesLog.error(e);
                    ctx.setRollbackOnly();
                    throw new MareException(e, UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
                
                UtilidadesLog.debug("...actualizando Descripcion internacionalizable");
                i18n.actualizaTraducciones("APP_TIPO_CAJA_PRODU", dtoe.getOid(), dtoe.getAttriTraducible());
            }
        
        } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarTipoCajaProducto(DTOTipoCajaProducto dtoe): Salida");
    }

    public DTOSalida buscarTipoCajaProducto(DTOTipoCajaProducto dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Entrada");
        DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Salida");
        return dao.buscarTipoCajaProducto(dtoe);        
    }

    public void eliminarTipoCajaProducto(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Entrada");
        try {
            Long[] oids = dtoe.getOids();
            TipoCajaProductoLocalHome tcpLH = new TipoCajaProductoLocalHome();
            TipoCajaProductoLocal tcpL = null;
            MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
            
            int cantTiposCaja = oids.length;
            
            try {
                for (int i = 0; i < cantTiposCaja; i++) {
                    UtilidadesLog.debug("...eliminando Entidad TipoCajaProducto");
                    tcpL = tcpLH.findByPrimaryKey(oids[i]);
                    tcpLH.remove(tcpL);
                    
                    UtilidadesLog.debug("...eliminando Descripcion internacionalizable");
                    i18n.eliminarTraducciones("APP_TIPO_CAJA_PRODU", oids[i]);
                }
            } catch (PersistenceException e) {
                UtilidadesLog.error(e);
                ctx.setRollbackOnly();
                throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
        } catch (CreateException ce) {
            UtilidadesLog.error(ce);
            ctx.setRollbackOnly();
            throw new MareException(ce, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (RemoteException rte) {
            UtilidadesLog.error(rte);
            ctx.setRollbackOnly();
            throw new MareException(rte, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaProducto(DTOTipoCajaProducto dtoe): Salida");
    }


    public DTOSalida obtenerLineasArmadoCD(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCD(DTOOID dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerLineasArmadoCD(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }

    public DTOSalida obtenerSublineasArmadoCD(DTOOID dtoe) throws MareException  {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSublineasArmadoCD(DTOOID dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerSublineasArmadoCD(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSublineasArmadoCD(DTOOID dtoe): Salida");
        return dtoSalida;
    }
   
  /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   23/01/2007
   * @version 1.00
   * @autor   Viviana Bongiovanni
   */
  public DTOSalida obtenerLineasMapaCD(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasMapaCD(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerLineasMapaCD(dtoe);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasMapaCD(DTOOID dtoe): Salida");
    return dtoSalida;
  }

    /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   23/01/2007
   * @version 1.00
   * @autor   Carlos Daniel Iglesias
   */
 public DTOSalida consultarSistemaPicado(DTOSiccPaginacion dtoE) throws MareException
  {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.consultarSistemaPicado(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().consultarSistemaPicado(dtoE);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.consultarSistemaPicado(DTOBelcorp dtoe): Salida");
        return dtoSalida;
  }
  
  /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   23/01/2007
   * @version 1.00
   * @autor   Viviana Bongiovanni
   */
  public DTOSalida obtenerSublineasLinea(DTOOID dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSublineasLinea(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerSublineasLinea(dtoe);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSublineasLinea(DTOOID dtoe): Salida");
    return dtoSalida;
  }


    /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   23/01/2007
   * @version 1.00
   * @autor   Carlos Daniel Iglesias
   */
  public DTOOID obtenerProximoCodigoLinea(DTOBelcorp dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProximoCodigoLinea(): Entrada");
    DTOOID dtoOid = new DTOOID();
    Long codigo = new DAOMantenimientoLineaSublinea().obtenerProximoCodigoLinea();
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProximoCodigoLinea(): Salida");
    dtoOid.setOid(codigo);
    return dtoOid;
  }

    /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   23/01/2007
   * @version 1.00
   * @autor   Carlos Daniel Iglesias
   */
  public DTOSalida obtenerProgramasCubicaje(DTOBelcorp dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProgramasCubicaje(DTOBelcorp dtoE): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerProgramasCubicaje(dtoE);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProximoCodigoLinea(DTOBelcorp dtoE): Salida");
    return dtoSalida;
  }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */
    public DTOSalida buscarTipoCajaSublinea(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaSublinea(DTOOID dtoe): Entrada");
        DTOSalida dtoSalida  = new DAOMantenimientoLineaSublinea().buscarTipoCajaSublinea(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarTipoCajaSublinea(DTOOID dtoe): Salida");
        return dtoSalida;
    }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */
    public DTOSalida buscarSublineasArmado(DTOBuscarSublineaArmado dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarSublineasArmado(DTOBuscarSublineaArmado dtoe): Entrada");
        DTOSalida dtoSalida  = new DAOMantenimientoLineaSublinea().buscarSublineasArmado(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarSublineasArmado(DTOBuscarSublineaArmado dtoe): Salida");
        return dtoSalida;    }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */
    public DTOOID obtenerProximoCodigoSublinea() throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProximoCodigoSublinea(): Entrada");
        Long codigo = new DAOMantenimientoLineaSublinea().obtenerProximoCodigoSublinea();
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerProximoCodigoSublinea(): Salida");
        DTOOID dtoOid = new DTOOID();
        dtoOid.setOid(codigo);
        
        return dtoOid;    
    }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */    
    //Eliminar todos los registros de APE:SublineaArmado cuyo oid se encuentre en el dtoe.
    public void eliminarSublineas(DTOOIDs dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.eliminarSublineas(DTOOIDs dtoe): Entrada");
        try {
            Long[] oids = dtoe.getOids();
            SublineaArmadoLocalHome slaLH = new SublineaArmadoLocalHome();
            SublineaArmadoLocal slaL = null;
            
            int cantSublineaArmado = oids.length;
            
            for (int i = 0; i < cantSublineaArmado; i++) {
                UtilidadesLog.debug("...eliminando Entidad SublineaArmado");
                
                /*ciglesias incidencia 480 inicio*/
                  AsignacionImpresoraAPELocalHome impresoraHome = new AsignacionImpresoraAPELocalHome();
                  AsignacionImpresoraAPELocal impresora = null;
                  
                  //Long oidSubLinea
                  impresora = impresoraHome.findByUk(oids[i]);
                  
                  try {
                    impresoraHome.remove(impresora);
                  } catch (PersistenceException e) {
                      ctx.setRollbackOnly();
                      UtilidadesLog.error("Error en remove: ", e);
                      throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                  }
                /*ciglesias incidencia 480 fin*/                
                slaL = slaLH.findByPrimaryKey(oids[i]);
                try {
                    slaLH.remove(slaL);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en remove: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.eliminarSublineas(DTOOIDs dtoe): Salida");
    }  
    
   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */    
    //Eliminar todos los registros de APE:TipoCajaSublinea cuyo oid se encuentre en tiposCajaSublineaEliminados
    public void eliminarTiposCajaSublinea(DTOOIDs tiposCajaSublineaEliminados) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.eliminarTiposCajaSublinea" +
                           "(DTOOIDs tiposCajaSublineaEliminados): Entrada");
        try {
            if(tiposCajaSublineaEliminados != null){
            
                Long[] oidsTCSE = tiposCajaSublineaEliminados.getOids();
                TipoCajaSublineaLocalHome tcsLH = new TipoCajaSublineaLocalHome();
                TipoCajaSublineaLocal tcsL = null;
                
                int cantTiposCajaSublinea = oidsTCSE.length;
                
                for (int i = 0; i < cantTiposCajaSublinea; i++) {
                    UtilidadesLog.debug("...eliminando Entidad TiposCajaSublinea");
                    tcsL = tcsLH.findByPrimaryKey(oidsTCSE[i]);
                    try {
                        tcsLH.remove(tcsL);
                    } catch (PersistenceException e) {
                        UtilidadesLog.error(e);
                        ctx.setRollbackOnly();
                        throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
                    }
                }
            }
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.eliminarTiposCajaSublinea" +
                           "(DTOOIDs tiposCajaSublineaEliminados): Salida");
        
    }    
   

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */
  
//Modifica la sublinea y los tipos de caja sublinea indicados.   
  /*

Implementación: 

eliminarTiposCajaSublinea( tiposCajaSublineaEliminados ) 
insertarSublineaArmado( dtoSublineaArmado, tiposCajaSublinea[] ) 
Si alguna de las dos operaciones falla deben deshacerse los cambios efectuados por ambas. 

   * */ 
   
    public void modificarSublineaArmado(DTOSublineaArmado dtoSublineaArmado) 
                                        throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.modificarSublineaArmado " +
                          "(DTOSublineaArmado dtoSublineaArmado) : Entrada");                
           
        try{                                
            eliminarTiposCajaSublinea(dtoSublineaArmado.getTipoCajaSublineasEliminados());
            insertarSublineaArmado(dtoSublineaArmado); 
        }catch (Exception ex) {
            UtilidadesLog.error("ERROR ", ex);
            ex.printStackTrace();
            throw new MareException(ex);
        }                 
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.modificarSublineaArmado " +
                          "(DTOSublineaArmado dtoSublineaArmado, DTOTipoCajaSublinea tiposCajaSublinea[]," +
                          " DTOOIDs tiposCajaSublineaEliminados) : Salida");                
    }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   */    
    public void insertarTiposCajaSublinea(DTOSublineaArmado dtoSublineaArmado ) 
                throws MareException {
   
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarTiposCajaSublinea" +
                           "(DTOSublineaArmado dtoSublineaArmado): Entrada");                
   
        try {  
             
             int cant;
             DTOTipoCajaSublinea dtoTipoCajaSublinea = null;
             TipoCajaSublineaLocalHome tcsLH = new TipoCajaSublineaLocalHome();
             TipoCajaSublineaLocal tcsL = null;
        
             Vector tiposCajaSublineas = dtoSublineaArmado.getTipoCajaSublineas();
             cant = tiposCajaSublineas.size();        

             for(int i=0; i<cant; i++){ 
                  dtoTipoCajaSublinea = (DTOTipoCajaSublinea)tiposCajaSublineas.get(i);
                  if (dtoTipoCajaSublinea.getOid() == null) {
                      UtilidadesLog.debug("Insercion");  
                      try {
                          tcsL = tcsLH.create(dtoTipoCajaSublinea.getNumCaja(),
                                 dtoSublineaArmado.getOid(), 
                                 dtoTipoCajaSublinea.getTipoCajaProducto().getOid());
                      } catch (PersistenceException e) {
                          ctx.setRollbackOnly();
                          UtilidadesLog.error("ERROR ", e);
                          throw new MareException(e, 
                          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                      }
                  }else{ 
                      UtilidadesLog.debug("Modificacion");
                      tcsL = tcsLH.findByPrimaryKey(dtoTipoCajaSublinea.getOid());
                      tcsL.setNumCaja(dtoTipoCajaSublinea.getNumCaja());
                      try {
                          tcsLH.merge(tcsL);
                      } catch (PersistenceException e) {
                          ctx.setRollbackOnly();
                          UtilidadesLog.error("ERROR ", e);
                          throw new MareException(e, 
                          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                      }
                  }
             }
        } catch (NoResultException e) {  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        } catch (PersistenceException e) {  
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, 
          UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarTiposCajaSublinea" +
                           "(DTOSublineaArmado dtoSublineaArmado): Salida");                
    }

   /**
   * Fecha:   31/01/2007
   * @autor   gpons
   * Descripción: Inserta un registro en SublineaArmado y n en TipoCajaSublinea 
   */    
   
    public void insertarSublineaArmado(DTOSublineaArmado dtoSublineaArmado) throws MareException {
        
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarSublineaArmado" +
        " (DTOSublineaArmado dtoSublineaArmado): Entrada");
        
        UtilidadesLog.debug(" DTOSublineaArmado recibido: " + dtoSublineaArmado);
        
        try {
            SublineaArmadoLocalHome slaLH = new SublineaArmadoLocalHome();
            SublineaArmadoLocal slaL = null;
            
            MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
            
           if (dtoSublineaArmado.getOid() == null) { //Insercion
                UtilidadesLog.debug("...creando Entidad SublineaArmado");
                try {
                    slaL = slaLH.create(dtoSublineaArmado.getCodigoSublinea(), 
                    dtoSublineaArmado.getPostVenta(),
                    dtoSublineaArmado.getLetraParaAnaquel(),
                    dtoSublineaArmado.getImprimirListaPicado(), //ciglesias incidencia 356
                    dtoSublineaArmado.getFrenteEspalda(),
                    dtoSublineaArmado.getBahiasFrente(),
                    dtoSublineaArmado.getBahiaEspalda(),
                    dtoSublineaArmado.getNumeroNivelesFrente(),
                    dtoSublineaArmado.getNumeroNivelesEspalda(),
                    dtoSublineaArmado.getNumeroColumnasFrente(),
                    dtoSublineaArmado.getNumeroColumnasEspalda(),
                    dtoSublineaArmado.getNumeroOrdenBalanceo(),
                    dtoSublineaArmado.getLineaArmado().getOid(),
                    dtoSublineaArmado.getSistemaPicado().getOid(),
                    dtoSublineaArmado.getCentroDistribucion()
                    );
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en create: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }

                UtilidadesLog.debug("...insertando Descripcion internacionalizable");
                i18n.insertarTraducciones("APE_SUBLI_ARMAD", slaL.getOid(), dtoSublineaArmado.getAttriTraducible());
                
                //Setearle al dtoSublineaArmado como oid el oid del registro creado. 
                dtoSublineaArmado.setOid(slaL.getOid());
                
                /*ciglesias incidencia 480 inicio*/
                try {
                    AsignacionImpresoraAPELocalHome impresoraHome = new AsignacionImpresoraAPELocalHome();
                    AsignacionImpresoraAPELocal impresora = null;
                    
                    impresora = impresoraHome.create(dtoSublineaArmado.getImpresora().getImpresoraVirtual(),
                                dtoSublineaArmado.getOid(), ConstantesAPE.TECNOLOGIA_IMPRESORA);
                                
                    impresora.setNumImprPtl(dtoSublineaArmado.getImpresora().getNroImpresoraPTL());
                    
                    impresoraHome.merge(impresora);
                    
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en create: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                /*ciglesias incidencia 480 fin*/
                


           } else {  // Modificacion
                UtilidadesLog.debug("...actualizando Entidad SublineaArmado");
                slaL = slaLH.findByPrimaryKey(dtoSublineaArmado.getOid());
                
                slaL.setPostVenta(dtoSublineaArmado.getPostVenta());
                slaL.setImprimirListaPicado(dtoSublineaArmado.getImprimirListaPicado());
                slaL.setFrenteEspalda(dtoSublineaArmado.getFrenteEspalda());
                slaL.setBahiasFrente(dtoSublineaArmado.getBahiasFrente());
                slaL.setBahiaEspalda(dtoSublineaArmado.getBahiaEspalda());
                slaL.setNumeroNivelesFrente(dtoSublineaArmado.getNumeroNivelesFrente());                
                slaL.setNumeroNivelesEspalda(dtoSublineaArmado.getNumeroNivelesEspalda());
                slaL.setNumeroColumnasFrente(dtoSublineaArmado.getNumeroColumnasFrente());
                slaL.setNumeroColumnasEspalda(dtoSublineaArmado.getNumeroColumnasEspalda());
                slaL.setNumeroOrdenBalanceo(dtoSublineaArmado.getNumeroOrdenBalanceo());
                slaL.setOidSistemaPicado(dtoSublineaArmado.getSistemaPicado().getOid());
                slaL.setOidCentroDistribucion(dtoSublineaArmado.getCentroDistribucion());
                
                try {
                    slaLH.merge(slaL);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                
                UtilidadesLog.debug("...actualizando Descripcion internacionalizable");
                i18n.actualizaTraducciones("APE_SUBLI_ARMAD", dtoSublineaArmado.getOid(), dtoSublineaArmado.getAttriTraducible());
                
                /*ciglesias incidencia 480 inicio*/
                AsignacionImpresoraAPELocalHome impresoraHome = new AsignacionImpresoraAPELocalHome();
                AsignacionImpresoraAPELocal impresora = null;
                
                //Long oidSubLinea
                impresora = impresoraHome.findByUk(dtoSublineaArmado.getOid());
                            
                impresora.setNumImprPtl(dtoSublineaArmado.getImpresora().getNroImpresoraPTL());
                impresora.setImviOidImpr(dtoSublineaArmado.getImpresora().getImpresoraVirtual());
                
                try {
                    impresoraHome.merge(impresora);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error en merge: ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
                /*ciglesias incidencia 480 fin*/
           }
           
           //Llamar a insertarTiposCajaSublinea pasándole el array de DTOTipoCajaSublinea tiposCajaSublinea[]
           insertarTiposCajaSublinea(dtoSublineaArmado);
           
        } catch (CreateException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (NoResultException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));        
        } catch (PersistenceException e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (RemoteException re) {
            UtilidadesLog.error(re);
            ctx.setRollbackOnly();
            throw new MareException(re, UtilidadesError.armarCodigoError(
                CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }        
        
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarSublineaArmado" +
        " (DTOSublineaArmado dtoSublineaArmado): Salida");
    }
    

    /**
    * Fecha:  07/02/2007
    * @autor   gpons
    */
    public DTOSalida obtenerSistemasEtiquetado(DTOBelcorp dtoE) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSistemasEtiquetado(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida  = new DAOMantenimientoLineaSublinea().obtenerSistemasEtiquetado(dtoE);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerSistemasEtiquetado(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }


  public DTOOID insertarLineaArmado(DTOInsertarLineaArmado dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarLineaArmado(DTOInsertarLineaArmado dtoE): Entrada");
    UtilidadesLog.info("DTO " + dtoE);
    UtilidadesLog.info("dtoE.getDtoLineaArmado().getValorDefecto().booleanValue(): " + dtoE.getDtoLineaArmado().getValorDefecto().booleanValue());
    UtilidadesLog.debug("dtoE.getDtoTipoSolicitudLinea(): " + Arrays.toString(dtoE.getDtoTipoSolicitudLinea()));
    DTOOID dto = null;
  if (dtoE.getDtoLineaArmado().getValorDefecto().booleanValue()) 
  {
    DAOMantenimientoLineaSublinea daoMLS = new DAOMantenimientoLineaSublinea();
    DTOLineaArmado dtoL = daoMLS.obtenerLineaArmadoDefaultCD(dtoE.getDtoLineaArmado().getCentroDistribucion());
    UtilidadesLog.info("dtoL.getOid(): " + dtoL.getOid());
    if (dtoL.getOid() != null)
    {
      if (dtoE.getDtoLineaArmado().getOid() == null || !dtoE.getDtoLineaArmado().getOid().equals(dtoL.getOid())) 
      {
          UtilidadesLog.info("entra a ExcepcionParametrizada exPar");
          ExcepcionParametrizada exPar;
          exPar = new ExcepcionParametrizada("", UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_APE, "",ErroresDeNegocio.APE_0002));
          exPar.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
          /* dmorello, 27/04/2007 */
          //exPar.addParameter(dtoL.getOid().toString());  
          exPar.addParameter(dtoL.getDescripcion());  
          /* Fin dmorello 27/04/2007 */
          throw exPar;
      }
    }
  }

  UtilidadesLog.info("dtoE.getDtoLineaArmado().getOid():" + dtoE.getDtoLineaArmado().getOid());
  if (dtoE.getDtoLineaArmado().getOid() == null) //INSERTAR
  {
      LineaArmadoLocalHome lineaArmadoLocalHome = new LineaArmadoLocalHome();
      LineaArmadoLocal lineaArmadoLocal = null; 
      
      UtilidadesLog.info("lineaArmadoLocalHome.create()");
      try {
      
        lineaArmadoLocal = lineaArmadoLocalHome.create(
                                            dtoE.getDtoLineaArmado().getCodigoLinea(),
                                            //dtoE.getDtoLineaArmado().getImprimirListaPicado(), //ciglesias incidencia 356
                                            dtoE.getDtoLineaArmado().getLongitudNumeroEtiqueta(),
                                            dtoE.getDtoLineaArmado().getLineaAFP(),
                                            dtoE.getDtoLineaArmado().getValorDefecto(),
                                            dtoE.getDtoLineaArmado().getCentroDistribucion().getOidCentroDistribucion(),
                                            null);
        //new Long(1)
        /*ciglesias 17-04-2007 incidencia 364
         * UtilidadesLog.info("dtoE.getDtoLineaArmado().getFormatoEtiqueta():" + dtoE.getDtoLineaArmado().getFormatoEtiqueta());   
        if (dtoE.getDtoLineaArmado().getFormatoEtiqueta() != null) {
          lineaArmadoLocal.setFormatoEtiqueta(dtoE.getDtoLineaArmado().getFormatoEtiqueta());
        }
        */
  
        UtilidadesLog.info("dtoE.getDtoLineaArmado().getNumeroEtiquetasAFP():" + dtoE.getDtoLineaArmado().getNumeroEtiquetasAFP());   
        if (dtoE.getDtoLineaArmado().getNumeroEtiquetasAFP() != null) {
          lineaArmadoLocal.setNumeroEtiquetasAFP(dtoE.getDtoLineaArmado().getNumeroEtiquetasAFP());
        }
  
        UtilidadesLog.info("dtoE.getDtoLineaArmado().getProgramaCubicaje().getOid():" + dtoE.getDtoLineaArmado().getProgramaCubicaje().getOid());   
        if (dtoE.getDtoLineaArmado().getProgramaCubicaje().getOid() != null) {
          lineaArmadoLocal.setProgramaCubicaje(dtoE.getDtoLineaArmado().getProgramaCubicaje().getOid());
        }
        
        lineaArmadoLocalHome.merge(lineaArmadoLocal);
        
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(
              CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }   
      
      UtilidadesLog.info("692 dtoE.getDtoTipoSolicitudLinea()" + dtoE.getDtoTipoSolicitudLinea());   
      if ((dtoE.getDtoTipoSolicitudLinea() != null) && (dtoE.getDtoTipoSolicitudLinea().length > 0)) {

        TipoSolicitudLineaLocalHome tipoSolicitudHome = new TipoSolicitudLineaLocalHome();
        TipoSolicitudLineaLocal tipoSolicitud = null; 
        DTOTipoSolicitudLinea solicitudes[] = dtoE.getDtoTipoSolicitudLinea();
      
        UtilidadesLog.info("699 solicitudes.length:" + solicitudes.length);     
        for  (int i = 0; i < solicitudes.length; i++) 
        {
          try {
            
            if ((solicitudes[i] != null) && (solicitudes[i].getTipoSolicitudPais() != null)) {
              UtilidadesLog.debug("valor tipoSolicitud "  + solicitudes[i] );
              UtilidadesLog.debug("linea armado " + lineaArmadoLocal.getOid() );
              tipoSolicitud = tipoSolicitudHome.create(
                                solicitudes[i].getTipoSolicitudPais(),
                                lineaArmadoLocal.getOid());
            } else {
                  UtilidadesLog.debug("El registro [" + i  + "] de solicitudes no tiene valores" );
            }
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e,UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }         
        }
      }

      UtilidadesLog.info("728 dtoE.getDtoUsuarioAlarmaLineas():" + dtoE.getDtoUsuarioAlarmaLineas());
      if ((dtoE.getDtoUsuarioAlarmaLineas() != null) && (dtoE.getDtoUsuarioAlarmaLineas().length > 0)) {
        UtilidadesLog.debug("alarma");
        UsuarioAlarmaLineaLocalHome usuarioHome = new UsuarioAlarmaLineaLocalHome();
        UsuarioAlarmaLineaLocal usuarios = null; 
        
        UtilidadesLog.info("734 dtoE.getDtoUsuarioAlarmaLineas().length:" + dtoE.getDtoUsuarioAlarmaLineas().length);
        for  (int i = 0; i < dtoE.getDtoUsuarioAlarmaLineas().length; i++) {
          try {
            
            if ((dtoE.getDtoUsuarioAlarmaLineas()[i] != null) && (dtoE.getDtoUsuarioAlarmaLineas()[i].getEmail() != null)) {
              UtilidadesLog.debug("usuarios " + dtoE.getDtoUsuarioAlarmaLineas()[i].getEmail() + " - " + lineaArmadoLocal.getOid());
              usuarios = usuarioHome.create(dtoE.getDtoUsuarioAlarmaLineas()[i].getEmail(),lineaArmadoLocal.getOid());
            } else {
                UtilidadesLog.debug("El registro [" + i  + "] de usuarios no tiene valores" );
            }
           
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e,UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }         
        }  
      }
      
      try {
      //traduccion
      Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
      
      for (int i=0; i<dtoE.getAttrTraducible().size(); i++){	
          UtilidadesLog.debug("entra loop de internacionalizacion");
          DTOI18nSICC dto18 = (DTOI18nSICC) dtoE.getAttrTraducible().elementAt(i); //devuelve los datos de la traducción
          UtilidadesLog.debug("obtine el dtoi18n " + dto18 );
          Long oidIdioma = dto18.getOidIdioma();
          UtilidadesLog.debug("obtine el idioma " + oidIdioma );
          String descripcion = dto18.getValorI18n();
          UtilidadesLog.debug("obtine descripcion " + descripcion );
          e18nLH.create("APE_LINEA_ARMAD", new Long(1), oidIdioma, descripcion, lineaArmadoLocal.getOid());
          UtilidadesLog.debug("despues del crete" );          
      }
      //traduccion
      } catch (PersistenceException e) {
           ctx.setRollbackOnly();
           throw new MareException(e,UtilidadesError.armarCodigoError(
               CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      //LLAMARA A OBTENER PROXIMO VALOR DE CODIGO LINEA
      dto = obtenerProximoCodigoLinea(null);
  }
  else //MODIFICAR
  {
      UtilidadesLog.info("790 MODIFICAR");
      
      LineaArmadoLocalHome lineaArmadoLocalHome = new LineaArmadoLocalHome();
      UsuarioAlarmaLineaLocalHome usuarioHome = new UsuarioAlarmaLineaLocalHome();
      TipoSolicitudLineaLocalHome tipoSolicitudHome = new TipoSolicitudLineaLocalHome();
      LineaArmadoLocal lineaArmadoLocal = null; 
      TipoSolicitudLineaLocal tipoSolicitud = null; 
      UsuarioAlarmaLineaLocal usuarios = null; 
                                                
      UtilidadesLog.debug("antes de modificar" );

      try {
        lineaArmadoLocal = lineaArmadoLocalHome.findByPrimaryKey(dtoE.getDtoLineaArmado().getOid());
      } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
      } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));            
      }
      
      //lineaArmadoLocal.setImprimirListaPicado(dtoE.getDtoLineaArmado().getImprimirListaPicado()); //ciglesias incidencia 356
      lineaArmadoLocal.setLongitudNumeroEtiqueta(dtoE.getDtoLineaArmado().getLongitudNumeroEtiqueta());
      lineaArmadoLocal.setLineaAFP(dtoE.getDtoLineaArmado().getLineaAFP());
      //lineaArmadoLocal.setFormatoEtiqueta(dtoE.getDtoLineaArmado().getFormatoEtiqueta()); //ciglesias 17-04-2007 incidencia 364
      lineaArmadoLocal.setNumeroEtiquetasAFP(dtoE.getDtoLineaArmado().getNumeroEtiquetasAFP());
      lineaArmadoLocal.setProgramaCubicaje(dtoE.getDtoLineaArmado().getProgramaCubicaje().getOid());
      lineaArmadoLocal.setValorDefecto(dtoE.getDtoLineaArmado().getValorDefecto());
      
      try {
          lineaArmadoLocalHome.merge(lineaArmadoLocal);
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
      
      Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
      
      for (int i=0;i<dtoE.getAttrTraducible().size();i++){
        DTOI18nSICC dtoTraduccion = (DTOI18nSICC) dtoE.getAttrTraducible().elementAt(i); 
        Long oidIdioma = dtoTraduccion.getOidIdioma();
        String descripcion = dtoTraduccion.getValorI18n();
        try{
          Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "APE_LINEA_ARMAD", new Long(1) ,oidIdioma, lineaArmadoLocal.getOid());
          e18nL.setDetalle(descripcion);
          try {
              e18nLH.merge(e18nL);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("Error al hacer merge en Entidadi18n: ",e );
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
        }catch(PersistenceException e){
          UtilidadesLog.error("****Error Metodo: guardarConfiguracionCD -- modificar: PersistenceException: ", e);
          try {
            e18nLH.create("APE_LINEA_ARMAD", new Long(1), oidIdioma, descripcion,lineaArmadoLocal.getOid());             
          } catch(PersistenceException pe) {
            UtilidadesLog.error("****Error Metodo: guardarConfiguracionCD -- creandoTraducible: PersistenceException: ", pe);
          }
        }
      }     
      
      if ((dtoE.getDtoTipoSolicitudLinea() != null) && (dtoE.getDtoTipoSolicitudLinea().length > 0)) {

  
        boolean create = false;
        for  (int i = 0; i < dtoE.getDtoTipoSolicitudLinea().length; i++) 
        {
          try {
              create = false;
              if (dtoE.getDtoTipoSolicitudLinea()[i].getOid() != null) {
                  tipoSolicitud = tipoSolicitudHome.findByPrimaryKey(dtoE.getDtoTipoSolicitudLinea()[i].getOid());
                  tipoSolicitud.setTspaOidTipoSoliPais(dtoE.getDtoTipoSolicitudLinea()[i].getTipoSolicitudPais());
                  try {
                      tipoSolicitudHome.merge(tipoSolicitud);
                  } catch (PersistenceException e) {
                      ctx.setRollbackOnly();
                      UtilidadesLog.error(e);
                      throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));            
                  }
              } else {
                  create = true;
              }
            
          }catch(NoResultException e) {
              create = true;
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e,UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          
          if (create) {
              try 
              {
                UtilidadesLog.debug("se crea Tipo Solicitud en el modificar");
                tipoSolicitud = tipoSolicitudHome.create(
                                  dtoE.getDtoTipoSolicitudLinea()[i].getTipoSolicitudPais(),
                                  lineaArmadoLocal.getOid());
               
              } catch (PersistenceException pe) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(pe);
                  throw new MareException(pe,UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }         
          }
        }
      }

 
      if ((dtoE.getDtoUsuarioAlarmaLineas() != null) && (dtoE.getDtoUsuarioAlarmaLineas().length > 0)) {
       
        for  (int i = 0; i < dtoE.getDtoUsuarioAlarmaLineas().length; i++) 
        {
  
          try {
              usuarios = usuarioHome.findByPrimaryKey(dtoE.getDtoUsuarioAlarmaLineas()[i].getOid());
              usuarios.setValMail(dtoE.getDtoUsuarioAlarmaLineas()[i].getEmail());
              
              try {
                  usuarioHome.merge(usuarios);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(e);
                  throw new MareException(e,UtilidadesError.armarCodigoError(
                      CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
            
          }catch(NoResultException e){
            try {
              usuarios = usuarioHome.create(dtoE.getDtoUsuarioAlarmaLineas()[i].getEmail(),lineaArmadoLocal.getOid());
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error(pe);
                    throw new MareException(pe,UtilidadesError.armarCodigoError(
                        CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
          } catch (PersistenceException pe) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(pe);
              throw new MareException(pe,UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        }       
      }
      
      if (dtoE.getOidsSolicitudEliminados().length > 0) 
      {
        Long oids[] = new DAOMantenimientoLineaSublinea().buscarSTLEliminar(dtoE.getOidsSolicitudEliminados(), dtoE.getDtoLineaArmado().getOid());

        for (int i = 0; i < oids.length; i++) 
        {
          try 
          {
            tipoSolicitud = tipoSolicitudHome.findByPrimaryKey(oids[i]);
            try {
                tipoSolicitudHome.remove(tipoSolicitud);
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error(e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
            }
          } catch (NoResultException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
        }
        
      }
      

      for (int i = 0; i < dtoE.getOidsUsuariosEliminados().length; i++) 
      {
        try 
        {
          usuarios = usuarioHome.findByPrimaryKey(dtoE.getOidsUsuariosEliminados()[i]);
          try {
            usuarioHome.remove(usuarios);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error(e);
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
      }
  }
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.insertarLineaArmado(DTOInsertarLineaArmado dtoE): Salida");  
    return dto;
  }

  public DTOSalida recuperarTiposSolicitudLinea(DTOOID dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarTiposSolicitudLinea(DTOOID dtoE): Entrada");
    DTOSalida dtoSalida = (new DAOMantenimientoLineaSublinea()).recuperarTiposSolicitudLinea(dtoE);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarTiposSolicitudLinea(DTOOID dtoE): Salida");
    return dtoSalida;
  }
  
  /** 
   * Autor: Cristian Valenzuela
   * Fecha: 13/2/2007
   */
    public DTOSalida obtenerLineasArmadoCDNoAFP(DTOOID dtoe) throws MareException {            
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCDNoAFP(DTOOID dtoE): Entrada");        
        DTOSalida dtoSalida = new DTOSalida();        
        DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
        dtoSalida = dao.obtenerLineasArmadoCDNoAFP(dtoe);        
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCDNoAFP(DTOOID dtoE): Salida");
        return dtoSalida;
    }
    
   /**
    * Consulta para cargar el combo de Lineas de Armado de tipo Fuera de Pedido.
    * @author eiraola
    * @date 23/02/2007
    */
    public DTOSalida obtenerLineasArmadoCDAFP(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCDAFP(DTOOID dtoE): Entrada");
        DTOSalida dtoSalida = new DTOSalida();
        dtoSalida = new DAOMantenimientoLineaSublinea().obtenerLineasArmadoCDAFP(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasArmadoCDAFP(DTOOID dtoE): Salida");
        return dtoSalida;
    }
    
  /**
   * Sistema: Belcorp
   * Módulo:  APE
   * Fecha:   13/02/2007
   * @version 1.00
   * @autor   Viviana Bongiovanni
   */
  public DTOSalida obtenerLineasMapaZona(DTOOID dtoe) throws MareException {
     UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasMapaZona(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerLineasMapaZona(dtoe);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerLineasMapaZona(DTOOID dtoe): Salida");
    return dtoSalida;
  }
  
  
  public void modificarLineaArmado(DTOInsertarLineaArmado dtoE) throws MareException
  {
  }
  
  private void eliminarUsuariosAlarmaLinea(DTOOIDs usuariosEliminados) throws MareException 
  {
    
  }
  
  private void eliminarTiposSolicitudLinea(DTOOID oidLinea, DTOOIDs oidTipoSolicitudEliminados) throws MareException 
  {
    
  }

  public DTOSalida obtenerUsuariosAlarmaLinea(DTOOID dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerUsuariosAlarmaLinea(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerUsuariosAlarmaLinea(dtoE);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerUsuariosAlarmaLinea(DTOOID dtoe): Salida");
    return dtoSalida;
  }

  public DTOSalida obtenerDescripcionesLineas(DTOBelcorp dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerUsuariosAlarmaLinea(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerDescripcionesLineas(dtoE);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerUsuariosAlarmaLinea(DTOOID dtoe): Salida");
    return dtoSalida;
  }

  public DTOSalida buscarLineasArmado(DTOBuscarLineasArmado dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarLineasArmado(DTOBuscarLineasArmado dtoe): Entrada");
    
    DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
    dtoLineaArmado.setOidPais(dtoE.getOidPais()); // 476
    dtoLineaArmado.setOidIdioma(dtoE.getOidIdioma()); // 476
    dtoLineaArmado.setTamanioPagina(dtoE.getTamanioPagina());
    dtoLineaArmado.setIndicadorSituacion(dtoE.getIndicadorSituacion());
    dtoLineaArmado.setDescripcion(dtoE.getDescripcion());
    dtoLineaArmado.setCodigoLinea(dtoE.getCodigoLinea());
    
    DTOConfiguracionCentroDistribucion dtoCD = new DTOConfiguracionCentroDistribucion();
    dtoCD.setDescripcion(dtoE.getDescripcionCD());
    dtoLineaArmado.setCentroDistribucion(dtoCD);    
    
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().buscarLineasArmado(dtoLineaArmado);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.buscarLineasArmado(DTOBuscarLineasArmado dtoe): Salida");
    return dtoSalida;
  }

  public void eliminarLineasArmado(DTOOIDs dtoE) throws MareException
  {
  
    Long[] oids = dtoE.getOids();
    
    for(int i = 0; i < oids.length; i++) 
    {
      try {
        
          
          DTOSalida lista = new DAOMantenimientoLineaSublinea().buscarTSLporLinea(oids[i]);
          RecordSet record = lista.getResultado();

          UtilidadesLog.info("resultado de buscarTSL " + record);
          UtilidadesLog.info("resultado de Booleano " + record.esVacio());

          if (!record.esVacio()) {
          
            for (int j = 0; j < record.getRowCount(); j++) {
              TipoSolicitudLineaLocalHome tipoSolicitudHome = new TipoSolicitudLineaLocalHome();
              
              UtilidadesLog.info("valor " + ((BigDecimal) record.getValueAt(j,0)));

              TipoSolicitudLineaLocal tipoSolicitud = tipoSolicitudHome.findByPrimaryKey(new Long(((BigDecimal) record.getValueAt(j,0)).toString()));
              try {
                tipoSolicitudHome.remove(tipoSolicitud);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
              }
            }
          }
          
          lista = new DAOMantenimientoLineaSublinea().buscarUALporLinea(oids[i]);
          record = lista.getResultado();

          UtilidadesLog.info("resultado de buscar " + record);
          UtilidadesLog.info("resultado de Booleano " + record.esVacio());
          
          if (!record.esVacio()) 
          {
            for (int j = 0; j < record.getRowCount(); j++) {
              UsuarioAlarmaLineaLocalHome usuarioHome = new UsuarioAlarmaLineaLocalHome();

              UtilidadesLog.info("valor " + ((BigDecimal) record.getValueAt(j,0)));

              UsuarioAlarmaLineaLocal usuario = usuarioHome.findByPrimaryKey(new Long(((BigDecimal) record.getValueAt(j,0)).toString()));
              try {
                usuarioHome.remove(usuario);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error(e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
              }
            }
            
          }

          LineaArmadoLocalHome lineaHome = new LineaArmadoLocalHome();
          LineaArmadoLocal linea = null;
          
          linea = lineaHome.findByPrimaryKey(oids[i]);
          try {
            lineaHome.remove(linea);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error(e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
          
          Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
          Collection col = e18nLH.findByEntAtrPK("APE_LINEA_ARMAD", new Long(1), oids[i]);
          Iterator it = col.iterator();

          UtilidadesLog.info("Datos para eliminar traduccion " + col);  
          UtilidadesLog.info("Datos para eliminar traduccion " + it);  
          
          try {
              while (it.hasNext()){
                Entidadi18nLocal e18nLocal= (Entidadi18nLocal)it.next();
                UtilidadesLog.info("traduccion " + e18nLocal);
                e18nLH.remove(e18nLocal);
              }          
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
        
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_ELIMINAR_NO_EXISTE));
      } catch (PersistenceException e) {            
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
    }
  }

  public DTOSalida obtenerTiposSolicitudLinea(DTOOID dtoE) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerTiposSolicitudLinea(DTOOID dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoLineaSublinea().obtenerTiposSolicitudLinea(dtoE);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.obtenerTiposSolicitudLinea(DTOOID dtoe): Salida");
    return dtoSalida;
  }
  
   /** 
   * Autor: Cristian Valenzuela
   * Fecha: 01/06/2007
   */
    public DTOSalida recuperarSublineasLinea(DTOOID dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLinea"+
        "(DTOOID dtoe): Entrada");
        DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
        DTOSalida dtoSalida = dao.recuperarSublineasLinea(dtoe);
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLinea"+
        "(DTOOID dtoe): Salida");
        return dtoSalida;
    }

  public DTOSalida consultaCodigosImpresora(DTOBelcorp dtoe) throws MareException
  {
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.consultaCodigosImpresora Entrada");
        DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
        DTOSalida dtoSalida = dao.consultaCodigosImpresora();
        UtilidadesLog.info("MONMantenimientoLineaSublineaBean.consultaCodigosImpresora Salida");
        return dtoSalida;
  }
  
  /** 
   * Autor: vbongiov
   * Fecha: 30/08/2007
   */
  public DTOSalida recuperarSublineasLineaBalanceo(DTOSublineasLineaOrdenacion dtoe) throws MareException {
      UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLineaBalanceo(DTOSublineasLineaOrdenacion dtoe): Entrada");
      DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
      DTOSalida dtoSalida = dao.recuperarSublineasLineaBalanceo(dtoe);
      UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLineaBalanceo(DTOSublineasLineaOrdenacion dtoe): Salida");
      return dtoSalida;
  }

  public DTOSalida recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe): Entrada");
    DAOMantenimientoLineaSublinea dao = new DAOMantenimientoLineaSublinea();
    DTOSalida dtoSalida = dao.recuperarSublineasLineaOrdenacion(dtoe);
    UtilidadesLog.info("MONMantenimientoLineaSublineaBean.recuperarSublineasLineaOrdenacion(DTOSublineasLineaOrdenacion dtoe): Salida");
    return dtoSalida;
  }
}