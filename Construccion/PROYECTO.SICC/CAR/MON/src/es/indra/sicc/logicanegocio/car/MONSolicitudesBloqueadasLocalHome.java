package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSolicitudesBloqueadasLocalHome extends EJBLocalHome 
{
    MONSolicitudesBloqueadasLocal create() throws CreateException;
}