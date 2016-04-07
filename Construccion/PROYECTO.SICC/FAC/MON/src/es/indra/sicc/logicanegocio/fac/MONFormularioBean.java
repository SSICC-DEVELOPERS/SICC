package es.indra.sicc.logicanegocio.fac;

import es.indra.belcorp.mso.FacDestiImpreData;
import es.indra.belcorp.mso.FacFormuData;
import es.indra.belcorp.mso.FacTecnoImpreData;
import es.indra.belcorp.mso.FacTipoDocumData;
import es.indra.belcorp.mso.FacTipoFormuData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONFormularioBean implements SessionBean {
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

    public Vector query(FacTecnoImpreData facTecnoImpreFrom, FacTecnoImpreData facTecnoImpreTo, HashMap userProperties) throws MareException
    {        
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.query( facTecnoImpreFrom,  facTecnoImpreTo,  userProperties) ;
    }

    public Vector query(FacDestiImpreData facDestiImpreFrom, FacDestiImpreData facDestiImpreTo, HashMap userProperties) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.query( facDestiImpreFrom,  facDestiImpreTo,  userProperties) ;
    }

    public Vector query(FacTipoFormuData facTipoFormuFrom, FacTipoFormuData facTipoFormuTo, HashMap userProperties) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.query( facTipoFormuFrom,  facTipoFormuTo,  userProperties) ;
    }

    public Vector query(FacTipoDocumData facTipoDocumFrom, FacTipoDocumData facTipoFormuTo, HashMap userProperties) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.query( facTipoDocumFrom,  facTipoFormuTo,  userProperties) ;
    }

    public Hashtable guardarFormulario(FacFormuData facFormu, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.guardarFormulario(facFormu) ;
    }

    public Vector query(FacFormuData facFormuFrom, FacFormuData facFormuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        return daoFormulario.query(facFormuFrom, facFormuTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector facFormuFrom) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        daoFormulario.remove(facFormuFrom);
    }

    public void update(FacFormuData facFormu, Vector localizationLabels) throws MareException
    {
        DAOFormulario daoFormulario = new DAOFormulario();
    
        daoFormulario.update(facFormu);
    }
}
