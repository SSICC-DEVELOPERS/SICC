package es.indra.sicc.logicanegocio.intsys;
import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;

public interface MONSecuenciacionAPPLocalHome extends EJBLocalHome  {
    MONSecuenciacionAPPLocal create() throws CreateException;
}