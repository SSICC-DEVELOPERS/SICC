package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import es.indra.sicc.dtos.ped.DTOEstadisticasDigitacion;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.ped.EstadisticasDigitacionLocalHome;
import es.indra.sicc.entidades.ped.EstadisticasDigitacionLocal;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.CodigosError;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONEstadisticasDigitacionBean implements SessionBean  {

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

	public DTOOID guardarEstadisticas(DTOEstadisticasDigitacion DTOE) throws MareException {
        UtilidadesLog.info("MONEstadisticasDigitacionBean.guardarEstadisticas(DTOEstadisticasDigitacion DTOE): Entrada ");
		EstadisticasDigitacionLocalHome localHome = new EstadisticasDigitacionLocalHome();
		EstadisticasDigitacionLocal local = null;
		DTOOID salida = new DTOOID();
		
		try{
			if (DTOE.getOidEstadisticas() == null){
				String usuario = ctx.getCallerPrincipal().getName();

				try {
                                    local = localHome.create(	DTOE.getPeriodo(),
                                                                DTOE.getTipoSolicitud(),
                                                                DTOE.getProcesoPedidos(),
                                                                DTOE.getInicioSesion(),
                                                                usuario,
                                                                DTOE.getFinSesion());
                                } catch (PersistenceException pe) {
                                    ctx.setRollbackOnly();
                                    UtilidadesLog.error("Error al insertar: ", pe);
                                    throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                }
			} else {

				local = localHome.findByPrimaryKey( DTOE.getOidEstadisticas() );
				local.setFinSesion( DTOE.getFinSesion() );
			}

			local.setErrorCV( DTOE.getErrorCV() );
			local.setErrorOC( DTOE.getErrorOC() );
			local.setNumeroCV( DTOE.getNumeroCV() );
			local.setNumeroOC( DTOE.getNumeroOC() );
                        
                        try {
                            localHome.merge(local);
                        } catch (PersistenceException pe) {
                            ctx.setRollbackOnly();
                            UtilidadesLog.error("Error al actualizar: ", pe);
                            throw new MareException(pe, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                        }

			salida.setOid( local.getOid() );
		}catch(NoResultException nre){
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error: ", nre);
                    throw new MareException(nre,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
		}catch (PersistenceException pe) {
                    ctx.setRollbackOnly();
                    UtilidadesLog.error("Error: ", pe);
                    throw new MareException(pe,
                            UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
                }
        UtilidadesLog.info("MONEstadisticasDigitacionBean.guardarEstadisticas(DTOEstadisticasDigitacion DTOE): Salida ");
		return salida;
	}

}
