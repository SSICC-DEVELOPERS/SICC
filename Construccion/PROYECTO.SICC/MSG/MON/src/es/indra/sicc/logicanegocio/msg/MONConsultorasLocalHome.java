package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONConsultorasLocalHome extends EJBLocalHome 
{
    MONConsultorasLocal create() throws CreateException;
}