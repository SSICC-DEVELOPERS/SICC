package es.indra.sicc.logicanegocio.car;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONValidarCreditosLocalHome extends EJBLocalHome 
{
    MONValidarCreditosLocal create() throws CreateException;
}