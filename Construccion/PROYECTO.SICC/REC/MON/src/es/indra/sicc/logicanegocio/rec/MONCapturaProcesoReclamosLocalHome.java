package es.indra.sicc.logicanegocio.rec;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONCapturaProcesoReclamosLocalHome extends EJBLocalHome 
{
    MONCapturaProcesoReclamosLocal create() throws CreateException;
}