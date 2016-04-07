package es.indra.sicc.logicanegocio.men;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONFuncionesFavoritasLocalHome extends EJBLocalHome 
{
    MONFuncionesFavoritasLocal create() throws CreateException;
}