package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoErrorData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccTipoErrorBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public Vector query(CccTipoErrorData cccTipoErrorFrom, 
                        CccTipoErrorData cccTipoErrorTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccTipoErrorBean.query(CccTipoErrorData cccTipoErrorFrom, CccTipoErrorData cccTipoErrorTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccTipoError dao = new DAOCccTipoError();
        UtilidadesLog.info("MONCccTipoErrorBean.query(CccTipoErrorData cccTipoErrorFrom, CccTipoErrorData cccTipoErrorTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccTipoErrorFrom, cccTipoErrorTo, userProperties, pageCount, pageSize);
    }
}
