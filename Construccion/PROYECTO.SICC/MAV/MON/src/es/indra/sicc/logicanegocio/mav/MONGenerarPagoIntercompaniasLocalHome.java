package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGenerarPagoIntercompaniasLocalHome extends EJBLocalHome 
{
    MONGenerarPagoIntercompaniasLocal create() throws CreateException;
}