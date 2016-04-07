package es.indra.sicc.logicanegocio.rec;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.rec.DTOAutorizacion;
import es.indra.sicc.entidades.rec.AutorizacionesLocal;
import es.indra.sicc.entidades.rec.AutorizacionesLocalHome;
import es.indra.sicc.entidades.rec.TiposOperacionLocal;
import es.indra.sicc.entidades.rec.TiposOperacionLocalHome;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOSalida;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAutorizacionBean implements SessionBean 
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
  {
       this.ctx = ctx;
  }
      

  public void actualizarAutorizacion(DTOAutorizacion dtoe) throws MareException {
  UtilidadesLog.debug("MONAutorizacion.actualizarAutorizacion(DTOAutorizacion dtoe):Entrada");
/*  Descripción: Si se ha seleccionado previamente una entidad Autorizacion, la actualiza, sino crea una nueva entidad Autorizacion. 
        Implementación: 
        Si DTOE.oid == null //es una Autorizacion nueva 
        { 
        Crear un registro nuevo en la entidad Autorizacion : autorizacion. 
        
        autorizacion.oid = secuencial 
        autorizacion.idUsuario = DTOE.oidUsiario 
        autorizacion.pais = DTOE.oidPais 
        autorizacion.tipoOperacion = DTOE.oidTipoOperacion 
        } 
        en otro caso //es una modificacion 
        { 
        autorizacion = llamar al método findByPrimaryKey(DTOE.oid) de la entidad Autorizacion 
        } 
        
        autorizacion.importeMaximo = DTOE.importeMaximo 
        autorizacion.montoMaximoDiferencia = DTOE.montoMaximoDiferencia 
        autorizacion.ingreso = DTOE.ingreso 
        autorizacion.desbloqueo = DTOE.desbloqueo
  */
    UtilidadesLog.debug("DTOAutorizacion recibido: " + dtoe);
  
      AutorizacionesLocalHome autorizacionesNuevaLocalHome = new AutorizacionesLocalHome();                          
        AutorizacionesLocal autorizacionesLocal;
      if (dtoe.getOid() == null){    
         try{
             autorizacionesLocal = autorizacionesNuevaLocalHome.create(Integer.valueOf((dtoe.getOidUsuario()).toString()),
                                    dtoe.getOidPais(),dtoe.getOidTipoOperacion());
            } catch (PersistenceException e) {
                    UtilidadesLog.error("actualizarCuenta: CreateException:grabarCabeceraReclamo",e);
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
            }       
      }else {
            try{
                autorizacionesLocal = autorizacionesNuevaLocalHome.findByPrimaryKey(dtoe.getOid());
               } catch(NoResultException fe){
                 UtilidadesLog.error("MONAutorizaciones.actualizarAutorizacion(DTOAutorizacion dtoe): FinderException", fe);
                 String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                 ctx.setRollbackOnly();
                 throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
           }  catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }        
      }
      autorizacionesLocal.setImporteMaximo(dtoe.getImporteMaximo());
      autorizacionesLocal.setMontoMaximoDiferencia(dtoe.getMontoMaximoDiferencia());
      autorizacionesLocal.setIngreso(dtoe.getIngreso());
      autorizacionesLocal.setDesbloqueo(dtoe.getDesbloqueo());
      autorizacionesNuevaLocalHome.merge(autorizacionesLocal); 
  UtilidadesLog.debug("MONAutorizacion.actualizarAutorizacion(DTOAutorizacion dtoe):Salida");
  }

  public DTOSalida buscarAutorizaciones(DTOAutorizacion dtoe) throws MareException {
  UtilidadesLog.debug("MONAutorizacion.buscarAutorizaciones(DTOAutorizacion dtoe):Entrada");  
    DTOSalida dtoSalida = new DTOSalida();
    DAOAutorizacion dao = new DAOAutorizacion();
    
    dtoSalida.setResultado(dao.buscarAutorizaciones(dtoe));
    
    UtilidadesLog.debug("MONAutorizacion.buscarAutorizaciones(DTOAutorizacion dtoe):Salida");  
    return dtoSalida;
  }

  public DTOAutorizacion obtenerAutorizacion(DTOOID dtoe) throws MareException {
  UtilidadesLog.debug("MONAutorizacion.obtenerAutorizacion(DTOOID dtoe):Entrada");
    
    AutorizacionesLocalHome autorizacionesLocalHome = new AutorizacionesLocalHome();
    AutorizacionesLocal autorizacionesLocal = null;
    
    TiposOperacionLocalHome tiposOperacionLocalHome = new TiposOperacionLocalHome();
    TiposOperacionLocal tiposOperacionLocal;
    
    try{
        autorizacionesLocal = autorizacionesLocalHome.findByPrimaryKey(dtoe.getOid());
       }catch(NoResultException fe){
             UtilidadesLog.error("MONAutorizaciones.obtenerAutorizacion: FinderException", fe);
             ctx.setRollbackOnly();
             String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
       }catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
       
    
       
    DTOAutorizacion dtoAuto = new DTOAutorizacion();
    dtoAuto.setOid(autorizacionesLocal.getOid());
    dtoAuto.setOidTipoOperacion(autorizacionesLocal.getTipoOperacion());  
    dtoAuto.setImporteMaximo(autorizacionesLocal.getImporteMaximo());
    dtoAuto.setMontoMaximoDiferencia(autorizacionesLocal.getMontoMaximoDiferencia());
    dtoAuto.setIngreso(autorizacionesLocal.getIngreso());
    dtoAuto.setDesbloqueo(autorizacionesLocal.getDesbloqueo());

    try{
             tiposOperacionLocal = tiposOperacionLocalHome.findByPrimaryKey(autorizacionesLocal.getTipoOperacion());
       }catch(NoResultException fe){
             ctx.setRollbackOnly();
             UtilidadesLog.error("MONAutorizaciones.obtenerAutorizacion: FinderException", fe);
             String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
             throw new MareException(fe, UtilidadesError.armarCodigoError(codigoError));
       }catch (PersistenceException e) {
                    ctx.setRollbackOnly();
                    throw new MareException(e,
                        UtilidadesError.armarCodigoError(
                            CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
     
     dtoAuto.setOidOperacion(tiposOperacionLocal.getOperacion());
  
  UtilidadesLog.debug("dtoAuto" + dtoAuto);   
  
  UtilidadesLog.debug("MONAutorizacion.obtenerAutorizacion(DTOOID dtoe):Salida");  
  return dtoAuto;
  }

  public void eliminarAutorizacion(DTOOIDs dtoe) throws MareException {
  UtilidadesLog.debug("MONAutorizacion.eliminarAutorizacion(DTOOIDs dtoe):Entrada");
          try {
            
            AutorizacionesLocalHome autorizacionesLocalHome = new AutorizacionesLocalHome();
            AutorizacionesLocal autorizacionesLocal = null;

            UtilidadesLog.info("Antes del bucle  dtoe.getOids().length----- " +  dtoe.getOids().length);

            for (int j = 0; j < dtoe.getOids().length; j++){
                UtilidadesLog.info("dtoe.getOids() +++++++  " + dtoe.getOids());
                UtilidadesLog.info("dtoe.getOids()[j]--------   " + "**** j ******" + j + "------" + dtoe.getOids()[j]);
                autorizacionesLocal = autorizacionesLocalHome.findByPrimaryKey(dtoe.getOids()[j]);
                UtilidadesLog.info("Ya busque  " );
                autorizacionesLocalHome.remove(autorizacionesLocal);
                UtilidadesLog.info("borre  ");
            }
            
        } catch (NoResultException e) {
            ctx.setRollbackOnly();
            String codigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
            throw new MareException(e, UtilidadesError.armarCodigoError(codigoError));
        } catch (PersistenceException cr) {
            ctx.setRollbackOnly();
            throw new MareException(cr, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC, "", CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        } catch (Exception ex) {
            ctx.setRollbackOnly();
            throw new MareException(ex, UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_REC, "", CodigosError.ERROR_DE_LECTURA_BLOB));
        }    

  }

}