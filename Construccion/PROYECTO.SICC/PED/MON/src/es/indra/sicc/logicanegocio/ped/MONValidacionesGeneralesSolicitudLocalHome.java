package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONValidacionesGeneralesSolicitudLocalHome extends EJBLocalHome 
{
    MONValidacionesGeneralesSolicitudLocal create() throws CreateException;
}