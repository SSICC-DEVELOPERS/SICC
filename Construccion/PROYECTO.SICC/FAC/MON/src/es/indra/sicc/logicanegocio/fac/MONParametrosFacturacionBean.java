package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacParamFactuData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParametrosFacturacionBean implements SessionBean {
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

    public Hashtable guardar(FacParamFactuData facParamFactu, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOParametrosFacturacion daoParametrosFacturacion = new DAOParametrosFacturacion();
    
        return daoParametrosFacturacion.guardar(facParamFactu) ;
    }

    public Vector query(FacParamFactuData facParamFactuFrom, FacParamFactuData facParamFactuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOParametrosFacturacion daoParametrosFacturacion = new DAOParametrosFacturacion();
    
        return daoParametrosFacturacion.query(facParamFactuFrom, facParamFactuTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector facParamFactuFrom) throws MareException
    {
        DAOParametrosFacturacion daoParametrosFacturacion = new DAOParametrosFacturacion();
    
        daoParametrosFacturacion.remove(facParamFactuFrom);
    }

    public void update(FacParamFactuData facParamFactu, Vector localizationLabels) throws MareException
    {
        DAOParametrosFacturacion daoParametrosFacturacion = new DAOParametrosFacturacion();
    
        daoParametrosFacturacion.update(facParamFactu);
    }
}
