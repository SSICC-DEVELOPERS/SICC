package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.cob.DTOAsignacionesCobranza;
import es.indra.sicc.logicanegocio.cob.DAOAsignacionesCobranza;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocal;
import es.indra.sicc.entidades.mae.ClienteTipoSubTipoLocalHome;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOString;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAsignacionesCobranzaBean implements SessionBean 
{
  private SessionContext sessionContext;
   
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
     sessionContext = ctx;
  }

  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       10/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida obtenerCriteriosOrdenacionTC(DTOBelcorp dto) throws MareException {
    DAOAsignacionesCobranza dao = new DAOAsignacionesCobranza();
		
		DTOSalida dtoSalida = dao.obtenerCriteriosOrdenacionTC(dto);
		return dtoSalida;        
  }

  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       10/03/2005
	 * @version     1.0
	 * @autor       Viviana Bongiovanni
	 */
  public DTOSalida buscarAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws MareException {    
    DAOAsignacionesCobranza dao = new DAOAsignacionesCobranza(sessionContext);
		//DTOSalida dtoSalida = dao.buscarAsignacionesCobranzaTC(dto);
        
        DTOSalida dtoSalida = dao.buscarAsignacionesCobranzaTC2(dto);
		return dtoSalida;  
  }

  /**
	 * Sistema:     Belcorp
	 * Modulo:      COB
	 * Fecha:       11/05/2005
	 * @version     1.0
	 * @autor       Emiliano Yache
	 */
  public DTOOID obtenerSubTipoClienteIVR(DTOOID oid) throws MareException {
    UtilidadesLog.info("MONAsignacionesCobranzaBean.obtenerSubTipoClienteIVR(DTOOID oid): Entrada");
  
    //Vamos a obtener el primer subtipo que encontremos para el cliente recibido 
    //Llamamos al findByCliente (DTOOid.oid) de la entidad ClienteTipoSubTipo 
    //De la colección que obtenemos tomamos el primer objeto y devolvemos un DTOOid con el oidSubTipoCliente de dicho objeto 
    ClienteTipoSubTipoLocalHome clLH = null;
    ClienteTipoSubTipoLocal clL = null;
    DTOOID dto = new DTOOID();
    
    try{
      clLH = new ClienteTipoSubTipoLocalHome();          
      Collection col = clLH.findByCliente(oid.getOid());

      Iterator it = col.iterator();
      clL =(ClienteTipoSubTipoLocal)it.next();
      
      dto.setOid(clL.getSbti_oid_subt_clie());

    } catch (NoResultException e){
      sessionContext.setRollbackOnly();
      UtilidadesLog.debug(e);
      String sCodigoError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
      throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    } catch (PersistenceException e){
      sessionContext.setRollbackOnly();
      UtilidadesLog.error(e);
      String sCodigoError = CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS;
      throw new MareException( e, UtilidadesError.armarCodigoError(sCodigoError) );
    }
    
    UtilidadesLog.info("MONAsignacionesCobranzaBean.obtenerSubTipoClienteIVR(DTOOID oid): Salida");
    
    return dto;
  }


    public DTOString obtenerTotalesAsignacionesCobranzaTC(DTOAsignacionesCobranza dto) throws MareException {
        UtilidadesLog.debug("MONAsignacionesCobranzaBean.obtenerTotalesAsignacionesCobranzaTC() : entrada");
        DTOString retorno = (new DAOAsignacionesCobranza(sessionContext)).obtenerTotalesAsignacionesCobranzaTC(dto);
        UtilidadesLog.debug("MONAsignacionesCobranzaBean.obtenerTotalesAsignacionesCobranzaTC() : salida");
        return retorno;
    }
}