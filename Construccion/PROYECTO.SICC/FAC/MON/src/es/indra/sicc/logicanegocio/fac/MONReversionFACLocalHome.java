package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONReversionFACLocalHome extends EJBLocalHome 
{
    MONReversionFACLocal create() throws CreateException;
}