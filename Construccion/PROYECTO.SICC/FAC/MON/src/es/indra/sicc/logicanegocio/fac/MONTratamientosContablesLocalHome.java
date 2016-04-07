package es.indra.sicc.logicanegocio.fac;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONTratamientosContablesLocalHome extends EJBLocalHome 
{
    MONTratamientosContablesLocal create() throws CreateException;
}