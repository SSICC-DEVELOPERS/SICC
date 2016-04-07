package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONParametrizacionCallCenterLocalHome extends EJBLocalHome 
{
    MONParametrizacionCallCenterLocal create() throws CreateException;
}