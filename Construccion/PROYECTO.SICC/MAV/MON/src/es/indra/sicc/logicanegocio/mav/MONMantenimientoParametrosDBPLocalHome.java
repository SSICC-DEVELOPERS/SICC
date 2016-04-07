package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoParametrosDBPLocalHome extends EJBLocalHome  {
    MONMantenimientoParametrosDBPLocal create() throws CreateException;
}