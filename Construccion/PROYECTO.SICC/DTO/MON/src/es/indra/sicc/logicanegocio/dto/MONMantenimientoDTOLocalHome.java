package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONMantenimientoDTOLocalHome extends EJBLocalHome 
{
    MONMantenimientoDTOLocal create() throws CreateException;
}