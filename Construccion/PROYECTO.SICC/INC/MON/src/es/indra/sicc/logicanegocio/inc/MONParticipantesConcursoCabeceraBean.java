package es.indra.sicc.logicanegocio.inc;

import es.indra.belcorp.mso.IncDirigData;
import es.indra.belcorp.mso.IncPartiConcuCabecData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONParticipantesConcursoCabeceraBean implements SessionBean {
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

    public Vector query(IncDirigData incDirigFrom, IncDirigData incDirigTo, HashMap userProperties) throws MareException
    {
        DAOParticipantesConcursoCabecera daoParticipantesConcursoCabecera = new DAOParticipantesConcursoCabecera();
    
        return daoParticipantesConcursoCabecera.query( incDirigFrom, incDirigTo,  userProperties);
    }


    public Hashtable guardar(IncPartiConcuCabecData incPartiConcuCabec, Vector localizationLabels, HashMap userProperties) throws MareException
    {
        DAOParticipantesConcursoCabecera daoParticipantesConcursoCabecera = new DAOParticipantesConcursoCabecera();
    
        return daoParticipantesConcursoCabecera.guardar( incPartiConcuCabec, userProperties) ;
    }

    public Vector query(IncPartiConcuCabecData incPartiConcuCabecFrom, IncPartiConcuCabecData incPartiConcuCabecTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
    {
        DAOParticipantesConcursoCabecera daoParticipantesConcursoCabecera = new DAOParticipantesConcursoCabecera();
    
        return daoParticipantesConcursoCabecera.query(incPartiConcuCabecFrom, incPartiConcuCabecTo, userProperties, pageCount, pageSize);
    }

    public void remove(Vector incPartiConcuCabecFrom) throws MareException
    {
        DAOParticipantesConcursoCabecera daoParticipantesConcursoCabecera = new DAOParticipantesConcursoCabecera();
        
        daoParticipantesConcursoCabecera.remove(incPartiConcuCabecFrom);
        
    }

    public void update(IncPartiConcuCabecData incPartiConcuCabec, Vector localizationLabels) throws MareException
    {
        DAOParticipantesConcursoCabecera daoParticipantesConcursoCabecera = new DAOParticipantesConcursoCabecera();
    
        daoParticipantesConcursoCabecera.update(incPartiConcuCabec);
    }

}
