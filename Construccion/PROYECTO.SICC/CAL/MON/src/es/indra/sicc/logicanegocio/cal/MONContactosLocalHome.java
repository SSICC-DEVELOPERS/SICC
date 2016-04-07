package es.indra.sicc.logicanegocio.cal;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONContactosLocalHome extends EJBLocalHome 
{
    MONContactosLocal create() throws CreateException;
}