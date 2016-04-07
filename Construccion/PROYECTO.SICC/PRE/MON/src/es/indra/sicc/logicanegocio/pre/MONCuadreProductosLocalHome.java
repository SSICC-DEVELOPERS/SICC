package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadreProductosLocalHome extends EJBLocalHome 
{
    MONCuadreProductosLocal create() throws CreateException;
}