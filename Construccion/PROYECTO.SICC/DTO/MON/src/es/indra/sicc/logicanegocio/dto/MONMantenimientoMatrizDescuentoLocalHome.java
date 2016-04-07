package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoMatrizDescuentoLocalHome extends EJBLocalHome 
{
    MONMantenimientoMatrizDescuentoLocal create() throws CreateException;
}