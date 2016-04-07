package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONBuzonLocalHome extends EJBLocalHome 
{
    MONBuzonLocal create() throws CreateException;
}