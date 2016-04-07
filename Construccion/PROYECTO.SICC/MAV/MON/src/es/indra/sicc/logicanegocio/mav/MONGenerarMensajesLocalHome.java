package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarMensajesLocalHome extends EJBLocalHome 
{
    MONGenerarMensajesLocal create() throws CreateException;
}