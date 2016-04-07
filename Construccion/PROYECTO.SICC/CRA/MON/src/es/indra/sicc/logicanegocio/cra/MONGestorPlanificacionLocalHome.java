package es.indra.sicc.logicanegocio.cra;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONGestorPlanificacionLocalHome extends EJBLocalHome 
{
    MONGestorPlanificacionLocal create() throws CreateException;
}