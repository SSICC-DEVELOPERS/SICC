package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONValoresPorDefectoLocalHome extends EJBLocalHome 
{
    MONValoresPorDefectoLocal create() throws CreateException;
}