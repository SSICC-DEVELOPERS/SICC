package es.indra.sicc.logicanegocio.pre;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCuadrePromocionLocalHome extends EJBLocalHome 
{
    MONCuadrePromocionLocal create() throws CreateException;
}