package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMensajesLocalHome extends EJBLocalHome 
{
    MONMensajesLocal create() throws CreateException;
}