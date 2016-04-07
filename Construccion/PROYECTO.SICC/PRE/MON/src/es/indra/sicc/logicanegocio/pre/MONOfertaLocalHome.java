package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONOfertaLocalHome extends EJBLocalHome 
{
    MONOfertaLocal create() throws CreateException;
}