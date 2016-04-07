package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONServicioMAVLocalHome extends EJBLocalHome 
{
    MONServicioMAVLocal create() throws CreateException;
}