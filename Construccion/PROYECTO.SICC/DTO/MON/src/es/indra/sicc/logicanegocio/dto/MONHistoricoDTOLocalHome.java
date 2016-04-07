package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONHistoricoDTOLocalHome extends EJBLocalHome 
{
    MONHistoricoDTOLocal create() throws CreateException;
}