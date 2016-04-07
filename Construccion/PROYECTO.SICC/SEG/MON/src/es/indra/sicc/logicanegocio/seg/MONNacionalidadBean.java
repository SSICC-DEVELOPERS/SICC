package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegNacioData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONNacionalidadBean implements SessionBean {
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

    public Hashtable guardar(SegNacioData segNacio, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAONacionalidad daoNacionalidad = new DAONacionalidad();
    
        return daoNacionalidad.guardar(segNacio, localizationLabels, userProperties) ;
    }

    public Vector query(SegNacioData segNacioFrom, SegNacioData segNacioTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAONacionalidad daoNacionalidad = new DAONacionalidad();
    
        return daoNacionalidad.query(segNacioFrom, segNacioTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segNacioFrom) throws MareException
    {
        DAONacionalidad daoNacionalidad = new DAONacionalidad();
    
        daoNacionalidad.remove(segNacioFrom);
    }

    public void update(SegNacioData segNacio, Vector localizationLabels) throws MareException
    {
        DAONacionalidad daoNacionalidad = new DAONacionalidad();
    
        daoNacionalidad.update(segNacio, localizationLabels);
    }
}
