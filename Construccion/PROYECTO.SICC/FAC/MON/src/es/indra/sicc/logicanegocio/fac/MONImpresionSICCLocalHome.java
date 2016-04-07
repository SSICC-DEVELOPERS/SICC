package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONImpresionSICCLocalHome extends EJBLocalHome 
{
    MONImpresionSICCLocal create() throws CreateException;
}