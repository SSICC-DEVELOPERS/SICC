package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGestionMensajesLocalHome extends EJBLocalHome 
{
    MONGestionMensajesLocal create() throws CreateException;
}