package es.indra.sicc.logicanegocio.mae;
import es.indra.mare.common.exception.MareException;
import javax.ejb.FinderException;

import javax.persistence.NoResultException;

public class ClienteNoUtilizableException extends MareException  {
    public ClienteNoUtilizableException() {
    }

    public ClienteNoUtilizableException(FinderException ex) {
        super(ex);
    }

    public ClienteNoUtilizableException(NoResultException ex) {
        super(ex);
    }

}