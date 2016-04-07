package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoListasLocalHome extends EJBLocalHome 
{
    MONMantenimientoListasLocal create() throws CreateException;
}