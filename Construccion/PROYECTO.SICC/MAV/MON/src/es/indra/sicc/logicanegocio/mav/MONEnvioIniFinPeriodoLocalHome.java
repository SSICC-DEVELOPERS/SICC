package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONEnvioIniFinPeriodoLocalHome extends EJBLocalHome 
{
    MONEnvioIniFinPeriodoLocal create() throws CreateException;
}