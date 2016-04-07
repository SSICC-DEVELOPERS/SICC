package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarSolicitudModulosExternosLocalHome extends EJBLocalHome 
{
    MONGenerarSolicitudModulosExternosLocal create() throws CreateException;
}