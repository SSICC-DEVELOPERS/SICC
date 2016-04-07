package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadreCondicionadaLocalHome extends EJBLocalHome 
{
    MONCuadreCondicionadaLocal create() throws CreateException;
}