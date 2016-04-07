package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.mav.DTOValoresDefectoDatosBP;
import es.indra.mare.common.exception.MareException;

public interface MONMantenimientoParametrosDBPLocal extends EJBLocalObject  {
    void guardarValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws MareException;

    DTOValoresDefectoDatosBP obtenerValoresDefectoActividad(DTOValoresDefectoDatosBP dtoe) throws MareException;
}