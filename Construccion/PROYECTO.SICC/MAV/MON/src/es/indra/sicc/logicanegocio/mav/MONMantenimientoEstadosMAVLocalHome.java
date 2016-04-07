package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoEstadosMAVLocalHome extends EJBLocalHome 
{
    MONMantenimientoEstadosMAVLocal create() throws CreateException;
}