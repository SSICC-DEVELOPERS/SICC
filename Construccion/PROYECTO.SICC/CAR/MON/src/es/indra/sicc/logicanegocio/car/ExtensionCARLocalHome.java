package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface ExtensionCARLocalHome extends EJBLocalHome 
{
    ExtensionCARLocal create() throws CreateException;
}