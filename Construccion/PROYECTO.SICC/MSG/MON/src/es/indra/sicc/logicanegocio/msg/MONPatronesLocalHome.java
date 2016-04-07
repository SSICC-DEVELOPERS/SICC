package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONPatronesLocalHome extends EJBLocalHome 
{
    MONPatronesLocal create() throws CreateException;
}