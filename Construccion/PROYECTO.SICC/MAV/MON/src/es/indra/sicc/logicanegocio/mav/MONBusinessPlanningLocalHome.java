package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONBusinessPlanningLocalHome extends EJBLocalHome 
{
    MONBusinessPlanningLocal create() throws CreateException;
}