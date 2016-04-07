package es.indra.sicc.logicanegocio.ccc;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.util.UtilidadesLog;

public class MONMantenimientoCCCBean implements SessionBean  {
	public void ejbCreate() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public void ejbRemove() {
	}

	public void setSessionContext(SessionContext ctx) {
	}

	public RecordSet obtenerBancos(DTOBelcorp dto) throws MareException {
		UtilidadesLog.info("MONMantenimientoCCCBean.obtenerBancos(DTOBelcorp dto): Entrada");
		DAOCCC daoccc= new DAOCCC();
        UtilidadesLog.info("MONMantenimientoCCCBean.obtenerBancos(DTOBelcorp dto): Salida");
		return daoccc.obtieneBancos(dto);

	}

  public DTOSalida obtenerProcesosActivos(DTOBelcorp dto) throws MareException{
     DAOCCC daoccc= new DAOCCC();
     return daoccc.obtenerProcesosActivos(dto);
  }

  public DTOSalida obtenertipoCargoProcesos(DTOBelcorp dto) throws MareException{
    DAOCCC daoccc= new DAOCCC();
    return daoccc.obtenerTipoCargoProcesos(dto);
  }

  public DTOSalida obtenerTipoCargoCCC004(DTOBelcorp dto) throws MareException{
    DAOCCC daoccc= new DAOCCC();
    return daoccc.obtenerTipoCargoCCC004(dto);
  }
}