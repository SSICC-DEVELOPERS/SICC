package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCalcularDTOLocalHome extends EJBLocalHome 
{
    MONCalcularDTOLocal create() throws CreateException;
}