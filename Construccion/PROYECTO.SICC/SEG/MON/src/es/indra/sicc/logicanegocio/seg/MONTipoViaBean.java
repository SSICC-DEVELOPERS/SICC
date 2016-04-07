package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegTipoViaData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONTipoViaBean implements SessionBean {
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

    public Hashtable guardar(SegTipoViaData segTipoVia, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOTipoVia daoTipoVia = new DAOTipoVia();
    
        return daoTipoVia.guardar(segTipoVia, localizationLabels, userProperties) ;
    }

    public Vector query(SegTipoViaData segTipoViaFrom, SegTipoViaData segTipoViaTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOTipoVia daoTipoVia = new DAOTipoVia();
    
        return daoTipoVia.query(segTipoViaFrom, segTipoViaTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segTipoViaFrom) throws MareException
    {
        DAOTipoVia daoTipoVia = new DAOTipoVia();
    
        daoTipoVia.remove(segTipoViaFrom);
    }

    public void update(SegTipoViaData segTipoVia, Vector localizationLabels) throws MareException
    {
        DAOTipoVia daoTipoVia = new DAOTipoVia();
    
        daoTipoVia.update(segTipoVia, localizationLabels);
    }
}
