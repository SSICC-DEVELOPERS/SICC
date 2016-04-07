package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONIncentivosLocalHome extends EJBLocalHome 
{
    MONIncentivosLocal create() throws CreateException;
}