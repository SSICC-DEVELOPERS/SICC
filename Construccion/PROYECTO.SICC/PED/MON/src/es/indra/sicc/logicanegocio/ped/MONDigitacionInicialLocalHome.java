package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONDigitacionInicialLocalHome extends EJBLocalHome 
{
    MONDigitacionInicialLocal create() throws CreateException;
}