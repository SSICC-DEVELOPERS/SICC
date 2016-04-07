package es.indra.sicc.logicanegocio.cal;

import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.cal.DTOMensajeCallCenter;
import es.indra.sicc.util.DTOBelcorp;
import java.rmi.RemoteException;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.cal.MensajeCallCenterLocalHome;
import es.indra.sicc.entidades.cal.MensajeCallCenterLocal;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.ejb.RemoveException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONParametrizacionCallCenterBean implements SessionBean  {
  public void ejbCreate() {  }
  public void ejbActivate() {  }
  public void ejbPassivate() {  }
  public void ejbRemove() {  }

  SessionContext ctx = null;
  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }

  /**
   * Metodo: obtenerMensajeCallCenter
   * Autor: Cristian Valenzuela
   * Fecha: 22/12/2004
   * Descripcion: Este metodo devuelve en un DTOMensajeCallCenter, el resultado
   * de la llamada al metodo findByUK de la entidad MensajeCallCenter,
   * Si no se encuentran registros (FinderException), se devuelve este DTO
   * con los valores oid y texto mensaje en null
   */

  public DTOMensajeCallCenter obtenerMensajeCallCenter(DTOBelcorp dtoe) throws MareException {
  
    UtilidadesLog.info("MONParametrizacionCallCenterBean.obtenerMensajeCallCenter(DTOBelcorp dtoe): Entrada");
  
  
  
    /*mensajeCallCenter = llamar al método findByUK (DTOE.pais) de la entidad MensajeCallCenter 

      Se crea un DTOMensajeCallCenter 

      Si existe un registro para ese país 
      DTOMensajeCallCenter.oid = mensajeCallCenter.oid 
      DTOMensajeCallCenter.textoMensaje = mensajeCallCenter.textoMensaje 
      en otro caso 
      DTOMensajeCallCenter.oid = null 
      DTOMensajeCallCenter.textoMensaje = null  */

    DTOMensajeCallCenter dtoMensaje = new DTOMensajeCallCenter();

    try {
      MensajeCallCenterLocalHome mcclh = this.getMensajeCallCenterLocalHome();
      MensajeCallCenterLocal mccl = mcclh.findByUK(dtoe.getOidPais());

      dtoMensaje.setOid(mccl.getOid());
      dtoMensaje.setTextoMensaje(mccl.getTextoMensaje());
    }
    catch (NoResultException ne) {
        // vbongiov -- MSiCC 20090025 CAL-02 -- 9/01/2009
        dtoMensaje.setOid(null);
        dtoMensaje.setTextoMensaje(null);
    }
    catch(PersistenceException pex) {
                 ctx.setRollbackOnly();
                 throw new MareException(pex, 
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
   }
    
    UtilidadesLog.info("MONParametrizacionCallCenterBean.obtenerMensajeCallCenter(DTOBelcorp dtoe): Salida");
    
    return dtoMensaje;
  }

  /**
   * Metodo: actualizarMensajeCallCenter
   * Autor: Cristian Valenzuela
   * Fecha: 20/12/2004
   * Descripcion: Este metodo inserta o actualiza un registro en la tabla CAL_MENSA_CALLC
   */

  public void actualizarMensajeCallCenter(DTOMensajeCallCenter dtoe) throws MareException {
  
    UtilidadesLog.info("MONParametrizacionCallCenterBean.actualizarMensajeCallCenter(DTOMensajeCallCenter dtoe): Entrada");
  
    /*Si DTOE.oid==null { //Se trata de una insercion 
      Hacer un create() en la entidad: MensajesCallCenter con la siguiente informacion: 
      MensajesCallCenter.textoMensaje=DTOE.textoMensaje 
      MensajesCallCenter.pais=DTOE.pais 
      } 

      En otro caso { // Actualiza el Mensaje 
      MensajesCallCenter = Llamar al método findByPrimaryKey(DTOE.oid) de la entidad MensajesCallCenter 

      Actualiza el texto del mensaje: 

      - MensajesCallCenter.textoMensaje = DTOE.textoMensaje 

      } */

    try {
      if(dtoe.getOid()==null) {
        MensajeCallCenterLocalHome mcclh = this.getMensajeCallCenterLocalHome();
        mcclh.create(dtoe.getTextoMensaje(),dtoe.getOidPais());       
      }
      else {
        MensajeCallCenterLocalHome mcclh = this.getMensajeCallCenterLocalHome();
        MensajeCallCenterLocal mccl = mcclh.findByPrimaryKey(dtoe.getOid());
        mccl.setTextoMensaje(dtoe.getTextoMensaje());        
        mcclh.merge(mccl);
      }    
    }
    catch (NoResultException ne) {
      UtilidadesLog.error(ne);
      ctx.setRollbackOnly();
      throw new MareException(ne,UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
    }catch(PersistenceException pex) {
                ctx.setRollbackOnly();
                throw new MareException(pex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
   }
        
    UtilidadesLog.info("MONParametrizacionCallCenterBean.actualizarMensajeCallCenter(DTOMensajeCallCenter dtoe): Salida");
    
  }
    private MensajeCallCenterLocalHome getMensajeCallCenterLocalHome()  {
        return new MensajeCallCenterLocalHome();
      }

}
