package es.indra.sicc.logicanegocio.app;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONTerritoriosRutasLocalHome extends EJBLocalHome 
{
    MONTerritoriosRutasLocal create() throws CreateException;
}