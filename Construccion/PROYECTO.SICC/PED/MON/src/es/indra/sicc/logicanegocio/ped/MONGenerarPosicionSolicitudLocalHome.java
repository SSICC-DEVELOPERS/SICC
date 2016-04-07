package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarPosicionSolicitudLocalHome extends EJBLocalHome 
{
    MONGenerarPosicionSolicitudLocal create() throws CreateException;
}