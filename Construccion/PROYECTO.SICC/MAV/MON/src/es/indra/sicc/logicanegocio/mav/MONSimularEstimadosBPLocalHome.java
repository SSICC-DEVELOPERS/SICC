package es.indra.sicc.logicanegocio.mav;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSimularEstimadosBPLocalHome extends EJBLocalHome 
{
    MONSimularEstimadosBPLocal create() throws CreateException;
}