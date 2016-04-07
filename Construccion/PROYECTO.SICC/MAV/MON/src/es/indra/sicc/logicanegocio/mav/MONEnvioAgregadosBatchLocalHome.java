package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONEnvioAgregadosBatchLocalHome extends EJBLocalHome 
{
    MONEnvioAgregadosBatchLocal create() throws CreateException;
}