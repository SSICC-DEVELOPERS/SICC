package es.indra.sicc.logicanegocio.ped;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONReversionCuadreOfertasLocalHome extends EJBLocalHome 
{
    MONReversionCuadreOfertasLocal create() throws CreateException;
}