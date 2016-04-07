package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCARParametrizacionLocalHome extends EJBLocalHome 
{
    MONCARParametrizacionLocal create() throws CreateException;
}