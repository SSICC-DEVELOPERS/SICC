package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONRegistroMAVLocalHome extends EJBLocalHome 
{
    MONRegistroMAVLocal create() throws CreateException;
}