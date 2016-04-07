package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONProcesoEnvioAgregadosSolicitudLocalHome extends EJBLocalHome 
{
    MONProcesoEnvioAgregadosSolicitudLocal create() throws CreateException;
}