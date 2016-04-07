package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadreOfertasLocalHome extends EJBLocalHome 
{
    MONCuadreOfertasLocal create() throws CreateException;
}