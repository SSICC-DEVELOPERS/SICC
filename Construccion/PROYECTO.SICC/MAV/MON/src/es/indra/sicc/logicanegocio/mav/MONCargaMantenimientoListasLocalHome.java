package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCargaMantenimientoListasLocalHome extends EJBLocalHome 
{
    MONCargaMantenimientoListasLocal create() throws CreateException;
}