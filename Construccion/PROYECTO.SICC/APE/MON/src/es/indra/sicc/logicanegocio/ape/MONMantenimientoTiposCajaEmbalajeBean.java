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
 */
package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.entidades.ape.LineaArmadoLocal;
import es.indra.sicc.entidades.ape.LineaArmadoLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.ape.DTOTiposCajaEmbalaje;
import es.indra.sicc.entidades.ape.TiposCajaEmbalajeLocal;
import es.indra.sicc.entidades.ape.TiposCajaEmbalajeLocalHome;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoTiposCajaEmbalajeBean implements SessionBean  {

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
    * Autor: hhernandez
    * Fecha: 21-02-2007
    * Descripcion:  Si se ha seleccionado previamente una entidad TiposCajaEmbalaje, la actualiza, sino crea una nueva entidad TiposCajaEmbalaje 
    * @return Long ; Oid recién creado o actualizado
    * @exception MareException 
    */    
  public Long actualizarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE) throws MareException {
    Long oid=null;
    UtilidadesLog.debug("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoe): Entrada");
    try {
      TiposCajaEmbalajeLocalHome tceLH = new TiposCajaEmbalajeLocalHome();
      TiposCajaEmbalajeLocal tceL = null;

      if(dtoE.getOid() ==null){ // insertar
        UtilidadesLog.debug("Por insertar...");
        tceL = tceLH.create(dtoE.getTipoCaja(),new Double(dtoE.getCapacidad().doubleValue()), new Double(dtoE.getCapacidadMinima().doubleValue()), (dtoE.getIndicadorCubicaje().booleanValue())?"1":"0", new Double(dtoE.getPorcentajeSeguridad().doubleValue()),new Double(dtoE.getNivelAplicacion().doubleValue()), dtoE.getNumeroEtiquetas(),new Double(dtoE.getAlto().doubleValue()), new Double(dtoE.getLargo().doubleValue()),new Double(dtoE.getAncho().doubleValue()), dtoE.getOidPais() , dtoE.getOidUnidadMedidaCapacidad(), dtoE.getOidUnidadMedidaExterior());
        // Descripcion   

          Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
          for (int i=0; i<dtoE.getVectorConTraducciones().size(); i++){	
            DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dtoE.getVectorConTraducciones ().elementAt(i); //devuelve los datos de la traducción
            Long oidIdioma = dtoTraduccion.getOidIdioma();
            String descripcion = dtoTraduccion.getValorI18n();
            try {
                e18nLH.create("APE_TIPO_CAJA_EMBAL", new Long(1), oidIdioma, descripcion, tceL.getOid());    
            } catch (PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            }
          }
        
        oid = tceL.getOid();
      }
      else{ // actualizar
        UtilidadesLog.debug("Por actualizar...");
        tceL = tceLH.findByPrimaryKey(dtoE.getOid());
        if(tceL.getOid()!=null){
          //Actualizando datos de TipoCajaEmbalaje
          //tceL.setFactorConversion(dtoe.getFactorConversion());
          tceL.setValTipoCaja(dtoE.getTipoCaja());
          tceL.setNumCapa(new Double(dtoE.getCapacidad().doubleValue()));
          tceL.setNumCapaMini(new Double(dtoE.getCapacidadMinima().doubleValue()));
          tceL.setIndCubi((dtoE.getIndicadorCubicaje().booleanValue())?"1":"0");
          tceL.setNumPorcSegu(new Double(dtoE.getPorcentajeSeguridad().doubleValue()));
          tceL.setNumNiveApli(new Double(dtoE.getNivelAplicacion().doubleValue()));
          tceL.setNumEtiq(dtoE.getNumeroEtiquetas());
          tceL.setValAlto(new Double(dtoE.getAlto().doubleValue()));
          tceL.setValLarg(new Double(dtoE.getLargo().doubleValue()));
          tceL.setValAnch(new Double(dtoE.getAncho().doubleValue()));
          tceL.setPaisOidPais(dtoE.getOidPais());
          tceL.setUnmdOidUnidMediCapa(dtoE.getOidUnidadMedidaCapacidad());
          tceL.setUnmdOidUnidMediExte(dtoE.getOidUnidadMedidaExterior());
          
          try {
              tceLH.merge(tceL);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
          
          //Actualizando descripcion de TipoCajaEMbalaje
          /*Entidadi18nLocal entidadi18n = entidadi18nLocalHome.findByEntAtrIdioPK("APE_TIPO_CAJA_EMBAL", new Long(1), dtoE.getOidIdioma(), dtoE.getOid());
          entidadi18n.setDetalle(dtoE.getDescripcion());*/
          Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
          for (int i=0;i< dtoE.getVectorConTraducciones ().size();i++){
              DTOI18nSICC dtoTraduccion = (DTOI18nSICC)dtoE.getVectorConTraducciones().elementAt(i); //devuelve los datos de la traducción
              Long oidIdioma = dtoTraduccion.getOidIdioma();
              String descripcion = dtoTraduccion.getValorI18n();
              try{
                Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "APE_TIPO_CAJA_EMBAL", new Long(1) ,oidIdioma, dtoE.getOid());
                e18nL.setDetalle(descripcion);
                try {
                    e18nLH.merge(e18nL);
                } catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", e);
                    throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
              }catch(NoResultException e){
                System.out.println("No se encontro la descripcion para ese idioma, vamos a crearlo");
                try {
                    e18nLH.create("APE_TIPO_CAJA_EMBAL ", new Long(1),oidIdioma,descripcion, dtoE.getOid());
                } catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("ERROR ", pe);
                    throw new MareException(pe, 
                    UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                }
              } catch (PersistenceException e) {
                  ctx.setRollbackOnly();
                  UtilidadesLog.error("ERROR ", e);
                  throw new MareException(e, 
                  UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
              }
          }
          
          oid = dtoE.getOid();
        }
        else{
          //COMO NO EXISTE SE LANZA UN ERROR
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR NO ENCONTRO OID");
          oid =  dtoE.getOid();      
        }
      }
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }    
    UtilidadesLog.debug("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoe): Salida");
    return oid;
  }

  /** 
    * Autor: hhernandez
    * Fecha: 21-02-2007
    * Descripcion:  Inserta un registro en la entidad TiposCajaEmbalaje, y actualiza los registros de LineasTiposCajaEmbalaje
    * @return void
    * @exception MareException 
    */    
  public void actualizarTiposCajaEmbalajeLineas (DTOTiposCajaEmbalaje dtoE) throws MareException { 
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalajeLineas(DTOTiposCajaEmbalaje dtoE): Entrada");
    Long oid = actualizarTiposCajaEmbalaje(dtoE);
    UtilidadesLog.info("dtoE.getLineasArmadoInsertadas():" + dtoE.getLineasArmadoInsertadas());
    if(dtoE.getLineasArmadoInsertadas()!=null){
      UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalajeLineas(DTOTiposCajaEmbalaje dtoE): insertarLineasTiposCajaEmbalaje");
      new DAOTiposCajaEmbalaje().insertarLineasTiposCajaEmbalaje(oid,dtoE.getLineasArmadoInsertadas());
    }
    UtilidadesLog.info("dtoE.getLineasArmadoEliminadas():" + dtoE.getLineasArmadoEliminadas());
    if(dtoE.getLineasArmadoEliminadas()!=null){
      UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalajeLineas(DTOTiposCajaEmbalaje dtoE): eliminarLineasTiposCajaEmbalaje");
      new DAOTiposCajaEmbalaje().eliminarLineasTiposCajaEmbalaje(oid,dtoE.getLineasArmadoEliminadas());
    }
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.actualizarTiposCajaEmbalajeLineas(DTOTiposCajaEmbalaje dtoE): Salida");
  }
  
 /** 
    * Autor: hhernandez
    * Fecha: 21-02-2007
    * Descripcion: Obtiene las entidades TiposCajaEmbalaje que coincidan con los parámetros de la búsqueda 
    * @return void
    * @exception MareException 
    */    
 public DTOSalida buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoe): Entrada");
    DTOSalida dtoSalida = new DAOTiposCajaEmbalaje().buscarTiposCajaEmbalaje(dtoE);
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.buscarTiposCajaEmbalaje(DTOTiposCajaEmbalaje dtoe): Salida");
    return dtoSalida;
  }    

 /** 
    * Autor: hhernandez
    * Fecha: 21-02-2007
    * Descripcion: Obtiene la entidad TiposCajaEmbalaje previamente seleccionada  
    * @return void
    * @exception MareException 
    */    
 public DTOTiposCajaEmbalaje obtenerTiposCajaEmbalaje (DTOOID dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.obtenerTiposCajaEmbalaje(DTOOID dtoe): Entrada");
    DAOTiposCajaEmbalaje daoTCE=new DAOTiposCajaEmbalaje();
    DTOTiposCajaEmbalaje dtoTCE = daoTCE.obtenerTiposCajaEmbalaje(dtoE);
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.obtenerTiposCajaEmbalaje(DTOOID dtoe): Llamar a obtenerLineasTipoCajaEmbalaje(dtoE)");
    DTOOIDs lineasTipoCaja = daoTCE.obtenerLineasTipoCajaEmbalaje(dtoE);
    UtilidadesLog.info("ObtenerTiposCajaEmbalaje: lineasTipoCaja:" + lineasTipoCaja);
    dtoTCE.setLineasArmadoInsertadas(lineasTipoCaja);
    
    if(lineasTipoCaja!=null){
      UtilidadesLog.info("ObtenerTiposCajaEmbalaje: lineasTipoCaja.getOids().length:" + lineasTipoCaja.getOids().length);
      if(lineasTipoCaja.getOids().length>0){
         LineaArmadoLocal laL = null;
         try{
           UtilidadesLog.info("ObtenerTiposCajaEmbalaje: antes de getLocalHome");
           LineaArmadoLocalHome laLH = new LineaArmadoLocalHome();
           UtilidadesLog.info("ObtenerTiposCajaEmbalaje: lineasTipoCaja.getOids()[0]:" + lineasTipoCaja.getOids()[0]);
           laL = laLH.findByPrimaryKey(lineasTipoCaja.getOids()[0]);//Se busca con el primer elemento 
         } catch (NoResultException e){
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
          } catch (PersistenceException e){
               ctx.setRollbackOnly();
               UtilidadesLog.error("ERROR ", e);
               throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
          }
          UtilidadesLog.info("ObtenerTiposCajaEmbalaje: laL.getConfiguracionCentroDistribucion():" + laL.getConfiguracionCentroDistribucion());
          //Se recupera ConfiguracionCentroDistribucion
          dtoTCE.setCentroDistribucion(laL.getConfiguracionCentroDistribucion());
      }
    }
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.obtenerTiposCajaEmbalaje(DTOOID dtoe): Salida");
    return dtoTCE;
  }
 
  /** 
    * Autor: hhernandez
    * Fecha: 21-02-2007
    * Descripcion: Se eliminan las entidades TiposCajaEmbalaje cuyos oids se reciben como parametros de entrada 
    * @return void
    * @exception MareException 
    */    
 public void eliminarTiposCajaEmbalaje(DTOOIDs dtoE) throws MareException {
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): Entrada");
    new DAOTiposCajaEmbalaje().eliminarTiposCajaEmbalaje(dtoE);
    /*Internacionalización*/
    try{
      Long[] oids = dtoE.getOids();
      for(int i=0;i<oids.length;i++){
        Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
        Collection col = e18nLH.findByEntAtrPK("APE_TIPO_CAJA_EMBAL", new Long(1), oids[i]);
        Iterator it = col.iterator();
        try {
            while (it.hasNext()){
                 Entidadi18nLocal e18nLocal= (Entidadi18nLocal)it.next();
                 e18nLH.remove(e18nLocal);
            }
        } catch (PersistenceException e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("ERROR ", e);
            throw new MareException(e, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
        }
      }
    }catch (NoResultException e){
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    }catch (PersistenceException e){
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, 
              UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
    }
    UtilidadesLog.info("MONMantenimientoTiposCajaEmbalajeBean.eliminarTiposCajaEmbalaje(DTOOIDs dtoE): Salida");
  }     
  
}