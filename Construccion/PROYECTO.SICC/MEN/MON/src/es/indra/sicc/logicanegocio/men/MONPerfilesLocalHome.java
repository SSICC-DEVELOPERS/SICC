package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONPerfilesLocalHome extends EJBLocalHome 
{
    MONPerfilesLocal create() throws CreateException;
}