package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSeguimientoPedidosLocalHome extends EJBLocalHome 
{
    MONSeguimientoPedidosLocal create() throws CreateException;
}