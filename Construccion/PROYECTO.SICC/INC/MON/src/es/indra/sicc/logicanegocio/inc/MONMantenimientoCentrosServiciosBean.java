package es.indra.sicc.logicanegocio.inc;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.inc.DTOCentroServicio;

import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.util.DTOBelcorp;

public class MONMantenimientoCentrosServiciosBean implements SessionBean {
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

    public DTOSalida buscarCentrosServicios(DTOCentroServicio dto) throws MareException {
        DAOCentrosServicios dao = new DAOCentrosServicios();
        return dao.buscarCentrosServicios(dto);
    }

    public void insertarCentroServicio(DTOCentroServicio dto) throws MareException {
        DAOCentrosServicios dao = new DAOCentrosServicios();
        if (dto.getOidCentroServicio() == null) {
            dao.insertarCentroServicio(dto);
        } else {
            dao.modificarCentroServicio(dto);
        }
    }

    public void eliminarCentroServicio(DTOOIDs dto) throws MareException {
        DAOCentrosServicios dao = new DAOCentrosServicios();
        dao.eliminarCentroServicio(dto);
    }

  /**
    * Sistema:     Belcorp
    * Modulo:      APE
    * Fecha:       11/10/2007
    * @version     1.0
    * @autor       Viviana Bongiovanni
    */
  public DTOSalida obtenerCentroServicio(DTOBelcorp dtoe) throws MareException {
    UtilidadesLog.info("MONMantenimientoCentrosServiciosBean.obtenerCentroServicio(DTOBelcorp dtoe): Entrada");
    DTOSalida dtoSalida = new DAOCentrosServicios().obtenerCentroServicio(dtoe);
    UtilidadesLog.info("MONMantenimientoCentrosServiciosBean.obtenerCentroServicio(DTOBelcorp dtoe): Salida");
    return dtoSalida;
  }
}