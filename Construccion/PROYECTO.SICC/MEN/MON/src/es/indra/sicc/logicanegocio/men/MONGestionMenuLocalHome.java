package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGestionMenuLocalHome extends EJBLocalHome 
{
    MONGestionMenuLocal create() throws CreateException;
}