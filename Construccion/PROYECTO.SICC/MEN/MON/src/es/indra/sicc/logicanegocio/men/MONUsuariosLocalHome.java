package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONUsuariosLocalHome extends EJBLocalHome 
{
    MONUsuariosLocal create() throws CreateException;
}