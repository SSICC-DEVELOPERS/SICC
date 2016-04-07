package es.indra.sicc.logicanegocio.dto;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONRevertirDescuentosLocalHome extends EJBLocalHome 
{
    MONRevertirDescuentosLocal create() throws CreateException;
}