package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONECMLocalHome extends EJBLocalHome  {
    MONECMLocal create() throws CreateException;
}