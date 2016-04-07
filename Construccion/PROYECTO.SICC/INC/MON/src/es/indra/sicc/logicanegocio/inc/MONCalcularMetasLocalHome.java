package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCalcularMetasLocalHome extends EJBLocalHome 
{
    MONCalcularMetasLocal create() throws CreateException;
}