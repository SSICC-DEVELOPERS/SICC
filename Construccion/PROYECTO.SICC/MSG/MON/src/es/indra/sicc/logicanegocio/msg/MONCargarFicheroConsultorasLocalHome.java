package es.indra.sicc.logicanegocio.msg;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCargarFicheroConsultorasLocalHome extends EJBLocalHome 
{
    MONCargarFicheroConsultorasLocal create() throws CreateException;
}