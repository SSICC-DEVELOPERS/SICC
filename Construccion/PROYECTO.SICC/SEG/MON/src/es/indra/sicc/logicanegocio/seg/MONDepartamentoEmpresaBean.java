package es.indra.sicc.logicanegocio.seg;

import es.indra.belcorp.mso.SegDeptoEmpreData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONDepartamentoEmpresaBean implements SessionBean {
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

    public Hashtable guardar(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAODepartamentoEmpresa daoDepartamentoEmpresa = new DAODepartamentoEmpresa();
    
        return daoDepartamentoEmpresa.guardar(segDeptoEmpre, localizationLabels, userProperties) ;
    }

    public Vector query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAODepartamentoEmpresa daoDepartamentoEmpresa = new DAODepartamentoEmpresa();
        
        return daoDepartamentoEmpresa.query(segDeptoEmpreFrom, segDeptoEmpreTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector segDeptoEmpreFrom) throws MareException
    {
        DAODepartamentoEmpresa daoDepartamentoEmpresa = new DAODepartamentoEmpresa();
        
        daoDepartamentoEmpresa.remove(segDeptoEmpreFrom);
    }

    public void update(SegDeptoEmpreData segDeptoEmpre, Vector localizationLabels) throws MareException
    {
        DAODepartamentoEmpresa daoDepartamentoEmpresa = new DAODepartamentoEmpresa();
        
        daoDepartamentoEmpresa.update(segDeptoEmpre, localizationLabels);
    }
}
