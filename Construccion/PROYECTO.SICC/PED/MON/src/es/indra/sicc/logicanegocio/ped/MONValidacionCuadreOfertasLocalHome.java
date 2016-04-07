package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONValidacionCuadreOfertasLocalHome extends EJBLocalHome 
{
    MONValidacionCuadreOfertasLocal create() throws CreateException;
}