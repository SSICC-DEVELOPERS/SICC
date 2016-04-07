package es.indra.sicc.logicanegocio.cob;
import es.indra.sicc.dtos.cob.DTOAccionCobranza;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocal;
import es.indra.sicc.entidades.cob.AccionesCobranzaLocalHome;
import es.indra.sicc.logicanegocio.mae.ClienteNoUtilizableException;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.FinderException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.cob.DTOBuscarAccionesCobranza;
import es.indra.sicc.logicanegocio.cob.DAOAccionesCobranza;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONAccionesCobranzaBean implements SessionBean 
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

  public void setSessionContext(SessionContext ctx) {
    sessionContext = ctx;
  }

  public DTOSalida buscarAccionesCobranza(DTOBuscarAccionesCobranza dto) throws MareException {
        UtilidadesLog.info("MONAccionesCobranzaBean.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Entrada");
  
        DAOAccionesCobranza dao = new DAOAccionesCobranza();
		DTOSalida dtoSalida = dao.buscarAccionesCobranza(dto);
        
        UtilidadesLog.info("MONAccionesCobranzaBean.buscarAccionesCobranza(DTOBuscarAccionesCobranza dto): Salida");
        
		return dtoSalida;     
  }

    public DTOSalida obtenerAccionesCobranza(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONAccionesCobranzaBean.obtenerAccionesCobranza(DTOBelcorp dto): Entrada");
    
        DAOAccionesCobranza daoAccionesCobranzas = new DAOAccionesCobranza();
        
        UtilidadesLog.info("MONAccionesCobranzaBean.obtenerAccionesCobranza(DTOBelcorp dto): Salida");
        
        return daoAccionesCobranzas.obtenerAccionesCobranza(dto);
    }

    /*Metodo agregado ciglesias incidencia 24442*/
    public DTOAccionCobranza obtenerAccionCobranza(DTOOID dtoE) throws MareException   {
    
        UtilidadesLog.info("MONAccionesCobranzaBean.obtenerAccionCobranza(DTOOID dto): Entrada");
        AccionesCobranzaLocalHome accionCobranzaLH = getAccionesCobranzaLocalHome();
        AccionesCobranzaLocal accionCobranzaL = null;
        DTOAccionCobranza dtoAccionCobranza = new DTOAccionCobranza();

        try {        
            accionCobranzaL = accionCobranzaLH.findByPrimaryKey(dtoE.getOid());
        } catch(NoResultException nre) {
            sessionContext.setRollbackOnly();
            nre.printStackTrace();
            UtilidadesLog.debug("FinderException AccionesCobranza");
            throw new ClienteNoUtilizableException(nre);
        } catch(PersistenceException pex) {
            sessionContext.setRollbackOnly();
            pex.printStackTrace();
            throw new MareException(pex, 
            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
        }
        
        dtoAccionCobranza.setOid(accionCobranzaL.getOid());
        dtoAccionCobranza.setCodigoAccionCobranza(accionCobranzaL.getCodigoAccionCobranza());
        dtoAccionCobranza.setDescripcion(accionCobranzaL.getDescripcion());
        dtoAccionCobranza.setIndFechaHoraSeguimiento(accionCobranzaL.getIndFechaHoraSeguimiento());
        dtoAccionCobranza.setIndFechaImporteCompromiso(accionCobranzaL.getIndFechaImporteCompromiso());
        dtoAccionCobranza.setIndFechaHoraNuevoSeguimiento(accionCobranzaL.getIndFechaHoraNuevoSeguimiento());
        dtoAccionCobranza.setIndAportaPrueba(accionCobranzaL.getIndAportaPrueba());
        dtoAccionCobranza.setIndDescripcionPrueba(accionCobranzaL.getIndDescripcionPrueba());
        dtoAccionCobranza.setIndTipoDocumentoPago(accionCobranzaL.getIndTipoDocumentoPago());
        dtoAccionCobranza.setIndBancoSucursal(accionCobranzaL.getIndBancoSucursal());
        dtoAccionCobranza.setIndNuevaDireccion(accionCobranzaL.getIndNuevaDireccion());
        dtoAccionCobranza.setIndNuevoTelefono(accionCobranzaL.getIndNuevoTelefono());
        dtoAccionCobranza.setIndPasaAdministrador(accionCobranzaL.getIndPasaAdministrador());
        dtoAccionCobranza.setIndPeticionBloqueoAdministrativo(accionCobranzaL.getIndPeticionBloqueoAdministrativo());
        dtoAccionCobranza.setIndPeticionDesbloqueoAdministrativo(accionCobranzaL.getIndPeticionDesbloqueoAdministrativo());
        dtoAccionCobranza.setIndAccionMensajeRecordatorio(accionCobranzaL.getIndAccionMensajeRecordatorio());
        dtoAccionCobranza.setIndObservaciones(accionCobranzaL.getIndObservaciones());
        dtoAccionCobranza.setObservaciones(accionCobranzaL.getObservaciones()); 

        UtilidadesLog.info("MONAccionesCobranzaBean.obtenerAccionCobranza(DTOOID dto): Salida");
        UtilidadesLog.info("DTO " + dtoAccionCobranza);

        return dtoAccionCobranza;
    }
    
    private AccionesCobranzaLocalHome getAccionesCobranzaLocalHome() 
  {
   return new AccionesCobranzaLocalHome();
  }


}
