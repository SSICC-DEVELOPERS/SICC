package es.indra.sicc.logicanegocio.cra;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBLocalObject;

public interface MONGestorPlanificacionLocal extends EJBLocalObject 
{
    void borrarTarea(String nombreTarea) throws MareException;
}