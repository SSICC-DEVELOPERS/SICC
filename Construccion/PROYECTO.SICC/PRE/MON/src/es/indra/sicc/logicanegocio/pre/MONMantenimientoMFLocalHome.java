package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoMFLocalHome extends EJBLocalHome 
{
    MONMantenimientoMFLocal create() throws CreateException;
}