package es.indra.sicc.logicanegocio.intsys;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface MONSAPBPSLocalHome extends EJBLocalHome {
    MONSAPBPSLocal create() throws CreateException;
}
