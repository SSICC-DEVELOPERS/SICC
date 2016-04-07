package es.indra.sicc.logicanegocio.inc;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONPremiacionLocalHome extends EJBLocalHome 
{
    MONPremiacionLocal create() throws CreateException;
}