package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCreditoRiesgoLocalHome extends EJBLocalHome 
{
    MONCreditoRiesgoLocal create() throws CreateException;
}