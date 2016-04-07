package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ape.DTOFactoresConversion;
import es.indra.sicc.entidades.ape.FactoresConversionLocal;
import es.indra.sicc.entidades.ape.FactoresConversionLocalHome;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

/**
 * @author Rafael Romero
 * @date 14/02/2007
 */
public class MONMantenimientoFactoresConversionBean implements SessionBean  {

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

  public void actualizarFactoresConversion(DTOFactoresConversion dtoe) throws MareException {
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): Entrada");
    FactoresConversionLocalHome fcLH = new FactoresConversionLocalHome();
    if(dtoe.getOidFactoresConversion()==null){ // insertar
      UtilidadesLog.debug("Por insertar...");
      UtilidadesLog.debug("factor["+dtoe.getFactorConversion()+"], magnitud["+dtoe.getOidMagnitud()+"], origen["+dtoe.getOidUnidadMedidaOrigen()+"], destino["+dtoe.getOidUnidadMedidaDestino()+"]");
      try {
        fcLH.create(dtoe.getFactorConversion(),dtoe.getOidMagnitud(),dtoe.getOidUnidadMedidaOrigen(),dtoe.getOidUnidadMedidaDestino());
      } catch (PersistenceException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): PersistenceException: " + e.getMessage());
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
    }else{ // actualizar
      UtilidadesLog.debug("Por actualizar...");
      FactoresConversionLocal fcl = null;
      try {
        fcl = fcLH.findByPrimaryKey(dtoe.getOidFactoresConversion());
      } catch (NoResultException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): NoResultException: " + e.getMessage());
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (PersistenceException e) {
        ctx.setRollbackOnly();
        UtilidadesLog.error("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): PersistenceException: " + e.getMessage());
        UtilidadesLog.error(e);
        throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
      
      fcl.setFactorConversion(dtoe.getFactorConversion());
      try {
          fcLH.merge(fcl);
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): FinderException: " + e.getMessage());
          UtilidadesLog.error(e);
          throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
    }
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.actualizarFactoresConversion(DTOFactoresConversion dtoe): Salida");
  }

  public DTOSalida buscarFactoresConversion(DTOFactoresConversion dtoe) throws MareException {
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.buscarFactoresConversion(DTOFactoresConversion dtoe): Entrada");  
    DAOFactoresConversion daoFacConv = new DAOFactoresConversion();
    RecordSet rs = daoFacConv.buscarFactoresConversion(dtoe);
    DTOSalida dtoSalida=new DTOSalida(rs);
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.buscarFactoresConversion(DTOFactoresConversion dtoe): Salida");
    return dtoSalida;
  }

  public void eliminarFactoresConversion(DTOOIDs dtoe) throws MareException {
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.eliminarFactoresConversion(DTOOIDs dtoe): Entrada");  
    DAOFactoresConversion daoFacConv = new DAOFactoresConversion();
    daoFacConv.eliminarFactoresConversion(dtoe);
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.eliminarFactoresConversion(DTOOIDs dtoe): Salida");
  }

  public DTOSalida obtenerMagnitudes(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.obtenerMagnitudes(DTOBelcorp dtoe): Entrada");  
    DAOFactoresConversion daoFacConv = new DAOFactoresConversion();
    DTOSalida dtoSalida = daoFacConv.obtenerMagnitudes(dtoe);
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.obtenerMagnitudes(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }

  public DTOSalida otenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Entrada");  
    DAOFactoresConversion daoFacConv = new DAOFactoresConversion();
    DTOSalida dtoSalida = daoFacConv.obtenerUnidadesMedidaPorMagnitud(dtoe);
    UtilidadesLog.debug("MONMantenimientoFactoresConversionBean.obtenerUnidadesMedidaPorMagnitud(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }
}