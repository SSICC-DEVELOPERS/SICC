package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudPais;
import es.indra.sicc.dtos.ped.DTOAtributoEspecial;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.logicanegocio.ped.DAOPED;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.logicanegocio.ped.ConstantesValoresDefecto;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.SEGEjbLocators;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEGHome;
import es.indra.sicc.logicanegocio.seg.MONMantenimientoSEG;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import java.rmi.RemoteException;
import javax.ejb.CreateException;

public class MONUtilidadesProcesosBean implements SessionBean  {
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

  	public DTOSalida consultaTipoSolicitudPais(DTOBelcorp dto) throws MareException {   
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTipoSolicitudPais(DTOBelcorp dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTipoSolicitudPais(DTOBelcorp dto): Salida ");
        return dao.obtieneTiposSolicitudPais(dto);
	}

    //@ssaavedr, 28/09/2005.. metodo creado para posibilitar traer solo tipos de sol.
    //consolidadas.......(FAC!)
  	public DTOSalida consultaTipoSolicitudPaisConsolidadas(DTOBelcorp dto) throws MareException {   
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTipoSolicitudPaisConsolidadas(DTOBelcorp dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTipoSolicitudPaisConsolidadas(DTOBelcorp dto): Salida ");
        return dao.obtieneTiposSolicitudPaisConsolidadas(dto);
	}
    
	public DTOSalida consultaClasesSolicitud(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaClasesSolicitud(DTOBelcorp dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida;
		dtoSalida = dao.obtieneClasesSolicitud(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaClasesSolicitud(DTOBelcorp dto): Salida ");
		return dtoSalida;
	}

	public DTOSalida consultaTiposPosicion(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposPosicion(DTOBelcorp dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida;
		dtoSalida = dao.obtieneTiposPosicion(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposPosicion(DTOBelcorp dto): Salida ");
		return dtoSalida;
	}

	public DTOSalida consultaSubtiposPosicion(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaSubtiposPosicion(DTOOID dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida;
		dtoSalida = dao.obtieneSubtiposPosicion(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaSubtiposPosicion(DTOOID dto): Salida ");
		return dtoSalida;
	}

  public DTOSalida consultaGruposProcesos(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaGruposProcesos(DTOBelcorp dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida;
		dtoSalida = dao.obtieneGruposProcesos(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaGruposProcesos(DTOBelcorp dto): Salida ");
		return dtoSalida;
  }

  public DTOSalida consultaCodigosProcesos(DTOOID dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaCodigosProcesos(DTOOID dto): Entrada ");
		String user = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(user);
		DTOSalida dtoSalida;
		dtoSalida = dao.obtieneProcesos(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaCodigosProcesos(DTOOID dto): Salida ");
		return dtoSalida;
  }

  public DTOSalida consultaAtributosEspeciales(DTOAtributoEspecial dto) throws CreateException, RemoteException, MareException {
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultaAtributosEspeciales(DTOAtributoEspecial dto): Entrada ");
    dto.setModulo(ConstantesSEG.MODULO_PED);
    dto.setFormulario(ConstantesValoresDefecto.PG_DATOS_SOLICITUD);

    MONMantenimientoSEGHome msegHome = SEGEjbLocators.getMONMantenimientoSEGHome();
    MONMantenimientoSEG mseg = msegHome.create();
    Long oid = mseg.obtenerOidModulo(dto.getModulo());
    dto.setOidModulo(oid);   
    
    String user = ctx.getCallerPrincipal().getName();
    DAOPED dao = new DAOPED(user);
    DTOSalida dtoSalida;
    dtoSalida = dao.obtieneAtributosEspeciales(dto);
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultaAtributosEspeciales(DTOAtributoEspecial dto): Salida ");
    return dtoSalida; 
  }	

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       23/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene todos los tipos de consolidado. 
	 */
	public DTOSalida consultaTiposConsolidado(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposConsolidado(DTOBelcorp dto): Entrada ");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(usuario);
		DTOSalida salida = dao.obtieneTiposConsolidado(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposConsolidado(DTOBelcorp dto): Salida ");
		return salida;
	}

	/**
	 * Sistema:     Belcorp
	 * Modulo:      PED
	 * Fecha:       23/07/2004
	 * @version     1.0
	 * @autor       Maximiliano Dello Russo
	 * Descripcion: Obtiene todos los tipos de solicitud.
	 */
	public DTOSalida consultaTiposSolicitud(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposSolicitud(DTOBelcorp dto): Entrada ");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(usuario);
		DTOSalida salida = dao.obtieneTiposSolicitud(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposSolicitud(DTOBelcorp dto): Salida ");
		return salida;
	}

	public DTOSalida consultaTiposDespacho(DTOBelcorp dto) throws MareException {
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposDespacho(DTOBelcorp dto): Entrada ");
		String usuario = ctx.getCallerPrincipal().getName();
		DAOPED dao = new DAOPED(usuario);
		DTOSalida salida = dao.obtieneTiposDespacho(dto);
        UtilidadesLog.info("MONUtilidadesProcesosBean.consultaTiposDespacho(DTOBelcorp dto): Salida ");
		return salida;
	}

  /**
   * @Autor: Cortaberria
   * @throws es.indra.mare.common.exception.MareException
   * @return DTOSalida
   * @param DTOBelcorp dto
   */
  public DTOSalida consultaClasesSolicitudOrdenCompra(DTOBelcorp dto) throws MareException  {
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultaClasesSolicitudOrdenCompra(DTOBelcorp dto): Entrada ");
    String usuario = ctx.getCallerPrincipal().getName();
    DAOPED dao = new DAOPED(usuario);
    DTOSalida salida = dao.obtieneClasesSolicitudOrdenCompra(dto);
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultaClasesSolicitudOrdenCompra(DTOBelcorp dto): Salida ");
    return salida;
  }

  //Incidencia 12368
  public DTOSalida consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto) throws MareException {
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto): Entrada ");
    String usuario = ctx.getCallerPrincipal().getName();
    DAOPED dao = new DAOPED(usuario);
	DTOSalida salida = dao.consultarTipoSolicitudPaisUnion(dto);
    UtilidadesLog.info("MONUtilidadesProcesosBean.consultarTipoSolicitudPaisUnion(DTOTipoSolicitudPais dto): Salida ");
	return salida;
  }

  public DTOSalida obtenerTipoSolicitudPorClase(DTOBelcorp dto) throws MareException {
    UtilidadesLog.info("MONUtilidadesProcesosBean.obtenerTipoSolicitudPorClase(DTOBelcorp dto): Entrada ");
    String usuario = ctx.getCallerPrincipal().getName();
	DAOPED dao = new DAOPED(usuario);
	DTOSalida salida = dao.obtenerTipoSolicitudPorClase(dto);
    UtilidadesLog.info("MONUtilidadesProcesosBean.obtenerTipoSolicitudPorClase(DTOBelcorp dto): Salida ");
	return salida;
  }

}