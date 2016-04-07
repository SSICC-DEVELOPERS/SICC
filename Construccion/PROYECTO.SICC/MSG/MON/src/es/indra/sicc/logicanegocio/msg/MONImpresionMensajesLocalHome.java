package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONImpresionMensajesLocalHome extends EJBLocalHome 
{
    MONImpresionMensajesLocal create() throws CreateException;
}