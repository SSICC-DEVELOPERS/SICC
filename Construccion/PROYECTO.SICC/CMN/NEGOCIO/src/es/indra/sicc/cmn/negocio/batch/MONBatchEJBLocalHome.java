package es.indra.sicc.cmn.negocio.batch;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONBatchEJBLocalHome extends EJBLocalHome 
{
    MONBatchEJBLocal create() throws CreateException;
}