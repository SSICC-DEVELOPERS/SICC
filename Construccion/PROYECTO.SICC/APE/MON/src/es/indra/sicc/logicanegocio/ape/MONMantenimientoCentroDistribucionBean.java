/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
import es.indra.sicc.cmn.negocio.i18n.MONI18n;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.entidades.app.ConfiguracionCentroDistribucionLocal;
import es.indra.sicc.entidades.app.ConfiguracionCentroDistribucionLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CMNEjbLocators;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.ExcepcionParametrizada;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOBoolean;
import javax.persistence.EntityExistsException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoCentroDistribucionBean implements SessionBean 
{

  private SessionContext ctx;
  
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  { this.ctx = ctx; }
  
  /**
   * Implementa la insercion/modificacion en la entidad APE ConfiguracionCentroDistribucion
   * @author cdiglesias
   * @since 08/01/2007
   * @observaciones
   *     BELC400000198 - dmorello - 06/03/2007 (agrega descr. del CD por default existente)
   *     BELC400000355 - ciglesias (se quita el campo indImprListaPicad)
   *     BELC400000417 - eiraola - 22/05/2007 (cambio APE-009)
   *     BELC400000478 - gpons - 30/05/2007  (Cambio tipo de dato)                  
   */
  public void guardarConfiguracionCD(DTOConfiguracionCentroDistribucion dtoE) throws  
          RemoteException, MareException {
      UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.guardarConfiguracionCD(): Entrada");  
      
      UtilidadesLog.debug(" *** Datos recibidos del CD a guardar: " + dtoE);
      
      try {
          
          if (dtoE.getValorDefecto().booleanValue()) { // Si el CD esta marcado para ser el default
              DAOMantenimientoCentroDistribucion daoCD = new DAOMantenimientoCentroDistribucion();
              
              // Se recuperara tambien la descripción del CD por defecto para enviarla
              // en la excepcion.
              RecordSet rsDefault = daoCD.obtenerCentrosDistribucionXDefectoMasDescripcion(dtoE);
              Long oidDefault = null;
              String descripcion = null;
              
              if (!rsDefault.esVacio()) {
                  oidDefault = new Long(((BigDecimal)rsDefault.getValueAt(0, "OID_CONF_CENT_DIST")).longValue());
                  descripcion = rsDefault.getValueAt(0, "VAL_I18N").toString();
              }
              UtilidadesLog.debug(" *** Recuperado acerca del CD default: " + oidDefault + "/" + descripcion);
          
              if ( (oidDefault != null) && ((dtoE.getOidCentroDistribucion() == null) 
                          || (dtoE.getOidCentroDistribucion().compareTo(oidDefault) != 0)) ) {
                  // Error APE-0001: Ya existe un CD por defecto para el país. Centro de distribución {0}
                  UtilidadesLog.debug(" --- Ya existe un cd default para el pais: " + descripcion);
                  ExcepcionParametrizada exPar;
                  exPar = new ExcepcionParametrizada(new Exception(), UtilidadesError.armarCodigoError(
                          ConstantesSEG.MODULO_APE, "", ErroresDeNegocio.APE_0001));
                  exPar.setPosicion(ExcepcionParametrizada.POSICION_FINAL);
                  exPar.addParameter(descripcion);
                  throw exPar;
              }
          } // fin si valorDefecto == true
          
          
          ConfiguracionCentroDistribucionLocalHome centroDistribucionHome = new ConfiguracionCentroDistribucionLocalHome();
          ConfiguracionCentroDistribucionLocal centroDistribucionLocal = null;
          
          MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
          UtilidadesLog.debug(" --- Gestor de descripciones i18n 'encontrado'");
          
                    
          if (dtoE.getOidCentroDistribucion() == null) { // Insertar
              try {
                  UtilidadesLog.debug("    *** Insercion de nueva ConfiguracionCD");
                  // vbongiov -- 26/08/2008
                  //Campos agregados por cambio 20090839,  dtoE.getImpresionDatosbasicos(), dtoE.getOidOredenVisulaChequeo(), dtoE.getOredenVisual()
                  
                  centroDistribucionLocal = centroDistribucionHome.create(
                                                        dtoE.getOidPais(),
                                                        new Long(dtoE.getNivelOutsourcing()),
                                                        dtoE.getOrdenAscDesc(),
                                                        dtoE.getOrdenPedidoPicado(),
                                                        dtoE.getAgrupacionDefaultAFP(), dtoE.getImpresionDatosbasicos(),
                                                        dtoE.getOidOredenVisulaChequeo(), dtoE.getOredenVisual() ); // Asc o Desc
                                                        
                  UtilidadesLog.debug("    *** luego de crear la entidad (solo con Not Nulls)");
                  
                  if (dtoE.getValorDefecto().booleanValue()) { // Verdadero
                      centroDistribucionLocal.setValorDefecto("S");
                  } else { // Falso
                      centroDistribucionLocal.setValorDefecto("N");
                  }
                  
                  centroDistribucionLocal.setTextoChequeos(dtoE.getTextoChequeos());
                  centroDistribucionLocal.setTextoPrimerPedido(dtoE.getTextoPrimerPedido());
                  
                  centroDistribucionHome.merge(centroDistribucionLocal);
                  
                  // Internacionalizacion de la descripcion
                  UtilidadesLog.debug("...insertando Descripcion internacionalizable");
                  i18n.insertarTraducciones("APP_CONFI_CENTR_DISTR", 
                                            centroDistribucionLocal.getOid(), 
                                            dtoE.getAttTraducible());
                  
              } catch(EntityExistsException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("guardarConfiguracionCD EntityExistsException: ", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_INTEGRIDAD_INSERCION));
              } catch(PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("guardarConfiguracionCD PersistenceException: ", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
          } else { // Modificar
              try {
                  centroDistribucionLocal = centroDistribucionHome.findByPrimaryKey(dtoE.getOidCentroDistribucion());
              } catch (NoResultException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("guardarConfiguracionCD NoResultException: ", e);
                  throw new MareException(e,UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));            
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("guardarConfiguracionCD PersistenceException: ", e);
                  throw new MareException(e,UtilidadesError.armarCodigoError(
                          CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));            
              }
              
              centroDistribucionLocal.setNivelOutsourcing(new Long(dtoE.getNivelOutsourcing()));
              
              if (dtoE.getValorDefecto().booleanValue()) {
                  centroDistribucionLocal.setValorDefecto("S");
              } else {
                  centroDistribucionLocal.setValorDefecto("N");
              }
              centroDistribucionLocal.setOrdenListaPicado(dtoE.getOrdenPedidoPicado());
              centroDistribucionLocal.setOrdenAscDesc(dtoE.getOrdenAscDesc());
              centroDistribucionLocal.setTextoChequeos(dtoE.getTextoChequeos());
              centroDistribucionLocal.setTextoPrimerPedido(dtoE.getTextoPrimerPedido());
              centroDistribucionLocal.setAgrupacionDefaultAFP(dtoE.getAgrupacionDefaultAFP());
              //Campos agregados por cambio 20090839
              centroDistribucionLocal.setImpresionDatosBasicos(dtoE.getImpresionDatosbasicos());
              centroDistribucionLocal.setOidOredenVisualChequeo(dtoE.getOidOredenVisulaChequeo());
              centroDistribucionLocal.setOrdenVisualChequeo(dtoE.getOredenVisual());
              
              try {
                  centroDistribucionHome.merge(centroDistribucionLocal);
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("Error al hacer merge en CentroDistribucion: ", e);
                  throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
              }
              
              // Internacionalizacion de la descripcion
              UtilidadesLog.debug("...actualizando Descripcion internacionalizable");
              i18n.actualizaTraducciones("APP_CONFI_CENTR_DISTR", 
                                         centroDistribucionLocal.getOid(),
                                         dtoE.getAttTraducible());
          } // fin else (modificar)
        
      } catch (Exception e) {
          UtilidadesLog.error(" ERROR al guardarConfiguracionCD ");
          ctx.setRollbackOnly();
          throw new MareException(e);
      }
      
      UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.guardarConfiguracionCD(): Salida");
  }


  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dtoE DTOConfiguracionCentroDistribucion 
   * @author cdiglesias
   * @since 08-01-2007
   */
  public DTOSalida buscarCentroDistribucion(DTOConfiguracionCentroDistribucion dtoE) throws  RemoteException, MareException
  {
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.buscarCentroDistribucion():Entrada");  
    DAOMantenimientoCentroDistribucion daoCD = new DAOMantenimientoCentroDistribucion();
    DTOSalida retorno = daoCD.buscarCentroDistribucion(dtoE);
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.buscarCentroDistribucion():Salida");  
    return retorno;
 }

  /**
   * Elimina registros de la Entidad APE:ConfiguracionCentroDistribucion
   * @author cdiglesias
   * @since 08/01/2007
   * @observaciones
   *     BELC400000417 - eiraola - 23/05/2007 (cambio APE-009)
   */
  public void eliminarCentroDistribucion(DTOOIDs dtoOids) throws MareException {
      UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.eliminarCentroDistribucion(dtoOids): Entrada");
      try {
          MONI18n i18n = CMNEjbLocators.getMONI18nHome().create();
          Long[] oids = dtoOids.getOids();
          UtilidadesLog.info(" *** Oids de ConfigCDs a eliminar: " + dtoOids);
          
          ConfiguracionCentroDistribucionLocalHome centroDistribucionHome = new ConfiguracionCentroDistribucionLocalHome();
          ConfiguracionCentroDistribucionLocal centroDistribucionLocal = null;
          
          try {
              for (int i = 0; i < oids.length; i++) {
                  UtilidadesLog.debug(" ...eliminando Entidad ConfiguracionCD: " + oids[i]);
                  centroDistribucionLocal = centroDistribucionHome.findByPrimaryKey(oids[i]);
                  centroDistribucionHome.remove(centroDistribucionLocal);
                  
                  UtilidadesLog.debug(" ...eliminando Descripcion internacionalizable");
                  i18n.eliminarTraducciones("APP_CONFI_CENTR_DISTR", oids[i]);
              } // fin for
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("Error al eliminar de CentroDistribucion: ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
          }
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_ELIMINAR_NO_EXISTE));
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          throw new MareException(e, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      } catch (CreateException ce) {
          throw new MareException(ce, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
      } catch (RemoteException re) {
          throw new MareException(re, UtilidadesError.armarCodigoError(
                  CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
      }
      UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.eliminarCentroDistribucion(dtoOids): Entrada");
  }

  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dtoE DTOBelcorp
   * @author cdiglesias
   * @since 08-01-2007
   */
  public DTOSalida obtenerNivelesOutSourcing(DTOBelcorp dtoE) throws  RemoteException, MareException
  {
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerNivelesOutSourcing():Entrada");  
    
    DAOMantenimientoCentroDistribucion daoCD = new DAOMantenimientoCentroDistribucion();
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerNivelesOutSourcing():Salida");    
    return daoCD.obtenerNivelesOutSourcing(dtoE);
  }

  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dtoE DTOBelcorp
   * @author cdiglesias
   * @since 08-01-2007
   */
  public DTOSalida obtenerCodigoCentrosDistribucion(DTOBelcorp dtoE) throws  RemoteException, MareException
  {
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCodigoCentrosDistribucion():Entrada");  
    
    DAOMantenimientoCentroDistribucion daoCD = new DAOMantenimientoCentroDistribucion();
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCodigoCentrosDistribucion():Salida");    
    return daoCD.obtenerCodigoCentrosDistribucion(dtoE);
  }

  /**
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param dtoE DTOBelcorp
   * @author cdiglesias
   * @since 08-01-2007
   */
  public DTOSalida obtenerDescripcionesCD(DTOBelcorp dtoE) throws  RemoteException, MareException
  {
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerDescripcionesCD():Entrada");  
    
    DAOMantenimientoCentroDistribucion daoCD = new DAOMantenimientoCentroDistribucion();
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerDescripcionesCD():Salida");    
    return daoCD.obtenerDescripcionesCD(dtoE);
  }

  public DTOSalida obtenerValoresDefecto(DTOBelcorp dtoe) throws MareException
  {
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerValoresDefecto(DTOBelcorp dtoe): Entrada");
    DTOSalida dtoSalida = new DAOMantenimientoCentroDistribucion().obtenerValoresDefecto(dtoe);
    UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerValoresDefecto(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }


    /** 
     * Autor: Cristian Valenzuela
     * Fecha: 18/1/2007
     */
    public DTOOID obtenerCentrosDistribucionXDefecto(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCentrosDistribucionXDefecto"+
       "(DTOBelcorp dtoe): Entrada");              
       DAOMantenimientoCentroDistribucion dao = new DAOMantenimientoCentroDistribucion();
       DTOOID dtoOid = new DTOOID();       
       dtoOid= dao.obtenerCentrosDistribucionXDefecto(dtoe);       
       UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCentrosDistribucionXDefecto"+
       "(DTOBelcorp dtoe): Salida");
       return dtoOid;
    }

    /**
     * Recupera el oid y las descripciones de las Agrupaciones default para AFP.
     * @autor eiraola
     * @since 18/05/2007
     */
    public DTOSalida obtenerAgrupacionAFP(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerAgrupacionAFP" + 
                          "(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoCentroDistribucion().obtenerAgrupacionAFP(dtoe);
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerAgrupacionAFP" + 
                          "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
     * Recupera el oid y las descripciones de los tipos de orden lista picado.
     * @autor eiraola
     * @since 18/05/2007
     */
    public DTOSalida obtenerOrdenListaPicado(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerOrdenListaPicado" + 
                           "(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoCentroDistribucion().obtenerOrdenListaPicado(dtoe);
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerOrdenListaPicado" + 
                           "(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }

    /**
     * @descripcion Valida la existencia de un territorio
     * @autor gpons
     * @since 04/10/2007
     */
    public DTOBoolean validarTerritorio(DTOOID dto) throws MareException
    {
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.validaTerritorio(DTOOID dto):Entrada");
        StringBuffer query = new StringBuffer();
        RecordSet rs = new RecordSet(); 
        DTOBoolean dtoB = new DTOBoolean();
        BelcorpService bs = UtilidadesEJB.getBelcorpService();
        
        Long oid = dto.getOid();
		query.append(" SELECT terr.cod_terr ");
        query.append(" FROM zon_terri terr ");
        query.append(" WHERE terr.cod_terr = " + oid);
            
        try {
           rs = (RecordSet) bs.dbService.executeStaticQuery(query.toString());    
        } catch (Exception e) {
             UtilidadesLog.error(e);
             throw new MareException(e, UtilidadesError.armarCodigoError(
                 CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }

	    if (rs.esVacio()){
            dtoB.setValor(true);
        }else{
           dtoB.setValor(false);
        }
             
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.validaTerritorio(DTOOID dto):Salida");
        return dtoB;
    }

    public DTOSalida obtenerCodigoVisualizacionChequeo(DTOBelcorp dtoe) throws MareException {
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCodigoVisualizacionChequeo(DTOBelcorp dtoe): Entrada");
        DTOSalida dtoSalida = new DAOMantenimientoCentroDistribucion().codigoVisualizacionCheque(dtoe);
        UtilidadesLog.info("MONMantenimientoCentroDistribucionBean.obtenerCodigoVisualizacionChequeo(DTOBelcorp dtoe): Salida");
        return dtoSalida;
    }
}
