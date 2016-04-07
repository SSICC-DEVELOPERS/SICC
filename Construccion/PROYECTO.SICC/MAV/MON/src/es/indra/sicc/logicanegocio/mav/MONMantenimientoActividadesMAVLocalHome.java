package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoActividadesMAVLocalHome extends EJBLocalHome 
{
    MONMantenimientoActividadesMAVLocal create() throws CreateException;
}