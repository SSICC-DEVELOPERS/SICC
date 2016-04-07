package es.indra.sicc.logicanegocio.rec;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

public interface MONGestionRecojosLocalHome extends EJBLocalHome {
    MONGestionRecojosLocal create() throws CreateException;
}
