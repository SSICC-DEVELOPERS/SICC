package es.indra.sicc.logicanegocio.app;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSecuYMarcasChequeoLocalHome extends EJBLocalHome 
{
    MONSecuYMarcasChequeoLocal create() throws CreateException;
}