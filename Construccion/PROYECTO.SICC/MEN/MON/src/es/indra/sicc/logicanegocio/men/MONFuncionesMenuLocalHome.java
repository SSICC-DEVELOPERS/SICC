package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONFuncionesMenuLocalHome extends EJBLocalHome 
{
    MONFuncionesMenuLocal create() throws CreateException;
}